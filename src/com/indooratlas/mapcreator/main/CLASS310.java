// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS311

public class CLASS310 extends AsyncTask
{

    public CLASS310(MapScreen mapscreen)
    {
        super();
        MF_CLASS113_a486 = mapscreen;
    }

    protected void MF_CLASS113_a486(Void void1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "DumpDBTask.onPostExecute, closing progressdialog");
        MF_CLASS113_a486.updateInProgressDialog(MF_CLASS113_a486.getString(0x7f080049));
        (new CLASS311(this, 1000L, 1000L)).start();
    }

    protected void MF_CLASS113_a486(Void avoid[])
    {
    }

    protected Void MF_CLASS310_b885(Void avoid[])
    {
        try {
	    	CLASS167.MF_CLASS167_b635("MapScreen", "DumpDBTask.doInBackground, calling dumpDatabaseToFile");
	        MeasurementDataSource.dumpDatabaseToFile();
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }

        return null;

    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS310_b885((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS113_a486((Void)obj);
    }

    protected void onPreExecute()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "DumpDBTask.onPreExecute, showing progressdialog");
        MF_CLASS113_a486.showInProgressDialog(MF_CLASS113_a486.getString(0x7f080048), false);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        MF_CLASS113_a486((Void[])aobj);
    }

    final MapScreen MF_CLASS113_a486;
}
