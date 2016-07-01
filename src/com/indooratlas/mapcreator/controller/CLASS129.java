// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.Sipa;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS129
    implements Runnable
{

    CLASS129(RestClient class181)
    {
        MF_CLASS129_a507 = class181;
    }

    public void run()
    {
        RestClient.getSipa(MF_CLASS129_a507).hideWaitDialog();
        RestClient.getSipa(MF_CLASS129_a507).setBuildingSelectionOngoing(false);
    }

    final RestClient MF_CLASS129_a507;
}
