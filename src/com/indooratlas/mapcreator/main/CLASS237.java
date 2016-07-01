// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.indooratlas.mapcreator.controller.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS237 extends BroadcastReceiver
{

    CLASS237(MapScreen mapscreen)
    {
        super();
        MF_CLASS113_b487 = mapscreen;
        MF_CLASS237_a784 = true;
    }

    public void onReceive(Context context, Intent intent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "mConnReceiver.onReceive()  called");
        boolean flag = intent.getBooleanExtra("noConnectivity", false);
        String s = intent.getStringExtra("reason");
        boolean flag1 = intent.getBooleanExtra("isFailover", false);
        boolean flag2 = MF_CLASS113_b487.mWifiManager.isWifiEnabled();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("mConnReceiver.onReceive(): wifiEnabled = ").append(flag2).toString());
        ConnectivityManager connectivitymanager = (ConnectivityManager)MF_CLASS113_b487.getSystemService("connectivity");
        NetworkInfo networkinfo = connectivitymanager.getNetworkInfo(1);
        NetworkInfo networkinfo1 = connectivitymanager.getNetworkInfo(0);
        NetworkInfo networkinfo2 = connectivitymanager.getNetworkInfo(5);
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if(networkinfo1 != null)
        {
            boolean flag7 = networkinfo1.isConnected();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("mConnReceiver.onReceive(): mobileConnected = ").append(flag7).toString());
            flag3 = flag7;
        } else
        {
            flag3 = false;
        }
        if(networkinfo1 != null)
        {
            boolean flag6 = networkinfo2.isConnected();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("mConnReceiver.onReceive(): mobileHipriConnected = ").append(flag6).toString());
            flag4 = flag6;
        } else
        {
            flag4 = false;
        }
        if(networkinfo != null)
        {
            flag5 = networkinfo.isConnected();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("mConnReceiver.onReceive(): wifiConnected = ").append(flag5).toString());
            if(flag5)
                if(MF_CLASS113_b487.mWifiManager.getConnectionInfo() == null);
        } else
        {
            flag5 = false;
        }
        if(CLASS113.isDeviceChecked.booleanValue())
        {
            NetworkInfo networkinfo3 = connectivitymanager.getActiveNetworkInfo();
            String s1;
            if(networkinfo3 != null && networkinfo3.isConnectedOrConnecting())
                s1 = networkinfo3.getTypeName();
            else
                s1 = "None";
            MF_CLASS113_b487.showToastMessage((new StringBuilder()).append("Connectivity: mobile = ").append(flag3).append(", hipri = ").append(flag4).append(", wifi = ").append(flag5).append(", activeNetwork = ").append(s1).toString(), 0);
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("mConnReceiver.onReceive():  noConnectivity  = ").append(flag).append(", reason = ").append(s).append(", isFailover = ").append(flag1).toString());
        if(MapScreen.MF_CLASS19_a67(MF_CLASS113_b487) != null)
            MapScreen.MF_CLASS19_a67(MF_CLASS113_b487).c();
    }

    boolean MF_CLASS237_a784;
    final MapScreen MF_CLASS113_b487;
}
