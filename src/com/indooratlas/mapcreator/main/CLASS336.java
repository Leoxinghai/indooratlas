// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.sensor.type.CLASS369;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS336
    implements Runnable
{

    CLASS336(Sipa sipa, CLASS369 c)
    {
        MF_CLASS336_b931 = sipa;
        MF_CLASS336_a932 = c;

    }

    public void run()
    {
        MF_CLASS336_b931.handlerSensorErrorAndTimetampError(MF_CLASS336_a932);
    }

    final CLASS369 MF_CLASS336_a932;
    final Sipa MF_CLASS336_b931;
}
