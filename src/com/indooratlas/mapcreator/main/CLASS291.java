// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS291
    implements Runnable
{

    CLASS291(MapScreen mapscreen, String s, int i)
    {
        mMapScreen = mapscreen;
        MF_CLASS113_a486 = s;
        MF_CLASS291_b856 = i;

    }

    public void run()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceFailure() within UIThread, reason =  ").append(MF_CLASS113_a486).toString());
        mMapScreen.hideInProgressDialog();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceFailure() within UIThread, hideInProgressDialog done, reason =  ").append(MF_CLASS113_a486).toString());
        switch(MF_CLASS291_b856) {
//        JVM INSTR lookupswitch 12: default 172
    //                   0: 440
    //                   1001: 470
    //                   1002: 489
    //                   1003: 508
    //                   2001: 527
    //                   2002: 546
    //                   2003: 565
    //                   2005: 584
    //                   3001: 603
    //                   3002: 622
    //                   3003: 641
    //                   3005: 660;
//           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
default:
        if(CLASS113.isExceptionLogged.booleanValue()) {
        mMapScreen.showInformationDialog((new StringBuilder()).append("SHOWN ONLY IN DEBUG MODE: ").append(MF_CLASS113_a486).toString());
        long l;
        l = System.currentTimeMillis() - mMapScreen.mLastSuccesfulLocationUpdateTimestamp;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceFailure(): diff = ").append(l).toString());
        MapScreen mapscreen = mMapScreen;
        mapscreen.F = 1 + mapscreen.F;
        MapScreen.N(mMapScreen);
        String s;
        if(MF_CLASS113_a486 != null && MF_CLASS113_a486.length() > 200) {
        	s = (new StringBuilder()).append(MF_CLASS113_a486.substring(0, 200)).append(", mFailedRequestCnt = ").append(MapScreen.O(mMapScreen)).toString();
        } else {
             s = (new StringBuilder()).append(MF_CLASS113_a486).append(", mFailedRequestCnt = ").append(MapScreen.O(mMapScreen)).toString();
        }        	

        if(mMapScreen.mUpdatingLocation && MapScreen.O(mMapScreen) > 3 && mMapScreen.F > 1 && l > 2000L) {
		    try
		    {
		        if(MapScreen.getSensorController(mMapScreen) != null && MapScreen.getSensorController(mMapScreen).MF_CLASS375_d1048())
		        {
		            mMapScreen.setDebugBoxVisible(true);
		            mMapScreen.setDebugMessage(String.format((new StringBuilder()).append("Service failure, reason: ").append(s).toString(), new Object[0]));
		            return;
		        }
		    }
		    catch(Exception exception)
		    {
		        if(CLASS113.isExceptionLogged.booleanValue())
		        {
		            exception.printStackTrace();
		            return;
		        }
		    }
        } else {
                if(MapScreen.getSensorController(mMapScreen) != null && MapScreen.getSensorController(mMapScreen).MF_CLASS375_d1048())
                {
                    mMapScreen.setDebugBoxVisible(true);
                    mMapScreen.setDebugMessage(String.format((new StringBuilder()).append("Service failure, reason: ").append(s).toString(), new Object[0]));
                }
                return;
        }
        } else {
                mMapScreen.showInformationDialog("Unexpected error.");
        }
        return;
case 0:
        mMapScreen.showToastMessage(MF_CLASS113_a486, 1);
        break; /* Loop/switch isn't completed */
case 1001:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f08006c));
        break; /* Loop/switch isn't completed */
case 1002:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f08006d));
        break; /* Loop/switch isn't completed */
case 1003:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f08006e));
        break; /* Loop/switch isn't completed */
case 2001:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080071));
        break; /* Loop/switch isn't completed */
case 2002:
        mMapScreen.showInformationDialog(mMapScreen.getString(R.string.internal_error));
        break; /* Loop/switch isn't completed */
case 2003:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080073));
        break; /* Loop/switch isn't completed */
case 2005:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f08006f));
        break; /* Loop/switch isn't completed */
case 3001:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080075));
        break; /* Loop/switch isn't completed */
case 3002:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080076));
        break; /* Loop/switch isn't completed */
case 3003:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080077));
        break; /* Loop/switch isn't completed */
case 3005:
        mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080079));
        break; /* Loop/switch isn't completed */
        }

    }

    final String MF_CLASS113_a486;
    final int MF_CLASS291_b856;
    final MapScreen mMapScreen;
}
