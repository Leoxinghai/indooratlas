// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import com.indooratlas.Calibrator.CLASS15;
import com.indooratlas.cursor.list.CLASS29;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.MeasurementDataSource;
import com.indooratlas.mapcreator.data.*;
import com.indooratlas.sensor.CLASS370;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, PrefsActivity, CLASS310, IndoorMapView,
//            CLASS320, PlotActivity, CLASS315

class CLASS261
    implements android.content.DialogInterface.OnClickListener
{

    CLASS261(MapScreen mapscreen)
    {
        MF_CLASS370_a999 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick ");
        if(i == 0) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 0");
	        MF_CLASS370_a999.mPrefsChanged = true;
	        CLASS167.MF_CLASS167_b635("MapScreen", "before opening PrefsActivity");
	        Intent intent3 = new Intent(MF_CLASS370_a999.mMe, PrefsActivity.class);
	        intent3.setFlags(0x40000000);
	        MF_CLASS370_a999.startActivity(intent3);
        } else if(i == 1) {
            try
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 1");
                (new CLASS310(MF_CLASS370_a999)).execute(new Void[0]);
            }
            catch(Exception exception)
            {
                CLASS167.unhandledexception(exception, MF_CLASS370_a999.getApplicationContext());
                return;
            }
        } else if(i == 2) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 2");
	        MapScreen.sReMSCreateTables(MF_CLASS370_a999);
        } else if(i == 3) {
            CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 3");
            dialoginterface.cancel();
            if(!MapScreen.getIndoorMapView(MF_CLASS370_a999).getBackEndSegmentVisibility())
                MapScreen.sFireBackendSegmentSynch(MF_CLASS370_a999);
            else
            	MapScreen.getIndoorMapView(MF_CLASS370_a999).setBackEndSegmentVisibility(false);
        } else if(i == 4) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 4");
	        MF_CLASS370_a999.informUploadDone();
        } else if(i == 5) {
	        Iterator iterator;
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 5");
	        iterator = ((SensorManager)MF_CLASS370_a999.mMe.getSystemService("sensor")).getSensorList(-1).iterator();
	        String s = "";
	        while(iterator.hasNext())
	        {
	            Sensor sensor = (Sensor)iterator.next();
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).toString());
	            s = (new StringBuilder()).append(s).append("Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).append("\n\n").toString();
	        }
	        MF_CLASS370_a999.showInformationDialog(s);
        } else if(i == 6) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 6");
	        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("vnd.youtube://").append("bA9iytNeDLw").toString()));
	        MF_CLASS370_a999.startActivity(intent);
        } else if(i == 7) {
	        double d;
	        double d1;
	        double d2;
	        ArrayList arraylist;
	        ArrayList arraylist1;
	        float af[];
	        float af1[];
	        float af2[];
	        float af3[];
	        float af4[];
	        float af5[];
	        float af6[];
	        float af7[];
	        float af8[];
	        float af9[];
	        float af10[];
	        float af11[];
	        double ad[];
	        CLASS29 class29;
	        Iterator iterator1;
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 7");
	        d = MapScreen.MF_CLASS108_l458(MF_CLASS370_a999)[1];
	        d1 = -1D * MapScreen.MF_CLASS108_l458(MF_CLASS370_a999)[0];
	        d2 = MapScreen.MF_CLASS108_l458(MF_CLASS370_a999)[2];
	        List list = MeasurementDataSource.getMeasurementMgnData(MeasurementDataSource.getCalibrationByCalibrationSetID().mMeasurementID, 1);
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog() onClick item == 7, lastMgnSamples.size = ").append(list.size()).toString());
	        arraylist = new ArrayList();
	        arraylist1 = new ArrayList();
	        af = new float[list.size()];
	        af1 = new float[list.size()];
	        af2 = new float[list.size()];
	        af3 = new float[list.size()];
	        af4 = new float[list.size()];
	        af5 = new float[list.size()];
	        af6 = new float[list.size()];
	        af7 = new float[list.size()];
	        af8 = new float[list.size()];
	        af9 = new float[list.size()];
	        af10 = new float[list.size()];
	        af11 = new float[list.size()];
	        ad = new double[3];
	        class29 = (CLASS29)list.get(0);
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog onclick: srhFirst = ").append(class29.timeStamp).toString());
	        iterator1 = list.iterator();
	        int j = 0;

	        CLASS29 class29_1;
	        for(;iterator1.hasNext();) {
		        class29_1 = (CLASS29)iterator1.next();
		        af1[j] = class29_1.AccelerometerX;
		        af3[j] = class29_1.AccelerometerY;
		        af5[j] = class29_1.AccelerometerZ;
		        af[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
		        af2[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
		        af4[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
		        ad[0] = class29_1.AccelerometerX;
		        ad[1] = class29_1.AccelerometerY;
		        ad[2] = class29_1.AccelerometerZ;
		        af6[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
		        af7[j] = (float)MathUtils.MF_CLASS320_a910(ad);
		        af8[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
		        af9[j] = class29_1.Accuracy;
		        ad[0] = ad[0] - d;
		        ad[1] = ad[1] - d1;
		        ad[2] = ad[2] - d2;
		        af10[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
		        af11[j] = (float)MathUtils.MF_CLASS320_a910(ad);
		        j++;
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog : mgn = ").append(class29_1.timeStamp).append(" ").append(class29_1.AccelerometerX).append(" ").append(class29_1.AccelerometerY).append(" ").append(class29_1.AccelerometerZ).toString());
	        }

	        arraylist.add(af);
	        arraylist.add(af2);
	        arraylist.add(af4);
	        arraylist.add(af6);
	        arraylist.add(af8);
	        arraylist.add(af10);
	        arraylist1.add(af1);
	        arraylist1.add(af3);
	        arraylist1.add(af5);
	        arraylist1.add(af7);
	        arraylist1.add(af9);
	        arraylist1.add(af11);
	        Intent intent1 = new Intent(MF_CLASS370_a999.mMe, PlotActivity.class);
	        intent1.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist);
	        intent1.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist1);
	        intent1.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
	            "mgn_x", "mgn_y", "mgn_z", "mgn_norm", "accu", "norm_bc"
	        });
	        intent1.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af.length / (af[-1 + af.length] - af[0]));
	        MF_CLASS370_a999.startActivity(intent1);
        } else if(i == 8) {
	        Sensor sensor1;
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 8");
	        SensorManager sensormanager = (SensorManager)MF_CLASS370_a999.mMe.getSystemService("sensor");
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog: checking uncalibrated mgn sensor");
	        if(android.os.Build.VERSION.SDK_INT < 18) {
		        MF_CLASS370_a999.showInformationDialog("No raw Mgn sensor found!");
	        } else {
		        sensor1 = sensormanager.getDefaultSensor(14);
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog: got uncalibrated mgn sensor = ").append(sensor1).toString());
		        if(sensor1 != null) {
			        MF_CLASS370_a999.showInformationDialog("Raw Mgn sensor found!");
		        } else {
			        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog: PLATFORM WAS > 4.3, BUT sensor == null");
			        MF_CLASS370_a999.showInformationDialog("No raw Mgn sensor found.");
		        }
	        }
        } else if(i == 9) {
        	CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 9, calling mIndoorAtlas.calibrate()");
        } else if(i == 10) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 10, calling teardown API, and re-create");
	        MF_CLASS370_a999.showInProgressDialog("Resetting...", false);
	        (new CLASS315(MF_CLASS370_a999)).execute(new Void[0]);
        } else if(i == 11) {
	        List list1;
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 11, test paths");
	        list1 = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(MF_CLASS370_a999.mCurrentBuilding.getBuildingID(), MF_CLASS370_a999.mCurrentLevel.getLevelID(), MF_CLASS370_a999.mGraphics.getGraphicsID());
	        long l;
	        long l1;
	        l = 0L;
	        l1 = 0L;
	        long l3;
	        long l4;
	        Iterator iterator2 = list1.iterator();
	        for(;iterator2.hasNext();) {
		        Measurement class108 = (Measurement)iterator2.next();
		        if(class108.TestSegment == 1) {
			        l3 = l1 + (long)class108.mPoints.size();
			        l4 = l;
		        } else {
			        long l2 = l + (long)class108.mPoints.size();
			        l3 = l1;
			        l4 = l2;
		        }
		        long l5 = l3;
		        l = l4;
		        l1 = l5;
		    }
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog() onClick item == 11, test paths, cntTest = ").append(l1).append(", cntMap = ").append(l).toString());
        } else if(i == 12) {
        	CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 12, generating map");
        } else if(i == 13) {
	        ArrayList arraylist2;
	        ArrayList arraylist3;
	        float af12[];
	        float af13[];
	        float af14[];
	        float af15[];
	        float af16[];
	        float af17[];
	        float af18[];
	        float af19[];
	        CLASS15 class15;
	        Iterator iterator3;
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() onClick item == 13");
	        List list2 = MeasurementDataSource.getAllBGCalibrations();
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog() onClick item == 13, calibSets.size = ").append(list2.size()).toString());
	        arraylist2 = new ArrayList();
	        arraylist3 = new ArrayList();
	        af12 = new float[list2.size()];
	        af13 = new float[list2.size()];
	        af14 = new float[list2.size()];
	        af15 = new float[list2.size()];
	        af16 = new float[list2.size()];
	        af17 = new float[list2.size()];
	        af18 = new float[list2.size()];
	        af19 = new float[list2.size()];
//	        new double[3];
	        class15 = (CLASS15)list2.get(0);
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog onclick: first  timestamp = ").append(class15.MF_CLASS15_f50()).toString());
	        iterator3 = list2.iterator();
	        int k;
	        String s1;
	        String s2;
	        k = 0;
	        s1 = "";
	        s2 = "";
	        String s3;

	        for(;iterator3.hasNext();) {
		        CLASS15 class15_1 = (CLASS15)iterator3.next();
		        af13[k] = (float)class15_1.MF_CLASS16_b54()[0];
		        af15[k] = (float)class15_1.MF_CLASS16_b54()[1];
		        af17[k] = (float)class15_1.MF_CLASS16_b54()[2];
		        af19[k] = (float)class15_1.MF_CLASS16_c55() / 1000F;
		        af12[k] = (float)(class15_1.MF_CLASS15_f50() - class15.MF_CLASS15_f50()) / 1000F;
		        af14[k] = af12[k];
		        af16[k] = af12[k];
		        af18[k] = af12[k];
		        s1 = (new StringBuilder()).append(s1).append(",").append(af12[k]).toString();
		        s3 = (new StringBuilder()).append(s2).append(",").append(af19[k]).toString();
		        k++;
		        s2 = s3;
	        }

	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog onclick: timestamps = ").append(s1).toString());
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showDeveloperMenuDialog onclick: covs = ").append(s2).toString());
	        arraylist2.add(af12);
	        arraylist2.add(af14);
	        arraylist2.add(af16);
	        arraylist2.add(af18);
	        arraylist3.add(af13);
	        arraylist3.add(af15);
	        arraylist3.add(af17);
	        arraylist3.add(af19);
	        Intent intent2 = new Intent(MF_CLASS370_a999.mMe, PlotActivity.class);
	        intent2.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist2);
	        intent2.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist3);
	        intent2.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
	            "bias_x", "bias_y", "bias_z", "cov_div1000"
	        });
	        intent2.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af12.length / (af12[-1 + af12.length] - af12[0]));
	        MF_CLASS370_a999.startActivity(intent2);
        }

        dialoginterface.cancel();
        return;


    }

    final MapScreen MF_CLASS370_a999;
}
