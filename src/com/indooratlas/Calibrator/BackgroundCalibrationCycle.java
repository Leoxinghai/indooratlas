package com.indooratlas.Calibrator;



import com.indooratlas.position.CLASS75;
import java.util.TimerTask;

//Referenced classes of package com.indooratlas.Calibrator:
//         BackgroundCalibratorController, CLASS10

class BackgroundCalibrationCycle extends TimerTask
{

 private BackgroundCalibrationCycle(BackgroundCalibratorController class9)
 {
     super();
     MF_CLASS13_a43 = class9;
 }

 public BackgroundCalibrationCycle(BackgroundCalibratorController class9, BGDataReaderThread class10)
 {
     this(class9);
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("BackgroundCalibratorController", "BackgroundCalibrationCycle.run()");
     BackgroundCalibratorController.MF_CLASS9_g28(MF_CLASS13_a43);
     BackgroundCalibratorController.sRunBackgroundCalibration(MF_CLASS13_a43);
 }

 final BackgroundCalibratorController MF_CLASS13_a43;
}
