package com.indooratlas.mapcreator.main;


import com.indooratlas.mapcreator.controller.CLASS167;

class ReconnectingTimer
 implements Runnable
{

	ReconnectingTimer(CLASS361 class361)
 {
     MF_CLASS362_a973 = class361;

 }

 public void run()
 {
     try
     {
         CLASS167.MF_CLASS167_b635("IndoorMapView", "ReconnectingTimer.run: calling invalidate()");
         MF_CLASS362_a973.mIndoorMapView.prepareDraw();
         MF_CLASS362_a973.mIndoorMapView.invalidate();
         return;
     }
     catch(Exception exception)
     {
         return;
     }
 }

 final CLASS361 MF_CLASS362_a973;
}
