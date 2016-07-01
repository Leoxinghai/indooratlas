// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.communication;
import com.xinghai.indoor.util.CacheBase;
import com.xinghai.indoor.util.ExceptionManager;
import com.xinghai.indoor.util.ReadStream;
import com.xinghai.indoor.util.WriteStream;    
import com.xinghai.indoor.util.ArrayUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class be
{

    private be()
    {
    }

    public static final int COMPLETED = 2;
    public static final int MAPSEQUENCE = 0;
    public static final int QUEUED = 0;
    public static final int RUNNING = 1;
    public static final int SUPPORTED = 1;
    public static final int TESTSEQUENCE = 1;
    public static final int UNKNOWN = 0;
    public static final int UNSUPPORTED = 2;
 

public static class AccessPointData
  extends CacheBase
{
  public static final int ACCESS_POINT_POSITION_X_FIELD_NUMBER = 1;
  public static final int ACCESS_POINT_POSITION_Y_FIELD_NUMBER = 2;
  public static final int DATA_FIELD_NUMBER = 3;
  private boolean a;
  private float b = 0.0F;
  private boolean c;
  private float d = 0.0F;
  private boolean e;
  private cmn.MatrixFloat f = null;
  private int g = -1;
  
  public static AccessPointData parseFrom(ReadStream paramReadStream)
  {
    return new AccessPointData().mergeFrom(paramReadStream);
  }
  
  public static AccessPointData parseFrom(byte[] paramArrayOfByte)
  {
    return (AccessPointData)new AccessPointData().mergeFrom(paramArrayOfByte);
  }
  
  public final AccessPointData clear()
  {
    clearAccessPointPositionX();
    clearAccessPointPositionY();
    clearData();
    this.g = -1;
    return this;
  }
  
  public AccessPointData clearAccessPointPositionX()
  {
    this.a = false;
    this.b = 0.0F;
    return this;
  }
  
  public AccessPointData clearAccessPointPositionY()
  {
    this.c = false;
    this.d = 0.0F;
    return this;
  }
  
  public AccessPointData clearData()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public float getAccessPointPositionX()
  {
    return this.b;
  }
  
  public float getAccessPointPositionY()
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
  
  public cmn.MatrixFloat getData()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasAccessPointPositionX();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getAccessPointPositionX());
    }
    if (hasAccessPointPositionY()) {
      i += WriteStream.dataLength(2, getAccessPointPositionY());
    }
    if (hasData()) {
      i += WriteStream.dataLength(3, getData());
    }
    this.g = i;
    return i;
  }
  
  public boolean hasAccessPointPositionX()
  {
    return this.a;
  }
  
  public boolean hasAccessPointPositionY()
  {
    return this.c;
  }
  
  public boolean hasData()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public AccessPointData mergeFrom(ReadStream paramReadStream)
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
        setAccessPointPositionX(paramReadStream.checkResult());
        break;
      case 21: 
        setAccessPointPositionY(paramReadStream.checkResult());
        break;
      case 26: // '\032'
          cmn.MatrixFloat localMatrixFloat = new cmn.MatrixFloat();
          paramReadStream.getInstance(localMatrixFloat);
          setData(localMatrixFloat);
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
  
  public AccessPointData setAccessPointPositionX(float paramFloat)
  {
    this.a = true;
    this.b = paramFloat;
    return this;
  }
  
  public AccessPointData setAccessPointPositionY(float paramFloat)
  {
    this.c = true;
    this.d = paramFloat;
    return this;
  }
  
  public AccessPointData setData(cmn.MatrixFloat paramMatrixFloat)
  {
    if (paramMatrixFloat == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramMatrixFloat;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasAccessPointPositionX()) {
      paramWriteStream.getInstance(1, getAccessPointPositionX());
    }
    if (hasAccessPointPositionY()) {
      paramWriteStream.getInstance(2, getAccessPointPositionY());
    }
    if (hasData()) {
      paramWriteStream.getInstance(3, getData());
    }
  }
}



public static class CalibrationSet
  extends CacheBase
{
  public static final int CALIBRATION_VALUES_FIELD_NUMBER = 7;
  public static final int DEVICE_MODEL_FIELD_NUMBER = 4;
  public static final int END_TIME_FIELD_NUMBER = 8;
  public static final int IDA_UID_FIELD_NUMBER = 3;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int MEASUREMENT_FIELD_NUMBER = 6;
  public static final int POSITION_FIELD_NUMBER = 5;
  public static final int URL_FIELD_NUMBER = 2;
  public static final int USED_TRANSFORMATIONS_FIELD_NUMBER = 9;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private cmn.Link h = null;
  private boolean i;
  private cmn.GeoPosition j = null;
  private boolean k;
  private cmn.Measurement l = null;
  private boolean m;
  private be.CalibrationValues n = null;
  private boolean o;
  private long p = 0L;
  private boolean q;
  private be.SensorTransformation r = null;
  private int s = -1;
  
  public static CalibrationSet parseFrom(ReadStream paramReadStream)
  {
    return new CalibrationSet().mergeFrom(paramReadStream);
  }
  
  public static CalibrationSet parseFrom(byte[] paramArrayOfByte)
  {
    return (CalibrationSet)new CalibrationSet().mergeFrom(paramArrayOfByte);
  }
  
  public final CalibrationSet clear()
  {
    clearId();
    clearUrl();
    clearIdaUid();
    clearDeviceModel();
    clearPosition();
    clearMeasurement();
    clearCalibrationValues();
    clearEndTime();
    clearUsedTransformations();
    this.s = -1;
    return this;
  }
  
  public CalibrationSet clearCalibrationValues()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public CalibrationSet clearDeviceModel()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public CalibrationSet clearEndTime()
  {
    this.o = false;
    this.p = 0L;
    return this;
  }
  
  public CalibrationSet clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public CalibrationSet clearIdaUid()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public CalibrationSet clearMeasurement()
  {
    this.k = false;
    this.l = null;
    return this;
  }
  
  public CalibrationSet clearPosition()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public CalibrationSet clearUrl()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public CalibrationSet clearUsedTransformations()
  {
    this.q = false;
    this.r = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.s < 0) {
      getSerializedSize();
    }
    return this.s;
  }
  
  public be.CalibrationValues getCalibrationValues()
  {
    return this.n;
  }
  
  public cmn.Link getDeviceModel()
  {
    return this.h;
  }
  
  public long getEndTime()
  {
    return this.p;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getIdaUid()
  {
    return this.f;
  }
  
  public cmn.Measurement getMeasurement()
  {
    return this.l;
  }
  
  public cmn.GeoPosition getPosition()
  {
    return this.j;
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
    if (hasIdaUid()) {
      i1 += WriteStream.dataLength(3, getIdaUid());
    }
    if (hasDeviceModel()) {
      i1 += WriteStream.dataLength(4, getDeviceModel());
    }
    if (hasPosition()) {
      i1 += WriteStream.dataLength(5, getPosition());
    }
    if (hasMeasurement()) {
      i1 += WriteStream.dataLength(6, getMeasurement());
    }
    if (hasCalibrationValues()) {
      i1 += WriteStream.dataLength(7, getCalibrationValues());
    }
    if (hasEndTime()) {
      i1 += WriteStream.bindLength(8, getEndTime());
    }
    if (hasUsedTransformations()) {
      i1 += WriteStream.dataLength(9, getUsedTransformations());
    }
    this.s = i1;
    return i1;
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public be.SensorTransformation getUsedTransformations()
  {
    return this.r;
  }
  
  public boolean hasCalibrationValues()
  {
    return this.m;
  }
  
  public boolean hasDeviceModel()
  {
    return this.g;
  }
  
  public boolean hasEndTime()
  {
    return this.o;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasIdaUid()
  {
    return this.e;
  }
  
  public boolean hasMeasurement()
  {
    return this.k;
  }
  
  public boolean hasPosition()
  {
    return this.i;
  }
  
  public boolean hasUrl()
  {
    return this.c;
  }
  
  public boolean hasUsedTransformations()
  {
    return this.q;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public CalibrationSet mergeFrom(ReadStream paramReadStream)
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
        setIdaUid(paramReadStream.getStr());
        break;
      case 34: 
        cmn.Link localLink = new cmn.Link();
        paramReadStream.getInstance(localLink);
        setDeviceModel(localLink);
        break;
      case 42: 
        cmn.GeoPosition localGeoPosition = new cmn.GeoPosition();
        paramReadStream.getInstance(localGeoPosition);
        setPosition(localGeoPosition);
        break;
      case 50: 
        cmn.Measurement localMeasurement = new cmn.Measurement();
        paramReadStream.getInstance(localMeasurement);
        setMeasurement(localMeasurement);
        break;
      case 58: 
        be.CalibrationValues localCalibrationValues = new be.CalibrationValues();
        paramReadStream.getInstance(localCalibrationValues);
        setCalibrationValues(localCalibrationValues);
        break;
      case 64: 
        setEndTime(paramReadStream.is1());
        break;
      case 74: // 'J'
          be.SensorTransformation localSensorTransformation = new be.SensorTransformation();
          paramReadStream.getInstance(localSensorTransformation);
          setUsedTransformations(localSensorTransformation);
          break;
      }
    }

	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(IOException ex) {
		  ex.printStackTrace();
	  }
	  return null;
  }
  
  public CalibrationSet setCalibrationValues(be.CalibrationValues paramCalibrationValues)
  {
    if (paramCalibrationValues == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramCalibrationValues;
    return this;
  }
  
  public CalibrationSet setDeviceModel(cmn.Link paramLink)
  {
    if (paramLink == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramLink;
    return this;
  }
  
  public CalibrationSet setEndTime(long paramLong)
  {
    this.o = true;
    this.p = paramLong;
    return this;
  }
  
  public CalibrationSet setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public CalibrationSet setIdaUid(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public CalibrationSet setMeasurement(cmn.Measurement paramMeasurement)
  {
    if (paramMeasurement == null) {
      throw new NullPointerException();
    }
    this.k = true;
    this.l = paramMeasurement;
    return this;
  }
  
  public CalibrationSet setPosition(cmn.GeoPosition paramGeoPosition)
  {
    if (paramGeoPosition == null) {
      throw new NullPointerException();
    }
    this.i = true;
    this.j = paramGeoPosition;
    return this;
  }
  
  public CalibrationSet setUrl(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public CalibrationSet setUsedTransformations(be.SensorTransformation paramSensorTransformation)
  {
    if (paramSensorTransformation == null) {
      throw new NullPointerException();
    }
    this.q = true;
    this.r = paramSensorTransformation;
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
    if (hasIdaUid()) {
      paramWriteStream.getInstance(3, getIdaUid());
    }
    if (hasDeviceModel()) {
      paramWriteStream.getInstance(4, getDeviceModel());
    }
    if (hasPosition()) {
      paramWriteStream.getInstance(5, getPosition());
    }
    if (hasMeasurement()) {
      paramWriteStream.getInstance(6, getMeasurement());
    }
    if (hasCalibrationValues()) {
      paramWriteStream.getInstance(7, getCalibrationValues());
    }
    if (hasEndTime()) {
      paramWriteStream.getInstance(8, getEndTime());
    }
    if (hasUsedTransformations()) {
      paramWriteStream.getInstance(9, getUsedTransformations());
    }
  
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(Exception ex) {
	  ex.printStackTrace();
}
  }  
}


public static class CalibrationValues
extends CacheBase
{
public static final int MGN_BIAS_FIELD_NUMBER = 2;
public static final int MGN_MODEL_FIELD_NUMBER = 1;
private boolean a;
private cmn.Matrix b = null;
private List c = Collections.emptyList();
private int d = -1;

public static CalibrationValues parseFrom(ReadStream paramReadStream)
{
  return new CalibrationValues().mergeFrom(paramReadStream);
}

public static CalibrationValues parseFrom(byte[] paramArrayOfByte)
{
  return (CalibrationValues)new CalibrationValues().mergeFrom(paramArrayOfByte);
}

public CalibrationValues addMgnBias(double paramDouble)
{
  if (this.c.isEmpty()) {
    this.c = new ArrayList();
  }
  this.c.add(Double.valueOf(paramDouble));
  return this;
}

public final CalibrationValues clear()
{
  clearMgnModel();
  clearMgnBias();
  this.d = -1;
  return this;
}

public CalibrationValues clearMgnBias()
{
  this.c = Collections.emptyList();
  return this;
}

public CalibrationValues clearMgnModel()
{
  this.a = false;
  this.b = null;
  return this;
}

public int getCachedSize()
{
  if (this.d < 0) {
    getSerializedSize();
  }
  return this.d;
}

public double getMgnBias(int paramInt)
{
  return ((Double)this.c.get(paramInt)).doubleValue();
}

public int getMgnBiasCount()
{
  return this.c.size();
}

public List getMgnBiasList()
{
  return this.c;
}

public cmn.Matrix getMgnModel()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasMgnModel();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getMgnModel());
  }
  int j = i + 8 * getMgnBiasList().size() + 1 * getMgnBiasList().size();
  this.d = j;
  return j;
}

public boolean hasMgnModel()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public CalibrationValues mergeFrom(ReadStream paramReadStream)
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
      cmn.Matrix localMatrix = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix);
      setMgnModel(localMatrix);
      break;
    case 17: // '\021'
    	addMgnBias(paramReadStream.getStatus());
    	break;
      
    }
  }

} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(IOException ex) {
	  ex.printStackTrace();
}
  return null;
}

public CalibrationValues setMgnBias(int paramInt, double paramDouble)
{
  this.c.set(paramInt, Double.valueOf(paramDouble));
  return this;
}

public CalibrationValues setMgnModel(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.a = true;
  this.b = paramMatrix;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
  if (hasMgnModel()) {
    paramWriteStream.getInstance(1, getMgnModel());
  }
  Iterator localIterator = getMgnBiasList().iterator();
  for (;;)
  {
    if (!localIterator.hasNext()) {
      return;
    }
    paramWriteStream.getInstance(2, ((Double)localIterator.next()).doubleValue());
  }
}
}



