package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

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
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.EventListAdapter;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.SpaceListAdapter;


public class Main_Fragment extends Fragment {
    
    Activity currentActivity;
    
    private RecyclerView eventsList;
    private RecyclerView spacesList;
    
    public Main_Fragment() {
        super(R.layout.mainpage_events);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentActivity = getActivity();
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        /* ---  Widgets --- */
        //Spinner datePicker = view.findViewById(R.id.mainpage_datePicker);

        eventsList = view.findViewById(R.id.mainpage_events_list);
        spacesList = view.findViewById(R.id.mainpage_spaces_list);

        /* --- Navigation --- */
        //MainPage -> Event

        /* --- Get User Info--- */
        Intent intent = getActivity().getIntent();
        //int userId = intent.getIntExtra("userID", 0); //TODO replace
        int userId = 1;

        /* --- Set Events --- */
        setEventsRecycleView(userId);

        /* --- Set Spaces --- */
        setSpacesRecycleView(userId);

        return view;
    }

    private void setSpacesRecycleView(int user_id) {
        //Adapter
        CoworkSpace[] nearCoworkSpaces = getNearSpaces().toArray(new CoworkSpace[0]);
        SpaceListAdapter spaceListAdapter = new SpaceListAdapter(nearCoworkSpaces);
        spacesList.setAdapter(spaceListAdapter);

        //Layout Manager
        LinearLayoutManager spaceLayoutManager = new LinearLayoutManager(getContext());
        spacesList.setLayoutManager(spaceLayoutManager);

        spacesList.setHasFixedSize(true);
        updateSpaceList(user_id);
    }

    private void updateSpaceList(int userId) {
    }

    private void setEventsRecycleView(int userId) {
        ArrayList<Event> currentEvents = new ArrayList<>();

        EventListAdapter eventListAdapter = new EventListAdapter(currentEvents.toArray(new Event[0]));
        ActivityResultLauncher<Intent> eventLauncher = getLauncher(getView());
        eventListAdapter.setEventLauncher(eventLauncher);
        eventsList.setAdapter(eventListAdapter);

        //Layout Manager
        LinearLayoutManager eventLayoutManager = new LinearLayoutManager(getContext());
        eventLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        eventsList.setLayoutManager(eventLayoutManager);

        eventsList.setHasFixedSize(true);

        updateEventList(eventLauncher, userId);
    }

    private void updateEventList(ActivityResultLauncher<Intent> eventLauncher, int userId) {

        getCurrentEvents(userId, new EventController.ReturnEvents() {
            @Override
            public void response(ArrayList<Event> events) {
                currentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        EventListAdapter enventListAdapter = new EventListAdapter(events.toArray(new Event[0]));
                        enventListAdapter.setEventLauncher(eventLauncher);
                        eventsList.swapAdapter(enventListAdapter, true);
                    }
                });

            }
        });
    }



    @NonNull
    private ActivityResultLauncher<Intent> getLauncher(View view) {
        ActivityResultLauncher<Intent> eventLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("message");
                        Snackbar confirmation = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
                        confirmation.setText(message);
                        confirmation.show();
                    }
                });
        return eventLauncher;
    }
}



