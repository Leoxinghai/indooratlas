// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS211
    implements android.content.DialogInterface.OnClickListener
{

    CLASS211(LoginActivity loginactivity)
    {
        MF_CLASS211_a755 = loginactivity;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS211_a755.i();
        LoginActivity.l(MF_CLASS211_a755);
        dialoginterface.cancel();
    }

    final LoginActivity MF_CLASS211_a755;
}
