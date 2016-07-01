// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.mapcreator.main.MapScreen;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.CLASS370;
import java.text.NumberFormat;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient, CLASS179, CLASS167, CLASS150,
//            CLASS144, CLASS113, CLASS145, CLASS146,
//            CLASS147, CLASS148, CLASS149, CLASS182

class CLASS143 extends AsyncTask
{

    private CLASS143(RestClient class181)
    {
        super();
        mRestClient = class181;

    }

    CLASS143(RestClient class181, CLASS182 class182)
    {
        this(class181);
    }

    private void handleRestSend(String s, String s1, String s2)
    {
        RestClient.MF_CLASS54_a201(mRestClient, 0);

        List list;
        List list1;
        Iterator iterator1;
        String s4;
        java.io.FileInputStream fileinputstream;
        String s5;
        java.io.FileInputStream fileinputstream1;
        CLASS370 class370;

        try {
	        list = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(s, s1, s2);
	        RestClient.MF_CLASS54_a201(mRestClient, new ArrayList());
	        RestClient.MF_CLASS108_b448(mRestClient, new ArrayList());
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): measurements.size = ").append(list.size()).toString());
	        Iterator iterator = list.iterator();
	        for(;iterator.hasNext();) {
		        Measurement class108 = (Measurement)iterator.next();
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): mId = ").append(class108.mMeasurementID).append(", m.mSentToServer = ").append(class108.mSentToServer).append(", m.mWrittenToFile = ").append(class108.mWrittenToFile).toString());
		        if(class108.mSentToServer == 0L && class108.mWrittenToFile == 1L)
		        {
		            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): going to send measurement : ").append(class108.toString()).toString());
		            RestClient.MF_CLASS32_d136(mRestClient).add(class108);
		        }
	        }
	        double d;
	        String s3;
	        d = RestClient.handleRestSend(list);
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): countSegmentLengthSeconds returned  coverageTestPercent = ").append(d).toString());
	        s3 = RestClient.MF_CLASS32_e135(mRestClient).format(100D * d);
	        RestClient.getMapScreen(mRestClient).runOnUiThread(new CLASS144(this, s3));
	        if(RestClient.MF_CLASS32_d136(mRestClient).size() != 0) {
	            if(RestClient.getMapScreen(mRestClient).mUploadingGenerationInProgress && d < 0.05000000074505806D)
	            {
	                try
	                {
	                    RestClient.getMapScreen(mRestClient).runOnUiThread(new CLASS146(this, s3));
	                    return;
	                }
	                // Misplaced declaration of an exception variable
	                catch(Exception exception)
	                {
	                    CLASS167.MF_CLASS167_b635("RestClient", "RestClient.handlerestSend: caught exception. ");
	                    CLASS75.MF_CLASS75_a259(5, "PREPARING_PATH_UPLOAD_FAILED", RestClient.class, (new StringBuilder()).append("handlerestSend: ").append(exception.getMessage()).toString());
	                    if(RestClient.getMapScreen(mRestClient) != null)
	                        CLASS167.unhandledexception(exception, RestClient.getMapScreen(mRestClient));
	                    else
	                        CLASS167.unhandledexception(exception, RestClient.getSipa(mRestClient));
	                }
//	                continue; /* Loop/switch isn't completed */
	                return;
	            }
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend() called, going to send measurements N = ").append(RestClient.MF_CLASS32_d136(mRestClient).size()).toString());
	            mRestClient.MF_CLASS108_a447 = RestClient.MF_CLASS32_d136(mRestClient).size();
	            RestClient.MF_CLASS108_b448(mRestClient, 0);
	            RestClient.MF_CLASS108_c449(mRestClient, 0);
	            RestClient.getMapScreen(mRestClient).runOnUiThread(new CLASS147(this));
	            RestClient.MF_CLASS32_d136(mRestClient, 0);
	            list1 = MeasurementDataSource.getNotUploadedCalibrationSets();
	            RestClient.MF_CLASS108_c449(mRestClient, new ArrayList());
	            iterator1 = list1.iterator();

	            for(;iterator1.hasNext();) {
	    	        class370 = (CLASS370)iterator1.next();
	    	        if(class370.WrittenToFile != 1L)
	    	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): *not* adding calibset to mToBeSendCalibrationSets = ").append(class370.toString()).toString());
	    	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): adding calibset to mToBeSendCalibrationSets = ").append(class370.toString()).toString());
	    	        RestClient.MF_CLASS381_f1112(mRestClient).add(class370);
	            }

	            RestClient.MF_CLASS32_d136(mRestClient, new ArrayList());
	            if(RestClient.MF_CLASS381_f1112(mRestClient).size() > 0)
	            {
	                CLASS167.MF_CLASS167_b635("RestClient", "Restclient.handleRestSend(): Starting calibration set uploads to server...");
	                s5 = RestClient.MF_CLASS54_a201((CLASS370)RestClient.MF_CLASS381_f1112(mRestClient).get(-1 + RestClient.MF_CLASS381_f1112(mRestClient).size()));
	                fileinputstream1 = RestClient.getMapScreen(mRestClient).openFileInput(s5);
	                CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): calibfname = ").append(s5).toString());
	                RestClient.getMapScreen(mRestClient).runOnUiThread(new CLASS148(this, fileinputstream1));
	                return;
	            }
	            CLASS167.MF_CLASS167_b635("RestClient", "Restclient.handleRestSend(): NO CALIBRATION SETS TO UPLOAD --> START SENDING MEASUREMENTS IMMEDIATELY...");
	            s4 = mRestClient.formatMeasurementFileString((Measurement)RestClient.MF_CLASS32_d136(mRestClient).get(-1 + RestClient.MF_CLASS32_d136(mRestClient).size()));
	            fileinputstream = RestClient.getMapScreen(mRestClient).openFileInput(s4);
	            RestClient.getMapScreen(mRestClient).runOnUiThread(new CLASS149(this, fileinputstream));
	            return;

	        }
	        CLASS167.MF_CLASS167_b635("RestClient", "Restclient.handleRestSend() called, mToBeSendMeasurements.size() == 0, calling informUploadDone, not uploading calibration set.");
	        RestClient.getMapScreen(mRestClient).showOkButtonDialog("No new paths to be stored.");
	        if(!CLASS113.isDeviceChecked.booleanValue()) {
	            return;
	        } else {
		        RestClient.getMapScreen(mRestClient).runOnUiThread(new CLASS145(this));
		        return;
	        }

        } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue()) {
	        	exception1.printStackTrace();
	        }
	        return;
        }
//        RestClient.MF_CLASS54_a201(MF_CLASS113_a486).hideInProgressDialog();
//        RestClient.MF_CLASS54_a201(MF_CLASS113_a486).runOnUiThread(new CLASS150(this));
//        return;

    }

    protected Void MF_CLASS113_a486(Object aobj[])
    {
        try
        {
        	handleRestSend((String)aobj[0], (String)aobj[1], (String)aobj[2]);
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, RestClient.getMapScreen(mRestClient));
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

    final RestClient mRestClient;
}
