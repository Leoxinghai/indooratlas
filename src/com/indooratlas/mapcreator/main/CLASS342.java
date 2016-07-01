// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

//import com.google.android.maps.LatLng;

import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.CLASS102;
import com.indooratlas.mapcreator.data.Building;
import java.util.*;

import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa, CLASS358, CLASS353, SipaMapView,
//            CLASS343

class CLASS342
    implements android.widget.SearchView.OnQueryTextListener
{

    CLASS342(Sipa sipa)
    {
        MF_CLASS342_a938 = sipa;

    }

    public boolean onQueryTextChange(String s)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onQueryTextChange() Building filter called");
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onQueryTextSubmit() Building filter called");
        if(Sipa.MF_CLASS181_c686(MF_CLASS342_a938) == null || Sipa.d(MF_CLASS342_a938) == null)
        {
            CLASS167.MF_CLASS167_b635("Sipa", "onQueryTextSubmit() Building filter skipped, mBuildings or overlay list null");
            return true;
        }
//        Sipa.d(MF_CLASS342_a938).MF_CLASS353_b954();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = Sipa.MF_CLASS181_c686(MF_CLASS342_a938).iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Building class99_1 = (Building)iterator.next();
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onQueryTextSubmit() Building filter : ").append(class99_1.MF_CLASS99_b371()).append(" : filter : ").append(s).toString());
            if(class99_1.MF_CLASS99_b371().toLowerCase().contains(s.toLowerCase()))
            {
                CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onQueryTextSubmit()  Building passed filter : ").append(class99_1.MF_CLASS99_b371()).toString());
                arraylist.add(class99_1);
            }
        } while(true);
        Building class99;
        for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onQueryTextSubmit()  plot building: ").append(class99.MF_CLASS99_b371()).append(" : ").append("lat = ").append(class99.MF_CLASS99_c372().MF_CLASS102_a412()).append(", lon = ").append(class99.MF_CLASS99_c372().MF_CLASS102_b413()).toString()))
        {
            class99 = (Building)iterator1.next();
            CLASS353 class353 = new CLASS353(new LatLng((int)(1000000D * class99.MF_CLASS99_c372().MF_CLASS102_a412()), (int)(1000000D * class99.MF_CLASS99_c372().MF_CLASS102_b413())), MF_CLASS342_a938.k, class99);
//            Sipa.d(MF_CLASS342_a938).MF_CLASS353_a955(class353);
        }

        Sipa.d(MF_CLASS342_a938).MF_CLASS353_a955();
        MF_CLASS342_a938.mMapView.invalidate();
        if(arraylist.size() == 0)
            MF_CLASS342_a938.k.runOnUiThread(new CLASS343(this));
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("End of Sipa.updateList() filteredBuildings.size = ").append(arraylist.size()).toString());
        return true;
    }

    final Sipa MF_CLASS342_a938;
}
