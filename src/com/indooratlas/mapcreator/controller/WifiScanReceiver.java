// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.os.Vibrator;
import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.mapcreator.main.MapScreen;
import com.indooratlas.sensor.CLASS381;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS167, CLASS113, CLASS170, CLASS179

public class WifiScanReceiver extends BroadcastReceiver
{

    public WifiScanReceiver(MapScreen mapscreen)
    {
        b = 0L;
        c = 0L;
        d = 0L;
        e = false;
        f = null;
        g = null;
        h = null;
        i = 0L;
        MF_CLASS108_a447 = mapscreen;
        g = new SimpleDateFormat("HH:mm:ss");
    }

    public boolean MF_CLASS108_a447()
    {
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "startScanning() called.");
        i = System.nanoTime();
        d = 0L;
        b = System.currentTimeMillis();
        boolean flag = MF_CLASS108_a447.mWifiManager.startScan();
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("startScanning() scanInitiated = ").append(flag).toString());
        e = true;
        if(CLASS113.isExceptionLogged.booleanValue())
        {
            Date date;
            if(!flag)
                try
                {
                    MF_CLASS108_a447.mVibrator.vibrate(200L);
                }
                catch(Exception exception) { }
            date = new Date(b);
            MF_CLASS108_a447.onDebug((new StringBuilder()).append("Last wifi scan : started first scan, ts = ").append(g.format(date)).append(", scanInitiated =").append(flag).toString());
        }
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "startScanning() starting ScanResultPoller");
        h = (new CLASS170(this, 0x23c34600L, 3000L)).start();
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "startScanning() returning...");
        return flag;
    }

    public void b()
    {
        e = false;
        if(h != null)
        {
            CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "stopScanning; stopping poller.");
            h.cancel();
        }
    }

    public void c()
    {
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("WifiScanReceiver.connectivityChanged()  called, mScanning = ").append(e).toString());
        if(e)
        {
            if(!MF_CLASS108_a447.checkScanModeOnly(false))
            {
                CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "WifiScanReceiver.connectivityChanged()  calling ensureWifiEnabled()");
                boolean flag = MF_CLASS108_a447.ensureWifiEnabled();
                CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("WifiScanReceiver.connectivityChanged()  result of ensureWifiEnabled = ").append(flag).toString());
            }
            CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("WifiScanReceiver.connectivityChanged() initiating WIFI scan : ").append(System.nanoTime()).toString());
            MF_CLASS108_a447.mWifiManager.startScan();
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("WifiScanReceiver.connectivityChanged(): mScanning == false, NOT initiating WIFI scan : ").append(System.nanoTime()).toString());
            return;
        }
    }

    public void d()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)MF_CLASS108_a447.getSystemService("connectivity");
        NetworkInfo networkinfo = connectivitymanager.getNetworkInfo(1);
        NetworkInfo networkinfo1 = connectivitymanager.getNetworkInfo(0);
        boolean flag;
        boolean flag1;
        if(networkinfo1 != null)
            flag = networkinfo1.isConnected();
        else
            flag = false;
        if(networkinfo != null)
            flag1 = networkinfo.isConnected();
        else
            flag1 = false;
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("checkConnections: mobileConnected = ").append(flag).toString());
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("checkConnections: wifiConnected = ").append(flag1).toString());
    }

    public void onReceive(Context context, Intent intent)
    {
        long l;
        List list;
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "onReceive() called.");
        l = System.nanoTime() - i;
        float f1 = (float)(System.nanoTime() - b) / 1E+009F;
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("onReceive() scan took : ").append(f1).append("s").toString());
        c = l;
        d = 1L + d;
        d();
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", "onReceive() calling : mWifiScanner.mWifiManager.getScanResults()");
        list = MF_CLASS108_a447.mWifiManager.getScanResults();
        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("onReceive() results = ").append(list).toString());

        if(list != null) {
	        ConcurrentLinkedQueue concurrentlinkedqueue;
	        CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("onReceive(): scan : ").append(d).append(", got results.size() = ").append(list.size()).toString());
	        concurrentlinkedqueue = new ConcurrentLinkedQueue();
	        ScanResult scanresult;
	        String s;
	        for(Iterator iterator = list.iterator(); iterator.hasNext(); concurrentlinkedqueue.add(new CLASS381(d, scanresult.level, scanresult.SSID, s, l)))
	        {
	            scanresult = (ScanResult)iterator.next();
	            CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("onReceive(): Network = ").append(scanresult.SSID).append(", Access point = ").append(scanresult.BSSID).append(", Signal strength =").append(scanresult.level).toString());
	            s = scanresult.BSSID.replaceAll(":", "");
	        }
	        MeasurementDataSource.storeWifiData(concurrentlinkedqueue, MapScreen.currentMeasurement.mMeasurementID);

        }
                boolean flag;
                boolean flag1;
                b = System.currentTimeMillis();
                CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("onReceive() initiating scan : ").append(b).toString());
                flag = MF_CLASS108_a447.mWifiManager.startScan();
                CLASS167.MF_CLASS167_b635("WiFiScanReceiver", (new StringBuilder()).append("onReceive() scanInitiated : ").append(flag).append(", at ").append(b).toString());
                flag1 = CLASS113.isExceptionLogged.booleanValue();
                if(flag1)
                {
                    if(!flag)
                        try
                        {
                            MF_CLASS108_a447.mVibrator.vibrate(200L);
                        }
                        catch(Exception exception1) { }
                    try
                    {
                        Date date = new Date(b);
                        MF_CLASS108_a447.onDebug((new StringBuilder()).append("Last wifi scan ").append(d).append(" : network count = ").append(list.size()).append(", ts = ").append(g.format(date)).append(", scanInitiated =").append(flag).toString());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch(Exception exception)
                    {
                        CLASS167.unhandledexception(exception, MF_CLASS108_a447);
                    }
                }

        return;

    }

    MapScreen MF_CLASS108_a447;
    public long b;
    public long c;
    public long d;
    public boolean e;
    BroadcastReceiver f;
    SimpleDateFormat g;
    CountDownTimer h;
    long i;
}
