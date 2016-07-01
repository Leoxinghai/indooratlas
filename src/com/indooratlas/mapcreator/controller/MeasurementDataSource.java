package com.indooratlas.mapcreator.controller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.indooratlas.Calibrator.CLASS15;
import com.indooratlas.Calibrator.CLASS17;
import com.indooratlas.cursor.list.*;
import com.indooratlas.mapcreator.data.*;
import com.indooratlas.sensor.CLASS370;
import com.indooratlas.sensor.CLASS381;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


//CLASS179

public class MeasurementDataSource
{

 public static long getMeasurementCount()
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", " getMeasurementCount() called.");
     Cursor cursor = mDatabase.rawQuery("SELECT count(*) from Measurements", null);
     cursor.moveToFirst();
     long l = cursor.getLong(0);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementCount() : count = ").append(l).toString());
     cursor.close();
     return l;
 }

 public static long getMeasurementFirstSampleRowID(long l, String s, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementFirstSampleRowID() : getting from DB with id: ").append(l).append(", tableName = ").append(s).toString());
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from ").append(s).append(" where ").append("MeasurementID").append("=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).append(" limit 1").toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         l = cursor.getLong(0);

     cursor.close();
     return l;
 }

 public static long getNotUploadedMeasurementCount(String s)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", " getNotUploadedMeasurementCount() called.");
     String s1 = (new StringBuilder()).append("\"").append(s).append("\"").toString();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT count(*) from Measurements where SentToServer = 0 AND GraphicsID = ").append(s1).toString(), null);
     cursor.moveToFirst();
     long l = cursor.getLong(0);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getNotUploadedMeasurementCount() : count = ").append(l).toString());
     cursor.close();
     return l;
 }

 public static long storeFloorplan(String s, String s1)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeFloorplan(): calling database.beginTransaction");
     long l1;
     long l;
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("FloorplanURL", s);
	        contentvalues.put("FloorplanLocalFileName", s1);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeFloorplan(): calling database.insertOrThrow(), floorplanURL=").append(s).append(", floorplanLocalFileName = ").append(s1).toString());
	        l1 = mDatabase.insertOrThrow("Floorplans", null, contentvalues);
	        l = l1;
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeFloorplan calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return l;
     } catch(Exception exception1) {
	        Exception exception2;
	        l = -1L;
	        exception2 = exception1;
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception2.printStackTrace();
	        mDatabase.endTransaction();
	        return l;
     }
 }

 public static CLASS15 storeBGCalibration(CLASS15 class15)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeBGCalibration(): calling database.beginTransaction");
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("BG_X", Double.valueOf(class15.MF_CLASS16_b54()[0]));
	        contentvalues.put("BG_Y", Double.valueOf(class15.MF_CLASS16_b54()[1]));
	        contentvalues.put("BG_Z", Double.valueOf(class15.MF_CLASS16_b54()[2]));
	        contentvalues.put("BG_COV", Double.valueOf(class15.MF_CLASS16_c55()));
	        contentvalues.put("BGCalibTimestamp", Long.valueOf(class15.MF_CLASS15_f50()));
	        contentvalues.put("CalibType", Integer.valueOf(class15.MF_CLASS15_h52().ordinal()));
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeBGCalibration(): calling database.insertOrThrow(), bgCalibration=").append(class15.toString()).toString());
	        class15.MF_CLASS17_a58(mDatabase.insertOrThrow("BGCalib", null, contentvalues));
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeBGCalibration calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return class15;
     } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return class15;
     }
 }

 public static Measurement storeMeasurement(Measurement class108)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeMeasurement(): calling database.beginTransaction");
     try {
	     mDatabase.beginTransaction();
	     ContentValues contentvalues = new ContentValues();
	     contentvalues.put("BuildingID", class108.bID);
	     contentvalues.put("LevelID", class108.lID);
	     contentvalues.put("GraphicsID", class108.gID);
	     contentvalues.put("CoordinateSystem", class108.coordSys);
	     contentvalues.put("DeviceModelGuid", class108.mDeviceModel);
	     contentvalues.put("IdaUid", class108.userId);
	     contentvalues.put("StartTimestamp", Long.valueOf(class108.mStartTimestamp));
	     contentvalues.put("EndTimestamp", Long.valueOf(class108.EndTimestamp));
	     contentvalues.put("SentToServer", Long.valueOf(class108.mSentToServer));
	     contentvalues.put("WrittenToFile", Long.valueOf(class108.mWrittenToFile));
	     contentvalues.put("SequenceIDBackend", class108.segmentID);
	     contentvalues.put("TestSegment", Integer.valueOf(class108.TestSegment));
	     contentvalues.put("Bezier", Integer.valueOf(class108.mBezier));
	     contentvalues.put("Label", class108.mLabel);
	     contentvalues.put("UserID", class108.userId);
	     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeMeasurement(): calling database.insertOrThrow(), \nmeasurement=").append(class108.toString()).toString());
	     class108.mMeasurementID = mDatabase.insertOrThrow("Measurements", null, contentvalues);
	     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeMeasurement(): calling database.insertOrThrow(), storing points, N = ").append(class108.mPoints.size()).toString());
	     long l;
	     for(Iterator iterator = class108.mPoints.iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeMeasurement(): calling database.insertOrThrow(), stored pointId = ").append(l).toString()))
	     {
	         CheckPoint class112 = (CheckPoint)iterator.next();
	         ContentValues contentvalues1 = new ContentValues();
	         contentvalues1.put("MeasurementID", Long.valueOf(class108.mMeasurementID));
	         contentvalues1.put("X", Float.valueOf(class112.coordX));
	         contentvalues1.put("Y", Float.valueOf(class112.coordY));
	         contentvalues1.put("CheckPointTimestamp", Long.valueOf(class112.CheckPointTimestamp));
	         contentvalues1.put("CheckPointLabel", class112.MF_CLASS112_e484);
	         CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeMeasurement(): calling database.insertOrThrow(), point=").append(class112.coordX).append(",").append(class112.coordY).append(", p.mTimestamp = ").append(class112.CheckPointTimestamp).append(", p.mLabel = ").append(class112.MF_CLASS112_e484).toString());
	         l = mDatabase.insertOrThrow("Points", null, contentvalues1);
	         class112.MF_CLASS112_a480 = l;
	     }
	
	     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeMeasurement calling database.setTransactionSuccessful()");
	     mDatabase.setTransactionSuccessful();
	     mDatabase.endTransaction();
	     return class108;
	     
     } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return class108;
     }        
 }

 public static CLASS109 getMeasurementAccDataByStartID(long l, long l1, long l2, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementAccDataByStartID() : getting from DB with id: ").append(l).append(", firstQueriedSampleID  = ").append(l1).append(", maxSamples = ").append(l2).toString());
     long l3 = (l1 + l2) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementAccDataByStartID() : querying samples between firstQueriedSampleID : ").append(l1).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from AccData where MeasurementID=").append(l).append(" and ").append("SampleID").append(" >= ").append(l1).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS23.getAccDatafromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementAccDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static CLASS370 storeCalibrationSet(CLASS370 class370)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeCalibrationSet(): calling database.beginTransaction");
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("StartTimestampMS", Long.valueOf(class370.StartTimestampMS));
	        contentvalues.put("EndTimestampMS", Long.valueOf(class370.EndTimestampMS));
	        contentvalues.put("Latitude", Double.valueOf(class370.Latitude));
	        contentvalues.put("Longitude", Double.valueOf(class370.Longitude));
	        contentvalues.put("Altitude", Double.valueOf(class370.Altitude));
	        contentvalues.put("SentToServer", Long.valueOf(class370.SentToServer));
	        contentvalues.put("WrittenToFile", Long.valueOf(class370.WrittenToFile));
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeCalibrationSet(): calling database.insertOrThrow(), \ncalibrationSet=").append(class370.toString()).toString());
	        class370.mMeasurementID = mDatabase.insertOrThrow("Calibration", null, contentvalues);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeCalibrationSet calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return class370;
     } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return class370;
     }
 }

 private static BufferedWriter createFileOutputStream(File file)
 {
     BufferedWriter bufferedwriter;
     try
     {
         bufferedwriter = new BufferedWriter(new FileWriter(file));
     }
     catch(IOException ioexception)
     {
         CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" MeasurementDataSource.createFileOutputStream: Could not open file for writing ").append(ioexception.getMessage()).toString());
         return null;
     }
     return bufferedwriter;
 }

 public static List getMeasurementMgnData(long l, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementMgnData() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from MgnData where MeasurementID=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS29.getMgnDataFromDB(cursor));

     }

     cursor.close();
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementMgnData() : returning with sensorData.size == ").append(arraylist.size()).toString());
     return arraylist;
 }

 public static List getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(String s, String s1, String s2)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementsByBuildingIDAndLevelIDAndGraphicsID() called with buildingID = ").append(s).append(", levelID = ").append(s1).append(", graphicsID = ").append(s2).toString());
     String s3 = (new StringBuilder()).append("\"").append(s).append("\"").toString();
     String s4 = (new StringBuilder()).append("\"").append(s1).append("\"").toString();
     String s5 = (new StringBuilder()).append("\"").append(s2).append("\"").toString();
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from Measurements where BuildingID = ").append(s3).append(" AND ").append("LevelID").append(" = ").append(s4).append(" AND ").append("GraphicsID").append(" = ").append(s5).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); ){
         arraylist.add(Measurement.getMeasurementfromDB(cursor));
    	 cursor.moveToNext();
     }

     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementsByBuildingIDAndLevelIDAndGraphicsID() returning measurements.size() = ").append(arraylist.size()).toString());
     cursor.close();
     return arraylist;
 }

 public static void MeasurementdeletedDBWithid(long l)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Measurement deleted from DB with id: ").append(l).toString());
     mDatabase.delete("Measurements", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     int i = mDatabase.delete("AccData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(i).append(" AccData items.").toString());
     int j = mDatabase.delete("GyroData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(j).append(" GyroData items.").toString());
     int k = mDatabase.delete("MgnData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(k).append(" MgnData items.").toString());
     int i1 = mDatabase.delete("PressureData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(i1).append(" PressureData items.").toString());
     int j1 = mDatabase.delete("LightData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(j1).append(" LightData items.").toString());
     int k1 = mDatabase.delete("ProximityData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(k1).append(" PoximityData items.").toString());
     int l1 = mDatabase.delete("TemperatureData", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(l1).append(" TemperatureData items.").toString());
     int i2 = mDatabase.delete("Wifi", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(i2).append(" Wifi items.").toString());
     int j2 = mDatabase.delete("Points", (new StringBuilder()).append("MeasurementID = ").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Deleted ").append(j2).append(" XY-Point items.").toString());
 }

 public static void openDB(Context context)
 {
     MF_CLASS381_a1107 = true;
     //mMeasurementsDB = new MeasurementsDB(context);
     
     //mDatabase = mMeasurementsDB.getWritableDatabase();
     mDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath("measurements.db"), null);
     //add by xinghai
     
     MeasurementDataSource.createSysTables();
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("MeasurementDataSource.open(): open db version = ").append(mDatabase.getVersion()).toString());
 }

 private static File getDatabasePath(String name) {
	 File sdcard = Environment.getExternalStorageDirectory();
	 String dbfile = sdcard.getAbsolutePath() + File.separator +"database" + File.separator + name;
	 File result = new File(dbfile);
	 return result;
 }
 
 public static long[] storeWifiData(ConcurrentLinkedQueue concurrentlinkedqueue, long l)
 {
     long al[]=null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeWifiData(): calling database.beginTransaction");
     try {
	        mDatabase.beginTransaction();
	        al = new long[concurrentlinkedqueue.size()];
	        Iterator iterator = concurrentlinkedqueue.iterator();
	        int i = 0;
	        long l1;
	        for(;iterator.hasNext();) {
		        CLASS381 class381 = (CLASS381)iterator.next();
		        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeWifiData(): storing data to measurement id = ").append(l).append("\n").append(class381.toString()).toString());
		        ContentValues contentvalues = new ContentValues();
		        contentvalues.put("MeasurementID", Long.valueOf(l));
		        contentvalues.put("ScanNo", Long.valueOf(class381.ScanNo));
		        contentvalues.put("WifiScanTimestamp", Long.valueOf(class381.mScanTimeStamp));
		        contentvalues.put("SSID", class381.mSsid);
		        contentvalues.put("BSSID", class381.BSSID);
		        contentvalues.put("SignalStrength", Integer.valueOf(class381.SignalStrength));
		        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeWifiData(): calling database.insertOrThrow(MySQLiteHelper.TABLE_Wifi, null, values)");
		        l1 = mDatabase.insertOrThrow("Wifi", null, contentvalues);
		        int j = i + 1;
		        al[i] = l1;
		        i = j;
	        }
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeWifiData calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return al;
	    } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
	    }
 }

 public static long[] storeAccSensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeAccSensorData(): calling database.beginTransaction");
     try {
     mDatabase.beginTransaction();
     al = new long[concurrentlinkedqueue.size()];
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeAccSensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
     if(flag) {
         Iterator iterator1 = concurrentlinkedqueue.iterator();
         int k = 0;
         long l2;
         for(;iterator1.hasNext();) {
             CLASS22 class22_1 = (CLASS22)iterator1.next();
             ContentValues contentvalues1 = new ContentValues();
             contentvalues1.put("MeasurementID", Long.valueOf(l));
             contentvalues1.put("AccelerometerTimestamp", Long.valueOf(class22_1.timeStamp));
             contentvalues1.put("AccelerometerX", Float.valueOf(class22_1.AccelerometerX));
             contentvalues1.put("AccelerometerY", Float.valueOf(class22_1.AccelerometerY));
             contentvalues1.put("AccelerometerZ", Float.valueOf(class22_1.AccelerometerZ));
             contentvalues1.put("CalibrationData", Integer.valueOf(1));
             l2 = mDatabase.insertOrThrow("AccData", null, contentvalues1);
             int i1 = k + 1;
             al[k] = l2;
             k = i1;
         }
     	
     } else {
	        Iterator iterator = concurrentlinkedqueue.iterator();
	        int i = 0;
	        long l1;
	        for(;iterator.hasNext();) {
		        CLASS22 class22 = (CLASS22)iterator.next();
		        ContentValues contentvalues = new ContentValues();
		        contentvalues.put("MeasurementID", Long.valueOf(l));
		        contentvalues.put("AccelerometerTimestamp", Long.valueOf(class22.timeStamp));
		        contentvalues.put("AccelerometerX", Float.valueOf(class22.AccelerometerX));
		        contentvalues.put("AccelerometerY", Float.valueOf(class22.AccelerometerY));
		        contentvalues.put("AccelerometerZ", Float.valueOf(class22.AccelerometerZ));
		        contentvalues.put("CalibrationData", Integer.valueOf(0));
		        l1 = mDatabase.insertOrThrow("AccData", null, contentvalues);
		        int j = i + 1;
		        al[i] = l1;
		        i = j;
	        }
     }

     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeAccSensorData calling database.setTransactionSuccessful()");
     mDatabase.setTransactionSuccessful();
     mDatabase.endTransaction();
     return al;
     } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
     }
 }

 public static CLASS109 getMeasurementGyroDataByStartID(long l, long l1, long l2, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementGyroDataByStartID() : getting from DB with id: ").append(l).append(", firstQueriedSampleID  = ").append(l1).append(", maxSamples = ").append(l2).toString());
     long l3 = (l1 + l2) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementGyroDataByStartID() : querying samples between firstQueriedSampleID : ").append(l1).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from GyroData where MeasurementID=").append(l).append(" and ").append("SampleID").append(" >= ").append(l1).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS26.getGyroDatafromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementGyroDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static String getFloorplanLocalFileName(String s)
 {
     String s1 = (new StringBuilder()).append("\"").append(s).append("\"").toString();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT FloorplanLocalFileName from Floorplans where FloorplanURL = ").append(s1).toString(), null);
     cursor.moveToFirst();
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getLatestCalibrationSet() = cursor.getCount() = ").append(cursor.getCount()).toString());
     int i = cursor.getCount();
     String s2 = null;
     if(i > 0)
         s2 = cursor.getString(0);
     cursor.close();
     return s2;
 }

 public static List getAllMeasurements()
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "getAllMeasurements() called. ");
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("Measurements", MeasurementsDB.MF_CLASS180_b672, null, null, null, null, null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getAllMeasurements() cursor.getCount() = ").append(cursor.getCount()).toString());
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(Measurement.getMeasurementfromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List getAllPointsByMeasurementID(long l)
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from Points where MeasurementID=").append(l).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CheckPoint.getCheckPointFromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static List getMeasurementAccData(long l, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementAccData() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from AccData where MeasurementID=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS23.getAccDatafromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static void updateMeasurement(Measurement class108)
 {
     long l;
     l = class108.mMeasurementID;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("updateMeasurement(): Measurement updated, with id: ").append(l).append(", mBezier = ").append(class108.mBezier).toString());
     try {
     mDatabase.beginTransaction();
     ContentValues contentvalues = new ContentValues();
     contentvalues.put("MeasurementID", Long.valueOf(l));
     contentvalues.put("StartTimestamp", Long.valueOf(class108.mStartTimestamp));
     contentvalues.put("EndTimestamp", Long.valueOf(class108.EndTimestamp));
     contentvalues.put("Label", class108.mLabel);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "updateMeasurement(): calling database.update()");
     int i = mDatabase.update("Measurements", contentvalues, (new StringBuilder()).append("MeasurementID=").append(l).toString(), null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("updateMeasurement(): noRowsAffected = ").append(i).toString());
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("updateMeasurement(): calling database.insertOrThrow(), storing points, N = ").append(class108.mPoints.size()).toString());
     CheckPoint class112;
     int j;
     for(Iterator iterator = class108.mPoints.iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("updateMeasurement(): calling database.insertOrThrow(), updated p.mID = ").append(class112.MF_CLASS112_a480).append(", noPointRowsAffected = ").append(j).toString()))
     {
         class112 = (CheckPoint)iterator.next();
         CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("Checkpoint = ").append(class112.hashCode()).toString());
         CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("updateMeasurement(): Checkpoint: p.mId = ").append(class112.MF_CLASS112_a480).append(" p.mTimestamp = ").append(class112.CheckPointTimestamp).toString());
         ContentValues contentvalues1 = new ContentValues();
         contentvalues1.put("PointID", Long.valueOf(class112.MF_CLASS112_a480));
         contentvalues1.put("MeasurementID", Long.valueOf(class108.mMeasurementID));
         contentvalues1.put("X", Float.valueOf(class112.coordX));
         contentvalues1.put("Y", Float.valueOf(class112.coordY));
         contentvalues1.put("CheckPointTimestamp", Long.valueOf(class112.CheckPointTimestamp));
         CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("updateMeasurement(): calling database.insertOrThrow(), point=").append(class112.coordX).append(",").append(class112.coordY).append(", p.mTimestamp = ").append(class112.CheckPointTimestamp).toString());
         j = mDatabase.update("Points", contentvalues1, (new StringBuilder()).append("PointID=").append(class112.MF_CLASS112_a480).toString(), null);
     }

     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "updateMeasurement() calling database.setTransactionSuccessful()");
     mDatabase.setTransactionSuccessful();
     mDatabase.endTransaction();
     return;
     
 } catch(Exception exception1) {
     if(CLASS113.isExceptionLogged.booleanValue())
         exception1.printStackTrace();
     mDatabase.endTransaction();
     return;
 }
 }

 public static void markCalibrationSetSent(CLASS370 class370)
 {
     long l;
     l = class370.mMeasurementID;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markCalibrationSetSent(): CalibrationSet marked sent with id: ").append(l).toString());
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("CalibrationSetID", Long.valueOf(l));
	        contentvalues.put("SentToServer", Integer.valueOf(1));
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markCalibrationSetSent(): calling database.update()");
	        int i = mDatabase.update("Calibration", contentvalues, (new StringBuilder()).append("CalibrationSetID=").append(l).toString(), null);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markCalibrationSetSent(): noRowsAffected = ").append(i).toString());
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markCalibrationSetSent() calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return;
     } catch(Exception exception1) {
     	exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return;
     }
 }

 public static long[] storeGyroSensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeGyroSensorData(): calling database.beginTransaction");
     try {
	        mDatabase.beginTransaction();
	        al = new long[concurrentlinkedqueue.size()];
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeGyroSensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
	        if(flag) {
	            Iterator iterator1 = concurrentlinkedqueue.iterator();
	            int k = 0;
	            long l2;
	            for(;iterator1.hasNext();) {
	    	        CLASS22 class22_1 = (CLASS22)iterator1.next();
	    	        ContentValues contentvalues1 = new ContentValues();
	    	        contentvalues1.put("MeasurementID", Long.valueOf(l));
	    	        contentvalues1.put("GyroscopeTimestamp", Long.valueOf(class22_1.timeStamp));
	    	        contentvalues1.put("GyroscopeX", Float.valueOf(class22_1.AccelerometerX));
	    	        contentvalues1.put("GyroscopeY", Float.valueOf(class22_1.AccelerometerY));
	    	        contentvalues1.put("GyroscopeZ", Float.valueOf(class22_1.AccelerometerZ));
	    	        contentvalues1.put("CalibrationData", Integer.valueOf(1));
	    	        l2 = mDatabase.insertOrThrow("GyroData", null, contentvalues1);
	    	        int i1 = k + 1;
	    	        al[k] = l2;
	    	        k = i1;
	            }
	        	
	        } else {
		        Iterator iterator = concurrentlinkedqueue.iterator();
		        int i = 0;
		        long l1;
		        for(;iterator.hasNext();) {
			        CLASS22 class22 = (CLASS22)iterator.next();
			        ContentValues contentvalues = new ContentValues();
			        contentvalues.put("MeasurementID", Long.valueOf(l));
			        contentvalues.put("GyroscopeTimestamp", Long.valueOf(class22.timeStamp));
			        contentvalues.put("GyroscopeX", Float.valueOf(class22.AccelerometerX));
			        contentvalues.put("GyroscopeY", Float.valueOf(class22.AccelerometerY));
			        contentvalues.put("GyroscopeZ", Float.valueOf(class22.AccelerometerZ));
			        contentvalues.put("CalibrationData", Integer.valueOf(0));
			        l1 = mDatabase.insertOrThrow("GyroData", null, contentvalues);
			        int j = i + 1;
			        al[i] = l1;
			        i = j;
		        }
	        }
	
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeGyroSensorData calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return al;
     } catch(Exception exception1) {
     	exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
     }
 }

 public static Measurement getMeasurementByMeasureID(long l)
 {
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from Measurements where MeasurementID = ").append(l).toString(), null);
     cursor.moveToFirst();
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurement() = cursor.getCount() = ").append(cursor.getCount()).toString());
     Measurement class108 = Measurement.getMeasurementfromDB(cursor);
     cursor.close();
     return class108;
 }

 public static CLASS109 getMeasurementMgnDataByStartID(long l, long l1, long l2, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementMgnDataByStartID() : getting from DB with id: ").append(l).append(", firstQueriedSampleID  = ").append(l1).append(", maxSamples = ").append(l2).toString());
     long l3 = (l1 + l2) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementMgnDataByStartID() : querying samples between firstQueriedSampleID : ").append(l1).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from MgnData where MeasurementID=").append(l).append(" and ").append("SampleID").append(" >= ").append(l1).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS29.getMgnDataFromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementMgnDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static CLASS370 getCalibrationByCalibrationSetID()
 {
     Cursor cursor = mDatabase.rawQuery("SELECT * from Calibration order by CalibrationSetID desc limit 1", null);
     cursor.moveToFirst();
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getLatestCalibrationSet() = cursor.getCount() = ").append(cursor.getCount()).toString());
     CLASS370 class370 = CLASS370.getCalibrationSetsfromDB(cursor);
     cursor.close();
     return class370;
 }

 private static File openFileForWriting(String s)
 {
     File file = new File(Environment.getExternalStorageDirectory(), "/dbfiles/");
     boolean flag = file.mkdirs();
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("openFileForWriting, created = ").append(flag).toString());
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" MeasurementDataSource.openFileForWriting: file path :").append(file.toString()).toString());
     if(file.canWrite())
     {
         return new File(file, s);
     } else
     {
         CLASS167.MF_CLASS167_b635("MeasurementDataSource", " MeasurementDataSource.openFileForWriting: canWrite = false, Could not open file for writing ");
         return null;
     }
 }

 public static List getMeasurementGyroData(long l, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementGyroData() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from GyroData where MeasurementID=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS26.getGyroDatafromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static void markMeasurementSent(Measurement class108)
 {
     long l;
     l = class108.mMeasurementID;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markMeasurementSent(): Measurement marked sent with id: ").append(l).toString());
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("MeasurementID", Long.valueOf(l));
	        contentvalues.put("SentToServer", Integer.valueOf(1));
	        contentvalues.put("SequenceIDBackend", class108.segmentID);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markMeasurementSent(): calling database.update()");
	        int i = mDatabase.update("Measurements", contentvalues, (new StringBuilder()).append("MeasurementID=").append(l).toString(), null);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markMeasurementSent(): noRowsAffected = ").append(i).toString());
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markMeasurementSent() calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return;
     }
 }

 public static void markCalibrationSetWrittenToFile(CLASS370 class370)
 {
     long l;
     l = class370.mMeasurementID;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markCalibrationSetWrittenToFile(): CalibrationSet marked written to file with id: ").append(l).toString());
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("CalibrationSetID", Long.valueOf(l));
	        contentvalues.put("WrittenToFile", Integer.valueOf(1));
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markCalibrationSetWrittenToFile(): calling database.update()");
	        int i = mDatabase.update("Calibration", contentvalues, (new StringBuilder()).append("CalibrationSetID=").append(l).toString(), null);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markCalibrationSetWrittenToFile(): noRowsAffected = ").append(i).toString());
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markCalibrationSetWrittenToFile() calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return;
     }
 }

 public static long[] storeMgnSensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeMgnSensorData(): calling database.beginTransaction");
     try {
	        mDatabase.beginTransaction();
	        al = new long[concurrentlinkedqueue.size()];
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeMgnSensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
	        if(flag) {
	            Iterator iterator1 = concurrentlinkedqueue.iterator();
	            int k = 0;
	            long l2;
	            for(;iterator1.hasNext();) {
	    	        CLASS22 class22_1 = (CLASS22)iterator1.next();
	    	        ContentValues contentvalues1 = new ContentValues();
	    	        contentvalues1.put("MeasurementID", Long.valueOf(l));
	    	        contentvalues1.put("MagnetometerTimestamp", Long.valueOf(class22_1.timeStamp));
	    	        contentvalues1.put("MagnetometerX", Float.valueOf(class22_1.AccelerometerX));
	    	        contentvalues1.put("MagnetometerY", Float.valueOf(class22_1.AccelerometerY));
	    	        contentvalues1.put("MagnetometerZ", Float.valueOf(class22_1.AccelerometerZ));
	    	        contentvalues1.put("MagnetometerAccuracy", Float.valueOf(class22_1.Accuracy));
	    	        contentvalues1.put("CalibrationData", Integer.valueOf(1));
	    	        l2 = mDatabase.insertOrThrow("MgnData", null, contentvalues1);
	    	        int i1 = k + 1;
	    	        al[k] = l2;
	    	        k = i1;
	            }
	        } else {
	
		        Iterator iterator = concurrentlinkedqueue.iterator();
		        int i = 0;
		
		        long l1;
		        for(;iterator.hasNext();) {
			        CLASS22 class22 = (CLASS22)iterator.next();
			        ContentValues contentvalues = new ContentValues();
			        contentvalues.put("MeasurementID", Long.valueOf(l));
			        contentvalues.put("MagnetometerTimestamp", Long.valueOf(class22.timeStamp));
			        contentvalues.put("MagnetometerX", Float.valueOf(class22.AccelerometerX));
			        contentvalues.put("MagnetometerY", Float.valueOf(class22.AccelerometerY));
			        contentvalues.put("MagnetometerZ", Float.valueOf(class22.AccelerometerZ));
			        contentvalues.put("MagnetometerAccuracy", Float.valueOf(class22.Accuracy));
			        contentvalues.put("CalibrationData", Integer.valueOf(0));
			        l1 = mDatabase.insertOrThrow("MgnData", null, contentvalues);
			        int j = i + 1;
			        al[i] = l1;
			        i = j;
		        }
	        }
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeMgnSensorData calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return al;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
     }
 }

 public static CLASS109 getMeasurementPressureDataByStartID(long l, long l1, long l2, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementPressureDataByStartID() : getting from DB with id: ").append(l).append(", firstQueriedSampleID  = ").append(l1).append(", maxSamples = ").append(l2).toString());
     long l3 = (l1 + l2) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementPressureDataByStartID() : querying samples between firstQueriedSampleID : ").append(l1).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from PressureData where MeasurementID=").append(l).append(" and ").append("SampleID").append(" >= ").append(l1).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS30.getPressureDatafromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementPressureDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static List getNotUploadedCalibrationSets()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery("SELECT * from Calibration where SentToServer = 0", null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getNotUploadedCalibrationSets() = cursor.getCount() = ").append(cursor.getCount()).toString());
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS370.getCalibrationSetsfromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List getMeasurementPressureData(long l, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementPressureData() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from PressureData where MeasurementID=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS30.getPressureDatafromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static void markMeasurementWrittenToFile(Measurement class108)
 {
     long l;
     l = class108.mMeasurementID;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markMeasurementWrittenToFile(): Measurement marked sent with id: ").append(l).toString());
     try {
	        mDatabase.beginTransaction();
	        ContentValues contentvalues = new ContentValues();
	        contentvalues.put("MeasurementID", Long.valueOf(l));
	        contentvalues.put("WrittenToFile", Integer.valueOf(1));
	        contentvalues.put("SequenceIDBackend", class108.segmentID);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markMeasurementWrittenToFile(): calling database.update()");
	        int i = mDatabase.update("Measurements", contentvalues, (new StringBuilder()).append("MeasurementID=").append(l).toString(), null);
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("markMeasurementWrittenToFile(): noRowsAffected = ").append(i).toString());
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "markMeasurementWrittenToFile() calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return;
     }
 }

 public static long[] storePressureSensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storePressureSensorData(): calling database.beginTransaction");
     
     try {
	        mDatabase.beginTransaction();
	        al = new long[concurrentlinkedqueue.size()];
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storePressureSensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
	        if(flag) 
	        {
		        Iterator iterator1 = concurrentlinkedqueue.iterator();
		        int k = 0;
		        long l2;
		        for(;iterator1.hasNext();) {
			        CLASS27 class27_1 = (CLASS27)iterator1.next();
			        ContentValues contentvalues1 = new ContentValues();
			        contentvalues1.put("MeasurementID", Long.valueOf(l));
			        contentvalues1.put("PressureTimestamp", Long.valueOf(class27_1.PressureTimestamp));
			        contentvalues1.put("Pressure", Float.valueOf(class27_1.Pressure));
			        contentvalues1.put("CalibrationData", Integer.valueOf(1));
			        l2 = mDatabase.insertOrThrow("PressureData", null, contentvalues1);
			        int i1 = k + 1;
			        al[k] = l2;
			        k = i1;
		        }
	        } else {
		        Iterator iterator = concurrentlinkedqueue.iterator();
		        int i = 0;
		        long l1;
		        for(;iterator.hasNext();) {
			        CLASS27 class27 = (CLASS27)iterator.next();
			        ContentValues contentvalues = new ContentValues();
			        contentvalues.put("MeasurementID", Long.valueOf(l));
			        contentvalues.put("PressureTimestamp", Long.valueOf(class27.PressureTimestamp));
			        contentvalues.put("Pressure", Float.valueOf(class27.Pressure));
			        contentvalues.put("CalibrationData", Integer.valueOf(0));
			        l1 = mDatabase.insertOrThrow("PressureData", null, contentvalues);
			        int j = i + 1;
			        al[i] = l1;
			        i = j;
		        }
	        }
	
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storePressureSensorData calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return al;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
     }
 }

 public static CLASS109 getMeasurementProximityDataByStartID(long l, long l1, long l2, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementProximityDataByStartID() : getting from DB with id: ").append(l).append(", firstQueriedSampleID  = ").append(l1).append(", maxSamples = ").append(l2).toString());
     long l3 = (l1 + l2) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementProximityDataByStartID() : querying samples between firstQueriedSampleID : ").append(l1).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from ProximityData where MeasurementID=").append(l).append(" and ").append("SampleID").append(" >= ").append(l1).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS31.getProximityDatafromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementProximityDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static Hashtable getAllFloorplans()
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "getAllFloorplans() called. ");
     Hashtable hashtable = new Hashtable();
     Cursor cursor = mDatabase.query("Floorplans", MeasurementsDB.MF_CLASS180_a671, null, null, null, null, null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getAllFloorplans() cursor.getCount() = ").append(cursor.getCount()).toString());
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         hashtable.put(cursor.getString(1), cursor.getString(2));

     cursor.close();
     return hashtable;
 }

 public static List getMeasurementLightData(long l, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementLightData() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from LightData where MeasurementID=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS28.getLightDatafromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static List getMeasurementWifiScans(Measurement class108)
 {
     long l = class108.mMeasurementID;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementWifiScans() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from Wifi where MeasurementID=").append(l).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS381.getWifiDataFromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static long[] storeLightSensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeLightSensorData(): calling database.beginTransaction");
     
     try {
     mDatabase.beginTransaction();
     al = new long[concurrentlinkedqueue.size()];
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeLightSensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
     if(flag) {
         Iterator iterator1 = concurrentlinkedqueue.iterator();
         int k = 0;
         long l2;
         for(;iterator1.hasNext();) {
 	        CLASS27 class27_1 = (CLASS27)iterator1.next();
 	        ContentValues contentvalues1 = new ContentValues();
 	        contentvalues1.put("MeasurementID", Long.valueOf(l));
 	        contentvalues1.put("LightTimestamp", Long.valueOf(class27_1.PressureTimestamp));
 	        contentvalues1.put("Light", Float.valueOf(class27_1.Pressure));
 	        contentvalues1.put("CalibrationData", Integer.valueOf(1));
 	        l2 = mDatabase.insertOrThrow("LightData", null, contentvalues1);
 	        int i1 = k + 1;
 	        al[k] = l2;
 	        k = i1;
         }
     	
     } else {

	        Iterator iterator = concurrentlinkedqueue.iterator();
	        int i = 0;
	        long l1;
	        for(;iterator.hasNext();) {
		        CLASS27 class27 = (CLASS27)iterator.next();
		        ContentValues contentvalues = new ContentValues();
		        contentvalues.put("MeasurementID", Long.valueOf(l));
		        contentvalues.put("LightTimestamp", Long.valueOf(class27.PressureTimestamp));
		        contentvalues.put("Light", Float.valueOf(class27.Pressure));
		        contentvalues.put("CalibrationData", Integer.valueOf(0));
		        l1 = mDatabase.insertOrThrow("LightData", null, contentvalues);
		        int j = i + 1;
		        al[i] = l1;
		        i = j;
	        }
     }


     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeLightSensorData calling database.setTransactionSuccessful()");
     mDatabase.setTransactionSuccessful();
     mDatabase.endTransaction();
     return al;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
     }
 }

 public static CLASS109 getMeasurementLightDataByStartID(long l, long l1, long l2, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementLightDataByStartID() : getting from DB with id: ").append(l).append(", firstQueriedSampleID  = ").append(l1).append(", maxSamples = ").append(l2).toString());
     long l3 = (l1 + l2) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementLightDataByStartID() : querying samples between firstQueriedSampleID : ").append(l1).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from LightData where MeasurementID=").append(l).append(" and ").append("SampleID").append(" >= ").append(l1).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS28.getLightDatafromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementLightDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static List getAllCalibrationSets()
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "getAllCalibrationSets() called. ");
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("Calibration", MeasurementsDB.MF_CLASS180_c673, null, null, null, null, null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getAllCalibrationSets() cursor.getCount() = ").append(cursor.getCount()).toString());
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS370.getCalibrationSetsfromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List getMeasurementProximityData(long l, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementProximityData() : getting from DB with id: ").append(l).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from ProximityData where MeasurementID=").append(l).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS31.getProximityDatafromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static long[] storeTemperatureSensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeTemperatureSensorData(): calling database.beginTransaction");
     try {
	        mDatabase.beginTransaction();
	        al = new long[concurrentlinkedqueue.size()];
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeTemperatureSensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
	        if(flag) {
	            Iterator iterator1 = concurrentlinkedqueue.iterator();
	            int k = 0;
	
	            long l2;
	            for(;iterator1.hasNext();) {
	    	        CLASS27 class27_1 = (CLASS27)iterator1.next();
	    	        ContentValues contentvalues1 = new ContentValues();
	    	        contentvalues1.put("MeasurementID", Long.valueOf(l));
	    	        contentvalues1.put("TemperatureTimestamp", Long.valueOf(class27_1.PressureTimestamp));
	    	        contentvalues1.put("Temperature", Float.valueOf(class27_1.Pressure));
	    	        contentvalues1.put("CalibrationData", Integer.valueOf(1));
	    	        l2 = mDatabase.insertOrThrow("TemperatureData", null, contentvalues1);
	    	        int i1 = k + 1;
	    	        al[k] = l2;
	    	        k = i1;
	            }
	        	
	        } else {
		        Iterator iterator = concurrentlinkedqueue.iterator();
		        int i = 0;
		        long l1;
		        for(;iterator.hasNext();) {
			        CLASS27 class27 = (CLASS27)iterator.next();
			        ContentValues contentvalues = new ContentValues();
			        contentvalues.put("MeasurementID", Long.valueOf(l));
			        contentvalues.put("TemperatureTimestamp", Long.valueOf(class27.PressureTimestamp));
			        contentvalues.put("Temperature", Float.valueOf(class27.Pressure));
			        contentvalues.put("CalibrationData", Integer.valueOf(0));
			        l1 = mDatabase.insertOrThrow("TemperatureData", null, contentvalues);
			        int j = i + 1;
			        al[i] = l1;
			        i = j;
		        }
	        }
	
	
	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeTemperatureSensorData calling database.setTransactionSuccessful()");
	        mDatabase.setTransactionSuccessful();
	        mDatabase.endTransaction();
	        return al;
	    } catch(Exception exception1) {
	        exception1.printStackTrace();;
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
	    }
 }

 public static CLASS109 getMeasurementTemperatureDataByStartID(long pMeasurementID, long pStartSampleID, long pMaxSamples, int pCalibrationData)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementTemperatureDataByStartID() : getting from DB with id: ").append(pMeasurementID).append(", firstQueriedSampleID  = ").append(pStartSampleID).append(", maxSamples = ").append(pMaxSamples).toString());
     long l3 = (pStartSampleID + pMaxSamples) - 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementTemperatureDataByStartID() : querying samples between firstQueriedSampleID : ").append(pStartSampleID).append(", lastQueriedSample = : ").append(l3).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from TemperatureData where MeasurementID=").append(pMeasurementID).append(" and ").append("SampleID").append(" >= ").append(pStartSampleID).append(" and ").append("SampleID").append(" <= ").append(l3).append(" and ").append("CalibrationData").append(" = ").append(pCalibrationData).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         arraylist.add(CLASS32.getTemperatureDataFromDB(cursor));
     }

     cursor.close();
     CLASS109 class109 = new CLASS109();
     class109.mData = arraylist;
     class109.mSampleID = l3 + 1L;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getMeasurementTemperatureDataByStartID() : returning with sensorData.size()  = ").append(arraylist.size()).toString());
     return class109;
 }

 public static List getAllBGCalibrations()
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "getAllBGCalibrations() called. ");
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("BGCalib", MeasurementsDB.MF_CLASS180_d674, null, null, null, null, null);
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getAllBGCalibrations() cursor.getCount() = ").append(cursor.getCount()).toString());
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS15.createBGCalibration(cursor));

     cursor.close();
     return arraylist;
 }

 public static List getMeasurementTemperatureData(long pMeasurementID, int i)
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append(" getMeasurementTemperatureData() : getting from DB with id: ").append(pMeasurementID).toString());
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.rawQuery((new StringBuilder()).append("SELECT * from TemperatureData where MeasurementID=").append(pMeasurementID).append(" and ").append("CalibrationData").append(" = ").append(i).toString(), null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         cursor.getLong(0);
         for(; !cursor.isAfterLast(); cursor.moveToNext())
             arraylist.add(CLASS32.getTemperatureDataFromDB(cursor));

     }

     cursor.close();
     return arraylist;
 }

 public static long[] storeProximitySensorData(ConcurrentLinkedQueue concurrentlinkedqueue, long l, boolean flag)
 {
     long al[] = null;
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeProximitySensorData(): calling database.beginTransaction");
     try {
     mDatabase.beginTransaction();
     al = new long[concurrentlinkedqueue.size()];
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeProximitySensorData(): going to store N samples, N =  ").append(concurrentlinkedqueue.size()).toString());
     if(flag) {
         Iterator iterator1 = concurrentlinkedqueue.iterator();
         int k = 0;
         long l2;
         for(;iterator1.hasNext();) {
 	        CLASS27 class27_1 = (CLASS27)iterator1.next();
 	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeProximitySensorData(): storing data to CalibrationSet id = ").append(l).append(" : ").append(class27_1.toString()).toString());
 	        ContentValues contentvalues1 = new ContentValues();
 	        contentvalues1.put("MeasurementID", Long.valueOf(l));
 	        contentvalues1.put("ProximityTimestamp", Long.valueOf(class27_1.PressureTimestamp));
 	        contentvalues1.put("Proximity", Float.valueOf(class27_1.Pressure));
 	        contentvalues1.put("CalibrationData", Integer.valueOf(1));
 	        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeProximitySensorData(): calling database.insertOrThrow(MySQLiteHelper.TABLE_ProximityData, null, values)");
 	        l2 = mDatabase.insertOrThrow("ProximityData", null, contentvalues1);
 	        int i1 = k + 1;
 	        al[k] = l2;
 	        k = i1;
         }
     } else {
	        Iterator iterator = concurrentlinkedqueue.iterator();
	        int i = 0;
	        long l1;
	        for(;iterator.hasNext();) {
		        CLASS27 class27 = (CLASS27)iterator.next();
		        CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("storeProximitySensorData(): storing data to measurement id = ").append(l).append(" : ").append(class27.toString()).toString());
		        ContentValues contentvalues = new ContentValues();
		        contentvalues.put("MeasurementID", Long.valueOf(l));
		        contentvalues.put("ProximityTimestamp", Long.valueOf(class27.PressureTimestamp));
		        contentvalues.put("Proximity", Float.valueOf(class27.Pressure));
		        contentvalues.put("CalibrationData", Integer.valueOf(0));
		        CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeProximitySensorData(): calling database.insertOrThrow(MySQLiteHelper.TABLE_ProximityData, null, values)");
		        l1 = mDatabase.insertOrThrow("ProximityData", null, contentvalues);
		        int j = i + 1;
		        al[i] = l1;
		        i = j;
	        }
     }

     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "storeProximitySensorData calling database.setTransactionSuccessful()");
     mDatabase.setTransactionSuccessful();
     mDatabase.endTransaction();
     return al;
     } catch(Exception exception1) {
	        exception1.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception1.printStackTrace();
	        mDatabase.endTransaction();
	        return al;
     }
 }

 public static List queryAccData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("AccData", MeasurementsDB.MF_CLASS180_f676, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS23.getAccDatafromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryGyroData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("GyroData", MeasurementsDB.MF_CLASS180_h678, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS26.getGyroDatafromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryMgnData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("MgnData", MeasurementsDB.MF_CLASS180_g677, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS29.getMgnDataFromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryPressureData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("PressureData", MeasurementsDB.MF_CLASS180_i679, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS30.getPressureDatafromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryProximityData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("ProximityData", MeasurementsDB.MF_CLASS180_k681, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS31.getProximityDatafromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryLightData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("LightData", MeasurementsDB.mLightColumns, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS28.getLightDatafromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryTemperatureData()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("TemperatureData", MeasurementsDB.mTemperatureColumns, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS32.getTemperatureDataFromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static List queryPoints()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("Points", MeasurementsDB.MF_CLASS180_e675, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
     {
         long l = cursor.getLong(0);
         CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("getAllMeasurementXYPoints() : XY points got from DB with id: ").append(l).toString());
         arraylist.add(CheckPoint.getCheckPointFromDB(cursor));
     }

     cursor.close();
     return arraylist;
 }

 public static List queryWifi()
 {
     ArrayList arraylist = new ArrayList();
     Cursor cursor = mDatabase.query("Wifi", MeasurementsDB.MF_CLASS180_m683, null, null, null, null, null);
     cursor.moveToFirst();
     for(; !cursor.isAfterLast(); cursor.moveToNext())
         arraylist.add(CLASS381.getWifiDataFromDB(cursor));

     cursor.close();
     return arraylist;
 }

 public static void reCreateTables()
 {
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 1");
     mDatabase.execSQL("DROP TABLE IF EXISTS AccData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 2");
     mDatabase.execSQL("DROP TABLE IF EXISTS GyroData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 3");
     mDatabase.execSQL("DROP TABLE IF EXISTS MgnData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 4");
     mDatabase.execSQL("DROP TABLE IF EXISTS PressureData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 5");
     mDatabase.execSQL("DROP TABLE IF EXISTS ProximityData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 6");
     mDatabase.execSQL("DROP TABLE IF EXISTS LightData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 7");
     mDatabase.execSQL("DROP TABLE IF EXISTS TemperatureData");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 8");
     mDatabase.execSQL("DROP TABLE IF EXISTS Wifi");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 9");
     mDatabase.execSQL("DROP TABLE IF EXISTS Measurements");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 10");
     mDatabase.execSQL("DROP TABLE IF EXISTS Points");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 11");
     mDatabase.execSQL("DROP TABLE IF EXISTS Calibration");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling drop table 12");
     mDatabase.execSQL("DROP TABLE IF EXISTS BGCalib");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 1");
     mDatabase.execSQL("create table AccData( SampleID integer primary key autoincrement, MeasurementID integer not null, AccelerometerTimestamp integer not null,AccelerometerX REAL not null,AccelerometerY REAL not null,AccelerometerZ REAL not null,CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 2");
     mDatabase.execSQL("create table GyroData( SampleID integer primary key autoincrement, MeasurementID integer not null, GyroscopeTimestamp integer not null,GyroscopeX REAL not null,GyroscopeY REAL not null,GyroscopeZ REAL not null,CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 3");
     mDatabase.execSQL("create table MgnData( SampleID integer primary key autoincrement, MeasurementID integer not null, MagnetometerTimestamp integer not null,MagnetometerX REAL not null,MagnetometerY REAL not null,MagnetometerZ REAL not null,MagnetometerAccuracy integer not null default 3,CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 4");
     mDatabase.execSQL("create table PressureData( SampleID integer primary key autoincrement, MeasurementID integer not null, PressureTimestamp integer not null,Pressure real not null, CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 5");
     mDatabase.execSQL("create table ProximityData( SampleID integer primary key autoincrement, MeasurementID integer not null, ProximityTimestamp integer not null,Proximity real not null, CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 6");
     mDatabase.execSQL("create table LightData( SampleID integer primary key autoincrement, MeasurementID integer not null, LightTimestamp integer not null,Light real not null,CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 7");
     mDatabase.execSQL("create table TemperatureData( SampleID integer primary key autoincrement, MeasurementID integer not null, TemperatureTimestamp integer not null,Temperature real not null, CalibrationData integer not null default 0);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 8");
     mDatabase.execSQL("create table Wifi( ID integer primary key autoincrement, MeasurementID integer not null, ScanNo integer not null, WifiScanTimestamp integer not null,SSID text not null,BSSID text not null,SignalStrength REAL not null);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 9");
     mDatabase.execSQL("create table Measurements( MeasurementID integer primary key autoincrement, BuildingID text not null,LevelID text not null,GraphicsID text not null,CoordinateSystem text not null,DeviceModelGuid text not null,UserID text not null,StartTimestamp integer not null,EndTimestamp integer not null,SentToServer INTEGER not null,WrittenToFile integer not null,SequenceIDBackend text not null,TestSegment INTEGER not null,Bezier INTEGER not null,Label text not null,IdaUid text not null);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 10");
     mDatabase.execSQL("create table Points( PointID integer primary key autoincrement, MeasurementID integer not null, X REAL not null,Y REAL not null,CheckPointTimestamp integer not null,CheckPointLabel text not null);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 11");
     mDatabase.execSQL("create table Calibration( CalibrationSetID integer primary key autoincrement, SentToServer integer not null,WrittenToFile integer not null,StartTimestampMS integer not null,EndTimestampMS integer not null,Latitude real not null,Longitude real not null,Altitude real not null);");
     CLASS167.MF_CLASS167_b635("MeasurementDataSource", "reCreateTables(): calling create table 12");
     mDatabase.execSQL("create table BGCalib( BGCalibID integer primary key autoincrement, BG_X REAL not null,BG_Y REAL not null,BG_Z REAL not null,BG_COV REAL not null,BGCalibTimestamp integer not null,CalibType integer not null);");
 }

 public static void createSysTables()
 {
     mDatabase.execSQL("DROP TABLE IF EXISTS Measurements");
     mDatabase.execSQL("DROP TABLE IF EXISTS AccData");
     mDatabase.execSQL("DROP TABLE IF EXISTS MgnData");
     mDatabase.execSQL("DROP TABLE IF EXISTS GyroData");
     mDatabase.execSQL("DROP TABLE IF EXISTS PressureData");
     mDatabase.execSQL("DROP TABLE IF EXISTS ProximityData");
     mDatabase.execSQL("DROP TABLE IF EXISTS LightData");
     mDatabase.execSQL("DROP TABLE IF EXISTS TemperatureData");
     mDatabase.execSQL("DROP TABLE IF EXISTS Wifi");
     mDatabase.execSQL("DROP TABLE IF EXISTS Points");
     mDatabase.execSQL("DROP TABLE IF EXISTS BGCalib");
     mDatabase.execSQL("DROP TABLE IF EXISTS Calibration");
     mDatabase.execSQL("DROP TABLE IF EXISTS Floorplans");
     mDatabase.execSQL("create table Measurements( MeasurementID integer primary key autoincrement, BuildingID text not null,LevelID text not null,GraphicsID text not null,CoordinateSystem text not null,DeviceModelGuid text not null,UserID text not null,StartTimestamp integer not null,EndTimestamp integer not null,SentToServer INTEGER not null,WrittenToFile integer not null,SequenceIDBackend text not null,TestSegment INTEGER not null,Bezier INTEGER not null,Label text not null,IdaUid text not null);");
     mDatabase.execSQL("create table AccData( SampleID integer primary key autoincrement, MeasurementID integer not null, AccelerometerTimestamp integer not null,AccelerometerX REAL not null,AccelerometerY REAL not null,AccelerometerZ REAL not null,CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table MgnData( SampleID integer primary key autoincrement, MeasurementID integer not null, MagnetometerTimestamp integer not null,MagnetometerX REAL not null,MagnetometerY REAL not null,MagnetometerZ REAL not null,MagnetometerAccuracy integer not null default 3,CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table GyroData( SampleID integer primary key autoincrement, MeasurementID integer not null, GyroscopeTimestamp integer not null,GyroscopeX REAL not null,GyroscopeY REAL not null,GyroscopeZ REAL not null,CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table PressureData( SampleID integer primary key autoincrement, MeasurementID integer not null, PressureTimestamp integer not null,Pressure real not null, CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table ProximityData( SampleID integer primary key autoincrement, MeasurementID integer not null, ProximityTimestamp integer not null,Proximity real not null, CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table LightData( SampleID integer primary key autoincrement, MeasurementID integer not null, LightTimestamp integer not null,Light real not null,CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table TemperatureData( SampleID integer primary key autoincrement, MeasurementID integer not null, TemperatureTimestamp integer not null,Temperature real not null, CalibrationData integer not null default 0);");
     mDatabase.execSQL("create table Wifi( ID integer primary key autoincrement, MeasurementID integer not null, ScanNo integer not null, WifiScanTimestamp integer not null,SSID text not null,BSSID text not null,SignalStrength REAL not null);");
     mDatabase.execSQL("create table Points( PointID integer primary key autoincrement, MeasurementID integer not null, X REAL not null,Y REAL not null,CheckPointTimestamp integer not null,CheckPointLabel text not null);");
     mDatabase.execSQL("create table BGCalib( BGCalibID integer primary key autoincrement, BG_X REAL not null,BG_Y REAL not null,BG_Z REAL not null,BG_COV REAL not null,BGCalibTimestamp integer not null,CalibType integer not null);");
     mDatabase.execSQL("create table Calibration( CalibrationSetID integer primary key autoincrement, SentToServer integer not null,WrittenToFile integer not null,StartTimestampMS integer not null,EndTimestampMS integer not null,Latitude real not null,Longitude real not null,Altitude real not null);");
     mDatabase.execSQL("create table Floorplans( FloorplanID integer primary key autoincrement, FloorplanURL text not null,FloorplanLocalFileName text not null);");
 }
 
 public static void dumpDatabaseToFile()
 {
     List list1;
     List list2;
     List list3;
     List list4;
     List list5;
     List list6;
     List list7;
     List list8;
     List list9;
     List list10;
     Hashtable hashtable;
     BufferedWriter bufferedwriter;
     List list = getAllMeasurements();
     list1 = getAllCalibrationSets();
     list2 = queryAccData();
     list3 = queryMgnData();
     list4 = queryGyroData();
     list5 = queryPressureData();
     list6 = queryProximityData();
     list7 = queryLightData();
     list8 = queryTemperatureData();
     list9 = queryWifi();
     list10 = queryPoints();
     hashtable = getAllFloorplans();

     try {
     bufferedwriter = createFileOutputStream(openFileForWriting("measurements_db.txt"));
     Iterator iterator = list.iterator();
     do
     {
         if(!iterator.hasNext())
             break;
         Measurement class108 = (Measurement)iterator.next();
         StringBuilder stringbuilder11 = new StringBuilder();
         try
         {
             bufferedwriter.write(stringbuilder11.append(class108.mMeasurementID).append(",").append(class108.bID).append(",").append(class108.lID).append(",").append(class108.gID).append(",").append(class108.coordSys).append(",").append(class108.mDeviceModel).append(",").append(class108.userId).append(",").append(class108.mStartTimestamp).append(",").append(class108.EndTimestamp).append(",").append(class108.mSentToServer).append(",").append(class108.segmentID).append(",").append(class108.TestSegment).append(",").append(class108.mBezier).append(",").append(class108.mLabel).append("\n").toString());            }
         catch(IOException ioexception23)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception23.printStackTrace();
         }
     } while(true);
     if(bufferedwriter == null) {
     	throw new Exception("disk full");
     }
     bufferedwriter.close();

     BufferedWriter bufferedwriter1;
     bufferedwriter1 = createFileOutputStream(openFileForWriting("calibrationset_db.txt"));
     Iterator iterator1 = list1.iterator();
     do
     {
         if(!iterator1.hasNext())
             break;
         CLASS370 class370 = (CLASS370)iterator1.next();
         StringBuilder stringbuilder10 = new StringBuilder();
         try
         {
             bufferedwriter1.write(stringbuilder10.append(class370.mMeasurementID).append(",").append(class370.StartTimestampMS).append(",").append(class370.EndTimestampMS).append(",").append(class370.Latitude).append(",").append(class370.Longitude).append(",").append(class370.Altitude).append(",").append(class370.SentToServer).append("\n").toString());
         }
         catch(IOException ioexception21)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception21.printStackTrace();
         }
     } while(true);
//     IOException ioexception22;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception22.printStackTrace();
     
     if(bufferedwriter1 == null)
     	throw new Exception("disk full");
     bufferedwriter1.close();

     BufferedWriter bufferedwriter2;
     bufferedwriter2 = createFileOutputStream(openFileForWriting("acc_data_db.txt"));
     Iterator iterator2 = list2.iterator();
     do
     {
         if(!iterator2.hasNext())
             break;
         CLASS23 class23 = (CLASS23)iterator2.next();
         StringBuilder stringbuilder9 = new StringBuilder();
         try
         {
             bufferedwriter2.write(stringbuilder9.append(class23.MF_CLASS23_a79).append(",").append(class23.MF_CLASS23_b80).append(",").append(class23.timeStamp).append(",").append(class23.AccelerometerX).append(",").append(class23.AccelerometerY).append(",").append(class23.AccelerometerZ).append(",").append(class23.MF_CLASS23_c81).append("\n").toString());
         }
         catch(IOException ioexception19)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception19.printStackTrace();
         }
     } while(true);
//     IOException ioexception20;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception20.printStackTrace();

     if(bufferedwriter2 == null)
     	throw new Exception("disk full");
     bufferedwriter2.close();

     BufferedWriter bufferedwriter3;
     bufferedwriter3 = createFileOutputStream(openFileForWriting("gyro_data_db.txt"));
     Iterator iterator3 = list4.iterator();
     do
     {
         if(!iterator3.hasNext())
             break;
         CLASS26 class26 = (CLASS26)iterator3.next();
         StringBuilder stringbuilder8 = new StringBuilder();
         try
         {
             bufferedwriter3.write(stringbuilder8.append(class26.MF_CLASS26_a100).append(",").append(class26.MF_CLASS26_b101).append(",").append(class26.timeStamp).append(",").append(class26.AccelerometerX).append(",").append(class26.AccelerometerY).append(",").append(class26.AccelerometerZ).append(",").append(class26.MF_CLASS26_c102).append("\n").toString());
         }
         catch(IOException ioexception17)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception17.printStackTrace();
         }
     } while(true);
//     IOException ioexception18;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception18.printStackTrace();
     
     if(bufferedwriter3 == null)
     	throw new Exception("disk full");
     bufferedwriter3.close();

     BufferedWriter bufferedwriter4;
     bufferedwriter4 = createFileOutputStream(openFileForWriting("mgn_data_db.txt"));
     Iterator iterator4 = list3.iterator();
     do
     {
         if(!iterator4.hasNext())
             break;
         CLASS29 class29 = (CLASS29)iterator4.next();
         StringBuilder stringbuilder7 = new StringBuilder();
         try
         {
             bufferedwriter4.write(stringbuilder7.append(class29.MF_CLASS29_a114).append(",").append(class29.MF_CLASS29_b115).append(",").append(class29.timeStamp).append(",").append(class29.AccelerometerX).append(",").append(class29.AccelerometerY).append(",").append(class29.AccelerometerZ).append(",").append(class29.MF_CLASS29_c116).append("\n").toString());
         }
         catch(IOException ioexception15)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception15.printStackTrace();
         }
     } while(true);

//     IOException ioexception16;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception16.printStackTrace();
     
     if(bufferedwriter4 == null)
     	throw new Exception("disk full");
     bufferedwriter4.close();
     
     BufferedWriter bufferedwriter5;
     bufferedwriter5 = createFileOutputStream(openFileForWriting("pressure_data_db.txt"));
     Iterator iterator5 = list5.iterator();
     do
     {
         if(!iterator5.hasNext())
             break;
         CLASS30 class30 = (CLASS30)iterator5.next();
         StringBuilder stringbuilder6 = new StringBuilder();
         try
         {
             bufferedwriter5.write(stringbuilder6.append(class30.MF_CLASS30_a122).append(",").append(class30.MF_CLASS30_b123).append(",").append(class30.PressureTimestamp).append(",").append(class30.Pressure).append(",").append(class30.MF_CLASS30_c124).append("\n").toString());
         }
         catch(IOException ioexception13)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception13.printStackTrace();
         }
     } while(true);
//     IOException ioexception14;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception14.printStackTrace();
     
     if(bufferedwriter5 == null)
     	throw new Exception("disk full");
     bufferedwriter5.close();

     BufferedWriter bufferedwriter6;
     bufferedwriter6 = createFileOutputStream(openFileForWriting("proximity_data_db.txt"));
     Iterator iterator6 = list6.iterator();
     do
     {
         if(!iterator6.hasNext())
             break;
         CLASS31 class31 = (CLASS31)iterator6.next();
         StringBuilder stringbuilder5 = new StringBuilder();
         try
         {
             bufferedwriter6.write(stringbuilder5.append(class31.MF_CLASS31_a127).append(",").append(class31.MF_CLASS31_b128).append(",").append(class31.PressureTimestamp).append(",").append(class31.Pressure).append(",").append(class31.MF_CLASS31_c129).append("\n").toString());
         }
         catch(IOException ioexception11)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception11.printStackTrace();
         }
     } while(true);
//     IOException ioexception12;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception12.printStackTrace();

     if(bufferedwriter6 == null)
     	throw new Exception("disk full");
     bufferedwriter6.close();

     BufferedWriter bufferedwriter7;
     bufferedwriter7 = createFileOutputStream(openFileForWriting("light_data_db.txt"));
     Iterator iterator7 = list7.iterator();
     do
     {
         if(!iterator7.hasNext())
             break;
         CLASS28 class28 = (CLASS28)iterator7.next();
         StringBuilder stringbuilder4 = new StringBuilder();
         try
         {
             CLASS167.MF_CLASS167_b635("MeasurementDataSource", (new StringBuilder()).append("dumpDatabaseToFile: light: reshol.timestamp = ").append(class28.PressureTimestamp).append(", reshol.light = ").append(class28.Pressure).toString());
             bufferedwriter7.write(stringbuilder4.append(class28.MF_CLASS28_a109).append(",").append(class28.MF_CLASS28_b110).append(",").append(class28.PressureTimestamp).append(",").append(class28.Pressure).append(",").append(class28.MF_CLASS28_c111).append("\n").toString());
         }
         catch(IOException ioexception9)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception9.printStackTrace();
         }
     } while(true);

