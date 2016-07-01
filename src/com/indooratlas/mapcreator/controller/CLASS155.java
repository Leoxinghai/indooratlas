// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.*;
import com.indooratlas.mapcreator.main.MapScreen;
import java.io.FileInputStream;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS154, RestClient

class CLASS155
    implements Runnable
{

    CLASS155(CLASS154 class154, FileInputStream fileinputstream)
    {
        MF_CLASS155_b558 = class154;
        MF_CLASS154_a557 = fileinputstream;
    }

    public void run()
    {
        MF_CLASS155_b558.MF_CLASS113_a486.postMeasurementSequenceFromStream(RestClient.getMapScreen(MF_CLASS155_b558.MF_CLASS113_a486).mCurrentBuilding.getBuildingID(), RestClient.getMapScreen(MF_CLASS155_b558.MF_CLASS113_a486).mCurrentLevel.getLevelID(), (Measurement)RestClient.MF_CLASS32_d136(MF_CLASS155_b558.MF_CLASS113_a486).get(-1 + RestClient.MF_CLASS32_d136(MF_CLASS155_b558.MF_CLASS113_a486).size()), MF_CLASS154_a557);
    }

    final FileInputStream MF_CLASS154_a557;
    final CLASS154 MF_CLASS155_b558;
}
