// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.xinghai.indoor.util:
//            ArrayUtil, CacheBase, OutofSpaceException, StatusBase

public final class WriteStream
{

    private WriteStream(OutputStream outputstream, byte abyte0[])
    {
        bindLength2 = outputstream;
        getInstance = abyte0;
        bindLength = 0;
        dataLength = abyte0.length;
    }

    private WriteStream(byte abyte0[], int i, int j)
    {
        bindLength2 = null;
        getInstance = abyte0;
        bindLength = i;
        dataLength = i + j;
    }

    public static WriteStream getInstance(OutputStream outputstream)
    {
        return getInstance(outputstream, 4096);
    }

    public static WriteStream getInstance(OutputStream outputstream, int i)
    {
        return new WriteStream(outputstream, new byte[i]);
    }

    public static WriteStream getInstance(byte abyte0[], int i, int j)
    {
        return new WriteStream(abyte0, i, j);
    }

    public static int dataLength(double d)
    {
        return 8;
    }

    public static int dataLength(float f)
    {
        return 4;
    }

    public static int dataLength(int i, double d)
    {
        return h_bindStatus(i) + dataLength(d);
    }

    public static int dataLength(int i, float f)
    {
        return h_bindStatus(i) + dataLength(f);
    }

    public static int dataLength(int i, ArrayUtil arrayutil)
    {
        return h_bindStatus(i) + dataLength(arrayutil);
    }

    public static int dataLength(int i, CacheBase cachebase)
    {
        return h_bindStatus(i) + dataLength(cachebase);
    }

    public static int dataLength(int i, String s)
    {
        return h_bindStatus(i) + dataLength(s);
    }

    public static int dataLength(int i, boolean flag)
    {
        return h_bindStatus(i) + dataLength(flag);
    }

    public static int dataLength(ArrayUtil arrayutil)
    {
        return j_bindStatus(arrayutil.createArray()) + arrayutil.createArray();
    }

    public static int dataLength(CacheBase cachebase)
    {
        int i = cachebase.getSerializedSize();
        return i + j_bindStatus(i);
    }

    public static int dataLength(String s)
    {
        int i;
        int j;
        try
        {
            byte abyte0[] = s.getBytes("UTF-8");
            i = j_bindStatus(abyte0.length);
            j = abyte0.length;
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 not supported.");
        }
        return j + i;
    }

    public static int dataLength(boolean flag)
    {
        return 1;
    }

    public static int bindLength(int i, long l)
    {
        return h_bindStatus(i) + bindLength(l);
    }

    public static int bindLength(long l)
    {
        return bindStatus(l);
    }

    public static int bindLength2(int i)
    {
        if(i >= 0)
            return j_bindStatus(i);
        else
            return 10;
    }

    public static int bindLength2(int i, int j)
    {
        return h_bindStatus(i) + bindLength2(j);
    }

    public static int bindLength2(int i, long l)
    {
        return h_bindStatus(i) + bindLength2(l);
    }

    public static int bindLength2(long l)
    {
        return bindStatus(h_bindStatus(l));
    }

    private void bindLength2() throws Exception
    {
        if(bindLength2 == null)
        {
            throw new OutofSpaceException();
        } else
        {
            bindLength2.write(getInstance, 0, bindLength);
            bindLength = 0;
            return;
        }
    }

    public static int bindLength3(int i)
    {
        return j_bindStatus(i);
    }

    public static int bindLength3(int i, int j)
    {
        return h_bindStatus(i) + bindLength3(j);
    }

    public static int bindStatus(int i)
    {
        return j_bindStatus(l_bindStatus(i));
    }

    public static int bindStatus(long l)
    {
        if((-128L & l) == 0L)
            return 1;
        if((-16384L & l) == 0L)
            return 2;
        if((0xffffffffffe00000L & l) == 0L)
            return 3;
        if((0xfffffffff0000000L & l) == 0L)
            return 4;
        if((0xfffffff800000000L & l) == 0L)
            return 5;
        if((0xfffffc0000000000L & l) == 0L)
            return 6;
        if((0xfffe000000000000L & l) == 0L)
            return 7;
        if((0xff00000000000000L & l) == 0L)
            return 8;
        return (0x8000000000000000L & l) != 0L ? 10 : 9;
    }

    public static int h_bindStatus(int i)
    {
        return j_bindStatus(StatusBase.Status1(i, 0));
    }

    public static long h_bindStatus(long l)
    {
        return l << 1 ^ l >> 63;
    }

    public static int j_bindStatus(int i)
    {
        if((i & 0xffffff80) == 0)
            return 1;
        if((i & 0xffffc000) == 0)
            return 2;
        if((0xffe00000 & i) == 0)
            return 3;
        return (0xf0000000 & i) != 0 ? 5 : 4;
    }

    public static int l_bindStatus(int i)
    {
        return i << 1 ^ i >> 31;
    }

    public void getInstance() throws Exception
    {
        if(bindLength2 != null)
            bindLength2();
    }

    public void getInstance(byte byte0) throws Exception
    {
        if(bindLength == dataLength)
            bindLength2();
        byte abyte0[] = getInstance;
        int i = bindLength;
        bindLength = i + 1;
        abyte0[i] = byte0;
    }

    public void getInstance(double d)
    {
    	try {
    		bindStatus2(Double.doubleToLongBits(d));
	    } catch(Exception ex) {
	    	ex.printStackTrace();
	    }
    }

