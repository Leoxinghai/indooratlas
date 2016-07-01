package com.indooratlas.mapcreator.controller;



import com.indooratlas.thread.client.IDeviceCheck;
import java.io.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.zip.GZIPInputStream;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.*;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;

// CookieHTTPHandler


public class CookieHTTPHandler
 implements Runnable
{

 public CookieHTTPHandler(int i, String s, List list, String s1, IDeviceCheck class54, boolean flag, int j,
         InputStream inputstream, String s2, String s3)
 {
     MF_CookieHTTPHandler_b523 = 0;
     MF_CookieHTTPHandler_c524 = null;
     isGZiped = false;
     MF_CookieHTTPHandler_h533 = 0;
     MF_CookieHTTPHandler_i534 = null;
     MF_CookieHTTPHandler_j535 = 0L;
     MF_CookieHTTPHandler_k536 = null;
     MF_CookieHTTPHandler_l537 = null;
     MF_CookieHTTPHandler_b523 = i;
     MF_CookieHTTPHandler_c524 = s;
     MF_CookieHTTPHandler_d525 = list;
     MF_CookieHTTPHandler_e526 = s1;
     mIDeviceCheck = class54;
     isGZiped = flag;
     MF_CookieHTTPHandler_h533 = j;
     MF_CookieHTTPHandler_i534 = inputstream;
     MF_CookieHTTPHandler_k536 = s2;
     MF_CookieHTTPHandler_l537 = s3;
 }

 static int MF_CLASS113_a486(CookieHTTPHandler class140)
 {
     return class140.MF_CookieHTTPHandler_b523;
 }

 private static int isExceptionLogged(HttpResponse httpresponse)
 {
     return httpresponse.getStatusLine().getStatusCode();
 }

 private HttpResponse go(HttpRequestBase httprequestbase) throws ClientProtocolException, IOException
 {
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "CookieHTTPHandler.go(), called.");
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "CookieHTTPHandler.go(), calling HTTPClient.execute.");
     DefaultHttpClient defaulthttpclient = isExceptionLogged();
     long l = System.currentTimeMillis();
     HttpResponse httpresponse = defaulthttpclient.execute(httprequestbase);
     float f = System.currentTimeMillis() - l;
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.go(), HTTPClient.execute done, took : ").append((double)f / 1000D).append("s.").toString());
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "CookieHTTPHandler.go(), returning...");
     return httpresponse;
 }

 private static DefaultHttpClient isExceptionLogged()
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
     MF_CookieHTTPHandler_m528 = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
     return MF_CookieHTTPHandler_m528;
 }

 static String MF_CookieHTTPHandler_b523(CookieHTTPHandler class140)
 {
     return class140.MF_CookieHTTPHandler_c524;
 }

 private static String MF_CookieHTTPHandler_b523(HttpResponse httpresponse) throws IOException
 {
     HttpEntity httpentity = httpresponse.getEntity();
     if(httpentity != null)
         return EntityUtils.toString(httpentity);
     else
         return null;
 }

 private String MF_CookieHTTPHandler_c524(HttpResponse httpresponse) throws IOException
 {
     InputStreamReader inputstreamreader = new InputStreamReader(MF_CookieHTTPHandler_e526(httpresponse), "UTF8");
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

 static List MF_CookieHTTPHandler_c524(CookieHTTPHandler class140)
 {
     return class140.MF_CookieHTTPHandler_d525;
 }

 private InputStream MF_CookieHTTPHandler_d525(HttpResponse httpresponse) throws IOException
 {
     return MF_CookieHTTPHandler_e526(httpresponse);
 }

 static String MF_CookieHTTPHandler_d525(CookieHTTPHandler class140)
 {
     return class140.MF_CookieHTTPHandler_e526;
 }

 static IDeviceCheck getIDeviceCheck(CookieHTTPHandler class140)
 {
     return class140.mIDeviceCheck;
 }

 private InputStream MF_CookieHTTPHandler_e526(HttpResponse httpresponse) throws IOException
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

 static long MF_CookieHTTPHandler_f527(CookieHTTPHandler class140)
 {
     return class140.MF_CookieHTTPHandler_j535;
 }

 public void isExceptionLogged(long l)
 {
     MF_CookieHTTPHandler_j535 = l;
 }

 public void run0()
 {
     isExceptionLogged.execute(new CLASS168(this));
     Object obj;
     HttpResponse httpresponse = null;
     Header aheader[];
     int i;
     int j;
     Header header;
     try {
     if(MF_CookieHTTPHandler_b523 == 1) {

	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.POST, posting to URL = ").append(MF_CookieHTTPHandler_c524).toString());
	        obj = new HttpPost(MF_CookieHTTPHandler_c524);
	        ((HttpPost)obj).addHeader("Application-ID", MF_CookieHTTPHandler_l537);
	        if(MF_CookieHTTPHandler_d525 != null) {
		        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.POST, request contains parameters, N = ").append(MF_CookieHTTPHandler_d525.size()).toString());
		        try
		        {
		            UrlEncodedFormEntity urlencodedformentity = new UrlEncodedFormEntity(MF_CookieHTTPHandler_d525, "UTF-8");
		            urlencodedformentity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
		            ((HttpPost)obj).addHeader("Accept", "text/plain");
		            ((HttpPost)obj).setEntity(urlencodedformentity);
		            ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
		        }
		        catch(UnsupportedEncodingException unsupportedencodingexception2)
		        {
		            if(CLASS113.isExceptionLogged.booleanValue())
		                unsupportedencodingexception2.printStackTrace();
//		            continue; /* Loop/switch isn't completed */
		        }

	        } else {
		        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.POST, request does not contain parameters");
		        if(!isGZiped)
		        {
		            CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.POST, *NOT* using GZip");
		            try
		            {
		                StringEntity stringentity1 = new StringEntity(MF_CookieHTTPHandler_e526, "UTF-8");
		                stringentity1.setContentType("application/xml");
		                ((HttpPost)obj).setEntity(stringentity1);
		                ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
		            }
		            catch(UnsupportedEncodingException unsupportedencodingexception1)
		            {
		                if(CLASS113.isExceptionLogged.booleanValue())
		                    unsupportedencodingexception1.printStackTrace();
		                isExceptionLogged.execute(new CLASS172(this));
		            }
//		            continue; /* Loop/switch isn't completed */
		        }
		        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.POST, using GZip");
		        if(MF_CookieHTTPHandler_i534 != null) {
			        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "mXMLInputStream != null");
			        InputStreamEntity inputstreamentity = new InputStreamEntity(MF_CookieHTTPHandler_i534, -1L);
			        inputstreamentity.setContentType("application/x-protobuf");
			        ((HttpPost)obj).addHeader("Accept-Encoding", "gzip");
			        ((HttpPost)obj).setEntity(inputstreamentity);
			        if(MF_CookieHTTPHandler_c524.contains("models")) {
				        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "run(): using shorter timeout: 10000");
				        ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 10000);
			        } else {
			            CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "run(): using normal POST timeout: 60000");
			            ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
			        }

			        UnsupportedEncodingException unsupportedencodingexception;
			        ((HttpPost)obj).addHeader("Content-Encoding", "gzip");
		        } else {
			        try
			        {
			            CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "mXMLInputStream == null");
			            StringEntity stringentity = new StringEntity(MF_CookieHTTPHandler_e526, "UTF-8");
			            stringentity.setContentType("gzip");
			            ((HttpPost)obj).addHeader("Accept-Encoding", "gzip");
			            ((HttpPost)obj).setEntity(new CLASS178(this, stringentity));
			            ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
			        }
			        // Misplaced declaration of an exception variable
			        catch(UnsupportedEncodingException unsupportedencodingexception)
			        {
			            if(CLASS113.isExceptionLogged.booleanValue())
			                unsupportedencodingexception.printStackTrace();
			        }
		        }
	        }
