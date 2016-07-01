// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS322
    implements android.view.View.OnClickListener
{

    CLASS322(Sipa sipa)
    {
        MF_CLASS322_a913 = sipa;

    }

    public void onClick(View view)
    {
        try
        {
            Sipa.MF_CLASS113_b487(MF_CLASS322_a913, true);
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS322_a913.getApplicationContext());
        }
    }

    final Sipa MF_CLASS322_a913;
}
