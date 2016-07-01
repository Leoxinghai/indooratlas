// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS309

class CLASS241
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS241(MapScreen mapscreen)
    {
        MF_CLASS241_a788 = mapscreen;
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "progressDialogFloorplanDownload.onKey(): BUTTON CLICKED.");
        if(i == 4 && keyevent.getAction() == 1)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "progressDialogFloorplanDownload.onKey(): *BACK* BUTTON CLICKED.");
            MF_CLASS241_a788.MF_CLASS19_b68.cancel(true);
            MF_CLASS241_a788.mMe.showToastMessage("Floor plan image download cancelled.", 0);
            MapScreen.MF_CLASS19_d70(MF_CLASS241_a788.mMe).cancel();
            MF_CLASS241_a788.mMe.finish();
            return true;
        } else
        {
            return false;
        }
    }

    final MapScreen MF_CLASS241_a788;
}
