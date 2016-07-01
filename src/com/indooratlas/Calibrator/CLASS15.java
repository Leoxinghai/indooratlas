// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.Calibrator;

import android.database.Cursor;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.Calibrator:
//            BGC_TYPE, CLASS17

public class CLASS15
{

    public CLASS15()
    {
        MF_CLASS16_b54 = 0L;
        MF_CLASS16_c55 = 0L;
        MF_CLASS17_a58 = "";
        MF_CLASS15_e49 = new double[3];
        mReadyStatus = BGC_TYPE.BGC_IN_PROGRESS;
    }

    public CLASS15(String s, double ad[], double d, double d1, CLASS17 class17, 
            BGC_TYPE class16)
    {
        MF_CLASS16_b54 = 0L;
        MF_CLASS16_c55 = 0L;
        MF_CLASS17_a58 = "";
        MF_CLASS15_e49 = new double[3];
        mReadyStatus = BGC_TYPE.BGC_IN_PROGRESS;
        MF_CLASS17_a58 = s;
        MF_CLASS15_e49 = ad;
        MF_CLASS15_f50 = d;
        MF_CLASS15_g51 = d1;
        MF_CLASS16_d56 = class17;
        mReadyStatus = class16;
    }

    public static CLASS15 createBGCalibration(Cursor cursor)
    {
        CLASS15 class15 = new CLASS15();
        class15.MF_CLASS16_b54 = cursor.getLong(0);
        class15.MF_CLASS15_e49[0] = cursor.getDouble(1);
        class15.MF_CLASS15_e49[1] = cursor.getDouble(2);
        class15.MF_CLASS15_e49[2] = cursor.getDouble(3);
        class15.MF_CLASS15_f50 = cursor.getDouble(4);
        class15.MF_CLASS16_c55 = cursor.getLong(5);
        switch(cursor.getInt(6))
        {
        default:
            return class15;

        case 0: // '\0'
            class15.MF_CLASS16_d56 = CLASS17.BACKGROUND;
            return class15;

        case 1: // '\001'
            class15.MF_CLASS16_d56 = CLASS17.FORCED;
            break;
        }
        return class15;
    }

    public static BGC_TYPE MF_CLASS17_a58(int i)
    {
        BGC_TYPE class16 = BGC_TYPE.BGC_IN_PROGRESS;
        switch(i)
        {
        default:
            return class16;

        case 0: // '\0'
            return BGC_TYPE.BGC_IN_PROGRESS;

        case 1: // '\001'
            return BGC_TYPE.BGC_FAILED;

        case 2: // '\002'
            return BGC_TYPE.BGC_READY;

        case 3: // '\003'
            return BGC_TYPE.BGC_CONVERGED;
        }
    }

    public String MF_CLASS17_a58()
    {
        return MF_CLASS17_a58;
    }

    public void MF_CLASS17_a58(long l)
    {
        MF_CLASS16_b54 = l;
    }

    public void MF_CLASS16_b54(long l)
    {
        MF_CLASS16_c55 = l;
    }

    public double[] MF_CLASS16_b54()
    {
        return MF_CLASS15_e49;
    }

    public double MF_CLASS16_c55()
    {
        return MF_CLASS15_f50;
    }

    public int MF_CLASS16_d56()
    {
        int i = Double.valueOf(100D * MF_CLASS15_g51).intValue();
        CLASS75.MF_CLASS75_b260("CalibrationOutcome", (new StringBuilder()).append("progress: ").append(MF_CLASS15_g51).toString());
        CLASS75.MF_CLASS75_b260("CalibrationOutcome", (new StringBuilder()).append("percentage: ").append(i).toString());
        if(i > 100)
            return 100;
        if(i < 0)
            return 0;
        else
            return i;
    }

    public long MF_CLASS15_e49()
    {
        return MF_CLASS16_b54;
    }

    public long MF_CLASS15_f50()
    {
        return MF_CLASS16_c55;
    }

    public BGC_TYPE getBGCState()
    {
        return mReadyStatus;
    }

    public CLASS17 MF_CLASS15_h52()
    {
        return MF_CLASS16_d56;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append("readyStatus: ").append(mReadyStatus).toString()).append(", ");
        stringbuilder.append((new StringBuilder()).append("ts : ").append(MF_CLASS16_c55).toString()).append((new StringBuilder()).append(", id : ").append(MF_CLASS16_b54).toString()).append((new StringBuilder()).append(", calibrationType = ").append(MF_CLASS16_d56.ordinal()).toString());
        stringbuilder.append(", bias :");
        if(MF_CLASS15_e49 != null)
        {
            stringbuilder.append(",").append(MF_CLASS15_e49[0]);
            stringbuilder.append(",").append(MF_CLASS15_e49[1]);
            stringbuilder.append(",").append(MF_CLASS15_e49[2]);
        }
        stringbuilder.append(", cov :");
        stringbuilder.append(",").append(MF_CLASS15_f50);
        return stringbuilder.toString();
    }

    String MF_CLASS17_a58;
    private long MF_CLASS16_b54;
    private long MF_CLASS16_c55;
    private CLASS17 MF_CLASS16_d56;
    private double MF_CLASS15_e49[];
    private double MF_CLASS15_f50;
    private double MF_CLASS15_g51;
    private BGC_TYPE mReadyStatus;
}
