// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS167, WifiScanReceiver

class CLASS170 extends CountDownTimer
{

    CLASS170(WifiScanReceiver wifiscanreceiver, long l, long l1)
    {
        super(l, l1);
        MF_CLASS170_a638 = wifiscanreceiver;
    }

    public void onFinish()
    {
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "mScanResultPoller.onFinish(): polling stopped...");
    }

    public void onTick(long l)
    {
        long l1 = System.currentTimeMillis() - MF_CLASS170_a638.c;
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("mScanResultPoller.onTick(): elapsedSinceLastScanResults = ").append(l1).toString());
        if(l1 > 3000L)
        {
            CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "mScanResultPoller.onTick(): initiating scan!");
            MF_CLASS170_a638.b = System.currentTimeMillis();
            boolean flag = MF_CLASS170_a638.MF_CLASS108_a447.mWifiManager.startScan();
            CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("mScanResultPoller.onTick(): scanInitiated = ").append(flag).toString());
        }
    }

    final WifiScanReceiver MF_CLASS170_a638;
}
