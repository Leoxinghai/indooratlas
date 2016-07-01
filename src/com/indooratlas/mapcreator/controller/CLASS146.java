// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS143, RestClient

class CLASS146
    implements Runnable
{

    CLASS146(CLASS143 class143, String s)
    {
        MF_CLASS146_b545 = class143;
        MF_CLASS143_a541 = s;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS146_b545.mRestClient).informUploadAborted(MF_CLASS143_a541);
    }

    final String MF_CLASS143_a541;
    final CLASS143 MF_CLASS146_b545;
}
