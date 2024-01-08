package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.CalendarItem;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Settings_Page;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters.CalendarAdapter;

public class Profile extends AppCompatActivity {

    private static RecyclerView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_fragment);
        Intent intent = getIntent();
        int userId = intent.getIntExtra("userID", 0);

        // Find the settings button by its ID
        Button settingsButton = findViewById(R.id.profile_settings_button);

        calendarView = findViewById(R.id.profile_calendar);

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

        setCalendarRecycleView(userId);
    }

    private void setCalendarRecycleView(int userId) {
        ArrayList<Event> eventList = new ArrayList<>();
        CalendarItem[] calendarDataSet = CalendarItem.makeCalendarDataSet(eventList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        calendarView.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter(calendarDataSet);
        calendarView.setAdapter(adapter);

        updateCalendar(userId);
    }

    private static void updateCalendar(int userId) {
        ArrayList<CalendarItem> calendarItems = new ArrayList<>();
        EventController.getUserEvents(userId, events -> {
            CalendarAdapter adapter = (CalendarAdapter) calendarView.getAdapter();
            for (Event event : events) {
                calendarItems.add(new CalendarItem(event));
            }
            adapter.setCalendarDataSet(calendarItems.toArray(new CalendarItem[0]));
        });
    }
}

