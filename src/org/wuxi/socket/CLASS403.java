// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.socket;

import java.nio.ByteBuffer;
import java.util.*;
import org.wuxi.exception.CLASS407;
import org.wuxi.exception.CLASS408;
import org.wuxi.optcode.*;
import org.wuxi.type.*;

// Referenced classes of package org.wuxi.socket:
//            CLASS397, CLASS399, CLASS398

public class CLASS403 extends Draft
{

    public CLASS403()
    {
        MF_CLASS403_f1189 = false;
        MF_CLASS403_g1190 = new LinkedList();
    }

    public ByteBuffer MF_CLASS413_a1212(Framedata class414)
    {
        if(class414.getOpcode() != CLASS419.TEXT)
        {
            throw new RuntimeException("only text frames supported");
        } else
        {
            ByteBuffer bytebuffer = class414.getPayloadData();
            ByteBuffer bytebuffer1 = ByteBuffer.allocate(2 + bytebuffer.remaining());
            bytebuffer1.put((byte)0);
            bytebuffer.mark();
            bytebuffer1.put(bytebuffer);
            bytebuffer.reset();
            bytebuffer1.put((byte)-1);
            bytebuffer1.flip();
            return bytebuffer1;
        }
    }

    public List MF_CLASS413_a1212(ByteBuffer bytebuffer, boolean flag)
    {
        throw new RuntimeException("not yet implemented");
    }

    public CLASS399 MF_CLASS413_a1212(CLASS421 class421)
    {
        if(class421.MF_CLASS420_c1243("Origin") && MF_CLASS413_a1212(((org.wuxi.type.Handshakedata) (class421))))
            return CLASS399.MF_CLASS399_a1168;
        else
            return CLASS399.MF_CLASS399_b1169;
    }

    public CLASS399 MF_CLASS413_a1212(CLASS421 class421, ServerHandshake class426)
    {
        if(class421.MF_CLASS420_b1242("WebSocket-Origin").equals(class426.MF_CLASS420_b1242("Origin")) && MF_CLASS413_a1212(((org.wuxi.type.Handshakedata) (class426))))
            return CLASS399.MF_CLASS399_a1168;
        else
            return CLASS399.MF_CLASS399_b1169;
    }

    public CLASS423 MF_CLASS413_a1212(CLASS423 class423)
    {
        class423.MF_CLASS422_a1245("Upgrade", "WebSocket");
        class423.MF_CLASS422_a1245("Connection", "Upgrade");
        if(!class423.MF_CLASS420_c1243("Origin"))
            class423.MF_CLASS422_a1245("Origin", (new StringBuilder()).append("random").append(MF_CLASS403_i1191.nextInt()).toString());
        return class423;
    }

    public CLASS422 MF_CLASS413_a1212(CLASS421 class421, CLASS427 class427) throws CLASS407
    {
        class427.MF_CLASS427_a1252("Web Socket Protocol Handshake");
        class427.MF_CLASS422_a1245("Upgrade", "WebSocket");
        class427.MF_CLASS422_a1245("Connection", class421.MF_CLASS420_b1242("Connection"));
        class427.MF_CLASS422_a1245("WebSocket-Origin", class421.MF_CLASS420_b1242("Origin"));
        class427.MF_CLASS422_a1245("WebSocket-Location", (new StringBuilder()).append("ws://").append(class421.MF_CLASS420_b1242("Host")).append(class421.MF_CLASS421_a1244()).toString());
        return class427;
    }

    public void MF_CLASS413_a1212()
    {
        MF_CLASS403_f1189 = false;
        MF_CLASS403_h1192 = null;
    }

    public CLASS398 MF_CLASS397_b1160()
    {
        return CLASS398.MF_CLASS398_a1164;
    }

    public List MF_CLASS397_c1161(ByteBuffer bytebuffer) throws CLASS407
    {
        List list = MF_CLASS403_e1188(bytebuffer);
        if(list == null)
            throw new CLASS407(1002);
        else
            return list;
    }

    public Draft MF_CLASS397_c1161()
    {
        return new CLASS403();
    }

    public ByteBuffer MF_CLASS403_d1187()
    {
        return ByteBuffer.allocate(MF_CLASS397_b1160);
    }

    protected List MF_CLASS403_e1188(ByteBuffer bytebuffer) throws CLASS408
    {
        List list;
        while(bytebuffer.hasRemaining()) 
        {
            byte byte0 = bytebuffer.get();
            if(byte0 == 0)
            {
                if(MF_CLASS403_f1189)
                    throw new CLASS408("unexpected START_OF_FRAME");
                MF_CLASS403_f1189 = true;
            } else
            if(byte0 == -1)
            {
                if(!MF_CLASS403_f1189)
                    throw new CLASS408("unexpected END_OF_FRAME");
                if(MF_CLASS403_h1192 != null)
                {
                    MF_CLASS403_h1192.flip();
                    CLASS417 class417 = new CLASS417();
                    class417.MF_CLASS416_a1221(MF_CLASS403_h1192);
                    class417.MF_CLASS416_a1221(true);
                    class417.MF_CLASS416_a1221(CLASS419.TEXT);
                    MF_CLASS403_g1190.add(class417);
                    MF_CLASS403_h1192 = null;
                    bytebuffer.mark();
                }
                MF_CLASS403_f1189 = false;
            } else
            {
                boolean flag = MF_CLASS403_f1189;
                list = null;
                if(!flag)
                    return list;
                if(MF_CLASS403_h1192 == null)
                    MF_CLASS403_h1192 = MF_CLASS403_d1187();
                else
                if(!MF_CLASS403_h1192.hasRemaining())
                    MF_CLASS403_h1192 = MF_CLASS403_f1189(MF_CLASS403_h1192);
                MF_CLASS403_h1192.put(byte0);
            }
        }
        list = MF_CLASS403_g1190;
        MF_CLASS403_g1190 = new LinkedList();
        return list;
    }

    public ByteBuffer MF_CLASS403_f1189(ByteBuffer bytebuffer)
    {
        try {
	    	bytebuffer.flip();
	        ByteBuffer bytebuffer1 = ByteBuffer.allocate(this.MF_CLASS413_a1212(2 * bytebuffer.capacity()));
	        bytebuffer1.put(bytebuffer);
	        return bytebuffer1;
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        return null;
    }

    protected boolean MF_CLASS403_f1189;
    protected List MF_CLASS403_g1190;
    protected ByteBuffer MF_CLASS403_h1192;
    private final Random MF_CLASS403_i1191 = new Random();
}
