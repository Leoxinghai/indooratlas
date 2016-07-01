// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.thread.client.IDeviceCheck;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS175
    implements Runnable
{

    CLASS175(CookieHTTPHandler class140, int i, String s)
    {
        MF_CLASS175_c643 = class140;
        MF_CLASS175_a644 = i;
        MF_CLASS175_b645 = s;
    }

    public void run()
    {
        CookieHTTPHandler.getIDeviceCheck(MF_CLASS175_c643).checkDeviceSupported(CookieHTTPHandler.MF_CLASS113_a486(MF_CLASS175_c643), CookieHTTPHandler.MF_CookieHTTPHandler_b523(MF_CLASS175_c643), MF_CLASS175_a644, MF_CLASS175_b645, CookieHTTPHandler.MF_CookieHTTPHandler_c524(MF_CLASS175_c643), CookieHTTPHandler.MF_CookieHTTPHandler_d525(MF_CLASS175_c643), "");
    }

    final int MF_CLASS175_a644;
    final String MF_CLASS175_b645;
    final CookieHTTPHandler MF_CLASS175_c643;
}
