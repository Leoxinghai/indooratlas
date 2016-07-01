// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS297
    implements Runnable
{

    CLASS297(MapScreen mapscreen)
    {
        MF_CLASS297_a865 = mapscreen;
    }

    public void run()
    {
        if(MapScreen.Z(MF_CLASS297_a865.mMe) == null)
            MF_CLASS297_a865.showInProgressDialog((new StringBuilder()).append(MF_CLASS297_a865.getString(0x7f080024)).append(": ").append(MapScreen.aa(MF_CLASS297_a865)).toString(), true);
        MF_CLASS297_a865.updateInProgressDialog((new StringBuilder()).append(MF_CLASS297_a865.getString(0x7f080024)).append(": ").append(MapScreen.aa(MF_CLASS297_a865)).toString());
    }

    final MapScreen MF_CLASS297_a865;
}
