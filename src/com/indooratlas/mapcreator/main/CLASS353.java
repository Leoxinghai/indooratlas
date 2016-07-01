// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.main;

//import com.google.android.maps.LatLng;
//import com.google.android.maps.OverlayItem;


import com.google.android.gms.maps.model.LatLng;

import com.indooratlas.mapcreator.data.Building;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

public class CLASS353 //extends OverlayItem
{

    public CLASS353(LatLng geopoint, Sipa sipa, Building class99)
    {
//        super(geopoint, class99.MF_CLASS99_b371(), class99.MF_CLASS99_b371());
        MF_CLASS353_b954 = sipa;
        MF_CLASS353_a955 = class99;
    }

    public Building MF_CLASS353_a955;
    public Sipa MF_CLASS353_b954;
}
