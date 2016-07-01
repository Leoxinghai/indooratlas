// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.thread.client.IDeviceCheck;

import java.io.InputStream;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS176
    implements Runnable
{

    CLASS176(CookieHTTPHandler class140, int i, String s, InputStream inputstream, String s1)
    {
        MF_CLASS176_e646 = class140;
        MF_CLASS176_a647 = i;
        MF_CLASS176_b648 = s;
        MF_CLASS176_c649 = inputstream;
        MF_CLASS176_d650 = s1;
    }

    public void run()
    {
        CookieHTTPHandler.getIDeviceCheck(MF_CLASS176_e646).onRequestComplete(CookieHTTPHandler.MF_CLASS113_a486(MF_CLASS176_e646), CookieHTTPHandler.MF_CookieHTTPHandler_b523(MF_CLASS176_e646), MF_CLASS176_a647, MF_CLASS176_b648, CookieHTTPHandler.MF_CookieHTTPHandler_c524(MF_CLASS176_e646), CookieHTTPHandler.MF_CookieHTTPHandler_d525(MF_CLASS176_e646), Long.valueOf(CookieHTTPHandler.MF_CookieHTTPHandler_f527(MF_CLASS176_e646)), MF_CLASS176_c649, MF_CLASS176_d650);
    }

    final int MF_CLASS176_a647;
    final String MF_CLASS176_b648;
    final InputStream MF_CLASS176_c649;
    final String MF_CLASS176_d650;
    final CookieHTTPHandler MF_CLASS176_e646;
}
