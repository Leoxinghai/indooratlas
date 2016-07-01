// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS286
    implements Runnable
{

    CLASS286(MapScreen mapscreen, String s)
    {
        MF_CLASS286_b842 = mapscreen;
        MF_CLASS286_a843 = s;

    }

    public void run()
    {
        MF_CLASS286_b842.showToastMessage((new StringBuilder()).append("Calibration failed: ").append(MF_CLASS286_a843).toString(), 1);
    }

    final String MF_CLASS286_a843;
    final MapScreen MF_CLASS286_b842;
}
