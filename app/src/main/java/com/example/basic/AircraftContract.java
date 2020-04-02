package com.example.basic;

import android.provider.BaseColumns;

public final class AircraftContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private AircraftContract() {}

    /* Inner class that defines the table contents */
    public static class Aircraft implements BaseColumns {
        public static final String TABLE_NAME = "aircraft";
        public static final String COLUMN_NAME_REGISTRATION = "registration";
        public static final String COLUMN_NAME_COUNTRY = "country";
        public static final String COLUMN_NAME_MAKER = "maker";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_OWNER = "owner";
    }
}

