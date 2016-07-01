package com.indooratlas.task;


import android.os.AsyncTask;
import com.indooratlas.position.CLASS75;

//Referenced classes of package com.indooratlas.task:
//         RemoteImplementation, CLASS51

class StopPositioningTask extends AsyncTask
{

 private StopPositioningTask(RemoteImplementation class50)
 {
     super();
     MF_CLASS61_a217 = class50;
 }

 public StopPositioningTask(RemoteImplementation class50, CLASS51 class51)
 {
     this(class50);
 }

 protected Void MF_CLASS61_a217(Void avoid[])
 {
     CLASS75.MF_CLASS75_b260("StopPositioningTask", "StopPositioningTask doInBackground starting.");
     CLASS75.MF_CLASS75_b260("StopPositioningTask", "StopPositioningTask doInBackground, calling synchronized doStopPositioning()");
     try {
     MF_CLASS61_a217.doStopPositioning();
     CLASS75.MF_CLASS75_a259(4, "STOP_POSITIONING_OK", RemoteImplementation.class, "StopPositioningTask.");
     if(RemoteImplementation.MF_CLASS50_k180(MF_CLASS61_a217)) {
             CLASS75.MF_CLASS75_b260("StopPositioningTask", "StopPositioningTask *NOT* calling stopHipriUpdater because mPreferMobileConnection == true");
     } else {
	        CLASS75.MF_CLASS75_b260("StopPositioningTask", "StopPositioningTask calling stopHipriUpdater because mPreferMobileConnection == false");
	        RemoteImplementation.MF_CLASS50_l181(MF_CLASS61_a217);
     }
     CLASS75.MF_CLASS75_b260("StopPositioningTask", "StopPositioningTask returning.");

     } catch(Exception exception) {
     	exception.printStackTrace();
     }
     return null;
 }

 protected void MF_CLASS61_a217(Void void1)
 {
 }

 protected Object doInBackground(Object aobj[])
 {
     return MF_CLASS61_a217((Void[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS61_a217((Void)obj);
 }

 protected void onPreExecute()
 {
 }

 final RemoteImplementation MF_CLASS61_a217;
}
