package com.indooratlas.mapcreator.main;


import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.position.CLASS75;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.*;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.io.IOException;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         LoginActivity

public class PerformNetworkLoginTask extends AsyncTask
{

 public PerformNetworkLoginTask(LoginActivity loginactivity)
 {
     super();
     MF_CLASS113_a486 = loginactivity;
 }

 protected Void MF_CLASS113_a486(String as[]) //throws UnsupportedEncodingException,IOException
 {
     SharedPreferences sharedpreferences;
     DefaultHttpClient defaulthttpclient;
     BasicHttpParams basichttpparams;
     HttpResponse httpresponse;
     HttpEntity httpentity;
     CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "PerformNetworkLoginTask.doInBackground");
     if(CLASS113.isExceptionLogged.booleanValue())
         CLASS167.MF_CLASS113_a486();
     String s = as[0];
     String s1 = as[1];
     try {

	        LoginActivity.MF_CLASS19_a67(MF_CLASS113_a486, s);
	        CLASS75.MF_CLASS75_a259(4, "APP_STARTED", MF_CLASS113_a486.f.getClass(), "PerformNetworkLoginTask. Performing first LogBack call. Setting up.");
	        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("Sending username=").append(s).append(",password=").append(s1).toString());
	        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(MF_CLASS113_a486.f.getApplicationContext());
	        String s2 = sharedpreferences.getString("login_address", MF_CLASS113_a486.getString(0x7f080064));
	        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("RestClient(): loginURL = ").append(s2).toString());
	        defaulthttpclient = MF_CLASS113_a486();
	        HttpPost httppost = new HttpPost(s2);
	        String s3 = (new StringBuilder()).append("{\n\"username\":\"").append(s).append("\",\n").append("\"password\":\"").append(s1).append("\"\n}").toString();
	        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("body in login: ").append(s3).toString());
	        
	        StringEntity stringentity = new StringEntity(s3, "UTF-8");
	        ((HttpPost)httppost).setEntity(stringentity);
	        ((HttpPost)httppost).setHeader("Content-Type", "application/json");
	        ((HttpPost)httppost).setHeader("Accept", "application/json");
	        basichttpparams = new BasicHttpParams();
	        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
	        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
	        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("request = ").append(httppost).toString());
	        httpresponse = defaulthttpclient.execute(httppost);
	        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("Got http response, status = ").append(httpresponse.getStatusLine().getStatusCode()).toString());
	        httpentity = httpresponse.getEntity();
	        if(httpresponse.getStatusLine().getStatusCode() < 300 && httpentity != null)
	        {
	            try
	            {
	                String s4 = EntityUtils.toString(httpentity);
	                CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("GOT RESPONSE: ").append(s4).toString());
	                JSONObject jsonobject = new JSONObject(s4);
	                MF_CLASS113_a486.k = jsonobject.getString("userId");
	                CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("mUserID  = ").append(MF_CLASS113_a486.k).toString());
	                for(Iterator iterator = defaulthttpclient.getCookieStore().getCookies().iterator(); iterator.hasNext();)
	                {
	                    Cookie cookie = (Cookie)iterator.next();
	                    CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("cookie = ").append(cookie.getName()).toString());
	                    CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("cookie = ").append(cookie.getValue()).toString());
	                    CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("cookie = ").append(cookie.getDomain()).toString());
	                    CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("cookie = ").append(cookie.getPath()).toString());
	                    MF_CLASS113_a486.i = cookie;
	                }
	
	            }
	            catch(Exception exception)
	            {
	                MF_CLASS113_a486.j = true;
	                CLASS75.MF_CLASS75_a259(5, "LOGIN_FAILED", MF_CLASS113_a486.f.getClass(), (new StringBuilder()).append("PerformNetworkLoginTask. login failed due to network error: ").append(CLASS75.MF_CLASS75_a259(exception)).toString());
	                if(CLASS113.isExceptionLogged.booleanValue())
	                    exception.printStackTrace();
	                return null;
	            }
	            try {
		            HttpResponse httpresponse1;
		            HttpEntity httpentity1;
		            DefaultHttpClient defaulthttpclient1 = MF_CLASS113_a486();
		            String s5 = sharedpreferences.getString("backend_address", MF_CLASS113_a486.f.getString(0x7f080065));
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("login(): backendURL = ").append(s5).toString());
		            String s6 = (new StringBuilder()).append(s5).append("/users/").append(MF_CLASS113_a486.k).append("/key").toString();
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("login(): apiKeyURL = ").append(s6).toString());
		            HttpGet httpget = new HttpGet(s6);
		            HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
		            HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
		            ((HttpGet)httpget).setHeader("Cookie", (new StringBuilder()).append(MF_CLASS113_a486.i.getName()).append("=").append(MF_CLASS113_a486.i.getValue()).toString());
		            ((HttpGet)httpget).setHeader("Accept", "application/json");
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("request = ").append(httpget).toString());
		            httpresponse1 = defaulthttpclient1.execute(httpget);
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("Got http response, status = ").append(httpresponse1.getStatusLine().getStatusCode()).toString());
		            httpentity1 = httpresponse1.getEntity();
		            if(httpresponse1.getStatusLine().getStatusCode() >= 300 || httpentity1 == null) {
		                MF_CLASS113_a486(httpentity1);
		                return null;
		            	
		            }
		
		            String s7 = EntityUtils.toString(httpentity1);
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("GOT APIKEY RESPONSE: ").append(s7).toString());
		            JSONObject jsonobject1 = new JSONObject(s7);
		            MF_CLASS113_a486.m = jsonobject1.getString("Id");
		            MF_CLASS113_a486.l = jsonobject1.getString("SecretKey");
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("mSecret  = ").append(MF_CLASS113_a486.l).toString());
		            CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("mApiKey  = ").append(MF_CLASS113_a486.m).toString());
	            } catch(Exception ex) {
	            	ex.printStackTrace();
	            }
	            return null;
	        }
	
	        MF_CLASS113_a486(httpentity);
     } catch(Exception ex0){
     	ex0.printStackTrace();
     }
     
     return null;
 }

 public DefaultHttpClient MF_CLASS113_a486()
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
     return new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
 }

 protected void MF_CLASS113_a486_sipa(Void void1)
 {
     CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "PerformNetworkLoginTask.onPostExecute");
     if(isCancelled())
     {
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "PerformNetworkLoginTask.onPostExecute: task has been cancelled! Just return.");
         return;
     }
     if(MF_CLASS113_a486.i != null && !MF_CLASS113_a486.j && MF_CLASS113_a486.m != null && !MF_CLASS113_a486.m.isEmpty())
     {
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "PerformNetworkLoginTask.onPostExecute, processing login");
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "remembering user name");
         android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MF_CLASS113_a486.f.getApplicationContext()).edit();
         editor.putString("user_name", MF_CLASS113_a486.MF_CLASS22_g77);
         editor.putString("password", MF_CLASS113_a486.h);
         boolean flag = editor.commit();
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("stored username to preferences, writtenPersistently = ").append(flag).toString());
         LoginActivity.f(MF_CLASS113_a486);
         if(LoginActivity.MF_CLASS22_g77(MF_CLASS113_a486) != null && LoginActivity.h(MF_CLASS113_a486) != null)
             LoginActivity.MF_CLASS19_a67(MF_CLASS113_a486, LoginActivity.MF_CLASS22_g77(MF_CLASS113_a486), LoginActivity.h(MF_CLASS113_a486));
         LoginActivity.startMapCreator_i(MF_CLASS113_a486);
         return;
     } else
     {
         MF_CLASS113_a486.f();
         return;
     }
 }

 public void MF_CLASS113_a486(HttpEntity httpentity)
 {
     StringBuilder stringbuilder;
     BufferedReader bufferedreader;
     String s;
     try
     {
         InputStreamReader inputstreamreader = new InputStreamReader(httpentity.getContent());
         stringbuilder = new StringBuilder();
         bufferedreader = new BufferedReader(inputstreamreader);
         while(true) {
         	s = bufferedreader.readLine();
             if(s == null)
             	break;
             stringbuilder.append(s);
         }
         String s1 = stringbuilder.toString();
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("loginActivity.debugPrintErrorStream:  - default, errStr = ").append(s1).toString());
     }
     catch(Exception exception)
     {
         exception.printStackTrace();
     	return;
     }
     return;
 }

 protected Object doInBackground(Object aobj[]) 
 {
     return MF_CLASS113_a486((String[])aobj);
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS113_a486_sipa((Void)obj);
 }

 protected void onPreExecute()
 {
     CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "PerformNetworkLoginTask.onPreExecute");
 }

 final LoginActivity MF_CLASS113_a486;
}
