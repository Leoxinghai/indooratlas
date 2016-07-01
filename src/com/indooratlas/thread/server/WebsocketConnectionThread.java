package com.indooratlas.thread.server;


import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.*;

import com.indooratlas.Calibrator.CLASS15;
import com.indooratlas.Calibrator.CLASS8;
import com.indooratlas.base.*;
import com.indooratlas.communication.api_psm_common;
import com.indooratlas.communication.positioning_common;

import com.indooratlas.cursor.list.CLASS22;
import com.indooratlas.cursor.list.CLASS24;
import com.indooratlas.position.PositioningStats;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.*;
import com.indooratlas.thread.PositionEvent;
import com.indooratlas.thread.CLASS98;
import com.indooratlas.thread.client.CLASS47;
import com.xinghai.indoor.util.ExceptionManager;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.net.ssl.*;

import org.wuxi.socket.Draft_17;
import org.wuxi.uri.WebSocketClient;

import java.security.KeyStoreException;
import com.indooratlas.communication.*;

//Referenced classes of package com.indooratlas.thread.server:
//         CLASS79, ProtobufBuilder, WebsocketConnectionService, CLASS84,
//         CLASS80, CLASS82, CLASS85

public class WebsocketConnectionThread
 implements Runnable
{

 private WebsocketConnectionThread(RemoteImplementation class50, Context context, CLASS42 class42, String s, String s1)
 {
     MF_CLASS24_c88 = "";
     MF_CLASS85_b316 = null;
     mIsStarted = false;
     MF_CLASS78_g288 = Integer.valueOf(0);
     MF_CLASS22_h78 = -1;
     MF_CLASS78_i290 = -1;
     mQueue = new ArrayList();
     MF_CLASS78_o296 = new TreeMap(MF_CLASS78_d285);
     MF_CLASS78_p297 = new TreeMap(MF_CLASS78_d285);
     MF_CLASS78_u302 = false;
     MF_CLASS78_v303 = false;
     MF_CLASS78_w304 = null;
     MF_CLASS78_x305 = null;
     mPositioningStats = null;
     MF_CLASS78_z307 = Boolean.valueOf(false);
     C = false;
     D = 0;
     E = 0L;
     F = 0L;
     G = 0L;
     H = false;
     I = 0L;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "WebSocketConnectionService()");
     mRemoteImpl = class50;
     MF_CLASS78_j291 = context;
     mProtobufBuilder = new ProtobufBuilder(class42, s);
     MF_CLASS78_t301 = (ConnectivityManager)context.getSystemService("connectivity");
     MF_CLASS78_k292 = CLASS59.CLOSED;
     MF_CLASS24_c88 = s1;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "WebSocketConnectionService() done.");
 }

 static int MF_CLASS85_a315(WebsocketConnectionThread class78, int i)
 {
     class78.D = i;
     return i;
 }

 static long MF_CLASS85_a315(WebsocketConnectionThread class78, long l)
 {
     class78.F = l;
     return l;
 }

 static CountDownTimer MF_CLASS85_a315(WebsocketConnectionThread class78, CountDownTimer countdowntimer)
 {
     class78.MF_CLASS78_w304 = countdowntimer;
     return countdowntimer;
 }

 private CLASS6 responseToServiceState(com.indooratlas.communication.positioning_response.Position position, float f, float f1, long l)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("responseToServiceState() called(): connection = ").append(MF_CLASS78_l293).append(", radiusMeters = ").append(f1).toString());
     return new CLASS98(l, MF_CLASS78_o296.size(), position.getGeoPosition().getLatitude(), position.getGeoPosition().getLongitude(), position.getPixelPosition().getX(), position.getPixelPosition().getY(), position.getMetricPosition().getX(), position.getMetricPosition().getY(), f, f1);
 }

 public static WebsocketConnectionThread MF_CLASS85_a315(RemoteImplementation class50, Context context, CLASS42 class42, String s, String s1)
 {
     if(L == null)
         L = new WebsocketConnectionThread(class50, context, class42, s, s1);
     return L;
 }

 static WebsocketConnectionService MF_CLASS85_a315(WebsocketConnectionThread class78, WebsocketConnectionService class90)
 {
     class78.MF_CLASS78_l293 = class90;
     return class90;
 }

 private PositionEvent MF_CLASS85_a315(positioning_request.PositioningRequest positioningrequest)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("createMessageContainer() called(): connection = ").append(MF_CLASS78_l293).toString());
     Integer integer = MF_CLASS78_g288;
     PositionEvent class97 = new PositionEvent(positioningrequest, MF_CLASS78_g288.intValue());
     synchronized(MF_CLASS78_o296)
     {
         MF_CLASS78_o296.put(MF_CLASS78_g288, class97);
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("createMessageContainer()  sentMessageContainers.size() = ").append(MF_CLASS78_o296.size()).toString());
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("createMessageContainer Control sequence number:").append(MF_CLASS78_g288).append(", locationmessage.hasCalibration: ").append(positioningrequest.hasCalibrationData()).toString());
     MF_CLASS78_g288 = Integer.valueOf(1 + MF_CLASS78_g288.intValue());
     return class97;
 }

 private String MF_CLASS85_a315(com.indooratlas.communication.positioning_response.PositioningResponse positioningresponse)
 {
     return "";
 }

 private UUID MF_CLASS85_a315(api_psm_common.UUID uuid)
 {
     if(uuid == null)
         throw new IllegalArgumentException("Null UUID.");
     UUID uuid1;
     try
     {
         uuid1 = new UUID(uuid.getMostSignBits(), uuid.getLeastSignBits());
     }
     catch(IllegalArgumentException illegalargumentexception)
     {
         throw new IllegalArgumentException("Malformed UUID.");
     }
     return uuid1;
 }

 static api_psm_common.UUID MF_CLASS85_a315(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_f287;
 }

 static positioning_common.UUID MF_CLASS85_a315(WebsocketConnectionThread class78, positioning_common.UUID uuid)
 {
 	return null;
//     return class78.MF_CLASS85_a315(uuid);
 }

 static api_psm_common.UUID MF_CLASS85_a315(WebsocketConnectionThread class78, api_psm_common.UUID uuid)
 {
     class78.MF_CLASS78_f287 = uuid;
     return uuid;
 }

 private void MF_CLASS85_a315(long l)
 {
     A = l;
 }

 static void MF_CLASS85_a315(WebsocketConnectionThread class78, List list)
 {
     class78.MF_CLASS85_a315(list);
 }

 static void MF_CLASS85_a315(WebsocketConnectionThread class78, SortedSet sortedset)
 {
     class78.MF_CLASS85_a315(sortedset);
 }

 private void MF_CLASS85_a315(List list)
 {
     Iterator iterator = list.iterator();
     while(iterator.hasNext())
     {
         Integer integer = (Integer)iterator.next();
         PositionEvent class97 = (PositionEvent)MF_CLASS78_o296.get(integer);
         if(class97 != null)
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("RETRANSMITTING: ").append(integer).toString());
             sendUpdate(class97);
         } else
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("NOT RETRANSMITTING: ").append(integer).append(", because it was not stored anymore in sentMessageContainers").toString());
         }
         mPositioningStats.MF_CLASS46_a157();
     }
 }

 private void MF_CLASS85_a315(SortedSet sortedset)
 {
     if(SystemClock.elapsedRealtime() - B > 2000L)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("Asking for retransmit for:").append(Arrays.toString(sortedset.toArray())).toString());
         byte abyte0[] = mProtobufBuilder.MF_CLASS24_a86(sortedset);
         MF_CLASS78_l293.send(abyte0);
         B = SystemClock.elapsedRealtime();
         mPositioningStats.MF_CLASS73_c240();
     }
 }

 static boolean MF_CLASS85_a315(WebsocketConnectionThread class78, boolean flag)
 {
     class78.H = flag;
     return flag;
 }

 static int MF_CLASS85_b316(WebsocketConnectionThread class78, int i)
 {
     class78.MF_CLASS22_h78 = i;
     return i;
 }

 static CountDownTimer MF_CLASS85_b316(WebsocketConnectionThread class78, CountDownTimer countdowntimer)
 {
     class78.MF_CLASS78_x305 = countdowntimer;
     return countdowntimer;
 }

 static WebsocketConnectionService MF_CLASS85_b316(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_l293;
 }

 static boolean MF_CLASS85_b316(WebsocketConnectionThread class78, boolean flag)
 {
     class78.K = flag;
     return flag;
 }

 private void sendConnect(PositionEvent class97) throws CLASS1
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendConnect() called(): connection = ").append(MF_CLASS78_l293).append(", messageContainer.getRequestLocationMessage() = ").append(class97.MF_CLASS97_d357().toString()).toString());
     byte abyte0[];
     StringBuilder stringbuilder;
     boolean flag;
     try
     {
         abyte0 = mProtobufBuilder.MF_CLASS24_a86(class97.MF_CLASS97_d357(), class97.MF_CLASS97_c356());
     }
     catch(Exception exceptionmanager)
     {
         throw new CLASS1((new StringBuilder()).append("sendConnect : ").append(exceptionmanager.getMessage()).toString());
     }
     stringbuilder = (new StringBuilder()).append("sendConnect() connection == null: ");
     if(MF_CLASS78_l293 == null)
         flag = true;
     else
         flag = false;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", stringbuilder.append(flag).toString());
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendConnect() connection.isOpen(): ").append(MF_CLASS78_l293.isOpen()).toString());
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendConnect() payload length: ").append(abyte0.length).toString());
     if(MF_CLASS78_l293 == null || !MF_CLASS78_l293.isOpen())
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "sendConnect() connection.isOpen() == false --> creating ReconnectTask");
         MF_CLASS22_h78();
     }
     E = SystemClock.elapsedRealtime();
     MF_CLASS78_l293.send(abyte0);
     synchronized(MF_CLASS78_o296)
     {
         MF_CLASS78_o296.put(Integer.valueOf(class97.MF_CLASS97_c356()), class97);
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "sendConnect() done.");
     return;
 }

 private void MF_CLASS24_c88(boolean flag)
 {
     synchronized(MF_CLASS78_z307)
     {
         MF_CLASS78_z307 = Boolean.valueOf(flag);
     }
     return;
 }

 static boolean MF_CLASS24_c88(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_s300();
 }

 static int MF_CLASS78_d285(WebsocketConnectionThread class78)
 {
     int i = class78.D;
     class78.D = i + 1;
     return i;
 }

 private void sendUpdate(PositionEvent class97)
 {
     byte abyte0[];
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendUpdate() called(): connection = ").append(MF_CLASS78_l293).append(", messageContainer = ").append(class97).append(", messageContainer.getControlSequenceNumber() = ").append(class97.MF_CLASS97_c356()).append(", lastReceivedControlSequenceNumber = ").append(MF_CLASS22_h78).toString());
     abyte0 = mProtobufBuilder.MF_CLASS24_a86(class97.MF_CLASS97_d357(), class97.MF_CLASS97_c356(), MF_CLASS22_h78);
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendUpdate() called(): createUpdate_returned : ").append(abyte0).toString());
     class97.MF_CLASS97_b355();
     if(MF_CLASS78_l293 == null || !MF_CLASS78_l293.isOpen() || abyte0 == null) {
             if(MF_CLASS78_l293 != null && !MF_CLASS78_l293.isOpen())
             {
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "sendUpdate() connection.isOpen() == false --> creating ReconnectTask");
                 MF_CLASS22_h78();
             }
     } else {
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendUpdate() called(): calling sendBinaryMessage : connection = ").append(MF_CLASS78_l293).append(", connection.isOpen() = ").append(MF_CLASS78_l293.isOpen()).toString());
	        MF_CLASS78_l293.send(abyte0);
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendUpdate_called: DONE : messageContainer.getControlSequenceNumber() = ").append(class97.MF_CLASS97_c356()).toString());
     return;

 }

 private void MF_CLASS78_d285(String s)
 {
 }

 private void MF_CLASS78_d285(boolean flag)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("setPositioningSessionAlive called with  = ").append(flag).toString());
     MF_CLASS78_u302 = flag;
 }

 static void MF_CLASS78_e286(WebsocketConnectionThread class78)
 {
     class78.MF_CLASS78_m294();
 }

 static Context MF_CLASS78_f287(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_j291;
 }

 static ReconnectTask MF_CLASS78_f287()
 {
     return J;
 }

 static int MF_CLASS78_g288(WebsocketConnectionThread class78)
 {
     return class78.D;
 }

 private boolean MF_CLASS78_g288()
 {
     boolean flag;
     synchronized(MF_CLASS78_z307)
     {
         flag = MF_CLASS78_z307.booleanValue();
     }
     return flag;
 }

 static RemoteImplementation MF_CLASS22_h78(WebsocketConnectionThread class78)
 {
     return class78.mRemoteImpl;
 }

 private void MF_CLASS22_h78()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "createAndStartReconnectTask()");
     cancelReconnectTask();
     J = new ReconnectTask(this, null);
     J.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
 }

 static long MF_CLASS78_i290(WebsocketConnectionThread class78)
 {
     return class78.F;
 }

 private void cancelReconnectTask()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "cancelReconnectTask()");
     if(J != null)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "canceled reconnect task.");
         J.cancel(true);
     }
 }

 private void reset()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "reset() called.");
     mProtobufBuilder.MF_CLASS24_a86();
     synchronized(mQueue)
     {
    	 mQueue.clear();
     }
     D = 0;
     MF_CLASS78_g288 = Integer.valueOf(0);
     MF_CLASS22_h78 = -1;
     MF_CLASS78_i290 = -1;
     synchronized(MF_CLASS78_o296)
     {
         MF_CLASS78_o296.clear();
     }
     MF_CLASS78_p297.clear();
     MF_CLASS78_d285(false);
     MF_CLASS24_c88(false);
     MF_CLASS85_a315(0L);
     H = false;
     MF_CLASS78_f287 = null;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "reset() done.");
     return;
 }

 static void MF_CLASS78_j291(WebsocketConnectionThread class78)
 {
     class78.stopInitTimeoutCheck();
 }

 static long MF_CLASS78_k292(WebsocketConnectionThread class78)
 {
     return class78.G;
 }

 private void MF_CLASS78_k292()
 {
     I = 0L;
     G = 0L;
 }

 static long MF_CLASS78_l293(WebsocketConnectionThread class78)
 {
     return class78.I;
 }

 private SortedSet MF_CLASS78_l293()
 {
     int i = MF_CLASS22_h78;
     TreeSet treeset = new TreeSet();
     if(MF_CLASS78_p297.size() > 0)
     {
         SortedSet sortedset = (SortedSet)MF_CLASS78_p297.keySet();
         int j = ((Integer)sortedset.last()).intValue();
         for(int k = i + 1; k < j; k++)
             if(!sortedset.contains(Integer.valueOf(k)))
                 treeset.add(Integer.valueOf(k));

     }
     return treeset;
 }

 private void MF_CLASS78_m294()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendReconnect() called(): connection = ").append(MF_CLASS78_l293).append(" protobufBuilder ").append(mProtobufBuilder).toString());
     byte abyte0[] = mProtobufBuilder.MF_CLASS24_b87();
     MF_CLASS78_l293.send(abyte0);
 }

 static boolean MF_CLASS78_m294(WebsocketConnectionThread class78)
 {
     return class78.H;
 }

 static SortedMap MF_CLASS78_n295(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_o296;
 }

 private void sendClose()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendClose() called(): connection = ").append(MF_CLASS78_l293).toString());
     byte abyte0[] = mProtobufBuilder.createClose();
     MF_CLASS78_l293.send(abyte0);
 }

 static PositioningStats MF_CLASS78_o296(WebsocketConnectionThread class78)
 {
     return class78.mPositioningStats;
 }

 private void stopInitTimeoutCheck()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopInitTimeoutCheck called --> stopping initTimeOutTimer");
     if(MF_CLASS78_w304 != null)
     {
         MF_CLASS78_w304.cancel();
         MF_CLASS78_w304 = null;
     }
 }

 static CLASS47 MF_CLASS78_p297(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_s300;
 }

 private void MF_CLASS78_p297()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "startInitTimeoutCheck: called");
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "startInitTimeoutCheck calling stopInitTimeoutCheck() to kill old initTimeOutTimer");
     stopInitTimeoutCheck();
     (new Handler(MF_CLASS78_j291.getMainLooper())).post(new CLASS80(this));
 }

 private void stopLastPositionTimeoutCheck()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopLastPositionTimeoutCheck called");
     if(MF_CLASS78_x305 != null)
     {
         MF_CLASS78_x305.cancel();
         MF_CLASS78_x305 = null;
     }
 }

 static void MF_CLASS78_q298(WebsocketConnectionThread class78)
 {
     class78.reset();
 }

 static ProtobufBuilder MF_CLASS78_r299(WebsocketConnectionThread class78)
 {
     return class78.mProtobufBuilder;
 }

 private void startLastPositionTimeoutCheck()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "startLastPositionTimeoutCheck: called");
     stopLastPositionTimeoutCheck();
     (new Handler(MF_CLASS78_j291.getMainLooper())).post(new CLASS82(this));
 }

 static int MF_CLASS78_s300(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS22_h78;
 }

 private boolean MF_CLASS78_s300()
 {
     return MF_CLASS78_u302;
 }

 static SortedMap MF_CLASS78_t301(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_p297;
 }

 private void MF_CLASS78_t301() throws KeyStoreException,Exception
 {
     KeyStore keystore = KeyStore.getInstance("BKS");
     keystore.load(MF_CLASS78_j291.getResources().getAssets().open("psm-api.bks"), "IdaPSM4096pow2".toCharArray());
     TrustManagerFactory trustmanagerfactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
     trustmanagerfactory.init(keystore);
     javax.net.ssl.TrustManager atrustmanager[];
     if(keystore.isCertificateEntry("BKS"))
     {
         Certificate certificate = keystore.getCertificate("BKS");
         CLASS75.MF_CLASS75_b260("CERT", (new StringBuilder()).append("cert = ").append(certificate.toString()).toString());
     } else
     {
         CLASS75.MF_CLASS75_b260("CERT", "no cert found");
     }
     atrustmanager = trustmanagerfactory.getTrustManagers();
     if(atrustmanager.length == 0)
         CLASS75.MF_CLASS75_b260("CERT", "no trustmanagers found");
     for(int i = 0; i < atrustmanager.length; i++)
         CLASS75.MF_CLASS75_b260("CERT", (new StringBuilder()).append("trustmanager object ").append(i).append(": ").append(atrustmanager[i].toString()).toString());

     SSLContext sslcontext = SSLContext.getInstance("TLS");
     sslcontext.init(null, trustmanagerfactory.getTrustManagers(), null);
     SSLSocketFactory sslsocketfactory = sslcontext.getSocketFactory();
     if(MF_CLASS78_l293 != null)
     {
         MF_CLASS78_l293.setSocket(sslsocketfactory.createSocket());
         return;
     } else
     {
         throw new IOException("Null connection.");
     }
 }

 static SortedSet MF_CLASS78_u302(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_l293();
 }

 static Integer MF_CLASS78_v303(WebsocketConnectionThread class78)
 {
     return class78.MF_CLASS78_g288;
 }

 static void MF_CLASS78_w304(WebsocketConnectionThread class78)
 {
     class78.stopLastPositionTimeoutCheck();
 }

 static void MF_CLASS78_x305(WebsocketConnectionThread class78)
 {
     class78.MF_CLASS22_h78();
 }

 public void connect() throws CLASS1
 {
     if(MF_CLASS78_s300() && MF_CLASS78_l293 != null && (MF_CLASS78_l293.isConnecting() || MF_CLASS78_l293.isOpen()))
         return;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() called, positioningServerURL = ").append(MF_CLASS24_c88).toString());
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() called, clearing messageContainers, size was = ").append(MF_CLASS78_o296.size()).toString());
     if(!MF_CLASS78_e286())
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "connect() isReconnectCycleOngoing() == false --> reset()");
         reset();
         mPositioningStats = new PositioningStats(MF_CLASS78_j291);
         if(MF_CLASS78_l293 != null)
         {
             for(int i = 0; MF_CLASS78_l293.isOpen() && i < 100;)
             {
                 if(i == 1)
                 {
                     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() called, but already connected --> waiting until closed, cnt = ").append(i).append(" --> calling connection.close()").toString());
                     MF_CLASS78_l293.close();
                 }
                 i++;
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() called, but already  connected  --> waiting until closed, cnt = ").append(i).toString());
                 try
                 {
                     Thread.sleep(50L);
                 }
                 catch(InterruptedException interruptedexception) { }
             }

             D = 0;
             if(MF_CLASS78_l293.isOpen())
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() after loop, connection.isOpen() == ").append(MF_CLASS78_l293.isOpen()).toString());
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() : after wait, connection.isOpen() ==  ").append(MF_CLASS78_l293.isOpen()).toString());
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect() called, creating socket and waiting for callback... positioningServerURL = ").append(MF_CLASS24_c88).toString());
         }
     }
     F = System.currentTimeMillis();
     URI uri;
     try
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("connect(): connecting to : ").append(MF_CLASS24_c88).toString());
         uri = new URI(MF_CLASS24_c88);
     }
     catch(URISyntaxException urisyntaxexception)
     {
         throw new CLASS1("Can't connect to positioning service.");
     }
     MF_CLASS78_l293 = new WebsocketConnectionService(this, uri, new Draft_17(), null, 6000);
     try
     {
         MF_CLASS78_t301();
     }
     catch(Exception exception)
     {
         throw new CLASS1("Error in secure connection setup.");
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "connect() calling connection.connect()");
     MF_CLASS78_l293.connect();
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "connect() done -- waiting for asynch response.");
 }

 public void MF_CLASS85_a315(CLASS3 class3, CLASS47 class47)
 {
	 mCalibrationService = class3;
     MF_CLASS78_s300 = class47;
 }

 public void initializeSession(CLASS5 class5)
 {
     if(MF_CLASS78_s300())
         return;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("initializeSession called, deviceModelId = ").append(MF_CLASS78_n295).toString());
     MF_CLASS78_k292();
     MF_CLASS78_p297();
     startLastPositionTimeoutCheck();
     mCalibrationService.onServiceInitializing();
     PositionEvent class97 = MF_CLASS85_a315(mProtobufBuilder.MF_CLASS24_a86(class5));
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "initializeSession calling sendConnect");
     try
     {
    	 sendConnect(class97);
     }
     catch(CLASS1 class1)
     {
    	 class1.printStackTrace();
    	 onInitializationFailed(class1.getMessage());
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "initializeSession done");
 }

 public void sendBias(CLASS15 class15)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sendBias(): ").append(class15).toString());
     sendUpdate(MF_CLASS85_a315(mProtobufBuilder.MF_CLASS24_a86(class15.MF_CLASS16_b54(), 2)));
     MF_CLASS24_c88(true);
 }

 public void queueSensorData(CLASS24 class24, ConcurrentLinkedQueue concurrentlinkedqueue)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "queueSensorData() called");
     ArrayList arraylist = mQueue;
     int i = mQueue.size();
     if(concurrentlinkedqueue == null)
         return;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("queueSensorData(), index = ").append(i).append(", queuing wifi data with size : ").append(concurrentlinkedqueue.size()).toString());
     mQueue.add(i, new CLASS85(this, class24, concurrentlinkedqueue));
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "queueSensorData() done.");
     MF_CLASS78_d285((new StringBuilder()).append("QueueLength: ").append(mQueue.size()).toString());
     return;
 }

 void onInitializationResponse(PositionEvent class97)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationResponse() called");
     if(!MF_CLASS78_s300())
     {
         I = SystemClock.elapsedRealtime();
         mPositioningStats.MF_CLASS46_a157(I - E);
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onInitializationResponse() : session not alive before call --> setPositioningSessionAlive(true), init_took : ").append(mPositioningStats.initTook()).toString());
         MF_CLASS78_d285(true);
         stopInitTimeoutCheck();
         class97.MF_CLASS97_e358().getInitResponse();
         CLASS75.MF_CLASS75_a259("SESSION_ID", MF_CLASS78_f287.toString());
         MF_CLASS22_h78 = class97.MF_CLASS97_c356();
         CLASS8 class8 = mRemoteImpl.MF_CLASS50_o184();
         if(class8 != null && class8.MF_CLASS16_c55() && class8.MF_CLASS16_b54() != null)
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onInitializationResponse() : fresh bgcalibration ready, sending last bias ").append(Arrays.toString(class8.MF_CLASS16_b54())).toString());
             PositionEvent class97_2 = MF_CLASS85_a315(mProtobufBuilder.MF_CLASS24_a86(class8.MF_CLASS16_b54(), 2));
             MF_CLASS85_a315(SystemClock.elapsedRealtime());
             class97_2.MF_CLASS97_c356();
             sendUpdate(class97_2);
             MF_CLASS24_c88(true);
         } else
         if(MF_CLASS85_b316 != null)
         {
             PositionEvent class97_1 = MF_CLASS85_a315(mProtobufBuilder.MF_CLASS24_a86(MF_CLASS85_b316.MF_CLASS16_b54(), 2));
             MF_CLASS85_a315(SystemClock.elapsedRealtime());
             class97_1.MF_CLASS97_c356();
             sendUpdate(class97_1);
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationResponse() HACK: NOT SENDING CALIB!!!");
             MF_CLASS24_c88(true);
         } else
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationResponse() : bgcalibration *NOT* ready --> not sending bias yet, not sending packets until bias sent");
         }
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationResponse() calling remoteImplementation.onInitializationSuccessful");
         mRemoteImpl.onInitializationSuccessful();
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationResponse() done");
         return;
     } else
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationResponse() : session alive before call --> skipping, returning");
         return;
     }
 }

 void onInitializationFailed(String s)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onInitializationFailed() called");
     mRemoteImpl.onInitializationFailed(s);
     reset();
 }

 public void MF_CLASS85_a315(boolean flag)
 {
	 mIsStarted = flag;
 }

 public int MF_CLASS85_b316()
 {
     return MF_CLASS78_o296.size();
 }

 public void MF_CLASS85_b316(CLASS15 class15)
 {
     MF_CLASS85_b316 = class15;
 }

 void onPositioningResponse(PositionEvent class97)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onPositioningResponse() called, seq num: ").append(class97.MF_CLASS97_c356()).append(", lastRelayedControlSequenceNumber = ").append(MF_CLASS78_i290).append(", messageContainer = ").append(class97).toString());
     if(mRemoteImpl.getPositioningState() != PositioningState.ACTIVE)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onPositioningResponse() called: state != PositioningState.ACTIVE --> return");
         return;
     }
     if(class97.MF_CLASS97_c356() > MF_CLASS78_i290)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onPositioningResponse() called : NEW POSITION");
         MF_CLASS78_i290 = class97.MF_CLASS97_c356();
         G = SystemClock.elapsedRealtime();
         if(class97.MF_CLASS97_e358() != null)
         {
             com.indooratlas.communication.positioning_response.PositioningResponse positioningresponse = class97.MF_CLASS97_e358();
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onPositioningResponse() getResponseLocationMessage != null");
             if(positioningresponse.getPositionData() != null && positioningresponse.getPositionData().getPositionContainerCount() > 0)
             {
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onPositioningResponse() positions.size > 0, seqNum = ").append(class97.MF_CLASS97_c356()).toString());
                 com.indooratlas.communication.positioning_response.PositionContainer positioncontainer = positioningresponse.getPositionData().getPositionContainer(-1 + positioningresponse.getPositionData().getPositionContainerCount());
                 com.indooratlas.communication.positioning_response.Position position = positioncontainer.getPosition(-1 + positioncontainer.getPositionCount());
                 if(mPositioningStats.seqNumOfFirstPosition() == -1)
                 {
                     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onPositioningResponse() firstPositionUpdate seqNum = ").append(class97.MF_CLASS97_c356()).toString());
                     mPositioningStats.MF_CLASS46_a157(class97.MF_CLASS97_c356());
                 }
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onPositioningResponse() calling onServiceUpdate()");
                 float f = position.getPixelPosition().getHeadingRadians();
                 float f1 = position.getMetricPosition().getRadius();
                 float f2 = position.getPixelPosition().getRadius();
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onPositioningResponse() PIXPOS calling onServiceUpdate(), X pix = ").append(position.getPixelPosition().getX()).append("Y pix = ").append(position.getPixelPosition().getY()).append("radiusMeters = ").append(f1).append(", radiusPixels = ").append(f2).toString());
                 mCalibrationService.onServiceUpdate(responseToServiceState(position, f, f1, class97.MF_CLASS97_a354()));
                 MF_CLASS78_d285(MF_CLASS85_a315(positioningresponse));
             } else
             {
                 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onPositioningResponse() **positions.size == 0**, seqNum = ").append(class97.MF_CLASS97_c356()).toString());
             }
             mPositioningStats.MF_CLASS73_b239(MF_CLASS85_b316());
             mPositioningStats.MF_CLASS46_a157(class97.MF_CLASS97_a354());
         }
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onPositioningResponse() done");
         return;
     } else
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onPositioningResponse() called : OLD POSITION");
         return;
     }
 }

 public void MF_CLASS85_b316(String s)
 {
//     MF_CLASS78_n295 = api_psm_common.UUID.fromString(s);
//     MF_CLASS78_q298.MF_CLASS24_b87(UUID.fromString(s));
 }

 public void MF_CLASS85_b316(boolean flag)
 {
     MF_CLASS78_v303 = flag;
 }

 public int getQueueSize()
 {
     return mQueue.size();
 }

 public void MF_CLASS24_c88(String s)
 {
	 mProtobufBuilder.MF_CLASS24_a86(s);
 }

 public void stopSession()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopSession() called");
     if(MF_CLASS78_f287 != null)
     {
         CLASS75.MF_CLASS75_a259(4, "POSITIONING_STOPPED_OK", WebSocketClient.class, (new StringBuilder()).append("stopSession: avgRT = ").append(CLASS75.formatDouble(mPositioningStats.getAvgRoundtrip())).append(", minRT = ").append(CLASS75.formatDouble(mPositioningStats.minRT())).append(", maxRT = ").append(CLASS75.formatDouble(mPositioningStats.maxRT())).append(", avgQ = ").append(CLASS75.formatDouble(mPositioningStats.getAvgQueueLen())).append(", minQ = ").append(CLASS75.formatDouble(mPositioningStats.minQ())).append(", maxQ = ").append(CLASS75.formatDouble(mPositioningStats.maxQ())).append(", retransmitCount = ").append(mPositioningStats.retransmitCount()).append(", createRetransmitCount = ").append(mPositioningStats.createRetransmitCount()).append(", seqNumOfFirstPosition = ").append(mPositioningStats.seqNumOfFirstPosition()).append(", connectTook = ").append(mPositioningStats.connectTook()).append(", initTook = ").append(mPositioningStats.initTook()).append(", locationService = ").append(CLASS41.locationService).toString());
         MF_CLASS78_f287 = null;
     }
     cancelReconnectTask();
     stopInitTimeoutCheck();
     stopLastPositionTimeoutCheck();
     MF_CLASS85_b316(false);
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopSession() stopInitTimeoutCheck and stopLastPositionTimeoutCheck done");
     if(MF_CLASS78_l293 == null || !MF_CLASS78_l293.isOpen())
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopSession(): Failed sending close.");
     else { 
    	 sendClose();
	     try
	     {
	         Thread.sleep(100L);
	     } catch(InterruptedException interruptedexception) { 
	     }
	     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopSession(), sendClose() done, calling connection.disconnect()");
     }
    if(MF_CLASS78_l293 != null)
        MF_CLASS78_l293.close();
    reset();
    CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "stopSession() done.");
    return;
     
 }

 public boolean MF_CLASS78_e286()
 {
     return MF_CLASS78_v303;
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "run() called");
     while(true) {
	        boolean flag;
	        PositionEvent class97;
	        if(!mIsStarted)
	            break; /* Loop/switch isn't completed */
	        if(MF_CLASS78_l293 == null || !MF_CLASS78_l293.isOpen())
	            continue;
	        flag = MF_CLASS78_g288();
	        class97 = null;
	        if(!flag) {
		        if(class97 != null && K)
		            synchronized(MF_CLASS78_o296)
		            {
		            	sendUpdate(class97);
		            }
		        try
		        {
		            Thread.sleep(25L);
		        }
		        catch(InterruptedException interruptedexception) { }
	        	
	        }

	        ArrayList arraylist = mQueue;
	        int i = mQueue.size();
	        class97 = null;
	        if(i <= 0)
	            continue;
	        PositionEvent class97_1;
	        CLASS85 class85 = (CLASS85)mQueue.remove(0);
	        class97_1 = MF_CLASS85_a315(mProtobufBuilder.wrapSensorDataToLocationMessage((CLASS24)class85.MF_CLASS85_a315, (ConcurrentLinkedQueue)class85.MF_CLASS85_b316));
	        class97_1.MF_CLASS97_a354(((CLASS22)((CLASS24)class85.MF_CLASS85_a315).magnetometerSamples.get(0)).Accuracy);
	        class97 = class97_1;
     }
     
 }

 private static ReconnectTask J = null;
 private static WebsocketConnectionThread L;
 private static Comparator MF_CLASS78_d285 = new CLASS79();
 private long A;
 private long B;
 private boolean C;
 private int D;
 private long E;
 private long F;
 private long G;
 private boolean H;
 private long I;
 private boolean K;
 protected CLASS3 mCalibrationService;
 protected CLASS15 MF_CLASS85_b316;
 private String MF_CLASS24_c88;
 private boolean mIsStarted;
 private api_psm_common.UUID MF_CLASS78_f287;
 private Integer MF_CLASS78_g288;
 private int MF_CLASS22_h78;
 private int MF_CLASS78_i290;
 private Context MF_CLASS78_j291;
 private CLASS59 MF_CLASS78_k292;
 private WebsocketConnectionService MF_CLASS78_l293;
 private ArrayList mQueue;
 private api_psm_common.UUID MF_CLASS78_n295;
 private SortedMap MF_CLASS78_o296;
 private SortedMap MF_CLASS78_p297;
 private ProtobufBuilder mProtobufBuilder;
 private RemoteImplementation mRemoteImpl;
 private CLASS47 MF_CLASS78_s300;
 private ConnectivityManager MF_CLASS78_t301;
 private boolean MF_CLASS78_u302;
 private boolean MF_CLASS78_v303;
 private CountDownTimer MF_CLASS78_w304;
 private CountDownTimer MF_CLASS78_x305;
 private PositioningStats mPositioningStats;
 private Boolean MF_CLASS78_z307;

}
