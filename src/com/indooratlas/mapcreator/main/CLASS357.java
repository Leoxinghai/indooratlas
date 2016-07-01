// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CalibrationDialogFragment, CLASS195

class CLASS357
    implements android.view.View.OnClickListener
{

    CLASS357(CalibrationDialogFragment class354)
    {
        MF_CLASS357_a962 = class354;

    }

    public void onClick(View view)
    {
        CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", "showCalibView:, text clicked");
        CalibrationDialogFragment.MF_CLASS354_a956(MF_CLASS357_a962).onStartCalibration();
    }

    final CalibrationDialogFragment MF_CLASS357_a962;
}
