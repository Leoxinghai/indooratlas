// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS200, CLASS334

class CLASS308 extends CountDownTimer
{

    CLASS308(CLASS200 class200, long l, long l1)
    {
        super(l, l1);
        MF_CLASS308_a881 = class200;
    }

    public void onFinish()
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "startInitialCalibReadyTimer() 15s elapsed --> suggest forced calibration");
        CLASS200.MF_CLASS200_a732(MF_CLASS308_a881, MF_CLASS308_a881.getString(0x7f08000e));
        CLASS200.MF_CLASS200_b733(MF_CLASS308_a881).setClickable(true);
        CLASS200.MF_CLASS200_b733(MF_CLASS308_a881).setTextColor(0xffff0000);
        CLASS200.MF_CLASS200_b733(MF_CLASS308_a881).setVisibility(0);
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "startInitialCalibReadyTimer() changed text to clickable.");
        CLASS200.MF_CLASS200_b733(MF_CLASS308_a881).setOnClickListener(new CLASS334(this));
        MF_CLASS308_a881.MF_CLASS200_a732();
    }

    public void onTick(long l)
    {
    }

    final CLASS200 MF_CLASS308_a881;
}
