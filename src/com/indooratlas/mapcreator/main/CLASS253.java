// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS253 extends CountDownTimer
{

    CLASS253(MapScreen mapscreen, long l, long l1)
    {
        super(l, l1);
        MF_CLASS253_a801 = mapscreen;
    }

    public void onFinish()
    {
    }

    public void onTick(long l)
    {
        long _tmp = (long)((double)l / 1000D);
        long l1 = (long)((double)(MF_CLASS253_a801.v - l) / 1000D);
        long l2 = (long)((double)MF_CLASS253_a801.v / 1000D);
        if(l1 > 1L)
            MF_CLASS253_a801.showToastMessage((new StringBuilder()).append("Recorded ").append(l1).append("s / ").append(l2).append("s of max duration.").toString(), 1);
    }

    final MapScreen MF_CLASS253_a801;
}