//			_L27:
	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "reading http response");
	        if(MF_CookieHTTPHandler_k536 == null) {
	                CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "*NOT* setting cookie to request");
//	                  goto _L14
//	                ConnectTimeoutException connecttimeoutexception;
//	                connecttimeoutexception;
	                CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "CookieHTTPHandler.run(), request failed: ConnectTimeoutException");
	                isExceptionLogged.execute(new CLASS177(this));
	                return;
	        } else {
		        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "Setting cookie to request");
		        ((HttpRequestBase) (obj)).setHeader("Cookie", MF_CookieHTTPHandler_k536);
	        }
//_L14:
	        httpresponse = go(((HttpRequestBase) (obj)));
	        aheader = httpresponse.getAllHeaders();
	        i = aheader.length;
	        j = 0;
	        for(;j < i;j++) {
		        header = aheader[j];
		        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("HEADERS: ").append(header.getName()).append(": ").append(header.getValue()).toString());
	        }

     } else if(MF_CookieHTTPHandler_b523 == 0) {
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.GET, getting from URL = ").append(MF_CookieHTTPHandler_c524).toString());
         try
         {
             obj = new HttpGet(MF_CookieHTTPHandler_c524);
         }
         catch(Exception exception3)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 exception3.printStackTrace();
             isExceptionLogged.execute(new CLASS173(this));
             return;
         }
         if(MF_CookieHTTPHandler_c524.contains("graphics") && MF_CookieHTTPHandler_c524.contains("sequences"))
         {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "run(): using longer timeout: 30000");
             ((HttpGet)obj).getParams().setIntParameter("http.socket.timeout", 30000);
         } else
         {
             ((HttpGet)obj).getParams().setIntParameter("http.socket.timeout", 10000);
         }
         ((HttpGet)obj).addHeader("Application-ID", MF_CookieHTTPHandler_l537);
         if(isGZiped)
             ((HttpGet)obj).addHeader("Accept-Encoding", "gzip");
         if(MF_CookieHTTPHandler_h533 == 0)
             ((HttpGet)obj).addHeader("Accept", "application/x-protobuf");
         else
         if(MF_CookieHTTPHandler_h533 == 1)
         {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.GET, mAcceptEncoding == AcceptEncoding.JSON ");
             ((HttpGet)obj).addHeader("Accept", "application/json");
         } else
         {
             ((HttpGet)obj).addHeader("Accept", "text/html,application/xhtml+xml,application/xml,text/plain");
         }
     } else
     if(MF_CookieHTTPHandler_b523 == 2)
     {
         obj = new HttpDelete(MF_CookieHTTPHandler_c524);
         ((HttpDelete)obj).getParams().setIntParameter("http.socket.timeout", 10000);
         ((HttpDelete)obj).addHeader("Accept", "application/json");
         if(isGZiped)
             ((HttpDelete)obj).addHeader("Accept-Encoding", "gzip");
     } else
     if(MF_CookieHTTPHandler_b523 == 3)
     {
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.HEAD, getting from URL = ").append(MF_CookieHTTPHandler_c524).toString());
         try
         {
             obj = new HttpHead(MF_CookieHTTPHandler_c524);
         }
         catch(Exception exception2)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 exception2.printStackTrace();
             isExceptionLogged.execute(new CLASS174(this));
             return;
         }
         ((HttpHead)obj).getParams().setIntParameter("http.socket.timeout", 10000);
         if(isGZiped)
             ((HttpHead)obj).addHeader("Accept-Encoding", "gzip");
         if(MF_CookieHTTPHandler_h533 == 0)
             ((HttpHead)obj).addHeader("Accept", "application/x-protobuf");
         else
         if(MF_CookieHTTPHandler_h533 == 1)
         {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.GET, mAcceptEncoding == AcceptEncoding.JSON ");
             ((HttpHead)obj).addHeader("Accept", "application/json");
         } else
         {
             ((HttpHead)obj).addHeader("Accept", "text/html,application/xhtml+xml,application/xml,text/plain");
         }
     } else
     {
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "Requesttype not supported");
         return;
     }
