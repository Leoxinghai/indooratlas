// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient, CLASS113

class CLASS128
    implements Runnable
{

    CLASS128(RestClient class181)
    {
        MF_CLASS113_a486 = class181;
    }

    public void run()
    {
        try {
	    	RestClient.getMapScreen(MF_CLASS113_a486).hideInProgressDialog();
	        RestClient.getMapScreen(MF_CLASS113_a486).showInformationDialog(RestClient.getMapScreen(MF_CLASS113_a486).getString(0x7f080047));
	        RestClient.MF_CLASS108_b448(MF_CLASS113_a486);

	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }

    }

    final RestClient MF_CLASS113_a486;
}
