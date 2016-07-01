// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.sensor;

import android.os.SystemClock;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.position.CLASS72;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.type.CLASS158;
import com.indooratlas.sensor.type.CLASS158;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.indooratlas.sensor:
//            CLASS375, CLASS374, CLASS373

public class SensorEventProcessor extends Thread
{

    public SensorEventProcessor(CLASS158 a)
    {
//        MF_CLASS373_a1036 = null;
    	isRunning = false;
        MF_CLASS372_w1014 = 0L;
        MF_CLASS372_x1015 = 0L;
        MF_CLASS372_y1016 = 0L;
        MF_CLASS373_c1038 = false;
        MF_CLASS375_d1048 = false;
        mAccTimeStamp = 0L;
        mGyroTimeStamp = 0L;
        mMgnTimeStamp = 0L;
        MF_CLASS372_k1023 = 0L;
        MF_CLASS372_l1024 = false;
        mSkippedEvents = 0;
        MF_CLASS372_n1026 = 0L;
        mFirstAccTSMillis = 0L;
        mFirstGyroTSMillis = 0L;
        mFirstMgnTSMillis = 0L;
        MF_CLASS372_r1030 = 0L;
        MF_CLASS372_s1031 = 0L;
        MF_CLASS372_t1032 = 0L;
        mFirstTemperatureTSMillis = 0L;
        mFirstTimeStamp = 0L;
        MF_CLASS372_v1035 = false;
        sensorImpl = a;
        CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("SensorEventProcessor(): ").append(toString()).toString());
        MF_CLASS372_v1035 = APIDataBase.MF_CLASS33_c139();
    }

    private void MF_CLASS373_a1036(CLASS375 class375)
    {
        int i = MF_CLASS373_c1038(class375);
        if(i != -1 && !MF_CLASS373_c1038())
        {
            CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("SensorEventProcessor.run(): informing jammed sensor: this = ").append(this).append(", thread = ").append(Thread.currentThread()).toString());
            MF_CLASS373_a1036(true);
            sensorImpl.notifySensorError(i);
        }
    }

    private void MF_CLASS373_a1036(double ad[], double ad1[])
    {
        for(int i = 0; i < ad1.length; i++)
            ad1[i] = ad[i];

    }

    private boolean MF_CLASS373_a1036(double ad[])
    {
        for(int i = 0; i < ad.length; i++)
            if(ad[i] != 0.0D)
                return false;

        return true;
    }

    private boolean MF_CLASS373_b1037(CLASS375 class375)
    {
        if(class375 == null) 
        	return false;

        switch(class375.getSensorType()) {
//        JVM INSTR lookupswitch 5: default 60
    //                   1: 90
    //                   2: 116
    //                   4: 62
    //                   14: 116
    //                   16: 62;
  //         goto _L2 _L3 _L4 _L5 _L4 _L5
default:
        return false;
case 4:
case 16:
        boolean flag2 = MF_CLASS373_b1037(class375.eventData, MF_CLASS372_i1021);
        MF_CLASS373_a1036(class375.eventData, MF_CLASS372_i1021);
        return flag2;
case 1:
        boolean flag1 = MF_CLASS373_b1037(class375.eventData, MF_CLASS372_j1022);
        MF_CLASS373_a1036(class375.eventData, MF_CLASS372_j1022);
        return flag1;
case 2:
case 14:
        boolean flag = MF_CLASS373_b1037(class375.eventData, MF_CLASS372_h1020);
        MF_CLASS373_a1036(class375.eventData, MF_CLASS372_h1020);
        return flag;
        }
    }

    private static boolean MF_CLASS373_b1037(double ad[], double ad1[])
    {
        for(int i = 0; i < ad1.length; i++)
            if(ad1[i] != ad[i])
                return false;

        return true;
    }

    private int MF_CLASS373_c1038(CLASS375 class375)
    {
        long l;
        long l1;
        long l2;
        long l3;
        long l4 =0;
        
        l = SystemClock.elapsedRealtime();
        l1 = l - MF_CLASS372_x1015;
        l2 = l - MF_CLASS372_w1014;
        l3 = l - MF_CLASS372_y1016;
        if(class375 != null) {

        switch(class375.getSensorType()) {
//        JVM INSTR lookupswitch 5: default 88
    //                   1: 126
    //                   2: 134
    //                   4: 118
    //                   14: 134
    //                   16: 118;
//           goto _L2 _L3 _L4 _L5 _L4 _L5
default:
        l4 = SystemClock.elapsedRealtime() - MF_CLASS372_k1023;
        if(l1 > 30000L && l4 > 30000L)
            return 4;
        break; /* Loop/switch isn't completed */
        case 4:
        case 16:
        MF_CLASS372_x1015 = l;
        break;
        case 1:
        MF_CLASS372_w1014 = l;
        break;
        case 2:
        case 14:
        MF_CLASS372_y1016 = l;
        break;
        }
        } else {
            l4 = SystemClock.elapsedRealtime() - MF_CLASS372_k1023;
            if(l1 > 30000L && l4 > 30000L)
                return 4;
        	
        }
         
        if(l2 > 30000L && l4 > 30000L)
            return 1;
        return l3 <= 30000L || l4 <= 30000L ? -1 : 2;
    }

    private CLASS374 checkSensorTimestamps(CLASS375 class375)
    {
        switch(class375.getSensorType()) {
        //JVM INSTR lookupswitch 5: default 56
    //                   1: 158
    //                   2: 169
    //                   4: 147
    //                   14: 169
    //                   16: 147;
//           goto _L1 _L2 _L3 _L4 _L3 _L4
		default:
		        break; /* Loop/switch isn't completed */
		case 4:
		case 16:
			mGyroTimeStamp = class375.getTimeStamp();
		        break;
		case 1:
			mAccTimeStamp = class375.getTimeStamp();
		        break;
		case 2:
		case 14:
			mMgnTimeStamp = class375.getTimeStamp();
		        break;
		}
        
        if(mMgnTimeStamp != 0L && mAccTimeStamp != 0L)
        {
            long l2 = Math.abs(mMgnTimeStamp - mAccTimeStamp);
            if(l2 > 0x2540be400L)
            {
                CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", (new StringBuilder()).append("SensorEventProcessor.checkSensorTimestamps(): diff mgn acc = ").append(l2).append(", --> returning true!").toString());
                return new CLASS374(this, CLASS373.MGNACC, mMgnTimeStamp, mAccTimeStamp);
            }
        }

        if(mMgnTimeStamp != 0L && mGyroTimeStamp != 0L)
        {
            long l1 = Math.abs(mMgnTimeStamp - mGyroTimeStamp);
            if(l1 > 0x2540be400L)
            {
                CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", (new StringBuilder()).append("SensorEventProcessor.checkSensorTimestamps(): diff mgn gyro = ").append(l1).append(", --> returning true!").toString());
                return new CLASS374(this, CLASS373.MGNGYR, mMgnTimeStamp, mGyroTimeStamp);
            }
        }
        if(mAccTimeStamp != 0L && mGyroTimeStamp != 0L)
        {
            long l = Math.abs(mAccTimeStamp - mGyroTimeStamp);
            if(l > 0x2540be400L)
            {
                CLASS75.MF_CLASS75_b260("TIMESTAMPTEST", (new StringBuilder()).append("SensorEventProcessor.checkSensorTimestamps(): diff gyro acc = ").append(l).append(", --> returning true!").toString());
                return new CLASS374(this, CLASS373.ACCGYR, mAccTimeStamp, mGyroTimeStamp);
            }
        }
        return null;
    }

    public long isFirstSensorMeasurementTimeNano(int i, long l)
    {
        long smallestTs = 0L;
        switch(i) {
//        JVM INSTR tableswitch 1 14: default 76
    //                   1 224
    //                   2 242
    //                   3 76
    //                   4 206
    //                   5 278
    //                   6 260
    //                   7 76
    //                   8 296
    //                   9 76
    //                   10 76
    //                   11 76
    //                   12 76
    //                   13 314
    //                   14 242;
//           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L1 _L7 _L1 _L1 _L1 _L1 _L8 _L3
        default:
        case 3:
        case 7:
        case 9:
        case 10:
        case 11:
        case 12:
        	break;
	
        case 4:
        if(mFirstGyroTSMillis == smallestTs)
        	mFirstGyroTSMillis = l;
        break;
        case 1:
        	
        if(mFirstAccTSMillis == smallestTs)
        	mFirstAccTSMillis = l;
        break;
        case 2:
        case 14:

        if(mFirstMgnTSMillis == smallestTs)
        	mFirstMgnTSMillis = l;
        break;
        case 6:
        if(MF_CLASS372_r1030 == smallestTs)
            MF_CLASS372_r1030 = l;
        break;
        case 5:
        if(MF_CLASS372_s1031 == smallestTs)
            MF_CLASS372_s1031 = l;
        break;
        case 8:
        if(MF_CLASS372_t1032 == smallestTs)
            MF_CLASS372_t1032 = l;
        break;
        case 13:
        if(mFirstTemperatureTSMillis == smallestTs)
        	mFirstTemperatureTSMillis = l;
        break;
        }
        if(mFirstGyroTSMillis != smallestTs && mFirstAccTSMillis != smallestTs && mFirstMgnTSMillis != smallestTs)
        {
            long al[] = new long[3];
            al[0] = mFirstGyroTSMillis;
            al[1] = mFirstAccTSMillis;
            al[2] = mFirstMgnTSMillis;
            smallestTs = CLASS72.MF_CLASS72_a237(al);
            CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("storeFirstTimestamps : smallestTs = ").append(smallestTs).append(", mFirstGyroTSMillis = ").append(mFirstGyroTSMillis).append(", mFirstAccTSMillis = ").append(mFirstAccTSMillis).append(", mFirstMgnTSMillis = ").append(mFirstMgnTSMillis).toString());
        }
        return smallestTs;
    }

    public void stopSensorEventProcessor()
    {
    	isRunning = false;
    }

    public void MF_CLASS373_a1036(boolean flag)
    {
        MF_CLASS373_c1038 = flag;
    }

    public void initZero()
    {
        MF_CLASS372_w1014 = 0L;
        MF_CLASS372_x1015 = 0L;
        MF_CLASS372_y1016 = 0L;
        MF_CLASS373_c1038 = false;
        MF_CLASS375_d1048 = false;
        mAccTimeStamp = 0L;
        mGyroTimeStamp = 0L;
        mMgnTimeStamp = 0L;
        MF_CLASS372_k1023 = 0L;
        MF_CLASS372_l1024 = false;
        mSkippedEvents = 0;
        MF_CLASS372_n1026 = 0L;
        mFirstAccTSMillis = 0L;
        mFirstGyroTSMillis = 0L;
        mFirstMgnTSMillis = 0L;
        MF_CLASS372_r1030 = 0L;
        MF_CLASS372_s1031 = 0L;
        MF_CLASS372_t1032 = 0L;
        mFirstTemperatureTSMillis = 0L;
        mFirstTimeStamp = 0L;
    }

    public boolean MF_CLASS373_c1038()
    {
        return MF_CLASS373_c1038;
    }

    public void run()
    {
        
    	try {
    		initZero();
	        CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("SensorEventProcessor.run called this = ").append(this).toString());
	        isRunning = true;
	        MF_CLASS372_k1023 = SystemClock.elapsedRealtime();
	
	        while(true) {
	        if(!sensorImpl.MF_CLASS158_f565() || !isRunning) {
	        	sensorImpl.sensorEventQueue().clear();
	                CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("SensorEventProcessor.run() returning, sensorReader.isListeningSensorEvents() = ").append(sensorImpl.MF_CLASS158_f565()).append(", running = ").append(isRunning).append(" this = ").append(toString()).toString());
	                return;        	
	        }
	
	        long l = SystemClock.elapsedRealtime() - MF_CLASS372_k1023;
	        if(MF_CLASS372_n1026 != 0L && l > MF_CLASS372_n1026) {
	        	CLASS75.MF_CLASS75_b260("SensorEventProcessor", "ERROR Should not be here.");
	            try
	            {
	            	sensorImpl.MF_CLASS158_h567();
	                return;
	            }
	            catch(Exception exception1)
	            {
	                exception1.printStackTrace();
	            	return;
	            }
	        }
	        ConcurrentLinkedQueue concurrentlinkedqueue;
	        CLASS375 class375;
	        CLASS374 class374;
	        boolean flag = false;
	        boolean duplicate = false;
	        String s;
	
	        
	        concurrentlinkedqueue = sensorImpl.sensorEventQueue();
	
	        synchronized(concurrentlinkedqueue) {
	        	
	        try
	        {
		        	if(sensorImpl.sensorEventQueue().size() <= 0) {
		        		Thread.sleep(100);
	//		                MF_CLASS373_a1036(((CLASS375) (null)));
	//		                sensorImpl.sensorEventQueue().wait(20L);
	//		                  continue;        	
			        }
	        }
	        catch(InterruptedException interruptedexception) {
	        	interruptedexception.printStackTrace();
	        }
	          
	
	        if(sensorImpl.sensorEventQueue().size() <= 0xdbba0);
	        if(!MF_CLASS372_l1024)
	        {
	            MF_CLASS372_l1024 = true;
	            long l1 = SystemClock.elapsedRealtime();
	            MF_CLASS372_x1015 = l1;
	            MF_CLASS372_w1014 = l1;
	            MF_CLASS372_y1016 = l1;
	        }
	        class375 = (CLASS375)sensorImpl.sensorEventQueue().poll();
	        if(sensorImpl.sensorEventQueue().size() > 512)
	            CLASS75.MF_CLASS75_b260("SensorEventProcessor", "SensorEventBuffer.size > 512");
	        if(class375 == null) {
	        	CLASS75.MF_CLASS75_b260("SensorEventProcessor", "SensorEventProcessor.run(): ev = null --> continue");
	        	continue;
	        }
	          
	        if(mFirstTimeStamp == 0L)
	        {
	        	mFirstTimeStamp = isFirstSensorMeasurementTimeNano(class375.getSensorType(), class375.getTimeStamp());
	            if(mFirstTimeStamp != 0L)
	            {
	                CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("run: calling setFirstSensorMeasurementTimeNano firstTimestamp = ").append(mFirstTimeStamp).toString());
	                sensorImpl.setFirstTimeStamp(mFirstTimeStamp);
	                CLASS75.MF_CLASS75_a259(4, "SENSOR_ALL_SENSORS_FIRST_SAMPLE", SensorEventProcessor.class, (new StringBuilder()).append("got firstTimestamp : ").append(mFirstTimeStamp).toString());
	            }
	        }
	        
	        }
	        
	        if(MF_CLASS372_v1035)
	            class374 = null;
	        else 
	        	class374 = checkSensorTimestamps(class375);
	
	        if(class374 != null) {
		        if(!MF_CLASS375_d1048)
		        {
		            MF_CLASS375_d1048 = true;
		            CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("SensorEventProcessor.run(): informing timestamp problem this = ").append(this).append(", thread = ").append(Thread.currentThread()).append(", error = ").append(class374.toString()).toString());
		            CLASS75.MF_CLASS75_a259(5, "TIMESTAMP_ERROR", SensorEventProcessor.class, (new StringBuilder()).append("SensorEventProcessor: informing timestam error : ").append(class374.toString()).toString());
		            sensorImpl.informTimestampError();
		        }
		        MF_CLASS373_a1036(class375);
		        flag = MF_CLASS373_a1036(class375.eventData);
		        duplicate = MF_CLASS373_b1037(class375);
	        } else {
		        if(class375 != null && class374 == null) {
			        if(mFirstTimeStamp != 0L && !flag && !duplicate) {
		        	sensorImpl.parseCalibrateEvent(class375);
			        }
		          continue;
		        }
	        }
	
	        mSkippedEvents = 1 + mSkippedEvents;
	        if(mSkippedEvents != 1 && mSkippedEvents % 1000 != 0) 
	        	continue;
	
	        s = "";
	        if(class374 != null) {
	            String s1 = (new StringBuilder()).append("skippedEvents = ").append(mSkippedEvents).append(", size = ").append(sensorImpl.sensorEventQueue().size()).append(", zero = ").append(flag).append(", firstTimestamp = ").append(mFirstTimeStamp).append(", tsProblem = ").append(s).append(", duplicate = ").append(duplicate).append(", eventType = ").append(class375.getSensorType()).append(", firstAccTSMillis = ").append(mFirstAccTSMillis).append(", firstGyroTSMillis = ").append(mFirstGyroTSMillis).append(", firstMgnTSMillis = ").append(mFirstMgnTSMillis).append(", event.values = ").append(Arrays.toString(class375.eventData)).toString();
	            CLASS75.MF_CLASS75_a259(5, "SKIPPING_SENSOR_SAMPLE", SensorEventProcessor.class, (new StringBuilder()).append("SensorEventProcessor: skipping : ").append(s1).toString());
		        s = class374.toString();
		        CLASS75.MF_CLASS75_b260("SensorEventProcessor", (new StringBuilder()).append("SensorEventProcessor.run(): ***NOT HANDLING SENSOR EVENT *** , size = ").append(sensorImpl.sensorEventQueue().size()).append(", skippedEvents = ").append(mSkippedEvents).append(", zero = ").append(flag).append(", firstTimestamp = ").append(mFirstTimeStamp).append(", tsProblem = ").append(s).append(", duplicate = ").append(duplicate).append(", eventType = ").append(class375.getSensorType()).append(", firstAccTSMillis = ").append(mFirstAccTSMillis).append(", firstGyroTSMillis = ").append(mFirstGyroTSMillis).append(", firstMgnTSMillis = ").append(mFirstMgnTSMillis).append(", event.values = ").append(Arrays.toString(class375.eventData)).toString());
	        }
	      }
        }
        catch(Exception exception1)
        {
            exception1.printStackTrace();
        	return;
        }
        

    }

    CLASS158 sensorImpl;
    boolean isRunning;
    boolean MF_CLASS373_c1038;
    boolean MF_CLASS375_d1048;
    long mAccTimeStamp;
    long mGyroTimeStamp;
    long mMgnTimeStamp;
    double MF_CLASS372_h1020[] = {
        0.0D, 0.0D, 0.0D
    };
    double MF_CLASS372_i1021[] = {
        0.0D, 0.0D, 0.0D
    };
    double MF_CLASS372_j1022[] = {
        0.0D, 0.0D, 0.0D
    };
    long MF_CLASS372_k1023;
    boolean MF_CLASS372_l1024;
    int mSkippedEvents;
    long MF_CLASS372_n1026;
    long mFirstAccTSMillis;
    long mFirstGyroTSMillis;
    long mFirstMgnTSMillis;
    long MF_CLASS372_r1030;
    long MF_CLASS372_s1031;
    long MF_CLASS372_t1032;
    long mFirstTemperatureTSMillis;
    public boolean MF_CLASS372_v1035;
    private long MF_CLASS372_w1014;
    private long MF_CLASS372_x1015;
    private long MF_CLASS372_y1016;
    private long mFirstTimeStamp;
}
