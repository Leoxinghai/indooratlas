// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS359, IndoorMapView

class CLASS360
    implements Runnable
{

    CLASS360(CLASS359 class359)
    {
        MF_CLASS360_a970 = class359;

    }

    public void run()
    {
        try
        {
            IndoorMapView.MF_CLASS113_a486(MF_CLASS360_a970.mIndoorMapView);
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    final CLASS359 MF_CLASS360_a970;
}
