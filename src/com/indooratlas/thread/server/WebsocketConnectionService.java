package com.indooratlas.thread.server;


import android.os.SystemClock;
import com.indooratlas.position.PositioningStats;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.CLASS46;
import com.indooratlas.task.RemoteImplementation;
import com.indooratlas.thread.PositionEvent;
import com.indooratlas.thread.client.CLASS47;
import com.xinghai.indoor.util.ArrayUtil;
import com.xinghai.indoor.util.ExceptionManager;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.*;
//import org.wuxi.socket.Draft;
//import org.wuxi.type.ServerHandshake;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

//import org.wuxi.uri.WebSocketClient;
import org.java_websocket.client.WebSocketClient;

import com.indooratlas.communication.*;


//Referenced classes of package com.indooratlas.thread.server:
//         WebsocketConnectionThread, CLASS84, CLASS77

class WebsocketConnectionService extends WebSocketClient
{

 public WebsocketConnectionService(WebsocketConnectionThread class78, URI uri, Draft class397, Map map, int i)
 {
     super(uri, class397, map, i);
     MF_CLASS90_a338 = class78;
     MF_CLASS90_d340 = false;
 }

 private void MF_CLASS90_a338(boolean flag)
 {
     MF_CLASS90_d340 = flag;
 }

 private boolean MF_CLASS90_i339()
 {
     return MF_CLASS90_d340;
 }

 public void close()
 {
     super.close();
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "close(): setting disconnectCalled == true and calling super implementation");
     MF_CLASS90_a338(true);
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "close(): done.");
 }

 public void onClose(int i, String s, boolean flag)
 {
     CLASS46 class46 = CLASS75.getNetworkStatus(WebsocketConnectionThread.MF_CLASS78_f287(MF_CLASS90_a338));
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onClose(): reason = ").append(s).append(", code = ").append(i).append("remote: ").append(flag).append(", isDisconnectCalled = ").append(MF_CLASS90_i339()).append(", reconnectingWebSocketCounter = ").append(WebsocketConnectionThread.MF_CLASS78_g288(MF_CLASS90_a338)).append(" nsw = ").append(class46.toString()).toString());
     if(MF_CLASS90_i339())
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onClose(): isDisconnectCalled() == true, Connection closed, code: ").append(i).append(" --> no actions, return").toString());
         return;
     }
     if(!MF_CLASS90_i339() && WebsocketConnectionThread.MF_CLASS78_g288(MF_CLASS90_a338) < 5)
     {
         if(WebsocketConnectionThread.MF_CLASS78_f287() != null && WebsocketConnectionThread.MF_CLASS78_f287().getStatus() == android.os.AsyncTask.Status.RUNNING)
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onClose(): Connection closed, code: ").append(i).append(", but reconnectTask is already RUNNING -> not starting it again").toString());
             return;
         } else
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onClose(): Connection closed, code: ").append(i).append(" --> createAndStartReconnectTask();").toString());
             WebsocketConnectionThread.MF_CLASS78_x305(MF_CLASS90_a338);
             return;
         }
     } else
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onClose(): LAST ELSE Connection closed, code: ").append(i).append(" --> do nothing...").toString());
         return;
     }
 }

 public void onError(Exception exception)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onError(): Exception: ").append(exception.toString()).append(", STACK: ").append(CLASS75.MF_CLASS75_a259(exception)).toString());
 }

 public void onMessage(String s)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onMessage(): Got string message, should not happen, discarding.");
 }

 public void onBinaryMessage(ByteBuffer bytebuffer)
 {
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage() called Thread = ").append(Thread.currentThread().getName()).toString());
     if(MF_CLASS90_i339()) {
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onMessage() isDisconnectCalled() == true --> no actions, return");
	        return;
     }
     
     long l;
     com.indooratlas.communication.api_psm_response.PSMResponse psmresponse;
     l = SystemClock.elapsedRealtime();
     try
     {
         psmresponse = com.indooratlas.communication.api_psm_response.PSMResponse.parseFrom(bytebuffer.array());
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage() sequence number: ").append(psmresponse.getSequenceNumber()).toString());
         if(psmresponse.getType() == 1)
         {
             WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338, WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338, psmresponse.getConnected().getSessionId()));
             WebsocketConnectionThread.MF_CLASS78_r299(MF_CLASS90_a338).MF_CLASS24_a86(WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338));
             WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS90_a338, true);
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): got CONNECTED. SessionId = ").append(WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338).toString()).toString());
             return;
         }
     }
     catch(Exception exceptionmanager)
     {
    	 exceptionmanager.printStackTrace();
    	 CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage(): failed to parse LocationMessage ");
         return;
     }
     int j;
