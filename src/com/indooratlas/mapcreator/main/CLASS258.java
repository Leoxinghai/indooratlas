// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView

class CLASS258
    implements android.content.DialogInterface.OnClickListener
{

    CLASS258(MapScreen mapscreen)
    {
        MF_CLASS258_a806 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MapScreen.getIndoorMapView(MF_CLASS258_a806).setSelectedSegment(null);
        MapScreen.getIndoorMapView(MF_CLASS258_a806).invalidate();
        MapScreen.MF_CLASS19_d70(MF_CLASS258_a806, false);
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS258_a806;
}
