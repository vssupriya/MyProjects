package com.example.supriya.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView batterytxt1, batterytxt2;
    private BroadcastReceiver mBatInfoReceiver = new MyReceiver();
    private String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        MainActivity.this.registerReceiver(mBatInfoReceiver,intentFilter);
        Float rec = i.getFloatExtra("level", 1);
        Log.e(TAG, "onCreate: "+rec );
        if (rec <= 15.0) {
            setContentView(R.layout.newstatus);
            batterytxt1=findViewById(R.id.tv);
            batterytxt1.setText(rec+"%");
        }


        else{
            setContentView(R.layout.activity_main);
            batterytxt2=findViewById(R.id.textView2);
            batterytxt2.setText(rec+"%");

            }
        }
    }
