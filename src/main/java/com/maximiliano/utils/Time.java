package com.maximiliano.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time {

    public static Timestamp create(int day, int month, int year, int hour, int minute, int second) {
        Calendar calendar = new GregorianCalendar(year, month, day, hour, minute, second);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static String toString(Timestamp timestamp) {
        return timestamp.toString().substring(0, 19);
    }
}
