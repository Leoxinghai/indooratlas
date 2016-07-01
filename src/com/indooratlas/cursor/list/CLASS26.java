// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS22

public class CLASS26 extends CLASS22
{

    public CLASS26()
    {
        super(0.0F, 0.0F, 0.0F, 0L, 0.0F);
        MF_CLASS26_a100 = -1L;
        MF_CLASS26_b101 = -1L;
        MF_CLASS26_c102 = 0;
    }

    public CLASS26(float f, float f1, float f2, long l)
    {
        super(f, f1, f2, l, 0.0F);
        MF_CLASS26_a100 = -1L;
        MF_CLASS26_b101 = -1L;
        MF_CLASS26_c102 = 0;
    }

    public static CLASS26 getGyroDatafromDB(Cursor cursor)
    {
        CLASS26 class26 = new CLASS26();
        class26.MF_CLASS26_a100 = cursor.getLong(0);
        class26.MF_CLASS26_b101 = cursor.getLong(1);
        class26.timeStamp = cursor.getLong(2);
        class26.AccelerometerX = cursor.getFloat(3);
        class26.AccelerometerY = cursor.getFloat(4);
        class26.AccelerometerZ = cursor.getFloat(5);
        class26.MF_CLASS26_c102 = cursor.getInt(6);
        return class26;
    }

    public long MF_CLASS26_a100;
    public long MF_CLASS26_b101;
    public int MF_CLASS26_c102;
}
