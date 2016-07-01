package com.indooratlas.mapcreator.main;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.*;
import android.widget.TextView;
import com.indooratlas.mapcreator.controller.CLASS167;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         CLASS352, CLASS351, CLASS197

public class WalkViewDialogFragment extends DialogFragment
{

 public WalkViewDialogFragment(CLASS197 class197)
 {
     MF_CLASS350_a948 = null;
     MF_CLASS350_b949 = null;
     MF_CLASS350_a948 = class197;
     MF_CLASS350_b949 = this;
 }

 static TextView MF_CLASS350_a948(WalkViewDialogFragment class350)
 {
     return class350.MF_CLASS350_c950;
 }

 public static WalkViewDialogFragment MF_CLASS350_a948(CLASS197 class197)
 {
     return new WalkViewDialogFragment(class197);
 }

 private void startInitTimeoutCheck()
 {
     CLASS167.MF_CLASS167_b635("WalkViewDialogFragment", "startInitTimeoutCheck: called");
     MF_CLASS350_a948();
     MF_CLASS350_d951 = (new CLASS352(this, 30000L, 5000L)).start();
 }

 public void MF_CLASS350_a948()
 {
     CLASS167.MF_CLASS167_b635("WalkViewDialogFragment", "stopInitTimeoutCheck()");
     if(MF_CLASS350_d951 != null)
     {
         MF_CLASS350_d951.cancel();
         MF_CLASS350_d951 = null;
     }
 }

 public void MF_CLASS350_a948(String s)
 {
     MF_CLASS350_c950.setText(s);
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
     dialog.setOnKeyListener(new CLASS351(this));
     return dialog;
 }

 public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
 {
     View view = layoutinflater.inflate(R.layout.walkview, viewgroup, true);
     MF_CLASS350_c950 = (TextView)view.findViewById(R.id.walk_instruction_text);
     startInitTimeoutCheck();
     return view;
 }

 CLASS197 MF_CLASS350_a948;
 WalkViewDialogFragment MF_CLASS350_b949;
 private TextView MF_CLASS350_c950;
 private CountDownTimer MF_CLASS350_d951;
}
