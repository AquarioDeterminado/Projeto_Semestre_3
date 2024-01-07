package pt.iade.ricardodiasjoaocoelho.projetosolar.views.adapters;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;
import pt.iade.ricardodiasjoaocoelho.projetosolar.views.Event_Page;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.CalendarItem;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

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
            calendar.setTime(calendarDataSet[position].getInitDate());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
            holder.day.setText(sdf.format(calendar.getTime()));
        }
        else {
            holder.title.setText(calendarDataSet[position].getTitle());

            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(calendarDataSet[position].getInitDate());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            holder.hour.setText(sdf.format(calendar.getTime()));

            holder.background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the SettingsActivity when the button is clicked
                    Intent eventPage = new Intent(view.getContext(), Event_Page.class);
                    eventPage.putExtra("event", calendarDataSet[position].getEvent());
                    view.getContext().startActivity(eventPage);
                }
            });
        }
    }

    private boolean isEvent(int position) {
        return calendarDataSet[position].getEvent() != null;
    }

    @Override
    public int getItemCount() {
        return calendarDataSet.length;
    }

    public void setCalendarDataSet(CalendarItem[] calendarDataSet) {
        this.calendarDataSet = calendarDataSet;
        notifyDataSetChanged();
    }
}
