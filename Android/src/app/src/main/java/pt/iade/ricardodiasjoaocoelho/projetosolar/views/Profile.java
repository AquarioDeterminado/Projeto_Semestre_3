package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

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


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        calendarView.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter();


    }
}

class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    CalendarItem[] calendarDataSet;

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView hour;

        public EventViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.calendar_event_row_item_title);
            hour = view.findViewById(R.id.calendar_envent_row_item_starting_hour);
        }
    }

    public static class DayViewHolder extends RecyclerView.ViewHolder {

        private TextView day;

        public DayViewHolder(@NonNull View view) {
            super(view);
            day = view.findViewById(R.id.calendar_day_row_item_day);
        }
    }

    public CalendarAdapter(CalendarItem[] calendarDataSet) {this.calendarDataSet = calendarDataSet;}

    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if(viewType == 0) view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_day_row_item, parent, false);
        else view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_event_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return calendarDataSet.length;
    }
}

class CalendarItem {

    String title;
    Date initDate;

    CalendarItem (Date day) {
        this.initDate = day;
    }

    CalendarItem (Event event) {
        this.title = event.getTitle();
        this.initDate = event.getStartTime();
    }
}