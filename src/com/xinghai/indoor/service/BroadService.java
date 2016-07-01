// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.app.Service;
import android.content.*;
import android.os.IBinder;

// Referenced classes of package com.xinghai.indoor.service:
//            XHReceiver

public class BroadService extends Service
{

    public BroadService()
    {
        mReceiver = new XHReceiver(this);
    }

    static void flag(BroadService broadservice, boolean flag1)
    {
        broadservice.flag = flag1;
    }

    static boolean flag(BroadService broadservice)
    {
        return broadservice.flag;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        onCreate();
        flag = false;
        mFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
        registerReceiver(mReceiver, mFilter);
    }

    public void onDestroy()
    {
        onDestroy();
        unregisterReceiver(mReceiver);
    }

    private boolean flag;
    private BroadcastReceiver mReceiver;
    private IntentFilter mFilter;
}
