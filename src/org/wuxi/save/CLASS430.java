// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.save;

import java.io.*;

import java.util.zip.GZIPOutputStream;

// Referenced classes of package org.wuxi.save:
//            CLASS431

public class CLASS430
{

    private CLASS430()
    {
    }

    static int MF_CLASS430_a1276(byte abyte0[], int i, byte abyte1[], int j, int k)
    {
        return MF_CLASS430_b1277(abyte0, i, abyte1, j, k);
    }

    public static String MF_CLASS430_a1276(byte abyte0[]) throws AssertionError
    {
    	String s = "";
    	try {
    	String s1 = MF_CLASS430_a1276(abyte0, 0, abyte0.length, 0);
        s = s1;

    	} catch(Exception ioexception) {
	        if(!MF_CLASS430_a1276 && s == null)
	            throw new AssertionError();
	        else
	            return s;
	/*
	        boolean flag = MF_CLASS430_a1276;
	        s = null;
	        if(!flag)
	            throw new AssertionError(ioexception.getMessage());
*/	            
    	}
    	return s;
    }

    public static String MF_CLASS430_a1276(byte abyte0[], int i, int j, int k)
    {
        byte abyte1[] = MF_CLASS430_b1277(abyte0, i, j, k);
        String s;
        try
        {
            s = new String(abyte1, "US-ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            return new String(abyte1);
        }
        return s;
    }

    static byte[] MF_CLASS430_a1276(int i)
    {
        return MF_CLASS430_c1278(i);
    }

    private static byte[] MF_CLASS430_a1276(byte abyte0[], int i, int j, byte abyte1[], int k, int l)
    {
        byte abyte2[] = MF_CLASS430_b1277(l);
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if(j > 0)
            i1 = (abyte0[i] << 24) >>> 8;
        else
            i1 = 0;
        if(j > 1)
            j1 = (abyte0[i + 1] << 24) >>> 16;
        else
            j1 = 0;
        k1 = j1 | i1;
        l1 = 0;
        if(j > 2)
            l1 = (abyte0[i + 2] << 24) >>> 24;
        i2 = l1 | k1;
        switch(j)
        {
        default:
            return abyte1;

        case 3: // '\003'
            abyte1[k] = abyte2[i2 >>> 18];
            abyte1[k + 1] = abyte2[0x3f & i2 >>> 12];
            abyte1[k + 2] = abyte2[0x3f & i2 >>> 6];
            abyte1[k + 3] = abyte2[i2 & 0x3f];
            return abyte1;

        case 2: // '\002'
            abyte1[k] = abyte2[i2 >>> 18];
            abyte1[k + 1] = abyte2[0x3f & i2 >>> 12];
            abyte1[k + 2] = abyte2[0x3f & i2 >>> 6];
            abyte1[k + 3] = 61;
            return abyte1;

        case 1: // '\001'
            abyte1[k] = abyte2[i2 >>> 18];
            abyte1[k + 1] = abyte2[0x3f & i2 >>> 12];
            abyte1[k + 2] = 61;
            abyte1[k + 3] = 61;
            return abyte1;
        }
    }

    static byte[] MF_CLASS430_a1276(byte abyte0[], byte abyte1[], int i, int j)
    {
        return MF_CLASS430_b1277(abyte0, abyte1, i, j);
    }

    private static int MF_CLASS430_b1277(byte abyte0[], int i, byte abyte1[], int j, int k)
    {
        if(abyte0 == null)
            throw new NullPointerException("Source array was null.");
        if(abyte1 == null)
            throw new NullPointerException("Destination array was null.");
        if(i < 0 || i + 3 >= abyte0.length)
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(abyte0.length);
            aobj[1] = Integer.valueOf(i);
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", aobj));
        }
        if(j < 0 || j + 2 >= abyte1.length)
        {
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(abyte1.length);
            aobj1[1] = Integer.valueOf(j);
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", aobj1));
        }
        byte abyte2[] = MF_CLASS430_c1278(k);
        if(abyte0[i + 2] == 61)
        {
            abyte1[j] = (byte)(((0xff & abyte2[abyte0[i]]) << 18 | (0xff & abyte2[abyte0[i + 1]]) << 12) >>> 16);
            return 1;
        }
        if(abyte0[i + 3] == 61)
        {
            int i1 = (0xff & abyte2[abyte0[i]]) << 18 | (0xff & abyte2[abyte0[i + 1]]) << 12 | (0xff & abyte2[abyte0[i + 2]]) << 6;
            abyte1[j] = (byte)(i1 >>> 16);
            abyte1[j + 1] = (byte)(i1 >>> 8);
            return 2;
        } else
        {
            int l = (0xff & abyte2[abyte0[i]]) << 18 | (0xff & abyte2[abyte0[i + 1]]) << 12 | (0xff & abyte2[abyte0[i + 2]]) << 6 | 0xff & abyte2[abyte0[i + 3]];
            abyte1[j] = (byte)(l >> 16);
            abyte1[j + 1] = (byte)(l >> 8);
            abyte1[j + 2] = (byte)l;
            return 3;
        }
    }

