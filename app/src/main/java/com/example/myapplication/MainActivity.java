package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity<Time1> extends AppCompatActivity {

    private TextView Time1, show_time ;
    int t1h, t1m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Time1 = (TextView) findViewById(R.id.T1);
        Button button = (Button) findViewById(R.id.button);

// first clock
        Time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(  
                        MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1h = hourOfDay;
                                t1m = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0,t1h,t1m);
                                Time1.setText(android.text.format.DateFormat.format( "hh-mm a", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1h,t1m);
                timePickerDialog.show();
            }
        });


// try to Show time
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Time1 = (TextView) findViewById(R.id.show_time);
                SimpleDateFormat sdf = new SimpleDateFormat("hh-mm");
                Calendar calendar = Calendar.getInstance();
                calendar.set(0, 0, 0,t1h,t1m);
                Time1 = (TextView) findViewById(R.id.show_time);
                Time1.setText(android.text.format.DateFormat.format( "hh-mm a", calendar));
            }
        });
    }
}