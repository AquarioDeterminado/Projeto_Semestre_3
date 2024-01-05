package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;
import java.net.URL;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class EventController {

    public static void getCurrentEvents(User_Info user, ReturnEvents returnEvents)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/Solar/events/getAvailableEvents"));
                        Log.i("WebRequest", "Post made to API: Events for user");
                        String response = req.performPostRequest(user.getId());

                        // Get the new ID from the server's response.
                        Event[] availableEvents = new Gson().fromJson(response, Event[].class);
                        returnEvents.response(availableEvents);

                    } catch (Exception e) {
                        Log.e("Even", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getUserEvents(User_Info user, ReturnEvents returnEvents)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/Solar/events/getRSVP"));
                        Log.i("WebRequest", "Post made to API: Events RSVP'ed by user");
                        String response = req.performPostRequest(user.getId());

                        // Get the new ID from the server's response.
                        Event[] availableEvents = new Gson().fromJson(response, Event[].class);
                        returnEvents.response(availableEvents);

                    } catch (Exception e) {
                        Log.e("TodoItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    interface ReturnEvents {
        void response(Event[] events);
    }

    interface ReturnEvent {
        void response(Event event);
    }

}
