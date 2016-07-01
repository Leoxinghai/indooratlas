// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

// Referenced classes of package org.slf4j:
//            ILoggerFactory, Logger

public final class LoggerFactory
{

    private LoggerFactory()
    {
    }

    private static final void bind()
    {
        try
        {
            Set set = findPossibleStaticLoggerBinderPathSet();
            reportMultipleBindingAmbiguity(set);
            StaticLoggerBinder.getSingleton();
            INITIALIZATION_STATE = 3;
            reportActualBinding(set);
            emitSubstituteLoggerWarning();
            return;
        }
        catch(NoClassDefFoundError noclassdeffounderror)
        {
            if(messageContainsOrgSlf4jImplStaticLoggerBinder(noclassdeffounderror.getMessage()))
            {
                INITIALIZATION_STATE = 4;
                Util.report("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                Util.report("Defaulting to no-operation (NOP) logger implementation");
                Util.report("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            } else
            {
                failedBinding(noclassdeffounderror);
                throw noclassdeffounderror;
            }
        }
        catch(NoSuchMethodError nosuchmethoderror)
        {
            String s = nosuchmethoderror.getMessage();
            if(s != null && s.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") != -1)
            {
                INITIALIZATION_STATE = 2;
                Util.report("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                Util.report("Your binding is version 1.5.5 or earlier.");
                Util.report("Upgrade your binding to version 1.6.x.");
            }
            throw nosuchmethoderror;
        }
        catch(Exception exception)
        {
            failedBinding(exception);
            throw new IllegalStateException("Unexpected initialization failure", exception);
        }
    }

    private static final void emitSubstituteLoggerWarning()
    {
        List list = TEMP_FACTORY.getLoggerNameList();
        if(list.size() != 0)
        {
            Util.report("The following loggers will not work because they were created");
            Util.report("during the default configuration phase of the underlying logging system.");
            Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
            int i = 0;
            while(i < list.size()) 
            {
                Util.report((String)list.get(i));
                i++;
            }
        }
    }

    static void failedBinding(Throwable throwable)
    {
        INITIALIZATION_STATE = 2;
        Util.report("Failed to instantiate SLF4J LoggerFactory", throwable);
    }

    private static Set findPossibleStaticLoggerBinderPathSet()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        try
        {
        
	        ClassLoader classloader = LoggerFactory.class.getClassLoader();
	        Enumeration enumeration;
	        
	        if(classloader != null) {
	                Enumeration enumeration1 = classloader.getResources(STATIC_LOGGER_BINDER_PATH);
	                enumeration = enumeration1;
	        }
            for(enumeration = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH); enumeration.hasMoreElements(); linkedhashset.add((URL)enumeration.nextElement()));
        }
        catch(IOException ioexception)
        {
            Util.report("Error getting resources from path", ioexception);
        }
        return linkedhashset;
    }

    public static ILoggerFactory getILoggerFactory()
    {
        if(INITIALIZATION_STATE == 0)
        {
            INITIALIZATION_STATE = 1;
            performInitialization();
        }
        switch(INITIALIZATION_STATE)
        {
        default:
            throw new IllegalStateException("Unreachable code");

        case 3: // '\003'
            return StaticLoggerBinder.getSingleton().getLoggerFactory();

        case 4: // '\004'
            return NOP_FALLBACK_FACTORY;

        case 2: // '\002'
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");

        case 1: // '\001'
            return TEMP_FACTORY;
        }
    }

    public static Logger getLogger(Class class1)
    {
        return getLogger(class1.getName());
    }

    public static Logger getLogger(String s)
    {
        return getILoggerFactory().getLogger(s);
    }

    private static boolean isAmbiguousStaticLoggerBinderPathSet(Set set)
    {
        return set.size() > 1;
    }

    private static boolean messageContainsOrgSlf4jImplStaticLoggerBinder(String s)
    {
        if(s != null)
        {
            if(s.indexOf("org/slf4j/impl/StaticLoggerBinder") != -1)
                return true;
            if(s.indexOf("org.slf4j.impl.StaticLoggerBinder") != -1)
                return true;
        }
        return false;
    }

    private static final void performInitialization()
    {
        bind();
        if(INITIALIZATION_STATE == 3)
            versionSanityCheck();
    }

    private static void reportActualBinding(Set set)
    {
        if(isAmbiguousStaticLoggerBinderPathSet(set))
            Util.report((new StringBuilder()).append("Actual binding is of type [").append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr()).append("]").toString());
    }

    private static void reportMultipleBindingAmbiguity(Set set)
    {
        if(isAmbiguousStaticLoggerBinderPathSet(set))
        {
            Util.report("Class path contains multiple SLF4J bindings.");
            URL url;
            for(Iterator iterator = set.iterator(); iterator.hasNext(); Util.report((new StringBuilder()).append("Found binding in [").append(url).append("]").toString()))
                url = (URL)iterator.next();

            Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    static void reset()
    {
        INITIALIZATION_STATE = 0;
        TEMP_FACTORY = new SubstituteLoggerFactory();
    }

    private static final void versionSanityCheck()
    {
        int i;
        boolean flag = false;
        String s;
        try
        {
            s = StaticLoggerBinder.REQUESTED_API_VERSION;
        }
        catch(NoSuchFieldError nosuchfielderror)
        {
            return;
        }
        catch(Throwable throwable)
        {
            Util.report("Unexpected problem occured during version sanity check", throwable);
            return;
        }
        i = 0;

        for(;i < API_COMPATIBILITY_LIST.length;i++)
        {
            if(s.startsWith(API_COMPATIBILITY_LIST[i]))
                flag = true;
        }
        if(flag)
            Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        else 
        	Util.report((new StringBuilder()).append("The requested version ").append(s).append(" by your slf4j binding is not compatible with ").append(Arrays.asList(API_COMPATIBILITY_LIST).toString()).toString());
        return;
    }

    private static final String API_COMPATIBILITY_LIST[] = {
        "1.6", "1.7"
    };
    static final String CODES_PREFIX = "http://www.slf4j.org/codes.html";
    static final int FAILED_INITIALIZATION = 2;
    static int INITIALIZATION_STATE = 0;
    static final String MULTIPLE_BINDINGS_URL = "http://www.slf4j.org/codes.html#multiple_bindings";
    static NOPLoggerFactory NOP_FALLBACK_FACTORY = new NOPLoggerFactory();
    static final int NOP_FALLBACK_INITIALIZATION = 4;
    static final String NO_STATICLOGGERBINDER_URL = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
    static final String NULL_LF_URL = "http://www.slf4j.org/codes.html#null_LF";
    static final int ONGOING_INITIALIZATION = 1;
    private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    static final String SUBSTITUTE_LOGGER_URL = "http://www.slf4j.org/codes.html#substituteLogger";
    static final int SUCCESSFUL_INITIALIZATION = 3;
    static SubstituteLoggerFactory TEMP_FACTORY = new SubstituteLoggerFactory();
    static final int UNINITIALIZED = 0;
    static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String UNSUCCESSFUL_INIT_URL = "http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String VERSION_MISMATCH = "http://www.slf4j.org/codes.html#version_mismatch";

    static 
    {
        INITIALIZATION_STATE = 0;
    }
}
