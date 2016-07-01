// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.thread:
//            CLASS76

class CLASS93
    implements Runnable
{

    CLASS93(HTTPHandler class76, int i, String s, String s1)
    {
        MF_CLASS93_d343 = class76;
        MF_CLASS93_a344 = i;
        MF_CLASS93_b345 = s;
        MF_CLASS93_c346 = s1;

    }

    public void run()
    {
        if(!MF_CLASS93_d343.MF_CLASS76_a262())
        	HTTPHandler.MF_CLASS76_d265(MF_CLASS93_d343).checkDeviceSupported(HTTPHandler.MF_CLASS76_a262(MF_CLASS93_d343), HTTPHandler.MF_CLASS76_b263(MF_CLASS93_d343), MF_CLASS93_a344, MF_CLASS93_b345, HTTPHandler.MF_CLASS76_c264(MF_CLASS93_d343), "", MF_CLASS93_c346);
    }

    final int MF_CLASS93_a344;
    final String MF_CLASS93_b345;
    final String MF_CLASS93_c346;
    final HTTPHandler MF_CLASS93_d343;
}