//     continue; /* Loop/switch isn't completed */



//_L7:
     int k;
     k = isExceptionLogged(httpresponse);
     k=200;

     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("reading http response, statusCode = ").append(k).toString());
     String s = "";
     Header aheader1[] = httpresponse.getAllHeaders();
     int l = 0;

     for(;l < aheader1.length;l++)
     {
         Header header1 = aheader1[l];
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("Header names: ").append(header1.getName()).toString());
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("Header Value: ").append(header1.getValue()).toString());
         if(header1.getName().equals("Date"))
             s = header1.getValue();
     }
     if(k < 400) {
         String s1;
         InputStream inputstream;
         s1 = "";
         inputstream = null;
         if(isGZiped) {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "reading http response, gzip");
             if(MF_CookieHTTPHandler_h533 == 0)
             	inputstream = MF_CookieHTTPHandler_d525(httpresponse);
             else {
                 String s2 = MF_CookieHTTPHandler_c524(httpresponse);
                 s1 = s2;
                 inputstream = null;
             }
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("reading http response, gzip, temp_result = ").append(s1).append(", temp_in = ").append(inputstream).toString());
         } else {
 	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "reading http response, no-gzip");
 	        s1 = MF_CookieHTTPHandler_b523(httpresponse);
         }
         isExceptionLogged.execute(new CLASS176(this, k, s1, inputstream, s));
         return;
     } else {
	        String s3 = "";
	        StringBuilder stringbuilder;
	        BufferedReader bufferedreader;
	        String s4;
	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   getContentLength() = ").append(httpresponse.getEntity().getContentLength()).toString());
	        InputStreamReader inputstreamreader = new InputStreamReader(httpresponse.getEntity().getContent());
	        stringbuilder = new StringBuilder();
	        bufferedreader = new BufferedReader(inputstreamreader);
	        s4 = bufferedreader.readLine();
	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   read = ").append(s4).toString());

	        while(s4 != null) {
		        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   read = ").append(s4).toString());
		        stringbuilder.append(s4);
		        s4 = bufferedreader.readLine();
	        }

	        s3 = stringbuilder.toString();
	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   errStr = ").append(s3).toString());

	        try
	        {
	            isExceptionLogged.execute(new CLASS175(this, k, s3));
	            return;
	        }
	        catch(Exception exception)
	        {
	            if(CLASS113.isExceptionLogged.booleanValue())
	                exception.printStackTrace();
	        }
	        CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run(), request failed: requestType=").append(MF_CookieHTTPHandler_b523).append(", url=").append(MF_CookieHTTPHandler_c524).append(", xml=").append(MF_CookieHTTPHandler_e526).toString());
	        isExceptionLogged.execute(new CLASS171(this));
	        return;
     }

 }
 catch(Exception exception)
 {
     if(CLASS113.isExceptionLogged.booleanValue())
         exception.printStackTrace();
 }
 }
 
 
 public void run()
 {
     isExceptionLogged.execute(new CLASS168(this));
     Object obj;
     HttpResponse httpresponse = null;
     try {
     
     Header aheader[];
     int i;
     int j;
     Header header;
     if(MF_CookieHTTPHandler_b523 == 1) {
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.POST, posting to URL = ").append(MF_CookieHTTPHandler_c524).toString());
	     obj = new HttpPost(MF_CookieHTTPHandler_c524);
	     ((HttpPost)obj).addHeader("Application-ID", MF_CookieHTTPHandler_l537);
	     if(MF_CookieHTTPHandler_d525 != null) {
	         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.POST, request contains parameters, N = ").append(MF_CookieHTTPHandler_d525.size()).toString());
	     try
	     {
	         UrlEncodedFormEntity urlencodedformentity = new UrlEncodedFormEntity(MF_CookieHTTPHandler_d525, "UTF-8");
	         urlencodedformentity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
	         ((HttpPost)obj).addHeader("Accept", "text/plain");
	         ((HttpPost)obj).setEntity(urlencodedformentity);
	         ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
	     }
	     catch(UnsupportedEncodingException unsupportedencodingexception2)
	     {
	         if(CLASS113.isExceptionLogged.booleanValue())
	             unsupportedencodingexception2.printStackTrace();
	     }
	     } else {	     
	     
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.POST, request does not contain parameters");
	     if(!isGZiped)
	     {
	         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.POST, *NOT* using GZip");
	         try
	         {
	             StringEntity stringentity1 = new StringEntity(MF_CookieHTTPHandler_e526, "UTF-8");
	             stringentity1.setContentType("application/xml");
	             ((HttpPost)obj).setEntity(stringentity1);
	             ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
	         }
	         catch(UnsupportedEncodingException unsupportedencodingexception1)
	         {
	             if(CLASS113.isExceptionLogged.booleanValue())
	                 unsupportedencodingexception1.printStackTrace();
	             isExceptionLogged.execute(new CLASS172(this));
	         }
	     } else {
		     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.POST, using GZip");
		     
		     if(MF_CookieHTTPHandler_i534 != null) {
			     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "mXMLInputStream != null");
			     InputStreamEntity inputstreamentity = new InputStreamEntity(MF_CookieHTTPHandler_i534, -1L);
			     inputstreamentity.setContentType("application/x-protobuf");
			     ((HttpPost)obj).addHeader("Accept-Encoding", "gzip");
			     ((HttpPost)obj).setEntity(inputstreamentity);
			     if(!MF_CookieHTTPHandler_c524.contains("models")) {
			    		     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "run(): using normal POST timeout: 60000");
			    		     ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
			     } else {
				     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "run(): using shorter timeout: 10000");
				     ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 10000);
			     }
			     UnsupportedEncodingException unsupportedencodingexception;
			     ((HttpPost)obj).addHeader("Content-Encoding", "gzip");
		     } else {
			     try
			     {
			         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "mXMLInputStream == null");
			         StringEntity stringentity = new StringEntity(MF_CookieHTTPHandler_e526, "UTF-8");
			         stringentity.setContentType("application/x-protobuf");
//			         ((HttpPost)obj).addHeader("Content-Type","gzip");
				     ((HttpPost)obj).addHeader("Content-Encoding", "gzip");
			         ((HttpPost)obj).addHeader("Accept-Encoding", "gzip");
			         ((HttpPost)obj).setEntity(new CLASS178(this, stringentity));
			         ((HttpPost)obj).getParams().setIntParameter("http.socket.timeout", 60000);
			     }
			     // Misplaced declaration of an exception variable
			     catch(UnsupportedEncodingException unsupportedencodingexception)
			     {
			         if(CLASS113.isExceptionLogged.booleanValue())
			             unsupportedencodingexception.printStackTrace();
			     }
		        }
		     }
		 }
     } else if(MF_CookieHTTPHandler_b523 == 0)
     {
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.GET, getting from URL = ").append(MF_CookieHTTPHandler_c524).toString());
         try
         {
             obj = new HttpGet(MF_CookieHTTPHandler_c524);
         }
         catch(Exception exception3)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 exception3.printStackTrace();
             isExceptionLogged.execute(new CLASS173(this));
             return;
         }
         if(MF_CookieHTTPHandler_c524.contains("graphics") && MF_CookieHTTPHandler_c524.contains("sequences"))
         {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "run(): using longer timeout: 30000");
             ((HttpGet)obj).getParams().setIntParameter("http.socket.timeout", 30000);
         } else
         {
             ((HttpGet)obj).getParams().setIntParameter("http.socket.timeout", 10000);
         }
         ((HttpGet)obj).addHeader("Application-ID", MF_CookieHTTPHandler_l537);
         if(isGZiped)
             ((HttpGet)obj).addHeader("Accept-Encoding", "gzip");
         if(MF_CookieHTTPHandler_h533 == 0)
             ((HttpGet)obj).addHeader("Accept", "application/x-protobuf");
         else
         if(MF_CookieHTTPHandler_h533 == 1)
         {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.GET, mAcceptEncoding == AcceptEncoding.JSON ");
             ((HttpGet)obj).addHeader("Accept", "application/json");
         } else
         {
             ((HttpGet)obj).addHeader("Accept", "text/html,application/xhtml+xml,application/xml,text/plain");
         }
     } else
     if(MF_CookieHTTPHandler_b523 == 2)
     {
         obj = new HttpDelete(MF_CookieHTTPHandler_c524);
         ((HttpDelete)obj).getParams().setIntParameter("http.socket.timeout", 10000);
         ((HttpDelete)obj).addHeader("Accept", "application/json");
         if(isGZiped)
             ((HttpDelete)obj).addHeader("Accept-Encoding", "gzip");
     } else
     if(MF_CookieHTTPHandler_b523 == 3)
     {
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("this.requestType == Request.HEAD, getting from URL = ").append(MF_CookieHTTPHandler_c524).toString());
         try
         {
             obj = new HttpHead(MF_CookieHTTPHandler_c524);
         }
         catch(Exception exception2)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 exception2.printStackTrace();
             isExceptionLogged.execute(new CLASS174(this));
             return;
         }
         ((HttpHead)obj).getParams().setIntParameter("http.socket.timeout", 10000);
         if(isGZiped)
             ((HttpHead)obj).addHeader("Accept-Encoding", "gzip");
         if(MF_CookieHTTPHandler_h533 == 0)
             ((HttpHead)obj).addHeader("Accept", "application/x-protobuf");
         else
         if(MF_CookieHTTPHandler_h533 == 1)
         {
             CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "this.requestType == Request.GET, mAcceptEncoding == AcceptEncoding.JSON ");
             ((HttpHead)obj).addHeader("Accept", "application/json");
         } else
         {
             ((HttpHead)obj).addHeader("Accept", "text/html,application/xhtml+xml,application/xml,text/plain");
         }
     } else
     {
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "Requesttype not supported");
         return;
     }
