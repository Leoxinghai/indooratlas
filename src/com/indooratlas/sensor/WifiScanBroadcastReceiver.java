// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;

import android.content.*;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.*;
import com.indooratlas.position.CLASS75;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.sensor:
//            CLASS378, CLASS379, CLASS381, CLASS49

public class WifiScanBroadcastReceiver extends BroadcastReceiver
{

    public WifiScanBroadcastReceiver(Context context, CLASS49 class49)
    {
        a = 0L;
        b = 0L;
        c = 0L;
        d = 0L;
        bNeedScan = false;
        f = false;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        g = context;
        o = class49;
        l = new SimpleDateFormat("HH:mm:ss", Locale.US);
        n = (WifiManager)context.getSystemService("wifi");
        i = new CLASS378(this);
        context.registerReceiver(i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    static long a(WifiScanBroadcastReceiver wifiscanbroadcastreceiver)
    {
        return wifiscanbroadcastreceiver.c;
    }

    static long a(WifiScanBroadcastReceiver wifiscanbroadcastreceiver, long l1)
    {
        wifiscanbroadcastreceiver.b = l1;
        return l1;
    }

    static CountDownTimer getCountDownTimer(WifiScanBroadcastReceiver wifiscanbroadcastreceiver, CountDownTimer countdowntimer)
    {
        wifiscanbroadcastreceiver.k = countdowntimer;
        return countdowntimer;
    }

    static WifiManager b(WifiScanBroadcastReceiver wifiscanbroadcastreceiver)
    {
        return wifiscanbroadcastreceiver.n;
    }

    private void d()
    {
        WifiManager wifimanager = (WifiManager)g.getSystemService("wifi");
        if(!wifimanager.isWifiEnabled())
            wifimanager.setWifiEnabled(true);
    }

    private void takeWifiScanLock()
    {
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "takeWifiScanLock  called");
        try
        {
            m = n.createWifiLock(2, "APIWifiLock");
            if(!m.isHeld())
            {
                CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "takeWifiScanLock, calling acquire()");
                m.acquire();
            }
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	return;
        }
    }

    private void giveWifiScanLock()
    {
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "giveWifiScanLock called.");
        try
        {
            if(m != null && m.isHeld())
                m.release();
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	return;
        }
    }

    public void startScanning()
    {
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver startScanning() called.");
        a = System.nanoTime();
        boolean flag = CLASS75.checkScanModeOnly(g);
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver startScanning() scanModeOnlyAvailable = ").append(flag).toString());
        if(!flag)
        {
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver startScanning():  **TURNING WIFI ON** --> MAY CONNECT TO NETWORK");
            d();
        }
        takeWifiScanLock();
        g.registerReceiver(this, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        d = 0L;
        b = SystemClock.elapsedRealtime();
        n.startScan();
        bNeedScan = true;
        f = false;
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "startScanning() starting ScanResultPoller");
        (new Handler(g.getMainLooper())).post(new CLASS379(this));
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver startScanning() returning...");
    }

    public void stopScanning()
    {
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "stopScanning() called");
        bNeedScan = false;
        giveWifiScanLock();
        try
        {
            g.unregisterReceiver(this);
        }
        catch(Exception exception) { 
            exception.printStackTrace();
        }
        try
        {
            g.unregisterReceiver(i);
        }
        catch(Exception exception1) { 
            exception1.printStackTrace();
        }
        if(k != null)
        {
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "stopScanning: calling mScanResultPoller.cancel");
            k.cancel();
            k = null;
            return;
        } else
        {
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "stopScanning: mScanResultPoller == null");
            return;
        }
    }

    public void connectivityChanged()
    {
        if(bNeedScan)
        {
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver.connectivityChanged() initiating WIFI scan : ").append(System.nanoTime()).toString());
            n.startScan();
            return;
        } else
        {
            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver.connectivityChanged(): mScanning == false, NOT initiating WIFI scan : ").append(System.nanoTime()).toString());
            return;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        long l1;
        List list;
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver onReceive() called, mScanning = ").append(bNeedScan).toString());
        l1 = System.nanoTime() - a;
        c = l1;
        d = 1L + d;
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver onReceive() scan took : ").append((double)(l1 - b) / 1000D).append("s").toString());
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver onReceive() calling : mWifiManager.getScanResults()");
        list = n.getScanResults();
        
        try {
        if(list != null) {
	        if(bNeedScan) {
		        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver onReceive(): got results.size() = ").append(list.size()).toString());
		        j = new ConcurrentLinkedQueue();
		        CLASS381 class381;
		        for(Iterator iterator = list.iterator(); iterator.hasNext(); j.add(class381))
		        {
		            ScanResult scanresult = (ScanResult)iterator.next();
		            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("WifiScanBroadcastReceiver onReceive(): Network = ").append(scanresult.SSID).append(", Access point = ").append(scanresult.BSSID).append(", Signal strength =").append(scanresult.level).append(", curTime =").append(l1).append(", measurementStartTimeNano =").append(a).toString());
		            String s = scanresult.BSSID.replaceAll(":", "");
		            class381 = new CLASS381(d, scanresult.level, scanresult.SSID, s, l1);
		        }
		        
	            if(f) {
		            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver onReceive(): cancelling timer task!");
		            h.cancel();
		            stopScanning();
		            CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver onReceive(): calling wifiSingleScanAvailable()");
		            o.MF_CLASS49_b169(j);
	            } else {
	                CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", "WifiScanBroadcastReceiver onReceive(): calling wifiScanAvailable()");
	                o.MF_CLASS49_a168(j);
	            }
	        }
        }
        
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        
        b = SystemClock.elapsedRealtime();
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("onReceive() initiating scan : ").append(b).toString());
        boolean flag = n.startScan();
        CLASS75.MF_CLASS75_b260("WifiScanBroadcastReceiver", (new StringBuilder()).append("onReceive() scanInitiated : ").append(flag).append(", at ").append(b).toString());
    }

    private long a;
    private long b;
    private long c;
    private long d;
    private boolean bNeedScan;
    private boolean f;
    private Context g;
    private TimerTask h;
    private BroadcastReceiver i;
    private ConcurrentLinkedQueue j;
    private CountDownTimer k;
    private SimpleDateFormat l;
    private android.net.wifi.WifiManager.WifiLock m;
    private WifiManager n;
    private CLASS49 o;
}
