package com.indooratlas.mapcreator.data;


import android.database.Cursor;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.MeasurementDataSource;
import java.util.*;

//Referenced classes of package com.indooratlas.mapcreator.data:
//         CheckPoint

public class Measurement
{

 public Measurement()
 {
 	 mMeasurementID = 0L;
 	 bID = "none";
 	 lID = "none";
     gID = "none";
     coordSys = "none";
     mDeviceModel = "0";
     userId = "none";
     mIdaUuid = "none";
     mStartTimestamp = 0L;
     EndTimestamp = 0L;
     mPoints = new ArrayList();
     mSentToServer = 0L;
     mWrittenToFile = 0L;
     segmentID = "none";
     TestSegment = 0;
     mBezier = 0;
     mLabel = "Normal";
     MF_CLASS108_r464 = false;
 }

 public static Measurement getMeasurementfromDB(Cursor cursor)
 {
     Measurement class108 = new Measurement();
     class108.mMeasurementID = cursor.getLong(0);
     class108.bID = cursor.getString(1);
     class108.lID = cursor.getString(2);
     class108.gID = cursor.getString(3);
     class108.coordSys = cursor.getString(4);
     class108.mDeviceModel = cursor.getString(5);
     class108.userId = cursor.getString(6);
     class108.mStartTimestamp = cursor.getLong(7);
     class108.EndTimestamp = cursor.getLong(8);
     class108.mSentToServer = cursor.getLong(9);
     class108.mWrittenToFile = cursor.getLong(10);
     class108.segmentID = cursor.getString(11);
     class108.TestSegment = cursor.getInt(12);
     class108.mBezier = cursor.getInt(13);
     class108.mLabel = cursor.getString(14);
     class108.mIdaUuid = cursor.getString(15);
     class108.mPoints = MeasurementDataSource.getAllPointsByMeasurementID(class108.mMeasurementID);
     class108.MF_CLASS108_r464 = false;
     return class108;
 }

 public static Measurement MF_CLASS108_a447(com.indooratlas.communication.be.Sequence sequence)
 {
     Measurement class108 = new Measurement();
     class108.MF_CLASS108_r464 = true;
     class108.mMeasurementID = -1L;
     class108.bID = "";
     class108.lID = "";
     class108.gID = sequence.getGraphicsLink().getId();
     class108.coordSys = sequence.getCoordinateSystem();
     class108.mDeviceModel = sequence.getDeviceModel().getId();
     class108.userId = sequence.getUserId().getId();
     class108.mStartTimestamp = sequence.getStartTime();
     class108.EndTimestamp = sequence.getEndTime();
     class108.mSentToServer = 1L;
     class108.mWrittenToFile = 0L;
     class108.segmentID = sequence.getId();
     class108.TestSegment = sequence.getSequenceType();
     class108.mBezier = 0;
     class108.mLabel = sequence.getLabel();
     class108.mIdaUuid = sequence.getIdaUuid();
     ArrayList arraylist = new ArrayList();
     CLASS167.MF_CLASS167_b635("Measurement", (new StringBuilder()).append("protoBufferSequenceToMeasurement: starting to convert points, sequence.getPointsList().size = ").append(sequence.getPointsList().size()).toString());
     class108.mPoints = arraylist;
     return class108;
 }

 public String MF_CLASS108_a447()
 {
     Iterator iterator = mPoints.iterator();
     String s;
     CheckPoint class112;
     for(s = ""; iterator.hasNext(); s = (new StringBuilder()).append(s).append("; ").append("(").append(class112.coordX).append(",").append(class112.coordY).append(")").append(", ").append(class112.CheckPointTimestamp).append(", ").append(class112.MF_CLASS112_e484).toString())
         class112 = (CheckPoint)iterator.next();

     return s;
 }

 public void MF_CLASS108_a447(float f, float f1)
 {
	 mPoints.add(new CheckPoint(f, f1));
 }

 public void setOrReplaceEndPoint(CheckPoint class112) throws Exception
 {
     CLASS167.MF_CLASS167_b635("Measurement", (new StringBuilder()).append("setOrReplaceEndPoint(): p.x = ").append(class112.coordX).append(", p.y = ").append(class112.coordY).append(", mPoints.size() = ").append(mPoints.size()).toString());
     if(mPoints.size() > 1)
     {
    	 mPoints.set(-1 + mPoints.size(), class112);
         return;
     }
     if(mPoints.size() == 1)
     {
    	 mPoints.add(class112);
         return;
     } else
     {
         throw new Exception("No end point set yet.");
     }
 }

 public void MF_CLASS108_a447(List list)
 {
	 mPoints = list;
 }

 public void MF_CLASS108_b448()
 {
	 mPoints.remove(-1 + mPoints.size());
 }

 public void MF_CLASS108_b448(float f, float f1)
 {
	 mPoints.add(0, new CheckPoint(f, f1));
 }

 public void MF_CLASS112_c482()
 {
     if(mPoints.size() == 3)
    	 mPoints.remove(1);
 }

 public void replaceStartPoint(float f, float f1)
 {
     CLASS167.MF_CLASS167_b635("Measurement", (new StringBuilder()).append("replaceStartPoint(): x = ").append(f).append(", y = ").append(f1).append(", mPoints.size() = ").append(mPoints.size()).toString());
     if(mPoints.size() > 0)
     {
    	 mPoints.set(0, new CheckPoint(f, f1));
         return;
     } else
     {
    	 mPoints.add(new CheckPoint(f, f1));
         return;
     }
 }

 public CheckPoint getFirstCheckPoint()
 {
     return (CheckPoint)mPoints.toArray()[0];
 }

 public void setMiddlePoint(float f, float f1) throws Exception
 {
     CLASS167.MF_CLASS167_b635("Measurement", (new StringBuilder()).append("setMiddlePoint(): x = ").append(f).append(", y = ").append(f1).append(", mPoints.size() = ").append(mPoints.size()).toString());
     if(mPoints.size() == 2)
     {
    	 mPoints.add(1, new CheckPoint(f, f1));
         return;
     }
     if(mPoints.size() == 3)
     {
    	 mPoints.set(1, new CheckPoint(f, f1));
         return;
     } else
     {
         throw new Exception("No middle point set yet.");
     }
 }

 public CheckPoint getLastCheckPoint()
 {
     Object aobj[] = mPoints.toArray();
     return (CheckPoint)aobj[-1 + aobj.length];
 }

 public String toString()
 {
     return (new StringBuilder()).append("ID: ").append(mMeasurementID).append(", bID : ").append(bID).append(", lID: ").append(lID).append(", gID: ").append(gID).append(", coordSys: ").append(coordSys).append(", userId: ").append(userId).append(",").append(", stime : ").append(mStartTimestamp).append(", eTime: ").append(EndTimestamp).append(", sSent : ").append(mSentToServer).append(", written: ").append(mWrittenToFile).append(", idBE: ").append(segmentID).append(", bezier: ").append(mBezier).append(", lavel: ").append(mLabel).append(", points: ").append(TestSegment).append(MF_CLASS108_a447()).toString();
 }

 public long mMeasurementID;
 public String bID;
 public String lID;
 public String gID;
 public String coordSys;
 public String mDeviceModel;
 public String userId;
 public String mIdaUuid;
 public long mStartTimestamp;
 public long EndTimestamp;
 public List mPoints;
 public long mSentToServer;
 public long mWrittenToFile;
 public String segmentID;
 public int TestSegment;
 public int mBezier;
 public String mLabel;
 public boolean MF_CLASS108_r464;
}
