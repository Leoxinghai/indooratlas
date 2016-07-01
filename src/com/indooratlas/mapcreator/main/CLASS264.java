// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS264
    implements android.content.DialogInterface.OnClickListener
{

    CLASS264(MapScreen mapscreen)
    {
        MF_CLASS264_a812 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try {
	    	CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() onClick ");
	        if(i != 0) {
	            //break MISSING_BLOCK_LABEL_61;
	        	return;
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() onClick item == 0");
	        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("vnd.youtube://").append("LA08TliSt4Y").toString()));
	        MF_CLASS264_a812.startActivity(intent);
	        dialoginterface.cancel();
	        return;
        } catch(Exception exception) {
	        CLASS167.unhandledexception(exception, MF_CLASS264_a812.getApplicationContext());
	        return;
        }
    }

    final MapScreen MF_CLASS264_a812;
}
