// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS362, IndoorMapView

class CLASS361 extends TimerTask
{

    CLASS361(IndoorMapView indoormapview, Handler handler)
    {
        super();
        mIndoorMapView = indoormapview;
        MF_CLASS361_a972 = handler;
    }

    public void run()
    {
        MF_CLASS361_a972.post(new ReconnectingTimer(this));
    }

    final Handler MF_CLASS361_a972;
    final IndoorMapView mIndoorMapView;
}
