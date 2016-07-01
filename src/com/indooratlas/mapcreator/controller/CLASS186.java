// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.Level;
import com.indooratlas.mapcreator.main.Sipa;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS186
    implements Runnable
{

    CLASS186(RestClient class181, com.indooratlas.communication.be.IndoorAtlas indooratlas)
    {
        MF_CLASS186_b718 = class181;
        MF_CLASS186_a719 = indooratlas;
    }

    public void run()
    {
        List list = MF_CLASS186_a719.getLevelList();
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(new Level((com.indooratlas.communication.cmn.Level)iterator.next())));
        RestClient.getSipa(MF_CLASS186_b718).mCurrentLevelList = arraylist;
        RestClient.getSipa(MF_CLASS186_b718).showLevelSelectionDialog();
    }

    final com.indooratlas.communication.be.IndoorAtlas MF_CLASS186_a719;
    final RestClient MF_CLASS186_b718;
}
