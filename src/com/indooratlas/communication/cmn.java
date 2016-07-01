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

public final class cmn
{

    private cmn()
    {
    }
    
    public static class AccSample
    extends CacheBase
  {
    public static final int ACC_TIMESTAMP_FIELD_NUMBER = 1;
    public static final int ACC_X_FIELD_NUMBER = 2;
    public static final int ACC_Y_FIELD_NUMBER = 3;
    public static final int ACC_Z_FIELD_NUMBER = 4;
    private boolean a;
    private long b = 0L;
    private boolean c;
    private float d = 0.0F;
    private boolean e;
    private float f = 0.0F;
    private boolean g;
    private float h = 0.0F;
    private int i = -1;
    
    public static AccSample parseFrom(ReadStream paramReadStream)
    {
      return new AccSample().mergeFrom(paramReadStream);
    }
    
    public static AccSample parseFrom(byte[] paramArrayOfByte)
    {
      return (AccSample)new AccSample().mergeFrom(paramArrayOfByte);
    }
    
    public final AccSample clear()
    {
      clearAccTimestamp();
      clearAccX();
      clearAccY();
      clearAccZ();
      this.i = -1;
      return this;
    }
    
    public AccSample clearAccTimestamp()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public AccSample clearAccX()
    {
      this.c = false;
      this.d = 0.0F;
      return this;
    }
    
    public AccSample clearAccY()
    {
      this.e = false;
      this.f = 0.0F;
      return this;
    }
    
    public AccSample clearAccZ()
    {
      this.g = false;
      this.h = 0.0F;
      return this;
    }
    
    public long getAccTimestamp()
    {
      return this.b;
    }
    
    public float getAccX()
    {
      return this.d;
    }
    
    public float getAccY()
    {
      return this.f;
    }
    
    public float getAccZ()
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
      boolean bool = hasAccTimestamp();
      int j = 0;
      if (bool) {
        j = 0 + WriteStream.bindLength(1, getAccTimestamp());
      }
      if (hasAccX()) {
        j += WriteStream.dataLength(2, getAccX());
      }
      if (hasAccY()) {
        j += WriteStream.dataLength(3, getAccY());
      }
      if (hasAccZ()) {
        j += WriteStream.dataLength(4, getAccZ());
      }
      this.i = j;
      return j;
    }
    
    public boolean hasAccTimestamp()
    {
      return this.a;
    }
    
    public boolean hasAccX()
    {
      return this.c;
    }
    
    public boolean hasAccY()
    {
      return this.e;
    }
    
    public boolean hasAccZ()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AccSample mergeFrom(ReadStream paramReadStream)
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
          setAccTimestamp(paramReadStream.is1());
          break;
        case 21: 
          setAccX(paramReadStream.checkResult());
          break;
        case 29: 
          setAccY(paramReadStream.checkResult());
          break;
        case 37: // '%'
            setAccZ(paramReadStream.checkResult());
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
    
