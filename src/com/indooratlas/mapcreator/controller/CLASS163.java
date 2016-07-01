// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.location.*;
import android.os.Bundle;

//import com.google.android.maps.LatLng;
//import com.google.android.maps.MapController;

import com.google.android.gms.maps.model.LatLng;


import com.indooratlas.mapcreator.main.Sipa;
import com.indooratlas.mapcreator.main.SipaMapView;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient, CLASS167, CLASS113

public class CLASS163
    implements LocationListener
{

    public CLASS163(Sipa sipa)
    {
        MF_CLASS113_a486 = 0.0D;
        MF_CLASS163_b625 = 0.0D;
        MF_CLASS163_f626 = false;
        MF_CLASS163_c627 = false;
        MF_CLASS163_d628 = sipa;
        MF_CLASS113_e490 = new RestClient(sipa, sipa.mCurrentBuilding, sipa.mCookie);
    }

    public void MF_CLASS113_a486()
    {
        onLocationChanged(MF_CLASS163_d628.mlocationManager.getLastKnownLocation("network"));
    }

    public void onLocationChanged(Location location)
    {
        CLASS167.MF_CLASS167_b635("SipaLocationListener", "SipaLocationListener.onLocationChanged() called");
        MF_CLASS163_c627 = true;
        if(location == null)
        {
            CLASS167.MF_CLASS167_b635("SipaLocationListener", "SipaLocationListener.onLocationChanged() location == null, returning.");
            return;
        }
        float af[] = {
            0.0F
        };
        Location.distanceBetween(MF_CLASS113_a486, MF_CLASS163_b625, location.getLatitude(), location.getLongitude(), af);
        CLASS167.MF_CLASS167_b635("SipaLocationListener", (new StringBuilder()).append("onLocationChanged(): distance from last location update = ").append(af[0]).append(" meters").toString());
        MF_CLASS163_d628.loc = location;
        LatLng geopoint = new LatLng((int)(1000000D * location.getLatitude()), (int)(1000000D * location.getLongitude()));
        if(!MF_CLASS163_f626)
            if(CLASS113.isExceptionLogged.booleanValue())
            {
                CLASS167.MF_CLASS167_b635("SipaLocationListener", "onLocationChanged(): current DEBUG BUILD centres on GPS location, like release build!");
//                MF_CLASS163_d628.mapController.animateTo(geopoint);
            } else
            {
//                MF_CLASS163_d628.mapController.animateTo(geopoint);
            }
        if((double)af[0] > CLASS113.MF_CLASS113_e490)
        {
            CLASS167.MF_CLASS167_b635("SipaLocationListener", "SipaLocationListener.onLocationChanged() removing location updates! Using only first update!");
            MF_CLASS163_d628.mlocationManager.removeUpdates(this);
//            LatLng geopoint1 = MF_CLASS163_d628.mMapView.getMapCenter();
            LatLng geopoint1 = MF_CLASS163_d628.mMap.getCameraPosition().target;
            float f = MF_CLASS163_d628.getVisibleRadiusMeters(geopoint1);
            float f1;
            if(f < 5000F)
                f1 = 5000F;
            else
                f1 = f;
            CLASS167.MF_CLASS167_b635("SipaLocationListener", (new StringBuilder()).append("SipaLocationListener.onLocationChanged(): getting buildings with search radius (m): ").append(f1).toString());
            MF_CLASS113_e490.getBuildings((double)geopoint1.latitude / 1000000D, (double)geopoint1.longitude / 1000000D, Float.valueOf(f1).intValue());
        }
        MF_CLASS113_a486 = location.getLatitude();
        MF_CLASS163_b625 = location.getLongitude();
    }

    public void onProviderDisabled(String s)
    {
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    public double MF_CLASS113_a486;
    public double MF_CLASS163_b625;
    public boolean MF_CLASS163_c627;
    private Sipa MF_CLASS163_d628;
    private RestClient MF_CLASS113_e490;
    private boolean MF_CLASS163_f626;
}
