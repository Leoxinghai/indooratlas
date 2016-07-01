// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS27

public class CLASS31 extends CLASS27
{

    public CLASS31()
    {
        super(0.0F, 0L);
        MF_CLASS31_a127 = -1L;
        MF_CLASS31_b128 = -1L;
        MF_CLASS31_c129 = 0;
    }

    public CLASS31(float f, long l)
    {
        super(f, l);
        MF_CLASS31_a127 = -1L;
        MF_CLASS31_b128 = -1L;
        MF_CLASS31_c129 = 0;
    }

    public static CLASS31 getProximityDatafromDB(Cursor cursor)
    {
        CLASS31 class31 = new CLASS31();
        class31.MF_CLASS31_a127 = cursor.getLong(0);
        class31.MF_CLASS31_b128 = cursor.getLong(1);
        class31.PressureTimestamp = cursor.getLong(2);
        class31.Pressure = cursor.getFloat(3);
        class31.MF_CLASS31_c129 = cursor.getInt(4);
        return class31;
    }

    public long MF_CLASS31_a127;
    public long MF_CLASS31_b128;
    public int MF_CLASS31_c129;
}
