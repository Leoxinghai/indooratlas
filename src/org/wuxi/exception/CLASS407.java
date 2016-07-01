// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.exception;


public class CLASS407 extends Exception
{

    public CLASS407(int i)
    {
        MF_CLASS407_a1211 = i;
    }

    public CLASS407(int i, String s)
    {
        super(s);
        MF_CLASS407_a1211 = i;
    }

    public CLASS407(int i, Throwable throwable)
    {
        super(throwable);
        MF_CLASS407_a1211 = i;
    }

    public int MF_CLASS407_a1211()
    {
        return MF_CLASS407_a1211;
    }

    private static final long serialVersionUID = 0x33ca2ae9af8edac6L;
    private int MF_CLASS407_a1211;
}
