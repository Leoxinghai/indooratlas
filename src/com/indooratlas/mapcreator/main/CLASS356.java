// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CalibrationDialogFragment, CLASS195

class CLASS356
    implements android.view.View.OnClickListener
{

    CLASS356(CalibrationDialogFragment class354)
    {
        MF_CLASS356_a961 = class354;

    }

    public void onClick(View view)
    {
        CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", "onClick() called --> starting calibration");
        CalibrationDialogFragment.MF_CLASS354_b957(MF_CLASS356_a961).setText("");
        CalibrationDialogFragment.MF_CLASS354_b957(MF_CLASS356_a961).setClickable(false);
        if(CalibrationDialogFragment.MF_CLASS354_c958(MF_CLASS356_a961) != null)
            CalibrationDialogFragment.MF_CLASS354_c958(MF_CLASS356_a961).setOnClickListener(null);
        CalibrationDialogFragment.MF_CLASS354_a956(MF_CLASS356_a961).onStartCalibration();
    }

    final CalibrationDialogFragment MF_CLASS356_a961;
}
