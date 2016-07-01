// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;

import android.hardware.*;
import com.indooratlas.position.CLASS75;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.sensor:
//            CLASS376

class SensorObserver
    implements SensorEventListener
{

    public SensorObserver(SensorReader class376)
    {
        MF_CLASS377_a1103 = class376;

        CLASS75.MF_CLASS75_b260("SensorReader", "SensorObserver created");
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        long l;
        CLASS375 class375;
        if(SensorReader.MF_CLASS375_a1045(MF_CLASS377_a1103))
            l = System.nanoTime();
        else
            l = sensorevent.timestamp;
        class375 = SensorReader.paseSensorEvent0(MF_CLASS377_a1103, sensorevent, l);
        synchronized(SensorReader.MF_CLASS369_b995(MF_CLASS377_a1103))
        {
        	SensorReader.MF_CLASS369_b995(MF_CLASS377_a1103).add(class375);
        	SensorReader.MF_CLASS369_b995(MF_CLASS377_a1103).notify();
        }
        return;
    }

    final SensorReader MF_CLASS377_a1103;
}
