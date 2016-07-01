package com.indooratlas.Calibrator;



import android.os.SystemClock;
import com.indooratlas.algorithm.CLASS7;
import com.indooratlas.base.CLASS1;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.SensorReader;
import java.util.*;

//Referenced classes of package com.indooratlas.Calibrator:
//         CLASS15, CLASS20, CLASS10, CLASS11,
//         CLASS12, CLASS13, CLASS14

public class BackgroundCalibratorController
{

 public BackgroundCalibratorController(SensorReader class376)
 {
     MF_CLASS376_a1051 = false;
     MF_CLASS9_b23 = false;
     MF_CLASS9_l33 = 0L;
     MF_CLASS9_m34 = 0L;
     MF_CLASS9_p35 = new TreeMap();
     MF_CLASS9_q36 = new TreeMap();
     mSensorReader = class376;
     MF_CLASS9_h29 = new Timer();
     class376.MF_CLASS376_x1058_com_indooratlas_Calibrator_CLASS9_fld = this;
 }

 static SensorReader MF_CLASS376_a1051(BackgroundCalibratorController class9)
 {
     return class9.mSensorReader;
 }

 static TimerTask MF_CLASS376_a1051(BackgroundCalibratorController class9, TimerTask timertask)
 {
     class9.MF_CLASS9_j31 = timertask;
     return timertask;
 }

 static void sNotifyListeners(BackgroundCalibratorController class9, CLASS15 class15) throws Exception
 {
     class9.notifyListeners(class15);
 }

 private void notifyListeners(CLASS15 class15) throws Exception
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", (new StringBuilder()).append("notifyListeners(): Notifying listeners about new BG-calib data, running = ").append(MF_CLASS9_b23).append(", listeners.size = ").append(MF_CLASS9_o32.size()).append(" this = ").append(toString()).toString());
     double ad[] = class15.MF_CLASS16_b54();
     double d = ad[1];
     double d1 = -1D * ad[0];
     ad[0] = d;
     ad[1] = d1;
     if(!MF_CLASS9_b23) {
     	return;
     }

