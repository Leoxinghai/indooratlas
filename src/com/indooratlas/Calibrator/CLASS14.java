// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.Calibrator;

import com.indooratlas.base.CLASS1;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.position.CLASS75;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.indooratlas.Calibrator:
//            CLASS15, BackgroundCalibratorController, CLASS10

class CLASS14 extends TimerTask
{

    private CLASS14(BackgroundCalibratorController class9)
    {
        super();
        MF_CLASS14_a44 = class9;
    }

    CLASS14(BackgroundCalibratorController class9, BGDataReaderThread class10)
    {
        this(class9);
    }

    public void run()
    {
        CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "BackgroundCalibrationStarter.run()");
        long l;
        CLASS15 class15;
        boolean flag;
        int i;
        try
        {
            l = System.currentTimeMillis();
            class15 = APIDataBase.selectBGCalibrationFromDB();
	        flag = false;
	        if(class15 == null) {
	            MF_CLASS14_a44.startBackgroundCalibration();
	            return;
	        }            
	//        i = l - class15.MF_CLASS15_f50() != 0x6ddd00L;
	        i = (int)(l - class15.MF_CLASS15_f50());
	        flag = false;
	        if(i < 0)
	            flag = true;
	        if(flag) {
		        CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "backgroundCalibrationStarter: not starting bgcalib, because old calib is valid, scheduling new BackgroundCalibrationStarter after 3600000 millis");
		        BackgroundCalibratorController.MF_CLASS376_a1051(MF_CLASS14_a44, new CLASS14(MF_CLASS14_a44));
		        BackgroundCalibratorController.MF_CLASS9_j31(MF_CLASS14_a44).schedule(BackgroundCalibratorController.MF_CLASS9_i30(MF_CLASS14_a44), 0x36ee80L);
	        }
        }
        catch(CLASS1 class1)
        {
            return;
        }
        
        return;
    }

    final BackgroundCalibratorController MF_CLASS14_a44;
}
