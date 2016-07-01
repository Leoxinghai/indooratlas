// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS190
    implements Runnable
{

    CLASS190(RestClient class181)
    {
        MF_CLASS190_a724 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS190_a724).clearSelectedSegment();
        RestClient.getMapScreen(MF_CLASS190_a724).hideInProgressDialog();
    }

    final RestClient MF_CLASS190_a724;
}
