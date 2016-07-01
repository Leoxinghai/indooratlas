// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.sensor;

import android.database.Cursor;

//Calibration
public class CLASS370
{

    public CLASS370()
    {
    	mMeasurementID = -1L;
    	SentToServer = 0L;
    	WrittenToFile = 0L;
        StartTimestampMS = 0L;
        EndTimestampMS = 0L;
        Latitude = 0.0D;
        Longitude = 0.0D;
        Altitude = 0.0D;
    }

    public CLASS370(long l, double d, double d1, double d2)
    {
    	mMeasurementID = -1L;
    	SentToServer = 0L;
    	WrittenToFile = 0L;
        EndTimestampMS = 0L;
        StartTimestampMS = l;
        Latitude = d;
        Longitude = d1;
        Altitude = d2;
    }

    public static CLASS370 getCalibrationSetsfromDB(Cursor cursor)
    {
        CLASS370 class370 = new CLASS370();
        class370.mMeasurementID = cursor.getLong(0);
        class370.SentToServer = cursor.getLong(1);
        class370.WrittenToFile = cursor.getLong(2);
        class370.StartTimestampMS = cursor.getLong(3);
        class370.EndTimestampMS = cursor.getLong(4);
        class370.Latitude = cursor.getDouble(5);
        class370.Longitude = cursor.getDouble(6);
        class370.Altitude = cursor.getDouble(7);
        return class370;
    }

    public long mMeasurementID;
    public long SentToServer;
    public long WrittenToFile;
    public long StartTimestampMS;
    public long EndTimestampMS;
    public double Latitude;
    public double Longitude;
    public double Altitude;
}
