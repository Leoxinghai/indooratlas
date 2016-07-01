// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.sensor.type.CLASS369;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS301
    implements Runnable
{

    CLASS301(MapScreen mapscreen, CLASS369 c)
    {
        MF_CLASS301_b871 = mapscreen;
        MF_CLASS301_a872 = c;

    }

    public void run()
    {
        MF_CLASS301_b871.handlerSensorErrorAndTimetampError(MF_CLASS301_a872);
    }

    final CLASS369 MF_CLASS301_a872;
    final MapScreen MF_CLASS301_b871;
}
