// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import android.database.Cursor;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS22

public class CLASS29 extends CLASS22
{

    public CLASS29()
    {
        super(0.0F, 0.0F, 0.0F, 0L, 0.0F);
        MF_CLASS29_a114 = -1L;
        MF_CLASS29_b115 = -1L;
        MF_CLASS29_c116 = 0;
    }

    public CLASS29(float f, float f1, float f2, long l, float f3)
    {
        super(f, f1, f2, l, f3);
        MF_CLASS29_a114 = -1L;
        MF_CLASS29_b115 = -1L;
        MF_CLASS29_c116 = 0;
    }

    public static CLASS29 getMgnDataFromDB(Cursor cursor)
    {
        CLASS29 class29 = new CLASS29();
        class29.MF_CLASS29_a114 = cursor.getLong(0);
        class29.MF_CLASS29_b115 = cursor.getLong(1);
        class29.timeStamp = cursor.getLong(2);
        class29.AccelerometerX = cursor.getFloat(3);
        class29.AccelerometerY = cursor.getFloat(4);
        class29.AccelerometerZ = cursor.getFloat(5);
        class29.Accuracy = cursor.getFloat(6);
        class29.MF_CLASS29_c116 = cursor.getInt(7);
        return class29;
    }

    public long MF_CLASS29_a114;
    public long MF_CLASS29_b115;
    public int MF_CLASS29_c116;
}
