package com.indooratlas.mapcreator.controller;

//RestClient


import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.indooratlas.cursor.list.*;
import com.indooratlas.mapcreator.data.*;
import com.indooratlas.mapcreator.main.*;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.CLASS370;
import com.indooratlas.sensor.CLASS381;
import com.indooratlas.thread.client.IDeviceCheck;
import com.xinghai.indoor.util.ReadStream;
import com.xinghai.indoor.util.WriteStream;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.GZIPOutputStream;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import com.indooratlas.communication.*;
import org.json.JSONException;

//Referenced classes of package com.indooratlas.mapcreator.controller:
//         CLASS167, CLASS113, CLASS179, CLASS133,
//         CLASS134, CLASS136, CookieHTTPHandler, CLASS188,
//         CLASS182, CLASS193, CLASS124, CLASS135,
//         CLASS137, CLASS138, CLASS154, CLASS139,
//         CLASS141, CLASS142, CLASS151, CLASS183,
//         CLASS184, CLASS185, CLASS186, CLASS187,
//         CLASS119, CLASS120, CLASS121, CLASS122,
//         CLASS123, CLASS125, CLASS126, CLASS127,
//         CLASS128, CLASS129, CLASS130, CLASS131,
//         CLASS132, CLASS189, CLASS190, CLASS191,
//         CLASS192, CLASS114, CLASS115, CLASS116,
//         CLASS117, CLASS118, CLASS143

