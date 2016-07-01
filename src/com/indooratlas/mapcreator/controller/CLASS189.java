// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS189
    implements Runnable
{

    CLASS189(RestClient class181)
    {
        MF_CLASS189_a723 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS189_a723).hideInProgressDialog();
        RestClient.getMapScreen(MF_CLASS189_a723).showRetryDeleteAllSegmentsDialog("Deleting paths from IndoorAtlas Maps failed due to a network error.");
    }

    final RestClient MF_CLASS189_a723;
}
