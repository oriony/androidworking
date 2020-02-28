package com.example.basic;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.basic.DateTimeText.getDateAsString;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText entry_date = findViewById(R.id.entry_date);
        final EditText entry_reg = findViewById(R.id.entry_reg);
        final EditText entry_type = findViewById(R.id.entry_type);
        final EditText entry_time = findViewById(R.id.entry_time);
        final EditText entry_origin = findViewById(R.id.entry_origin);
        final EditText entry_dest = findViewById(R.id.entry_dest);
        final EditText entry_pic = findViewById(R.id.entry_pic);
        final EditText entry_pax = findViewById(R.id.entry_pax);

        entry_date.setText(getDateAsString());

        Button create = (Button) findViewById(R.id.initial_entry);
        Button cancel = (Button) findViewById(R.id.cancel);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = entry_date.getText().toString();
                String reg = entry_reg.getText().toString();
                String type = entry_type.getText().toString();
                String flight_time = entry_time.getText().toString();
                String origin = entry_origin.getText().toString();
                String dest = entry_dest.getText().toString();
                String pic = entry_pic.getText().toString();
                String pax = entry_pax.getText().toString();

                Snackbar.make(view,"test text "+date, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


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
