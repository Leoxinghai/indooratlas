// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView, CLASS316

class CLASS295
    implements Runnable
{

    CLASS295(MapScreen mapscreen)
    {
        MF_CLASS316_a895 = mapscreen;
    }

    public void run()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onServiceStopped(): on UIThread, calling stopPositioning(false)");
        MapScreen.MF_CLASS19_b68(MF_CLASS316_a895, false);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceStopped(): mMaxImageWidthHWAccel = ").append(MF_CLASS316_a895.mMaxImageWidthHWAccel).append(" --> setting HW accel OFF").toString());
        MapScreen.getIndoorMapView(MF_CLASS316_a895).setLayerType(1, null);
        if(MapScreen.S(MF_CLASS316_a895))
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceStopped() mPaused == true, returning without doing anything.");
            return;
        }
        try
        {
            MF_CLASS316_a895.hideInProgressDialog();
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceStopped() calling fitImageToScreen()");
            MapScreen.doubleTap(MF_CLASS316_a895);
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceStopped() calling setState with DEFAULT");
            MapScreen.setMapState(MF_CLASS316_a895, POINT_TYPE.DEFAULT);
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return;
    }

    final MapScreen MF_CLASS316_a895;
}
