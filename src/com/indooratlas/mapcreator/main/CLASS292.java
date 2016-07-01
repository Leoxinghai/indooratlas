// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS292
    implements Runnable
{

    CLASS292(MapScreen mapscreen)
    {
    	mMapScreen = mapscreen;

    }

    public void run()
    {
    	mMapScreen.showInProgressDialog(mMapScreen.getString(0x7f080030), true);
    }

    final MapScreen mMapScreen;
}
