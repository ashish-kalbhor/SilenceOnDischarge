package com.ashish.silenceondischarge;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Ashish Kalbhor on 5/15/2016.
 */
public class BatteryService extends Service
{
    int threshold = 0;


    private BroadcastReceiver BatteryLevelReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            int rawlevel = intent.getIntExtra("level", -1);
            int scale = intent.getIntExtra("scale", -1);
            int level = -1;

            if ( rawlevel >= 0 && scale > 0 )
            {
                level = rawlevel * 100 / scale;
            }

            if ( level == threshold )
            {
                Toast.makeText(context, "Threshold reached", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(context, "Threshold NOT reached", Toast.LENGTH_LONG).show();
            }
        }
    };

    /*public static void checkStatus(Context context, int threshold)
    {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        int rawlevel = batteryStatus.getIntExtra("level", -1);
        int scale = batteryStatus.getIntExtra("scale", -1);
        int level = -1;

        if ( rawlevel >= 0 && scale > 0 )
        {
            level = rawlevel * 100 / scale;
        }

        if ( level == threshold )
        {
            Toast.makeText(context, "Threshold reached", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Threshold NOT reached", Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    public void onCreate()
    {
        super.onCreate();
        this.registerReceiver(this.BatteryLevelReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
