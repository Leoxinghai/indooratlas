// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView

class CLASS260
    implements android.content.DialogInterface.OnClickListener
{

    CLASS260(MapScreen mapscreen)
    {
        MF_CLASS260_a808 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MapScreen.getIndoorMapView(MF_CLASS260_a808).setSelectedSegment(null);
        MapScreen.getIndoorMapView(MF_CLASS260_a808).invalidate();
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS260_a808;
}
