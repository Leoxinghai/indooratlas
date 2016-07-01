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

public class api_psm_request
{

    private api_psm_request()
    {
    }
    
    public static class CloseHeader
    extends CacheBase
  {
    private int a = -1;
    
    public static CloseHeader parseFrom(ReadStream paramReadStream)
    {
      return new CloseHeader().mergeFrom(paramReadStream);
    }
    
    public static CloseHeader parseFrom(byte[] paramArrayOfByte)
    {
      return (CloseHeader)new CloseHeader().mergeFrom(paramArrayOfByte);
    }
    
    public final CloseHeader clear()
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
    
    public CloseHeader mergeFrom(ReadStream paramReadStream)
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
      } while (true);
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(IOException ex) {
    	  ex.printStackTrace();
      }
      return this;	  

    }
    

    public void writeTo(WriteStream paramWriteStream) {}
  }


    

public static class ConnectHeader
  extends CacheBase
{
  public static final int ALGORITHMVERSION_FIELD_NUMBER = 5;
  public static final int APIKEY_FIELD_NUMBER = 3;
  public static final int DEVICEMODELID_FIELD_NUMBER = 4;
  public static final int IDAUUID_FIELD_NUMBER = 2;
  public static final int SIGNATURE_FIELD_NUMBER = 1;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private api_psm_common.UUID f = null;
  private boolean g;
  private api_psm_common.UUID h = null;
  private boolean i;
  private int j = 0;
  private int k = -1;
  
  public static ConnectHeader parseFrom(ReadStream paramReadStream)
  {
    return new ConnectHeader().mergeFrom(paramReadStream);
  }
  
  public static ConnectHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (ConnectHeader)new ConnectHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final ConnectHeader clear()
  {
    clearSignature();
    clearIDAUuid();
    clearApikey();
    clearDeviceModelId();
    clearAlgorithmVersion();
    this.k = -1;
    return this;
  }
  
  public ConnectHeader clearAlgorithmVersion()
  {
    this.i = false;
    this.j = 0;
    return this;
  }
  
  public ConnectHeader clearApikey()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public ConnectHeader clearDeviceModelId()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public ConnectHeader clearIDAUuid()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public ConnectHeader clearSignature()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public int getAlgorithmVersion()
  {
    return this.j;
  }
  
  public api_psm_common.UUID getApikey()
  {
    return this.f;
  }
  
  public int getCachedSize()
  {
    if (this.k < 0) {
      getSerializedSize();
    }
    return this.k;
  }
  
  public api_psm_common.UUID getDeviceModelId()
  {
    return this.h;
  }
  
  public String getIDAUuid()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasSignature();
    int m = 0;
    if (bool) {
      m = 0 + WriteStream.dataLength(1, getSignature());
    }
    if (hasIDAUuid()) {
      m += WriteStream.dataLength(2, getIDAUuid());
    }
    if (hasApikey()) {
      m += WriteStream.dataLength(3, getApikey());
    }
    if (hasDeviceModelId()) {
      m += WriteStream.dataLength(4, getDeviceModelId());
    }
    if (hasAlgorithmVersion()) {
      m += WriteStream.bindLength3(5, getAlgorithmVersion());
    }
    this.k = m;
    return m;
  }
  
  public String getSignature()
  {
    return this.b;
  }
  
  public boolean hasAlgorithmVersion()
  {
    return this.i;
  }
  
  public boolean hasApikey()
  {
    return this.e;
  }
  
  public boolean hasDeviceModelId()
  {
    return this.g;
  }
  
  public boolean hasIDAUuid()
  {
    return this.c;
  }
  
  public boolean hasSignature()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    if (!this.a) {}
    while ((!this.c) || (!this.e) || (!getApikey().isInitialized()) || ((hasDeviceModelId()) && (!getDeviceModelId().isInitialized()))) {
      return false;
    }
    return true;
  }
  
  public ConnectHeader mergeFrom(ReadStream paramReadStream)
  {
	  try {
    for (;;)
    {
      int m = paramReadStream.getInstance();
      switch (m)
      {
      default: 
        if (parseUnknownField(paramReadStream, m)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        setSignature(paramReadStream.getStr());
        break;
      case 18: 
        setIDAUuid(paramReadStream.getStr());
        break;
      case 26: 
        api_psm_common.UUID localUUID2 = new api_psm_common.UUID();
        paramReadStream.getInstance(localUUID2);
        setApikey(localUUID2);
        break;
      case 34: 
        api_psm_common.UUID localUUID1 = new api_psm_common.UUID();
        paramReadStream.getInstance(localUUID1);
        setDeviceModelId(localUUID1);
        break;
      case 40: // '('
          setAlgorithmVersion(paramReadStream.calc3());
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
  
  public ConnectHeader setAlgorithmVersion(int paramInt)
  {
    this.i = true;
    this.j = paramInt;
    return this;
  }
  
  public ConnectHeader setApikey(api_psm_common.UUID paramUUID)
  {
    if (paramUUID == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramUUID;
    return this;
  }
  
  public ConnectHeader setDeviceModelId(api_psm_common.UUID paramUUID)
  {
    if (paramUUID == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramUUID;
    return this;
  }
  
  public ConnectHeader setIDAUuid(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public ConnectHeader setSignature(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    try {
	  
	if (hasSignature()) {
      paramWriteStream.getInstance(1, getSignature());
    }
    if (hasIDAUuid()) {
      paramWriteStream.getInstance(2, getIDAUuid());
    }
    if (hasApikey()) {
      paramWriteStream.getInstance(3, getApikey());
    }
    if (hasDeviceModelId()) {
      paramWriteStream.getInstance(4, getDeviceModelId());
    }
    if (hasAlgorithmVersion()) {
      paramWriteStream.dataLength(5, getAlgorithmVersion());
    }
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(Exception ex) {
    	  ex.printStackTrace();
      }
    
  }
}




public static class PSMRequest
  extends CacheBase
{
  public static final int CLOSE = 4;
  public static final int CLOSE_FIELD_NUMBER = 6;
  public static final int CONNECT = 1;
  public static final int CONNECT_FIELD_NUMBER = 3;
  public static final int LASTRECEIVED_FIELD_NUMBER = 14;
  public static final int PAYLOAD_FIELD_NUMBER = 15;
  public static final int PERFORMANCE = 5;
  public static final int PING = 7;
  public static final int PING_FIELD_NUMBER = 8;
  public static final int RECONNECT = 2;
  public static final int RECONNECT_FIELD_NUMBER = 4;
  public static final int RETRANSMIT = 6;
  public static final int RETRANSMIT_FIELD_NUMBER = 7;
  public static final int SEQUENCENUMBER_FIELD_NUMBER = 13;
  public static final int SESSIONID_FIELD_NUMBER = 12;
  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  public static final int UPDATE = 3;
  public static final int UPDATE_FIELD_NUMBER = 5;
  private boolean createArray;
  private int b = 1;
  private boolean c;
  private long d = 0L;
  private boolean e;
  private api_psm_request.ConnectHeader f = null;
  private boolean g;
  private api_psm_request.ReconnectHeader h = null;
  private boolean i;
  private api_psm_request.UpdateHeader j = null;
  private boolean k;
  private api_psm_request.CloseHeader l = null;
  private boolean m;
  private api_psm_common.RetransmitHeader n = null;
  private boolean o;
  private api_psm_common.PingHeader p = null;
  private boolean q;
  private api_psm_common.UUID r = null;
  private boolean s;
  private int t = 0;
  private boolean u;
  private int v = 0;
  private boolean w;
  private ArrayUtil x = ArrayUtil.createArray;
  private int y = -1;
  
  public static PSMRequest parseFrom(ReadStream paramReadStream)
  {
    return new PSMRequest().mergeFrom(paramReadStream);
  }
  
  public static PSMRequest parseFrom(byte[] paramArrayOfByte)
  {
    return (PSMRequest)new PSMRequest().mergeFrom(paramArrayOfByte);
  }
  
  public final PSMRequest clear()
  {
    clearType();
    clearTimestamp();
    clearConnect();
    clearReconnect();
    clearUpdate();
    clearClose();
    clearRetransmit();
    clearPing();
    clearSessionId();
    clearSequenceNumber();
    clearLastReceived();
    clearPayload();
    this.y = -1;
    return this;
  }
  
  public PSMRequest clearClose()
  {
    this.k = false;
    this.l = null;
    return this;
  }
  
  public PSMRequest clearConnect()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public PSMRequest clearLastReceived()
  {
    this.u = false;
    this.v = 0;
    return this;
  }
  
  public PSMRequest clearPayload()
  {
    this.w = false;
    this.x = ArrayUtil.createArray;
    return this;
  }
  
  public PSMRequest clearPing()
  {
    this.o = false;
    this.p = null;
    return this;
  }
  
  public PSMRequest clearReconnect()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public PSMRequest clearRetransmit()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public PSMRequest clearSequenceNumber()
  {
    this.s = false;
    this.t = 0;
    return this;
  }
  
  public PSMRequest clearSessionId()
  {
    this.q = false;
    this.r = null;
    return this;
  }
  
  public PSMRequest clearTimestamp()
  {
    this.c = false;
    this.d = 0L;
    return this;
  }
  
  public PSMRequest clearType()
  {
    this.createArray = false;
    this.b = 1;
    return this;
  }
  
  public PSMRequest clearUpdate()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.y < 0) {
      getSerializedSize();
    }
    return this.y;
  }
  
  public api_psm_request.CloseHeader getClose()
  {
    return this.l;
  }
  
  public api_psm_request.ConnectHeader getConnect()
  {
    return this.f;
  }
  
  public int getLastReceived()
  {
    return this.v;
  }
  
  public ArrayUtil getPayload()
  {
    return this.x;
  }
  
  public api_psm_common.PingHeader getPing()
  {
    return this.p;
  }
  
  public api_psm_request.ReconnectHeader getReconnect()
  {
    return this.h;
  }
  
  public api_psm_common.RetransmitHeader getRetransmit()
  {
    return this.n;
  }
  
  public int getSequenceNumber()
  {
    return this.t;
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
    if (hasConnect()) {
      i1 += WriteStream.dataLength(3, getConnect());
    }
    if (hasReconnect()) {
      i1 += WriteStream.dataLength(4, getReconnect());
    }
    if (hasUpdate()) {
      i1 += WriteStream.dataLength(5, getUpdate());
    }
    if (hasClose()) {
      i1 += WriteStream.dataLength(6, getClose());
    }
    if (hasRetransmit()) {
      i1 += WriteStream.dataLength(7, getRetransmit());
    }
    if (hasPing()) {
      i1 += WriteStream.dataLength(8, getPing());
    }
    if (hasSessionId()) {
      i1 += WriteStream.dataLength(12, getSessionId());
    }
    if (hasSequenceNumber()) {
      i1 += WriteStream.bindLength3(13, getSequenceNumber());
    }
    if (hasLastReceived()) {
      i1 += WriteStream.bindLength3(14, getLastReceived());
    }
    if (hasPayload()) {
      i1 += WriteStream.dataLength(15, getPayload());
    }
    this.y = i1;
    return i1;
  }
  
  public api_psm_common.UUID getSessionId()
  {
    return this.r;
  }
  
  public long getTimestamp()
  {
    return this.d;
  }
  
  public int getType()
  {
    return this.b;
  }
  
  public api_psm_request.UpdateHeader getUpdate()
  {
    return this.j;
  }
  
  public boolean hasClose()
  {
    return this.k;
  }
  
  public boolean hasConnect()
  {
    return this.e;
  }
  
  public boolean hasLastReceived()
  {
    return this.u;
  }
  
  public boolean hasPayload()
  {
    return this.w;
  }
  
  public boolean hasPing()
  {
    return this.o;
  }
  
  public boolean hasReconnect()
  {
    return this.g;
  }
  
  public boolean hasRetransmit()
  {
    return this.m;
  }
  
  public boolean hasSequenceNumber()
  {
    return this.s;
  }
  
  public boolean hasSessionId()
  {
    return this.q;
  }
  
  public boolean hasTimestamp()
  {
    return this.c;
  }
  
  public boolean hasType()
  {
    return this.createArray;
  }
  
  public boolean hasUpdate()
  {
    return this.i;
  }
  
  public final boolean isInitialized()
  {
    if (!this.createArray) {}
    while (((hasConnect()) && (!getConnect().isInitialized())) || ((hasReconnect()) && (!getReconnect().isInitialized())) || ((hasSessionId()) && (!getSessionId().isInitialized()))) {
      return false;
    }
    return true;
  }
  
  public PSMRequest mergeFrom(ReadStream paramReadStream)
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
        api_psm_request.ConnectHeader localConnectHeader = new api_psm_request.ConnectHeader();
        paramReadStream.getInstance(localConnectHeader);
        setConnect(localConnectHeader);
        break;
      case 34: 
        api_psm_request.ReconnectHeader localReconnectHeader = new api_psm_request.ReconnectHeader();
        paramReadStream.getInstance(localReconnectHeader);
        setReconnect(localReconnectHeader);
        break;
      case 42: 
        api_psm_request.UpdateHeader localUpdateHeader = new api_psm_request.UpdateHeader();
        paramReadStream.getInstance(localUpdateHeader);
        setUpdate(localUpdateHeader);
        break;
      case 50: 
        api_psm_request.CloseHeader localCloseHeader = new api_psm_request.CloseHeader();
        paramReadStream.getInstance(localCloseHeader);
        setClose(localCloseHeader);
        break;
      case 58: 
        api_psm_common.RetransmitHeader localRetransmitHeader = new api_psm_common.RetransmitHeader();
        paramReadStream.getInstance(localRetransmitHeader);
        setRetransmit(localRetransmitHeader);
        break;
      case 66: 
        api_psm_common.PingHeader localPingHeader = new api_psm_common.PingHeader();
        paramReadStream.getInstance(localPingHeader);
        setPing(localPingHeader);
        break;
      case 98: 
        api_psm_common.UUID localUUID = new api_psm_common.UUID();
        paramReadStream.getInstance(localUUID);
        setSessionId(localUUID);
        break;
      case 104: 
        setSequenceNumber(paramReadStream.calc3());
        break;
      case 112: 
        setLastReceived(paramReadStream.calc3());
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
  
  public PSMRequest setClose(api_psm_request.CloseHeader paramCloseHeader)
  {
    if (paramCloseHeader == null) {
      throw new NullPointerException();
    }
    this.k = true;
    this.l = paramCloseHeader;
    return this;
  }
  
  public PSMRequest setConnect(api_psm_request.ConnectHeader paramConnectHeader)
  {
    if (paramConnectHeader == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramConnectHeader;
    return this;
  }
  
  public PSMRequest setLastReceived(int paramInt)
  {
    this.u = true;
    this.v = paramInt;
    return this;
  }
  
  public PSMRequest setPayload(ArrayUtil paramArrayUtil)
  {
    this.w = true;
    this.x = paramArrayUtil;
    return this;
  }
  
  public PSMRequest setPing(api_psm_common.PingHeader paramPingHeader)
  {
    if (paramPingHeader == null) {
      throw new NullPointerException();
    }
    this.o = true;
    this.p = paramPingHeader;
    return this;
  }
  
  public PSMRequest setReconnect(api_psm_request.ReconnectHeader paramReconnectHeader)
  {
    if (paramReconnectHeader == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramReconnectHeader;
    return this;
  }
  
  public PSMRequest setRetransmit(api_psm_common.RetransmitHeader paramRetransmitHeader)
  {
    if (paramRetransmitHeader == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramRetransmitHeader;
    return this;
  }
  
  public PSMRequest setSequenceNumber(int paramInt)
  {
    this.s = true;
    this.t = paramInt;
    return this;
  }
  
  public PSMRequest setSessionId(api_psm_common.UUID paramUUID)
  {
    if (paramUUID == null) {
      throw new NullPointerException();
    }
    this.q = true;
    this.r = paramUUID;
    return this;
  }
  
  public PSMRequest setTimestamp(long paramLong)
  {
    this.c = true;
    this.d = paramLong;
    return this;
  }
  
  public PSMRequest setType(int paramInt)
  {
    this.createArray = true;
    this.b = paramInt;
    return this;
  }
  
  public PSMRequest setUpdate(api_psm_request.UpdateHeader paramUpdateHeader)
  {
    if (paramUpdateHeader == null) {
      throw new NullPointerException();
    }
    this.i = true;
    this.j = paramUpdateHeader;
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
    if (hasConnect()) {
      paramWriteStream.getInstance(3, getConnect());
    }
    if (hasReconnect()) {
      paramWriteStream.getInstance(4, getReconnect());
    }
    if (hasUpdate()) {
      paramWriteStream.getInstance(5, getUpdate());
    }
    if (hasClose()) {
      paramWriteStream.getInstance(6, getClose());
    }
    if (hasRetransmit()) {
      paramWriteStream.getInstance(7, getRetransmit());
    }
    if (hasPing()) {
      paramWriteStream.getInstance(8, getPing());
    }
    if (hasSessionId()) {
      paramWriteStream.getInstance(12, getSessionId());
    }
    if (hasSequenceNumber()) {
      paramWriteStream.dataLength(13, getSequenceNumber());
    }
    if (hasLastReceived()) {
      paramWriteStream.dataLength(14, getLastReceived());
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




public static class ReconnectHeader
  extends CacheBase
{
  public static final int IDAUUID_FIELD_NUMBER = 2;
  public static final int SIGNATURE_FIELD_NUMBER = 1;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private int e = -1;
  
  public static ReconnectHeader parseFrom(ReadStream paramReadStream)
  {
    return new ReconnectHeader().mergeFrom(paramReadStream);
  }
  
  public static ReconnectHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (ReconnectHeader)new ReconnectHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final ReconnectHeader clear()
  {
    clearSignature();
    clearIDAUuid();
    this.e = -1;
    return this;
  }
  
  public ReconnectHeader clearIDAUuid()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public ReconnectHeader clearSignature()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public String getIDAUuid()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasSignature();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getSignature());
    }
    if (hasIDAUuid()) {
      i += WriteStream.dataLength(2, getIDAUuid());
    }
    this.e = i;
    return i;
  }
  
  public String getSignature()
  {
    return this.b;
  }
  
  public boolean hasIDAUuid()
  {
    return this.c;
  }
  
  public boolean hasSignature()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    if (!this.a) {}
    while (!this.c) {
      return false;
    }
    return true;
  }
  
  public ReconnectHeader mergeFrom(ReadStream paramReadStream)
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
      case 10: 
        setSignature(paramReadStream.getStr());
        break;
      case 18: // '\022'
          setIDAUuid(paramReadStream.getStr());
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
  
  public ReconnectHeader setIDAUuid(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public ReconnectHeader setSignature(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
	  try {	  
    if (hasSignature()) {
      paramWriteStream.getInstance(1, getSignature());
    }
    if (hasIDAUuid()) {
      paramWriteStream.getInstance(2, getIDAUuid());
    }
	    } catch(ExceptionManager mng) {
	    	  mng.printStackTrace();
	      } catch(Exception ex) {
	    	  ex.printStackTrace();
	      }
    
  }
}




public static class UpdateHeader
  extends CacheBase
{
  private int a = -1;
  
  public static UpdateHeader parseFrom(ReadStream paramReadStream)
  {
    return new UpdateHeader().mergeFrom(paramReadStream);
  }
  
  public static UpdateHeader parseFrom(byte[] paramArrayOfByte)
  {
    return (UpdateHeader)new UpdateHeader().mergeFrom(paramArrayOfByte);
  }
  
  public final UpdateHeader clear()
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
  
  public UpdateHeader mergeFrom(ReadStream paramReadStream)
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
    } while (true);
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(IOException ex) {
    	  ex.printStackTrace();
      }
      return this;	  

  }
  
  public void writeTo(WriteStream paramWriteStream) {}
}


}