public static class DeviceModel
extends CacheBase
{
public static final int BRAND_FIELD_NUMBER = 9;
public static final int DEVICE_FIELD_NUMBER = 8;
public static final int HARDWARE_VERSION_FIELD_NUMBER = 6;
public static final int ID_FIELD_NUMBER = 1;
public static final int MANUFACTURER_FIELD_NUMBER = 7;
public static final int OTHERS_FIELD_NUMBER = 11;
public static final int PLATFORM_FIELD_NUMBER = 4;
public static final int PLATFORM_VERSION_FIELD_NUMBER = 5;
public static final int PRODUCT_FIELD_NUMBER = 3;
public static final int SDK_VERSION_FIELD_NUMBER = 10;
public static final int SENSOR_AXES_MAPPING_FIELD_NUMBER = 13;
public static final int SUPPORT_STATUS_FIELD_NUMBER = 12;
public static final int URL_FIELD_NUMBER = 2;
private int A = -1;
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
private String n = "";
private boolean o;
private String p = "";
private boolean q;
private String r = "";
private boolean s;
private String t = "";
private boolean u;
private String v = "";
private boolean w;
private int x = 0;
private boolean y;
private be.SensorTransformation z = null;

public static DeviceModel parseFrom(ReadStream paramReadStream)
{
  return new DeviceModel().mergeFrom(paramReadStream);
}

public static DeviceModel parseFrom(byte[] paramArrayOfByte)
{
  return (DeviceModel)new DeviceModel().mergeFrom(paramArrayOfByte);
}

public final DeviceModel clear()
{
  clearId();
  clearUrl();
  clearProduct();
  clearPlatform();
  clearPlatformVersion();
  clearHardwareVersion();
  clearManufacturer();
  clearDevice();
  clearBrand();
  clearSdkVersion();
  clearOthers();
  clearSupportStatus();
  clearSensorAxesMapping();
  this.A = -1;
  return this;
}

public DeviceModel clearBrand()
{
  this.q = false;
  this.r = "";
  return this;
}

public DeviceModel clearDevice()
{
  this.o = false;
  this.p = "";
  return this;
}

public DeviceModel clearHardwareVersion()
{
  this.k = false;
  this.l = "";
  return this;
}

public DeviceModel clearId()
{
  this.a = false;
  this.b = "";
  return this;
}

public DeviceModel clearManufacturer()
{
  this.m = false;
  this.n = "";
  return this;
}

public DeviceModel clearOthers()
{
  this.u = false;
  this.v = "";
  return this;
}

public DeviceModel clearPlatform()
{
  this.g = false;
  this.h = "";
  return this;
}

public DeviceModel clearPlatformVersion()
{
  this.i = false;
  this.j = "";
  return this;
}

public DeviceModel clearProduct()
{
  this.e = false;
  this.f = "";
  return this;
}

public DeviceModel clearSdkVersion()
{
  this.s = false;
  this.t = "";
  return this;
}

public DeviceModel clearSensorAxesMapping()
{
  this.y = false;
  this.z = null;
  return this;
}

public DeviceModel clearSupportStatus()
{
  this.w = false;
  this.x = 0;
  return this;
}

public DeviceModel clearUrl()
{
  this.c = false;
  this.d = "";
  return this;
}

public String getBrand()
{
  return this.r;
}

public int getCachedSize()
{
  if (this.A < 0) {
    getSerializedSize();
  }
  return this.A;
}

public String getDevice()
{
  return this.p;
}

public String getHardwareVersion()
{
  return this.l;
}

public String getId()
{
  return this.b;
}

public String getManufacturer()
{
  return this.n;
}

public String getOthers()
{
  return this.v;
}

public String getPlatform()
{
  return this.h;
}

public String getPlatformVersion()
{
  return this.j;
}

public String getProduct()
{
  return this.f;
}

public String getSdkVersion()
{
  return this.t;
}

public be.SensorTransformation getSensorAxesMapping()
{
  return this.z;
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
  if (hasProduct()) {
    i1 += WriteStream.dataLength(3, getProduct());
  }
  if (hasPlatform()) {
    i1 += WriteStream.dataLength(4, getPlatform());
  }
  if (hasPlatformVersion()) {
    i1 += WriteStream.dataLength(5, getPlatformVersion());
  }
  if (hasHardwareVersion()) {
    i1 += WriteStream.dataLength(6, getHardwareVersion());
  }
  if (hasManufacturer()) {
    i1 += WriteStream.dataLength(7, getManufacturer());
  }
  if (hasDevice()) {
    i1 += WriteStream.dataLength(8, getDevice());
  }
  if (hasBrand()) {
    i1 += WriteStream.dataLength(9, getBrand());
  }
  if (hasSdkVersion()) {
    i1 += WriteStream.dataLength(10, getSdkVersion());
  }
  if (hasOthers()) {
    i1 += WriteStream.dataLength(11, getOthers());
  }
  if (hasSupportStatus()) {
    i1 += WriteStream.bindLength2(12, getSupportStatus());
  }
  if (hasSensorAxesMapping()) {
    i1 += WriteStream.dataLength(13, getSensorAxesMapping());
  }
  this.A = i1;
  return i1;
}

public int getSupportStatus()
{
  return this.x;
}

public String getUrl()
{
  return this.d;
}

public boolean hasBrand()
{
  return this.q;
}

public boolean hasDevice()
{
  return this.o;
}

public boolean hasHardwareVersion()
{
  return this.k;
}

public boolean hasId()
{
  return this.a;
}

public boolean hasManufacturer()
{
  return this.m;
}

public boolean hasOthers()
{
  return this.u;
}

public boolean hasPlatform()
{
  return this.g;
}

public boolean hasPlatformVersion()
{
  return this.i;
}

public boolean hasProduct()
{
  return this.e;
}

public boolean hasSdkVersion()
{
  return this.s;
}

public boolean hasSensorAxesMapping()
{
  return this.y;
}

public boolean hasSupportStatus()
{
  return this.w;
}

public boolean hasUrl()
{
  return this.c;
}

public final boolean isInitialized()
{
  return true;
}

public DeviceModel mergeFrom(ReadStream paramReadStream)
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
	      setProduct(paramReadStream.getStr());
	      break;
	    case 34: 
	      setPlatform(paramReadStream.getStr());
	      break;
	    case 42: 
	      setPlatformVersion(paramReadStream.getStr());
	      break;
	    case 50: 
	      setHardwareVersion(paramReadStream.getStr());
	      break;
	    case 58: 
	      setManufacturer(paramReadStream.getStr());
	      break;
	    case 66: 
	      setDevice(paramReadStream.getStr());
	      break;
	    case 74: 
	      setBrand(paramReadStream.getStr());
	      break;
	    case 82: 
	      setSdkVersion(paramReadStream.getStr());
	      break;
	    case 90: 
	      setOthers(paramReadStream.getStr());
	      break;
	    case 96: 
	      setSupportStatus(paramReadStream.getMBytes());
	      break;
	    case 106: // 'j'
	        be.SensorTransformation localSensorTransformation = new be.SensorTransformation();
	        paramReadStream.getInstance(localSensorTransformation);
	        setSensorAxesMapping(localSensorTransformation);
	        break;
	    }
	  }
		
	} catch(ExceptionManager mng) {
		  mng.printStackTrace();
	} catch(IOException ex) {
		  ex.printStackTrace();
	}
	
	return null;
}

public DeviceModel setBrand(String paramString)
{
  this.q = true;
  this.r = paramString;
  return this;
}

public DeviceModel setDevice(String paramString)
{
  this.o = true;
  this.p = paramString;
  return this;
}

public DeviceModel setHardwareVersion(String paramString)
{
  this.k = true;
  this.l = paramString;
  return this;
}

public DeviceModel setId(String paramString)
{
  this.a = true;
  this.b = paramString;
  return this;
}

public DeviceModel setManufacturer(String paramString)
{
  this.m = true;
  this.n = paramString;
  return this;
}

public DeviceModel setOthers(String paramString)
{
  this.u = true;
  this.v = paramString;
  return this;
}

public DeviceModel setPlatform(String paramString)
{
  this.g = true;
  this.h = paramString;
  return this;
}

public DeviceModel setPlatformVersion(String paramString)
{
  this.i = true;
  this.j = paramString;
  return this;
}

public DeviceModel setProduct(String paramString)
{
  this.e = true;
  this.f = paramString;
  return this;
}

public DeviceModel setSdkVersion(String paramString)
{
  this.s = true;
  this.t = paramString;
  return this;
}

public DeviceModel setSensorAxesMapping(be.SensorTransformation paramSensorTransformation)
{
  if (paramSensorTransformation == null) {
    throw new NullPointerException();
  }
  this.y = true;
  this.z = paramSensorTransformation;
  return this;
}

public DeviceModel setSupportStatus(int paramInt)
{
  this.w = true;
  this.x = paramInt;
  return this;
}

public DeviceModel setUrl(String paramString)
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
  if (hasProduct()) {
    paramWriteStream.getInstance(3, getProduct());
  }
  if (hasPlatform()) {
    paramWriteStream.getInstance(4, getPlatform());
  }
  if (hasPlatformVersion()) {
    paramWriteStream.getInstance(5, getPlatformVersion());
  }
  if (hasHardwareVersion()) {
    paramWriteStream.getInstance(6, getHardwareVersion());
  }
  if (hasManufacturer()) {
    paramWriteStream.getInstance(7, getManufacturer());
  }
  if (hasDevice()) {
    paramWriteStream.getInstance(8, getDevice());
  }
  if (hasBrand()) {
    paramWriteStream.getInstance(9, getBrand());
  }
  if (hasSdkVersion()) {
    paramWriteStream.getInstance(10, getSdkVersion());
  }
  if (hasOthers()) {
    paramWriteStream.getInstance(11, getOthers());
  }
  if (hasSupportStatus()) {
    paramWriteStream.getInstance(12, getSupportStatus());
  }
  if (hasSensorAxesMapping()) {
    paramWriteStream.getInstance(13, getSensorAxesMapping());
  }
  
  } catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(Exception ex) {
	  ex.printStackTrace();
  }

  
}
  
}




public static class DoubleArray
  extends CacheBase
{
  public static final int VALUE_FIELD_NUMBER = 1;
  private List a = Collections.emptyList();
  private int b = -1;
  
  public static DoubleArray parseFrom(ReadStream paramReadStream)
  {
    return new DoubleArray().mergeFrom(paramReadStream);
  }
  
  public static DoubleArray parseFrom(byte[] paramArrayOfByte)
  {
    return (DoubleArray)new DoubleArray().mergeFrom(paramArrayOfByte);
  }
  
  public DoubleArray addValue(double paramDouble)
  {
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(Double.valueOf(paramDouble));
    return this;
  }
  
  public final DoubleArray clear()
  {
    clearValue();
    this.b = -1;
    return this;
  }
  
  public DoubleArray clearValue()
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
    int i = 0 + 8 * getValueList().size() + 1 * getValueList().size();
    this.b = i;
    return i;
  }
  
  public double getValue(int paramInt)
  {
    return ((Double)this.a.get(paramInt)).doubleValue();
  }
  
  public int getValueCount()
  {
    return this.a.size();
  }
  
  public List getValueList()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public DoubleArray mergeFrom(ReadStream paramReadStream)
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
      case 9: // '\t'
          addValue(paramReadStream.getStatus());
          break;
      }
    }

  } catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(IOException ex) {
	  ex.printStackTrace();
  }
return null;    
  }
  
  public DoubleArray setValue(int paramInt, double paramDouble)
  {
    this.a.set(paramInt, Double.valueOf(paramDouble));
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    Iterator localIterator = getValueList().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      paramWriteStream.getInstance(1, ((Double)localIterator.next()).doubleValue());
    }
  }
}



public static class IndoorAtlas
extends CacheBase
{
public static final int BUILDING_FIELD_NUMBER = 1;
public static final int CALIBRATION_FIELD_NUMBER = 5;
public static final int GRAPHIC_FIELD_NUMBER = 4;
public static final int LEVEL_FIELD_NUMBER = 2;
public static final int SEQUENCE_FIELD_NUMBER = 3;
private List a = Collections.emptyList();
private List b = Collections.emptyList();
private List c = Collections.emptyList();
private List d = Collections.emptyList();
private List e = Collections.emptyList();
private int f = -1;

public static IndoorAtlas parseFrom(ReadStream paramReadStream)
{
  return new IndoorAtlas().mergeFrom(paramReadStream);
}

public static IndoorAtlas parseFrom(byte[] paramArrayOfByte)
{
  return (IndoorAtlas)new IndoorAtlas().mergeFrom(paramArrayOfByte);
}

public IndoorAtlas addBuilding(cmn.Building paramBuilding)
{
  if (paramBuilding == null) {
    throw new NullPointerException();
  }
  if (this.a.isEmpty()) {
    this.a = new ArrayList();
  }
  this.a.add(paramBuilding);
  return this;
}

public IndoorAtlas addCalibration(be.CalibrationSet paramCalibrationSet)
{
  if (paramCalibrationSet == null) {
    throw new NullPointerException();
  }
  if (this.e.isEmpty()) {
    this.e = new ArrayList();
  }
  this.e.add(paramCalibrationSet);
  return this;
}

public IndoorAtlas addGraphic(cmn.Graphic paramGraphic)
{
  if (paramGraphic == null) {
    throw new NullPointerException();
  }
  if (this.d.isEmpty()) {
    this.d = new ArrayList();
  }
  this.d.add(paramGraphic);
  return this;
}

public IndoorAtlas addLevel(cmn.Level paramLevel)
{
  if (paramLevel == null) {
    throw new NullPointerException();
  }
  if (this.b.isEmpty()) {
    this.b = new ArrayList();
  }
  this.b.add(paramLevel);
  return this;
}

public IndoorAtlas addSequence(be.Sequence paramSequence)
{
  if (paramSequence == null) {
    throw new NullPointerException();
  }
  if (this.c.isEmpty()) {
    this.c = new ArrayList();
  }
  this.c.add(paramSequence);
  return this;
}

public final IndoorAtlas clear()
{
  clearBuilding();
  clearLevel();
  clearSequence();
  clearGraphic();
  clearCalibration();
  this.f = -1;
  return this;
}

public IndoorAtlas clearBuilding()
{
  this.a = Collections.emptyList();
  return this;
}

public IndoorAtlas clearCalibration()
{
  this.e = Collections.emptyList();
  return this;
}

public IndoorAtlas clearGraphic()
{
  this.d = Collections.emptyList();
  return this;
}

public IndoorAtlas clearLevel()
{
  this.b = Collections.emptyList();
  return this;
}

public IndoorAtlas clearSequence()
{
  this.c = Collections.emptyList();
  return this;
}

public cmn.Building getBuilding(int paramInt)
{
  return (cmn.Building)this.a.get(paramInt);
}

public int getBuildingCount()
{
  return this.a.size();
}

public List getBuildingList()
{
  return this.a;
}

public int getCachedSize()
{
  if (this.f < 0) {
    getSerializedSize();
  }
  return this.f;
}

public be.CalibrationSet getCalibration(int paramInt)
{
  return (be.CalibrationSet)this.e.get(paramInt);
}

public int getCalibrationCount()
{
  return this.e.size();
}

public List getCalibrationList()
{
  return this.e;
}

public cmn.Graphic getGraphic(int paramInt)
{
  return (cmn.Graphic)this.d.get(paramInt);
}

public int getGraphicCount()
{
  return this.d.size();
}

public List getGraphicList()
{
  return this.d;
}

public cmn.Level getLevel(int paramInt)
{
  return (cmn.Level)this.b.get(paramInt);
}

public int getLevelCount()
{
  return this.b.size();
}

public List getLevelList()
{
  return this.b;
}

public be.Sequence getSequence(int paramInt)
{
  return (be.Sequence)this.c.get(paramInt);
}

public int getSequenceCount()
{
  return this.c.size();
}

public List getSequenceList()
{
  return this.c;
}


public int getSerializedSize()
{
    Iterator iterator;
    int i;
    iterator = getBuildingList().iterator();
    i = 0;

    for(;iterator.hasNext();) { 
	    i += WriteStream.dataLength(1, (cmn.Building)iterator.next());
    }
    Iterator iterator1 = getLevelList().iterator();
    for(;iterator1.hasNext();) {
    	i += WriteStream.dataLength(2, (cmn.Level)iterator1.next());
    }

    Iterator iterator2 = getSequenceList().iterator();
    for(;iterator2.hasNext();) {
        i += WriteStream.dataLength(3, (be.Sequence)iterator2.next());
    }
    
    Iterator iterator3 = getGraphicList().iterator();
    for(;iterator3.hasNext();) {
	    i += WriteStream.dataLength(4, (cmn.Graphic)iterator3.next());
    }
    Iterator iterator4 = getCalibrationList().iterator();

    for(;iterator4.hasNext();) 
    {
        i += WriteStream.dataLength(5, (be.CalibrationSet)iterator4.next());
    }
    f = i;
    return i;
}




public final boolean isInitialized()
{
  return true;
}

public IndoorAtlas mergeFrom(ReadStream paramReadStream)
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
      cmn.Building localBuilding = new cmn.Building();
      paramReadStream.getInstance(localBuilding);
      addBuilding(localBuilding);
      break;
    case 18: 
      cmn.Level localLevel = new cmn.Level();
      paramReadStream.getInstance(localLevel);
      addLevel(localLevel);
      break;
    case 26: 
      be.Sequence localSequence = new be.Sequence();
      paramReadStream.getInstance(localSequence);
      addSequence(localSequence);
      break;
    case 34: 
      cmn.Graphic localGraphic = new cmn.Graphic();
      paramReadStream.getInstance(localGraphic);
      addGraphic(localGraphic);
      break;
    case 42: // '*'
        be.CalibrationSet localCalibrationSet = new be.CalibrationSet();
        paramReadStream.getInstance(localCalibrationSet);
        addCalibration(localCalibrationSet);
        break;
    }
  }
	
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(IOException ex) {
	  ex.printStackTrace();
}
return null;

}

