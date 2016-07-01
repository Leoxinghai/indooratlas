// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.base.CLASS6;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView

class CLASS289
    implements Runnable
{

    CLASS289(MapScreen mapscreen, double d, double d1, double d2,
            CLASS6 class6)
    {
        MF_CLASS289_e847 = mapscreen;
        MF_CLASS113_a486 = d;
        MF_CLASS289_b849 = d1;
        MF_CLASS289_c850 = d2;
        MF_CLASS289_d851 = class6;
    }

    public void run()
    {
        try {
	    	CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): within UIThread thread = ").append(Thread.currentThread().getName()).toString());
	        MF_CLASS289_e847.hideWalkView();
	        MF_CLASS289_e847.hideInProgressDialog();
	        MapScreen.getIndoorMapView(MF_CLASS289_e847).updatePosition((float)MF_CLASS113_a486, (float)MF_CLASS289_b849, (float)MF_CLASS289_c850, (float)MF_CLASS289_d851.MF_CLASS6_d10());
        } catch(Exception exception) {
            if(CLASS113.isExceptionLogged.booleanValue())
                exception.printStackTrace();
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): within UIThread DONE thread = ").append(Thread.currentThread().getName()).toString());
        return;
    }

    final double MF_CLASS113_a486;
    final double MF_CLASS289_b849;
    final double MF_CLASS289_c850;
    final CLASS6 MF_CLASS289_d851;
    final MapScreen MF_CLASS289_e847;
}
