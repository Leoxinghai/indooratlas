// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.AlertDialog;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS303

class CLASS302
    implements Runnable
{

    CLASS302(MapScreen mapscreen, String s)
    {
        MF_CLASS302_b873 = mapscreen;
        MF_CLASS302_a874 = s;

    }

    public void run()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MF_CLASS302_b873.mMe);
        builder.setMessage(MF_CLASS302_a874).setCancelable(false).setPositiveButton("Ok", new CLASS303(this));
        builder.create().show();
    }

    final String MF_CLASS302_a874;
    final MapScreen MF_CLASS302_b873;
}
