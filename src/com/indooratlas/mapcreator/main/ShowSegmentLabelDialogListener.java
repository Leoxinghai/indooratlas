package com.indooratlas.mapcreator.main;


import android.content.DialogInterface;
import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.Measurement;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         MapScreen, CLASS319

class ShowSegmentLabelDialogListener
 implements android.content.DialogInterface.OnClickListener
{

	ShowSegmentLabelDialogListener(MapScreen mapscreen, String as[])
 {
     MF_CLASS267_b819 = mapscreen;
     MF_CLASS113_a486 = as;
 }

 public void onClick(DialogInterface dialoginterface, int i)
 {
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentLabelDialog() onClick, item = ").append(i).append(", items.length = ").append(MF_CLASS113_a486.length).toString());
     try
     {
         if(i != -1 + MF_CLASS113_a486.length)
         {
             String s = MF_CLASS113_a486[i].toString();
             CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentLabelDialog() onClick item == ").append(i).append(", storing label = ").append(s).append(", and updating measurement to DB.").toString());
             MapScreen.currentMeasurement.mLabel = s;
             MeasurementDataSource.updateMeasurement(MapScreen.currentMeasurement);
             dialoginterface.cancel();
             CLASS319 class319 = new CLASS319(MF_CLASS267_b819);
             java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
             Measurement aclass108[] = new Measurement[1];
             aclass108[0] = MapScreen.currentMeasurement;
             class319.executeOnExecutor(executor, aclass108);
             return;
         }
     }
     catch(Exception exception)
     {
         if(CLASS113.isExceptionLogged.booleanValue())
             exception.printStackTrace();
         CLASS167.unhandledexception(exception, MF_CLASS267_b819.getApplicationContext());
         return;
     }
     MapScreen.J(MF_CLASS267_b819);
     dialoginterface.cancel();
     return;
 }

 final String MF_CLASS113_a486[];
 final MapScreen MF_CLASS267_b819;
}
