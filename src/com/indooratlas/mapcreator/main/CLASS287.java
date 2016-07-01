// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS287
    implements android.content.DialogInterface.OnClickListener
{

    CLASS287(MapScreen mapscreen)
    {
        MF_CLASS287_a844 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        MapScreen.MF_CLASS19_a67(MF_CLASS287_a844, (float)i);
    }

    final MapScreen MF_CLASS287_a844;
}
