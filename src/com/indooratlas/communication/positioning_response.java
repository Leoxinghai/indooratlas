// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.communication;
import com.xinghai.indoor.util.CacheBase;

import com.xinghai.indoor.util.ExceptionManager;
import com.xinghai.indoor.util.ReadStream;
import com.xinghai.indoor.util.WriteStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;


public final class positioning_response
{

    private positioning_response()
    {
    }
    
    public static class DebugContainer
    extends CacheBase
  {
    public static final int KEYVALUEPAIR_FIELD_NUMBER = 1;
    private List a = Collections.emptyList();
    private int b = -1;
    
    public static DebugContainer parseFrom(ReadStream paramReadStream)
    {
      return new DebugContainer().mergeFrom(paramReadStream);
    }
    
    public static DebugContainer parseFrom(byte[] paramArrayOfByte)
    {
      return (DebugContainer)new DebugContainer().mergeFrom(paramArrayOfByte);
    }
    
    public DebugContainer addKeyValuePair(positioning_common.KeyValuePair paramKeyValuePair)
    {
      if (paramKeyValuePair == null) {
        throw new NullPointerException();
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramKeyValuePair);
      return this;
    }
    
    public final DebugContainer clear()
    {
      clearKeyValuePair();
      this.b = -1;
      return this;
    }
    
    public DebugContainer clearKeyValuePair()
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
    
    public positioning_common.KeyValuePair getKeyValuePair(int paramInt)
    {
      return (positioning_common.KeyValuePair)this.a.get(paramInt);
    }
    
    public int getKeyValuePairCount()
    {
      return this.a.size();
    }
    
    public List getKeyValuePairList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getKeyValuePairList().iterator();
      int i = 0;
      for (;localIterator.hasNext();)
      {
        i += WriteStream.dataLength(1, (positioning_common.KeyValuePair)localIterator.next());
      }
      
      this.b = i;
      return i;
      
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getKeyValuePairList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          return true;
        }
      } while (((positioning_common.KeyValuePair)localIterator.next()).isInitialized());
      return false;
    }
    
    public DebugContainer mergeFrom(ReadStream paramReadStream)
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
            positioning_common.KeyValuePair localKeyValuePair = new positioning_common.KeyValuePair();
            paramReadStream.getInstance(localKeyValuePair);
            addKeyValuePair(localKeyValuePair);
            break;
        }
      }
      } catch(ExceptionManager mng) {
      	  mng.printStackTrace();
        } catch(Exception ex) {
      	  ex.printStackTrace();
        }

          return this;      
    	
    }
    
    public DebugContainer setKeyValuePair(int paramInt, positioning_common.KeyValuePair paramKeyValuePair)
    {
      if (paramKeyValuePair == null) {
        throw new NullPointerException();
      }
      this.a.set(paramInt, paramKeyValuePair);
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      Iterator localIterator = getKeyValuePairList().iterator();
      for (;localIterator.hasNext();)
      {
        paramWriteStream.getInstance(1, (positioning_common.KeyValuePair)localIterator.next());
      }
    }
  }

    
    
    

public static class InitializationResponse
  extends CacheBase
{
  public static final int SENSORSCONFIGURATION_FIELD_NUMBER = 1;
  private boolean a;
  private positioning_response.SensorsConfiguration b = null;
  private int c = -1;
  
  public static InitializationResponse parseFrom(ReadStream paramReadStream)
  {
    return new InitializationResponse().mergeFrom(paramReadStream);
  }
  
  public static InitializationResponse parseFrom(byte[] paramArrayOfByte)
  {
    return (InitializationResponse)new InitializationResponse().mergeFrom(paramArrayOfByte);
  }
  
  public final InitializationResponse clear()
  {
    clearSensorsConfiguration();
    this.c = -1;
    return this;
  }
  
  public InitializationResponse clearSensorsConfiguration()
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
  
  public positioning_response.SensorsConfiguration getSensorsConfiguration()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasSensorsConfiguration();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getSensorsConfiguration());
    }
    this.c = i;
    return i;
  }
  
  public boolean hasSensorsConfiguration()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return (!hasSensorsConfiguration()) || (getSensorsConfiguration().isInitialized());
  }
  
  public InitializationResponse mergeFrom(ReadStream paramReadStream)
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
          positioning_response.SensorsConfiguration localSensorsConfiguration = new positioning_response.SensorsConfiguration();
          paramReadStream.getInstance(localSensorsConfiguration);
          setSensorsConfiguration(localSensorsConfiguration);
          break;
      }
    }
	    } catch(ExceptionManager mng) {
	    	  mng.printStackTrace();
	      } catch(Exception ex) {
	    	  ex.printStackTrace();
	      }

	        return this;      
	  
  }
  
  public InitializationResponse setSensorsConfiguration(positioning_response.SensorsConfiguration paramSensorsConfiguration)
  {
    if (paramSensorsConfiguration == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramSensorsConfiguration;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasSensorsConfiguration()) {
      paramWriteStream.getInstance(1, getSensorsConfiguration());
    }
  }
}




