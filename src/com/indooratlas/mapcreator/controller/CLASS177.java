// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS177
    implements Runnable
{

    CLASS177(CookieHTTPHandler class140)
    {
        MF_CLASS177_a651 = class140;
    }

    public void run()
    {
        CookieHTTPHandler.getIDeviceCheck(MF_CLASS177_a651).onRequestTimeout(CookieHTTPHandler.MF_CLASS113_a486(MF_CLASS177_a651), CookieHTTPHandler.MF_CookieHTTPHandler_b523(MF_CLASS177_a651), 0, CookieHTTPHandler.MF_CookieHTTPHandler_c524(MF_CLASS177_a651), CookieHTTPHandler.MF_CookieHTTPHandler_d525(MF_CLASS177_a651));
    }

    final CookieHTTPHandler MF_CLASS177_a651;
}
