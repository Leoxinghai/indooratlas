// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread.server;


// Referenced classes of package com.indooratlas.thread.server:
//            CLASS81, CLASS78

class CLASS80
    implements Runnable
{

    CLASS80(WebsocketConnectionThread class78)
    {
        MF_CLASS80_a309 = class78;

    }

    public void run()
    {
    	WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS80_a309, (new CLASS81(this, 30000L, 30000L)).start());
    }

    final WebsocketConnectionThread MF_CLASS80_a309;
}
