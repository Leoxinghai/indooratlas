// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.sensor;

import java.text.NumberFormat;
import java.util.Locale;

public class CLASS375
    implements Cloneable
{

    public CLASS375(int i)
    {
    	eventData = new double[i];
    }

    public CLASS375(CLASS375 class375)
    {
    	eventData = (double[])class375.eventData.clone();
    	mTimeStamp = class375.mTimeStamp;
        MF_CLASS375_b1046 = class375.MF_CLASS375_b1046;
        MF_CLASS375_c1047 = class375.MF_CLASS375_c1047;
    }

    public static String MF_CLASS375_a1045(CLASS375 class375)
    {
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append(class375.getTimeStamp()).append(", ").append(", type = ").append(class375.mSensorType).append(", ").toString());
        for(int i = 0; i < class375.getEventData().length; i++)
        {
            MF_CLASS375_f1050.setMinimumFractionDigits(2);
            MF_CLASS375_f1050.setMaximumFractionDigits(2);
            String s = MF_CLASS375_f1050.format(class375.getEventData()[i]);
            stringbuilder.append((new StringBuilder()).append(s).append(" ").toString());
        }

        return stringbuilder.toString();
    }

    public long getTimeStamp()
    {
        return mTimeStamp;
    }

    public void MF_CLASS375_a1045(double d)
    {
        MF_CLASS375_c1047 = d;
    }

    public void setSensorType(int i)
    {
    	//System.out.println("setSensorType." + i);
    	mSensorType = i;
    }

    public void setTimeStamp(long l)
    {
    	mTimeStamp = l;
    }

    public double[] getEventData()
    {
        return eventData;
    }

    public CLASS375 MF_CLASS375_c1047()
    {
        return new CLASS375(this);
    }

    public Object clone()
    {
        return MF_CLASS375_c1047();
    }

    public double MF_CLASS375_d1048()
    {
        return MF_CLASS375_c1047;
    }

    public int getSensorType()
    {
        return mSensorType;
    }

    public String toString()
    {
        return MF_CLASS375_a1045(this);
    }

    private static NumberFormat MF_CLASS375_f1050;
    public long mTimeStamp;
    public String MF_CLASS375_b1046;
    public double MF_CLASS375_c1047;
    public double eventData[];
    protected int mSensorType;

    static 
    {
        MF_CLASS375_f1050 = NumberFormat.getInstance(Locale.US);
    }
}
