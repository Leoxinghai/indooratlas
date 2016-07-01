// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS279
    implements android.content.DialogInterface.OnClickListener
{

    CLASS279(MapScreen mapscreen)
    {
        MF_CLASS113_a486 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try {
	    	CLASS167.MF_CLASS167_b635("MapScreen", "onWalkViewCancelled() called - calling MapScreen.stopPositioning()");
	        MapScreen.MF_CLASS19_b68(MF_CLASS113_a486, true);
	        MF_CLASS113_a486.hideWalkView();
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
        dialoginterface.cancel();
        return;

    }

    final MapScreen MF_CLASS113_a486;
}
