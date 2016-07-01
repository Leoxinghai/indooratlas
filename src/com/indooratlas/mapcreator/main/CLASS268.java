// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.mapcreator.data.CheckPoint;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView

class CLASS268
    implements android.content.DialogInterface.OnClickListener
{

    CLASS268(MapScreen mapscreen, String as[])
    {
        MF_CLASS268_b821 = mapscreen;
        MF_CLASS268_a822 = as;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showRoutePointLabelDialog() onClick ");
        if(i != -1 + MF_CLASS268_a822.length)
        {
            String s = MF_CLASS268_a822[i].toString();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showRoutePointLabelDialog() onClick item == ").append(i).append(", storing label = ").append(s).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showRoutePointLabelDialog() onClick mTestSegmentPath.getEndPoint().mLabel == ").append(MapScreen.getStartMeasure(MF_CLASS268_b821).getLastCheckPoint().MF_CLASS112_e484).toString());
            MapScreen.getStartMeasure(MF_CLASS268_b821).getLastCheckPoint().MF_CLASS112_e484 = s;
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showRoutePointLabelDialog() onClick mTestSegmentPath.getEndPoint().mLabel == ").append(MapScreen.getStartMeasure(MF_CLASS268_b821).getLastCheckPoint().MF_CLASS112_e484).toString());
            dialoginterface.cancel();
            MapScreen.getIndoorMapView(MF_CLASS268_b821).invalidate();
            return;
        }
        try
        {
            MF_CLASS268_b821.showToastMessage("Entering free-text labels is currently not supported.", 1);
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, MF_CLASS268_b821.getApplicationContext());
        }
        return;
    }

    final String MF_CLASS268_a822[];
    final MapScreen MF_CLASS268_b821;
}
