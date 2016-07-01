package com.indooratlas.task;


import com.indooratlas.base.CLASS3;

//Referenced classes of package com.indooratlas.task:
//         RemoteImplementation

class CalibInvalidThread
 implements Runnable
{

	CalibInvalidThread(RemoteImplementation class50)
 {
     MF_CLASS53_a200 = class50;

 }

 public void run()
 {
     RemoteImplementation.getIndoorAltas(MF_CLASS53_a200).onCalibrationInvalid();
     RemoteImplementation.MF_CLASS19_a67(MF_CLASS53_a200, false);
 }

 final RemoteImplementation MF_CLASS53_a200;
}
