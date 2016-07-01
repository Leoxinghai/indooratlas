// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import com.indooratlas.sensor.type.CLASS369;;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS214
    implements Runnable
{

    CLASS214(LoginActivity loginactivity, CLASS369 c)
    {
        MF_CLASS214_b759 = loginactivity;
        MF_CLASS214_a760 = c;

    }

    public void run()
    {
        MF_CLASS214_b759.MF_CLASS19_a67(MF_CLASS214_a760);
    }

    final CLASS369 MF_CLASS214_a760;
    final LoginActivity MF_CLASS214_b759;
}