public static class MetricPosition
extends CacheBase
{
public static final int HEADINGRADIANS_FIELD_NUMBER = 4;
public static final int RADIUS_FIELD_NUMBER = 3;
public static final int X_FIELD_NUMBER = 1;
public static final int Y_FIELD_NUMBER = 2;
private boolean a;
private double b = 0.0D;
private boolean c;
private double d = 0.0D;
private boolean e;
private float f = 0.0F;
private boolean g;
private float h = 0.0F;
private int i = -1;

public static MetricPosition parseFrom(ReadStream paramReadStream)
{
  return new MetricPosition().mergeFrom(paramReadStream);
}

public static MetricPosition parseFrom(byte[] paramArrayOfByte)
{
  return (MetricPosition)new MetricPosition().mergeFrom(paramArrayOfByte);
}

public final MetricPosition clear()
{
  clearX();
  clearY();
  clearRadius();
  clearHeadingRadians();
  this.i = -1;
  return this;
}

public MetricPosition clearHeadingRadians()
{
  this.g = false;
  this.h = 0.0F;
  return this;
}

public MetricPosition clearRadius()
{
  this.e = false;
  this.f = 0.0F;
  return this;
}

public MetricPosition clearX()
{
  this.a = false;
  this.b = 0.0D;
  return this;
}

public MetricPosition clearY()
{
  this.c = false;
  this.d = 0.0D;
  return this;
}

public int getCachedSize()
{
  if (this.i < 0) {
    getSerializedSize();
  }
  return this.i;
}

public float getHeadingRadians()
{
  return this.h;
}

public float getRadius()
{
  return this.f;
}

public int getSerializedSize()
{
  boolean bool = hasX();
  int j = 0;
  if (bool) {
    j = 0 + WriteStream.dataLength(1, getX());
  }
  if (hasY()) {
    j += WriteStream.dataLength(2, getY());
  }
  if (hasRadius()) {
    j += WriteStream.dataLength(3, getRadius());
  }
  if (hasHeadingRadians()) {
    j += WriteStream.dataLength(4, getHeadingRadians());
  }
  this.i = j;
  return j;
}

public double getX()
{
  return this.b;
}

public double getY()
{
  return this.d;
}

public boolean hasHeadingRadians()
{
  return this.g;
}

public boolean hasRadius()
{
  return this.e;
}

public boolean hasX()
{
  return this.a;
}

public boolean hasY()
{
  return this.c;
}

public final boolean isInitialized()
{
  return true;
}

public MetricPosition mergeFrom(ReadStream paramReadStream)
{
  try {
	for (;;)
  {
    int j = paramReadStream.getInstance();
    switch (j)
    {
    default: 
      if (parseUnknownField(paramReadStream, j)) {
        continue;
      }
    case 0: 
      return this;
    case 9: 
      setX(paramReadStream.getStatus());
      break;
    case 17: 
      setY(paramReadStream.getStatus());
      break;
    case 29: 
      setRadius(paramReadStream.checkResult());
      break;
    case 37: // '%'
        setHeadingRadians(paramReadStream.checkResult());
        break;
    }
  }
  } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }

      return this;      
	
}

public MetricPosition setHeadingRadians(float paramFloat)
{
  this.g = true;
  this.h = paramFloat;
  return this;
}

public MetricPosition setRadius(float paramFloat)
{
  this.e = true;
  this.f = paramFloat;
  return this;
}

public MetricPosition setX(double paramDouble)
{
  this.a = true;
  this.b = paramDouble;
  return this;
}

