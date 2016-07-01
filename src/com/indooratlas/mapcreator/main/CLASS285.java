// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.widget.ImageView;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS285
    implements Runnable
{

    CLASS285(MapScreen mapscreen)
    {
        MF_CLASS285_a841 = mapscreen;

    }

    public void run()
    {
        ImageView imageview = (ImageView)MF_CLASS285_a841.findViewById(R.id.bgCalibProgressRedImage);
        if(MapScreen.K(MF_CLASS285_a841))
        {
            imageview.setVisibility(4);
            return;
        } else
        {
            imageview.setVisibility(0);
            return;
        }
    }

    final MapScreen MF_CLASS285_a841;
}
