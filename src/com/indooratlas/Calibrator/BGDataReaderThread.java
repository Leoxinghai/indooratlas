package com.indooratlas.Calibrator;

import com.indooratlas.cursor.list.*;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.SensorReader;
import java.util.SortedMap;

//Referenced classes of package com.indooratlas.Calibrator:
//         CLASS9

class BGDataReaderThread
 implements Runnable
{

	BGDataReaderThread(BackgroundCalibratorController class9)
 {
     MF_CLASS10_a40 = class9;
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): Data reader thread running.");

     CLASS22 aclass22_1[];
     Object obj;
     CLASS22 aclass22[];
     int k;
     int l;
     CLASS22 class22_1;
     try {
	        do {
		        try
		        {
		            Thread.sleep(100L);
		        }
		        catch(InterruptedException interruptedexception)
		        {
		            interruptedexception.printStackTrace();
		        }
		        aclass22 = BackgroundCalibratorController.MF_CLASS376_a1051(MF_CLASS10_a40).MF_CLASS376_q1074();
		        aclass22_1 = BackgroundCalibratorController.MF_CLASS376_a1051(MF_CLASS10_a40).MF_CLASS376_p1073();
		        obj = BackgroundCalibratorController.MF_CLASS9_b23(MF_CLASS10_a40);

		        k = aclass22.length;
		        l = 0;

		        for(;l < k;l++) {
			        class22_1 = aclass22[l];
			        BackgroundCalibratorController.MF_CLASS9_c24(MF_CLASS10_a40).put(Long.valueOf(class22_1.timeStamp), (CLASS26)class22_1);
		        }
		        int i = aclass22_1.length;
		        int j = 0;

		        for(;j<i;j++) {
			        CLASS22 class22 = aclass22_1[j];
			        BackgroundCalibratorController.MF_CLASS9_d25(MF_CLASS10_a40).put(Long.valueOf(class22.timeStamp), (CLASS29)class22);
			    }
	        } while(BackgroundCalibratorController.MF_CLASS9_e26(MF_CLASS10_a40));


	        CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "runBackgroundCalibration(): dataReaderThread dying.");
	        return;

	    } catch(Exception exception) {
	        exception.printStackTrace();
	    }
 }

 final BackgroundCalibratorController MF_CLASS10_a40;
}
