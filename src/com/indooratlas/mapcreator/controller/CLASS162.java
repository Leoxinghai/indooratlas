// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.controller;

import android.hardware.*;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS167, SensorController

class CLASS162
    implements SensorEventListener
{

    CLASS162(SensorController class159)
    {
    	mSensorController = class159;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
        CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("onAccuracyChanged: sensor = ").append(sensor.getName()).append(", accuracy = ").append(i).toString());
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        try {
        	ConcurrentLinkedQueue concurrentlinkedqueue = SensorController.sGetSensorDataQueue(mSensorController);
	    	synchronized(concurrentlinkedqueue) {
		        long l;
		        if(!mSensorController.MF_CLASS159_ai614)
		        	l = sensorevent.timestamp;
		        else
		        	l = System.nanoTime();
		
		        SensorController class159 = mSensorController;
		        class159.MF_CLASS158_g566 = 1 + class159.MF_CLASS158_g566;
		        com.indooratlas.sensor.CLASS375 class375 = SensorController.MF_CLASS158_a563(mSensorController, sensorevent, l);
		        if(!SensorController.MF_CLASS113_b487(mSensorController) && mSensorController.mSensorEventProcessor != null)
		        {
		        	concurrentlinkedqueue.add(class375);
		        	concurrentlinkedqueue.notify();
		        }
		        return;
	    	}
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }

    final SensorController mSensorController;
}
