// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

// Referenced classes of package org.slf4j.helpers:
//            NOPLogger

public class SubstituteLoggerFactory
    implements ILoggerFactory
{

    public SubstituteLoggerFactory()
    {
    }

    public Logger getLogger(String s)
    {
        synchronized(loggerNameList)
        {
            loggerNameList.add(s);
        }
        return NOPLogger.NOP_LOGGER;
    }

    public List getLoggerNameList()
    {
        ArrayList arraylist = new ArrayList();
        synchronized(loggerNameList)
        {
            arraylist.addAll(loggerNameList);
        }
        return arraylist;
    }

    final List loggerNameList = new ArrayList();
}
