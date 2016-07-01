// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS273
    implements android.content.DialogInterface.OnClickListener
{

    CLASS273(MapScreen mapscreen)
    {
        MF_CLASS273_a829 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MapScreen.MF_CLASS108_j456(MF_CLASS273_a829, true);
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS273_a829;
}
