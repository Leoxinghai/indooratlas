package org.wuxi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.wuxi.exception.CLASS406;
import org.wuxi.exception.CLASS407;
import org.wuxi.exception.CLASS409;
import org.wuxi.exception.CLASS412;
import org.wuxi.optcode.Framedata;
import org.wuxi.optcode.CLASS415;
import org.wuxi.optcode.CLASS418;
import org.wuxi.optcode.CLASS419;
import org.wuxi.save.CLASS432;
import org.wuxi.socket.Draft;
import org.wuxi.socket.CLASS398;
import org.wuxi.socket.CLASS399;
import org.wuxi.socket.CLASS400;
import org.wuxi.socket.Draft_17;
import org.wuxi.socket.CLASS403;
import org.wuxi.socket.CLASS404;
import org.wuxi.type.Handshakedata;
import org.wuxi.type.CLASS421;
import org.wuxi.type.CLASS423;
import org.wuxi.type.ServerHandshake;

	// Referenced classes of package org.wuxi:
//	            CLASS88, READYSTATE, Role, WebSocketListener

	public class WebSocketImpl
	    implements WebSocket
	{

	    public WebSocketImpl(WebSocketListener class86, Draft class397)
	    {
	        MF_CLASS429_i1263 = false;
	        MF_CLASS429_j1264 = READYSTATE.NOT_YET_CONNECTED;
	        MF_CLASS429_m1265 = null;
	        MF_CLASS429_o1266 = null;
	        MF_CLASS429_p1267 = ByteBuffer.allocate(0);
	        MF_CLASS429_q1268 = null;
	        MF_CLASS429_r1269 = null;
	        MF_CLASS429_s1270 = null;
	        MF_CLASS429_t1271 = null;
	        MF_CLASS429_u1272 = null;
	        if(class86 == null || class397 == null && MF_CLASS429_n1273 == Role.MF_CLASS413_b1213)
	            throw new IllegalArgumentException("parameters must not be null");
	        MF_CLASS429_k1274 = class86;
	        MF_CLASS429_n1273 = Role.MF_CLASS413_a1212;
	        if(class397 != null)
	            MF_CLASS429_m1265 = class397.MF_CLASS397_c1161();
	    }

	    private void MF_CLASS419_a1235(Collection collection)
	    {
	        if(!MF_CLASS429_d1257())
	            throw new CLASS412();
	        for(Iterator iterator = collection.iterator(); iterator.hasNext(); sendFrame((Framedata)iterator.next()));
	    }

	    private void MF_CLASS419_a1235(List list)
	    {
	        for(Iterator iterator = list.iterator(); iterator.hasNext(); MF_CLASS419_f1240((ByteBuffer)iterator.next()));
	    }

	    private void MF_CLASS419_a1235(Handshakedata class420)
	    {
	        if(MF_CLASS405_b1205)
	            System.out.println((new StringBuilder()).append("open using draft: ").append(MF_CLASS429_m1265.getClass().getSimpleName()).toString());
	        MF_CLASS429_j1264 = READYSTATE.OPEN;
	        try
	        {
	            MF_CLASS429_k1274.onWebsocketOpen(this, class420);
	            return;
	        }
	        catch(RuntimeException runtimeexception)
	        {
	            MF_CLASS429_k1274.onWebsocketError(this, runtimeexception);
	        }
	    }

	    private void close(int i, String s, boolean flag)
	    {
	        try {
		    	if(MF_CLASS429_j1264 != READYSTATE.CLOSING && MF_CLASS429_j1264 != READYSTATE.CLOSED)
		        {
		            if(!MF_CLASS429_h1262 && flag)
		                throw new AssertionError();
		            MF_CLASS429_j1264 = READYSTATE.CLOSING;
		            flushAndClose(i, s, false);
		            return;
		        }
		
		        if(MF_CLASS429_j1264 != READYSTATE.OPEN) {
		            if(i == -3)
		            {
		                if(!MF_CLASS429_h1262 && !flag)
		                    throw new AssertionError();
		                flushAndClose(-3, s, true);
		            } else
		            {
		            	flushAndClose(-1, s, false);
		            }
		            
		        }  else if(i != 1006) {
			        
			        if(MF_CLASS429_m1265.MF_CLASS397_b1160() == CLASS398.MF_CLASS398_a1164) {
				        if(flag) {
				            CLASS407 class407 = null;
				            MF_CLASS429_k1274.onWebsocketError(this, class407);
				            flushAndClose(1006, "generated frame is invalid", false);
				        } else { 
				        	MF_CLASS429_k1274.MF_CLASS86_a317(this, i, s);
				        	sendFrame(new CLASS418(i, s));
				        }
			        }
			        flushAndClose(i, s, flag);
		        }
		        
		        if(i == 1002)
		        	flushAndClose(i, s, flag);
		        MF_CLASS429_j1264 = READYSTATE.CLOSING;
		        MF_CLASS429_p1267 = null;
		        return;
		        
	        } catch(RuntimeException runtimeexception) {
	        	MF_CLASS429_k1274.onWebsocketError(this, runtimeexception);
	        }
	          
	    }

	    private boolean MF_CLASS397_c1161(ByteBuffer bytebuffer)
	    {
	        ByteBuffer bytebuffer1 = bytebuffer;
	        CLASS399 class399_2;
	        CLASS399 class399_3;
	        
	        try {
	        	

	        if(MF_CLASS429_p1267.capacity() == 0)
	        {
	            bytebuffer1 = bytebuffer;
	        } else
	        {
	            if(MF_CLASS429_p1267.remaining() < bytebuffer.remaining())
	            {
	                ByteBuffer bytebuffer2 = ByteBuffer.allocate(MF_CLASS429_p1267.capacity() + bytebuffer.remaining());
	                MF_CLASS429_p1267.flip();
	                bytebuffer2.put(MF_CLASS429_p1267);
	                MF_CLASS429_p1267 = bytebuffer2;
	            }
	            MF_CLASS429_p1267.put(bytebuffer);
	            MF_CLASS429_p1267.flip();
	            bytebuffer1 = MF_CLASS429_p1267;
	        }
	        bytebuffer1.mark();
	        if(MF_CLASS429_m1265 == null) {
		        class399_2 = MF_CLASS429_e1258(bytebuffer1);
		        class399_3 = CLASS399.MF_CLASS399_a1168;
		        if(class399_2 == class399_3) {
			        MF_CLASS419_f1240(ByteBuffer.wrap(CLASS432.a(MF_CLASS429_k1274.getFlashPolicy(this))));
			        MF_CLASS419_a1235(-3, "");
		        }
	        } else {
	            if(MF_CLASS429_n1273 != Role.MF_CLASS413_b1213) {
	                if(MF_CLASS429_n1273 == Role.MF_CLASS413_a1212) {
	        	        Handshakedata class420;
	        	        MF_CLASS429_m1265.MF_CLASS413_a1212(MF_CLASS429_n1273);
	        	        class420 = MF_CLASS429_m1265.MF_CLASS397_d1162(bytebuffer1);
	        	        if(class420 instanceof ServerHandshake) {
	        	        	ServerHandshake class426;
	        	            CLASS399 class399;
	        	            CLASS399 class399_1;
	        	            class426 = (ServerHandshake)class420;
	        	            class399 = MF_CLASS429_m1265.MF_CLASS413_a1212(MF_CLASS429_q1268, class426);
	        	            class399_1 = CLASS399.MF_CLASS399_a1168;
	        	            if(class399 != class399_1) {
	        	                MF_CLASS419_a1235(1002, (new StringBuilder()).append("draft ").append(MF_CLASS429_m1265).append(" refuses handshake").toString());
	        	                return false;
	        	            }
	        	            MF_CLASS429_k1274.MF_CLASS86_a317(this, MF_CLASS429_q1268, class426);
	        	            MF_CLASS419_a1235(class426);
	        	            return true;
	        	        	
	        	        }
	        	        flushAndClose(1002, "wrong http function", false);
	        	        return false;
	                } else {
	                	return false;        	
	                }
	            } else { 
	                if(MF_CLASS429_m1265 != null) {
	                    Handshakedata class420_1;
	                    class420_1 = MF_CLASS429_m1265.MF_CLASS397_d1162(bytebuffer1);
	                    if(class420_1 instanceof CLASS421) {
	                        CLASS421 class421 = (CLASS421)class420_1;
	                        if(MF_CLASS429_m1265.MF_CLASS413_a1212(class421) != CLASS399.MF_CLASS399_a1168) {
	                            MF_CLASS419_a1235(1002, "the handshake did finaly not match");
	                            return false;
	                        }
	                        MF_CLASS419_a1235(class421);
	                        return true;
	                    }
	                    flushAndClose(1002, "wrong http function", false);
	                    return false;        	
	                }
	                Iterator iterator = MF_CLASS429_l1275.iterator();
	                for(;iterator.hasNext();) {  
	        	        Draft class397 = ((Draft)iterator.next()).MF_CLASS397_c1161();
	        	        Handshakedata class420_2;
	        	        class397.MF_CLASS413_a1212(MF_CLASS429_n1273);
	        	        bytebuffer1.reset();
	        	        class420_2 = class397.MF_CLASS397_d1162(bytebuffer1);
	        	        if(class420_2 instanceof CLASS421) {
	            	        CLASS421 class421_1 = (CLASS421)class420_2;
	            	        if(class397.MF_CLASS413_a1212(class421_1) == CLASS399.MF_CLASS399_a1168) {
	            		        MF_CLASS429_u1272 = class421_1.MF_CLASS421_a1244();
	            		        org.wuxi.type.CLASS427 class427 = MF_CLASS429_k1274.MF_CLASS86_a317(this, class397, class421_1);
	            		        MF_CLASS419_a1235(class397.MF_CLASS413_a1212(class397.MF_CLASS413_a1212(class421_1, class427), MF_CLASS429_n1273));
	            		        MF_CLASS429_m1265 = class397;
	            		        MF_CLASS419_a1235(class421_1);
	            		        return true;
	            	        }        	
	        	        } else {
	        	        	flushAndClose(1002, "wrong http function", false);
	        		        return false;
	        	        }
	        	    }
	                if(MF_CLASS429_m1265 == null)
	                    MF_CLASS419_a1235(1002, "no draft matches");
	                return false;
	            }
	        }
	        return false;
	        
	/*        
	        } catch(CLASS407 class407_2) {
		        MF_CLASS397_c1161(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
		        return false;
	*/	        
	        } catch(CLASS406 class406) {
		        if(MF_CLASS429_p1267.capacity() != 0) {
		            MF_CLASS429_p1267.position(MF_CLASS429_p1267.limit());
		            MF_CLASS429_p1267.limit(MF_CLASS429_p1267.capacity());
		        } else {
			        int i;
			        bytebuffer1.reset();
			        i = class406.MF_CLASS406_a1210();
			        if(i != 0) {
			            if(!MF_CLASS429_h1262 && class406.MF_CLASS406_a1210() < bytebuffer1.remaining()) {
			                throw new AssertionError();
			            }
			        } else {
			        	i = 16 + bytebuffer1.capacity();
			        }
			        MF_CLASS429_p1267 = ByteBuffer.allocate(i);
			        MF_CLASS429_p1267.put(bytebuffer);
		        }
		        return false;
		        
	        } catch(CLASS409 class409) {
		        MF_CLASS419_a1235(class409);
		        return false;
	        } catch(CLASS407 class407_1) {
	        	flushAndClose(class407_1.MF_CLASS407_a1211(), class407_1.getMessage(), false);
		        return false;
	        } catch(RuntimeException runtimeexception) {
		        MF_CLASS429_k1274.onWebsocketError(this, runtimeexception);
		        flushAndClose(-1, runtimeexception.getMessage(), false);
		        return false;
		        
	        }
	        
	    }

	    private void decodeFrames(ByteBuffer bytebuffer) throws CLASS407
	    {
	        Iterator iterator = MF_CLASS429_m1265.MF_CLASS397_c1161(bytebuffer).iterator();
	        for(;iterator.hasNext();) {
	        	try {
		        Framedata class414;
		        CLASS419 class419;
		        boolean flag;
		        class414 = (Framedata)iterator.next();
		        if(MF_CLASS405_b1205)
		            System.out.println((new StringBuilder()).append("matched frame: ").append(class414).toString());
		        class419 = class414.getOpcode();
		        flag = class414.isFin();
		        
		        if(class419 == CLASS419.CLOSING) {
			        String s;
			        int i;
			        if(!(class414 instanceof CLASS415)) {
			            s = "";
			            i = 1005;
			        } else {
				        CLASS415 class415 = (CLASS415)class414;
				        i = class415.MF_CLASS415_a1219();
				        s = class415.MF_CLASS415_b1220();
			        }
			        if(MF_CLASS429_j1264 != READYSTATE.CLOSING) {
		                if(MF_CLASS429_m1265.MF_CLASS397_b1160() != CLASS398.MF_CLASS398_c1166) {
		                	flushAndClose(i, s, false);
		                } else {
		                	close(i, s, true);
		                }
			        } else {
				        CLASS407 class407;
				        MF_CLASS419_a1235(i, s, true);
			        }
		        } else if(class419 == CLASS419.PING) {
		            	MF_CLASS429_k1274.MF_CLASS86_b318(this, class414);
		        } else if(class419 == CLASS419.PONG) {
		            	MF_CLASS429_k1274.MF_CLASS86_c319(this, class414);
		        }
		        
	            if(!flag) {
	                if(MF_CLASS429_o1266 != null) { 
	                        MF_CLASS429_k1274.onWebsocketMessageFragment(this, class414);
	                } else { 
	                    throw new CLASS407(1002, "Continuous frame sequence was not started.");
//	                    if(MF_CLASS429_o1266 != null)
//	                        throw new CLASS407(1002, "Continuous frame sequence not completed.");
	                }                    
	            }
	            if(class419 == CLASS419.CONTINUOUS) {
	                if(!flag)
	                    continue; /* Loop/switch isn't completed */
	                if(MF_CLASS429_o1266 == null)
	                    throw new CLASS407(1002, "Continuous frame sequence was not started.");
	                MF_CLASS429_o1266 = null;
	            }
	            
		        if(MF_CLASS429_o1266 != null)
		            throw new CLASS407(1002, "Previous continuous frame sequence not completed.");
		        MF_CLASS429_o1266 = class419;
	            
		        if(class419 == CLASS419.BINARY) {
		            	MF_CLASS429_k1274.onWebsocketMessage(this, class414.getPayloadData());
		        } else if(class419 == CLASS419.TEXT) {
			            MF_CLASS429_k1274.onWebsocketMessage(this, CLASS432.a(class414.getPayloadData()));
	             } else {
	 	            try
	 	            {
	 	               throw new CLASS407(1002, "non control or continious frame expected");
	 	            }
	 	            // Misplaced declaration of an exception variable
	 	            catch(CLASS407 class407)
	 	            {
	 	               MF_CLASS429_k1274.onWebsocketError(this, class407);
	 	               MF_CLASS419_a1235(class407);
	 	            }
	 	            return;
		         }
		        
	        	} catch(RuntimeException runtimeexception2) {
	        		MF_CLASS429_k1274.onWebsocketError(this, runtimeexception2);
	        	}
		        
	       }
	        return;
	          
	          
	    }
	    
	    
	    private CLASS399 MF_CLASS429_e1258(ByteBuffer bytebuffer)
	    {
	        bytebuffer.mark();
	        if(bytebuffer.limit() > Draft.MF_CLASS397_c1161.length)
	            return CLASS399.MF_CLASS399_b1169;
	        if(bytebuffer.limit() < Draft.MF_CLASS397_c1161.length)
	            throw new CLASS406(Draft.MF_CLASS397_c1161.length);
	        for(int i = 0; bytebuffer.hasRemaining(); i++)
	            if(Draft.MF_CLASS397_c1161[i] != bytebuffer.get())
	            {
	                bytebuffer.reset();
	                return CLASS399.MF_CLASS399_b1169;
	            }

	        return CLASS399.MF_CLASS399_a1168;
	    }

	    private void MF_CLASS419_f1240(ByteBuffer bytebuffer)
	    {
	        if(MF_CLASS405_b1205)
	        {
	            PrintStream printstream = System.out;
	            StringBuilder stringbuilder = (new StringBuilder()).append("write(").append(bytebuffer.remaining()).append("): {");
	            String s;
	            if(bytebuffer.remaining() > 1000)
	                s = "too big to display";
	            else
	                s = new String(bytebuffer.array());
	            printstream.println(stringbuilder.append(s).append("}").toString());
	        }
	        outQueue.add(bytebuffer);
	        MF_CLASS429_k1274.MF_CLASS86_b318(this);
	    }

	    public void eot()
	    {
	        if(MF_CLASS429_h1262() == READYSTATE.NOT_YET_CONNECTED)
	        {
	            MF_CLASS419_a1235(-1, true);
	            return;
	        }
	        if(MF_CLASS429_i1263)
	        {
	            MF_CLASS419_a1235(MF_CLASS429_s1270.intValue(), MF_CLASS429_r1269, MF_CLASS429_t1271.booleanValue());
	            return;
	        }
	        if(MF_CLASS429_m1265.MF_CLASS397_b1160() == CLASS398.MF_CLASS398_a1164)
	        {
	            MF_CLASS419_a1235(1000, true);
	            return;
	        }
	        if(MF_CLASS429_m1265.MF_CLASS397_b1160() == CLASS398.MF_CLASS398_b1165)
	        {
	            if(MF_CLASS429_n1273 == Role.MF_CLASS413_b1213)
	            {
	                MF_CLASS419_a1235(1006, true);
	                return;
	            } else
	            {
	                MF_CLASS419_a1235(1000, true);
	                return;
	            }
	        } else
	        {
	            MF_CLASS419_a1235(1006, true);
	            return;
	        }
	    }

	    public void MF_CLASS419_a1235(int i)
	    {
	    	close(i, "", false);
	    }

	    public void MF_CLASS419_a1235(int i, String s)
	    {
	    	close(i, s, false);
	    }

	    protected void MF_CLASS419_a1235(int i, String s, boolean flag)
	    {
	        READYSTATE class405;
	        READYSTATE class405_1;
	        class405 = MF_CLASS429_j1264;
	        class405_1 = READYSTATE.CLOSED;
	        if(class405 == class405_1) {
	        	return;
	        }
	        
	        ByteChannel bytechannel;
	        if(MF_CLASS429_d1257 != null)
	            MF_CLASS429_d1257.cancel();
	        bytechannel = MF_CLASS429_e1258;
	        try {
	        try {
		        if(bytechannel != null) {
		        	MF_CLASS429_e1258.close();
		        }
	        } catch(IOException ioexception) {
	        	MF_CLASS429_k1274.onWebsocketError(this, ioexception);
	        }
	        
	        MF_CLASS429_k1274.onWebsocketClose(this, i, s, flag);
	        

	        } catch(RuntimeException runtimeexception) {
	        	MF_CLASS429_k1274.onWebsocketError(this, runtimeexception);
	        }
	        
	        if(MF_CLASS429_m1265 != null)
	            MF_CLASS429_m1265.MF_CLASS413_a1212();
	        MF_CLASS429_q1268 = null;
	        MF_CLASS429_j1264 = READYSTATE.CLOSED;
	        outQueue.clear();
	        return;
	        
	    }

	    protected void MF_CLASS419_a1235(int i, boolean flag)
	    {
	        MF_CLASS419_a1235(i, "", flag);
	    }

	    public void decode(ByteBuffer bytebuffer) throws AssertionError, CLASS407
	    {
	        if(!MF_CLASS429_h1262 && !bytebuffer.hasRemaining())
	            throw new AssertionError();
	        if(MF_CLASS405_b1205)
	        {
	            PrintStream printstream = System.out;
	            StringBuilder stringbuilder = (new StringBuilder()).append("process(").append(bytebuffer.remaining()).append("): {");
	            String s;
	            if(bytebuffer.remaining() > 1000)
	                s = "too big to display";
	            else
	                s = new String(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining());
	            printstream.println(stringbuilder.append(s).append("}").toString());
	        }
	        if(MF_CLASS429_j1264 != READYSTATE.NOT_YET_CONNECTED)
	        	decodeFrames(bytebuffer);
	        else
	        if(MF_CLASS397_c1161(bytebuffer))
	        {
	            if(!MF_CLASS429_h1262 && MF_CLASS429_p1267.hasRemaining() == bytebuffer.hasRemaining() && bytebuffer.hasRemaining())
	                throw new AssertionError();
	            if(bytebuffer.hasRemaining())
	            	decodeFrames(bytebuffer);
	            else
	            if(MF_CLASS429_p1267.hasRemaining())
	            	decodeFrames(MF_CLASS429_p1267);
	        }
	        if(!MF_CLASS429_h1262 && !MF_CLASS429_e1258() && !MF_CLASS419_f1240() && bytebuffer.hasRemaining())
	            throw new AssertionError();
	        else
	            return;
	    }

	    public void MF_CLASS419_a1235(CLASS407 class407)
	    {
	    	close(class407.MF_CLASS407_a1211(), class407.getMessage(), false);
	    }

	    public void sendFrame(Framedata class414)
	    {
	        if(MF_CLASS405_b1205)
	            System.out.println((new StringBuilder()).append("send frame: ").append(class414).toString());
	        MF_CLASS419_f1240(MF_CLASS429_m1265.MF_CLASS413_a1212(class414));
	    }

	    public void MF_CLASS419_a1235(CLASS423 class423) throws CLASS409
	    {
	        try
	        {
		        if(!MF_CLASS429_h1262 && MF_CLASS429_j1264 == READYSTATE.CONNECTING)
		            throw new AssertionError("shall only be called once");
		        MF_CLASS429_q1268 = MF_CLASS429_m1265.MF_CLASS413_a1212(class423);
		        MF_CLASS429_u1272 = class423.MF_CLASS421_a1244();
		        if(!MF_CLASS429_h1262 && MF_CLASS429_u1272 == null)
		        	throw new AssertionError();
	            MF_CLASS429_k1274.MF_CLASS86_a317(this, MF_CLASS429_q1268);
	        }
	/*        
	        catch(CLASS407 class407)
	        {
	            throw new CLASS409("Handshake data rejected by client.");
	        }
	*/        
	        catch(RuntimeException runtimeexception)
	        {
	            MF_CLASS429_k1274.onWebsocketError(this, runtimeexception);
	            throw new CLASS409((new StringBuilder()).append("rejected because of").append(runtimeexception).toString());
	        }
	        MF_CLASS419_a1235(MF_CLASS429_m1265.MF_CLASS413_a1212(MF_CLASS429_q1268, MF_CLASS429_n1273));
	    }

	    public void MF_CLASS419_a1235(byte abyte0[])
	    {
	        MF_CLASS405_b1205(ByteBuffer.wrap(abyte0));
	    }

	    public InetSocketAddress getLocalSocketAddress()
	    {
	        return MF_CLASS429_k1274.getLocalSocketAddress(this);
	    }

	    public void closeConnection(int i, String s)
	    {
	        MF_CLASS419_a1235(i, s, false);
	    }

	    protected void flushAndClose(int i, String s, boolean flag)
	    {
	        boolean flag1 = MF_CLASS429_i1263;
	        if(flag1)
	        	return;
	        try {
		        MF_CLASS429_s1270 = Integer.valueOf(i);
		        MF_CLASS429_r1269 = s;
		        MF_CLASS429_t1271 = Boolean.valueOf(flag);
		        MF_CLASS429_i1263 = true;
		        MF_CLASS429_k1274.MF_CLASS86_b318(this);
		        MF_CLASS429_k1274.MF_CLASS86_b318(this, i, s, flag);
		        
		        if(MF_CLASS429_m1265 != null)
		            MF_CLASS429_m1265.MF_CLASS413_a1212();
		        MF_CLASS429_q1268 = null;
		        return;
		        
	        } catch(RuntimeException runtimeexception) {
	        	MF_CLASS429_k1274.onWebsocketError(this, runtimeexception);
	        }
	    }

	    public void MF_CLASS405_b1205(ByteBuffer bytebuffer)
	    {
	        if(bytebuffer == null)
	            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
	        Draft class397 = MF_CLASS429_m1265;
	        boolean flag;
	        if(MF_CLASS429_n1273 == Role.MF_CLASS413_a1212)
	            flag = true;
	        else
	            flag = false;
	        MF_CLASS419_a1235(class397.MF_CLASS413_a1212(bytebuffer, flag));
	    }

	    public boolean MF_CLASS397_c1161()
	    {
	        if(MF_CLASS429_h1262 || !MF_CLASS429_i1263 || MF_CLASS429_j1264 == READYSTATE.CONNECTING)
	            return MF_CLASS429_j1264 == READYSTATE.CONNECTING;
	        else
	            throw new AssertionError();
	    }

	    public boolean MF_CLASS429_d1257()
	    {
	        if(MF_CLASS429_h1262 || MF_CLASS429_j1264 != READYSTATE.OPEN || !MF_CLASS429_i1263)
	            return MF_CLASS429_j1264 == READYSTATE.OPEN;
	        else
	            throw new AssertionError();
	    }

	    public boolean MF_CLASS429_e1258()
	    {
	        return MF_CLASS429_j1264 == READYSTATE.CLOSING;
	    }

	    public boolean MF_CLASS419_f1240()
	    {
	        return MF_CLASS429_i1263;
	    }

	    public boolean MF_CLASS429_g1261()
	    {
	        return MF_CLASS429_j1264 == READYSTATE.CLOSED;
	    }

	    public READYSTATE MF_CLASS429_h1262()
	    {
	        return MF_CLASS429_j1264;
	    }

	    public int hashCode()
	    {
	        return hashCode();
	    }

	    public String toString()
	    {
	        return toString();
	    }

	    public static int RCVBUF = 16384;
	    public static boolean MF_CLASS405_b1205 = false;
	    public static final List MF_CLASS397_c1161;
	    static final boolean MF_CLASS429_h1262;
	    public SelectionKey MF_CLASS429_d1257;
	    public ByteChannel MF_CLASS429_e1258;
	    public final BlockingQueue outQueue = new LinkedBlockingQueue();
	    public final BlockingQueue MF_CLASS429_g1261 = new LinkedBlockingQueue();
	    private boolean MF_CLASS429_i1263;
	    private READYSTATE MF_CLASS429_j1264;
	    private final WebSocketListener MF_CLASS429_k1274;
	    private List MF_CLASS429_l1275;
	    private Draft MF_CLASS429_m1265;
	    private Role MF_CLASS429_n1273;
	    private CLASS419 MF_CLASS429_o1266;
	    private ByteBuffer MF_CLASS429_p1267;
	    private CLASS421 MF_CLASS429_q1268;
	    private String MF_CLASS429_r1269;
	    private Integer MF_CLASS429_s1270;
	    private Boolean MF_CLASS429_t1271;
	    private String MF_CLASS429_u1272;

	    static 
	    {
	        boolean flag;
	        if(!WebSocketImpl.class.desiredAssertionStatus())
	            flag = true;
	        else
	            flag = false;
	        MF_CLASS429_h1262 = flag;
	        MF_CLASS397_c1161 = new ArrayList(4);
	        MF_CLASS397_c1161.add(new Draft_17());
	        MF_CLASS397_c1161.add(new CLASS400());
	        MF_CLASS397_c1161.add(new CLASS404());
	        MF_CLASS397_c1161.add(new CLASS403());
	    }
	}
	
