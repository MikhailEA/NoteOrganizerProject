package com.refactoring.noteorganizerproject.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    private final static String DATE_OUTPUT_FORMAT = "%s/%s/%s";
    private final static String TIME_OUTPUT_FORMAT = "%s:%s";
    private final static Long NULL_DATE = 0L;
    private final static String BEGIN_DATE_STRING = "01/01/1970";

    public static boolean isDateConfigured(String date) {
        Long dateInMills = stringToDate("", date);
        return notEqualsToBeginDate(dateInMills) && !date.contains(BEGIN_DATE_STRING);
    }
    public static boolean isDateConfigured(Long dateInMills) {
        return notEqualsToBeginDate(dateInMills);
    }
    private static boolean notEqualsToBeginDate(Long dateInMills) {
        return !dateToString(dateInMills).contains(BEGIN_DATE_STRING);
    }

    public static String dateToString(Long dateInMills) {
        Calendar calendar = getCalendar(dateInMills);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String date = getNormalizedDate(day, month, year);
        String time = getNormalizedTime(hour, minute);

        return date + " " + time;
    }

    private static String getNormalizedTime(int hour, int minute) {
        String hourS = makeTwoNumbersFromOne(hour);
        String minuteS = makeTwoNumbersFromOne(minute);
        return String.format(DATE_OUTPUT_FORMAT, hourS, minuteS);
    }

    private static String getNormalizedDate(int day, int month, int year) {
        String dayS = makeTwoNumbersFromOne(day);
        String monthS = makeTwoNumbersFromOne(month + 1);
        String yearsS = makeTwoNumbersFromOne(year);
        return String.format(DATE_OUTPUT_FORMAT, dayS, monthS, yearsS);
    }

    private static String makeTwoNumbersFromOne(Integer num) {
        return num < 10 ? "0" + num : num.toString();

    }

    public static Long stringToDate(String time, String date) {
        Calendar calendar = getCalendar(NULL_DATE);
        if (!time.equals("")) {
            Integer[] timeArr = parseTime(time);
            calendar.set(Calendar.HOUR_OF_DAY, timeArr[0]);
            calendar.set(Calendar.MINUTE, timeArr[1]);
        }

        if (!date.equals("")) {
            Integer[] dateArr = parseDate(date);
            calendar.set(Calendar.DAY_OF_MONTH, dateArr[0]);
            calendar.set(Calendar.MONTH, dateArr[1] - 1);
            calendar.set(Calendar.YEAR, dateArr[2]);
        } else
            return  NULL_DATE;

        return calendar.getTimeInMillis();
    }

    private static Integer[] parseTime(String time) {
        String[] timeStringArr = time.replace(" ", "").split(":");
        Integer[] timeArr = new Integer[2];
        if (timeStringArr.length > 0) {
            for (int i = 0; i < timeStringArr.length ; i++)
                timeArr[i] = Integer.valueOf(timeStringArr[i]);
        }
        return timeArr;
    }

    private static Integer[] parseDate(String date) {
        String[] dateStringArr = date.replace(" ", "").split("/");
        Integer[] dateArr = new Integer[3];
        if (dateStringArr.length > 0) {
            for (int i = 0; i < dateStringArr.length; i++)
                dateArr[i] = Integer.valueOf(dateStringArr[i]);
        }
        return dateArr;
    }

    private static Calendar getCalendar(Long dateInMills) {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date(dateInMills);
        calendar.setTime(date);
        return calendar;

    }
}
