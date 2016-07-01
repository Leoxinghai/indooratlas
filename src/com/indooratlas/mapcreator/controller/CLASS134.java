// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS134
    implements Runnable
{

    CLASS134(RestClient class181, String s)
    {
        MF_CLASS134_b512 = class181;
        MF_CLASS134_a513 = s;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS134_b512).showToastMessage(MF_CLASS134_a513, RestClient.MF_CLASS54_a201());
    }

    final String MF_CLASS134_a513;
    final RestClient MF_CLASS134_b512;
}
