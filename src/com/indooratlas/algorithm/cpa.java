// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.algorithm;


public class cpa
{

    static long MF_null_a15()
    {
        return jnim_initializeBackgroundCalibrator();
    }

    static void MF_null_a15(long l)
    {
        jnim_disposeBackgroundCalibrator(l);
    }

    static void addMagnetometerSample(long l, long l1, double d, double d1, 
            double d2)
    {
        jnim_addMagnetometerSample(l, l1, d, d1, d2);
    }

    static void addGyroscopeSample(long l, long l1, double d, double d1, 
            double d2)
    {
        jnim_addGyroscopeSample(l, l1, d, d1, d2);
    }

    static double[] getCalibration(long l)
    {
        return jnim_getCalibration(l);
    }

    public static native double[] calibrate(double ad[], int i);

    private static native void jnim_addGyroscopeSample(long l, long l1, double d, double d1, 
            double d2);

    private static native void jnim_addMagnetometerSample(long l, long l1, double d, double d1, 
            double d2);

    private static native void jnim_disposeBackgroundCalibrator(long l);

    private static native double[] jnim_getCalibration(long l);

    private static native long jnim_initializeBackgroundCalibrator();
}
