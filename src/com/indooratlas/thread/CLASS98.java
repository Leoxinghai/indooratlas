// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.thread;

import com.indooratlas.base.CLASS4;
import com.indooratlas.base.CLASS6;
import com.indooratlas.position.CLASS72;
import com.indooratlas.task.CLASS44;
import com.indooratlas.task.CLASS45;
import com.indooratlas.types.Some2Base;

public class CLASS98
    implements CLASS6
{

    public CLASS98(long l, int i, double d, double d1, 
            double d2, double d3, double d4, double d5, float f, float f1)
    {
        MF_CLASS98_a360 = 0;
        MF_CLASS98_b361 = 0;
        MF_CLASS98_c362 = 0;
        MF_CLASS98_e364 = 0.0D;
        MF_CLASS98_f365 = 0.0D;
        MF_CLASS98_g366 = 0.0D;
        MF_CLASS98_h367 = 0.0D;
        MF_CLASS98_i368 = 0.0F;
        MF_CLASS98_j369 = -1F;
        MF_CLASS98_d363 = l;
        MF_CLASS98_a360 = i;
        MF_CLASS98_j369 = f1;
        MF_CLASS98_e364 = d;
        MF_CLASS98_f365 = d1;
        MF_CLASS98_b361 = (int)d2;
        MF_CLASS98_c362 = (int)d3;
        MF_CLASS98_g366 = d4;
        MF_CLASS98_h367 = d5;
        MF_CLASS98_i368 = f;
    }

    public Some2Base MF_CLASS6_a7()
    {
        return MF_CLASS98_g366();
    }

    public CLASS4 MF_CLASS6_b8()
    {
        return MF_CLASS98_h367();
    }

    public double MF_CLASS6_c9()
    {
        double d = Math.toDegrees(CLASS72.MF_CLASS72_a237(MF_CLASS98_i368));
        if(d < 0.0D)
            d += 360D;
        return d;
    }

    public double MF_CLASS6_d10()
    {
        return (double)MF_CLASS98_j369;
    }

    public long MF_CLASS6_e11()
    {
        return MF_CLASS98_d363;
    }

    public int MF_CLASS6_f12()
    {
        return MF_CLASS98_a360;
    }

    public CLASS44 MF_CLASS98_g366()
    {
        return new CLASS44(MF_CLASS98_b361, MF_CLASS98_c362);
    }

    public CLASS45 MF_CLASS98_h367()
    {
        return new CLASS45((float)MF_CLASS98_g366, (float)MF_CLASS98_h367);
    }

    private int MF_CLASS98_a360;
    private int MF_CLASS98_b361;
    private int MF_CLASS98_c362;
    private long MF_CLASS98_d363;
    private double MF_CLASS98_e364;
    private double MF_CLASS98_f365;
    private double MF_CLASS98_g366;
    private double MF_CLASS98_h367;
    private float MF_CLASS98_i368;
    private float MF_CLASS98_j369;
}
