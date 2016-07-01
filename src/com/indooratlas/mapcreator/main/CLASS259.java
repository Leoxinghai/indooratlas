// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.content.Intent;
import com.indooratlas.cursor.list.*;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.*;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView, CLASS320, PlotActivity

class CLASS259
    implements android.content.DialogInterface.OnClickListener
{

    CLASS259(MapScreen mapscreen)
    {
        mMapScreen = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick ");
        Measurement class108;
        class108 = MapScreen.getIndoorMapView(mMapScreen).getSelectedSegment();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onContextItemSelected(): mIndoorMapView.getSelectedSegment returned measurement = ").append(class108).toString());
        Measurement class108_1;
        if(class108.MF_CLASS108_r464) {
            class108_1 = class108;
        } else {
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onContextItemSelected(): getting measurement with  ID = ").append(class108.mMeasurementID).append(" from DB.").toString());
	        class108_1 = MeasurementDataSource.getMeasurementByMeasureID(class108.mMeasurementID);
        }

        if(i == 0) {
	        try
	        {
	            CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 0");
	            if(class108_1.segmentID.equals("none"))
	            {
	                mMapScreen.deleteSelectedMeasurementFromLocalDB();
	                String s = MapScreen.MF_CLASS108_i455(mMapScreen).formatMeasurementFileString(class108_1);
	                boolean flag = mMapScreen.deleteFile(s);
	                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onContextItemSelected(): measurement protobuffer file with ID was deleted = ").append(flag).toString());
	                MapScreen.MF_CLASS19_d70(mMapScreen, false);
	                dialoginterface.cancel();
	                return;
	            }
	        }
	        catch(Exception exception)
	        {
	            MapScreen.MF_CLASS19_d70(mMapScreen, false);
	            CLASS167.unhandledexception(exception, mMapScreen.getApplicationContext());
	            return;
	        }
	        MapScreen.getIndoorMapView(mMapScreen).removeRecordedSegment(class108);
	        mMapScreen.showInProgressDialog(mMapScreen.getString(0x7f08001b), false);
	        MapScreen.MF_CLASS108_i455(mMapScreen).deleteMeasurementSequence(mMapScreen.mCurrentBuilding.getBuildingID(), mMapScreen.mCurrentLevel.getLevelID(), class108_1.segmentID);
        } else if(i == 1) {
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 1");
    	        MapScreen.MF_CLASS19_a67(mMapScreen, class108_1);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog(): SELECTED SEGMENT: ").append(class108_1.toString()).toString());
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
            } else if(i == 2) {
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
    	        double ad[];
    	        CLASS29 class29;
    	        Iterator iterator;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 2");
    	        List list = MeasurementDataSource.getMeasurementMgnData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
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
    	        ad = new double[3];
    	        class29 = (CLASS29)list.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class29.timeStamp).toString());
    	        iterator = list.iterator();
    	        int j = 0;

    	        for(;iterator.hasNext();) {
	    	        CLASS29 class29_1 = (CLASS29)iterator.next();
	    	        af1[j] = class29_1.AccelerometerX;
	    	        af3[j] = class29_1.AccelerometerY;
	    	        af5[j] = class29_1.AccelerometerZ;
	    	        af9[j] = class29_1.Accuracy;
	    	        af[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
	    	        af2[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
	    	        af4[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
	    	        af8[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
	    	        ad[0] = class29_1.AccelerometerX;
	    	        ad[1] = class29_1.AccelerometerY;
	    	        ad[2] = class29_1.AccelerometerZ;
	    	        af6[j] = (float)(class29_1.timeStamp - class29.timeStamp) / 1E+009F;
	    	        af7[j] = (float)MathUtils.MF_CLASS320_a910(ad);
	    	        j++;
    	        }

    	        arraylist.add(af);
    	        arraylist.add(af2);
    	        arraylist.add(af4);
    	        arraylist.add(af6);
    	        arraylist.add(af8);
    	        arraylist1.add(af1);
    	        arraylist1.add(af3);
    	        arraylist1.add(af5);
    	        arraylist1.add(af7);
    	        arraylist1.add(af9);
    	        Intent intent = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist);
    	        intent.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist1);
    	        intent.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "mgn_x", "mgn_y", "mgn_z", "mgn_norm", "mgn accu"
    	        });
    	        intent.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af.length / (af[-1 + af.length] - af[0]));
    	        mMapScreen.startActivity(intent);
            } else if(i == 3) {
    	        ArrayList arraylist2;
    	        ArrayList arraylist3;
    	        float af10[];
    	        float af11[];
    	        CLASS30 class30;
    	        Iterator iterator1;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 3");
    	        List list1 = MeasurementDataSource.getMeasurementPressureData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
    	        arraylist2 = new ArrayList();
    	        arraylist3 = new ArrayList();
    	        af10 = new float[list1.size()];
    	        af11 = new float[list1.size()];
//    	        new double[3];
    	        class30 = (CLASS30)list1.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class30.PressureTimestamp).toString());
    	        iterator1 = list1.iterator();
    	        int k = 0;

    	        for(;iterator1.hasNext();) {
	    	        CLASS30 class30_1 = (CLASS30)iterator1.next();
	    	        af11[k] = class30_1.Pressure - 1013.25F;
	    	        af10[k] = (float)(class30_1.PressureTimestamp - class30.PressureTimestamp) / 1E+009F;
	    	        k++;
    	        }
    	        arraylist2.add(af10);
    	        arraylist3.add(af11);
    	        Intent intent1 = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent1.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist2);
    	        intent1.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist3);
    	        intent1.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "Pressure"
    	        });
    	        intent1.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af10.length / (af10[-1 + af10.length] - af10[0]));
    	        mMapScreen.startActivity(intent1);
            } else if(i == 4) {
    	        ArrayList arraylist4;
    	        ArrayList arraylist5;
    	        float af12[];
    	        float af13[];
    	        CLASS28 class28;
    	        Iterator iterator2;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 4");
    	        List list2 = MeasurementDataSource.getMeasurementLightData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
    	        arraylist4 = new ArrayList();
    	        arraylist5 = new ArrayList();
    	        af12 = new float[list2.size()];
    	        af13 = new float[list2.size()];
    	        //new double[3];
    	        class28 = (CLASS28)list2.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class28.PressureTimestamp).toString());
    	        iterator2 = list2.iterator();
    	        int l = 0;

    	        for(;iterator2.hasNext();) {
	    	        CLASS28 class28_1 = (CLASS28)iterator2.next();
	    	        af13[l] = class28_1.Pressure;
	    	        af12[l] = (float)(class28_1.PressureTimestamp - class28.PressureTimestamp) / 1E+009F;
	    	        l++;
    	        }

    	        arraylist4.add(af12);
    	        arraylist5.add(af13);
    	        Intent intent2 = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent2.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist4);
    	        intent2.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist5);
    	        intent2.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "Light"
    	        });
    	        intent2.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af12.length / (af12[-1 + af12.length] - af12[0]));
    	        mMapScreen.startActivity(intent2);
            } else if(i == 5) {
    	        ArrayList arraylist6;
    	        ArrayList arraylist7;
    	        float af14[];
    	        float af15[];
    	        CLASS31 class31;
    	        Iterator iterator3;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 5");
    	        List list3 = MeasurementDataSource.getMeasurementProximityData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
    	        arraylist6 = new ArrayList();
    	        arraylist7 = new ArrayList();
    	        af14 = new float[list3.size()];
    	        af15 = new float[list3.size()];
//    	        new double[3];
    	        class31 = (CLASS31)list3.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class31.PressureTimestamp).toString());
    	        iterator3 = list3.iterator();
    	        int i1 = 0;

    	        for(;iterator3.hasNext();) {
	    	        CLASS31 class31_1 = (CLASS31)iterator3.next();
	    	        af15[i1] = class31_1.Pressure;
	    	        af14[i1] = (float)(class31_1.PressureTimestamp - class31.PressureTimestamp) / 1E+009F;
	    	        i1++;
    	        }
    	        arraylist6.add(af14);
    	        arraylist7.add(af15);
    	        Intent intent3 = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent3.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist6);
    	        intent3.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist7);
    	        intent3.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "Proximity"
    	        });
    	        intent3.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af14.length / (af14[-1 + af14.length] - af14[0]));
    	        mMapScreen.startActivity(intent3);
            } else if(i == 6) {
    	        ArrayList arraylist8;
    	        ArrayList arraylist9;
    	        float af16[];
    	        float af17[];
    	        CLASS32 class32;
    	        Iterator iterator4;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 6");
    	        List list4 = MeasurementDataSource.getMeasurementTemperatureData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
    	        arraylist8 = new ArrayList();
    	        arraylist9 = new ArrayList();
    	        af16 = new float[list4.size()];
    	        af17 = new float[list4.size()];
//    	        new double[3];
    	        class32 = (CLASS32)list4.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class32.PressureTimestamp).toString());
    	        iterator4 = list4.iterator();
    	        int j1 = 0;

    	        for(;iterator4.hasNext();) {
	    	        CLASS32 class32_1 = (CLASS32)iterator4.next();
	    	        af17[j1] = class32_1.Pressure;
	    	        af16[j1] = (float)(class32_1.PressureTimestamp - class32.PressureTimestamp) / 1E+009F;
	    	        j1++;
    	        }
    	        arraylist8.add(af16);
    	        arraylist9.add(af17);
    	        Intent intent4 = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent4.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist8);
    	        intent4.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist9);
    	        intent4.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "Temperature"
    	        });
    	        intent4.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af16.length / (af16[-1 + af16.length] - af16[0]));
    	        mMapScreen.startActivity(intent4);
            } else if(i == 7) {
    	        ArrayList arraylist10;
    	        ArrayList arraylist11;
    	        float af18[];
    	        float af19[];
    	        float af20[];
    	        float af21[];
    	        float af22[];
    	        float af23[];
    	        float af24[];
    	        float af25[];
    	        double ad1[];
    	        CLASS26 class26;
    	        Iterator iterator5;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 7");
    	        List list5 = MeasurementDataSource.getMeasurementGyroData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
    	        arraylist10 = new ArrayList();
    	        arraylist11 = new ArrayList();
    	        af18 = new float[list5.size()];
    	        af19 = new float[list5.size()];
    	        af20 = new float[list5.size()];
    	        af21 = new float[list5.size()];
    	        af22 = new float[list5.size()];
    	        af23 = new float[list5.size()];
    	        af24 = new float[list5.size()];
    	        af25 = new float[list5.size()];
    	        ad1 = new double[3];
    	        class26 = (CLASS26)list5.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class26.timeStamp).toString());
    	        iterator5 = list5.iterator();
    	        int k1 = 0;

    	        for(;iterator5.hasNext();) {
	    	        CLASS26 class26_1 = (CLASS26)iterator5.next();
	    	        af19[k1] = class26_1.AccelerometerX;
	    	        af21[k1] = class26_1.AccelerometerY;
	    	        af23[k1] = class26_1.AccelerometerZ;
	    	        af18[k1] = (float)(class26_1.timeStamp - class26.timeStamp) / 1E+009F;
	    	        af20[k1] = (float)(class26_1.timeStamp - class26.timeStamp) / 1E+009F;
	    	        af22[k1] = (float)(class26_1.timeStamp - class26.timeStamp) / 1E+009F;
	    	        ad1[0] = class26_1.AccelerometerX;
	    	        ad1[1] = class26_1.AccelerometerY;
	    	        ad1[2] = class26_1.AccelerometerZ;
	    	        af24[k1] = (float)(class26_1.timeStamp - class26.timeStamp) / 1E+009F;
	    	        af25[k1] = (float)MathUtils.MF_CLASS320_a910(ad1);
	    	        k1++;
    	        }
    	        arraylist10.add(af18);
    	        arraylist10.add(af20);
    	        arraylist10.add(af22);
    	        arraylist10.add(af24);
    	        arraylist11.add(af19);
    	        arraylist11.add(af21);
    	        arraylist11.add(af23);
    	        arraylist11.add(af25);
    	        Intent intent5 = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent5.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist10);
    	        intent5.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist11);
    	        intent5.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "gyr_x", "gyr_y", "gyr_z", "gyr_norm"
    	        });
    	        intent5.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af18.length / (af18[-1 + af18.length] - af18[0]));
    	        mMapScreen.startActivity(intent5);
            } else if(i == 8) {
    	        ArrayList arraylist12;
    	        ArrayList arraylist13;
    	        float af26[];
    	        float af27[];
    	        float af28[];
    	        float af29[];
    	        float af30[];
    	        float af31[];
    	        float af32[];
    	        float af33[];
    	        double ad2[];
    	        CLASS23 class23;
    	        Iterator iterator6;
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 8");
    	        List list6 = MeasurementDataSource.getMeasurementAccData(class108.mMeasurementID, 0);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
    	        arraylist12 = new ArrayList();
    	        arraylist13 = new ArrayList();
    	        af26 = new float[list6.size()];
    	        af27 = new float[list6.size()];
    	        af28 = new float[list6.size()];
    	        af29 = new float[list6.size()];
    	        af30 = new float[list6.size()];
    	        af31 = new float[list6.size()];
    	        af32 = new float[list6.size()];
    	        af33 = new float[list6.size()];
    	        ad2 = new double[3];
    	        class23 = (CLASS23)list6.get(0);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showSegmentSelectedDialog onclick: srhFirst = ").append(class23.timeStamp).toString());
    	        iterator6 = list6.iterator();
    	        int l1 = 0;

    	        for(;iterator6.hasNext();) {
	    	        CLASS23 class23_1 = (CLASS23)iterator6.next();
	    	        af27[l1] = class23_1.AccelerometerX;
	    	        af29[l1] = class23_1.AccelerometerY;
	    	        af31[l1] = class23_1.AccelerometerZ;
	    	        af26[l1] = (float)(class23_1.timeStamp - class23.timeStamp) / 1E+009F;
	    	        af28[l1] = (float)(class23_1.timeStamp - class23.timeStamp) / 1E+009F;
	    	        af30[l1] = (float)(class23_1.timeStamp - class23.timeStamp) / 1E+009F;
	    	        ad2[0] = class23_1.AccelerometerX;
	    	        ad2[1] = class23_1.AccelerometerY;
	    	        ad2[2] = class23_1.AccelerometerZ;
	    	        af32[l1] = (float)(class23_1.timeStamp - class23.timeStamp) / 1E+009F;
	    	        af33[l1] = (float)MathUtils.MF_CLASS320_a910(ad2);
	    	        l1++;
    	        }
    	        arraylist12.add(af26);
    	        arraylist12.add(af28);
    	        arraylist12.add(af30);
    	        arraylist12.add(af32);
    	        arraylist13.add(af27);
    	        arraylist13.add(af29);
    	        arraylist13.add(af31);
    	        arraylist13.add(af33);
    	        Intent intent6 = new Intent(mMapScreen.mMe, PlotActivity.class);
    	        intent6.putExtra("com.indooratlas.mapcreator.main.xvalues", arraylist12);
    	        intent6.putExtra("com.indooratlas.mapcreator.main.yvalues", arraylist13);
    	        intent6.putExtra("com.indooratlas.mapcreator.main.legends", new String[] {
    	            "acc_x", "acc_y", "acc_z", "acc_norm"
    	        });
    	        intent6.putExtra("com.indooratlas.mapcreator.main.samplefreq", (float)af26.length / (af26[-1 + af26.length] - af26[0]));
    	        mMapScreen.startActivity(intent6);
            } else if(i == 9) {
    	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() onClick item == 9");
    	        MapScreen.MF_CLASS19_a67(mMapScreen, class108_1);
    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("SELECTED SEGMENT: ").append(class108_1.toString()).toString());
    	        MapScreen.MF_CLASS108_i455(mMapScreen).measurementToProtoBufferFileIncrementalWithWifi(class108_1);
    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
    	        MapScreen.getIndoorMapView(mMapScreen).invalidate();
            }

        MapScreen.MF_CLASS19_d70(mMapScreen, false);
        dialoginterface.cancel();
        return;
    }

    final MapScreen mMapScreen;
}
