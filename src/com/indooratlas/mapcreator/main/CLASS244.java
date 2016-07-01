// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS244
    implements Runnable
{

    CLASS244(MapScreen mapscreen)
    {
        MF_CLASS244_a791 = mapscreen;

    }

    public void run()
    {
        MF_CLASS244_a791.showInformationDialog(MF_CLASS244_a791.getString(0x7f080009));
    }

    final MapScreen MF_CLASS244_a791;
}
