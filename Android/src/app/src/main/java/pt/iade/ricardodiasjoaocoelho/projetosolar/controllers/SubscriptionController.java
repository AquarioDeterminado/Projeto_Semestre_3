package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.net.URL;
import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class SubscriptionController {

    private static final String BASE_URL = WebRequest.LOCALHOST + "/subscriptions";

    public static void getUserSubscriptions(int userId, ReturnSubscriptions returnSubscriptions) {
        Thread thread = new Thread(new Runnable() {
            ArrayList<Subscription> items = new ArrayList<>();
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/getUserSubscriptions"));
                        Log.i("WebRequest", "Post made to API: RSVP to event");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);

                        JsonArray subsctiptions  = new Gson().fromJson(response, JsonArray.class);
                        for (int i = 0; i < subsctiptions.size(); i++) {
                            Subscription event = new Gson().fromJson(subsctiptions.get(i), Subscription.class);
                            items.add(event);
                        }

                        returnSubscriptions.response(items);
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

    public static void RemoveSubscription(Subscription sub, ReturnSubscription subscription) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/cancelSubscription"));
                        Log.i("WebRequest", "Post made to API: RSVP to event");
                        Id id = new Id(sub.getId());
                        String response = req.performPostRequest(id);

                        Subscription sub = new Gson().fromJson(response, Subscription.class);
                        subscription.response(sub);
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

    public interface ReturnSubscriptions {
        void response(ArrayList<Subscription> items);
    }

    public interface ReturnSubscription {
        void response(Subscription item);
    }


}