public MetricPosition setY(double paramDouble)
{
  this.c = true;
  this.d = paramDouble;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasX()) {
    paramWriteStream.getInstance(1, getX());
  }
  if (hasY()) {
    paramWriteStream.getInstance(2, getY());
  }
  if (hasRadius()) {
    paramWriteStream.getInstance(3, getRadius());
  }
  if (hasHeadingRadians()) {
    paramWriteStream.getInstance(4, getHeadingRadians());
  }
}
}




public static class PixelPosition
extends CacheBase
{
public static final int HEADINGRADIANS_FIELD_NUMBER = 4;
public static final int RADIUS_FIELD_NUMBER = 3;
public static final int X_FIELD_NUMBER = 1;
public static final int Y_FIELD_NUMBER = 2;
private boolean a;
private double b = 0.0D;
private boolean c;
private double d = 0.0D;
private boolean e;
private float f = 0.0F;
private boolean g;
private float h = 0.0F;
private int i = -1;

public static PixelPosition parseFrom(ReadStream paramReadStream)
{
  return new PixelPosition().mergeFrom(paramReadStream);
}

public static PixelPosition parseFrom(byte[] paramArrayOfByte)
{
  return (PixelPosition)new PixelPosition().mergeFrom(paramArrayOfByte);
}

public final PixelPosition clear()
{
  clearX();
  clearY();
  clearRadius();
  clearHeadingRadians();
  this.i = -1;
  return this;
}

public PixelPosition clearHeadingRadians()
{
  this.g = false;
  this.h = 0.0F;
  return this;
}

public PixelPosition clearRadius()
{
  this.e = false;
  this.f = 0.0F;
  return this;
}

public PixelPosition clearX()
{
  this.a = false;
  this.b = 0.0D;
  return this;
}

public PixelPosition clearY()
{
  this.c = false;
  this.d = 0.0D;
  return this;
}

public int getCachedSize()
{
  if (this.i < 0) {
    getSerializedSize();
  }
  return this.i;
}

public float getHeadingRadians()
{
  return this.h;
}

public float getRadius()
{
  return this.f;
}

public int getSerializedSize()
{
  boolean bool = hasX();
  int j = 0;
  if (bool) {
    j = 0 + WriteStream.dataLength(1, getX());
  }
  if (hasY()) {
    j += WriteStream.dataLength(2, getY());
  }
  if (hasRadius()) {
    j += WriteStream.dataLength(3, getRadius());
  }
  if (hasHeadingRadians()) {
    j += WriteStream.dataLength(4, getHeadingRadians());
  }
  this.i = j;
  return j;
}

public double getX()
{
  return this.b;
}

public double getY()
{
  return this.d;
}

public boolean hasHeadingRadians()
{
  return this.g;
}

public boolean hasRadius()
{
  return this.e;
}

public boolean hasX()
{
  return this.a;
}

public boolean hasY()
{
  return this.c;
}

public final boolean isInitialized()
{
  return true;
}

public PixelPosition mergeFrom(ReadStream paramReadStream)
{
  try {
	for (;;)
  {
    int j = paramReadStream.getInstance();
    switch (j)
    {
    default: 
      if (parseUnknownField(paramReadStream, j)) {
        continue;
      }
    case 0: 
      return this;
    case 9: 
      setX(paramReadStream.getStatus());
      break;
    case 17: 
      setY(paramReadStream.getStatus());
      break;
    case 29: 
      setRadius(paramReadStream.checkResult());
      break;
    case 37: // '%'
        setHeadingRadians(paramReadStream.checkResult());
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

public PixelPosition setHeadingRadians(float paramFloat)
{
  this.g = true;
  this.h = paramFloat;
  return this;
}

public PixelPosition setRadius(float paramFloat)
{
  this.e = true;
  this.f = paramFloat;
  return this;
}

public PixelPosition setX(double paramDouble)
{
  this.a = true;
  this.b = paramDouble;
  return this;
}

public PixelPosition setY(double paramDouble)
{
  this.c = true;
  this.d = paramDouble;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasX()) {
    paramWriteStream.getInstance(1, getX());
  }
  if (hasY()) {
    paramWriteStream.getInstance(2, getY());
  }
  if (hasRadius()) {
    paramWriteStream.getInstance(3, getRadius());
  }
  if (hasHeadingRadians()) {
    paramWriteStream.getInstance(4, getHeadingRadians());
  }
}
}



public static class Position
extends CacheBase
{
public static final int GEOPOSITION_FIELD_NUMBER = 1;
public static final int METRICPOSITION_FIELD_NUMBER = 3;
public static final int PIXELPOSITION_FIELD_NUMBER = 2;
private boolean a;
private positioning_common.GeoPosition b = null;
private boolean c;
private positioning_response.PixelPosition d = null;
private boolean e;
private positioning_response.MetricPosition f = null;
private int g = -1;

public static Position parseFrom(ReadStream paramReadStream)
{
  return new Position().mergeFrom(paramReadStream);
}

public static Position parseFrom(byte[] paramArrayOfByte)
{
  return (Position)new Position().mergeFrom(paramArrayOfByte);
}

public final Position clear()
{
  clearGeoPosition();
  clearPixelPosition();
  clearMetricPosition();
  this.g = -1;
  return this;
}

public Position clearGeoPosition()
{
  this.a = false;
  this.b = null;
  return this;
}

public Position clearMetricPosition()
{
  this.e = false;
  this.f = null;
  return this;
}

public Position clearPixelPosition()
{
  this.c = false;
  this.d = null;
  return this;
}

public int getCachedSize()
{
  if (this.g < 0) {
    getSerializedSize();
  }
  return this.g;
}

public positioning_common.GeoPosition getGeoPosition()
{
  return this.b;
}

public positioning_response.MetricPosition getMetricPosition()
{
  return this.f;
}

public positioning_response.PixelPosition getPixelPosition()
{
  return this.d;
}

public int getSerializedSize()
{
  boolean bool = hasGeoPosition();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getGeoPosition());
  }
  if (hasPixelPosition()) {
    i += WriteStream.dataLength(2, getPixelPosition());
  }
  if (hasMetricPosition()) {
    i += WriteStream.dataLength(3, getMetricPosition());
  }
  this.g = i;
  return i;
}

public boolean hasGeoPosition()
{
  return this.a;
}

public boolean hasMetricPosition()
{
  return this.e;
}

public boolean hasPixelPosition()
{
  return this.c;
}

public final boolean isInitialized()
{
  return true;
}

public Position mergeFrom(ReadStream paramReadStream)
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
      positioning_common.GeoPosition localGeoPosition = new positioning_common.GeoPosition();
      paramReadStream.getInstance(localGeoPosition);
      setGeoPosition(localGeoPosition);
      break;
    case 18: 
      positioning_response.PixelPosition localPixelPosition = new positioning_response.PixelPosition();
      paramReadStream.getInstance(localPixelPosition);
      setPixelPosition(localPixelPosition);
      break;
    case 26: // '\032'
        positioning_response.MetricPosition localMetricPosition = new positioning_response.MetricPosition();
        paramReadStream.getInstance(localMetricPosition);
        setMetricPosition(localMetricPosition);
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

public Position setGeoPosition(positioning_common.GeoPosition paramGeoPosition)
{
  if (paramGeoPosition == null) {
    throw new NullPointerException();
  }
  this.a = true;
  this.b = paramGeoPosition;
  return this;
}

public Position setMetricPosition(positioning_response.MetricPosition paramMetricPosition)
{
  if (paramMetricPosition == null) {
    throw new NullPointerException();
  }
  this.e = true;
  this.f = paramMetricPosition;
  return this;
}

public Position setPixelPosition(positioning_response.PixelPosition paramPixelPosition)
{
  if (paramPixelPosition == null) {
    throw new NullPointerException();
  }
  this.c = true;
  this.d = paramPixelPosition;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasGeoPosition()) {
    paramWriteStream.getInstance(1, getGeoPosition());
  }
  if (hasPixelPosition()) {
    paramWriteStream.getInstance(2, getPixelPosition());
  }
  if (hasMetricPosition()) {
    paramWriteStream.getInstance(3, getMetricPosition());
  }
}
}

