// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS346, CLASS196

class CLASS349 extends CountDownTimer
{

    CLASS349(CLASS346 class346, long l, long l1)
    {
        super(l, l1);
        MF_CLASS349_a947 = class346;
    }

    public void onFinish()
    {
        CLASS167.MF_CLASS167_b635("SplashScreenDialogFragment", "startInstallSplashTimer: run.");
        MF_CLASS349_a947.killTimer();
        CLASS346.MF_CLASS346_a943(MF_CLASS349_a947).MF_CLASS196_c731();
    }

    public void onTick(long l)
    {
    }

    final CLASS346 MF_CLASS349_a947;
}
