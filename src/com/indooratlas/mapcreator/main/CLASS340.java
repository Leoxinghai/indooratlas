// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.MeasurementDataSource;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS340
    implements android.content.DialogInterface.OnClickListener
{

    CLASS340(Sipa sipa)
    {
    	mSipa = sipa;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MeasurementDataSource.reCreateTables();
        dialoginterface.cancel();
    }

    final Sipa mSipa;
}
