// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS218
    implements Runnable
{

    CLASS218(LoginActivity loginactivity)
    {
        MF_CLASS218_a764 = loginactivity;
    }

    public void run()
    {
        MF_CLASS218_a764.j = true;
        MF_CLASS218_a764.f.f();
    }

    final LoginActivity MF_CLASS218_a764;
}
