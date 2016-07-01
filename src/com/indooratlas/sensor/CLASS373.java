// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.sensor;


public enum CLASS373 
{
	MGNACC("MGNACC", 0),
	MGNGYR("MGNGYR", 1),
	ACCGYR("ACCGYR", 2),
	NONE("NONE", 3);
    
    private String sType;
    private int iType;

    private CLASS373(String s, int i)
    {
        sType = s;
        iType = i;
        
    }

    private static final CLASS373 MF_CLASS373_e1040[];

    static 
    {
        CLASS373 aclass373[] = new CLASS373[4];
        aclass373[0] = MGNACC;
        aclass373[1] = MGNGYR;
        aclass373[2] = ACCGYR;
        aclass373[3] = NONE;
        MF_CLASS373_e1040 = aclass373;
    }
}