    public AccSample setAccTimestamp(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public AccSample setAccX(float paramFloat)
    {
      this.c = true;
      this.d = paramFloat;
      return this;
    }
    
    public AccSample setAccY(float paramFloat)
    {
      this.e = true;
      this.f = paramFloat;
      return this;
    }
    
    public AccSample setAccZ(float paramFloat)
    {
      this.g = true;
      this.h = paramFloat;
      return this;
    }
    
    public void writeTo(WriteStream paramWriteStream)
    {
      if (hasAccTimestamp()) {
        paramWriteStream.getInstance(1, getAccTimestamp());
      }
      if (hasAccX()) {
        paramWriteStream.getInstance(2, getAccX());
      }
      if (hasAccY()) {
        paramWriteStream.getInstance(3, getAccY());
      }
      if (hasAccZ()) {
        paramWriteStream.getInstance(4, getAccZ());
      }
    }
  }

    


public static class Building
  extends CacheBase
{
  public static final int ADDRESS_FIELD_NUMBER = 5;
  public static final int DESCRIPTION_FIELD_NUMBER = 6;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int ISPRIVATE_FIELD_NUMBER = 8;
  public static final int LEVELS_URL_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 4;
  public static final int POSITION_FIELD_NUMBER = 7;
  public static final int URL_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private String h = "";
  private boolean i;
  private String j = "";
  private boolean k;
  private String l = "";
  private boolean m;
  private cmn.GeoPosition n = null;
  private boolean o;
  private boolean p = false;
  private int q = -1;
  
  public static Building parseFrom(ReadStream paramReadStream)
  {
    return new Building().mergeFrom(paramReadStream);
  }
  
  public static Building parseFrom(byte[] paramArrayOfByte)
  {
    return (Building)new Building().mergeFrom(paramArrayOfByte);
  }
  
  public final Building clear()
  {
    clearId();
    clearUrl();
    clearLevelsUrl();
    clearName();
    clearAddress();
    clearDescription();
    clearPosition();
    clearIsPrivate();
    this.q = -1;
    return this;
  }
  
  public Building clearAddress()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public Building clearDescription()
  {
    this.k = false;
    this.l = "";
    return this;
  }
  
  public Building clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Building clearIsPrivate()
  {
    this.o = false;
    this.p = false;
    return this;
  }
  
  public Building clearLevelsUrl()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public Building clearName()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public Building clearPosition()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public Building clearUrl()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public String getAddress()
  {
    return this.j;
  }
  
  public int getCachedSize()
  {
    if (this.q < 0) {
      getSerializedSize();
    }
    return this.q;
  }
  
  public String getDescription()
  {
    return this.l;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public boolean getIsPrivate()
  {
    return this.p;
  }
  
  public String getLevelsUrl()
  {
    return this.f;
  }
  
  public String getName()
  {
    return this.h;
  }
  
  public cmn.GeoPosition getPosition()
  {
    return this.n;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasId();
    int i1 = 0;
    if (bool) {
      i1 = 0 + WriteStream.dataLength(1, getId());
    }
    if (hasUrl()) {
      i1 += WriteStream.dataLength(2, getUrl());
    }
    if (hasLevelsUrl()) {
      i1 += WriteStream.dataLength(3, getLevelsUrl());
    }
    if (hasName()) {
      i1 += WriteStream.dataLength(4, getName());
    }
    if (hasAddress()) {
      i1 += WriteStream.dataLength(5, getAddress());
    }
    if (hasDescription()) {
      i1 += WriteStream.dataLength(6, getDescription());
    }
    if (hasPosition()) {
      i1 += WriteStream.dataLength(7, getPosition());
    }
    if (hasIsPrivate()) {
      i1 += WriteStream.dataLength(8, getIsPrivate());
    }
    this.q = i1;
    return i1;
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public boolean hasAddress()
  {
    return this.i;
  }
  
  public boolean hasDescription()
  {
    return this.k;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasIsPrivate()
  {
    return this.o;
  }
  
  public boolean hasLevelsUrl()
  {
    return this.e;
  }
  
  public boolean hasName()
  {
    return this.g;
  }
  
  public boolean hasPosition()
  {
    return this.m;
  }
  
  public boolean hasUrl()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Building mergeFrom(ReadStream paramReadStream)
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
      case 10: 
        setId(paramReadStream.getStr());
        break;
      case 18: 
        setUrl(paramReadStream.getStr());
        break;
      case 26: 
        setLevelsUrl(paramReadStream.getStr());
        break;
      case 34: 
        setName(paramReadStream.getStr());
        break;
      case 42: 
        setAddress(paramReadStream.getStr());
        break;
      case 50: 
        setDescription(paramReadStream.getStr());
        break;
      case 58: 
        cmn.GeoPosition localGeoPosition = new cmn.GeoPosition();
        paramReadStream.getInstance(localGeoPosition);
        setPosition(localGeoPosition);
        break;
      case 64: // '@'
          setIsPrivate(paramReadStream.calc2());
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
  
  public Building setAddress(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public Building setDescription(String paramString)
  {
    this.k = true;
    this.l = paramString;
    return this;
  }
  
  public Building setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Building setIsPrivate(boolean paramBoolean)
  {
    this.o = true;
    this.p = paramBoolean;
    return this;
  }
  
  public Building setLevelsUrl(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public Building setName(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public Building setPosition(cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramGeoPosition;
    return this;
  }
  
  public Building setUrl(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
	  try {
    if (hasId()) {
      paramWriteStream.getInstance(1, getId());
    }
    if (hasUrl()) {
      paramWriteStream.getInstance(2, getUrl());
    }
    if (hasLevelsUrl()) {
      paramWriteStream.getInstance(3, getLevelsUrl());
    }
    if (hasName()) {
      paramWriteStream.getInstance(4, getName());
    }
    if (hasAddress()) {
      paramWriteStream.getInstance(5, getAddress());
    }
    if (hasDescription()) {
      paramWriteStream.getInstance(6, getDescription());
    }
    if (hasPosition()) {
      paramWriteStream.getInstance(7, getPosition());
    }
    if (hasIsPrivate()) {
      paramWriteStream.getInstance(8, getIsPrivate());
    }
  } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }
    
  }
}




public static class EncodedOneValuedSignal
  extends CacheBase
{
  public static final int FIRSTTS_FIELD_NUMBER = 1;
  public static final int FIRST_VAL_FIELD_NUMBER = 3;
  public static final int TS_FIELD_NUMBER = 2;
  public static final int VALS_FIELD_NUMBER = 4;
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
  
  public EncodedOneValuedSignal addTs(int paramInt)
  {
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public EncodedOneValuedSignal addVals(int paramInt)
  {
    if (this.f.isEmpty()) {
      this.f = new ArrayList();
    }
    this.f.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public final EncodedOneValuedSignal clear()
  {
    clearFirstTs();
    clearTs();
    clearFirstVal();
    clearVals();
    this.g = -1;
    return this;
  }
  
  public EncodedOneValuedSignal clearFirstTs()
  {
    this.a = false;
    this.b = 0L;
    return this;
  }
  
  public EncodedOneValuedSignal clearFirstVal()
  {
    this.d = false;
    this.e = 0.0F;
    return this;
  }
  
  public EncodedOneValuedSignal clearTs()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public EncodedOneValuedSignal clearVals()
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
  
  public long getFirstTs()
  {
    return this.b;
  }
  
  public float getFirstVal()
  {
    return this.e;
  }
  
  
  public int getSerializedSize()
  {
      int i = 0;
      int j;
      Iterator iterator;
      int k;
      if(hasFirstTs())
          j = 0 + WriteStream.bindLength(1, getFirstTs());
      else
          j = 0;
      iterator = getTsList().iterator();
      k = 0;
      for(;iterator.hasNext();) {
    	  k += WriteStream.bindLength2(((Integer)iterator.next()).intValue());
      }
      
      int l = j + k + 1 * getTsList().size();
      int i1;
      Iterator iterator1;
      int j1;
      if(hasFirstVal())
          i1 = l + WriteStream.dataLength(3, getFirstVal());
      else
          i1 = l;
      iterator1 = getValsList().iterator();

	  for(;iterator1.hasNext();)
	  {
	      i += WriteStream.bindStatus(((Integer)iterator1.next()).intValue());
	  }
	  j1 = i1 + i + 1 * getValsList().size();
	  g = j1;
	  return j1;
                  
  }

  
  public int getTs(int paramInt)
  {
    return ((Integer)this.c.get(paramInt)).intValue();
  }
  
  public int getTsCount()
  {
    return this.c.size();
  }
  
  public List getTsList()
  {
    return this.c;
  }
  
  public int getVals(int paramInt)
  {
    return ((Integer)this.f.get(paramInt)).intValue();
  }
  
  public int getValsCount()
  {
    return this.f.size();
  }
  
  public List getValsList()
  {
    return this.f;
  }
  
  public boolean hasFirstTs()
  {
    return this.a;
  }
  
  public boolean hasFirstVal()
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
        setFirstTs(paramReadStream.is1());
        break;
      case 16: 
        addTs(paramReadStream.getMBytes());
        break;
      case 29: 
        setFirstVal(paramReadStream.checkResult());
        break;
      case 32: // ' '
          addVals(paramReadStream.calc4());
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
  
  public EncodedOneValuedSignal setFirstTs(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public EncodedOneValuedSignal setFirstVal(float paramFloat)
  {
    this.d = true;
    this.e = paramFloat;
    return this;
  }
  
  public EncodedOneValuedSignal setTs(int paramInt1, int paramInt2)
  {
    this.c.set(paramInt1, Integer.valueOf(paramInt2));
    return this;
  }
  
  public EncodedOneValuedSignal setVals(int paramInt1, int paramInt2)
  {
    this.f.set(paramInt1, Integer.valueOf(paramInt2));
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasFirstTs()) {
      paramWriteStream.getInstance(1, getFirstTs());
    }
    Iterator localIterator1 = getTsList().iterator();
    Iterator localIterator2;
    for(;localIterator1.hasNext();)
    {
    	paramWriteStream.getInstance(2, ((Integer)localIterator1.next()).intValue());      
    }
	if (hasFirstVal()) {
       paramWriteStream.getInstance(3, getFirstVal());
    }
    localIterator2 = getValsList().iterator();
    
    for (;localIterator2.hasNext();)
    {
      paramWriteStream.bindLength(4, ((Integer)localIterator2.next()).intValue());
    }
      return;
    
  }
}




public static class EncodedThreeValuedSignal
  extends CacheBase
{
  public static final int FIRSTTS_FIELD_NUMBER = 1;
  public static final int FIRST_X_FIELD_NUMBER = 3;
  public static final int FIRST_Y_FIELD_NUMBER = 4;
  public static final int FIRST_Z_FIELD_NUMBER = 5;
  public static final int TS_FIELD_NUMBER = 2;
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
  
  public EncodedThreeValuedSignal addTs(int paramInt)
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
    clearFirstTs();
    clearTs();
    clearFirstX();
    clearFirstY();
    clearFirstZ();
    clearX();
    clearY();
    clearZ();
    this.m = -1;
    return this;
  }
  
  public EncodedThreeValuedSignal clearFirstTs()
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
  
  public EncodedThreeValuedSignal clearTs()
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
  
  public long getFirstTs()
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
      if(hasFirstTs())
          j1 = 0 + WriteStream.bindLength(1, getFirstTs());
      else
          j1 = 0;
      iterator = getTsList().iterator();
      k1 = 0;
      for(;iterator.hasNext();) {
    	      k1 += WriteStream.bindLength2(((Integer)iterator.next()).intValue());
      }

      l1 = j1 + k1 + 1 * getTsList().size();
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
      
      for(;iterator1.hasNext();)
      {
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

  
  public int getTs(int paramInt)
  {
    return ((Integer)this.c.get(paramInt)).intValue();
  }
  
  public int getTsCount()
  {
    return this.c.size();
  }
  
  public List getTsList()
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
  
  public boolean hasFirstTs()
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
        setFirstTs(paramReadStream.is1());
        break;
      case 16: 
        addTs(paramReadStream.getMBytes());
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
  
  public EncodedThreeValuedSignal setFirstTs(long paramLong)
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
  
  public EncodedThreeValuedSignal setTs(int paramInt1, int paramInt2)
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
      if(hasFirstTs())
          writestream.getInstance(1, getFirstTs());
      iterator = getTsList().iterator();

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


public static class GeoBoundingBox
  extends CacheBase
{
  public static final int CORNER1_FIELD_NUMBER = 1;
  public static final int CORNER2_FIELD_NUMBER = 2;
  private boolean a;
  private cmn.GeoPosition b = null;
  private boolean c;
  private cmn.GeoPosition d = null;
  private int e = -1;
  
  public static GeoBoundingBox parseFrom(ReadStream paramReadStream)
  {
    return new GeoBoundingBox().mergeFrom(paramReadStream);
  }
  
  public static GeoBoundingBox parseFrom(byte[] paramArrayOfByte)
  {
    return (GeoBoundingBox)new GeoBoundingBox().mergeFrom(paramArrayOfByte);
  }
  
  public final GeoBoundingBox clear()
  {
    clearCorner1();
    clearCorner2();
    this.e = -1;
    return this;
  }
  
  public GeoBoundingBox clearCorner1()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public GeoBoundingBox clearCorner2()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public cmn.GeoPosition getCorner1()
  {
    return this.b;
  }
  
  public cmn.GeoPosition getCorner2()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasCorner1();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getCorner1());
    }
    if (hasCorner2()) {
      i += WriteStream.dataLength(2, getCorner2());
    }
    this.e = i;
    return i;
  }
  
  public boolean hasCorner1()
  {
    return this.a;
  }
  
  public boolean hasCorner2()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public GeoBoundingBox mergeFrom(ReadStream paramReadStream)
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
        cmn.GeoPosition localGeoPosition2 = new cmn.GeoPosition();
        paramReadStream.getInstance(localGeoPosition2);
        setCorner1(localGeoPosition2);
        break;
      case 18: // '\022'
          cmn.GeoPosition localGeoPosition1 = new cmn.GeoPosition();
          paramReadStream.getInstance(localGeoPosition1);
          setCorner2(localGeoPosition1);
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
  
  public GeoBoundingBox setCorner1(cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramGeoPosition;
    return this;
  }
  
  public GeoBoundingBox setCorner2(cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    this.c = true;
    this.d = paramGeoPosition;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasCorner1()) {
      paramWriteStream.getInstance(1, getCorner1());
    }
    if (hasCorner2()) {
      paramWriteStream.getInstance(2, getCorner2());
    }
  }
}




public static class GeoCircle
extends CacheBase
{
public static final int LATITUDE_FIELD_NUMBER = 1;
public static final int LONGITUDE_FIELD_NUMBER = 2;
public static final int RADIUS_FIELD_NUMBER = 3;
private boolean a;
private double b = 0.0D;
private boolean c;
private double d = 0.0D;
private boolean e;
private double f = 0.0D;
private int g = -1;

public static GeoCircle parseFrom(ReadStream paramReadStream)
{
  return new GeoCircle().mergeFrom(paramReadStream);
}

public static GeoCircle parseFrom(byte[] paramArrayOfByte)
{
  return (GeoCircle)new GeoCircle().mergeFrom(paramArrayOfByte);
}

public final GeoCircle clear()
{
  clearLatitude();
  clearLongitude();
  clearRadius();
  this.g = -1;
  return this;
}

public GeoCircle clearLatitude()
{
  this.a = false;
  this.b = 0.0D;
  return this;
}

public GeoCircle clearLongitude()
{
  this.c = false;
  this.d = 0.0D;
  return this;
}

public GeoCircle clearRadius()
{
  this.e = false;
  this.f = 0.0D;
  return this;
}

public int getCachedSize()
{
  if (this.g < 0) {
    getSerializedSize();
  }
  return this.g;
}

public double getLatitude()
{
  return this.b;
}

public double getLongitude()
{
  return this.d;
}

public double getRadius()
{
  return this.f;
}

public int getSerializedSize()
{
  boolean bool = hasLatitude();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getLatitude());
  }
  if (hasLongitude()) {
    i += WriteStream.dataLength(2, getLongitude());
  }
  if (hasRadius()) {
    i += WriteStream.dataLength(3, getRadius());
  }
  this.g = i;
  return i;
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

public GeoCircle mergeFrom(ReadStream paramReadStream)
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
    case 9: 
      setLatitude(paramReadStream.getStatus());
      break;
    case 17: 
      setLongitude(paramReadStream.getStatus());
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


public GeoCircle setLatitude(double paramDouble)
{
  this.a = true;
  this.b = paramDouble;
  return this;
}

public GeoCircle setLongitude(double paramDouble)
{
  this.c = true;
  this.d = paramDouble;
  return this;
}

public GeoCircle setRadius(double paramDouble)
{
  this.e = true;
  this.f = paramDouble;
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
}
}



public static class GeoLocation
  extends CacheBase
{
  public static final int BOX_FIELD_NUMBER = 3;
  public static final int CIRCLE_FIELD_NUMBER = 2;
  public static final int GEOBOUNDINGBOX = 2;
  public static final int GEOCIRCLE = 1;
  public static final int GEOPOLYGON = 3;
  public static final int POLYGON_FIELD_NUMBER = 4;
  public static final int TYPE_FIELD_NUMBER = 1;
  private boolean a;
  private int b = 1;
  private boolean c;
  private cmn.GeoCircle d = null;
  private boolean e;
  private cmn.GeoBoundingBox f = null;
  private boolean g;
  private cmn.GeoPolygon h = null;
  private int i = -1;
  
  public static GeoLocation parseFrom(ReadStream paramReadStream)
  {
    return new GeoLocation().mergeFrom(paramReadStream);
  }
  
  public static GeoLocation parseFrom(byte[] paramArrayOfByte)
  {
    return (GeoLocation)new GeoLocation().mergeFrom(paramArrayOfByte);
  }
  
  public final GeoLocation clear()
  {
    clearType();
    clearCircle();
    clearBox();
    clearPolygon();
    this.i = -1;
    return this;
  }
  
  public GeoLocation clearBox()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public GeoLocation clearCircle()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public GeoLocation clearPolygon()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public GeoLocation clearType()
  {
    this.a = false;
    this.b = 1;
    return this;
  }
  
  public cmn.GeoBoundingBox getBox()
  {
    return this.f;
  }
  
  public int getCachedSize()
  {
    if (this.i < 0) {
      getSerializedSize();
    }
    return this.i;
  }
  
  public cmn.GeoCircle getCircle()
  {
    return this.d;
  }
  
  public cmn.GeoPolygon getPolygon()
  {
    return this.h;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasType();
    int j = 0;
    if (bool) {
      j = 0 + WriteStream.bindLength2(1, getType());
    }
    if (hasCircle()) {
      j += WriteStream.dataLength(2, getCircle());
    }
    if (hasBox()) {
      j += WriteStream.dataLength(3, getBox());
    }
    if (hasPolygon()) {
      j += WriteStream.dataLength(4, getPolygon());
    }
    this.i = j;
    return j;
  }
  
  public int getType()
  {
    return this.b;
  }
  
  public boolean hasBox()
  {
    return this.e;
  }
  
  public boolean hasCircle()
  {
    return this.c;
  }
  
  public boolean hasPolygon()
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
  
  public GeoLocation mergeFrom(ReadStream paramReadStream)
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
        cmn.GeoCircle localGeoCircle = new cmn.GeoCircle();
        paramReadStream.getInstance(localGeoCircle);
        setCircle(localGeoCircle);
        break;
      case 26: 
        cmn.GeoBoundingBox localGeoBoundingBox = new cmn.GeoBoundingBox();
        paramReadStream.getInstance(localGeoBoundingBox);
        setBox(localGeoBoundingBox);
        break;
      case 34: // '"'
          cmn.GeoPolygon localGeoPolygon = new cmn.GeoPolygon();
          paramReadStream.getInstance(localGeoPolygon);
          setPolygon(localGeoPolygon);
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
  
  public GeoLocation setBox(cmn.GeoBoundingBox paramGeoBoundingBox)
  {
    if (paramGeoBoundingBox == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramGeoBoundingBox;
    return this;
  }
  
  public GeoLocation setCircle(cmn.GeoCircle paramGeoCircle)
  {
    if (paramGeoCircle == null) {
      throw new NullPointerException();
    }
    this.c = true;
    this.d = paramGeoCircle;
    return this;
  }
  
  public GeoLocation setPolygon(cmn.GeoPolygon paramGeoPolygon)
  {
    if (paramGeoPolygon == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramGeoPolygon;
    return this;
  }
  
  public GeoLocation setType(int paramInt)
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
    if (hasCircle()) {
      paramWriteStream.getInstance(2, getCircle());
    }
    if (hasBox()) {
      paramWriteStream.getInstance(3, getBox());
    }
    if (hasPolygon()) {
      paramWriteStream.getInstance(4, getPolygon());
    }
  }
}






public static class GeoPolygon
  extends CacheBase
{
  public static final int VERTICES_FIELD_NUMBER = 1;
  private List a = Collections.emptyList();
  private int b = -1;
  
  public static GeoPolygon parseFrom(ReadStream paramReadStream)
  {
    return new GeoPolygon().mergeFrom(paramReadStream);
  }
  
  public static GeoPolygon parseFrom(byte[] paramArrayOfByte)
  {
    return (GeoPolygon)new GeoPolygon().mergeFrom(paramArrayOfByte);
  }
  
  public GeoPolygon addVertices(cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramGeoPosition);
    return this;
  }
  
  public final GeoPolygon clear()
  {
    clearVertices();
    this.b = -1;
    return this;
  }
  
  public GeoPolygon clearVertices()
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
  
  public int getSerializedSize()
  {
    Iterator localIterator = getVerticesList().iterator();
    int i = 0;
    for (;localIterator.hasNext();)
    {
      i += WriteStream.dataLength(1, (cmn.GeoPosition)localIterator.next());
    }
    
    this.b = i;
    return i;
    
  }
  
  public cmn.GeoPosition getVertices(int paramInt)
  {
    return (cmn.GeoPosition)this.a.get(paramInt);
  }
  
  public int getVerticesCount()
  {
    return this.a.size();
  }
  
  public List getVerticesList()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public GeoPolygon mergeFrom(ReadStream paramReadStream)
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
          cmn.GeoPosition localGeoPosition = new cmn.GeoPosition();
          paramReadStream.getInstance(localGeoPosition);
          addVertices(localGeoPosition);
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
  
  public GeoPolygon setVertices(int paramInt, cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    this.a.set(paramInt, paramGeoPosition);
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    Iterator localIterator = getVerticesList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(1, (cmn.GeoPosition)localIterator.next());
    }
    
  }
}





public static class GeoPosition
  extends CacheBase
{
  public static final int LATITUDE_FIELD_NUMBER = 1;
  public static final int LONGITUDE_FIELD_NUMBER = 2;
  private boolean a;
  private double mLatitude = 0.0D;
  private boolean c;
  private double d = 0.0D;
  private int e = -1;
  
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
    this.e = -1;
    return this;
  }
  
  public GeoPosition clearLatitude()
  {
    this.a = false;
    this.mLatitude = 0.0D;
    return this;
  }
  
  public GeoPosition clearLongitude()
  {
    this.c = false;
    this.d = 0.0D;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public double getLatitude()
  {
    return this.mLatitude;
  }
  
  public double getLongitude()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasLatitude();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getLatitude());
    }
    if (hasLongitude()) {
      i += WriteStream.dataLength(2, getLongitude());
    }
    this.e = i;
    return i;
  }
  
  public boolean hasLatitude()
  {
    return this.a;
  }
  
