// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS333
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS333(Sipa sipa)
    {
        MF_CLASS333_a927 = sipa;

    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if(i == 84 && keyevent.getRepeatCount() == 0)
        {
            CLASS167.MF_CLASS167_b635("Sipa", "onKey(): preventing touches.");
            return true;
        } else
        {
            return false;
        }
    }

    final Sipa MF_CLASS333_a927;
}
