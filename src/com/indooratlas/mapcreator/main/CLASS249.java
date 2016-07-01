// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS354

class CLASS249
    implements Runnable
{

    CLASS249(MapScreen mapscreen)
    {
        MF_CLASS249_a797 = mapscreen;
    }

    public void run()
    {
        MapScreen.MF_CLASS159_f577(MF_CLASS249_a797).setProgress(MF_CLASS249_a797.mMe.getString(0x7f08000b));
    }

    final MapScreen MF_CLASS249_a797;
}
