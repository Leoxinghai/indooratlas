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



public final class positioning_request
{

    private positioning_request()
    {
    }
    
    public static class CalibrationData
    extends CacheBase
  {
    public static final int BACKGROUND = 2;
    public static final int BIASX_FIELD_NUMBER = 2;
    public static final int BIASY_FIELD_NUMBER = 3;
    public static final int BIASZ_FIELD_NUMBER = 4;
    public static final int FORCED = 1;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 1;
    private boolean c;
    private double d = 0.0D;
    private boolean e;
    private double f = 0.0D;
    private boolean g;
    private double h = 0.0D;
    private int i = -1;
    
    public static CalibrationData parseFrom(ReadStream paramReadStream)
    {
      return new CalibrationData().mergeFrom(paramReadStream);
    }
    
    public static CalibrationData parseFrom(byte[] paramArrayOfByte)
    {
      return (CalibrationData)new CalibrationData().mergeFrom(paramArrayOfByte);
    }
    
    public final CalibrationData clear()
    {
      clearType();
      clearBiasX();
      clearBiasY();
      clearBiasZ();
      this.i = -1;
      return this;
    }
    
    public CalibrationData clearBiasX()
    {
      this.c = false;
      this.d = 0.0D;
      return this;
    }
    
    public CalibrationData clearBiasY()
    {
      this.e = false;
      this.f = 0.0D;
      return this;
    }
    
    public CalibrationData clearBiasZ()
    {
      this.g = false;
      this.h = 0.0D;
      return this;
    }
    
    public CalibrationData clearType()
    {
      this.a = false;
      this.b = 1;
      return this;
    }
    
    public double getBiasX()
    {
      return this.d;
    }
    
    public double getBiasY()
    {
      return this.f;
    }
    
    public double getBiasZ()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasType();
      int j = 0;
      if (bool) {
        j = 0 + WriteStream.bindLength2(1, getType());
      }
      if (hasBiasX()) {
        j += WriteStream.dataLength(2, getBiasX());
      }
      if (hasBiasY()) {
        j += WriteStream.dataLength(3, getBiasY());
      }
      if (hasBiasZ()) {
        j += WriteStream.dataLength(4, getBiasZ());
      }
      this.i = j;
      return j;
    }
    
    public int getType()
    {
      return this.b;
    }
    
    public boolean hasBiasX()
    {
      return this.c;
    }
    
    public boolean hasBiasY()
    {
      return this.e;
    }
    
    public boolean hasBiasZ()
    {
      return this.g;
    }
    
    public boolean hasType()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public CalibrationData mergeFrom(ReadStream paramReadStream)
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
        case 17: 
          setBiasX(paramReadStream.getStatus());
          break;
        case 25: 
          setBiasY(paramReadStream.getStatus());
          break;
        case 33: // '!'
            setBiasZ(paramReadStream.getStatus());
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
    
    public CalibrationData setBiasX(double paramDouble)
    {
      this.c = true;
      this.d = paramDouble;
      return this;
    }
    
    public CalibrationData setBiasY(double paramDouble)
    {
      this.e = true;
      this.f = paramDouble;
      return this;
    }
    
    public CalibrationData setBiasZ(double paramDouble)
    {
      this.g = true;
      this.h = paramDouble;
      return this;
    }
    
