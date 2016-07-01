// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

import android.widget.Toast;
import com.indooratlas.sensor.type.CLASS369;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity

class CLASS213
    implements Runnable
{

    CLASS213(LoginActivity loginactivity, CLASS369 c)
    {
        MF_CLASS213_b757 = loginactivity;
        MF_CLASS213_a758 = c;
    }

    public void run()
    {
        Toast.makeText(MF_CLASS213_b757.f, "Sensor error.", 1).show();
        MF_CLASS213_b757.MF_CLASS19_a67(MF_CLASS213_a758);
    }

    final CLASS369 MF_CLASS213_a758;
    final LoginActivity MF_CLASS213_b757;
}
