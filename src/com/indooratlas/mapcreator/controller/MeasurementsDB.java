package com.indooratlas.mapcreator.controller;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Referenced classes of package com.indooratlas.mapcreator.controller:
//         CLASS167

public class MeasurementsDB extends SQLiteOpenHelper
{

 public MeasurementsDB(Context context)
 {
     //super(context, "measurements.db", null, 2);
     super(context, "/storage/emulated/0/database/measurements.db", null, 2);
     				 
 }

 private SQLiteDatabase MF_CLASS180_a671(SQLiteDatabase sqlitedatabase)
 {
     try {
	    	sqlitedatabase.beginTransaction();
	        CLASS167.MF_CLASS167_b635("MySQLiteHelper", (new StringBuilder()).append("upgradeFrom1To2(): upgradeFrom1To2 A running ").append("create table BGCalib( BGCalibID integer primary key autoincrement, BG_X REAL not null,BG_Y REAL not null,BG_Z REAL not null,BG_COV REAL not null,BGCalibTimestamp integer not null,CalibType integer not null);").toString());
	        sqlitedatabase.execSQL("create table BGCalib( BGCalibID integer primary key autoincrement, BG_X REAL not null,BG_Y REAL not null,BG_Z REAL not null,BG_COV REAL not null,BGCalibTimestamp integer not null,CalibType integer not null);");
	        sqlitedatabase.setTransactionSuccessful();
	        CLASS167.MF_CLASS167_b635("MySQLiteHelper", "upgradeFrom1To2 done.");
	        sqlitedatabase.endTransaction();
	        return sqlitedatabase;
     } catch(Exception exception1) {
     	exception1.printStackTrace();
     	CLASS167.MF_CLASS167_b635("MySQLiteHelper", "upgradeFrom1To2 failed");
     	CLASS167.MF_CLASS167_b635("MySQLiteHelper", "upgradeFrom1To2 done.");
     	sqlitedatabase.endTransaction();
     	return sqlitedatabase;
     }
 }

 public void onCreate(SQLiteDatabase sqlitedatabase)
 {
     sqlitedatabase.execSQL("create table Measurements( MeasurementID integer primary key autoincrement, BuildingID text not null,LevelID text not null,GraphicsID text not null,CoordinateSystem text not null,DeviceModelGuid text not null,UserID text not null,StartTimestamp integer not null,EndTimestamp integer not null,SentToServer INTEGER not null,WrittenToFile integer not null,SequenceIDBackend text not null,TestSegment INTEGER not null,Bezier INTEGER not null,Label text not null,IdaUid text not null);");
     sqlitedatabase.execSQL("create table AccData( SampleID integer primary key autoincrement, MeasurementID integer not null, AccelerometerTimestamp integer not null,AccelerometerX REAL not null,AccelerometerY REAL not null,AccelerometerZ REAL not null,CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table MgnData( SampleID integer primary key autoincrement, MeasurementID integer not null, MagnetometerTimestamp integer not null,MagnetometerX REAL not null,MagnetometerY REAL not null,MagnetometerZ REAL not null,MagnetometerAccuracy integer not null default 3,CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table GyroData( SampleID integer primary key autoincrement, MeasurementID integer not null, GyroscopeTimestamp integer not null,GyroscopeX REAL not null,GyroscopeY REAL not null,GyroscopeZ REAL not null,CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table PressureData( SampleID integer primary key autoincrement, MeasurementID integer not null, PressureTimestamp integer not null,Pressure real not null, CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table ProximityData( SampleID integer primary key autoincrement, MeasurementID integer not null, ProximityTimestamp integer not null,Proximity real not null, CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table LightData( SampleID integer primary key autoincrement, MeasurementID integer not null, LightTimestamp integer not null,Light real not null,CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table TemperatureData( SampleID integer primary key autoincrement, MeasurementID integer not null, TemperatureTimestamp integer not null,Temperature real not null, CalibrationData integer not null default 0);");
     sqlitedatabase.execSQL("create table Wifi( ID integer primary key autoincrement, MeasurementID integer not null, ScanNo integer not null, WifiScanTimestamp integer not null,SSID text not null,BSSID text not null,SignalStrength REAL not null);");
     sqlitedatabase.execSQL("create table Points( PointID integer primary key autoincrement, MeasurementID integer not null, X REAL not null,Y REAL not null,CheckPointTimestamp integer not null,CheckPointLabel text not null);");
     sqlitedatabase.execSQL("create table BGCalib( BGCalibID integer primary key autoincrement, BG_X REAL not null,BG_Y REAL not null,BG_Z REAL not null,BG_COV REAL not null,BGCalibTimestamp integer not null,CalibType integer not null);");
     sqlitedatabase.execSQL("create table Calibration( CalibrationSetID integer primary key autoincrement, SentToServer integer not null,WrittenToFile integer not null,StartTimestampMS integer not null,EndTimestampMS integer not null,Latitude real not null,Longitude real not null,Altitude real not null);");
     sqlitedatabase.execSQL("create table Floorplans( FloorplanID integer primary key autoincrement, FloorplanURL text not null,FloorplanLocalFileName text not null);");
 }