    public CalibrationData setType(int paramInt)
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
      if (hasBiasX()) {
        paramWriteStream.getInstance(2, getBiasX());
      }
      if (hasBiasY()) {
        paramWriteStream.getInstance(3, getBiasY());
      }
      if (hasBiasZ()) {
        paramWriteStream.getInstance(4, getBiasZ());
      }
    }
  }

    
    
    
    public static class Device
    extends CacheBase
  {
    public static final int DEVICEMODELID_FIELD_NUMBER = 1;
    private boolean a;
    private positioning_common.UUID b = null;
    private int c = -1;
    
    public static Device parseFrom(ReadStream paramReadStream)
    {
      return new Device().mergeFrom(paramReadStream);
    }
    
    public static Device parseFrom(byte[] paramArrayOfByte)
    {
      return (Device)new Device().mergeFrom(paramArrayOfByte);
    }
    
    public final Device clear()
    {
      clearDeviceModelId();
      this.c = -1;
      return this;
    }
    
    public Device clearDeviceModelId()
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
    
    public positioning_common.UUID getDeviceModelId()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasDeviceModelId();
      int i = 0;
      if (bool) {
        i = 0 + WriteStream.dataLength(1, getDeviceModelId());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasDeviceModelId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return (!hasDeviceModelId()) || (getDeviceModelId().isInitialized());
    }
    
    public Device mergeFrom(ReadStream paramReadStream)
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
            positioning_common.UUID localUUID = new positioning_common.UUID();
            paramReadStream.getInstance(localUUID);
            setDeviceModelId(localUUID);
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
    
    public Device setDeviceModelId(positioning_common.UUID paramUUID)
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
      if (hasDeviceModelId()) {
        paramWriteStream.getInstance(1, getDeviceModelId());
      }
    }
  }

    
    public static class EncodedOneValuedSignal
    extends CacheBase
  {
    public static final int FIRSTTIMESTAMP_FIELD_NUMBER = 1;
    public static final int FIRSTVALUE_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int VALUES_FIELD_NUMBER = 4;
    private boolean a;
    private long b = 0L;
    private List c = Collections.emptyList();
    private boolean d;
    private float e = 0.0F;
    private List f = Collections.emptyList();
    private int g = -1;
    
    public static EncodedOneValuedSignal parseFrom(ReadStream paramReadStream)
    {
      return new EncodedOneValuedSignal().mergeFrom(paramReadStream);
    }
    
    public static EncodedOneValuedSignal parseFrom(byte[] paramArrayOfByte)
    {
      return (EncodedOneValuedSignal)new EncodedOneValuedSignal().mergeFrom(paramArrayOfByte);
    }
    
    public EncodedOneValuedSignal addTimestamp(int paramInt)
    {
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public EncodedOneValuedSignal addValues(int paramInt)
    {
      if (this.f.isEmpty()) {
        this.f = new ArrayList();
      }
      this.f.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public final EncodedOneValuedSignal clear()
    {
      clearFirstTimestamp();
      clearTimestamp();
      clearFirstValue();
      clearValues();
      this.g = -1;
      return this;
    }
    
    public EncodedOneValuedSignal clearFirstTimestamp()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public EncodedOneValuedSignal clearFirstValue()
    {
      this.d = false;
      this.e = 0.0F;
      return this;
    }
    
    public EncodedOneValuedSignal clearTimestamp()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public EncodedOneValuedSignal clearValues()
    {
      this.f = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public long getFirstTimestamp()
    {
      return this.b;
    }
    
    public float getFirstValue()
    {
      return this.e;
    }
    

    public int getSerializedSize()
    {
        int i = 0;
        int j;
        Iterator iterator;
        int k;
        int i1;
        int j1;
        if(hasFirstTimestamp())
            j = 0 + WriteStream.bindLength(1, getFirstTimestamp());
        else
            j = 0;
        iterator = getTimestampList().iterator();
        k = 0;
        for(;iterator.hasNext();) {
        	k += WriteStream.bindLength2(((Integer)iterator.next()).intValue());
        }
        
        int l = j + k + 1 * getTimestampList().size();
        Iterator iterator1;
        if(hasFirstValue())
            i1 = l + WriteStream.dataLength(3, getFirstValue());
        else
            i1 = l;
        iterator1 = getValuesList().iterator();
        
        for(;iterator1.hasNext();)
        {
        	i += WriteStream.bindStatus(((Integer)iterator1.next()).intValue());
        }
    	j1 = i1 + i + 1 * getValuesList().size();
        g = j1;
        return j1;
        
    }
    
    public int getTimestamp(int paramInt)
    {
      return ((Integer)this.c.get(paramInt)).intValue();
    }
    
    public int getTimestampCount()
    {
      return this.c.size();
    }
    
    public List getTimestampList()
    {
      return this.c;
    }
    
    public int getValues(int paramInt)
    {
      return ((Integer)this.f.get(paramInt)).intValue();
    }
    
    public int getValuesCount()
    {
      return this.f.size();
    }
    
    public List getValuesList()
    {
      return this.f;
    }
    
    public boolean hasFirstTimestamp()
    {
      return this.a;
    }
    
    public boolean hasFirstValue()
    {
      return this.d;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public EncodedOneValuedSignal mergeFrom(ReadStream paramReadStream)
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
          setFirstTimestamp(paramReadStream.is1());
          break;
        case 16: 
          addTimestamp(paramReadStream.getMBytes());
          break;
        case 29: 
          setFirstValue(paramReadStream.checkResult());
          break;
        case 32: // ' '
            addValues(paramReadStream.calc4());
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
    
    public EncodedOneValuedSignal setFirstTimestamp(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public EncodedOneValuedSignal setFirstValue(float paramFloat)
    {
      this.d = true;
      this.e = paramFloat;
      return this;
    }
    
    public EncodedOneValuedSignal setTimestamp(int paramInt1, int paramInt2)
    {
      this.c.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public EncodedOneValuedSignal setValues(int paramInt1, int paramInt2)
    {
      this.f.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
  

    public void writeTo(WriteStream writestream)
    {
        Iterator iterator;
        if(hasFirstTimestamp())
            writestream.getInstance(1, getFirstTimestamp());
        
        iterator = getTimestampList().iterator();
        for(;iterator.hasNext();) {
            writestream.getInstance(2, ((Integer)iterator.next()).intValue());
        }

        Iterator iterator1;
        if(hasFirstValue())
            writestream.getInstance(3, getFirstValue());
        
        iterator1 = getValuesList().iterator();
        for(;iterator1.hasNext();) {
            writestream.bindLength(4, ((Integer)iterator1.next()).intValue());
        }
    }
    
  }
    
    
    public static class EncodedThreeValuedSignal
    extends CacheBase
  {
    public static final int FIRSTTIMESTAMP_FIELD_NUMBER = 1;
    public static final int FIRSTX_FIELD_NUMBER = 3;
    public static final int FIRSTY_FIELD_NUMBER = 4;
    public static final int FIRSTZ_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int X_FIELD_NUMBER = 6;
    public static final int Y_FIELD_NUMBER = 7;
    public static final int Z_FIELD_NUMBER = 8;
    private boolean a;
    private long b = 0L;
    private List c = Collections.emptyList();
    private boolean d;
    private float e = 0.0F;
    private boolean f;
    private float g = 0.0F;
    private boolean h;
    private float i = 0.0F;
    private List j = Collections.emptyList();
    private List k = Collections.emptyList();
    private List l = Collections.emptyList();
    private int m = -1;
    
    public static EncodedThreeValuedSignal parseFrom(ReadStream paramReadStream)
    {
      return new EncodedThreeValuedSignal().mergeFrom(paramReadStream);
    }
    
    public static EncodedThreeValuedSignal parseFrom(byte[] paramArrayOfByte)
    {
      return (EncodedThreeValuedSignal)new EncodedThreeValuedSignal().mergeFrom(paramArrayOfByte);
    }
    
    public EncodedThreeValuedSignal addTimestamp(int paramInt)
    {
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public EncodedThreeValuedSignal addX(int paramInt)
    {
      if (this.j.isEmpty()) {
        this.j = new ArrayList();
      }
      this.j.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public EncodedThreeValuedSignal addY(int paramInt)
    {
      if (this.k.isEmpty()) {
        this.k = new ArrayList();
      }
      this.k.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public EncodedThreeValuedSignal addZ(int paramInt)
    {
      if (this.l.isEmpty()) {
        this.l = new ArrayList();
      }
      this.l.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public final EncodedThreeValuedSignal clear()
    {
      clearFirstTimestamp();
      clearTimestamp();
      clearFirstX();
      clearFirstY();
      clearFirstZ();
      clearX();
      clearY();
      clearZ();
      this.m = -1;
      return this;
    }
    
    public EncodedThreeValuedSignal clearFirstTimestamp()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public EncodedThreeValuedSignal clearFirstX()
    {
      this.d = false;
      this.e = 0.0F;
      return this;
    }
    
    public EncodedThreeValuedSignal clearFirstY()
    {
      this.f = false;
      this.g = 0.0F;
      return this;
    }
    
    public EncodedThreeValuedSignal clearFirstZ()
    {
      this.h = false;
      this.i = 0.0F;
      return this;
    }
    
    public EncodedThreeValuedSignal clearTimestamp()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public EncodedThreeValuedSignal clearX()
    {
      this.j = Collections.emptyList();
      return this;
    }
    
    public EncodedThreeValuedSignal clearY()
    {
      this.k = Collections.emptyList();
      return this;
    }
    
    public EncodedThreeValuedSignal clearZ()
    {
      this.l = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public long getFirstTimestamp()
    {
      return this.b;
    }
    
    public float getFirstX()
    {
      return this.e;
    }
    
    public float getFirstY()
    {
      return this.g;
    }
    
    public float getFirstZ()
    {
      return this.i;
    }
    

    public int getSerializedSize()
    {
        int i1 = 0;
        int j1;
        Iterator iterator;
        int k1;
        int l1;
        int i2;
        Iterator iterator1;
        int j2;
        int k2;
        Iterator iterator2;
        int l2;
        int i3;
        Iterator iterator3;
        int j3;
        if(hasFirstTimestamp())
            j1 = 0 + WriteStream.bindLength(1, getFirstTimestamp());
        else
            j1 = 0;
        iterator = getTimestampList().iterator();
        k1 = 0;
        for(;iterator.hasNext();) {
                k1 += WriteStream.bindLength2(((Integer)iterator.next()).intValue());
        }

        l1 = j1 + k1 + 1 * getTimestampList().size();
        if(hasFirstX())
            l1 += WriteStream.dataLength(3, getFirstX());
        if(hasFirstY())
            l1 += WriteStream.dataLength(4, getFirstY());
        if(hasFirstZ())
            i2 = l1 + WriteStream.dataLength(5, getFirstZ());
        else
            i2 = l1;
        iterator1 = getXList().iterator();
        j2 = 0;
        for(;iterator1.hasNext();) {
            j2 += WriteStream.bindStatus(((Integer)iterator1.next()).intValue());
        }

        k2 = i2 + j2 + 1 * getXList().size();
        iterator2 = getYList().iterator();
        l2 = 0;

        for(;iterator2.hasNext();) {
            l2 += WriteStream.bindStatus(((Integer)iterator2.next()).intValue());
        }

        i3 = k2 + l2 + 1 * getYList().size();
        iterator3 = getZList().iterator();
        for(;iterator3.hasNext();)
        {
            i1 += WriteStream.bindStatus(((Integer)iterator3.next()).intValue());
        }
        j3 = i3 + i1 + 1 * getZList().size();
        m = j3;
        return j3;
    }

    
    public int getTimestamp(int paramInt)
    {
      return ((Integer)this.c.get(paramInt)).intValue();
    }
    
    public int getTimestampCount()
    {
      return this.c.size();
    }
    
    public List getTimestampList()
    {
      return this.c;
    }
    
    public int getX(int paramInt)
    {
      return ((Integer)this.j.get(paramInt)).intValue();
    }
    
    public int getXCount()
    {
      return this.j.size();
    }
    
    public List getXList()
    {
      return this.j;
    }
    
    public int getY(int paramInt)
    {
      return ((Integer)this.k.get(paramInt)).intValue();
    }
    
    public int getYCount()
    {
      return this.k.size();
    }
    
    public List getYList()
    {
      return this.k;
    }
    
    public int getZ(int paramInt)
    {
      return ((Integer)this.l.get(paramInt)).intValue();
    }
    
    public int getZCount()
    {
      return this.l.size();
    }
    
    public List getZList()
    {
      return this.l;
    }
    
    public boolean hasFirstTimestamp()
    {
      return this.a;
    }
    
    public boolean hasFirstX()
    {
      return this.d;
    }
    
    public boolean hasFirstY()
    {
      return this.f;
    }
    
    public boolean hasFirstZ()
    {
      return this.h;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public EncodedThreeValuedSignal mergeFrom(ReadStream paramReadStream)
    {
      
    	try {
    	for (;;)
      {
        int n = paramReadStream.getInstance();
        switch (n)
        {
        default: 
          if (parseUnknownField(paramReadStream, n)) {
            continue;
          }
        case 0: 
          return this;
        case 8: 
          setFirstTimestamp(paramReadStream.is1());
          break;
        case 16: 
          addTimestamp(paramReadStream.getMBytes());
          break;
        case 29: 
          setFirstX(paramReadStream.checkResult());
          break;
        case 37: 
          setFirstY(paramReadStream.checkResult());
          break;
        case 45: 
          setFirstZ(paramReadStream.checkResult());
          break;
        case 48: 
          addX(paramReadStream.calc4());
          break;
        case 56: 
          addY(paramReadStream.calc4());
          break;
        case 64: // '@'
            addZ(paramReadStream.calc4());
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
    
    public EncodedThreeValuedSignal setFirstTimestamp(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public EncodedThreeValuedSignal setFirstX(float paramFloat)
    {
      this.d = true;
      this.e = paramFloat;
      return this;
    }
    
    public EncodedThreeValuedSignal setFirstY(float paramFloat)
    {
      this.f = true;
      this.g = paramFloat;
      return this;
    }
    
    public EncodedThreeValuedSignal setFirstZ(float paramFloat)
    {
      this.h = true;
      this.i = paramFloat;
      return this;
    }
    
    public EncodedThreeValuedSignal setTimestamp(int paramInt1, int paramInt2)
    {
      this.c.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public EncodedThreeValuedSignal setX(int paramInt1, int paramInt2)
    {
      this.j.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public EncodedThreeValuedSignal setY(int paramInt1, int paramInt2)
    {
      this.k.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    
    public EncodedThreeValuedSignal setZ(int paramInt1, int paramInt2)
    {
      this.l.set(paramInt1, Integer.valueOf(paramInt2));
      return this;
    }
    

    public void writeTo(WriteStream writestream)
    {
        Iterator iterator;
        if(hasFirstTimestamp())
            writestream.getInstance(1, getFirstTimestamp());
        iterator = getTimestampList().iterator();

        for(;iterator.hasNext();) {
            writestream.getInstance(2, ((Integer)iterator.next()).intValue());
        }
        Iterator iterator1;
        if(hasFirstX())
            writestream.getInstance(3, getFirstX());
        if(hasFirstY())
            writestream.getInstance(4, getFirstY());
        if(hasFirstZ())
            writestream.getInstance(5, getFirstZ());
        iterator1 = getXList().iterator();

        for(;iterator1.hasNext();) {
            writestream.bindLength(6, ((Integer)iterator1.next()).intValue());
        }

        Iterator iterator2 = getYList().iterator();
        for(;iterator2.hasNext();) {
            writestream.bindLength(7, ((Integer)iterator2.next()).intValue());
        }
        
        Iterator iterator3 = getZList().iterator();
        for(;iterator3.hasNext();) {
            writestream.bindLength(8, ((Integer)iterator3.next()).intValue());
        }
    }
    
  }

    
    
    
    public static class GivenPosition
    extends CacheBase
  {
    public static final int COORDS_FIELD_NUMBER = 2;
    public static final int PIXEL_IN_FLOORPLAN = 2;
    public static final int RADIUS_FIELD_NUMBER = 3;
    public static final int UNIT_FIELD_NUMBER = 1;
    public static final int WGS84 = 1;
    private boolean a;
    private int b = 1;
    private List c = Collections.emptyList();
    private boolean d;
    private double e = 0.0D;
    private int f = -1;
    
    public static GivenPosition parseFrom(ReadStream paramReadStream)
    {
      return new GivenPosition().mergeFrom(paramReadStream);
    }
    
    public static GivenPosition parseFrom(byte[] paramArrayOfByte)
    {
      return (GivenPosition)new GivenPosition().mergeFrom(paramArrayOfByte);
    }
    
    public GivenPosition addCoords(double paramDouble)
    {
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(Double.valueOf(paramDouble));
      return this;
    }
    
    public final GivenPosition clear()
    {
      clearUnit();
      clearCoords();
      clearRadius();
      this.f = -1;
      return this;
    }
    
    public GivenPosition clearCoords()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public GivenPosition clearRadius()
    {
      this.d = false;
      this.e = 0.0D;
      return this;
    }
    
    public GivenPosition clearUnit()
    {
      this.a = false;
      this.b = 1;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public double getCoords(int paramInt)
    {
      return ((Double)this.c.get(paramInt)).doubleValue();
    }
    
    public int getCoordsCount()
    {
      return this.c.size();
    }
    
    public List getCoordsList()
    {
      return this.c;
    }
    
    public double getRadius()
    {
      return this.e;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasUnit();
      int i = 0;
      if (bool) {
        i = 0 + WriteStream.bindLength2(1, getUnit());
      }
      int j = i + 8 * getCoordsList().size() + 1 * getCoordsList().size();
      if (hasRadius()) {
        j += WriteStream.dataLength(3, getRadius());
      }
      this.f = j;
      return j;
    }
    
    public int getUnit()
    {
      return this.b;
    }
    
    public boolean hasRadius()
    {
      return this.d;
    }
    
    public boolean hasUnit()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public GivenPosition mergeFrom(ReadStream paramReadStream)
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
          setUnit(paramReadStream.getMBytes());
          break;
        case 17: 
          addCoords(paramReadStream.getStatus());
          break;
        case 25: // '\031'
            setRadius(paramReadStream.getStatus());
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
    
    public GivenPosition setCoords(int paramInt, double paramDouble)
    {
      this.c.set(paramInt, Double.valueOf(paramDouble));
      return this;
    }
    
    public GivenPosition setRadius(double paramDouble)
    {
      this.d = true;
      this.e = paramDouble;
      return this;
    }
    
    public GivenPosition setUnit(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      if (hasUnit()) {
        paramWriteStream.getInstance(1, getUnit());
      }
      Iterator localIterator = getCoordsList().iterator();
      for(;localIterator.hasNext();)
      {
        paramWriteStream.getInstance(2, ((Double)localIterator.next()).doubleValue());
      }
      if (hasRadius()) {
        paramWriteStream.getInstance(3, getRadius());
      }
        
    }
  }

    
    
    public static class GPSSample
    extends CacheBase
  {
    public static final int ALTITUDE_FIELD_NUMBER = 4;
    public static final int GPSTIMESTAMP_FIELD_NUMBER = 1;
    public static final int LATITUDE_FIELD_NUMBER = 2;
    public static final int LONGITUDE_FIELD_NUMBER = 3;
    private boolean a;
    private long b = 0L;
    private boolean c;
    private double d = 0.0D;
    private boolean e;
    private double f = 0.0D;
    private boolean g;
    private double h = 0.0D;
    private int i = -1;
    
    public static GPSSample parseFrom(ReadStream paramReadStream)
    {
      return new GPSSample().mergeFrom(paramReadStream);
    }
    
    public static GPSSample parseFrom(byte[] paramArrayOfByte)
    {
      return (GPSSample)new GPSSample().mergeFrom(paramArrayOfByte);
    }
    
    public final GPSSample clear()
    {
      clearGpsTimestamp();
      clearLatitude();
      clearLongitude();
      clearAltitude();
      this.i = -1;
      return this;
    }
    
    public GPSSample clearAltitude()
    {
      this.g = false;
      this.h = 0.0D;
      return this;
    }
    
    public GPSSample clearGpsTimestamp()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public GPSSample clearLatitude()
    {
      this.c = false;
      this.d = 0.0D;
      return this;
    }
    
    public GPSSample clearLongitude()
    {
      this.e = false;
      this.f = 0.0D;
      return this;
    }
    
    public double getAltitude()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public long getGpsTimestamp()
    {
      return this.b;
    }
    
    public double getLatitude()
    {
      return this.d;
    }
    
    public double getLongitude()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasGpsTimestamp();
      int j = 0;
      if (bool) {
        j = 0 + WriteStream.bindLength(1, getGpsTimestamp());
      }
      if (hasLatitude()) {
        j += WriteStream.dataLength(2, getLatitude());
      }
      if (hasLongitude()) {
        j += WriteStream.dataLength(3, getLongitude());
      }
      if (hasAltitude()) {
        j += WriteStream.dataLength(4, getAltitude());
      }
      this.i = j;
      return j;
    }
    
    public boolean hasAltitude()
    {
      return this.g;
    }
    
    public boolean hasGpsTimestamp()
    {
      return this.a;
    }
    
    public boolean hasLatitude()
    {
      return this.c;
    }
    
    public boolean hasLongitude()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public GPSSample mergeFrom(ReadStream paramReadStream)
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
          setGpsTimestamp(paramReadStream.is1());
          break;
        case 17: 
          setLatitude(paramReadStream.getStatus());
          break;
        case 25: 
          setLongitude(paramReadStream.getStatus());
          break;
        case 33: // '!'
            setAltitude(paramReadStream.getStatus());
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
    
    public GPSSample setAltitude(double paramDouble)
    {
      this.g = true;
      this.h = paramDouble;
      return this;
    }
    
    public GPSSample setGpsTimestamp(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public GPSSample setLatitude(double paramDouble)
    {
      this.c = true;
      this.d = paramDouble;
      return this;
    }
    
    public GPSSample setLongitude(double paramDouble)
    {
      this.e = true;
      this.f = paramDouble;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      if (hasGpsTimestamp()) {
        paramWriteStream.getInstance(1, getGpsTimestamp());
      }
      if (hasLatitude()) {
        paramWriteStream.getInstance(2, getLatitude());
      }
      if (hasLongitude()) {
        paramWriteStream.getInstance(3, getLongitude());
      }
      if (hasAltitude()) {
        paramWriteStream.getInstance(4, getAltitude());
      }
    }
  }

    
    
    public static class InitializationConstraint
    extends CacheBase
  {
    public static final int GRAPHICS_ID = 1;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 1;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static InitializationConstraint parseFrom(ReadStream paramReadStream)
    {
      return new InitializationConstraint().mergeFrom(paramReadStream);
    }
    
    public static InitializationConstraint parseFrom(byte[] paramArrayOfByte)
    {
      return (InitializationConstraint)new InitializationConstraint().mergeFrom(paramArrayOfByte);
    }
    
    public final InitializationConstraint clear()
    {
      clearType();
      clearValue();
      this.e = -1;
      return this;
    }
    
    public InitializationConstraint clearType()
    {
      this.a = false;
      this.b = 1;
      return this;
    }
    
    public InitializationConstraint clearValue()
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
    
    public int getSerializedSize()
    {
      boolean bool = hasType();
      int i = 0;
      if (bool) {
        i = 0 + WriteStream.bindLength2(1, getType());
      }
      if (hasValue()) {
        i += WriteStream.dataLength(2, getValue());
      }
      this.e = i;
      return i;
    }
    
    public int getType()
    {
      return this.b;
    }
    
    public String getValue()
    {
      return this.d;
    }
    
    public boolean hasType()
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
    
    public InitializationConstraint mergeFrom(ReadStream paramReadStream)
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
          setType(paramReadStream.getMBytes());
          break;
        case 18: // '\022'
           setValue(paramReadStream.getStr());
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
    
    public InitializationConstraint setType(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public InitializationConstraint setValue(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
    	try {
      if (hasType()) {
        paramWriteStream.getInstance(1, getType());
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


    
    
    public static class OnlineMeasurement
    extends CacheBase
  {
    public static final int ACCELEROMETER_FIELD_NUMBER = 3;
    public static final int GPSSAMPLES_FIELD_NUMBER = 10;
    public static final int GYROSCOPE_FIELD_NUMBER = 4;
    public static final int LIGHT_FIELD_NUMBER = 8;
    public static final int MAGNETOMETER_FIELD_NUMBER = 5;
    public static final int PRESSURE_FIELD_NUMBER = 6;
    public static final int PROXIMITY_FIELD_NUMBER = 7;
    public static final int TEMPERATURE_FIELD_NUMBER = 9;
    public static final int TIME_END_FIELD_NUMBER = 2;
    public static final int TIME_START_FIELD_NUMBER = 1;
    public static final int WIFIMEASUREMENT_FIELD_NUMBER = 11;
    private boolean a;
    private long b = 0L;
    private boolean c;
    private long d = 0L;
    private boolean e;
    private positioning_request.EncodedThreeValuedSignal f = null;
    private boolean g;
    private positioning_request.EncodedThreeValuedSignal h = null;
    private boolean i;
    private positioning_request.EncodedThreeValuedSignal j = null;
    private boolean k;
    private positioning_request.EncodedOneValuedSignal l = null;
    private boolean m;
    private positioning_request.EncodedOneValuedSignal n = null;
    private boolean o;
    private positioning_request.EncodedOneValuedSignal p = null;
    private boolean q;
    private positioning_request.EncodedOneValuedSignal r = null;
    private List s = Collections.emptyList();
    private boolean t;
    private positioning_request.WifiMeasurement u = null;
    private int v = -1;
    
    public static OnlineMeasurement parseFrom(ReadStream paramReadStream)
    {
      return new OnlineMeasurement().mergeFrom(paramReadStream);
    }
    
    public static OnlineMeasurement parseFrom(byte[] paramArrayOfByte)
    {
      return (OnlineMeasurement)new OnlineMeasurement().mergeFrom(paramArrayOfByte);
    }
    
    public OnlineMeasurement addGpsSamples(positioning_request.GPSSample paramGPSSample)
    {
      if (paramGPSSample == null) {
        throw new NullPointerException();
      }
      if (this.s.isEmpty()) {
        this.s = new ArrayList();
      }
      this.s.add(paramGPSSample);
      return this;
    }
    
    public final OnlineMeasurement clear()
    {
      clearTimeStart();
      clearTimeEnd();
      clearAccelerometer();
      clearGyroscope();
      clearMagnetometer();
      clearPressure();
      clearProximity();
      clearLight();
      clearTemperature();
      clearGpsSamples();
      clearWifiMeasurement();
      this.v = -1;
      return this;
    }
    
    public OnlineMeasurement clearAccelerometer()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public OnlineMeasurement clearGpsSamples()
    {
      this.s = Collections.emptyList();
      return this;
    }
    
    public OnlineMeasurement clearGyroscope()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public OnlineMeasurement clearLight()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public OnlineMeasurement clearMagnetometer()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public OnlineMeasurement clearPressure()
    {
      this.k = false;
      this.l = null;
      return this;
    }
    
    public OnlineMeasurement clearProximity()
    {
      this.m = false;
      this.n = null;
      return this;
    }
    
    public OnlineMeasurement clearTemperature()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public OnlineMeasurement clearTimeEnd()
    {
      this.c = false;
      this.d = 0L;
      return this;
    }
    
    public OnlineMeasurement clearTimeStart()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public OnlineMeasurement clearWifiMeasurement()
    {
      this.t = false;
      this.u = null;
      return this;
    }
    
    public positioning_request.EncodedThreeValuedSignal getAccelerometer()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.v < 0) {
        getSerializedSize();
      }
      return this.v;
    }
    
    public positioning_request.GPSSample getGpsSamples(int paramInt)
    {
      return (positioning_request.GPSSample)this.s.get(paramInt);
    }
    
    public int getGpsSamplesCount()
    {
      return this.s.size();
    }
    
    public List getGpsSamplesList()
    {
      return this.s;
    }
    
    public positioning_request.EncodedThreeValuedSignal getGyroscope()
    {
      return this.h;
    }
    
    public positioning_request.EncodedOneValuedSignal getLight()
    {
      return this.p;
    }
    
    public positioning_request.EncodedThreeValuedSignal getMagnetometer()
    {
      return this.j;
    }
    
    public positioning_request.EncodedOneValuedSignal getPressure()
    {
      return this.l;
    }
    
    public positioning_request.EncodedOneValuedSignal getProximity()
    {
      return this.n;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasTimeStart();
      int i1 = 0;
      if (bool) {
        i1 = 0 + WriteStream.bindLength(1, getTimeStart());
      }
      if (hasTimeEnd()) {
        i1 += WriteStream.bindLength(2, getTimeEnd());
      }
      if (hasAccelerometer()) {
        i1 += WriteStream.dataLength(3, getAccelerometer());
      }
      if (hasGyroscope()) {
        i1 += WriteStream.dataLength(4, getGyroscope());
      }
      if (hasMagnetometer()) {
        i1 += WriteStream.dataLength(5, getMagnetometer());
      }
      if (hasPressure()) {
        i1 += WriteStream.dataLength(6, getPressure());
      }
      if (hasProximity()) {
        i1 += WriteStream.dataLength(7, getProximity());
      }
      if (hasLight()) {
        i1 += WriteStream.dataLength(8, getLight());
      }
      if (hasTemperature()) {
        i1 += WriteStream.dataLength(9, getTemperature());
      }
      Iterator localIterator = getGpsSamplesList().iterator();
      int i2 = i1;
      for (;localIterator.hasNext();)
      {
    	  i2 += WriteStream.dataLength(10, (positioning_request.GPSSample)localIterator.next());    	  
      }
      
      if (hasWifiMeasurement()) {
    	  i2 += WriteStream.dataLength(11, getWifiMeasurement());
      }
      this.v = i2;
      return i2;
      
    }
    
    public positioning_request.EncodedOneValuedSignal getTemperature()
    {
      return this.r;
    }
    
    public long getTimeEnd()
    {
      return this.d;
    }
    
    public long getTimeStart()
    {
      return this.b;
    }
    
    public positioning_request.WifiMeasurement getWifiMeasurement()
    {
      return this.u;
    }
    
    public boolean hasAccelerometer()
    {
      return this.e;
    }
    
    public boolean hasGyroscope()
    {
      return this.g;
    }
    
    public boolean hasLight()
    {
      return this.o;
    }
    
    public boolean hasMagnetometer()
    {
      return this.i;
    }
    
    public boolean hasPressure()
    {
      return this.k;
    }
    
    public boolean hasProximity()
    {
      return this.m;
    }
    
    public boolean hasTemperature()
    {
      return this.q;
    }
    
    public boolean hasTimeEnd()
    {
      return this.c;
    }
    
    public boolean hasTimeStart()
    {
      return this.a;
    }
    
    public boolean hasWifiMeasurement()
    {
      return this.t;
    }
    
    public final boolean isInitialized()
    {
      return (!hasWifiMeasurement()) || (getWifiMeasurement().isInitialized());
    }
    
    public OnlineMeasurement mergeFrom(ReadStream paramReadStream)
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
          setTimeStart(paramReadStream.is1());
          break;
        case 16: 
          setTimeEnd(paramReadStream.is1());
          break;
        case 26: 
          positioning_request.EncodedThreeValuedSignal localEncodedThreeValuedSignal3 = new positioning_request.EncodedThreeValuedSignal();
          paramReadStream.getInstance(localEncodedThreeValuedSignal3);
          setAccelerometer(localEncodedThreeValuedSignal3);
          break;
        case 34: 
          positioning_request.EncodedThreeValuedSignal localEncodedThreeValuedSignal2 = new positioning_request.EncodedThreeValuedSignal();
          paramReadStream.getInstance(localEncodedThreeValuedSignal2);
          setGyroscope(localEncodedThreeValuedSignal2);
          break;
        case 42: 
          positioning_request.EncodedThreeValuedSignal localEncodedThreeValuedSignal1 = new positioning_request.EncodedThreeValuedSignal();
          paramReadStream.getInstance(localEncodedThreeValuedSignal1);
          setMagnetometer(localEncodedThreeValuedSignal1);
          break;
        case 50: 
          positioning_request.EncodedOneValuedSignal localEncodedOneValuedSignal4 = new positioning_request.EncodedOneValuedSignal();
          paramReadStream.getInstance(localEncodedOneValuedSignal4);
          setPressure(localEncodedOneValuedSignal4);
          break;
        case 58: 
          positioning_request.EncodedOneValuedSignal localEncodedOneValuedSignal3 = new positioning_request.EncodedOneValuedSignal();
          paramReadStream.getInstance(localEncodedOneValuedSignal3);
          setProximity(localEncodedOneValuedSignal3);
          break;
        case 66: 
          positioning_request.EncodedOneValuedSignal localEncodedOneValuedSignal2 = new positioning_request.EncodedOneValuedSignal();
          paramReadStream.getInstance(localEncodedOneValuedSignal2);
          setLight(localEncodedOneValuedSignal2);
          break;
        case 74: 
          positioning_request.EncodedOneValuedSignal localEncodedOneValuedSignal1 = new positioning_request.EncodedOneValuedSignal();
          paramReadStream.getInstance(localEncodedOneValuedSignal1);
          setTemperature(localEncodedOneValuedSignal1);
          break;
        case 82: 
          positioning_request.GPSSample localGPSSample = new positioning_request.GPSSample();
          paramReadStream.getInstance(localGPSSample);
          addGpsSamples(localGPSSample);
          break;
        case 90: // 'Z'
            positioning_request.WifiMeasurement localWifiMeasurement = new positioning_request.WifiMeasurement();
            paramReadStream.getInstance(localWifiMeasurement);
            setWifiMeasurement(localWifiMeasurement);
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
    
    public OnlineMeasurement setAccelerometer(positioning_request.EncodedThreeValuedSignal paramEncodedThreeValuedSignal)
    {
      if (paramEncodedThreeValuedSignal == null) {
        throw new NullPointerException();
      }
      this.e = true;
      this.f = paramEncodedThreeValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setGpsSamples(int paramInt, positioning_request.GPSSample paramGPSSample)
    {
      if (paramGPSSample == null) {
        throw new NullPointerException();
      }
      this.s.set(paramInt, paramGPSSample);
      return this;
    }
    
    public OnlineMeasurement setGyroscope(positioning_request.EncodedThreeValuedSignal paramEncodedThreeValuedSignal)
    {
      if (paramEncodedThreeValuedSignal == null) {
        throw new NullPointerException();
      }
      this.g = true;
      this.h = paramEncodedThreeValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setLight(positioning_request.EncodedOneValuedSignal paramEncodedOneValuedSignal)
    {
      if (paramEncodedOneValuedSignal == null) {
        throw new NullPointerException();
      }
      this.o = true;
      this.p = paramEncodedOneValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setMagnetometer(positioning_request.EncodedThreeValuedSignal paramEncodedThreeValuedSignal)
    {
      if (paramEncodedThreeValuedSignal == null) {
        throw new NullPointerException();
      }
      this.i = true;
      this.j = paramEncodedThreeValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setPressure(positioning_request.EncodedOneValuedSignal paramEncodedOneValuedSignal)
    {
      if (paramEncodedOneValuedSignal == null) {
        throw new NullPointerException();
      }
      this.k = true;
      this.l = paramEncodedOneValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setProximity(positioning_request.EncodedOneValuedSignal paramEncodedOneValuedSignal)
    {
      if (paramEncodedOneValuedSignal == null) {
        throw new NullPointerException();
      }
      this.m = true;
      this.n = paramEncodedOneValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setTemperature(positioning_request.EncodedOneValuedSignal paramEncodedOneValuedSignal)
    {
      if (paramEncodedOneValuedSignal == null) {
        throw new NullPointerException();
      }
      this.q = true;
      this.r = paramEncodedOneValuedSignal;
      return this;
    }
    
    public OnlineMeasurement setTimeEnd(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public OnlineMeasurement setTimeStart(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public OnlineMeasurement setWifiMeasurement(positioning_request.WifiMeasurement paramWifiMeasurement)
    {
      if (paramWifiMeasurement == null) {
        throw new NullPointerException();
      }
      this.t = true;
      this.u = paramWifiMeasurement;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      if (hasTimeStart()) {
        paramWriteStream.getInstance(1, getTimeStart());
      }
      if (hasTimeEnd()) {
        paramWriteStream.getInstance(2, getTimeEnd());
      }
      if (hasAccelerometer()) {
        paramWriteStream.getInstance(3, getAccelerometer());
      }
      if (hasGyroscope()) {
        paramWriteStream.getInstance(4, getGyroscope());
      }
      if (hasMagnetometer()) {
        paramWriteStream.getInstance(5, getMagnetometer());
      }
      if (hasPressure()) {
        paramWriteStream.getInstance(6, getPressure());
      }
      if (hasProximity()) {
        paramWriteStream.getInstance(7, getProximity());
      }
      if (hasLight()) {
        paramWriteStream.getInstance(8, getLight());
      }
      if (hasTemperature()) {
        paramWriteStream.getInstance(9, getTemperature());
      }
      Iterator localIterator = getGpsSamplesList().iterator();
      for (;localIterator.hasNext();)
      {
        paramWriteStream.getInstance(10, (positioning_request.GPSSample)localIterator.next());
      }
      
        if (hasWifiMeasurement()) {
          paramWriteStream.getInstance(11, getWifiMeasurement());
        }
        return;
      
    }
  }

    
    
    public static class PositioningInitialization
    extends CacheBase
  {
    public static final int CONSTRAINT_FIELD_NUMBER = 1;
    public static final int DEVICE_FIELD_NUMBER = 5;
    public static final int IDAUUID_FIELD_NUMBER = 4;
    public static final int PARAMETERS_FIELD_NUMBER = 2;
    public static final int STARTLOCATION_FIELD_NUMBER = 3;
    private List a = Collections.emptyList();
    private List b = Collections.emptyList();
    private List c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private boolean f;
    private positioning_request.Device g = null;
    private int h = -1;
    
    public static PositioningInitialization parseFrom(ReadStream paramReadStream)
    {
      return new PositioningInitialization().mergeFrom(paramReadStream);
    }
    
    public static PositioningInitialization parseFrom(byte[] paramArrayOfByte)
    {
      return (PositioningInitialization)new PositioningInitialization().mergeFrom(paramArrayOfByte);
    }
    
    public PositioningInitialization addConstraint(positioning_request.InitializationConstraint paramInitializationConstraint)
    {
      if (paramInitializationConstraint == null) {
        throw new NullPointerException();
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramInitializationConstraint);
      return this;
    }
    
    public PositioningInitialization addParameters(positioning_common.KeyValuePair paramKeyValuePair)
    {
      if (paramKeyValuePair == null) {
        throw new NullPointerException();
      }
      if (this.b.isEmpty()) {
        this.b = new ArrayList();
      }
      this.b.add(paramKeyValuePair);
      return this;
    }
    
    public PositioningInitialization addStartLocation(positioning_request.StartLocation paramStartLocation)
    {
      if (paramStartLocation == null) {
        throw new NullPointerException();
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramStartLocation);
      return this;
    }
    
    public final PositioningInitialization clear()
    {
      clearConstraint();
      clearParameters();
      clearStartLocation();
      clearIdaUUID();
      clearDevice();
      this.h = -1;
      return this;
    }
    
    public PositioningInitialization clearConstraint()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public PositioningInitialization clearDevice()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public PositioningInitialization clearIdaUUID()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public PositioningInitialization clearParameters()
    {
      this.b = Collections.emptyList();
      return this;
    }
    
    public PositioningInitialization clearStartLocation()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public positioning_request.InitializationConstraint getConstraint(int paramInt)
    {
      return (positioning_request.InitializationConstraint)this.a.get(paramInt);
    }
    
    public int getConstraintCount()
    {
      return this.a.size();
    }
    
    public List getConstraintList()
    {
      return this.a;
    }
    
    public positioning_request.Device getDevice()
    {
      return this.g;
    }
    
    public String getIdaUUID()
    {
      return this.e;
    }
    
    public positioning_common.KeyValuePair getParameters(int paramInt)
    {
      return (positioning_common.KeyValuePair)this.b.get(paramInt);
    }
    
    public int getParametersCount()
    {
      return this.b.size();
    }
    
    public List getParametersList()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator1 = getConstraintList().iterator();
      int i = 0;
      Iterator localIterator2;
      
      Iterator localIterator3;
      for(;localIterator1.hasNext();) {
    	  i += WriteStream.dataLength(1, (positioning_request.InitializationConstraint)localIterator1.next());
      }
      
      localIterator2 = getParametersList().iterator();
      for(;localIterator2.hasNext();) {
            i += WriteStream.dataLength(2, (positioning_common.KeyValuePair)localIterator2.next());
      }
      localIterator3 = getStartLocationList().iterator();
        
      for (;localIterator3.hasNext();)
      {
        i += WriteStream.dataLength(3, (positioning_request.StartLocation)localIterator3.next());
      }
      
    if (hasIdaUUID()) {
      i += WriteStream.dataLength(4, getIdaUUID());
    }
    if (hasDevice()) {
      i += WriteStream.dataLength(5, getDevice());
    }
    this.h = i;
    return i;
      
    }
    
    public positioning_request.StartLocation getStartLocation(int paramInt)
    {
      return (positioning_request.StartLocation)this.c.get(paramInt);
    }
    
    public int getStartLocationCount()
    {
      return this.c.size();
    }
    
    public List getStartLocationList()
    {
      return this.c;
    }
    
    public boolean hasDevice()
    {
      return this.f;
    }
    
    public boolean hasIdaUUID()
    {
      return this.d;
    }
    
    public final boolean isInitialized()
    {
        Iterator iterator;
        if(!d)
            return false;
        if(!f)
            return false;
        iterator = getConstraintList().iterator();
        Iterator iterator1;
        for(;iterator.hasNext();) {
            if(!((positioning_request.InitializationConstraint)iterator.next()).isInitialized()) {
            	return false;
            }
        }

        iterator1 = getParametersList().iterator();
        Iterator iterator2;
        for(;iterator1.hasNext();) {
            if(!((positioning_common.KeyValuePair)iterator1.next()).isInitialized()) {
                return false;
            }
        	
        }
        iterator2 = getStartLocationList().iterator();
        for(;iterator2.hasNext();) {
            if(!((positioning_request.StartLocation)iterator2.next()).isInitialized()) {
                    return false;
            }
        }
        return getDevice().isInitialized();
    }
    
    public PositioningInitialization mergeFrom(ReadStream paramReadStream)
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
          positioning_request.InitializationConstraint localInitializationConstraint = new positioning_request.InitializationConstraint();
          paramReadStream.getInstance(localInitializationConstraint);
          addConstraint(localInitializationConstraint);
          break;
        case 18: 
          positioning_common.KeyValuePair localKeyValuePair = new positioning_common.KeyValuePair();
          paramReadStream.getInstance(localKeyValuePair);
          addParameters(localKeyValuePair);
          break;
        case 26: 
          positioning_request.StartLocation localStartLocation = new positioning_request.StartLocation();
          paramReadStream.getInstance(localStartLocation);
          addStartLocation(localStartLocation);
          break;
        case 34: 
          setIdaUUID(paramReadStream.getStr());
          break;
        case 42: // '*'
            positioning_request.Device localDevice = new positioning_request.Device();
            paramReadStream.getInstance(localDevice);
            setDevice(localDevice);
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
    
    public PositioningInitialization setConstraint(int paramInt, positioning_request.InitializationConstraint paramInitializationConstraint)
    {
      if (paramInitializationConstraint == null) {
        throw new NullPointerException();
      }
      this.a.set(paramInt, paramInitializationConstraint);
      return this;
    }
    
    public PositioningInitialization setDevice(positioning_request.Device paramDevice)
    {
      if (paramDevice == null) {
        throw new NullPointerException();
      }
      this.f = true;
      this.g = paramDevice;
      return this;
    }
    
    public PositioningInitialization setIdaUUID(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public PositioningInitialization setParameters(int paramInt, positioning_common.KeyValuePair paramKeyValuePair)
    {
      if (paramKeyValuePair == null) {
        throw new NullPointerException();
      }
      this.b.set(paramInt, paramKeyValuePair);
      return this;
    }
    
    public PositioningInitialization setStartLocation(int paramInt, positioning_request.StartLocation paramStartLocation)
    {
      if (paramStartLocation == null) {
        throw new NullPointerException();
      }
      this.c.set(paramInt, paramStartLocation);
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
    	try {
      Iterator localIterator1 = getConstraintList().iterator();
      Iterator localIterator2;
      Iterator localIterator3;
      for(;localIterator1.hasNext();) {
    	  paramWriteStream.getInstance(1, (positioning_request.InitializationConstraint)localIterator1.next());
      }
    localIterator2 = getParametersList().iterator();
    
    for(;localIterator2.hasNext();) {
        paramWriteStream.getInstance(2, (positioning_common.KeyValuePair)localIterator2.next());
    }
    localIterator3 = getStartLocationList().iterator();
    
      for (;localIterator3.hasNext();)
      {
        paramWriteStream.getInstance(3, (positioning_request.StartLocation)localIterator3.next());
      }
      
        if (hasIdaUUID()) {
          paramWriteStream.getInstance(4, getIdaUUID());
        }
        if (hasDevice()) {
          paramWriteStream.getInstance(5, getDevice());
        }
        } catch(ExceptionManager mng) {
        	  mng.printStackTrace();
          } catch(Exception ex) {
        	  ex.printStackTrace();
          }
        
        return;
    }
  }


    
    
    
    public static class PositioningRequest
    extends CacheBase
  {
    public static final int CALIBRATIONDATA_FIELD_NUMBER = 4;
    public static final int CALIBRATION_DATA = 3;
    public static final int GIVENPOSITION_FIELD_NUMBER = 5;
    public static final int GIVEN_POSITION = 4;
    public static final int POSITIONINGINIT_FIELD_NUMBER = 2;
    public static final int POSITIONING_INITIALIZATION = 1;
    public static final int SENSORDATA_FIELD_NUMBER = 3;
    public static final int SENSOR_DATA = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 1;
    private boolean c;
    private positioning_request.PositioningInitialization d = null;
    private boolean e;
    private positioning_request.SensorData f = null;
    private boolean g;
    private positioning_request.CalibrationData h = null;
    private List i = Collections.emptyList();
    private int j = -1;
    
    public static PositioningRequest parseFrom(ReadStream paramReadStream)
    {
      return new PositioningRequest().mergeFrom(paramReadStream);
    }
    
    public static PositioningRequest parseFrom(byte[] paramArrayOfByte)
    {
      return (PositioningRequest)new PositioningRequest().mergeFrom(paramArrayOfByte);
    }
    
    public PositioningRequest addGivenPosition(positioning_request.GivenPosition paramGivenPosition)
    {
      if (paramGivenPosition == null) {
        throw new NullPointerException();
      }
      if (this.i.isEmpty()) {
        this.i = new ArrayList();
      }
      this.i.add(paramGivenPosition);
      return this;
    }
    
    public final PositioningRequest clear()
    {
      clearType();
      clearPositioningInit();
      clearSensorData();
      clearCalibrationData();
      clearGivenPosition();
      this.j = -1;
      return this;
    }
    
    public PositioningRequest clearCalibrationData()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public PositioningRequest clearGivenPosition()
    {
      this.i = Collections.emptyList();
      return this;
    }
    
    public PositioningRequest clearPositioningInit()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public PositioningRequest clearSensorData()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public PositioningRequest clearType()
    {
      this.a = false;
      this.b = 1;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.j < 0) {
        getSerializedSize();
      }
      return this.j;
    }
    
    public positioning_request.CalibrationData getCalibrationData()
    {
      return this.h;
    }
    
    public positioning_request.GivenPosition getGivenPosition(int paramInt)
    {
      return (positioning_request.GivenPosition)this.i.get(paramInt);
    }
    
    public int getGivenPositionCount()
    {
      return this.i.size();
    }
    
    public List getGivenPositionList()
    {
      return this.i;
    }
    
    public positioning_request.PositioningInitialization getPositioningInit()
    {
      return this.d;
    }
    
    public positioning_request.SensorData getSensorData()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      boolean bool = hasType();
      int k = 0;
      if (bool) {
        k = 0 + WriteStream.bindLength2(1, getType());
      }
      if (hasPositioningInit()) {
        k += WriteStream.dataLength(2, getPositioningInit());
      }
      if (hasSensorData()) {
        k += WriteStream.dataLength(3, getSensorData());
      }
      if (hasCalibrationData()) {
        k += WriteStream.dataLength(4, getCalibrationData());
      }
      Iterator localIterator = getGivenPositionList().iterator();
      int m = k;
      for (;localIterator.hasNext();)
      {
        m += WriteStream.dataLength(5, (positioning_request.GivenPosition)localIterator.next());
      }
        this.j = m;
        return m;
        
    }
    
    public int getType()
    {
      return this.b;
    }
    
    public boolean hasCalibrationData()
    {
      return this.g;
    }
    
    public boolean hasPositioningInit()
    {
      return this.c;
    }
    
    public boolean hasSensorData()
    {
      return this.e;
    }
    
    public boolean hasType()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {
        return false;
      }
      if ((hasPositioningInit()) && (!getPositioningInit().isInitialized())) {
        return false;
      }
      if ((hasSensorData()) && (!getSensorData().isInitialized())) {
        return false;
      }
      if ((hasCalibrationData()) && (!getCalibrationData().isInitialized())) {
        return false;
      }
      Iterator localIterator = getGivenPositionList().iterator();
      for (;localIterator.hasNext();) {
    	  if(!((positioning_request.GivenPosition)localIterator.next()).isInitialized()) {
    		  return false;
    	  }
      }
      
      return true;
    }
    
    public PositioningRequest mergeFrom(ReadStream paramReadStream)
    {
    	try {
      for (;;)
      {
        int k = paramReadStream.getInstance();
        switch (k)
        {
        default: 
          if (parseUnknownField(paramReadStream, k)) {
            continue;
          }
        case 0: 
          return this;
        case 8: 
          setType(paramReadStream.getMBytes());
          break;
        case 18: 
          positioning_request.PositioningInitialization localPositioningInitialization = new positioning_request.PositioningInitialization();
          paramReadStream.getInstance(localPositioningInitialization);
          setPositioningInit(localPositioningInitialization);
          break;
        case 26: 
          positioning_request.SensorData localSensorData = new positioning_request.SensorData();
          paramReadStream.getInstance(localSensorData);
          setSensorData(localSensorData);
          break;
        case 34: 
          positioning_request.CalibrationData localCalibrationData = new positioning_request.CalibrationData();
          paramReadStream.getInstance(localCalibrationData);
          setCalibrationData(localCalibrationData);
          break;
        case 42: // '*'
            positioning_request.GivenPosition localGivenPosition = new positioning_request.GivenPosition();
            paramReadStream.getInstance(localGivenPosition);
            addGivenPosition(localGivenPosition);
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
    
    public PositioningRequest setCalibrationData(positioning_request.CalibrationData paramCalibrationData)
    {
      if (paramCalibrationData == null) {
        throw new NullPointerException();
      }
      this.g = true;
      this.h = paramCalibrationData;
      return this;
    }
    
    public PositioningRequest setGivenPosition(int paramInt, positioning_request.GivenPosition paramGivenPosition)
    {
      if (paramGivenPosition == null) {
        throw new NullPointerException();
      }
      this.i.set(paramInt, paramGivenPosition);
      return this;
    }
    
    public PositioningRequest setPositioningInit(positioning_request.PositioningInitialization paramPositioningInitialization)
    {
      if (paramPositioningInitialization == null) {
        throw new NullPointerException();
      }
      this.c = true;
      this.d = paramPositioningInitialization;
      return this;
    }
    
    public PositioningRequest setSensorData(positioning_request.SensorData paramSensorData)
    {
      if (paramSensorData == null) {
        throw new NullPointerException();
      }
      this.e = true;
      this.f = paramSensorData;
      return this;
    }
    
    public PositioningRequest setType(int paramInt)
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
      if (hasPositioningInit()) {
        paramWriteStream.getInstance(2, getPositioningInit());
      }
      if (hasSensorData()) {
        paramWriteStream.getInstance(3, getSensorData());
      }
      if (hasCalibrationData()) {
        paramWriteStream.getInstance(4, getCalibrationData());
      }
      Iterator localIterator = getGivenPositionList().iterator();
      for (;localIterator.hasNext();)
      {
        paramWriteStream.getInstance(5, (positioning_request.GivenPosition)localIterator.next());
      }
      
    }
  }


    
    

public static class SensorData
  extends CacheBase
{
  public static final int ENCODEDSENSORDATA_FIELD_NUMBER = 1;
  public static final int SESSIONUPDATENUMBER_FIELD_NUMBER = 2;
  private boolean a;
  private positioning_request.OnlineMeasurement b = null;
  private boolean c;
  private int d = 0;
  private int e = -1;
  
  public static SensorData parseFrom(ReadStream paramReadStream)
  {
    return new SensorData().mergeFrom(paramReadStream);
  }
  
  public static SensorData parseFrom(byte[] paramArrayOfByte)
  {
    return (SensorData)new SensorData().mergeFrom(paramArrayOfByte);
  }
  
  public final SensorData clear()
  {
    clearEncodedSensorData();
    clearSessionUpdateNumber();
    this.e = -1;
    return this;
  }
  
  public SensorData clearEncodedSensorData()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public SensorData clearSessionUpdateNumber()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public positioning_request.OnlineMeasurement getEncodedSensorData()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasEncodedSensorData();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getEncodedSensorData());
    }
    if (hasSessionUpdateNumber()) {
      i += WriteStream.bindLength3(2, getSessionUpdateNumber());
    }
    this.e = i;
    return i;
  }
  
  public int getSessionUpdateNumber()
  {
    return this.d;
  }
  
  public boolean hasEncodedSensorData()
  {
    return this.a;
  }
  
  public boolean hasSessionUpdateNumber()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    if (!this.c) {}
    while ((hasEncodedSensorData()) && (!getEncodedSensorData().isInitialized())) {
      return false;
    }
    return true;
  }
  
  public SensorData mergeFrom(ReadStream paramReadStream)
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
        positioning_request.OnlineMeasurement localOnlineMeasurement = new positioning_request.OnlineMeasurement();
        paramReadStream.getInstance(localOnlineMeasurement);
        setEncodedSensorData(localOnlineMeasurement);
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
  
  public SensorData setEncodedSensorData(positioning_request.OnlineMeasurement paramOnlineMeasurement)
  {
    if (paramOnlineMeasurement == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramOnlineMeasurement;
    return this;
  }
  
  public SensorData setSessionUpdateNumber(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasEncodedSensorData()) {
      paramWriteStream.getInstance(1, getEncodedSensorData());
    }
    if (hasSessionUpdateNumber()) {
      paramWriteStream.dataLength(2, getSessionUpdateNumber());
    }
  }
}




public static class StartLocation
extends CacheBase
{
public static final int GIVENPOSITION_FIELD_NUMBER = 1;
public static final int TIMESTAMP_FIELD_NUMBER = 2;
private boolean a;
private positioning_request.GivenPosition b = null;
private boolean c;
private long d = 0L;
private int e = -1;

public static StartLocation parseFrom(ReadStream paramReadStream)
{
  return new StartLocation().mergeFrom(paramReadStream);
}

public static StartLocation parseFrom(byte[] paramArrayOfByte)
{
  return (StartLocation)new StartLocation().mergeFrom(paramArrayOfByte);
}

public final StartLocation clear()
{
  clearGivenPosition();
  clearTimestamp();
  this.e = -1;
  return this;
}

public StartLocation clearGivenPosition()
{
  this.a = false;
  this.b = null;
  return this;
}

public StartLocation clearTimestamp()
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

public positioning_request.GivenPosition getGivenPosition()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasGivenPosition();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getGivenPosition());
  }
  if (hasTimestamp()) {
    i += WriteStream.bindLength(2, getTimestamp());
  }
  this.e = i;
  return i;
}

public long getTimestamp()
{
  return this.d;
}

public boolean hasGivenPosition()
{
  return this.a;
}

public boolean hasTimestamp()
{
  return this.c;
}

public final boolean isInitialized()
{
  if (!this.a) {}
  while (!getGivenPosition().isInitialized()) {
    return false;
  }
  return true;
}

public StartLocation mergeFrom(ReadStream paramReadStream)
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
      positioning_request.GivenPosition localGivenPosition = new positioning_request.GivenPosition();
      paramReadStream.getInstance(localGivenPosition);
      setGivenPosition(localGivenPosition);
      break;
    case 16: // '\020'
        setTimestamp(paramReadStream.is1());
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

public StartLocation setGivenPosition(positioning_request.GivenPosition paramGivenPosition)
{
  if (paramGivenPosition == null) {
    throw new NullPointerException();
  }
  this.a = true;
  this.b = paramGivenPosition;
  return this;
}

public StartLocation setTimestamp(long paramLong)
{
  this.c = true;
  this.d = paramLong;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasGivenPosition()) {
    paramWriteStream.getInstance(1, getGivenPosition());
  }
  if (hasTimestamp()) {
    paramWriteStream.getInstance(2, getTimestamp());
  }
}
}




public static class WifiAP
extends CacheBase
{
public static final int BSSID_FIELD_NUMBER = 2;
public static final int ID_FIELD_NUMBER = 1;
public static final int SSID_FIELD_NUMBER = 3;
private boolean a;
private positioning_common.UUID b = null;
private boolean c;
private long d = 0L;
private boolean e;
private String f = "";
private int g = -1;

public static WifiAP parseFrom(ReadStream paramReadStream)
{
  return new WifiAP().mergeFrom(paramReadStream);
}

public static WifiAP parseFrom(byte[] paramArrayOfByte)
{
  return (WifiAP)new WifiAP().mergeFrom(paramArrayOfByte);
}

public final WifiAP clear()
{
  clearId();
  clearBssid();
  clearSsid();
  this.g = -1;
  return this;
}

public WifiAP clearBssid()
{
  this.c = false;
  this.d = 0L;
  return this;
}

public WifiAP clearId()
{
  this.a = false;
  this.b = null;
  return this;
}

public WifiAP clearSsid()
{
  this.e = false;
  this.f = "";
  return this;
}

public long getBssid()
{
  return this.d;
}

public int getCachedSize()
{
  if (this.g < 0) {
    getSerializedSize();
  }
  return this.g;
}

public positioning_common.UUID getId()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasId();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getId());
  }
  if (hasBssid()) {
    i += WriteStream.bindLength(2, getBssid());
  }
  if (hasSsid()) {
    i += WriteStream.dataLength(3, getSsid());
  }
  this.g = i;
  return i;
}

public String getSsid()
{
  return this.f;
}

public boolean hasBssid()
{
  return this.c;
}

public boolean hasId()
{
  return this.a;
}

public boolean hasSsid()
{
  return this.e;
}

public final boolean isInitialized()
{
  return (!hasId()) || (getId().isInitialized());
}

public WifiAP mergeFrom(ReadStream paramReadStream)
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
      setId(localUUID);
      break;
    case 16: 
      setBssid(paramReadStream.is1());
      break;
    case 26: // '\032'
        setSsid(paramReadStream.getStr());
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

public WifiAP setBssid(long paramLong)
{
  this.c = true;
  this.d = paramLong;
  return this;
}

public WifiAP setId(positioning_common.UUID paramUUID)
{
  if (paramUUID == null) {
    throw new NullPointerException();
  }
  this.a = true;
  this.b = paramUUID;
  return this;
}

public WifiAP setSsid(String paramString)
{
  this.e = true;
  this.f = paramString;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  try {
	if (hasId()) {
    paramWriteStream.getInstance(1, getId());
  }
  if (hasBssid()) {
    paramWriteStream.getInstance(2, getBssid());
  }
  if (hasSsid()) {
    paramWriteStream.getInstance(3, getSsid());
  }
  } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }

}
}





public static class WifiMeasurement
extends CacheBase
{
public static final int APLIST_FIELD_NUMBER = 2;
public static final int WIFISCANLIST_FIELD_NUMBER = 1;
private List a = Collections.emptyList();
private List b = Collections.emptyList();
private int c = -1;

public static WifiMeasurement parseFrom(ReadStream paramReadStream)
{
  return new WifiMeasurement().mergeFrom(paramReadStream);
}

public static WifiMeasurement parseFrom(byte[] paramArrayOfByte)
{
  return (WifiMeasurement)new WifiMeasurement().mergeFrom(paramArrayOfByte);
}

public WifiMeasurement addApList(positioning_request.WifiAP paramWifiAP)
{
  if (paramWifiAP == null) {
    throw new NullPointerException();
  }
  if (this.b.isEmpty()) {
    this.b = new ArrayList();
  }
  this.b.add(paramWifiAP);
  return this;
}

public WifiMeasurement addWifiScanList(positioning_request.WifiScan paramWifiScan)
{
  if (paramWifiScan == null) {
    throw new NullPointerException();
  }
  if (this.a.isEmpty()) {
    this.a = new ArrayList();
  }
  this.a.add(paramWifiScan);
  return this;
}

public final WifiMeasurement clear()
{
  clearWifiScanList();
  clearApList();
  this.c = -1;
  return this;
}

public WifiMeasurement clearApList()
{
  this.b = Collections.emptyList();
  return this;
}

public WifiMeasurement clearWifiScanList()
{
  this.a = Collections.emptyList();
  return this;
}

public positioning_request.WifiAP getApList(int paramInt)
{
  return (positioning_request.WifiAP)this.b.get(paramInt);
}

public int getApListCount()
{
  return this.b.size();
}

public List getApListList()
{
  return this.b;
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
  Iterator localIterator1 = getWifiScanListList().iterator();
  int i = 0;
  Iterator localIterator2;
  for (;localIterator1.hasNext();) {
	  i += WriteStream.dataLength(1, (positioning_request.WifiScan)localIterator1.next());
  }

  localIterator2 = getApListList().iterator();
 
  for (;localIterator2.hasNext();)
  {
    i += WriteStream.dataLength(2, (positioning_request.WifiAP)localIterator2.next());
  }
    this.c = i;
    return i;
  
}

public positioning_request.WifiScan getWifiScanList(int paramInt)
{
  return (positioning_request.WifiScan)this.a.get(paramInt);
}

public int getWifiScanListCount()
{
  return this.a.size();
}

public List getWifiScanListList()
{
  return this.a;
}

public final boolean isInitialized()
{
  Iterator localIterator1 = getWifiScanListList().iterator();
  Iterator localIterator2;
  for (;localIterator1.hasNext();) {
    if (!((positioning_request.WifiScan)localIterator1.next()).isInitialized()) {
        return false;
      }
  }
  localIterator2 = getApListList().iterator();
    for (;localIterator2.hasNext();)
    {
      if (!((positioning_request.WifiAP)localIterator2.next()).isInitialized()) {
          return false;
      }
    }
  return true;
}

public WifiMeasurement mergeFrom(ReadStream paramReadStream)
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
      positioning_request.WifiScan localWifiScan = new positioning_request.WifiScan();
      paramReadStream.getInstance(localWifiScan);
      addWifiScanList(localWifiScan);
      break;
    case 18: // '\022'
        positioning_request.WifiAP localWifiAP = new positioning_request.WifiAP();
        paramReadStream.getInstance(localWifiAP);
        addApList(localWifiAP);
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

public WifiMeasurement setApList(int paramInt, positioning_request.WifiAP paramWifiAP)
{
  if (paramWifiAP == null) {
    throw new NullPointerException();
  }
  this.b.set(paramInt, paramWifiAP);
  return this;
}

public WifiMeasurement setWifiScanList(int paramInt, positioning_request.WifiScan paramWifiScan)
{
  if (paramWifiScan == null) {
    throw new NullPointerException();
  }
  this.a.set(paramInt, paramWifiScan);
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  Iterator localIterator1 = getWifiScanListList().iterator();
  Iterator localIterator2;
  for (;localIterator1.hasNext();) {
    paramWriteStream.getInstance(1, (positioning_request.WifiScan)localIterator1.next());
    
  }
  localIterator2 = getApListList().iterator();
  for (;localIterator2.hasNext();)
  {
    paramWriteStream.getInstance(2, (positioning_request.WifiAP)localIterator2.next());
  }
  
}
}




public static class WifiScan
extends CacheBase
{
public static final int SCAN_FIELD_NUMBER = 2;
public static final int TIMESTAMP_FIELD_NUMBER = 1;
private boolean a;
private long b = 0L;
private List c = Collections.emptyList();
private int d = -1;

public static WifiScan parseFrom(ReadStream paramReadStream)
{
  return new WifiScan().mergeFrom(paramReadStream);
}

public static WifiScan parseFrom(byte[] paramArrayOfByte)
{
  return (WifiScan)new WifiScan().mergeFrom(paramArrayOfByte);
}

public WifiScan addScan(positioning_request.WifiScanEntry paramWifiScanEntry)
{
  if (paramWifiScanEntry == null) {
    throw new NullPointerException();
  }
  if (this.c.isEmpty()) {
    this.c = new ArrayList();
  }
  this.c.add(paramWifiScanEntry);
  return this;
}

public final WifiScan clear()
{
  clearTimestamp();
  clearScan();
  this.d = -1;
  return this;
}

public WifiScan clearScan()
{
  this.c = Collections.emptyList();
  return this;
}

public WifiScan clearTimestamp()
{
  this.a = false;
  this.b = 0L;
  return this;
}

public int getCachedSize()
{
  if (this.d < 0) {
    getSerializedSize();
  }
  return this.d;
}

public positioning_request.WifiScanEntry getScan(int paramInt)
{
  return (positioning_request.WifiScanEntry)this.c.get(paramInt);
}

public int getScanCount()
{
  return this.c.size();
}

public List getScanList()
{
  return this.c;
}

public int getSerializedSize()
{
  boolean bool = hasTimestamp();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.bindLength(1, getTimestamp());
  }
  Iterator localIterator = getScanList().iterator();
  int j = i;
  for (;localIterator.hasNext();)
  {
    j += WriteStream.dataLength(2, (positioning_request.WifiScanEntry)localIterator.next());
  }
  
  this.d = j;
  return j;
  
}

public long getTimestamp()
{
  return this.b;
}

public boolean hasTimestamp()
{
  return this.a;
}

public final boolean isInitialized()
{
  Iterator localIterator = getScanList().iterator();
  do
  {
    if (!localIterator.hasNext()) {
      return true;
    }
  } while (((positioning_request.WifiScanEntry)localIterator.next()).isInitialized());
  return false;
}

public WifiScan mergeFrom(ReadStream paramReadStream)
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
      setTimestamp(paramReadStream.is1());
      break;
    case 18: // '\022'
        positioning_request.WifiScanEntry localWifiScanEntry = new positioning_request.WifiScanEntry();
        paramReadStream.getInstance(localWifiScanEntry);
        addScan(localWifiScanEntry);
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

public WifiScan setScan(int paramInt, positioning_request.WifiScanEntry paramWifiScanEntry)
{
  if (paramWifiScanEntry == null) {
    throw new NullPointerException();
  }
  this.c.set(paramInt, paramWifiScanEntry);
  return this;
}

public WifiScan setTimestamp(long paramLong)
{
  this.a = true;
  this.b = paramLong;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasTimestamp()) {
    paramWriteStream.getInstance(1, getTimestamp());
  }
  Iterator localIterator = getScanList().iterator();
  for (;localIterator.hasNext();)
  {
    paramWriteStream.getInstance(2, (positioning_request.WifiScanEntry)localIterator.next());
  }
  
}
}



public static class WifiScanEntry
extends CacheBase
{
public static final int ACCESSPOINTID_FIELD_NUMBER = 3;
public static final int ACCESSPOINTNUM_FIELD_NUMBER = 2;
public static final int SIGNALSTRENGTH_FIELD_NUMBER = 1;
private boolean a;
private float b = 0.0F;
private boolean c;
private int d = 0;
private boolean e;
private positioning_common.UUID f = null;
private int g = -1;

public static WifiScanEntry parseFrom(ReadStream paramReadStream)
{
  return new WifiScanEntry().mergeFrom(paramReadStream);
}

public static WifiScanEntry parseFrom(byte[] paramArrayOfByte)
{
  return (WifiScanEntry)new WifiScanEntry().mergeFrom(paramArrayOfByte);
}

public final WifiScanEntry clear()
{
  clearSignalStrength();
  clearAccessPointNum();
  clearAccessPointId();
  this.g = -1;
  return this;
}

public WifiScanEntry clearAccessPointId()
{
  this.e = false;
  this.f = null;
  return this;
}

public WifiScanEntry clearAccessPointNum()
{
  this.c = false;
  this.d = 0;
  return this;
}

public WifiScanEntry clearSignalStrength()
{
  this.a = false;
  this.b = 0.0F;
  return this;
}

public positioning_common.UUID getAccessPointId()
{
  return this.f;
}

public int getAccessPointNum()
{
  return this.d;
}

public int getCachedSize()
{
  if (this.g < 0) {
    getSerializedSize();
  }
  return this.g;
}

public int getSerializedSize()
{
  boolean bool = hasSignalStrength();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getSignalStrength());
  }
  if (hasAccessPointNum()) {
    i += WriteStream.bindLength3(2, getAccessPointNum());
  }
  if (hasAccessPointId()) {
    i += WriteStream.dataLength(3, getAccessPointId());
  }
  this.g = i;
  return i;
}

public float getSignalStrength()
{
  return this.b;
}

public boolean hasAccessPointId()
{
  return this.e;
}

public boolean hasAccessPointNum()
{
  return this.c;
}

public boolean hasSignalStrength()
{
  return this.a;
}

public final boolean isInitialized()
{
  return (!hasAccessPointId()) || (getAccessPointId().isInitialized());
}

public WifiScanEntry mergeFrom(ReadStream paramReadStream)
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
    case 13: 
      setSignalStrength(paramReadStream.checkResult());
      break;
    case 16: 
      setAccessPointNum(paramReadStream.calc3());
      break;
    case 26: // '\032'
        positioning_common.UUID localUUID = new positioning_common.UUID();
        paramReadStream.getInstance(localUUID);
        setAccessPointId(localUUID);
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

public WifiScanEntry setAccessPointId(positioning_common.UUID paramUUID)
{
  if (paramUUID == null) {
    throw new NullPointerException();
  }
  this.e = true;
  this.f = paramUUID;
  return this;
}

public WifiScanEntry setAccessPointNum(int paramInt)
{
  this.c = true;
  this.d = paramInt;
  return this;
}

public WifiScanEntry setSignalStrength(float paramFloat)
{
  this.a = true;
  this.b = paramFloat;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasSignalStrength()) {
    paramWriteStream.getInstance(1, getSignalStrength());
  }
  if (hasAccessPointNum()) {
    paramWriteStream.dataLength(2, getAccessPointNum());
  }
  if (hasAccessPointId()) {
    paramWriteStream.getInstance(3, getAccessPointId());
  }
}
}



    
    
    
}
