// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.Sipa;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS118
    implements Runnable
{

    CLASS118(RestClient class181)
    {
        MF_CLASS118_a496 = class181;
    }

    public void run()
    {
        RestClient.getSipa(MF_CLASS118_a496).hideWaitDialog();
    }

    final RestClient MF_CLASS118_a496;
}
