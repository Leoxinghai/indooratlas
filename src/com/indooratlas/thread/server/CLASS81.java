// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread.server;

import android.os.CountDownTimer;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.RemoteImplementation;

// Referenced classes of package com.indooratlas.thread.server:
//            CLASS80, WebsocketConnectionThread

class CLASS81 extends CountDownTimer
{

    CLASS81(CLASS80 class80, long l, long l1)
    {
        super(l, l1);
        MF_CLASS80_a309 = class80;
    }

    public void onFinish()
    {
        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("initTimeOutTimer: running.").append(this).toString());
        try
        {
            if(WebsocketConnectionThread.MF_CLASS24_c88(MF_CLASS80_a309.MF_CLASS80_a309))
            {
                CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("initTimeOutTimer: session has been initilized and BG calib sent and ack. Stopping self.").append(this).toString());
                WebsocketConnectionThread.MF_CLASS78_j291(MF_CLASS80_a309.MF_CLASS80_a309);
                return;
            }
        }
        catch(Exception exception)
        {
        	exception.printStackTrace();
        	return;
        }
        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "initTimeOutTimer: session has **NOT** been initilized");
        if(!MF_CLASS80_a309.MF_CLASS80_a309.MF_CLASS78_e286())
        {
            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("initTimeOutTimer: **NOT** reconnectCycleOngoing --> calling connection.disconnect").append(this).toString());
            WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS80_a309.MF_CLASS80_a309).MF_CLASS19_a67(2002, "Initialization timeout.");
            MF_CLASS80_a309.MF_CLASS80_a309.stopSession();
            WebsocketConnectionThread.MF_CLASS78_j291(MF_CLASS80_a309.MF_CLASS80_a309);
            return;
        }
        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("initTimeOutTimer: reconnectCycleOngoing --> doing nothing.").append(this).toString());
        return;
    }

    public void onTick(long l)
    {
    }

    final CLASS80 MF_CLASS80_a309;
}
