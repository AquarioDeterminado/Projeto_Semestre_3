package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.Space;

public class CoworkSpaceController {

    static public ArrayList<Space> getNearSpaces()
    {
        ArrayList<Space> spaces = new ArrayList<>();
        spaces.add(new Space("1"));
        spaces.add(new Space("2"));
        return spaces;
    }
}
