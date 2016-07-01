// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.sensor.CLASS370;
import java.io.FileInputStream;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS113, CLASS143, RestClient

class CLASS148
    implements Runnable
{

    CLASS148(CLASS143 class143, FileInputStream fileinputstream)
    {
        MF_CLASS148_b548 = class143;
        MF_CLASS143_a541 = fileinputstream;
    }

    public void run()
    {
        if(!CLASS113.isExceptionLogged.booleanValue());
        MF_CLASS148_b548.mRestClient.postCalibrationSetFromStream((CLASS370)RestClient.MF_CLASS381_f1112(MF_CLASS148_b548.mRestClient).get(-1 + RestClient.MF_CLASS381_f1112(MF_CLASS148_b548.mRestClient).size()), MF_CLASS143_a541);
    }

    final FileInputStream MF_CLASS143_a541;
    final CLASS143 MF_CLASS148_b548;
}
