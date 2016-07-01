// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS200

class CLASS281
    implements android.view.View.OnClickListener
{

    CLASS281(CLASS200 class200)
    {
        MF_CLASS281_a837 = class200;

    }

    public void onClick(View view)
    {
        CLASS200.sStartListeningCalibration(MF_CLASS281_a837);
    }

    final CLASS200 MF_CLASS281_a837;
}
