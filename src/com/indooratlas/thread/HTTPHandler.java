// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.thread;

import com.indooratlas.message.event.CLASS65;
import com.indooratlas.position.CLASS71;
import com.indooratlas.position.CLASS75;
import com.indooratlas.thread.client.IDeviceCheck;
import java.io.*;
import java.net.URI;
import java.util.*;
import java.util.zip.GZIPInputStream;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.*;
import com.indooratlas.message.event.type.CLASS63;

// Referenced classes of package com.indooratlas.thread:
//            CLASS91, CLASS92, CLASS93, CLASS95,
//            CLASS94, CLASS96

public class HTTPHandler
    implements Runnable
{

    public HTTPHandler(int i, String s, List list, IDeviceCheck class54, int j, byte abyte0[], String s1,
            String s2, long l)
    {
        MF_CLASS76_b263 = null;
        MF_CLASS76_e266 = 0;
//        MF_CLASS76_f267 = 0;
        MF_CLASS76_g268 = 0L;
        MF_CLASS76_h269 = 0L;
        MF_CLASS76_i270 = false;
        MF_CLASS76_j271 = null;
        MF_CLASS76_e266 = i;
        MF_CLASS76_b263 = s;
        MF_CLASS76_k272 = list;
        MF_CLASS76_l273 = class54;
        MF_CLASS76_f267 = j;
        MF_CLASS76_j271 = abyte0;
        MF_CLASS76_h269 = l;
        MF_CLASS76_c264 = s1;
        MF_CLASS76_d265 = s2;
    }

    static int MF_CLASS76_a262(HTTPHandler class76)
    {
        return class76.MF_CLASS76_e266;
    }

    private static int MF_CLASS76_a262(HttpResponse httpresponse)
    {
        return httpresponse.getStatusLine().getStatusCode();
    }

    private HttpResponse go(HttpRequestBase httprequestbase) throws IOException, CLASS63
    {
        CLASS75.MF_CLASS75_b260("HTTPHandler", "HTTPHandler.go(), called.");
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
        HttpResponse httpresponse;
        if(httprequestbase.getURI().toString().contains("init"))
        {
            CLASS75.MF_CLASS75_b260("HTTPHandler", "go Setting setSoTimeout Constants.HTTP_CONNECTION_TIMEOUT_INITIALIZE_SESSION");
            HttpConnectionParams.setSoTimeout(basichttpparams, 60000);
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 60000);
        } else
        {
            CLASS75.MF_CLASS75_b260("HTTPHandler", "go  Setting setSoTimeout Constants.HTTP_CONNECTION_TIMEOUT");
            HttpConnectionParams.setSoTimeout(basichttpparams, 5000);
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 5000);
        }
        CLASS75.MF_CLASS75_b260("HTTPHandler", "HTTPHandler.go(), calling HTTPClient.execute.");
        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.go(), creating MAC and signing request: ").append(httprequestbase).toString());
        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.go(), serverTime: ").append((new Date(MF_CLASS76_h269)).toString()).toString());
        (new CLASS65(new CLASS71())).MF_CLASS65_a221(new Date(MF_CLASS76_h269), httprequestbase, MF_CLASS76_c264, MF_CLASS76_d265, "");
        httpresponse = MF_CLASS76_b263().execute(httprequestbase);
        CLASS75.MF_CLASS75_b260("HTTPHandler", "HTTPHandler.go(), HTTPClient.execute done.");
        httpresponse.setParams(basichttpparams);
        CLASS75.MF_CLASS75_b260("HTTPHandler", "HTTPHandler.go(), returning...");
        return httpresponse;
    }

    static String MF_CLASS76_b263(HTTPHandler class76)
    {
        return class76.MF_CLASS76_b263;
    }

    private String MF_CLASS76_b263(HttpResponse httpresponse) throws IOException
    {
        InputStreamReader inputstreamreader = new InputStreamReader(MF_CLASS76_d265(httpresponse), "UTF8");
        StringWriter stringwriter = new StringWriter();
        do
        {
            int i = inputstreamreader.read();
            if(i != -1)
                stringwriter.write(i);
            else
                return stringwriter.toString();
        } while(true);
    }

    private static DefaultHttpClient MF_CLASS76_b263()
    {
        if(MF_CLASS76_a262 == null)
        {
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basichttpparams, "utf-8");
            basichttpparams.setBooleanParameter("http.protocol.expect-continue", false);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            SSLSocketFactory sslsocketfactory = SSLSocketFactory.getSocketFactory();
            sslsocketfactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            schemeregistry.register(new Scheme("https", sslsocketfactory, 443));
            MF_CLASS76_a262 = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        }
        return MF_CLASS76_a262;
    }

    private InputStream MF_CLASS76_c264(HttpResponse httpresponse) throws IOException
    {
        return MF_CLASS76_d265(httpresponse);
    }

    static List MF_CLASS76_c264(HTTPHandler class76)
    {
        return class76.MF_CLASS76_k272;
    }

    static IDeviceCheck MF_CLASS76_d265(HTTPHandler class76)
    {
        return class76.MF_CLASS76_l273;
    }

    private InputStream MF_CLASS76_d265(HttpResponse httpresponse) throws IOException
    {
        HttpEntity httpentity = httpresponse.getEntity();
        if(httpentity != null && httpentity.getContentLength() != 0L)
        {
            InputStream inputstream = httpentity.getContent();
            Header header = httpresponse.getFirstHeader("Content-Encoding");
            if(header != null && header.getValue().equalsIgnoreCase("gzip"))
                return new GZIPInputStream(inputstream);
            else
                return inputstream;
        } else
        {
            return null;
        }
    }

    static long MF_CLASS76_e266(HTTPHandler class76)
    {
        return class76.MF_CLASS76_g268;
    }

    public boolean MF_CLASS76_a262()
    {
        return MF_CLASS76_i270;
    }

    public void run()
    {
        Thread thread1;
        Thread thread2;
        HttpResponse httpresponse;
        int i;
        String s;
        Header aheader[];
        int j;
        String s1;
        InputStream inputstream;
        Thread thread3;
        Header aheader1[];
        int k;
        Iterator iterator;
        Cookie cookie;
        Header header;
        String s2;
        Thread thread4;
        InputStream inputstream1;
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        String s3;
        Header header1;
        String s4;
        Thread thread5;
        Object obj;
        ByteArrayEntity bytearrayentity;
        Thread thread = new Thread(new CLASS91(this));
        thread.setName("HTTPHandlerCallback");
        thread.start();
        
        try {
        
        if(MF_CLASS76_e266 != 1) {
            if(MF_CLASS76_e266 == 0)
            {
                CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("this.requestType == Method.GET, getting from URL = ").append(MF_CLASS76_b263).toString());
                try
                {
                    obj = new HttpGet(MF_CLASS76_b263);
                }
                // Misplaced declaration of an exception variable
                catch(Exception exception2)
                {
                    exception2.printStackTrace();
                	thread5 = new Thread(new CLASS92(this));
                    thread5.setName("HTTPHandlerCallback");
                    thread5.start();
                    return;
                }
                ((HttpGet)obj).getParams().setIntParameter("http.socket.timeout", 5000);
                ((HttpGet)obj).getParams().setIntParameter("http.connection.timeout", 5000);
                if(MF_CLASS76_f267 == 0)
                    ((HttpGet)obj).addHeader("Accept", "application/x-protobuf");
                else
                if(MF_CLASS76_f267 == 1)
                {
                    CLASS75.MF_CLASS75_b260("HTTPHandler", "this.requestType == Method.GET, acceptEncoding == AcceptEncoding.JSON ");
                    ((HttpGet)obj).addHeader("Accept", "application/json");
                } else
                {
                    ((HttpGet)obj).addHeader("Accept", "text/html,application/xhtml+xml,application/xml,text/plain");
                }
            } else
            {
                CLASS75.MF_CLASS75_b260("HTTPHandler", "Requesttype not supported");
                return;
            }
        } else {
	        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("this.requestType == Method.POST, posting to URL = ").append(MF_CLASS76_b263).toString());
	        obj = new HttpPost(MF_CLASS76_b263);

	        
	        if(MF_CLASS76_k272 == null) {
	            CLASS75.MF_CLASS75_b260("HTTPHandler", "this.requestType == Method.POST, request does not contain parameters");
	            CLASS75.MF_CLASS75_b260("HTTPHandler", "this.requestType == Method.POST, NOT ever using GZip");
	            if(MF_CLASS76_j271 != null)
	            {
	                CLASS75.MF_CLASS75_b260("HTTPHandler", "inputData != null");
	                bytearrayentity = new ByteArrayEntity(MF_CLASS76_j271);
	                bytearrayentity.setContentType("application/x-protobuf");
	                if(MF_CLASS76_f267 == 0)
	                    ((HttpPost)obj).addHeader("Accept", "application/x-protobuf");
	                ((HttpPost)obj).setEntity(bytearrayentity);
	                if(!MF_CLASS76_b263.contains("init"))
	                {
	                    CLASS75.MF_CLASS75_b260("HTTPHandler", "this.requestType == Method.POST: *NOT* sending init --> using normal timeout");
	                    ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 5000);
	                    ((HttpPost)obj).getParams().setIntParameter("http.connection.timeout", 5000);
	                } else
	                {
	                    CLASS75.MF_CLASS75_b260("HTTPHandler", "this.requestType == Method.POST: sending init --> using longer timeout");
	                    ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
	                    ((HttpPost)obj).getParams().setIntParameter("http.connection.timeout", 60000);
	                }
	                CLASS75.MF_CLASS75_b260("HTTPHandler", "this.requestType == Method.POST, created protobuf Entity");
	            }
	        } else {
	            try
	            {
	                UrlEncodedFormEntity urlencodedformentity = new UrlEncodedFormEntity(MF_CLASS76_k272, "UTF-8");
	                urlencodedformentity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
	                ((HttpPost)obj).addHeader("Accept", "text/plain");
	                ((HttpPost)obj).setEntity(urlencodedformentity);
	                ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 5000);
	                ((HttpPost)obj).getParams().setIntParameter("http.connection.timeout", 5000);
	            }
	            catch(UnsupportedEncodingException unsupportedencodingexception) { 
	            	unsupportedencodingexception.printStackTrace();	            	
	            }
	        	
	        }
