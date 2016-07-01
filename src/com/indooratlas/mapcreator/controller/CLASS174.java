// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS174
    implements Runnable
{

    CLASS174(CookieHTTPHandler class140)
    {
        MF_CLASS174_a642 = class140;
    }

    public void run()
    {
        CookieHTTPHandler.getIDeviceCheck(MF_CLASS174_a642).checkDeviceSupported(CookieHTTPHandler.MF_CLASS113_a486(MF_CLASS174_a642), CookieHTTPHandler.MF_CookieHTTPHandler_b523(MF_CLASS174_a642), -1, "Malformed URL", CookieHTTPHandler.MF_CookieHTTPHandler_c524(MF_CLASS174_a642), CookieHTTPHandler.MF_CookieHTTPHandler_d525(MF_CLASS174_a642), "");
    }

    final CookieHTTPHandler MF_CLASS174_a642;
}
