package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;

public class Profile_Fragment extends Fragment {
    public Profile_Fragment() {super(R.layout.profile_fragment);}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_fragment, container, false);

        //Buttons
        Button settingsButton = view.findViewById(R.id.profile_settings_button);
        RecyclerView calendarView = view.findViewById(R.id.profile_calendar);

        //Click Listener for Settings Button
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(getActivity(), Settings_Page.class);
                startActivity(myintent);
            }
        });
        /* ---  Widgets --- */
        RecyclerView recyclerView = view.findViewById(R.id.profile_calendar);
        ArrayList<Event> eventList = EventController.getUserEvents();

        /* ---  Navigation --- */
        ActivityResultLauncher<Intent> eventInfoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        Event event = data.getExtras().getParcelable("event");

                    }
                }
        );
        return view;
    }
}

























