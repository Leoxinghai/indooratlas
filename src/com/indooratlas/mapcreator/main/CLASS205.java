// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity, CLASS354

class CLASS205
    implements Runnable
{

    CLASS205(LoginActivity loginactivity)
    {
        MF_CLASS205_a745 = loginactivity;
    }

    public void run()
    {
        if(LoginActivity.n(MF_CLASS205_a745) != null)
            LoginActivity.n(MF_CLASS205_a745).setProgress(MF_CLASS205_a745.f.getString(0x7f08000b));
    }

    final LoginActivity MF_CLASS205_a745;
}
