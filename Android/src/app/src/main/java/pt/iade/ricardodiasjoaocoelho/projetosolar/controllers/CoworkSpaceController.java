package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;
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

                ArrayList<CoworkSpace> coworkSpaces = new ArrayList<>();
                ArrayList<Subscription> subscriptions = new ArrayList<>();
                ArrayList<Tag> tags = new ArrayList<>();

                // Get the new ID from the server's response.
                JsonArray allCoworks = new Gson().fromJson(response, JsonArray.class);

                for (int i = 0; i < allCoworks.size(); i++) {
                    JsonObject coworkJson = allCoworks.get(i).getAsJsonObject();

                    JsonArray subscriptionsJson = coworkJson.get("subscriptionsInfo").getAsJsonArray();
                    for (int j = 0; j < subscriptionsJson.size(); j++) {
                        JsonObject subscriptionJson = subscriptionsJson.get(j).getAsJsonObject();
                        Subscription subscription = new Gson().fromJson(subscriptionJson, Subscription.class);
                        subscriptions.add(subscription);
                    }

                    JsonArray tagsJson = coworkJson.get("tags").getAsJsonArray();
                    for (int j = 0; j < tagsJson.size(); j++) {
                        JsonObject tagJson = tagsJson.get(j).getAsJsonObject();
                        Tag tag = new Gson().fromJson(tagJson, Tag.class);
                        tags.add(tag);
                    }

                    CoworkSpace coworkSpace = new Gson().fromJson(coworkJson, CoworkSpace.class);
                    coworkSpace.setSubscriptions(subscriptions);
                    coworkSpace.setTags(tags);

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

    public interface ReturnCoworkSpace {
        void response(CoworkSpace coworkSpace);
    }
}
