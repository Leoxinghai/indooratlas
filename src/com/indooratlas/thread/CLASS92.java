// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.thread:
//            CLASS76

class CLASS92
    implements Runnable
{

    CLASS92(HTTPHandler class76)
    {
        MF_CLASS92_a342 = class76;

    }

    public void run()
    {
        if(!MF_CLASS92_a342.MF_CLASS76_a262())
        	HTTPHandler.MF_CLASS76_d265(MF_CLASS92_a342).checkDeviceSupported(HTTPHandler.MF_CLASS76_a262(MF_CLASS92_a342), HTTPHandler.MF_CLASS76_b263(MF_CLASS92_a342), -1, "Malformed URL", HTTPHandler.MF_CLASS76_c264(MF_CLASS92_a342), "", "");
    }

    final HTTPHandler MF_CLASS92_a342;
}
