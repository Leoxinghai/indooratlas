// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;

import android.content.Context;
import android.hardware.*;
import android.location.Location;
import android.location.LocationManager;
import android.os.*;
import android.util.Log;
import com.indooratlas.Calibrator.*;
import com.indooratlas.Signal.SignalProcessingUtil;
import com.indooratlas.algorithm.cpa;
import com.indooratlas.cursor.list.*;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.position.CLASS68;
import com.indooratlas.position.CLASS75;

import com.indooratlas.sensor.type.CLASS158;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.sensor.type.CLASS48;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.housidea.indoor.collect.util.CLASS393;

// Referenced classes of package com.indooratlas.sensor:
//            CLASS377, CLASS375, CLASS370, CLASS372

public class SensorReader extends HandlerThread
    implements CLASS158
{

    public SensorReader(Context context, CLASS48 b, IBGCalibration class21)
    {
        super("APISensorReader");
        isCalibrating = false;
        MF_CLASS376_aa1076_boolean_fld = false;
        isAccDataSet = false;
        isMgnDataSet = false;
        isGyroDataSet = false;
        isRecordingSensorData = false;
        isSensorStarted = false;
        MF_CLASS376_ag1081_boolean_fld = false;
        mCollectedTimeStamp = 0L;
        MF_CLASS376_aj1083 = 0L;
        MF_CLASS369_b995 = 0L;
        MF_CLASS369_c996 = null;
        MF_CLASS376_ap1084 = NumberFormat.getInstance(Locale.US);
        mGyroList = new ArrayList();
        bgCalibList = new ArrayList();
        mGyroscopeSamples = null;
        mAccelerometerSamples = null;
        mMagnetometerSamples = null;
        mBarometerList = null;
        mRGBList = null;
        mTemperatureTimeStampList = null;
        mProximityList = null;
        mIntervalAccTimeStamp = 0L;
        mIntervalGyroTimeStamp = 0L;
        mIntervalMgnTimeStamp = 0L;
        MF_CLASS376_o1072 = 0L;
        MF_CLASS376_p1073 = 0L;
        mIntervalTemperatureTimeStamp = 0L;
        mIntervalProximityTimeStamp = 0L;
        MF_CLASS376_s1053 = 0.0F;
        MF_CLASS376_t1054 = 0.0F;
        MF_CLASS376_u1055_float_fld = 0.0F;
        MF_CLASS372_v1035 = 0.0F;
        MF_CLASS376_w1057_float_fld = 0.0F;
        MF_CLASS376_x1058_float_fld = 0.0F;
        MF_CLASS376_y1059_int_fld = 3;
        MF_CLASS376_z1087 = 0L;
        A = 0.0F;
        B = 0.0F;
        C = 0.0F;
        mPrevAccTimeStamp = 0L;
        E = 0.0F;
        F = 0.0F;
        G = 0.0F;
        mPrevGyroTimeStamp = 0L;
        I = 0.0F;
        J = 0L;
        K = 0.0F;
        mLastRGBTimeStamp = 0L;
        M = 0.0F;
        mLastProximityTimeStamp = 0L;
        O = 0.0F;
        mLastTemperatureTimeStamp = 0L;
        Q = 0.0F;
        MF_CLASS376_r1075_float_fld = 0.0F;
        MF_CLASS376_s1053 = 0.0F;
        MF_CLASS376_t1054 = 0.0F;
        MF_CLASS376_at1089 = 0L;
        mMgnTimeStamp = 0L;
        MF_CLASS376_av1091 = 0L;
        mLastACCTimeStamp = 0L;
        mLastMgnTimeStamp = 0L;
        mLastGyroTimeStamp = 0L;
        mAccTimeStampSave = new CLASS393(2);
        mGyroTimeStampSave = new CLASS393(2);
        mMgnTimeStampSave = new CLASS393(2);
        mIntervalTimeStamp = 0L;
        collectDataQueue = new ConcurrentLinkedQueue();
        mTimeStamp = 0L;
        MF_CLASS376_ae1079_long_fld = 0L;
        mBGCalibration = null;
        listenerCount = new AtomicInteger(0);
        MF_CLASS376_w1057_android_os_Handler_fld = null;
        MF_CLASS376_ag1081_java_lang_Object_fld = new Object();
        MF_CLASS375_a1045(50D);
        MF_CLASS369_b995(50D);
        setMgnTimeStampInterval(50D);
        MF_CLASS370_d1002(50D);
        MF_CLASS24_e90(50D);
        MF_CLASS24_g92(50D);
        MF_CLASS24_f91(50D);
        mSensorManager = (SensorManager)context.getSystemService("sensor");
        mLocationManager = (LocationManager)context.getSystemService("location");
        MF_CLASS376_ak1099 = new ConcurrentLinkedQueue();
        mSensorObserver = new SensorObserver(this);
        MF_CLASS376_ap1084.setMinimumFractionDigits(2);
        MF_CLASS376_ap1084.setMaximumFractionDigits(2);
        MF_CLASS369_c996 = b;
        mBGCalibration = class21;
        CLASS75.MF_CLASS75_b260("SensorReader", "SensorReader created");
        if(APIDataBase.MF_CLASS33_c139())
        {
            MF_CLASS376_ag1081_boolean_fld = APIDataBase.MF_CLASS33_b138();
            return;
        } else
        {
            MF_CLASS376_ag1081_boolean_fld = false;
            return;
        }
    }

    private CalibrationEvent generateCAEvent(double ad[])
    {
        int i;
        int j;
        CLASS19 class19;
        i = 100;
        j = Double.valueOf(ad[4]).intValue();
        class19 = null;
        switch(j) {
    //    JVM INSTR tableswitch 0 2: default 44
    //                   0 131
    //                   1 139
    //                   2 147;
    //       goto _L1 _L2 _L3 _L4
			default:
			        break;
			case 2:
			    class19 = CLASS19.READY;
			    break;
			case 0:
			        class19 = CLASS19.IN_PROGRESS;
			        break;
			case 1:
			        class19 = CLASS19.FAILED;
			        break;
        }
        int k = Double.valueOf(100D * ad[3]).intValue();
        CLASS19 class19_1;
        double ad1[];
        if(k <= i)
            if(k < 0)
                i = 0;
            else
                i = k;
        if(i < 10)
            class19_1 = CLASS19.DISCARDING;
        else
            class19_1 = class19;
        ad1 = new double[3];
        ad1[0] = ad[0];
        ad1[1] = ad[1];
        ad1[2] = ad[2];
        return new CalibrationEvent(class19_1, i, ad1, SystemClock.elapsedRealtime() - MF_CLASS376_ah1101, mMgnTimeStamp, MF_CLASS376_av1091);
    }

    private CLASS24 cutData(CLASS24 class24, long l, long l1)
    {
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("cutData called, startTime = ").append(l).append(", endTime = ").append(l1).toString());
        List list = MF_CLASS375_a1045(class24.gyroscopeSamples, l, l1);
        List list1 = MF_CLASS375_a1045(class24.accelerometerSamples, l, l1);
        List list2 = MF_CLASS375_a1045(class24.magnetometerSamples, l, l1);
        CLASS24 class24_1 = new CLASS24();
        class24_1.accelerometerSamples = list1;
        class24_1.gyroscopeSamples = list;
        class24_1.magnetometerSamples = list2;
        return class24_1;
    }

    private CLASS375 paseSensorEvent(SensorEvent sensorevent, long l)
    {
        CLASS375 class375 = new CLASS375(sensorevent.values.length);
        class375.setSensorType(sensorevent.sensor.getType());
        class375.MF_CLASS375_a1045(sensorevent.accuracy);
        class375.setTimeStamp(l);
        for(int i = 0; i < sensorevent.values.length; i++)
            class375.getEventData()[i] = sensorevent.values[i];

        return class375;
    }

    static CLASS375 paseSensorEvent0(SensorReader class376, SensorEvent sensorevent, long l)
    {
        return class376.paseSensorEvent(sensorevent, l);
    }

    private List MF_CLASS375_a1045(List list, long l, long l1)
    {
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        for(;iterator.hasNext();) {
	        CLASS22 class22 = (CLASS22)iterator.next();
	        if(class22.timeStamp >= l && class22.timeStamp <= l1)
	            arraylist.add(class22);
        }
        return arraylist;
    }

    private void informCalibrationDone(CalibrationEvent class18)
    {
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("informCalibrationDone() status.getStartTime() = ").append(class18.MF_CLASS18_e65()).append(" status.getEndTime() = ").append(class18.MF_CLASS18_f66()).toString());
        if(MF_CLASS376_an1102 != null)
            MF_CLASS376_an1102.EndTimestampMS = System.currentTimeMillis();
        stopCalibration();
        CLASS24 class24 = getAllCollectedData();
        CLASS24 class24_1 = cutData(class24, class18.MF_CLASS18_e65(), class18.MF_CLASS18_f66());
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("informCalibrationDone: mgn size before cutting = ").append(class24.magnetometerSamples.size()).append(", after = ").append(class24_1.magnetometerSamples.size()).toString());
        try {
	        if(class18.getCalibrationStatus() == CLASS19.READY)
	        {
	            CLASS75.MF_CLASS75_b260("SensorReader", "informCalibrationDone: SUCCESS --> storing forced calib result to API DB");
	            CLASS15 class15 = APIDataBase.selectBGCalibrationFromDB();
	            if(class15 != null)
	            {
	                CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("informCalibrationDone: old calib in db was: ").append(class15).toString());
	                APIDataBase.MF_CLASS33_b138(class15);
	            }
	            double d = class18.MF_CLASS18_c63()[1];
	            double d1 = -1D * class18.MF_CLASS18_c63()[0];
	            double ad[] = new double[3];
	            ad[0] = d;
	            ad[1] = d1;
	            ad[2] = class18.MF_CLASS18_c63()[2];
	            CLASS15 class15_1 = new CLASS15("forced", ad, 0.0D, 0.0D, CLASS17.FORCED, BGC_TYPE.BGC_READY);
	            class15_1.MF_CLASS16_b54(System.currentTimeMillis());
	            CLASS15 class15_2 = APIDataBase.storeBGCalibration(class15_1);
	            CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("informCalibrationDone: SUCCESS --> stored : ").append(class15_2).toString());
	        }
	        mBGCalibration.notifyCalibrationDone(class18, class24_1);
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	return;
        }
    }

    static boolean MF_CLASS375_a1045(SensorReader class376)
    {
        return class376.MF_CLASS376_ag1081_boolean_fld;
    }

    private double[] listToArray(List list)
    {
        int i = list.size();
        double ad[] = new double[i * 3];
        for(int j = 0; j < i; j++)
        {
            ad[j] = ((double[])list.get(j))[0];
            ad[i + j] = ((double[])list.get(j))[1];
            ad[j + i * 2] = ((double[])list.get(j))[2];
        }

        return ad;
    }

    static ConcurrentLinkedQueue MF_CLASS369_b995(SensorReader class376)
    {
        return class376.MF_CLASS376_ak1099;
    }

    private void MF_CLASS376_s1053()
    {
    	mLastTemperatureTimeStamp = 0L;
        mLastProximityTimeStamp = 0L;
        mLastRGBTimeStamp = 0L;
        J = 0L;
        mPrevGyroTimeStamp = 0L;
        mPrevAccTimeStamp = 0L;
        MF_CLASS376_z1087 = 0L;
        mTimeStamp = 0L;
    }

    private void resetCollection()
    {
        if(isCalibrating)
        	mMagnetometerSamples = new ArrayList(150);
        else
        	mMagnetometerSamples = new ArrayList(15);
        mGyroscopeSamples = new ArrayList(15);
        mAccelerometerSamples = new ArrayList(15);
        mBarometerList = new ArrayList(15);
        mRGBList = new ArrayList(15);
        mProximityList = new ArrayList(15);
        mTemperatureTimeStampList = new ArrayList(15);
    }

    private void startSensorProsessor()
    {
        if(mSensorProcessor != null)
        {
            CLASS75.MF_CLASS75_b260("SensorReader", " startSensorProsessor(): processor != null -> return");
            return;
        }
        MF_CLASS376_ak1099.clear();
        if(mSensorProcessor != null)
        {
        	mSensorProcessor.stopSensorEventProcessor();
            CLASS75.MF_CLASS75_b260("SensorReader", " startSensorProsessor(): joining sensorEventProcessorThread");
            CLASS75.MF_CLASS75_b260("SensorReader", " startSensorProsessor(): joined");
        }
        mSensorProcessor = new SensorEventProcessor(this);
        mSensorProcessor.start();
    }

    private void stopSensorProcessor()
    {
        if(mSensorProcessor != null)
        {
        	mSensorProcessor.stopSensorEventProcessor();
            CLASS75.MF_CLASS75_b260("SensorReader", "stopSensorProcessor(): joining sensorEventProcessorThread");
            CLASS75.MF_CLASS75_b260("SensorReader", " stopSensorProcessor(): joined");
            mSensorProcessor = null;
        }
    }

    private void startCalibdataRecording()
    {
        CLASS75.MF_CLASS75_b260("SensorReader", "startCalibdataRecording: STARTING CALIBRATION DATA COLLECTION ");
        isCollectingCalibData = true;
        MF_CLASS376_ah1101 = SystemClock.elapsedRealtime();
        try
        {
        	startDataCollection();
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	return;
        }
    }

    private boolean isCollectedEnoughData()
    {
        return mAccelerometerSamples != null && mAccelerometerSamples.size() > 2 && mGyroscopeSamples != null && mGyroscopeSamples.size() > 2 && mMagnetometerSamples != null && mMagnetometerSamples.size() > 2;
    }

    private CLASS24 getAllCollectedData()
    {
        CLASS24 class24 = new CLASS24();
        class24.accelerometerSamples = mAccelerometerSamples;
        class24.gyroscopeSamples = mGyroscopeSamples;
        class24.magnetometerSamples = mMagnetometerSamples;
        class24.mBarometerList = mBarometerList;
        class24.mProximityList = mProximityList;
        class24.mRGBList = mRGBList;
        class24.mTemperatureList = mTemperatureTimeStampList;
        CLASS24 class24_1 = new CLASS24(class24);
        resetCollection();
        return class24_1;
    }

    public void MF_CLASS375_a1045(double d)
    {
    	mIntervalAccTimeStamp = MF_CLASS376_h1065(d);
    }

    public void MF_CLASS375_a1045(float f)
    {
        MF_CLASS375_a1045((double)f);
        MF_CLASS369_b995(f);
        setMgnTimeStampInterval(f);
        MF_CLASS370_d1002(f);
        MF_CLASS24_e90(f);
        MF_CLASS24_g92(f);
        MF_CLASS24_f91(f);
    }

    public void notifySensorError(int i)
    {
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("informSensorError type = ").append(i).toString());
        CLASS75.MF_CLASS75_a259(5, "SENSOR_ERROR", SensorReader.class, (new StringBuilder()).append("SensorReader: sensor error type : ").append(i).append(", calibrating = ").append(isCalibrating).toString());
        if(isCalibrating)
        {
            MF_CLASS369_c996.notifySensorError(i, CLASS369.CALIBRATING);
            return;
        }
        if(isRecordingSensorData)
        {
            MF_CLASS369_c996.notifySensorError(i, CLASS369.POSITIONING);
            return;
        }
        if(isCollectingBGCalibData)
        {
            MF_CLASS369_c996.notifySensorError(i, CLASS369.BGCALIBRATING);
            return;
        } else
        {
            CLASS75.MF_CLASS75_b260("SensorReader", "** sensor error, but not collecting data or calibrating **");
            return;
        }
    }

    public void setFirstTimeStamp(long l)
    {
    	mTimeStamp = l;
    }

    public void parseCalibrateEvent(CLASS375 class375)
    {
        long eventTimeStamp = class375.mTimeStamp;
        //add by xinghai
//         isCollectingCalibData = true;
        switch(class375.getSensorType()) {
//        JVM INSTR tableswitch 1 14: default 80
    //                   1 511
    //                   2 778
    //                   3 80
    //                   4 156
    //                   5 1541
    //                   6 1467
    //                   7 80
    //                   8 1615
    //                   9 80
    //                   10 80
    //                   11 80
    //                   12 80
    //                   13 1689
    //                   14 778;
  //         goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L1 _L7 _L1 _L1 _L1 _L1 _L8 _L3
default:
case 3:
case 7:
case 9:
case 10:
case 11:
case 12:
	break;
case 4:
        if(mIntervalTimeStamp != 0L)
        	eventTimeStamp += mIntervalTimeStamp;
        long l5;
        long l6;
        CLASS26 class26;
        if((eventTimeStamp - mLastGyroTimeStamp <= 0L || eventTimeStamp - mLastGyroTimeStamp > 0x3b9aca00L) && mGyroTimeStampSave.size() > 1)
        {
        	mIntervalTimeStamp = (mLastGyroTimeStamp - eventTimeStamp) + Math.abs(((Long)mGyroTimeStampSave.MF_CLASS393_a1149(0)).longValue() - ((Long)mGyroTimeStampSave.MF_CLASS393_a1149(1)).longValue());
            l5 = class375.mTimeStamp + mIntervalTimeStamp;
            mGyroTimeStampSave.clear();
        } else
        {
        	mGyroTimeStampSave.add(Long.valueOf(eventTimeStamp));
            l5 = eventTimeStamp;
        }
        mLastGyroTimeStamp = l5;
        l6 = l5 - mPrevGyroTimeStamp;
        if(isCollectingBGCalibData)
        {
            float f3 = (float)class375.eventData[0];
            float f4 = (float)class375.eventData[1];
            float f5 = (float)class375.eventData[2];
            synchronized(mGyroList)
            {
            	mGyroList.add(new CLASS26(f3, f4, f5, l5));
            }
        }
        if(l6 > mIntervalGyroTimeStamp) {
        	mPrevGyroTimeStamp = l5;
	        E = (float)class375.eventData[0];
	        F = (float)class375.eventData[1];
	        G = (float)class375.eventData[2];
	        isGyroDataSet = true;
	        if(isRecordingSensorData)
	        {
	            if(mPrevGyroTimeStamp - mTimeStamp < 0L)
	            {
	                Log.e("SensorReader", "TIMESTAMP NEGATIVE");
	                Thread.dumpStack();
	            }
	            class26 = new CLASS26(E, F, G, mPrevGyroTimeStamp - mTimeStamp);
	            mGyroscopeSamples.add(class26);
	        }
        }
        break;
case 1:
        if(mIntervalTimeStamp != 0L)
        	eventTimeStamp += mIntervalTimeStamp;
        CLASS23 class23;
        if((eventTimeStamp - mLastACCTimeStamp <= 0L || eventTimeStamp - mLastACCTimeStamp > 0x3b9aca00L) && mAccTimeStampSave.size() > 1)
        {
        	mIntervalTimeStamp = (mLastACCTimeStamp - eventTimeStamp) + Math.abs(((Long)mAccTimeStampSave.MF_CLASS393_a1149(0)).longValue() - ((Long)mAccTimeStampSave.MF_CLASS393_a1149(1)).longValue());
        	eventTimeStamp = class375.mTimeStamp + mIntervalTimeStamp;
        	mAccTimeStampSave.clear();
        } else
        {
        	mAccTimeStampSave.add(Long.valueOf(eventTimeStamp));
        }
        mLastACCTimeStamp = eventTimeStamp;
        if(eventTimeStamp - mPrevAccTimeStamp > mIntervalAccTimeStamp) {
        	mPrevAccTimeStamp = eventTimeStamp;
	        A = (float)class375.eventData[0];
	        B = (float)class375.eventData[1];
	        C = (float)class375.eventData[2];
	        isAccDataSet = true;
	        if(isRecordingSensorData)
	        {
	            if(mPrevAccTimeStamp - mTimeStamp < 0L)
	            {
	                Log.e("SensorReader", "TIMESTAMP NEGATIVE");
	                Thread.dumpStack();
	            }
	            class23 = new CLASS23(A, B, C, mPrevAccTimeStamp - mTimeStamp);
	            mAccelerometerSamples.add(class23);
	        }
        }
        break;
case 2:
case 14:
        if(mIntervalTimeStamp != 0L)
        	eventTimeStamp += mIntervalTimeStamp;
        long l2;
        long l3;
        CLASS29 class29;
        double ad[];
        if((eventTimeStamp - mLastMgnTimeStamp <= 0L || eventTimeStamp - mLastMgnTimeStamp > 0x3b9aca00L) && mMgnTimeStampSave.size() > 1)
        {
        	mIntervalTimeStamp = (mLastMgnTimeStamp - eventTimeStamp) + Math.abs(((Long)mMgnTimeStampSave.MF_CLASS393_a1149(0)).longValue() - ((Long)mMgnTimeStampSave.MF_CLASS393_a1149(1)).longValue());
            l2 = class375.mTimeStamp + mIntervalTimeStamp;
            mMgnTimeStampSave.clear();
        } else
        {
        	mMgnTimeStampSave.add(Long.valueOf(eventTimeStamp));
            l2 = eventTimeStamp;
        }
        mLastMgnTimeStamp = l2;
        l3 = l2 - MF_CLASS376_z1087;
        if(isCollectingBGCalibData)
        {
            float f = (float)class375.eventData[0];
            float f1 = (float)class375.eventData[1];
            float f2 = (float)class375.eventData[2];
            //synchronized(MF_CLASS376_ar1086)
            //{
            bgCalibList.add(new CLASS29(f, f1, f2, l2, 0.0F));
            //}
        }
        if(l3 > mIntervalMgnTimeStamp) {
	        MF_CLASS369_b995 = 1L + MF_CLASS369_b995;
	        if(MF_CLASS369_b995 > 1L)
	        {
	            ad = new double[3];
	            ad[0] = MF_CLASS376_s1053;
	            ad[1] = MF_CLASS376_t1054;
	            ad[2] = MF_CLASS376_u1055_float_fld;
	            SignalProcessingUtil.outlierDetection(class375.eventData, ad, l2, MF_CLASS376_z1087, 100D, 0x2faf080L);
	        }
	        MF_CLASS376_z1087 = l2;
	        MF_CLASS376_s1053 = (float)class375.eventData[0];
	        MF_CLASS376_t1054 = (float)class375.eventData[1];
	        MF_CLASS376_u1055_float_fld = (float)class375.eventData[2];
	        isMgnDataSet = true;
	        if(MF_CLASS376_aa1076_boolean_fld)
	        {
	            MF_CLASS376_y1059_int_fld = 3;
	            MF_CLASS372_v1035 = (float)class375.eventData[3];
	            MF_CLASS376_w1057_float_fld = (float)class375.eventData[4];
	            MF_CLASS376_x1058_float_fld = (float)class375.eventData[5];
	        } else
	        {
	            MF_CLASS376_y1059_int_fld = (int)class375.MF_CLASS375_d1048();
	        }
	        isMgnDataSet = true;
	        if(!isCollectingCalibData && isCalibrating)
	            if(!MF_CLASS376_aa1076_boolean_fld && MF_CLASS376_y1059_int_fld == 3)
	            {
	                long l4 = System.currentTimeMillis() - MF_CLASS376_ae1079_long_fld;
	                if(MF_CLASS376_ae1079_long_fld == 0L)
	                    MF_CLASS376_ae1079_long_fld = System.currentTimeMillis();
	                else
	                if(l4 > 3000L)
	                	startCalibdataRecording();
	            } else
	            if(!MF_CLASS376_aa1076_boolean_fld && MF_CLASS376_y1059_int_fld != 3)
	            {
	                CalibrationEvent class18 = new CalibrationEvent(CLASS19.IN_PROGRESS, 0, new double[] {
	                    0.0D, 0.0D, 0.0D
	                }, 0L, 0L, 0L);
	                mBGCalibration.updateCalibrationStatus(class18);
	                if(System.currentTimeMillis() - MF_CLASS376_an1102.StartTimestampMS > 20000L)
	                {
	                    CLASS75.MF_CLASS75_b260("SensorReader", "handleSensorEvent: not using raw mgn, ** waited very long time for accuracy high ** --> starting calib data collection anyway!");
	                    startCalibdataRecording();
	                }
	            } else
	            if(MF_CLASS376_aa1076_boolean_fld)
	            {
	                CLASS75.MF_CLASS75_b260("SensorReader", "handleSensorEvent: using raw mgn --> starting calib data collection");
	                startCalibdataRecording();
	            }
	        if(isRecordingSensorData || isCollectingCalibData)
	        {
	            if(MF_CLASS376_z1087 - mTimeStamp < 0L)
	            {
	                Log.e("SensorReader", "TIMESTAMP NEGATIVE");
	                Thread.dumpStack();
	            }
	            class29 = new CLASS29(MF_CLASS376_s1053, MF_CLASS376_t1054, MF_CLASS376_u1055_float_fld, MF_CLASS376_z1087 - mTimeStamp, MF_CLASS376_y1059_int_fld);
	            mMagnetometerSamples.add(class29);
	        }
        }
        break;
case 6:
        if(eventTimeStamp - J > MF_CLASS376_o1072) {
	        J = eventTimeStamp;
	        I = (float)class375.eventData[0];
	        if(isRecordingSensorData)
	        {
	            CLASS30 class30 = new CLASS30(I, J - mTimeStamp);
	            mBarometerList.add(class30);
	        }
        }
        break;
case 5:
        if(eventTimeStamp - mLastRGBTimeStamp > MF_CLASS376_p1073) {
        	mLastRGBTimeStamp = eventTimeStamp;
	        K = (float)class375.eventData[0];
	        if(isRecordingSensorData)
	        {
	            CLASS28 class28 = new CLASS28(K, mLastRGBTimeStamp - mTimeStamp);
	            mRGBList.add(class28);
	        }
        }
        break;
case 8:
        if(eventTimeStamp - mLastProximityTimeStamp > mIntervalProximityTimeStamp) {
        	mLastProximityTimeStamp = eventTimeStamp;
	        M = (float)class375.eventData[0];
	        if(isRecordingSensorData)
	        {
	            CLASS31 class31 = new CLASS31(M, mLastProximityTimeStamp - mTimeStamp);
	            mProximityList.add(class31);
	        }
        }
        break;
case 13:
        if(eventTimeStamp - mLastTemperatureTimeStamp > mIntervalTemperatureTimeStamp) {
        	mLastTemperatureTimeStamp = eventTimeStamp;
	        O = (float)class375.eventData[0];
	        if(isRecordingSensorData)
	        {
	            CLASS32 class32 = new CLASS32(O, mLastTemperatureTimeStamp - mTimeStamp);
	            mTemperatureTimeStampList.add(class32);
	        }
        }
        break;
   }
        
        if(isRecordingSensorData && !isCalibrating && isRequireCollected() && isCollectedEnoughData())
        {
        	setCollectedTimeStamp();
        	collectDataQueue.add(getAllCollectedData());
        }
        if(isCollectingCalibData) {
	        long l1 = SystemClock.elapsedRealtime();
	        if(MF_CLASS376_at1089 != 0L) {
                if(l1 - MF_CLASS376_at1089 > 100L) {
	                MF_CLASS376_at1089 = l1;
	                runCalibration();
	                return;
                }
	        } else {
		        MF_CLASS376_at1089 = l1;
		        runCalibration();
	        }
        }
        return;
        
    }

    public void startCalibration(boolean flag)
    {
        CLASS75.MF_CLASS75_b260("SensorReader", "startCalibration() called.");
        isCollectingCalibData = false;
        Location location = mLocationManager.getLastKnownLocation("network");
        if(location != null)
        {
            CLASS75.MF_CLASS75_b260("SensorReader", "startCalibration() got last location.");
            double d = location.getLatitude();
            double d1 = location.getLongitude();
            double d2 = location.getAltitude();
            MF_CLASS376_an1102 = new CLASS370(System.currentTimeMillis(), d, d1, d2);
        } else
        {
            CLASS75.MF_CLASS75_b260("SensorReader", "startCalibration() did not get last location.");
            MF_CLASS376_an1102 = new CLASS370(System.currentTimeMillis(), 0.0D, 0.0D, 0.0D);
        }
        isCalibrating = true;
        if(!isCollectingBGCalibData)
        {
            CLASS75.MF_CLASS75_b260("SensorReader", "startCalibration(), collectingBackgroundCalibrationData == false --> starting SensorProcessor");
            startSensorProsessor();
            startSensors();
            return;
        } else
        {
            CLASS75.MF_CLASS75_b260("SensorReader", "startCalibration(), collectingBackgroundCalibrationData == true --> *NOT* starting SensorProcessor, already running");
            return;
        }
    }

    public void stopSensors(boolean flag, boolean flag1) throws Exception
    {
        Object obj = MF_CLASS376_ag1081_java_lang_Object_fld;
        listenerCount.decrementAndGet();
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("stopSensors(): listenerCount = ").append(listenerCount.get()).toString());
        if(flag) {
            //break MISSING_BLOCK_LABEL_110;
        	//throw new Exception("sensorReader Error");
        }
        if(listenerCount.get() >= 0) {
            //break MISSING_BLOCK_LABEL_81;
        	listenerCount.set(0);
            CLASS75.MF_CLASS75_b260("SensorReader", "stopSensors called");
            if(!flag1) {
                //break MISSING_BLOCK_LABEL_144;
                //throw new Exception("sensorReader Error2");                
            }
            CLASS75.MF_CLASS75_b260("SensorReader", "stopSensors stopping sensorprocessor");
            stopSensorProcessor();
            if(!isSensorStarted) {
                //break MISSING_BLOCK_LABEL_656;
            }
            CLASS75.MF_CLASS75_b260("SensorReader", "stopSensors unregistering sensors");
            isSensorStarted = false;
            Sensor sensor8;
            for(Iterator iterator = mSensorManager.getSensorList(1).iterator(); iterator.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor8))
                sensor8 = (Sensor)iterator.next();

            Sensor sensor7;
            for(Iterator iterator1 = mSensorManager.getSensorList(2).iterator(); iterator1.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor7))
                sensor7 = (Sensor)iterator1.next();

            if(android.os.Build.VERSION.SDK_INT >= 18)
            {
                Sensor sensor6;
                for(Iterator iterator8 = mSensorManager.getSensorList(14).iterator(); iterator8.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor6))
                    sensor6 = (Sensor)iterator8.next();

            }
            Sensor sensor5;
            for(Iterator iterator2 = mSensorManager.getSensorList(4).iterator(); iterator2.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor5))
                sensor5 = (Sensor)iterator2.next();

            Sensor sensor4;
            for(Iterator iterator3 = mSensorManager.getSensorList(6).iterator(); iterator3.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor4))
                sensor4 = (Sensor)iterator3.next();

            Sensor sensor3;
            for(Iterator iterator4 = mSensorManager.getSensorList(13).iterator(); iterator4.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor3))
                sensor3 = (Sensor)iterator4.next();

            Sensor sensor2;
            for(Iterator iterator5 = mSensorManager.getSensorList(13).iterator(); iterator5.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor2))
                sensor2 = (Sensor)iterator5.next();

            Sensor sensor1;
            for(Iterator iterator6 = mSensorManager.getSensorList(5).iterator(); iterator6.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor1))
                sensor1 = (Sensor)iterator6.next();

            Sensor sensor;
            for(Iterator iterator7 = mSensorManager.getSensorList(8).iterator(); iterator7.hasNext(); mSensorManager.unregisterListener(mSensorObserver, sensor))
                sensor = (Sensor)iterator7.next();

            mLastACCTimeStamp = 0L;
            mLastMgnTimeStamp = 0L;
            mIntervalGyroTimeStamp = 0L;
            mAccTimeStampSave.clear();
            mMgnTimeStampSave.clear();
            mGyroTimeStampSave.clear();
            mIntervalTimeStamp = 0L;
            CLASS75.MF_CLASS75_b260("SensorReader", "StopSensors(): done.");
            collectDataQueue.clear();
            MF_CLASS376_ak1099.clear();
            isRecordingSensorData = false;
            isCalibrating = false;
            isCollectingCalibData = false;
        	
            listenerCount.set(0);
	        CLASS75.MF_CLASS75_b260("SensorReader", "StopSensors(): listener count negative.");
	        return;
        } else {
	        CLASS75.MF_CLASS75_b260("SensorReader", "stopSensors(): not stopping due to remaining listeners.");
	        return;
        }
        
    }

    public boolean startDataCollection()
    {
        CLASS75.MF_CLASS75_b260("SensorReader", "startDataCollection called");
        collectDataQueue = new ConcurrentLinkedQueue();
        setCollectedTimeStamp();
        resetCollection();
        MF_CLASS376_s1053();
        startSensors();
        MF_CLASS376_aj1083 = SystemClock.elapsedRealtime();
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("startDataCollection measurementStartTime = ").append(MF_CLASS376_aj1083).toString());
        isRecordingSensorData = true;
        startSensorProsessor();
        return true;
    }

    public void MF_CLASS369_b995(double d)
    {
    	mIntervalGyroTimeStamp = MF_CLASS376_h1065(d);
    }

    public void setBackgroundCalibrationDataCollection(boolean flag)
    {
        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("setBackgroundCalibrationDataCollection : value = ").append(flag).toString());
        isCollectingBGCalibData = flag;
    }

    public boolean startBGCalibDataCollection()
    {
    	mGyroList.clear();
        bgCalibList.clear();
        CLASS75.MF_CLASS75_b260("SensorReader", "startBGCalibDataCollection called");
        setBackgroundCalibrationDataCollection(true);
        if(!isRecordingSensorData)
        {
        	collectDataQueue = new ConcurrentLinkedQueue();
        	setCollectedTimeStamp();
        	resetCollection();
            MF_CLASS376_s1053();
            if(!isSensorStarted)
            	startSensors();
            MF_CLASS376_aj1083 = SystemClock.elapsedRealtime();
            startSensorProsessor();
            CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("startBGCalibDataCollection measurementStartTime = ").append(MF_CLASS376_aj1083).toString());
            return true;
        } else
        {
        	startSensors();
        	mSensorProcessor.MF_CLASS373_a1036(false);
            CLASS75.MF_CLASS75_b260("SensorReader", "startBGCalibDataCollection sensorEventProcessor.setReportedError(false)");
            return true;
        }
    }

    public void MF_CLASS369_c996()
    {
    	isRecordingSensorData = false;
    	resetCollection();
    }

    public void setMgnTimeStampInterval(double d)
    {
    	mIntervalMgnTimeStamp = MF_CLASS376_h1065(d);
    }

    public void setUseNanoTime(boolean flag) throws Exception
    {
        CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", (new StringBuilder()).append("setUseNanoTime() called with useNanoTime = ").append(flag).toString());
        while(mSensorProcessor != null && mSensorProcessor.MF_CLASS372_v1035 || APIDataBase.MF_CLASS33_c139())
            return;
        APIDataBase.MF_CLASS33_a137(flag);
        MF_CLASS376_ag1081_boolean_fld = flag;
        if(mSensorProcessor != null)
        	mSensorProcessor.MF_CLASS372_v1035 = true;
        if(APIDataBase.MF_CLASS33_c139())
        {
            CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", "setUseNanoTime() called and check done set");
            return;
        } else
        {
            CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", "setUseNanoTime() called and check done NOT set!");
            return;
        }
    }

    public void startSensors()
    {
        synchronized(MF_CLASS376_ag1081_java_lang_Object_fld) {
        	listenerCount.incrementAndGet();
            CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("startSensors(): listenerCount = ").append(listenerCount.get()).toString());
            if(listenerCount.get() > 1) {
            	CLASS75.MF_CLASS75_b260("SensorReader", "startSensors(): not starting, already started.");
                return;
            }
        }
        
        CLASS75.MF_CLASS75_b260("SensorReader", "startSensors: called");
        MF_CLASS369_b995 = 0L;
        
        if(!isSensorStarted) {
		    HashMap hashmap;
		    hashmap = new HashMap();
		    CLASS75.MF_CLASS75_b260("SensorReader", "startSensors: starting sensors");
		    isSensorStarted = true;
		    Sensor sensor = mSensorManager.getDefaultSensor(1);
		    CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).toString());
		    boolean flag = mSensorManager.registerListener(mSensorObserver, sensor, 0, MF_CLASS376_w1057_android_os_Handler_fld);
		    hashmap.put(Integer.valueOf(sensor.getType()), Boolean.valueOf(flag));
		    if(android.os.Build.VERSION.SDK_INT < 18) {
		        CLASS75.MF_CLASS75_b260("SensorReader", "startSensors: starting *calibrated* mgn sensor");
		        Sensor sensor1 = mSensorManager.getDefaultSensor(2);
		        boolean flag1 = mSensorManager.registerListener(mSensorObserver, sensor1, 0, MF_CLASS376_w1057_android_os_Handler_fld);
		        hashmap.put(Integer.valueOf(sensor1.getType()), Boolean.valueOf(flag1));
		        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor1.getName()).append(", type = ").append(sensor1.getType()).append(", vendor = ").append(sensor1.getVendor()).append(", maxRange = ").append(sensor1.getMaximumRange()).append(", resolution = ").append(sensor1.getResolution()).append(", power = ").append(sensor1.getPower()).toString());
		    } else {
		        Sensor sensor3 = mSensorManager.getDefaultSensor(14);
		        if(sensor3 != null) {
		            MF_CLASS376_aa1076_boolean_fld = true;
		        }else {
		        	sensor3 = mSensorManager.getDefaultSensor(2);
		        }
		        boolean flag3 = mSensorManager.registerListener(mSensorObserver, sensor3, 0, MF_CLASS376_w1057_android_os_Handler_fld);
		        hashmap.put(Integer.valueOf(sensor3.getType()), Boolean.valueOf(flag3));
		        CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor3.getName()).append(", type = ").append(sensor3.getType()).append(", vendor = ").append(sensor3.getVendor()).append(", maxRange = ").append(sensor3.getMaximumRange()).append(", resolution = ").append(sensor3.getResolution()).append(", power = ").append(sensor3.getPower()).toString());
		    }
		    
		    Sensor sensor2 = mSensorManager.getDefaultSensor(4);
		    boolean flag2 = mSensorManager.registerListener(mSensorObserver, sensor2, 0, MF_CLASS376_w1057_android_os_Handler_fld);
		    hashmap.put(Integer.valueOf(sensor2.getType()), Boolean.valueOf(flag2));
		    CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor2.getName()).append(", type = ").append(sensor2.getType()).append(", vendor = ").append(sensor2.getVendor()).append(", maxRange = ").append(sensor2.getMaximumRange()).append(", resolution = ").append(sensor2.getResolution()).append(", power = ").append(sensor2.getPower()).toString());
		    CLASS75.MF_CLASS75_b260("SensorReader", "startSensors: *NOT* starting extra sensors");
		    Integer integer;
		    for(Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("startSensors: sensor: ").append(integer).append(" registerListener: ").append(hashmap.get(integer)).toString()))
		        integer = (Integer)iterator.next();
		
        } else {
	        CLASS75.MF_CLASS75_b260("SensorReader", "startSensors: sensors already running");
        }
        CLASS75.MF_CLASS75_b260("SensorReader", "startSensors: done");
        return;
    }

    public void MF_CLASS370_d1002(double d)
    {
        MF_CLASS376_o1072 = MF_CLASS376_h1065(d);
    }

    public ConcurrentLinkedQueue sensorEventQueue()
    {
        return MF_CLASS376_ak1099;
    }

    public void MF_CLASS24_e90(double d)
    {
        MF_CLASS376_p1073 = MF_CLASS376_h1065(d);
    }

    public void MF_CLASS24_f91(double d)
    {
    	mIntervalTemperatureTimeStamp = MF_CLASS376_h1065(d);
    }

    public boolean MF_CLASS158_f565()
    {
        return isRecordingSensorData || isCollectingCalibData || isCalibrating || isCollectingBGCalibData;
    	//add by xinghai
        //return isRecordingSensorData || isCollectingCalibData || isCalibrating ;    	
    }

    public void informTimestampError()
    {
        CLASS75.MF_CLASS75_a259(5, "TIMESTAMP_ERROR", SensorReader.class, (new StringBuilder()).append("SensorReader: timestamp error : calibrating = ").append(isCalibrating).append(", collectingCalibrationData = ").append(isCollectingCalibData).append(", collectingBackgroundCalibrationData = ").append(isCollectingBGCalibData).toString());
        try {
	        if(isCollectingBGCalibData)
	        {
	        	setUseNanoTime(true);
	            MF_CLASS376_x1058_com_indooratlas_Calibrator_CLASS9_fld.MF_CLASS9_b23();
	        }
	        if(!isCollectingCalibData) {
	            if(isRecordingSensorData && !isCalibrating)
	            {
	                CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", "informTimestampError(), calling sensorProcessorListener.notifyTimestampError(SensorProcessorState.POSITIONING)");
	                return;
	            }
	        } else {
	        	stopCalibration();
		        MF_CLASS376_s1053();
		        startCalibration(false);
	        }
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
        return;
    }

    public void MF_CLASS24_g92(double d)
    {
    	mIntervalProximityTimeStamp = MF_CLASS376_h1065(d);
    }

    public long MF_CLASS376_h1065(double d)
    {
        return (long)(1000000000D / d);
    }

    public void MF_CLASS158_h567()
    {
    }

    public boolean MF_CLASS376_i1066()
    {
        return isCalibrating;
    }

    public void stopCalibration()
    {
        CLASS75.MF_CLASS75_b260("SensorReader", "stopCalibration called.");
        isCollectingCalibData = false;
        isRecordingSensorData = false;
        MF_CLASS376_at1089 = 0L;
        mMgnTimeStamp = 0L;
        MF_CLASS376_av1091 = 0L;
        try
        {
	        if(isCollectingBGCalibData) {
	            CLASS75.MF_CLASS75_b260("SensorReader", "stopCalibration: collectingBackgroundCalibrationData == true --> *NOT* stopping sensors ");
	        } else {
		        CLASS75.MF_CLASS75_b260("SensorReader", "stopCalibration: collectingBackgroundCalibrationData == false --> stopping sensors ");
		        stopSensors(true, true);
	        }
        }
        catch(Exception exception) {
        	exception.printStackTrace();
        }

        isCalibrating = false;
        if(MF_CLASS376_an1102 != null)
            MF_CLASS376_an1102.EndTimestampMS = System.currentTimeMillis();
        return;
    }

    public CLASS370 MF_CLASS376_k1068()
    {
        return MF_CLASS376_an1102;
    }

    public void runCalibration()
    {
        if(!isMgnDataSet || !isGyroDataSet || !isAccDataSet) {
            //break MISSING_BLOCK_LABEL_492;
        	
        }
        isMgnDataSet = false;
        isGyroDataSet = false;
        isAccDataSet = false;
        CalibrationEvent caevent;
        try {
	        if(mMagnetometerSamples.size() > 2)
	        {
	            List list = CLASS68.MF_CLASS68_b227(mMagnetometerSamples);
	            double ad[] = cpa.calibrate(listToArray(list), list.size());
	            mMgnTimeStamp = ((CLASS22)mMagnetometerSamples.get(0)).timeStamp;
	            caevent = generateCAEvent(ad);
	            if(caevent.getCalibrationStatus() == CLASS19.READY)
	            {
	                CLASS75.MF_CLASS75_b260("SensorReader", "runCalibration(): READY ");
	                MF_CLASS376_av1091 = ((CLASS22)mMagnetometerSamples.get(-1 + mMagnetometerSamples.size())).timeStamp;
	                caevent.MF_CLASS18_a61(MF_CLASS376_av1091);
	                CLASS75.MF_CLASS75_a259(4, "CALIBRATION_DONE_SUCCESS",SensorReader.class, (new StringBuilder()).append("runCalibration: ").append(System.currentTimeMillis()).append(", ").append(CLASS75.MF_CLASS75_a259(caevent.MF_CLASS18_c63())).append(", ").append(caevent.MF_CLASS18_b62()).append(", ").append(caevent.MF_CLASS18_e65()).append(", ").append(caevent.MF_CLASS18_f66()).toString());
	                informCalibrationDone(caevent);
	                return;
	            }
	            if(caevent.getCalibrationStatus() == CLASS19.FAILED)
	            {
	                CLASS75.MF_CLASS75_b260("SensorReader", "runCalibration(): FAILED");
	                CLASS75.MF_CLASS75_a259(5, "DONE_FAILURE_NOT_MOVED_ENOUGH", SensorReader.class, "runCalibration:");
	                CLASS75.MF_CLASS75_a259("SensorReader", CLASS68.MF_CLASS68_c228(mMagnetometerSamples));
	                resetCollection();
	                mBGCalibration.updateCalibrationStatus(caevent);
	                return;
	            }
	            if(caevent.getCalibrationStatus() == CLASS19.DISCARDING)
	            {
	                CLASS75.MF_CLASS75_b260("SensorReader", "runCalibration(): discarding calibration data so far");
	                CLASS75.MF_CLASS75_b260("SensorReader", (new StringBuilder()).append("progress: ").append(caevent.MF_CLASS18_b62()).toString());
	                CLASS75.MF_CLASS75_a259(5, "DISCARD_DATA_SO_FAR", SensorReader.class, "runCalibration");
	                CLASS75.MF_CLASS75_a259("SensorReader", CLASS68.MF_CLASS68_c228(mMagnetometerSamples));
	                resetCollection();
	                mBGCalibration.updateCalibrationStatus(caevent);
	                return;
	            }
	            if(caevent.getCalibrationStatus() == CLASS19.IN_PROGRESS)
	            	mBGCalibration.updateCalibrationStatus(caevent);
	        }
            CLASS75.MF_CLASS75_b260("SensorReader", "Not enough data yet.");
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	CLASS75.MF_CLASS75_b260("SensorReader", "runCalibration(): EXCEPTION ");
        }
        CLASS75.MF_CLASS75_b260("SensorReader", "runCalibration(): Restarting calibration");
        CLASS75.MF_CLASS75_a259(5, "DONE_FAILURE_NOT_MOVED_ENOUGH", SensorReader.class, "runCalibration: exception.");
        informCalibrationDone(new CalibrationEvent(CLASS19.FAILED, 0, new double[3], 0L, 0L, 0L));
        return;
    }

    public long getLastCollectedTimeStamp()
    {
        return mCollectedTimeStamp;
    }

    public void setCollectedTimeStamp()
    {
    	mCollectedTimeStamp = SystemClock.elapsedRealtime();
    }

    public boolean isRequireCollected()
    {
        return SystemClock.elapsedRealtime() - getLastCollectedTimeStamp() > 500L;
    }

    public void onLooperPrepared()
    {
        MF_CLASS376_w1057_android_os_Handler_fld = new Handler(getLooper());
    }

    public CLASS22[] MF_CLASS376_p1073()
    {
        CLASS22 aclass22[];
        synchronized(bgCalibList)
        {
            aclass22 = (CLASS22[])bgCalibList.toArray(new CLASS22[bgCalibList.size()]);
            bgCalibList.clear();
        }
        return aclass22;
    }

    public CLASS22[] MF_CLASS376_q1074()
    {
        CLASS22 aclass22[];
        synchronized(mGyroList)
        {
            aclass22 = (CLASS22[])mGyroList.toArray(new CLASS22[mGyroList.size()]);
            mGyroList.clear();
        }
        return aclass22;
    }

    public boolean isSensorErrorReported()
    {
        CLASS75.MF_CLASS75_b260("SensorReader", "isSensorErrorReported called");
        if(mSensorProcessor != null)
            return mSensorProcessor.MF_CLASS373_c1038();
        else
            return false;
    }

    float A;
    float B;
    float C;
    long mPrevAccTimeStamp;
    float E;
    float F;
    float G;
    long mPrevGyroTimeStamp;
    float I;
    long J;
    float K;
    long mLastRGBTimeStamp;
    float M;
    long mLastProximityTimeStamp;
    float O;
    long mLastTemperatureTimeStamp;
    float Q;
    float MF_CLASS376_r1075_float_fld;
    float MF_CLASS376_s1053;
    float MF_CLASS376_t1054;
    public ConcurrentLinkedQueue collectDataQueue;
    IBGCalibration mBGCalibration;
    Handler MF_CLASS376_w1057_android_os_Handler_fld;
    public BackgroundCalibratorController MF_CLASS376_x1058_com_indooratlas_Calibrator_CLASS9_fld;
    private boolean isCalibrating;
    private boolean isCollectingCalibData;
    public boolean isRecordingSensorData;
    private CLASS393 mGyroTimeStampSave;
    private CLASS393 mMgnTimeStampSave;
    private long mIntervalTimeStamp;
    private long mTimeStamp;
    private long MF_CLASS376_ae1079_long_fld;
    private AtomicInteger listenerCount;
    private Object MF_CLASS376_ag1081_java_lang_Object_fld;
    private boolean MF_CLASS376_aa1076_boolean_fld;
    private boolean isCollectingBGCalibData;
    private boolean isAccDataSet;
    private boolean isGyroDataSet;
    private boolean isMgnDataSet;
    private boolean isSensorStarted;
    private boolean MF_CLASS376_ag1081_boolean_fld;
    private long MF_CLASS376_ah1101;
    private long mCollectedTimeStamp;
    private long MF_CLASS376_aj1083;
    private ConcurrentLinkedQueue MF_CLASS376_ak1099;
    private SensorManager mSensorManager;
    private LocationManager mLocationManager;
    private CLASS370 MF_CLASS376_an1102;
    private SensorObserver mSensorObserver;
    private NumberFormat MF_CLASS376_ap1084;
    private ArrayList mGyroList;
    private ArrayList bgCalibList;
    private final int MF_CLASS376_as1088 = 100;
    private long MF_CLASS376_at1089;
    private long mMgnTimeStamp;
    private long MF_CLASS376_av1091;
    private long mLastACCTimeStamp;
    private long mLastMgnTimeStamp;
    private long mLastGyroTimeStamp;
    private CLASS393 mAccTimeStampSave;
    public long MF_CLASS369_b995;
    CLASS48 MF_CLASS369_c996;
    public SensorEventProcessor mSensorProcessor;
    public List mGyroscopeSamples;
    public List mAccelerometerSamples;
    public List mMagnetometerSamples;
    public List mBarometerList;
    public List mRGBList;
    public List mTemperatureTimeStampList;
    public List mProximityList;
    long mIntervalAccTimeStamp;
    long mIntervalGyroTimeStamp;
    long mIntervalMgnTimeStamp;
    long MF_CLASS376_o1072;
    long MF_CLASS376_p1073;
    long mIntervalTemperatureTimeStamp;
    long mIntervalProximityTimeStamp;
//    float MF_CLASS376_s1053;
//    float MF_CLASS376_t1054;
    float MF_CLASS376_u1055_float_fld;
    float MF_CLASS372_v1035;
    float MF_CLASS376_w1057_float_fld;
    float MF_CLASS376_x1058_float_fld;
    int MF_CLASS376_y1059_int_fld;
    long MF_CLASS376_z1087;
}