  public boolean hasLongitude()
  {
    return this.c;
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
      int i = paramReadStream.getInstance();
      switch (i)
      {
      default: 
        if (parseUnknownField(paramReadStream, i)) {
          continue;
        }
      case 0: 
        return this;
      case 9: 
        setLatitude(paramReadStream.getStatus());
        break;
      case 17: // '\021'
          setLongitude(paramReadStream.getStatus());
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
  
  public GeoPosition setLatitude(double paramDouble)
  {
    this.a = true;
    this.mLatitude = paramDouble;
    return this;
  }
  
  public GeoPosition setLongitude(double paramDouble)
  {
    this.c = true;
    this.d = paramDouble;
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
  }
}





public static class GPSSample
extends CacheBase
{
public static final int ALT_FIELD_NUMBER = 4;
public static final int GPS_TIMESTAMP_FIELD_NUMBER = 1;
public static final int LAT_FIELD_NUMBER = 2;
public static final int LON_FIELD_NUMBER = 3;
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
  clearLat();
  clearLon();
  clearAlt();
  this.i = -1;
  return this;
}

public GPSSample clearAlt()
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

public GPSSample clearLat()
{
  this.c = false;
  this.d = 0.0D;
  return this;
}

public GPSSample clearLon()
{
  this.e = false;
  this.f = 0.0D;
  return this;
}

public double getAlt()
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

public double getLat()
{
  return this.d;
}

public double getLon()
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
  if (hasLat()) {
    j += WriteStream.dataLength(2, getLat());
  }
  if (hasLon()) {
    j += WriteStream.dataLength(3, getLon());
  }
  if (hasAlt()) {
    j += WriteStream.dataLength(4, getAlt());
  }
  this.i = j;
  return j;
}

public boolean hasAlt()
{
  return this.g;
}

public boolean hasGpsTimestamp()
{
  return this.a;
}

public boolean hasLat()
{
  return this.c;
}

public boolean hasLon()
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
      setLat(paramReadStream.getStatus());
      break;
    case 25: 
      setLon(paramReadStream.getStatus());
      break;
    case 33: // '!'
        setAlt(paramReadStream.getStatus());
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

public GPSSample setAlt(double paramDouble)
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

public GPSSample setLat(double paramDouble)
{
  this.c = true;
  this.d = paramDouble;
  return this;
}

public GPSSample setLon(double paramDouble)
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
  if (hasLat()) {
    paramWriteStream.getInstance(2, getLat());
  }
  if (hasLon()) {
    paramWriteStream.getInstance(3, getLon());
  }
  if (hasAlt()) {
    paramWriteStream.getInstance(4, getAlt());
  }
}
}




public static class Graphic
  extends CacheBase
{
  public static final int ID_FIELD_NUMBER = 1;
  public static final int IMAGE_FIELD_NUMBER = 5;
  public static final int LEVEL_LINK_FIELD_NUMBER = 4;
  public static final int MARKERS_FIELD_NUMBER = 6;
  public static final int NAME_FIELD_NUMBER = 3;
  public static final int TRANSFORMATIONS_FIELD_NUMBER = 7;
  public static final int URL_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private cmn.Link h = null;
  private boolean i;
  private cmn.GraphicsImage j = null;
  private List k = Collections.emptyList();
  private boolean l;
  private cmn.Transformations m = null;
  private int n = -1;
  
  public static Graphic parseFrom(ReadStream paramReadStream)
  {
    return new Graphic().mergeFrom(paramReadStream);
  }
  
  public static Graphic parseFrom(byte[] paramArrayOfByte)
  {
    return (Graphic)new Graphic().mergeFrom(paramArrayOfByte);
  }
  
  public Graphic addMarkers(cmn.GraphicsMarker paramGraphicsMarker)
  {
    if (paramGraphicsMarker == null) {
      throw new NullPointerException();
    }
    if (this.k.isEmpty()) {
      this.k = new ArrayList();
    }
    this.k.add(paramGraphicsMarker);
    return this;
  }
  
  public final Graphic clear()
  {
    clearId();
    clearUrl();
    clearName();
    clearLevelLink();
    clearImage();
    clearMarkers();
    clearTransformations();
    this.n = -1;
    return this;
  }
  
  public Graphic clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Graphic clearImage()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public Graphic clearLevelLink()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public Graphic clearMarkers()
  {
    this.k = Collections.emptyList();
    return this;
  }
  
  public Graphic clearName()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public Graphic clearTransformations()
  {
    this.l = false;
    this.m = null;
    return this;
  }
  
  public Graphic clearUrl()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.n < 0) {
      getSerializedSize();
    }
    return this.n;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public cmn.GraphicsImage getImage()
  {
    return this.j;
  }
  
  public cmn.Link getLevelLink()
  {
    return this.h;
  }
  
  public cmn.GraphicsMarker getMarkers(int paramInt)
  {
    return (cmn.GraphicsMarker)this.k.get(paramInt);
  }
  
  public int getMarkersCount()
  {
    return this.k.size();
  }
  
  public List getMarkersList()
  {
    return this.k;
  }
  
  public String getName()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasId();
    int i1 = 0;
    if (bool) {
      i1 = 0 + WriteStream.dataLength(1, getId());
    }
    if (hasUrl()) {
      i1 += WriteStream.dataLength(2, getUrl());
    }
    if (hasName()) {
      i1 += WriteStream.dataLength(3, getName());
    }
    if (hasLevelLink()) {
      i1 += WriteStream.dataLength(4, getLevelLink());
    }
    if (hasImage()) {
      i1 += WriteStream.dataLength(5, getImage());
    }
    Iterator localIterator = getMarkersList().iterator();
    int i2 = i1;
    for (;localIterator.hasNext();)
    {
      i2 += WriteStream.dataLength(6, (cmn.GraphicsMarker)localIterator.next());
    }
      if (hasTransformations()) {
        i2 += WriteStream.dataLength(7, getTransformations());
      }
      this.n = i2;
      return i2;
    
  }
  
  public cmn.Transformations getTransformations()
  {
    return this.m;
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasImage()
  {
    return this.i;
  }
  
  public boolean hasLevelLink()
  {
    return this.g;
  }
  
  public boolean hasName()
  {
    return this.e;
  }
  
  public boolean hasTransformations()
  {
    return this.l;
  }
  
  public boolean hasUrl()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Graphic mergeFrom(ReadStream paramReadStream)
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
      case 10: 
        setId(paramReadStream.getStr());
        break;
      case 18: 
        setUrl(paramReadStream.getStr());
        break;
      case 26: 
        setName(paramReadStream.getStr());
        break;
      case 34: 
        cmn.Link localLink = new cmn.Link();
        paramReadStream.getInstance(localLink);
        setLevelLink(localLink);
        break;
      case 42: 
        cmn.GraphicsImage localGraphicsImage = new cmn.GraphicsImage();
        paramReadStream.getInstance(localGraphicsImage);
        setImage(localGraphicsImage);
        break;
      case 50: 
        cmn.GraphicsMarker localGraphicsMarker = new cmn.GraphicsMarker();
        paramReadStream.getInstance(localGraphicsMarker);
        addMarkers(localGraphicsMarker);
        break;
      case 58: // ':'
          cmn.Transformations localTransformations = new cmn.Transformations();
          paramReadStream.getInstance(localTransformations);
          setTransformations(localTransformations);
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
  
  public Graphic setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Graphic setImage(cmn.GraphicsImage paramGraphicsImage)
  {
    if (paramGraphicsImage == null) {
      throw new NullPointerException();
    }
    this.i = true;
    this.j = paramGraphicsImage;
    return this;
  }
  
  public Graphic setLevelLink(cmn.Link paramLink)
  {
    if (paramLink == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramLink;
    return this;
  }
  
  public Graphic setMarkers(int paramInt, cmn.GraphicsMarker paramGraphicsMarker)
  {
    if (paramGraphicsMarker == null) {
      throw new NullPointerException();
    }
    this.k.set(paramInt, paramGraphicsMarker);
    return this;
  }
  
  public Graphic setName(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public Graphic setTransformations(cmn.Transformations paramTransformations)
  {
    if (paramTransformations == null) {
      throw new NullPointerException();
    }
    this.l = true;
    this.m = paramTransformations;
    return this;
  }
  
  public Graphic setUrl(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
	  try {
    if (hasId()) {
      paramWriteStream.getInstance(1, getId());
    }
    if (hasUrl()) {
      paramWriteStream.getInstance(2, getUrl());
    }
    if (hasName()) {
      paramWriteStream.getInstance(3, getName());
    }
    if (hasLevelLink()) {
      paramWriteStream.getInstance(4, getLevelLink());
    }
    if (hasImage()) {
      paramWriteStream.getInstance(5, getImage());
    }
    Iterator localIterator = getMarkersList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(6, (cmn.GraphicsMarker)localIterator.next());
    }
    
      if (hasTransformations()) {
        paramWriteStream.getInstance(7, getTransformations());
      }
      return;

  } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }
      
  }
}




public static class GraphicsImage
extends CacheBase
{
public static final int FORMAT_FIELD_NUMBER = 2;
public static final int HEIGHT_FIELD_NUMBER = 4;
public static final int URL_FIELD_NUMBER = 1;
public static final int WIDTH_FIELD_NUMBER = 3;
private boolean a;
private String b = "";
private boolean c;
private String d = "";
private boolean e;
private int f = 0;
private boolean g;
private int h = 0;
private int i = -1;

public static GraphicsImage parseFrom(ReadStream paramReadStream)
{
  return new GraphicsImage().mergeFrom(paramReadStream);
}

public static GraphicsImage parseFrom(byte[] paramArrayOfByte)
{
  return (GraphicsImage)new GraphicsImage().mergeFrom(paramArrayOfByte);
}

public final GraphicsImage clear()
{
  clearUrl();
  clearFormat();
  clearWidth();
  clearHeight();
  this.i = -1;
  return this;
}

public GraphicsImage clearFormat()
{
  this.c = false;
  this.d = "";
  return this;
}

public GraphicsImage clearHeight()
{
  this.g = false;
  this.h = 0;
  return this;
}

public GraphicsImage clearUrl()
{
  this.a = false;
  this.b = "";
  return this;
}

public GraphicsImage clearWidth()
{
  this.e = false;
  this.f = 0;
  return this;
}

public int getCachedSize()
{
  if (this.i < 0) {
    getSerializedSize();
  }
  return this.i;
}

public String getFormat()
{
  return this.d;
}

public int getHeight()
{
  return this.h;
}

public int getSerializedSize()
{
  boolean bool = hasUrl();
  int j = 0;
  if (bool) {
    j = 0 + WriteStream.dataLength(1, getUrl());
  }
  if (hasFormat()) {
    j += WriteStream.dataLength(2, getFormat());
  }
  if (hasWidth()) {
    j += WriteStream.bindLength3(3, getWidth());
  }
  if (hasHeight()) {
    j += WriteStream.bindLength3(4, getHeight());
  }
  this.i = j;
  return j;
}

public String getUrl()
{
  return this.b;
}

public int getWidth()
{
  return this.f;
}

public boolean hasFormat()
{
  return this.c;
}

public boolean hasHeight()
{
  return this.g;
}

public boolean hasUrl()
{
  return this.a;
}

public boolean hasWidth()
{
  return this.e;
}

public final boolean isInitialized()
{
  return true;
}

public GraphicsImage mergeFrom(ReadStream paramReadStream)
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
    case 10: 
      setUrl(paramReadStream.getStr());
      break;
    case 18: 
      setFormat(paramReadStream.getStr());
      break;
    case 24: 
      setWidth(paramReadStream.calc3());
      break;
    case 32: // ' '
        setHeight(paramReadStream.calc3());
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

public GraphicsImage setFormat(String paramString)
{
  this.c = true;
  this.d = paramString;
  return this;
}

public GraphicsImage setHeight(int paramInt)
{
  this.g = true;
  this.h = paramInt;
  return this;
}

public GraphicsImage setUrl(String paramString)
{
  this.a = true;
  this.b = paramString;
  return this;
}

public GraphicsImage setWidth(int paramInt)
{
  this.e = true;
  this.f = paramInt;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
	
	try {
  if (hasUrl()) {
    paramWriteStream.getInstance(1, getUrl());
  }
  if (hasFormat()) {
    paramWriteStream.getInstance(2, getFormat());
  }
  if (hasWidth()) {
    paramWriteStream.dataLength(3, getWidth());
  }
  if (hasHeight()) {
    paramWriteStream.dataLength(4, getHeight());
  }
    } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(Exception ex) {
    	  ex.printStackTrace();
      }
}
}





public static class GraphicsMarker
  extends CacheBase
{
  public static final int GEO_POINT_FIELD_NUMBER = 1;
  public static final int PIXEL_POINT_FIELD_NUMBER = 2;
  private boolean a;
  private cmn.GeoPosition b = null;
  private List c = Collections.emptyList();
  private int d = -1;
  
  public static GraphicsMarker parseFrom(ReadStream paramReadStream)
  {
    return new GraphicsMarker().mergeFrom(paramReadStream);
  }
  
  public static GraphicsMarker parseFrom(byte[] paramArrayOfByte)
  {
    return (GraphicsMarker)new GraphicsMarker().mergeFrom(paramArrayOfByte);
  }
  
  public GraphicsMarker addPixelPoint(cmn.PixelPosition paramPixelPosition)
  {
    if (paramPixelPosition == null) {
      throw new NullPointerException();
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramPixelPosition);
    return this;
  }
  
  public final GraphicsMarker clear()
  {
    clearGeoPoint();
    clearPixelPoint();
    this.d = -1;
    return this;
  }
  
  public GraphicsMarker clearGeoPoint()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public GraphicsMarker clearPixelPoint()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.d < 0) {
      getSerializedSize();
    }
    return this.d;
  }
  
  public cmn.GeoPosition getGeoPoint()
  {
    return this.b;
  }
  
  public cmn.PixelPosition getPixelPoint(int paramInt)
  {
    return (cmn.PixelPosition)this.c.get(paramInt);
  }
  
  public int getPixelPointCount()
  {
    return this.c.size();
  }
  
  public List getPixelPointList()
  {
    return this.c;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasGeoPoint();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getGeoPoint());
    }
    Iterator localIterator = getPixelPointList().iterator();
    int j = i;
    for (;localIterator.hasNext();)
    {
      j += WriteStream.dataLength(2, (cmn.PixelPosition)localIterator.next());
    }
    
    this.d = j;
    return j;
    
  }
  
  public boolean hasGeoPoint()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public GraphicsMarker mergeFrom(ReadStream paramReadStream)
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
        cmn.GeoPosition localGeoPosition = new cmn.GeoPosition();
        paramReadStream.getInstance(localGeoPosition);
        setGeoPoint(localGeoPosition);
        break;
      case 18: // '\022'
          cmn.PixelPosition localPixelPosition = new cmn.PixelPosition();
          paramReadStream.getInstance(localPixelPosition);
          addPixelPoint(localPixelPosition);
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
  
  public GraphicsMarker setGeoPoint(cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramGeoPosition;
    return this;
  }
  
  public GraphicsMarker setPixelPoint(int paramInt, cmn.PixelPosition paramPixelPosition)
  {
    if (paramPixelPosition == null) {
      throw new NullPointerException();
    }
    this.c.set(paramInt, paramPixelPosition);
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasGeoPoint()) {
      paramWriteStream.getInstance(1, getGeoPoint());
    }
    Iterator localIterator = getPixelPointList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(2, (cmn.PixelPosition)localIterator.next());
    }
    
  }
}


