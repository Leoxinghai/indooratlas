// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.*;
import android.widget.ImageView;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS349, CLASS347, CLASS348, CLASS196

public class CLASS346 extends DialogFragment
{

    public CLASS346(CLASS196 class196)
    {
        MF_CLASS346_a943 = null;
        MF_CLASS346_a943 = class196;
    }

    public static CLASS346 MF_CLASS346_a943(CLASS196 class196)
    {
        return new CLASS346(class196);
    }

    static CLASS196 MF_CLASS346_a943(CLASS346 class346)
    {
        return class346.MF_CLASS346_a943;
    }

    private void MF_CLASS346_b944()
    {
        CLASS167.MF_CLASS167_b635("SplashScreenDialogFragment", "startInstallSplashTimer: called");
        killTimer();
        MF_CLASS346_b944 = (new CLASS349(this, 1000L, 1000L)).start();
    }

    public void killTimer()
    {
        if(MF_CLASS346_b944 != null)
        {
            MF_CLASS346_b944.cancel();
            MF_CLASS346_b944 = null;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        window.getAttributes();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Dialog dialog = super.onCreateDialog(bundle);
        dialog.getWindow().requestFeature(1);
        CLASS167.MF_CLASS167_b635("SplashScreenDialogFragment", (new StringBuilder()).append("onCreateDialog() called dialog = ").append(dialog).toString());
        dialog.setOnKeyListener(new CLASS347(this));
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        CLASS167.MF_CLASS167_b635("SplashScreenDialogFragment", "onCreateView() called");
        View view = layoutinflater.inflate(R.layout.installsplashview, viewgroup, true);
        ((ImageView)view.findViewById(0x7f0b000a)).setOnClickListener(new CLASS348(this));
        MF_CLASS346_b944();
        return view;
    }

    private CLASS196 MF_CLASS346_a943;
    private CountDownTimer MF_CLASS346_b944;
}
