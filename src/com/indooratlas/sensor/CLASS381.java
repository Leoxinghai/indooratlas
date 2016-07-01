// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.sensor;

import android.database.Cursor;

public class CLASS381
{

    public CLASS381()
    {
        MF_CLASS381_a1107 = 0L;
        MF_CLASS381_b1108 = 0L;
    }

    public CLASS381(long l, int i, String s, String s1, long l1)
    {
        MF_CLASS381_a1107 = 0L;
        MF_CLASS381_b1108 = 0L;
        ScanNo = l;
        mScanTimeStamp = l1;
        SignalStrength = i;
        mSsid = s;
        BSSID = s1;
    }

    public static CLASS381 getWifiDataFromDB(Cursor cursor)
    {
        CLASS381 class381 = new CLASS381();
        class381.MF_CLASS381_a1107 = cursor.getLong(0);
        class381.MF_CLASS381_b1108 = cursor.getLong(1);
        class381.ScanNo = cursor.getLong(2);
        class381.mScanTimeStamp = cursor.getLong(3);
        class381.mSsid = cursor.getString(4);
        class381.BSSID = cursor.getString(5);
        class381.SignalStrength = cursor.getInt(6);
        return class381;
    }

    public String toString()
    {
        return (new StringBuilder()).append(MF_CLASS381_a1107).append(",").append(MF_CLASS381_b1108).append(",").append(ScanNo).append(",").append(mScanTimeStamp).append(",").append(mSsid).append(",").append(BSSID).append(",").append(SignalStrength).toString();
    }

    public long MF_CLASS381_a1107;
    public long MF_CLASS381_b1108;
    public long ScanNo;
    public long mScanTimeStamp;
    public int SignalStrength;
    public String mSsid;
    public String BSSID;
}
