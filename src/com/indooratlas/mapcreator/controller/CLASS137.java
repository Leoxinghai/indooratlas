// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS137
    implements Runnable
{

    CLASS137(RestClient class181, List list)
    {
        MF_CLASS137_b517 = class181;
        MF_CLASS137_a518 = list;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS137_b517).showToastMessage((new StringBuilder()).append("Loaded ").append(MF_CLASS137_a518.size()).append(" paths.").toString(), 0);
        RestClient.getMapScreen(MF_CLASS137_b517).setBackendSequences(MF_CLASS137_a518);
    }

    final List MF_CLASS137_a518;
    final RestClient MF_CLASS137_b517;
}
