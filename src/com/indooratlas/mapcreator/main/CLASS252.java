// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;
import com.indooratlas.mapcreator.controller.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS252 extends CountDownTimer
{

    CLASS252(MapScreen mapscreen, long l, long l1)
    {
        super(l, l1);
        MF_CLASS113_a486 = mapscreen;
    }

    public void onFinish()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "mMapGenerationStatusPoller.onFinish(): map generation polling stopped...");
        MF_CLASS113_a486.showInformationDialog("Map generation is taking a long time. Please be patient and try positioning after a few minutes.");
        
        try {
        MapScreen.MF_CLASS24_c88(MF_CLASS113_a486, false);
        MF_CLASS113_a486.hideInProgressDialog();
        return;
        } catch(Exception exception) {
	        exception.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
    }

    public void onTick(long l)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "mMapGenerationStatusPoller.onTick(): fetching backend map generation status.");
        MapScreen.MF_CLASS108_i455(MF_CLASS113_a486).checkMapGenerationStatus(MapScreen.MF_CLASS159_h579(MF_CLASS113_a486));
    }

    final MapScreen MF_CLASS113_a486;
}
