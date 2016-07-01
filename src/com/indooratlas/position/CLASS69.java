// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.position;

import java.util.LinkedList;

public class CLASS69 extends LinkedList
{

    public CLASS69(int i)
    {
        MF_CLASS69_a231 = i;
    }

    public boolean add(Object obj)
    {
        add(obj);
        for(; size() > MF_CLASS69_a231; remove());
        return true;
    }

    private static final long serialVersionUID = 0xd3ec9dea6b52e461L;
    private int MF_CLASS69_a231;
}
