// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.position;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.*;

// Referenced classes of package com.indooratlas.position:
//            CLASS70, CLASS75

public class CLASS74 extends Thread
{

    public CLASS74()
    {
    }

    private void MF_CLASS74_a256(CLASS70 class70)
    {
        if(class70.MF_CLASS70_c234() == null) {
            try
            {
                CLASS75.MF_CLASS75_b260("LoggingThread", (new StringBuilder()).append("sendLogMessage called: class == null, message = ").append(class70.MF_CLASS70_d235()).append(", tag = ").append(class70.MF_CLASS70_b233()).toString());
            }
            catch(Exception exception)
            {
                return;
            }
        } else {
        	CLASS75.MF_CLASS75_b260("LoggingThread", (new StringBuilder()).append("sendLogMessage called: class = ").append(class70.MF_CLASS70_c234().getName()).append(", message = ").append(class70.MF_CLASS70_d235()).append(", tag = ").append(class70.MF_CLASS70_b233()).toString());
        }

        Logger logger;
        logger = LoggerFactory.getLogger(class70.MF_CLASS70_c234());
        if(class70.MF_CLASS70_a232() < 3) {
            CLASS75.MF_CLASS75_b260("LoggingThread", "sendLogMessage called lm.getLogLevel() ***NO MATCH**");
            return;
        }
        CLASS75.MF_CLASS75_b260("LoggingThread", (new StringBuilder()).append("sendLogMessage called: logger = ").append(logger).append(" message = ").append(class70.MF_CLASS70_d235()).append(", tag = ").append(class70.MF_CLASS70_b233()).toString());
        if(class70.MF_CLASS70_a232() == 3)
        {
            CLASS75.MF_CLASS75_b260("LoggingThread", "sendLogMessage called logLevel = DEBUG");
            logger.debug((new StringBuilder()).append(class70.MF_CLASS70_b233()).append(",").append(class70.MF_CLASS70_d235()).toString());
            return;
        }
        if(class70.MF_CLASS70_a232() == 4)
        {
            CLASS75.MF_CLASS75_b260("LoggingThread", "sendLogMessage called lm.getLogLevel() = INFO");
            logger.info((new StringBuilder()).append(class70.MF_CLASS70_b233()).append(",").append(class70.MF_CLASS70_d235()).toString());
            return;
        }
        if(class70.MF_CLASS70_a232() == 5)
        {
            CLASS75.MF_CLASS75_b260("LoggingThread", "sendLoglm.getMessage() called lm.getLogLevel() = WARN");
            logger.warn((new StringBuilder()).append(class70.MF_CLASS70_b233()).append(",").append(class70.MF_CLASS70_d235()).toString());
            return;
        }
        if(class70.MF_CLASS70_a232() == 6)
        {
            CLASS75.MF_CLASS75_b260("LoggingThread", "sendLoglm.getMessage() called lm.getLogLevel() = ERROR");
            logger.error((new StringBuilder()).append(class70.MF_CLASS70_b233()).append(",").append(class70.MF_CLASS70_d235()).toString());
            return;
        }
    }

    public void MF_CLASS74_a256(String s, String s1)
    {
        synchronized(MF_CLASS74_c258)
        {
            MF_CLASS74_c258.put(s, s1);
        }
        return;
    }

    public void run()
    {
        CLASS75.MF_CLASS75_b260("LoggingThread", (new StringBuilder()).append("LoggingThread.run called this = ").append(this).toString());
        MF_CLASS74_a256 = true;
        System.currentTimeMillis();

        while(MF_CLASS74_a256) {
	        try
	        {

	        Hashtable hashtable = MF_CLASS74_c258;
	        if(MF_CLASS74_c258.size() > 0)
	        {
	            String s;
	            for(Iterator iterator = MF_CLASS74_c258.keySet().iterator(); iterator.hasNext();) {
	                s = (String)iterator.next();
	                //MDC.put(s, (String)MF_CLASS74_c258.get(s));
	            }
	
	        }
	        ConcurrentLinkedQueue concurrentlinkedqueue;
	        MF_CLASS74_c258.clear();
	        concurrentlinkedqueue = MF_CLASS74_b257;

	        if(MF_CLASS74_b257.size() <= 0) {
	        	synchronized(MF_CLASS74_b257) {
	        		MF_CLASS74_b257.wait(20L);
	        	}
	        } else 
	        	MF_CLASS74_a256((CLASS70)MF_CLASS74_b257.poll());
	        
	        }
	        catch(InterruptedException interruptedexception) { }
	        catch(Exception exception) {
	        	exception.printStackTrace();
	        }
	        
	        
	    }
        return;
        
    }

    
    static boolean MF_CLASS74_a256 = false;
    private static ConcurrentLinkedQueue MF_CLASS74_b257 = new ConcurrentLinkedQueue();
    private static Hashtable MF_CLASS74_c258 = new Hashtable();

}
