package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;


public class Main_Fragment extends Fragment {
    public Main_Fragment() {
        super(R.layout.mainpage_events);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        ImageButton profileButton = view.findViewById(R.id.mainpage_profile_button);

        //Spinner datePicker = view.findViewById(R.id.mainpage_datePicker);

        //HorizontalScrollView eventsList = view.findViewById(R.id.mainpage_eventList);
        Button eventsBttn = view.findViewById(R.id.mainpage_event_more_button);
        Button spaceBttn = view.findViewById(R.id.mainpage_events_space_info_button_1);
        //LinearLayout spacesList = view.findViewById(R.id.mainpage_spaces_list);

        /* --- Navigation --- */
        Context context = getActivity();
        View parentLayout = getActivity().findViewById(android.R.id.content);

        //MainPage -> Profile
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //MainPage -> Event
        ActivityResultLauncher<Intent> eventLauncher = afterLunchSnack(parentLayout);
        eventsBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Event_RSVP.class);

                String eventId = GetEventId();
                intent.putExtra("eventID", eventId);

                //Event_RSVP event = new Event_RSVP();

                eventLauncher.launch(intent);
            }

            String GetEventId() {
                return "1";
            }
        });

        //MainPage -> Space
        spaceBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Space_Info.class);
                String spaceId = GetSpaceId();
                intent.putExtra("spaceID", spaceId);
                startActivity(intent);
            }

            String GetSpaceId() {
                return "1";
            }
        });

        return view;
    }

    private ActivityResultLauncher<Intent> afterLunchSnack(View parentLayout) {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String message = data.getStringExtra("message");
                        Snackbar confirmation = Snackbar.make(parentLayout , message, Snackbar.LENGTH_LONG);
                        confirmation.setText(message);
                        confirmation.show();
                    }
                }
        );
    }
}
