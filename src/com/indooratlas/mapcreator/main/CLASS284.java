// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.types.IndoorAtlas;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS284
    implements android.content.DialogInterface.OnClickListener
{

    CLASS284(MapScreen mapscreen)
    {
        MF_CLASS284_a840 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS284_a840.showInProgressDialog(MF_CLASS284_a840.getString(0x7f08003a), true);
        MapScreen.MF_CLASS19_a67(MF_CLASS284_a840, true);
        MapScreen.MF_CLASS24_c88(MF_CLASS284_a840).setPreferMobileConnection(true);
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS284_a840;
}
