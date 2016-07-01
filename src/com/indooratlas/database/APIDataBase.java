package com.indooratlas.database;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.indooratlas.Calibrator.CLASS15;
import com.indooratlas.Calibrator.CLASS17;
import com.indooratlas.position.CLASS75;

//Referenced classes of package com.indooratlas.database:
//         CLASS34

public class APIDataBase
{

 public static CLASS15 selectBGCalibrationFromDB()
 {
     Cursor cursor = MF_CLASS33_b138.rawQuery("SELECT * from Calib order by CalibID desc limit 1", null);
     cursor.moveToFirst();
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("getLatestBGCalibration() = cursor.getCount() = ").append(cursor.getCount()).toString());
     int i = cursor.getCount();
     CLASS15 class15 = null;
     if(i > 0)
         class15 = CLASS15.createBGCalibration(cursor);
     cursor.close();
     return class15;
 }

 public static CLASS15 storeBGCalibration(CLASS15 class15) throws Exception
 {
     CLASS75.MF_CLASS75_b260("APIDataBase", "storeBGCalibration(): calling database.beginTransaction");
     try {
	        MF_CLASS33_b138.beginTransaction();
	        try
	        {
	            ContentValues contentvalues = new ContentValues();
	            contentvalues.put("X", Double.valueOf(class15.MF_CLASS16_b54()[0]));
	            contentvalues.put("Y", Double.valueOf(class15.MF_CLASS16_b54()[1]));
	            contentvalues.put("Z", Double.valueOf(class15.MF_CLASS16_b54()[2]));
	            contentvalues.put("COV", Double.valueOf(class15.MF_CLASS16_c55()));
	            contentvalues.put("CalibTimestamp", Long.valueOf(class15.MF_CLASS15_f50()));
	            contentvalues.put("CalibType", Integer.valueOf(class15.MF_CLASS15_h52().ordinal()));
	            CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("storeBGCalibration(): calling database.insertOrThrow(), bgCalibration=").append(class15.toString()).toString());
	            class15.MF_CLASS17_a58(MF_CLASS33_b138.insertOrThrow("Calib", null, contentvalues));
	            CLASS75.MF_CLASS75_b260("APIDataBase", "storeBGCalibration calling database.setTransactionSuccessful()");
	            MF_CLASS33_b138.setTransactionSuccessful();
	        }
	        catch(Exception exception1)
	        {
	            MF_CLASS33_b138.endTransaction();
	            return class15;
	        }
	        MF_CLASS33_b138.endTransaction();
	        return class15;
     } catch(Exception exception) {
	        exception.printStackTrace();
	        MF_CLASS33_b138.endTransaction();
	        throw exception;
     }
 }

 public static void MF_CLASS33_a137(Context context)
 {
     MF_CLASS33_a137 = true;
     MF_CLASS33_c139 = new ApiSQLiteHelper(context);
     MF_CLASS33_b138 = MF_CLASS33_c139.getWritableDatabase();
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("APIDataBase.open(): open db version = ").append(MF_CLASS33_b138.getVersion()).toString());
 }

 public static void MF_CLASS33_a137(boolean flag) throws Exception
 {
     int i;
     i = 0;
     if(flag)
         i = 1;
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("setUseSystemTimestamps(): calling database.beginTransaction with use = ").append(flag).toString());
     
     MF_CLASS33_b138.beginTransaction();
     try
     {
         ContentValues contentvalues = new ContentValues();
         contentvalues.put("TimestampFormat", Integer.valueOf(i));
         MF_CLASS33_b138.insertOrThrow("Timestamp", null, contentvalues);
         CLASS75.MF_CLASS75_b260("APIDataBase", "setUseSystemTimestamps calling database.setTransactionSuccessful()");
         MF_CLASS33_b138.setTransactionSuccessful();
     }
     catch(Exception exception1)
     {
         MF_CLASS33_b138.endTransaction();
         return;
     }
     MF_CLASS33_b138.endTransaction();
     return;
 }

 public static void MF_CLASS33_b138(CLASS15 class15)
 {
     long l = class15.MF_CLASS15_e49();
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("deleteCalibration with id: ").append(l).toString());
     int i = MF_CLASS33_b138.delete("Calib", (new StringBuilder()).append("CalibID = ").append(l).toString(), null);
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("deleteCalibration with id: ").append(l).append(", deletedRows = ").append(i).toString());
 }

 public static boolean MF_CLASS33_b138()
 {
     Cursor cursor = MF_CLASS33_b138.query("Timestamp", new String[] {
         "TimestampFormat"
     }, null, null, null, null, null, null);
     if(cursor != null)
         cursor.moveToFirst();
     int i;
     if(cursor.getCount() > 0)
         i = cursor.getInt(0);
     else
         i = 0;
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("isUseSystemTimestamps(), use = ").append(i).append(", cursor.getCount() == ").append(cursor.getCount()).toString());
     return i != 0;
 }

 public static boolean MF_CLASS33_c139()
 {
     Cursor cursor = MF_CLASS33_b138.query("Timestamp", new String[] {
         "TimestampFormat"
     }, null, null, null, null, null, null);
     if(cursor != null)
         cursor.moveToFirst();
     int i;
     if(cursor.getCount() > 0)
         i = 1;
     else
         i = 0;
     CLASS75.MF_CLASS75_b260("APIDataBase", (new StringBuilder()).append("isUseSystemTimestampsCheckdone(), done = ").append(i).append(", cursor.getCount() == ").append(cursor.getCount()).toString());
     return i == 1;
 }

 public static boolean MF_CLASS33_a137 = false;
 private static SQLiteDatabase MF_CLASS33_b138;
 private static ApiSQLiteHelper MF_CLASS33_c139;

}
