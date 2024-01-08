package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class LocationController {

    private static final String BASE_URL = WebRequest.LOCALHOST + "/deskReserve";

    public static void getUserAccessibleLocations(int userId, ReturnLocations returnLocations) {
        ArrayList<Location> locations = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/spaceslist"));
                        Log.i("WebRequest", "Post made to API: Events for user");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);

                        // Get the new ID from the server's response.
                        JsonArray availableEvents = new Gson().fromJson(response, JsonArray.class);
                        for (int i = 0; i < availableEvents.size(); i++) {
                            Location location = new Gson().fromJson(availableEvents.get(i), Location.class);
                            locations.add(location);
                        }
                        returnLocations.response(locations);

                    } catch (Exception e) {
                        Log.e("LocarionList", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void getFloorPlan(int userId, Location location, ReturnString returnFloorPlan) {
        int locationId = location.getId();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/showSpaceLayout/" + locationId));
                        Log.i("WebRequest", "Post made to API: Events for user");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);

                        // Get the new ID from the server's response.

                        returnFloorPlan.response(response);

                    } catch (Exception e) {
                        Log.e("FloorPlan", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void reserveDesk(int tableId, int userId, ReturnInt returnId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/reserveTable/" + tableId));
                        Log.i("WebRequest", "Post made to API: Events for user");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);

                        // Get the new ID from the server's response.
                        int newId = new Gson().fromJson(response, int.class);
                        returnId.response(newId);

                    } catch (Exception e) {
                        Log.e("DeskReserve", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public interface ReturnLocations {
        void response(ArrayList<Location> locations);
    }

    public interface ReturnString {
        void response(String floorPlan);
    }

    public interface ReturnInt {
        void response(int id);
    }
}
