package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace.Location;

public class LocationController {
    public static ArrayList<Location> getUserAccessibleLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("1"));
        locations.add(new Location("2"));
        return locations;
    }
}
