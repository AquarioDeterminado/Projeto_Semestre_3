package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_fragment);

        // Find the settings button by its ID
        Button settingsButton = findViewById(R.id.profile_settings_button);

        RecyclerView calendarView = findViewById(R.id.profile_calendar);




        ArrayList<Event> eventList = EventController.getUserEvents();
        eventList.sort(new Comparator<Event>() {
            @Override
            public int compare(Event event, Event t1) {
                if (event.getStartTime().before(t1.getStartTime())) return -1;
                else if (event.getStartTime().after(t1.getStartTime())) return 1;
                else return 0;
            }
        });
    }
}

class CalendarItem {

    String title;
    Event event = null;
    Date initDate;

    CalendarItem (Date day) {
        this.initDate = day;
    }

    CalendarItem (Event event) {
        this.title = event.getTitle();
        this.event = event;
        this.initDate = event.getStartTime();
    }

    //TODO: There are some events that last more than a day, so we need to find a way to show them
    public static CalendarItem[] makeCalendarDataSet(ArrayList<Event> eventList) {
        ArrayList<CalendarItem> calendarList = new ArrayList<>();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(eventList.get(0).getStartTime());

        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        calendarList.add(new CalendarItem(eventList.get(0).getStartTime()));
        for (Event event : eventList) {
            calendar.setTime(event.getStartTime());
            int eventDay = calendar.get(Calendar.DAY_OF_MONTH);
            int eventMonth = calendar.get(Calendar.MONTH);
            int eventYear = calendar.get(Calendar.YEAR);

            if(eventDay != currentDay || eventMonth != currentMonth || eventYear != currentYear) {
                calendarList.add(new CalendarItem(event.getStartTime()));

                currentDay = eventDay;
                currentMonth = eventMonth;
                currentYear = eventYear;
            }
            calendarList.add(new CalendarItem(event));
        }

        return calendarList.toArray(new CalendarItem[0]);
    }

    private static ArrayList<CalendarItem> orderDaylists(ArrayList<CalendarItem[]> dayList) {
        ArrayList<CalendarItem> calendarDataSet = new ArrayList<>();

        dayList.sort(compareDays());

        for (CalendarItem[] calendarItems : dayList)
            Collections.addAll(calendarDataSet, calendarItems);

        return calendarDataSet;
    }

    @NonNull
    private static Comparator<CalendarItem[]> compareDays() {
        return (calendarItems, t1) -> {
            if (calendarItems[0].initDate.before(t1[0].initDate)) return -1;
            else if (calendarItems[0].initDate.after(t1[0].initDate)) return 1;
            else return 0;
        };
    }
}