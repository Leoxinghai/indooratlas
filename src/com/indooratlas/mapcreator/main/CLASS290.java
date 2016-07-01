// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.Calibrator.*;
import com.indooratlas.mapcreator.controller.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS316, IndoorMapView

class CLASS290
    implements Runnable
{

    CLASS290(MapScreen mapscreen, String s)
    {
        MF_CLASS290_b852 = mapscreen;
        MF_CLASS17_a58 = s;
    }

    public void run()
    {
        int i = 0;
        String s;
        String s2;
        String as1[];
        CLASS15 class15;
        CLASS15 class15_1;

        if(MF_CLASS17_a58.startsWith("Toast:"))
            MF_CLASS290_b852.showToastMessage(MF_CLASS17_a58.substring("Toast:".length()), 0);

        if(MF_CLASS290_b852.mScreenPointType != POINT_TYPE.POSITIONING) {
                if(MF_CLASS17_a58.startsWith("sensors:")) {
                	MF_CLASS290_b852.I = MF_CLASS17_a58.substring("sensors:".length());
                } else if(MF_CLASS17_a58.startsWith("freq")) {
                	MF_CLASS290_b852.J = MF_CLASS17_a58;
                } else if(MF_CLASS17_a58.startsWith("Magnetometer") || System.currentTimeMillis() - MF_CLASS290_b852.D <= 10000L) {
        	        MF_CLASS290_b852.D = System.currentTimeMillis();
        	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): ").append(MF_CLASS17_a58).toString());
        	        s = MF_CLASS17_a58;
        	        MF_CLASS290_b852.showToastMessage(s, 1);
        	        MF_CLASS290_b852.vibrate(500);
                }
        } else {
	        if(MF_CLASS17_a58.startsWith("ShortTermPos:"))
	        {
	            MF_CLASS290_b852.hideInProgressDialog();
	            String s4 = MF_CLASS17_a58.substring("ShortTermPos:".length());
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug() : ShortTermPos = ").append(s4).toString());
	            String as2[] = s4.split(",");
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug() : xy[0] = ").append(as2[0]).append(", xy[1] = ").append(as2[1]).append(", angle = ").append(as2[2]).toString());
	            float f = Float.parseFloat(as2[0]);
	            float f1 = Float.parseFloat(as2[1]);
	            float f2 = Float.parseFloat(as2[2]);
	            MapScreen.getIndoorMapView(MF_CLASS290_b852).updateShortTermPosition(f, f1, f2);
	            return;
	        }
	        if(MF_CLASS17_a58.startsWith("Last buffered observation")) {
		        Date date = new Date();
		        String s3 = MF_CLASS290_b852.z.format(date);
		        MF_CLASS290_b852.C = (new StringBuilder()).append(MF_CLASS17_a58).append(" added at = ").append(s3).toString();
	        } else if(MF_CLASS17_a58.startsWith("freq")) {
	        	MF_CLASS290_b852.J = MF_CLASS17_a58;
	        } else if(MF_CLASS17_a58.startsWith("Feedback")) {
	        	MF_CLASS290_b852.K = MF_CLASS17_a58;
	        } else if(MF_CLASS17_a58.startsWith("QueueLength")) {
	            MapScreen.MF_CLASS19_b68(MF_CLASS290_b852, MF_CLASS17_a58);
	        }
        }

        if(MF_CLASS17_a58.startsWith("BGcalib")) {
	        long l;
	        MapScreen.MF_CLASS24_c88(MF_CLASS290_b852, MF_CLASS17_a58);
	        l = System.currentTimeMillis();
	        if(l - MapScreen.M(MF_CLASS290_b852) > 60000L) {
	                String as[];
	                double ad[];
	                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): PARSINGBGCALIB origstr:").append(MF_CLASS17_a58).toString());
	                String s1 = MF_CLASS17_a58.substring(1 + MF_CLASS17_a58.indexOf("["), MF_CLASS17_a58.indexOf("]"));
	                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): PARSINGBGCALIB biasStr:").append(s1).toString());
	                as = s1.split(" ");
	                ad = new double[3];
	                int j = 0;
	                do
	                {
	                    try
	                    {
	                        if(j >= as.length)
	                            break;
	                        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): PARSINGBGCALIB biasStrList[").append(j).append("]:").append(as[j]).toString());
	                        ad[j] = Double.parseDouble(as[j]);
	                    }
	                    catch(Exception exception)
	                    {
	                        if(CLASS113.isExceptionLogged.booleanValue())
	                        {
	                            exception.printStackTrace();
	                            return;
	                        } else
	                        {
	                            return;
	                        }
	                    }
	                    j++;
	                } while(true);
                    s2 = MF_CLASS17_a58.substring(9 + MF_CLASS17_a58.lastIndexOf("biasCov: "), -1 + MF_CLASS17_a58.length());
                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): PARSINGBGCALIB covStr:").append(s2).toString());

                    as1 = s2.split(",");
                    for(i=0;i < as1.length;i++) {
                    	CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): PARSINGBGCALIB tempList[").append(i).append("]:").append(as1[i]).toString());
                    }

                    class15 = new CLASS15("unknown", ad, Double.parseDouble(as1[0]), 0.0D, CLASS17.BACKGROUND, BGC_TYPE.BGC_READY);
                    class15.MF_CLASS16_b54(System.currentTimeMillis());
                    CLASS167.MF_CLASS167_b635("MapScreen", "onDebug(): PARSINGBGCALIB calling MeasurementDataSource.storeBGCalibration(bg)");
                    class15_1 = MeasurementDataSource.storeBGCalibration(class15);
                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug(): PARSINGBGCALIB MeasurementDataSource.storeBGCalibration ret = ").append(class15_1).toString());
                    MapScreen.MF_CLASS19_b68(MF_CLASS290_b852, l);
	        }
        } else if(MF_CLASS17_a58.startsWith("Last wifi scan")) {
                MF_CLASS290_b852.H = MF_CLASS17_a58;
        }
        MF_CLASS290_b852.B = MF_CLASS17_a58;
        MF_CLASS290_b852.showOnDebugMessage();
        return;
    }

    final String MF_CLASS17_a58;
    final MapScreen MF_CLASS290_b852;
}
