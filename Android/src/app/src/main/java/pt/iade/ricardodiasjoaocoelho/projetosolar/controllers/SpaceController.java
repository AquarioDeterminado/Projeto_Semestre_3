package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;
import android.widget.Space;

import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;

public class SpaceController {

    static public ArrayList<CoworkSpace> getNearSpaces()
    {
        ArrayList<CoworkSpace> spaces = new ArrayList<>();
        spaces.add(new CoworkSpace("1", "Space1"));
        spaces.add(new CoworkSpace("2", "Space2"));
        return spaces;
    }
}

