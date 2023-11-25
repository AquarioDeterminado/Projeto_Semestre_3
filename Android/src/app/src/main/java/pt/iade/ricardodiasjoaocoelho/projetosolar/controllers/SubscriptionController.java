package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Subscription;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class SubscriptionController {
    public static ArrayList<Subscription> getUserSubscriptions(User_Info user) {
        ArrayList<Subscription> subs = new ArrayList<>();
        subs.add(new Subscription("1", user));
        subs.add(new Subscription("2", user));
        return subs;
    }
}
