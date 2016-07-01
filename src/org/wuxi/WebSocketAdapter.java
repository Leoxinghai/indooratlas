package org.wuxi;


import java.net.InetSocketAddress;
import org.wuxi.exception.CLASS409;
import org.wuxi.optcode.Framedata;
import org.wuxi.optcode.CLASS417;
import org.wuxi.optcode.CLASS419;
import org.wuxi.socket.Draft;
import org.wuxi.type.CLASS421;
import org.wuxi.type.ServerHandshake;
import org.wuxi.type.CLASS427;
import org.wuxi.type.CLASS428;
import org.wuxi.*;
//Referenced classes of package org.wuxi:
//         CLASS86, WebSocket

public abstract class WebSocketAdapter
 implements WebSocketListener
{

 public WebSocketAdapter()
 {
 }

 public String getFlashPolicy(WebSocket class88) 
 {
     InetSocketAddress inetsocketaddress = class88.getLocalSocketAddress();
     if(inetsocketaddress == null)
     {
//         throw new CLASS409("socket not bound");
     	return null;
     } else
     {
         StringBuffer stringbuffer = new StringBuffer(90);
         stringbuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
         stringbuffer.append(inetsocketaddress.getPort());
         stringbuffer.append("\" /></cross-domain-policy>\0");
         return stringbuffer.toString();
     }
 }

 public CLASS427 MF_CLASS86_a317(WebSocket class88, Draft class397, CLASS421 class421)
 {
     return new CLASS428();
 }

 public void MF_CLASS86_a317(WebSocket class88, Framedata class414)
 {
 }

 public void MF_CLASS86_a317(WebSocket class88, CLASS421 class421)
 {
 }

 public void MF_CLASS86_a317(WebSocket class88, CLASS421 class421, ServerHandshake class426)
 {
 }

 public void MF_CLASS86_b318(WebSocket class88, Framedata class414)
 {
     CLASS417 class417 = new CLASS417(class414);
     class417.MF_CLASS416_a1221(CLASS419.PONG);
     class88.sendFrame(class417);
 }

 public void MF_CLASS86_c319(WebSocket class88, Framedata class414)
 {
 }
}
