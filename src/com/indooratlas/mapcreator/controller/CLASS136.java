// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.Sipa;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS136
    implements Runnable
{

    CLASS136(RestClient class181, String s)
    {
        MF_CLASS136_b515 = class181;
        MF_CLASS136_a516 = s;

    }

    public void run()
    {
        RestClient.getSipa(MF_CLASS136_b515).showToastMessage(MF_CLASS136_a516, RestClient.MF_CLASS54_a201());
    }

    final String MF_CLASS136_a516;
    final RestClient MF_CLASS136_b515;
}
