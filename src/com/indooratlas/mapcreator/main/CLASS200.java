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
import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS194, CLASS308, CLASS227, CLASS254,
//            CLASS281

public class CLASS200 extends DialogFragment
{

    public CLASS200(CLASS194 class194)
    {
        MF_CLASS200_a732 = null;
        MF_CLASS200_b733 = null;
        MF_CLASS200_g735 = false;
        MF_CLASS200_a732 = class194;
        MF_CLASS200_b733 = this;
    }

    public static CLASS200 createInstance(CLASS194 class194)
    {
        return new CLASS200(class194);
    }

    static void sStartListeningCalibration(CLASS200 class200)
    {
        class200.startListeningCalibration();
    }

    static void MF_CLASS200_a732(CLASS200 class200, String s)
    {
        class200.MF_CLASS200_b733(s);
    }

    static TextView MF_CLASS200_b733(CLASS200 class200)
    {
        return class200.MF_CLASS200_d736;
    }

    private void startListeningCalibration()
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "startListeningCalibration()");
        MF_CLASS200_g735 = true;
        setProgressValue("0 %");
        tvBGcalibrationProgress.setClickable(false);
        tvBGcalibrationProgress.setOnClickListener(null);
        if(MF_CLASS200_e737 != null)
            MF_CLASS200_e737.setOnClickListener(null);
        startInitialCalibReadyTimer();
        MF_CLASS200_a732.startBackGroundCalibration();
    }

    private void MF_CLASS200_b733(String s)
    {
        MF_CLASS200_d736.setText(s);
    }

    private void startInitialCalibReadyTimer()
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "startInitialCalibReadyTimer: called");
        MF_CLASS200_a732();
        MF_CLASS200_f738 = (new CLASS308(this, 30000L, 30000L)).start();
    }

    public void MF_CLASS200_a732()
    {
        if(MF_CLASS200_f738 != null)
        {
            MF_CLASS200_f738.cancel();
            MF_CLASS200_f738 = null;
        }
    }

    public void setProgressValue(String s)
    {
        if(MF_CLASS200_g735)
        	tvBGcalibrationProgress.setText(s);
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
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", (new StringBuilder()).append("onCreateDialog() called dialog = ").append(dialog).toString());
        dialog.setOnKeyListener(new CLASS227(this));
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", "onCreateView() called");
        View view = layoutinflater.inflate(R.layout.bgcalibview, viewgroup, true);
        tvBGcalibrationProgress = (TextView)view.findViewById(R.id.bgcalibration_progress);
        tvBGcalibrationProgress.setText(getString(R.string.calibrate_begin));
        tvBGcalibrationProgress.setClickable(true);
        tvBGcalibrationProgress.setOnClickListener(new CLASS254(this));
        MF_CLASS200_d736 = (TextView)view.findViewById(R.id.bg_calibrate_instruction_text);
        MF_CLASS200_d736.setClickable(false);
        MF_CLASS200_e737 = (ImageView)view.findViewById(R.id.calib_animation_view);
        MF_CLASS200_e737.setClickable(true);
        if(MF_CLASS200_e737 != null)
            MF_CLASS200_e737.setOnClickListener(new CLASS281(this));
        CLASS167.MF_CLASS167_b635("BackgroundCalibrationDialogFragment", (new StringBuilder()).append("onCreateView() returning view = ").append(view).toString());
        return view;
    }

    CLASS194 MF_CLASS200_a732;
    CLASS200 MF_CLASS200_b733;
    private TextView tvBGcalibrationProgress;
    private TextView MF_CLASS200_d736;
    private ImageView MF_CLASS200_e737;
    private CountDownTimer MF_CLASS200_f738;
    private boolean MF_CLASS200_g735;
}
