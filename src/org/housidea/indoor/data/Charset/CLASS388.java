// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.housidea.indoor.data.Charset;


// Referenced classes of package org.housidea.indoor.data.Charset:
//            CLASS387, CLASS390, CLASS389

public class CLASS388 extends CLASS387
{

    public CLASS388()
    {
        this(0);
    }

    public CLASS388(int i)
    {
        this(i, MF_CLASS389_a1137);
    }

    public CLASS388(int i, byte abyte0[])
    {
        this(i, abyte0, false);
    }

    public CLASS388(int i, byte abyte0[], boolean flag)
    {
        super(3, 4, i, abyte0==null?0:abyte0.length);
        
        MF_CLASS389_h1139 = MF_CLASS389_f1136;
        byte abyte1[];
        if(abyte0 != null)
        {
            if(MF_CLASS389_c1134(abyte0))
            {
                String s = CLASS390.MF_CLASS390_a1142(abyte0);
                throw new IllegalArgumentException((new StringBuilder()).append("lineSeparator must not contain base64 characters: [").append(s).append("]").toString());
            }
            if(i > 0)
            {
                MF_CLASS388_k1129 = 4 + abyte0.length;
                MF_CLASS388_i1130 = new byte[abyte0.length];
                System.arraycopy(abyte0, 0, MF_CLASS388_i1130, 0, abyte0.length);
            } else
            {
                MF_CLASS388_k1129 = 4;
                MF_CLASS388_i1130 = null;
            }
        } else
        {
            MF_CLASS388_k1129 = 4;
            MF_CLASS388_i1130 = null;
        }
        MF_CLASS388_j1131 = -1 + MF_CLASS388_k1129;
        if(flag)
            abyte1 = MF_CLASS388_e1126;
        else
            abyte1 = MF_CLASS389_d1140;
        MF_CLASS389_g1135 = abyte1;
    }

    public CLASS388(boolean flag)
    {
        this(76, MF_CLASS389_a1137, flag);
    }

    public static byte[] MF_CLASS387_a1120(byte abyte0[])
    {
        return MF_CLASS387_a1120(abyte0, false);
    }

    public static byte[] MF_CLASS387_a1120(byte abyte0[], boolean flag)
    {
        return MF_CLASS387_a1120(abyte0, flag, false);
    }

    public static byte[] MF_CLASS387_a1120(byte abyte0[], boolean flag, boolean flag1)
    {
        return MF_CLASS387_a1120(abyte0, flag, flag1, 0x7fffffff);
    }

    public static byte[] MF_CLASS387_a1120(byte abyte0[], boolean flag, boolean flag1, int i)
    {
        if(abyte0 == null || abyte0.length == 0)
            return abyte0;
        CLASS388 class388;
        long l;
        if(flag)
            class388 = new CLASS388(flag1);
        else
            class388 = new CLASS388(0, MF_CLASS389_a1137, flag1);
        l = class388.MF_CLASS389_d1140(abyte0);
        if(l > (long)i)
            throw new IllegalArgumentException((new StringBuilder()).append("Input array too big, the output array would be bigger (").append(l).append(") than the specified maximum size of ").append(i).toString());
        else
            return class388.MF_CLASS387_b1119(abyte0);
    }