public static class PositionContainer
extends CacheBase
{
public static final int GRAPHICSID_FIELD_NUMBER = 1;
public static final int POSITION_FIELD_NUMBER = 3;
public static final int PROBABILITY_FIELD_NUMBER = 2;
private boolean a;
private positioning_common.UUID b = null;
private boolean c;
private float d = 0.0F;
private List e = Collections.emptyList();
private int f = -1;

public static PositionContainer parseFrom(ReadStream paramReadStream)
{
  return new PositionContainer().mergeFrom(paramReadStream);
}

public static PositionContainer parseFrom(byte[] paramArrayOfByte)
{
  return (PositionContainer)new PositionContainer().mergeFrom(paramArrayOfByte);
}

public PositionContainer addPosition(positioning_response.Position paramPosition)
{
  if (paramPosition == null) {
    throw new NullPointerException();
  }
  if (this.e.isEmpty()) {
    this.e = new ArrayList();
  }
  this.e.add(paramPosition);
  return this;
}

public final PositionContainer clear()
{
  clearGraphicsId();
  clearProbability();
  clearPosition();
  this.f = -1;
  return this;
}

public PositionContainer clearGraphicsId()
{
  this.a = false;
  this.b = null;
  return this;
}

public PositionContainer clearPosition()
{
  this.e = Collections.emptyList();
  return this;
}

public PositionContainer clearProbability()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public int getCachedSize()
{
  if (this.f < 0) {
    getSerializedSize();
  }
  return this.f;
}

public positioning_common.UUID getGraphicsId()
{
  return this.b;
}

public positioning_response.Position getPosition(int paramInt)
{
  return (positioning_response.Position)this.e.get(paramInt);
}

public int getPositionCount()
{
  return this.e.size();
}

public List getPositionList()
{
  return this.e;
}

public float getProbability()
{
  return this.d;
}

public int getSerializedSize()
{
  boolean bool = hasGraphicsId();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getGraphicsId());
  }
  if (hasProbability()) {
    i += WriteStream.dataLength(2, getProbability());
  }
  Iterator localIterator = getPositionList().iterator();
  int j = i;
  for (;localIterator.hasNext();)
  {
    j += WriteStream.dataLength(3, (positioning_response.Position)localIterator.next());
  }
  
  this.f = j;
  return j;
}

