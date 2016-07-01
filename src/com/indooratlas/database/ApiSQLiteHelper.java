package com.indooratlas.database;

//CLASS34

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.indooratlas.position.CLASS75;

public class ApiSQLiteHelper extends SQLiteOpenHelper
{

 public ApiSQLiteHelper(Context context)
 {
     super(context, "api.db", null, 2);
 }

 private SQLiteDatabase upgradeFrom1To2(SQLiteDatabase sqlitedatabase) 
 {
     
 	try {
	    	sqlitedatabase.beginTransaction();
	        CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", (new StringBuilder()).append("upgradeFrom1To2(): upgradeFrom1To2 A running ").append("create table Timestamp( TimestampFormat integer unique);").toString());
	        sqlitedatabase.execSQL("create table Timestamp( TimestampFormat integer unique);");
	        sqlitedatabase.execSQL("DROP TABLE IF EXISTS Calib");
	        sqlitedatabase.execSQL("create table Calib( CalibID integer primary key autoincrement, X REAL not null,Y REAL not null,Z REAL not null,COV REAL not null,CalibTimestamp integer not null,CalibType integer not null);");
	        sqlitedatabase.setTransactionSuccessful();
	        CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", "upgradeFrom1To2 done.");
	        sqlitedatabase.endTransaction();
	        return sqlitedatabase;
 	} catch(Exception exception1) {
	        exception1.printStackTrace();
	        CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", "upgradeFrom1To2 failed");
	        CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", "upgradeFrom1To2 done.");
	        sqlitedatabase.endTransaction();
	        return sqlitedatabase;
 	}
 }

 public void onCreate(SQLiteDatabase sqlitedatabase)
 {
     CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", "onCreate(): called.");
     sqlitedatabase.execSQL("create table Calib( CalibID integer primary key autoincrement, X REAL not null,Y REAL not null,Z REAL not null,COV REAL not null,CalibTimestamp integer not null,CalibType integer not null);");
     sqlitedatabase.execSQL("create table Timestamp( TimestampFormat integer unique);");
     CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", "onCreate(): done.");
 }

 public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
 {
     if(i < j && i == 1)
     {
         SQLiteDatabase sqlitedatabase1 = upgradeFrom1To2(sqlitedatabase);
         CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", (new StringBuilder()).append("onUpgrade(): Old Version ").append(i).append(" New Version ").append(j).append(" db.getVersion is ").append(sqlitedatabase1.getVersion()).toString());
     }
     CLASS75.MF_CLASS75_b260("ApiSQLiteHelper", "onUpgrade(): done.");
 }

 public static final String MF_CLASS34_a140[] = {
     "CalibID", "X", "Y", "Z", "COV", "CalibTimestamp"
 };

}
