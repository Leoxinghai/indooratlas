// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS354

class CLASS248
    implements Runnable
{

    CLASS248(MapScreen mapscreen, String s)
    {
        MF_CLASS248_b795 = mapscreen;
        MF_CLASS248_a796 = s;
    }

    public void run()
    {
        MapScreen.MF_CLASS159_f577(MF_CLASS248_b795).setProgress(MF_CLASS248_a796);
    }

    final String MF_CLASS248_a796;
    final MapScreen MF_CLASS248_b795;
}
