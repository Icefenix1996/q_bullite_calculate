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

    private EditText ns, q1, q2;
    private TextView sr, T1, T2;
    private Button button;
    int t1h, t1m, t2h, t2m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ns  = (EditText) findViewById(R.id.ns);
        q1 = (EditText) findViewById(R.id.Q1);
        q2 = (EditText) findViewById(R.id.Q2);
        T1  = (TextView) findViewById(R.id.T1);
        sr  = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        T2  = (TextView) findViewById(R.id.T2);
        
        

        T1.setOnClickListener(new View.OnClickListener() { // first clock  
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


        T2.setOnClickListener(new View.OnClickListener() {   // 2 clock
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




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("hh-mm");
                //Объявим числовые переменные
                double a,b,c,x,y;
                //Считаем с editText и editText2 текстовые значения
                String S1 = q1.getText().toString();
                String S2 = q2.getText().toString();
                String S3 = T1.getText().toString();
                String S4 = T2.getText().toString();

                //Преобразуем текстовые переменные в числовые значения
                a = Double.parseDouble(S1);
                b = Double.parseDouble(S2);
                x = Double.parseDouble(S3);
                y = Double.parseDouble(S4);

                //Проведем с числовыми переменными нужные действия
                double time = y-x;
                c = (b-a)/time*60*24*0.9;

                //Преобразуем ответ в число
                String S = Double.toString(c);


                sr.setText(S);
            }
        });
    }
}