public boolean hasGraphicsId()
{
  return this.a;
}

public boolean hasProbability()
{
  return this.c;
}

public final boolean isInitialized()
{
  if (!this.a) {}
  while ((!this.c) || (!getGraphicsId().isInitialized())) {
    return false;
  }
  return true;
}

public PositionContainer mergeFrom(ReadStream paramReadStream)
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
      positioning_common.UUID localUUID = new positioning_common.UUID();
      paramReadStream.getInstance(localUUID);
      setGraphicsId(localUUID);
      break;
    case 21: 
      setProbability(paramReadStream.checkResult());
      break;
    case 26: // '\032'
        positioning_response.Position localPosition = new positioning_response.Position();
        paramReadStream.getInstance(localPosition);
        addPosition(localPosition);
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

public PositionContainer setGraphicsId(positioning_common.UUID paramUUID)
{
  if (paramUUID == null) {
    throw new NullPointerException();
  }
  this.a = true;
  this.b = paramUUID;
  return this;
}

public PositionContainer setPosition(int paramInt, positioning_response.Position paramPosition)
{
  if (paramPosition == null) {
    throw new NullPointerException();
  }
  this.e.set(paramInt, paramPosition);
  return this;
}

public PositionContainer setProbability(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasGraphicsId()) {
    paramWriteStream.getInstance(1, getGraphicsId());
  }
  if (hasProbability()) {
    paramWriteStream.getInstance(2, getProbability());
  }
  Iterator localIterator = getPositionList().iterator();
  for (;localIterator.hasNext();)
  {
    paramWriteStream.getInstance(3, (positioning_response.Position)localIterator.next());
  }
  
}
}