public static class GyroSample
  extends CacheBase
{
  public static final int GYRO_TIMESTAMP_FIELD_NUMBER = 1;
  public static final int GYRO_X_FIELD_NUMBER = 2;
  public static final int GYRO_Y_FIELD_NUMBER = 3;
  public static final int GYRO_Z_FIELD_NUMBER = 4;
  private boolean a;
  private long b = 0L;
  private boolean c;
  private float d = 0.0F;
  private boolean e;
  private float f = 0.0F;
  private boolean g;
  private float h = 0.0F;
  private int i = -1;
  
  public static GyroSample parseFrom(ReadStream paramReadStream)
  {
    return new GyroSample().mergeFrom(paramReadStream);
  }
  
  public static GyroSample parseFrom(byte[] paramArrayOfByte)
  {
    return (GyroSample)new GyroSample().mergeFrom(paramArrayOfByte);
  }
  
  public final GyroSample clear()
  {
    clearGyroTimestamp();
    clearGyroX();
    clearGyroY();
    clearGyroZ();
    this.i = -1;
    return this;
  }
  
  public GyroSample clearGyroTimestamp()
  {
    this.a = false;
    this.b = 0L;
    return this;
  }
  
  public GyroSample clearGyroX()
  {
    this.c = false;
    this.d = 0.0F;
    return this;
  }
  
  public GyroSample clearGyroY()
  {
    this.e = false;
    this.f = 0.0F;
    return this;
  }
  
  public GyroSample clearGyroZ()
  {
    this.g = false;
    this.h = 0.0F;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.i < 0) {
      getSerializedSize();
    }
    return this.i;
  }
  
  public long getGyroTimestamp()
  {
    return this.b;
  }
  
  public float getGyroX()
  {
    return this.d;
  }
  
  public float getGyroY()
  {
    return this.f;
  }
  
  public float getGyroZ()
  {
    return this.h;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasGyroTimestamp();
    int j = 0;
    if (bool) {
      j = 0 + WriteStream.bindLength(1, getGyroTimestamp());
    }
    if (hasGyroX()) {
      j += WriteStream.dataLength(2, getGyroX());
    }
    if (hasGyroY()) {
      j += WriteStream.dataLength(3, getGyroY());
    }
    if (hasGyroZ()) {
      j += WriteStream.dataLength(4, getGyroZ());
    }
    this.i = j;
    return j;
  }
  
  public boolean hasGyroTimestamp()
  {
    return this.a;
  }
  
  public boolean hasGyroX()
  {
    return this.c;
  }
  
  public boolean hasGyroY()
  {
    return this.e;
  }
  
  public boolean hasGyroZ()
  {
    return this.g;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public GyroSample mergeFrom(ReadStream paramReadStream)
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
        setGyroTimestamp(paramReadStream.is1());
        break;
      case 21: 
        setGyroX(paramReadStream.checkResult());
        break;
      case 29: 
        setGyroY(paramReadStream.checkResult());
        break;
      case 37: // '%'
          setGyroZ(paramReadStream.checkResult());
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
  
  public GyroSample setGyroTimestamp(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public GyroSample setGyroX(float paramFloat)
  {
    this.c = true;
    this.d = paramFloat;
    return this;
  }
  
  public GyroSample setGyroY(float paramFloat)
  {
    this.e = true;
    this.f = paramFloat;
    return this;
  }
  
  public GyroSample setGyroZ(float paramFloat)
  {
    this.g = true;
    this.h = paramFloat;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasGyroTimestamp()) {
      paramWriteStream.getInstance(1, getGyroTimestamp());
    }
    if (hasGyroX()) {
      paramWriteStream.getInstance(2, getGyroX());
    }
    if (hasGyroY()) {
      paramWriteStream.getInstance(3, getGyroY());
    }
    if (hasGyroZ()) {
      paramWriteStream.getInstance(4, getGyroZ());
    }
  }
}



public static class Level
extends CacheBase
{
public static final int BUILDING_LINK_FIELD_NUMBER = 5;
public static final int GRAPHICS_URL_FIELD_NUMBER = 6;
public static final int ID_FIELD_NUMBER = 1;
public static final int LEVEL_NUM_FIELD_NUMBER = 4;
public static final int NAME_FIELD_NUMBER = 3;
public static final int URL_FIELD_NUMBER = 2;
private boolean a;
private String b = "";
private boolean c;
private String d = "";
private boolean e;
private String f = "";
private boolean g;
private int h = 0;
private boolean i;
private cmn.Link j = null;
private boolean k;
private String l = "";
private int m = -1;

public static Level parseFrom(ReadStream paramReadStream)
{
  return new Level().mergeFrom(paramReadStream);
}

public static Level parseFrom(byte[] paramArrayOfByte)
{
  return (Level)new Level().mergeFrom(paramArrayOfByte);
}

public final Level clear()
{
  clearId();
  clearUrl();
  clearName();
  clearLevelNum();
  clearBuildingLink();
  clearGraphicsUrl();
  this.m = -1;
  return this;
}

public Level clearBuildingLink()
{
  this.i = false;
  this.j = null;
  return this;
}

public Level clearGraphicsUrl()
{
  this.k = false;
  this.l = "";
  return this;
}

public Level clearId()
{
  this.a = false;
  this.b = "";
  return this;
}

public Level clearLevelNum()
{
  this.g = false;
  this.h = 0;
  return this;
}

public Level clearName()
{
  this.e = false;
  this.f = "";
  return this;
}

public Level clearUrl()
{
  this.c = false;
  this.d = "";
  return this;
}

public cmn.Link getBuildingLink()
{
  return this.j;
}

public int getCachedSize()
{
  if (this.m < 0) {
    getSerializedSize();
  }
  return this.m;
}

public String getGraphicsUrl()
{
  return this.l;
}

public String getId()
{
  return this.b;
}

public int getLevelNum()
{
  return this.h;
}

public String getName()
{
  return this.f;
}

public int getSerializedSize()
{
  boolean bool = hasId();
  int n = 0;
  if (bool) {
    n = 0 + WriteStream.dataLength(1, getId());
  }
  if (hasUrl()) {
    n += WriteStream.dataLength(2, getUrl());
  }
  if (hasName()) {
    n += WriteStream.dataLength(3, getName());
  }
  if (hasLevelNum()) {
    n += WriteStream.bindLength3(4, getLevelNum());
  }
  if (hasBuildingLink()) {
    n += WriteStream.dataLength(5, getBuildingLink());
  }
  if (hasGraphicsUrl()) {
    n += WriteStream.dataLength(6, getGraphicsUrl());
  }
  this.m = n;
  return n;
}

public String getUrl()
{
  return this.d;
}

public boolean hasBuildingLink()
{
  return this.i;
}

public boolean hasGraphicsUrl()
{
  return this.k;
}

public boolean hasId()
{
  return this.a;
}

public boolean hasLevelNum()
{
  return this.g;
}

public boolean hasName()
{
  return this.e;
}

public boolean hasUrl()
{
  return this.c;
}

public final boolean isInitialized()
{
  return true;
}

public Level mergeFrom(ReadStream paramReadStream)
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
    case 10: 
      setId(paramReadStream.getStr());
      break;
    case 18: 
      setUrl(paramReadStream.getStr());
      break;
    case 26: 
      setName(paramReadStream.getStr());
      break;
    case 32: 
      setLevelNum(paramReadStream.calc3());
      break;
    case 42: 
      cmn.Link localLink = new cmn.Link();
      paramReadStream.getInstance(localLink);
      setBuildingLink(localLink);
      break;
    case 50: // '2'
        setGraphicsUrl(paramReadStream.getStr());
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

public Level setBuildingLink(cmn.Link paramLink)
{
  if (paramLink == null) {
    throw new NullPointerException();
  }
  this.i = true;
  this.j = paramLink;
  return this;
}

public Level setGraphicsUrl(String paramString)
{
  this.k = true;
  this.l = paramString;
  return this;
}

public Level setId(String paramString)
{
  this.a = true;
  this.b = paramString;
  return this;
}

public Level setLevelNum(int paramInt)
{
  this.g = true;
  this.h = paramInt;
  return this;
}

public Level setName(String paramString)
{
  this.e = true;
  this.f = paramString;
  return this;
}

public Level setUrl(String paramString)
{
  this.c = true;
  this.d = paramString;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
	try {
  if (hasId()) {
    paramWriteStream.getInstance(1, getId());
  }
  if (hasUrl()) {
    paramWriteStream.getInstance(2, getUrl());
  }
  if (hasName()) {
    paramWriteStream.getInstance(3, getName());
  }
  if (hasLevelNum()) {
    paramWriteStream.dataLength(4, getLevelNum());
  }
  if (hasBuildingLink()) {
    paramWriteStream.getInstance(5, getBuildingLink());
  }
  if (hasGraphicsUrl()) {
    paramWriteStream.getInstance(6, getGraphicsUrl());
  }
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(Exception ex) {
	  ex.printStackTrace();
  }
  
}
}




public static class LightSample
extends CacheBase
{
public static final int LIGHT_FIELD_NUMBER = 2;
public static final int LIGHT_TIMESTAMP_FIELD_NUMBER = 1;
private boolean a;
private long b = 0L;
private boolean c;
private float d = 0.0F;
private int e = -1;

public static LightSample parseFrom(ReadStream paramReadStream)
{
  return new LightSample().mergeFrom(paramReadStream);
}

public static LightSample parseFrom(byte[] paramArrayOfByte)
{
  return (LightSample)new LightSample().mergeFrom(paramArrayOfByte);
}

public final LightSample clear()
{
  clearLightTimestamp();
  clearLight();
  this.e = -1;
  return this;
}

public LightSample clearLight()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public LightSample clearLightTimestamp()
{
  this.a = false;
  this.b = 0L;
  return this;
}

public int getCachedSize()
{
  if (this.e < 0) {
    getSerializedSize();
  }
  return this.e;
}

public float getLight()
{
  return this.d;
}

public long getLightTimestamp()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasLightTimestamp();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.bindLength(1, getLightTimestamp());
  }
  if (hasLight()) {
    i += WriteStream.dataLength(2, getLight());
  }
  this.e = i;
  return i;
}

public boolean hasLight()
{
  return this.c;
}

public boolean hasLightTimestamp()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public LightSample mergeFrom(ReadStream paramReadStream)
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
      setLightTimestamp(paramReadStream.is1());
      break;
    case 21: // '\025'
        setLight(paramReadStream.checkResult());
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

public LightSample setLight(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public LightSample setLightTimestamp(long paramLong)
{
  this.a = true;
  this.b = paramLong;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasLightTimestamp()) {
    paramWriteStream.getInstance(1, getLightTimestamp());
  }
  if (hasLight()) {
    paramWriteStream.getInstance(2, getLight());
  }
}
}






public static class Link
  extends CacheBase
{
  public static final int HREF_FIELD_NUMBER = 2;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int NAME_FIELD_NUMBER = 3;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private int g = -1;
  
  public static Link parseFrom(ReadStream paramReadStream)
  {
    return new Link().mergeFrom(paramReadStream);
  }
  
  public static Link parseFrom(byte[] paramArrayOfByte)
  {
    return (Link)new Link().mergeFrom(paramArrayOfByte);
  }
  
  public final Link clear()
  {
    clearId();
    clearHref();
    clearName();
    this.g = -1;
    return this;
  }
  
  public Link clearHref()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public Link clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Link clearName()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public String getHref()
  {
    return this.d;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasId();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getId());
    }
    if (hasHref()) {
      i += WriteStream.dataLength(2, getHref());
    }
    if (hasName()) {
      i += WriteStream.dataLength(3, getName());
    }
    this.g = i;
    return i;
  }
  
  public boolean hasHref()
  {
    return this.c;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasName()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Link mergeFrom(ReadStream paramReadStream)
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
        setId(paramReadStream.getStr());
        break;
      case 18: 
        setHref(paramReadStream.getStr());
        break;
      case 26: // '\032'
          setName(paramReadStream.getStr());
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
  
  public Link setHref(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public Link setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Link setName(String paramString)
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
    if (hasHref()) {
      paramWriteStream.getInstance(2, getHref());
    }
    if (hasName()) {
      paramWriteStream.getInstance(3, getName());
    }
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(Exception ex) {
	  ex.printStackTrace();
  }
    
  }
}




