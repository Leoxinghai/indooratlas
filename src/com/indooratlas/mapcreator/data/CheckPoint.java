package com.indooratlas.mapcreator.data;



import android.database.Cursor;

public class CheckPoint
{

 public CheckPoint()
 {
     MF_CLASS112_a480 = 0L;
     MF_CLASS112_b481 = 0L;
     coordX = 0.0F;
     coordY = 0.0F;
     MF_CLASS112_e484 = "";
     CheckPointTimestamp = 0L;
 }

 public CheckPoint(float f, float f1)
 {
     MF_CLASS112_a480 = 0L;
     MF_CLASS112_b481 = 0L;
     MF_CLASS112_e484 = "";
     CheckPointTimestamp = 0L;
     coordX = f;
     coordY = f1;
 }

 public static CheckPoint getCheckPointFromDB(Cursor cursor)
 {
	 CheckPoint class112 = new CheckPoint();
     class112.MF_CLASS112_a480 = cursor.getLong(0);
     class112.MF_CLASS112_b481 = cursor.getLong(1);
     class112.coordX = cursor.getFloat(2);
     class112.coordY = cursor.getFloat(3);
     class112.CheckPointTimestamp = cursor.getLong(4);
     class112.MF_CLASS112_e484 = cursor.getString(5);
     return class112;
 }

 public String toString()
 {
     return (new StringBuilder()).append("(").append(coordX).append(",").append(coordY).append(")").toString();
 }

 public long MF_CLASS112_a480;
 public long MF_CLASS112_b481;
 public float coordX;
 public float coordY;
 public String MF_CLASS112_e484;
 public long CheckPointTimestamp;
}
