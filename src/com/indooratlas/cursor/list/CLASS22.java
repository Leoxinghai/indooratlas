// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;


public class CLASS22
{

    public CLASS22(float f, float f1, float f2, long l, float f3)
    {

        AccelerometerX = f;
        AccelerometerY = f1;
        AccelerometerZ = f2;
        timeStamp = l;
        Accuracy = f3;
    }

    public CLASS22(CLASS22 class22)
    {

        AccelerometerX = class22.AccelerometerX;
        AccelerometerY = class22.AccelerometerY;
        AccelerometerZ = class22.AccelerometerZ;
        timeStamp = class22.timeStamp;
        Accuracy = class22.Accuracy;
    }

    public float AccelerometerX;
    public float AccelerometerY;
    public float AccelerometerZ;
    public long timeStamp;
    public float Accuracy;
}
