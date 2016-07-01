// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity, CLASS354

class CLASS207
    implements Runnable
{

    CLASS207(LoginActivity loginactivity)
    {
        MF_CLASS207_a747 = loginactivity;
    }

    public void run()
    {
        if(LoginActivity.n(MF_CLASS207_a747) != null)
            LoginActivity.n(MF_CLASS207_a747).setProgress(MF_CLASS207_a747.f.getString(0x7f08000c));
    }

    final LoginActivity MF_CLASS207_a747;
}
