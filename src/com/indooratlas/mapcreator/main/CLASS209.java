// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity, CLASS354

class CLASS209
    implements Runnable
{

    CLASS209(LoginActivity loginactivity)
    {
        MF_CLASS209_a753 = loginactivity;
    }

    public void run()
    {
        if(LoginActivity.n(MF_CLASS209_a753) != null)
            LoginActivity.n(MF_CLASS209_a753).setProgress("100 %");
        MF_CLASS209_a753.MF_CLASS19_b68(MF_CLASS209_a753.getString(0x7f080009));
    }

    final LoginActivity MF_CLASS209_a753;
}
