package com.ashish.silenceondischarge;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

/**
 * Created by Ashish Kalbhor on 5/15/2016.
 */
public class BatteryStatusPoll
{


    public static void checkStatus(Context context, int threshold)
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
    }

}
