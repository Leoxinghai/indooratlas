// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.Sipa;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS130
    implements Runnable
{

    CLASS130(RestClient class181)
    {
        MF_CLASS130_a508 = class181;
    }

    public void run()
    {
        RestClient.getSipa(MF_CLASS130_a508).hideWaitDialog();
        RestClient.getSipa(MF_CLASS130_a508).setBuildingSelectionOngoing(false);
    }

    final RestClient MF_CLASS130_a508;
}
