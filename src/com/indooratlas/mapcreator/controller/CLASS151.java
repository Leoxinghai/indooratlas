// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.main.MapScreen;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.CLASS370;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient, CLASS167, CLASS152, CLASS153,
//            CLASS113, CLASS182

class CLASS151 extends AsyncTask
{

    private CLASS151(RestClient class181)
    {
        super();
    	MF_CLASS113_a486 = class181;
    }

    CLASS151(RestClient class181, CLASS182 class182)
    {
        this(class181);
    }

    protected Void MF_CLASS113_a486(Object aobj[])
    {
    	try {
	    	String s = RestClient.MF_CLASS54_a201((CLASS370)RestClient.MF_CLASS381_f1112(MF_CLASS113_a486).get(-1 + RestClient.MF_CLASS381_f1112(MF_CLASS113_a486).size()));
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("PostCalibrationSetToBackendTask.doInBackground(): fname = ").append(s).toString());
	        java.io.FileInputStream fileinputstream = RestClient.getMapScreen(MF_CLASS113_a486).openFileInput(s);
	        CLASS167.MF_CLASS167_b635("RestClient", "PostCalibrationSetToBackendTask.doInBackground(): calling mapScreen.runOnUiThread with method postMeasurementSequence");
	        RestClient.getMapScreen(MF_CLASS113_a486).runOnUiThread(new CLASS152(this, fileinputstream));
	        return null;
    	} catch(Exception exception) {
	        CLASS75.MF_CLASS75_a259(5, "PREPARING_CALIBRATION_UPLOAD_FAILED", RestClient.class, (new StringBuilder()).append("PostCalibrationSetToBackendTask: ").append(exception.getMessage()).toString());
	        if(RestClient.getMapScreen(MF_CLASS113_a486) != null)
	            CLASS167.unhandledexception(exception, RestClient.getMapScreen(MF_CLASS113_a486));
	        else
	            CLASS167.unhandledexception(exception, RestClient.getSipa(MF_CLASS113_a486));
	        try
	        {
	            RestClient.getMapScreen(MF_CLASS113_a486).hideInProgressDialog();
	            RestClient.getMapScreen(MF_CLASS113_a486).runOnUiThread(new CLASS153(this));
	        }
	        catch(Exception exception1)
	        {
	            if(CLASS113.isExceptionLogged.booleanValue())
	                exception1.printStackTrace();
	        }
	        return null;
    	}
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
