package com.example.basic;

import android.provider.BaseColumns;

public final class ME_LogContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ME_LogContract() {}

    /* Inner class that defines the table contents */
    public static class ME_Log implements BaseColumns {
        public static final String TABLE_NAME = "multi_log";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_ME_DAY_DUAL = "me_day_dual";
        public static final String COLUMN_NAME_ME_DAY_PIC = "me_day_pic";
        public static final String COLUMN_NAME_ME_DAY_COPILOT = "me_day_copilot";
        public static final String COLUMN_NAME_ME_NIGHT_DUAL = "me_night_dual";
        public static final String COLUMN_NAME_ME_NIGHT_PIC = "me_night_pic";
        public static final String COLUMN_NAME_ME_NIGHT_COPILOT = "me_night_copilot";
    }
}

