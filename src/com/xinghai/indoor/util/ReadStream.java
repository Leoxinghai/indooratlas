// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;

import java.io.InputStream;
import java.util.Vector;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.xinghai.indoor.util:
//            ExceptionManager, CacheBase, StatusBase, ArrayUtil

public final class ReadStream
{

    private ReadStream(InputStream inputstream)
    {
        getStr = 0x7fffffff;
        calc3 = 64;
        calc4 = 0x4000000;
        getInstance = new byte[4096];
        value1 = 0;
        checkResult = 0;
        is1 = inputstream;
    }

    private ReadStream(byte abyte0[], int i, int j)
    {
        getStr = 0x7fffffff;
        calc3 = 64;
        calc4 = 0x4000000;
        getInstance = abyte0;
        value1 = i + j;
        checkResult = i;
        is1 = null;
    }

    public static long getInstance(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    public static ReadStream getInstance(InputStream inputstream)
    {
        return new ReadStream(inputstream);
    }

    public static ReadStream getInstance(byte abyte0[], int i, int j)
    {
        return new ReadStream(abyte0, i, j);
    }

    private boolean getInstance(boolean flag) throws ExceptionManager,IOException
    {
        if(checkResult < value1)
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        if(calc2 + value1 == getStr)
            if(flag)
                throw ExceptionManager.InputEndingException();
            else
                return false;
        calc2 = calc2 + value1;
        checkResult = 0;
        int i;
        if(is1 == null)
            i = -1;
        else
            i = is1.read(getInstance);
        value1 = i;
        if(value1 == 0 || value1 < -1)
            throw new IllegalStateException((new StringBuilder("InputStream#read(byte[]) returned invalid result: ")).append(value1).append("\nThe InputStream implementation is buggy.").toString());
        if(value1 == -1)
        {
            value1 = 0;
            if(flag)
                throw ExceptionManager.InputEndingException();
            else
                return false;
        }
        calc();
        int j = calc2 + value1 + getStatus;
        if(j > calc4 || j < 0)
            throw ExceptionManager.OverSizeException();
        else
            return true;
    }

    public static int getStatus(int i)
    {
        return i >>> 1 ^ -(i & 1);
    }

    private void calc()
    {
        value1 = value1 + getStatus;
        int i = calc2 + value1;
        if(i > getStr)
        {
            getStatus = i - getStr;
            value1 = value1 - getStatus;
            return;
        } else
        {
            getStatus = 0;
            return;
        }
    }

    public int getInstance()  throws ExceptionManager,IOException
    {
        if(getFlag())
        {
            getMBytes = 0;
            return 0;
        }
        getMBytes = calc6();
        if(getMBytes == 0)
            throw ExceptionManager.InvalidTagException();
        else
            return getMBytes;
    }

    public void getInstance(int i)  throws ExceptionManager,IOException
    {
        if(getMBytes != i)
            throw ExceptionManager.NotMatchException();
        else
            return;
    }

    public void getInstance(CacheBase cachebase)  throws ExceptionManager,IOException
    {
        int i = calc6();
        if(getArrayUtil >= calc3)
        {
            throw ExceptionManager.OverNestingException();
        } else
        {
            int j = checkResult(i);
            getArrayUtil = 1 + getArrayUtil;
            cachebase.mergeFrom(this);
            getInstance(0);
            getArrayUtil = -1 + getArrayUtil;
            is1(j);
            return;
        }
    }

    public void value1() throws ExceptionManager,IOException
    {
        int i;
        do
            i = getInstance();
        while(i != 0 && value1(i));
    }

    public boolean value1(int i) throws ExceptionManager,IOException
    {
        switch(StatusBase.Status1(i))
        {
        default:
            throw ExceptionManager.InvalidWireException();

        case 0: // '\0'
            getMBytes();
            return true;

        case 1: // '\001'
            calc9();
            return true;

        case 2: // '\002'
            calc2(calc6());
            return true;

        case 3: // '\003'
            value1();
            getInstance(StatusBase.Status1(StatusBase.Status2(i), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            calc8();
            break;
        }
        return true;
    }

    public double getStatus() throws ExceptionManager,IOException
    {
        return Double.longBitsToDouble(calc9());
    }

    public float checkResult() throws ExceptionManager,IOException
    {
        return Float.intBitsToFloat(calc8());
    }

    public int checkResult(int i)  throws ExceptionManager,IOException
    {
        if(i < 0)
            throw ExceptionManager.NegativeException();
        int j = i + (calc2 + checkResult);
        int k = getStr;
        if(j > k)
        {
            throw ExceptionManager.InputEndingException();
        } else
        {
            getStr = j;
            calc();
            return k;
        }
    }

    public long is1()  throws ExceptionManager,IOException
    {
        return calc7();
    }

    public void is1(int i)  throws ExceptionManager,IOException
    {
        getStr = i;
        calc();
    }

    public int getMBytes()  throws ExceptionManager,IOException
    {
        return calc6();
    }

    public byte[] getMBytes(int i) throws ExceptionManager,IOException
    {
        int j;
        int k;
        Vector vector;
        int i1;
        if(i < 0)
            throw ExceptionManager.NegativeException();
        if(i + (calc2 + checkResult) > getStr)
        {
            calc2(getStr - calc2 - checkResult);
            throw ExceptionManager.InputEndingException();
        }
        if(i <= value1 - checkResult)
        {
            byte abyte4[] = new byte[i];
            System.arraycopy(getInstance, checkResult, abyte4, 0, i);
            checkResult = i + checkResult;
            return abyte4;
        }
        if(i < 4096)
        {
            byte abyte3[] = new byte[i];
            int l2 = value1 - checkResult;
            System.arraycopy(getInstance, checkResult, abyte3, 0, l2);
            checkResult = value1;
            getInstance(true);
            do
            {
                if(i - l2 <= value1)
                {
                    System.arraycopy(getInstance, 0, abyte3, l2, i - l2);
                    checkResult = i - l2;
                    return abyte3;
                }
                System.arraycopy(getInstance, 0, abyte3, l2, value1);
                l2 += value1;
                checkResult = value1;
                getInstance(true);
            } while(true);
        }
        j = checkResult;
        k = value1;
        calc2 = calc2 + value1;
        checkResult = 0;
        value1 = 0;
        int l = i - (k - j);
        vector = new Vector();
        i1 = l;

        if(i1 >0 ) {
                byte abyte0[];
                int j1;
                abyte0 = new byte[Math.min(i1, 4096)];
                j1 = 0;
                for(;j1 < abyte0.length;) {
                    int k1;
                    if(is1 == null)
                        k1 = -1;
                    else
                        k1 = is1.read(abyte0, j1, abyte0.length - j1);
                    if(k1 == -1)
                        throw ExceptionManager.InputEndingException();
                    calc2 = k1 + calc2;
                    j1 += k1;
                }
                int l1 = i1 - abyte0.length;
                vector.addElement(abyte0);
                i1 = l1;
        	
        }
        byte abyte1[];
        int j2;
        int k2;
        abyte1 = new byte[i];
        int i2 = k - j;
        System.arraycopy(getInstance, j, abyte1, 0, i2);
        j2 = 0;
        k2 = i2;
        for(;j2 < vector.size();) {
	        byte abyte2[] = (byte[])vector.elementAt(j2);
	        System.arraycopy(abyte2, 0, abyte1, k2, abyte2.length);
	        k2 += abyte2.length;
	        j2++;
        }
        return abyte1;
    }

    public void calc2(int i) throws ExceptionManager,IOException
    {
        if(i < 0)
            throw ExceptionManager.NegativeException();
        if(i + (calc2 + checkResult) > getStr)
        {
            calc2(getStr - calc2 - checkResult);
            throw ExceptionManager.InputEndingException();
        }
        if(i <= value1 - checkResult)
        {
            checkResult = i + checkResult;
        } else
        {
            int j = value1 - checkResult;
            calc2 = calc2 + value1;
            checkResult = 0;
            value1 = 0;
            int k = j;
            while(k < i) 
            {
                int l;
                if(is1 == null)
                    l = -1;
                else
                    l = (int)is1.skip(i - k);
                if(l <= 0)
                    throw ExceptionManager.InputEndingException();
                k += l;
                calc2 = l + calc2;
            }
        }
    }

    public boolean calc2()  throws ExceptionManager,IOException
    {
        return calc6() != 0;
    }

    public String getStr()  throws ExceptionManager,UnsupportedEncodingException,IOException
    {
        int i = calc6();
        if(i <= value1 - checkResult && i > 0)
        {
            String s = new String(getInstance, checkResult, i, "UTF-8");
            checkResult = i + checkResult;
            return s;
        } else
        {
            return new String(getMBytes(i), "UTF-8");
        }
    }

    public ArrayUtil getArrayUtil() throws ExceptionManager,IOException
    {
        int i = calc6();
        if(i <= value1 - checkResult && i > 0)
        {
            ArrayUtil arrayutil = ArrayUtil.createArray(getInstance, checkResult, i);
            checkResult = i + checkResult;
            return arrayutil;
        } else
        {
            return ArrayUtil.createArray(getMBytes(i));
        }
    }

    public int calc3()  throws ExceptionManager,IOException
    {
        return calc6();
    }

    public int calc4()  throws ExceptionManager,IOException
    {
        return getStatus(calc6());
    }

    public long calc5()  throws ExceptionManager,IOException
    {
        return getInstance(calc7());
    }

    public int calc6()  throws ExceptionManager,IOException
    {
        int i = calc11();
        if(i < 0) {
                int j = i & 0x7f;
                byte byte0 = calc11();
                if(byte0 >= 0)
                    return j | byte0 << 7;
                int k = j | (byte0 & 0x7f) << 7;
                byte byte1 = calc11();
                if(byte1 >= 0)
                    return k | byte1 << 14;
                int l = k | (byte1 & 0x7f) << 14;
                byte byte2 = calc11();
                if(byte2 >= 0)
                    return l | byte2 << 21;
                int i1 = l | (byte2 & 0x7f) << 21;
                byte byte3 = calc11();
                i = i1 | byte3 << 28;
                if(byte3 >= 0) {
                	return i;
//                    continue;
                }
                int j1 = 0;
                do
                {
                    if(j1 >= 5)
                        throw ExceptionManager.MalformedvarintException();
                    if(calc11() >= 0)
                        continue;
                    j1++;
                } while(true);
        }
        return i;
    }

    public long calc7()  throws ExceptionManager,IOException
    {
        int i = 0;
        long l = 0L;
        do
        {
            if(i >= 64)
                throw ExceptionManager.MalformedvarintException();
            byte byte0 = calc11();
            l |= (long)(byte0 & 0x7f) << i;
            if((byte0 & 0x80) == 0)
                return l;
            i += 7;
        } while(true);
    }

    public int calc8() throws ExceptionManager,IOException
    {
        byte byte0 = calc11();
        byte byte1 = calc11();
        byte byte2 = calc11();
        byte byte3 = calc11();
        return byte0 & 0xff | (byte1 & 0xff) << 8 | (byte2 & 0xff) << 16 | (byte3 & 0xff) << 24;
    }

    public long calc9() throws ExceptionManager,IOException
    {
        int i = calc11();
        int j = calc11();
        int k = calc11();
        int l = calc11();
        int i1 = calc11();
        int j1 = calc11();
        int k1 = calc11();
        int l1 = calc11();
        return 255L & (long)i | (255L & (long)j) << 8 | (255L & (long)k) << 16 | (255L & (long)l) << 24 | (255L & (long)i1) << 32 | (255L & (long)j1) << 40 | (255L & (long)k1) << 48 | (255L & (long)l1) << 56;
    }

    public boolean getFlag() throws ExceptionManager,IOException
    {
        int i = checkResult;
        int j = value1;
        boolean flag = false;
        if(i == j)
        {
            boolean flag1 = getInstance(false);
            flag = false;
            if(!flag1)
                flag = true;
        }
        return flag;
    }

    public byte calc11() throws ExceptionManager,IOException
    {
        if(checkResult == value1)
            getInstance(true);
        byte abyte0[] = getInstance;
        int i = checkResult;
        checkResult = i + 1;
        return abyte0[i];
    }

    private final byte getInstance[];
    private int value1;
    private int getStatus;
    private int checkResult;
    private final InputStream is1;
    private int getMBytes;
    private int calc2;
    private int getStr;
    private int getArrayUtil;
    private int calc3;
    private int calc4;
}
