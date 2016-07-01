// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS350, CLASS197

class CLASS351
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS351(WalkViewDialogFragment class350)
    {
        MF_CLASS350_a948 = class350;

    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("WalkViewDialogFragment", "onKey(): closing dialog.");
        if(i == 4 && keyevent.getAction() == 1)
        {
            CLASS167.MF_CLASS167_b635("WalkViewDialogFragment", "onKey(): back clicked --> listener.onWalkViewCancelled()");
            MF_CLASS350_a948.MF_CLASS350_a948.onWalkViewCancelled();
            return true;
        } else
        {
            return false;
        }
    }

    final WalkViewDialogFragment MF_CLASS350_a948;
}
