// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.position.CLASS75;
import java.io.File;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

public class CLASS319 extends AsyncTask
{

    public CLASS319(MapScreen mapscreen)
    {
        super();
        MF_CLASS113_a486 = mapscreen;
    }

    protected Void MF_CLASS113_a486(Measurement aclass108[])
    {
        try {
	    	CLASS167.MF_CLASS167_b635("MapScreen", "WriteMeasurementProtobufferFileTask.doInBackground, calling measurementToXMLFileIncremental");
	        Measurement class108 = aclass108[0];
	        File file = MapScreen.MF_CLASS108_i455(MF_CLASS113_a486).measurementToProtoBufferFileIncrementalWithWifi(class108);
	        MeasurementDataSource.markMeasurementWrittenToFile(class108);
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("WriteMeasurementProtobufferFileTask.doInBackground: wrote file ").append(file.getName()).append(" length = ").append(file.length()).toString());
	        synchronized(MF_CLASS113_a486.mFilesBeingWritten)
	        {
//	            MF_CLASS113_a486.mFilesBeingWritten;
	            MF_CLASS113_a486.mFilesBeingWritten = Integer.valueOf(-1 + MF_CLASS113_a486.mFilesBeingWritten.intValue());
	        }

        } catch(Exception exception) {
	        CLASS167.unhandledexception(exception, MF_CLASS113_a486.mMe.getApplicationContext());
	        synchronized(MF_CLASS113_a486.mFilesBeingWritten)
	        {
//	            MF_CLASS113_a486.mFilesBeingWritten;
	            MF_CLASS113_a486.mFilesBeingWritten = Integer.valueOf(-1 + MF_CLASS113_a486.mFilesBeingWritten.intValue());
	        }
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }


        CLASS75.MF_CLASS75_a259(4, "PATH_RECORDED", RestClient.class, (new StringBuilder()).append("WriteMeasurementProtobufferFileTask: file writing done, mSequenceCount = ").append(MapScreen.ae(MF_CLASS113_a486)).toString());
        return null;
    }

    protected void MF_CLASS113_a486(Void void1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "WriteMeasurementProtobufferFileTask.onPostExecute");
        Integer integer = MF_CLASS113_a486.mFilesBeingWritten;

        try {
	        if(MapScreen.ab(MF_CLASS113_a486) != null)
	        {
	            if(MF_CLASS113_a486.mFilesBeingWritten.intValue() <= 0) {
	                MapScreen.ac(MF_CLASS113_a486);
	                MapScreen.ad(MF_CLASS113_a486);
	            } else {
	            	MapScreen.sUpdateCancellableWaitDialog(MF_CLASS113_a486, (new StringBuilder()).append("Preparing data, please wait...\n\n").append(MF_CLASS113_a486.mFilesBeingWritten).append(" items to be processed.").toString());
	            }
	        }
        } catch(Exception exception) {
	        exception.printStackTrace();
        }

        MF_CLASS113_a486.setDebugMessage((new StringBuilder()).append("File writing done. Total files being written = ").append(MF_CLASS113_a486.mFilesBeingWritten).toString());
        return;

    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS113_a486((Measurement[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS113_a486((Void)obj);
    }

    protected void onPreExecute()
    {
        try {
	    	synchronized(MF_CLASS113_a486.mFilesBeingWritten)
	        {
	//            MF_CLASS113_a486.mFilesBeingWritten;
	            MF_CLASS113_a486.mFilesBeingWritten = Integer.valueOf(1 + MF_CLASS113_a486.mFilesBeingWritten.intValue());
	            MapScreen.sUpdateCancellableWaitDialog(MF_CLASS113_a486, (new StringBuilder()).append("Preparing data, please wait...\n\n").append(MF_CLASS113_a486.mFilesBeingWritten).append(" items to be processed.").toString());
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "WriteMeasurementProtobufferFileTask.onPreExecute, showing progressdialog");
	        MF_CLASS113_a486.setDebugMessage((new StringBuilder()).append("String to write file. Total files being written = ").append(MF_CLASS113_a486.mFilesBeingWritten).toString());
	        return;
        } catch(Exception exception){
        	exception.printStackTrace();
        }
    }

    final MapScreen MF_CLASS113_a486;
}
