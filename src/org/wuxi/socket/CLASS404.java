// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.socket;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import org.wuxi.Role;
import org.wuxi.exception.*;
import org.wuxi.optcode.*;
import org.wuxi.type.*;

// Referenced classes of package org.wuxi.socket:
//            CLASS403, CLASS399, CLASS398, CLASS397

public class CLASS404 extends CLASS403
{

    public CLASS404()
    {
        MF_CLASS404_i1199 = false;
    }

    private static byte[] MF_CLASS413_a1212(String s) throws CLASS409
    {
        long l;
        long l1;
        try
        {
            l = Long.parseLong(s.replaceAll("[^0-9]", ""));
            l1 = -1 + s.split(" ").length;
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new CLASS409("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
        if(l1 == 0L)
        	throw new CLASS409("invalid Sec-WebSocket-Key (/key2/)");
        byte abyte0[];
        long l2 = (new Long(l / l1)).longValue();
        abyte0 = new byte[4];
        abyte0[0] = (byte)(int)(l2 >> 24);
        abyte0[1] = (byte)(int)((l2 << 8) >> 24);
        abyte0[2] = (byte)(int)((l2 << 16) >> 24);
        abyte0[3] = (byte)(int)((l2 << 24) >> 24);
        return abyte0;
    }

    public static byte[] MF_CLASS413_a1212(String s, String s1, byte abyte0[])
    {
        try
        {
	        byte abyte1[] = MF_CLASS413_a1212(s);
	        byte abyte2[] = MF_CLASS413_a1212(s1);
	        byte abyte3[] = new byte[16];
	        abyte3[0] = abyte1[0];
	        abyte3[1] = abyte1[1];
	        abyte3[2] = abyte1[2];
	        abyte3[3] = abyte1[3];
	        abyte3[4] = abyte2[0];
	        abyte3[5] = abyte2[1];
	        abyte3[6] = abyte2[2];
	        abyte3[7] = abyte2[3];
	        abyte3[8] = abyte0[0];
	        abyte3[9] = abyte0[1];
	        abyte3[10] = abyte0[2];
	        abyte3[11] = abyte0[3];
	        abyte3[12] = abyte0[4];
	        abyte3[13] = abyte0[5];
	        abyte3[14] = abyte0[6];
	        abyte3[15] = abyte0[7];
	        MessageDigest messagedigest;
            messagedigest = MessageDigest.getInstance("MD5");
            return messagedigest.digest(abyte3);
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new RuntimeException(nosuchalgorithmexception);
        } catch(Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
    }

    private static String MF_CLASS404_e1194()
    {
        Random random = new Random();
        long l = 1 + random.nextInt(12);
        String s = Long.toString(l * (long)(1 + random.nextInt(Math.abs((new Long(0xffffffffL / l)).intValue()))));
        int i = 1 + random.nextInt(12);
        for(int j = 0; j < i; j++)
        {
            int j1 = Math.abs(random.nextInt(s.length()));
            char c = (char)(33 + random.nextInt(95));
            if(c >= '0' && c <= '9')
                c -= '\017';
            s = (new StringBuilder(s)).insert(j1, c).toString();
        }

        int k = 0;
        String s1 = s;
        for(; (long)k < l; k++)
        {
            int i1 = Math.abs(1 + random.nextInt(-1 + s1.length()));
            s1 = (new StringBuilder(s1)).insert(i1, " ").toString();
        }

        return s1;
    }

    public ByteBuffer MF_CLASS413_a1212(Framedata class414)
    {
        if(class414.getOpcode() == CLASS419.CLOSING)
            return ByteBuffer.wrap(MF_CLASS404_j1198);
        else
            return MF_CLASS413_a1212(class414);
    }

    public CLASS399 MF_CLASS413_a1212(CLASS421 class421)
    {
        if(class421.MF_CLASS420_b1242("Upgrade").equals("WebSocket") && class421.MF_CLASS420_b1242("Connection").contains("Upgrade") && class421.MF_CLASS420_b1242("Sec-WebSocket-Key1").length() > 0 && !class421.MF_CLASS420_b1242("Sec-WebSocket-Key2").isEmpty() && class421.MF_CLASS420_c1243("Origin"))
            return CLASS399.MF_CLASS399_a1168;
        else
            return CLASS399.MF_CLASS399_b1169;
    }

    public CLASS399 MF_CLASS413_a1212(CLASS421 class421, ServerHandshake class426) throws CLASS406
    {
        byte abyte0[];
        if(MF_CLASS404_i1199)
            return CLASS399.MF_CLASS399_b1169;
        try
        {
            if(!class426.MF_CLASS420_b1242("Sec-WebSocket-Origin").equals(class421.MF_CLASS420_b1242("Origin")) || !MF_CLASS413_a1212(((Handshakedata) (class426))))
                return CLASS399.MF_CLASS399_b1169;
            abyte0 = class426.MF_CLASS420_c1243();
        }
        catch(Exception class409)
        {
            throw new RuntimeException("bad handshakerequest", class409);
        }
        if(abyte0 == null)
            throw new CLASS406();
        
        CLASS399 class399;
        if(abyte0.length != 0) {
	        if(Arrays.equals(abyte0, MF_CLASS413_a1212(class421.MF_CLASS420_b1242("Sec-WebSocket-Key1"), class421.MF_CLASS420_b1242("Sec-WebSocket-Key2"), class421.MF_CLASS420_c1243())))
	            return CLASS399.MF_CLASS399_a1168;
        }
        class399 = CLASS399.MF_CLASS399_b1169;
        return class399;
    }

    public CLASS423 MF_CLASS413_a1212(CLASS423 class423)
    {
    	class423.MF_CLASS422_a1245("Upgrade", "WebSocket");
        class423.MF_CLASS422_a1245("Connection", "Upgrade");
        class423.MF_CLASS422_a1245("Sec-WebSocket-Key1", MF_CLASS404_e1194());
        class423.MF_CLASS422_a1245("Sec-WebSocket-Key2", MF_CLASS404_e1194());
        if(!class423.MF_CLASS420_c1243("Origin"))
            class423.MF_CLASS422_a1245("Origin", (new StringBuilder()).append("random").append(MF_CLASS404_k1200.nextInt()).toString());
        byte abyte0[] = new byte[8];
        MF_CLASS404_k1200.nextBytes(abyte0);
        class423.MF_CLASS422_a1245(abyte0);
        return class423;
    }

    public CLASS422 MF_CLASS413_a1212(CLASS421 class421, CLASS427 class427) throws CLASS407
    {
        class427.MF_CLASS427_a1252("WebSocket Protocol Handshake");
        class427.MF_CLASS422_a1245("Upgrade", "WebSocket");
        class427.MF_CLASS422_a1245("Connection", class421.MF_CLASS420_b1242("Connection"));
        class427.MF_CLASS422_a1245("Sec-WebSocket-Origin", class421.MF_CLASS420_b1242("Origin"));
        class427.MF_CLASS422_a1245("Sec-WebSocket-Location", (new StringBuilder()).append("ws://").append(class421.MF_CLASS420_b1242("Host")).append(class421.MF_CLASS421_a1244()).toString());
        String s = class421.MF_CLASS420_b1242("Sec-WebSocket-Key1");
        String s1 = class421.MF_CLASS420_b1242("Sec-WebSocket-Key2");
        byte abyte0[] = class421.MF_CLASS420_c1243();
        if(s == null || s1 == null || abyte0 == null || abyte0.length != 8)
        {
            throw new CLASS409("Bad keys");
        } else
        {
            class427.MF_CLASS422_a1245(MF_CLASS413_a1212(s, s1, abyte0));
            return class427;
        }
    }

    public CLASS398 MF_CLASS413_b1213()
    {
        return CLASS398.MF_CLASS398_b1165;
    }

    public List MF_CLASS404_c1196(ByteBuffer bytebuffer) throws Exception
    {
        List list;
        bytebuffer.mark();
        list = this.MF_CLASS403_e1188(bytebuffer);
        if(list == null)
        {
            bytebuffer.reset();
            list = this.MF_CLASS403_g1190;
            this.MF_CLASS403_f1189 = true;
            if(this.MF_CLASS403_h1192 == null)
            {
            	MF_CLASS403_h1192 = ByteBuffer.allocate(2);
                if(bytebuffer.remaining() > MF_CLASS403_h1192.remaining())
                    throw new CLASS408();
            } else
            {
                throw new CLASS408();
            }
            MF_CLASS403_h1192.put(bytebuffer);
            if(MF_CLASS403_h1192.hasRemaining()) {
            	MF_CLASS403_g1190 = new LinkedList();
                return list;
            }            	
            if(!Arrays.equals(MF_CLASS403_h1192.array(), MF_CLASS404_j1198))
            	throw new CLASS408();
            list.add(new CLASS418(1000));
        }
        return list;
    }

    public Draft MF_CLASS404_c1196()
    {
        return new CLASS404();
    }

    public Handshakedata MF_CLASS404_d1197(ByteBuffer bytebuffer)
    {
        try
        {
	        CLASS422 class422 = MF_CLASS413_a1212(bytebuffer, this.MF_CLASS397_d1162);
	        if((class422.MF_CLASS420_c1243("Sec-WebSocket-Key1") || MF_CLASS397_d1162 == Role.MF_CLASS413_a1212) && !class422.MF_CLASS420_c1243("Sec-WebSocket-Version"))
	        {
	            byte byte0;
	            byte abyte0[];
	            if(MF_CLASS397_d1162 == Role.MF_CLASS413_b1213)
	                byte0 = 8;
	            else
	                byte0 = 16;
	            abyte0 = new byte[byte0];
	                bytebuffer.get(abyte0);
	            class422.MF_CLASS422_a1245(abyte0);
	        }
	        return class422;
        }
        catch(BufferUnderflowException bufferunderflowexception)
        {
            throw new CLASS406(16 + bytebuffer.capacity());
        } catch(Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
        
    }

    private static final byte MF_CLASS404_j1198[] = {
        -1, 0
    };
    private boolean MF_CLASS404_i1199;
    private final Random MF_CLASS404_k1200 = new Random();

}
