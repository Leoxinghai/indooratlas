// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS27

public class CLASS28 extends CLASS27
{

    public CLASS28()
    {
        super(0.0F, 0L);
        MF_CLASS28_a109 = -1L;
        MF_CLASS28_b110 = -1L;
        MF_CLASS28_c111 = 0;
    }

    public CLASS28(float f, long l)
    {
        super(f, l);
        MF_CLASS28_a109 = -1L;
        MF_CLASS28_b110 = -1L;
        MF_CLASS28_c111 = 0;
    }

    public static CLASS28 getLightDatafromDB(Cursor cursor)
    {
        CLASS28 class28 = new CLASS28();
        class28.MF_CLASS28_a109 = cursor.getLong(0);
        class28.MF_CLASS28_b110 = cursor.getLong(1);
        class28.PressureTimestamp = cursor.getLong(2);
        class28.Pressure = cursor.getFloat(3);
        class28.MF_CLASS28_c111 = cursor.getInt(4);
        return class28;
    }

    public long MF_CLASS28_a109;
    public long MF_CLASS28_b110;
    public int MF_CLASS28_c111;
}
