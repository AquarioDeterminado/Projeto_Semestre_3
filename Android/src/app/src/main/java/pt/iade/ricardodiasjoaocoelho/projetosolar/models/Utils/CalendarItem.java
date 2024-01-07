package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;

public class CalendarItem {

    String title;
    Event event = null;
    Date initDate;

    CalendarItem (Date day) {
        this.initDate = day;
    }

    public CalendarItem(Event event) {
        this.title = event.getTitle();
        this.event = event;
        this.initDate = event.getStartTime();
    }

    public String getTitle() {
        return title;
    }

    public Event getEvent() {
        return event;
    }

    public Date getInitDate() {
        return initDate;
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
