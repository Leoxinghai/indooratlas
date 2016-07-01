package com.indooratlas.mapcreator.main;


import android.content.Intent;
import com.indooratlas.mapcreator.controller.CLASS167;
import org.apache.http.cookie.Cookie;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         LoginActivity, Sipa

class StartWorldMapViewRunnable
 implements Runnable
{

 StartWorldMapViewRunnable(LoginActivity loginactivity)
 {
     MF_CLASS219_a765 = loginactivity;
 }

 public void run()
 {
     LoginActivity.MF_CLASS19_e71(MF_CLASS219_a765);
//     Intent intent = new Intent(MF_CLASS219_a765.f, Sipa.class);
     
     Intent intent = new Intent(MF_CLASS219_a765.f, MapScreen.class);
     intent.putExtra("com.indooratlas.mapcreator.main.username", MF_CLASS219_a765.MF_CLASS22_g77);
     intent.putExtra("com.indooratlas.mapcreator.main.password", MF_CLASS219_a765.h);
//     intent.putExtra("com.indooratlas.mapcreator.main.cookie", (new StringBuilder()).append(MF_CLASS219_a765.i.getName()).append("=").append(MF_CLASS219_a765.i.getValue()).toString());
     intent.putExtra("com.indooratlas.mapcreator.main.devicemodel", LoginActivity.MF_CLASS19_b68(MF_CLASS219_a765));
     intent.putExtra("com.indooratlas.mapcreator.main.secret", MF_CLASS219_a765.l);
     intent.putExtra("com.indooratlas.mapcreator.main.apikey", MF_CLASS219_a765.m);
     LoginActivity.MF_CLASS19_a67(MF_CLASS219_a765, true);
     if(!MF_CLASS219_a765.q)
     {
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "startWorldMapView: mLoginCancelled == false --> starting world map activity");
         MF_CLASS219_a765.startActivity(intent);
     } else
     {
         CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, "startWorldMapView: mLoginCancelled == true --> finishing Login activity");
     }
     MF_CLASS219_a765.finish();
 }

 final LoginActivity MF_CLASS219_a765;
}
