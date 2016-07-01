// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS22

public class CLASS23 extends CLASS22
{

    public CLASS23()
    {
        super(0.0F, 0.0F, 0.0F, 0L, 0.0F);
        MF_CLASS23_a79 = -1L;
        MF_CLASS23_b80 = -1L;
        MF_CLASS23_c81 = 0;
    }

    public CLASS23(float f, float f1, float f2, long l)
    {
        super(f, f1, f2, l, 0.0F);
        MF_CLASS23_a79 = -1L;
        MF_CLASS23_b80 = -1L;
        MF_CLASS23_c81 = 0;
    }

    public static CLASS23 getAccDatafromDB(Cursor cursor)
    {
        CLASS23 class23 = new CLASS23();
        class23.MF_CLASS23_a79 = cursor.getLong(0);
        class23.MF_CLASS23_b80 = cursor.getLong(1);
        class23.timeStamp = cursor.getLong(2);
        class23.AccelerometerX = cursor.getFloat(3);
        class23.AccelerometerY = cursor.getFloat(4);
        class23.AccelerometerZ = cursor.getFloat(5);
        class23.MF_CLASS23_c81 = cursor.getInt(6);
        return class23;
    }

    public long MF_CLASS23_a79;
    public long MF_CLASS23_b80;
    public int MF_CLASS23_c81;
}
