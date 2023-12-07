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


        ArrayList<CalendarItem> calendarDataSet = new ArrayList<>();
        calendarDataSet.add(new CalendarItem(new Event(1)));
        calendarDataSet.add(new CalendarItem(new Event(2)));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        calendarView.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter(calendarDataSet.toArray(new CalendarItem[0]));
        calendarView.setAdapter(adapter);
    }
}

class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    CalendarItem[] calendarDataSet;

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

        if(viewType == 0) view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_day_row_item, parent, false);
        else if (viewType == 1)  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_event_row_item, parent, false);
        else view = null;
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if(!isEvent(position)) return 0;
        else return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!isEvent(position)) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(calendarDataSet[position].initDate);
            SimpleDateFormat sdf = new SimpleDateFormat("DD");
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
                    view.getContext().startActivity(myintent);
                }
            });
        }
    }

    private boolean isEvent(int position) {
        return calendarDataSet[position].title == null;
    }

    @Override
    public int getItemCount() {
        return calendarDataSet.length;
    }
}

class CalendarItem {

    String title;
    Event event;
    Date initDate;

    CalendarItem (Date day) {
        this.initDate = day;
    }

    CalendarItem (Event event) {
        this.title = event.getTitle();
        this.event = event;
        this.initDate = event.getStartTime();
    }
}