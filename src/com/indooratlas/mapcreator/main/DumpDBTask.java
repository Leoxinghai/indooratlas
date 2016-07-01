package com.indooratlas.mapcreator.main;


import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.MeasurementDataSource;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         Sipa, CLASS345

public class DumpDBTask extends AsyncTask
{

 public DumpDBTask(Sipa sipa)
 {
     super();
     MF_CLASS179_a653 = sipa;
 }

 protected void MF_CLASS179_a653(Void void1)
 {
     CLASS167.MF_CLASS167_b635("Sipa", "DumpDBTask.onPostExecute, closing progressdialog");
     MF_CLASS179_a653.updateInProgressDialog(MF_CLASS179_a653.getString(0x7f080049));
     (new CLASS345(this, 1000L, 1000L)).start();
 }

 protected void MF_CLASS179_a653(Void avoid[])
 {
 }

 protected Void MF_CLASS344_b941(Void avoid[])
 {
     try
     {
         CLASS167.MF_CLASS167_b635("Sipa", "DumpDBTask.doInBackground, calling dumpDatabaseToFile");
         if(!MeasurementDataSource.MF_CLASS381_a1107)
             MeasurementDataSource.openDB(MF_CLASS179_a653.k.getApplicationContext());
         MeasurementDataSource.dumpDatabaseToFile();
     }
     catch(Exception exception) { }
     return null;
 }

 protected Object doInBackground(Object aobj[])
 {
     return MF_CLASS344_b941((Void[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS179_a653((Void)obj);
 }

 protected void onPreExecute()
 {
     CLASS167.MF_CLASS167_b635("Sipa", "DumpDBTask.onPreExecute, showing progressdialog");
     MF_CLASS179_a653.showInProgressDialog(MF_CLASS179_a653.getString(0x7f080048));
 }

 protected void onProgressUpdate(Object aobj[])
 {
     MF_CLASS179_a653((Void[])aobj);
 }

 final Sipa MF_CLASS179_a653;
}