 public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
 {
     if(i < j && i == 1)
     {
         SQLiteDatabase sqlitedatabase1 = MF_CLASS180_a671(sqlitedatabase);
         CLASS167.MF_CLASS167_b635("MySQLiteHelper", (new StringBuilder()).append("onUpgrade(): Old Version ").append(i).append(" New Version ").append(j).append(" db.getVersion is ").append(sqlitedatabase1.getVersion()).toString());
     }
     CLASS167.MF_CLASS167_b635("MySQLiteHelper", "onUpgrade(): done.");
 }

 public static final String MF_CLASS180_a671[] = {
     "FloorplanID", "FloorplanID", "FloorplanURL", "FloorplanLocalFileName"
 };
 public static final String MF_CLASS180_b672[] = {
     "MeasurementID", "BuildingID", "LevelID", "GraphicsID", "CoordinateSystem", "DeviceModelGuid", "IdaUid", "StartTimestamp", "EndTimestamp", "SentToServer",
     "SequenceIDBackend", "TestSegment", "Bezier", "Label", "UserID"
 };
 public static final String MF_CLASS180_c673[] = {
     "CalibrationSetID", "SentToServer", "WrittenToFile", "StartTimestampMS", "EndTimestampMS", "Latitude", "Longitude", "Altitude"
 };
 public static final String MF_CLASS180_d674[] = {
     "BGCalibID", "BG_X", "BG_Y", "BG_Z", "BG_COV", "BGCalibTimestamp", "CalibType"
 };
 public static final String MF_CLASS180_e675[] = {
     "PointID", "MeasurementID", "X", "Y", "CheckPointTimestamp", "CheckPointLabel"
 };
 public static final String MF_CLASS180_f676[] = {
     "SampleID", "MeasurementID", "AccelerometerTimestamp", "AccelerometerX", "AccelerometerY", "AccelerometerZ", "CalibrationData"
 };
 public static final String MF_CLASS180_g677[] = {
     "SampleID", "MeasurementID", "MagnetometerTimestamp", "MagnetometerX", "MagnetometerY", "MagnetometerZ", "MagnetometerAccuracy", "CalibrationData"
 };
 public static final String MF_CLASS180_h678[] = {
     "SampleID", "MeasurementID", "GyroscopeTimestamp", "GyroscopeX", "GyroscopeY", "GyroscopeZ", "CalibrationData"
 };
 public static final String MF_CLASS180_i679[] = {
     "SampleID", "MeasurementID", "PressureTimestamp", "Pressure", "CalibrationData"
 };
 public static final String mLightColumns[] = {
     "SampleID", "MeasurementID", "LightTimestamp", "Light", "CalibrationData"
 };
 public static final String MF_CLASS180_k681[] = {
     "SampleID", "MeasurementID", "ProximityTimestamp", "Proximity", "CalibrationData"
 };
 public static final String mTemperatureColumns[] = {
     "SampleID", "MeasurementID", "TemperatureTimestamp", "Temperature", "CalibrationData"
 };
 public static final String MF_CLASS180_m683[] = {
     "ID", "MeasurementID", "ScanNo", "WifiScanTimestamp", "SSID", "BSSID", "SignalStrength"
 };

}
