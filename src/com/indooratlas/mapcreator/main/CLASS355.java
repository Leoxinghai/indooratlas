// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CalibrationDialogFragment, CLASS195

class CLASS355
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS355(CalibrationDialogFragment class354)
    {
        MF_CLASS355_a960 = class354;

    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", "onKey(): closing dialog.");
        if(i == 4 && keyevent.getAction() == 1)
        {
            CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", "onKey(): back clicked --> calling listener.onCancelCalibration()");
            CalibrationDialogFragment.MF_CLASS354_a956(MF_CLASS355_a960).onCancelCalibration();
            return true;
        } else
        {
            return false;
        }
    }

    final CalibrationDialogFragment MF_CLASS355_a960;
}
