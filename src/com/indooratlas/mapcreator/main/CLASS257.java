// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS257
    implements Runnable
{

    CLASS257(MapScreen mapscreen)
    {
        MF_CLASS257_a805 = mapscreen;

    }

    public void run()
    {
        MF_CLASS257_a805.handleSelectPath();
    }

    final MapScreen MF_CLASS257_a805;
}
