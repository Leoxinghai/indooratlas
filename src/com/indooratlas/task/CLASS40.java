// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.task;

import com.indooratlas.types.INDOORTYPE;
import com.indooratlas.types.Some1Base;

public class CLASS40
    implements Some1Base
{

    public CLASS40(INDOORTYPE indoortype, float f)
    {
        mPercentage = f;
        mIndoorAction = indoortype;
    }

    public float actionPercentage()
    {
        return mPercentage;
    }

    public INDOORTYPE getIndoorAction()
    {
        return mIndoorAction;
    }

    private float mPercentage;
    private INDOORTYPE mIndoorAction;
}
