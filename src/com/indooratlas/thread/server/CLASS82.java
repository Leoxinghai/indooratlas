// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread.server;


// Referenced classes of package com.indooratlas.thread.server:
//            CLASS83, WebsocketConnectionThread

class CLASS82
    implements Runnable
{

    CLASS82(WebsocketConnectionThread class78)
    {
        MF_CLASS82_a311 = class78;

    }

    public void run()
    {
        WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS82_a311, (new CLASS83(this, 0x7fffffffffffffffL, 2000L)).start());
    }

    final WebsocketConnectionThread MF_CLASS82_a311;
}