    public void getInstance(float f)
    {
        setBindStatus2(Float.floatToIntBits(f));
    }

    public void getInstance(int i)
    {
        if(i >= 0)
        {
            setBindStatus(i);
            return;
        } else
        {
            bindLength3(i);
            return;
        }
    }

    public void getInstance(int i, double d)
    {
        bindStatus(i, 1);
        getInstance(d);
    }

    public void getInstance(int i, float f)
    {
        bindStatus(i, 5);
        getInstance(f);
    }

    public void getInstance(int i, int j)
    {
        bindStatus(i, 0);
        getInstance(j);
    }

    public void getInstance(int i, long l)
    {
        bindStatus(i, 0);
        getInstance(l);
    }

    public void getInstance(int i, ArrayUtil arrayutil) throws Exception
    {
        bindStatus(i, 2);
        getInstance(arrayutil);
    }

    public void getInstance(int i, CacheBase cachebase)
    {
        bindStatus(i, 2);
        getInstance(cachebase);
    }

    public void getInstance(int i, String s) throws Exception
    {
        bindStatus(i, 2);
        getInstance(s);
    }

    public void getInstance(int i, boolean flag)
    {
        bindStatus(i, 0);
        getInstance(flag);
    }

    public void getInstance(long l)
    {
        bindLength3(l);
    }

    public void getInstance(ArrayUtil arrayutil) throws Exception
    {
        byte abyte0[] = arrayutil.backupArray();
        setBindStatus(abyte0.length);
        getInstance(abyte0);
    }

    public void getInstance(CacheBase cachebase)
    {
        setBindStatus(cachebase.getCachedSize());
        cachebase.writeTo(this);
    }

    public void getInstance(String s) throws Exception
    {
        byte abyte0[] = s.getBytes("UTF-8");
        setBindStatus(abyte0.length);
        getInstance(abyte0);
    }

    public void getInstance(boolean flag)
    {
        int i;
        try {
	        if(flag)
	            i = 1;
	        else
	            i = 0;
	        bindStatus2(i);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        
    }

    public void getInstance(byte abyte0[]) throws Exception
    {
        dataLength(abyte0, 0, abyte0.length);
    }

    public int dataLength()
    {
        if(bindLength2 == null)
            return dataLength - bindLength;
        else
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void dataLength(int i)
    {
        setBindStatus(i);
    }

    public void dataLength(int i, int j)
    {
        bindStatus(i, 0);
        dataLength(j);
    }

    public void dataLength(int i, long l)
    {
        bindStatus(i, 0);
        dataLength(l);
    }

    public void dataLength(long l)
    {
        bindLength3(h_bindStatus(l));
    }

    public void dataLength(byte abyte0[], int i, int j) throws Exception
    {
        if(dataLength - bindLength >= j)
        {
            System.arraycopy(abyte0, i, getInstance, bindLength, j);
            bindLength = j + bindLength;
            return;
        }
        int k = dataLength - bindLength;
        System.arraycopy(abyte0, i, getInstance, bindLength, k);
        int l = i + k;
        int i1 = j - k;
        bindLength = dataLength;
        bindLength2();
        if(i1 <= dataLength)
        {
            System.arraycopy(abyte0, l, getInstance, 0, i1);
            bindLength = i1;
            return;
        } else
        {
            bindLength2.write(abyte0, l, i1);
            return;
        }
    }

    public void bindLength()
    {
        if(dataLength() != 0)
            throw new IllegalStateException("Did not write as much data as expected.");
        else
            return;
    }

    public void bindLength(int i)
    {
        setBindStatus(l_bindStatus(i));
    }

    public void bindLength(int i, int j)
    {
        bindStatus(i, 0);
        bindLength(j);
    }

    public void bindLength3(long l)
    {
    	try {
	    	do
	        {
	            if((-128L & l) == 0L)
	            {
	                bindStatus2((int)l);
	                return;
	            }
	            bindStatus2(0x80 | 0x7f & (int)l);
	            l >>>= 7;
	        } while(true);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
	    	
    }

    public void bindStatus(int i, int j) 
    {
        try {
        	setBindStatus(StatusBase.Status1(i, j));
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

    public void bindStatus2(int i) throws Exception
    {
        try {
        	getInstance((byte)i);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

    public void bindStatus2(long l) throws Exception
    {
        bindStatus2(0xff & (int)l);
        bindStatus2(0xff & (int)(l >> 8));
        bindStatus2(0xff & (int)(l >> 16));
        bindStatus2(0xff & (int)(l >> 24));
        bindStatus2(0xff & (int)(l >> 32));
        bindStatus2(0xff & (int)(l >> 40));
        bindStatus2(0xff & (int)(l >> 48));
        bindStatus2(0xff & (int)(l >> 56));
    }

    public void setBindStatus(int i)
    {
    	try {
        do
        {
            if((i & 0xffffff80) == 0)
            {
                bindStatus2(i);
                return;
            }
            bindStatus2(0x80 | i & 0x7f);
            i >>>= 7;
        } while(true);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        
    }

    public void setBindStatus2(int i)
    {
    	try {
	    	bindStatus2(i & 0xff);
	        bindStatus2(0xff & i >> 8);
	        bindStatus2(0xff & i >> 16);
	        bindStatus2(0xff & i >> 24);
	    } catch(Exception ex) {
	    	ex.printStackTrace();
	    }
    }

    private final byte getInstance[];
    private final int dataLength;
    private int bindLength;
    private final OutputStream bindLength2;
}
