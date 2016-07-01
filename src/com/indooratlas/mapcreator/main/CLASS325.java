// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS325
    implements android.content.DialogInterface.OnClickListener
{

    CLASS325(Sipa sipa)
    {
        MF_CLASS325_a916 = sipa;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            MF_CLASS325_a916.setBuildingSelectionOngoing(false);
            dialoginterface.cancel();
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS325_a916.getApplicationContext());
        }
    }

    final Sipa MF_CLASS325_a916;
}
