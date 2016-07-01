package com.indooratlas.Calibrator;


import com.indooratlas.algorithm.CLASS7;
import com.indooratlas.position.CLASS75;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

//Referenced classes of package com.indooratlas.Calibrator:
//         BackgroundCalibratorController, CLASS15, CLASS17, BGC_TYPE

class BGResultPollerThread
 implements Runnable
{

	BGResultPollerThread(BackgroundCalibratorController class9)
 {
     MF_CLASS17_a58 = class9;
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): Result poller thread running.");

     Object obj;
     CLASS15 class15;
     while(true) {
	        try
	        {
	            Thread.sleep(100L);
	        }
	        catch(InterruptedException interruptedexception) { }
	        
	        try {
	        obj = BackgroundCalibratorController.MF_CLASS9_b23(MF_CLASS17_a58);
	        
	        if(!MF_CLASS17_a58.MF_CLASS376_a1051) {
	                double ad[] = BackgroundCalibratorController.MF_CLASS9_f27(MF_CLASS17_a58).getCalibration();
	                double ad1[] = new double[3];
	                ad1[0] = ad[0];
	                ad1[1] = ad[1];
	                ad1[2] = ad[2];
	                double d = ad[4];
	                double d1 = ad[5];
	                double d2 = ad[6];
	                BGC_TYPE class16 = CLASS15.MF_CLASS17_a58((int)d1);
	                class15 = new CLASS15("background", ad1, d, d2, CLASS17.BACKGROUND, class16);
	                CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", (new StringBuilder()).append("runBackgroundCalibration(): calibStatusEnum = ").append(d1).append(", readyStatus = ").append(class16).append(", progress : ").append(d2).append(", biases: ").append(Arrays.toString(ad1)).append(", covariance: ").append(d).toString());
	                if(ad1[0] != 0.0D || ad1[1] != 0.0D || ad1[2] != 0.0D)
	                    BackgroundCalibratorController.sNotifyListeners(MF_CLASS17_a58, class15);
	                if(class15.getBGCState() != BGC_TYPE.BGC_READY && class15.getBGCState() != BGC_TYPE.BGC_CONVERGED) {
	                        if(class15.getBGCState() == BGC_TYPE.BGC_FAILED) {
	        	                CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): Background calibration done, BGC_FAILED --> restart immediately if not externally stopped");
	        	                if(BackgroundCalibratorController.MF_CLASS9_e26(MF_CLASS17_a58))
	        	                {
	        	                    CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): --> restart immediately");
	        	                    MF_CLASS17_a58.stopBackgroundCalibration(true, 100L);
	        	                }
	                        }
	                } else {
	        	        if(class15.getBGCState() == BGC_TYPE.BGC_READY)
	        	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): Background calibration done: BGC_READY.");
	        	        if(class15.getBGCState() == BGC_TYPE.BGC_CONVERGED)
	        	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): Background calibration done: BGC_CONVERGED.");
	        	        MF_CLASS17_a58.stopBackgroundCalibration(true, 0x36ee80L);
	                }
	        	
	        } else {
	
		        if(BackgroundCalibratorController.MF_CLASS9_e26(MF_CLASS17_a58))
		        {
		            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): restart scheduled --> stopping calibration");
		            MF_CLASS17_a58.stopBackgroundCalibration(true, 100L);
		        }
	        }
	        
	        if(BackgroundCalibratorController.MF_CLASS9_e26(MF_CLASS17_a58)) { 
	        	continue;
	        } else {
	            CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): resultPollerThread dying.");
	            return;
	        	
	        }
	        
     } catch(ConcurrentModificationException concurrentmodificationexception) {
     	concurrentmodificationexception.printStackTrace();
     } catch(Exception ex) {
     	ex.printStackTrace();
     }
     }

 }

 final BackgroundCalibratorController MF_CLASS17_a58;
}
