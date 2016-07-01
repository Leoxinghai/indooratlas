// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.wifiroaming;

import android.net.wifi.ScanResult;
import java.util.Comparator;

// Referenced classes of package com.indooratlas.wifiroaming:
//            WifiRoamingScanReceiver

class CLASS386
    implements Comparator
{

    CLASS386(WifiRoamingScanReceiver wifiroamingscanreceiver)
    {
        MF_CLASS386_a1118 = wifiroamingscanreceiver;

    }

    public int MF_CLASS386_a1118(ScanResult scanresult, ScanResult scanresult1)
    {
        if(scanresult.level > scanresult1.level)
            return -1;
        return scanresult.level >= scanresult1.level ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return MF_CLASS386_a1118((ScanResult)obj, (ScanResult)obj1);
    }

    final WifiRoamingScanReceiver MF_CLASS386_a1118;
}
