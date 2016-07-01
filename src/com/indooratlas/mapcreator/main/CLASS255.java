// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS255
    implements Runnable
{

    CLASS255(MapScreen mapscreen)
    {
    	mMapScreen = mapscreen;

    }

    public void run()
    {
    	mMapScreen.showWalkView();
    	mMapScreen.showRotateIcon();
    }

    final MapScreen mMapScreen;
}
