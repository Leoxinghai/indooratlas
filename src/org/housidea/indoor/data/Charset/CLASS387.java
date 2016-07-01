// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.housidea.indoor.data.Charset;


// Referenced classes of package org.housidea.indoor.data.Charset:
//            CLASS389

public abstract class CLASS387
{

    protected CLASS387(int i, int j, int k, int l)
    {
        MF_CLASS387_a1120 = i;
        MF_CLASS389_d1140 = j;
        boolean flag;
        int i1;
        if(k > 0 && l > 0)
            flag = true;
        else
            flag = false;
        i1 = 0;
        if(flag)
            i1 = j * (k / j);
        MF_CLASS389_c1134 = i1;
        MF_CLASS389_e1141 = l;
    }

    private byte[] MF_CLASS387_b1119(CLASS389 class389)
    {
        if(class389.MF_CLASS389_c1134 == null)
        {
            class389.MF_CLASS389_c1134 = new byte[MF_CLASS387_a1120()];
            class389.MF_CLASS389_d1140 = 0;
            class389.MF_CLASS389_e1141 = 0;
        } else
        {
            byte abyte0[] = new byte[2 * class389.MF_CLASS389_c1134.length];
            System.arraycopy(class389.MF_CLASS389_c1134, 0, abyte0, 0, class389.MF_CLASS389_c1134.length);
            class389.MF_CLASS389_c1134 = abyte0;
        }
        return class389.MF_CLASS389_c1134;
    }

    protected int MF_CLASS387_a1120()
    {
        return 8192;
    }

    int MF_CLASS387_a1120(CLASS389 class389)
    {
        if(class389.MF_CLASS389_c1134 != null)
            return class389.MF_CLASS389_d1140 - class389.MF_CLASS389_e1141;
        else
            return 0;
    }

    abstract void MF_CLASS387_a1120(byte abyte0[], int i, int j, CLASS389 class389);

    protected abstract boolean MF_CLASS387_a1120(byte byte0);

    protected byte[] MF_CLASS387_a1120(int i, CLASS389 class389)
    {
        if(class389.MF_CLASS389_c1134 == null || class389.MF_CLASS389_c1134.length < i + class389.MF_CLASS389_d1140)
            return MF_CLASS387_b1119(class389);
        else
            return class389.MF_CLASS389_c1134;
    }

    int MF_CLASS387_b1119(byte abyte0[], int i, int j, CLASS389 class389)
    {
        if(class389.MF_CLASS389_c1134 != null)
        {
            int k = Math.min(MF_CLASS387_a1120(class389), j);
            System.arraycopy(class389.MF_CLASS389_c1134, class389.MF_CLASS389_e1141, abyte0, i, k);
            class389.MF_CLASS389_e1141 = k + class389.MF_CLASS389_e1141;
            if(class389.MF_CLASS389_e1141 >= class389.MF_CLASS389_d1140)
                class389.MF_CLASS389_c1134 = null;
            return k;
        }
        return !class389.MF_CLASS389_f1136 ? 0 : -1;
    }

    public byte[] MF_CLASS387_b1119(byte abyte0[])
    {
        if(abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        } else
        {
            CLASS389 class389 = new CLASS389();
            MF_CLASS387_a1120(abyte0, 0, abyte0.length, class389);
            MF_CLASS387_a1120(abyte0, 0, -1, class389);
            byte abyte1[] = new byte[class389.MF_CLASS389_d1140 - class389.MF_CLASS389_e1141];
            MF_CLASS387_b1119(abyte1, 0, abyte1.length, class389);
            return abyte1;
        }
    }

    protected boolean MF_CLASS389_c1134(byte abyte0[])
    {
        if(abyte0 != null)
        {
            int i = abyte0.length;
            int j = 0;
            while(j < i) 
            {
                byte byte0 = abyte0[j];
                if(61 == byte0 || MF_CLASS387_a1120(byte0))
                    return true;
                j++;
            }
        }
        return false;
    }

    public long MF_CLASS389_d1140(byte abyte0[])
    {
        long l = (long)((-1 + (abyte0.length + MF_CLASS387_a1120)) / MF_CLASS387_a1120) * (long)MF_CLASS389_d1140;
        if(MF_CLASS389_c1134 > 0)
            l += (((l + (long)MF_CLASS389_c1134) - 1L) / (long)MF_CLASS389_c1134) * (long)MF_CLASS389_e1141;
        return l;
    }

    private final int MF_CLASS387_a1120;
    protected final byte MF_CLASS387_b1119 = 61;
    protected final int MF_CLASS389_c1134;
    private final int MF_CLASS389_d1140;
    private final int MF_CLASS389_e1141;
}
