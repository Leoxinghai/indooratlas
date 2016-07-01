package com.indooratlas.mapcreator.main;


import android.os.AsyncTask;
import android.view.MenuItem;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         MapScreen, CLASS316

public class FlashStopButtonTask extends AsyncTask
{

 public FlashStopButtonTask(MapScreen mapscreen)
 {
     super();
     mMapScreen = mapscreen;
 }

 protected void MF_CLASS113_a486(Void void1)
 {
     MapScreen.W(mMapScreen);
     if(mMapScreen.mScreenPointType == POINT_TYPE.RECORDING)
     {
         if(MapScreen.X(mMapScreen) % 2L == 0L)
         {
             MapScreen.getRecordingItem(mMapScreen).setIcon(R.drawable.action_bar_icon_stop);
             return;
         } else
         {
             MapScreen.getRecordingItem(mMapScreen).setIcon(R.drawable.actionbar_bg_drawable);
             return;
         }
     } else
     {
         MapScreen.getRecordingItem(mMapScreen).setIcon(R.drawable.action_bar_icon_startpoint2);
         return;
     }
 }

 protected  void MF_CLASS113_a486(Void avoid[])
 {
 }

 protected Void MF_CLASS312_b888(Void avoid[])
 {
     try
     {
         Thread.sleep(700L);
     }
     catch(InterruptedException interruptedexception)
     {
         if(CLASS113.isExceptionLogged.booleanValue())
             interruptedexception.printStackTrace();
     }
     if(mMapScreen.mScreenPointType == POINT_TYPE.RECORDING)
     {
         CLASS167.MF_CLASS167_b635("MapScreen", "FlashStopButtonTask.doInBackground(): Creating new instance of FlashStopButtonTask");
         mMapScreen.mFlashStop = new FlashStopButtonTask(mMapScreen);
         mMapScreen.mFlashStop.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
     } else
     {
         CLASS167.MF_CLASS167_b635("MapScreen", "FlashStopButtonTask.doInBackground(): Stopping...");
     }
     return null;
 }

 protected Object doInBackground(Object aobj[])
 {
     return MF_CLASS312_b888((Void[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS113_a486((Void)obj);
 }

 protected void onPreExecute()
 {
 }

 protected void onProgressUpdate(Object aobj[])
 {
     MF_CLASS113_a486((Void[])aobj);
 }

 final MapScreen mMapScreen;
}
