// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS310, MapScreen

class CLASS311 extends CountDownTimer
{

    CLASS311(CLASS310 class310, long l, long l1)
    {
        super(l, l1);
        MF_CLASS310_a884 = class310;
    }

    public void onFinish()
    {
        MF_CLASS310_a884.MF_CLASS113_a486.hideInProgressDialog();
    }

    public void onTick(long l)
    {
    }

    final CLASS310 MF_CLASS310_a884;
}
