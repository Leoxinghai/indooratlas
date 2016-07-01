// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS133
    implements Runnable
{

    CLASS133(RestClient class181)
    {
        MF_CLASS133_a511 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS133_a511).hideInProgressDialog();
        RestClient.MF_CLASS54_a201(MF_CLASS133_a511, "All paths could not be fetched due to network errors.");
    }

    final RestClient MF_CLASS133_a511;
}
