package com.indooratlas.mapcreator.main;



import com.indooratlas.mapcreator.controller.CLASS167;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         MapScreen, CLASS316

class ShowCalibrationRequiredDialog
 implements Runnable
{

	ShowCalibrationRequiredDialog(MapScreen mapscreen)
 {
 	mMapScreen = mapscreen;
 }

 public void run()
 {
     CLASS167.MF_CLASS167_b635("MapScreen", "startPositioning exception caught, showing BG calib view");
     mMapScreen.hideWalkView();
     mMapScreen.showInformationDialog("Calibration required. Rock your phone gently");
     try
     {
         MapScreen.setMapState(mMapScreen, POINT_TYPE.DEFAULT);
         return;
     }
     catch(Exception exception)
     {
         return;
     }
 }

 final MapScreen mMapScreen;
}
