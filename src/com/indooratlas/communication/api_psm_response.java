// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.communication;


import java.io.IOException;

import com.xinghai.indoor.util.ArrayUtil;
import com.xinghai.indoor.util.CacheBase;
import com.xinghai.indoor.util.ExceptionManager;
import com.xinghai.indoor.util.ReadStream;
import com.xinghai.indoor.util.WriteStream;


public final class api_psm_response
{

    private api_psm_response()
    {
    }
    

public static class ConnectedHeader
  extends CacheBase
{
  public static final int SESSIONID_FIELD_NUMBER = 1;
  private boolean a;
  private api_psm_common.UUID b = null;
  private int c = -1;
  
  public static ConnectedHeader parseFrom(ReadStream paramReadStream)
  {
    return new ConnectedHeader().mergeFrom(paramReadStream);
  }
  
  public static ConnectedHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (ConnectedHeader)new ConnectedHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final ConnectedHeader clear()
  {
    clearSessionId();
    this.c = -1;
    return this;
  }
  
  public ConnectedHeader clearSessionId()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.c < 0) {
      getSerializedSize();
    }
    return this.c;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasSessionId();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getSessionId());
    }
    this.c = i;
    return i;
  }
  
  public api_psm_common.UUID getSessionId()
  {
    return this.b;
  }
  
  public boolean hasSessionId()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return (!hasSessionId()) || (getSessionId().isInitialized());
  }
  
  public ConnectedHeader mergeFrom(ReadStream paramReadStream)
  {
    
	  try {
	  for (;;)
    {
      int i = paramReadStream.getInstance();
      switch (i)
      {
      default: 
        if (parseUnknownField(paramReadStream, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: // '\n'
          api_psm_common.UUID uuid = new api_psm_common.UUID();
          paramReadStream.getInstance(uuid);
          setSessionId(uuid);
          break;        
      }
    }
	    } catch(ExceptionManager mng) {
	    	  mng.printStackTrace();
	      } catch(IOException ex) {
	    	  ex.printStackTrace();
	      }
	      return this;	  
	  
  }
  
  public ConnectedHeader setSessionId(api_psm_common.UUID paramUUID)
  {
    if (paramUUID == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramUUID;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasSessionId()) {
      paramWriteStream.getInstance(1, getSessionId());
    }
  }
}




public static class ErrorHeader
  extends CacheBase
{
  public static final int ERRORCODE_FIELD_NUMBER = 1;
  public static final int ERRORMESSAGE_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static ErrorHeader parseFrom(ReadStream paramReadStream)
  {
    return new ErrorHeader().mergeFrom(paramReadStream);
  }
  
  public static ErrorHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (ErrorHeader)new ErrorHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final ErrorHeader clear()
  {
    clearErrorCode();
    clearErrorMessage();
    this.e = -1;
    return this;
  }
  
  public ErrorHeader clearErrorCode()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public ErrorHeader clearErrorMessage()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public int getErrorCode()
  {
    return this.b;
  }
  
  public String getErrorMessage()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasErrorCode();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.bindLength3(1, getErrorCode());
    }
    if (hasErrorMessage()) {
      i += WriteStream.dataLength(2, getErrorMessage());
    }
    this.e = i;
    return i;
  }
  
  public boolean hasErrorCode()
  {
    return this.a;
  }
  
  public boolean hasErrorMessage()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public ErrorHeader mergeFrom(ReadStream paramReadStream)
  {
    try {
	  for (;;)
    {
      int i = paramReadStream.getInstance();
      switch (i)
      {
      default: 
        if (parseUnknownField(paramReadStream, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        setErrorCode(paramReadStream.calc3());
        break;

      case 18: // '\022'
          setErrorMessage(paramReadStream.getStr());
          break;        
      }
    }
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(IOException ex) {
    	  ex.printStackTrace();
      }
      return this;	  
	  
  }
  
  public ErrorHeader setErrorCode(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public ErrorHeader setErrorMessage(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    try {
	  if (hasErrorCode()) {
      paramWriteStream.dataLength(1, getErrorCode());
    }
    if (hasErrorMessage()) {
      paramWriteStream.getInstance(2, getErrorMessage());
    }
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(Exception ex) {
    	  ex.printStackTrace();
      }
  }
}




public static class PSMResponse
  extends CacheBase
{
  public static final int CONNECTED = 1;
  public static final int CONNECTED_FIELD_NUMBER = 3;
  public static final int ERROR = 3;
  public static final int ERROR_FIELD_NUMBER = 5;
  public static final int PAYLOAD_FIELD_NUMBER = 15;
  public static final int PING = 5;
  public static final int PING_FIELD_NUMBER = 7;
  public static final int RETRANSMIT = 4;
  public static final int RETRANSMIT_FIELD_NUMBER = 6;
  public static final int SEQUENCENUMBER_FIELD_NUMBER = 14;
  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  public static final int UPDATED = 2;
  public static final int UPDATED_FIELD_NUMBER = 4;
  private boolean createArray;
  private int b = 1;
  private boolean c;
  private long d = 0L;
  private boolean e;
  private api_psm_response.ConnectedHeader f = null;
  private boolean g;
  private api_psm_response.UpdatedHeader h = null;
  private boolean i;
  private api_psm_response.ErrorHeader j = null;
  private boolean k;
  private api_psm_common.RetransmitHeader l = null;
  private boolean m;
  private api_psm_common.PingHeader n = null;
  private boolean o;
  private int p = 0;
  private boolean q;
  private ArrayUtil r = ArrayUtil.createArray;
  private int s = -1;
  
  public static PSMResponse parseFrom(ReadStream paramReadStream)
  {
    return new PSMResponse().mergeFrom(paramReadStream);
  }
  
  public static PSMResponse parseFrom(byte[] paramArrayOfByte)
  {
    return (PSMResponse)new PSMResponse().mergeFrom(paramArrayOfByte);
  }
  
  public final PSMResponse clear()
  {
    clearType();
    clearTimestamp();
    clearConnected();
    clearUpdated();
    clearError();
    clearRetransmit();
    clearPing();
    clearSequenceNumber();
    clearPayload();
    this.s = -1;
    return this;
  }
  
  public PSMResponse clearConnected()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public PSMResponse clearError()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public PSMResponse clearPayload()
  {
    this.q = false;
    this.r = ArrayUtil.createArray;
    return this;
  }
  
  public PSMResponse clearPing()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public PSMResponse clearRetransmit()
  {
    this.k = false;
    this.l = null;
    return this;
  }
  
  public PSMResponse clearSequenceNumber()
  {
    this.o = false;
    this.p = 0;
    return this;
  }
  
  public PSMResponse clearTimestamp()
  {
    this.c = false;
    this.d = 0L;
    return this;
  }
  
  public PSMResponse clearType()
  {
    this.createArray = false;
    this.b = 1;
    return this;
  }
  
  public PSMResponse clearUpdated()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.s < 0) {
      getSerializedSize();
    }
    return this.s;
  }
  
  public api_psm_response.ConnectedHeader getConnected()
  {
    return this.f;
  }
  
  public api_psm_response.ErrorHeader getError()
  {
    return this.j;
  }
  
  public ArrayUtil getPayload()
  {
    return this.r;
  }
  
  public api_psm_common.PingHeader getPing()
  {
    return this.n;
  }
  
  public api_psm_common.RetransmitHeader getRetransmit()
  {
    return this.l;
  }
  
  public int getSequenceNumber()
  {
    return this.p;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasType();
    int i1 = 0;
    if (bool) {
      i1 = 0 + WriteStream.bindLength2(1, getType());
    }
    if (hasTimestamp()) {
      i1 += WriteStream.bindLength(2, getTimestamp());
    }
    if (hasConnected()) {
      i1 += WriteStream.dataLength(3, getConnected());
    }
    if (hasUpdated()) {
      i1 += WriteStream.dataLength(4, getUpdated());
    }
    if (hasError()) {
      i1 += WriteStream.dataLength(5, getError());
    }
    if (hasRetransmit()) {
      i1 += WriteStream.dataLength(6, getRetransmit());
    }
    if (hasPing()) {
      i1 += WriteStream.dataLength(7, getPing());
    }
    if (hasSequenceNumber()) {
      i1 += WriteStream.bindLength3(14, getSequenceNumber());
    }
    if (hasPayload()) {
      i1 += WriteStream.dataLength(15, getPayload());
    }
    this.s = i1;
    return i1;
  }
  
  public long getTimestamp()
  {
    return this.d;
  }
  
  public int getType()
  {
    return this.b;
  }
  
  public api_psm_response.UpdatedHeader getUpdated()
  {
    return this.h;
  }
  
  public boolean hasConnected()
  {
    return this.e;
  }
  
  public boolean hasError()
  {
    return this.i;
  }
  
  public boolean hasPayload()
  {
    return this.q;
  }
  
  public boolean hasPing()
  {
    return this.m;
  }
  
  public boolean hasRetransmit()
  {
    return this.k;
  }
  
  public boolean hasSequenceNumber()
  {
    return this.o;
  }
  
  public boolean hasTimestamp()
  {
    return this.c;
  }
  
  public boolean hasType()
  {
    return this.createArray;
  }
  
  public boolean hasUpdated()
  {
    return this.g;
  }
  
  public final boolean isInitialized()
  {
    if (!this.createArray) {}
    while ((hasConnected()) && (!getConnected().isInitialized())) {
      return false;
    }
    return true;
  }
  
  public PSMResponse mergeFrom(ReadStream paramReadStream)
  {
    try {
	  for (;;)
    {
      int i1 = paramReadStream.getInstance();
      switch (i1)
      {
      default: 
        if (parseUnknownField(paramReadStream, i1)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        setType(paramReadStream.getMBytes());
        break;
      case 16: 
        setTimestamp(paramReadStream.is1());
        break;
      case 26: 
        api_psm_response.ConnectedHeader localConnectedHeader = new api_psm_response.ConnectedHeader();
        paramReadStream.getInstance(localConnectedHeader);
        setConnected(localConnectedHeader);
        break;
      case 34: 
        api_psm_response.UpdatedHeader localUpdatedHeader = new api_psm_response.UpdatedHeader();
        paramReadStream.getInstance(localUpdatedHeader);
        setUpdated(localUpdatedHeader);
        break;
      case 42: 
        api_psm_response.ErrorHeader localErrorHeader = new api_psm_response.ErrorHeader();
        paramReadStream.getInstance(localErrorHeader);
        setError(localErrorHeader);
        break;
      case 50: 
        api_psm_common.RetransmitHeader localRetransmitHeader = new api_psm_common.RetransmitHeader();
        paramReadStream.getInstance(localRetransmitHeader);
        setRetransmit(localRetransmitHeader);
        break;
      case 58: 
        api_psm_common.PingHeader localPingHeader = new api_psm_common.PingHeader();
        paramReadStream.getInstance(localPingHeader);
        setPing(localPingHeader);
        break;
      case 112: 
        setSequenceNumber(paramReadStream.calc3());
        break;
      case 122: // 'z'
          setPayload(paramReadStream.getArrayUtil());
          break;        
      }

    }
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(IOException ex) {
    	  ex.printStackTrace();
      }
      return this;	  
	  
  }
  
  public PSMResponse setConnected(api_psm_response.ConnectedHeader paramConnectedHeader)
  {
    if (paramConnectedHeader == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramConnectedHeader;
    return this;
  }
  
  public PSMResponse setError(api_psm_response.ErrorHeader paramErrorHeader)
  {
    if (paramErrorHeader == null) {
      throw new NullPointerException();
    }
    this.i = true;
    this.j = paramErrorHeader;
    return this;
  }
  
  public PSMResponse setPayload(ArrayUtil paramArrayUtil)
  {
    this.q = true;
    this.r = paramArrayUtil;
    return this;
  }
  
  public PSMResponse setPing(api_psm_common.PingHeader paramPingHeader)
  {
    if (paramPingHeader == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramPingHeader;
    return this;
  }
  
  public PSMResponse setRetransmit(api_psm_common.RetransmitHeader paramRetransmitHeader)
  {
    if (paramRetransmitHeader == null) {
      throw new NullPointerException();
    }
    this.k = true;
    this.l = paramRetransmitHeader;
    return this;
  }
  
  public PSMResponse setSequenceNumber(int paramInt)
  {
    this.o = true;
    this.p = paramInt;
    return this;
  }
  
  public PSMResponse setTimestamp(long paramLong)
  {
    this.c = true;
    this.d = paramLong;
    return this;
  }
  
  public PSMResponse setType(int paramInt)
  {
    this.createArray = true;
    this.b = paramInt;
    return this;
  }
  
  public PSMResponse setUpdated(api_psm_response.UpdatedHeader paramUpdatedHeader)
  {
    if (paramUpdatedHeader == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramUpdatedHeader;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
	    try {
    if (hasType()) {
      paramWriteStream.getInstance(1, getType());
    }
    if (hasTimestamp()) {
      paramWriteStream.getInstance(2, getTimestamp());
    }
    if (hasConnected()) {
      paramWriteStream.getInstance(3, getConnected());
    }
    if (hasUpdated()) {
      paramWriteStream.getInstance(4, getUpdated());
    }
    if (hasError()) {
      paramWriteStream.getInstance(5, getError());
    }
    if (hasRetransmit()) {
      paramWriteStream.getInstance(6, getRetransmit());
    }
    if (hasPing()) {
      paramWriteStream.getInstance(7, getPing());
    }
    if (hasSequenceNumber()) {
      paramWriteStream.dataLength(14, getSequenceNumber());
    }
    if (hasPayload()) {
      paramWriteStream.getInstance(15, getPayload());
    }
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(Exception ex) {
    	  ex.printStackTrace();
      }
    
  }
}




public static class UpdatedHeader
  extends CacheBase
{
  private int a = -1;
  
  public static UpdatedHeader parseFrom(ReadStream paramReadStream)
  {
    return new UpdatedHeader().mergeFrom(paramReadStream);
  }
  
  public static UpdatedHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (UpdatedHeader)new UpdatedHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final UpdatedHeader clear()
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
  
  public UpdatedHeader mergeFrom(ReadStream paramReadStream)
  {
    int i;
    try {
    do
    {
      i = paramReadStream.getInstance();
      switch (i)
      {
      default:
    	  if(parseUnknownField(paramReadStream, i))
    		  continue;
    	  return this;
      case 0: 
    	  return this;
      }
    } while (parseUnknownField(paramReadStream, i));

  } catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(Exception ex) {
	  ex.printStackTrace();
  }

    return this;
    
  }
  
  public void writeTo(WriteStream paramWriteStream) {}
}


}
