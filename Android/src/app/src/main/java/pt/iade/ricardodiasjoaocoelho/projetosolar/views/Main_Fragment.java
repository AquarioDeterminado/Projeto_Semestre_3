package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import static androidx.core.content.ContextCompat.startActivity;
import static pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController.getCurrentEvents;
import static pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.CoworkSpaceController.getNearSpaces;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;


public class Main_Fragment extends Fragment {
    public Main_Fragment() {
        super(R.layout.mainpage_events);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        /* ---  Widgets --- */
        //Spinner datePicker = view.findViewById(R.id.mainpage_datePicker);

        RecyclerView eventsList = view.findViewById(R.id.mainpage_events_list);
        RecyclerView spacesList = view.findViewById(R.id.mainpage_spaces_list);


        /* --- Navigation --- */
        //MainPage -> Event
        ActivityResultLauncher<Intent> eventLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("message");
                        Snackbar confirmation = Snackbar.make(view , message, Snackbar.LENGTH_LONG);
                        confirmation.setText(message);
                        confirmation.show();
                    }
                });

        /* --- Set Events --- */
        //Adapter
        Event[] currentEvents = getCurrentEvents(User_Info.getUserById(1,"")).toArray(new Event[0]);
        EventListAdapter enventListAdapter = new EventListAdapter(currentEvents);
        enventListAdapter.setEventLauncher(eventLauncher);
        eventsList.setAdapter(enventListAdapter);

        //Layout Manager
        LinearLayoutManager eventLayoutManager = new LinearLayoutManager(getContext());
        eventLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        eventsList.setLayoutManager(eventLayoutManager);

        eventsList.setHasFixedSize(true);

        /* --- Set Spaces --- */
        //Adapter
        CoworkSpace[] nearCoworkSpaces = getNearSpaces().toArray(new CoworkSpace[0]);
        SpaceListAdapter spaceListAdapter = new SpaceListAdapter(nearCoworkSpaces);
        spacesList.setAdapter(spaceListAdapter);

        //Layout Manager
        LinearLayoutManager spaceLayoutManager = new LinearLayoutManager(getContext());
        spacesList.setLayoutManager(spaceLayoutManager);

        spacesList.setHasFixedSize(true);

        return view;
    }
}

class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    private Event[] eventDataSet;
    private ActivityResultLauncher<Intent> eventLauncher;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView eventDate;

        private final ImageView eventImage;
        private final TextView eventTitle;
        private final Button eventRSVP;
        public ViewHolder(View view) {
            super(view);
            eventDate = view.findViewById(R.id.mainpage_event_row_item_start_time);
            eventImage = view.findViewById(R.id.mainpage_event_row_item_img);
            eventTitle = view.findViewById(R.id.mainpage_event_row_item_title);
            eventRSVP = view.findViewById(R.id.mainpage_event_row_item_more_button);
        }

    }
    public EventListAdapter(Event[] eventDataSet) {
         this.eventDataSet = eventDataSet;
    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mainpage_event_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventListAdapter.ViewHolder holder, int position) {
        /* --- Set Widgets --- */
        holder.eventTitle.setText(eventDataSet[position].getTitle());
        holder.eventDate.setText(eventDataSet[position].getStartTime().toString());
        //holder.eventImage.setImageResource(eventDataSet[position].getImage());

        holder.eventRSVP.setText((R.string.mainpage_events_show_me_more_bttn));
        /* --- Navigation --- */
        holder.eventRSVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Event_RSVP.class);
                int eventId = eventDataSet[position].getId();
                intent.putExtra("eventID", eventId);
                eventLauncher.launch(intent);
            }
        });
    }

    public void setEventLauncher(ActivityResultLauncher<Intent> eventLauncher) {
        this.eventLauncher = eventLauncher;
    }

    @Override
    public int getItemCount() {
        return eventDataSet.length;
    }
}

class SpaceListAdapter extends RecyclerView.Adapter<SpaceListAdapter.ViewHolder> {
    private CoworkSpace[] coworkSpaceDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView spaceName;
        private final ImageView spaceImage;
        private final Button spaceBttn;

        public ViewHolder(View view) {
            super(view);
            spaceName = view.findViewById(R.id.space_row_item_name);
            spaceImage = view.findViewById(R.id.space_row_item_img);
            spaceBttn = view.findViewById(R.id.space_row_item_button);
        }

    }
    SpaceListAdapter (CoworkSpace[] coworkSpaceDataSet) {
         this.coworkSpaceDataSet = coworkSpaceDataSet;
    }

    @Override
    public SpaceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.space_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpaceListAdapter.ViewHolder holder, int position) {
        /* --- Set Widgets --- */
        holder.spaceName.setText(coworkSpaceDataSet[position].getName());
        //holder.spaceImage.setImageResource(spaceDataSet[position].getImage());

        holder.spaceBttn.setText((R.string.mainpage_spaces_show_me_more_bttn));
        /* --- Navigation --- */
        holder.spaceBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Space_Info.class);
                String eventId = coworkSpaceDataSet[position].getId();
                intent.putExtra("eventID", eventId);
                startActivity(v.getContext(), intent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coworkSpaceDataSet.length;
    }
}


