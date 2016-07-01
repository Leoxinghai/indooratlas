// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.widget.Toast;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS296
    implements Runnable
{

    CLASS296(MapScreen mapscreen, String s, int i)
    {
        MF_CLASS296_c862 = mapscreen;
        MF_CLASS296_a863 = s;
        MF_CLASS296_b864 = i;

    }

    public void run()
    {
        Toast.makeText(MF_CLASS296_c862.mMe, MF_CLASS296_a863, MF_CLASS296_b864).show();
    }

    final String MF_CLASS296_a863;
    final int MF_CLASS296_b864;
    final MapScreen MF_CLASS296_c862;
}