     Object obj = MF_CLASS9_d25;
     try {
	        for(Iterator iterator = MF_CLASS9_o32.iterator(); iterator.hasNext();) {
	        	((CLASS20)iterator.next()).BGcalib(class15);        	
	        }
     } catch(Exception exception) {
     	exception.printStackTrace();
     	throw exception;
     }

 }

 public static void MF_CLASS376_a1051(CLASS20 class20) throws Exception
 {
     try {
	    	synchronized(MF_CLASS9_d25)
	        {
	            MF_CLASS9_o32.add(class20);
	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "Added BG-calib listener.");
	        }
	        return;
     } catch(Exception exception) {
     	exception.printStackTrace();
     	throw exception;
     }
 }

 static Object MF_CLASS9_b23(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_c24;
 }

 public static void MF_CLASS9_b23(CLASS20 class20) throws Exception
 {
     try {
	    	synchronized(MF_CLASS9_d25)
	        {
	            if(MF_CLASS9_o32.contains(class20))
	                MF_CLASS9_o32.remove(class20);
	        }
	        return;
	    } catch(Exception exception) {
	    	exception.printStackTrace();
	    	throw exception;
	    }
 }

 static SortedMap MF_CLASS9_c24(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_q36;
 }

 private void runBackgroundCalibration()
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration called, setting setBackgroundCalibrationDataCollection(true)");
     mSensorReader.setBackgroundCalibrationDataCollection(true);
     MF_CLASS9_b23 = true;
     MF_CLASS9_k38 = SystemClock.elapsedRealtime();
     MF_CLASS9_l33 = System.nanoTime();
     MF_CLASS9_e26 = new Thread(new BGDataReaderThread(this));
     MF_CLASS9_g28 = new Thread(new BGDataFeederThread(this));
     th_resultpoller = new Thread(new BGResultPollerThread(this));
     MF_CLASS9_e26.setName("BGDataReaderThread");
     MF_CLASS9_g28.setName("BGDataFeederThread");
     th_resultpoller.setName("BGResultPollerThread");
     MF_CLASS9_e26.start();
     th_resultpoller.start();
     MF_CLASS9_g28.start();
 }

 static SortedMap MF_CLASS9_d25(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_p35;
 }

 private void MF_CLASS9_d25()
 {
 	try {
			synchronized(MF_CLASS9_c24)
		    {
		        MF_CLASS9_r39 = new CLASS7();
		    }
		    return;
		} catch(Exception exception) {
			exception.printStackTrace();
//			throw exception;
		}
 }

 static boolean MF_CLASS9_e26(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_b23;
 }

 static CLASS7 MF_CLASS9_f27(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_r39;
 }

 static void MF_CLASS9_g28(BackgroundCalibratorController class9) 
 {
     class9.MF_CLASS9_d25();
 }

 static void sRunBackgroundCalibration(BackgroundCalibratorController class9)
 {
     class9.runBackgroundCalibration();
 }

 static TimerTask MF_CLASS9_i30(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_j31;
 }

 static Timer MF_CLASS9_j31(BackgroundCalibratorController class9)
 {
     return class9.MF_CLASS9_h29;
 }

 public void startBackgroundCalibration() throws CLASS1
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "startBackgroundCalibration: calling sensorReader.startBGCalibDataCollection()");
     try {
	        if(!MF_CLASS9_b23) {
	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "startBackgroundCalibration: calling running == false --> start bg calibration threads");
	            MF_CLASS376_a1051 = false;
	            MF_CLASS9_q36.clear();
	            MF_CLASS9_p35.clear();
	            mSensorReader.startBGCalibDataCollection();
	            MF_CLASS9_i30 = new BackgroundCalibrationCycle(this, null);
	            MF_CLASS9_h29.schedule(MF_CLASS9_i30, 100L);
	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "Starting BG calibration cycle.");
	            return;
	        }
	        if(mSensorReader.isSensorErrorReported())
	        {
	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "startBackgroundCalibration: sensorError == true --> throwing exception");
	            throw new CLASS1("Sensor error, restart the device.");
	        }
	        CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "startBackgroundCalibration: calling running == true --> do nothing, return");
	        
		} catch(CLASS1 exception) {
			exception.printStackTrace();
			throw exception;
		}
     
     return;
 }

 public void stopBackgroundCalibration(boolean flag, long l) throws Exception
 {
     CLASS7 class7 = MF_CLASS9_r39;
     if(class7 == null)
     	return;

     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "stopBackgroundCalibration(): Stopping BG-calibration.");
     MF_CLASS376_a1051 = false;
     MF_CLASS9_b23 = false;
     mSensorReader.setBackgroundCalibrationDataCollection(false);
     if(!mSensorReader.isRecordingSensorData)
    	 mSensorReader.stopSensors(true, true);
     else 
    	 mSensorReader.stopSensors(false, true);

     if(MF_CLASS9_i30 != null)
     {
         CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "stopBackgroundCalibration(): calling calibrationCycleTask.cancel()");
         MF_CLASS9_i30.cancel();
     }
     if(MF_CLASS9_j31 != null)
     {
         CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "stopBackgroundCalibration(): calling backgroundCalibrationStarter.cancel()");
         MF_CLASS9_j31.cancel();
     }
     MF_CLASS9_r39.MF_CLASS7_a13();
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "stopBackgroundCalibration(): Stopping BG-calibration: stopped thread.");
     if(!flag || l <= 0L) 
     	return;
     try {
	        CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", (new StringBuilder()).append("stopBackgroundCalibration(): scheduling new BackgroundCalibrationStarter after ").append(l).append(" millis").toString());
	        MF_CLASS9_j31 = new CLASS14(this, null);
	        MF_CLASS9_h29.schedule(MF_CLASS9_j31, l);
	        return;
     } catch(Exception exception) {
	        exception.printStackTrace();
	        throw exception;
     }
 }

 public void MF_CLASS9_b23()
 {
     MF_CLASS376_a1051 = true;
 }

 private static final Object MF_CLASS9_d25 = new Object();
 private static ArrayList MF_CLASS9_o32 = new ArrayList();
 boolean MF_CLASS376_a1051;
 private boolean MF_CLASS9_b23;
 private final Object MF_CLASS9_c24 = new Object();
 private Thread MF_CLASS9_e26;
 private Thread th_resultpoller;
 private Thread MF_CLASS9_g28;
 private Timer MF_CLASS9_h29;
 private TimerTask MF_CLASS9_i30;
 private TimerTask MF_CLASS9_j31;
 private long MF_CLASS9_k38;
 private long MF_CLASS9_l33;
 private long MF_CLASS9_m34;
 private SensorReader mSensorReader;
 private SortedMap MF_CLASS9_p35;
 private SortedMap MF_CLASS9_q36;
 private CLASS7 MF_CLASS9_r39;

}
