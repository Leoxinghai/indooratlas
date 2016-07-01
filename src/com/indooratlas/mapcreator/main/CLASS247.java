// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.base.IndoorAtlasFactory;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS247
    implements Runnable
{

    CLASS247(MapScreen mapscreen)
    {
        MF_CLASS113_a486 = mapscreen;
    }

    public void run()
    {
        try
        {
            MapScreen.MF_CLASS19_a67(MF_CLASS113_a486, false);
            MapScreen.MF_CLASS19_a67(MF_CLASS113_a486, IndoorAtlasFactory.createIndoorAtlas(MF_CLASS113_a486.mMe.getApplicationContext(), MF_CLASS113_a486.mMe, MF_CLASS113_a486.mApiKey, MF_CLASS113_a486.mSecret));
            CLASS75.MF_CLASS75_a259(4, "API_CREATION_OK", MapScreen.class, "notifyCalibrationDone");
            return;
        }
        catch(Exception exception)
        {
            if(CLASS113.isExceptionLogged.booleanValue())
                exception.printStackTrace();
        }
        CLASS75.MF_CLASS75_a259(5, "API_CREATION_FAILED", MapScreen.class, "notifyCalibrationDone");
        MF_CLASS113_a486.showInformationDialogWhichClosesActivity("Error connecting to IndoorAtlas Maps. Closing floor plan.");
    }

    final MapScreen MF_CLASS113_a486;
}