public static class PositionData
extends CacheBase
{
public static final int POSITIONCONTAINER_FIELD_NUMBER = 1;
public static final int SESSIONUPDATENUMBER_FIELD_NUMBER = 2;
private List a = Collections.emptyList();
private boolean b;
private int c = 0;
private int d = -1;

public static PositionData parseFrom(ReadStream paramReadStream)
{
  return new PositionData().mergeFrom(paramReadStream);
}

public static PositionData parseFrom(byte[] paramArrayOfByte)
{
  return (PositionData)new PositionData().mergeFrom(paramArrayOfByte);
}

public PositionData addPositionContainer(positioning_response.PositionContainer paramPositionContainer)
{
  if (paramPositionContainer == null) {
    throw new NullPointerException();
  }
  if (this.a.isEmpty()) {
    this.a = new ArrayList();
  }
  this.a.add(paramPositionContainer);
  return this;
}

public final PositionData clear()
{
  clearPositionContainer();
  clearSessionUpdateNumber();
  this.d = -1;
  return this;
}

public PositionData clearPositionContainer()
{
  this.a = Collections.emptyList();
  return this;
}

public PositionData clearSessionUpdateNumber()
{
  this.b = false;
  this.c = 0;
  return this;
}

public int getCachedSize()
{
  if (this.d < 0) {
    getSerializedSize();
  }
  return this.d;
}

public positioning_response.PositionContainer getPositionContainer(int paramInt)
{
  return (positioning_response.PositionContainer)this.a.get(paramInt);
}

public int getPositionContainerCount()
{
  return this.a.size();
}

public List getPositionContainerList()
{
  return this.a;
}

public int getSerializedSize()
{
  Iterator localIterator = getPositionContainerList().iterator();
  int i = 0;
  for (;localIterator.hasNext();)
  {
    i += WriteStream.dataLength(1, (positioning_response.PositionContainer)localIterator.next());
  }
	if (hasSessionUpdateNumber()) {
	  i += WriteStream.bindLength3(2, getSessionUpdateNumber());
	}
	this.d = i;
	return i;
  
}

public int getSessionUpdateNumber()
{
  return this.c;
}

public boolean hasSessionUpdateNumber()
{
  return this.b;
}

public final boolean isInitialized()
{
  if (!this.b) {
    return false;
  }
  Iterator localIterator = getPositionContainerList().iterator();
  do
  {
    if (!localIterator.hasNext()) {
      return true;
    }
  } while (((positioning_response.PositionContainer)localIterator.next()).isInitialized());
  return false;
}

public PositionData mergeFrom(ReadStream paramReadStream)
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
      positioning_response.PositionContainer localPositionContainer = new positioning_response.PositionContainer();
      paramReadStream.getInstance(localPositionContainer);
      addPositionContainer(localPositionContainer);
      break;
    case 16: // '\020'
        setSessionUpdateNumber(paramReadStream.calc3());
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

public PositionData setPositionContainer(int paramInt, positioning_response.PositionContainer paramPositionContainer)
{
  if (paramPositionContainer == null) {
    throw new NullPointerException();
  }
  this.a.set(paramInt, paramPositionContainer);
  return this;
}

public PositionData setSessionUpdateNumber(int paramInt)
{
  this.b = true;
  this.c = paramInt;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  Iterator localIterator = getPositionContainerList().iterator();
  for (;localIterator.hasNext();)
  {
    paramWriteStream.getInstance(1, (positioning_response.PositionContainer)localIterator.next());
  }
    if (hasSessionUpdateNumber()) {
      paramWriteStream.dataLength(2, getSessionUpdateNumber());
    }
    return;
  
}
}



