// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS138
    implements Runnable
{

    CLASS138(RestClient class181, String s)
    {
        MF_CLASS138_b519 = class181;
        MF_CLASS138_a520 = s;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS138_b519).updateInProgressDialog((new StringBuilder()).append("Uploading ").append(MF_CLASS138_a520).append("%").toString());
    }

    final String MF_CLASS138_a520;
    final RestClient MF_CLASS138_b519;
}