//     if(psmresponse.getType() != 2)
//         break MISSING_BLOCK_LABEL_951;
     j = psmresponse.getSequenceNumber();
     
     if(!WebsocketConnectionThread.MF_CLASS78_n295(MF_CLASS90_a338).containsKey(Integer.valueOf(j)))
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage() : sentMessageContainers.containsKey(sequenceNumber) == false");
         return;
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage(): bufferedMessageContainers.containsKey(sequenceNumber) == true.");
     if(j <= 1 + WebsocketConnectionThread.MF_CLASS78_s300(MF_CLASS90_a338)) {
         if(j < 1 + WebsocketConnectionThread.MF_CLASS78_s300(MF_CLASS90_a338))
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage(): packet already received.");
             return;
         }
     }
     if(WebsocketConnectionThread.MF_CLASS78_t301(MF_CLASS90_a338).containsKey(Integer.valueOf(j))) {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage(): no missing packets.");
         return;
     	
     }
     
     PositionEvent class97_1;
     synchronized(WebsocketConnectionThread.MF_CLASS78_n295(MF_CLASS90_a338))
     {
         class97_1 = (PositionEvent)WebsocketConnectionThread.MF_CLASS78_n295(MF_CLASS90_a338).remove(Integer.valueOf(j));
     }
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage() sequence number: ").append(j).append(" removed from sentMessageContainers : ").append(class97_1).toString());
     class97_1.MF_CLASS97_a354(l);
     if(psmresponse.hasPayload())
         class97_1.MF_CLASS97_a354(positioning_response.PositioningResponse.parseFrom(psmresponse.getPayload().backupArray()));
     WebsocketConnectionThread.MF_CLASS78_t301(MF_CLASS90_a338).put(Integer.valueOf(j), class97_1);
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): buffered message: ").append(psmresponse.getSequenceNumber()).toString());
//_L3:
     SortedSet sortedset = WebsocketConnectionThread.MF_CLASS78_u302(MF_CLASS90_a338);
     if(sortedset.size() > 0)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): packet(s) missing, asking for retransmit for: ").append(Arrays.toString(sortedset.toArray())).toString());
         WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338, sortedset);
         return;
     }
