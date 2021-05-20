package com.example.basic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FlightEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Bundle extras = getIntent().getExtras();

        TextView e_date = findViewById(R.id.e_date);
        TextView entry_plane = findViewById(R.id.entry_plane);
        TextView entry_time = findViewById(R.id.entry_time);
        TextView entry_route = findViewById(R.id.entry_route);
        TextView e_pic = findViewById(R.id.e_pic);
        TextView e_pax = findViewById(R.id.e_pax);

        final String date = extras.getString("DATE");

        e_date.setText(extras.getString("DATE"));
        entry_plane.setText(extras.getString("REG"));
        entry_time.setText(extras.getString("TIME"));
        entry_route.setText(extras.getString("ORIGIN")+" > "+extras.getString("DEST"));
        e_pic.setText(extras.getString("PIC"));
        e_pax.setText(extras.getString("PAX"));

        String fields = "";
        if (extras.getBoolean("TYPE_D")) {
            fields = fields + "day";
        }
        else {
            fields = fields + "0";
        }
        fields = fields + " | ";
        if (extras.getBoolean("TYPE_N")) {
            fields = fields + "night";
        }
        else {
            fields = fields + "0";
        }
        fields = fields + " | ";
        if (extras.getBoolean("TYPE_I")) {
            fields = fields + "ifr";
        }
        else {
            fields = fields + "0";
        }
        fields = fields + " | ";
        if (extras.getBoolean("TYPE_X")) {
            fields = fields + "xc";
        }
        else {
            fields = fields + "0";
        }
        TextView entry_time2 = findViewById(R.id.entry_time2);
        entry_time2.setText(fields);

        Button create = (Button) findViewById(R.id.flight_entry);
        Button cancel = (Button) findViewById(R.id.cancel);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainLogDBHelper dbHelper = new MainLogDBHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                //values.put(MainLogContract.MainLog.COLUMN_NAME_TIMESTAMP, title);
                values.put(MainLogContract.MainLog.COLUMN_NAME_DATE, extras.getString("DATE"));
                values.put(MainLogContract.MainLog.COLUMN_NAME_REGISTRATION, extras.getString("REG"));
                values.put(MainLogContract.MainLog.COLUMN_NAME_ORIGIN, extras.getString("ORIGIN"));
                values.put(MainLogContract.MainLog.COLUMN_NAME_DESTINATION, extras.getString("DEST"));
                //values.put(MainLogContract.MainLog.COLUMN_NAME_XC_DAY, );
                //values.put(MainLogContract.MainLog.COLUMN_NAME_XC_NIGHT, );
                //values.put(MainLogContract.MainLog.COLUMN_NAME_TL_DAY, );
                //values.put(MainLogContract.MainLog.COLUMN_NAME_TL_NIGHT, );
                values.put(MainLogContract.MainLog.COLUMN_NAME_PIC, extras.getString("PIC"));
                values.put(MainLogContract.MainLog.COLUMN_NAME_PAX, extras.getString("PAX"));

                long newRowId = db.insert(MainLogContract.MainLog.TABLE_NAME, null, values);

                Intent final_entry = new Intent(FlightEntry.this, HomeScreen.class);
                final_entry.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(final_entry);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
