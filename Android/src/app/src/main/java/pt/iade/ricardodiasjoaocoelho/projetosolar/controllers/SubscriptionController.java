package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class SubscriptionController {
    public static ArrayList<Subscription> getUserSubscriptions(User_Info user) {
        String user_id = user.getId();
        ArrayList<Subscription> subs = new ArrayList<>();
        subs.add(new Subscription("1", user_id));
        subs.add(new Subscription("2", user_id));
        return subs;
    }
}
