// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS202
    implements android.content.DialogInterface.OnClickListener
{

    CLASS202(LoginActivity loginactivity)
    {
        MF_CLASS202_a740 = loginactivity;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS202_a740.k();
        LoginActivity.l(MF_CLASS202_a740);
        dialoginterface.cancel();
    }

    final LoginActivity MF_CLASS202_a740;
}
