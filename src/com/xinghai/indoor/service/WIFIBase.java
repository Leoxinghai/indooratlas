// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;

// Referenced classes of package com.xinghai.indoor.service:
//            WEPWifi, PSKWifi

public abstract class WIFIBase
{

    public WIFIBase()
    {
    }

    public static WIFIBase wifiConfig()
    {
        if(android.os.Build.VERSION.SDK_INT < 8)
            return new WEPWifi();
        else
            return new PSKWifi();
    }

    public abstract String wifiConfig(ScanResult scanresult);

    public abstract String wifiConfig(WifiConfiguration wificonfiguration);

    public abstract void wifiConfig(WifiConfiguration wificonfiguration, String s, String s1);

    public abstract boolean wifiConfig(String s);
}
