package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;
import java.net.URL;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class EventController {

    public static void getCurrentEvents(int userId, ReturnEvents returnEvents) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/Solar/events" + "/getAvailableEvents"));
                        Log.i("WebRequest", "Get made to API: Events for user");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);

                        // Get the new ID from the server's response.
                        Event[] availableEvents = new Gson().fromJson(response, Event[].class);
                        returnEvents.response(availableEvents);

                    } catch (Exception e) {
                        Log.e("AvailableEvents", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void getUserEvents(int userId, ReturnEvents returnEvents) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/Solar/events/getRSVP"));
                        Log.i("WebRequest", "Post made to API: Events RSVP'ed by user");
                        String response = req.performPostRequest(userId);

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
        thread.start();
    }

    public interface ReturnEvents {
        void response(Event[] events);
    }

    interface ReturnEvent {
        void response(Event event);
    }
}

class Id implements Serializable {
    int id;

    public Id(int id) {
        this.id = id;
    }
}
