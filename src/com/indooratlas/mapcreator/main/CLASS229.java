// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS229
    implements android.content.DialogInterface.OnClickListener
{

    CLASS229(MapScreen mapscreen)
    {
        MF_CLASS229_a775 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            MF_CLASS229_a775.mUploadingGenerationInProgress = true;
            MapScreen.MF_CLASS19_a67(MF_CLASS229_a775, MF_CLASS229_a775.mCurrentBuilding.getBuildingID(), MF_CLASS229_a775.mCurrentLevel.getLevelID(), MF_CLASS229_a775.mGraphics.getGraphicsID());
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS229_a775.getApplicationContext());
        }
    }

    final MapScreen MF_CLASS229_a775;
}
