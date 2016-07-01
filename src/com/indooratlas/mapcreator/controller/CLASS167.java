// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.indooratlas.mapcreator.main.MapScreen;
import com.indooratlas.position.CLASS75;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS113

public class CLASS167
{

    public static File openFileForWriting(String s, String s1)
    {
        File file = new File(Environment.getExternalStorageDirectory(), (new StringBuilder()).append("/").append(s1).append("/").toString());
        boolean flag = file.mkdirs();
        Log.d("Util", (new StringBuilder()).append("openFileForWriting, created = ").append(flag).toString());
        Log.d("Util", (new StringBuilder()).append(" MapScreen.openFileForWriting: file path :").append(file.toString()).toString());
        if(file.canWrite())
        {
            return new File(file, s);
        } else
        {
            Log.d("Util", " MapScreen.openFileForWriting: canWrite = false, Could not open file for writing ");
            return null;
        }
    }

    public static PrintStream MF_CLASS113_a486(File file)
    {
        PrintStream printstream;
        try
        {
            printstream = new PrintStream(new FileOutputStream(file));
        }
        catch(IOException ioexception)
        {
            Log.d("Util", (new StringBuilder()).append(" MapScreen.createFilePrintStream: Could not open file for writing ").append(ioexception.getMessage()).toString());
            return null;
        }
        return printstream;
    }

    private static String MF_CLASS113_a486(Exception exception)
    {
        StringWriter stringwriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString();
    }

    public static void MF_CLASS113_a486()
    {
        Logger.getLogger("org.apache.http.wire").setLevel(Level.FINEST);
        Logger.getLogger("org.apache.http.headers").setLevel(Level.FINEST);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
    }

    public static void unhandledexception(Exception exception, Context context)
    {
        try {
	    	String s = MF_CLASS113_a486(exception);
	        CLASS75.MF_CLASS75_a259(4, "UNHANDLED_EXCEPTION", MapScreen.class, (new StringBuilder()).append("unhandledexception: ").append(exception.getMessage()).append(", ").append(s).toString());
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            PrintStream printstream = MF_CLASS113_a486(openFileForWriting((new StringBuilder()).append("Exception_").append(System.currentTimeMillis()).append(".txt").toString(), "errorfiles"));
	            exception.printStackTrace(printstream);
	            printstream.flush();
	            printstream.close();
	        }
	
	        return;
        } catch(Exception exception1) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception1.printStackTrace();
	            return;
	        }
        }
    }

    public static void MF_CLASS167_b635(String s, String s1)
    {
        if(CLASS113.isExceptionLogged.booleanValue())
            Log.d(s, s1);
        int ll = 0;
    }
}
