// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;

import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.os.SystemClock;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.sensor:
//            CLASS379, WifiScanBroadcastReceiver

class CLASS380 extends CountDownTimer
{

    CLASS380(CLASS379 class379, long l, long l1)
    {
        super(l, l1);
        MF_CLASS379_a1105 = class379;
    }

    public void onFinish()
    {
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "mScanResultPoller.onFinish(): polling stopped...");
    }

    public void onTick(long l)
    {
        long l1 = SystemClock.elapsedRealtime() - WifiScanBroadcastReceiver.a(MF_CLASS379_a1105.MF_CLASS379_a1105);
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("scanResultPoller.onTick(): elapsedSinceLastScanResults = ").append(l1).toString());
        if(l1 > 3000L)
        {
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "scanResultPoller.onTick(): initiating scan!");
            WifiScanBroadcastReceiver.a(MF_CLASS379_a1105.MF_CLASS379_a1105, SystemClock.elapsedRealtime());
            boolean flag = WifiScanBroadcastReceiver.b(MF_CLASS379_a1105.MF_CLASS379_a1105).startScan();
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("scanResultPoller.onTick(): scanInitiated = ").append(flag).toString());
        }
    }

    final CLASS379 MF_CLASS379_a1105;
}
