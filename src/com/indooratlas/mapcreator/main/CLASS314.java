// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


public enum CLASS314
{
	SEGMENT_DATA("SEGMENT_DATA", 0),
	TEST_DATA("TEST_DATA", 1);
    String sType;
    int iType;
    
    private CLASS314(String s, int i)
    {
        sType = s;
        iType = i;
    }


    private static final CLASS314 MF_CLASS314_c892[];

    static 
    {
        CLASS314 aclass314[] = new CLASS314[2];
        aclass314[0] = SEGMENT_DATA;
        aclass314[1] = TEST_DATA;
        MF_CLASS314_c892 = aclass314;
    }
}
