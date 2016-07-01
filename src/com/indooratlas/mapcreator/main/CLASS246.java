// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.CLASS113;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS316, MapScreen

class CLASS246
    implements Runnable
{

    CLASS246(MapScreen mapscreen)
    {
        MF_CLASS113_a486 = mapscreen;
    }

    public void run()
    {
        try {
        	MapScreen.setMapState(MF_CLASS113_a486, POINT_TYPE.DEFAULT);
        } catch(Exception exception) {
            if(CLASS113.isExceptionLogged.booleanValue())
            {
                exception.printStackTrace();
                return;
            }
        }
        return;
    }

    final MapScreen MF_CLASS113_a486;
}
