// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.CLASS103;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS331
    implements android.content.DialogInterface.OnClickListener
{

    CLASS331(Sipa sipa, List list)
    {
        MF_CLASS331_b924 = sipa;
        MF_CLASS331_a925 = list;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            MF_CLASS331_b924.mSelectedGraphics = (CLASS103)MF_CLASS331_a925.get(i);
            MF_CLASS331_b924.getFloorPlanImage();
            dialoginterface.cancel();
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS331_b924.getApplicationContext());
        }
    }

    final List MF_CLASS331_a925;
    final Sipa MF_CLASS331_b924;
}
