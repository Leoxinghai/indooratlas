// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS239
    implements android.content.DialogInterface.OnClickListener
{

    CLASS239(MapScreen mapscreen)
    {
        MF_CLASS239_a786 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MF_CLASS239_a786.showHipriModeDialog();
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS239_a786;
}
