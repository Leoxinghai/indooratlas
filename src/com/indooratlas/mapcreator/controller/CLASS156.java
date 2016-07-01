// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS154, RestClient

class CLASS156
    implements Runnable
{

    CLASS156(CLASS154 class154, String s)
    {
        MF_CLASS156_b560 = class154;
        MF_CLASS154_a557 = s;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS156_b560.MF_CLASS113_a486).showToastMessage((new StringBuilder()).append("Error: file not found: ").append(MF_CLASS154_a557).toString(), 1);
    }

    final String MF_CLASS154_a557;
    final CLASS154 MF_CLASS156_b560;
}
