// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.thread:
//            CLASS76

class CLASS95
    implements Runnable
{

    CLASS95(HTTPHandler class76)
    {
        MF_CLASS95_a352 = class76;

    }

    public void run()
    {
        if(!MF_CLASS95_a352.MF_CLASS76_a262())
        	HTTPHandler.MF_CLASS76_d265(MF_CLASS95_a352).onRequestTimeout(HTTPHandler.MF_CLASS76_a262(MF_CLASS95_a352), HTTPHandler.MF_CLASS76_b263(MF_CLASS95_a352), 0, HTTPHandler.MF_CLASS76_c264(MF_CLASS95_a352), "");
    }

    final HTTPHandler MF_CLASS95_a352;
}
