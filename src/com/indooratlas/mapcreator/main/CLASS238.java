// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.types.IndoorAtlas;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS238
    implements android.content.DialogInterface.OnClickListener
{

    CLASS238(MapScreen mapscreen)
    {
        MF_CLASS238_a785 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS238_a785.showInProgressDialog(MF_CLASS238_a785.getString(0x7f08003b), true);
        MapScreen.MF_CLASS19_a67(MF_CLASS238_a785, true);
        MapScreen.MF_CLASS24_c88(MF_CLASS238_a785).setPreferMobileConnection(false);
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS238_a785;
}
