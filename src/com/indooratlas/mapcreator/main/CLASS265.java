// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS265
    implements android.content.DialogInterface.OnClickListener
{

    CLASS265(MapScreen mapscreen)
    {
        MF_CLASS265_a813 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS265_a813;
}
