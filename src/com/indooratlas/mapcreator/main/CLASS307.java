// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS314

public class CLASS307 extends AsyncTask
{

    public CLASS307(MapScreen mapscreen, boolean flag)
    {
        super();
        MF_CLASS307_b880 = mapscreen;
        MF_CLASS113_a486 = false;
        MF_CLASS113_a486 = flag;
    }

    protected void MF_CLASS113_a486(Void void1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("CheckDataStoringIsDoneTask.onPostExecute, abortCollection = ").append(MF_CLASS113_a486).toString());

        try {
        if(MF_CLASS113_a486) {
	        MF_CLASS307_b880.discardCollectedData();
        } else {
	        CLASS167.MF_CLASS167_b635("MapScreen", "CheckDataStoringIsDoneTask.onPostExecute, closing progressdialog");
	        Thread.sleep(300L);
	        
	        MF_CLASS307_b880.hideInProgressDialog();
	        if(MF_CLASS307_b880.mMode != CLASS314.SEGMENT_DATA) {
	            if(MF_CLASS307_b880.checkTimeStamps(MapScreen.currentMeasurement)) {
	            	MapScreen.sHandleStoringTestData(MF_CLASS307_b880);
	            } else {
	                try
	                {
	                    MF_CLASS307_b880.mMe.discardCollectedData();
	                    MF_CLASS307_b880.showInformationDialog("Validation path was discarded because some checkpoints were not labeled. Please tap screen at each checkpoint.");
	                }
	                // Misplaced declaration of an exception variable
	                catch(Exception exception)
	                {
	                    if(CLASS113.isExceptionLogged.booleanValue())
	                        exception.printStackTrace();
	                    CLASS167.unhandledexception(exception, MF_CLASS307_b880.getApplicationContext());
	                    return;
	                }
	            }
	        } else {
	        	MapScreen.sHandleStoringMapData(MF_CLASS307_b880);
	        }
        }
        MapScreen.ah(MF_CLASS307_b880);
        return;

        } catch(Exception exception1) {
        	if(CLASS113.isExceptionLogged.booleanValue())
        		exception1.printStackTrace();
        }

    }

    protected void MF_CLASS113_a486(Void avoid[])
    {
    }

    protected Void MF_CLASS307_b880(Void avoid[])
    {
        int i = 1;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("CheckDataStoringIsDoneTask.doInBackground, cnt =  ").append(i).toString());

        try {
        while(i!=0) {

	        SensorController class159 = MapScreen.getSensorController(MF_CLASS307_b880);
	        if(class159 == null)
	            return null;

	        i = MapScreen.getSensorController(MF_CLASS307_b880).MF_CLASS158_a563();
	        if(i != 0) {
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("CheckDataStoringIsDoneTask.doInBackground, waiting cnt =  ").append(i).toString());
		        Thread.sleep(50L);
	        }
        }
        try {
        	CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("CheckDataStoringIsDoneTask.doInBackground, going to stop and close wait dialog, cnt =  ").append(i).toString());
        } catch (Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
        CLASS75.MF_CLASS75_a259(4, "PATH_RECORDED", RestClient.class, "CheckDataStoringIsDoneTask: storing done. ");
        return null;

        } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        	exception1.printStackTrace();
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS307_b880((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS113_a486((Void)obj);
    }

    protected void onPreExecute()
    {
        if(!MF_CLASS113_a486)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "CheckDataStoringIsDoneTask.onPreExecute, showing progressdialog");
            MF_CLASS307_b880.showInProgressDialog("Saving...", false);
        }
    }

    protected void onProgressUpdate(Object aobj[])
    {
        MF_CLASS113_a486((Void[])aobj);
    }

    boolean MF_CLASS113_a486;
    final MapScreen MF_CLASS307_b880;
}
