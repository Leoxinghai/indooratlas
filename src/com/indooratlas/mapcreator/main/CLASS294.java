// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView, CLASS350

class CLASS294
    implements Runnable
{

    CLASS294(MapScreen mapscreen)
    {
        MF_CLASS294_a860 = mapscreen;
    }

    public void run()
    {
        MF_CLASS294_a860.mUpdatingLocation = true;
        MapScreen.getIndoorMapView(MF_CLASS294_a860).setPositioning(true);
        MapScreen.R(MF_CLASS294_a860).MF_CLASS350_a948(MF_CLASS294_a860.getString(0x7f080036));
        MapScreen.R(MF_CLASS294_a860).MF_CLASS350_a948();
    }

    final MapScreen MF_CLASS294_a860;
}
