package com.indooratlas.task;

//CLASS56

import android.os.AsyncTask;
import com.indooratlas.position.CLASS75;
import java.util.TimerTask;

//Referenced classes of package com.indooratlas.task:
//         RemoteImplementation, RefreshHipriTask

class HipriUpdaterTask extends TimerTask
{

	HipriUpdaterTask(RemoteImplementation class50)
 {
     super();
     MF_CLASS56_a203 = class50;
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("RemoteImplementation", "startHipriUpdater timer: calling creating new RefreshHipriTask");
     if(RemoteImplementation.getRefreshHipriTask(MF_CLASS56_a203) != null && RemoteImplementation.getRefreshHipriTask(MF_CLASS56_a203).getStatus() != android.os.AsyncTask.Status.FINISHED)
     {
         CLASS75.MF_CLASS75_b260("RemoteImplementation", "startHipriUpdater timer: old RefreshHipriTask has not finished --> do nothing");
         return;
     }
     try
     {
         if(RemoteImplementation.getRefreshHipriTask(MF_CLASS56_a203) == null || RemoteImplementation.getRefreshHipriTask(MF_CLASS56_a203) != null && RemoteImplementation.getRefreshHipriTask(MF_CLASS56_a203).getStatus() == android.os.AsyncTask.Status.FINISHED)
         {
             CLASS75.MF_CLASS75_b260("RemoteImplementation", "startHipriUpdater timer: old RefreshHipriTask has finished or is null --> start a new task");
             RemoteImplementation.MF_CLASS19_a67(MF_CLASS56_a203, new RefreshHipriTask(MF_CLASS56_a203, null));
             RemoteImplementation.getRefreshHipriTask(MF_CLASS56_a203).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
             return;
         }
     }
     catch(Exception exception) { 
         exception.printStackTrace();
     	
     }
     return;
 }

 final RemoteImplementation MF_CLASS56_a203;
}
