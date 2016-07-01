// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS364, IndoorMapView

class CLASS363 extends TimerTask
{

    CLASS363(IndoorMapView indoormapview, Handler handler)
    {
        super();
        MF_CLASS363_b974 = indoormapview;
        MF_CLASS363_a975 = handler;
    }

    public void run()
    {
        MF_CLASS363_a975.post(new CLASS364(this));
    }

    final Handler MF_CLASS363_a975;
    final IndoorMapView MF_CLASS363_b974;
}
