// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS143, RestClient

class CLASS150
    implements Runnable
{

    CLASS150(CLASS143 class143)
    {
        MF_CLASS143_a541 = class143;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS143_a541.mRestClient).showToastMessage(RestClient.getMapScreen(MF_CLASS143_a541.mRestClient).getString(0x7f080047), 1);
    }

    final CLASS143 MF_CLASS143_a541;
}
