package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.net.URL;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class CoworkSpaceController {

    private final static String BASE_URL = WebRequest.LOCALHOST + "/coworkspaces";

    static public void getNearSpaces(int userId, ReturnCoworkSpaces returnSpaces) {
        ArrayList<CoworkSpace> items = new ArrayList<>();

        Thread thread = new Thread(() -> {
            try {
                // This is a brand new object and must be a INSERT in the database.
                WebRequest req = new WebRequest(new URL(
                        BASE_URL));
                Log.i("WebRequest", "Post made to API: Events for user");
                Id id = new Id(userId);
                String response = req.performPostRequest(id);

                // Get the new ID from the server's response.
                JsonArray availableEvents = new Gson().fromJson(response, JsonArray.class);
                for (int i = 0; i < availableEvents.size(); i++) {
                    CoworkSpace coworkSpace = new Gson().fromJson(availableEvents.get(i), CoworkSpace.class);
                    items.add(coworkSpace);
                }
                returnSpaces.response(items);
            } catch (Exception e) {
                Log.e("AvailableEvents", e.toString());
            }
        });
        thread.start();
    }

    public interface ReturnCoworkSpaces {
        void response(ArrayList<CoworkSpace> spaces);
    }

    public interface ReturnCoweorkSpace {
        void response(CoworkSpace coworkSpace);
    }
}
