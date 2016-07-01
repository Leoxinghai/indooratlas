// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.Toast;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS200

class CLASS227
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS227(CLASS200 class200)
    {
        MF_CLASS227_a773 = class200;
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "onKey(): closing dialog.");
        if(i == 4 && keyevent.getAction() == 1)
        {
            CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "onKey(): doing nothing.");
            Toast.makeText(MF_CLASS227_a773.MF_CLASS200_b733.getActivity(), "Cancelling not allowed.", 0).show();
            return true;
        } else
        {
            return false;
        }
    }

    final CLASS200 MF_CLASS227_a773;
}
