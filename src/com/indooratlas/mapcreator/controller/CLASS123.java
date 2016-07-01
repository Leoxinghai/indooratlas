// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS123
    implements Runnable
{

    CLASS123(RestClient class181)
    {
        MF_CLASS123_a501 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS123_a501).clearSelectedSegment();
        RestClient.getMapScreen(MF_CLASS123_a501).hideInProgressDialog();
    }

    final RestClient MF_CLASS123_a501;
}
