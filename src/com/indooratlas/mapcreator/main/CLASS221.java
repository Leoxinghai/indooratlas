// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.position.CLASS75;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS221
    implements Runnable
{

    CLASS221(LoginActivity loginactivity)
    {
        MF_CLASS221_a767 = loginactivity;
    }

    public void run()
    {
        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "handleLoginError called.");
        LoginActivity.j(MF_CLASS221_a767);
        if(MF_CLASS221_a767.j)
        {
            MF_CLASS221_a767.MF_CLASS19_d70.setText(MF_CLASS221_a767.getString(0x7f080067));
            CLASS75.MF_CLASS75_a259(5, "LOGIN_FAILED", MF_CLASS221_a767.f.getClass(), "PerformNetworkLoginTask. login failed. Network error.");
            return;
        }
        if(MF_CLASS221_a767.m == null || !MF_CLASS221_a767.m.isEmpty())
        {
            MF_CLASS221_a767.MF_CLASS19_d70.setText(MF_CLASS221_a767.getString(0x7f080068));
            CLASS75.MF_CLASS75_a259(5, "LOGIN_FAILED", MF_CLASS221_a767.f.getClass(), "PerformNetworkLoginTask. login failed. Apikey null or empty.");
            return;
        } else
        {
            MF_CLASS221_a767.MF_CLASS19_d70.setText(MF_CLASS221_a767.getString(0x7f080066));
            CLASS75.MF_CLASS75_a259(5, "LOGIN_FAILED", MF_CLASS221_a767.f.getClass(), "PerformNetworkLoginTask. login failed. Other problem.");
            return;
        }
    }

    final LoginActivity MF_CLASS221_a767;
}
