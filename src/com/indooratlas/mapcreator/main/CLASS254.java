// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS200

class CLASS254
    implements android.view.View.OnClickListener
{

    CLASS254(CLASS200 class200)
    {
        MF_CLASS254_a802 = class200;

    }

    public void onClick(View view)
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "showCalibView:, text clicked");
        CLASS200.sStartListeningCalibration(MF_CLASS254_a802);
    }

    final CLASS200 MF_CLASS254_a802;
}
