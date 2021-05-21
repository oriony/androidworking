package com.example.basic;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import static com.example.basic.DateTimeText.getDateAsString;
import static com.example.basic.DateTimeText.getUTCDateAsString;


public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainLogDBHelper main_dbHelper = new MainLogDBHelper(this);
        MedicalDBHelper recents_dbHelper = new MedicalDBHelper(this);

        //TextView lclTime = (TextView)findViewById(R.id.lclTime);
        //lclTime.setText(getTimeAsString());
        //TextView utcTime = (TextView)findViewById(R.id.utcTime);
        //utcTime.setText(getUTCTimeAsString());

        TextView lclDate = (TextView)findViewById(R.id.lclDate);
        lclDate.setText(getDateAsString());
        TextView utcDate = (TextView)findViewById(R.id.utcDate);
        utcDate.setText(getUTCDateAsString());

        TextView since_flight = (TextView)findViewById(R.id.since_flight);
        since_flight.setText("1");
        TextView since_dual = (TextView)findViewById(R.id.since_dual);
        since_dual.setText("1");
        TextView since_night = (TextView)findViewById(R.id.since_night);
        since_night.setText("42");
        TextView since_ifr = (TextView)findViewById(R.id.since_ifr);
        since_ifr.setText("-");

        TextView medical_expiry = (TextView)findViewById(R.id.medical_expiry);
        medical_expiry.setText("Medical expires in " + "108" + " days");
        TextView medical_type = (TextView)findViewById(R.id.medical_type);
        medical_type.setText("Category " + "3");

        final MainLogDBHelper dbHelper = new MainLogDBHelper(getApplicationContext());
        Button flight = findViewById(R.id.flight);
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, InitialEntry.class);
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
