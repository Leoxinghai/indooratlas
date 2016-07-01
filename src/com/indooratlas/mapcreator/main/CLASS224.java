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
//            LoginActivity

public class CLASS224 extends AsyncTask
{

    public CLASS224(LoginActivity loginactivity)
    {
        super();
        MF_CLASS224_a770 = loginactivity;
    }

    protected Void MF_CLASS224_a770(CLASS370 aclass370[])
    {
        try
        {
            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "WriteCalibrationSetProtobufferFileTask.doInBackground, calling calibrationSetToProtoBufferFileIncremental");
            CLASS370 class370 = aclass370[0];
            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("WriteCalibrationSetProtobufferFileTask.doInBackground: DB inserts done, going to write protobuf file, cs = ").append(class370).append(", mDeviceModel = ").append(LoginActivity.MF_CLASS19_b68(MF_CLASS224_a770)).toString());
            File file = RestClient.calibrationSetToProtoBufferFileIncremental(class370, MF_CLASS224_a770.f, MF_CLASS224_a770.m, LoginActivity.MF_CLASS19_b68(MF_CLASS224_a770).MF_CLASS101_a388(), (new CLASS100()).MF_CLASS100_b387);
            MeasurementDataSource.markCalibrationSetWrittenToFile(class370);
            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("WriteCalibrationSetProtobufferFileTask.doInBackground: wrote file ").append(file.getName()).append(" length = ").append(file.length()).toString());
            CLASS75.MF_CLASS75_a259(4, "CALIBRATION_OK", RestClient.class, "WriteCalibrationSetProtobufferFileTask: file writing done. Starting upload.");
            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "*** NOTE: CALIBRATION IS NOT POSTED --- WILL BE POSTED AT NEXT MAP DATA UPLOAD ***");
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS224_a770.f.getApplicationContext());
        }
        return null;
    }

    protected void MF_CLASS224_a770(Void void1)
    {
        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "WriteCalibrationSetProtobufferFileTask.onPostExecute");
    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS224_a770((CLASS370[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS224_a770((Void)obj);
    }

    protected void onPreExecute()
    {
    }

    final LoginActivity MF_CLASS224_a770;
}
