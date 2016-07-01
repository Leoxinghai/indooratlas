// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;


// Referenced classes of package com.indooratlas.sensor:
//            CLASS380, WifiScanBroadcastReceiver

class CLASS379
    implements Runnable
{

    CLASS379(WifiScanBroadcastReceiver wifiscanbroadcastreceiver)
    {
        MF_CLASS379_a1105 = wifiscanbroadcastreceiver;

    }

    public void run()
    {
        WifiScanBroadcastReceiver.getCountDownTimer(MF_CLASS379_a1105, (new CLASS380(this, 0x7fffffffffffffffL, 3000L)).start());
    }

    final WifiScanBroadcastReceiver MF_CLASS379_a1105;
}
