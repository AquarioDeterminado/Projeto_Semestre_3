package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.RSVPResponseInfo;

public class Event_RSVP extends AppCompatActivity {

    // Sends data back to MainPage
    Event event;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_rsvp);

        /* --- Get eventID --- */
        Intent intent = getIntent();
        event = intent.getParcelableExtra("event");
        userId = intent.getIntExtra("userID", 0);

        /* --- Widgets --- */
        ConstraintLayout background = findViewById(R.id.rsvp_background);

        TextView eventTitle = findViewById(R.id.rsvp_event_title);
        TextView eventDate = findViewById(R.id.rsvp_event_date);
        TextView eventDescrip = findViewById(R.id.rsvp_event_descrip);

        Button acceptButton = findViewById(R.id.rsvp_accept_button);
        Button notifyButton = findViewById(R.id.rsvp_notify_bttn);

        /* --- Set widgets --- */
        eventTitle.setText(event.getTitle());
        eventDate.setText(event.getStartTime().toString());
        eventDescrip.setText(event.getDescrip());


        /* --- Navigation --- */
        //All go back to main page
        notifyButton.setOnClickListener(
                BackToMainPage(getString(R.string.rsvp_notify_message), false));

        acceptButton.setOnClickListener(
                BackToMainPage(getString(R.string.rsvp_accept_message), true));

        background.setOnClickListener(
                BackToMainPage(null, false));

    }

    private View.OnClickListener BackToMainPage (String message, boolean attend) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(message != null)
                {
                    intent.putExtra("message", message);
                    if (attend)
                        EventController.attend(userId, event.getId(), new EventController.ReturnRSVP() {
                            @Override
                            public void response(RSVPResponseInfo rsvp) {
                                if (rsvp.isSuccess()) {
                                    setResult(RESULT_OK, intent);
                                    intent.putExtra("eventId", rsvp.getId());
                                    finish();
                                } else {
                                    Snackbar.make(v, rsvp.getMessage(), Snackbar.LENGTH_LONG).show();
                                }

                            }
                        });
                    else
                        EventController.notify(userId, event.getId());
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        };

        }
    }





