package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.CoworkSpace;

public class CoworkSpaceController {

    static public ArrayList<CoworkSpace> getNearSpaces()
    {
        ArrayList<CoworkSpace> coworkSpaces = new ArrayList<>();
        coworkSpaces.add(new CoworkSpace(1, "Big Compa"));
        coworkSpaces.add(new CoworkSpace(2, "Mega Compa"));
        coworkSpaces.add(new CoworkSpace(3, "Medium Compa"));
        coworkSpaces.add(new CoworkSpace(4, "Mini Compa"));
        return coworkSpaces;
    }
}
