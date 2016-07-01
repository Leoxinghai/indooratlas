// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;

import android.content.*;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.sensor:
//            WifiScanBroadcastReceiver

class CLASS378 extends BroadcastReceiver
{

    CLASS378(WifiScanBroadcastReceiver wifiscanbroadcastreceiver)
    {
        super();
        MF_CLASS378_a1104 = wifiscanbroadcastreceiver;
    }

    public void onReceive(Context context, Intent intent)
    {
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver : connectivity event onReceive");
        MF_CLASS378_a1104.connectivityChanged();
    }

    final WifiScanBroadcastReceiver MF_CLASS378_a1104;
}
