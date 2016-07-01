// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS171
    implements Runnable
{

    CLASS171(CookieHTTPHandler class140)
    {
        MF_CLASS171_a639 = class140;
    }

    public void run()
    {
        CookieHTTPHandler.getIDeviceCheck(MF_CLASS171_a639).checkDeviceSupported(CookieHTTPHandler.MF_CLASS113_a486(MF_CLASS171_a639), CookieHTTPHandler.MF_CookieHTTPHandler_b523(MF_CLASS171_a639), 0, null, CookieHTTPHandler.MF_CookieHTTPHandler_c524(MF_CLASS171_a639), CookieHTTPHandler.MF_CookieHTTPHandler_d525(MF_CLASS171_a639), "");
    }

    final CookieHTTPHandler MF_CLASS171_a639;
}
