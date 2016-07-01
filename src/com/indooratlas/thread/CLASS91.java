// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.thread:
//            CLASS76

class CLASS91
    implements Runnable
{

    CLASS91(HTTPHandler class76)
    {
        MF_CLASS91_a341 = class76;

    }

    public void run()
    {
        if(!MF_CLASS91_a341.MF_CLASS76_a262())
        	HTTPHandler.MF_CLASS76_d265(MF_CLASS91_a341).checkDeviceSupported(HTTPHandler.MF_CLASS76_a262(MF_CLASS91_a341), HTTPHandler.MF_CLASS76_b263(MF_CLASS91_a341), HTTPHandler.MF_CLASS76_c264(MF_CLASS91_a341), "");
    }

    final HTTPHandler MF_CLASS91_a341;
}
