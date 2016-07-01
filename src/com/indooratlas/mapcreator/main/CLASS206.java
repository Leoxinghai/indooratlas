// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS206
    implements Runnable
{

    CLASS206(LoginActivity loginactivity)
    {
        MF_CLASS206_a746 = loginactivity;
    }

    public void run()
    {
        LoginActivity.o(MF_CLASS206_a746);
        MF_CLASS206_a746.MF_CLASS19_b68(MF_CLASS206_a746.getString(0x7f080011));
    }

    final LoginActivity MF_CLASS206_a746;
}