    void MF_CLASS387_a1120(byte abyte0[], int i, int j, CLASS389 class389)
    {
        if(class389.MF_CLASS389_f1136) 
        	return;

        if(j < 0) {

        byte abyte2[];
        int j2;
        class389.MF_CLASS389_f1136 = true;
        if(class389.MF_CLASS389_h1139 == 0 && this.MF_CLASS389_c1134 == 0) {
        	return;
            //continue; /* Loop/switch isn't completed */
        }
        abyte2 = MF_CLASS387_a1120(MF_CLASS388_k1129, class389);
        j2 = class389.MF_CLASS389_d1140;
        switch(class389.MF_CLASS389_h1139) {
//        JVM INSTR tableswitch 0 2: default 84
    //                   0 243
    //                   1 115
    //                   2 314;
//           goto _L5 _L6 _L7 _L8
	        case 0:
		        break;
	default:
	        throw new IllegalStateException((new StringBuilder()).append("Impossible modulus ").append(class389.MF_CLASS389_h1139).toString());
	case 1:
	        int k3 = class389.MF_CLASS389_d1140;
	        class389.MF_CLASS389_d1140 = k3 + 1;
	        abyte2[k3] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 >> 2];
	        int l3 = class389.MF_CLASS389_d1140;
	        class389.MF_CLASS389_d1140 = l3 + 1;
	        abyte2[l3] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 << 4];
	        if(MF_CLASS389_g1135 == MF_CLASS389_d1140)
	        {
	            int i4 = class389.MF_CLASS389_d1140;
	            class389.MF_CLASS389_d1140 = i4 + 1;
	            abyte2[i4] = 61;
	            int j4 = class389.MF_CLASS389_d1140;
	            class389.MF_CLASS389_d1140 = j4 + 1;
	            abyte2[j4] = 61;
	        }
	        break;
	case 2:
	        int k2 = class389.MF_CLASS389_d1140;
	        class389.MF_CLASS389_d1140 = k2 + 1;
	        abyte2[k2] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 >> 10];
	        int l2 = class389.MF_CLASS389_d1140;
	        class389.MF_CLASS389_d1140 = l2 + 1;
	        abyte2[l2] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 >> 4];
	        int i3 = class389.MF_CLASS389_d1140;
	        class389.MF_CLASS389_d1140 = i3 + 1;
	        abyte2[i3] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 << 2];
	        if(MF_CLASS389_g1135 == MF_CLASS389_d1140)
	        {
	            int j3 = class389.MF_CLASS389_d1140;
	            class389.MF_CLASS389_d1140 = j3 + 1;
	            abyte2[j3] = 61;
	        }
	        break;
        }
        
        class389.MF_CLASS389_g1135 = class389.MF_CLASS389_g1135 + (class389.MF_CLASS389_d1140 - j2);
        if(MF_CLASS389_c1134 > 0 && class389.MF_CLASS389_g1135 > 0)
        {
            System.arraycopy(MF_CLASS388_i1130, 0, abyte2, class389.MF_CLASS389_d1140, MF_CLASS388_i1130.length);
            class389.MF_CLASS389_d1140 = class389.MF_CLASS389_d1140 + MF_CLASS388_i1130.length;
            return;
        }
    
        
        } else {

	        int k = 0;
	        while(k < j) 
	        {
	            byte abyte1[] = MF_CLASS387_a1120(MF_CLASS388_k1129, class389);
	            class389.MF_CLASS389_h1139 = (1 + class389.MF_CLASS389_h1139) % 3;
	            int l = i + 1;
	            int i1 = abyte0[i];
	            if(i1 < 0)
	                i1 += 256;
	            class389.MF_CLASS389_a1137 = i1 + (class389.MF_CLASS389_a1137 << 8);
	            if(class389.MF_CLASS389_h1139 == 0)
	            {
	                int j1 = class389.MF_CLASS389_d1140;
	                class389.MF_CLASS389_d1140 = j1 + 1;
	                abyte1[j1] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 >> 18];
	                int k1 = class389.MF_CLASS389_d1140;
	                class389.MF_CLASS389_d1140 = k1 + 1;
	                abyte1[k1] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 >> 12];
	                int l1 = class389.MF_CLASS389_d1140;
	                class389.MF_CLASS389_d1140 = l1 + 1;
	                abyte1[l1] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137 >> 6];
	                int i2 = class389.MF_CLASS389_d1140;
	                class389.MF_CLASS389_d1140 = i2 + 1;
	                abyte1[i2] = MF_CLASS389_g1135[0x3f & class389.MF_CLASS389_a1137];
	                class389.MF_CLASS389_g1135 = 4 + class389.MF_CLASS389_g1135;
	                if(MF_CLASS389_c1134 > 0 && MF_CLASS389_c1134 <= class389.MF_CLASS389_g1135)
	                {
	                    System.arraycopy(MF_CLASS388_i1130, 0, abyte1, class389.MF_CLASS389_d1140, MF_CLASS388_i1130.length);
	                    class389.MF_CLASS389_d1140 = class389.MF_CLASS389_d1140 + MF_CLASS388_i1130.length;
	                    class389.MF_CLASS389_g1135 = 0;
	                }
	            }
	            k++;
	            i = l;
	        }
        }
    }

    protected boolean MF_CLASS387_a1120(byte byte0)
    {
        return byte0 >= 0 && byte0 < MF_CLASS389_h1139.length && MF_CLASS389_h1139[byte0] != -1;
    }

    static final byte MF_CLASS389_a1137[] = {
        13, 10
    };
    private static final byte MF_CLASS389_d1140[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte MF_CLASS388_e1126[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private static final byte MF_CLASS389_f1136[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51
    };
    private final byte MF_CLASS389_g1135[];
    private final byte MF_CLASS389_h1139[];
    private final byte MF_CLASS388_i1130[];
    private final int MF_CLASS388_j1131;
    private final int MF_CLASS388_k1129;

}
