// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS350, CLASS197

class CLASS352 extends CountDownTimer
{

    CLASS352(WalkViewDialogFragment class350, long l, long l1)
    {
        super(l, l1);
        MF_CLASS350_a948 = class350;
    }

    public void onFinish()
    {
        CLASS167.MF_CLASS167_b635("WalkViewDialogFragment", "startInitTimeoutCheck: onFinish --> calling listener.onInitializationTimeout()");
        MF_CLASS350_a948.MF_CLASS350_a948.onInitializationTimeout();
    }

    public void onTick(long l)
    {
        CLASS167.MF_CLASS167_b635("WalkViewDialogFragment", (new StringBuilder()).append("startInitTimeoutCheck() onTick millisUntilFinished : ").append(l).toString());
      
    }

    final WalkViewDialogFragment MF_CLASS350_a948;
}
