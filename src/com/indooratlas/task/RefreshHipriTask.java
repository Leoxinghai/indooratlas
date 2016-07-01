package com.indooratlas.task;


import android.os.AsyncTask;
import com.indooratlas.base.CLASS3;
import com.indooratlas.position.CLASS75;

//Referenced classes of package com.indooratlas.task:
//         RemoteImplementation, CLASS51

class RefreshHipriTask extends AsyncTask
{

 private RefreshHipriTask(RemoteImplementation class50)
 {
     super();
     MF_CLASS58_b210 = class50;
     MF_CLASS58_a209 = false;
 }

 RefreshHipriTask(RemoteImplementation class50, CLASS51 class51)
 {
     this(class50);
 }

 protected Void MF_CLASS58_a209(Void avoid[])
 {
     try
     {
         CLASS75.MF_CLASS75_b260("RefreshHipriTask", (new StringBuilder()).append("RefreshHipriTask doInBackground calling forceHipriMode, changingNetwork = ").append(RemoteImplementation.MF_CLASS50_m182(MF_CLASS58_b210)).toString());
         MF_CLASS58_a209 = RemoteImplementation.MF_CLASS50_p185(MF_CLASS58_b210);
         CLASS75.MF_CLASS75_b260("RefreshHipriTask", (new StringBuilder()).append("RefreshHipriTask doInBackground, returning: result = ").append(MF_CLASS58_a209).append(", changingNetwork = ").append(RemoteImplementation.MF_CLASS50_m182(MF_CLASS58_b210)).toString());
     }
     catch(Exception exception) {
         exception.printStackTrace();
     	
     }
     return null;
 }

 protected void MF_CLASS58_a209(Void void1)
 {
     if(!MF_CLASS58_a209 && RemoteImplementation.MF_CLASS50_m182(MF_CLASS58_b210))
     {
         CLASS75.MF_CLASS75_b260("RefreshHipriTask", "onPostExecute(): changingToHipri == true && result == false --> not successful --> stop updating hipri");
         RemoteImplementation.MF_CLASS50_l181(MF_CLASS58_b210);
         RemoteImplementation.WAITINGType(MF_CLASS58_b210, false);
     }
     if(RemoteImplementation.MF_CLASS50_m182(MF_CLASS58_b210))
     {
         CLASS75.MF_CLASS75_b260("RefreshHipriTask", "onPostExecute(): changingToHipri == true --> callback");
         RemoteImplementation.getIndoorAltas(MF_CLASS58_b210).onNetworkChangeComplete(MF_CLASS58_a209);
         RemoteImplementation.MF_CLASS19_c69(MF_CLASS58_b210, false);
         return;
     } else
     {
         CLASS75.MF_CLASS75_b260("RefreshHipriTask", "onPostExecute(): changingToHipri == false --> no callback");
         return;
     }
 }

 protected Object doInBackground(Object aobj[])
 {
     return MF_CLASS58_a209((Void[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS58_a209((Void)obj);
 }

 protected void onPreExecute()
 {
 }

 boolean MF_CLASS58_a209;
 final RemoteImplementation MF_CLASS58_b210;
}
