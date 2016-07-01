// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS245
    implements Runnable
{

    CLASS245(MapScreen mapscreen)
    {
        MF_CLASS245_a792 = mapscreen;

    }

    public void run()
    {
        MF_CLASS245_a792.showInformationDialog(MF_CLASS245_a792.getString(0x7f080011));
    }

    final MapScreen MF_CLASS245_a792;
}
