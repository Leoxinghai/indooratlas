// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS236
    implements android.content.DialogInterface.OnKeyListener
{

    CLASS236(MapScreen mapscreen)
    {
        MF_CLASS236_a782 = mapscreen;
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showSelectConnectionTypeDialog(): closing dialog.");
        if(i == 4 && keyevent.getAction() == 1)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "showSelectConnectionTypeDialog(): closing dialog wihtout actions.");
            dialoginterface.dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    final MapScreen MF_CLASS236_a782;
}
