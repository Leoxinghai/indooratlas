// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.wifiroaming;

import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.*;
import android.os.CountDownTimer;
import android.os.SystemClock;
import com.xinghai.indoor.service.WIFIBase;
import com.xinghai.indoor.service.XHWIFIManager;
import java.util.*;

// Referenced classes of package com.indooratlas.wifiroaming:
//            CLASS383, CLASS384, CLASS382, CLASS385, 
//            CLASS386, CLASS198

public class WifiRoamingScanReceiver extends BroadcastReceiver
{

    public void MF_null_a1()
    {
        c.registerReceiver(this, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        MF_null_a1.startScan();
        if(g != null)
            g.cancel();
        g = (new ScanResultPoller(this, 0x7fffffffffffffffL, 3000L)).start();
        h = new CLASS384(this);
        c.registerReceiver(h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void MF_null_a1(ScanResult scanresult)
    {
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("connectToAccessPoint : ")).append(scanresult).toString());
        String s = XHWIFIManager.MF_null_a1.wifiConfig(scanresult);
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("connectToAccessPoint scanResultSecurity : ")).append(s).toString());
        WifiConfiguration wificonfiguration = XHWIFIManager.MF_null_a1(MF_null_a1, scanresult, s);
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("connectToAccessPoint  existingWC : ")).append(wificonfiguration).toString());
        boolean flag;
        if(wificonfiguration != null)
        {
            CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("connectToAccessPoint  existingWC.preSharedKey : ")).append(wificonfiguration.preSharedKey).toString());
            wificonfiguration.BSSID = scanresult.BSSID;
            flag = XHWIFIManager.MF_null_a1(c, MF_null_a1, wificonfiguration, true);
        } else
        {
            int i = android.provider.Settings.Secure.getInt(c.getContentResolver(), "wifi_num_open_networks_kept", 10);
            if(i < 10)
                i = 17;
            flag = XHWIFIManager.MF_null_a1(c, MF_null_a1, scanresult, null, i);
        }
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("connectToAccessPoint  connResult : ")).append(flag).toString());
    }

    public void MF_null_a1(boolean flag)
    {
        f = flag;
    }

    public void b()
    {
        try
        {
            c.unregisterReceiver(this);
            c.unregisterReceiver(h);
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public void c()
    {
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "WifiScanReceiver.connectivityChanged() called");
        MF_null_a1.startScan();
    }

    public boolean d()
    {
        return f;
    }

    public void onReceive(Context context, Intent intent)
    {
        long l;
        List list;
        NetworkInfo networkinfo;
        ScanResult scanresult;
        ScanResult scanresult1;
        boolean flag;
        
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive called, roamingOn = ")).append(f).toString());
        l = SystemClock.elapsedRealtime();
        d = l;
        list = MF_null_a1.getScanResults();
        Collections.sort(list, new CLASS385(this));
        networkinfo = e.getActiveNetworkInfo();
        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive, scan received, checking current connection, activeNetwork = ")).append(networkinfo).toString());
        if(networkinfo != null) {
	        	
	        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive, scan received, checking current connection, activeNetwork.getExtraInfo = ")).append(networkinfo.getExtraInfo()).toString());
	        boolean flag1 = networkinfo.isConnected();
	        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive(): activeNetwork != null,  isConnected == ")).append(flag1).append(", activeNetwork.getType()  = ").append(networkinfo.getType()).append(" (mobile == ").append(0).append(", WiFi == ").append(1).append(")").toString());
	        if(networkinfo.getType() == 1) {
	
	        WifiInfo wifiinfo;
	        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "onReceive(): *WIFI* network now connected --> Connect to Strongest Access Point");
	        wifiinfo = MF_null_a1.getConnectionInfo();
	        if(wifiinfo != null && list != null && list.size() > 0) {
			        int i;
			        ArrayList arraylist;
			        Iterator iterator;
			        i = wifiinfo.getRssi();
			        arraylist = new ArrayList();
			        iterator = list.iterator();
			        
			        for(;iterator.hasNext();) {
			            scanresult = (ScanResult)iterator.next();
			            CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive: comparing SSID ")).append(scanresult.SSID).append(" --- ").append(wifiinfo.getSSID().replace("\"", "")).toString());
			            if(scanresult.SSID.equals(wifiinfo.getSSID().replace("\"", "")))
			                arraylist.add(scanresult);
			        }
			        
			        int j;
			        Iterator iterator1;
			        Collections.sort(arraylist, new CLASS386(this));
			        j = -200;
			        if(arraylist.size() > 0)
			            j = ((ScanResult)arraylist.get(0)).level;
			        iterator1 = arraylist.iterator();
			        for(;iterator1.hasNext();) {
			                scanresult1 = (ScanResult)iterator1.next();
			                CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive: comparing BSSID ")).append(scanresult1.BSSID).append(" --- ").append(wifiinfo.getBSSID()).toString());
			                if(scanresult1.BSSID.equals(wifiinfo.getBSSID()))
			                    i = scanresult1.level;
			        }
			
			        int k = j - i;
			        CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive: signalDiff = ")).append(k).append(", currentSignalStrength = ").append(i).append(", strongest = ").append(j).toString());
			        if(k >= 7 || i <= -75 && k >= 5)
			        {
			            if(f)
			            {
			                CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive: signalDiff = ")).append(k).append(" --> try connecting to AP: ").append(((ScanResult)arraylist.get(0)).BSSID).toString());
			                MF_null_a1((ScanResult)arraylist.get(0));
			            } else
			            {
			                CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive: signalDiff = ")).append(k).append(" BUT roaming == OFF --> *NOT* trying connecting to AP: ").append(((ScanResult)arraylist.get(0)).BSSID).toString());
			            }
			        } else
			        {
			            CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("onReceive: signalDiff = ")).append(k).append(" --> no need to change AP").toString());
			        }
			        b.onScanReceived(l, list, wifiinfo, i, j, f);
		        }
		        flag = true;
	        } else {
	            CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "onReceive(): Active network is not Wifi.");
	            flag = false;
	        }
        } else {
            CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "onReceive(): No active networks.");
            flag = false;
        }
        
        if(!flag)
            b.onScanReceived(l, list, null, -200, -200, false);
        MF_null_a1.startScan();
        return;

    }

    WifiManager MF_null_a1;
    CLASS198 b;
    Context c;
    long d;
    private ConnectivityManager e;
    private boolean f;
    private CountDownTimer g;
    private BroadcastReceiver h;
}
