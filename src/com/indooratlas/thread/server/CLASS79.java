// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.thread.server;

import java.util.Comparator;

final class CLASS79
    implements Comparator
{

    CLASS79()
    {
    }

    public int MF_CLASS79_a308(Integer integer, Integer integer1)
    {
        return integer.compareTo(integer1);
    }

    public int compare(Object obj, Object obj1)
    {
        return MF_CLASS79_a308((Integer)obj, (Integer)obj1);
    }
}
