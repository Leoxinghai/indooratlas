// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.socket;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import org.wuxi.Role;
import org.wuxi.exception.*;
import org.wuxi.optcode.*;
import org.wuxi.save.CLASS430;
import org.wuxi.type.*;

// Referenced classes of package org.wuxi.socket:
//            CLASS397, CLASS399, CLASS398, CLASS401

public class CLASS400 extends Draft
{

    public CLASS400()
    {
        MF_CLASS400_h1176 = null;
    }

    private byte MF_CLASS413_a1212(CLASS419 class419)
    {
        if(class419 == CLASS419.CONTINUOUS)
            return 0;
        if(class419 == CLASS419.TEXT)
            return 1;
        if(class419 == CLASS419.BINARY)
            return 2;
        if(class419 == CLASS419.CLOSING)
            return 8;
        if(class419 == CLASS419.PING)
            return 9;
        if(class419 == CLASS419.PONG)
            return 10;
        else
            throw new RuntimeException((new StringBuilder()).append("Don't know how to handle ").append(class419.toString()).toString());
    }

    private String MF_CLASS413_a1212(String s)
    {
        String s1 = s.trim();
        String s2 = (new StringBuilder()).append(s1).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11").toString();
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA1");
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new RuntimeException(nosuchalgorithmexception);
        }
        return CLASS430.MF_CLASS430_a1276(messagedigest.digest(s2.getBytes()));
    }

    private CLASS419 MF_CLASS413_a1212(byte byte0) throws CLASS408
    {
        switch(byte0)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            throw new CLASS408((new StringBuilder()).append("unknow optcode ").append((short)byte0).toString());

        case 0: // '\0'
            return CLASS419.CONTINUOUS;

        case 1: // '\001'
            return CLASS419.TEXT;

        case 2: // '\002'
            return CLASS419.BINARY;

        case 8: // '\b'
            return CLASS419.CLOSING;

        case 9: // '\t'
            return CLASS419.PING;

        case 10: // '\n'
            return CLASS419.PONG;
        }
    }

    private byte[] MF_CLASS413_a1212(long l, int i)
    {
        byte abyte0[] = new byte[i];
        int j = -8 + i * 8;
        for(int k = 0; k < i; k++)
            abyte0[k] = (byte)(int)(l >>> j - k * 8);

        return abyte0;
    }

    public static int MF_CLASS397_b1160(Handshakedata class420)
    {
        int i = -1;
        String s = class420.MF_CLASS420_b1242("Sec-WebSocket-Version");
        if(s.length() > 0)
        {
            int j;
            try
            {
                j = (new Integer(s.trim())).intValue();
            }
            catch(NumberFormatException numberformatexception)
            {
                return i;
            }
            i = j;
        }
        return i;
    }

    public ByteBuffer MF_CLASS413_a1212(Framedata class414)
    {
        byte byte0 = -128;
        int i = 0;
        ByteBuffer bytebuffer = class414.getPayloadData();
        boolean flag;
        int j;
        int k;
        int l;
        byte byte1;
        ByteBuffer bytebuffer1;
        byte byte2;
        byte byte3;
        byte abyte0[];
        ByteBuffer bytebuffer2;
        
        if(this.MF_CLASS397_d1162 == Role.MF_CLASS413_a1212)
            flag = true;
        else
            flag = false;
        if(bytebuffer.remaining() <= 125)
            j = 1;
        else
        if(bytebuffer.remaining() <= 65535)
            j = 2;
        else
            j = 8;
        if(j > 1)
            k = j + 1;
        else
            k = j;
        l = k + 1;
        if(flag)
            byte1 = 4;
        else
            byte1 = 0;
        bytebuffer1 = ByteBuffer.allocate(byte1 + l + bytebuffer.remaining());
        byte2 = MF_CLASS413_a1212(class414.getOpcode());
        if(class414.isFin())
            byte3 = byte0;
        else
            byte3 = 0;
        bytebuffer1.put((byte)(byte2 | byte3));
        abyte0 = MF_CLASS413_a1212(bytebuffer.remaining(), j);
        if(!MF_CLASS419_f1240 && abyte0.length != j)
            throw new AssertionError();
        
        byte byte4 = abyte0[0];
        if(j == 1)
        {
            if(!flag)
                byte0 = 0;
            bytebuffer1.put((byte)(byte4 | byte0));
        } else
        if(j == 2)
        {
            if(!flag)
                byte0 = 0;
            bytebuffer1.put((byte)(byte0 | 0x7e));
            bytebuffer1.put(abyte0);
        } else
        if(j == 8)
        {
            if(!flag)
                byte0 = 0;
            bytebuffer1.put((byte)(byte0 | 0x7f));
            bytebuffer1.put(abyte0);
        } else
        {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if(flag)
        {
            bytebuffer2 = ByteBuffer.allocate(4);
            bytebuffer2.putInt(MF_CLASS400_i1177.nextInt());
            bytebuffer1.put(bytebuffer2.array());
            while(bytebuffer.hasRemaining()) 
            {
                bytebuffer1.put((byte)(bytebuffer.get() ^ bytebuffer2.get(i % 4)));
                i++;
            }
        } else
        {
            bytebuffer1.put(bytebuffer);
        }
        if(!MF_CLASS419_f1240 && bytebuffer1.remaining() != 0)
        {
            throw new AssertionError(bytebuffer1.remaining());
        } else
        {
            bytebuffer1.flip();
            return bytebuffer1;
        }
    }

    public List MF_CLASS413_a1212(ByteBuffer bytebuffer, boolean flag) throws CLASS411
    {
        CLASS417 class417 = new CLASS417();
        try
        {
            class417.MF_CLASS416_a1221(bytebuffer);
	        class417.MF_CLASS416_a1221(true);
	        class417.MF_CLASS416_a1221(CLASS419.BINARY);
	        class417.MF_CLASS416_b1222(flag);
        }
        catch(Exception class407)
        {
            throw new CLASS411(class407);
        }
        return Collections.singletonList(class417);
        
    }

    public CLASS399 MF_CLASS413_a1212(CLASS421 class421)
    {
        int i = MF_CLASS397_b1160(class421);
        if(i == 7 || i == 8)
        {
            if(MF_CLASS413_a1212(((Handshakedata) (class421))))
                return CLASS399.MF_CLASS399_a1168;
            else
                return CLASS399.MF_CLASS399_b1169;
        } else
        {
            return CLASS399.MF_CLASS399_b1169;
        }
    }

    public CLASS399 MF_CLASS413_a1212(CLASS421 class421, ServerHandshake class426)
    {
        if(!class421.MF_CLASS420_c1243("Sec-WebSocket-Key") || !class426.MF_CLASS420_c1243("Sec-WebSocket-Accept"))
            return CLASS399.MF_CLASS399_b1169;
        String s = class426.MF_CLASS420_b1242("Sec-WebSocket-Accept");
        if(MF_CLASS413_a1212(class421.MF_CLASS420_b1242("Sec-WebSocket-Key")).equals(s))
            return CLASS399.MF_CLASS399_a1168;
        else
            return CLASS399.MF_CLASS399_b1169;
    }

    public CLASS423 MF_CLASS413_a1212(CLASS423 class423)
    {
        class423.MF_CLASS422_a1245("Upgrade", "websocket");
        class423.MF_CLASS422_a1245("Connection", "Upgrade");
        class423.MF_CLASS422_a1245("Sec-WebSocket-Version", "8");
        byte abyte0[] = new byte[16];
        MF_CLASS400_i1177.nextBytes(abyte0);
        class423.MF_CLASS422_a1245("Sec-WebSocket-Key", CLASS430.MF_CLASS430_a1276(abyte0));
        return class423;
    }

    public CLASS422 MF_CLASS413_a1212(CLASS421 class421, CLASS427 class427) throws CLASS409
    {
        class427.MF_CLASS422_a1245("Upgrade", "websocket");
        class427.MF_CLASS422_a1245("Connection", class421.MF_CLASS420_b1242("Connection"));
        class427.MF_CLASS427_a1252("Switching Protocols");
        String s = class421.MF_CLASS420_b1242("Sec-WebSocket-Key");
        if(s == null)
        {
            throw new CLASS409("missing Sec-WebSocket-Key");
        } else
        {
            class427.MF_CLASS422_a1245("Sec-WebSocket-Accept", MF_CLASS413_a1212(s));
            return class427;
        }
    }

    public void MF_CLASS413_a1212()
    {
        MF_CLASS400_g1179 = null;
    }

    public CLASS398 MF_CLASS397_b1160()
    {
        return CLASS398.MF_CLASS398_c1166;
    }

    public List MF_CLASS397_c1161(ByteBuffer bytebuffer) throws CLASS407
    {
        LinkedList linkedlist = new LinkedList();
        if(MF_CLASS400_g1179 == null)
            return null;
        CLASS401 class401;
        int i;
        int j;
        try
        {
            bytebuffer.mark();
            i = bytebuffer.remaining();
            j = MF_CLASS400_g1179.remaining();
	        if(j <= i) {
	            MF_CLASS400_g1179.put(bytebuffer.array(), bytebuffer.position(), j);
	            bytebuffer.position(j + bytebuffer.position());
	            linkedlist.add(MF_CLASS419_e1239((ByteBuffer)MF_CLASS400_g1179.duplicate().position(0)));
	            MF_CLASS400_g1179 = null;
	
	            for(;bytebuffer.hasRemaining();) {
	    	        bytebuffer.mark();
	    	        linkedlist.add(this.MF_CLASS419_e1239(bytebuffer));
	            }
	
//	            bytebuffer.reset();
//	            MF_CLASS400_g1179 = ByteBuffer.allocate(this.MF_CLASS413_a1212(class401.MF_CLASS401_a1180()));
//	            MF_CLASS400_g1179.put(bytebuffer);
	            return linkedlist;
	        	
	        }
	        MF_CLASS400_g1179.put(bytebuffer.array(), bytebuffer.position(), i);
	        bytebuffer.position(i + bytebuffer.position());
        }
        catch(CLASS401 class401_1)
        {
            MF_CLASS400_g1179.limit();
            ByteBuffer bytebuffer1 = ByteBuffer.allocate(this.MF_CLASS413_a1212(class401_1.MF_CLASS401_a1180()));
            if(!MF_CLASS419_f1240 && bytebuffer1.limit() <= MF_CLASS400_g1179.limit())
            {
                throw new AssertionError();
            } else
            {
                MF_CLASS400_g1179.rewind();
                bytebuffer1.put(MF_CLASS400_g1179);
                MF_CLASS400_g1179 = bytebuffer1;
                return MF_CLASS397_c1161(bytebuffer);
            }
        }
        
        return Collections.emptyList();
        
    }

    public Draft MF_CLASS397_c1161()
    {
        return new CLASS400();
    }

    public Framedata MF_CLASS419_e1239(ByteBuffer bytebuffer) throws CLASS407, CLASS401
    {
        byte byte0 = 2;
        int i = 0;
        int j = bytebuffer.remaining();
        if(j < byte0)
            throw new CLASS401(this, byte0);
        byte byte1 = bytebuffer.get();
        boolean flag;
        byte byte2;
        if(byte1 >> 8 != 0)
            flag = true;
        else
            flag = false;
        byte2 = (byte)((byte1 & 0x7f) >> 4);
        if(byte2 != 0)
            throw new CLASS408((new StringBuilder()).append("bad rsv ").append(byte2).toString());
        byte byte3 = bytebuffer.get();
        boolean flag1;
        int k;
        CLASS419 class419;
        if((byte3 & 0xffffff80) != 0)
            flag1 = true;
        else
            flag1 = false;
        k = (byte)(byte3 & 0x7f);
        class419 = MF_CLASS413_a1212((byte)(byte1 & 0xf));
        if(!flag && (class419 == CLASS419.PING || class419 == CLASS419.PONG || class419 == CLASS419.CLOSING))
            throw new CLASS408("control frames may no be fragmented");
        byte byte4;
        int j1;
        if(k < 0 || k > 125)
        {
            if(class419 == CLASS419.PING || class419 == CLASS419.PONG || class419 == CLASS419.CLOSING)
                throw new CLASS408("more than 125 octets");
            if(k == 126)
            {
                if(j < 4)
                    throw new CLASS401(this, 4);
                byte abyte2[] = new byte[3];
                abyte2[1] = bytebuffer.get();
                abyte2[byte0] = bytebuffer.get();
                k = (new BigInteger(abyte2)).intValue();
                byte0 = 4;
            } else
            {
                if(j < 10)
                    throw new CLASS401(this, 10);
                byte abyte0[] = new byte[8];
                for(int l = 0; l < 8; l++)
                    abyte0[l] = bytebuffer.get();

                long l1 = (new BigInteger(abyte0)).longValue();
                if(l1 > 0x7fffffffL)
                    throw new CLASS410("Payloadsize is to big...");
                int i1 = (int)l1;
                byte0 = 10;
                k = i1;
            }
        }
        if(flag1)
            byte4 = 4;
        else
            byte4 = 0;
        j1 = k + (byte4 + byte0);
        if(j < j1)
            throw new CLASS401(this, j1);
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(this.MF_CLASS413_a1212(k));
        if(flag1)
        {
            byte abyte1[] = new byte[4];
            bytebuffer.get(abyte1);
            for(; i < k; i++)
                bytebuffer1.put((byte)(bytebuffer.get() ^ abyte1[i % 4]));

        } else
        {
            bytebuffer1.put(bytebuffer.array(), bytebuffer.position(), bytebuffer1.limit());
            bytebuffer.position(bytebuffer.position() + bytebuffer1.limit());
        }
        Object obj;
        if(class419 == CLASS419.CLOSING)
        {
            obj = new CLASS418();
        } else
        {
            obj = new CLASS417();
            ((CLASS416) (obj)).MF_CLASS416_a1221(flag);
            ((CLASS416) (obj)).MF_CLASS416_a1221(class419);
        }
        bytebuffer1.flip();
        ((CLASS416) (obj)).MF_CLASS416_a1221(bytebuffer1);
        return ((Framedata) (obj));
    }

    static final boolean MF_CLASS419_f1240;
    private ByteBuffer MF_CLASS400_g1179;
    private Framedata MF_CLASS400_h1176;
    private final Random MF_CLASS400_i1177 = new Random();

    static 
    {
        boolean flag;
        if(!CLASS400.class.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        MF_CLASS419_f1240 = flag;
    }
}
