// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS201
    implements Runnable
{

    CLASS201(LoginActivity loginactivity)
    {
        MF_CLASS201_a739 = loginactivity;
    }

    public void run()
    {
        CLASS75.MF_CLASS75_a259(4, "APP_STARTED", MF_CLASS201_a739.f.getClass(), "LoginActivity onCreate");
    }

    final LoginActivity MF_CLASS201_a739;
}
