package com.refactoring.noteorganizerproject.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    private final static String DATE_OUTPUT_FORMAT = "%s/%s/%s";
    private final static String TIME_OUTPUT_FORMAT = "%s:%s";
    private final static Long NULL_DATE = 0L;
    private final static String BEGIN_DATE_STRING = "01/01/1970";

    public static Long stringToDate(String time, String date) {
        Calendar calendar = getCalendar(NULL_DATE);
        if (!time.equals("")) {
            Integer[] timeArr = parseTime(time);
            calendar.set(Calendar.HOUR_OF_DAY, timeArr[0]);
        }

    }

    private static Calendar getCalendar(Long dateInMills) {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date(dateInMills);
        calendar.setTime(date);
        return calendar;

    }
}
