// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.mapcreator.main.MapScreen;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient, CLASS167, CLASS155, CLASS113,
//            CLASS156, CLASS157, CLASS182

class CLASS154 extends AsyncTask
{

    private CLASS154(RestClient class181)
    {
        super();
    	MF_CLASS113_a486 = class181;
    }

    CLASS154(RestClient class181, CLASS182 class182)
    {
        this(class181);
    }

    protected Void MF_CLASS113_a486(Object aobj[])
    {
        String s ="";
        try {
	        Measurement class108 = (Measurement)aobj[0];
	        s = MF_CLASS113_a486.formatMeasurementFileString(class108);
	        java.io.FileInputStream fileinputstream = RestClient.getMapScreen(MF_CLASS113_a486).openFileInput(s);
	        CLASS167.MF_CLASS167_b635("RestClient", "PostMeasurementToBackendTask.doInBackground(): calling mapScreen.runOnUiThread with method postMeasurementSequence");
	        RestClient.getMapScreen(MF_CLASS113_a486).runOnUiThread(new CLASS155(this, fileinputstream));
	        return null;
        } catch(Exception exception2) {
	        try
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", "File not found?");
	            CLASS75.MF_CLASS75_a259(5, "PREPARING_PATH_UPLOAD_FAILED", RestClient.class, (new StringBuilder()).append("PostMeasurementToBackendTask: ").append(exception2.getMessage()).toString());
	            if(CLASS113.isExceptionLogged.booleanValue())
	            {
	                exception2.printStackTrace();
	                RestClient.getMapScreen(MF_CLASS113_a486).runOnUiThread(new CLASS156(this, s));
	            }
	        }
	        catch(Exception exception)
	        {
	            CLASS75.MF_CLASS75_a259(5, "PREPARING_PATH_UPLOAD_FAILED", RestClient.class, (new StringBuilder()).append("PostMeasurementToBackendTask: ").append(exception.getMessage()).toString());
	            if(RestClient.getMapScreen(MF_CLASS113_a486) != null)
	                CLASS167.unhandledexception(exception, RestClient.getMapScreen(MF_CLASS113_a486));
	            else
	                CLASS167.unhandledexception(exception, RestClient.getSipa(MF_CLASS113_a486));
	            try
	            {
	                RestClient.getMapScreen(MF_CLASS113_a486).hideInProgressDialog();
	                RestClient.getMapScreen(MF_CLASS113_a486).runOnUiThread(new CLASS157(this));
	            }
	            catch(Exception exception1)
	            {
	                if(CLASS113.isExceptionLogged.booleanValue())
	                    exception1.printStackTrace();
	            }
	        }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS113_a486(aobj);
    }

    protected void onPreExecute()
    {
    }

    final RestClient MF_CLASS113_a486;
}