public static class Matrix
  extends CacheBase
{
  public static final int COLS_FIELD_NUMBER = 1;
  public static final int ROWS_FIELD_NUMBER = 2;
  public static final int VALUE_FIELD_NUMBER = 3;
  private boolean a;
  private int b = 0;
  private boolean c;
  private int d = 0;
  private List e = Collections.emptyList();
  private int f = -1;
  
  public static Matrix parseFrom(ReadStream paramReadStream)
  {
    return new Matrix().mergeFrom(paramReadStream);
  }
  
  public static Matrix parseFrom(byte[] paramArrayOfByte)
  {
    return (Matrix)new Matrix().mergeFrom(paramArrayOfByte);
  }
  
  public Matrix addValue(double paramDouble)
  {
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(Double.valueOf(paramDouble));
    return this;
  }
  
  public final Matrix clear()
  {
    clearCols();
    clearRows();
    clearValue();
    this.f = -1;
    return this;
  }
  
  public Matrix clearCols()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public Matrix clearRows()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public Matrix clearValue()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public int getCols()
  {
    return this.b;
  }
  
  public int getRows()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasCols();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.bindLength3(1, getCols());
    }
    if (hasRows()) {
      i += WriteStream.bindLength3(2, getRows());
    }
    int j = i + 8 * getValueList().size() + 1 * getValueList().size();
    this.f = j;
    return j;
  }
  
  public double getValue(int paramInt)
  {
    return ((Double)this.e.get(paramInt)).doubleValue();
  }
  
  public int getValueCount()
  {
    return this.e.size();
  }
  
  public List getValueList()
  {
    return this.e;
  }
  
  public boolean hasCols()
  {
    return this.a;
  }
  
  public boolean hasRows()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Matrix mergeFrom(ReadStream paramReadStream)
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
        setCols(paramReadStream.calc3());
        break;
      case 16: 
        setRows(paramReadStream.calc3());
        break;
      case 25: // '\031'
          addValue(paramReadStream.getStatus());
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
  
  public Matrix setCols(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public Matrix setRows(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public Matrix setValue(int paramInt, double paramDouble)
  {
    this.e.set(paramInt, Double.valueOf(paramDouble));
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasCols()) {
      paramWriteStream.dataLength(1, getCols());
    }
    if (hasRows()) {
      paramWriteStream.dataLength(2, getRows());
    }
    Iterator localIterator = getValueList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(3, ((Double)localIterator.next()).doubleValue());
    }
  }
}





public static class MatrixFloat
  extends CacheBase
{
  public static final int COLS_FIELD_NUMBER = 1;
  public static final int ROWS_FIELD_NUMBER = 2;
  public static final int VALUE_FIELD_NUMBER = 3;
  private boolean a;
  private int b = 0;
  private boolean c;
  private int d = 0;
  private List e = Collections.emptyList();
  private int f = -1;
  
  public static MatrixFloat parseFrom(ReadStream paramReadStream)
  {
    return new MatrixFloat().mergeFrom(paramReadStream);
  }
  
  public static MatrixFloat parseFrom(byte[] paramArrayOfByte)
  {
    return (MatrixFloat)new MatrixFloat().mergeFrom(paramArrayOfByte);
  }
  
  public MatrixFloat addValue(float paramFloat)
  {
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(Float.valueOf(paramFloat));
    return this;
  }
  
  public final MatrixFloat clear()
  {
    clearCols();
    clearRows();
    clearValue();
    this.f = -1;
    return this;
  }
  
  public MatrixFloat clearCols()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public MatrixFloat clearRows()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public MatrixFloat clearValue()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public int getCols()
  {
    return this.b;
  }
  
  public int getRows()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasCols();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.bindLength3(1, getCols());
    }
    if (hasRows()) {
      i += WriteStream.bindLength3(2, getRows());
    }
    int j = i + 4 * getValueList().size() + 1 * getValueList().size();
    this.f = j;
    return j;
  }
  
  public float getValue(int paramInt)
  {
    return ((Float)this.e.get(paramInt)).floatValue();
  }
  
  public int getValueCount()
  {
    return this.e.size();
  }
  
  public List getValueList()
  {
    return this.e;
  }
  
  public boolean hasCols()
  {
    return this.a;
  }
  
  public boolean hasRows()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public MatrixFloat mergeFrom(ReadStream paramReadStream)
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
        setCols(paramReadStream.calc3());
        break;
      case 16: 
        setRows(paramReadStream.calc3());
        break;
      case 29: // '\035'
          addValue(paramReadStream.checkResult());
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
  
  public MatrixFloat setCols(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public MatrixFloat setRows(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public MatrixFloat setValue(int paramInt, float paramFloat)
  {
    this.e.set(paramInt, Float.valueOf(paramFloat));
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasCols()) {
      paramWriteStream.dataLength(1, getCols());
    }
    if (hasRows()) {
      paramWriteStream.dataLength(2, getRows());
    }
    Iterator localIterator = getValueList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(3, ((Float)localIterator.next()).floatValue());
    }
  }
}






