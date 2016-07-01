// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread.server;

import android.os.CountDownTimer;
import android.os.SystemClock;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.RemoteImplementation;

// Referenced classes of package com.indooratlas.thread.server:
//            CLASS82, WebsocketConnectionThread

class CLASS83 extends CountDownTimer
{

    CLASS83(CLASS82 class82, long l, long l1)
    {
        super(l, l1);
        MF_CLASS82_a311 = class82;
    }

    public void onFinish()
    {
    }

    public void onTick(long l)
    {
        long l2;
        long l3;
        try
        {
            long l1 = SystemClock.elapsedRealtime();
            l2 = l1 - WebsocketConnectionThread.MF_CLASS78_k292(MF_CLASS82_a311.MF_CLASS82_a311);
            l3 = l1 - WebsocketConnectionThread.MF_CLASS78_l293(MF_CLASS82_a311.MF_CLASS82_a311);
            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("LastPositionTimeoutCheck() curTime = ").append(l1).append(", lastPositionTimestamp = ").append(WebsocketConnectionThread.MF_CLASS78_k292(MF_CLASS82_a311.MF_CLASS82_a311)).append(", sessionErrorSent = ").append(WebsocketConnectionThread.MF_CLASS78_m294(MF_CLASS82_a311.MF_CLASS82_a311)).append(", diffSinceLastPosition = ").append(l2).append(", diffSinceInitReady = ").append(l3).append(", millisUntilFinished = ").append(l).append(", this = ").append(this).toString());
        }
        catch(Exception exception)
        {
        	exception.printStackTrace();
        	return;
        }
        if(l3 >= 5000L && l2 > 40000L) {
	        if(WebsocketConnectionThread.MF_CLASS78_k292(MF_CLASS82_a311.MF_CLASS82_a311) != 0L && !WebsocketConnectionThread.MF_CLASS78_m294(MF_CLASS82_a311.MF_CLASS82_a311))
	        {
	            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("LastPositionTimeoutCheck() : positions not received in last 40s --> calling remoteImplementation.relayPositioningError, this = ").append(this).toString());
	            WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS82_a311.MF_CLASS82_a311, true);
	            WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS82_a311.MF_CLASS82_a311).MF_CLASS19_a67(2005, "Error in session, no positions received for a long while during session.");
	            return;
	        }
        }
        if(WebsocketConnectionThread.MF_CLASS78_l293(MF_CLASS82_a311.MF_CLASS82_a311) != 0L && l3 > 30000L) {
            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("LastPositionTimeoutCheck() : no actions., this = ").append(this).toString());
            return;
        }
        if(WebsocketConnectionThread.MF_CLASS78_k292(MF_CLASS82_a311.MF_CLASS82_a311) == 0L && !WebsocketConnectionThread.MF_CLASS78_m294(MF_CLASS82_a311.MF_CLASS82_a311))
        {
            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("LastPositionTimeoutCheck() : positions not received after init ready within 30s --> relayPositioningError, this = ").append(this).toString());
            WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS82_a311.MF_CLASS82_a311, true);
            WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS82_a311.MF_CLASS82_a311).MF_CLASS19_a67(2005, "Error in session, no positions received for a long while.");
            return;
        }
        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("LastPositionTimeoutCheck() : no actions., this = ").append(this).toString());
        return;
    }

    final CLASS82 MF_CLASS82_a311;
}
