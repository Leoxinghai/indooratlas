// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import android.util.Log;
import java.util.BitSet;

// Referenced classes of package com.xinghai.indoor.service:
//            WIFIBase, XHWIFIManager

public class WEPWifi extends WIFIBase
{

    public WEPWifi()
    {
    }

    private static boolean wifiType(String s)
    {
        int i = s.length();
        if(i != 10 && i != 26 && i != 58)
            return false;
        else
            return isAlphaNum(s);
    }

    private static boolean isAlphaNum(String s)
    {
        int i = -1 + s.length();
        do
        {
            if(i < 0)
                return true;
            char c = s.charAt(i);
            if((c < '0' || c > '9') && (c < 'A' || c > 'F') && (c < 'a' || c > 'f'))
                return false;
            i--;
        } while(true);
    }

    public String wifiConfig(ScanResult scanresult)
    {
        String s = scanresult.capabilities;
        int i = -1 + wifiType.length;
        do
        {
            if(i < 0)
                return "Open";
            if(s.contains(wifiType[i]))
                return wifiType[i];
            i--;
        } while(true);
    }

    public String wifiConfig(WifiConfiguration wificonfiguration)
    {
        if(wificonfiguration.allowedKeyManagement.get(0))
            if(!wificonfiguration.allowedGroupCiphers.get(3) && (wificonfiguration.allowedGroupCiphers.get(0) || wificonfiguration.allowedGroupCiphers.get(1)))
                return "WEP";
            else
                return "Open";
        if(wificonfiguration.allowedProtocols.get(1))
            return "WPA2";
        if(wificonfiguration.allowedKeyManagement.get(2))
            return "WPA-EAP";
        if(wificonfiguration.allowedKeyManagement.get(3))
            return "IEEE8021X";
        if(wificonfiguration.allowedProtocols.get(0))
        {
            return "WPA";
        } else
        {
            Log.w("ConfigurationSecuritiesOld", "Unknown security type from WifiConfiguration, falling back on open.");
            return "Open";
        }
    }

    public void wifiConfig(WifiConfiguration wificonfiguration, String s, String s1)
    {
        int i;
        i = 1;
        wificonfiguration.allowedAuthAlgorithms.clear();
        wificonfiguration.allowedGroupCiphers.clear();
        wificonfiguration.allowedKeyManagement.clear();
        wificonfiguration.allowedPairwiseCiphers.clear();
        wificonfiguration.allowedProtocols.clear();
        if(TextUtils.isEmpty(s))
        {
            s = "Open";
            Log.w("ConfigurationSecuritiesOld", "Empty security, assuming open");
        }
        if(!s.equals("WEP")) {
                if(!s.equals("WPA") && !s.equals("WPA2")) {
                    if(s.equals("Open"))
                    {
                        wificonfiguration.allowedKeyManagement.set(0);
                        return;
                    }
                    if(s.equals("WPA-EAP") || s.equals("IEEE8021X"))
                    {
                        wificonfiguration.allowedGroupCiphers.set(2);
                        wificonfiguration.allowedGroupCiphers.set(3);
                        if(s.equals("WPA-EAP"))
                            wificonfiguration.allowedKeyManagement.set(2);
                        else
                            wificonfiguration.allowedKeyManagement.set(3);
                        if(!TextUtils.isEmpty(s1))
                        {
                            wificonfiguration.preSharedKey = XHWIFIManager.MF_null_a1(s1);
                            return;
                        }
                    }
                    return;
                }
                wificonfiguration.allowedGroupCiphers.set(2);
                wificonfiguration.allowedGroupCiphers.set(3);
                wificonfiguration.allowedKeyManagement.set(i);
                wificonfiguration.allowedPairwiseCiphers.set(2);
                wificonfiguration.allowedPairwiseCiphers.set(i);
                BitSet bitset = wificonfiguration.allowedProtocols;
                if(!s.equals("WPA2"))
                    i = 0;
                bitset.set(i);
                if(!TextUtils.isEmpty(s1))
                    if(s1.length() == 64 && isAlphaNum(s1))
                    {
                        wificonfiguration.preSharedKey = s1;
                        return;
                    } else
                    {
                        wificonfiguration.preSharedKey = XHWIFIManager.MF_null_a1(s1);
                        return;
                    }
        } else {
	        if(!TextUtils.isEmpty(s1))
	            if(wifiType(s1))
	                wificonfiguration.wepKeys[0] = s1;
	            else
	                wificonfiguration.wepKeys[0] = XHWIFIManager.MF_null_a1(s1);
	        wificonfiguration.wepTxKeyIndex = 0;
	        wificonfiguration.allowedAuthAlgorithms.set(0);
	        wificonfiguration.allowedAuthAlgorithms.set(i);
	        wificonfiguration.allowedKeyManagement.set(0);
	        wificonfiguration.allowedGroupCiphers.set(0);
	        wificonfiguration.allowedGroupCiphers.set(i);
        }
        
        return;

    }

    public boolean wifiConfig(String s)
    {
        return "Open".equals(s);
    }

    public static final String wifiConfig[] = {
        "PEAP", "TLS", "TTLS"
    };
    static final String wifiType[] = {
        "WEP", "WPA", "WPA2", "WPA-EAP", "IEEE8021X"
    };

}
