// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.Calibrator;

import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.Calibrator:
//            CLASS15, BGC_TYPE

public class CLASS8
{

    public CLASS8()
    {
        MF_CLASS8_a17 = null;
        MF_CLASS16_c55 = false;
        mCalibrationPercent = 0;
        MF_CLASS8_e21 = 0L;
    }

    public int getCalibrationPercent()
    {
        return mCalibrationPercent;
    }

    public void update(CLASS15 class15)
    {
        CLASS75.MF_CLASS75_b260("BackgroundCalibrationHelper", (new StringBuilder()).append("update(): called, calibrationOutcome = ").append(class15).toString());
        MF_CLASS8_a17 = class15.MF_CLASS16_b54();
        MF_CLASS16_b54 = class15.MF_CLASS16_c55();
        if(class15.getBGCState() == BGC_TYPE.BGC_READY)
        {
        	mCalibrationPercent = 100;
            MF_CLASS16_c55 = true;
            MF_CLASS8_e21 = System.currentTimeMillis();
        } else
        if(class15.getBGCState() == BGC_TYPE.BGC_FAILED)
        {
        	mCalibrationPercent = 0;
            MF_CLASS16_c55 = false;
            MF_CLASS8_e21 = 0L;
        } else
        {
        	mCalibrationPercent = class15.MF_CLASS16_d56();
            MF_CLASS16_c55 = false;
            MF_CLASS8_e21 = 0L;
        }
        CLASS75.MF_CLASS75_b260("BackgroundCalibrationHelper", (new StringBuilder()).append("update(): maxCov : ").append(MF_CLASS16_b54).append(", calibrationPercent = ").append(mCalibrationPercent).toString());
    }

    public double[] MF_CLASS16_b54()
    {
        return MF_CLASS8_a17;
    }

    public boolean MF_CLASS16_c55()
    {
        return MF_CLASS16_c55;
    }

    public long MF_CLASS8_d20()
    {
        return MF_CLASS8_e21;
    }

    private double MF_CLASS8_a17[];
    private double MF_CLASS16_b54;
    private boolean MF_CLASS16_c55;
    private int mCalibrationPercent;
    private long MF_CLASS8_e21;
}
