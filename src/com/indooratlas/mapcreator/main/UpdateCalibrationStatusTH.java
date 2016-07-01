package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.types.INDOORTYPE;
import com.indooratlas.types.Some1Base;
import java.text.NumberFormat;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         LoginActivity, CLASS200

class UpdateCalibrationStatusTH
 implements Runnable
{

 UpdateCalibrationStatusTH(LoginActivity loginactivity, Some1Base some1base)
 {
 	mLoginActivity = loginactivity;
     MF_CLASS203_a742 = some1base;
 }

 public void run()
 {
     float f = 99F;
     if(MF_CLASS203_a742.getIndoorAction() == INDOORTYPE.RESTARTED)
     {
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "onCalibrationStatus() RESTARTED --> set warning message on UI");
         if(LoginActivity.k(mLoginActivity) != null)
         {
             LoginActivity.k(mLoginActivity).setProgressValue(mLoginActivity.getString(R.string.bg_calib_restarted));
             LoginActivity.MF_CLASS19_a67(mLoginActivity, 0.0F);
         }
     } else
     {
         float f1 = MF_CLASS203_a742.actionPercentage();
         if(LoginActivity.m(mLoginActivity) >= f1)
         {
             CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "onCalibrationStatus() percent not changed, skipping event and returning");
             return;
         }
         if(f1 <= f || f1 >= 100F)
             f = f1;
         LoginActivity.MF_CLASS19_a67(mLoginActivity, f);
         if(LoginActivity.k(mLoginActivity) != null)
         {
             LoginActivity.k(mLoginActivity).setProgressValue((new StringBuilder()).append(mLoginActivity.o.format(f)).append("%").toString());
             return;
         }
     }
 }

 final Some1Base MF_CLASS203_a742;
 final LoginActivity mLoginActivity;
}
