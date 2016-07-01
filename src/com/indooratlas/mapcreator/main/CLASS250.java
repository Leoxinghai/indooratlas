// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import com.indooratlas.base.CLASS1;
import com.indooratlas.mapcreator.controller.CLASS113;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS250
    implements Runnable
{

    CLASS250(MapScreen mapscreen)
    {
    	mMapScreen = mapscreen;
    }

    public void run()
    {
    	try {
    		MapScreen.MF_CLASS22_g77(mMapScreen);
    	} catch(CLASS1 class1) {
	        class1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            class1.printStackTrace();
    	}
    	mMapScreen.showInformationDialog(mMapScreen.getString(0x7f080011));
        return;
    }

    final MapScreen mMapScreen;
}
