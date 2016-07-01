package com.indooratlas.thread.server;


import android.os.SystemClock;

import com.indooratlas.base.CLASS5;
import com.indooratlas.cursor.list.CLASS24;
import com.indooratlas.cursor.list.CLASS25;
import com.indooratlas.data.*;
import com.indooratlas.message.event.CLASS65;
import com.indooratlas.position.CLASS68;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.CLASS381;
import com.indooratlas.task.CLASS42;
import com.xinghai.indoor.util.ArrayUtil;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.indooratlas.communication.*;

public class ProtobufBuilder
{

	ProtobufBuilder(CLASS42 class42, String s)
 {
     MF_CLASS24_b87 = 1;
     MF_CLASS381_g1113 = class42;
     MF_CLASS381_d1110 = s;
     MF_CLASS24_h93 = new CLASS65();
 }

 private positioning_request.EncodedOneValuedSignal MF_CLASS24_a86(CLASS36 class36)
 {
     positioning_request.EncodedOneValuedSignal encodedonevaluedsignal = new positioning_request.EncodedOneValuedSignal();
     encodedonevaluedsignal.setFirstTimestamp(class36.MF_CLASS36_a142);
     encodedonevaluedsignal.setFirstValue(Double.valueOf(class36.MF_CLASS36_c143).floatValue());
     for(int i = 0; i < class36.d.length; i++)
     {
         encodedonevaluedsignal.addTimestamp(class36.b[i]);
         encodedonevaluedsignal.addValues(class36.d[i]);
     }

     return encodedonevaluedsignal;
 }

 private positioning_request.EncodedThreeValuedSignal MF_CLASS24_a86(CLASS37 class37)
 {
     int i = 0;
     positioning_request.EncodedThreeValuedSignal encodedthreevaluedsignal = new positioning_request.EncodedThreeValuedSignal();
     encodedthreevaluedsignal.setFirstTimestamp(class37.MF_CLASS37_a144);
     encodedthreevaluedsignal.setFirstX(Double.valueOf(class37.MF_CLASS37_c145[0]).floatValue());
     encodedthreevaluedsignal.setFirstY(Double.valueOf(class37.MF_CLASS37_c145[1]).floatValue());
     encodedthreevaluedsignal.setFirstZ(Double.valueOf(class37.MF_CLASS37_c145[2]).floatValue());
     for(; i < class37.d.length; i++)
     {
         encodedthreevaluedsignal.addTimestamp(class37.b[i]);
         encodedthreevaluedsignal.addX(class37.d[i]);
         encodedthreevaluedsignal.addY(class37.e[i]);
         encodedthreevaluedsignal.addZ(class37.f[i]);
     }

     return encodedthreevaluedsignal;
 }

 private positioning_request.OnlineMeasurement MF_CLASS24_a86(CLASS37 class37, CLASS37 class37_1, CLASS37 class37_2, CLASS36 class36, CLASS36 class36_1, CLASS36 class36_2, CLASS36 class36_3,
         List list)
 {
     positioning_request.OnlineMeasurement onlinemeasurement = new positioning_request.OnlineMeasurement();
     onlinemeasurement.setAccelerometer(MF_CLASS24_a86(class37));
     onlinemeasurement.setGyroscope(MF_CLASS24_a86(class37_1));
     onlinemeasurement.setMagnetometer(MF_CLASS24_a86(class37_2));
     if(class36 != null)
         onlinemeasurement.setPressure(MF_CLASS24_a86(class36));
     if(class36_1 != null)
         onlinemeasurement.setLight(MF_CLASS24_a86(class36_1));
     if(class36_2 != null)
         onlinemeasurement.setProximity(MF_CLASS24_a86(class36_2));
     if(class36_3 != null)
         onlinemeasurement.setTemperature(MF_CLASS24_a86(class36_3));
     if(list != null)
     {
         positioning_request.GPSSample gpssample;
         for(Iterator iterator = list.iterator(); iterator.hasNext(); onlinemeasurement.addGpsSamples(gpssample))
         {
             CLASS25 class25 = (CLASS25)iterator.next();
             gpssample = new positioning_request.GPSSample();
             gpssample.setGpsTimestamp(class25.mTimeStamp);
             gpssample.setLatitude(class25.mLatitude);
             gpssample.setLongitude(class25.mLongitude);
             gpssample.setAltitude(class25.mAltitude);
         }

     }
     return onlinemeasurement;
 }

