package com.indooratlas.Calibrator;



import com.indooratlas.cursor.list.CLASS24;

//Referenced classes of package com.indooratlas.Calibrator:
//         CalibrationEvent

public interface IBGCalibration
{

 public abstract void notifyCalibrationDone(CalibrationEvent class18, CLASS24 class24);

 public abstract void updateCalibrationStatus(CalibrationEvent class18);
}
