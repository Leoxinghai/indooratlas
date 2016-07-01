// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.optcode;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.wuxi.save.CLASS432;

// Referenced classes of package org.wuxi.optcode:
//            CLASS416, CLASS414, CLASS419

public class CLASS417
    implements CLASS416
{

    public CLASS417()
    {
    }

    public CLASS417(Framedata class414)
    {
        MF_CLASS417_c1225 = class414.isFin();
        MF_CLASS417_d1226 = class414.getOpcode();
        MF_CLASS417_a1223 = class414.getPayloadData();
        MF_CLASS417_e1227 = class414.getTransfereMasked();
    }

    public CLASS417(CLASS419 class419)
    {
        MF_CLASS417_d1226 = class419;
        MF_CLASS417_a1223 = ByteBuffer.wrap(MF_CLASS417_b1224);
    }

    public void MF_CLASS416_a1221(ByteBuffer bytebuffer)
    {
        MF_CLASS417_a1223 = bytebuffer;
    }

    public void MF_CLASS416_a1221(CLASS419 class419)
    {
        MF_CLASS417_d1226 = class419;
    }

    public void MF_CLASS416_a1221(boolean flag)
    {
        MF_CLASS417_c1225 = flag;
    }

    public void MF_CLASS416_b1222(boolean flag)
    {
        MF_CLASS417_e1227 = flag;
    }

    public ByteBuffer getPayloadData()
    {
        return MF_CLASS417_a1223;
    }

    public boolean isFin()
    {
        return MF_CLASS417_c1225;
    }

    public boolean getTransfereMasked()
    {
        return MF_CLASS417_e1227;
    }

    public CLASS419 getOpcode()
    {
        return MF_CLASS417_d1226;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Framedata{ optcode:").append(getOpcode()).append(", fin:").append(isFin()).append(", payloadlength:[pos:").append(MF_CLASS417_a1223.position()).append(", len:").append(MF_CLASS417_a1223.remaining()).append("], payload:").append(Arrays.toString(CLASS432.a(new String(MF_CLASS417_a1223.array())))).append("}").toString();
    }

    protected static byte MF_CLASS417_b1224[] = new byte[0];
    private ByteBuffer MF_CLASS417_a1223;
    protected boolean MF_CLASS417_c1225;
    protected CLASS419 MF_CLASS417_d1226;
    protected boolean MF_CLASS417_e1227;

}
