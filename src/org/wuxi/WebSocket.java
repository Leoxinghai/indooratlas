package org.wuxi;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import org.wuxi.optcode.Framedata;
import org.wuxi.socket.Draft;
import org.wuxi.type.Handshakedata;
import org.wuxi.type.CLASS421;
import org.wuxi.type.ServerHandshake;
import org.wuxi.type.CLASS427;

// Referenced classes of package org.wuxi:
//            WebSocket

public interface WebSocket
{
    public abstract void sendFrame(Framedata class414);

    public abstract InetSocketAddress getLocalSocketAddress();
}