package com.example.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeText {
    static final String DATE_FORMAT = "yyyy-MM-dd";
    static final String TIME_FORMAT = "kkmm";

    public static Date getUTCdatetimeAsDate() {
        // note: doesn't check for null
        return stringDateToDate(getUTCDateAsString());
    }

    public static String getUTCDateAsString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcDate = sdf.format(new Date());
        return utcDate;
    }

    public static String getDateAsString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        final String lclDate = sdf.format(new Date());
        return lclDate;
    }

    public static String getUTCTimeAsString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(new Date());
        return utcTime;
    }

    public static String getTimeAsString() {
        final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        final String lclTime = sdf.format(new Date());
        return lclTime;
    }

    public static Date stringDateToDate(String StrDate) {
        Date dateToReturn = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            dateToReturn = (Date)dateFormat.parse(StrDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return dateToReturn;
    }
}