public IndoorAtlas setBuilding(int paramInt, cmn.Building paramBuilding)
{
  if (paramBuilding == null) {
    throw new NullPointerException();
  }
  this.a.set(paramInt, paramBuilding);
  return this;
}

public IndoorAtlas setCalibration(int paramInt, be.CalibrationSet paramCalibrationSet)
{
  if (paramCalibrationSet == null) {
    throw new NullPointerException();
  }
  this.e.set(paramInt, paramCalibrationSet);
  return this;
}

public IndoorAtlas setGraphic(int paramInt, cmn.Graphic paramGraphic)
{
  if (paramGraphic == null) {
    throw new NullPointerException();
  }
  this.d.set(paramInt, paramGraphic);
  return this;
}

public IndoorAtlas setLevel(int paramInt, cmn.Level paramLevel)
{
  if (paramLevel == null) {
    throw new NullPointerException();
  }
  this.b.set(paramInt, paramLevel);
  return this;
}

public IndoorAtlas setSequence(int paramInt, be.Sequence paramSequence)
{
  if (paramSequence == null) {
    throw new NullPointerException();
  }
  this.c.set(paramInt, paramSequence);
  return this;
}



public void writeTo(WriteStream writestream)
{
    Iterator iterator = getBuildingList().iterator();

    for(;iterator.hasNext();) {
	    writestream.getInstance(1, (cmn.Building)iterator.next());
    }

    Iterator iterator1 = getLevelList().iterator();

    for(;iterator1.hasNext();) {
   	    writestream.getInstance(2, (cmn.Level)iterator1.next());
    }

    Iterator iterator2 = getSequenceList().iterator();
    for(;iterator2.hasNext();) {
        writestream.getInstance(3, (be.Sequence)iterator2.next());
    }

    Iterator iterator3 = getGraphicList().iterator();
    for(;iterator3.hasNext();) {
        writestream.getInstance(4, (cmn.Graphic)iterator3.next());
    }

    Iterator iterator4 = getCalibrationList().iterator();
    for(;iterator4.hasNext();) {
        writestream.getInstance(5, (be.CalibrationSet)iterator4.next());
    }
}


}




public static class JobStatus
  extends CacheBase
{
  public static final int ID_FIELD_NUMBER = 1;
  public static final int STATE_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private int d = 0;
  private int e = -1;
  
  public static JobStatus parseFrom(ReadStream paramReadStream)
  {
    return new JobStatus().mergeFrom(paramReadStream);
  }
  
  public static JobStatus parseFrom(byte[] paramArrayOfByte)
  {
    return (JobStatus)new JobStatus().mergeFrom(paramArrayOfByte);
  }
  
  public final JobStatus clear()
  {
    clearId();
    clearState();
    this.e = -1;
    return this;
  }
  
  public JobStatus clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public JobStatus clearState()
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
    if (hasState()) {
      i += WriteStream.bindLength2(2, getState());
    }
    this.e = i;
    return i;
  }
  
  public int getState()
  {
    return this.d;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasState()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public JobStatus mergeFrom(ReadStream paramReadStream)
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
      case 16: // '\020'
          setState(paramReadStream.getMBytes());
          break;
      }
    }
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(IOException ex) {
		  ex.printStackTrace();
	  }

	  return null;
  }
  
  public JobStatus setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public JobStatus setState(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
try {
	if (hasId()) {
      paramWriteStream.getInstance(1, getId());
    }
    if (hasState()) {
      paramWriteStream.getInstance(2, getState());
    }
    
  } catch(ExceptionManager mng) {
	  mng.printStackTrace();
  } catch(Exception ex) {
	  ex.printStackTrace();
  }
    
  }
}




public static class MagMap
  extends CacheBase
{
  public static final int DATA_FIELD_NUMBER = 2;
  public static final int GRID_X_FIELD_NUMBER = 3;
  public static final int GRID_Y_FIELD_NUMBER = 4;
  public static final int MAG_X_FIELD_NUMBER = 5;
  public static final int MAG_Y_FIELD_NUMBER = 6;
  public static final int MAG_Z_FIELD_NUMBER = 7;
  public static final int MAP_COMMONS_FIELD_NUMBER = 8;
  public static final int POSITIONS_FIELD_NUMBER = 1;
  private List a = Collections.emptyList();
  private List b = Collections.emptyList();
  private boolean c;
  private be.DoubleArray d = null;
  private boolean e;
  private be.DoubleArray f = null;
  private boolean g;
  private cmn.Matrix h = null;
  private boolean i;
  private cmn.Matrix j = null;
  private boolean k;
  private cmn.Matrix l = null;
  private boolean m;
  private be.MapCommons n = null;
  private int o = -1;
  
  public static MagMap parseFrom(ReadStream paramReadStream)
  {
    return new MagMap().mergeFrom(paramReadStream);
  }
  
  public static MagMap parseFrom(byte[] paramArrayOfByte)
  {
    return (MagMap)new MagMap().mergeFrom(paramArrayOfByte);
  }
  
  public MagMap addData(be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    if (this.b.isEmpty()) {
      this.b = new ArrayList();
    }
    this.b.add(paramDoubleArray);
    return this;
  }
  
  public MagMap addPositions(be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramDoubleArray);
    return this;
  }
  
  public final MagMap clear()
  {
    clearPositions();
    clearData();
    clearGridX();
    clearGridY();
    clearMagX();
    clearMagY();
    clearMagZ();
    clearMapCommons();
    this.o = -1;
    return this;
  }
  
  public MagMap clearData()
  {
    this.b = Collections.emptyList();
    return this;
  }
  
  public MagMap clearGridX()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public MagMap clearGridY()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public MagMap clearMagX()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public MagMap clearMagY()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public MagMap clearMagZ()
  {
    this.k = false;
    this.l = null;
    return this;
  }
  
  public MagMap clearMapCommons()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public MagMap clearPositions()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.o < 0) {
      getSerializedSize();
    }
    return this.o;
  }
  
  public be.DoubleArray getData(int paramInt)
  {
    return (be.DoubleArray)this.b.get(paramInt);
  }
  
  public int getDataCount()
  {
    return this.b.size();
  }
  
  public List getDataList()
  {
    return this.b;
  }
  
  public be.DoubleArray getGridX()
  {
    return this.d;
  }
  
  public be.DoubleArray getGridY()
  {
    return this.f;
  }
  
  public cmn.Matrix getMagX()
  {
    return this.h;
  }
  
  public cmn.Matrix getMagY()
  {
    return this.j;
  }
  
  public cmn.Matrix getMagZ()
  {
    return this.l;
  }
  
  public be.MapCommons getMapCommons()
  {
    return this.n;
  }
  
  public be.DoubleArray getPositions(int paramInt)
  {
    return (be.DoubleArray)this.a.get(paramInt);
  }
  
  public int getPositionsCount()
  {
    return this.a.size();
  }
  
  public List getPositionsList()
  {
    return this.a;
  }
  
  
  public int getSerializedSize()
  {
      Iterator iterator;
      int i1;
      iterator = getPositionsList().iterator();
      i1 = 0;
      for(;iterator.hasNext();) {
	      i1 += WriteStream.dataLength(1, (be.DoubleArray)iterator.next());
      }

      Iterator iterator1 = getDataList().iterator();
      for(;iterator1.hasNext();) {
    	  i1 += WriteStream.dataLength(2, (be.DoubleArray)iterator1.next());
      }
      if(hasGridX())
          i1 += WriteStream.dataLength(3, getGridX());
      if(hasGridY())
          i1 += WriteStream.dataLength(4, getGridY());
      if(hasMagX())
          i1 += WriteStream.dataLength(5, getMagX());
      if(hasMagY())
          i1 += WriteStream.dataLength(6, getMagY());
      if(hasMagZ())
          i1 += WriteStream.dataLength(7, getMagZ());
      if(hasMapCommons())
          i1 += WriteStream.dataLength(8, getMapCommons());
      o = i1;
      return i1;
  }

  
  
  public boolean hasGridX()
  {
    return this.c;
  }
  
  public boolean hasGridY()
  {
    return this.e;
  }
  
  public boolean hasMagX()
  {
    return this.g;
  }
  
  public boolean hasMagY()
  {
    return this.i;
  }
  
  public boolean hasMagZ()
  {
    return this.k;
  }
  
  public boolean hasMapCommons()
  {
    return this.m;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public MagMap mergeFrom(ReadStream paramReadStream)
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
        be.DoubleArray localDoubleArray4 = new be.DoubleArray();
        paramReadStream.getInstance(localDoubleArray4);
        addPositions(localDoubleArray4);
        break;
      case 18: 
        be.DoubleArray localDoubleArray3 = new be.DoubleArray();
        paramReadStream.getInstance(localDoubleArray3);
        addData(localDoubleArray3);
        break;
      case 26: 
        be.DoubleArray localDoubleArray2 = new be.DoubleArray();
        paramReadStream.getInstance(localDoubleArray2);
        setGridX(localDoubleArray2);
        break;
      case 34: 
        be.DoubleArray localDoubleArray1 = new be.DoubleArray();
        paramReadStream.getInstance(localDoubleArray1);
        setGridY(localDoubleArray1);
        break;
      case 42: 
        cmn.Matrix localMatrix3 = new cmn.Matrix();
        paramReadStream.getInstance(localMatrix3);
        setMagX(localMatrix3);
        break;
      case 50: 
        cmn.Matrix localMatrix2 = new cmn.Matrix();
        paramReadStream.getInstance(localMatrix2);
        setMagY(localMatrix2);
        break;
      case 58: 
        cmn.Matrix localMatrix1 = new cmn.Matrix();
        paramReadStream.getInstance(localMatrix1);
        setMagZ(localMatrix1);
        break;
      case 66: // 'B'
          be.MapCommons localMapCommons = new be.MapCommons();
          paramReadStream.getInstance(localMapCommons);
          setMapCommons(localMapCommons);
          break;
      }
    }
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(IOException ex) {
		  ex.printStackTrace();
	  }
	  return null;	  
  }
  
  public MagMap setData(int paramInt, be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    this.b.set(paramInt, paramDoubleArray);
    return this;
  }
  
  public MagMap setGridX(be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    this.c = true;
    this.d = paramDoubleArray;
    return this;
  }
  
  public MagMap setGridY(be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramDoubleArray;
    return this;
  }
  
  public MagMap setMagX(cmn.Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramMatrix;
    return this;
  }
  
  public MagMap setMagY(cmn.Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new NullPointerException();
    }
    this.i = true;
    this.j = paramMatrix;
    return this;
  }
  
  public MagMap setMagZ(cmn.Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new NullPointerException();
    }
    this.k = true;
    this.l = paramMatrix;
    return this;
  }
  
  public MagMap setMapCommons(be.MapCommons paramMapCommons)
  {
    if (paramMapCommons == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramMapCommons;
    return this;
  }
  
  public MagMap setPositions(int paramInt, be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    this.a.set(paramInt, paramDoubleArray);
    return this;
  }
  

  public void writeTo(WriteStream writestream)
  {
      Iterator iterator = getPositionsList().iterator();
      for(;iterator.hasNext();) {
	      writestream.getInstance(1, (be.DoubleArray)iterator.next());
      }

      Iterator iterator1 = getDataList().iterator();
      for(;iterator1.hasNext();) {
    	  writestream.getInstance(2, (be.DoubleArray)iterator1.next());
      }
      if(hasGridX())
          writestream.getInstance(3, getGridX());
      if(hasGridY())
          writestream.getInstance(4, getGridY());
      if(hasMagX())
          writestream.getInstance(5, getMagX());
      if(hasMagY())
          writestream.getInstance(6, getMagY());
      if(hasMagZ())
          writestream.getInstance(7, getMagZ());
      if(hasMapCommons())
          writestream.getInstance(8, getMapCommons());
      return;
  }  
  
}




