// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.sensor.type;

//c ?

public enum CLASS369 
{
	CALIBRATING("CALIBRATING", 0),
	BGCALIBRATING("BGCALIBRATING", 1),
	POSITIONING("POSITIONING", 2),
	RECORDING_PATH("RECORDING_PATH", 3);

    private CLASS369(String s, int i)
    {
        sType = s;
        iType = i;
    }
    private String sType;
    private int iType;


    private static final CLASS369 MF_CLASS369_e998[];

    static 
    {
        CLASS369 aclass369[] = new CLASS369[4];
        aclass369[0] = CALIBRATING;
        aclass369[1] = BGCALIBRATING;
        aclass369[2] = POSITIONING;
        aclass369[3] = RECORDING_PATH;
        MF_CLASS369_e998 = aclass369;
    }
}
