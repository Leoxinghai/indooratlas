// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.sensor.type.CLASS369;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS300
    implements Runnable
{

    CLASS300(MapScreen mapscreen, CLASS369 c)
    {
        MF_CLASS300_b869 = mapscreen;
        MF_CLASS300_a870 = c;

    }

    public void run()
    {
        MF_CLASS300_b869.handlerSensorErrorAndTimetampError(MF_CLASS300_a870);
    }

    final CLASS369 MF_CLASS300_a870;
    final MapScreen MF_CLASS300_b869;
}
