package com.example.basic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.google.android.material.snackbar.Snackbar;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;
import static com.basgeekball.awesomevalidation.ValidationStyle.UNDERLABEL;
import static com.example.basic.DateTimeText.getDateAsString;

public class InitialEntry extends AppCompatActivity {

    AwesomeValidation mAwesomeValidation = new AwesomeValidation(COLORATION);
    String registration_regex = "^(C-){0,1}[GFgf]\\w{3}$";
    String type_regex = "^\\w+$";
    String aerodrome_regex = "^[\\w\\d]{4}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mAwesomeValidation.setContext(this);

        final EditText entry_date = findViewById(R.id.entry_date);
        final EditText entry_reg = findViewById(R.id.entry_reg);
        final EditText entry_time = findViewById(R.id.entry_time);
        final EditText entry_origin = findViewById(R.id.entry_origin);
        final EditText entry_dest = findViewById(R.id.entry_dest);
        final EditText entry_pic = findViewById(R.id.entry_pic);
        final EditText entry_pax = findViewById(R.id.entry_pax);

        mAwesomeValidation.addValidation(this, R.id.entry_date, "^\\d{4}\\-\\d{2}\\-\\d{2}$", R.string.dateerror);
        mAwesomeValidation.addValidation(this, R.id.entry_reg, registration_regex, R.string.regerror);
        mAwesomeValidation.addValidation(this, R.id.entry_time, "^\\d+(\\.\\d)*$", R.string.timeerror);
        mAwesomeValidation.addValidation(this, R.id.entry_origin, aerodrome_regex, R.string.aerodromeerror);
        mAwesomeValidation.addValidation(this, R.id.entry_dest, aerodrome_regex, R.string.aerodromeerror);
        mAwesomeValidation.addValidation(this, R.id.entry_pic, "^\\D+(\\s\\D+)*$", R.string.nameerror);

        entry_date.setText(getDateAsString());

        Button create = (Button) findViewById(R.id.initial_entry);
        Button cancel = (Button) findViewById(R.id.cancel);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = entry_date.getText().toString();
                String reg = entry_reg.getText().toString().toUpperCase();
                String time = entry_time.getText().toString();
                String origin = entry_origin.getText().toString().toUpperCase();
                String dest = entry_dest.getText().toString().toUpperCase();
                String pic = entry_pic.getText().toString();
                String pax = entry_pax.getText().toString();

                boolean check_day = ((CheckBox) findViewById(R.id.check_day)).isChecked();
                boolean check_night = ((CheckBox) findViewById(R.id.check_night)).isChecked();
                boolean check_ifr = ((CheckBox) findViewById(R.id.check_ifr)).isChecked();
                boolean check_xc = ((CheckBox) findViewById(R.id.check_xc)).isChecked();

                Intent detail_entry = new Intent(InitialEntry.this, FlightEntry.class);
                detail_entry.putExtra("DATE", date);
                detail_entry.putExtra("REG", reg);
                detail_entry.putExtra("TIME", time);
                detail_entry.putExtra("TYPE_D", check_day);
                detail_entry.putExtra("TYPE_N", check_night);
                detail_entry.putExtra("TYPE_I", check_ifr);
                detail_entry.putExtra("TYPE_X", check_xc);
                detail_entry.putExtra("ORIGIN", origin);
                detail_entry.putExtra("DEST", dest);
                detail_entry.putExtra("PIC", pic);
                detail_entry.putExtra("PAX", pax);

                if (check_day || check_night) {
                    if (mAwesomeValidation.validate()) {
                        startActivity(detail_entry);
                    }
                }
                else {
                    Snackbar.make(view, R.string.nochecked, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
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
