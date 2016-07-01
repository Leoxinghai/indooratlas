// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.socket;


public enum CLASS398 
{
    MF_CLASS398_a1164("NONE", 0),
    MF_CLASS398_b1165("ONEWAY", 1),
    MF_CLASS398_c1166("TWOWAY", 2);
    private String sType;
    private int iType;

    private CLASS398(String s, int i)
    {
        sType = s;
        iType = i;
    }

    private static final CLASS398 MF_CLASS398_d1167[];

    static 
    {
        CLASS398 aclass398[] = new CLASS398[3];
        aclass398[0] = MF_CLASS398_a1164;
        aclass398[1] = MF_CLASS398_b1165;
        aclass398[2] = MF_CLASS398_c1166;
        MF_CLASS398_d1167 = aclass398;
    }
}
