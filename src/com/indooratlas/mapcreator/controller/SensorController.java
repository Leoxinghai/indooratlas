// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

//SensorController

import android.content.Context;
import android.hardware.*;
import android.location.LocationManager;
import android.os.*;
import com.indooratlas.Signal.SignalProcessingUtil;
import com.indooratlas.cursor.list.*;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.mapcreator.main.CLASS314;
import com.indooratlas.mapcreator.main.MapScreen;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.type.CLASS48;
import com.indooratlas.sensor.SensorEventProcessor;
import com.indooratlas.sensor.CLASS375;
import com.indooratlas.sensor.type.*;
import com.indooratlas.task.CLASS42;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS167, CLASS162, CLASS161, CLASS160,
//            CLASS113

public class SensorController extends HandlerThread
    implements CLASS158
{

    public SensorController(Context context, MapScreen mapscreen, CLASS48 b)
    {
        super("SensorController");
        MF_CLASS158_a563 = false;
        mLocationManager = null;
        MF_CLASS159_ap582 = false;
        MF_CLASS159_aq583 = false;
        MF_CLASS113_b487 = 0L;
        MF_CLASS375_c1047 = 0L;
        MF_CLASS375_d1048 = 0L;
        MF_CLASS158_e564 = 0L;
        MF_CLASS158_f565 = 0L;
        MF_CLASS158_g566 = 0;
        MF_CLASS158_h567 = 0L;
//        mMaxQueueLen = 1000;
        mMaxQueueLen = 1;
        mMapScreen = null;
        MF_CLASS159_as585 = false;
        isGyroCollected = false;
        MF_CLASS159_au587 = false;
        MF_CLASS159_av588 = false;
        MF_CLASS159_j572 = null;
        MF_CLASS159_k573 = NumberFormat.getInstance(Locale.US);
        MF_CLASS159_l574 = NumberFormat.getInstance(Locale.US);
        MF_CLASS159_aw589 = 0;
        MF_CLASS159_ax590 = null;
        mPrevMgnTimeStamp = 0L;
        freq = "0";
        mGyroQueue = null;
        mAccQueue = null;
        mMgnQueue = null;
        mBarometerQueue = null;
        mRGBQueue = null;
        mTemperatureQueue = null;
        mProximityQueue = null;
        mLastRGBTimeStamp = 0L;
        mIntervalGyroTimeStamp = 0L;
        mLastGyroTimeStamp = 0L;
        mLastAccTimeStamp = 0L;
        mLastMgnTimeStamp = 0L;
        MF_CLASS159_y605_long_fld = 0L;
        mIntervalProximityTimeStamp = 0L;
        A = 0.0F;
        B = 0.0F;
        C = 0.0F;
        D = 0.0F;
        E = 0.0F;
        F = 0.0F;
        G = 3;
        H = 0.0F;
        I = 0.0F;
        J = 0.0F;
        K = 0.0F;
        L = 0.0F;
        M = 0.0F;
        N = 0.0F;
        O = 0.0F;
        P = 0.0F;
        Q = 0.0F;
        MF_CLASS159_r598_long_fld = 0L;
        mLastProximityTimeStamp = 0L;
        mLastRGBTimeStamp = 0L;
        mIntervalGyroTimeStamp = 0L;
        mLastGyroTimeStamp = 0L;
        mLastAccTimeStamp = 0L;
        mLastMgnTimeStamp = 0L;
        MF_CLASS159_y605_float_fld = 0.0F;
        Z = 0.0F;
        MF_CLASS159_aa607_float_fld = 0.0F;
        MF_CLASS159_ab608_float_fld = 0.0F;
        MF_CLASS159_ac609_float_fld = 0.0F;
        MF_CLASS159_ad610_float_fld = 0.0F;
        normOrig = 0.0F;
        MF_CLASS159_ag612 = null;
        MF_CLASS159_aa607_boolean_fld = false;
        mSensorDataQueue = null;
        mSensorEventProcessor = null;
        MF_CLASS159_ai614 = false;
        MF_CLASS159_ac609_long_fld = 0L;
        MF_CLASS159_ad610_boolean_fld = false;
        MF_CLASS159_aj615 = false;
        MF_CLASS159_ak616 = null;
        mCalibtionHandler = null;
        MF_CLASS159_af580 = 1 + MF_CLASS159_af580;
        CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("SensorController constructor, cnt = ").append(MF_CLASS159_af580).toString());
        mMapScreen = mapscreen;
        MF_CLASS159_ak616 = b;
        MF_CLASS159_ag612 = this;
        MF_CLASS158_a563(50D);
        MF_CLASS113_b487(50D);
        setMgnInterval(50D);
        setBarmeterInterval(50D);
        MF_CLASS158_e564(50D);
        setIntervalProximity(50D);
        MF_CLASS158_f565(50D);
        mSensorManager = (SensorManager)context.getSystemService("sensor");
        mSensorListener = new CLASS162(this);
        mSensorDataQueue = new ConcurrentLinkedQueue();
        mLocationManager = (LocationManager)context.getSystemService("location");
        MF_CLASS159_k573.setMinimumFractionDigits(2);
        MF_CLASS159_k573.setMaximumFractionDigits(2);
        MF_CLASS159_l574 = NumberFormat.getInstance(Locale.US);
        MF_CLASS159_l574.setMinimumFractionDigits(0);
        MF_CLASS159_l574.setMaximumFractionDigits(0);
        
        mLastMgnTimeStamp = 0L;
    }

    private CLASS375 MF_CLASS158_a563(SensorEvent sensorevent, long l)
    {
        CLASS375 class375 = new CLASS375(sensorevent.values.length);
        class375.setSensorType(sensorevent.sensor.getType());
        class375.MF_CLASS375_a1045(sensorevent.accuracy);
        class375.setTimeStamp(l);
        for(int i = 0; i < sensorevent.values.length; i++)
            class375.getEventData()[i] = sensorevent.values[i];

        return class375;
    }

    static CLASS375 MF_CLASS158_a563(SensorController class159, SensorEvent sensorevent, long l)
    {
        return class159.MF_CLASS158_a563(sensorevent, l);
    }

    static ConcurrentLinkedQueue sGetSensorDataQueue(SensorController class159)
    {
        return class159.mSensorDataQueue;
    }

    private void insertToDatabase(Object obj, int i)
    {
        CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("insertToDatabase(): creating new InsertDataTask() sensorType == ").append(i).toString());
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = obj;
        if(MF_CLASS159_aq583)
        {
            CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("insertToDatabase(): mCollectingData && !mCalibrating: MapScreen.currentMeasurement = ").append(MapScreen.currentMeasurement).toString());
            aobj[2] = Long.valueOf(MapScreen.currentMeasurement.mMeasurementID);
            aobj[3] = Boolean.valueOf(false);
            MF_CLASS159_ax590.add(MF_CLASS159_aw589, (new CLASS161(this, MF_CLASS159_aw589)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ((Object []) (new Object[][] {
                aobj
            }))));
        } else
        {
            CLASS167.MF_CLASS167_b635("SensorController", "insertToDatabase(): ERROR: nothing to store, not collecting data or calibrating...?");
        }
        MF_CLASS159_aw589 = 1 + MF_CLASS159_aw589;
    }

    static boolean MF_CLASS113_b487(SensorController class159)
    {
        return class159.MF_CLASS159_ad610_boolean_fld;
    }

    static ArrayList MF_CLASS375_c1047(SensorController class159)
    {
        return class159.MF_CLASS159_ax590;
    }

    private void MF_CLASS159_i571()
    {
        MF_CLASS159_r598_long_fld = 0L;
        mLastProximityTimeStamp = 0L;
        mLastRGBTimeStamp = 0L;
        mIntervalGyroTimeStamp = 0L;
        mLastGyroTimeStamp = 0L;
        mLastAccTimeStamp = 0L;
        mLastMgnTimeStamp = 0L;
        MF_CLASS159_ac609_long_fld = 0L;
        mLastMgnTimeStamp = 0L;
    }

    private void MF_CLASS159_j572()
    {
        String s = MF_CLASS159_k573.format(A);
        String s1 = MF_CLASS159_k573.format(B);
        String s2 = MF_CLASS159_k573.format(C);
        String s3 = MF_CLASS159_k573.format(G);
        String s4 = MF_CLASS159_k573.format(D);
        String s5 = MF_CLASS159_k573.format(E);
        String s6 = MF_CLASS159_k573.format(F);
        String s7 = MF_CLASS159_k573.format(H);
        String s8 = MF_CLASS159_k573.format(I);
        String s9 = MF_CLASS159_k573.format(J);
        String s10 = MF_CLASS159_k573.format(K);
        String s11 = MF_CLASS159_k573.format(L);
        String s12 = MF_CLASS159_k573.format(M);
        String s13 = MF_CLASS159_k573.format(N);
        double ad[] = new double[3];
        ad[0] = A;
        ad[1] = B;
        ad[2] = C;
        float f = 1000F * (1000F * (1000F * (100F / (float)(mLastMgnTimeStamp - mPrevMgnTimeStamp))));
        mPrevMgnTimeStamp = mLastMgnTimeStamp;
        freq = MF_CLASS159_k573.format(f);
        mMapScreen.onDebug((new StringBuilder()).append("sensors: mx = ").append(s).append(", my = ").append(s1).append(", mz = ").append(s2).append(", accu = ").append(s3).append("\nmxb = ").append(s4).append(", myb = ").append(s5).append(", mzb = ").append(s6).append("\nax = ").append(s7).append(", ay = ").append(s8).append(", az = ").append(s9).append("\ngx = ").append(s10).append(", gy = ").append(s11).append(", gz = ").append(s12).append("\npressure = ").append(s13).append("\nnormOrig = ").append(normOrig).append("\nfreq = ").append(freq).toString());
    }

    private void restart()
    {
    	mSensorDataQueue.clear();
        if(mSensorEventProcessor != null)
        	mSensorEventProcessor.stopSensorEventProcessor();
        mSensorEventProcessor = new SensorEventProcessor(this);
        mSensorEventProcessor.start();
    }

    private void stopSensorProcessor()
    {
        CLASS167.MF_CLASS167_b635("SensorController", "stopSensorProcessor(): called");
        if(mSensorEventProcessor != null)
        {
        	mSensorEventProcessor.stopSensorEventProcessor();
        	mSensorEventProcessor = null;
        }
    }

    public int MF_CLASS158_a563()
    {
        int i = 0;
        int j = 0;
        for(; i < MF_CLASS159_ax590.size(); i++)
            if(((AsyncTask)MF_CLASS159_ax590.get(i)).getStatus() != android.os.AsyncTask.Status.FINISHED)
                j++;

        return j;
    }

    public void MF_CLASS158_a563(double d)
    {
    	mIntervalAccTimeStamp = MF_CLASS158_h567(d);
    }

    public void notifySensorError(int i)
    {
        if(!MF_CLASS159_aj615)
        {
            CLASS167.MF_CLASS167_b635("SensorController", "notifySensorError(), setting mInformedSensorError = true");
            CLASS75.MF_CLASS75_a259(5, "SENSOR_ERROR", SensorController.class, (new StringBuilder()).append("SensorController: sensor error : type = ").append(i).toString());
            MF_CLASS159_aj615 = true;
            MF_CLASS159_ak616.notifySensorError(i, CLASS369.RECORDING_PATH);
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635("SensorController", "notifySensorError(), already informed, skipping...");
            return;
        }
    }

    public void setFirstTimeStamp(long l)
    {
        MF_CLASS159_ac609_long_fld = l;
    }

    public void parseCalibrateEvent(CLASS375 class375)
    {
        long l;
        l = class375.mTimeStamp;
        CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent, event = ").append(class375).append(", event.getSensorType() = ").append(class375.getSensorType()).append(", Sensor.TYPE_GYROSCOPE = ").append(4).append(", Sensor.TYPE_ACCELEROMETER = ").append(1).append(", Sensor.TYPE_MAGNETIC_FIELD = ").append(2).append(", Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED = ").append(14).append(", THREAD = ").append(Thread.currentThread().getName()).toString());
        switch(class375.getSensorType()) {
    //  JVM INSTR tableswitch 1 16: default 180
    //                   1 528
    //                   2 718
    //                   3 180
    //                   4 338
    //                   5 1396
    //                   6 1270
    //                   7 180
    //                   8 1521
    //                   9 180
    //                   10 180
    //                   11 180
    //                   12 180
    //                   13 1647
    //                   14 718
    //                   15 180
    //                   16 338;
    //     goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L1 _L7 _L1 _L1 _L1 _L1 _L8 _L3 _L1 _L4
default:
case 3:
case 7:
case 9:
case 10:
case 11:
case 12:
case 15:
        long l1 = MF_CLASS158_h567 % 100L;
        if(MF_CLASS159_av588 && !mMapScreen.mUpdatingLocation && l1 == 0L)
            MF_CLASS159_j572();
        if(MF_CLASS159_aq583)
        {
            long l2 = System.nanoTime() - MF_CLASS375_c1047;
            if(l2 > 0x8bb2c97000L && !MF_CLASS158_a563)
            {
                MF_CLASS158_a563 = true;
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent(): MEASUREMENT MAXIMUM DURATION LIMIT EXCEEDED! Stopping recording automatically!, tsNano = ").append(l).append(", mMeasurementStartTimeNano = ").append(MF_CLASS375_c1047).append(", duration = ").append(l2).toString());
                mMapScreen.showOkButtonDialog(mMapScreen.getString(0x7f080027));
                mMapScreen.runOnUiThread(new CLASS160(this));
            }
        }
        return;
        
        case 4:
        case 16:
        if(l - mLastGyroTimeStamp > mIntervalGyroTimeStamp)
        {
        	mLastGyroTimeStamp = l;
            K = (float)class375.eventData[0];
            L = (float)class375.eventData[1];
            M = (float)class375.eventData[2];
            isGyroCollected = true;
            if(MF_CLASS159_aq583)
            {
                long l5 = mLastGyroTimeStamp - MF_CLASS159_ac609_long_fld;
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent, GYRO: ts = ").append(l5).toString());
                CLASS26 class26 = new CLASS26(K, L, M, l5);
                mGyroQueue.add(class26);
                if(mGyroQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mGyroQueue, 4);
                    }
                    catch(Exception exception6)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception6.printStackTrace();
                    }
                    mGyroQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        break;
        
        case 1:
        if(l - mLastAccTimeStamp > mIntervalAccTimeStamp)
        {
        	mLastAccTimeStamp = l;
            H = (float)class375.eventData[0];
            I = (float)class375.eventData[1];
            J = (float)class375.eventData[2];
            MF_CLASS159_as585 = true;
            if(MF_CLASS159_aq583)
            {
                long l4 = mLastAccTimeStamp - MF_CLASS159_ac609_long_fld;
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent, ACC: ts = ").append(l4).toString());
                CLASS23 class23 = new CLASS23(H, I, J, l4);
                mAccQueue.add(class23);
                if(mAccQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mAccQueue, 1);
                    }
                    catch(Exception exception5)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception5.printStackTrace();
                    }
                    mAccQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        break;
        
        case 2:
        case 14:
        	
        if(l - mLastMgnTimeStamp > mIntervalMgnTimeStamp)
        {
            MF_CLASS158_h567 = 1L + MF_CLASS158_h567;
            if(MF_CLASS158_h567 > 1L)
            {
                double ad[] = new double[3];
                ad[0] = A;
                ad[1] = B;
                ad[2] = C;
                if(SignalProcessingUtil.outlierDetection(class375.eventData, ad, l, mLastMgnTimeStamp, 100D, 0x2faf080L) && CLASS113.isDeviceChecked.booleanValue())
                {
                	mMapScreen.vibrate(100);
                	mMapScreen.showToastMessage("Outlier detected!", 0);
                }
            }
            mLastMgnTimeStamp = l;
            A = (float)class375.eventData[0];
            B = (float)class375.eventData[1];
            C = (float)class375.eventData[2];
            if(MF_CLASS159_aa607_boolean_fld)
            {
                G = 3;
                D = (float)class375.eventData[3];
                E = (float)class375.eventData[4];
                F = (float)class375.eventData[5];
            } else
            {
                G = (int)class375.MF_CLASS375_c1047;
                D = 0.0F;
                E = 0.0F;
                F = 0.0F;
            }
            MF_CLASS159_au587 = true;
            CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent:mSampleIndex = ").append(MF_CLASS158_h567).append(",  mgnTimestamp = ").append(mLastMgnTimeStamp).append(", accuracy = ").append(G).append(", event.values.length = ").append(class375.eventData.length).append(", values = ").append(Arrays.toString(class375.eventData)).toString());
            if(G != 3 && MF_CLASS159_aq583 && mMapScreen.mMode == CLASS314.SEGMENT_DATA)
            {
                CLASS167.MF_CLASS167_b635("SensorController", "handleSensorEvent: STARTING RE-CALIBRATION ");
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent: accuracy has dropped, accuracy = ").append(G).toString());
                mMapScreen.setReCalibrationRequired(true);
            }
            if(MF_CLASS159_aq583)
            {
                long l3 = mLastMgnTimeStamp - MF_CLASS159_ac609_long_fld;
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("handleSensorEvent, MGN: ts = ").append(l3).append(", mFirstSensorMeasurementNano = ").append(MF_CLASS159_ac609_long_fld).append(", mgnTimestamp = ").append(mLastMgnTimeStamp).toString());
                CLASS29 class29 = new CLASS29(A, B, C, l3, G);
                mMgnQueue.add(class29);
                if(mMgnQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mMgnQueue, 2);
                    }
                    catch(Exception exception4)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception4.printStackTrace();
                    }
                    mMgnQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        break;
        
        case 6:
        if(l - mLastBarometerTimeStamp > mIntervalBarmeterTimeStamp)
        {
        	mLastBarometerTimeStamp = l;
            N = (float)class375.eventData[0];
            if(MF_CLASS159_aq583)
            {
                CLASS30 class30 = new CLASS30(N, mLastBarometerTimeStamp - MF_CLASS159_ac609_long_fld);
                mBarometerQueue.add(class30);
                if(mBarometerQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mBarometerQueue, 6);
                    }
                    catch(Exception exception3)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception3.printStackTrace();
                    }
                    mBarometerQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        break;
        
        case 5:
        if(l - mLastRGBTimeStamp > mIntervalRGBTimeStamp)
        {
        	mLastRGBTimeStamp = l;
            O = (float)class375.eventData[0];
            if(MF_CLASS159_aq583)
            {
                CLASS28 class28 = new CLASS28(O, mLastRGBTimeStamp - MF_CLASS159_ac609_long_fld);
                mRGBQueue.add(class28);
                if(mRGBQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mRGBQueue, 5);
                    }
                    catch(Exception exception2)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception2.printStackTrace();
                    }
                    mRGBQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        break;
        
        case 8:
        if(l - mLastProximityTimeStamp > mIntervalProximityTimeStamp)
        {
        	mLastProximityTimeStamp = l;
            P = (float)class375.eventData[0];
            if(MF_CLASS159_aq583)
            {
                CLASS31 class31 = new CLASS31(P, mLastProximityTimeStamp - MF_CLASS159_ac609_long_fld);
                mProximityQueue.add(class31);
                if(mProximityQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mProximityQueue, 8);
                    }
                    catch(Exception exception1)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception1.printStackTrace();
                    }
                    mProximityQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        break;
        
        case 13:
        if(l - MF_CLASS159_r598_long_fld > MF_CLASS159_y605_long_fld)
        {
            MF_CLASS159_r598_long_fld = l;
            Q = (float)class375.eventData[0];
            if(MF_CLASS159_aq583)
            {
                CLASS32 class32 = new CLASS32(Q, MF_CLASS159_r598_long_fld - MF_CLASS159_ac609_long_fld);
                mTemperatureQueue.add(class32);
                if(mTemperatureQueue.size() > mMaxQueueLen)
                {
                    try
                    {
                    	insertToDatabase(mTemperatureQueue, 13);
                    }
                    catch(Exception exception)
                    {
                        if(CLASS113.isExceptionLogged.booleanValue())
                            exception.printStackTrace();
                    }
                    mTemperatureQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        
       }
    }

    public void startSensors(boolean flag)
    {
        CLASS167.MF_CLASS167_b635("SensorController", "startSensors: called.");
        MF_CLASS158_h567 = 0L;
        MF_CLASS159_ad610_boolean_fld = flag;
        Sensor sensor2;
        boolean flag3;
        Sensor sensor3;
        Sensor sensor4;
        Sensor sensor5;
        Sensor sensor6;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        
        if(!MF_CLASS159_ap582)
        {
            MF_CLASS159_ap582 = true;
            Sensor sensor = mSensorManager.getDefaultSensor(1);
            boolean flag1 = mSensorManager.registerListener(mSensorListener, sensor, 0, mCalibtionHandler);
            CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).append(", started = ").append(flag1).toString());
            if(android.os.Build.VERSION.SDK_INT >= 18)
            {
                CLASS167.MF_CLASS167_b635("SensorController", "startSensors: starting uncalibrated mgn sensor");
                Sensor sensor7 = mSensorManager.getDefaultSensor(14);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("startSensors: got uncalibrated mgn sensor = ").append(sensor7).toString());
                if(sensor7 == null)
                {
                    CLASS167.MF_CLASS167_b635("SensorController", "startSensors: PLATFORM WAS > 4.3, BUT sensor == null --> starting *calibrated* mgn sensor");
                    sensor7 = mSensorManager.getDefaultSensor(2);
                } else
                {
                    MF_CLASS159_aa607_boolean_fld = true;
                }
                flag8 = mSensorManager.registerListener(mSensorListener, sensor7, 0, mCalibtionHandler);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor7.getName()).append(", type = ").append(sensor7.getType()).append(", vendor = ").append(sensor7.getVendor()).append(", maxRange = ").append(sensor7.getMaximumRange()).append(", resolution = ").append(sensor7.getResolution()).append(", power = ").append(sensor7.getPower()).append(", started = ").append(flag8).toString());
            } else
            {
                CLASS167.MF_CLASS167_b635("SensorController", "startSensors: starting *calibrated* mgn sensor");
                Sensor sensor1 = mSensorManager.getDefaultSensor(2);
                boolean flag2 = mSensorManager.registerListener(mSensorListener, sensor1, 0, mCalibtionHandler);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor1.getName()).append(", type = ").append(sensor1.getType()).append(", vendor = ").append(sensor1.getVendor()).append(", maxRange = ").append(sensor1.getMaximumRange()).append(", resolution = ").append(sensor1.getResolution()).append(", power = ").append(sensor1.getPower()).append(", started = ").append(flag2).toString());
            }
            sensor2 = mSensorManager.getDefaultSensor(4);
            flag3 = mSensorManager.registerListener(mSensorListener, sensor2, 0, mCalibtionHandler);
            CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor2.getName()).append(", type = ").append(sensor2.getType()).append(", vendor = ").append(sensor2.getVendor()).append(", maxRange = ").append(sensor2.getMaximumRange()).append(", resolution = ").append(sensor2.getResolution()).append(", power = ").append(sensor2.getPower()).append(", started = ").append(flag3).toString());
            sensor3 = mSensorManager.getDefaultSensor(6);
            if(sensor3 != null)
            {
                flag7 = mSensorManager.registerListener(mSensorListener, sensor3, 0, mCalibtionHandler);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor3.getName()).append(", type = ").append(sensor3.getType()).append(", vendor = ").append(sensor3.getVendor()).append(", maxRange = ").append(sensor3.getMaximumRange()).append(", resolution = ").append(sensor3.getResolution()).append(", power = ").append(sensor3.getPower()).append(", started = ").append(flag7).toString());
            }
            sensor4 = mSensorManager.getDefaultSensor(13);
            if(sensor4 != null)
            {
                flag6 = mSensorManager.registerListener(mSensorListener, sensor4, 0, mCalibtionHandler);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor4.getName()).append(", type = ").append(sensor4.getType()).append(", vendor = ").append(sensor4.getVendor()).append(", maxRange = ").append(sensor4.getMaximumRange()).append(", resolution = ").append(sensor4.getResolution()).append(", power = ").append(sensor4.getPower()).append(", started = ").append(flag6).toString());
            }
            sensor5 = mSensorManager.getDefaultSensor(5);
            if(sensor5 != null)
            {
                flag5 = mSensorManager.registerListener(mSensorListener, sensor5, 0, mCalibtionHandler);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor5.getName()).append(", type = ").append(sensor5.getType()).append(", vendor = ").append(sensor5.getVendor()).append(", maxRange = ").append(sensor5.getMaximumRange()).append(", resolution = ").append(sensor5.getResolution()).append(", power = ").append(sensor5.getPower()).append(", started = ").append(flag5).toString());
            }
            sensor6 = mSensorManager.getDefaultSensor(8);
            if(sensor6 != null)
            {
                flag4 = mSensorManager.registerListener(mSensorListener, sensor6, 0, mCalibtionHandler);
                CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("Starting Sensor: name = ").append(sensor6.getName()).append(", type = ").append(sensor6.getType()).append(", vendor = ").append(sensor6.getVendor()).append(", maxRange = ").append(sensor6.getMaximumRange()).append(", resolution = ").append(sensor6.getResolution()).append(", power = ").append(sensor6.getPower()).append(", started = ").append(flag4).toString());
            }
        }
    }

    public void MF_CLASS113_b487(double d)
    {
    	mIntervalGyroTimeStamp = MF_CLASS158_h567(d);
    }

    public void stopSensors(boolean flag)
    {
        CLASS167.MF_CLASS167_b635("SensorController", "stopSensors: called.");
        if(flag)
        	stopSensorProcessor();
        if(MF_CLASS159_ap582)
        {
            MF_CLASS159_ap582 = false;
            CLASS167.MF_CLASS167_b635("SensorController", "stopSensors: stopping sensors.");
            Sensor sensor7;
            for(Iterator iterator = mSensorManager.getSensorList(1).iterator(); iterator.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor7))
                sensor7 = (Sensor)iterator.next();

            Sensor sensor6;
            for(Iterator iterator1 = mSensorManager.getSensorList(2).iterator(); iterator1.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor6))
                sensor6 = (Sensor)iterator1.next();

            if(android.os.Build.VERSION.SDK_INT >= 18)
            {
                Sensor sensor5;
                for(Iterator iterator7 = mSensorManager.getSensorList(14).iterator(); iterator7.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor5))
                    sensor5 = (Sensor)iterator7.next();

            }
            Sensor sensor4;
            for(Iterator iterator2 = mSensorManager.getSensorList(4).iterator(); iterator2.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor4))
                sensor4 = (Sensor)iterator2.next();

            Sensor sensor3;
            for(Iterator iterator3 = mSensorManager.getSensorList(6).iterator(); iterator3.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor3))
                sensor3 = (Sensor)iterator3.next();

            Sensor sensor2;
            for(Iterator iterator4 = mSensorManager.getSensorList(13).iterator(); iterator4.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor2))
                sensor2 = (Sensor)iterator4.next();

            Sensor sensor1;
            for(Iterator iterator5 = mSensorManager.getSensorList(5).iterator(); iterator5.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor1))
                sensor1 = (Sensor)iterator5.next();

            Sensor sensor;
            for(Iterator iterator6 = mSensorManager.getSensorList(8).iterator(); iterator6.hasNext(); mSensorManager.unregisterListener(mSensorListener, sensor))
                sensor = (Sensor)iterator6.next();

        }
    }

    public boolean startDataCollection()
    {
        if(APIDataBase.MF_CLASS33_c139())
            MF_CLASS159_ai614 = APIDataBase.MF_CLASS33_b138();
        else
            MF_CLASS159_ai614 = false;
        MF_CLASS159_aj615 = false;
        mGyroQueue = new ConcurrentLinkedQueue();
        mAccQueue = new ConcurrentLinkedQueue();
        mMgnQueue = new ConcurrentLinkedQueue();
        mBarometerQueue = new ConcurrentLinkedQueue();
        mRGBQueue = new ConcurrentLinkedQueue();
        mTemperatureQueue = new ConcurrentLinkedQueue();
        mProximityQueue = new ConcurrentLinkedQueue();
        MF_CLASS113_b487 = System.currentTimeMillis();
        MF_CLASS375_c1047 = System.nanoTime();
        CLASS167.MF_CLASS167_b635("SensorController", (new StringBuilder()).append("startDataCollection: mMeasurementStartTimeNano = ").append(MF_CLASS375_c1047).append(", mMeasurementStartTime = ").append(MF_CLASS113_b487).toString());
        MF_CLASS159_i571();
        startSensors(false);
        MF_CLASS159_aw589 = 0;
        MF_CLASS159_ax590 = new ArrayList();
        MF_CLASS159_aq583 = true;
        restart();
        return true;
    }

    public void stopDataCollection()
    {
        CLASS167.MF_CLASS167_b635("SensorController", "stopDataCollection(): STOP_SENSORS_WHEN_NOT_USED --> just stopping SensorEventProcessor");
        stopSensorProcessor();
        if(MF_CLASS159_aq583)
        {
            MF_CLASS375_d1048 = System.currentTimeMillis();
            MF_CLASS158_e564 = System.nanoTime();
            try
            {
            	insertToDatabase(mGyroQueue, 4);
            }
            catch(Exception exception)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception.printStackTrace();
            }
            mGyroQueue = new ConcurrentLinkedQueue();
            try
            {
            	insertToDatabase(mAccQueue, 1);
            }
            catch(Exception exception1)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception1.printStackTrace();
            }
            mAccQueue = new ConcurrentLinkedQueue();
            try
            {
            	insertToDatabase(mMgnQueue, 2);
            }
            catch(Exception exception2)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception2.printStackTrace();
            }
            mMgnQueue = new ConcurrentLinkedQueue();
            try
            {
            	insertToDatabase(mBarometerQueue, 6);
            }
            catch(Exception exception3)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception3.printStackTrace();
            }
            mBarometerQueue = new ConcurrentLinkedQueue();
            try
            {
            	insertToDatabase(mRGBQueue, 5);
            }
            catch(Exception exception4)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception4.printStackTrace();
            }
            mRGBQueue = new ConcurrentLinkedQueue();
            try
            {
            	insertToDatabase(mProximityQueue, 8);
            }
            catch(Exception exception5)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception5.printStackTrace();
            }
            mProximityQueue = new ConcurrentLinkedQueue();
            try
            {
            	insertToDatabase(mTemperatureQueue, 13);
            }
            catch(Exception exception6)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception6.printStackTrace();
            }
            mTemperatureQueue = new ConcurrentLinkedQueue();
        }
        MF_CLASS159_aq583 = false;
    }

    public void setMgnInterval(double d)
    {
    	mIntervalMgnTimeStamp = MF_CLASS158_h567(d);
    }

    public void MF_CLASS375_c1047(boolean flag)
    {
        MF_CLASS159_av588 = flag;
    }

    public void setBarmeterInterval(double d)
    {
    	mIntervalBarmeterTimeStamp = MF_CLASS158_h567(d);
    }

    public boolean MF_CLASS375_d1048()
    {
        return MF_CLASS159_av588;
    }

    public ConcurrentLinkedQueue sensorEventQueue()
    {
        return mSensorDataQueue;
    }

    public void MF_CLASS158_e564(double d)
    {
    	mIntervalRGBTimeStamp = MF_CLASS158_h567(d);
    }

    public void MF_CLASS158_f565(double d)
    {
        MF_CLASS159_y605_long_fld = MF_CLASS158_h567(d);
    }

    public boolean MF_CLASS158_f565()
    {
        return true;
    }

    public void informTimestampError()
    {
        try {
	    	CLASS167.MF_CLASS167_b635("SensorController", "informTimestampError() called");
	        CLASS75.MF_CLASS75_a259(5, "TIMESTAMP_ERROR", SensorController.class, "SensorController: timestamp error");
	        ConcurrentLinkedQueue concurrentlinkedqueue = mSensorDataQueue;
	        CLASS167.MF_CLASS167_b635("SensorController", "informTimestampError(): within synchronized");
	        if(!MF_CLASS159_aq583) {
	            MF_CLASS159_ai614 = true;
	            MF_CLASS159_i571();
	            if(CLASS113.isDeviceChecked.booleanValue() && CLASS113.isExceptionLogged.booleanValue())
	            	mMapScreen.showToastMessage("Sensor timestamp error. Was not recording data.", 0);
	        } else {
		        CLASS167.MF_CLASS167_b635("SensorController", "informTimestampError() : cancelling path recording");
		        if(!MF_CLASS159_ai614)
		        {
		            MF_CLASS159_ai614 = true;
		            MF_CLASS159_ak616.notifyTimestampError(CLASS369.RECORDING_PATH);
		        }
	        }
	        return;
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }

    public void setIntervalProximity(double d)
    {
    	mIntervalProximityTimeStamp = MF_CLASS158_h567(d);
    }

    public long MF_CLASS158_h567(double d)
    {
        return (long)(1000000000D / d);
    }

    public void MF_CLASS158_h567()
    {
    }

    public void onLooperPrepared()
    {
    	mCalibtionHandler = new Handler(getLooper());
    }

    static int MF_CLASS159_af580 = 0;
    float A;
    float B;
    float C;
    float D;
    float E;
    float F;
    int G;
    float H;
    float I;
    float J;
    float K;
    float L;
    float M;
    float N;
    float O;
    float P;
    float Q;
    long MF_CLASS159_r598_long_fld;
    long mLastProximityTimeStamp;
    long mLastRGBTimeStamp;
    long mIntervalGyroTimeStamp;
    long mLastGyroTimeStamp;
    long mLastAccTimeStamp;
    long mLastMgnTimeStamp;
    float MF_CLASS159_y605_float_fld;
    float Z;
    public boolean MF_CLASS158_a563;
    private boolean MF_CLASS159_aa607_boolean_fld;
    private ConcurrentLinkedQueue mSensorDataQueue;
    private long MF_CLASS159_ac609_long_fld;
    private boolean MF_CLASS159_ad610_boolean_fld;
    float MF_CLASS159_aa607_float_fld;
    float MF_CLASS159_ab608_float_fld;
    float MF_CLASS159_ac609_float_fld;
    float MF_CLASS159_ad610_float_fld;
    float normOrig;
    SensorController MF_CLASS159_ag612;
    SensorEventProcessor mSensorEventProcessor;
    boolean MF_CLASS159_ai614;
    boolean MF_CLASS159_aj615;
    CLASS48 MF_CLASS159_ak616;
    Handler mCalibtionHandler;
    private SensorManager mSensorManager;
    private CLASS162 mSensorListener;
    private LocationManager mLocationManager;
    private boolean MF_CLASS159_ap582;
    private boolean MF_CLASS159_aq583;
    private int mMaxQueueLen;
    private boolean MF_CLASS159_as585;
    private boolean isGyroCollected;
    private boolean MF_CLASS159_au587;
    private boolean MF_CLASS159_av588;
    private int MF_CLASS159_aw589;
    private ArrayList MF_CLASS159_ax590;
    private long mPrevMgnTimeStamp;
    private String freq;
    public long MF_CLASS113_b487;
    public long MF_CLASS375_c1047;
    public long MF_CLASS375_d1048;
    public long MF_CLASS158_e564;
    public long MF_CLASS158_f565;
    public int MF_CLASS158_g566;
    public long MF_CLASS158_h567;
    public MapScreen mMapScreen;
    CLASS42 MF_CLASS159_j572;
    NumberFormat MF_CLASS159_k573;
    NumberFormat MF_CLASS159_l574;
    public ConcurrentLinkedQueue mGyroQueue;
    public ConcurrentLinkedQueue mAccQueue;
    public ConcurrentLinkedQueue mMgnQueue;
    public ConcurrentLinkedQueue mBarometerQueue;
    public ConcurrentLinkedQueue mRGBQueue;
    public ConcurrentLinkedQueue mTemperatureQueue;
    public ConcurrentLinkedQueue mProximityQueue;
    long mIntervalAccTimeStamp;
    long mLastBarometerTimeStamp;
    long mIntervalMgnTimeStamp;
    long mIntervalBarmeterTimeStamp;
    long mIntervalRGBTimeStamp;
    long MF_CLASS159_y605_long_fld;
    long mIntervalProximityTimeStamp;

}
