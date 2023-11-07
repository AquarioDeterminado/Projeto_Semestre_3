package pt.iade.ricardodiasjoaocoelho.projetosolar.views;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        eventsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Event.class);
                startActivity(intent);
            }
        });

        //MainPage -> Space
        spacesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Space.class);
                startActivity(intent);
            }
        });



    }
}