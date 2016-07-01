// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS168
    implements Runnable
{

    CLASS168(CookieHTTPHandler class140)
    {
        MF_CLASS168_a636 = class140;
    }

    public void run()
    {
        CookieHTTPHandler.getIDeviceCheck(MF_CLASS168_a636).checkDeviceSupported(CookieHTTPHandler.MF_CLASS113_a486(MF_CLASS168_a636), CookieHTTPHandler.MF_CookieHTTPHandler_b523(MF_CLASS168_a636), CookieHTTPHandler.MF_CookieHTTPHandler_c524(MF_CLASS168_a636), CookieHTTPHandler.MF_CookieHTTPHandler_d525(MF_CLASS168_a636));
    }

    final CookieHTTPHandler MF_CLASS168_a636;
}
