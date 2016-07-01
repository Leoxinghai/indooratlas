// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

public class CLASS368 extends Thread
{

    public void run()
    {
        long l;
        CLASS167.MF_CLASS167_b635("LogCatReaderThread", "run called");
        l = System.currentTimeMillis();
        SimpleDateFormat simpledateformat;
        try {
        MF_CLASS368_b987 = Runtime.getRuntime().exec("logcat");
        CLASS167.MF_CLASS167_b635("LogCatReaderThread", (new StringBuilder()).append("LogCatReaderThread.run logcat process created = ").append(MF_CLASS368_b987).toString());
        MF_CLASS368_c988 = new BufferedReader(new InputStreamReader(MF_CLASS368_b987.getInputStream()));
        simpledateformat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss.SSSZ");
        String s = simpledateformat.format(new Date(System.currentTimeMillis()));
        MF_CLASS368_d989 = CLASS167.openFileForWriting((new StringBuilder()).append("Logcat_").append(s).append(".zip").toString(), "dbgfiles");
        MF_CLASS368_g990 = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(MF_CLASS368_d989)));
        MF_CLASS368_e991 = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(MF_CLASS368_g990), "UTF-8"));
        MF_CLASS368_e991.write("Test line\n");
        CLASS167.MF_CLASS167_b635("LogCatReaderThread", (new StringBuilder()).append("LogCatReaderThread.run wrote test line to file : ").append(MF_CLASS368_d989).toString());
//        new StringBuilder();
        while(MF_CLASS113_a486) {
	        
	        while(true) {
		        String s1 = MF_CLASS368_c988.readLine();
		        long l1;
		        if(s1 == null || !MF_CLASS113_a486) {
			        try
			        {
			            CLASS167.MF_CLASS167_b635("LogCatReaderThread", "LogCatReaderThread.run calling mLogCatProcess.destroy()");
			            MF_CLASS368_b987.destroy();
			            MF_CLASS368_e991.flush();
			            MF_CLASS368_e991.close();
			            CLASS167.MF_CLASS167_b635("LogCatReaderThread", "LogCatReaderThread.run(): stopped, returning, dying...");
			        }
			        // Misplaced declaration of an exception variable
			        catch(Exception exception)
			        {
			            if(CLASS113.isExceptionLogged.booleanValue())
			                exception.printStackTrace();
			        }
			        MF_CLASS368_f993 = true;
			        return;
		        	
		        }
		        
		        l1 = System.currentTimeMillis();
		        long l2;
		        l2 = l1 - l;
		        if(l2 > 0x493e0L) {
			        CLASS167.MF_CLASS167_b635("LogCatReaderThread", (new StringBuilder()).append("LogCatReaderThread.run diff = ").append(l2).append(", stopping LogCatReaderThread, because max time is ").append(0x493e0L).toString());
			        MF_CLASS113_a486 = false;
			        break;
			        //Exception exception;
		        } else {
			        String s2 = simpledateformat.format(new Date(l1));
			        MF_CLASS368_e991.write((new StringBuilder()).append(s2).append(" : ").append(s1).append("\n").toString());
		        }
	        }
	        
	        CLASS167.MF_CLASS167_b635("LogCatReaderThread", "LogCatReaderThread.run exited Logcat reading while, going back to it soon");
	        try
	        {
	            Thread.sleep(10L);
	        }
	        // Misplaced declaration of an exception variable
	        catch(Exception exception1) {
	        	exception1.printStackTrace();
	        }
    	}
        
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

    private boolean MF_CLASS113_a486;
    private Process MF_CLASS368_b987;
    private BufferedReader MF_CLASS368_c988;
    private File MF_CLASS368_d989;
    private BufferedWriter MF_CLASS368_e991;
    private boolean MF_CLASS368_f993;
    private BufferedOutputStream MF_CLASS368_g990;
}
