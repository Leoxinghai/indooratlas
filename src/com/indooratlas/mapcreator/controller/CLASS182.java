// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS182
    implements Runnable
{

    CLASS182(RestClient class181, boolean flag, String s)
    {
        MF_CLASS182_c710 = class181;
        MF_CLASS182_a711 = flag;
        MF_CLASS182_b712 = s;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS182_c710).informMapGenerationStatus(MF_CLASS182_a711, MF_CLASS182_b712);
    }

    final boolean MF_CLASS182_a711;
    final String MF_CLASS182_b712;
    final RestClient MF_CLASS182_c710;
}
