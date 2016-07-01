// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.AsyncTask;
import com.indooratlas.base.CLASS1;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

public class CLASS315 extends AsyncTask
{

    public CLASS315(MapScreen mapscreen)
    {
        super();
        MF_CLASS113_a486 = mapscreen;
    }

    protected void MF_CLASS113_a486(Void void1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "ResetAPITask.onPostExecute, closing inprogressdialog");
        MF_CLASS113_a486.hideInProgressDialog();
    }

    protected void MF_CLASS113_a486(Void avoid[])
    {
    }

    protected Void MF_CLASS315_b894(Void avoid[])
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "ResetAPITask.doInBackground, calling resetAPI");
        try
        {
            MF_CLASS113_a486.resetAPI();
        }
        catch(CLASS1 class1)
        {
            if(CLASS113.isExceptionLogged.booleanValue())
                class1.printStackTrace();
        }
        try
        {
            Thread.sleep(500L);
        }
        catch(InterruptedException interruptedexception)
        {
            if(CLASS113.isExceptionLogged.booleanValue())
                interruptedexception.printStackTrace();
        }
        CLASS167.MF_CLASS167_b635("MapScreen", "ResetAPITask.doInBackground, done");
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return MF_CLASS315_b894((Void[])aobj);
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

    final MapScreen MF_CLASS113_a486;
}
