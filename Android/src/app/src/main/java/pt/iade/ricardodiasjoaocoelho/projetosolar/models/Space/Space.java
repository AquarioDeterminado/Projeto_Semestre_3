package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;

public class Space {

    private final String id;
    private String name;

    public Space(String id)
    {
        this.id = id;

        if (id == "1")
        {
            name = "Space Name";
        }
        else if (id == "2")
        {
            name = "Space Name 2";
        }
    }

    public String getId()
    {
        return id;
    }

    public String getName()
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
