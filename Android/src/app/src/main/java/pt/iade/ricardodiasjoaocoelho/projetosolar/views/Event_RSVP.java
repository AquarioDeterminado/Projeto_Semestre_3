package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Event_RSVP extends AppCompatActivity {
    String eventID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_rsvp);

        Intent intent = getIntent();
        eventID = intent.getStringExtra("eventID");
    }
}