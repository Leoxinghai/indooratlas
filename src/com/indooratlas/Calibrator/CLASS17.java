// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.Calibrator;


public enum CLASS17 
{
	BACKGROUND("BACKGROUND", 0),
	FORCED("FORCED", 1);

    private CLASS17(String s, int i)
    {
        sType = s;
        iType = i;
    }
    private String sType;
    private int iType;

    private static final CLASS17 MF_CLASS17_c60[];

    static 
    {
        CLASS17 aclass17[] = new CLASS17[2];
        aclass17[0] = BACKGROUND;
        aclass17[1] = FORCED;
        MF_CLASS17_c60 = aclass17;
    }
}
