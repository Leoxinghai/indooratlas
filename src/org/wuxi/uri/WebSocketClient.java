package org.wuxi.uri;


import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import org.wuxi.*;
import org.wuxi.optcode.Framedata;
import org.wuxi.socket.Draft;
import org.wuxi.type.*;
import org.wuxi.exception.*;


//Referenced classes of package org.wuxi.uri:
//         CLASS396

public abstract class WebSocketClient extends WebSocketAdapter
 implements Runnable, WebSocket
{

 public WebSocketClient(URI uri, Draft class397, Map map, int i)
 {
     MF_CLASS89_b326 = null;
     engine = null;
     socket = null;
     proxy = Proxy.NO_PROXY;
     MF_CLASS89_k335 = new CountDownLatch(1);
     MF_CLASS89_l336 = new CountDownLatch(1);
     MF_CLASS89_m337 = 0;
     if(uri == null)
         throw new IllegalArgumentException();
     if(class397 == null)
     {
         throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
     } else
     {
         MF_CLASS89_b326 = uri;
         MF_CLASS89_i327 = class397;
         MF_CLASS89_j328 = map;
         MF_CLASS89_m337 = i;
         engine = new WebSocketImpl(this, class397);
         return;
     }
 }

 static WebSocketImpl engine(WebSocketClient class89)
 {
     return class89.engine;
 }

 static OutputStream MF_CLASS89_b326(WebSocketClient class89)
 {
     return class89.ostream;
 }

 private int getPort()
 {
     String s;
     int i = MF_CLASS89_b326.getPort();
     if(i == -1)
     {
         s = MF_CLASS89_b326.getScheme();
         if(!s.equals("wss")) {
             if(s.equals("ws"))
                 return 80;
             else
                 throw new RuntimeException((new StringBuilder()).append("unkonow scheme").append(s).toString());
         }
         i = 443;
     }
     return i;
 }

 private void sendHandshake() throws CLASS409
 {
     String s = MF_CLASS89_b326.getPath();
     String s1 = MF_CLASS89_b326.getQuery();
     if(s == null || s.length() == 0)
         s = "/";
     if(s1 != null)
         s = (new StringBuilder()).append(s).append("?").append(s1).toString();
     int i = getPort();
     StringBuilder stringbuilder = (new StringBuilder()).append(MF_CLASS89_b326.getHost());
     String s2;
     String s3;
     CLASS425 class425;
     if(i != 80)
         s2 = (new StringBuilder()).append(":").append(i).toString();
     else
         s2 = "";
     s3 = stringbuilder.append(s2).toString();
     class425 = new CLASS425();
     class425.MF_CLASS423_a1246(s);
     class425.MF_CLASS422_a1245("Host", s3);
     if(MF_CLASS89_j328 != null)
     {
         java.util.Map.Entry entry;
         for(Iterator iterator = MF_CLASS89_j328.entrySet().iterator(); iterator.hasNext(); ) {
             entry = (java.util.Map.Entry)iterator.next();
             class425.MF_CLASS422_a1245((String)entry.getKey(), (String)entry.getValue());                
         }

     }
     engine.MF_CLASS419_a1235(class425);
 }

 public void close()
 {
     if(writeThread != null)
         engine.MF_CLASS419_a1235(1000);
 }

 public void MF_CLASS429_a1255(int i, String s)
 {
 }

 public abstract void onClose(int i, String s, boolean flag);

 public abstract void onError(Exception exception);

 public abstract void onMessage(String s);

 public void setSocket(Socket _socket)
 {
     if(socket != null)
     {
         throw new IllegalStateException("socket has already been set");
     } else
     {
    	 socket = _socket;
         return;
     }
 }

 public void onMessage(ByteBuffer bytebuffer)
 {
 }

 public void MF_CLASS86_a317(WebSocket class88, int i, String s)
 {
     MF_CLASS429_a1255(i, s);
 }

 public final void onWebsocketClose(WebSocket class88, int i, String s, boolean flag)
 {
     MF_CLASS89_k335.countDown();
     MF_CLASS89_l336.countDown();
     if(writeThread != null)
    	 writeThread.interrupt();
     try
     {
         if(socket != null)
        	 socket.close();
     }
     catch(IOException ioexception)
     {
    	 onWebsocketError(((WebSocket) (this)), ((Exception) (ioexception)));
     }
     onClose(i, s, flag);
 }

 public final void onWebsocketError(WebSocket class88, Exception exception)
 {
	 onError(exception);
 }

 public final void onWebsocketMessage(WebSocket class88, String s)
 {
	 onMessage(s);
 }

 public final void onWebsocketMessage(WebSocket class88, ByteBuffer bytebuffer)
 {
	 onMessage(bytebuffer);
 }

 public void onWebsocketMessageFragment(WebSocket class88, Framedata class414)
 {
     MF_CLASS89_b326(class414);
 }

 public final void onWebsocketOpen(WebSocket class88, Handshakedata class420)
 {
     MF_CLASS89_k335.countDown();
     onOpen((ServerHandshake)class420);
 }

 public void sendFrame(Framedata class414)
 {
     engine.sendFrame(class414);
 }

 public abstract void onOpen(ServerHandshake class426);

 public void send(byte abyte0[])
 {
     engine.MF_CLASS419_a1235(abyte0);
 }

 public InetSocketAddress getLocalSocketAddress()
 {
     return engine.getLocalSocketAddress();
 }

 public void MF_CLASS89_b326(int i, String s, boolean flag)
 {
 }

 public final void MF_CLASS86_b318(WebSocket class88)
 {
 }

 public void MF_CLASS86_b318(WebSocket class88, int i, String s, boolean flag)
 {
     MF_CLASS89_b326(i, s, flag);
 }

 public void MF_CLASS89_b326(Framedata class414)
 {
 }

 public InetSocketAddress getLocalSocketAddress(WebSocket class88)
 {
     if(socket != null)
         return (InetSocketAddress)socket.getLocalSocketAddress();
     else
         return null;
 }

 public void connect()
 {
     if(writeThread != null)
     {
         throw new IllegalStateException("WebSocketClient objects are not reuseable");
     } else
     {
    	 writeThread = new Thread(this);
    	 writeThread.start();
         return;
     }
 }

 public READYSTATE getReadyState()
 {
     return engine.MF_CLASS429_h1262();
 }

 public boolean isOpen()
 {
     return engine.MF_CLASS429_d1257();
 }

 public boolean isClosed()
 {
     return engine.MF_CLASS429_g1261();
 }

 public boolean isClosing()
 {
     return engine.MF_CLASS429_e1258();
 }

 public boolean isConnecting()
 {
     return engine.MF_CLASS397_c1161();
 }

 public void run()
 {
     if(socket != null) {
         if(socket.isClosed()) {
         	return;
             //throw new IOException();
         }
     } else {
    	 socket = new Socket(proxy);
     }

     try
     {
     	
     if(!socket.isBound())
    	 socket.connect(new InetSocketAddress(MF_CLASS89_b326.getHost(), getPort()), MF_CLASS89_m337);
     istream = socket.getInputStream();
     ostream = socket.getOutputStream();
     sendHandshake();
     byte abyte0[];
     writeThread = new Thread(new WebsocketWriteThread());
     writeThread.start();
     abyte0 = new byte[WebSocketImpl.RCVBUF];

     int i;
     
	        while(true) {
		        if(isClosed())
		            break; /* Loop/switch isn't completed */
		        i = istream.read(abyte0);
		        if(i == -1)
		            break; /* Loop/switch isn't completed */
		        engine.decode(ByteBuffer.wrap(abyte0, 0, i));
	        }

         engine.eot();
         if(!MF_CLASS89_c329 && !socket.isClosed())
             throw new AssertionError();
     }
     // Misplaced declaration of an exception variable
     catch(IOException ioexception)
     {
         engine.eot();
     } catch(CLASS407 class407) {
             class407.printStackTrace();
     }
     catch(RuntimeException runtimeexception)
     {
    	 onError(runtimeexception);
         engine.closeConnection(1006, runtimeexception.getMessage());
     }
 }

 static final boolean MF_CLASS89_c329;
 private WebSocketImpl engine;
 protected URI MF_CLASS89_b326;
 private Socket socket;
 private InputStream istream;
 private OutputStream ostream;
 private Proxy proxy;
 private Thread writeThread;
 private Draft MF_CLASS89_i327;
 private Map MF_CLASS89_j328;
 private CountDownLatch MF_CLASS89_k335;
 private CountDownLatch MF_CLASS89_l336;
 private int MF_CLASS89_m337;

	private class WebsocketWriteThread implements Runnable {
		@Override
		public void run() {
			Thread.currentThread().setName( "WebsocketWriteThread" );
			try {
				while ( !Thread.interrupted() ) {
					ByteBuffer buffer = (ByteBuffer)engine.outQueue.take();
					ostream.write( buffer.array(), 0, buffer.limit() );
					ostream.flush();
				}
			} catch ( IOException e ) {
				engine.eot();
			} catch ( InterruptedException e ) {
				// this thread is regularly terminated via an interrupt
			}
		}
	} 
 
 static 
 {
     boolean flag;
     if(!WebSocketClient.class.desiredAssertionStatus())
         flag = true;
     else
         flag = false;
     MF_CLASS89_c329 = flag;
 }
}
