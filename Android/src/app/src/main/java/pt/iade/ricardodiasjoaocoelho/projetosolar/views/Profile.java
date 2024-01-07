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
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Find the settings button by its ID
        Button settingsButton = findViewById(R.id.profile_settings_button);

        RecyclerView calendarView = findViewById(R.id.profile_calendar);

        // Set a click listener for the settings button
        Context context = this;
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the SettingsActivity when the button is clicked
                Intent myintent = new Intent(context, Settings_Page.class);
                startActivity(myintent);
            }
        });

        ArrayList<Event> eventList = new ArrayList<>();
        //eventList = EventController.getUserEvents();
        CalendarItem[] calendarDataSet = CalendarItem.makeCalendarDataSet(eventList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        calendarView.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter(calendarDataSet);
        calendarView.setAdapter(adapter);
    }
}

class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    CalendarItem[] calendarDataSet;

    private final int EVENT = 1;
    private final int DAY = 0;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView hour;
        private  TextView day;

        private ConstraintLayout background;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.calendar_event_row_item_title);
            hour = view.findViewById(R.id.calendar_envent_row_item_starting_hour);
            day = view.findViewById(R.id.calendar_day_row_item_day);
            background = view.findViewById(R.id.calendar_event_row_item_background);
        }
    }

    public CalendarAdapter(CalendarItem[] calendarDataSet) {this.calendarDataSet = calendarDataSet;}

    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if(viewType == DAY) view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_day_row_item, parent, false);
        else if (viewType == EVENT)  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_event_row_item, parent, false);
        else view = null;
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if(isEvent(position)) return EVENT;
        else return DAY;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!isEvent(position)) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(calendarDataSet[position].initDate);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
            holder.day.setText(sdf.format(calendar.getTime()));
        }
        else {
            holder.title.setText(calendarDataSet[position].title);

            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(calendarDataSet[position].initDate);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            holder.hour.setText(sdf.format(calendar.getTime()));

            holder.background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the SettingsActivity when the button is clicked
                    Intent eventPage = new Intent(view.getContext(), Event_Page.class);
                    eventPage.putExtra("event", calendarDataSet[position].event);
                    view.getContext().startActivity(eventPage);
                }
            });
        }
    }

    private boolean isEvent(int position) {
        return calendarDataSet[position].event != null;
    }

    @Override
    public int getItemCount() {
        return calendarDataSet.length;
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
        if (eventList.isEmpty()) return new CalendarItem[0];

        ArrayList<CalendarItem[]> calendarList = new ArrayList<>();
        ArrayList<CalendarItem> dayList = new ArrayList<>();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(eventList.get(0).getStartTime());

        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        dayList.add(new CalendarItem(eventList.get(0).getStartTime()));
        for (Event event : eventList) {
            calendar.setTime(event.getStartTime());
            int eventDay = calendar.get(Calendar.DAY_OF_MONTH);
            int eventMonth = calendar.get(Calendar.MONTH);
            int eventYear = calendar.get(Calendar.YEAR);

            if(eventDay != currentDay || eventMonth != currentMonth || eventYear != currentYear) {
                addDayList(calendarList, dayList);

                dayList.clear();

                dayList.add(new CalendarItem(event.getStartTime()));

                currentDay = eventDay;
                currentMonth = eventMonth;
                currentYear = eventYear;
            }

            dayList.add(new CalendarItem(event));
        }
        addDayList(calendarList, dayList);

        ArrayList<CalendarItem> calendarDataSet = orderDaylists(calendarList);

        return calendarDataSet.toArray(new CalendarItem[0]);
    }

    private static ArrayList<CalendarItem> orderDaylists(ArrayList<CalendarItem[]> dayList) {
        ArrayList<CalendarItem> calendarDataSet = new ArrayList<>();

        dayList.sort(compareDays());

        for (CalendarItem[] calendarItems : dayList)
            Collections.addAll(calendarDataSet, calendarItems);

        return calendarDataSet;
    }

    private static void addDayList(ArrayList<CalendarItem[]> calendarList, ArrayList<CalendarItem> calendarDaySet) {
        calendarDaySet.sort(compareHours());
        calendarList.add(calendarDaySet.toArray(new CalendarItem[0]));
    }

@NonNull
    private static Comparator<? super CalendarItem> compareHours() {
        return (calendarItem, t1) -> {
            if (calendarItem.initDate.before(t1.initDate)) return -1;
            else if (calendarItem.initDate.after(t1.initDate)) return 1;
            else return 0;
        };
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