//     IOException ioexception10;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception10.printStackTrace();

     if(bufferedwriter7 == null)
     	throw new Exception("disk full");
     bufferedwriter7.close();

     BufferedWriter bufferedwriter8;
     bufferedwriter8 = createFileOutputStream(openFileForWriting("temperature_data_db.txt"));
     Iterator iterator8 = list8.iterator();
     do
     {
         if(!iterator8.hasNext())
             break;
         CLASS32 class32 = (CLASS32)iterator8.next();
         StringBuilder stringbuilder3 = new StringBuilder();
         try
         {
             bufferedwriter8.write(stringbuilder3.append(class32.MF_CLASS32_a132).append(",").append(class32.MF_CLASS32_b133).append(",").append(class32.PressureTimestamp).append(",").append(class32.Pressure).append(",").append(class32.MF_CLASS32_c134).append("\n").toString());
         }
         catch(IOException ioexception7)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception7.printStackTrace();
         }
     } while(true);
//     IOException ioexception8;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception8.printStackTrace();

     if(bufferedwriter8 == null)
     	throw new Exception("disk full");
     bufferedwriter8.close();

     BufferedWriter bufferedwriter9;
     bufferedwriter9 = createFileOutputStream(openFileForWriting("wifi_db.txt"));
     Iterator iterator9 = list9.iterator();
     do
     {
         if(!iterator9.hasNext())
             break;
         CLASS381 class381 = (CLASS381)iterator9.next();
         StringBuilder stringbuilder2 = new StringBuilder();
         try
         {
             bufferedwriter9.write(stringbuilder2.append(class381.MF_CLASS381_a1107).append(",").append(class381.MF_CLASS381_b1108).append(",").append(class381.ScanNo).append(",").append(class381.mScanTimeStamp).append(",").append(class381.mSsid).append(",").append(class381.BSSID).append(",").append(class381.SignalStrength).append("\n").toString());
         }
         catch(IOException ioexception5)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception5.printStackTrace();
         }
     } while(true);
