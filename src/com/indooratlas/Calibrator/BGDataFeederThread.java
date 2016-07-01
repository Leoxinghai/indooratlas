package com.indooratlas.Calibrator;


import com.indooratlas.algorithm.CLASS7;
import com.indooratlas.cursor.list.CLASS26;
import com.indooratlas.cursor.list.CLASS29;
import com.indooratlas.position.CLASS75;
import java.util.SortedMap;

//Referenced classes of package com.indooratlas.Calibrator:
//         BackgroundCalibratorController

class BGDataFeederThread
 implements Runnable
{

	BGDataFeederThread(BackgroundCalibratorController class9)
 {
     MF_CLASS11_a41 = class9;
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): Data feeder thread running.");

     CLASS29 class29;
     CLASS26 class26;
     
     while(true) {
	        if(BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).size() + BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).size() <= 0) {
				try
				{
				    Thread.sleep(50L);
				}
				catch(InterruptedException interruptedexception)
				{
				    interruptedexception.printStackTrace();
				}
				if(!BackgroundCalibratorController.MF_CLASS9_e26(MF_CLASS11_a41))
				{
				    CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): dataFeederThread dying.");
				    return;
				}
				continue;
			}
		        
		     try {
		        	
		        Object obj = BackgroundCalibratorController.MF_CLASS9_b23(MF_CLASS11_a41);
		        synchronized(obj) {
		        
		        if(BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).size() <= 0 || BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).size() <= 0) {
					if(BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).size() <= 0) {
						if(BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).size() <= 0) {
							class29 = null;
							class26 = null;
						 } else {
							class29 = (CLASS29)BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).remove(BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).firstKey());
							class26 = null;
						 }
					} else {
						class26 = (CLASS26)BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).remove(BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).firstKey());
						class29 = null;
					}
		        } else {
		        	SortedMap smap = BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41);
		        	Object obj0 = smap.firstKey();
		        	CLASS26 temp26 = (CLASS26)smap.get(obj0);
		        	
		        	long temp1 = temp26.timeStamp;//((CLASS26)BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).get(BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).firstKey())).MF_CLASS22_g77;
		        	SortedMap smap2 = BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41);
		        	Object obj2 = smap2.firstKey();
		        	CLASS29 temp29 = (CLASS29)smap2.get(obj2);
		        	
		        	long temp2 = temp29.timeStamp;//((CLASS29)BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).get(BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).firstKey())).timeStamp; 
					if( temp1 >= temp2 ) {
						class29 = temp29;//(CLASS29)BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).remove(BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS11_a41).firstKey());
						class26 = null;
					} else {
						class26 = temp26;//(CLASS26)BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).remove(BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS11_a41).firstKey());
						class29 = null;
					}        
				}        
		     }		        
		
//		        if(class26 == null) {
					if(class29 != null) {
							BackgroundCalibratorController.MF_CLASS9_f27(MF_CLASS11_a41).MF_CLASS7_a13(class29.timeStamp, class29.AccelerometerX, class29.AccelerometerY, class29.AccelerometerZ);
					}
					if(class26 != null) {       
				        BackgroundCalibratorController.MF_CLASS9_f27(MF_CLASS11_a41).MF_CLASS7_b14(class26.timeStamp, class26.AccelerometerX, class26.AccelerometerY, class26.AccelerometerZ);
			        }
//		        }

			} catch(Exception exception) {
				exception.printStackTrace();
			}
     }
 }

 final BackgroundCalibratorController MF_CLASS11_a41;
}
