package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event;

import java.text.DateFormat;
import java.util.Date;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Event {
    private final int id;
    private String title;
    private Date initDate;
    private Date endDate;
    private String descrip;
    private int spaceID;
    private String location;

    public Event(int id)
    {
        this.id = id;

        if (id == 1)
        {
            title = "Event Title";
            initDate = DateFormat.getDateInstance().parse("2021-01-01");
            endDate = DateFormat.getDateInstance().parse("2021-01-01");
            descrip = "Event Description";
            spaceID = 1;
            location = "Event Location";
        }
        else if (id == 2)
        {
            title = "Event Title 2";
            initDate = DateFormat.getDateInstance().parse("2021-01-01");
            endDate = DateFormat.getDateInstance().parse("2021-01-01");
            descrip = "Event Description 2";
            spaceID = 2;
            location = "Event Location 2";
        }
    }

    public String getTitle()
    {
        return title;
    }

    public int getId() {
        return id;
    }

    public Date getStartTime() {
        return initDate;
    }

    public Date getEndTime() {
        return endDate;
    }

    public String getDescrip() {
        return descrip;
    }


    public int getImage() {
        return R.drawable.ic_launcher_background;
    }
}
