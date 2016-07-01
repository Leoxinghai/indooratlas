// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.widget.Toast;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS220
    implements Runnable
{

    CLASS220(LoginActivity loginactivity)
    {
        MF_CLASS220_a766 = loginactivity;
    }

    public void run()
    {
        Toast.makeText(MF_CLASS220_a766.f, "Required sensors missing. Closing IndoorAtlas Mobile", 1).show();
    }

    final LoginActivity MF_CLASS220_a766;
}
