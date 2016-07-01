// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.RestClient;
import com.indooratlas.mapcreator.data.Level;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS329
    implements android.content.DialogInterface.OnClickListener
{

    CLASS329(Sipa sipa, List list)
    {
        MF_CLASS329_b921 = sipa;
        MF_CLASS329_a922 = list;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() onClick ");
            MF_CLASS329_b921.mSelectedLevel = (Level)MF_CLASS329_a922.get(i);
            CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() calling getFloorplans ");
            Sipa.MF_CLASS113_b487(MF_CLASS329_b921).Floorplans(MF_CLASS329_b921.mSelectedLevel.getLevelID());
            dialoginterface.cancel();
            CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() calling showWaitDialog ");
            MF_CLASS329_b921.showWaitDialog("Loading...");
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS329_b921.getApplicationContext());
        }
    }

    final List MF_CLASS329_a922;
    final Sipa MF_CLASS329_b921;
}
