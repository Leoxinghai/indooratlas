// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;


// Referenced classes of package com.indooratlas.sensor:
//            CLASS373, CLASS372

class CLASS374
{

    public CLASS374(SensorEventProcessor class372, CLASS373 class373, long l, long l1)
    {
    	mSensorEventProcessor = class372;

        MF_CLASS374_a1042 = class373;
        MF_CLASS374_b1043 = l;
        MF_CLASS374_c1044 = l1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(MF_CLASS374_a1042).append(", ").append(MF_CLASS374_b1043).append(", ").append(MF_CLASS374_c1044).toString();
    }

    public CLASS373 MF_CLASS374_a1042;
    public long MF_CLASS374_b1043;
    public long MF_CLASS374_c1044;
    final SensorEventProcessor mSensorEventProcessor;
}
