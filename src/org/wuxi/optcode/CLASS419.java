// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.optcode;


public enum CLASS419
{
	CONTINUOUS("CONTINUOUS", 0),
	TEXT("TEXT", 1),
	BINARY("BINARY", 2),
	PING("PING", 3),
	PONG("PONG", 4),
	CLOSING("CLOSING", 5);
    
    private String sType;
    private int iType;
    
    private CLASS419(String s, int i)
    {
        sType = s;
        iType = i;
    }

    private static final CLASS419 MF_CLASS419_g1241[];

    static 
    {
        CLASS419 aclass419[] = new CLASS419[6];
        aclass419[0] = CONTINUOUS;
        aclass419[1] = TEXT;
        aclass419[2] = BINARY;
        aclass419[3] = PING;
        aclass419[4] = PONG;
        aclass419[5] = CLOSING;
        MF_CLASS419_g1241 = aclass419;
    }
}
