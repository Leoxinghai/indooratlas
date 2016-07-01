// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.types.Some1Base;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS288
    implements Runnable
{

    CLASS288(MapScreen mapscreen, Some1Base some1base)
    {
    	mMapScreen = mapscreen;
        MF_CLASS288_a846 = some1base;
    }

    public void run()
    {
        float f = 99F;
        float f1 = MF_CLASS288_a846.actionPercentage();
        MapScreen.MF_CLASS19_d70(mMapScreen, f1);
        if(MapScreen.L(mMapScreen) >= f1)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onCalibrationStatus() percent not changed, skipping event and returning");
            return;
        }
        if(f1 <= f || f1 >= 100F)
            f = f1;
        MapScreen.MF_CLASS19_e71(mMapScreen, f);
    }

    final Some1Base MF_CLASS288_a846;
    final MapScreen mMapScreen;
}
