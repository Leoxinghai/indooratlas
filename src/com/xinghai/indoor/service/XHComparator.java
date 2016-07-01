// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.net.wifi.WifiConfiguration;
import java.util.Comparator;

class XHComparator
    implements Comparator
{

    XHComparator()
    {
    }

    public int getPriorityDiff(WifiConfiguration wificonfiguration, WifiConfiguration wificonfiguration1)
    {
        return wificonfiguration.priority - wificonfiguration1.priority;
    }

    public int compare(Object obj, Object obj1)
    {
        return getPriorityDiff((WifiConfiguration)obj, (WifiConfiguration)obj1);
    }
}
