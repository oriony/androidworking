package com.example.basic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import static com.example.basic.DateTimeText.getDateAsString;

public class InitialEntry extends AppCompatActivity {

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
                String reg = entry_reg.getText().toString().toUpperCase();
                String type = entry_type.getText().toString().toUpperCase();
                String time = entry_time.getText().toString();
                String origin = entry_origin.getText().toString().toUpperCase();
                String dest = entry_dest.getText().toString().toUpperCase();
                String pic = entry_pic.getText().toString();
                String pax = entry_pax.getText().toString();

                String time_type;
                boolean check_day = ((CheckBox) findViewById(R.id.check_day)).isChecked();
                boolean check_night = ((CheckBox) findViewById(R.id.check_night)).isChecked();
                boolean check_ifr = ((CheckBox) findViewById(R.id.check_ifr)).isChecked();
                boolean check_xc = ((CheckBox) findViewById(R.id.check_xc)).isChecked();
                if (check_day)
                    time_type = "1";
                else
                    time_type = "0";
                if (check_night)
                    time_type = time_type + "1";
                else
                    time_type = time_type + "0";
                if (check_ifr)
                    time_type = time_type + "1";
                else
                    time_type = time_type + "0";
                if (check_xc)
                    time_type = time_type + "1";
                else
                    time_type = time_type + "0";

                Intent detail_entry = new Intent(InitialEntry.this, FlightEntry.class);
                detail_entry.putExtra("DATE", date);
                detail_entry.putExtra("REG", reg);
                detail_entry.putExtra("TYPE", type);
                detail_entry.putExtra("TIME", time);
                detail_entry.putExtra("DIV", time_type);
                detail_entry.putExtra("ORIGIN", origin);
                detail_entry.putExtra("DEST", dest);
                detail_entry.putExtra("PIC", pic);
                detail_entry.putExtra("PAX", pax);
                startActivity(detail_entry);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showDatePickerDialog(View v) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
