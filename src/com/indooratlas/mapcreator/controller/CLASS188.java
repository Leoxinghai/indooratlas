// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS188
    implements Runnable
{

    CLASS188(RestClient class181)
    {
        MF_CLASS188_a722 = class181;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS188_a722).hideInProgressDialog();
        RestClient.getMapScreen(MF_CLASS188_a722).showToastMessage("Error in communicating with IndoorAtlas Maps.", RestClient.MF_CLASS54_a201());
    }

    final RestClient MF_CLASS188_a722;
}
