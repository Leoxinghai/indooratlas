// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS344, Sipa

class CLASS345 extends CountDownTimer
{

    CLASS345(DumpDBTask class344, long l, long l1)
    {
        super(l, l1);
        MF_CLASS344_a940 = class344;
    }

    public void onFinish()
    {
        MF_CLASS344_a940.MF_CLASS179_a653.hideInProgressDialog();
    }

    public void onTick(long l)
    {
    }

    final DumpDBTask MF_CLASS344_a940;
}
