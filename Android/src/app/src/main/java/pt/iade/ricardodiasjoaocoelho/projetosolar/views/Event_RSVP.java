package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Event_RSVP extends AppCompatActivity {
    String eventID;

    // Sends data back to MainPage
    private OnDataReceivedListener onDataReceivedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_rsvp);

        /* --- Get eventID --- */
        Intent intent = getIntent();
        eventID = intent.getStringExtra("eventID");

        /* --- Widgets --- */
        ConstraintLayout background = findViewById(R.id.rsvp_background);

        //TextView eventTitle = findViewById(R.id.rsvp_event_title);
        //TextView eventDate = findViewById(R.id.rsvp_event_date);
        //TextView eventDescrip = findViewById(R.id.rsvp_event_descrip);

        Button acceptButton = findViewById(R.id.rsvp_accept_button);
        Button notifyButton = findViewById(R.id.rsvp_notify_bttn);

        /* --- Navigation --- */
        //All go back to main page
        notifyButton.setOnClickListener(
                BackToMainPage(getString(R.string.rsvp_notify_message)));

        acceptButton.setOnClickListener(
                BackToMainPage(getString(R.string.rsvp_accept_message)));

        background.setOnClickListener(
                BackToMainPage(""));

    }

    private View.OnClickListener BackToMainPage (String message) {
        return v -> {
            Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
            finish();
            Log.d("RSVP", message);
            if (!message.isEmpty())
                sendDataBack(message);
        };
    }

    public void SetOnDataReceivedListener (OnDataReceivedListener listener) {
        this.onDataReceivedListener = listener;
    }

    private void sendDataBack (String data) {
        if (onDataReceivedListener != null) {
            onDataReceivedListener.onDataReceived(data);
        }
    }

    public interface OnDataReceivedListener {
        void onDataReceived(String data);
    }
}