public static class PositioningResponse
extends CacheBase
{
public static final int DEBUGCONTAINER_FIELD_NUMBER = 15;
public static final int INITIALIZATION_RESPONSE = 1;
public static final int INITRESPONSE_FIELD_NUMBER = 2;
public static final int POSITIONDATA_FIELD_NUMBER = 3;
public static final int POSITION_DATA = 2;
public static final int TYPE_FIELD_NUMBER = 1;
private boolean a;
private int b = 1;
private boolean c;
private positioning_response.InitializationResponse d = null;
private boolean e;
private positioning_response.PositionData f = null;
private boolean g;
private positioning_response.DebugContainer h = null;
private int i = -1;

public static PositioningResponse parseFrom(ReadStream paramReadStream)
{
  return new PositioningResponse().mergeFrom(paramReadStream);
}

public static PositioningResponse parseFrom(byte[] paramArrayOfByte)
{
  return (PositioningResponse)new PositioningResponse().mergeFrom(paramArrayOfByte);
}

public final PositioningResponse clear()
{
  clearType();
  clearInitResponse();
  clearPositionData();
  clearDebugContainer();
  this.i = -1;
  return this;
}

public PositioningResponse clearDebugContainer()
{
  this.g = false;
  this.h = null;
  return this;
}

public PositioningResponse clearInitResponse()
{
  this.c = false;
  this.d = null;
  return this;
}

public PositioningResponse clearPositionData()
{
  this.e = false;
  this.f = null;
  return this;
}

public PositioningResponse clearType()
{
  this.a = false;
  this.b = 1;
  return this;
}

public int getCachedSize()
{
  if (this.i < 0) {
    getSerializedSize();
  }
  return this.i;
}

public positioning_response.DebugContainer getDebugContainer()
{
  return this.h;
}

public positioning_response.InitializationResponse getInitResponse()
{
  return this.d;
}

public positioning_response.PositionData getPositionData()
{
  return this.f;
}

public int getSerializedSize()
{
  boolean bool = hasType();
  int j = 0;
  if (bool) {
    j = 0 + WriteStream.bindLength2(1, getType());
  }
  if (hasInitResponse()) {
    j += WriteStream.dataLength(2, getInitResponse());
  }
  if (hasPositionData()) {
    j += WriteStream.dataLength(3, getPositionData());
  }
  if (hasDebugContainer()) {
    j += WriteStream.dataLength(15, getDebugContainer());
  }
  this.i = j;
  return j;
}

public int getType()
{
  return this.b;
}

public boolean hasDebugContainer()
{
  return this.g;
}

public boolean hasInitResponse()
{
  return this.c;
}

public boolean hasPositionData()
{
  return this.e;
}

public boolean hasType()
{
  return this.a;
}

public final boolean isInitialized()
{
  if (!this.a) {}
  while (((hasInitResponse()) && (!getInitResponse().isInitialized())) || ((hasPositionData()) && (!getPositionData().isInitialized())) || ((hasDebugContainer()) && (!getDebugContainer().isInitialized()))) {
    return false;
  }
  return true;
}

public PositioningResponse mergeFrom(ReadStream paramReadStream)
{
	try {
  for (;;)
  {
    int j = paramReadStream.getInstance();
    switch (j)
    {
    default: 
      if (parseUnknownField(paramReadStream, j)) {
        continue;
      }
    case 0: 
      return this;
    case 8: 
      setType(paramReadStream.getMBytes());
      break;
    case 18: 
      positioning_response.InitializationResponse localInitializationResponse = new positioning_response.InitializationResponse();
      paramReadStream.getInstance(localInitializationResponse);
      setInitResponse(localInitializationResponse);
      break;
    case 26: 
      positioning_response.PositionData localPositionData = new positioning_response.PositionData();
      paramReadStream.getInstance(localPositionData);
      setPositionData(localPositionData);
      break;
    case 122: // 'z'
        positioning_response.DebugContainer localDebugContainer = new positioning_response.DebugContainer();
        paramReadStream.getInstance(localDebugContainer);
        setDebugContainer(localDebugContainer);
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

public PositioningResponse setDebugContainer(positioning_response.DebugContainer paramDebugContainer)
{
  if (paramDebugContainer == null) {
    throw new NullPointerException();
  }
  this.g = true;
  this.h = paramDebugContainer;
  return this;
}

public PositioningResponse setInitResponse(positioning_response.InitializationResponse paramInitializationResponse)
{
  if (paramInitializationResponse == null) {
    throw new NullPointerException();
  }
  this.c = true;
  this.d = paramInitializationResponse;
  return this;
}

public PositioningResponse setPositionData(positioning_response.PositionData paramPositionData)
{
  if (paramPositionData == null) {
    throw new NullPointerException();
  }
  this.e = true;
  this.f = paramPositionData;
  return this;
}

public PositioningResponse setType(int paramInt)
{
  this.a = true;
  this.b = paramInt;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasType()) {
    paramWriteStream.getInstance(1, getType());
  }
  if (hasInitResponse()) {
    paramWriteStream.getInstance(2, getInitResponse());
  }
  if (hasPositionData()) {
    paramWriteStream.getInstance(3, getPositionData());
  }
  if (hasDebugContainer()) {
    paramWriteStream.getInstance(15, getDebugContainer());
  }
}
}





public static class SensorDeclaration
extends CacheBase
{
public static final int EXPECTEDSAMPLINGFREQUENCY_FIELD_NUMBER = 2;
public static final int SENSORTYPE_FIELD_NUMBER = 1;
private boolean a;
private int b = 0;
private boolean c;
private int d = 0;
private int e = -1;

public static SensorDeclaration parseFrom(ReadStream paramReadStream)
{
  return new SensorDeclaration().mergeFrom(paramReadStream);
}

public static SensorDeclaration parseFrom(byte[] paramArrayOfByte)
{
  return (SensorDeclaration)new SensorDeclaration().mergeFrom(paramArrayOfByte);
}

public final SensorDeclaration clear()
{
  clearSensorType();
  clearExpectedSamplingFrequency();
  this.e = -1;
  return this;
}

public SensorDeclaration clearExpectedSamplingFrequency()
{
  this.c = false;
  this.d = 0;
  return this;
}

public SensorDeclaration clearSensorType()
{
  this.a = false;
  this.b = 0;
  return this;
}

public int getCachedSize()
{
  if (this.e < 0) {
    getSerializedSize();
  }
  return this.e;
}

public int getExpectedSamplingFrequency()
{
  return this.d;
}

public int getSensorType()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasSensorType();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.bindLength2(1, getSensorType());
  }
  if (hasExpectedSamplingFrequency()) {
    i += WriteStream.bindLength2(2, getExpectedSamplingFrequency());
  }
  this.e = i;
  return i;
}

public boolean hasExpectedSamplingFrequency()
{
  return this.c;
}

public boolean hasSensorType()
{
  return this.a;
}

public final boolean isInitialized()
{
  return this.a;
}

public SensorDeclaration mergeFrom(ReadStream paramReadStream)
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
      setSensorType(paramReadStream.getMBytes());
      break;
    case 16: // '\020'
        setExpectedSamplingFrequency(paramReadStream.getMBytes());
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

public SensorDeclaration setExpectedSamplingFrequency(int paramInt)
{
  this.c = true;
  this.d = paramInt;
  return this;
}

public SensorDeclaration setSensorType(int paramInt)
{
  this.a = true;
  this.b = paramInt;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasSensorType()) {
    paramWriteStream.getInstance(1, getSensorType());
  }
  if (hasExpectedSamplingFrequency()) {
    paramWriteStream.getInstance(2, getExpectedSamplingFrequency());
  }
}
}




