// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.service;

import android.content.*;
import android.net.NetworkInfo;

// Referenced classes of package com.xinghai.indoor.service:
//            BroadService, WIFIContext

class XHReceiver extends BroadcastReceiver
{

    XHReceiver(BroadService broadservice)
    {
        super();
        mBroadService = broadservice;
    }

    public void onReceive(Context context, Intent intent)
    {
        if("android.net.wifi.STATE_CHANGE".equals(intent.getAction()))
        {
            android.net.NetworkInfo.DetailedState detailedstate = ((NetworkInfo)intent.getParcelableExtra("networkInfo")).getDetailedState();
            if(detailedstate != android.net.NetworkInfo.DetailedState.DISCONNECTED && detailedstate != android.net.NetworkInfo.DetailedState.DISCONNECTING && detailedstate != android.net.NetworkInfo.DetailedState.SCANNING && !BroadService.flag(mBroadService))
            {
                BroadService.flag(mBroadService, true);
                WIFIContext.enableNetwork1(context);
                mBroadService.stopSelf();
            }
        }
    }

    final BroadService mBroadService;
}
