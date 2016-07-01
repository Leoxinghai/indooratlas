// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.algorithm;


// Referenced classes of package com.indooratlas.algorithm:
//            cpa

public class CLASS7
{

    public CLASS7()
    {
        MF_CLASS7_b14 = false;
        MF_CLASS7_a13();
        MF_CLASS7_a13 = cpa.MF_null_a15();
    }

    public void MF_CLASS7_a13()
    {
        if(MF_CLASS7_a13 == 0L)
        {
            return;
        } else
        {
            cpa.MF_null_a15(MF_CLASS7_a13);
            MF_CLASS7_a13 = 0L;
            return;
        }
    }

    public void MF_CLASS7_a13(long l, double d, double d1, double d2)
    {
        if(MF_CLASS7_a13 == 0L)
            return;
        if(MF_CLASS7_b14)
        {
            cpa.addMagnetometerSample(MF_CLASS7_a13, (long)(80000000D + (double)l), d, d1, d2);
            return;
        } else
        {
            cpa.addMagnetometerSample(MF_CLASS7_a13, l, d, d1, d2);
            return;
        }
    }

    public void MF_CLASS7_b14(long l, double d, double d1, double d2)
    {
        if(MF_CLASS7_a13 == 0L)
        {
            return;
        } else
        {
            cpa.addGyroscopeSample(MF_CLASS7_a13, l, d, d1, d2);
            return;
        }
    }

    public double[] getCalibration()
    {
        if(MF_CLASS7_a13 == 0L)
            return (new double[] {
                0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D
            });
        else
            return cpa.getCalibration(MF_CLASS7_a13);
    }

    protected void finalize()
    {
        MF_CLASS7_a13();
    }

    private long MF_CLASS7_a13;
    private boolean MF_CLASS7_b14;
}
