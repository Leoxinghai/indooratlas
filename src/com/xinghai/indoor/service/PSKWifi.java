// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.util.Log;
import java.util.BitSet;

// Referenced classes of package com.xinghai.indoor.service:
//            WIFIBase

public class PSKWifi extends WIFIBase
{

    public PSKWifi()
    {
    }

    private static int wifiType(ScanResult scanresult)
    {
        if(scanresult.capabilities.contains("WEP"))
            return 1;
        if(scanresult.capabilities.contains("PSK"))
            return 2;
        return !scanresult.capabilities.contains("EAP") ? 0 : 3;
    }

    private static int wifiType(WifiConfiguration wificonfiguration)
    {
        int i = 1;
        if(wificonfiguration.allowedKeyManagement.get(i))
        {
            i = 2;
        } else
        {
            if(wificonfiguration.allowedKeyManagement.get(2) || wificonfiguration.allowedKeyManagement.get(3))
                return 3;
            if(wificonfiguration.wepKeys[0] == null)
                return 0;
        }
        return i;
    }

    public String wifiConfig(ScanResult scanresult)
    {
        return String.valueOf(wifiType(scanresult));
    }

    public String wifiConfig(WifiConfiguration wificonfiguration)
    {
        return String.valueOf(wifiType(wificonfiguration));
    }

    public void wifiConfig(WifiConfiguration wificonfiguration, String s, String s1)
    {
        int j;
        wificonfiguration.allowedAuthAlgorithms.clear();
        wificonfiguration.allowedGroupCiphers.clear();
        wificonfiguration.allowedKeyManagement.clear();
        wificonfiguration.allowedPairwiseCiphers.clear();
        wificonfiguration.allowedProtocols.clear();
        int i;
        if(s == null)
            i = 0;
        else
            i = Integer.valueOf(s).intValue();
        if(s1 == null)
            j = 0;
        else
            j = s1.length();
        switch(i) {
//        JVM INSTR tableswitch 0 3: default 80
    //                   0 125
    //                   1 134
    //                   2 232
    //                   3 289;
//           goto _L1 _L2 _L3 _L4 _L5
default:
        Log.e("ConfigurationSecuritiesV14", (new StringBuilder("Invalid security type: ")).append(i).toString());
        break;
case 0:
        wificonfiguration.allowedKeyManagement.set(0);
        break;
case 1:
        wificonfiguration.allowedKeyManagement.set(0);
        wificonfiguration.allowedAuthAlgorithms.set(0);
        wificonfiguration.allowedAuthAlgorithms.set(1);
        if(j != 0) {
	        if((j == 10 || j == 26 || j == 58) && s1.matches("[0-9A-Fa-f]*"))
	        {
	            wificonfiguration.wepKeys[0] = s1;
	            return;
	        } else
	        {
	            wificonfiguration.wepKeys[0] = (new StringBuilder(String.valueOf('"'))).append(s1).append('"').toString();
	            return;
	        }
        }
        break;
case 2:
        wificonfiguration.allowedKeyManagement.set(1);
        if(j != 0) {
	        if(s1.matches("[0-9A-Fa-f]{64}"))
	        {
	            wificonfiguration.preSharedKey = s1;
	            return;
	        } else
	        {
	            wificonfiguration.preSharedKey = (new StringBuilder(String.valueOf('"'))).append(s1).append('"').toString();
	            return;
	        }
        }
        break;
case 3:
        wificonfiguration.allowedKeyManagement.set(2);
        wificonfiguration.allowedKeyManagement.set(3);
        break;
        }
        
    }

    public boolean wifiConfig(String s)
    {
        return String.valueOf(0).equals(s);
    }
}
