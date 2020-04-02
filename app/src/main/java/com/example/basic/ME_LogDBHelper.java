package com.example.basic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ME_LogDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MainLogContract.MainLog.TABLE_NAME + " (" +
                    ME_LogContract.ME_Log._ID + " INTEGER PRIMARY KEY," +
                    ME_LogContract.ME_Log.COLUMN_NAME_DATE + " TEXT," +
                    ME_LogContract.ME_Log.COLUMN_NAME_ME_DAY_DUAL + " REAL," +
                    ME_LogContract.ME_Log.COLUMN_NAME_ME_DAY_PIC + " REAL," +
                    ME_LogContract.ME_Log.COLUMN_NAME_ME_DAY_COPILOT + " REAL," +
                    ME_LogContract.ME_Log.COLUMN_NAME_ME_NIGHT_DUAL + " REAL," +
                    ME_LogContract.ME_Log.COLUMN_NAME_ME_NIGHT_PIC + " REAL," +
                    ME_LogContract.ME_Log.COLUMN_NAME_ME_NIGHT_COPILOT + " REAL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ME_LogContract.ME_Log.TABLE_NAME;


    public ME_LogDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

