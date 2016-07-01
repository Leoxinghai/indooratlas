// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS321
    implements android.content.DialogInterface.OnClickListener
{

    CLASS321(Sipa sipa)
    {
        MF_CLASS321_a912 = sipa;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS321_a912.k.finish();
        dialoginterface.cancel();
    }

    final Sipa MF_CLASS321_a912;
}
