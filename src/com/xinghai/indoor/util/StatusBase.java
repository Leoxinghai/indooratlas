// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;


public final class StatusBase
{

    static int Status1(int i)
    {
        return i & 7;
    }

    static int Status1(int i, int j)
    {
        return j | i << 3;
    }

    public static int Status2(int i)
    {
        return i >>> 3;
    }

    static final int Status1 = Status1(1, 3);
    static final int Status2 = Status1(1, 4);
    static final int Status3 = Status1(2, 0);
    static final int Status4 = Status1(3, 2);

}
