// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS193
    implements Runnable
{

    CLASS193(RestClient class181, String s)
    {
        MF_CLASS193_b727 = class181;
        MF_CLASS193_a728 = s;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS193_b727).informMapGenerationInitiatedOk(MF_CLASS193_a728);
    }

    final String MF_CLASS193_a728;
    final RestClient MF_CLASS193_b727;
}
