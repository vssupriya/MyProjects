package com.example.supriya.firenotes;

/**
 * Created by Supriya on 2/5/2018.
 */

import android.support.v4.app.NotificationCompat;


        import android.app.Notification;
        import android.app.NotificationManager;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.media.Ringtone;
        import android.media.RingtoneManager;
        import android.net.Uri;
        import android.support.v4.app.NotificationCompat;


/**
 * Created by Supriya on 1/29/2018.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Notification notification=new NotificationCompat.Builder(context,"test")
                .setContentTitle(" TO DO APP ")
                .setContentText("   REMINDER  ")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
       /* for OREO
        if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.0)

        {
            NotificationChannel notificationChannel=new NotificationChannel("test",)
        }*/
        notificationManager.notify(123,notification);
    }
}
