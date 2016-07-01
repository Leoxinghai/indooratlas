// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS27

public class CLASS30 extends CLASS27
{

    public CLASS30()
    {
        super(0.0F, 0L);
        MF_CLASS30_a122 = -1L;
        MF_CLASS30_b123 = -1L;
        MF_CLASS30_c124 = 0;
    }

    public CLASS30(float f, long l)
    {
        super(f, l);
        MF_CLASS30_a122 = -1L;
        MF_CLASS30_b123 = -1L;
        MF_CLASS30_c124 = 0;
    }

    public static CLASS30 getPressureDatafromDB(Cursor cursor)
    {
        CLASS30 class30 = new CLASS30();
        class30.MF_CLASS30_a122 = cursor.getLong(0);
        class30.MF_CLASS30_b123 = cursor.getLong(1);
        class30.PressureTimestamp = cursor.getLong(2);
        class30.Pressure = cursor.getFloat(3);
        class30.MF_CLASS30_c124 = cursor.getInt(4);
        return class30;
    }

    public long MF_CLASS30_a122;
    public long MF_CLASS30_b123;
    public int MF_CLASS30_c124;
}
