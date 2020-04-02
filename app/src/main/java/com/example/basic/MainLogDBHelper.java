package com.example.basic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MainLogDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MainLogContract.MainLog.TABLE_NAME + " (" +
                    MainLogContract.MainLog._ID + " INTEGER PRIMARY KEY," +
                    MainLogContract.MainLog.COLUMN_NAME_TIMESTAMP + " INTEGER," +
                    MainLogContract.MainLog.COLUMN_NAME_DATE + " TEXT," +
                    MainLogContract.MainLog.COLUMN_NAME_REGISTRATION + " TEXT," +
                    MainLogContract.MainLog.COLUMN_NAME_ORIGIN + " TEXT," +
                    MainLogContract.MainLog.COLUMN_NAME_DESTINATION + " TEXT," +
                    MainLogContract.MainLog.COLUMN_NAME_PIC + " TEXT," +
                    MainLogContract.MainLog.COLUMN_NAME_PAX + " TEXT," +

                    MainLogContract.MainLog.COLUMN_NAME_XC_DAY + " REAL," +
                    MainLogContract.MainLog.COLUMN_NAME_XC_NIGHT + " REAL," +
                    MainLogContract.MainLog.COLUMN_NAME_TL_DAY + " INTEGER," +
                    MainLogContract.MainLog.COLUMN_NAME_TL_NIGHT + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MainLogContract.MainLog.TABLE_NAME;


    public MainLogDBHelper(Context context) {
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

