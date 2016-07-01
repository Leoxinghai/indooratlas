// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS308, CLASS200, CLASS194

class CLASS334
    implements android.view.View.OnClickListener
{

    CLASS334(CLASS308 class308)
    {
        MF_CLASS200_a732 = class308;

    }

    public void onClick(View view)
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "instruction text clicked");
        MF_CLASS200_a732.MF_CLASS308_a881.MF_CLASS200_a732.MF_CLASS194_b730();
    }

    final CLASS308 MF_CLASS200_a732;
}
