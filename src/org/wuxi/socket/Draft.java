package org.wuxi.socket;

import java.nio.ByteBuffer;
import java.util.*;

import org.wuxi.Role;
import org.wuxi.exception.*;
import org.wuxi.optcode.Framedata;
import org.wuxi.optcode.CLASS419;
import org.wuxi.save.CLASS432;
import org.wuxi.type.*;

//Referenced classes of package org.wuxi.socket:
//         CLASS399, CLASS398

public abstract class Draft
{

 public Draft()
 {
     MF_CLASS397_d1162 = null;
     MF_CLASS397_e1163 = null;
 }

 public static ByteBuffer MF_CLASS413_a1212(ByteBuffer bytebuffer)
 {
     ByteBuffer bytebuffer1 = ByteBuffer.allocate(bytebuffer.remaining());
     byte byte0 = 48;
     do
     {
         byte byte1;
         if(bytebuffer.hasRemaining())
         {
             byte1 = bytebuffer.get();
             bytebuffer1.put(byte1);
             if(byte0 == 13 && byte1 == 10)
             {
                 bytebuffer1.limit(-2 + bytebuffer1.position());
                 bytebuffer1.position(0);
                 return bytebuffer1;
             }
         } else
         {
             bytebuffer.position(bytebuffer.position() - bytebuffer1.position());
             return null;
         }
         byte0 = byte1;
     } while(true);
 }

 public static CLASS422 MF_CLASS413_a1212(ByteBuffer bytebuffer, Role class413) throws CLASS409
 {
     String s = MF_CLASS397_b1160(bytebuffer);
     if(s == null)
         throw new CLASS406(128 + bytebuffer.capacity());
     String as[] = s.split(" ", 3);
     if(as.length != 3)
         throw new CLASS409();
     Object obj;
     String s1;
     if(class413 == Role.MF_CLASS413_a1212)
     {
         obj = new CLASS428();
         CLASS427 class427 = (CLASS427)obj;
         class427.MF_CLASS427_a1252(Short.parseShort(as[1]));
         class427.MF_CLASS427_a1252(as[2]);
     } else
     {
         obj = new CLASS425();
         ((CLASS423) (obj)).MF_CLASS423_a1246(as[1]);
     }
     for(s1 = MF_CLASS397_b1160(bytebuffer); s1 != null && s1.length() > 0; s1 = MF_CLASS397_b1160(bytebuffer))
     {
         String as1[] = s1.split(":", 2);
         if(as1.length != 2)
             throw new CLASS409("not an http header");
         ((CLASS422) (obj)).MF_CLASS422_a1245(as1[0], as1[1].replaceFirst("^ +", ""));
     }

     if(s1 == null)
         throw new CLASS406();
     else
         return ((CLASS422) (obj));
 }

 public static String MF_CLASS397_b1160(ByteBuffer bytebuffer)
 {
     ByteBuffer bytebuffer1 = MF_CLASS413_a1212(bytebuffer);
     if(bytebuffer1 == null)
         return null;
     else
         return CLASS432.a(bytebuffer1.array(), 0, bytebuffer1.limit());
 }

 public int MF_CLASS413_a1212(int i) throws CLASS407
 {
     if(i < 0)
         throw new CLASS407(1002, "Negative count");
     else
         return i;
 }

 public abstract ByteBuffer MF_CLASS413_a1212(Framedata class414);

 public abstract List MF_CLASS413_a1212(ByteBuffer bytebuffer, boolean flag);

 public List MF_CLASS413_a1212(Handshakedata class420, Role class413)
 {
     return MF_CLASS413_a1212(class420, class413, true);
 }

 public List MF_CLASS413_a1212(Handshakedata class420, Role class413, boolean flag)
 {
     StringBuilder stringbuilder = new StringBuilder(100);
     if(class420 instanceof CLASS421)
     {
         stringbuilder.append("GET ");
         stringbuilder.append(((CLASS421)class420).MF_CLASS421_a1244());
         stringbuilder.append(" HTTP/1.1");
     } else
     if(class420 instanceof ServerHandshake)
         stringbuilder.append((new StringBuilder()).append("HTTP/1.1 101 ").append(((ServerHandshake)class420).MF_CLASS426_a1251()).toString());
     else
         throw new RuntimeException("unknow role");
     stringbuilder.append("\r\n");
     for(Iterator iterator = class420.MF_CLASS420_b1242();iterator.hasNext();)
     {
         String s = (String)iterator.next();
         String s1 = class420.MF_CLASS420_b1242(s);
         stringbuilder.append(s);
         stringbuilder.append(": ");
         stringbuilder.append(s1);
         stringbuilder.append("\r\n");            
     }

     stringbuilder.append("\r\n");
     byte abyte0[] = CLASS432.b(stringbuilder.toString());
     byte abyte1[];
     int i;
     ByteBuffer bytebuffer;
     if(flag)
         abyte1 = class420.MF_CLASS420_c1243();
     else
         abyte1 = null;
     if(abyte1 == null)
         i = 0;
     else
         i = abyte1.length;
     bytebuffer = ByteBuffer.allocate(i + abyte0.length);
     bytebuffer.put(abyte0);
     if(abyte1 != null)
         bytebuffer.put(abyte1);
     bytebuffer.flip();
     return Collections.singletonList(bytebuffer);
 }

 public abstract CLASS399 MF_CLASS413_a1212(CLASS421 class421);

 public abstract CLASS399 MF_CLASS413_a1212(CLASS421 class421, ServerHandshake class426) throws CLASS407;

 public abstract CLASS423 MF_CLASS413_a1212(CLASS423 class423);

 public abstract CLASS422 MF_CLASS413_a1212(CLASS421 class421, CLASS427 class427)throws CLASS407;

 public abstract void MF_CLASS413_a1212();

 public void MF_CLASS413_a1212(Role class413)
 {
     MF_CLASS397_d1162 = class413;
 }

 protected boolean MF_CLASS413_a1212(Handshakedata class420)
 {
     return class420.MF_CLASS420_b1242("Upgrade").equalsIgnoreCase("websocket") && class420.MF_CLASS420_b1242("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
 }

 public abstract CLASS398 MF_CLASS397_b1160();

 public abstract List MF_CLASS397_c1161(ByteBuffer bytebuffer) throws CLASS407;

 public abstract Draft MF_CLASS397_c1161();

 public Handshakedata MF_CLASS397_d1162(ByteBuffer bytebuffer) throws CLASS409
 {
     return MF_CLASS413_a1212(bytebuffer, MF_CLASS397_d1162);
 }

 public static int MF_CLASS413_a1212 = 1000;
 public static int MF_CLASS397_b1160 = 64;
 public static final byte MF_CLASS397_c1161[] = CLASS432.a("<policy-file-request/>\0");
 protected Role MF_CLASS397_d1162;
 protected CLASS419 MF_CLASS397_e1163;

}
