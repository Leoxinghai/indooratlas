package com.indooratlas.mapcreator.main;


import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.RestClient;
import com.indooratlas.mapcreator.data.Building;
import java.util.List;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         Sipa

class showBuildingSelectionDialog
 implements android.content.DialogInterface.OnClickListener
{

	showBuildingSelectionDialog(Sipa sipa, List list)
 {
     MF_CLASS326_b917 = sipa;
     MF_CLASS326_a918 = list;

 }

 public void onClick(DialogInterface dialoginterface, int i)
 {
     try
     {
         CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() onClick ");
         MF_CLASS326_b917.mCurrentBuilding = (Building)MF_CLASS326_a918.get(i);
         CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() calling getFloorplans ");
         Sipa.MF_CLASS113_b487(MF_CLASS326_b917).getLevels(MF_CLASS326_b917.mCurrentBuilding.getBuildingID());
         dialoginterface.cancel();
         CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() calling showWaitDialog ");
         MF_CLASS326_b917.showWaitDialog("Loading...");
         return;
     }
     catch(Exception exception)
     {
         CLASS167.unhandledexception(exception, MF_CLASS326_b917.getApplicationContext());
     }
 }

 final List MF_CLASS326_a918;
 final Sipa MF_CLASS326_b917;
}