public static class Measurement
  extends CacheBase
{
  public static final int ACC_SAMPLES_FIELD_NUMBER = 3;
  public static final int GPS_SAMPLES_FIELD_NUMBER = 10;
  public static final int GYRO_SAMPLES_FIELD_NUMBER = 4;
  public static final int LIGHT_SAMPLES_FIELD_NUMBER = 8;
  public static final int MGN_SAMPLES_FIELD_NUMBER = 5;
  public static final int PRESSURE_SAMPLES_FIELD_NUMBER = 6;
  public static final int PROXIMITY_SAMPLES_FIELD_NUMBER = 7;
  public static final int TEMPERATURE_SAMPLES_FIELD_NUMBER = 9;
  public static final int TIME_END_FIELD_NUMBER = 2;
  public static final int TIME_START_FIELD_NUMBER = 1;
  public static final int WIFI_MEASUREMENT_FIELD_NUMBER = 11;
  private boolean a;
  private long b = 0L;
  private boolean c;
  private long d = 0L;
  private List e = Collections.emptyList();
  private List f = Collections.emptyList();
  private List g = Collections.emptyList();
  private List h = Collections.emptyList();
  private List i = Collections.emptyList();
  private List j = Collections.emptyList();
  private List k = Collections.emptyList();
  private List l = Collections.emptyList();
  private boolean m;
  private cmn.WifiMeasurement n = null;
  private int o = -1;
  
  public static Measurement parseFrom(ReadStream paramReadStream)
  {
    return new Measurement().mergeFrom(paramReadStream);
  }
  
  public static Measurement parseFrom(byte[] paramArrayOfByte)
  {
    return (Measurement)new Measurement().mergeFrom(paramArrayOfByte);
  }
  
  public Measurement addAccSamples(cmn.AccSample paramAccSample)
  {
    if (paramAccSample == null) {
      throw new NullPointerException();
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramAccSample);
    return this;
  }
  
  public Measurement addGpsSamples(cmn.GPSSample paramGPSSample)
  {
    if (paramGPSSample == null) {
      throw new NullPointerException();
    }
    if (this.l.isEmpty()) {
      this.l = new ArrayList();
    }
    this.l.add(paramGPSSample);
    return this;
  }
  
  public Measurement addGyroSamples(cmn.GyroSample paramGyroSample)
  {
    if (paramGyroSample == null) {
      throw new NullPointerException();
    }
    if (this.f.isEmpty()) {
      this.f = new ArrayList();
    }
    this.f.add(paramGyroSample);
    return this;
  }
  
  public Measurement addLightSamples(cmn.LightSample paramLightSample)
  {
    if (paramLightSample == null) {
      throw new NullPointerException();
    }
    if (this.j.isEmpty()) {
      this.j = new ArrayList();
    }
    this.j.add(paramLightSample);
    return this;
  }
  
  public Measurement addMgnSamples(cmn.MgnSample paramMgnSample)
  {
    if (paramMgnSample == null) {
      throw new NullPointerException();
    }
    if (this.g.isEmpty()) {
      this.g = new ArrayList();
    }
    this.g.add(paramMgnSample);
    return this;
  }
  
  public Measurement addPressureSamples(cmn.PressureSample paramPressureSample)
  {
    if (paramPressureSample == null) {
      throw new NullPointerException();
    }
    if (this.h.isEmpty()) {
      this.h = new ArrayList();
    }
    this.h.add(paramPressureSample);
    return this;
  }
  
  public Measurement addProximitySamples(cmn.ProximitySample paramProximitySample)
  {
    if (paramProximitySample == null) {
      throw new NullPointerException();
    }
    if (this.i.isEmpty()) {
      this.i = new ArrayList();
    }
    this.i.add(paramProximitySample);
    return this;
  }
  
  public Measurement addTemperatureSamples(cmn.TemperatureSample paramTemperatureSample)
  {
    if (paramTemperatureSample == null) {
      throw new NullPointerException();
    }
    if (this.k.isEmpty()) {
      this.k = new ArrayList();
    }
    this.k.add(paramTemperatureSample);
    return this;
  }
  
  public final Measurement clear()
  {
    clearTimeStart();
    clearTimeEnd();
    clearAccSamples();
    clearGyroSamples();
    clearMgnSamples();
    clearPressureSamples();
    clearProximitySamples();
    clearLightSamples();
    clearTemperatureSamples();
    clearGpsSamples();
    clearWifiMeasurement();
    this.o = -1;
    return this;
  }
  
  public Measurement clearAccSamples()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public Measurement clearGpsSamples()
  {
    this.l = Collections.emptyList();
    return this;
  }
  
  public Measurement clearGyroSamples()
  {
    this.f = Collections.emptyList();
    return this;
  }
  
  public Measurement clearLightSamples()
  {
    this.j = Collections.emptyList();
    return this;
  }
  
  public Measurement clearMgnSamples()
  {
    this.g = Collections.emptyList();
    return this;
  }
  
  public Measurement clearPressureSamples()
  {
    this.h = Collections.emptyList();
    return this;
  }
  
  public Measurement clearProximitySamples()
  {
    this.i = Collections.emptyList();
    return this;
  }
  
  public Measurement clearTemperatureSamples()
  {
    this.k = Collections.emptyList();
    return this;
  }
  
  public Measurement clearTimeEnd()
  {
    this.c = false;
    this.d = 0L;
    return this;
  }
  
  public Measurement clearTimeStart()
  {
    this.a = false;
    this.b = 0L;
    return this;
  }
  
  public Measurement clearWifiMeasurement()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public cmn.AccSample getAccSamples(int paramInt)
  {
    return (cmn.AccSample)this.e.get(paramInt);
  }
  
  public int getAccSamplesCount()
  {
    return this.e.size();
  }
  
  public List getAccSamplesList()
  {
    return this.e;
  }
  
  public int getCachedSize()
  {
    if (this.o < 0) {
      getSerializedSize();
    }
    return this.o;
  }
  
  public cmn.GPSSample getGpsSamples(int paramInt)
  {
    return (cmn.GPSSample)this.l.get(paramInt);
  }
  
  public int getGpsSamplesCount()
  {
    return this.l.size();
  }
  
  public List getGpsSamplesList()
  {
    return this.l;
  }
  
  public cmn.GyroSample getGyroSamples(int paramInt)
  {
    return (cmn.GyroSample)this.f.get(paramInt);
  }
  
  public int getGyroSamplesCount()
  {
    return this.f.size();
  }
  
  public List getGyroSamplesList()
  {
    return this.f;
  }
  
  public cmn.LightSample getLightSamples(int paramInt)
  {
    return (cmn.LightSample)this.j.get(paramInt);
  }
  
  public int getLightSamplesCount()
  {
    return this.j.size();
  }
  
  public List getLightSamplesList()
  {
    return this.j;
  }
  
  public cmn.MgnSample getMgnSamples(int paramInt)
  {
    return (cmn.MgnSample)this.g.get(paramInt);
  }
  
  public int getMgnSamplesCount()
  {
    return this.g.size();
  }
  
  public List getMgnSamplesList()
  {
    return this.g;
  }
  
  public cmn.PressureSample getPressureSamples(int paramInt)
  {
    return (cmn.PressureSample)this.h.get(paramInt);
  }
  
  public int getPressureSamplesCount()
  {
    return this.h.size();
  }
  
  public List getPressureSamplesList()
  {
    return this.h;
  }
  
  public cmn.ProximitySample getProximitySamples(int paramInt)
  {
    return (cmn.ProximitySample)this.i.get(paramInt);
  }
  
  public int getProximitySamplesCount()
  {
    return this.i.size();
  }
  
  public List getProximitySamplesList()
  {
    return this.i;
  }
  

  public int getSerializedSize()
  {
      Iterator iterator;
      int j1;
      boolean flag = hasTimeStart();
      int i1 = 0;
      if(flag)
          i1 = 0 + WriteStream.bindLength(1, getTimeStart());
      if(hasTimeEnd())
          i1 += WriteStream.bindLength(2, getTimeEnd());
      iterator = getAccSamplesList().iterator();
      j1 = i1;

      for(;iterator.hasNext();) {
    	  j1 += WriteStream.dataLength(3, (cmn.AccSample)iterator.next());
      }

      Iterator iterator1 = getGyroSamplesList().iterator();

      for(;iterator1.hasNext();) {
  	      j1 += WriteStream.dataLength(4, (cmn.GyroSample)iterator1.next());
      }

      Iterator iterator2 = getMgnSamplesList().iterator();

      for(;iterator2.hasNext();) {
	      j1 += WriteStream.dataLength(5, (cmn.MgnSample)iterator2.next());
      }

      Iterator iterator3 = getPressureSamplesList().iterator();

      for(;iterator3.hasNext();) {
	      j1 += WriteStream.dataLength(6, (PressureSample)iterator3.next());
      }

      Iterator iterator4 = getProximitySamplesList().iterator();

      for(;iterator4.hasNext();) {
	      j1 += WriteStream.dataLength(7, (ProximitySample)iterator4.next());
      }

      Iterator iterator5 = getLightSamplesList().iterator();
      for(;iterator5.hasNext();) {
	      j1 += WriteStream.dataLength(8, (LightSample)iterator5.next());
      }
      
      Iterator iterator6 = getTemperatureSamplesList().iterator();
      for(;iterator6.hasNext();) {
	      j1 += WriteStream.dataLength(9, (TemperatureSample)iterator6.next());
      }

      Iterator iterator7 = getGpsSamplesList().iterator();

      for(;iterator7.hasNext();)
      {
          j1 += WriteStream.dataLength(10, (cmn.GPSSample)iterator7.next());
      }
      if(hasWifiMeasurement())
          j1 += WriteStream.dataLength(11, getWifiMeasurement());
      o = j1;
      return j1;
  }

  
  
  public cmn.TemperatureSample getTemperatureSamples(int paramInt)
  {
    return (cmn.TemperatureSample)this.k.get(paramInt);
  }
  
  public int getTemperatureSamplesCount()
  {
    return this.k.size();
  }
  
  public List getTemperatureSamplesList()
  {
    return this.k;
  }
  
  public long getTimeEnd()
  {
    return this.d;
  }
  
  public long getTimeStart()
  {
    return this.b;
  }
  
  public cmn.WifiMeasurement getWifiMeasurement()
  {
    return this.n;
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
    return this.m;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Measurement mergeFrom(ReadStream paramReadStream)
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
        cmn.AccSample localAccSample = new cmn.AccSample();
        paramReadStream.getInstance(localAccSample);
        addAccSamples(localAccSample);
        break;
      case 34: 
        cmn.GyroSample localGyroSample = new cmn.GyroSample();
        paramReadStream.getInstance(localGyroSample);
        addGyroSamples(localGyroSample);
        break;
      case 42: 
        cmn.MgnSample localMgnSample = new cmn.MgnSample();
        paramReadStream.getInstance(localMgnSample);
        addMgnSamples(localMgnSample);
        break;
      case 50: 
        cmn.PressureSample localPressureSample = new cmn.PressureSample();
        paramReadStream.getInstance(localPressureSample);
        addPressureSamples(localPressureSample);
        break;
      case 58: 
        cmn.ProximitySample localProximitySample = new cmn.ProximitySample();
        paramReadStream.getInstance(localProximitySample);
        addProximitySamples(localProximitySample);
        break;
      case 66: 
        cmn.LightSample localLightSample = new cmn.LightSample();
        paramReadStream.getInstance(localLightSample);
        addLightSamples(localLightSample);
        break;
      case 74: 
        cmn.TemperatureSample localTemperatureSample = new cmn.TemperatureSample();
        paramReadStream.getInstance(localTemperatureSample);
        addTemperatureSamples(localTemperatureSample);
        break;
      case 82: 
        cmn.GPSSample localGPSSample = new cmn.GPSSample();
        paramReadStream.getInstance(localGPSSample);
        addGpsSamples(localGPSSample);
        break;
      case 90: // 'Z'
          cmn.WifiMeasurement localWifiMeasurement = new cmn.WifiMeasurement();
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
  
  public Measurement setAccSamples(int paramInt, cmn.AccSample paramAccSample)
  {
    if (paramAccSample == null) {
      throw new NullPointerException();
    }
    this.e.set(paramInt, paramAccSample);
    return this;
  }
  
  public Measurement setGpsSamples(int paramInt, cmn.GPSSample paramGPSSample)
  {
    if (paramGPSSample == null) {
      throw new NullPointerException();
    }
    this.l.set(paramInt, paramGPSSample);
    return this;
  }
  
  public Measurement setGyroSamples(int paramInt, cmn.GyroSample paramGyroSample)
  {
    if (paramGyroSample == null) {
      throw new NullPointerException();
    }
    this.f.set(paramInt, paramGyroSample);
    return this;
  }
  
  public Measurement setLightSamples(int paramInt, cmn.LightSample paramLightSample)
  {
    if (paramLightSample == null) {
      throw new NullPointerException();
    }
    this.j.set(paramInt, paramLightSample);
    return this;
  }
  
  public Measurement setMgnSamples(int paramInt, cmn.MgnSample paramMgnSample)
  {
    if (paramMgnSample == null) {
      throw new NullPointerException();
    }
    this.g.set(paramInt, paramMgnSample);
    return this;
  }
  
  public Measurement setPressureSamples(int paramInt, cmn.PressureSample paramPressureSample)
  {
    if (paramPressureSample == null) {
      throw new NullPointerException();
    }
    this.h.set(paramInt, paramPressureSample);
    return this;
  }
  
  public Measurement setProximitySamples(int paramInt, cmn.ProximitySample paramProximitySample)
  {
    if (paramProximitySample == null) {
      throw new NullPointerException();
    }
    this.i.set(paramInt, paramProximitySample);
    return this;
  }
  
  public Measurement setTemperatureSamples(int paramInt, cmn.TemperatureSample paramTemperatureSample)
  {
    if (paramTemperatureSample == null) {
      throw new NullPointerException();
    }
    this.k.set(paramInt, paramTemperatureSample);
    return this;
  }
  
  public Measurement setTimeEnd(long paramLong)
  {
    this.c = true;
    this.d = paramLong;
    return this;
  }
  
  public Measurement setTimeStart(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public Measurement setWifiMeasurement(cmn.WifiMeasurement paramWifiMeasurement)
  {
    if (paramWifiMeasurement == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramWifiMeasurement;
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
    Iterator localIterator1 = getAccSamplesList().iterator();
    Iterator localIterator2;
    Iterator localIterator3;
    Iterator localIterator4;
    Iterator localIterator5;
    Iterator localIterator6;
    Iterator localIterator7;
    Iterator localIterator8;
    for (;localIterator1.hasNext();) {
    	paramWriteStream.getInstance(3, (cmn.AccSample)localIterator1.next());
    }
      localIterator2 = getGyroSamplesList().iterator();
      for (;localIterator2.hasNext();) {
         paramWriteStream.getInstance(4, (cmn.GyroSample)localIterator2.next());
      }
      localIterator3 = getMgnSamplesList().iterator();
      for (;localIterator3.hasNext();) {
         paramWriteStream.getInstance(5, (cmn.MgnSample)localIterator3.next());
      }
      localIterator4 = getPressureSamplesList().iterator();
      for (;localIterator4.hasNext();) {
              paramWriteStream.getInstance(6, (cmn.PressureSample)localIterator4.next());
      }
      localIterator5 = getProximitySamplesList().iterator();
      for(;localIterator5.hasNext();) {
              paramWriteStream.getInstance(7, (cmn.ProximitySample)localIterator5.next());
      }
      localIterator6 = getLightSamplesList().iterator();
      for (;localIterator6.hasNext();) {
              paramWriteStream.getInstance(8, (cmn.LightSample)localIterator6.next());
      }
      localIterator7 = getTemperatureSamplesList().iterator();
      for (;localIterator7.hasNext();) {
              paramWriteStream.getInstance(9, (cmn.TemperatureSample)localIterator7.next());
      }
      	localIterator8 = getGpsSamplesList().iterator();
      for (;localIterator8.hasNext();) {
    	  paramWriteStream.getInstance(10, (cmn.GPSSample)localIterator8.next());
      }
    if (hasWifiMeasurement()) {
        paramWriteStream.getInstance(11, getWifiMeasurement());
    }
  }
  
}




public static class MgnSample
extends CacheBase
{
public static final int MGN_ACCURACY_FIELD_NUMBER = 5;
public static final int MGN_TIMESTAMP_FIELD_NUMBER = 1;
public static final int MGN_X_FIELD_NUMBER = 2;
public static final int MGN_Y_FIELD_NUMBER = 3;
public static final int MGN_Z_FIELD_NUMBER = 4;
private boolean a;
private long b = 0L;
private boolean c;
private float d = 0.0F;
private boolean e;
private float f = 0.0F;
private boolean g;
private float h = 0.0F;
private boolean i;
private int j = 0;
private int k = -1;

public static MgnSample parseFrom(ReadStream paramReadStream)
{
  return new MgnSample().mergeFrom(paramReadStream);
}

public static MgnSample parseFrom(byte[] paramArrayOfByte)
{
  return (MgnSample)new MgnSample().mergeFrom(paramArrayOfByte);
}

public final MgnSample clear()
{
  clearMgnTimestamp();
  clearMgnX();
  clearMgnY();
  clearMgnZ();
  clearMgnAccuracy();
  this.k = -1;
  return this;
}

public MgnSample clearMgnAccuracy()
{
  this.i = false;
  this.j = 0;
  return this;
}

public MgnSample clearMgnTimestamp()
{
  this.a = false;
  this.b = 0L;
  return this;
}

public MgnSample clearMgnX()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public MgnSample clearMgnY()
{
  this.e = false;
  this.f = 0.0F;
  return this;
}

public MgnSample clearMgnZ()
{
  this.g = false;
  this.h = 0.0F;
  return this;
}

public int getCachedSize()
{
  if (this.k < 0) {
    getSerializedSize();
  }
  return this.k;
}

public int getMgnAccuracy()
{
  return this.j;
}

public long getMgnTimestamp()
{
  return this.b;
}

public float getMgnX()
{
  return this.d;
}

public float getMgnY()
{
  return this.f;
}

public float getMgnZ()
{
  return this.h;
}

public int getSerializedSize()
{
  boolean bool = hasMgnTimestamp();
  int m = 0;
  if (bool) {
    m = 0 + WriteStream.bindLength(1, getMgnTimestamp());
  }
  if (hasMgnX()) {
    m += WriteStream.dataLength(2, getMgnX());
  }
  if (hasMgnY()) {
    m += WriteStream.dataLength(3, getMgnY());
  }
  if (hasMgnZ()) {
    m += WriteStream.dataLength(4, getMgnZ());
  }
  if (hasMgnAccuracy()) {
    m += WriteStream.bindLength3(5, getMgnAccuracy());
  }
  this.k = m;
  return m;
}

public boolean hasMgnAccuracy()
{
  return this.i;
}

public boolean hasMgnTimestamp()
{
  return this.a;
}

public boolean hasMgnX()
{
  return this.c;
}

public boolean hasMgnY()
{
  return this.e;
}

public boolean hasMgnZ()
{
  return this.g;
}

public final boolean isInitialized()
{
  return true;
}

public MgnSample mergeFrom(ReadStream paramReadStream)
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
    case 8: 
      setMgnTimestamp(paramReadStream.is1());
      break;
    case 21: 
      setMgnX(paramReadStream.checkResult());
      break;
    case 29: 
      setMgnY(paramReadStream.checkResult());
      break;
    case 37: 
      setMgnZ(paramReadStream.checkResult());
      break;
    case 40: // '('
        setMgnAccuracy(paramReadStream.calc3());
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

public MgnSample setMgnAccuracy(int paramInt)
{
  this.i = true;
  this.j = paramInt;
  return this;
}

public MgnSample setMgnTimestamp(long paramLong)
{
  this.a = true;
  this.b = paramLong;
  return this;
}

public MgnSample setMgnX(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public MgnSample setMgnY(float paramFloat)
{
  this.e = true;
  this.f = paramFloat;
  return this;
}

public MgnSample setMgnZ(float paramFloat)
{
  this.g = true;
  this.h = paramFloat;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasMgnTimestamp()) {
    paramWriteStream.getInstance(1, getMgnTimestamp());
  }
  if (hasMgnX()) {
    paramWriteStream.getInstance(2, getMgnX());
  }
  if (hasMgnY()) {
    paramWriteStream.getInstance(3, getMgnY());
  }
  if (hasMgnZ()) {
    paramWriteStream.getInstance(4, getMgnZ());
  }
  if (hasMgnAccuracy()) {
    paramWriteStream.dataLength(5, getMgnAccuracy());
  }
}
}




public static class OnlineMeasurement
  extends CacheBase
{
  public static final int ACC_FIELD_NUMBER = 3;
  public static final int GPS_SAMPLES_FIELD_NUMBER = 10;
  public static final int GYRO_FIELD_NUMBER = 4;
  public static final int LIGHT_FIELD_NUMBER = 8;
  public static final int MGN_FIELD_NUMBER = 5;
  public static final int PRESSURE_FIELD_NUMBER = 6;
  public static final int PROXIMITY_FIELD_NUMBER = 7;
  public static final int TEMPERATURE_FIELD_NUMBER = 9;
  public static final int TIME_END_FIELD_NUMBER = 2;
  public static final int TIME_START_FIELD_NUMBER = 1;
  public static final int WIFI_MEASUREMENT_FIELD_NUMBER = 11;
  private boolean a;
  private long b = 0L;
  private boolean c;
  private long d = 0L;
  private boolean e;
  private cmn.EncodedThreeValuedSignal f = null;
  private boolean g;
  private cmn.EncodedThreeValuedSignal h = null;
  private boolean i;
  private cmn.EncodedThreeValuedSignal j = null;
  private boolean k;
  private cmn.EncodedOneValuedSignal l = null;
  private boolean m;
  private cmn.EncodedOneValuedSignal n = null;
  private boolean o;
  private cmn.EncodedOneValuedSignal p = null;
  private boolean q;
  private cmn.EncodedOneValuedSignal r = null;
  private List s = Collections.emptyList();
  private boolean t;
  private cmn.WifiMeasurement u = null;
  private int v = -1;
  
  public static OnlineMeasurement parseFrom(ReadStream paramReadStream)
  {
    return new OnlineMeasurement().mergeFrom(paramReadStream);
  }
  
  public static OnlineMeasurement parseFrom(byte[] paramArrayOfByte)
  {
    return (OnlineMeasurement)new OnlineMeasurement().mergeFrom(paramArrayOfByte);
  }
  
  public OnlineMeasurement addGpsSamples(cmn.GPSSample paramGPSSample)
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
    clearAcc();
    clearGyro();
    clearMgn();
    clearPressure();
    clearProximity();
    clearLight();
    clearTemperature();
    clearGpsSamples();
    clearWifiMeasurement();
    this.v = -1;
    return this;
  }
  
  public OnlineMeasurement clearAcc()
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
  
  public OnlineMeasurement clearGyro()
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
  
  public OnlineMeasurement clearMgn()
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
  
  public cmn.EncodedThreeValuedSignal getAcc()
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
  
  public cmn.GPSSample getGpsSamples(int paramInt)
  {
    return (cmn.GPSSample)this.s.get(paramInt);
  }
  
  public int getGpsSamplesCount()
  {
    return this.s.size();
  }
  
  public List getGpsSamplesList()
  {
    return this.s;
  }
  
  public cmn.EncodedThreeValuedSignal getGyro()
  {
    return this.h;
  }
  
  public cmn.EncodedOneValuedSignal getLight()
  {
    return this.p;
  }
  
  public cmn.EncodedThreeValuedSignal getMgn()
  {
    return this.j;
  }
  
  public cmn.EncodedOneValuedSignal getPressure()
  {
    return this.l;
  }
  
  public cmn.EncodedOneValuedSignal getProximity()
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
    if (hasAcc()) {
      i1 += WriteStream.dataLength(3, getAcc());
    }
    if (hasGyro()) {
      i1 += WriteStream.dataLength(4, getGyro());
    }
    if (hasMgn()) {
      i1 += WriteStream.dataLength(5, getMgn());
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
      i2 += WriteStream.dataLength(10, (cmn.GPSSample)localIterator.next());
    }
    if (hasWifiMeasurement()) {
        i2 += WriteStream.dataLength(11, getWifiMeasurement());
    }
    this.v = i2;
    return i2;
    
  }
  
  public cmn.EncodedOneValuedSignal getTemperature()
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
  
  public cmn.WifiMeasurement getWifiMeasurement()
  {
    return this.u;
  }
  
  public boolean hasAcc()
  {
    return this.e;
  }
  
  public boolean hasGyro()
  {
    return this.g;
  }
  
  public boolean hasLight()
  {
    return this.o;
  }
  
  public boolean hasMgn()
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
    return true;
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
        cmn.EncodedThreeValuedSignal localEncodedThreeValuedSignal3 = new cmn.EncodedThreeValuedSignal();
        paramReadStream.getInstance(localEncodedThreeValuedSignal3);
        setAcc(localEncodedThreeValuedSignal3);
        break;
      case 34: 
        cmn.EncodedThreeValuedSignal localEncodedThreeValuedSignal2 = new cmn.EncodedThreeValuedSignal();
        paramReadStream.getInstance(localEncodedThreeValuedSignal2);
        setGyro(localEncodedThreeValuedSignal2);
        break;
      case 42: 
        cmn.EncodedThreeValuedSignal localEncodedThreeValuedSignal1 = new cmn.EncodedThreeValuedSignal();
        paramReadStream.getInstance(localEncodedThreeValuedSignal1);
        setMgn(localEncodedThreeValuedSignal1);
        break;
      case 50: 
        cmn.EncodedOneValuedSignal localEncodedOneValuedSignal4 = new cmn.EncodedOneValuedSignal();
        paramReadStream.getInstance(localEncodedOneValuedSignal4);
        setPressure(localEncodedOneValuedSignal4);
        break;
      case 58: 
        cmn.EncodedOneValuedSignal localEncodedOneValuedSignal3 = new cmn.EncodedOneValuedSignal();
        paramReadStream.getInstance(localEncodedOneValuedSignal3);
        setProximity(localEncodedOneValuedSignal3);
        break;
      case 66: 
        cmn.EncodedOneValuedSignal localEncodedOneValuedSignal2 = new cmn.EncodedOneValuedSignal();
        paramReadStream.getInstance(localEncodedOneValuedSignal2);
        setLight(localEncodedOneValuedSignal2);
        break;
      case 74: 
        cmn.EncodedOneValuedSignal localEncodedOneValuedSignal1 = new cmn.EncodedOneValuedSignal();
        paramReadStream.getInstance(localEncodedOneValuedSignal1);
        setTemperature(localEncodedOneValuedSignal1);
        break;
      case 82: 
        cmn.GPSSample localGPSSample = new cmn.GPSSample();
        paramReadStream.getInstance(localGPSSample);
        addGpsSamples(localGPSSample);
        break;
      case 90: // 'Z'
          cmn.WifiMeasurement localWifiMeasurement = new cmn.WifiMeasurement();
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
  
  public OnlineMeasurement setAcc(cmn.EncodedThreeValuedSignal paramEncodedThreeValuedSignal)
  {
    if (paramEncodedThreeValuedSignal == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramEncodedThreeValuedSignal;
    return this;
  }
  
  public OnlineMeasurement setGpsSamples(int paramInt, cmn.GPSSample paramGPSSample)
  {
    if (paramGPSSample == null) {
      throw new NullPointerException();
    }
    this.s.set(paramInt, paramGPSSample);
    return this;
  }
  
  public OnlineMeasurement setGyro(cmn.EncodedThreeValuedSignal paramEncodedThreeValuedSignal)
  {
    if (paramEncodedThreeValuedSignal == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramEncodedThreeValuedSignal;
    return this;
  }
  
  public OnlineMeasurement setLight(cmn.EncodedOneValuedSignal paramEncodedOneValuedSignal)
  {
    if (paramEncodedOneValuedSignal == null) {
      throw new NullPointerException();
    }
    this.o = true;
    this.p = paramEncodedOneValuedSignal;
    return this;
  }
  
  public OnlineMeasurement setMgn(cmn.EncodedThreeValuedSignal paramEncodedThreeValuedSignal)
  {
    if (paramEncodedThreeValuedSignal == null) {
      throw new NullPointerException();
    }
    this.i = true;
    this.j = paramEncodedThreeValuedSignal;
    return this;
  }
  
  public OnlineMeasurement setPressure(cmn.EncodedOneValuedSignal paramEncodedOneValuedSignal)
  {
    if (paramEncodedOneValuedSignal == null) {
      throw new NullPointerException();
    }
    this.k = true;
    this.l = paramEncodedOneValuedSignal;
    return this;
  }
  
  public OnlineMeasurement setProximity(cmn.EncodedOneValuedSignal paramEncodedOneValuedSignal)
  {
    if (paramEncodedOneValuedSignal == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramEncodedOneValuedSignal;
    return this;
  }
  
  public OnlineMeasurement setTemperature(cmn.EncodedOneValuedSignal paramEncodedOneValuedSignal)
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
  
  public OnlineMeasurement setWifiMeasurement(cmn.WifiMeasurement paramWifiMeasurement)
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
    if (hasAcc()) {
      paramWriteStream.getInstance(3, getAcc());
    }
    if (hasGyro()) {
      paramWriteStream.getInstance(4, getGyro());
    }
    if (hasMgn()) {
      paramWriteStream.getInstance(5, getMgn());
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
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (hasWifiMeasurement()) {
          paramWriteStream.getInstance(11, getWifiMeasurement());
        }
        return;
      }
      paramWriteStream.getInstance(10, (cmn.GPSSample)localIterator.next());
    }
  }
}



public static class PixelPosition
extends CacheBase
{
public static final int I_FIELD_NUMBER = 1;
public static final int J_FIELD_NUMBER = 2;
private boolean a;
private float b = 0.0F;
private boolean c;
private float d = 0.0F;
private int e = -1;

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
  clearI();
  clearJ();
  this.e = -1;
  return this;
}

public PixelPosition clearI()
{
  this.a = false;
  this.b = 0.0F;
  return this;
}

public PixelPosition clearJ()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public int getCachedSize()
{
  if (this.e < 0) {
    getSerializedSize();
  }
  return this.e;
}

public float getI()
{
  return this.b;
}

public float getJ()
{
  return this.d;
}

public int getSerializedSize()
{
  boolean bool = hasI();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getI());
  }
  if (hasJ()) {
    i += WriteStream.dataLength(2, getJ());
  }
  this.e = i;
  return i;
}

