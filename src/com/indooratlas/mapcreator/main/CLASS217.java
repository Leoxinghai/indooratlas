// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.os.Build;
import android.widget.Toast;
import com.indooratlas.mapcreator.controller.CLASS113;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS216, LoginActivity

class CLASS217
    implements Runnable
{

    CLASS217(CLASS216 class216)
    {
        MF_CLASS216_a762 = class216;
    }

    public void run()
    {
        if(CLASS113.isExceptionLogged.booleanValue())
            Toast.makeText(MF_CLASS216_a762.MF_CLASS113_a486.f, (new StringBuilder()).append("Your device is supported by IndoorAtlas. Device is = ").append(Build.MODEL).toString(), 1).show();
    }

    final CLASS216 MF_CLASS216_a762;
}
