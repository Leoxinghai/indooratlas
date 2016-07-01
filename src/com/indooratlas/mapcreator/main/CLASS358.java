// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
//import com.google.android.maps.ItemizedOverlay;
//import com.google.android.maps.OverlayItem;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.RestClient;
import com.indooratlas.mapcreator.data.Building;
import java.util.ArrayList;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa, CLASS353

public class CLASS358 //extends ItemizedOverlay
{

    public CLASS358(Drawable drawable)
    {
//        super(boundCenterBottom(drawable));
        MF_CLASS353_b954 = new ArrayList();
        MF_CLASS358_d965 = null;
        MF_CLASS358_e966 = null;
    }

    public CLASS358(Drawable drawable, Context context, Sipa sipa)
    {
        this(drawable);
        MF_CLASS358_c967 = context;
        MF_CLASS358_d965 = sipa;
//        populate();
    }

    public void MF_CLASS353_a955()
    {
//        populate();
    }
/*
    public void MF_CLASS353_a955(OverlayItem overlayitem)
    {
        MF_CLASS353_b954.add(overlayitem);
        setLastFocusedIndex(-1);
    }

    public void MF_CLASS353_b954()
    {
        MF_CLASS353_b954.clear();
    }

    protected OverlayItem createItem(int i)
    {
        return (OverlayItem)MF_CLASS353_b954.get(i);
    }
*/
    protected boolean onTap(int i)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS353_a955, "onTap() called, before synchroning");

        try {
	        if(MF_CLASS358_d965.getBuildingSelectionOngoing())
	        {
	            CLASS167.MF_CLASS167_b635(MF_CLASS353_a955, "onTap() called, mBuildingLevelFloorplanSelectionOngoing == true, returning without actions.");
	            return true;
	        }
	        CLASS167.MF_CLASS167_b635(MF_CLASS353_a955, "onTap() called, mBuildingLevelFloorplanSelectionOngoing == false, continuing to Level-Floorplan image selection interaction.");
	        synchronized(MF_CLASS358_d965)
	        {
	            CLASS167.MF_CLASS167_b635(MF_CLASS353_a955, "onTap() called, within synchronized.");
	            MF_CLASS358_d965.setBuildingSelectionOngoing(true);
	            MF_CLASS358_e966 = (CLASS353)MF_CLASS353_b954.get(i);
	            CLASS167.MF_CLASS167_b635(MF_CLASS353_a955, (new StringBuilder()).append("onTap() mapOverlays.size() == ").append(MF_CLASS353_b954.size()).toString());
	            MF_CLASS358_d965.showWaitDialog("Loading building...");
	            (new RestClient(MF_CLASS358_e966.MF_CLASS353_b954, MF_CLASS358_e966.MF_CLASS353_a955, MF_CLASS358_d965.mCookie)).getLevels(MF_CLASS358_e966.MF_CLASS353_a955.getBuildingID());
	            MF_CLASS358_d965.mCurrentBuilding = MF_CLASS358_e966.MF_CLASS353_a955;
	            CLASS167.MF_CLASS167_b635(MF_CLASS353_a955, "onTap() returning.");
	        }
	        return true;
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
        return false;
    }

    public int size()
    {
        return MF_CLASS353_b954.size();
    }

    private static String MF_CLASS353_a955 = "CustomizedItemizedOverlay";
    private ArrayList MF_CLASS353_b954;
    private Context MF_CLASS358_c967;
    private Sipa MF_CLASS358_d965;
    private CLASS353 MF_CLASS358_e966;

}
