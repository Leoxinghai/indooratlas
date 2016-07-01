// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS302

class CLASS303
    implements android.content.DialogInterface.OnClickListener
{

    CLASS303(CLASS302 class302)
    {
        MF_CLASS303_a875 = class302;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    final CLASS302 MF_CLASS303_a875;
}
