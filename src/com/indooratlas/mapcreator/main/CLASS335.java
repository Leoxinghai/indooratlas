// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.sensor.type.CLASS369;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS335
    implements Runnable
{

    CLASS335(Sipa sipa, CLASS369 c)
    {
        MF_CLASS335_b929 = sipa;
        MF_CLASS335_a930 = c;

    }

    public void run()
    {
        MF_CLASS335_b929.handlerSensorErrorAndTimetampError(MF_CLASS335_a930);
    }

    final CLASS369 MF_CLASS335_a930;
    final Sipa MF_CLASS335_b929;
}
