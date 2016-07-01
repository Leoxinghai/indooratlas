// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.uri;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import org.wuxi.WebSocketImpl;

// Referenced classes of package org.wuxi.uri:
//            WebSocketClient, CLASS395

class CLASS396
    implements Runnable
{

    public CLASS396(WebSocketClient class89)
    {
        MF_CLASS396_a1158 = class89;
    }


    public void run()
    {
        Thread.currentThread().setName("WebsocketWriteThread");
        try
        {
            for(; !Thread.interrupted(); WebSocketClient.MF_CLASS89_b326(MF_CLASS396_a1158).flush())
            {
                ByteBuffer bytebuffer = (ByteBuffer)WebSocketClient.engine(MF_CLASS396_a1158).outQueue.take();
                WebSocketClient.MF_CLASS89_b326(MF_CLASS396_a1158).write(bytebuffer.array(), 0, bytebuffer.limit());
            }

        }
        catch(IOException ioexception)
        {
            WebSocketClient.engine(MF_CLASS396_a1158).eot();
        }
        catch(InterruptedException interruptedexception)
        {
            return;
        }
    }

    final WebSocketClient MF_CLASS396_a1158;
}
