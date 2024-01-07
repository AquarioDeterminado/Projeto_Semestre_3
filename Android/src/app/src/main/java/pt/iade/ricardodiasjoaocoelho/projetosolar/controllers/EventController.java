package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.net.URL;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class EventController {

    private static final String BASE_URL = WebRequest.LOCALHOST + "/events";

    public static void getCurrentEvents(int userId, ReturnEvents returnEvents) {
        ArrayList<Event> items = new ArrayList<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/getAvailableEvents"));
                        Log.i("WebRequest", "Post made to API: Events for user");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);

                        // Get the new ID from the server's response.
                        JsonArray availableEvents = new Gson().fromJson(response, JsonArray.class);
                        for (int i = 0; i < availableEvents.size(); i++) {
                            Event event = new Gson().fromJson(availableEvents.get(i), Event.class);
                            items.add(event);
                        }
                        returnEvents.response(items);

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
        ArrayList<Event> items = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/getUserEvents"));
                        Log.i("WebRequest", "Post made to API: Events RSVP'ed by user");
                        String response = req.performPostRequest(userId);

                        // Get the new ID from the server's response.
                        JsonArray availableEvents = new Gson().fromJson(response, JsonArray.class);
                        for (int i = 0; i < availableEvents.size(); i++) {
                            Event event = new Gson().fromJson(availableEvents.get(i), Event.class);
                            items.add(event);
                        }
                        returnEvents.response(items);

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
        void response(ArrayList<Event> events);
    }

    interface ReturnEvent {
        void response(Event event);
    }
}

