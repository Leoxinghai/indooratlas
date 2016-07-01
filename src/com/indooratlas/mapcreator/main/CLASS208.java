// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.widget.Toast;
import com.indooratlas.Calibrator.CalibrationEvent;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS208
    implements Runnable
{

    CLASS208(LoginActivity loginactivity, String s, String s1, String s2, CalibrationEvent class18)
    {
        MF_CLASS208_e748 = loginactivity;
        MF_CLASS208_a749 = s;
        MF_CLASS208_b750 = s1;
        MF_CLASS208_c751 = s2;
        MF_CLASS208_d752 = class18;
    }

    public void run()
    {
        Toast.makeText(MF_CLASS208_e748.f, (new StringBuilder()).append("Calibration successful. \nBiases : \nx : ").append(MF_CLASS208_a749).append("\ny : ").append(MF_CLASS208_b750).append("\nz : ").append(MF_CLASS208_c751).append("\nt = ").append(MF_CLASS208_d752.MF_CLASS18_d64()).toString(), 1).show();
    }

    final String MF_CLASS208_a749;
    final String MF_CLASS208_b750;
    final String MF_CLASS208_c751;
    final CalibrationEvent MF_CLASS208_d752;
    final LoginActivity MF_CLASS208_e748;
}
