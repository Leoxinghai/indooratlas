// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.task;

import com.indooratlas.base.CLASS3;
import com.indooratlas.sensor.SensorReader;

// Referenced classes of package com.indooratlas.task:
//            RemoteImplementation

class CLASS52
    implements Runnable
{

    CLASS52(RemoteImplementation class50)
    {
    	mRemoteImpl = class50;

    }

    public void run()
    {
        try {
	    	if(RemoteImplementation.getSensorReader(mRemoteImpl) != null)
	            RemoteImplementation.getSensorReader(mRemoteImpl).setUseNanoTime(false);
	        RemoteImplementation.getIndoorAltas(mRemoteImpl).onCalibrationReady();
	        RemoteImplementation.MF_CLASS19_a67(mRemoteImpl, true);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

    final RemoteImplementation mRemoteImpl;
}
