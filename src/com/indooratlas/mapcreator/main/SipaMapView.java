// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;

//import com.google.android.maps.LatLng;
//import com.google.android.maps.MapView;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS199

public class SipaMapView extends MapView
{

    public SipaMapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        d = true;
    }

    public SipaMapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = -1;
        d = true;
    }

    public SipaMapView(Context context, String s)
    {
    	super(context);
//        super(context, s);
        a = -1;
        d = true;
    }

    public void disableListener()
    {
        d = false;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        /*
    	CLASS167.MF_CLASS167_b635("MapView", (new StringBuilder()).append("SipaMapView.dispatchDraw() called, enabled = ").append(d).append(" newZoom = ").append(getZoomLevel()).append(", oldZoom = ").append(a).toString());
        if(!d) 
        	return;
        
        if(getZoomLevel() <= a) {
            if(getZoomLevel() < a)
            {
                a = getZoomLevel();
                c.onZoomOut();
            }
        } else {
	        a = getZoomLevel();
	        c.onZoomIn();
        }
        */
        dispatchDraw(canvas);
        return;
    }

    public void enableListener()
    {
        d = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
    	/*
        CLASS167.MF_CLASS167_b635("MapView", (new StringBuilder()).append("SipaMapView.onTouchEvent() called, enabled = ").append(d).append(" newZoom = ").append(getZoomLevel()).append(", oldZoom = ").append(a).append(", ev = ").append(motionevent).toString());
        if(motionevent.getAction() == 1)
        {
            LatLng geopoint = getMapCenter();
            if(b == null || b.getLatitudeE6() != geopoint.getLatitudeE6() || b.getLongitudeE6() != geopoint.getLongitudeE6())
                c.onPan();
            b = getMapCenter();
        }
        */
        boolean flag;
        synchronized(c)
        {
            flag = onTouchEvent(motionevent);
        }
        return flag;
    }

    public void setOnPanListener(CLASS199 class199)
    {
        c = class199;
    }

    public static final String TAG = "MapView";
    private int a;
    private LatLng b;
    private CLASS199 c;
    private boolean d;
}
