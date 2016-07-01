// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.task;


public enum CLASS59 
{
	CLOSED("CLOSED", 0),
	INITIALIZED("INITIALIZED", 1),
	ACTIVE("ACTIVE", 2),
	RECONNECTING("RECONNECTING", 3);
    private String sType;
    private int iType;
    private CLASS59(String s, int i)
    {
    	sType = s;
    	iType = i;
    }

    private static final CLASS59 MF_CLASS59_e215[];

    static 
    {
        CLASS59 aclass59[] = new CLASS59[4];
        aclass59[0] = CLOSED;
        aclass59[1] = INITIALIZED;
        aclass59[2] = ACTIVE;
        aclass59[3] = RECONNECTING;
        MF_CLASS59_e215 = aclass59;
    }
}
