package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;
import android.widget.ImageView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space.CoworkSpaces;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Space_Info;

public class CoworkSpaceController {

    static public ArrayList<CoworkSpaces> getNearSpaces()
    {
        ArrayList<CoworkSpaces> coworkSpaces = new ArrayList<>();
        coworkSpaces.add(new CoworkSpaces("1", "Big Compa"));
        coworkSpaces.add(new CoworkSpaces("2", "Mega Compa"));
        coworkSpaces.add(new CoworkSpaces("3", "Medium Compa"));
        coworkSpaces.add(new CoworkSpaces("4", "Mini Compa"));
        return coworkSpaces;
    }

    public String getName() {
        return CoworkSpaces.getName();
    }

    public ImageView getLogo() {
        return CoworkSpaces.getLogo();
    }
}
