// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.content.Context;
import android.net.wifi.*;
import android.text.TextUtils;
import java.util.*;

// Referenced classes of package com.xinghai.indoor.service:
//            WIFIBase, XHComparator, WIFIContext

public class XHWIFIManager
{

    private static int MF_null_a1(WifiManager wifimanager)
    {
        List list = wifimanager.getConfiguredNetworks();
        MF_null_a1(list);
        int i = list.size();
        int j = 0;
        do
        {
            if(j >= i)
            {
                wifimanager.saveConfiguration();
                return i;
            }
            WifiConfiguration wificonfiguration = (WifiConfiguration)list.get(j);
            wificonfiguration.priority = j;
            wifimanager.updateNetwork(wificonfiguration);
            j++;
        } while(true);
    }

    public static WifiConfiguration MF_null_a1(WifiManager wifimanager, ScanResult scanresult, String s)
    {
        String s1 = MF_null_a1(scanresult.SSID);
        if(s1.length() == 0)
            return null;
        String s2 = scanresult.BSSID;
        if(s2 == null)
            return null;
        if(s == null)
            s = MF_null_a1.wifiConfig(scanresult);
        List list = wifimanager.getConfiguredNetworks();
        if(list == null)
            return null;
        Iterator iterator = list.iterator();
        WifiConfiguration wificonfiguration;
        do
        {
            if(!iterator.hasNext())
                return null;
            wificonfiguration = (WifiConfiguration)iterator.next();
        } while(wificonfiguration.SSID == null || !s1.equals(wificonfiguration.SSID) || wificonfiguration.BSSID != null && !s2.equals(wificonfiguration.BSSID) || !s.equals(MF_null_a1.wifiConfig(wificonfiguration)));
        return wificonfiguration;
    }

    public static WifiConfiguration MF_null_a1(WifiManager wifimanager, WifiConfiguration wificonfiguration, String s)
    {
        String s1 = wificonfiguration.SSID;
        if(s1.length() == 0)
            return null;
        String s2 = wificonfiguration.BSSID;
        if(s == null)
            s = MF_null_a1.wifiConfig(wificonfiguration);
        Iterator iterator = wifimanager.getConfiguredNetworks().iterator();
        WifiConfiguration wificonfiguration1;
        do
        {
            if(!iterator.hasNext())
                return null;
            wificonfiguration1 = (WifiConfiguration)iterator.next();
        } while(wificonfiguration1.SSID == null || !s1.equals(wificonfiguration1.SSID) || wificonfiguration1.BSSID != null && s2 != null && !s2.equals(wificonfiguration1.BSSID) || !s.equals(MF_null_a1.wifiConfig(wificonfiguration1)));
        return wificonfiguration1;
    }

    public static String MF_null_a1(String s)
    {
        if(TextUtils.isEmpty(s))
        {
            s = "";
        } else
        {
            int i = -1 + s.length();
            if(i <= 0 || s.charAt(0) != '"' || s.charAt(i) != '"')
                return (new StringBuilder("\"")).append(s).append("\"").toString();
        }
        return s;
    }

    private static void MF_null_a1(List list)
    {
        Collections.sort(list, new XHComparator());
    }

    public static boolean MF_null_a1(Context context, WifiManager wifimanager, ScanResult scanresult, String s, int i)
    {
        String s1;
        WifiConfiguration wificonfiguration;
        s1 = MF_null_a1.wifiConfig(scanresult);
        if(MF_null_a1.wifiConfig(s1))
            MF_null_a1(wifimanager, i);
        wificonfiguration = new WifiConfiguration();
        wificonfiguration.SSID = MF_null_a1(scanresult.SSID);
        wificonfiguration.BSSID = scanresult.BSSID;
        MF_null_a1.wifiConfig(wificonfiguration, s1, s);
        int j = 0;
        int k=0;
        try
        {
            k = wifimanager.addNetwork(wificonfiguration);
            j = k;
        }
        catch(NullPointerException nullpointerexception)
        {
        	nullpointerexception.printStackTrace();
        	j = -1;
//            break MISSING_BLOCK_LABEL_80;
        }
        if(j != -1 && wifimanager.saveConfiguration())
        {
            WifiConfiguration wificonfiguration1 = MF_null_a1(wifimanager, wificonfiguration, s1);
            if(wificonfiguration1 != null)
                return MF_null_a1(context, wifimanager, wificonfiguration1, true);
        }
        return false;
    }

    public static boolean MF_null_a1(Context context, WifiManager wifimanager, WifiConfiguration wificonfiguration, boolean flag)
    {
        String s = MF_null_a1.wifiConfig(wificonfiguration);
        int i = wificonfiguration.priority;
        int j = 1 + setPriority(wifimanager);
        if(j > 0x1869f)
        {
            j = MF_null_a1(wifimanager);
            wificonfiguration = MF_null_a1(wifimanager, wificonfiguration, s);
            if(wificonfiguration == null)
                return false;
        }
        wificonfiguration.priority = j;
        int k = wifimanager.updateNetwork(wificonfiguration);
        if(k == -1)
            return false;
        if(!wifimanager.enableNetwork(k, false))
        {
            wificonfiguration.priority = i;
            return false;
        }
        if(!wifimanager.saveConfiguration())
        {
            wificonfiguration.priority = i;
            return false;
        }
        WifiConfiguration wificonfiguration1 = MF_null_a1(wifimanager, wificonfiguration, s);
        if(wificonfiguration1 == null)
            return false;
        WIFIContext.startService(context);
        if(!wifimanager.enableNetwork(wificonfiguration1.networkId, true))
            return false;
        boolean flag1;
        if(flag)
            flag1 = wifimanager.reassociate();
        else
            flag1 = wifimanager.reconnect();
        return flag1;
    }

    private static boolean MF_null_a1(WifiManager wifimanager, int i)
    {
        boolean flag = true;
        int j = 0;
        List list = wifimanager.getConfiguredNetworks();
        MF_null_a1(list);
        int k = -1 + list.size();
        boolean flag1 = false;
        do
        {
            if(k < 0)
            {
                if(flag1)
                    flag = wifimanager.saveConfiguration();
                return flag;
            }
            WifiConfiguration wificonfiguration = (WifiConfiguration)list.get(k);
            int l;
            boolean flag2;
            if(MF_null_a1.wifiConfig(MF_null_a1.wifiConfig(wificonfiguration)) && ++j >= i)
            {
                wifimanager.removeNetwork(wificonfiguration.networkId);
                l = j;
                flag2 = flag;
            } else
            {
                l = j;
                flag2 = flag1;
            }
            k--;
            flag1 = flag2;
            j = l;
        } while(true);
    }

    private static int setPriority(WifiManager wifimanager)
    {
        Iterator iterator = wifimanager.getConfiguredNetworks().iterator();
        int i = 0;
        do
        {
            WifiConfiguration wificonfiguration;
            do
            {
                if(!iterator.hasNext())
                    return i;
                wificonfiguration = (WifiConfiguration)iterator.next();
            } while(wificonfiguration.priority <= i);
            i = wificonfiguration.priority;
        } while(true);
    }

    public static final WIFIBase MF_null_a1 = WIFIBase.wifiConfig();

}
