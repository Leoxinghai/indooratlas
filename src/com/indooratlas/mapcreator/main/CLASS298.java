// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView

class CLASS298
    implements Runnable
{

    CLASS298(MapScreen mapscreen)
    {
        MF_CLASS298_a866 = mapscreen;
    }

    public void run()
    {
        MF_CLASS298_a866.hideInProgressDialog();
        MF_CLASS298_a866.showToastMessage("Paths synchronized.", 1);
        MapScreen.getIndoorMapView(MF_CLASS298_a866).setBackendSegments(null);
        MapScreen.w(MF_CLASS298_a866);
    }

    final MapScreen MF_CLASS298_a866;
}
