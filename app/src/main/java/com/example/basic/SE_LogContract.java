package com.example.basic;

import android.provider.BaseColumns;

public final class SE_LogContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SE_LogContract() {}

    /* Inner class that defines the table contents */
    public static class SE_Log implements BaseColumns {
        public static final String TABLE_NAME = "single_log";
        public static final String COLUMN_NAME_DATE = "date";

        public static final String COLUMN_NAME_SE_DAY_DUAL = "se_day_dual";
        public static final String COLUMN_NAME_SE_DAY_PIC = "se_day_pic";
        public static final String COLUMN_NAME_SE_NIGHT_DUAL = "se_night_dual";
        public static final String COLUMN_NAME_SE_NIGHT_PIC = "se_night_pic";
    }
}

