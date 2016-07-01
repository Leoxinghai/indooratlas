// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS243
    implements Runnable
{

    CLASS243(MapScreen mapscreen)
    {
        MF_CLASS243_a790 = mapscreen;
    }

    public void run()
    {
        MapScreen.MF_CLASS19_a67(MF_CLASS243_a790, MF_CLASS243_a790.getString(0x7f080014));
    }

    final MapScreen MF_CLASS243_a790;
}
