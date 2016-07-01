// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.optcode;

import java.nio.ByteBuffer;
import org.wuxi.exception.CLASS407;
import org.wuxi.exception.CLASS408;
import org.wuxi.save.CLASS432;

// Referenced classes of package org.wuxi.optcode:
//            CLASS417, CLASS415, CLASS419

public class CLASS418 extends CLASS417
    implements CLASS415
{

    public CLASS418()
    {
        super(CLASS419.CLOSING);
        MF_CLASS416_a1221(true);
    }

    public CLASS418(int i)
    {
    	super(CLASS419.CLOSING);
    	MF_CLASS416_a1221(true);
    	MF_CLASS418_a1229(i, "");
    }

    public CLASS418(int i, String s)
    {
    	super(CLASS419.CLOSING);
    	MF_CLASS416_a1221(true);
        MF_CLASS418_a1229(i, s);
    }

    private void MF_CLASS418_a1229(int i, String s)
    {
        String s1;
        if(s == null)
            s1 = "";
        else
            s1 = s;
        if(i == 1015)
        {
            s1 = "";
            i = 1005;
        }
         try {
        if(i == 1005)
        {
            if(s1.length() > 0)
                throw new CLASS407(1002, "A close frame must have a closecode if it has a reason");
        } else
        {
            byte abyte0[] = CLASS432.a(s1);
            ByteBuffer bytebuffer = ByteBuffer.allocate(4);
            bytebuffer.putInt(i);
            bytebuffer.position(2);
            ByteBuffer bytebuffer1 = ByteBuffer.allocate(2 + abyte0.length);
            bytebuffer1.put(bytebuffer);
            bytebuffer1.put(abyte0);
            bytebuffer1.rewind();
            MF_CLASS418_a1229(bytebuffer1);
        }
         } catch(Exception ex) {
        	 ex.printStackTrace();
         }
    }

    private void MF_CLASS418_g1230() throws CLASS408
    {
        MF_CLASS418_f1234 = 1005;
        ByteBuffer bytebuffer = MF_CLASS418_c1233();
        bytebuffer.mark();
        if(bytebuffer.remaining() >= 2)
        {
            ByteBuffer bytebuffer1 = ByteBuffer.allocate(4);
            bytebuffer1.position(2);
            bytebuffer1.putShort(bytebuffer.getShort());
            bytebuffer1.position(0);
            MF_CLASS418_f1234 = bytebuffer1.getInt();
            if(MF_CLASS418_f1234 == 1006 || MF_CLASS418_f1234 == 1015 || MF_CLASS418_f1234 == 1005 || MF_CLASS418_f1234 > 4999 || MF_CLASS418_f1234 < 1000 || MF_CLASS418_f1234 == 1004)
                throw new CLASS408((new StringBuilder()).append("closecode must not be sent over the wire: ").append(MF_CLASS418_f1234).toString());
        }
        bytebuffer.reset();
    }

    private void MF_CLASS418_h1231() throws CLASS407
    {
        ByteBuffer bytebuffer;
        int i;
        if(MF_CLASS418_f1234 == 1005)
        {
            MF_CLASS418_g1230 = CLASS432.a(MF_CLASS418_c1233());
            return;
        }
        bytebuffer = MF_CLASS418_c1233();
        i = bytebuffer.position();
        bytebuffer.position(2 + bytebuffer.position());
        MF_CLASS418_g1230 = CLASS432.a(bytebuffer);
        bytebuffer.position(i);
        return;
        /*
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        throw new CLASS408(illegalargumentexception);
        Exception exception;
        exception;
        bytebuffer.position(i);
        throw exception;
        */
    }

    public int MF_CLASS415_a1219()
    {
        return MF_CLASS418_f1234;
    }

    public void MF_CLASS418_a1229(ByteBuffer bytebuffer) throws CLASS407
    {
        MF_CLASS418_a1229(bytebuffer);
        MF_CLASS418_g1230();
        MF_CLASS418_h1231();
    }

    public String MF_CLASS415_b1220()
    {
        return MF_CLASS418_g1230;
    }

    public ByteBuffer MF_CLASS418_c1233()
    {
        if(MF_CLASS418_f1234 == 1005)
            return MF_CLASS418_a1229;
        else
            return MF_CLASS418_c1233();
    }

    public String toString()
    {
        return (new StringBuilder()).append(toString()).append("code: ").append(MF_CLASS418_f1234).toString();
    }

    static final ByteBuffer MF_CLASS418_a1229 = ByteBuffer.allocate(0);
    private int MF_CLASS418_f1234;
    private String MF_CLASS418_g1230;

}