public boolean hasI()
{
  return this.a;
}

public boolean hasJ()
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
      setI(paramReadStream.checkResult());
      break;
    case 21: // '\025'
        setJ(paramReadStream.checkResult());
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

public PixelPosition setI(float paramFloat)
{
  this.a = true;
  this.b = paramFloat;
  return this;
}

public PixelPosition setJ(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasI()) {
    paramWriteStream.getInstance(1, getI());
  }
  if (hasJ()) {
    paramWriteStream.getInstance(2, getJ());
  }
}
}




public static class PressureSample
extends CacheBase
{
public static final int PRESSURE_FIELD_NUMBER = 2;
public static final int PRESSURE_TIMESTAMP_FIELD_NUMBER = 1;
private boolean a;
private long b = 0L;
private boolean c;
private float d = 0.0F;
private int e = -1;

public static PressureSample parseFrom(ReadStream paramReadStream)
{
  return new PressureSample().mergeFrom(paramReadStream);
}

public static PressureSample parseFrom(byte[] paramArrayOfByte)
{
  return (PressureSample)new PressureSample().mergeFrom(paramArrayOfByte);
}

public final PressureSample clear()
{
  clearPressureTimestamp();
  clearPressure();
  this.e = -1;
  return this;
}

public PressureSample clearPressure()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public PressureSample clearPressureTimestamp()
{
  this.a = false;
  this.b = 0L;
  return this;
}

public int getCachedSize()
{
  if (this.e < 0) {
    getSerializedSize();
  }
  return this.e;
}

public float getPressure()
{
  return this.d;
}

public long getPressureTimestamp()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasPressureTimestamp();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.bindLength(1, getPressureTimestamp());
  }
  if (hasPressure()) {
    i += WriteStream.dataLength(2, getPressure());
  }
  this.e = i;
  return i;
}

public boolean hasPressure()
{
  return this.c;
}

public boolean hasPressureTimestamp()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public PressureSample mergeFrom(ReadStream paramReadStream)
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
      setPressureTimestamp(paramReadStream.is1());
      break;
    case 21: // '\025'
        setPressure(paramReadStream.checkResult());
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

public PressureSample setPressure(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public PressureSample setPressureTimestamp(long paramLong)
{
  this.a = true;
  this.b = paramLong;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasPressureTimestamp()) {
    paramWriteStream.getInstance(1, getPressureTimestamp());
  }
  if (hasPressure()) {
    paramWriteStream.getInstance(2, getPressure());
  }
}
}




public static class ProximitySample
extends CacheBase
{
public static final int PROXIMITY_FIELD_NUMBER = 2;
public static final int PROXIMITY_TIMESTAMP_FIELD_NUMBER = 1;
private boolean a;
private long b = 0L;
private boolean c;
private float d = 0.0F;
private int e = -1;

public static ProximitySample parseFrom(ReadStream paramReadStream)
{
  return new ProximitySample().mergeFrom(paramReadStream);
}

public static ProximitySample parseFrom(byte[] paramArrayOfByte)
{
  return (ProximitySample)new ProximitySample().mergeFrom(paramArrayOfByte);
}

public final ProximitySample clear()
{
  clearProximityTimestamp();
  clearProximity();
  this.e = -1;
  return this;
}

public ProximitySample clearProximity()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public ProximitySample clearProximityTimestamp()
{
  this.a = false;
  this.b = 0L;
  return this;
}

public int getCachedSize()
{
  if (this.e < 0) {
    getSerializedSize();
  }
  return this.e;
}

public float getProximity()
{
  return this.d;
}

public long getProximityTimestamp()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasProximityTimestamp();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.bindLength(1, getProximityTimestamp());
  }
  if (hasProximity()) {
    i += WriteStream.dataLength(2, getProximity());
  }
  this.e = i;
  return i;
}

public boolean hasProximity()
{
  return this.c;
}

public boolean hasProximityTimestamp()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public ProximitySample mergeFrom(ReadStream paramReadStream)
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
      setProximityTimestamp(paramReadStream.is1());
      break;
    case 21: // '\025'
        setProximity(paramReadStream.checkResult());
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

public ProximitySample setProximity(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public ProximitySample setProximityTimestamp(long paramLong)
{
  this.a = true;
  this.b = paramLong;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasProximityTimestamp()) {
    paramWriteStream.getInstance(1, getProximityTimestamp());
  }
  if (hasProximity()) {
    paramWriteStream.getInstance(2, getProximity());
  }
}
}




public static class RoutePoint
extends CacheBase
{
public static final int X_FIELD_NUMBER = 1;
public static final int Y_FIELD_NUMBER = 2;
public static final int Z_FIELD_NUMBER = 3;
private boolean a;
private float b = 0.0F;
private boolean c;
private float d = 0.0F;
private boolean e;
private float f = 0.0F;
private int g = -1;

public static RoutePoint parseFrom(ReadStream paramReadStream)
{
  return new RoutePoint().mergeFrom(paramReadStream);
}

public static RoutePoint parseFrom(byte[] paramArrayOfByte)
{
  return (RoutePoint)new RoutePoint().mergeFrom(paramArrayOfByte);
}

public final RoutePoint clear()
{
  clearX();
  clearY();
  clearZ();
  this.g = -1;
  return this;
}

public RoutePoint clearX()
{
  this.a = false;
  this.b = 0.0F;
  return this;
}

public RoutePoint clearY()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public RoutePoint clearZ()
{
  this.e = false;
  this.f = 0.0F;
  return this;
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
  boolean bool = hasX();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getX());
  }
  if (hasY()) {
    i += WriteStream.dataLength(2, getY());
  }
  if (hasZ()) {
    i += WriteStream.dataLength(3, getZ());
  }
  this.g = i;
  return i;
}

public float getX()
{
  return this.b;
}

public float getY()
{
  return this.d;
}

public float getZ()
{
  return this.f;
}

public boolean hasX()
{
  return this.a;
}

public boolean hasY()
{
  return this.c;
}

public boolean hasZ()
{
  return this.e;
}

public final boolean isInitialized()
{
  return true;
}

public RoutePoint mergeFrom(ReadStream paramReadStream)
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
      setX(paramReadStream.checkResult());
      break;
    case 21: 
      setY(paramReadStream.checkResult());
      break;
    case 29: // '\035'
        setZ(paramReadStream.checkResult());
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

public RoutePoint setX(float paramFloat)
{
  this.a = true;
  this.b = paramFloat;
  return this;
}

public RoutePoint setY(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public RoutePoint setZ(float paramFloat)
{
  this.e = true;
  this.f = paramFloat;
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
  if (hasZ()) {
    paramWriteStream.getInstance(3, getZ());
  }
}
}



