// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS360, IndoorMapView

class CLASS359 extends TimerTask
{

    CLASS359(IndoorMapView indoormapview, Handler handler)
    {
        super();
        mIndoorMapView = indoormapview;
        MF_CLASS359_a969 = handler;
    }

    public void run()
    {
        MF_CLASS359_a969.post(new CLASS360(this));
    }

    final Handler MF_CLASS359_a969;
    final IndoorMapView mIndoorMapView;
}
