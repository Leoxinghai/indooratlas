// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS191
    implements Runnable
{

    CLASS191(RestClient class181)
    {
        MF_CLASS191_a725 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS191_a725).hideInProgressDialog();
        RestClient.getMapScreen(MF_CLASS191_a725).setBackendSequences(null);
    }

    final RestClient MF_CLASS191_a725;
}
