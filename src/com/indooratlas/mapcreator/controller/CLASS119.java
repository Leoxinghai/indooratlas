// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS119
    implements Runnable
{

    CLASS119(RestClient class181)
    {
        MF_CLASS119_a497 = class181;

    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS119_a497).showToastMessage(RestClient.getMapScreen(MF_CLASS119_a497).getString(0x7f080051), 0);
    }

    final RestClient MF_CLASS119_a497;
}
