// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.view.View;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS341
    implements android.view.View.OnClickListener
{

    CLASS341(Sipa sipa)
    {
    	mSipa = sipa;

    }

    public void onClick(View view)
    {
        try
        {
            Sipa.MF_CLASS179_a653(mSipa, true);
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, mSipa.getApplicationContext());
        }
    }

    final Sipa mSipa;
}