//     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage(): bufferedMessageContainers.containsKey(sequenceNumber) == true.");
//       goto _L3
     
     
     
     PositionEvent class97;
     positioning_response.PositioningResponse positioningresponse;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): last created packet number (not necessarily sent yet):").append(WebsocketConnectionThread.MF_CLASS78_v303(MF_CLASS90_a338)).append(", received ").append(j).toString());
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): has binary payload:").append(psmresponse.hasPayload()).toString());
     class97 = (PositionEvent)WebsocketConnectionThread.MF_CLASS78_n295(MF_CLASS90_a338).remove(Integer.valueOf(j));
     class97.MF_CLASS97_a354(l);
     WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS90_a338, psmresponse.getSequenceNumber());
     
     if(!psmresponse.hasPayload()) {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): message had no payload, checking if this is the first BG calib value. sequenceNumber == ").append(j).toString());
         if(j == 1) {
 	        MF_CLASS90_a338.onPositioningResponse(class97);
 	        Iterator iterator = WebsocketConnectionThread.MF_CLASS78_t301(MF_CLASS90_a338).keySet().iterator();
 	        while(iterator.hasNext())
 	        {
 	            Integer integer = (Integer)iterator.next();
 	            if(integer.intValue() == 1 + WebsocketConnectionThread.MF_CLASS78_s300(MF_CLASS90_a338))
 	            {
 	                MF_CLASS90_a338.onPositioningResponse((PositionEvent)WebsocketConnectionThread.MF_CLASS78_t301(MF_CLASS90_a338).get(integer));
 	                WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS90_a338, integer.intValue());
 	            }
 	        }
 	        return;
         }
         return;
     }
     positioningresponse = positioning_response.PositioningResponse.parseFrom(psmresponse.getPayload().backupArray());
     class97.MF_CLASS97_a354(positioningresponse);
     
     if(positioningresponse.getType() == 1)
     {
         MF_CLASS90_a338.onInitializationResponse(class97);
         return;
     } else if(positioningresponse.getType() == 2) {
	        MF_CLASS90_a338.onPositioningResponse(class97);
	        Iterator iterator1 = WebsocketConnectionThread.MF_CLASS78_t301(MF_CLASS90_a338).keySet().iterator();
	        while(iterator1.hasNext())
	        {
	            Integer integer1 = (Integer)iterator1.next();
	            if(integer1.intValue() == 1 + WebsocketConnectionThread.MF_CLASS78_s300(MF_CLASS90_a338))
	            {
	                MF_CLASS90_a338.onPositioningResponse((PositionEvent)WebsocketConnectionThread.MF_CLASS78_t301(MF_CLASS90_a338).get(integer1));
	                WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS90_a338, integer1.intValue());
	            }
	        }
     } else if(psmresponse.getType() == 3) {
	        if(!MF_CLASS90_a338.MF_CLASS78_e286()) {
		        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): response-error: ").append(psmresponse.getError().getErrorMessage()).append(" --> calling remoteImplementation.doStopSessionDueToError").toString());
		        String s = psmresponse.getError().getErrorMessage();
		        int i = psmresponse.getError().getErrorCode();
		        WebsocketConnectionThread.MF_CLASS78_j291(MF_CLASS90_a338);
		        WebsocketConnectionThread.MF_CLASS78_w304(MF_CLASS90_a338);
		        WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS90_a338).doStopSessionDueToError(i, s);
		        MF_CLASS90_a338.stopSession();
		        return;
	        }
	        return;
	    } else if(psmresponse.getType() == 4)
		{
			List list = psmresponse.getRetransmit().getControlSequenceNumbersList();
			CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onBinaryMessage(): got a retransmit request for packet numbers: ").append(Arrays.toString(list.toArray())).toString());
			WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338, list);
			return;
		} else {
			CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onBinaryMessage(): unknown message type received.");
			return;
		}
 }

 public void onOpen(ServerHandshake class426)
 {
     if(MF_CLASS90_i339())
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onOpen() isDisconnectCalled() == true --> no actions, return");
         return;
     }
     try {
	        SortedMap sortedmap = WebsocketConnectionThread.MF_CLASS78_n295(MF_CLASS90_a338);
	        WebsocketConnectionThread.MF_CLASS78_o296(MF_CLASS90_a338).MF_CLASS73_b239(System.currentTimeMillis() - WebsocketConnectionThread.MF_CLASS78_i290(MF_CLASS90_a338));
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("onOpen() called, reconnectingWebSocketCounter = ").append(WebsocketConnectionThread.MF_CLASS78_g288(MF_CLASS90_a338)).append(", connect_took : ").append(WebsocketConnectionThread.MF_CLASS78_o296(MF_CLASS90_a338).connectTook()).toString());
	        if(WebsocketConnectionThread.MF_CLASS78_g288(MF_CLASS90_a338) <= 0) {
	            WebsocketConnectionThread.MF_CLASS78_q298(MF_CLASS90_a338);
	            WebsocketConnectionThread.MF_CLASS78_p297(MF_CLASS90_a338).onConnect();
	            return;
	        }
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onOpen() reconnectingWebSocket == true --> reconnect()");
	        CLASS75.MF_CLASS75_a259(4, "WEBSOCKET_ONOPEN", WebSocketClient.class, (new StringBuilder()).append("onOpen: reconnectingWebSocket == true, calling reconnect() reconnectingWebSocketCounter = ").append(WebsocketConnectionThread.MF_CLASS78_g288(MF_CLASS90_a338)).append(", getNetworkStatus = ").append(CLASS75.getNetworkStatus(WebsocketConnectionThread.MF_CLASS78_f287(MF_CLASS90_a338)).toString()).toString());
	        WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS90_a338, 0);
	        if(!WebsocketConnectionThread.MF_CLASS24_c88(MF_CLASS90_a338)) {
	                CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onOpen() : isPositioningSessionAlive() == false --> webSocketConnectionListener.onConnect();");
	                WebsocketConnectionThread.MF_CLASS78_p297(MF_CLASS90_a338).onConnect();
	        } else {
		        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "onOpen() : isPositioningSessionAlive() == true --> calling reconnect()");
		        WebsocketConnectionThread.MF_CLASS78_e286(MF_CLASS90_a338);
	        }
	        return;
     } catch(Exception exception) {
     	exception.printStackTrace();
//     throw exception;
     }
 }

 final WebsocketConnectionThread MF_CLASS90_a338;
 private boolean MF_CLASS90_d340;
}