public static class TemperatureSample
extends CacheBase
{
public static final int TEMPERATURE_FIELD_NUMBER = 2;
public static final int TEMPERATURE_TIMESTAMP_FIELD_NUMBER = 1;
private boolean a;
private long b = 0L;
private boolean c;
private float d = 0.0F;
private int e = -1;

public static TemperatureSample parseFrom(ReadStream paramReadStream)
{
  return new TemperatureSample().mergeFrom(paramReadStream);
}

public static TemperatureSample parseFrom(byte[] paramArrayOfByte)
{
  return (TemperatureSample)new TemperatureSample().mergeFrom(paramArrayOfByte);
}

public final TemperatureSample clear()
{
  clearTemperatureTimestamp();
  clearTemperature();
  this.e = -1;
  return this;
}

public TemperatureSample clearTemperature()
{
  this.c = false;
  this.d = 0.0F;
  return this;
}

public TemperatureSample clearTemperatureTimestamp()
{
  this.a = false;
  this.b = 0L;
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
  boolean bool = hasTemperatureTimestamp();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.bindLength(1, getTemperatureTimestamp());
  }
  if (hasTemperature()) {
    i += WriteStream.dataLength(2, getTemperature());
  }
  this.e = i;
  return i;
}

public float getTemperature()
{
  return this.d;
}

public long getTemperatureTimestamp()
{
  return this.b;
}

public boolean hasTemperature()
{
  return this.c;
}

public boolean hasTemperatureTimestamp()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public TemperatureSample mergeFrom(ReadStream paramReadStream)
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
      setTemperatureTimestamp(paramReadStream.is1());
      break;
    case 21: // '\025'
        setTemperature(paramReadStream.checkResult());
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

public TemperatureSample setTemperature(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public TemperatureSample setTemperatureTimestamp(long paramLong)
{
  this.a = true;
  this.b = paramLong;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasTemperatureTimestamp()) {
    paramWriteStream.getInstance(1, getTemperatureTimestamp());
  }
  if (hasTemperature()) {
    paramWriteStream.getInstance(2, getTemperature());
  }
}
}




public static class Transformations
extends CacheBase
{
public static final int GEO_TO_PIXEL_MATRIX_FIELD_NUMBER = 5;
public static final int METER_TO_PIXEL_MATRIX_FIELD_NUMBER = 3;
public static final int PIXEL_TO_GEO_MATRIX_FIELD_NUMBER = 4;
public static final int PIXEL_TO_METER_MATRIX_FIELD_NUMBER = 2;
public static final int PIXEL_TO_METER_RATIO_FIELD_NUMBER = 1;
private boolean a;
private float b = 0.0F;
private boolean c;
private cmn.Matrix d = null;
private boolean e;
private cmn.Matrix f = null;
private boolean g;
private cmn.Matrix h = null;
private boolean i;
private cmn.Matrix j = null;
private int k = -1;

public static Transformations parseFrom(ReadStream paramReadStream)
{
  return new Transformations().mergeFrom(paramReadStream);
}

public static Transformations parseFrom(byte[] paramArrayOfByte)
{
  return (Transformations)new Transformations().mergeFrom(paramArrayOfByte);
}

public final Transformations clear()
{
  clearPixelToMeterRatio();
  clearPixelToMeterMatrix();
  clearMeterToPixelMatrix();
  clearPixelToGeoMatrix();
  clearGeoToPixelMatrix();
  this.k = -1;
  return this;
}

public Transformations clearGeoToPixelMatrix()
{
  this.i = false;
  this.j = null;
  return this;
}

public Transformations clearMeterToPixelMatrix()
{
  this.e = false;
  this.f = null;
  return this;
}

public Transformations clearPixelToGeoMatrix()
{
  this.g = false;
  this.h = null;
  return this;
}

public Transformations clearPixelToMeterMatrix()
{
  this.c = false;
  this.d = null;
  return this;
}

public Transformations clearPixelToMeterRatio()
{
  this.a = false;
  this.b = 0.0F;
  return this;
}

public int getCachedSize()
{
  if (this.k < 0) {
    getSerializedSize();
  }
  return this.k;
}

public cmn.Matrix getGeoToPixelMatrix()
{
  return this.j;
}

public cmn.Matrix getMeterToPixelMatrix()
{
  return this.f;
}

public cmn.Matrix getPixelToGeoMatrix()
{
  return this.h;
}

public cmn.Matrix getPixelToMeterMatrix()
{
  return this.d;
}

public float getPixelToMeterRatio()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasPixelToMeterRatio();
  int m = 0;
  if (bool) {
    m = 0 + WriteStream.dataLength(1, getPixelToMeterRatio());
  }
  if (hasPixelToMeterMatrix()) {
    m += WriteStream.dataLength(2, getPixelToMeterMatrix());
  }
  if (hasMeterToPixelMatrix()) {
    m += WriteStream.dataLength(3, getMeterToPixelMatrix());
  }
  if (hasPixelToGeoMatrix()) {
    m += WriteStream.dataLength(4, getPixelToGeoMatrix());
  }
  if (hasGeoToPixelMatrix()) {
    m += WriteStream.dataLength(5, getGeoToPixelMatrix());
  }
  this.k = m;
  return m;
}

public boolean hasGeoToPixelMatrix()
{
  return this.i;
}

public boolean hasMeterToPixelMatrix()
{
  return this.e;
}

public boolean hasPixelToGeoMatrix()
{
  return this.g;
}

public boolean hasPixelToMeterMatrix()
{
  return this.c;
}

public boolean hasPixelToMeterRatio()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public Transformations mergeFrom(ReadStream paramReadStream)
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
    case 13: 
      setPixelToMeterRatio(paramReadStream.checkResult());
      break;
    case 18: 
      cmn.Matrix localMatrix4 = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix4);
      setPixelToMeterMatrix(localMatrix4);
      break;
    case 26: 
      cmn.Matrix localMatrix3 = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix3);
      setMeterToPixelMatrix(localMatrix3);
      break;
    case 34: 
      cmn.Matrix localMatrix2 = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix2);
      setPixelToGeoMatrix(localMatrix2);
      break;
    case 42: // '*'
        cmn.Matrix localMatrix1 = new cmn.Matrix();
        paramReadStream.getInstance(localMatrix1);
        setGeoToPixelMatrix(localMatrix1);
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

public Transformations setGeoToPixelMatrix(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.i = true;
  this.j = paramMatrix;
  return this;
}

public Transformations setMeterToPixelMatrix(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.e = true;
  this.f = paramMatrix;
  return this;
}

public Transformations setPixelToGeoMatrix(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.g = true;
  this.h = paramMatrix;
  return this;
}

public Transformations setPixelToMeterMatrix(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.c = true;
  this.d = paramMatrix;
  return this;
}

public Transformations setPixelToMeterRatio(float paramFloat)
{
  this.a = true;
  this.b = paramFloat;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasPixelToMeterRatio()) {
    paramWriteStream.getInstance(1, getPixelToMeterRatio());
  }
  if (hasPixelToMeterMatrix()) {
    paramWriteStream.getInstance(2, getPixelToMeterMatrix());
  }
  if (hasMeterToPixelMatrix()) {
    paramWriteStream.getInstance(3, getMeterToPixelMatrix());
  }
  if (hasPixelToGeoMatrix()) {
    paramWriteStream.getInstance(4, getPixelToGeoMatrix());
  }
  if (hasGeoToPixelMatrix()) {
    paramWriteStream.getInstance(5, getGeoToPixelMatrix());
  }
}
}




public static class Value
extends CacheBase
{
public static final int TYPE_FIELD_NUMBER = 1;
public static final int VALUE_FIELD_NUMBER = 2;
private boolean a;
private int b = 0;
private boolean c;
private float d = 0.0F;
private int e = -1;

public static Value parseFrom(ReadStream paramReadStream)
{
  return new Value().mergeFrom(paramReadStream);
}

public static Value parseFrom(byte[] paramArrayOfByte)
{
  return (Value)new Value().mergeFrom(paramArrayOfByte);
}

public final Value clear()
{
  clearType();
  clearValue();
  this.e = -1;
  return this;
}

public Value clearType()
{
  this.a = false;
  this.b = 0;
  return this;
}

public Value clearValue()
{
  this.c = false;
  this.d = 0.0F;
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
    i = 0 + WriteStream.bindLength3(1, getType());
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

public float getValue()
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
  return true;
}

public Value mergeFrom(ReadStream paramReadStream)
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
      setType(paramReadStream.calc3());
      break;
    case 21: // '\025'
        setValue(paramReadStream.checkResult());
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

public Value setType(int paramInt)
{
  this.a = true;
  this.b = paramInt;
  return this;
}

public Value setValue(float paramFloat)
{
  this.c = true;
  this.d = paramFloat;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasType()) {
    paramWriteStream.dataLength(1, getType());
  }
  if (hasValue()) {
    paramWriteStream.getInstance(2, getValue());
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
private String b = "";
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
  this.b = "";
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

public String getId()
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
  return true;
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
      setId(paramReadStream.getStr());
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

public WifiAP setId(String paramString)
{
  this.a = true;
  this.b = paramString;
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
public static final int AP_FIELD_NUMBER = 2;
public static final int WIFI_SCAN_FIELD_NUMBER = 1;
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

public WifiMeasurement addAp(cmn.WifiAP paramWifiAP)
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

public WifiMeasurement addWifiScan(cmn.WifiScan paramWifiScan)
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
  clearWifiScan();
  clearAp();
  this.c = -1;
  return this;
}

public WifiMeasurement clearAp()
{
  this.b = Collections.emptyList();
  return this;
}

public WifiMeasurement clearWifiScan()
{
  this.a = Collections.emptyList();
  return this;
}

public cmn.WifiAP getAp(int paramInt)
{
  return (cmn.WifiAP)this.b.get(paramInt);
}

public int getApCount()
{
  return this.b.size();
}

public List getApList()
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
  Iterator localIterator1 = getWifiScanList().iterator();
  int i = 0;
  Iterator localIterator2;
  for (;localIterator1.hasNext();) {
	 i += WriteStream.dataLength(1, (cmn.WifiScan)localIterator1.next());
  }
  localIterator2 = getApList().iterator();

  for (;localIterator2.hasNext();)
  {
     i += WriteStream.dataLength(2, (cmn.WifiAP)localIterator2.next());
  }
  
  this.c = i;
  return i;
  
}

public cmn.WifiScan getWifiScan(int paramInt)
{
  return (cmn.WifiScan)this.a.get(paramInt);
}

public int getWifiScanCount()
{
  return this.a.size();
}

public List getWifiScanList()
{
  return this.a;
}

public final boolean isInitialized()
{
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
      cmn.WifiScan localWifiScan = new cmn.WifiScan();
      paramReadStream.getInstance(localWifiScan);
      addWifiScan(localWifiScan);
      break;
    case 18: // '\022'
        cmn.WifiAP localWifiAP = new cmn.WifiAP();
        paramReadStream.getInstance(localWifiAP);
        addAp(localWifiAP);
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

public WifiMeasurement setAp(int paramInt, cmn.WifiAP paramWifiAP)
{
  if (paramWifiAP == null) {
    throw new NullPointerException();
  }
  this.b.set(paramInt, paramWifiAP);
  return this;
}

public WifiMeasurement setWifiScan(int paramInt, cmn.WifiScan paramWifiScan)
{
  if (paramWifiScan == null) {
    throw new NullPointerException();
  }
  this.a.set(paramInt, paramWifiScan);
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  Iterator localIterator1 = getWifiScanList().iterator();
  Iterator localIterator2;
  for (;localIterator1.hasNext();) {
      paramWriteStream.getInstance(1, (cmn.WifiScan)localIterator1.next());
  }
  localIterator2 = getApList().iterator();
  for (;localIterator2.hasNext();)
  {
     paramWriteStream.getInstance(2, (cmn.WifiAP)localIterator2.next());
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

public WifiScan addScan(cmn.WifiScanEntry paramWifiScanEntry)
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

public cmn.WifiScanEntry getScan(int paramInt)
{
  return (cmn.WifiScanEntry)this.c.get(paramInt);
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
    j += WriteStream.dataLength(2, (cmn.WifiScanEntry)localIterator.next());
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
  return true;
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
        cmn.WifiScanEntry localWifiScanEntry = new cmn.WifiScanEntry();
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

public WifiScan setScan(int paramInt, cmn.WifiScanEntry paramWifiScanEntry)
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
    paramWriteStream.getInstance(2, (cmn.WifiScanEntry)localIterator.next());
  }
}
}






public static class WifiScanEntry
  extends CacheBase
{
  public static final int ACCESS_POINT_ID_FIELD_NUMBER = 3;
  public static final int ACCESS_POINT_NUM_FIELD_NUMBER = 2;
  public static final int SIGNAL_STRENGTH_FIELD_NUMBER = 1;
  private boolean a;
  private float b = 0.0F;
  private boolean c;
  private int d = 0;
  private boolean e;
  private String f = "";
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
    this.f = "";
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
  
  public String getAccessPointId()
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
    return true;
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
          setAccessPointId(paramReadStream.getStr());
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
  
  public WifiScanEntry setAccessPointId(String paramString)
  {
    this.e = true;
    this.f = paramString;
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
    
	  try {
		  if (hasSignalStrength()) {
			  paramWriteStream.getInstance(1, getSignalStrength());
			}
			if (hasAccessPointNum()) {
			  paramWriteStream.dataLength(2, getAccessPointNum());
			}
			if (hasAccessPointId()) {
			  paramWriteStream.getInstance(3, getAccessPointId());
			}
      } catch(ExceptionManager mng) {
    	  mng.printStackTrace();
      } catch(Exception ex) {
    	  ex.printStackTrace();
      }
    
  }
}




}
