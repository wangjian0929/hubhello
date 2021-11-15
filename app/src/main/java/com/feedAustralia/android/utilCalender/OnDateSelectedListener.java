package com.feedAustralia.android.utilCalender;

import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.List;

public interface OnDateSelectedListener {

    /**
     * Called after click on day of the month
     * @param dayCalendar Calendar of selected day
     * @param events Events of selected day
     */
    void onDateSelected(Calendar dayCalendar, @Nullable List<CalendarEvent> events);
    void onDateSelected_day(Calendar dayCalendar, int eventsOfDay, int month, int day, List<CalendarEvent> eventOfDay);


}