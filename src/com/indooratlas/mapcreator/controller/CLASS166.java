// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.controller;

import android.content.DialogInterface;
import android.os.Process;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS164

class CLASS166
    implements android.content.DialogInterface.OnClickListener
{

    CLASS166(CLASS164 class164)
    {
        MF_CLASS166_a633 = class164;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    final CLASS164 MF_CLASS166_a633;
}
