package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Event {
    private final String id;
    private String title;
    private String initDate;
    private String endDate;
    private String descrip;
    private String spaceID;
    private String location;

    public Event(String id)
    {
        this.id = id;

        if (id == "1")
        {
            title = "Event Title";
            initDate = "2021-01-01";
            endDate = "2021-01-01";
            descrip = "Event Description";
            spaceID = "1";
            location = "Event Location";
        }
        else if (id == "2")
        {
            title = "Event Title 2";
            initDate = "2021-01-01";
            endDate = "2021-01-01";
            descrip = "Event Description 2";
            spaceID = "2";
            location = "Event Location 2";
        }
    }

    public String getTitle()
    {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getStartTime() {
        return initDate;
    }

    public String getEndTime() {
        return endDate;
    }

    public String getDescrip() {
        return descrip;
    }


    public int getImage() {
        return R.drawable.ic_launcher_background;
    }
}
