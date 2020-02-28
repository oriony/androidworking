package com.example.basic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.BaseColumns;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.basic.DateTimeText.getDateAsString;
import static com.example.basic.DateTimeText.getTimeAsString;
import static com.example.basic.DateTimeText.getUTCDateAsString;
import static com.example.basic.DateTimeText.getUTCTimeAsString;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TextView lclTime = (TextView)findViewById(R.id.lclTime);
        //lclTime.setText(getTimeAsString());
        //TextView utcTime = (TextView)findViewById(R.id.utcTime);
        //utcTime.setText(getUTCTimeAsString());

        TextView lclDate = (TextView)findViewById(R.id.lclDate);
        lclDate.setText(getDateAsString());
        TextView utcDate = (TextView)findViewById(R.id.utcDate);
        utcDate.setText(getUTCDateAsString());

        TextView since_flight = (TextView)findViewById(R.id.since_flight);
        since_flight.setText("52");
        TextView since_night = (TextView)findViewById(R.id.since_night);
        since_night.setText("1");
        TextView since_ifr = (TextView)findViewById(R.id.since_ifr);
        since_ifr.setText("52");
        TextView since_dual = (TextView)findViewById(R.id.since_dual);
        since_dual.setText("1");

        TextView medical_expiry = (TextView)findViewById(R.id.medical_expiry);
        medical_expiry.setText("Medical expires in " + "52" + " days");
        TextView medical_type = (TextView)findViewById(R.id.medical_type);
        medical_type.setText("(Category " + "1" + ")");

        final FeedReaderDBHelper dbHelper = new FeedReaderDBHelper(getApplicationContext());
        Button flight = findViewById(R.id.flight);
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);

                //Snackbar.make(view, getDateAsString(), Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
