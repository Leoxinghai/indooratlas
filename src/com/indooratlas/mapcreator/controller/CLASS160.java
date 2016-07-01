// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            SensorController

class CLASS160
    implements Runnable
{

    CLASS160(SensorController class159)
    {
        MF_CLASS160_a620 = class159;
    }

    public void run()
    {
        try
        {
            MF_CLASS160_a620.mMapScreen.onRecordButtonClick();
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    final SensorController MF_CLASS160_a620;
}
