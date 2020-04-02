package com.example.basic;

import android.provider.BaseColumns;

public final class IFR_LogContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private IFR_LogContract() {}

    /* Inner class that defines the table contents */
    public static class IFR_Log implements BaseColumns {
        public static final String TABLE_NAME = "ifr_log";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_IFR_ACTUAL = "ifr_actual";
        public static final String COLUMN_NAME_IFR_SIM = "ifr_sim";
        public static final String COLUMN_NAME_IFR_FLTSIM = "ifr_fltsim";
    }
}

