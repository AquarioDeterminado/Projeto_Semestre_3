package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.Space;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.Subscription;

public class CoworkSpaceController {

    static public ArrayList<Space> getNearSpaces()
    {
        ArrayList<Space> spaces = new ArrayList<>();
        spaces.add(new Space("1"));
        spaces.add(new Space("2"));
        return spaces;
    }

    public String getName() {
        ArrayList<Subscription> names = new ArrayList<>();
        subs.add(new Subscription("Big Compa", user_id));
        subs.add(new Subscription("Mega Compa", user_id));
        subs.add(new Subscription("Medium Compa", user_id));
        subs.add(new Subscription("Mini Compa", user_id));
        return ;
    }
}
