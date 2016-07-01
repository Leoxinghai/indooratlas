// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.wifiroaming;

import android.content.*;

// Referenced classes of package com.indooratlas.wifiroaming:
//            CLASS382, WifiRoamingScanReceiver

class CLASS384 extends BroadcastReceiver
{

    CLASS384(WifiRoamingScanReceiver wifiroamingscanreceiver)
    {
        super();
        MF_CLASS384_a1116 = wifiroamingscanreceiver;
    }

    public void onReceive(Context context, Intent intent)
    {
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "connectivityReceiver.onReceive()  called");
        MF_CLASS384_a1116.c();
    }

    final WifiRoamingScanReceiver MF_CLASS384_a1116;
}
