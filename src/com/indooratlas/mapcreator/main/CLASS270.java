// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS270
    implements android.content.DialogInterface.OnClickListener
{

    CLASS270(MapScreen mapscreen)
    {
        MF_CLASS270_a825 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showEnterLabelDialog(): cancel storing label, go back to label list ");
        dialoginterface.cancel();
        MF_CLASS270_a825.showSegmentLabelDialog();
    }

    final MapScreen MF_CLASS270_a825;
}
