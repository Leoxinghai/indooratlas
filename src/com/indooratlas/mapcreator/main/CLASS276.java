// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS276
    implements android.content.DialogInterface.OnClickListener
{

    CLASS276(MapScreen mapscreen)
    {
        MF_CLASS276_a832 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS276_a832.startCalibration();
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS276_a832;
}
