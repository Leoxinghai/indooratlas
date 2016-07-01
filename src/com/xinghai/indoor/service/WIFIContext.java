// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xinghai.indoor.service:
//            BroadService

public class WIFIContext
{

    public static void startService(Context context)
    {
        context.startService(new Intent(context, BroadService.class));
    }

    static void enableNetwork1(Context context)
    {
        enableNetwork(context);
    }

    private static void enableNetwork(Context context)
    {
        WifiManager wifimanager;
        List list;
        wifimanager = (WifiManager)context.getSystemService("wifi");
        list = wifimanager.getConfiguredNetworks();
        if(list != null) {
	        Iterator iterator = list.iterator();
	        for(;iterator.hasNext();) {
	            wifimanager.enableNetwork(((WifiConfiguration)iterator.next()).networkId, false);
	        }
        }
        return;
    }
}
