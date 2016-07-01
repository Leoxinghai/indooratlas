// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.MeasurementDataSource;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView

class CLASS226
    implements android.content.DialogInterface.OnClickListener
{

    CLASS226(MapScreen mapscreen)
    {
        MF_CLASS226_a772 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MeasurementDataSource.reCreateTables();
        MapScreen.getIndoorMapView(MF_CLASS226_a772).initialize();
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS226_a772;
}
