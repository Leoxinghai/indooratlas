// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS346, CLASS196

class CLASS348
    implements android.view.View.OnClickListener
{

    CLASS348(CLASS346 class346)
    {
        MF_CLASS348_a946 = class346;

    }

    public void onClick(View view)
    {
        MF_CLASS348_a946.killTimer();
        CLASS346.MF_CLASS346_a943(MF_CLASS348_a946).MF_CLASS196_c731();
    }

    final CLASS346 MF_CLASS348_a946;
}
