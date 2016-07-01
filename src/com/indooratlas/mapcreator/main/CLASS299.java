// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS299
    implements Runnable
{

    CLASS299(MapScreen mapscreen, boolean flag)
    {
        MF_CLASS299_b867 = mapscreen;
        MF_CLASS299_a868 = flag;
    }

    public void run()
    {
        if(MapScreen.ai(MF_CLASS299_b867))
        {
            MF_CLASS299_b867.hideInProgressDialog();
            if(MF_CLASS299_a868)
                MF_CLASS299_b867.showToastMessage("Network switch done.", 0);
            MF_CLASS299_b867.showToastMessage("Mobile network not available or mobile data is disabled. Using WiFi.", 1);
        }
        return;
    }

    final boolean MF_CLASS299_a868;
    final MapScreen MF_CLASS299_b867;
}
