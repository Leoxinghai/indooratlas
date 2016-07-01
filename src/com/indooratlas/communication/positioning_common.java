// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.communication;
import com.xinghai.indoor.util.CacheBase;
import com.xinghai.indoor.util.ExceptionManager;
import com.xinghai.indoor.util.ReadStream;
import com.xinghai.indoor.util.WriteStream;
import java.io.IOException;

public final class positioning_common
{

    private positioning_common()
    {
    }

    public static final int ACCELEROMETER = 3;
    public static final int GYROSCOPE = 2;
    public static final int LIGHT_SENSOR = 6;
    public static final int MAGNETOMETER = 1;
    public static final int PRESSURE_SENSOR = 4;
    public static final int PROXIMITY_SENSOR = 5;
    public static final int TEMPERATURE_SENSOR = 7;
    public static final int UNSPECIFIED_TYPE = 0;
    public static final int WIFI = 8;
    
    
    public static class GeoPosition
    extends CacheBase
  {
    public static final int HEADINGRADIANS_FIELD_NUMBER = 4;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    public static final int RADIUS_FIELD_NUMBER = 3;
    private boolean a;
    private double b = 0.0D;
    private boolean c;
    private double d = 0.0D;
    private boolean e;
    private float f = 0.0F;
    private boolean g;
    private float h = 0.0F;
    private int i = -1;
    
    public static GeoPosition parseFrom(ReadStream paramReadStream)
    {
      return new GeoPosition().mergeFrom(paramReadStream);
    }
    
    public static GeoPosition parseFrom(byte[] paramArrayOfByte)
    {
      return (GeoPosition)new GeoPosition().mergeFrom(paramArrayOfByte);
    }
    
    public final GeoPosition clear()
    {
      clearLatitude();
      clearLongitude();
      clearRadius();
      clearHeadingRadians();
      this.i = -1;
      return this;
    }
    
    public GeoPosition clearHeadingRadians()
    {
      this.g = false;
      this.h = 0.0F;
      return this;
    }
    
    public GeoPosition clearLatitude()
    {
      this.a = false;
      this.b = 0.0D;
      return this;
    }
    
    public GeoPosition clearLongitude()
    {
      this.c = false;
      this.d = 0.0D;
      return this;
    }
    
    public GeoPosition clearRadius()
    {
      this.e = false;
      this.f = 0.0F;
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
    
    public double getLatitude()
    {
      return this.b;
    }
    
    public double getLongitude()
    {
      return this.d;
    }
    
    public float getRadius()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasLatitude();
      int j = 0;
      if (bool) {
        j = 0 + WriteStream.dataLength(1, getLatitude());
      }
      if (hasLongitude()) {
        j += WriteStream.dataLength(2, getLongitude());
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
    
    public boolean hasHeadingRadians()
    {
      return this.g;
    }
    
    public boolean hasLatitude()
    {
      return this.a;
    }
    
    public boolean hasLongitude()
    {
      return this.c;
    }
    
    public boolean hasRadius()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public GeoPosition mergeFrom(ReadStream paramReadStream)
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
          setLatitude(paramReadStream.getStatus());
          break;
        case 17: 
          setLongitude(paramReadStream.getStatus());
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
    
    public GeoPosition setHeadingRadians(float paramFloat)
    {
      this.g = true;
      this.h = paramFloat;
      return this;
    }
    
    public GeoPosition setLatitude(double paramDouble)
    {
      this.a = true;
      this.b = paramDouble;
      return this;
    }
    
    public GeoPosition setLongitude(double paramDouble)
    {
      this.c = true;
      this.d = paramDouble;
      return this;
    }
    
    public GeoPosition setRadius(float paramFloat)
    {
      this.e = true;
      this.f = paramFloat;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      if (hasLatitude()) {
        paramWriteStream.getInstance(1, getLatitude());
      }
      if (hasLongitude()) {
        paramWriteStream.getInstance(2, getLongitude());
      }
      if (hasRadius()) {
        paramWriteStream.getInstance(3, getRadius());
      }
      if (hasHeadingRadians()) {
        paramWriteStream.getInstance(4, getHeadingRadians());
      }
    }
  }

    
    public static class KeyValuePair
    extends CacheBase
  {
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static KeyValuePair parseFrom(ReadStream paramReadStream)
    {
      return new KeyValuePair().mergeFrom(paramReadStream);
    }
    
    public static KeyValuePair parseFrom(byte[] paramArrayOfByte)
    {
      return (KeyValuePair)new KeyValuePair().mergeFrom(paramArrayOfByte);
    }
    
    public final KeyValuePair clear()
    {
      clearKey();
      clearValue();
      this.e = -1;
      return this;
    }
    
    public KeyValuePair clearKey()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public KeyValuePair clearValue()
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
    
    public String getKey()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasKey();
      int i = 0;
      if (bool) {
        i = 0 + WriteStream.dataLength(1, getKey());
      }
      if (hasValue()) {
        i += WriteStream.dataLength(2, getValue());
      }
      this.e = i;
      return i;
    }
    
    public String getValue()
    {
      return this.d;
    }
    
    public boolean hasKey()
    {
      return this.a;
    }
    
    public boolean hasValue()
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
    
    public KeyValuePair mergeFrom(ReadStream paramReadStream)
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
          setKey(paramReadStream.getStr());
          break;
        case 18: // '\022'
            setValue(paramReadStream.getStr());
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
    
    public KeyValuePair setKey(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public KeyValuePair setValue(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      try {
    	if (hasKey()) {
        paramWriteStream.getInstance(1, getKey());
      }
      if (hasValue()) {
        paramWriteStream.getInstance(2, getValue());
      }
      } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(Exception ex) {
    	  ex.printStackTrace();
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
    
    public UUID mergeFrom(ReadStream paramReadStream)
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
          setLeastSignBits(paramReadStream.calc5());
          break;
        case 16: // '\020'
            setMostSignBits(paramReadStream.calc5());
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
