// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS309

class CLASS240
    implements android.content.DialogInterface.OnClickListener
{

    CLASS240(MapScreen mapscreen)
    {
        MF_CLASS240_a787 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "progressDialogFloorplanDownload *CANCEL* BUTTON CLICKED.");
        dialoginterface.dismiss();
        MF_CLASS240_a787.MF_CLASS19_b68.cancel(true);
        MF_CLASS240_a787.mMe.showToastMessage("Floor plan image download cancelled.", 0);
        MapScreen.MF_CLASS19_d70(MF_CLASS240_a787.mMe).cancel();
        MF_CLASS240_a787.mMe.finish();
    }

    final MapScreen MF_CLASS240_a787;
}
