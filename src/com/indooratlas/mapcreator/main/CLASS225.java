// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS225
    implements android.view.View.OnClickListener
{

    CLASS225(MapScreen mapscreen)
    {
        MF_CLASS225_a771 = mapscreen;
    }

    public void onClick(View view)
    {
        if(MF_CLASS225_a771.mMe.mTurnMapAutomatically)
        {
            MF_CLASS225_a771.mMe.mTurnMapAutomatically = false;
            Toast.makeText(MF_CLASS225_a771.mMe, "Rotate off", 0).show();
            MF_CLASS225_a771.mNaviButton.setBackgroundResource(0x7f020027);
            return;
        } else
        {
            MF_CLASS225_a771.mMe.mTurnMapAutomatically = true;
            Toast.makeText(MF_CLASS225_a771.mMe, "Rotate on", 0).show();
            MF_CLASS225_a771.mNaviButton.setBackgroundResource(0x7f020028);
            return;
        }
    }

    final MapScreen MF_CLASS225_a771;
}
