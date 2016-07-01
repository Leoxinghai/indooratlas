// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.CLASS103;
import com.indooratlas.mapcreator.main.Sipa;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS185
    implements Runnable
{

    CLASS185(RestClient class181, com.indooratlas.communication.cmn.Graphic graphic)
    {
        MF_CLASS185_b716 = class181;
        mGraphic = graphic;
    }

    public void run()
    {
        RestClient.getSipa(MF_CLASS185_b716).showIndoorMapView(new CLASS103(mGraphic));
    }

    final com.indooratlas.communication.cmn.Graphic mGraphic;
    final RestClient MF_CLASS185_b716;
}
