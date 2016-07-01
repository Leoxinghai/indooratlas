// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.communication;

import com.xinghai.indoor.util.CacheBase;
import com.xinghai.indoor.util.ExceptionManager;
import com.xinghai.indoor.util.ReadStream;
import com.xinghai.indoor.util.WriteStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class api_psm_common
{

    private api_psm_common()
    {
    }
    

public static class PingHeader
  extends CacheBase
{
  private int a = -1;
  
  public static PingHeader parseFrom(ReadStream paramReadStream)
  {
    return new PingHeader().mergeFrom(paramReadStream);
  }
  
  public static PingHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (PingHeader)new PingHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final PingHeader clear()
  {
    this.a = -1;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.a < 0) {
      getSerializedSize();
    }
    return this.a;
  }
  
  public int getSerializedSize()
  {
    this.a = 0;
    return 0;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public PingHeader mergeFrom(ReadStream paramReadStream)
  {
    int i;
    
    try {
    	
    do
    {
	      i = paramReadStream.getInstance();
	      switch (i)
	      {
	      }
	    } while (parseUnknownField(paramReadStream, i));
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(IOException ex) {
		  ex.printStackTrace();
	  }
    
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream) {}
}




public static class RetransmitHeader
  extends CacheBase
{
  public static final int CONTROLSEQUENCENUMBERS_FIELD_NUMBER = 1;
  private List a = Collections.emptyList();
  private int b = -1;
  
  public static RetransmitHeader parseFrom(ReadStream paramReadStream)
  {
    return new RetransmitHeader().mergeFrom(paramReadStream);
  }
  
  public static RetransmitHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (RetransmitHeader)new RetransmitHeader().mergeFrom(paramArrayOfByte);
  }
  
  public RetransmitHeader addControlSequenceNumbers(int paramInt)
  {
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public final RetransmitHeader clear()
  {
    clearControlSequenceNumbers();
    this.b = -1;
    return this;
  }
  
  public RetransmitHeader clearControlSequenceNumbers()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.b < 0) {
      getSerializedSize();
    }
    return this.b;
  }
  
  public int getControlSequenceNumbers(int paramInt)
  {
    return ((Integer)this.a.get(paramInt)).intValue();
  }
  
  public int getControlSequenceNumbersCount()
  {
    return this.a.size();
  }
  
  public List getControlSequenceNumbersList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getControlSequenceNumbersList().iterator();
    int i = 0;
    for (;localIterator.hasNext();)
    {
      i += WriteStream.bindLength3(((Integer)localIterator.next()).intValue());
    }
    
	int j = 0 + i + 1 * getControlSequenceNumbersList().size();
	this.b = j;
	return j;
    
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  
  public RetransmitHeader mergeFrom(ReadStream readstream)
  {
	  try {
	  do
      {
          int i = readstream.getInstance();
          switch(i)
          {
          default:
              if(parseUnknownField(readstream, i))
                  continue;
              // fall through

          case 0: // '\0'
              return this;

          case 8: // '\b'
              addControlSequenceNumbers(readstream.calc3());
              break;
          }
      } while(true);
      
  } catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(IOException ex) {
	  ex.printStackTrace();
  }
      return null;
  }

  
  public RetransmitHeader setControlSequenceNumbers(int paramInt1, int paramInt2)
  {
    this.a.set(paramInt1, Integer.valueOf(paramInt2));
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    Iterator localIterator = getControlSequenceNumbersList().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      paramWriteStream.dataLength(1, ((Integer)localIterator.next()).intValue());
    }
  }
}



public static class UUID
  extends CacheBase
{
  public static final int LEASTSIGNBITS_FIELD_NUMBER = 1;
  public static final int MOSTSIGNBITS_FIELD_NUMBER = 2;
  private boolean a;
  private long b = 0L;
  private boolean c;
  private long d = 0L;
  private int e = -1;
  
  public static UUID parseFrom(ReadStream paramReadStream)
  {
    return new UUID().mergeFrom(paramReadStream);
  }
  
  public static UUID parseFrom(byte[] paramArrayOfByte)
  {
    return (UUID)new UUID().mergeFrom(paramArrayOfByte);
  }
  
  public final UUID clear()
  {
    clearLeastSignBits();
    clearMostSignBits();
    this.e = -1;
    return this;
  }
  
  public UUID clearLeastSignBits()
  {
    this.a = false;
    this.b = 0L;
    return this;
  }
  
  public UUID clearMostSignBits()
  {
    this.c = false;
    this.d = 0L;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public long getLeastSignBits()
  {
    return this.b;
  }
  
  public long getMostSignBits()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasLeastSignBits();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.bindLength2(1, getLeastSignBits());
    }
    if (hasMostSignBits()) {
      i += WriteStream.bindLength2(2, getMostSignBits());
    }
    this.e = i;
    return i;
  }
  
  public boolean hasLeastSignBits()
  {
    return this.a;
  }
  
  public boolean hasMostSignBits()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    if (!this.a) {}
    while (!this.c) {
      return false;
    }
    return true;
  }
  
  public UUID mergeFrom(ReadStream readstream)
  {
try {
	  do
      {
          int i = readstream.getInstance();
          switch(i)
          {
          default:
              if(parseUnknownField(readstream, i))
                  continue;
              // fall through

          case 0: // '\0'
              return this;

          case 8: // '\b'
              setLeastSignBits(readstream.calc5());
              break;

          case 16: // '\020'
              setMostSignBits(readstream.calc5());
              break;
          }
      } while(true);
  } catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(IOException ex) {
	  ex.printStackTrace();
  }
     return null; 
  }
  
  public UUID setLeastSignBits(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public UUID setMostSignBits(long paramLong)
  {
    this.c = true;
    this.d = paramLong;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasLeastSignBits()) {
      paramWriteStream.dataLength(1, getLeastSignBits());
    }
    if (hasMostSignBits()) {
      paramWriteStream.dataLength(2, getMostSignBits());
    }
  }
}



}
