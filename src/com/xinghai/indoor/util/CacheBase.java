// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;

import java.io.IOException;

// Referenced classes of package com.xinghai.indoor.util:
//            ExceptionManager, ReadStream, WriteStream

public abstract class CacheBase
{

    public CacheBase()
    {
    }

    public abstract int getCachedSize();

    public abstract int getSerializedSize();

    public abstract CacheBase mergeFrom(ReadStream readstream);

    public CacheBase mergeFrom(byte abyte0[])
    {
        return mergeFrom(abyte0, 0, abyte0.length);
    }

    public CacheBase mergeFrom(byte abyte0[], int i, int j)
    {
        try
        {
            ReadStream readstream = ReadStream.getInstance(abyte0, i, j);
            mergeFrom(readstream);
            readstream.getInstance(0);
        }
        catch(Exception exceptionmanager)
        {
        	exceptionmanager.printStackTrace();
//            throw exceptionmanager;
        }
//        catch(IOException ioexception)
//        {
//            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
//        }
        return this;
    }

    protected boolean parseUnknownField(ReadStream readstream, int i) throws IOException
    {
        return readstream.value1(i);
    }

    public void toByteArray(byte abyte0[], int i, int j)
    {
//        try
//        {
            WriteStream writestream = WriteStream.getInstance(abyte0, i, j);
            writeTo(writestream);
            writestream.bindLength();
            return;
//        }
//        catch(IOException ioexception)
//        {
//            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
//        }
    }

    public byte[] toByteArray()
    {
        byte abyte0[] = new byte[getSerializedSize()];
        toByteArray(abyte0, 0, abyte0.length);
        return abyte0;
    }

    public abstract void writeTo(WriteStream writestream);
}
