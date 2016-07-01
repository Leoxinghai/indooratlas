// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.CLASS100;
import com.indooratlas.mapcreator.data.CLASS101;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.CLASS370;
import java.io.File;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

public class CLASS318 extends AsyncTask
{

    public CLASS318(MapScreen mapscreen)
    {
        super();
        MF_CLASS113_a486 = mapscreen;
    }

    protected Void MF_CLASS113_a486(CLASS370 aclass370[])
    {
    	try {
	    	CLASS167.MF_CLASS167_b635("MapScreen", "WriteCalibrationSetProtobufferFileTask.doInBackground, calling calibrationSetToProtoBufferFileIncremental()");
	        CLASS370 class370 = aclass370[0];
	        CLASS167.MF_CLASS167_b635("MapScreen", "WriteCalibrationSetProtobufferFileTask.doInBackground: DB inserts done, going to write protobuf file");
	        File file = RestClient.calibrationSetToProtoBufferFileIncremental(class370, MF_CLASS113_a486.mMe, MF_CLASS113_a486.mApiKey, MF_CLASS113_a486.mDeviceModel.MF_CLASS101_a388(), MF_CLASS113_a486.mDevice.MF_CLASS100_b387);
	        MeasurementDataSource.markCalibrationSetWrittenToFile(class370);

	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("WriteCalibrationSetProtobufferFileTask.doInBackground: wrote file ").append(file.getName()).append(" length = ").append(file.length()).toString());
	        CLASS75.MF_CLASS75_a259(4, "CALIBRATION_OK", RestClient.class, "WriteCalibrationSetProtobufferFileTask: file writing done.");
    	} catch(Exception exception) {
	        CLASS167.unhandledexception(exception, MF_CLASS113_a486.mMe.getApplicationContext());
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
    	}

        return null;
    }

    protected void MF_CLASS113_a486(Void void1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "WriteCalibrationSetProtobufferFileTask.onPostExecute");
    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS113_a486((CLASS370[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS113_a486((Void)obj);
    }

    protected void onPreExecute()
    {
    }

    final MapScreen MF_CLASS113_a486;
}