//     IOException ioexception6;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception6.printStackTrace();

     if(bufferedwriter9 == null)
     	throw new Exception("disk full");
     bufferedwriter9.close();

     BufferedWriter bufferedwriter10;
     bufferedwriter10 = createFileOutputStream(openFileForWriting("xypoints_db.txt"));
     Iterator iterator10 = list10.iterator();
     do
     {
         if(!iterator10.hasNext())
             break;
         CheckPoint class112 = (CheckPoint)iterator10.next();
         StringBuilder stringbuilder1 = new StringBuilder();
         try
         {
             bufferedwriter10.write(stringbuilder1.append(class112.MF_CLASS112_a480).append(",").append(class112.MF_CLASS112_b481).append(",").append(class112.coordX).append(",").append(class112.coordY).append(",").append(class112.CheckPointTimestamp).append(",").append(class112.MF_CLASS112_e484).append("\n").toString());
         }
         catch(IOException ioexception3)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception3.printStackTrace();
         }
     } while(true);
//     IOException ioexception4;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception4.printStackTrace();
     if(bufferedwriter10 == null)
     	throw new Exception("disk full");
     
     bufferedwriter10.close();
     BufferedWriter bufferedwriter11;
     bufferedwriter11 = createFileOutputStream(openFileForWriting("floorplans_db.txt"));
     Iterator iterator11 = hashtable.keySet().iterator();
     do
     {
         if(!iterator11.hasNext())
             break;
         String s = (String)iterator11.next();
         String s1 = (String)hashtable.get(s);
         StringBuilder stringbuilder = new StringBuilder();
         try
         {
             bufferedwriter11.write(stringbuilder.append(s).append(",").append(s1).append("\n").toString());
         }
         catch(IOException ioexception1)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 ioexception1.printStackTrace();
         }
     } while(true);
//     IOException ioexception2;
//     if(CLASS113.isExceptionLogged.booleanValue())
//         ioexception2.printStackTrace();

     if(bufferedwriter11 == null)
     	throw new Exception("disk full");
     bufferedwriter11.close();
     return;
     
     } catch(Exception ioexception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            ioexception.printStackTrace();
	            return;
	        }
     }
 }

 public static boolean MF_CLASS381_a1107 = false;
 private static SQLiteDatabase mDatabase;
 private static MeasurementsDB mMeasurementsDB;

}