public class RestClient
 implements IDeviceCheck
{

 public RestClient(MapScreen mapscreen, Building class99, CLASS100 class100, String s)
 {
// 	mServiceSSLURL = "https://services.indooratlas.com";
 	mServiceSSLURL = "http://services.indooratlas.com";
     mServiceURL = "http://services.indooratlas.com";
     mRealURL = (new StringBuilder()).append(mServiceSSLURL).append("/buildings").toString();
     mMapScreen = null;
     mSipa = null;
     MF_CLASS181_u705 = null;
     MF_CLASS181_y706 = new Hashtable();
     MF_CLASS181_z707 = new Hashtable();
     A = 0L;
     MF_CLASS108_a447 = 0;
     B = 0;
     C = null;
     D = null;
     E = 0;
     F = null;
     G = null;
     H = 0;
     I = 0;
     J = 0;
     MF_CLASS108_b448 = false;
     MF_CLASS108_c449 = false;
     MF_CLASS32_d136 = 0L;
     MF_CLASS32_e135 = null;
     K = null;
     mBuilding = class99;
     mMapScreen = mapscreen;
     MF_CLASS181_u705 = mapscreen;
     MF_CLASS181_v709 = class100;
     MF_CLASS32_e135 = s;
     String s1 = PreferenceManager.getDefaultSharedPreferences(mMapScreen.getApplicationContext()).getString("backend_address", mMapScreen.getString(0x7f080065));
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("loadPreferences(): backendURL = ").append(s1).toString());
     mServiceSSLURL = s1;
     mServiceURL = mServiceSSLURL.replace("https", "http");
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient(): BASE_ADDRESS_INDOORATLAS_NO_SSL = ").append(mServiceURL).toString());
     mRealURL = (new StringBuilder()).append(mServiceSSLURL).append(mAtlasPath).append("/buildings").toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient(): BUILDINGS = ").append(mRealURL).toString());
     K = NumberFormat.getInstance(Locale.US);
     K.setMinimumFractionDigits(0);
     K.setMaximumFractionDigits(0);
     if(CLASS113.isExceptionLogged.booleanValue())
         CLASS167.MF_CLASS113_a486();
 }

 public RestClient(Sipa sipa, Building class99, String s)
 {
// 	mServiceSSLURL = "https://services.indooratlas.com";
 	mServiceSSLURL = "http://services.indooratlas.com";
     mServiceURL = "http://services.indooratlas.com";
     mRealURL = (new StringBuilder()).append(mServiceSSLURL).append("/buildings").toString();
     mMapScreen = null;
     mSipa = null;
     MF_CLASS181_u705 = null;
     MF_CLASS181_y706 = new Hashtable();
     MF_CLASS181_z707 = new Hashtable();
     A = 0L;
     MF_CLASS108_a447 = 0;
     B = 0;
     C = null;
     D = null;
     E = 0;
     F = null;
     G = null;
     H = 0;
     I = 0;
     J = 0;
     MF_CLASS108_b448 = false;
     MF_CLASS108_c449 = false;
     MF_CLASS32_d136 = 0L;
     MF_CLASS32_e135 = null;
     K = null;
     mSipa = sipa;
     MF_CLASS181_u705 = sipa;
     mBuilding = class99;
     MF_CLASS32_e135 = s;
     String s1 = PreferenceManager.getDefaultSharedPreferences(mSipa.getApplicationContext()).getString("backend_address", mSipa.getString(0x7f080065));
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("loadPreferences(): backendURL = ").append(s1).toString());
     mServiceSSLURL = s1;
     mServiceURL = mServiceSSLURL.replace("https", "http");
     mRealURL = (new StringBuilder()).append(mServiceSSLURL).append(mAtlasPath).append("/buildings").toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient(): BUILDINGS = ").append(mRealURL).toString());
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient(): BASE_ADDRESS_INDOORATLAS_NO_SSL = ").append(mServiceURL).toString());
     if(CLASS113.isExceptionLogged.booleanValue())
         CLASS167.MF_CLASS113_a486();
 }

 static int MF_CLASS54_a201()
 {
     return MF_CLASS181_w702;
 }

 static int MF_CLASS54_a201(RestClient class181, int i)
 {
     class181.H = i;
     return i;
 }

 static MapScreen getMapScreen(RestClient class181)
 {
     return class181.mMapScreen;
 }

 public static File calibrationSetToProtoBufferFileIncremental(CLASS370 class370, Activity activity, String s, String s1, String s2)
 {
     be.CalibrationSet calibrationset;
     String s3;
     BufferedOutputStream bufferedoutputstream;
     WriteStream writestream;
     try {
     CLASS167.MF_CLASS167_b635("RestClient", "RestClient.calibrationSetToProtoBufferFileIncremental() called.");
     calibrationset = new be.CalibrationSet();
     calibrationset.setIdaUid(CLASS75.createIDAUID(s, s2));
     cmn.Link link = new cmn.Link();
     link.setId(s1);
     calibrationset.setDeviceModel(link);
     cmn.GeoPosition geoposition = new cmn.GeoPosition();
     geoposition.setLatitude(class370.Latitude);
     geoposition.setLongitude(class370.Longitude);
     calibrationset.setPosition(geoposition);
     cmn.Measurement measurement = new cmn.Measurement();
     measurement.setTimeStart(class370.StartTimestampMS);
     measurement.setTimeEnd(class370.EndTimestampMS);
     List list = addAccSamples(class370.mMeasurementID, 1);
     for(int i = 0; i < list.size(); i++)
         measurement.addAccSamples((com.indooratlas.communication.cmn.AccSample)list.get(i));

     List list1 = addGyroSamples(class370.mMeasurementID, 1);
     for(int j = 0; j < list1.size(); j++)
         measurement.addGyroSamples((cmn.GyroSample)list1.get(j));

     List list2 = addMgnSamples(class370.mMeasurementID, 1);
     for(int k = 0; k < list2.size(); k++)
         measurement.addMgnSamples((com.indooratlas.communication.cmn.MgnSample)list2.get(k));

     calibrationset.setMeasurement(measurement);
     calibrationset.setEndTime(class370.EndTimestampMS);
     s3 = MF_CLASS108_b448(class370);
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.calibrationSetToProtoBufferFileIncremental(): fname = ").append(s3).toString());
     bufferedoutputstream = new BufferedOutputStream(new GZIPOutputStream(activity.openFileOutput(s3, 0)));
     writestream = WriteStream.getInstance(bufferedoutputstream);
     long l = System.currentTimeMillis();
     CLASS167.MF_CLASS167_b635("RestClient", "calibrationSetToProtoBufferFileIncremental() calling serializer.write(s, mFile)");
     calibrationset.writeTo(writestream);
     CLASS167.MF_CLASS167_b635("RestClient", "calibrationSetToProtoBufferFileIncremental() wrote protobuffer to file.");

     double d = (double)(System.currentTimeMillis() - l) / 1000D;
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("calibrationSetToProtoBufferFileIncremental() serialization to file took: dur = ").append(d).append(" seconds").toString());
     writestream.getInstance();
     bufferedoutputstream.close();
     return new File(s3);
     } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        	exception1.printStackTrace();
	        return null;
     }

 }

 static String MF_CLASS54_a201(CLASS370 class370)
 {
     return MF_CLASS108_b448(class370);
 }

 static List MF_CLASS54_a201(RestClient class181, List list)
 {
     class181.C = list;
     return list;
 }

 public static List onRequestComplete(String s, String s1, boolean flag, boolean flag1) throws JSONException
 {
     JSONArray jsonarray = (new JSONObject(s)).getJSONArray("Points");
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestComplete: routeJson = ").append(jsonarray).toString());
     ArrayList arraylist = new ArrayList();
     ArrayList arraylist1 = new ArrayList();
     float af[] = null;
     CLASS167.MF_CLASS167_b635("RestClient", "Original Points");
     int i = 0;
     while(i < jsonarray.length())
     {
         JSONObject jsonobject = jsonarray.getJSONObject(i);
         double d = jsonobject.getDouble("X");
         double d1 = jsonobject.getDouble("Y");
         jsonobject.getDouble("Z");
         float af1[] = new float[2];
         af1[0] = (float)d;
         af1[1] = (float)d1;
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append(af1[0]).append(",").append(af1[1]).toString());
         float af2[];
         if(i == 0 || i == -1 + jsonarray.length())
         {
             arraylist.add(af1);
             af2 = af1;
         } else
         if(flag1 && jsonarray.length() > 10)
         {
             if(flag)
             {
                 if(i == 1)
                 {
                     af2 = af1;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestComplete: \nlastXY[0] : ").append(af[0]).append("\nlastXY[1] : ").append(af[1]).append("\nxy[0] : ").append(af1[0]).append("\nxy[1] : ").append(af1[1]).append("\nlast added X : ").append(((float[])arraylist.get(-1 + arraylist.size()))[0]).append("\nlast added Y : ").append(((float[])arraylist.get(-1 + arraylist.size()))[1]).append("\ni = ").append(i).append(", mId = ").append(s1).toString());
                     double d2 = MathUtils.MF_CLASS320_b911(af[0], af[1], ((float[])arraylist.get(-1 + arraylist.size()))[0], ((float[])arraylist.get(-1 + arraylist.size()))[1], af1[0], af1[1]);
                     arraylist1.add(Double.valueOf(d2));
                     if(!Double.isNaN(d2) && d2 > 0.01D)
                     {
                         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestComplete: dist ").append(d2).append(", i = ").append(i).append(", mId = ").append(s1).toString());
                         arraylist.add(af1);
                         af2 = af1;
                     } else
                     {
                         af2 = af1;
                     }
                 }
             } else
             {
                 if(i % 5 == 0)
                     arraylist.add(af1);
                 af2 = af1;
             }
         } else
         if(flag1)
         {
             arraylist.add(af1);
             af2 = af1;
         } else
         {
             af2 = af;
         }
         i++;
         af = af2;
     }
     return arraylist;
 }

 static void MF_CLASS54_a201(RestClient class181, String s)
 {
     class181.MF_CLASS108_k457(s);
 }

 public static double handleRestSend(List list)
 {
     double ad[] = countSegmentLengthSeconds(list);
     double d = ad[0];
     double d1 = ad[1];
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.handleRestSend(): countSegmentLengthSeconds returned  mapDur = ").append(d).append(", testDur = ").append(d1).toString());
     double d2 = 1.0D;
     if(d != 0.0D)
         d2 = d1 / d;
     return d2;
 }

 static int MF_CLASS108_b448(RestClient class181, int i)
 {
     class181.B = i;
     return i;
 }

 private static String MF_CLASS108_b448(CLASS370 class370)
 {
     return (new StringBuilder()).append("calibration_protobuf_ID_").append(class370.mMeasurementID).append(".gzip").toString();
 }

 static List MF_CLASS108_b448(RestClient class181, List list)
 {
     class181.D = list;
     return list;
 }

 private void MF_CLASS108_b448()
 {
     mMapScreen.onResetButtonClick();
     boolean flag = PreferenceManager.getDefaultSharedPreferences(mMapScreen.getApplicationContext()).getBoolean("sensor_values_on_screen_key", false);
     mMapScreen.setShowSensorValuesOnScreen(flag);
 }

 static void MF_CLASS108_b448(RestClient class181)
 {
     class181.MF_CLASS108_b448();
 }

 static int MF_CLASS108_c449(RestClient class181, int i)
 {
     class181.E = i;
     return i;
 }

 static Sipa getSipa(RestClient class181)
 {
     return class181.mSipa;
 }

 static List MF_CLASS108_c449(RestClient class181, List list)
 {
     class181.F = list;
     return list;
 }

 private static double[] countSegmentLengthSeconds(List list)
 {
     double ad[] = new double[2];
     if(list == null)
         return null;
     Iterator iterator = list.iterator();
     double d = 0.0D;
     double d1 = 0.0D;
     while(iterator.hasNext())
     {
         Measurement class108 = (Measurement)iterator.next();
         long l = class108.EndTimestamp - class108.mStartTimestamp;
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("countSegmentLengthSeconds: dur = ").append(l).append(", m = ").append(class108.mMeasurementID).toString());
         double d4;
         double d5;
         double d6;
         if(class108.TestSegment == 1)
         {
             d4 = d1 + (double)l;
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("countSegmentLengthSeconds: testLenSecs = ").append(d4).toString());
             d5 = d;
         } else
         {
             double d3 = d + (double)l;
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("countSegmentLengthSeconds: mapLenSecs = ").append(d3).toString());
             d4 = d1;
             d5 = d3;
         }
         d6 = d4;
         d = d5;
         d1 = d6;
     }
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("countSegmentLengthSeconds: mapLenSecs = ").append(d).toString());
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("countSegmentLengthSeconds: testLenSecs = ").append(d1).toString());
     double d2 = d1 / 1000D;
     ad[0] = d / 1000D;
     ad[1] = d2;
     return ad;
 }

 static int MF_CLASS32_d136(RestClient class181, int i)
 {
     class181.I = i;
     return i;
 }

 static List MF_CLASS32_d136(RestClient class181)
 {
     return class181.C;
 }

 static List MF_CLASS32_d136(RestClient class181, List list)
 {
     class181.G = list;
     return list;
 }

 static NumberFormat MF_CLASS32_e135(RestClient class181)
 {
     return class181.K;
 }

 private static List addAccSamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "AccData", i);
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementAccDataByStartID(l, l1, 100L, i);
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addAccSamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addAccSamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS23 class23 = (CLASS23)iterator.next();
                 cmn.AccSample accsample = new cmn.AccSample();
                 accsample.setAccTimestamp(class23.timeStamp);
                 accsample.setAccX(class23.AccelerometerX);
                 accsample.setAccY(class23.AccelerometerY);
                 accsample.setAccZ(class23.AccelerometerZ);
                 long l4;
                 if(class23.timeStamp > l3)
                 {
                     arraylist.add(accsample);
                     l4 = class23.timeStamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addAccSamples : skipped duplicate acc ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 private static List addGyroSamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "GyroData", i);
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementGyroDataByStartID(l, l1, 100L, i);
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addGyroSamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addGyroSamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS26 class26 = (CLASS26)iterator.next();
                 cmn.GyroSample gyrosample = new cmn.GyroSample();
                 gyrosample.setGyroTimestamp(class26.timeStamp);
                 gyrosample.setGyroX(class26.AccelerometerX);
                 gyrosample.setGyroY(class26.AccelerometerY);
                 gyrosample.setGyroZ(class26.AccelerometerZ);
                 long l4;
                 if(class26.timeStamp > l3)
                 {
                     arraylist.add(gyrosample);
                     l4 = class26.timeStamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addGyroSamples : skipped duplicate gyro ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 static List MF_CLASS381_f1112(RestClient class181)
 {
     return class181.F;
 }

 private static List addMgnSamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "MgnData", i);
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementMgnDataByStartID(l, l1, 100L, i);
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addMgnSamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addMgnSamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS29 class29 = (CLASS29)iterator.next();
                 cmn.MgnSample mgnsample = new cmn.MgnSample();
                 mgnsample.setMgnTimestamp(class29.timeStamp);
                 mgnsample.setMgnX(class29.AccelerometerX);
                 mgnsample.setMgnY(class29.AccelerometerY);
                 mgnsample.setMgnZ(class29.AccelerometerZ);
                 mgnsample.setMgnAccuracy((int)class29.Accuracy);
                 long l4;
                 if(class29.timeStamp > l3)
                 {
                     arraylist.add(mgnsample);
                     l4 = class29.timeStamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addMgnSamples : skipped duplicate mgn ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 private void retryRouteLoading(String s)
 {
     J = 1 + J;
     if(J < 100)
     {
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("retryRouteLoading : retrying for id = ").append(s).append(", mRouteQueryRetryCnt = ").append(J).toString());
         getBackendSegmentRoute(s);
     } else
     if(J == 100)
     {
         mMapScreen.runOnUiThread(new CLASS133(this));
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("retryRouteLoading : NOT retrying for id = ").append(s).append(", mRouteQueryRetryCnt = ").append(J).toString());
         return;
     }
 }

 private static File openFileForWriting(String s)
 {
     File file = new File(Environment.getExternalStorageDirectory(), "/dbgfiles/");
     boolean flag = file.mkdirs();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("openFileForWriting, created = ").append(flag).toString());
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append(" RestClient.openFileForWriting: file path :").append(file.toString()).toString());
     if(file.canWrite())
     {
         return new File(file, s);
     } else
     {
         CLASS167.MF_CLASS167_b635("RestClient", " RestClient.openFileForWriting: canWrite = false, Could not open file for writing ");
         return null;
     }
 }

 private void MF_CLASS108_k457(String s)
 {
     if(mMapScreen != null)
     {
         mMapScreen.runOnUiThread(new CLASS134(this, s));
         return;
     } else
     {
         mSipa.runOnUiThread(new CLASS136(this, s));
         return;
     }
 }

 public File measurementToProtoBufferFileIncrementalWithWifi(Measurement pMeasurement)
 {
     long l2;
     Iterator iterator1;
     String s;
     BufferedOutputStream bufferedoutputstream;
     WriteStream writestream;
     long l3;

     double d;
     CLASS381 class381;
     long l4;
     cmn.WifiScan wifiscan1;
     cmn.WifiScanEntry wifiscanentry;
     int i2;
     cmn.WifiScan wifiscan;

     try {
	     CLASS167.MF_CLASS167_b635("RestClient", "RestClient.measurementToProtoBufferFileIncrementalWithWifi() called.");
	     be.Sequence sequence = new be.Sequence();
	     sequence.setCoordinateSystem("image");
	     sequence.setIdaUuid(CLASS75.createIDAUID(mMapScreen.mApiKey, MF_CLASS181_v709.MF_CLASS100_b387));
	     com.indooratlas.communication.cmn.Link link;
	     com.indooratlas.communication.cmn.Link link1;
	     if(pMeasurement.TestSegment == 1)
	     {
	         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.measurementToProtoBufferFileIncrementalWithWifi(): measurement.mTestSegment == 1");
	         sequence.setSequenceType(1);
	     } else
	     {
	         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.measurementToProtoBufferFileIncrementalWithWifi(): measurement.mTestSegment != 1");
	         sequence.setSequenceType(0);
	     }
	     link = new cmn.Link();
	     link.setId(pMeasurement.gID);
	     sequence.setGraphicsLink(link);
	     sequence.setDataFormat(3);
	     sequence.setMcVersion(mMapScreen.getPackageManager().getPackageInfo(mMapScreen.getPackageName(), 0).versionName);
	     link1 = new cmn.Link();
	     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.measurementToProtoBufferFileIncrementalWithWifi(): mMapScreen.mDeviceModel.getId() : ").append(mMapScreen.mDeviceModel.MF_CLASS101_a388()).toString());
	     link1.setId(mMapScreen.mDeviceModel.MF_CLASS101_a388());
	     sequence.setDeviceModel(link1);
	     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.measurementToProtoBufferFileIncrementalWithWifi(): Sequence label : ").append(pMeasurement.mLabel).toString());
	     sequence.setLabel(pMeasurement.mLabel);
	     sequence.setSensorNum(0);
	     if(pMeasurement.mBezier == 1)
	     {
	         double d8 = pMeasurement.getFirstCheckPoint().CheckPointTimestamp;
	         double d9 = (double)pMeasurement.getLastCheckPoint().CheckPointTimestamp - d8;
	         double d10 = d9 / 1000000000D;
	         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.measurementToProtoBufferFileIncrementalWithWifi(): bezier segmentDurSecs : ").append(d10).toString());
	         int i5 = (int)(d10 * 5D);
	         CheckPoint aclass112_3[] = getBezierPoints(pMeasurement, i5, d8, d9 / (double)i5);
	         int j5 = 0;
	         int k5 = aclass112_3.length;
	         for(int i6 = 0; i6 < k5; i6++)
	         {
	             CheckPoint class112_4 = aclass112_3[i6];
	             be.SequencePoint sequencepoint2 = new be.SequencePoint();
	             cmn.PixelPosition pixelposition2 = new cmn.PixelPosition();
	             pixelposition2.setI(class112_4.coordX);
	             pixelposition2.setJ(class112_4.coordY);
	             sequencepoint2.setPosition(pixelposition2);
	             if(j5 == 0 || j5 == -1 + aclass112_3.length)
	                 sequencepoint2.setTimestamp(class112_4.CheckPointTimestamp);
	             sequencepoint2.setLabel("normal_bezier");
	             sequence.addPoints(sequencepoint2);
	             j5++;
	         }
	
	     } else
	     if(pMeasurement.TestSegment == 1)
	     {
	         CheckPoint aclass112_1[] = (CheckPoint[])pMeasurement.mPoints.toArray(new CheckPoint[pMeasurement.mPoints.size()]);
	         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: measurements point count = ").append(aclass112_1.length).toString());
	         for(int j3 = 1; j3 < aclass112_1.length; j3++)
	         {
	             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: handling measurement point = ").append(j3).append(", points[i].timestamp = ").append(aclass112_1[j3].CheckPointTimestamp).append(", points[i-1].timestamp = ").append(aclass112_1[j3 - 1].CheckPointTimestamp).toString());
	             double d5 = (double)(aclass112_1[j3].CheckPointTimestamp - aclass112_1[j3 - 1].CheckPointTimestamp) / 1000000000D;
	             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: TEST segment subDurSecs = ").append(d5).toString());
	             int k3 = (int)(d5 * 5D);
	             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: subPointNum = ").append(k3).toString());
	             CheckPoint aclass112_2[] = getPointsAlongLine(aclass112_1[j3 - 1], aclass112_1[j3], k3);
	             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: getPointsAlongLine returned points len = ").append(aclass112_2.length).toString());
	             double d6 = aclass112_1[j3 - 1].CheckPointTimestamp;
	             double d7 = ((double)aclass112_1[j3].CheckPointTimestamp - d6) / (double)k3;
	             int i4 = 0;
	             int j4 = aclass112_2.length;
	             for(int k4 = 0; k4 < j4; k4++)
	             {
	                 CheckPoint class112_3 = aclass112_2[k4];
	                 be.SequencePoint sequencepoint1 = new be.SequencePoint();
	                 cmn.PixelPosition pixelposition1 = new cmn.PixelPosition();
	                 pixelposition1.setI(class112_3.coordX);
	                 pixelposition1.setJ(class112_3.coordY);
	                 sequencepoint1.setPosition(pixelposition1);
	                 long l7 = (long)(d6 + d7 * (double)i4);
	                 CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: TEST segment ts = ").append(l7).toString());
	                 sequencepoint1.setTimestamp(l7);
	                 CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.measurementToXMLSequenceIncremental(), routepoint label : ").append(class112_3.MF_CLASS112_e484).toString());
	                 sequencepoint1.setLabel(class112_3.MF_CLASS112_e484);
	                 sequence.addPoints(sequencepoint1);
	                 i4++;
	             }
	
	         }
	
	     } else
	     if(pMeasurement.TestSegment == 0)
	     {
	         CheckPoint class112 = pMeasurement.getFirstCheckPoint();
	         CheckPoint class112_1 = pMeasurement.getLastCheckPoint();
	         double d1 = class112.CheckPointTimestamp;
	         double d2 = (double)class112_1.CheckPointTimestamp - d1;
	         double d3 = d2 / 1000000000D;
	         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.measurementToProtoBufferFileIncrementalWithWifi(): normal map segmentDurSecs : ").append(d3).toString());
	         int j2 = (int)(d3 * 5D);
	         double d4 = d2 / (double)j2;
	         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: segmentDurNano = ").append(d2).append(", timeIncrement = ").append(d4).toString());
	         CheckPoint aclass112[] = getPointsAlongLine(class112, class112_1, j2);
	         long l5 = 0L;
	         int k2 = aclass112.length;
	         for(int i3 = 0; i3 < k2; i3++)
	         {
	             CheckPoint class112_2 = aclass112[i3];
	             be.SequencePoint sequencepoint = new be.SequencePoint();
	             cmn.PixelPosition pixelposition = new cmn.PixelPosition();
	             pixelposition.setI(class112_2.coordX);
	             pixelposition.setJ(class112_2.coordY);
	             sequencepoint.setPosition(pixelposition);
	             long l6 = (long)(d1 + d4 * (double)l5);
	             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi: ts1 = ").append(l6).append(", pointCnt = ").append(l5).append(", timeStart = ").append(d1).append(", timeIncrement = ").append(d4).toString());
	             sequencepoint.setTimestamp(l6);
	             sequence.addPoints(sequencepoint);
	             l5++;
	         }
	
	     }
	     cmn.Measurement measurement = new cmn.Measurement();
	     measurement.setTimeStart(pMeasurement.mStartTimestamp);
	     measurement.setTimeEnd(pMeasurement.EndTimestamp);
	     List list = addAccSamples(pMeasurement.mMeasurementID, 0);
	     for(int i = 0; i < list.size(); i++)
	         measurement.addAccSamples((com.indooratlas.communication.cmn.AccSample)list.get(i));
	
	     List list1 = addGyroSamples(pMeasurement.mMeasurementID, 0);
	     for(int j = 0; j < list1.size(); j++)
	         measurement.addGyroSamples((com.indooratlas.communication.cmn.GyroSample)list1.get(j));
	
	     List list2 = addMgnSamples(pMeasurement.mMeasurementID, 0);
	     for(int k = 0; k < list2.size(); k++)
	         measurement.addMgnSamples((com.indooratlas.communication.cmn.MgnSample)list2.get(k));
	
	     List list3 = addPressureSamples(pMeasurement.mMeasurementID, 0);
	     for(int l = 0; l < list3.size(); l++)
	         measurement.addPressureSamples((com.indooratlas.communication.cmn.PressureSample)list3.get(l));
	
	     List list4 = addProximitySamples(pMeasurement.mMeasurementID, 0);
	     for(int i1 = 0; i1 < list4.size(); i1++)
	         measurement.addProximitySamples((com.indooratlas.communication.cmn.ProximitySample)list4.get(i1));
	
	     List list5 = addLightSamples(pMeasurement.mMeasurementID, 0);
	     for(int j1 = 0; j1 < list5.size(); j1++)
	         measurement.addLightSamples((com.indooratlas.communication.cmn.LightSample)list5.get(j1));
	
	     List list6 = addTemperatureSamples(pMeasurement.mMeasurementID, 0);
	     for(int k1 = 0; k1 < list6.size(); k1++)
	         measurement.addTemperatureSamples((com.indooratlas.communication.cmn.TemperatureSample)list6.get(k1));
	
	     List list7 = MeasurementDataSource.getMeasurementWifiScans(pMeasurement);
	     int l1;
	     if(list7.size() > 0)
	     {
	         cmn.WifiMeasurement wifimeasurement = new cmn.WifiMeasurement();
	         Hashtable hashtable = new Hashtable();
	         Iterator iterator = list7.iterator();
	         l1 = 0;
	
	         while(iterator.hasNext())
	         {
	             CLASS381 class381_1 = (CLASS381)iterator.next();
	             if(!hashtable.containsKey(class381_1.BSSID))
	             {
	                 cmn.WifiAP wifiap = new cmn.WifiAP();
	                 wifiap.setSsid(class381_1.mSsid);
	                 wifiap.setBssid(Long.parseLong(class381_1.BSSID, 16));
	                 wifimeasurement.addAp(wifiap);
	                 hashtable.put(class381_1.BSSID, Integer.valueOf(l1));
	                 i2 = l1 + 1;
	             } else
	             {
	                 i2 = l1;
	             }
	             l1 = i2;
	         }
	         l2 = ((CLASS381)list7.get(0)).ScanNo;
	         wifiscan = new cmn.WifiScan();
	         wifiscan.setTimestamp(((CLASS381)list7.get(0)).mScanTimeStamp);
	         iterator1 = list7.iterator();
	         while(iterator1.hasNext())
	         {
	             class381 = (CLASS381)iterator1.next();
	             if(l2 != class381.ScanNo)
	             {
	                 CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RESTClient.measurementToProtoBufferFileIncrementalWithWifi(): new scan starts scanNumbers, old : ").append(l2).append(", new : ").append(class381.ScanNo).toString());
	                 l4 = class381.ScanNo;
	                 wifimeasurement.addWifiScan(wifiscan);
	                 wifiscan1 = new cmn.WifiScan();
	                 wifiscan1.setTimestamp(class381.mScanTimeStamp);
	             } else
	             {
	                 l4 = l2;
	                 wifiscan1 = wifiscan;
	             }
	             wifiscanentry = new cmn.WifiScanEntry();
	             wifiscanentry.setSignalStrength(class381.SignalStrength);
	             wifiscanentry.setAccessPointNum(((Integer)hashtable.get(class381.BSSID)).intValue());
	             wifiscan1.addScan(wifiscanentry);
	             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RESTClient.measurementToProtoBufferFileIncrementalWithWifi(): added AP to wifi scan: ").append(class381.ScanNo).append(", bssid = ").append(class381.BSSID).append(", strength = ").append(class381.SignalStrength).toString());
	             wifiscan = wifiscan1;
	             l2 = l4;
	         }
	         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RESTClient.measurementToProtoBufferFileIncrementalWithWifi(): added LAST wifi scan: ").append(l2).toString());
	         wifimeasurement.addWifiScan(wifiscan);
	         measurement.setWifiMeasurement(wifimeasurement);
	     } else
	     {
	         l1 = 0;
	     }
	     sequence.setMeasurement(measurement);
	     s = formatMeasurementFileString(pMeasurement);
	     bufferedoutputstream = new BufferedOutputStream(new GZIPOutputStream(mMapScreen.openFileOutput(s, 0)));
	     writestream = WriteStream.getInstance(bufferedoutputstream);
	     l3 = System.currentTimeMillis();
	     CLASS167.MF_CLASS167_b635("RestClient", "measurementToProtoBufferFileIncrementalWithWifi() calling serializer.write(s, mFile)");
	     sequence.writeTo(writestream);
	     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi() wrote protobuffer to file: ").append(s).toString());
	
	     d = (double)(System.currentTimeMillis() - l3) / 1000D;
	     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("measurementToProtoBufferFileIncrementalWithWifi() serialization of ").append(l1).append(" samples to file took: dur = ").append(d).append(" seconds").toString());
	     writestream.getInstance();
	     bufferedoutputstream.close();
	     return new File(s);
	 } catch(Exception exception1) {
	     exception1.printStackTrace();
	     if(CLASS113.isExceptionLogged.booleanValue())
	     	exception1.printStackTrace();
	     return null;
	 }
 }

 public List addPressureSamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "PressureData", i);
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addPressureSamples(): firstQueriedSampleID = ").append(l1).toString());
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementPressureDataByStartID(l, l1, 100L, i);
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addPressureSamples(): data.size = ").append(class109.mData.size()).toString());
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addPressureSamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addPressureSamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS30 class30 = (CLASS30)iterator.next();
                 cmn.PressureSample pressuresample = new cmn.PressureSample();
                 pressuresample.setPressureTimestamp(class30.PressureTimestamp);
                 pressuresample.setPressure(class30.Pressure);
                 long l4;
                 if(class30.PressureTimestamp > l3)
                 {
                     arraylist.add(pressuresample);
                     l4 = class30.PressureTimestamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addPressureSamples : skipped duplicate pres ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 public void getBuildings(double d, double d1, int i)
 {
 	try {
 	CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.getBuildings() called, latitude = ").append(d).append(", longitude = ").append(d1).append(", radius (m) = ").append(i).toString());
     if(MF_CLASS108_c449) {
         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.getBuildings(), mGetBuildingsRequestPending already TRUE, *not* initiating request!");
         return;
     }
     CLASS167.MF_CLASS167_b635("RestClient", "RestClient.getBuildings(), mGetBuildingsRequestPending FALSE, *initiating request*!");
     MF_CLASS108_c449 = true;
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, mRealURL, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
     return;
 	} catch(Exception exception) {
 		exception.printStackTrace();
 	}
 }

 public void onRequestComplete(int i, String s, int j, String s1, List list, String s2, Long long1,
         InputStream inputstream, String s3)
 {
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, url = ").append(s).append(", statusCode = ").append(j).append(", result = ").append(s1).append(", xml = ").append(s2).toString());
     if(list != null) {
	        NameValuePair namevaluepair;
	        for(Iterator iterator = list.iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete(): parameter: ").append(namevaluepair.getName()).append("=").append(namevaluepair.getValue()).toString()))
	            namevaluepair = (NameValuePair)iterator.next();

     }

     try {

     ReadStream readstream;
     be.JobStatus jobstatus;
     int k1;
     readstream = ReadStream.getInstance(inputstream);
     if(s.contains(mJobStatusFolder)) {
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, CHECK_MAP_GENERATION_STATUS_CLOUD, result = ").append(s1).toString());
	        CLASS75.MF_CLASS75_a259(4, "CHECK_MAP_GENERATION_STATUS_OK", RestClient.class, "onRequestComplete.");
	     jobstatus = be.JobStatus.parseFrom(readstream);
	     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, CHECK_MAP_GENERATION_STATUS_CLOUD, stat_resp = ").append(jobstatus).toString());
	     k1 = jobstatus.getState();
	     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, CHECK_MAP_GENERATION_STATUS_CLOUD, JobState = ").append(k1).toString());
	     boolean flag4;
	     flag4 = true;
	     if(k1 == 2) {
		        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() called, CHECK_MAP_GENERATION_STATUS_CLOUD, setting generating = false");
		        CLASS75.MF_CLASS75_a259(4, "CHECK_MAP_GENERATION_STATUS_OK", RestClient.class, "onRequestComplete, completed = true");
		        flag4 = false;
		        String s10 = jobstatus.getId();
		        mMapScreen.runOnUiThread(new CLASS182(this, flag4, s10));
		        return;
	     }
     } else if(s.contains(mJobsGeneratemapFolder))
     {
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, MAP_GENERATION_URL, result = ").append(s1).toString());
         CLASS75.MF_CLASS75_a259(4, "MAP_GENERATION_START_OK", RestClient.class, "onRequestComplete.");
         String s9 = be.JobStatus.parseFrom(readstream).getId();
         mMapScreen.runOnUiThread(new CLASS193(this, s9));
         return;
     }
     if(i == 2) {
	        if(s.contains(mGraphicsFolder))
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, DELETE ALL MEASUREMENTS, result = ").append(s1).toString());
	            CLASS75.MF_CLASS75_a259(4, "ALL_PATHS_DELETE_OK", RestClient.class, "onRequestComplete.");
	            mMapScreen.runOnUiThread(new CLASS124(this));
	            mMapScreen.showOkButtonDialog(mMapScreen.getString(0x7f080023));
	            return;
	        }
	        if(s.contains(mSequencesFolder))
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, DELETE MEASUREMENT, result = ").append(s1).toString());
	            CLASS75.MF_CLASS75_a259(4, "PATH_DELETE_OK", RestClient.class, "onRequestComplete.");
	            mMapScreen.runOnUiThread(new CLASS135(this));
	            return;
	        }
     }

     String s7;
     Measurement class108_4;
     String s8;
     int i1;
     if(s.contains(mRouteFolder)) {
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, GET ROUTE, result = ").append(s1).toString());
	        CLASS75.MF_CLASS75_a259(4, "ROUTE_LOADING_OK", RestClient.class, "onRequestComplete.");
	        s7 = mServiceURL(s);
	        class108_4 = mMapScreen.getSequenceFromLocalMeasurementsForBeSynch(s7);
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() GET ROUTE, measurement is bezier ? = ").append(class108_4.mBezier).toString());
	        s8 = class108_4.segmentID;
	        i1 = class108_4.mBezier;
	        boolean flag2;
	        flag2 = false;
	        if(i1 == 1)
	            flag2 = true;
	        int j1 = class108_4.TestSegment;
	        boolean flag3;
	        flag3 = false;
	        if(j1 == 1)
	        {
	            flag2 = true;
	            flag3 = true;
	        }
	        ArrayList arraylist1;
	        List list1 = onRequestComplete(s1, s8, flag3, flag2);
	        arraylist1 = new ArrayList(list1.size());
	        float af[];
	        for(Iterator iterator3 = list1.iterator(); iterator3.hasNext(); arraylist1.add(new CheckPoint(af[0], af[1])))
	            af = (float[])iterator3.next();

	        mMapScreen.setRouteForSequence(s7, arraylist1);
	        return;
     }

     if(i == 0) {
	        be.IndoorAtlas indooratlas3;
	        if(s.contains(mSequencesFolder)) {

		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, GET MEASUREMENTS, result = ").append(s1).toString());
		        CLASS75.MF_CLASS75_a259(4, "MEASUREMENT_LOADING_OK", RestClient.class, "onRequestComplete.");
		        indooratlas3 = be.IndoorAtlas.parseFrom(readstream);
		        if(indooratlas3 != null) {
			        ArrayList arraylist;
			        if(CLASS113.isExceptionLogged.booleanValue())
			            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() measurements = ").append(indooratlas3).toString());
			        arraylist = new ArrayList();
			        Measurement class108_3;
			        for(Iterator iterator2 = indooratlas3.getSequenceList().iterator(); iterator2.hasNext(); arraylist.add(class108_3))
			        {
			            be.Sequence sequence1 = (be.Sequence)iterator2.next();
			            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete(): got backend sequence: ").append(sequence1.toString()).toString());
			            class108_3 = Measurement.MF_CLASS108_a447(sequence1);
			            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete(): mapped to local sequence: ").append(class108_3.toString()).toString());
			        }

			        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, calling  mMapScreen.setBackendSequences with backendMeasurements.size() = ").append(arraylist.size()).toString());
			        mMapScreen.runOnUiThread(new CLASS137(this, arraylist));
			        return;
		        }

		        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : protobuf measurement == NULL");
		        if(CLASS113.isExceptionLogged.booleanValue())
		            mMapScreen.showToastMessage("No measurements found from the backend.", 0);
		        mMapScreen.setBackendSequences(null);
		        return;
	        }
     }


     boolean flag1;
     if(s.contains(mSequencesFolder)) {
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, post MEASUREMENTS, result = ").append(s1).toString());
	        B = 1 + B;
	        H = 0;
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, MEASUREMENTS, mCurrentNumberOfMeasurementsAlreadySent = ").append(B).toString());
	        double d = (double)B / (double)MF_CLASS108_a447;
	        String s5 = K.format(d * 100D);
	        mMapScreen.runOnUiThread(new CLASS138(this, s5));
	        CLASS75.MF_CLASS75_a259(4, "PATH_UPLOAD_OK", RestClient.class, (new StringBuilder()).append("onRequestComplete: ").append(B).append("/").append(MF_CLASS108_a447).toString());
	        be.Sequence sequence = be.Sequence.parseFrom(readstream);
	        Measurement class108 = (Measurement)MF_CLASS181_y706.remove(long1);
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : storing backend-side generated ID to DB measurement: id = ").append(sequence.getId()).append(", size = ").append(sequence.toByteArray().length).toString());
	        class108.segmentID = sequence.getId();
	        MeasurementDataSource.markMeasurementSent(class108);
	        D.add(class108);
	        String s6 = formatMeasurementFileString(class108);
	        flag1 = MF_CLASS181_u705.deleteFile(s6);
	        if(CLASS113.isExceptionLogged.booleanValue()) {
		        String as1[];
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : deleted  file ? = ").append(flag1).toString());
		        as1 = MF_CLASS181_u705.fileList();
		        int l = 0;

		        for(;l < as1.length;l++) {
		        	CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : file left (not yet uploaded/deleted)  = ").append(as1[l]).toString());
		        }
	        }

	        if(C.size() > 0)
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : mToBeSendMeasurements.size() > 0, removing sent measurement");
	            C.remove(-1 + C.size());
	        }
	        if(C.size() > 0)
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : mToBeSendMeasurements.size() > 0  AFTER removing sent measurement");
	            Measurement class108_2 = (Measurement)C.get(-1 + C.size());
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : next measurement to be sent : ").append(class108_2.mMeasurementID).toString());
	            (new CLASS154(this, null)).execute(new Object[] {
	                class108_2
	            });
	        }
	        if(C.size() != 0)
	        	return;

	        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : mToBeSendMeasurements.size() > 0  closing  progress dialog.");
	        CLASS75.MF_CLASS75_a259(4, "PATH_UPLOAD_OK", RestClient.class, "onRequestComplete: all paths uploaded.");
	        mMapScreen.runOnUiThread(new CLASS139(this));
	        Measurement class108_1;
	        for(Iterator iterator1 = D.iterator(); iterator1.hasNext(); mMapScreen.runOnUiThread(new CLASS141(this, class108_1)))
	        {
	            class108_1 = (Measurement)iterator1.next();
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : marking measurement sent, id = ").append(class108_1.mMeasurementID).toString());
	        }

	        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete(): calling mMapScreen.informUploadDone()");
	        mMapScreen.runOnUiThread(new CLASS142(this));
	        return;
     }

     if(i == 1) {
     	boolean flag;
	        if(s.contains(mCalibrationsFolder)) {
		        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : calibrationset uploaded, marking it sent.");
		        CLASS75.MF_CLASS75_a259(4, "CALIBRATION_UPLOAD_OK", RestClient.class, "onRequestComplete");
		        E = 1 + E;
		        H = 0;
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() called, CALIBRATIONS, mCurrentNumberOfCalibrationSetsAlreadySent = ").append(E).toString());
		        be.CalibrationSet calibrationset = be.CalibrationSet.parseFrom(readstream);
		        CLASS370 class370 = (CLASS370)MF_CLASS181_z707.remove(long1);
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : storing backend-side generated ID to DB CAlibrationSet: id = ").append(calibrationset.getId()).append(", size = ").append(calibrationset.toByteArray().length).toString());
		        MeasurementDataSource.markCalibrationSetSent(class370);
		        String s4 = MF_CLASS108_b448(class370);
		        flag = MF_CLASS181_u705.deleteFile(s4);
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : calibrationset file deleted filename = ").append(s4).append(", deleted = ").append(flag).toString());
		        G.add(class370);
		        if(CLASS113.isExceptionLogged.booleanValue()) {
			        String as[];
			        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : deleted calibration file ? = ").append(flag).toString());
			        as = MF_CLASS181_u705.fileList();
			        int k = 0;

			        for(;k < as.length;) {
			        	CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestComplete() : file left (not yet uploaded/deleted)  = ").append(as[k]).toString());
			        }
		        }

		        if(F.size() > 0)
		        {
		            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : mToBeSendCalibrationSets.size() > 0, removing sent calibration Set");
		            F.remove(-1 + F.size());
		        }
		        if(F.size() > 0)
		        {
		            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : mToBeSendCalibrationSets.size() > 0  AFTER removing sent CalibrationSet");
		            CLASS151 class151 = new CLASS151(this, null);
		            Object aobj1[] = new Object[1];
		            aobj1[0] = F.get(-1 + F.size());
		            class151.execute(aobj1);
		        }

		        if(F.size() != 0)
		        	return;

		        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : mToBeSendMeasurements.size() > 0  closing  progress dialog.");
		        CLASS75.MF_CLASS75_a259(4, "CALIBRATION_UPLOAD_OK", RestClient.class, "onRequestComplete: all calibrations uploaded");
		        if(CLASS113.isExceptionLogged.booleanValue())
		            MF_CLASS181_u705.runOnUiThread(new CLASS183(this));
		        if(C != null && C.size() > 0)
		        {
		            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : creating PostMeasurementToBackendTask for FIRST MEASUREMENT TO BE UPLOADED!");
		            CLASS154 class154 = new CLASS154(this, null);
		            Object aobj[] = new Object[1];
		            aobj[0] = C.get(-1 + C.size());
		            class154.execute(aobj);
		            return;
		        }
		        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() : ONLY calibration uploaded --> NO MEASUREMENTS TO BE UPLOADED!");
		        return;
	        }
	    }

     if(s.contains(mLevelsFolder) && s.endsWith(mGraphicsFolder))
     {
         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() called, LIST OF GRAPHICS");
         CLASS75.MF_CLASS75_a259(4, "GRAPHICS_LOAD_OK", RestClient.class, "onRequestComplete.");
         be.IndoorAtlas indooratlas2 = be.IndoorAtlas.parseFrom(readstream);
         mSipa.runOnUiThread(new CLASS184(this, indooratlas2));
         return;
     } else if(s.contains((new StringBuilder()).append(mGraphicsFolder).append("/").toString()))
     {
         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() called, ONE GRAPHIC");
         CLASS75.MF_CLASS75_a259(4, "GRAPHIC_LOAD_OK", RestClient.class, "onRequestComplete.");
         cmn.Graphic graphic = cmn.Graphic.parseFrom(readstream);
         mSipa.runOnUiThread(new CLASS185(this, graphic));
         return;
     } else if(s.contains(mRealURL) && s.endsWith(mLevelsFolder))
     {
         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() called, LEVELS");
         CLASS75.MF_CLASS75_a259(4, "LEVELS_LOAD_OK", RestClient.class, "onRequestComplete.");
         be.IndoorAtlas indooratlas1 = be.IndoorAtlas.parseFrom(readstream);
         mSipa.runOnUiThread(new CLASS186(this, indooratlas1));
         return;
     } else if(s.contains(mRealURL)) {
	     CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() called, BUILD_SEARCH_URL");
	     CLASS75.MF_CLASS75_a259(4, "BUILDINGS_FETCH_OK", RestClient.class, "onRequestComplete.");
	
	     MF_CLASS108_c449 = false;
	     CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestComplete() called, BUILD_SEARCH_URL, parsing response xml.");
	     be.IndoorAtlas indooratlas = be.IndoorAtlas.parseFrom(readstream);
	     mSipa.runOnUiThread(new CLASS187(this, indooratlas));
	     return;
     }

 } catch(Exception exception) {

     if(CLASS113.isExceptionLogged.booleanValue())
         exception.printStackTrace();
     CLASS75.MF_CLASS75_a259(5, "REST_CALL_FAILED", RestClient.class, (new StringBuilder()).append("onRequestComplete: ").append(exception.getMessage()).toString());
     if(mMapScreen != null)
         CLASS167.unhandledexception(exception, mMapScreen);
     mMapScreen.runOnUiThread(new CLASS188(this));

     return;
 }

 }

 public void checkDeviceSupported(int i, String s, int j, String s1, List list, String s2, String s3)
 {
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestFailed() called: ").append(s).append(", statusCode=").append(j).append(", xml=").append(s2).toString());
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestFailed() called: result = ").append(s1).append(", requestType = ").append(i).toString());
     try {
	     if(s.contains(mJobStatusFolder))
	     {
	         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestFailed() called, CHECK_MAP_GENERATION_STATUS, result = ").append(s1).toString());
	         CLASS75.MF_CLASS75_a259(5, "CHECK_MAP_GENERATION_STATUS_FAILED", RestClient.class, "onRequestFailed.");
	         mMapScreen.runOnUiThread(new CLASS119(this));
	         return;
	     }
	     if(s.contains(mJobsGeneratemapFolder)) {
		        CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestFailed() called, MAP_GENERATION_URL");
		        CLASS75.MF_CLASS75_a259(5, "MAP_GENERATION_START_FAILED", RestClient.class, "onRequestFailed.");
		        if(j != 409) {
		            mMapScreen.runOnUiThread(new CLASS121(this));
		            mMapScreen.showOkButtonDialog(mMapScreen.getString(0x7f08004b));
		            return;
		        }
		        mMapScreen.runOnUiThread(new CLASS120(this));
		        mMapScreen.showOkButtonDialog(mMapScreen.getString(0x7f08004e));
		        return;
	     }
	
	     if(i == 2) {
		        if(s.contains(mGraphicsFolder))
		        {
		            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestTimeout() called, DELETE ALL MEASUREMENTS");
		            CLASS75.MF_CLASS75_a259(5, "ALL_PATHS_DELETE_FAILED", RestClient.class, "onRequestFailed.");
		            mMapScreen.runOnUiThread(new CLASS122(this));
		            return;
		        }
	     }
	     if(i == 2) {
		        if(s.contains(mSequencesFolder))
		        {
		            CLASS75.MF_CLASS75_a259(5, "PATH_DELETE_FAILED", RestClient.class, "onRequestFailed.");
		            mMapScreen.runOnUiThread(new CLASS123(this));
		            mMapScreen.showOkButtonDialog("Deleting path from IndoorAtlas Maps failed due to a network error. Please retry.");
		            return;
		        }
		        if(s.contains(mRouteFolder))
		        {
		            CLASS167.MF_CLASS167_b635("RestClient", "onRequestFailed() : url.contains(ROUTE)");
		            if(!CLASS113.isExceptionLogged.booleanValue())
		            	CLASS75.MF_CLASS75_a259(5, "ROUTE_LOADING_FAILED", RestClient.class, "onRequestFailed.");
		            retryRouteLoading(mServiceURL(s));
		            return;
		        }
	     }
	     if(i == 0) {
		        if(s.contains(mSequencesFolder)) {
			        CLASS167.MF_CLASS167_b635("RestClient", "onRequestFailed() : requestType == Request.GET && url.contains(MEASUREMENTS)");
			        if(!CLASS113.isExceptionLogged.booleanValue())
			            mMapScreen.showOkButtonDialog("There was a network error. Please retry map generation.");
			        else
			        	mMapScreen.showOkButtonDialog("Requesting stored paths failed due to a network error. Please retry.");
			        CLASS75.MF_CLASS75_a259(5, "MEASUREMENT_LOADING_FAILED", RestClient.class, "onRequestFailed.");
			        mMapScreen.runOnUiThread(new CLASS125(this));
			        return;
		        }
	     }
	
	     int i1;
	     if(s.contains(mSequencesFolder)) {
		        CLASS75.MF_CLASS75_a259(5, "PATH_UPLOAD_FAILED", RestClient.class, "onRequestFailed.");
		        i1 = H;
		        H = i1 + 1;
		        if(i1 >= 10) {
		            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestFailed: *not* retrying measurement upload, because mSegmentPostRetryCnt = ").append(H).toString());
		            mMapScreen.runOnUiThread(new CLASS126(this));
		            mMapScreen.runOnUiThread(new CLASS127(this));
		            return;
		        }
		        CLASS167.MF_CLASS167_b635("RestClient", "onRequestFailed: retrying measurement upload.");
		        CLASS154 class154 = new CLASS154(this, null);
		        Object aobj[] = new Object[1];
		        aobj[0] = C.get(-1 + C.size());
		        class154.execute(aobj);
		        return;
	     }
	
	     if(i == 1) {
		        int k;
		        if(s.contains(mCalibrationsFolder)) {
			        CLASS75.MF_CLASS75_a259(5, "CALIBRATION_UPLOAD_FAILED", RestClient.class, "onRequestFailed.");
			        k = I;
			        I = k + 1;
			        if(k >= 10) {
			            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestTimeout: *not* retrying calibration upload, because mCalibrationSetPostRetryCnt = ").append(I).toString());
				        if(mMapScreen != null)
				        {
				            mMapScreen.runOnUiThread(new CLASS128(this));
				            return;
				        }
				        return;
			        }
				    CLASS370 class370 = (CLASS370)F.get(-1 + F.size());
			        String s4 = MF_CLASS108_b448(class370);
			        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.onRequestFailed(): calibfname = ").append(s4).toString());
			        java.io.FileInputStream fileinputstream = MF_CLASS181_u705.openFileInput(s4);
			        CLASS167.MF_CLASS167_b635("RestClient", "Re-sending latest calibration set after failure.");
			        postCalibrationSetFromStream(class370, ((InputStream) (fileinputstream)));
			        return;
		        }
	     }
	
	
	     if(s.contains((new StringBuilder()).append(mGraphicsFolder).append("/").toString()))
	     {
	         CLASS75.MF_CLASS75_a259(5, "FLOORPLAN_IMAGE_LOAD_FAILED", RestClient.class, "onRequestFailed.");
	         mSipa.runOnUiThread(new CLASS129(this));
	         MF_CLASS108_k457("Loading floorplan image failed due to a network error. Please retry.");
	         return;
	     }
	     if(s.contains(mLevelsFolder) && s.endsWith(mGraphicsFolder))
	     {
	         CLASS75.MF_CLASS75_a259(5, "GRAPHICS_LOAD_FAILED", RestClient.class, "onRequestFailed.");
	         mSipa.runOnUiThread(new CLASS130(this));
	         MF_CLASS108_k457("Loading floor plan list failed due to a network error. Please retry.");
	         return;
	     }
	     if(s.contains(mRealURL) && s.endsWith(mLevelsFolder))
	     {
	         CLASS75.MF_CLASS75_a259(5, "LEVELS_LOAD_FAILED", RestClient.class, "onRequestFailed.");
	         mSipa.runOnUiThread(new CLASS131(this));
	         MF_CLASS108_k457("Loading levels of the building failed due to a network error. Please retry.");
	         return;
	     }
	     long l;
	     long l1;
	     if(s.contains(mRealURL)) {
	     	CLASS75.MF_CLASS75_a259(5, "BUILDINGS_FETCH_FAILED", RestClient.class, "onRequestFailed.");
	     }
	     mSipa.runOnUiThread(new CLASS132(this));
	     l = System.currentTimeMillis();
	     l1 = l - MF_CLASS32_d136;
	     if(l1 > 5000L) {
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestFailed() : buildings-query, showing toast: diff = ").append(l1).toString());
		        MF_CLASS108_k457("We're sorry, loading buildings failed due to a network error. Retrying right now.");
		        MF_CLASS32_d136 = l;
	     }
	     return;
	
	 } catch(Exception exception) {
	     if(mMapScreen != null)
	     {
	         CLASS167.unhandledexception(exception, mMapScreen);
	         return;
	     }
	     CLASS167.unhandledexception(exception, mSipa);
	 }
 }

 public void onRequestTimeout(int i, String s, int j, List list, String s1)
 {
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.onRequestTimeout() called: ").append(s).append(", statusCode=").append(j).append(", xml=").append(s1).append(", requestType = ").append(i).toString());

     try {
     if(s.contains(mJobStatusFolder))
     {
         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestTimeout() called, CHECK_MAP_GENERATION_STATUS_CLOUD");
         CLASS75.MF_CLASS75_a259(5, "CHECK_MAP_GENERATION_STATUS_FAILED", RestClient.class, "onRequestTimeout.");
         mMapScreen.hideInProgressDialog();
         mMapScreen.showOkButtonDialog(mMapScreen.getString(0x7f080051));
         return;
     }
     if(s.contains(mJobsGeneratemapFolder))
     {
         CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestTimeout() called, MAP_GENERATION_URL");
         CLASS75.MF_CLASS75_a259(5, "MAP_GENERATION_START_FAILED", RestClient.class, "onRequestTimeout.");
         mMapScreen.hideInProgressDialog();
         mMapScreen.showOkButtonDialog(mMapScreen.getString(0x7f08004b));
         return;
     }

     if(i == 2) {
	        if(s.contains(mGraphicsFolder))
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", "RestClient.onRequestTimeout() called, DELETE ALL MEASUREMENTS");
	            CLASS75.MF_CLASS75_a259(5, "ALL_PATHS_DELETE_FAILED", RestClient.class, "onRequestTimeout.");
	            mMapScreen.runOnUiThread(new CLASS189(this));
	            return;
	        }
     }
     if(i == 2) {
	        if(s.contains(mSequencesFolder))
	        {
	            CLASS75.MF_CLASS75_a259(5, "PATH_DELETE_FAILED", RestClient.class, "onRequestTimeout.");
	            mMapScreen.runOnUiThread(new CLASS190(this));
	            mMapScreen.showOkButtonDialog("Deleting path from IndoorAtlas Maps failed due to a network error. Please retry.");
	            return;
	        }
	        if(s.contains(mRouteFolder))
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", "onRequestTimeout() : url.contains(ROUTE)");
	            if(!CLASS113.isExceptionLogged.booleanValue());
	            CLASS75.MF_CLASS75_a259(5, "ROUTE_LOADING_FAILED", RestClient.class, "onRequestTimeout.");
	            retryRouteLoading(mServiceURL(s));
	            return;
	        }
     }

     if(i == 0) {
	        if(s.contains(mSequencesFolder)) {
	        CLASS167.MF_CLASS167_b635("RestClient", "onRequestTimeout() : requestType == Request.GET && url.contains(MEASUREMENTS)");
	        CLASS75.MF_CLASS75_a259(5, "MEASUREMENT_LOADING_FAILED", RestClient.class, "onRequestTimeout.");
	        if(!CLASS113.isExceptionLogged.booleanValue())
	            mMapScreen.showOkButtonDialog("A network error occurred. Please retry.");
	        else
	        	mMapScreen.showOkButtonDialog("Requesting stored paths failed due to a network error. Please retry.");
	        mMapScreen.runOnUiThread(new CLASS191(this));
	        return;
	        }
     }

     int l;
     if(s.contains(mSequencesFolder)) {
	        CLASS75.MF_CLASS75_a259(5, "PATH_UPLOAD_FAILED", RestClient.class, "onRequestTimeout.");
	        l = H;
	        H = l + 1;
	        if(l >= 10) {
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestTimeout: *not* retrying measurement upload, because mSegmentPostRetryCnt = ").append(H).toString());
	            mMapScreen.runOnUiThread(new CLASS192(this));
	            MF_CLASS108_b448();
	            return;
	        }
	        CLASS167.MF_CLASS167_b635("RestClient", "onRequestTimeout: retrying measurement upload.");
	        CLASS154 class154 = new CLASS154(this, null);
	        Object aobj[] = new Object[1];
	        aobj[0] = C.get(-1 + C.size());
	        class154.execute(aobj);
	        return;
     }

     if(i == 1) {
	        int k;
	        if(s.contains(mCalibrationsFolder)) {
	        CLASS75.MF_CLASS75_a259(5, "CALIBRATION_UPLOAD_FAILED", RestClient.class, "onRequestTimeout.");
	        k = I;
	        I = k + 1;
	        if(k >= 10) {
		        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestTimeout: *not* retrying calibration upload, because mCalibrationSetPostRetryCnt = ").append(I).toString());
		        if(mMapScreen != null)
		            mMapScreen.runOnUiThread(new CLASS114(this));
		        MF_CLASS108_b448();
		        return;
	        }
	        CLASS370 class370 = (CLASS370)F.get(-1 + F.size());
	        String s2 = MF_CLASS108_b448(class370);
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("Restclient.onRequestTimeout(): calibfname = ").append(s2).toString());
	        java.io.FileInputStream fileinputstream = MF_CLASS181_u705.openFileInput(s2);
	        CLASS167.MF_CLASS167_b635("RestClient", "Re-sending latest calibration set after failure.");
	        postCalibrationSetFromStream(class370, ((InputStream) (fileinputstream)));
	        return;
	        }
     }


     if(s.contains((new StringBuilder()).append(mGraphicsFolder).append("/").toString()))
     {
         CLASS75.MF_CLASS75_a259(5, "FLOORPLAN_IMAGE_LOAD_FAILED", RestClient.class, "onRequestTimeout.");
         mSipa.runOnUiThread(new CLASS115(this));
         MF_CLASS108_k457("Loading floor plan image failed due to a network error. Please retry.");
         return;
     }
     if(s.contains(mLevelsFolder) && s.endsWith(mGraphicsFolder))
     {
         CLASS75.MF_CLASS75_a259(5, "GRAPHICS_LOAD_FAILED", RestClient.class, "onRequestTimeout.");
         mSipa.runOnUiThread(new CLASS116(this));
         MF_CLASS108_k457("Loading floorplan list failed due to a network error. Please retry.");
         return;
     }
     if(s.contains(mRealURL) && s.endsWith(mLevelsFolder))
     {
         CLASS75.MF_CLASS75_a259(5, "LEVELS_LOAD_FAILED", RestClient.class, "onRequestTimeout.");
         mSipa.runOnUiThread(new CLASS117(this));
         MF_CLASS108_k457("Loading levels of the building failed due to a network error. Please retry.");
         return;
     }

     if(s.contains(mRealURL)) {
	        CLASS75.MF_CLASS75_a259(5, "BUILDINGS_FETCH_FAILED", RestClient.class, "onRequestTimeout.");
	        MF_CLASS108_c449 = false;
	        mSipa.runOnUiThread(new CLASS118(this));
	        MF_CLASS108_k457("Loading buildings failed due to a network error.");
	        return;
     }

     } catch(Exception exception) {
	     if(mMapScreen != null)
	     {
	         CLASS167.unhandledexception(exception, mMapScreen);
	         return;
	     }
	     CLASS167.unhandledexception(exception, mSipa);
     }
 }

 public void checkDeviceSupported(int i, String s, List list, String s1)
 {
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("onRequestStarted: url = ").append(s).toString());
 }

 public void setBuilding(Building class99)
 {
	 mBuilding = class99;
 }

 public void postCalibrationSetFromStream(CLASS370 class370, InputStream inputstream)
 {
     try
     {
         String s = (new StringBuilder()).append(mServiceSSLURL).append(mResourceFolder).append(mCalibrationsFolder).toString();
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.postCalibrationSetFromStream() called, url = ").append(s).append(", inputStream.available() = ").append(inputstream.available()).toString());
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.postCalibrationSetFromStream() called, calibrationSet.calibrationSetID = ").append(class370.mMeasurementID).toString());
         CookieHTTPHandler class140 = new CookieHTTPHandler(1, s, null, null, this, true, 0, inputstream, MF_CLASS32_e135, "MapCreator");
         class140.isExceptionLogged(A);
         MF_CLASS181_z707.put(Long.valueOf(A), class370);
         mThreadPoolExecutor.execute(class140);
         A = 1L + A;
         return;
     }
     catch(Exception exception)
     {
         if(CLASS113.isExceptionLogged.booleanValue())
             exception.printStackTrace();
         CLASS167.unhandledexception(exception, mMapScreen);
         return;
     }
 }

 public void deleteMeasurementSequence(String s)
 {
     String s1 = (new StringBuilder()).append(mServiceSSLURL).append(mAtlasPath).append(mGraphicsFolder).append("/").append(s).append(mSequencesFolder).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.deleteMeasurementSequence() called, url = ").append(s1).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(2, s1, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void postMeasurementSequenceFromStream(String s, String s1, Measurement class108, InputStream inputstream)
 {
     try
     {
         String s2 = (new StringBuilder()).append(mServiceSSLURL).append(mResourceFolder).append(mSequencesFolder).toString();
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.postMeasurementSequenceFromStream() called, url = ").append(s2).toString());
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.postMeasurementSequenceFromStream() called, measurement.mMeasurementID = ").append(class108.mMeasurementID).toString());
         MF_CLASS181_y706.put(Long.valueOf(A), class108);
         CookieHTTPHandler class140 = new CookieHTTPHandler(1, s2, null, null, this, true, 0, inputstream, MF_CLASS32_e135, "MapCreator");
         class140.isExceptionLogged(A);
         mThreadPoolExecutor.execute(class140);
         A = 1L + A;
         return;
     }
     catch(Exception exception)
     {
         CLASS167.unhandledexception(exception, mMapScreen);
     }
 }

 public void deleteMeasurementSequence(String s, String s1, String s2)
 {
     String s3 = (new StringBuilder()).append(mServiceSSLURL).append(mResourceFolder).append(mSequencesFolder).append("/").append(s2).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.deleteMeasurementSequence() called, url = ").append(s3).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(2, s3, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void getBackendSegmentRoutes(List list)
 {
     CLASS167.MF_CLASS167_b635("RestClient", "RestClient.getBackendSegmentRoutes() called");
     J = 0;
     for(Iterator iterator = list.iterator(); iterator.hasNext(); ) {
     	getBackendSegmentRoute(((Measurement)iterator.next()).segmentID);
     }
 }

 public void MF_CLASS54_a201(boolean flag)
 {
     MF_CLASS108_b448 = flag;
 }

 public CheckPoint[] getBezierPoints(Measurement class108, int i, double d, double d1)
 {
     CheckPoint aclass112[] = new CheckPoint[i];
     if(class108.mBezier == 1)
     {
         CheckPoint class112 = (CheckPoint)class108.mPoints.get(0);
         CheckPoint class112_1 = (CheckPoint)class108.mPoints.get(1);
         CheckPoint class112_2 = (CheckPoint)class108.mPoints.get(2);
         Path path = new Path();
         path.moveTo(class112.coordX, class112.coordY);
         path.quadTo(class112_1.coordX, class112_1.coordY, class112_2.coordX, class112_2.coordY);
         PathMeasure pathmeasure = new PathMeasure(path, false);
         float af[] = new float[2];
         for(int j = 0; j < i; j++)
         {
             pathmeasure.getPosTan(((float)j / (float)i) * pathmeasure.getLength(), af, null);
             aclass112[j] = new CheckPoint(af[0], af[1]);
             aclass112[j].CheckPointTimestamp = (long)(d + d1 * (double)j);
         }

         return aclass112;
     } else
     {
         return null;
     }
 }

 public CheckPoint[] getPointsAlongLine(CheckPoint startPoint, CheckPoint endPoint, int i)
 {
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("getPointsAlongLine called with : start  = ").append(startPoint.toString()).toString());
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("getPointsAlongLine called with : end  = ").append(endPoint.toString()).toString());
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("getPointsAlongLine called with : numPoints  = ").append(i).toString());
     CheckPoint aclass112[] = new CheckPoint[i];
     Path path = new Path();
     path.moveTo(startPoint.coordX, startPoint.coordY);
     path.lineTo(endPoint.coordX, endPoint.coordY);
     PathMeasure pathmeasure = new PathMeasure(path, false);
     float af[] = new float[2];
     for(int j = 0; j < i; j++)
     {
         pathmeasure.getPosTan(((float)j / (float)i) * pathmeasure.getLength(), af, null);
         aclass112[j] = new CheckPoint(af[0], af[1]);
     }

     aclass112[0].CheckPointTimestamp = startPoint.CheckPointTimestamp;
     aclass112[i - 1].CheckPointTimestamp = endPoint.CheckPointTimestamp;
     aclass112[0].MF_CLASS112_e484 = startPoint.MF_CLASS112_e484;
     aclass112[i - 1].MF_CLASS112_e484 = endPoint.MF_CLASS112_e484;
     return aclass112;
 }

 public String formatMeasurementFileString(Measurement pMeasurement)
 {
     return (new StringBuilder()).append("bID_").append(pMeasurement.bID).append("_levID_").append(pMeasurement.lID).append("_gID_").append(pMeasurement.gID).append("_mesID_").append(pMeasurement.mMeasurementID).append(".gzip").toString();
 }

 public List addProximitySamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "ProximityData", i);
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addProximitySamples(): firstQueriedSampleID = ").append(l1).toString());
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementProximityDataByStartID(l, l1, 100L, i);
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addProximitySamples(): data.size = ").append(class109.mData.size()).toString());
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addProximitySamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addProximitySamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS31 class31 = (CLASS31)iterator.next();
                 cmn.ProximitySample proximitysample = new cmn.ProximitySample();
                 proximitysample.setProximityTimestamp(class31.PressureTimestamp);
                 proximitysample.setProximity(class31.Pressure);
                 long l4;
                 if(class31.PressureTimestamp > l3)
                 {
                     arraylist.add(proximitysample);
                     l4 = class31.PressureTimestamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addProximiteSamples : skipped duplicate proximity ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 public void getLevels(String s)
 {
     String s1 = (new StringBuilder()).append(mRealURL).append("/").append(s).append(mLevelsFolder).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.getLevels() called, url = ").append(s1).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, s1, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void initiateMapGeneration(String s, String s1, String s2)
 {
     String s3;
     be.MapJob mapjob;
     ByteArrayOutputStream bytearrayoutputstream;

     try {
	        if(!CLASS113.isExceptionLogged.booleanValue());
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("initiateMapGeneration(): buildingId = ").append(s).append(", levelID = ").append(s1).append(", graphicsID = ").append(s2).toString());
	        s3 = (new StringBuilder()).append(mServiceSSLURL).append(mJobsGeneratemapFolder).toString();
	        mapjob = new be.MapJob();
	        mapjob.setGraphicsId(s2);
	        mapjob.setLevelId(s1);
	        bytearrayoutputstream = new ByteArrayOutputStream();
	        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new GZIPOutputStream(bytearrayoutputstream));
	        WriteStream writestream = WriteStream.getInstance(bufferedoutputstream);
	        mapjob.writeTo(writestream);
	        bufferedoutputstream.flush();
	        writestream.getInstance();
	        bufferedoutputstream.close();
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("initiateMapGeneration()").append(mapjob.toString()).toString());
	            FileOutputStream fileoutputstream = new FileOutputStream(openFileForWriting("mapjob.proto"));
	            mapjob.writeTo(WriteStream.getInstance(fileoutputstream));
	            fileoutputstream.close();
	        }


	        byte abyte0[] = bytearrayoutputstream.toByteArray();
	        CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("checkDeviceSupported: gzipped length = ").append(abyte0.length).toString());
	        CookieHTTPHandler class140 = new CookieHTTPHandler(1, s3, null, null, this, true, 0, new ByteArrayInputStream(abyte0), MF_CLASS32_e135, "MapCreator");
	        mThreadPoolExecutor.execute(class140);
     } catch(Exception ioexception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            ioexception.printStackTrace();
     }

     return;
 }

 public List addLightSamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "LightData", i);
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addLightSamples(): firstQueriedSampleID = ").append(l1).toString());
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementLightDataByStartID(l, l1, 100L, i);
         CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addLightSamples(): data.size = ").append(class109.mData.size()).toString());
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addLightSamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addLightSamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS28 class28 = (CLASS28)iterator.next();
                 cmn.LightSample lightsample = new cmn.LightSample();
                 lightsample.setLightTimestamp(class28.PressureTimestamp);
                 lightsample.setLight(class28.Pressure);
                 long l4;
                 if(class28.PressureTimestamp > l3)
                 {
                     arraylist.add(lightsample);
                     l4 = class28.PressureTimestamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addLightSamples : skipped duplicate light ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 public void Floorplans(String s)
 {
     String s1 = (new StringBuilder()).append(mServiceSSLURL).append(mAtlasPath).append(mLevelsFolder).append("/").append(s).append(mGraphicsFolder).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.Floorplans() called, url = ").append(s1).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, s1, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void MF_CLASS108_c449(String s, String s1, String s2)
 {
     (new CLASS143(this, null)).execute(new Object[] {
         s, s1, s2
     });
 }

 public List addTemperatureSamples(long l, int i)
 {
     long l1 = MeasurementDataSource.getMeasurementFirstSampleRowID(l, "TemperatureData", i);
     ArrayList arraylist = new ArrayList();
     long l2 = -1L;
     boolean flag = true;
     do
     {
         CLASS109 class109 = MeasurementDataSource.getMeasurementTemperatureDataByStartID(l, l1, 100L, i);
         if(class109 == null || (long)class109.mData.size() != 100L)
         {
             CLASS167.MF_CLASS167_b635("RestClient", "addTemperatureSamples(): setting continueQueries = false");
             flag = false;
         } else
         {
             CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("addTemperatureSamples(): data.size() = ").append(class109.mData.size()).toString());
         }
         if(class109 != null && class109.mData.size() != 0)
         {
             Iterator iterator = class109.mData.iterator();
             long l3 = l2;
             while(iterator.hasNext())
             {
                 CLASS32 class32 = (CLASS32)iterator.next();
                 cmn.TemperatureSample temperaturesample = new cmn.TemperatureSample();
                 temperaturesample.setTemperatureTimestamp(class32.PressureTimestamp);
                 temperaturesample.setTemperature(class32.Pressure);
                 long l4;
                 if(class32.PressureTimestamp > l3)
                 {
                     arraylist.add(temperaturesample);
                     l4 = class32.PressureTimestamp;
                 } else
                 {
                     CLASS167.MF_CLASS167_b635("RestClient", "addTemperatureSamples : skipped duplicate temperature ts.");
                     l4 = l3;
                 }
                 l3 = l4;
             }
             l1 += 100L;
             l2 = l3;
         }
     } while(flag);
     return arraylist;
 }

 public void getGraphics(String s)
 {
     String s1 = (new StringBuilder()).append(mServiceSSLURL).append(mAtlasPath).append(mGraphicsFolder).append("/").append(s).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.getGraphics() called, url = ").append(s1).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, s1, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void getSegments(String s)
 {
     String s1 = (new StringBuilder()).append(mServiceSSLURL).append(mAtlasPath).append(mGraphicsFolder).append("/").append(s).append(mSequencesFolder).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.getSegments() called, url = ").append(s1).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, s1, null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void getBackendSegmentRoute(String s)
 {
     String s1 = (new StringBuilder()).append(mServiceSSLURL).append(mResourceFolder).append(mSequencesFolder).append("/").append(s).append(mRouteFolder).toString();
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("RestClient.getBackendSegmentRoute() called, url = ").append(s1).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, s1, null, null, this, true, 1, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public void checkMapGenerationStatus(String s)
 {
     CLASS167.MF_CLASS167_b635("RestClient", (new StringBuilder()).append("checkMapGenerationStatus(): jobID = ").append(s).toString());
     CookieHTTPHandler class140 = new CookieHTTPHandler(0, (new StringBuilder()).append(mServiceSSLURL).append(mJobStatusFolder).append(s).toString(), null, null, this, true, 0, null, MF_CLASS32_e135, "MapCreator");
     mThreadPoolExecutor.execute(class140);
 }

 public String mServiceURL(String s)
 {
     return s.split("/")[5];
 }

 private static int L;
 private static final BlockingQueue mBlockingQueue;
 private static final TimeUnit N;
 static ThreadPoolExecutor mThreadPoolExecutor = null;
 private static String mAtlasPath = "/atlas";
 private static String mResourceFolder = "/resources";
 private static String mLevelsFolder = "/levels";
 private static String mGraphicsFolder = "/graphics";
 private static String mSequencesFolder = "/sequences";
 private static String mCalibrationsFolder = "/calibrations";
 private static String mRouteFolder = "/route";
 private static String mJobsGeneratemapFolder = "/jobs/generatemap";
 private static String mJobStatusFolder = "/jobs/jobstatus?id=";
 private static int MF_CLASS181_w702 = 500;
 private long A;
 private int B;
 private List C;
 private List D;
 private int E;
 private List F;
 private List G;
 private int H;
 private int I;
 private int J;
 private NumberFormat K;
 public int MF_CLASS108_a447;
 boolean MF_CLASS108_b448;
 public boolean MF_CLASS108_c449;
 long MF_CLASS32_d136;
 public String MF_CLASS32_e135;
 private String mServiceSSLURL;
 private String mServiceURL;
 private String mRealURL;
 private MapScreen mMapScreen;
 private Sipa mSipa;
 private Activity MF_CLASS181_u705;
 private CLASS100 MF_CLASS181_v709;
 private Building mBuilding;
 private Hashtable MF_CLASS181_y706;
 private Hashtable MF_CLASS181_z707;

 static
 {
     L = Runtime.getRuntime().availableProcessors();
     N = TimeUnit.SECONDS;
     mBlockingQueue = new LinkedBlockingQueue();
     mThreadPoolExecutor = new ThreadPoolExecutor(L, L, 1L, N, mBlockingQueue);
 }
}
