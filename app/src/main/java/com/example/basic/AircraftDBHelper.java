package com.example.basic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AircraftDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MainLogContract.MainLog.TABLE_NAME + " (" +
                    AircraftContract.Aircraft._ID + " INTEGER PRIMARY KEY," +
                    AircraftContract.Aircraft.COLUMN_NAME_REGISTRATION + " TEXT," +
                    AircraftContract.Aircraft.COLUMN_NAME_COUNTRY + " TEXT," +
                    AircraftContract.Aircraft.COLUMN_NAME_MAKER + " TEXT," +
                    AircraftContract.Aircraft.COLUMN_NAME_TYPE + " TEXT," +
                    AircraftContract.Aircraft.COLUMN_NAME_OWNER + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AircraftContract.Aircraft.TABLE_NAME;


    public AircraftDBHelper(Context context) {
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

