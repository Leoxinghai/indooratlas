// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS346, CLASS196

class CLASS347
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS347(CLASS346 class346)
    {
        MF_CLASS347_a945 = class346;

    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if(i == 4 && keyevent.getAction() == 1)
        {
            CLASS167.MF_CLASS167_b635("SplashScreenDialogFragment", "onKey(): back button --> closing dialog.");
            CLASS346.MF_CLASS346_a943(MF_CLASS347_a945).MF_CLASS196_c731();
            return true;
        } else
        {
            return false;
        }
    }

    final CLASS346 MF_CLASS347_a945;
}
