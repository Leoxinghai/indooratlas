// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView, CLASS316

class CLASS293
    implements Runnable
{

    CLASS293(MapScreen mapscreen, String s)
    {
    	mMapScreen = mapscreen;
    	mReason = s;

    }

    public void run()
    {
    	mMapScreen.hideInProgressDialog();
        String s;
        CLASS167.MF_CLASS167_b635("MapScreen", "onInitializationFailed(): calling stopPositioning(false)");
        MapScreen.MF_CLASS19_b68(mMapScreen, false);
        MapScreen.N(mMapScreen);
        if(mReason == null || mReason.length() <= 200) {
            try
            {
                s = mReason;
            }
            catch(Exception exception)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception.printStackTrace();
                return;
            }
        } else { 
        	s = mReason.substring(0, 200);
        }

        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onInitializationFailed(): mMaxImageWidthHWAccel = ").append(mMapScreen.mMaxImageWidthHWAccel).append(" --> setting HW accel OFF").toString());
        MapScreen.getIndoorMapView(mMapScreen).setLayerType(1, null);
        if(MapScreen.getSensorController(mMapScreen) != null && MapScreen.getSensorController(mMapScreen).MF_CLASS375_d1048())
        {
        	mMapScreen.setDebugBoxVisible(true);
        	mMapScreen.setDebugMessage(String.format((new StringBuilder()).append("Service initialization failure, reason: ").append(s).toString(), new Object[0]));
        }
        mMapScreen.hideInProgressDialog();
        CLASS167.MF_CLASS167_b635("MapScreen", "onInitializationFailed() calling fitImageToScreen()");
        MapScreen.doubleTap(mMapScreen);
        CLASS167.MF_CLASS167_b635("MapScreen", "onInitializationFailed() calling setState with DEFAULT");
        MapScreen.setMapState(mMapScreen, POINT_TYPE.DEFAULT);
        mMapScreen.showInformationDialog(s);
        return;

    }

    final String mReason;
    final MapScreen mMapScreen;
}