//	        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("this.requestType == Method.POST, request contains parameters, N = ").append(MF_CLASS76_k272.size()).toString());
        }

        

        CLASS75.MF_CLASS75_b260("HTTPHandler", "reading http response");
        httpresponse = go(((HttpRequestBase) (obj)));
        i = MF_CLASS76_a262(httpresponse);
        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("reading http response, statusCode = ").append(i).toString());
        s = "";
        aheader = httpresponse.getAllHeaders();
        j = 0;

        for(;j < aheader.length;) {
	        header1 = aheader[j];
	        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("Header names: ").append(header1.getName()).toString());
	        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("Header Value: ").append(header1.getValue()).toString());
	        if(!header1.getName().equals("Date"))
	            j++;
	        s4 = header1.getValue();
	        s = s4;
	        j++;
        }


        
//        ConnectTimeoutException connecttimeoutexception;
        
        
        if(i < 400) {
            s1 = "";
            inputstream = null;
            if(MF_CLASS76_f267 == 0) {
    	
    	        inputstream = MF_CLASS76_c264(httpresponse);
    	        aheader1 = httpresponse.getAllHeaders();
    	        k = 0;
    	
    	        for(;k < aheader1.length;) { 
    		        header = aheader1[k];
    		        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("Header names: ").append(header.getName()).toString());
    		        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("Header Value: ").append(header.getValue()).toString());
    		        k++;
    	        }
    	        
    	        for(iterator = MF_CLASS76_a262.getCookieStore().getCookies().iterator(); iterator.hasNext();)
    	        {
    	            cookie = (Cookie)iterator.next();
    	            CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("cookie = ").append(cookie.getName()).toString());
    	            CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("cookie = ").append(cookie.getValue()).toString());
    	            CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("cookie = ").append(cookie.getDomain()).toString());
    	            CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("cookie = ").append(cookie.getPath()).toString());
    	            s1 = (new StringBuilder()).append(cookie.getName()).append("=").append(cookie.getValue()).toString();
    	        }
            } else {
    	        
    	        s1 = MF_CLASS76_b263(httpresponse);
    	        thread3 = new Thread(new CLASS94(this, i, s1, inputstream, s));
    	        thread3.setName("HTTPHandlerCallback");
    	        thread3.start();
    	        return;
            }
        	
        }
        
        s2 = "";
        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.run():   getContentLength() = ").append(httpresponse.getEntity().getContentLength()).toString());
        inputstream1 = httpresponse.getEntity().getContent();
        stringbuilder = new StringBuilder();
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream1));
        s3 = bufferedreader.readLine();
        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.run():   read = ").append(s3).toString());
        while(s3 != null) {
	        CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.run():   read = ").append(s3).toString());
	        stringbuilder.append(s3);
	        s3 = bufferedreader.readLine();
        }
        
        try
        {
            s2 = stringbuilder.toString();
            CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.run():   errStr = ").append(s2).toString());
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception1) { 
        	exception1.printStackTrace();        	
        }
        try
        {
            thread4 = new Thread(new CLASS93(this, i, s2, s));
            thread4.setName("HTTPHandlerCallback");
            thread4.start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception)
        {
        	exception.printStackTrace();
        	CLASS75.MF_CLASS75_b260("HTTPHandler", (new StringBuilder()).append("HTTPHandler.run(), request failed: requestType=").append(MF_CLASS76_e266).append(", url=").append(MF_CLASS76_b263).append(", xml=").append("").toString());
        }
        thread1 = new Thread(new CLASS96(this));
        thread1.setName("HTTPHandlerCallback");
        thread1.start();
        return;

    } catch(ConnectTimeoutException connecttimeoutexception) {
        CLASS75.MF_CLASS75_b260("HTTPHandler", "HTTPHandler.run(), request failed: ConnectTimeoutException");
        thread2 = new Thread(new CLASS95(this));
        thread2.setName("HTTPHandlerCallback");
        thread2.start();
        return;
    } catch(Exception exc) {
        thread2 = new Thread(new CLASS95(this));
        thread2.setName("HTTPHandlerCallback");
        thread2.start();
    	exc.printStackTrace();
    	return;
    }
        
    }

    private static DefaultHttpClient MF_CLASS76_a262 = null;
    private String MF_CLASS76_b263;
    private String MF_CLASS76_c264;
    private String MF_CLASS76_d265;
    private int MF_CLASS76_e266;
    private int MF_CLASS76_f267;
    private long MF_CLASS76_g268;
    private long MF_CLASS76_h269;
    private boolean MF_CLASS76_i270;
    private byte MF_CLASS76_j271[];
    private List MF_CLASS76_k272;
    private IDeviceCheck MF_CLASS76_l273;

}
