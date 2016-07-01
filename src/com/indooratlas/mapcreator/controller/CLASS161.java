// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            SensorController, CLASS167, CLASS179, CLASS113

class CLASS161 extends AsyncTask
{

    public CLASS161(SensorController class159, int i)
    {
        super();
    	MF_CLASS113_a486 = class159;
        MF_CLASS161_b622 = 0;
        MF_CLASS161_b622 = i;
    }

    protected Void MF_CLASS113_a486(Object aobj[][])
    {
        boolean flag;
        int i;
        flag = false;
        i = 0;
        boolean flag2;
        int j;
        int k=0;
        AsyncTask asynctask;

        try {
	        if(MF_CLASS161_b622 == 0 || SensorController.MF_CLASS375_c1047(MF_CLASS113_a486).size() <= 0) {
	                asynctask = null;
	        } else {
	        	asynctask = (AsyncTask)SensorController.MF_CLASS375_c1047(MF_CLASS113_a486).get(-1 + MF_CLASS161_b622);
	        }
	
	        if(asynctask != null) {
	        	while(asynctask.getStatus() != android.os.AsyncTask.Status.FINISHED) {
	        	        k = i + 1;
	        	        try {
	        	        	Thread.sleep(50L);
	        	        } catch(Exception ex) {
	        	        	ex.printStackTrace();
	        	        }
	        	        boolean flag4 = flag;
	        	        j = k;
	        	        flag2 = flag4;
	        	}
	        }
	
	        Object aobj1[];
	        Integer integer;
	        long l;
	        boolean flag1;
	        long l1;
	        aobj1 = aobj[0];
	        integer = (Integer)aobj1[0];
	        l = ((Long)aobj1[2]).longValue();
	        flag1 = ((Boolean)aobj1[3]).booleanValue();
	        l1 = System.nanoTime();
	        switch(integer.intValue()) {
			default:
			case 3:
			case 7:
			case 9:
			case 10:
			case 12:
			        break; /* Loop/switch isn't completed */
			case 4:
					try {
			        MeasurementDataSource.storeGyroSensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			
					} catch(Exception exception) {
						exception.printStackTrace();
						CLASS167.unhandledexception(exception, MF_CLASS113_a486.mMapScreen);
						return null;
					}
			case 1:
			        MeasurementDataSource.storeAccSensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			       break;
			case 2:
			        MeasurementDataSource.storeMgnSensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			        break;
			case 6:
			        MeasurementDataSource.storePressureSensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			        break;
			case 5:
			        MeasurementDataSource.storeLightSensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			        break;
			case 8:
			        MeasurementDataSource.storeProximitySensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			        break;
			case 13:
			        MeasurementDataSource.storeTemperatureSensorData((ConcurrentLinkedQueue)aobj1[1], l, flag1);
			        break;
	        }
	        double d = (double)(System.nanoTime() - l1) / 1000000000D;
	        CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("InsertDataTask: insert took ").append(d).append("s").toString());
	        flag2 = true;
	        j = i;

        } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        boolean flag3 = flag;
	        j = k;
	        flag2 = flag3;
        }

        i = j;
        flag = flag2;
        return null;
    }

    protected void MF_CLASS113_a486(Void void1)
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS113_a486((Object[][])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS113_a486((Void)obj);
    }

    protected void onPreExecute()
    {
    }

    final SensorController MF_CLASS113_a486;
    private int MF_CLASS161_b622;
}
