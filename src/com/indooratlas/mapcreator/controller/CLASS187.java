// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.Building;
import com.indooratlas.mapcreator.main.Sipa;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS187
    implements Runnable
{

    CLASS187(RestClient class181, com.indooratlas.communication.be.IndoorAtlas indooratlas)
    {
        MF_CLASS187_b720 = class181;
        MF_CLASS187_a721 = indooratlas;
    }

    public void run()
    {
        List list = MF_CLASS187_a721.getBuildingList();
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = list.iterator(); iterator.hasNext(); ){
        	arraylist.add(new Building((com.indooratlas.communication.cmn.Building)iterator.next()));        	
        }
        RestClient.getSipa(MF_CLASS187_b720).updateBuildingList(arraylist);
    }

    final com.indooratlas.communication.be.IndoorAtlas MF_CLASS187_a721;
    final RestClient MF_CLASS187_b720;
}
