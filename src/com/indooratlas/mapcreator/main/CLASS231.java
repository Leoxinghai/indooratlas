// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS231
    implements android.content.DialogInterface.OnClickListener
{

    CLASS231(MapScreen mapscreen)
    {
        MF_CLASS231_a777 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            MF_CLASS231_a777.mMe.deleteAllMeasurementsOfCurrentFloorplan();
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS231_a777.getApplicationContext());
        }
    }

    final MapScreen MF_CLASS231_a777;
}
