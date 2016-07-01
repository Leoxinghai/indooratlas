// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.cursor.list;

import java.util.*;

// Referenced classes of package com.indooratlas.cursor.list:
//            CLASS22, CLASS27, CLASS25

public class CLASS24
{

    public CLASS24()
    {
    	accelerometerSamples = new ArrayList();
    	gyroscopeSamples = new ArrayList();
    	magnetometerSamples = new ArrayList();
    	mBarometerList = new ArrayList();
    	mProximityList = new ArrayList();
    	mRGBList = new ArrayList();
    	mTemperatureList = new ArrayList();
        MF_CLASS24_h93 = new ArrayList();
    }

    public CLASS24(CLASS24 class24)
    {
    	accelerometerSamples = new ArrayList();
    	gyroscopeSamples = new ArrayList();
    	magnetometerSamples = new ArrayList();
    	mBarometerList = new ArrayList();
    	mProximityList = new ArrayList();
    	mRGBList = new ArrayList();
    	mTemperatureList = new ArrayList();
        MF_CLASS24_h93 = new ArrayList();
        if(class24.accelerometerSamples != null)
        {
            CLASS22 class22_2;
            for(Iterator iterator7 = class24.accelerometerSamples.iterator(); iterator7.hasNext(); accelerometerSamples.add(new CLASS22(class22_2)))
                class22_2 = (CLASS22)iterator7.next();

        }
        if(class24.gyroscopeSamples != null)
        {
            CLASS22 class22_1;
            for(Iterator iterator6 = class24.gyroscopeSamples.iterator(); iterator6.hasNext(); gyroscopeSamples.add(new CLASS22(class22_1)))
                class22_1 = (CLASS22)iterator6.next();

        }
        if(class24.magnetometerSamples != null)
        {
            CLASS22 class22;
            for(Iterator iterator5 = class24.magnetometerSamples.iterator(); iterator5.hasNext(); magnetometerSamples.add(new CLASS22(class22)))
                class22 = (CLASS22)iterator5.next();

        }
        if(class24.mBarometerList != null)
        {
            CLASS27 class27_3;
            for(Iterator iterator4 = class24.mBarometerList.iterator(); iterator4.hasNext(); mBarometerList.add(new CLASS27(class27_3)))
                class27_3 = (CLASS27)iterator4.next();

        }
        if(class24.mProximityList != null)
        {
            CLASS27 class27_2;
            for(Iterator iterator3 = class24.mProximityList.iterator(); iterator3.hasNext(); mProximityList.add(new CLASS27(class27_2)))
                class27_2 = (CLASS27)iterator3.next();

        }
        if(class24.mRGBList != null)
        {
            CLASS27 class27_1;
            for(Iterator iterator2 = class24.mRGBList.iterator(); iterator2.hasNext(); mRGBList.add(new CLASS27(class27_1)))
                class27_1 = (CLASS27)iterator2.next();

        }
        if(class24.mTemperatureList != null)
        {
            CLASS27 class27;
            for(Iterator iterator1 = class24.mTemperatureList.iterator(); iterator1.hasNext(); mTemperatureList.add(new CLASS27(class27)))
                class27 = (CLASS27)iterator1.next();

        }
        if(class24.MF_CLASS24_h93 != null)
        {
            CLASS25 class25;
            for(Iterator iterator = class24.MF_CLASS24_h93.iterator(); iterator.hasNext(); MF_CLASS24_h93.add(new CLASS25(class25.mLatitude, class25.mLongitude, class25.mAltitude, class25.mTimeStamp)))
                class25 = (CLASS25)iterator.next();

        }
    }

    public List accelerometerSamples;
    public List gyroscopeSamples;
    public List magnetometerSamples;
    public List mBarometerList;
    public List mProximityList;
    public List mRGBList;
    public List mTemperatureList;
    public List MF_CLASS24_h93;
}
