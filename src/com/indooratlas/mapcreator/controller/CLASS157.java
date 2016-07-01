// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS154, RestClient

class CLASS157
    implements Runnable
{

    CLASS157(CLASS154 class154)
    {
        MF_CLASS154_a557 = class154;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS154_a557.MF_CLASS113_a486).showToastMessage(RestClient.getMapScreen(MF_CLASS154_a557.MF_CLASS113_a486).getString(0x7f080047), 1);
    }

    final CLASS154 MF_CLASS154_a557;
}
