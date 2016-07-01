// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS275
    implements android.content.DialogInterface.OnClickListener
{

    CLASS275(MapScreen mapscreen)
    {
        MF_CLASS275_a831 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS275_a831.mMe.finish();
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS275_a831;
}
