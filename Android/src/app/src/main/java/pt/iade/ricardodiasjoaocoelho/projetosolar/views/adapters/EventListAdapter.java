package pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Event_RSVP;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    private Event[] eventDataSet;
    private ActivityResultLauncher<Intent> eventLauncher;
    private int userId;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView eventDate;

        private final ImageView eventImage;
        private final TextView eventTitle;
        private final Button eventRSVP;
        public ViewHolder(View view) {
            super(view);
            eventDate = view.findViewById(R.id.mainpage_event_row_item_name1);
            eventImage = view.findViewById(R.id.mainpage_event_row_item_img);
            eventTitle = view.findViewById(R.id.mainpage_event_row_item_name2);
            eventRSVP = view.findViewById(R.id.mainpage_event_row_item_more_button);
        }

    }
    public EventListAdapter(Event[] eventDataSet, int userId) {
        this.eventDataSet = eventDataSet;
        this.userId = userId;
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
                Event event = eventDataSet[position];
                intent.putExtra("event", event);
                intent.putExtra("userID", userId);
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