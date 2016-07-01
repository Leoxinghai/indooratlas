// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS135
    implements Runnable
{

    CLASS135(RestClient class181)
    {
        MF_CLASS135_a514 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS135_a514).deleteSelectedMeasurementFromLocalDB();
    }

    final RestClient MF_CLASS135_a514;
}
