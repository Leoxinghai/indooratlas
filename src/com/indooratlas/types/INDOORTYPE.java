// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.types;


public enum INDOORTYPE
{
	IDLE("IDLE", 0),
	ONGOING("ONGOING", 1),
	RESTARTED("RESTARTED", 2),
    WAITINGCALIBRATION("WAITING_FOR_ANDROID_INTERNAL_CALIBRATION", 3);
    String sType;
    int iType;
    
    private INDOORTYPE(String s, int i)
    {
        sType = s;
        iType = i;
    }

    private static final INDOORTYPE mIndoorTypss[];

    static 
    {
        INDOORTYPE aindoortype[] = new INDOORTYPE[4];
        aindoortype[0] = IDLE;
        aindoortype[1] = ONGOING;
        aindoortype[2] = RESTARTED;
        aindoortype[3] = WAITINGCALIBRATION;
        mIndoorTypss = aindoortype;
    }
}
