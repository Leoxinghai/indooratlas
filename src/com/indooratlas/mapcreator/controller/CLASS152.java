// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.sensor.CLASS370;
import java.io.FileInputStream;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS151, RestClient

class CLASS152
    implements Runnable
{

    CLASS152(CLASS151 class151, FileInputStream fileinputstream)
    {
        MF_CLASS152_b554 = class151;
        MF_CLASS151_a553 = fileinputstream;
    }

    public void run()
    {
        MF_CLASS152_b554.MF_CLASS113_a486.postCalibrationSetFromStream((CLASS370)RestClient.MF_CLASS381_f1112(MF_CLASS152_b554.MF_CLASS113_a486).get(-1 + RestClient.MF_CLASS381_f1112(MF_CLASS152_b554.MF_CLASS113_a486).size()), MF_CLASS151_a553);
    }

    final FileInputStream MF_CLASS151_a553;
    final CLASS151 MF_CLASS152_b554;
}
