// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS316

class CLASS242
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS242(MapScreen mapscreen)
    {
        MF_CLASS113_a486 = mapscreen;
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showInProgressDialog(): closing dialog.");
        if(MF_CLASS113_a486.mScreenPointType != POINT_TYPE.POSITIONING) {

            if(MapScreen.MF_CLASS19_e71(MF_CLASS113_a486))
            {
                if(i == 4 && keyevent.getAction() == 1)
                {
                    CLASS167.MF_CLASS167_b635("MapScreen", "showInProgressDialog(): closing dialog.");
                    dialoginterface.dismiss();
                    MF_CLASS113_a486.hideInProgressDialog();
                    MF_CLASS113_a486.showToastMessage(MF_CLASS113_a486.getString(0x7f08004d), 1);
                    MapScreen.MF_CLASS24_c88(MF_CLASS113_a486, false);
                    if(MF_CLASS113_a486.t != null)
                    {
                        MF_CLASS113_a486.t.cancel();
                        return true;
                    }
                } else
                {
                    return false;
                }
            } else
            if(i == 84 && keyevent.getRepeatCount() == 0)
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "showInProgressDialog(): preventing touches.");
                return true;
            } else
            {
                return false;
            }
        	
        } else {
	        if(i != 4 || keyevent.getAction() != 1)
	            return false;
	        
	        CLASS167.MF_CLASS167_b635("MapScreen", "showInProgressDialog(): closing dialog and calling stopPositioning");
	        dialoginterface.dismiss();
	        try
	        {
	            MapScreen.MF_CLASS19_b68(MF_CLASS113_a486, true);
	        }
	        catch(Exception exception)
	        {
	            if(CLASS113.isExceptionLogged.booleanValue())
	            {
	                exception.printStackTrace();
	                return true;
	            }
	        }
        }
        return true;
    }

    final MapScreen MF_CLASS113_a486;
}
