// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.CLASS103;
import com.indooratlas.mapcreator.main.Sipa;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS184
    implements Runnable
{

    CLASS184(RestClient class181, com.indooratlas.communication.be.IndoorAtlas indooratlas)
    {
        MF_CLASS184_b714 = class181;
        MF_CLASS184_a715 = indooratlas;
    }

    public void run()
    {
        List list = MF_CLASS184_a715.getGraphicList();
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(new CLASS103((com.indooratlas.communication.cmn.Graphic)iterator.next())));
        RestClient.getSipa(MF_CLASS184_b714).showFloorplanImageSelectionDialog(arraylist);
    }

    final com.indooratlas.communication.be.IndoorAtlas MF_CLASS184_a715;
    final RestClient MF_CLASS184_b714;
}
