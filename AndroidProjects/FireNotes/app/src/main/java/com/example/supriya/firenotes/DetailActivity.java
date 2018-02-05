package com.example.supriya.firenotes;

/**
 * Created by Supriya on 2/5/2018.
 */

import android.app.Activity;
import android.support.annotation.Nullable;

import java.util.GregorianCalendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.widget.Toast.*;


public class DetailActivity extends AppCompatActivity {
    TimePicker pickertime;
    DatePicker pickerdate;
    final static int RQS_1 = 1;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picker);
        pickertime = findViewById(R.id.pickertime);
        pickerdate=findViewById(R.id.pickerdate);
        Button btn = findViewById(R.id.alarm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
                AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

                int year = pickerdate.getYear();
                int month = pickerdate.getMonth();
                int day = pickerdate.getDayOfMonth();
                int hour = pickertime.getCurrentHour();
                int minute = pickertime.getCurrentMinute();
                GregorianCalendar calendar = new GregorianCalendar(year,month,day, hour, minute);
                /** Converting the date and time in to milliseconds elapsed since epoch */
                long alarm_time = calendar.getTimeInMillis();
                alarmManager.set(AlarmManager.RTC_WAKEUP,alarm_time , pendingIntent);
                Toast.makeText(DetailActivity.this, "Alarm is set "+alarm_time, Toast.LENGTH_SHORT).show();

            }
        });
    }
}


