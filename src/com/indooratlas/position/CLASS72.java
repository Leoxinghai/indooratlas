// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.position;


public class CLASS72
{

    public static double MF_CLASS72_a237(double d)
    {
        double d1;
        for(d1 = d; d1 > 3.1415926535897931D; d1 -= 6.2831853071795862D);
        for(; d1 < -3.1415926535897931D; d1 += 6.2831853071795862D);
        return d1;
    }

    public static float MF_CLASS72_a237(float f, float f1, float f2, float f3)
    {
        return (float)Math.atan2(f2 - f3, f - f1);
    }

    public static long MF_CLASS72_a237(long al[])
    {
        long l = 0x7fffffffffffffffL;
        int i = al.length;
        int j = 0;
        while(j < i) 
        {
            long l1 = al[j];
            if(l1 >= l)
                l1 = l;
            j++;
            l = l1;
        }
        return l;
    }
}
