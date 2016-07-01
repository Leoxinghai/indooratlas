// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.*;
import com.indooratlas.mapcreator.main.MapScreen;
import java.io.FileInputStream;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS113, CLASS143, RestClient

class CLASS149
    implements Runnable
{

    CLASS149(CLASS143 class143, FileInputStream fileinputstream)
    {
        MF_CLASS149_b550 = class143;
        MF_CLASS143_a541 = fileinputstream;
    }

    public void run()
    {
        if(!CLASS113.isExceptionLogged.booleanValue());
        MF_CLASS149_b550.mRestClient.postMeasurementSequenceFromStream(RestClient.getMapScreen(MF_CLASS149_b550.mRestClient).mCurrentBuilding.getBuildingID(), RestClient.getMapScreen(MF_CLASS149_b550.mRestClient).mCurrentLevel.getLevelID(), (Measurement)RestClient.MF_CLASS32_d136(MF_CLASS149_b550.mRestClient).get(-1 + RestClient.MF_CLASS32_d136(MF_CLASS149_b550.mRestClient).size()), MF_CLASS143_a541);
    }

    final FileInputStream MF_CLASS143_a541;
    final CLASS143 MF_CLASS149_b550;
}
