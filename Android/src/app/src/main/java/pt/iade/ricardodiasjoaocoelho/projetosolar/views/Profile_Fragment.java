package pt.iade.ricardodiasjoaocoelho.projetosolar.views;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.controllers.EventController;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;

public class Profile_Fragment extends Fragment {
    public Profile_Fragment() {super(R.layout.profile_fragment);}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_fragment, container, false);

        //TextViews
        TextView name = view.findViewById(R.id.profile_name_display);
        TextView email = view.findViewById(R.id.profile_email_display);

        //ImageView
        ImageView avatar = view.findViewById(R.id.profile_avatar_display);

        //Set text to replace later on
        name.setText("John Doe");
        email.setText("johndoe@gmail.com");
        avatar.setImageResource(R.drawable.avatar_profile_picture);

        //Settings Button
        Button settingsButton = view.findViewById(R.id.profile_settings_button);

        //Calender
        RecyclerView calendarView = view.findViewById(R.id.profile_calendar);

        //Click Listener for Settings Button
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(getActivity(), Settings_Page.class);
                startActivity(myintent);
            }
        });

        ArrayList<Event> eventList = EventController.getUserEvents();
        eventList.sort(new Comparator<Event>() {
            @Override
            public int compare(Event event, Event t1) {
                if(event.getStartTime().before(t1.getStartTime()))
                    return -1;
                else if(event.getStartTime().after(t1.getStartTime()))
                    return 1;
                return 0;
            }
        });

        //adapter
        CalendarItem[] calendarDataSet = CalendarItem.makeCalendarDataSet(eventList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        calendarView.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter(calendarDataSet);
        calendarView.setAdapter(adapter);


        /* ---  Navigation --- */
        ActivityResultLauncher<Intent> eventInfoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        Event event = data.getExtras().getParcelable("event");

                    }
                }
        );
        return view;

    }
    static class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

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
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
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
}

