//     continue; /* Loop/switch isn't completed */
     
     
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "reading http response");
     if(MF_CookieHTTPHandler_k536 == null) {
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "*NOT* setting cookie to request");
     } else {
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "Setting cookie to request");
	     ((HttpRequestBase) (obj)).setHeader("Cookie", MF_CookieHTTPHandler_k536);
     }
     httpresponse = this.go(((HttpRequestBase) (obj)));
     aheader = httpresponse.getAllHeaders();
     i = aheader.length;
     j = 0;

     for(;j < i;j++) {
	     header = aheader[j];
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("HEADERS: ").append(header.getName()).append(": ").append(header.getValue()).toString());
     }
     //goto _L7

     
     int k;
     k = isExceptionLogged(httpresponse);
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("reading http response, statusCode = ").append(k).toString());
     String s = "";
     Header aheader1[] = httpresponse.getAllHeaders();
     int l = 0;

     for(;l < aheader1.length;l++)
     {
         Header header1 = aheader1[l];
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("Header names: ").append(header1.getName()).toString());
         CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("Header Value: ").append(header1.getValue()).toString());
         if(header1.getName().equals("Date"))
             s = header1.getValue();
     }
     if(k < 400) {
	     String s1;
	     InputStream inputstream;
	     s1 = "";
	     inputstream = null;
	     if(isGZiped) {
		     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "reading http response, gzip");
		     if(MF_CookieHTTPHandler_h533 != 0) {
			     String s2 = MF_CookieHTTPHandler_c524(httpresponse);
			     s1 = s2;
			     inputstream = null;
		     } else {
		    	 inputstream = MF_CookieHTTPHandler_d525(httpresponse);
		     }
		     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("reading http response, gzip, temp_result = ").append(s1).append(", temp_in = ").append(inputstream).toString());
	     } else {
		     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", "reading http response, no-gzip");
		     s1 = MF_CookieHTTPHandler_b523(httpresponse);
	     }
	     isExceptionLogged.execute(new CLASS176(this, k, s1, inputstream, s));
	     return;
     } else {
	     String s3 = "";
	     StringBuilder stringbuilder;
	     BufferedReader bufferedreader;
	     String s4;
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   getContentLength() = ").append(httpresponse.getEntity().getContentLength()).toString());
	     InputStreamReader inputstreamreader = new InputStreamReader(httpresponse.getEntity().getContent());
	     stringbuilder = new StringBuilder();
	     bufferedreader = new BufferedReader(inputstreamreader);
	     s4 = bufferedreader.readLine();
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   read = ").append(s4).toString());
	     while(s4 != null) {
		     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   read = ").append(s4).toString());
		     stringbuilder.append(s4);
		     s4 = bufferedreader.readLine();
	     }
	     s3 = stringbuilder.toString();
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run():   errStr = ").append(s3).toString());
	     try
	     {
	         isExceptionLogged.execute(new CLASS175(this, k, s3));
	         return;
	     }
	     catch(Exception exception)
	     {
	         if(CLASS113.isExceptionLogged.booleanValue())
	             exception.printStackTrace();
	     }
	     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("CookieHTTPHandler.run(), request failed: requestType=").append(MF_CookieHTTPHandler_b523).append(", url=").append(MF_CookieHTTPHandler_c524).append(", xml=").append(MF_CookieHTTPHandler_e526).toString());
	     isExceptionLogged.execute(new CLASS171(this));
	     return;
     }    
     } catch(Exception ex) {
    	 ex.printStackTrace();
     }
 }
 


 static ThreadPoolExecutor isExceptionLogged = null;
 private static DefaultHttpClient MF_CookieHTTPHandler_m528 = null;
 private static int MF_CookieHTTPHandler_n529;
 private static final BlockingQueue MF_CookieHTTPHandler_o531;
 private static final TimeUnit MF_CookieHTTPHandler_p530;
 private int MF_CookieHTTPHandler_b523;
 private String MF_CookieHTTPHandler_c524;
 private List MF_CookieHTTPHandler_d525;
 private String MF_CookieHTTPHandler_e526;
 private IDeviceCheck mIDeviceCheck;
 private boolean isGZiped;
 private int MF_CookieHTTPHandler_h533;
 private InputStream MF_CookieHTTPHandler_i534;
 private long MF_CookieHTTPHandler_j535;
 private String MF_CookieHTTPHandler_k536;
 private String MF_CookieHTTPHandler_l537;

 static
 {
     MF_CookieHTTPHandler_n529 = Runtime.getRuntime().availableProcessors();
     MF_CookieHTTPHandler_p530 = TimeUnit.SECONDS;
     MF_CookieHTTPHandler_o531 = new LinkedBlockingQueue();
     CLASS167.MF_CLASS167_b635("CookieHTTPHandler", (new StringBuilder()).append("Creating threadpool of size: ").append(MF_CookieHTTPHandler_n529).toString());
     isExceptionLogged = new ThreadPoolExecutor(MF_CookieHTTPHandler_n529, MF_CookieHTTPHandler_n529, 1L, MF_CookieHTTPHandler_p530, MF_CookieHTTPHandler_o531);
 }
}