public static class Map
  extends CacheBase
{
  public static final int ALGORITHM_VERSION_FIELD_NUMBER = 7;
  public static final int CONTENT_FIELD_NUMBER = 8;
  public static final int CREATED_AT_FIELD_NUMBER = 3;
  public static final int GRAPHICS_ID_FIELD_NUMBER = 4;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int REVISION_FIELD_NUMBER = 5;
  public static final int SEQUENCE_IDS_FIELD_NUMBER = 6;
  public static final int TYPE_FIELD_NUMBER = 2;
  private boolean createArray;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private long f = 0L;
  private boolean g;
  private String h = "";
  private boolean i;
  private int j = 0;
  private List k = Collections.emptyList();
  private boolean l;
  private int m = 0;
  private boolean n;
  private ArrayUtil o = ArrayUtil.createArray;
  private int p = -1;
  
  public static Map parseFrom(ReadStream paramReadStream)
  {
    return new Map().mergeFrom(paramReadStream);
  }
  
  public static Map parseFrom(byte[] paramArrayOfByte)
  {
    return (Map)new Map().mergeFrom(paramArrayOfByte);
  }
  
  public Map addSequenceIds(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    if (this.k.isEmpty()) {
      this.k = new ArrayList();
    }
    this.k.add(paramString);
    return this;
  }
  
  public final Map clear()
  {
    clearId();
    clearType();
    clearCreatedAt();
    clearGraphicsId();
    clearRevision();
    clearSequenceIds();
    clearAlgorithmVersion();
    clearContent();
    this.p = -1;
    return this;
  }
  
  public Map clearAlgorithmVersion()
  {
    this.l = false;
    this.m = 0;
    return this;
  }
  
  public Map clearContent()
  {
    this.n = false;
    this.o = ArrayUtil.createArray;
    return this;
  }
  
  public Map clearCreatedAt()
  {
    this.e = false;
    this.f = 0L;
    return this;
  }
  
  public Map clearGraphicsId()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public Map clearId()
  {
    this.createArray = false;
    this.b = "";
    return this;
  }
  
  public Map clearRevision()
  {
    this.i = false;
    this.j = 0;
    return this;
  }
  
  public Map clearSequenceIds()
  {
    this.k = Collections.emptyList();
    return this;
  }
  
  public Map clearType()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getAlgorithmVersion()
  {
    return this.m;
  }
  
  public int getCachedSize()
  {
    if (this.p < 0) {
      getSerializedSize();
    }
    return this.p;
  }
  
  public ArrayUtil getContent()
  {
    return this.o;
  }
  
  public long getCreatedAt()
  {
    return this.f;
  }
  
  public String getGraphicsId()
  {
    return this.h;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public int getRevision()
  {
    return this.j;
  }
  
  public String getSequenceIds(int paramInt)
  {
    return (String)this.k.get(paramInt);
  }
  
  public int getSequenceIdsCount()
  {
    return this.k.size();
  }
  
  public List getSequenceIdsList()
  {
    return this.k;
  }
  
  
  public int getSerializedSize()
  {
      int i1 = 0;
      int j1;
      int k1;
      Iterator iterator;
      if(hasId())
          j1 = 0 + WriteStream.dataLength(1, getId());
      else
          j1 = 0;
      if(hasType())
          j1 += WriteStream.dataLength(2, getType());
      if(hasCreatedAt())
          j1 += WriteStream.bindLength(3, getCreatedAt());
      if(hasGraphicsId())
          j1 += WriteStream.dataLength(4, getGraphicsId());
      if(hasRevision())
          k1 = j1 + WriteStream.bindLength3(5, getRevision());
      else
          k1 = j1;
      iterator = getSequenceIdsList().iterator();
      do
      {
          if(!iterator.hasNext())
          {
              int l1 = k1 + i1 + 1 * getSequenceIdsList().size();
              if(hasAlgorithmVersion())
                  l1 += WriteStream.bindLength3(7, getAlgorithmVersion());
              if(hasContent())
                  l1 += WriteStream.dataLength(8, getContent());
              p = l1;
              return l1;
          }
          i1 += WriteStream.dataLength((String)iterator.next());
      } while(true);
  }

  
  
  public String getType()
  {
    return this.d;
  }
  
  public boolean hasAlgorithmVersion()
  {
    return this.l;
  }
  
  public boolean hasContent()
  {
    return this.n;
  }
  
  public boolean hasCreatedAt()
  {
    return this.e;
  }
  
  public boolean hasGraphicsId()
  {
    return this.g;
  }
  
  public boolean hasId()
  {
    return this.createArray;
  }
  
  public boolean hasRevision()
  {
    return this.i;
  }
  
  public boolean hasType()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Map mergeFrom(ReadStream paramReadStream)
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
        setType(paramReadStream.getStr());
        break;
      case 24: 
        setCreatedAt(paramReadStream.is1());
        break;
      case 34: 
        setGraphicsId(paramReadStream.getStr());
        break;
      case 40: 
        setRevision(paramReadStream.calc3());
        break;
      case 50: 
        addSequenceIds(paramReadStream.getStr());
        break;
      case 56: 
        setAlgorithmVersion(paramReadStream.calc3());
        break;
      case 66: // 'B'
          setContent(paramReadStream.getArrayUtil());
          break;
      }
    }
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(IOException ex) {
		  ex.printStackTrace();
	  }
    return null;	  
  }
  
  public Map setAlgorithmVersion(int paramInt)
  {
    this.l = true;
    this.m = paramInt;
    return this;
  }
  
  public Map setContent(ArrayUtil paramArrayUtil)
  {
    this.n = true;
    this.o = paramArrayUtil;
    return this;
  }
  
  public Map setCreatedAt(long paramLong)
  {
    this.e = true;
    this.f = paramLong;
    return this;
  }
  
  public Map setGraphicsId(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public Map setId(String paramString)
  {
    this.createArray = true;
    this.b = paramString;
    return this;
  }
  
  public Map setRevision(int paramInt)
  {
    this.i = true;
    this.j = paramInt;
    return this;
  }
  
  public Map setSequenceIds(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.k.set(paramInt, paramString);
    return this;
  }
  
  public Map setType(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public void writeTo(WriteStream writestream)
  {
try {
	  if(hasId())
          writestream.getInstance(1, getId());
      if(hasType())
          writestream.getInstance(2, getType());
      if(hasCreatedAt())
          writestream.getInstance(3, getCreatedAt());
      if(hasGraphicsId())
          writestream.getInstance(4, getGraphicsId());
      if(hasRevision())
          writestream.dataLength(5, getRevision());
      Iterator iterator = getSequenceIdsList().iterator();
      do
      {
          if(!iterator.hasNext())
          {
              if(hasAlgorithmVersion())
                  writestream.dataLength(7, getAlgorithmVersion());
              if(hasContent())
                  writestream.getInstance(8, getContent());
              return;
          }
          writestream.getInstance(6, (String)iterator.next());
      } while(true);
      
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(Exception ex) {
	  ex.printStackTrace();
}


  }

  
}


public static class MapCommons
extends CacheBase
{
public static final int GRAPHICS_FIELD_NUMBER = 10;
public static final int STATEMAGOBS_FIELD_NUMBER = 8;
public static final int STATES_X_FIELD_NUMBER = 1;
public static final int STATEWIFIOBS_FIELD_NUMBER = 9;
public static final int STPEUCDIST_FIELD_NUMBER = 4;
public static final int STPINDEND_FIELD_NUMBER = 3;
public static final int STPINDSTART_FIELD_NUMBER = 2;
public static final int STPROTCCWBINCENT_FIELD_NUMBER = 7;
public static final int STPROTCCWBIN_FIELD_NUMBER = 6;
public static final int STPROTCCW_FIELD_NUMBER = 5;
private boolean a;
private cmn.Matrix b = null;
private List c = Collections.emptyList();
private List d = Collections.emptyList();
private boolean e;
private be.DoubleArray f = null;
private boolean g;
private be.DoubleArray h = null;
private List i = Collections.emptyList();
private boolean j;
private be.DoubleArray k = null;
private boolean l;
private cmn.Matrix m = null;
private boolean n;
private cmn.Matrix o = null;
private boolean p;
private cmn.Graphic q = null;
private int r = -1;

public static MapCommons parseFrom(ReadStream paramReadStream)
{
  return new MapCommons().mergeFrom(paramReadStream);
}

public static MapCommons parseFrom(byte[] paramArrayOfByte)
{
  return (MapCommons)new MapCommons().mergeFrom(paramArrayOfByte);
}

public MapCommons addStpIndEnd(int paramInt)
{
  if (this.d.isEmpty()) {
    this.d = new ArrayList();
  }
  this.d.add(Integer.valueOf(paramInt));
  return this;
}

public MapCommons addStpIndStart(int paramInt)
{
  if (this.c.isEmpty()) {
    this.c = new ArrayList();
  }
  this.c.add(Integer.valueOf(paramInt));
  return this;
}

public MapCommons addStpRotCCWbin(int paramInt)
{
  if (this.i.isEmpty()) {
    this.i = new ArrayList();
  }
  this.i.add(Integer.valueOf(paramInt));
  return this;
}

public final MapCommons clear()
{
  clearStatesX();
  clearStpIndStart();
  clearStpIndEnd();
  clearStpEucDist();
  clearStpRotCCW();
  clearStpRotCCWbin();
  clearStpRotCCWbinCent();
  clearStateMagObs();
  clearStateWifiObs();
  clearGraphics();
  this.r = -1;
  return this;
}

public MapCommons clearGraphics()
{
  this.p = false;
  this.q = null;
  return this;
}

public MapCommons clearStateMagObs()
{
  this.l = false;
  this.m = null;
  return this;
}

public MapCommons clearStateWifiObs()
{
  this.n = false;
  this.o = null;
  return this;
}

public MapCommons clearStatesX()
{
  this.a = false;
  this.b = null;
  return this;
}

public MapCommons clearStpEucDist()
{
  this.e = false;
  this.f = null;
  return this;
}

public MapCommons clearStpIndEnd()
{
  this.d = Collections.emptyList();
  return this;
}

public MapCommons clearStpIndStart()
{
  this.c = Collections.emptyList();
  return this;
}

public MapCommons clearStpRotCCW()
{
  this.g = false;
  this.h = null;
  return this;
}

public MapCommons clearStpRotCCWbin()
{
  this.i = Collections.emptyList();
  return this;
}

public MapCommons clearStpRotCCWbinCent()
{
  this.j = false;
  this.k = null;
  return this;
}

public int getCachedSize()
{
  if (this.r < 0) {
    getSerializedSize();
  }
  return this.r;
}

public cmn.Graphic getGraphics()
{
  return this.q;
}


public int getSerializedSize()
{
    int i1 = 0;
    int j1;
    Iterator iterator;
    int k1;
    int l1;
    Iterator iterator1;
    int i2;
    int j2;
    int k2;
    Iterator iterator2;
    int l2;
    if(hasStatesX())
        j1 = 0 + WriteStream.dataLength(1, getStatesX());
    else
        j1 = 0;
    iterator = getStpIndStartList().iterator();
    k1 = 0;
    for(;iterator.hasNext();) {
    	    k1 += WriteStream.bindLength3(((Integer)iterator.next()).intValue());
    }

    l1 = j1 + k1 + 1 * getStpIndStartList().size();
    iterator1 = getStpIndEndList().iterator();
    i2 = 0;

    for(;iterator1.hasNext();) {
    	    i2 += WriteStream.bindLength3(((Integer)iterator1.next()).intValue());
    }

    j2 = l1 + i2 + 1 * getStpIndEndList().size();
    if(hasStpEucDist())
        j2 += WriteStream.dataLength(4, getStpEucDist());
    if(hasStpRotCCW())
        k2 = j2 + WriteStream.dataLength(5, getStpRotCCW());
    else
        k2 = j2;
    
    iterator2 = getStpRotCCWbinList().iterator();
    for(;iterator2.hasNext();) {
    	i1 += WriteStream.bindLength3(((Integer)iterator2.next()).intValue());
    }
    l2 = k2 + i1 + 1 * getStpRotCCWbinList().size();
    if(hasStpRotCCWbinCent())
        l2 += WriteStream.dataLength(7, getStpRotCCWbinCent());
    if(hasStateMagObs())
        l2 += WriteStream.dataLength(8, getStateMagObs());
    if(hasStateWifiObs())
        l2 += WriteStream.dataLength(9, getStateWifiObs());
    if(hasGraphics())
        l2 += WriteStream.dataLength(10, getGraphics());
    r = l2;
    return l2;
 
}


public cmn.Matrix getStateMagObs()
{
  return this.m;
}

public cmn.Matrix getStateWifiObs()
{
  return this.o;
}

public cmn.Matrix getStatesX()
{
  return this.b;
}

public be.DoubleArray getStpEucDist()
{
  return this.f;
}

public int getStpIndEnd(int paramInt)
{
  return ((Integer)this.d.get(paramInt)).intValue();
}

public int getStpIndEndCount()
{
  return this.d.size();
}

public List getStpIndEndList()
{
  return this.d;
}

public int getStpIndStart(int paramInt)
{
  return ((Integer)this.c.get(paramInt)).intValue();
}

public int getStpIndStartCount()
{
  return this.c.size();
}

public List getStpIndStartList()
{
  return this.c;
}

public be.DoubleArray getStpRotCCW()
{
  return this.h;
}

public int getStpRotCCWbin(int paramInt)
{
  return ((Integer)this.i.get(paramInt)).intValue();
}

public be.DoubleArray getStpRotCCWbinCent()
{
  return this.k;
}

public int getStpRotCCWbinCount()
{
  return this.i.size();
}

public List getStpRotCCWbinList()
{
  return this.i;
}

public boolean hasGraphics()
{
  return this.p;
}

public boolean hasStateMagObs()
{
  return this.l;
}

public boolean hasStateWifiObs()
{
  return this.n;
}

public boolean hasStatesX()
{
  return this.a;
}

public boolean hasStpEucDist()
{
  return this.e;
}

public boolean hasStpRotCCW()
{
  return this.g;
}

public boolean hasStpRotCCWbinCent()
{
  return this.j;
}

public final boolean isInitialized()
{
  return true;
}

public MapCommons mergeFrom(ReadStream paramReadStream)
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
      cmn.Matrix localMatrix3 = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix3);
      setStatesX(localMatrix3);
      break;
    case 16: 
      addStpIndStart(paramReadStream.calc3());
      break;
    case 24: 
      addStpIndEnd(paramReadStream.calc3());
      break;
    case 34: 
      be.DoubleArray localDoubleArray3 = new be.DoubleArray();
      paramReadStream.getInstance(localDoubleArray3);
      setStpEucDist(localDoubleArray3);
      break;
    case 42: 
      be.DoubleArray localDoubleArray2 = new be.DoubleArray();
      paramReadStream.getInstance(localDoubleArray2);
      setStpRotCCW(localDoubleArray2);
      break;
    case 48: 
      addStpRotCCWbin(paramReadStream.calc3());
      break;
    case 58: 
      be.DoubleArray localDoubleArray1 = new be.DoubleArray();
      paramReadStream.getInstance(localDoubleArray1);
      setStpRotCCWbinCent(localDoubleArray1);
      break;
    case 66: 
      cmn.Matrix localMatrix2 = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix2);
      setStateMagObs(localMatrix2);
      break;
    case 74: 
      cmn.Matrix localMatrix1 = new cmn.Matrix();
      paramReadStream.getInstance(localMatrix1);
      setStateWifiObs(localMatrix1);
      break;
    case 82: // 'R'
        cmn.Graphic localGraphic = new cmn.Graphic();
        paramReadStream.getInstance(localGraphic);
        setGraphics(localGraphic);
        break;
    }
  }
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(IOException ex) {
	  ex.printStackTrace();
}
return null;	
}

public MapCommons setGraphics(cmn.Graphic paramGraphic)
{
  if (paramGraphic == null) {
    throw new NullPointerException();
  }
  this.p = true;
  this.q = paramGraphic;
  return this;
}

public MapCommons setStateMagObs(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.l = true;
  this.m = paramMatrix;
  return this;
}

public MapCommons setStateWifiObs(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.n = true;
  this.o = paramMatrix;
  return this;
}

public MapCommons setStatesX(cmn.Matrix paramMatrix)
{
  if (paramMatrix == null) {
    throw new NullPointerException();
  }
  this.a = true;
  this.b = paramMatrix;
  return this;
}

public MapCommons setStpEucDist(be.DoubleArray paramDoubleArray)
{
  if (paramDoubleArray == null) {
    throw new NullPointerException();
  }
  this.e = true;
  this.f = paramDoubleArray;
  return this;
}

public MapCommons setStpIndEnd(int paramInt1, int paramInt2)
{
  this.d.set(paramInt1, Integer.valueOf(paramInt2));
  return this;
}

public MapCommons setStpIndStart(int paramInt1, int paramInt2)
{
  this.c.set(paramInt1, Integer.valueOf(paramInt2));
  return this;
}

public MapCommons setStpRotCCW(be.DoubleArray paramDoubleArray)
{
  if (paramDoubleArray == null) {
    throw new NullPointerException();
  }
  this.g = true;
  this.h = paramDoubleArray;
  return this;
}

public MapCommons setStpRotCCWbin(int paramInt1, int paramInt2)
{
  this.i.set(paramInt1, Integer.valueOf(paramInt2));
  return this;
}

public MapCommons setStpRotCCWbinCent(be.DoubleArray paramDoubleArray)
{
  if (paramDoubleArray == null) {
    throw new NullPointerException();
  }
  this.j = true;
  this.k = paramDoubleArray;
  return this;
}

