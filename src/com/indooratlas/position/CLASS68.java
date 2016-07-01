// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.position;

import com.indooratlas.cursor.list.CLASS22;
import com.indooratlas.cursor.list.CLASS27;
import com.indooratlas.data.CLASS38;
import com.indooratlas.data.CLASS39;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CLASS68
{

    public static CLASS39 MF_CLASS68_a226(List list)
    {
        CLASS39 class39 = new CLASS39();
        long al[] = new long[list.size()];
        double ad[] = new double[list.size()];
        double ad1[] = new double[list.size()];
        double ad2[] = new double[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            al[i] = ((CLASS22)list.get(i)).timeStamp;
            ad[i] = ((CLASS22)list.get(i)).AccelerometerX;
            ad1[i] = ((CLASS22)list.get(i)).AccelerometerY;
            ad2[i] = ((CLASS22)list.get(i)).AccelerometerZ;
        }

        class39.mArrayTimeStamps = al;
        class39.mArrayAccelerometerX = ad;
        class39.mArrayAccelerometerY = ad1;
        class39.mArrayAccelerometerZ = ad2;
        return class39;
    }

    public static List MF_CLASS68_b227(List list)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < list.size(); i++)
        {
            double ad[] = new double[3];
            ad[0] = ((CLASS22)list.get(i)).AccelerometerX;
            ad[1] = ((CLASS22)list.get(i)).AccelerometerY;
            ad[2] = ((CLASS22)list.get(i)).AccelerometerZ;
            arraylist.add(ad);
        }

        return arraylist;
    }

    public static List MF_CLASS68_c228(List list)
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < list.size(); i++)
        {
            double ad[] = new double[4];
            ad[0] = ((CLASS22)list.get(i)).timeStamp;
            ad[1] = ((CLASS22)list.get(i)).AccelerometerX;
            ad[2] = ((CLASS22)list.get(i)).AccelerometerY;
            ad[3] = ((CLASS22)list.get(i)).AccelerometerZ;
            arraylist.add(ad);
        }

        return arraylist;
    }

    public static ConcurrentLinkedQueue MF_CLASS27_d107(List list)
    {
        ConcurrentLinkedQueue concurrentlinkedqueue = new ConcurrentLinkedQueue();
        for(int i = 0; i < list.size(); i++)
            concurrentlinkedqueue.add(list.get(i));

        return concurrentlinkedqueue;
    }

    public static CLASS38 MF_CLASS27_e108(List list)
    {
        CLASS38 class38 = new CLASS38();
        long al[] = new long[list.size()];
        double ad[] = new double[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            al[i] = ((CLASS27)list.get(i)).PressureTimestamp;
            ad[i] = ((CLASS27)list.get(i)).Pressure;
        }

        class38.a = al;
        class38.b = ad;
        return class38;
    }
}
