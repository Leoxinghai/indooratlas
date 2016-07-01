// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS277
    implements android.content.DialogInterface.OnClickListener
{

    CLASS277(MapScreen mapscreen)
    {
        MF_CLASS277_a833 = mapscreen;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        MF_CLASS277_a833.startActivity(new Intent("android.net.wifi.PICK_WIFI_NETWORK"));
    }

    final MapScreen MF_CLASS277_a833;
}
