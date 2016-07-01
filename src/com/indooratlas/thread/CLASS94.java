// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread;

import com.indooratlas.thread.client.IDeviceCheck;
import java.io.InputStream;

// Referenced classes of package com.indooratlas.thread:
//            CLASS76

class CLASS94
    implements Runnable
{

    CLASS94(HTTPHandler class76, int i, String s, InputStream inputstream, String s1)
    {
        MF_CLASS94_e347 = class76;
        MF_CLASS94_a348 = i;
        MF_CLASS94_b349 = s;
        MF_CLASS94_c350 = inputstream;
        MF_CLASS94_d351 = s1;

    }

    public void run()
    {
        if(!MF_CLASS94_e347.MF_CLASS76_a262())
        	HTTPHandler.MF_CLASS76_d265(MF_CLASS94_e347).onRequestComplete(HTTPHandler.MF_CLASS76_a262(MF_CLASS94_e347), HTTPHandler.MF_CLASS76_b263(MF_CLASS94_e347), MF_CLASS94_a348, MF_CLASS94_b349, HTTPHandler.MF_CLASS76_c264(MF_CLASS94_e347), "", Long.valueOf(HTTPHandler.MF_CLASS76_e266(MF_CLASS94_e347)), MF_CLASS94_c350, MF_CLASS94_d351);
    }

    final int MF_CLASS94_a348;
    final String MF_CLASS94_b349;
    final InputStream MF_CLASS94_c350;
    final String MF_CLASS94_d351;
    final HTTPHandler MF_CLASS94_e347;
}
