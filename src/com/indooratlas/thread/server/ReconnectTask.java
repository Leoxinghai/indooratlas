package com.indooratlas.thread.server;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import com.indooratlas.base.CLASS1;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.RemoteImplementation;
import java.util.UUID;

//import org.wuxi.READYSTATE;
import org.java_websocket.WebSocket.READYSTATE;

//Referenced classes of package com.indooratlas.thread.server:
//         WebsocketConnectionThread, CLASS90, CLASS79

class ReconnectTask extends AsyncTask
{

 private ReconnectTask(WebsocketConnectionThread class78)
 {
     super();
     MF_CLASS84_a313 = class78;
 }

 ReconnectTask(WebsocketConnectionThread class78, CLASS79 class79)
 {
     this(class78);
 }

 protected Void MF_CLASS84_a313(Void avoid[])
 {
     ConnectivityManager connectivitymanager;
     CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("ReconnectTask: doInBackground(): this = ").append(toString()).toString());
     if(WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313) != null)
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("sessionID = ").append(WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313).toString()).toString());
     if(WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313) != null)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "connection != null");
         if(WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).isOpen())
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "connection is open");
         if(WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).isConnecting())
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "connection is connecting");
     }
     if(WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313) != null && !WebsocketConnectionThread.MF_CLASS24_c88(MF_CLASS84_a313))
     {
         if(WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313) != null && !WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).isClosed() && !WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).isClosing())
         {
             CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask doInBackground(): calling sendReconnect()");
             MF_CLASS84_a313.MF_CLASS85_b316(true);
             WebsocketConnectionThread.MF_CLASS78_d285(MF_CLASS84_a313);
             WebsocketConnectionThread.MF_CLASS78_e286(MF_CLASS84_a313);
             return null;
         }
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask doInBackground(): sessionId != null but connection closed, stopping session and connecting again");
         MF_CLASS84_a313.stopSession();
         try
         {
             MF_CLASS84_a313.connect();
         }
         catch(CLASS1 class1_2)
         {
             class1_2.printStackTrace();
             return null;
         }
         return null;
     }
     if(WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313) == null)
     {
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask doInBackground(): sessionId == null -> stopping session and connecting again");
         MF_CLASS84_a313.stopSession();
         try
         {
             MF_CLASS84_a313.connect();
         }
         catch(CLASS1 class1_1)
         {
             class1_1.printStackTrace();
             return null;
         }
         return null;
     }
     if(WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313) != null)
     {
         WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).close();
         WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313, 0);
         CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground : Closed connection.");
     }
     WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313, System.currentTimeMillis());
     connectivitymanager = (ConnectivityManager)WebsocketConnectionThread.MF_CLASS78_f287(MF_CLASS84_a313).getSystemService("connectivity");

     while(true) {
	        if(isCancelled())
	        {
	            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: task has been cancelled --> returning");
	            return null;
	        }
	        MF_CLASS84_a313.MF_CLASS85_b316(true);
	        WebsocketConnectionThread.MF_CLASS78_d285(MF_CLASS84_a313);
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", (new StringBuilder()).append("ReconnectTask.doInBackground: trying to connect. this = ").append(toString()).toString());
	        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
	        if(networkinfo != null)
	            try
	            {
	                if(networkinfo.isConnectedOrConnecting() && (WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313) == null || WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313) != null && WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).getReadyState() != READYSTATE.OPEN && WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).getReadyState() != READYSTATE.CONNECTING && !isCancelled()))
	                    MF_CLASS84_a313.connect();
	            }
	            catch(CLASS1 class1) { 
	            	class1.printStackTrace();	            	
	            }
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: reconnect in progress.");
	        if(WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313) != null && WebsocketConnectionThread.MF_CLASS85_b316(MF_CLASS84_a313).getReadyState() == READYSTATE.OPEN)
	        {
	            WebsocketConnectionThread.MF_CLASS85_a315(MF_CLASS84_a313, 0);
	            MF_CLASS84_a313.MF_CLASS85_b316(false);
	            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: connection reopened successfully.");
	            return null;
	        }
	        CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: sleeping 6500ms.");
	        try
	        {
	            Thread.sleep(6500L);
	        }
	        catch(InterruptedException interruptedexception) {
	        	
	        }
	        
	        if(WebsocketConnectionThread.MF_CLASS78_g288(MF_CLASS84_a313) == 1)
	            WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS84_a313).relayPositioningWarning("Reconnecting to IndoorAtlas cloud.");
	        if(System.currentTimeMillis() - WebsocketConnectionThread.MF_CLASS78_i290(MF_CLASS84_a313) > 30000L && !isCancelled())
	        {
	            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: NOT TRYING RECONNECT, calling stopSession and remoteImplementation.relayPositioningError");
	            MF_CLASS84_a313.stopSession();
	            WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS84_a313).MF_CLASS19_a67(2001, "Could not connect to IndoorAtlas cloud.");
	            if(!isCancelled())
	            {
	                CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: isCancelled() == false --> calling serviceListener.onServiceFailure(Failed to reconnect) and remoteImplementation.onDisconnect()");
	                WebsocketConnectionThread.MF_CLASS22_h78(MF_CLASS84_a313).onDisConnect();
	            }
	            CLASS75.MF_CLASS75_b260("WebsocketConnectionService", "ReconnectTask.doInBackground: done.");
	            return null;
	        }
	    }
 }

 protected void MF_CLASS84_a313(Void void1)
 {
 }

 protected Object doInBackground(Object aobj[])
 {
     return MF_CLASS84_a313((Void[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS84_a313((Void)obj);
 }

 protected void onPreExecute()
 {
 }

 final WebsocketConnectionThread MF_CLASS84_a313;
}
