package com.example.supriya.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

/**
 * Created by Supriya on 1/20/2018.
 */

class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
            float perc=(((float)level/(float)scale)*100.0f);
            Intent i = new Intent(context,MainActivity.class);
            i.putExtra("level", perc);
            context.startActivity(i);
    }
}
