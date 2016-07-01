// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS151, RestClient

class CLASS153
    implements Runnable
{

    CLASS153(CLASS151 class151)
    {
        MF_CLASS151_a553 = class151;
    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS151_a553.MF_CLASS113_a486).showToastMessage(RestClient.getMapScreen(MF_CLASS151_a553.MF_CLASS113_a486).getString(0x7f080047), 1);
    }

    final CLASS151 MF_CLASS151_a553;
}
