// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.task;

import android.os.AsyncTask;
import com.indooratlas.base.CLASS3;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.task:
//            RemoteImplementation, CLASS43, CLASS51

class StartPositioningTask extends AsyncTask
{

    private StartPositioningTask(RemoteImplementation class50)
    {
        super();
        mRemoteImpl = class50;
    }

    StartPositioningTask(RemoteImplementation class50, CLASS51 class51)
    {
        this(class50);
    }

    protected Void doInBackground0(Void avoid[])
    {
        try
        {

        	CLASS75.MF_CLASS75_b260("StartPositioningTask", "StartPositioningTask doInBackground starting, outside synchronized");
        CLASS75.MF_CLASS75_b260("StartPositioningTask", "within synchronized: StartPositioningTask Background.");
        RemoteImplementation.DoStartPositioning(mRemoteImpl);
        CLASS75.MF_CLASS75_a259(4, "START_POSITIONING_OK", RemoteImplementation.class, "StartPositioningTask done.");
        CLASS75.MF_CLASS75_b260("StartPositioningTask", "StartPositioningTask returning.");
        int i = CLASS43.MF_CLASS43_a152(1005);
        String s = "";
        if(i != 1005)
            s = (new StringBuilder()).append(" (Internal error code: ").append(i).append(")").toString();
        RemoteImplementation.getIndoorAltas(mRemoteImpl).onServiceFailure(i, (new StringBuilder()).append("Starting positioning failed due to internal error in API.").append(s).toString());
        mRemoteImpl.doStopPositioning();
        return null;
        
        }
        catch(Exception exception)
        {
        	exception.printStackTrace();
        	CLASS75.MF_CLASS75_a259(5, "START_POSITIONING_FAILED", RemoteImplementation.class, (new StringBuilder()).append("StartPositioningTask : ").append(CLASS75.MF_CLASS75_a259(exception)).toString());
        }
        return null;
    }

    protected void MF_CLASS60_a216(Void void1)
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        return doInBackground0((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        MF_CLASS60_a216((Void)obj);
    }

    protected void onPreExecute()
    {
    }

    final RemoteImplementation mRemoteImpl;
}
