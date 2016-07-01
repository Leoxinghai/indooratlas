package com.indooratlas.mapcreator.main;


import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         CLASS355, CLASS356, CLASS357, CLASS195

public class CalibrationDialogFragment extends DialogFragment
{

 public CalibrationDialogFragment(CLASS195 class195)
 {
     MF_CLASS354_a956 = null;
     MF_CLASS354_d959 = null;
     MF_CLASS354_d959 = class195;
     MF_CLASS354_a956 = this;
 }

 public static CalibrationDialogFragment createInstance(CLASS195 class195)
 {
     return new CalibrationDialogFragment(class195);
 }

 static CLASS195 MF_CLASS354_a956(CalibrationDialogFragment class354)
 {
     return class354.MF_CLASS354_d959;
 }

 static TextView MF_CLASS354_b957(CalibrationDialogFragment class354)
 {
     return class354.tvProgress;
 }

 static ImageView MF_CLASS354_c958(CalibrationDialogFragment class354)
 {
     return class354.MF_CLASS354_c958;
 }

 public void setProgress(String s)
 {
	 tvProgress.setText(s);
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
     CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", (new StringBuilder()).append("onCreateDialog() called dialog = ").append(dialog).toString());
     dialog.setOnKeyListener(new CLASS355(this));
     return dialog;
 }

 public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
 {
     CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", "onCreateView() called");
     View view = layoutinflater.inflate(R.layout.calibview, viewgroup, true);
     tvProgress = (TextView)view.findViewById(R.id.calibration_progress);
//     MF_CLASS354_b957.setText(getString(0x7f080008));
     MF_CLASS354_c958 = (ImageView)view.findViewById(R.id.forced_calib_animation_view);
     if(MF_CLASS354_c958 != null) {
         MF_CLASS354_c958.setClickable(true);
         MF_CLASS354_c958.setOnClickListener(new CLASS356(this));
     } else {
    	 tvProgress.setClickable(true);
    	 tvProgress.setOnClickListener(new CLASS357(this));
     }
     CLASS167.MF_CLASS167_b635("CalibrationDialogFragment", (new StringBuilder()).append("onCreateView() returning view = ").append(view).toString());
     return view;
 }

 CalibrationDialogFragment MF_CLASS354_a956;
 private TextView tvProgress;
 private ImageView MF_CLASS354_c958;
 private CLASS195 MF_CLASS354_d959;
}
