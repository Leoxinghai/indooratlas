// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.Calibrator;


public enum CLASS19 
{
	IN_PROGRESS("IN_PROGRESS", 0),
	FAILED("FAILED", 1),
	READY("READY", 2),
	DISCARDING("DISCARDING", 3),
	WAITING("WAITING_FOR_ANDROID_INTERNAL_CALIBRATION", 4);

    private CLASS19(String s, int i)
    {
    	sType = s;
    	iType = i;
    }

    private String sType;
    private int iType;
    
    private static final CLASS19 MF_CLASS19_f72[];

    static 
    {
        CLASS19 aclass19[] = new CLASS19[5];
        aclass19[0] = IN_PROGRESS;
        aclass19[1] = FAILED;
        aclass19[2] = READY;
        aclass19[3] = DISCARDING;
        aclass19[4] = WAITING;
        MF_CLASS19_f72 = aclass19;
    }
}