 positioning_request.PositioningRequest MF_CLASS24_a86(CLASS5 class5)
 {
     String s = CLASS75.createIDAUID(MF_CLASS381_g1113.MF_CLASS42_a150(), MF_CLASS381_d1110);
     positioning_request.PositioningRequest positioningrequest = new positioning_request.PositioningRequest();
     positioning_request.PositioningInitialization positioninginitialization = new positioning_request.PositioningInitialization();
     positioninginitialization.addConstraint((new positioning_request.InitializationConstraint()).setType(1).setValue(mIdaUUID.toString()));
     positioninginitialization.setIdaUUID(s);
     positioninginitialization.setDevice((new positioning_request.Device()).setDeviceModelId((new positioning_common.UUID()).setMostSignBits(DeviceModelId.getMostSignBits()).setLeastSignBits(DeviceModelId.getLeastSignBits())));
     String s1 = null;
     if(class5 != null)
         s1 = class5.MF_CLASS5_a6();
     if(s1 != null)
     {
         positioning_common.KeyValuePair keyvaluepair = new positioning_common.KeyValuePair();
         keyvaluepair.setKey("motion_mode");
         keyvaluepair.setValue(s1);
         positioninginitialization.addParameters(keyvaluepair);
     }
     if(s1 != null)
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("createInitialization(): motion_mode: ").append(s1).toString());
     else
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", "createInitialization(): motion_mode: normal");
     positioningrequest.setPositioningInit(positioninginitialization);
     positioningrequest.setType(1);
     return positioningrequest;
 }

 positioning_request.PositioningRequest wrapSensorDataToLocationMessage(CLASS24 class24, ConcurrentLinkedQueue concurrentlinkedqueue)
 {
     positioning_request.PositioningRequest positioningrequest = new positioning_request.PositioningRequest();
     positioning_request.SensorData sensordata = new positioning_request.SensorData();
     List list = CLASS75.removeDuplicateTimestamps(class24.accelerometerSamples);
     List list1 = CLASS75.removeDuplicateTimestamps(class24.gyroscopeSamples);
     List list2 = CLASS75.removeDuplicateTimestamps(class24.accelerometerSamples);
     CLASS39 class39 = CLASS68.MF_CLASS68_a226(list);
     CLASS39 class39_1 = CLASS68.MF_CLASS68_a226(list1);
     CLASS39 class39_2 = CLASS68.MF_CLASS68_a226(list2);
     CLASS38 class38 = CLASS68.MF_CLASS27_e108(class24.mBarometerList);
     CLASS38 class38_1 = CLASS68.MF_CLASS27_e108(class24.mRGBList);
     CLASS38 class38_2 = CLASS68.MF_CLASS27_e108(class24.mProximityList);
     CLASS38 class38_3 = CLASS68.MF_CLASS27_e108(class24.mTemperatureList);
     if(class39.mArrayAccelerometerX.length == 0 || class39.mArrayAccelerometerY.length == 0 || class39.mArrayAccelerometerZ.length == 0)
     {
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", "wrapSensorDataToLocationMessage(): Accelerometer values zero.");
         return null;
     }
     if(class39_1.mArrayAccelerometerX.length == 0 || class39_1.mArrayAccelerometerY.length == 0 || class39_1.mArrayAccelerometerZ.length == 0)
     {
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", "wrapSensorDataToLocationMessage(): Gyroscope values zero.");
         return null;
     }
     if(class39_2.mArrayAccelerometerX.length == 0 || class39_2.mArrayAccelerometerY.length == 0 || class39_2.mArrayAccelerometerZ.length == 0)
     {
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", "wrapSensorDataToLocationMessage(): Magnetometer values zero.");
         return null;
     }
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("wrapSensorDataToLocationMessage(): accelerometerSignal.timestamps[0] = ").append(class39.mArrayTimeStamps[0]).toString());
     CLASS37 class37 = CLASS35.MF_CLASS37_a144(class39.mArrayTimeStamps, class39.mArrayAccelerometerX, class39.mArrayAccelerometerY, class39.mArrayAccelerometerZ);
     CLASS37 class37_1 = CLASS35.MF_CLASS37_a144(class39_1.mArrayTimeStamps, class39_1.mArrayAccelerometerX, class39_1.mArrayAccelerometerY, class39_1.mArrayAccelerometerZ);
     CLASS37 class37_2 = CLASS35.MF_CLASS37_a144(class39_2.mArrayTimeStamps, class39_2.mArrayAccelerometerX, class39_2.mArrayAccelerometerY, class39_2.mArrayAccelerometerZ);
     CLASS36 class36 = null;
     if(class38 != null)
     {
         int k1 = class38.a.length;
         class36 = null;
         if(k1 > 0)
             class36 = CLASS35.MF_CLASS37_a144(class38.a, class38.b);
     }
     CLASS36 class36_1 = null;
     if(class38_1 != null)
     {
         int j1 = class38_1.a.length;
         class36_1 = null;
         if(j1 > 0)
             class36_1 = CLASS35.MF_CLASS37_a144(class38_1.a, class38_1.b);
     }
     CLASS36 class36_2 = null;
     if(class38_2 != null)
     {
         int i1 = class38_2.a.length;
         class36_2 = null;
         if(i1 > 0)
             class36_2 = CLASS35.MF_CLASS37_a144(class38_2.a, class38_2.b);
     }
     CLASS36 class36_3 = null;
     if(class38_3 != null)
     {
         int k = class38_3.a.length;
         class36_3 = null;
         if(k > 0)
             class36_3 = CLASS35.MF_CLASS37_a144(class38_3.a, class38_3.b);
     }
     positioning_request.OnlineMeasurement onlinemeasurement = MF_CLASS24_a86(class37, class37_1, class37_2, class36, class36_1, class36_2, class36_3, class24.MF_CLASS24_h93);
     sensordata.setEncodedSensorData(onlinemeasurement);
     if(concurrentlinkedqueue != null && concurrentlinkedqueue.size() > 0)
     {
         positioning_request.WifiMeasurement wifimeasurement = new positioning_request.WifiMeasurement();
         Hashtable hashtable = new Hashtable();
         Iterator iterator = concurrentlinkedqueue.iterator();
         int i = 0;
         long l;
         positioning_request.WifiScan wifiscan;
         Iterator iterator1;
         CLASS381 class381;
         positioning_request.WifiScanEntry wifiscanentry;
         while(iterator.hasNext())
         {
             CLASS381 class381_1 = (CLASS381)iterator.next();
             int j;
             if(!hashtable.containsKey(class381_1.BSSID))
             {
                 positioning_request.WifiAP wifiap = new positioning_request.WifiAP();
                 wifiap.setBssid(Long.parseLong(class381_1.BSSID, 16));
                 wifimeasurement.addApList(wifiap);
                 String s = class381_1.BSSID;
                 j = i + 1;
                 hashtable.put(s, Integer.valueOf(i));
             } else
             {
                 j = i;
             }
             i = j;
         }
         l = ((CLASS381)concurrentlinkedqueue.peek()).ScanNo;
         wifiscan = new positioning_request.WifiScan();
         wifiscan.setTimestamp(((CLASS381)concurrentlinkedqueue.peek()).mScanTimeStamp);
         for(iterator1 = concurrentlinkedqueue.iterator(); iterator1.hasNext(); wifiscan.addScan(wifiscanentry))
         {
             class381 = (CLASS381)iterator1.next();
             if(l != class381.ScanNo)
             {
                 l = class381.ScanNo;
                 wifimeasurement.addWifiScanList(wifiscan);
                 wifiscan = new positioning_request.WifiScan();
                 wifiscan.setTimestamp(class381.mScanTimeStamp);
             }
             wifiscanentry = new positioning_request.WifiScanEntry();
             wifiscanentry.setSignalStrength(class381.SignalStrength);
             wifiscanentry.setAccessPointNum(((Integer)hashtable.get(class381.BSSID)).intValue());
         }

         wifimeasurement.addWifiScanList(wifiscan);
         onlinemeasurement.setWifiMeasurement(wifimeasurement);
     }
     sensordata.setEncodedSensorData(onlinemeasurement);
     synchronized(MF_CLASS24_a86)
     {
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("Setting positioning sequence number to packet: ").append(MF_CLASS24_b87).toString());
         sensordata.setSessionUpdateNumber(MF_CLASS24_b87);
         MF_CLASS24_b87 = 1 + MF_CLASS24_b87;
     }
     positioningrequest.setSensorData(sensordata);
     positioningrequest.setType(2);
     return positioningrequest;
 }

 com.indooratlas.communication.positioning_request.PositioningRequest MF_CLASS24_a86(double ad[], int i)
 {
     positioning_request.PositioningRequest positioningrequest = new positioning_request.PositioningRequest();
     positioning_request.CalibrationData calibrationdata = new positioning_request.CalibrationData();
     calibrationdata.setType(i);
     calibrationdata.setBiasX(ad[0]);
     calibrationdata.setBiasY(ad[1]);
     calibrationdata.setBiasZ(ad[2]);
     positioningrequest.setCalibrationData(calibrationdata);
     positioningrequest.setType(3);
     positioningrequest.setCalibrationData(calibrationdata);
     return positioningrequest;
 }

 void MF_CLASS24_a86()
 {
     MF_CLASS24_b87 = 1;
     sessionId = null;
 }

 void MF_CLASS24_a86(String s)
 {
//     MF_CLASS24_f91 = api_psm_common.UUID.fromString(s);
 }

 void MF_CLASS24_a86(api_psm_common.UUID uuid)
 {
	 sessionId = uuid;
 }

 byte[] MF_CLASS24_a86(com.indooratlas.communication.positioning_request.PositioningRequest positioningrequest, int i)
 {
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", "Creating CONNECT message.");
     positioning_request.PositioningRequest positioningrequest1 = new positioning_request.PositioningRequest();
     positioningrequest1.mergeFrom(positioningrequest.toByteArray());
     api_psm_request.PSMRequest psmrequest = new api_psm_request.PSMRequest();
     psmrequest.setPayload(ArrayUtil.createArray(positioningrequest1.toByteArray()));
     long l = SystemClock.elapsedRealtime();
     psmrequest.setTimestamp(l);
     psmrequest.setSequenceNumber(i);
     psmrequest.setType(1);
     String s = CLASS75.createIDAUID(MF_CLASS381_g1113.MF_CLASS42_a150(), MF_CLASS381_d1110);
     String s1 = MF_CLASS381_g1113.MF_CLASS42_b151();
     UUID uuid = UUID.fromString(MF_CLASS381_g1113.MF_CLASS42_a150());
     String s2 = (new StringBuilder()).append(uuid).append(s).append(l).toString().toUpperCase();
     String s3;
     api_psm_request.ConnectHeader connectheader;
     try
     {
         s3 = MF_CLASS24_h93.MF_CLASS65_a221(s1, s2);
     }
     catch(Exception unsupportedencodingexception)
     {
    	 unsupportedencodingexception.printStackTrace();
         return null;
     }
     connectheader = new api_psm_request.ConnectHeader();
     connectheader.setApikey((new api_psm_common.UUID()).setMostSignBits(uuid.getMostSignificantBits()).setLeastSignBits(uuid.getLeastSignificantBits()));
     connectheader.setIDAUuid(s);
     connectheader.setSignature(s3);
     connectheader.setIDAUuid(s);
     connectheader.setAlgorithmVersion(1);
     psmrequest.setConnect(connectheader);
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("createConnect: Creating CONNECT message, request = ").append(psmrequest.toString()).toString());
     return psmrequest.toByteArray();
 }

 byte[] MF_CLASS24_a86(com.indooratlas.communication.positioning_request.PositioningRequest positioningrequest, int i, int j)
 {
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("createUpdate(): Creating UPDATE message, sessionId = ").append(sessionId).toString());
     if(sessionId == null)
     {
         CLASS75.MF_CLASS75_a259(5, "MESSAGE_CREATION_ERROR", ProtobufBuilder.class, "ProtobufBuilder.createUpdate: sessionId was null");
         return null;
     } else
     {
         api_psm_request.PSMRequest psmrequest = new api_psm_request.PSMRequest();
         psmrequest.setPayload(ArrayUtil.createArray(positioningrequest.toByteArray()));
         long l = SystemClock.elapsedRealtime();
         psmrequest.setSessionId((new api_psm_common.UUID()).setMostSignBits(sessionId.getMostSignBits()).setLeastSignBits(sessionId.getLeastSignBits()));
         psmrequest.setTimestamp(l);
         psmrequest.setSequenceNumber(i);
         psmrequest.setLastReceived(j);
         psmrequest.setType(3);
         psmrequest.setUpdate(new api_psm_request.UpdateHeader());
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("createUpdate(): created UPDATE message : size = ").append(psmrequest.toByteArray().length).toString());
         return psmrequest.toByteArray();
     }
 }

 byte[] MF_CLASS24_a86(SortedSet sortedset)
 {
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", "createRetransmit(): Creating RETRANSMIT message.");
     api_psm_request.PSMRequest psmrequest = new api_psm_request.PSMRequest();
     psmrequest.setTimestamp(SystemClock.elapsedRealtime());
     psmrequest.setSessionId((new api_psm_common.UUID()).setMostSignBits(sessionId.getMostSignBits()).setLeastSignBits(sessionId.getLeastSignBits()));
     psmrequest.setType(6);
     api_psm_common.RetransmitHeader retransmitheader = new api_psm_common.RetransmitHeader();
     for(Iterator iterator = sortedset.iterator(); iterator.hasNext(); retransmitheader.addControlSequenceNumbers(((Integer)iterator.next()).intValue()));
     psmrequest.setRetransmit(retransmitheader);
     return psmrequest.toByteArray();
 }

 void MF_CLASS24_b87(api_psm_common.UUID uuid)
 {
	 DeviceModelId = uuid;
 }

 byte[] MF_CLASS24_b87()
 {
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", "createReconnect(): called.");
     api_psm_common.UUID uuid = sessionId;
     byte abyte0[] = null;
     if(uuid != null)
     {
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", "createReconnect(): Creating RECONNECT message.");
         api_psm_request.PSMRequest psmrequest = new api_psm_request.PSMRequest();
         long l = SystemClock.elapsedRealtime();
         psmrequest.setSessionId((new api_psm_common.UUID()).setMostSignBits(sessionId.getMostSignBits()).setLeastSignBits(sessionId.getLeastSignBits()));
         psmrequest.setTimestamp(l);
         psmrequest.setType(2);
         String s = CLASS75.createIDAUID(MF_CLASS381_g1113.MF_CLASS42_a150(), MF_CLASS381_d1110);
         String s1 = MF_CLASS381_g1113.MF_CLASS42_b151();
         String s2 = (new StringBuilder()).append(sessionId).append(s).append(l).toString().toUpperCase();
         String s3;
         api_psm_request.ReconnectHeader reconnectheader;
         try
         {
             s3 = MF_CLASS24_h93.MF_CLASS65_a221(s1, s2);
         }
         catch(Exception unsupportedencodingexception)
         {
        	 unsupportedencodingexception.printStackTrace();
        	 return null;
         }
         reconnectheader = new api_psm_request.ReconnectHeader();
         reconnectheader.setIDAUuid(s);
         reconnectheader.setSignature(s3);
         psmrequest.setReconnect(reconnectheader);
         CLASS75.MF_CLASS75_b260("ProtobufBuilder", (new StringBuilder()).append("createReconnect(): timestamp = ").append(l).append(", IdaUUID = ").append(s).append(", sessionId = ").append(sessionId).append(", secretKey = ").append(s1).append(", signatureContent = ").append(s2).append(", signature = ").append(s3).toString());
         abyte0 = psmrequest.toByteArray();
     }
     return abyte0;
 }

 byte[] createClose()
 {
     CLASS75.MF_CLASS75_b260("ProtobufBuilder", "createClose(): Creating CLOSE message.");
     api_psm_request.PSMRequest psmrequest = new api_psm_request.PSMRequest();
     psmrequest.setTimestamp(SystemClock.elapsedRealtime());
     psmrequest.setSessionId((new api_psm_common.UUID()).setMostSignBits(sessionId.getMostSignBits()).setLeastSignBits(sessionId.getLeastSignBits()));
     psmrequest.setType(4);
     psmrequest.setClose(new api_psm_request.CloseHeader());
     return psmrequest.toByteArray();
 }

 private static final Object MF_CLASS24_a86 = new Object();
 private int MF_CLASS24_b87;
 private api_psm_common.UUID DeviceModelId;
 private String MF_CLASS381_d1110;
 private api_psm_common.UUID sessionId;
 private api_psm_common.UUID mIdaUUID;
 private CLASS42 MF_CLASS381_g1113;
 private CLASS65 MF_CLASS24_h93;

}