    private static final byte[] MF_CLASS430_b1277(int i)
    {
        if((i & 0x10) == 16)
            return MF_CLASS430_d1279;
        if((i & 0x20) == 32)
            return MF_CLASS430_f1281;
        else
            return MF_CLASS430_b1277;
    }

    public static byte[] MF_CLASS430_b1277(byte abyte0[], int i, int j, int k)
    {
        GZIPOutputStream gzipoutputstream;
        gzipoutputstream = null;
        if(abyte0 == null)
            throw new NullPointerException("Cannot serialize a null array.");
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot have negative offset: ").append(i).toString());
        if(j < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot have length offset: ").append(j).toString());
        if(i + j > abyte0.length)
        {
            Object aobj[] = new Object[3];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = Integer.valueOf(j);
            aobj[2] = Integer.valueOf(abyte0.length);
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", aobj));
        }
        
        boolean flag;
        int l;
        byte byte0;
        int i1;
        byte abyte1[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte abyte2[];
        int j2;
        int k2;

        
        if((k & 2) != 0) {
	        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
	        CLASS431 class431;
	        GZIPOutputStream gzipoutputstream1;
	        ByteArrayOutputStream bytearrayoutputstream1;
	        Exception exception;
	        try
	        {
	            class431 = new CLASS431(bytearrayoutputstream, k | 1);
	            gzipoutputstream1 = new GZIPOutputStream(class431);
	            gzipoutputstream1.write(abyte0, i, j);
	            gzipoutputstream1.close();
	            class431.close();
	            bytearrayoutputstream.close();
	            abyte1 = bytearrayoutputstream.toByteArray();
	            return abyte1;
	        }
	        // Misplaced declaration of an exception variable
	        catch(IOException ioexception)
	        {
	            bytearrayoutputstream1 = bytearrayoutputstream;
	            class431 = null;
	            gzipoutputstream = null;
	            return null;
	        }
        } else {
	        if((k & 8) != 0)
	            flag = true;
	        else
	            flag = false;
	        l = 4 * (j / 3);
	        if(j % 3 > 0)
	            byte0 = 4;
	        else
	            byte0 = 0;
	        i1 = byte0 + l;
	        if(flag)
	            i1 += i1 / 76;
	        abyte1 = new byte[i1];
	        j1 = j - 2;
	        k1 = 0;
	        l1 = 0;
	        for(i2 = 0; i2 < j1; i2 = k2)
	        {
	            MF_CLASS430_a1276(abyte0, i2 + i, 3, abyte1, l1, k);
	            j2 = k1 + 4;
	            if(flag && j2 >= 76)
	            {
	                abyte1[l1 + 4] = 10;
	                l1++;
	                j2 = 0;
	            }
	            k2 = i2 + 3;
	            l1 += 4;
	            k1 = j2;
	        }
	
	        if(i2 < j)
	        {
	            MF_CLASS430_a1276(abyte0, i2 + i, j - i2, abyte1, l1, k);
	            l1 += 4;
	        }
	        if(l1 <= -1 + abyte1.length)
	        {
	            abyte2 = new byte[l1];
	            System.arraycopy(abyte1, 0, abyte2, 0, l1);
	            return abyte2;
	        } else
	        {
	            return null;
	        }
        }
    }

    private static byte[] MF_CLASS430_b1277(byte abyte0[], byte abyte1[], int i, int j)
    {
        MF_CLASS430_a1276(abyte1, 0, i, abyte0, 0, j);
        return abyte0;
    }

    private static final byte[] MF_CLASS430_c1278(int i)
    {
        if((i & 0x10) == 16)
            return MF_CLASS430_e1280;
        if((i & 0x20) == 32)
            return MF_CLASS430_g1282;
        else
            return MF_CLASS430_c1278;
    }

    static final boolean MF_CLASS430_a1276;
    private static final byte MF_CLASS430_b1277[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte MF_CLASS430_c1278[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9
    };
    private static final byte MF_CLASS430_d1279[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    private static final byte MF_CLASS430_e1280[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9
    };
    private static final byte MF_CLASS430_f1281[] = {
        45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
        57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
        74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
        84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
        99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
        109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
        119, 120, 121, 122
    };
    private static final byte MF_CLASS430_g1282[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
        3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
        -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
        36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
        51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
        61, 62, 63, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9
    };

    static 
    {
        boolean flag;
        if(!CLASS430.class.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        MF_CLASS430_a1276 = flag;
    }
}
