package com.example.basic;

import android.provider.BaseColumns;

public final class MedicalContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private MedicalContract() {}

    /* Inner class that defines the table contents */
    public static class Medical implements BaseColumns {
        public static final String TABLE_NAME = "medical";
        public static final String COLUMN_NAME_EXAM = "exam";
        public static final String COLUMN_NAME_ISSUE = "issue";
        public static final String COLUMN_NAME_EXPIRY = "expiry";
        public static final String COLUMN_NAME_CLASS = "class";
        public static final String COLUMN_NAME_EXAMINER = "examiner";
    }
}

