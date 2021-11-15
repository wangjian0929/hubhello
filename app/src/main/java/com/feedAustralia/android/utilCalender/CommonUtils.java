package com.feedAustralia.android.utilCalender;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class CommonUtils {

    public static String[] getWeekDaysAbbreviation(int firstDayOfWeek) {

//
//        if (firstDayOfWeek >= Calendar.MONDAY || firstDayOfWeek <= Calendar.SUNDAY) {
//            throw new IllegalArgumentException("Day must be from Java Calendar class");
//        }

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.getDefault());
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();

        String[] weekDaysFromSunday = new String[]{shortWeekdays[1], shortWeekdays[2],
                shortWeekdays[3], shortWeekdays[4], shortWeekdays[5], shortWeekdays[6],
                shortWeekdays[7]};

        String[] weekDaysNames = new String[7];

        for (int day = 1, i = 0; i < 7; i++, day++) {
            day = day >= 7 ? 0 : day;
            weekDaysNames[i] = weekDaysFromSunday[day].toUpperCase();
        //    Log.d("jkghjkghkghjk", "getWeekDaysAbbreviation: "+i);
        }

        return weekDaysNames;
    }
}