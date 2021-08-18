package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView sr, T1, T2;
    private Button button;
    int t1h, t1m, t2h, t2m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        T1  = (TextView) findViewById(R.id.T1);
        sr  = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        T2  = (TextView) findViewById(R.id.T2);

// first clock
        T1.setOnClickListener(new View.OnClickListener() {
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
                                T1.setText(android.text.format.DateFormat.format( "hh-mm a", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1h,t1m);
                timePickerDialog.show();
            }
        });
// second clock
        T2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t2h = hourOfDay;
                                t2m = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t2h, t2m);
                                T2.setText(android.text.format.DateFormat.format( "hh-mm a",calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t2h,t2m);
                timePickerDialog.show();
            }
        });

// try to count but i can't
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("hh-mm");

                double c,x,y;

                String S3 = T1.getText().toString();
                String S4 = T2.getText().toString();


                x = Double.parseDouble(S3);
                y = Double.parseDouble(S4);

                c = y - x;

                String S = Double.toString(c);

                sr.setText(S);
            }
        });
    }
}