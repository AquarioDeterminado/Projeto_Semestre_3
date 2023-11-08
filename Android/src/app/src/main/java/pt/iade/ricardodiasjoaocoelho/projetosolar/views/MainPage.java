package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_events);

        /*Widgets*/
        ImageButton profileButton = findViewById(R.id.mainpage_profile_button);

        Spinner datePicker = findViewById(R.id.mainpage_datePicker);

        HorizontalScrollView eventsList = findViewById(R.id.mainpage_eventList);
        Button eventsBttn = findViewById(R.id.mainpage_event_more_button);
        Button spaceBttn = findViewById(R.id.mainpage_events_space_info_button_1);
        LinearLayout spacesList = findViewById(R.id.mainpage_spaces_list);

        /* --- Navigation --- */
        Context context = this;
        //MainPage -> Profile
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Profile.class);
                startActivity(intent);
            }
        });

        //MainPage -> Event
        eventsBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Event_RSVP.class);
                String eventId = GetEventId();
                intent.putExtra("eventID", eventId);
                startActivity(intent);
            }

            String GetEventId()
            {
                View.OnClickListener something = this;
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

            String GetSpaceId()
            {
                return "1";
            }
        });

    }
}