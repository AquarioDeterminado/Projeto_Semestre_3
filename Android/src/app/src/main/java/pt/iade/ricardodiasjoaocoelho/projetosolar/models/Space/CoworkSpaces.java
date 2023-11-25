package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space;

import android.widget.ImageView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;

public class CoworkSpaces {

    private final String id;
    private static String name;
    private static ImageView logo;

    public CoworkSpaces(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public static ImageView getLogo() {
        return logo;
    }

    public static void setLogo(ImageView logo) {
        CoworkSpaces.logo = logo;
    }

    public String getId()
    {
        return id;
    }

    public static String getName()
    {
        return name;
    }

    public ArrayList<Tag> getTags()
    {
        ArrayList<Tag> tags = new ArrayList<>();

        ArrayList<String> descrips = new ArrayList<>();//not  Final
        descrips.add("Tag1");
        descrips.add("Tag2");
        descrips.forEach(descrip -> {
            Tag tag = new Tag(descrip);
            tags.add(tag);
        });
        return tags;
    }
}