package com.indooratlas.task;

//CLASS62

import android.os.AsyncTask;
import com.indooratlas.base.CLASS3;
import com.indooratlas.position.CLASS75;

//Referenced classes of package com.indooratlas.task:
//         RemoteImplementation, CLASS46, CLASS51

class StopUsingHipriTask extends AsyncTask
{

 private StopUsingHipriTask(RemoteImplementation class50)
 {
     super();
     MF_CLASS62_b219 = class50;
     MF_CLASS62_a218 = false;
 }

 StopUsingHipriTask(RemoteImplementation class50, CLASS51 class51)
 {
     this(class50);
 }

 protected Void MF_CLASS62_a218(Void avoid[])
 {
     try
     {
         CLASS75.MF_CLASS75_b260("StopUsingHipriTask", "StopUsingHipriTask Background, calling stopUsingHipri().");
         if(CLASS75.getNetworkStatus(RemoteImplementation.MF_CLASS50_n183(MF_CLASS62_b219)).mMobileHipriAvailable)
         {
             CLASS75.MF_CLASS75_b260("StopUsingHipriTask", "StopUsingHipriTask Background calling stopUsingHipri");
             MF_CLASS62_a218 = MF_CLASS62_b219.stopUsingHipri();
         }
         CLASS75.MF_CLASS75_a259(4, "HIPRI_STOPPED", RemoteImplementation.class, (new StringBuilder()).append("StopUsingHipriTask, stoppedOk = ").append(MF_CLASS62_a218).toString());
         CLASS75.MF_CLASS75_b260("StopUsingHipriTask", (new StringBuilder()).append("StopUsingHipriTask returning, stoppedOk = ").append(MF_CLASS62_a218).toString());
     }
     catch(Exception exception) { 
         exception.printStackTrace();

     }
     return null;
 }

 protected void MF_CLASS62_a218(Void void1)
 {
     if(RemoteImplementation.MF_CLASS50_m182(MF_CLASS62_b219))
     {
         CLASS75.MF_CLASS75_b260("StopUsingHipriTask", "onPostExecute(): changingNetwork == true --> callback");
         RemoteImplementation.getIndoorAltas(MF_CLASS62_b219).onNetworkChangeComplete(MF_CLASS62_a218);
         RemoteImplementation.MF_CLASS19_c69(MF_CLASS62_b219, false);
         return;
     } else
     {
         CLASS75.MF_CLASS75_b260("StopUsingHipriTask", "onPostExecute(): changingNetwork == false --> no callback");
         return;
     }
 }

 protected Object doInBackground(Object aobj[])
 {
     return MF_CLASS62_a218((Void[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS62_a218((Void)obj);
 }

 protected void onPreExecute()
 {
 }

 boolean MF_CLASS62_a218;
 final RemoteImplementation MF_CLASS62_b219;
}
