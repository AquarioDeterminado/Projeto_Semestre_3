package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.UserInfo;

public class EventController {

    public static ArrayList<Event> getCurrentEvents(UserInfo user)
    {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event("1"));
        eventArrayList.add(new Event("2"));
        return eventArrayList;
    }
}
