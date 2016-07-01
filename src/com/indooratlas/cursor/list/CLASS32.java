// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS27

public class CLASS32 extends CLASS27
{

    public CLASS32()
    {
        super(0.0F, 0L);
        MF_CLASS32_a132 = -1L;
        MF_CLASS32_b133 = -1L;
        MF_CLASS32_c134 = 0;
    }

    public CLASS32(float f, long l)
    {
        super(f, l);
        MF_CLASS32_a132 = -1L;
        MF_CLASS32_b133 = -1L;
        MF_CLASS32_c134 = 0;
    }

    public static CLASS32 getTemperatureDataFromDB(Cursor cursor)
    {
        CLASS32 class32 = new CLASS32();
        class32.MF_CLASS32_a132 = cursor.getLong(0);
        class32.MF_CLASS32_b133 = cursor.getLong(1);
        class32.PressureTimestamp = cursor.getLong(2);
        class32.Pressure = cursor.getFloat(3);
        class32.MF_CLASS32_c134 = cursor.getInt(4);
        return class32;
    }

    public long MF_CLASS32_a132;
    public long MF_CLASS32_b133;
    public int MF_CLASS32_c134;
}
