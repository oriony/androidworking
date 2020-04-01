package com.example.basic;

import android.content.Intent;
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
        Bundle extras = getIntent().getExtras();

        TextView e_date = findViewById(R.id.e_date);
        TextView entry_plane = findViewById(R.id.entry_plane);
        TextView entry_time = findViewById(R.id.entry_time);
        TextView entry_route = findViewById(R.id.entry_route);
        TextView e_pic = findViewById(R.id.e_pic);
        TextView e_pax = findViewById(R.id.e_pax);

        e_date.setText(extras.getString("DATE"));
        entry_plane.setText(extras.getString("REG"));
        entry_time.setText(extras.getString("TIME"));
        entry_route.setText(extras.getString("ORIGIN")+" > "+extras.getString("DEST"));
        e_pic.setText(extras.getString("PIC"));
        e_pax.setText(extras.getString("PAX"));

        Button create = (Button) findViewById(R.id.flight_entry);
        Button cancel = (Button) findViewById(R.id.cancel);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
