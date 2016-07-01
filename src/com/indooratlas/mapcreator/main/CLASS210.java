// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS210
    implements Runnable
{

    CLASS210(LoginActivity loginactivity)
    {
        MF_CLASS210_a754 = loginactivity;
    }

    public void run()
    {
        MF_CLASS210_a754.MF_CLASS19_b68(MF_CLASS210_a754.getString(0x7f080011));
        try
        {
            Thread.sleep(1000L);
            return;
        }
        catch(InterruptedException interruptedexception)
        {
            return;
        }
    }

    final LoginActivity MF_CLASS210_a754;
}