public static class SensorsConfiguration
extends CacheBase
{
public static final int SENSORS_FIELD_NUMBER = 1;
private List a = Collections.emptyList();
private int b = -1;

public static SensorsConfiguration parseFrom(ReadStream paramReadStream)
{
  return new SensorsConfiguration().mergeFrom(paramReadStream);
}

public static SensorsConfiguration parseFrom(byte[] paramArrayOfByte)
{
  return (SensorsConfiguration)new SensorsConfiguration().mergeFrom(paramArrayOfByte);
}

public SensorsConfiguration addSensors(positioning_response.SensorDeclaration paramSensorDeclaration)
{
  if (paramSensorDeclaration == null) {
    throw new NullPointerException();
  }
  if (this.a.isEmpty()) {
    this.a = new ArrayList();
  }
  this.a.add(paramSensorDeclaration);
  return this;
}

public final SensorsConfiguration clear()
{
  clearSensors();
  this.b = -1;
  return this;
}

public SensorsConfiguration clearSensors()
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

public positioning_response.SensorDeclaration getSensors(int paramInt)
{
  return (positioning_response.SensorDeclaration)this.a.get(paramInt);
}

public int getSensorsCount()
{
  return this.a.size();
}

public List getSensorsList()
{
  return this.a;
}

public int getSerializedSize()
{
  Iterator localIterator = getSensorsList().iterator();
  int i = 0;
  for (;localIterator.hasNext();)
  {
    i += WriteStream.dataLength(1, (positioning_response.SensorDeclaration)localIterator.next());
  }
    this.b = i;
    return i;
}

public final boolean isInitialized()
{
  Iterator localIterator = getSensorsList().iterator();
    for (;localIterator.hasNext();) {
    	if(!((positioning_response.SensorDeclaration)localIterator.next()).isInitialized()) {
    		  return false;
    	}
    }
      return true;
}

public SensorsConfiguration mergeFrom(ReadStream paramReadStream)
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
        positioning_response.SensorDeclaration localSensorDeclaration = new positioning_response.SensorDeclaration();
        paramReadStream.getInstance(localSensorDeclaration);
        addSensors(localSensorDeclaration);
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

public SensorsConfiguration setSensors(int paramInt, positioning_response.SensorDeclaration paramSensorDeclaration)
{
  if (paramSensorDeclaration == null) {
    throw new NullPointerException();
  }
  this.a.set(paramInt, paramSensorDeclaration);
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  Iterator localIterator = getSensorsList().iterator();
  for (;localIterator.hasNext();)
  {
    paramWriteStream.getInstance(1, (positioning_response.SensorDeclaration)localIterator.next());
  }
  
}
}


}
