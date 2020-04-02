package com.example.basic;

import android.provider.BaseColumns;

public final class MainLogContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private MainLogContract() {}

    /* Inner class that defines the table contents */
    public static class MainLog implements BaseColumns {
        public static final String TABLE_NAME = "main_log";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_REGISTRATION = "registration";
        public static final String COLUMN_NAME_ORIGIN = "origin";
        public static final String COLUMN_NAME_DESTINATION = "destination";

        public static final String COLUMN_NAME_XC_DAY = "xc_day";
        public static final String COLUMN_NAME_XC_NIGHT = "xc_night";
        public static final String COLUMN_NAME_TL_DAY = "tl_day";
        public static final String COLUMN_NAME_TL_NIGHT = "tl_night";
        public static final String COLUMN_NAME_PIC = "pic";
        public static final String COLUMN_NAME_PAX = "pax";
    }
}

