// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.sensor.type;

import com.indooratlas.sensor.CLASS375;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface CLASS158
{

    public abstract void notifySensorError(int i);

    public abstract void setFirstTimeStamp(long l);

    public abstract void parseCalibrateEvent(CLASS375 class375);

    public abstract ConcurrentLinkedQueue sensorEventQueue();

    public abstract boolean MF_CLASS158_f565();

    public abstract void informTimestampError();

    public abstract void MF_CLASS158_h567();
}