public void writeTo(WriteStream writestream)
{
    Iterator iterator;
    if(hasStatesX())
        writestream.getInstance(1, getStatesX());
    iterator = getStpIndStartList().iterator();
    for(;iterator.hasNext();) {
	    writestream.dataLength(2, ((Integer)iterator.next()).intValue());
    }

    Iterator iterator1 = getStpIndEndList().iterator();
    for(;iterator1.hasNext();) {
    	    writestream.dataLength(3, ((Integer)iterator1.next()).intValue());
    }
    Iterator iterator2;
    if(hasStpEucDist())
        writestream.getInstance(4, getStpEucDist());
    if(hasStpRotCCW())
        writestream.getInstance(5, getStpRotCCW());
    iterator2 = getStpRotCCWbinList().iterator();
    for(;iterator2.hasNext();) {
        writestream.dataLength(6, ((Integer)iterator2.next()).intValue());
    }

    if(hasStpRotCCWbinCent())
        writestream.getInstance(7, getStpRotCCWbinCent());
    if(hasStateMagObs())
        writestream.getInstance(8, getStateMagObs());
    if(hasStateWifiObs())
        writestream.getInstance(9, getStateWifiObs());
    if(hasGraphics())
        writestream.getInstance(10, getGraphics());
    return;
}



}





public static class MapJob
extends CacheBase
{
public static final int GRAPHICS_ID_FIELD_NUMBER = 2;
public static final int LEVEL_ID_FIELD_NUMBER = 1;
private boolean a;
private String b = "";
private boolean c;
private String d = "";
private int e = -1;

public static MapJob parseFrom(ReadStream paramReadStream)
{
  return new MapJob().mergeFrom(paramReadStream);
}

public static MapJob parseFrom(byte[] paramArrayOfByte)
{
  return (MapJob)new MapJob().mergeFrom(paramArrayOfByte);
}

public final MapJob clear()
{
  clearLevelId();
  clearGraphicsId();
  this.e = -1;
  return this;
}

public MapJob clearGraphicsId()
{
  this.c = false;
  this.d = "";
  return this;
}

public MapJob clearLevelId()
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

public String getGraphicsId()
{
  return this.d;
}

public String getLevelId()
{
  return this.b;
}

public int getSerializedSize()
{
  boolean bool = hasLevelId();
  int i = 0;
  if (bool) {
    i = 0 + WriteStream.dataLength(1, getLevelId());
  }
  if (hasGraphicsId()) {
    i += WriteStream.dataLength(2, getGraphicsId());
  }
  this.e = i;
  return i;
}

public boolean hasGraphicsId()
{
  return this.c;
}

public boolean hasLevelId()
{
  return this.a;
}

public final boolean isInitialized()
{
  return true;
}

public MapJob mergeFrom(ReadStream paramReadStream)
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
      setLevelId(paramReadStream.getStr());
      break;
    case 18: // '\022'
        setGraphicsId(paramReadStream.getStr());
        break;
    }
  }
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(IOException ex) {
	  ex.printStackTrace();
}
return null;
}

public MapJob setGraphicsId(String paramString)
{
  this.c = true;
  this.d = paramString;
  return this;
}

public MapJob setLevelId(String paramString)
{
  this.a = true;
  this.b = paramString;
  return this;
}

public void writeTo(WriteStream paramWriteStream)
{
try {
	if (hasLevelId()) {
    paramWriteStream.getInstance(1, getLevelId());
  }
  if (hasGraphicsId()) {
    paramWriteStream.getInstance(2, getGraphicsId());
  }
} catch(ExceptionManager mng) {
	  mng.printStackTrace();
} catch(Exception ex) {
	  ex.printStackTrace();
}
  
}
}



public static class Maps
  extends CacheBase
{
  public static final int MAPS_FIELD_NUMBER = 1;
  private List a = Collections.emptyList();
  private int b = -1;
  
  public static Maps parseFrom(ReadStream paramReadStream)
  {
    return new Maps().mergeFrom(paramReadStream);
  }
  
  public static Maps parseFrom(byte[] paramArrayOfByte)
  {
    return (Maps)new Maps().mergeFrom(paramArrayOfByte);
  }
  
  public Maps addMaps(be.Map paramMap)
  {
    if (paramMap == null) {
      throw new NullPointerException();
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramMap);
    return this;
  }
  
  public final Maps clear()
  {
    clearMaps();
    this.b = -1;
    return this;
  }
  
  public Maps clearMaps()
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
  
  public be.Map getMaps(int paramInt)
  {
    return (be.Map)this.a.get(paramInt);
  }
  
  public int getMapsCount()
  {
    return this.a.size();
  }
  
  public List getMapsList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
      Iterator iterator = getMapsList().iterator();
      int i = 0;
      for(;iterator.hasNext();) 
      {
          i += WriteStream.dataLength(1, (be.Map)iterator.next());
      }
      b = i;
      return i;
  }  
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Maps mergeFrom(ReadStream paramReadStream)
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
          be.Map localMap = new be.Map();
          paramReadStream.getInstance(localMap);
          addMaps(localMap);
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
  
  public Maps setMaps(int paramInt, be.Map paramMap)
  {
    if (paramMap == null) {
      throw new NullPointerException();
    }
    this.a.set(paramInt, paramMap);
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    Iterator localIterator = getMapsList().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      paramWriteStream.getInstance(1, (be.Map)localIterator.next());
    }
  }
}





