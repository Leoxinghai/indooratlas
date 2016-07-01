// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

// Referenced classes of package org.slf4j.helpers:
//            BasicMarker

public class BasicMarkerFactory
    implements IMarkerFactory
{

    public BasicMarkerFactory()
    {
        markerMap = new HashMap();
    }

    public boolean detachMarker(String s)
    {
        while(s == null || markerMap.remove(s) == null) 
            return false;
        return true;
    }

    public boolean exists(String s)
    {
    	boolean flag1 = false;
        if(s != null){
            boolean flag = markerMap.containsKey(s);
            flag1 = flag;
        }
        
        return flag1;
    }

    public Marker getDetachedMarker(String s)
    {
        return new BasicMarker(s);
    }

    public Marker getMarker(String s) throws IllegalArgumentException
    {
        if(s != null) {
            Object obj = (Marker)markerMap.get(s);
            if(obj == null)
            	obj = new BasicMarker(s);
            markerMap.put(s, obj);
            return ((Marker) (obj));
        } else 
        	throw new IllegalArgumentException("Marker name cannot be null");
    }

    Map markerMap;
}
