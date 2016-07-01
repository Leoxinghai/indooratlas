// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS262
    implements Runnable
{

    CLASS262(MapScreen mapscreen)
    {
        MF_CLASS262_a810 = mapscreen;

    }

    public void run()
    {
        MF_CLASS262_a810.showOnDebugMessage();
        MF_CLASS262_a810.invalidateOptionsMenu();
    }

    final MapScreen MF_CLASS262_a810;
}
