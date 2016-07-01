// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.MotionEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS316, CLASS225

class CLASS313 extends android.view.GestureDetector.SimpleOnGestureListener
{

    private CLASS313(MapScreen mapscreen)
    {
        super();
        MF_CLASS313_a889 = mapscreen;
    }

    CLASS313(MapScreen mapscreen, CLASS225 class225)
    {
        this(mapscreen);
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onDoubleTap(): double tap enabled? ");
        if(MF_CLASS313_a889.mScreenPointType == POINT_TYPE.RECORDING)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onDoubleTap(): skippinh double tap, because recording  ");
            return super.onDoubleTap(motionevent);
        } else
        {
            MapScreen.doubleTap(MF_CLASS313_a889);
            MapScreen.w(MF_CLASS313_a889);
            return super.onDoubleTap(motionevent);
        }
    }

    final MapScreen MF_CLASS313_a889;
}
