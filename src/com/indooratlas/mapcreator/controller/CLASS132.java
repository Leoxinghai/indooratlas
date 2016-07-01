// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.Sipa;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient, CLASS167

class CLASS132
    implements Runnable
{

    CLASS132(RestClient class181)
    {
        MF_CLASS132_a510 = class181;
    }

    public void run()
    {
        try {
	    	RestClient.getSipa(MF_CLASS132_a510).hideWaitDialog();
	        if(MF_CLASS132_a510.MF_CLASS108_b448) {
	            CLASS167.MF_CLASS167_b635("RestClient", "onRequestFailed() : buildings-query, *NOT* re-sending request, because Sipa has been paused.");
	            return;
	        }
	        CLASS167.MF_CLASS167_b635("RestClient", "onRequestFailed() : buildings-query, re-sending request!");
	        MF_CLASS132_a510.MF_CLASS108_c449 = false;
	        RestClient.getSipa(MF_CLASS132_a510).initiateGetBuildingsRequest();
	        return;
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }

    final RestClient MF_CLASS132_a510;
}
