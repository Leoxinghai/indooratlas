package org.wuxi;


import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import org.wuxi.optcode.Framedata;
import org.wuxi.socket.Draft;
import org.wuxi.type.Handshakedata;
import org.wuxi.type.CLASS421;
import org.wuxi.type.ServerHandshake;
import org.wuxi.type.CLASS427;
import org.java_websocket.*;

//Referenced classes of package org.wuxi:
//         WebSocket

public interface WebSocketListener
{

 public abstract String getFlashPolicy(WebSocket class88);

 public abstract CLASS427 MF_CLASS86_a317(WebSocket class88, Draft class397, CLASS421 class421);

 public abstract void MF_CLASS86_a317(WebSocket class88, int i, String s);

 public abstract void onWebsocketClose(WebSocket class88, int i, String s, boolean flag);

 public abstract void onWebsocketError(WebSocket class88, Exception exception);

 public abstract void onWebsocketMessage(WebSocket class88, String s);

 public abstract void onWebsocketMessage(WebSocket class88, ByteBuffer bytebuffer);

 public abstract void onWebsocketMessageFragment(WebSocket class88, Framedata class414);

 public abstract void MF_CLASS86_a317(WebSocket class88, CLASS421 class421);

 public abstract void MF_CLASS86_a317(WebSocket class88, CLASS421 class421, ServerHandshake class426);

 public abstract void onWebsocketOpen(WebSocket class88, Handshakedata class420);

 public abstract void MF_CLASS86_b318(WebSocket class88);

 public abstract void MF_CLASS86_b318(WebSocket class88, int i, String s, boolean flag);

 public abstract void MF_CLASS86_b318(WebSocket class88, Framedata class414);

 public abstract InetSocketAddress getLocalSocketAddress(WebSocket class88);

 public abstract void MF_CLASS86_c319(WebSocket class88, Framedata class414);
}
