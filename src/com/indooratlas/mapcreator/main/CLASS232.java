// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS232
    implements android.content.DialogInterface.OnClickListener
{

    CLASS232(MapScreen mapscreen)
    {
        MF_CLASS232_a778 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showImageDownloadRetryDialog : RETRY clicked --> closing activity");
        MF_CLASS232_a778.mMe.finish();
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS232_a778;
}
