// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.slf4j.helpers;

import java.util.*;
import org.slf4j.spi.MDCAdapter;

public class BasicMDCAdapter
    implements MDCAdapter
{

    public BasicMDCAdapter()
    {
        inheritableThreadLocal = new InheritableThreadLocal();
    }

    static boolean isJDK14()
    {
        boolean flag;
        try
        {
            flag = System.getProperty("java.version").startsWith("1.4");
        }
        catch(SecurityException securityexception)
        {
            return false;
        }
        return flag;
    }

    public void clear()
    {
label0:
        {
            Map map = (Map)inheritableThreadLocal.get();
            if(map != null)
            {
                map.clear();
                if(!isJDK14())
                    break label0;
                inheritableThreadLocal.set(null);
            }
            return;
        }
        inheritableThreadLocal.remove();
    }

    public String get(String s)
    {
        Map map = (Map)inheritableThreadLocal.get();
        if(map != null && s != null)
            return (String)map.get(s);
        else
            return null;
    }

    public Map getCopyOfContextMap()
    {
        Map map;
        map = (Map)inheritableThreadLocal.get();
        if(map == null)
            return null;
        Map map1 = Collections.synchronizedMap(new HashMap());
        map1.putAll(map);
        return map1;
    }

    public Set getKeys()
    {
        Map map = (Map)inheritableThreadLocal.get();
        if(map != null)
            return map.keySet();
        else
            return null;
    }

    public void put(String s, String s1)
    {
        if(s == null)
            throw new IllegalArgumentException("key cannot be null");
        Map map = (Map)inheritableThreadLocal.get();
        if(map == null)
        {
            map = Collections.synchronizedMap(new HashMap());
            inheritableThreadLocal.set(map);
        }
        map.put(s, s1);
    }

    public void remove(String s)
    {
        Map map = (Map)inheritableThreadLocal.get();
        if(map != null)
            map.remove(s);
    }

    public void setContextMap(Map map)
    {
        Map map1 = Collections.synchronizedMap(new HashMap(map));
        inheritableThreadLocal.set(map1);
    }

    static boolean IS_JDK14 = isJDK14();
    private InheritableThreadLocal inheritableThreadLocal;

}
