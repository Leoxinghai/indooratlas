// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity, CLASS200

class CLASS222
    implements Runnable
{

    CLASS222(LoginActivity loginactivity)
    {
        MF_CLASS222_a768 = loginactivity;
    }

    public void run()
    {
        LoginActivity.k(MF_CLASS222_a768).MF_CLASS200_a732();
        MF_CLASS222_a768.MF_CLASS19_a67(MF_CLASS222_a768.getString(0x7f080009));
    }

    final LoginActivity MF_CLASS222_a768;
}