public static class Mask
  extends CacheBase
{
  public static final int CONTAINER_FIELD_NUMBER = 4;
  public static final int GRAPHICS_ID_FIELD_NUMBER = 2;
  public static final int GRAPHICS_MASK_TYPE_FIELD_NUMBER = 3;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int INSERT_TIME_FIELD_NUMBER = 5;
  public static final int UPDATE_TIME_FIELD_NUMBER = 6;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private be.MaskType f = null;
  private boolean g;
  private String h = "";
  private boolean i;
  private String j = "";
  private boolean k;
  private String l = "";
  private int m = -1;
  
  public static Mask parseFrom(ReadStream paramReadStream)
  {
    return new Mask().mergeFrom(paramReadStream);
  }
  
  public static Mask parseFrom(byte[] paramArrayOfByte)
  {
    return (Mask)new Mask().mergeFrom(paramArrayOfByte);
  }
  
  public final Mask clear()
  {
    clearId();
    clearGraphicsId();
    clearGraphicsMaskType();
    clearContainer();
    clearInsertTime();
    clearUpdateTime();
    this.m = -1;
    return this;
  }
  
  public Mask clearContainer()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public Mask clearGraphicsId()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public Mask clearGraphicsMaskType()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public Mask clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Mask clearInsertTime()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public Mask clearUpdateTime()
  {
    this.k = false;
    this.l = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.m < 0) {
      getSerializedSize();
    }
    return this.m;
  }
  
  public String getContainer()
  {
    return this.h;
  }
  
  public String getGraphicsId()
  {
    return this.d;
  }
  
  public be.MaskType getGraphicsMaskType()
  {
    return this.f;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getInsertTime()
  {
    return this.j;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasId();
    int n = 0;
    if (bool) {
      n = 0 + WriteStream.dataLength(1, getId());
    }
    if (hasGraphicsId()) {
      n += WriteStream.dataLength(2, getGraphicsId());
    }
    if (hasGraphicsMaskType()) {
      n += WriteStream.dataLength(3, getGraphicsMaskType());
    }
    if (hasContainer()) {
      n += WriteStream.dataLength(4, getContainer());
    }
    if (hasInsertTime()) {
      n += WriteStream.dataLength(5, getInsertTime());
    }
    if (hasUpdateTime()) {
      n += WriteStream.dataLength(6, getUpdateTime());
    }
    this.m = n;
    return n;
  }
  
  public String getUpdateTime()
  {
    return this.l;
  }
  
  public boolean hasContainer()
  {
    return this.g;
  }
  
  public boolean hasGraphicsId()
  {
    return this.c;
  }
  
  public boolean hasGraphicsMaskType()
  {
    return this.e;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasInsertTime()
  {
    return this.i;
  }
  
  public boolean hasUpdateTime()
  {
    return this.k;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Mask mergeFrom(ReadStream paramReadStream)
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
        setGraphicsId(paramReadStream.getStr());
        break;
      case 26: 
        be.MaskType localMaskType = new be.MaskType();
        paramReadStream.getInstance(localMaskType);
        setGraphicsMaskType(localMaskType);
        break;
      case 34: 
        setContainer(paramReadStream.getStr());
        break;
      case 42: 
        setInsertTime(paramReadStream.getStr());
        break;
      case 50: // '2'
          setUpdateTime(paramReadStream.getStr());
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
  
  public Mask setContainer(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public Mask setGraphicsId(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public Mask setGraphicsMaskType(be.MaskType paramMaskType)
  {
    if (paramMaskType == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramMaskType;
    return this;
  }
  
  public Mask setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Mask setInsertTime(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public Mask setUpdateTime(String paramString)
  {
    this.k = true;
    this.l = paramString;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    try {
	  if (hasId()) {
      paramWriteStream.getInstance(1, getId());
    }
    if (hasGraphicsId()) {
      paramWriteStream.getInstance(2, getGraphicsId());
    }
    if (hasGraphicsMaskType()) {
      paramWriteStream.getInstance(3, getGraphicsMaskType());
    }
    if (hasContainer()) {
      paramWriteStream.getInstance(4, getContainer());
    }
    if (hasInsertTime()) {
      paramWriteStream.getInstance(5, getInsertTime());
    }
    if (hasUpdateTime()) {
      paramWriteStream.getInstance(6, getUpdateTime());
    }
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(Exception ex) {
		  ex.printStackTrace();
	  }
    
  }
}




public static class MaskType
  extends CacheBase
{
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  public static final int HELP_FIELD_NUMBER = 4;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int NAME_FIELD_NUMBER = 2;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private String h = "";
  private int i = -1;
  
  public static MaskType parseFrom(ReadStream paramReadStream)
  {
    return new MaskType().mergeFrom(paramReadStream);
  }
  
  public static MaskType parseFrom(byte[] paramArrayOfByte)
  {
    return (MaskType)new MaskType().mergeFrom(paramArrayOfByte);
  }
  
  public final MaskType clear()
  {
    clearId();
    clearName();
    clearDescription();
    clearHelp();
    this.i = -1;
    return this;
  }
  
  public MaskType clearDescription()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public MaskType clearHelp()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public MaskType clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public MaskType clearName()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.i < 0) {
      getSerializedSize();
    }
    return this.i;
  }
  
  public String getDescription()
  {
    return this.f;
  }
  
  public String getHelp()
  {
    return this.h;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasId();
    int j = 0;
    if (bool) {
      j = 0 + WriteStream.dataLength(1, getId());
    }
    if (hasName()) {
      j += WriteStream.dataLength(2, getName());
    }
    if (hasDescription()) {
      j += WriteStream.dataLength(3, getDescription());
    }
    if (hasHelp()) {
      j += WriteStream.dataLength(4, getHelp());
    }
    this.i = j;
    return j;
  }
  
  public boolean hasDescription()
  {
    return this.e;
  }
  
  public boolean hasHelp()
  {
    return this.g;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasName()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public MaskType mergeFrom(ReadStream paramReadStream)
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
        setId(paramReadStream.getStr());
        break;
      case 18: 
        setName(paramReadStream.getStr());
        break;
      case 26: 
        setDescription(paramReadStream.getStr());
        break;
      case 34: // '"'
          setHelp(paramReadStream.getStr());
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
  
  public MaskType setDescription(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public MaskType setHelp(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public MaskType setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public MaskType setName(String paramString)
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
    if (hasName()) {
      paramWriteStream.getInstance(2, getName());
    }
    if (hasDescription()) {
      paramWriteStream.getInstance(3, getDescription());
    }
    if (hasHelp()) {
      paramWriteStream.getInstance(4, getHelp());
    }
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(Exception ex) {
		  ex.printStackTrace();
	  }
    
  }
}




public static class PointOfInterest
  extends CacheBase
{
  public static final int BOUNDING_POLYGON_FIELD_NUMBER = 14;
  public static final int COUNTER_PART_POI_ID_FIELD_NUMBER = 7;
  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int INSERTTIME_FIELD_NUMBER = 8;
  public static final int MARKER_IMAGE_URL_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int UPDATETIME_FIELD_NUMBER = 9;
  public static final int URL_FIELD_NUMBER = 15;
  public static final int USER_FIELD_NUMBER = 5;
  public static final int VALUE_FIELD_NUMBER = 6;
  public static final int X_FIELD_NUMBER = 10;
  public static final int Y_FIELD_NUMBER = 11;
  public static final int Z_FIELD_NUMBER = 12;
  private String A = "";
  private int B = -1;
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
  private String n = "";
  private boolean o;
  private long p = 0L;
  private boolean q;
  private long r = 0L;
  private boolean s;
  private double t = 0.0D;
  private boolean u;
  private double v = 0.0D;
  private boolean w;
  private double x = 0.0D;
  private List y = Collections.emptyList();
  private boolean z;
  
  public static PointOfInterest parseFrom(ReadStream paramReadStream)
  {
    return new PointOfInterest().mergeFrom(paramReadStream);
  }
  
  public static PointOfInterest parseFrom(byte[] paramArrayOfByte)
  {
    return (PointOfInterest)new PointOfInterest().mergeFrom(paramArrayOfByte);
  }
  
  public PointOfInterest addBoundingPolygon(be.Polygon paramPolygon)
  {
    if (paramPolygon == null) {
      throw new NullPointerException();
    }
    if (this.y.isEmpty()) {
      this.y = new ArrayList();
    }
    this.y.add(paramPolygon);
    return this;
  }
  
  public final PointOfInterest clear()
  {
    clearId();
    clearName();
    clearMarkerImageUrl();
    clearDescription();
    clearUser();
    clearValue();
    clearCounterPartPoiId();
    clearInsertTime();
    clearUpdateTime();
    clearX();
    clearY();
    clearZ();
    clearBoundingPolygon();
    clearUrl();
    this.B = -1;
    return this;
  }
  
  public PointOfInterest clearBoundingPolygon()
  {
    this.y = Collections.emptyList();
    return this;
  }
  
  public PointOfInterest clearCounterPartPoiId()
  {
    this.m = false;
    this.n = "";
    return this;
  }
  
  public PointOfInterest clearDescription()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public PointOfInterest clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public PointOfInterest clearInsertTime()
  {
    this.o = false;
    this.p = 0L;
    return this;
  }
  
  public PointOfInterest clearMarkerImageUrl()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public PointOfInterest clearName()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public PointOfInterest clearUpdateTime()
  {
    this.q = false;
    this.r = 0L;
    return this;
  }
  
  public PointOfInterest clearUrl()
  {
    this.z = false;
    this.A = "";
    return this;
  }
  
  public PointOfInterest clearUser()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public PointOfInterest clearValue()
  {
    this.k = false;
    this.l = "";
    return this;
  }
  
  public PointOfInterest clearX()
  {
    this.s = false;
    this.t = 0.0D;
    return this;
  }
  
  public PointOfInterest clearY()
  {
    this.u = false;
    this.v = 0.0D;
    return this;
  }
  
  public PointOfInterest clearZ()
  {
    this.w = false;
    this.x = 0.0D;
    return this;
  }
  
  public be.Polygon getBoundingPolygon(int paramInt)
  {
    return (be.Polygon)this.y.get(paramInt);
  }
  
  public int getBoundingPolygonCount()
  {
    return this.y.size();
  }
  
  public List getBoundingPolygonList()
  {
    return this.y;
  }
  
  public int getCachedSize()
  {
    if (this.B < 0) {
      getSerializedSize();
    }
    return this.B;
  }
  
  public String getCounterPartPoiId()
  {
    return this.n;
  }
  
  public String getDescription()
  {
    return this.h;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public long getInsertTime()
  {
    return this.p;
  }
  
  public String getMarkerImageUrl()
  {
    return this.f;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  
  public int getSerializedSize()
  {
      boolean flag = hasId();
      int i1 = 0;
      if(flag)
          i1 = 0 + WriteStream.dataLength(1, getId());
      if(hasName())
          i1 += WriteStream.dataLength(2, getName());
      if(hasMarkerImageUrl())
          i1 += WriteStream.dataLength(3, getMarkerImageUrl());
      if(hasDescription())
          i1 += WriteStream.dataLength(4, getDescription());
      if(hasUser())
          i1 += WriteStream.dataLength(5, getUser());
      if(hasValue())
          i1 += WriteStream.dataLength(6, getValue());
      if(hasCounterPartPoiId())
          i1 += WriteStream.dataLength(7, getCounterPartPoiId());
      if(hasInsertTime())
          i1 += WriteStream.bindLength(8, getInsertTime());
      if(hasUpdateTime())
          i1 += WriteStream.bindLength(9, getUpdateTime());
      if(hasX())
          i1 += WriteStream.dataLength(10, getX());
      if(hasY())
          i1 += WriteStream.dataLength(11, getY());
      if(hasZ())
          i1 += WriteStream.dataLength(12, getZ());
      Iterator iterator = getBoundingPolygonList().iterator();
      int j1 = i1;
      for(;iterator.hasNext();)
      {
          j1 += WriteStream.dataLength(14, (be.Polygon)iterator.next());
      }
      if(hasUrl())
          j1 += WriteStream.dataLength(15, getUrl());
      B = j1;
      return j1;
      
  }
  
  
  
  public long getUpdateTime()
  {
    return this.r;
  }
  
  public String getUrl()
  {
    return this.A;
  }
  
  public String getUser()
  {
    return this.j;
  }
  
  public String getValue()
  {
    return this.l;
  }
  
  public double getX()
  {
    return this.t;
  }
  
  public double getY()
  {
    return this.v;
  }
  
  public double getZ()
  {
    return this.x;
  }
  
  public boolean hasCounterPartPoiId()
  {
    return this.m;
  }
  
  public boolean hasDescription()
  {
    return this.g;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasInsertTime()
  {
    return this.o;
  }
  
  public boolean hasMarkerImageUrl()
  {
    return this.e;
  }
  
  public boolean hasName()
  {
    return this.c;
  }
  
  public boolean hasUpdateTime()
  {
    return this.q;
  }
  
  public boolean hasUrl()
  {
    return this.z;
  }
  
  public boolean hasUser()
  {
    return this.i;
  }
  
  public boolean hasValue()
  {
    return this.k;
  }
  
  public boolean hasX()
  {
    return this.s;
  }
  
  public boolean hasY()
  {
    return this.u;
  }
  
  public boolean hasZ()
  {
    return this.w;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public PointOfInterest mergeFrom(ReadStream paramReadStream)
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
        setName(paramReadStream.getStr());
        break;
      case 26: 
        setMarkerImageUrl(paramReadStream.getStr());
        break;
      case 34: 
        setDescription(paramReadStream.getStr());
        break;
      case 42: 
        setUser(paramReadStream.getStr());
        break;
      case 50: 
        setValue(paramReadStream.getStr());
        break;
      case 58: 
        setCounterPartPoiId(paramReadStream.getStr());
        break;
      case 64: 
        setInsertTime(paramReadStream.is1());
        break;
      case 72: 
        setUpdateTime(paramReadStream.is1());
        break;
      case 81: 
        setX(paramReadStream.getStatus());
        break;
      case 89: 
        setY(paramReadStream.getStatus());
        break;
      case 97: 
        setZ(paramReadStream.getStatus());
        break;
      case 114: 
        be.Polygon localPolygon = new be.Polygon();
        paramReadStream.getInstance(localPolygon);
        addBoundingPolygon(localPolygon);
        break;
      case 122: // 'z'
          setUrl(paramReadStream.getStr());
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
  
  public PointOfInterest setBoundingPolygon(int paramInt, be.Polygon paramPolygon)
  {
    if (paramPolygon == null) {
      throw new NullPointerException();
    }
    this.y.set(paramInt, paramPolygon);
    return this;
  }
  
  public PointOfInterest setCounterPartPoiId(String paramString)
  {
    this.m = true;
    this.n = paramString;
    return this;
  }
  
  public PointOfInterest setDescription(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public PointOfInterest setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public PointOfInterest setInsertTime(long paramLong)
  {
    this.o = true;
    this.p = paramLong;
    return this;
  }
  
  public PointOfInterest setMarkerImageUrl(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public PointOfInterest setName(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public PointOfInterest setUpdateTime(long paramLong)
  {
    this.q = true;
    this.r = paramLong;
    return this;
  }
  
  public PointOfInterest setUrl(String paramString)
  {
    this.z = true;
    this.A = paramString;
    return this;
  }
  
  public PointOfInterest setUser(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public PointOfInterest setValue(String paramString)
  {
    this.k = true;
    this.l = paramString;
    return this;
  }
  
  public PointOfInterest setX(double paramDouble)
  {
    this.s = true;
    this.t = paramDouble;
    return this;
  }
  
  public PointOfInterest setY(double paramDouble)
  {
    this.u = true;
    this.v = paramDouble;
    return this;
  }
  
  public PointOfInterest setZ(double paramDouble)
  {
    this.w = true;
    this.x = paramDouble;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    try {
	  if (hasId()) {
      paramWriteStream.getInstance(1, getId());
    }
    if (hasName()) {
      paramWriteStream.getInstance(2, getName());
    }
    if (hasMarkerImageUrl()) {
      paramWriteStream.getInstance(3, getMarkerImageUrl());
    }
    if (hasDescription()) {
      paramWriteStream.getInstance(4, getDescription());
    }
    if (hasUser()) {
      paramWriteStream.getInstance(5, getUser());
    }
    if (hasValue()) {
      paramWriteStream.getInstance(6, getValue());
    }
    if (hasCounterPartPoiId()) {
      paramWriteStream.getInstance(7, getCounterPartPoiId());
    }
    if (hasInsertTime()) {
      paramWriteStream.getInstance(8, getInsertTime());
    }
    if (hasUpdateTime()) {
      paramWriteStream.getInstance(9, getUpdateTime());
    }
    if (hasX()) {
      paramWriteStream.getInstance(10, getX());
    }
    if (hasY()) {
      paramWriteStream.getInstance(11, getY());
    }
    if (hasZ()) {
      paramWriteStream.getInstance(12, getZ());
    }
    Iterator localIterator = getBoundingPolygonList().iterator();
    for (;localIterator.hasNext();)
	{
	   paramWriteStream.getInstance(14, (be.Polygon)localIterator.next());
	}
    if (hasUrl()) {
      paramWriteStream.getInstance(15, getUrl());
	}
	return;
    } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }
    
  }
    
}





public static class Polygon
  extends CacheBase
{
  public static final int ID_FIELD_NUMBER = 1;
  public static final int INSERT_TIME_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int POLYGON_POINTS_FIELD_NUMBER = 5;
  public static final int UPDATE_TIME_FIELD_NUMBER = 4;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private long f = 0L;
  private boolean g;
  private long h = 0L;
  private List i = Collections.emptyList();
  private int j = -1;
  
  public static Polygon parseFrom(ReadStream paramReadStream)
  {
    return new Polygon().mergeFrom(paramReadStream);
  }
  
  public static Polygon parseFrom(byte[] paramArrayOfByte)
  {
    return (Polygon)new Polygon().mergeFrom(paramArrayOfByte);
  }
  
  public Polygon addPolygonPoints(cmn.PixelPosition paramPixelPosition)
  {
    if (paramPixelPosition == null) {
      throw new NullPointerException();
    }
    if (this.i.isEmpty()) {
      this.i = new ArrayList();
    }
    this.i.add(paramPixelPosition);
    return this;
  }
  
  public final Polygon clear()
  {
    clearId();
    clearName();
    clearInsertTime();
    clearUpdateTime();
    clearPolygonPoints();
    this.j = -1;
    return this;
  }
  
  public Polygon clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Polygon clearInsertTime()
  {
    this.e = false;
    this.f = 0L;
    return this;
  }
  
  public Polygon clearName()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public Polygon clearPolygonPoints()
  {
    this.i = Collections.emptyList();
    return this;
  }
  
  public Polygon clearUpdateTime()
  {
    this.g = false;
    this.h = 0L;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.j < 0) {
      getSerializedSize();
    }
    return this.j;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public long getInsertTime()
  {
    return this.f;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public cmn.PixelPosition getPolygonPoints(int paramInt)
  {
    return (cmn.PixelPosition)this.i.get(paramInt);
  }
  
  public int getPolygonPointsCount()
  {
    return this.i.size();
  }
  
  public List getPolygonPointsList()
  {
    return this.i;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasId();
    int k = 0;
    if (bool) {
      k = 0 + WriteStream.dataLength(1, getId());
    }
    if (hasName()) {
      k += WriteStream.dataLength(2, getName());
    }
    if (hasInsertTime()) {
      k += WriteStream.bindLength(3, getInsertTime());
    }
    if (hasUpdateTime()) {
      k += WriteStream.bindLength(4, getUpdateTime());
    }
    Iterator localIterator = getPolygonPointsList().iterator();
    int m = k;
    for (;localIterator.hasNext();)
    {
      m += WriteStream.dataLength(5, (cmn.PixelPosition)localIterator.next());
    }
    
    this.j = m;
    return m;
  }
  
  public long getUpdateTime()
  {
    return this.h;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasInsertTime()
  {
    return this.e;
  }
  
  public boolean hasName()
  {
    return this.c;
  }
  
  public boolean hasUpdateTime()
  {
    return this.g;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Polygon mergeFrom(ReadStream paramReadStream)
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
      case 10: 
        setId(paramReadStream.getStr());
        break;
      case 18: 
        setName(paramReadStream.getStr());
        break;
      case 24: 
        setInsertTime(paramReadStream.is1());
        break;
      case 32: 
        setUpdateTime(paramReadStream.is1());
        break;
      case 42: // '*'
          cmn.PixelPosition localPixelPosition = new cmn.PixelPosition();
          paramReadStream.getInstance(localPixelPosition);
          addPolygonPoints(localPixelPosition);
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
  
  public Polygon setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Polygon setInsertTime(long paramLong)
  {
    this.e = true;
    this.f = paramLong;
    return this;
  }
  
  public Polygon setName(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public Polygon setPolygonPoints(int paramInt, cmn.PixelPosition paramPixelPosition)
  {
    if (paramPixelPosition == null) {
      throw new NullPointerException();
    }
    this.i.set(paramInt, paramPixelPosition);
    return this;
  }
  
  public Polygon setUpdateTime(long paramLong)
  {
    this.g = true;
    this.h = paramLong;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    try {
	  
	if (hasId()) {
      paramWriteStream.getInstance(1, getId());
    }
    if (hasName()) {
      paramWriteStream.getInstance(2, getName());
    }
    if (hasInsertTime()) {
      paramWriteStream.getInstance(3, getInsertTime());
    }
    if (hasUpdateTime()) {
      paramWriteStream.getInstance(4, getUpdateTime());
    }
    Iterator localIterator = getPolygonPointsList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(5, (cmn.PixelPosition)localIterator.next());
    }
    } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }
    
  }
}



public static class Route
  extends CacheBase
{
  public static final int POINTS_FIELD_NUMBER = 2;
  public static final int SAMPLING_RATE_FIELD_NUMBER = 1;
  private boolean a;
  private int b = 0;
  private List c = Collections.emptyList();
  private int d = -1;
  
  public static Route parseFrom(ReadStream paramReadStream)
  {
    return new Route().mergeFrom(paramReadStream);
  }
  
  public static Route parseFrom(byte[] paramArrayOfByte)
  {
    return (Route)new Route().mergeFrom(paramArrayOfByte);
  }
  
  public Route addPoints(cmn.RoutePoint paramRoutePoint)
  {
    if (paramRoutePoint == null) {
      throw new NullPointerException();
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramRoutePoint);
    return this;
  }
  
  public final Route clear()
  {
    clearSamplingRate();
    clearPoints();
    this.d = -1;
    return this;
  }
  
  public Route clearPoints()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public Route clearSamplingRate()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.d < 0) {
      getSerializedSize();
    }
    return this.d;
  }
  
  public cmn.RoutePoint getPoints(int paramInt)
  {
    return (cmn.RoutePoint)this.c.get(paramInt);
  }
  
  public int getPointsCount()
  {
    return this.c.size();
  }
  
  public List getPointsList()
  {
    return this.c;
  }
  
  public int getSamplingRate()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasSamplingRate();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.bindLength3(1, getSamplingRate());
    }
    Iterator localIterator = getPointsList().iterator();
    int j = i;
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.d = j;
        return j;
      }
      j += WriteStream.dataLength(2, (cmn.RoutePoint)localIterator.next());
    }
  }
  
  public boolean hasSamplingRate()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Route mergeFrom(ReadStream paramReadStream)
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
        setSamplingRate(paramReadStream.calc3());
        break;
      case 18: // '\022'
          cmn.RoutePoint localRoutePoint = new cmn.RoutePoint();
          paramReadStream.getInstance(localRoutePoint);
          addPoints(localRoutePoint);
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
  
  public Route setPoints(int paramInt, cmn.RoutePoint paramRoutePoint)
  {
    if (paramRoutePoint == null) {
      throw new NullPointerException();
    }
    this.c.set(paramInt, paramRoutePoint);
    return this;
  }
  
  public Route setSamplingRate(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasSamplingRate()) {
      paramWriteStream.dataLength(1, getSamplingRate());
    }
    Iterator localIterator = getPointsList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(2, (cmn.RoutePoint)localIterator.next());
    }
  }
}


public static class SensorTransformation
  extends CacheBase
{
  public static final int ACC_MAPPING_FIELD_NUMBER = 1;
  public static final int GYRO_MAPPING_FIELD_NUMBER = 2;
  public static final int MGN_MAPPING_FIELD_NUMBER = 3;
  private boolean a;
  private cmn.Matrix b = null;
  private boolean c;
  private cmn.Matrix d = null;
  private boolean e;
  private cmn.Matrix f = null;
  private int g = -1;
  
  public static SensorTransformation parseFrom(ReadStream paramReadStream)
  {
    return new SensorTransformation().mergeFrom(paramReadStream);
  }
  
  public static SensorTransformation parseFrom(byte[] paramArrayOfByte)
  {
    return (SensorTransformation)new SensorTransformation().mergeFrom(paramArrayOfByte);
  }
  
  public final SensorTransformation clear()
  {
    clearAccMapping();
    clearGyroMapping();
    clearMgnMapping();
    this.g = -1;
    return this;
  }
  
  public SensorTransformation clearAccMapping()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public SensorTransformation clearGyroMapping()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public SensorTransformation clearMgnMapping()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public cmn.Matrix getAccMapping()
  {
    return this.b;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public cmn.Matrix getGyroMapping()
  {
    return this.d;
  }
  
  public cmn.Matrix getMgnMapping()
  {
    return this.f;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasAccMapping();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getAccMapping());
    }
    if (hasGyroMapping()) {
      i += WriteStream.dataLength(2, getGyroMapping());
    }
    if (hasMgnMapping()) {
      i += WriteStream.dataLength(3, getMgnMapping());
    }
    this.g = i;
    return i;
  }
  
  public boolean hasAccMapping()
  {
    return this.a;
  }
  
  public boolean hasGyroMapping()
  {
    return this.c;
  }
  
  public boolean hasMgnMapping()
  {
    return this.e;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SensorTransformation mergeFrom(ReadStream paramReadStream)
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
        cmn.Matrix localMatrix3 = new cmn.Matrix();
        paramReadStream.getInstance(localMatrix3);
        setAccMapping(localMatrix3);
        break;
      case 18: 
        cmn.Matrix localMatrix2 = new cmn.Matrix();
        paramReadStream.getInstance(localMatrix2);
        setGyroMapping(localMatrix2);
        break;
      case 26: // '\032'
          cmn.Matrix localMatrix1 = new cmn.Matrix();
          paramReadStream.getInstance(localMatrix1);
          setMgnMapping(localMatrix1);
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
  
  public SensorTransformation setAccMapping(cmn.Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramMatrix;
    return this;
  }
  
  public SensorTransformation setGyroMapping(cmn.Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new NullPointerException();
    }
    this.c = true;
    this.d = paramMatrix;
    return this;
  }
  
  public SensorTransformation setMgnMapping(cmn.Matrix paramMatrix)
  {
    if (paramMatrix == null) {
      throw new NullPointerException();
    }
    this.e = true;
    this.f = paramMatrix;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    if (hasAccMapping()) {
      paramWriteStream.getInstance(1, getAccMapping());
    }
    if (hasGyroMapping()) {
      paramWriteStream.getInstance(2, getGyroMapping());
    }
    if (hasMgnMapping()) {
      paramWriteStream.getInstance(3, getMgnMapping());
    }
  }
}


public static class Sequence
  extends CacheBase
{
  public static final int CALIBRATION_VALUES_FIELD_NUMBER = 17;
  public static final int COORDINATE_SYSTEM_FIELD_NUMBER = 3;
  public static final int DATA_FORMAT_FIELD_NUMBER = 8;
  public static final int DEVICE_MODEL_FIELD_NUMBER = 10;
  public static final int END_TIME_FIELD_NUMBER = 16;
  public static final int GRAPHICS_LINK_FIELD_NUMBER = 7;
  public static final int IDA_UUID_FIELD_NUMBER = 5;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int LABEL_FIELD_NUMBER = 11;
  public static final int MC_VERSION_FIELD_NUMBER = 9;
  public static final int MEASUREMENT_FIELD_NUMBER = 14;
  public static final int POINTS_FIELD_NUMBER = 13;
  public static final int SENSOR_NUM_FIELD_NUMBER = 12;
  public static final int SEQUENCE_TYPE_FIELD_NUMBER = 6;
  public static final int START_TIME_FIELD_NUMBER = 15;
  public static final int URL_FIELD_NUMBER = 2;
  public static final int USER_ID_FIELD_NUMBER = 4;
  private cmn.Measurement A = null;
  private boolean B;
  private long C = 0L;
  private boolean D;
  private long E = 0L;
  private boolean F;
  private be.CalibrationValues G = null;
  private int H = -1;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private cmn.Link h = null;
  private boolean i;
  private String j = "";
  private boolean k;
  private int l = 0;
  private boolean m;
  private cmn.Link n = null;
  private boolean o;
  private int p = 0;
  private boolean q;
  private String r = "";
  private boolean s;
  private cmn.Link t = null;
  private boolean u;
  private String v = "";
  private boolean w;
  private int x = 0;
  private List y = Collections.emptyList();
  private boolean z;
  
  public static Sequence parseFrom(ReadStream paramReadStream)
  {
    return new Sequence().mergeFrom(paramReadStream);
  }
  
  public static Sequence parseFrom(byte[] paramArrayOfByte)
  {
    return (Sequence)new Sequence().mergeFrom(paramArrayOfByte);
  }
  
  public Sequence addPoints(be.SequencePoint paramSequencePoint)
  {
    if (paramSequencePoint == null) {
      throw new NullPointerException();
    }
    if (this.y.isEmpty()) {
      this.y = new ArrayList();
    }
    this.y.add(paramSequencePoint);
    return this;
  }
  
  public final Sequence clear()
  {
    clearId();
    clearUrl();
    clearCoordinateSystem();
    clearUserId();
    clearIdaUuid();
    clearSequenceType();
    clearGraphicsLink();
    clearDataFormat();
    clearMcVersion();
    clearDeviceModel();
    clearLabel();
    clearSensorNum();
    clearPoints();
    clearMeasurement();
    clearStartTime();
    clearEndTime();
    clearCalibrationValues();
    this.H = -1;
    return this;
  }
  
  public Sequence clearCalibrationValues()
  {
    this.F = false;
    this.G = null;
    return this;
  }
  
  public Sequence clearCoordinateSystem()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public Sequence clearDataFormat()
  {
    this.o = false;
    this.p = 0;
    return this;
  }
  
  public Sequence clearDeviceModel()
  {
    this.s = false;
    this.t = null;
    return this;
  }
  
  public Sequence clearEndTime()
  {
    this.D = false;
    this.E = 0L;
    return this;
  }
  
  public Sequence clearGraphicsLink()
  {
    this.m = false;
    this.n = null;
    return this;
  }
  
  public Sequence clearId()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Sequence clearIdaUuid()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public Sequence clearLabel()
  {
    this.u = false;
    this.v = "";
    return this;
  }
  
  public Sequence clearMcVersion()
  {
    this.q = false;
    this.r = "";
    return this;
  }
  
  public Sequence clearMeasurement()
  {
    this.z = false;
    this.A = null;
    return this;
  }
  
  public Sequence clearPoints()
  {
    this.y = Collections.emptyList();
    return this;
  }
  
  public Sequence clearSensorNum()
  {
    this.w = false;
    this.x = 0;
    return this;
  }
  
  public Sequence clearSequenceType()
  {
    this.k = false;
    this.l = 0;
    return this;
  }
  
  public Sequence clearStartTime()
  {
    this.B = false;
    this.C = 0L;
    return this;
  }
  
  public Sequence clearUrl()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public Sequence clearUserId()
  {
    this.g = false;
    this.h = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.H < 0) {
      getSerializedSize();
    }
    return this.H;
  }
  
  public be.CalibrationValues getCalibrationValues()
  {
    return this.G;
  }
  
  public String getCoordinateSystem()
  {
    return this.f;
  }
  
  public int getDataFormat()
  {
    return this.p;
  }
  
  public cmn.Link getDeviceModel()
  {
    return this.t;
  }
  
  public long getEndTime()
  {
    return this.E;
  }
  
  public cmn.Link getGraphicsLink()
  {
    return this.n;
  }
  
  public String getId()
  {
    return this.b;
  }
  
  public String getIdaUuid()
  {
    return this.j;
  }
  
  public String getLabel()
  {
    return this.v;
  }
  
  public String getMcVersion()
  {
    return this.r;
  }
  
  public cmn.Measurement getMeasurement()
  {
    return this.A;
  }
  
  public be.SequencePoint getPoints(int paramInt)
  {
    return (be.SequencePoint)this.y.get(paramInt);
  }
  
  public int getPointsCount()
  {
    return this.y.size();
  }
  
  public List getPointsList()
  {
    return this.y;
  }
  
  public int getSensorNum()
  {
    return this.x;
  }
  
  public int getSequenceType()
  {
    return this.l;
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
    if (hasCoordinateSystem()) {
      i1 += WriteStream.dataLength(3, getCoordinateSystem());
    }
    if (hasUserId()) {
      i1 += WriteStream.dataLength(4, getUserId());
    }
    if (hasIdaUuid()) {
      i1 += WriteStream.dataLength(5, getIdaUuid());
    }
    if (hasSequenceType()) {
      i1 += WriteStream.bindLength2(6, getSequenceType());
    }
    if (hasGraphicsLink()) {
      i1 += WriteStream.dataLength(7, getGraphicsLink());
    }
    if (hasDataFormat()) {
      i1 += WriteStream.bindLength3(8, getDataFormat());
    }
    if (hasMcVersion()) {
      i1 += WriteStream.dataLength(9, getMcVersion());
    }
    if (hasDeviceModel()) {
      i1 += WriteStream.dataLength(10, getDeviceModel());
    }
    if (hasLabel()) {
      i1 += WriteStream.dataLength(11, getLabel());
    }
    if (hasSensorNum()) {
      i1 += WriteStream.bindLength3(12, getSensorNum());
    }
    Iterator localIterator = getPointsList().iterator();
    int i2 = i1;
    for (;localIterator.hasNext();)
    {
      i2 += WriteStream.dataLength(13, (be.SequencePoint)localIterator.next());
    }
    
	  if (hasMeasurement()) {
	    i2 += WriteStream.dataLength(14, getMeasurement());
	  }
	  if (hasStartTime()) {
	    i2 += WriteStream.bindLength(15, getStartTime());
	  }
	  if (hasEndTime()) {
	    i2 += WriteStream.bindLength(16, getEndTime());
	  }
	  if (hasCalibrationValues()) {
	    i2 += WriteStream.dataLength(17, getCalibrationValues());
	  }
	  this.H = i2;
	  return i2;
    
  }
  
  public long getStartTime()
  {
    return this.C;
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public cmn.Link getUserId()
  {
    return this.h;
  }
  
  public boolean hasCalibrationValues()
  {
    return this.F;
  }
  
  public boolean hasCoordinateSystem()
  {
    return this.e;
  }
  
  public boolean hasDataFormat()
  {
    return this.o;
  }
  
  public boolean hasDeviceModel()
  {
    return this.s;
  }
  
  public boolean hasEndTime()
  {
    return this.D;
  }
  
  public boolean hasGraphicsLink()
  {
    return this.m;
  }
  
  public boolean hasId()
  {
    return this.a;
  }
  
  public boolean hasIdaUuid()
  {
    return this.i;
  }
  
  public boolean hasLabel()
  {
    return this.u;
  }
  
  public boolean hasMcVersion()
  {
    return this.q;
  }
  
  public boolean hasMeasurement()
  {
    return this.z;
  }
  
  public boolean hasSensorNum()
  {
    return this.w;
  }
  
  public boolean hasSequenceType()
  {
    return this.k;
  }
  
  public boolean hasStartTime()
  {
    return this.B;
  }
  
  public boolean hasUrl()
  {
    return this.c;
  }
  
  public boolean hasUserId()
  {
    return this.g;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Sequence mergeFrom(ReadStream paramReadStream)
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
        setCoordinateSystem(paramReadStream.getStr());
        break;
      case 34: 
        cmn.Link localLink3 = new cmn.Link();
        paramReadStream.getInstance(localLink3);
        setUserId(localLink3);
        break;
      case 42: 
        setIdaUuid(paramReadStream.getStr());
        break;
      case 48: 
        setSequenceType(paramReadStream.getMBytes());
        break;
      case 58: 
        cmn.Link localLink2 = new cmn.Link();
        paramReadStream.getInstance(localLink2);
        setGraphicsLink(localLink2);
        break;
      case 64: 
        setDataFormat(paramReadStream.calc3());
        break;
      case 74: 
        setMcVersion(paramReadStream.getStr());
        break;
      case 82: 
        cmn.Link localLink1 = new cmn.Link();
        paramReadStream.getInstance(localLink1);
        setDeviceModel(localLink1);
        break;
      case 90: 
        setLabel(paramReadStream.getStr());
        break;
      case 96: 
        setSensorNum(paramReadStream.calc3());
        break;
      case 106: 
        be.SequencePoint localSequencePoint = new be.SequencePoint();
        paramReadStream.getInstance(localSequencePoint);
        addPoints(localSequencePoint);
        break;
      case 114: 
        cmn.Measurement localMeasurement = new cmn.Measurement();
        paramReadStream.getInstance(localMeasurement);
        setMeasurement(localMeasurement);
        break;
      case 120: 
        setStartTime(paramReadStream.is1());
        break;
      case 128: 
        setEndTime(paramReadStream.is1());
        break;
      case 138: 
          be.CalibrationValues localCalibrationValues = new be.CalibrationValues();
          paramReadStream.getInstance(localCalibrationValues);
          setCalibrationValues(localCalibrationValues);
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
  
  public Sequence setCalibrationValues(be.CalibrationValues paramCalibrationValues)
  {
    if (paramCalibrationValues == null) {
      throw new NullPointerException();
    }
    this.F = true;
    this.G = paramCalibrationValues;
    return this;
  }
  
  public Sequence setCoordinateSystem(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public Sequence setDataFormat(int paramInt)
  {
    this.o = true;
    this.p = paramInt;
    return this;
  }
  
  public Sequence setDeviceModel(cmn.Link paramLink)
  {
    if (paramLink == null) {
      throw new NullPointerException();
    }
    this.s = true;
    this.t = paramLink;
    return this;
  }
  
  public Sequence setEndTime(long paramLong)
  {
    this.D = true;
    this.E = paramLong;
    return this;
  }
  
  public Sequence setGraphicsLink(cmn.Link paramLink)
  {
    if (paramLink == null) {
      throw new NullPointerException();
    }
    this.m = true;
    this.n = paramLink;
    return this;
  }
  
  public Sequence setId(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Sequence setIdaUuid(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public Sequence setLabel(String paramString)
  {
    this.u = true;
    this.v = paramString;
    return this;
  }
  
  public Sequence setMcVersion(String paramString)
  {
    this.q = true;
    this.r = paramString;
    return this;
  }
  
  public Sequence setMeasurement(cmn.Measurement paramMeasurement)
  {
    if (paramMeasurement == null) {
      throw new NullPointerException();
    }
    this.z = true;
    this.A = paramMeasurement;
    return this;
  }
  
  public Sequence setPoints(int paramInt, be.SequencePoint paramSequencePoint)
  {
    if (paramSequencePoint == null) {
      throw new NullPointerException();
    }
    this.y.set(paramInt, paramSequencePoint);
    return this;
  }
  
  public Sequence setSensorNum(int paramInt)
  {
    this.w = true;
    this.x = paramInt;
    return this;
  }
  
  public Sequence setSequenceType(int paramInt)
  {
    this.k = true;
    this.l = paramInt;
    return this;
  }
  
  public Sequence setStartTime(long paramLong)
  {
    this.B = true;
    this.C = paramLong;
    return this;
  }
  
  public Sequence setUrl(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public Sequence setUserId(cmn.Link paramLink)
  {
    if (paramLink == null) {
      throw new NullPointerException();
    }
    this.g = true;
    this.h = paramLink;
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
    if (hasCoordinateSystem()) {
      paramWriteStream.getInstance(3, getCoordinateSystem());
    }
    if (hasUserId()) {
      paramWriteStream.getInstance(4, getUserId());
    }
    if (hasIdaUuid()) {
      paramWriteStream.getInstance(5, getIdaUuid());
    }
    if (hasSequenceType()) {
      paramWriteStream.getInstance(6, getSequenceType());
    }
    if (hasGraphicsLink()) {
      paramWriteStream.getInstance(7, getGraphicsLink());
    }
    if (hasDataFormat()) {
      paramWriteStream.dataLength(8, getDataFormat());
    }
    if (hasMcVersion()) {
      paramWriteStream.getInstance(9, getMcVersion());
    }
    if (hasDeviceModel()) {
      paramWriteStream.getInstance(10, getDeviceModel());
    }
    if (hasLabel()) {
      paramWriteStream.getInstance(11, getLabel());
    }
    if (hasSensorNum()) {
      paramWriteStream.dataLength(12, getSensorNum());
    }
    Iterator localIterator = getPointsList().iterator();
    for (;localIterator.hasNext();)
    {
      paramWriteStream.getInstance(13, (be.SequencePoint)localIterator.next());
    }
    if (hasMeasurement()) {
        paramWriteStream.getInstance(14, getMeasurement());
    }
    if (hasStartTime()) {
	    paramWriteStream.getInstance(15, getStartTime());
    }
    if (hasEndTime()) {
    	paramWriteStream.getInstance(16, getEndTime());
    }
    if (hasCalibrationValues()) {
    	paramWriteStream.getInstance(17, getCalibrationValues());
    }

    } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }

    return;
    
  }
}



public static class SequencePoint
  extends CacheBase
{
  public static final int LABEL_FIELD_NUMBER = 3;
  public static final int POSITION_FIELD_NUMBER = 1;
  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  private boolean a;
  private cmn.PixelPosition b = null;
  private boolean c;
  private long d = 0L;
  private boolean e;
  private String f = "";
  private int g = -1;
  
  public static SequencePoint parseFrom(ReadStream paramReadStream)
  {
    return new SequencePoint().mergeFrom(paramReadStream);
  }
  
  public static SequencePoint parseFrom(byte[] paramArrayOfByte)
  {
    return (SequencePoint)new SequencePoint().mergeFrom(paramArrayOfByte);
  }
  
  public final SequencePoint clear()
  {
    clearPosition();
    clearTimestamp();
    clearLabel();
    this.g = -1;
    return this;
  }
  
  public SequencePoint clearLabel()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public SequencePoint clearPosition()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public SequencePoint clearTimestamp()
  {
    this.c = false;
    this.d = 0L;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public String getLabel()
  {
    return this.f;
  }
  
  public cmn.PixelPosition getPosition()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    boolean bool = hasPosition();
    int i = 0;
    if (bool) {
      i = 0 + WriteStream.dataLength(1, getPosition());
    }
    if (hasTimestamp()) {
      i += WriteStream.bindLength(2, getTimestamp());
    }
    if (hasLabel()) {
      i += WriteStream.dataLength(3, getLabel());
    }
    this.g = i;
    return i;
  }
  
  public long getTimestamp()
  {
    return this.d;
  }
  
  public boolean hasLabel()
  {
    return this.e;
  }
  
  public boolean hasPosition()
  {
    return this.a;
  }
  
  public boolean hasTimestamp()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SequencePoint mergeFrom(ReadStream paramReadStream)
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
        cmn.PixelPosition localPixelPosition = new cmn.PixelPosition();
        paramReadStream.getInstance(localPixelPosition);
        setPosition(localPixelPosition);
        break;
      case 16: 
        setTimestamp(paramReadStream.is1());
        break;
      case 26: // '\032'
          setLabel(paramReadStream.getStr());
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
  
  public SequencePoint setLabel(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public SequencePoint setPosition(cmn.PixelPosition paramPixelPosition)
  {
    if (paramPixelPosition == null) {
      throw new NullPointerException();
    }
    this.a = true;
    this.b = paramPixelPosition;
    return this;
  }
  
  public SequencePoint setTimestamp(long paramLong)
  {
    this.c = true;
    this.d = paramLong;
    return this;
  }
  
  public void writeTo(WriteStream paramWriteStream)
  {
    try {
	if (hasPosition()) {
      paramWriteStream.getInstance(1, getPosition());
    }
    if (hasTimestamp()) {
      paramWriteStream.getInstance(2, getTimestamp());
    }
    if (hasLabel()) {
      paramWriteStream.getInstance(3, getLabel());
    }
    } catch(ExceptionManager mng) {
  	  mng.printStackTrace();
    } catch(Exception ex) {
  	  ex.printStackTrace();
    }
    
  }
}


public static class WifiMap
  extends CacheBase
{
  public static final int ACCESS_POINT_DATA_FIELD_NUMBER = 9;
  public static final int ACCESS_POINT_FIELD_NUMBER = 3;
  public static final int DEFAULT_SIGNAL_VALUE_FIELD_NUMBER = 4;
  public static final int GRID_X_FIELD_NUMBER = 7;
  public static final int GRID_Y_FIELD_NUMBER = 8;
  public static final int MAP_COMMONS_FIELD_NUMBER = 5;
  public static final int POSITIONS_FIELD_NUMBER = 1;
  public static final int SIGNAL_STRENGTHS_FIELD_NUMBER = 2;
  public static final int WIFI_RELIABILITY_FIELD_NUMBER = 6;
  private List a = Collections.emptyList();
  private List b = Collections.emptyList();
  private List c = Collections.emptyList();
  private boolean d;
  private double e = 0.0D;
  private boolean f;
  private be.MapCommons g = null;
  private boolean h;
  private double i = 0.0D;
  private List j = Collections.emptyList();
  private List k = Collections.emptyList();
  private List l = Collections.emptyList();
  private int m = -1;
  
  public static WifiMap parseFrom(ReadStream paramReadStream)
  {
    return new WifiMap().mergeFrom(paramReadStream);
  }
  
  public static WifiMap parseFrom(byte[] paramArrayOfByte)
  {
    return (WifiMap)new WifiMap().mergeFrom(paramArrayOfByte);
  }
  
  public WifiMap addAccessPoint(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramString);
    return this;
  }
  
  public WifiMap addAccessPointData(be.AccessPointData paramAccessPointData)
  {
    if (paramAccessPointData == null) {
      throw new NullPointerException();
    }
    if (this.l.isEmpty()) {
      this.l = new ArrayList();
    }
    this.l.add(paramAccessPointData);
    return this;
  }
  
  public WifiMap addGridX(float paramFloat)
  {
    if (this.j.isEmpty()) {
      this.j = new ArrayList();
    }
    this.j.add(Float.valueOf(paramFloat));
    return this;
  }
  
  public WifiMap addGridY(float paramFloat)
  {
    if (this.k.isEmpty()) {
      this.k = new ArrayList();
    }
    this.k.add(Float.valueOf(paramFloat));
    return this;
  }
  
  public WifiMap addPositions(be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramDoubleArray);
    return this;
  }
  
  public WifiMap addSignalStrengths(be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    if (this.b.isEmpty()) {
      this.b = new ArrayList();
    }
    this.b.add(paramDoubleArray);
    return this;
  }
  
  public final WifiMap clear()
  {
    clearPositions();
    clearSignalStrengths();
    clearAccessPoint();
    clearDefaultSignalValue();
    clearMapCommons();
    clearWifiReliability();
    clearGridX();
    clearGridY();
    clearAccessPointData();
    this.m = -1;
    return this;
  }
  
  public WifiMap clearAccessPoint()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public WifiMap clearAccessPointData()
  {
    this.l = Collections.emptyList();
    return this;
  }
  
  public WifiMap clearDefaultSignalValue()
  {
    this.d = false;
    this.e = 0.0D;
    return this;
  }
  
  public WifiMap clearGridX()
  {
    this.j = Collections.emptyList();
    return this;
  }
  
  public WifiMap clearGridY()
  {
    this.k = Collections.emptyList();
    return this;
  }
  
  public WifiMap clearMapCommons()
  {
    this.f = false;
    this.g = null;
    return this;
  }
  
  public WifiMap clearPositions()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public WifiMap clearSignalStrengths()
  {
    this.b = Collections.emptyList();
    return this;
  }
  
  public WifiMap clearWifiReliability()
  {
    this.h = false;
    this.i = 0.0D;
    return this;
  }
  
  public String getAccessPoint(int paramInt)
  {
    return (String)this.c.get(paramInt);
  }
  
  public int getAccessPointCount()
  {
    return this.c.size();
  }
  
  public be.AccessPointData getAccessPointData(int paramInt)
  {
    return (be.AccessPointData)this.l.get(paramInt);
  }
  
  public int getAccessPointDataCount()
  {
    return this.l.size();
  }
  
  public List getAccessPointDataList()
  {
    return this.l;
  }
  
  public List getAccessPointList()
  {
    return this.c;
  }
  
  public int getCachedSize()
  {
    if (this.m < 0) {
      getSerializedSize();
    }
    return this.m;
  }
  
  public double getDefaultSignalValue()
  {
    return this.e;
  }
  
  public float getGridX(int paramInt)
  {
    return ((Float)this.j.get(paramInt)).floatValue();
  }
  
  public int getGridXCount()
  {
    return this.j.size();
  }
  
  public List getGridXList()
  {
    return this.j;
  }
  
  public float getGridY(int paramInt)
  {
    return ((Float)this.k.get(paramInt)).floatValue();
  }
  
  public int getGridYCount()
  {
    return this.k.size();
  }
  
  public List getGridYList()
  {
    return this.k;
  }
  
  public be.MapCommons getMapCommons()
  {
    return this.g;
  }
  
  public be.DoubleArray getPositions(int paramInt)
  {
    return (be.DoubleArray)this.a.get(paramInt);
  }
  
  public int getPositionsCount()
  {
    return this.a.size();
  }
  
  public List getPositionsList()
  {
    return this.a;
  }
  
 
  public int getSerializedSize()
  {
      int i1;
      Iterator iterator;
      int j1;
      i1 = 0;
      iterator = getPositionsList().iterator();
      j1 = 0;

      for(;iterator.hasNext();) {
    	      j1 += WriteStream.dataLength(1, (be.DoubleArray)iterator.next());
      }

      Iterator iterator1 = getSignalStrengthsList().iterator();
      for(;iterator1.hasNext();) {
          j1 += WriteStream.dataLength(2, (be.DoubleArray)iterator1.next());
      }
      Iterator iterator2 = getAccessPointList().iterator();
      for(;iterator2.hasNext();) {
   	      i1 += WriteStream.dataLength((String)iterator2.next());
      }

      Iterator iterator3;
      int i2;
      int k1 = j1 + i1 + 1 * getAccessPointList().size();
      if(hasDefaultSignalValue())
          k1 += WriteStream.dataLength(4, getDefaultSignalValue());
      if(hasMapCommons())
          k1 += WriteStream.dataLength(5, getMapCommons());
      if(hasWifiReliability())
          k1 += WriteStream.dataLength(6, getWifiReliability());
      int l1 = k1 + 4 * getGridXList().size() + 1 * getGridXList().size() + 4 * getGridYList().size() + 1 * getGridYList().size();
      iterator3 = getAccessPointDataList().iterator();
      i2 = l1;

      for(;iterator3.hasNext();) {
          i2 += WriteStream.dataLength(9, (be.AccessPointData)iterator3.next());
      }
      
      m = i2;
      return i2;
  }

  
  
  public be.DoubleArray getSignalStrengths(int paramInt)
  {
    return (be.DoubleArray)this.b.get(paramInt);
  }
  
  public int getSignalStrengthsCount()
  {
    return this.b.size();
  }
  
  public List getSignalStrengthsList()
  {
    return this.b;
  }
  
  public double getWifiReliability()
  {
    return this.i;
  }
  
  public boolean hasDefaultSignalValue()
  {
    return this.d;
  }
  
  public boolean hasMapCommons()
  {
    return this.f;
  }
  
  public boolean hasWifiReliability()
  {
    return this.h;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public WifiMap mergeFrom(ReadStream paramReadStream)
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
        be.DoubleArray localDoubleArray2 = new be.DoubleArray();
        paramReadStream.getInstance(localDoubleArray2);
        addPositions(localDoubleArray2);
        break;
      case 18: 
        be.DoubleArray localDoubleArray1 = new be.DoubleArray();
        paramReadStream.getInstance(localDoubleArray1);
        addSignalStrengths(localDoubleArray1);
        break;
      case 26: 
        addAccessPoint(paramReadStream.getStr());
        break;
      case 33: 
        setDefaultSignalValue(paramReadStream.getStatus());
        break;
      case 42: 
        be.MapCommons localMapCommons = new be.MapCommons();
        paramReadStream.getInstance(localMapCommons);
        setMapCommons(localMapCommons);
        break;
      case 49: 
        setWifiReliability(paramReadStream.getStatus());
        break;
      case 61: 
        addGridX(paramReadStream.checkResult());
        break;
      case 69: 
        addGridY(paramReadStream.checkResult());
        break;
      case 74: // 'J'
          be.AccessPointData localAccessPointData = new be.AccessPointData();
          paramReadStream.getInstance(localAccessPointData);
          addAccessPointData(localAccessPointData);
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
  
  public WifiMap setAccessPoint(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.c.set(paramInt, paramString);
    return this;
  }
  
  public WifiMap setAccessPointData(int paramInt, be.AccessPointData paramAccessPointData)
  {
    if (paramAccessPointData == null) {
      throw new NullPointerException();
    }
    this.l.set(paramInt, paramAccessPointData);
    return this;
  }
  
  public WifiMap setDefaultSignalValue(double paramDouble)
  {
    this.d = true;
    this.e = paramDouble;
    return this;
  }
  
  public WifiMap setGridX(int paramInt, float paramFloat)
  {
    this.j.set(paramInt, Float.valueOf(paramFloat));
    return this;
  }
  
  public WifiMap setGridY(int paramInt, float paramFloat)
  {
    this.k.set(paramInt, Float.valueOf(paramFloat));
    return this;
  }
  
  public WifiMap setMapCommons(be.MapCommons paramMapCommons)
  {
    if (paramMapCommons == null) {
      throw new NullPointerException();
    }
    this.f = true;
    this.g = paramMapCommons;
    return this;
  }
  
  public WifiMap setPositions(int paramInt, be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    this.a.set(paramInt, paramDoubleArray);
    return this;
  }
  
  public WifiMap setSignalStrengths(int paramInt, be.DoubleArray paramDoubleArray)
  {
    if (paramDoubleArray == null) {
      throw new NullPointerException();
    }
    this.b.set(paramInt, paramDoubleArray);
    return this;
  }
  
  public WifiMap setWifiReliability(double paramDouble)
  {
    this.h = true;
    this.i = paramDouble;
    return this;
  }
  


  public void writeTo(WriteStream writestream)
  {
      
	  try {
	  Iterator iterator = getPositionsList().iterator();

      for(;iterator.hasNext();) {
	      writestream.getInstance(1, (be.DoubleArray)iterator.next());
      }

      Iterator iterator1 = getSignalStrengthsList().iterator();
      for(;iterator1.hasNext();) {
	      writestream.getInstance(2, (be.DoubleArray)iterator1.next());
      }

      Iterator iterator2 = getAccessPointList().iterator();

      for(;iterator2.hasNext();) {
    	  writestream.getInstance(3, (String)iterator2.next());
      }

      Iterator iterator3;
      if(hasDefaultSignalValue())
          writestream.getInstance(4, getDefaultSignalValue());
      if(hasMapCommons())
          writestream.getInstance(5, getMapCommons());
      if(hasWifiReliability())
          writestream.getInstance(6, getWifiReliability());
      iterator3 = getGridXList().iterator();

      for(;iterator3.hasNext();) {
    	  writestream.getInstance(7, ((Float)iterator3.next()).floatValue());
      }

      Iterator iterator4 = getGridYList().iterator();
      for(;iterator4.hasNext();) {
    	  writestream.getInstance(8, ((Float)iterator4.next()).floatValue());
      }

      Iterator iterator5 = getAccessPointDataList().iterator();

      for(;iterator5.hasNext();) {
          writestream.getInstance(9, (be.AccessPointData)iterator5.next());
      }
	  } catch(ExceptionManager mng) {
		  mng.printStackTrace();
	  } catch(Exception ex) {
		  ex.printStackTrace();
	  }
      
  }

}









}
