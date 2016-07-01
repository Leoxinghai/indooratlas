// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS339
    implements android.content.DialogInterface.OnClickListener
{

    CLASS339(Sipa sipa)
    {
        MF_CLASS339_a935 = sipa;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    final Sipa MF_CLASS339_a935;
}
