// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity, CLASS354

class CLASS204
    implements Runnable
{

    CLASS204(LoginActivity loginactivity, String s)
    {
    	mLoginActivity = loginactivity;
        MF_CLASS204_a744 = s;
    }

    public void run()
    {
        if(LoginActivity.n(mLoginActivity) != null)
            LoginActivity.n(mLoginActivity).setProgress(MF_CLASS204_a744);
    }

    final String MF_CLASS204_a744;
    final LoginActivity mLoginActivity;
}
