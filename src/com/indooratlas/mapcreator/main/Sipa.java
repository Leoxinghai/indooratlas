// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.*;
import android.content.res.Resources;
import android.location.*;
import android.os.Bundle;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.maps.*;
import com.indooratlas.base.*;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.*;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.types.Some1Base;
import com.indooratlas.types.IndoorAtlas;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.model.LatLng;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS199, CLASS341, CLASS322, SipaMapView,
//            CLASS340, CLASS339, CLASS335, CLASS336,
//            CLASS358, CLASS342, LoginActivity, CLASS324,
//            CLASS326, CLASS325, CLASS337, CLASS332,
//            CLASS331, CLASS330, CLASS333, MapScreen,
//            CLASS338, CLASS321, CLASS327, CLASS329,
//            CLASS328, CLASS353, CLASS323

public class Sipa extends FragmentActivity
    implements android.widget.SearchView.OnQueryTextListener, CLASS3, CLASS199
{

    public Sipa()
    {
        r = null;
        s = null;
        mUser = "";
        mPassword = "";
        mApiKey = "";
        mSecret = "";
        mCookie = null;
        mCurrentScale = 16;
        MF_CLASS179_a653 = null;
        MF_CLASS113_b487 = null;
        MF_CLASS181_c686 = null;
        d = null;
        e = null;
        MF_CLASS113_f491 = null;
        mBuildingLevelFloorplanSelectionOngoing = Boolean.valueOf(false);
        g = 0;
        h = 0L;
        i = 0;
        j = false;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        x = null;
        mCurrentBuilding = null;
        p = new CLASS341(this);
        q = new CLASS322(this);
    }

    private float MF_CLASS179_a653(double d1, double d2, List list)
    {
        float af[] = {
            -1F
        };
        Iterator iterator = list.iterator();
        float f = 3.402823E+038F;
        while(iterator.hasNext())
        {
            double ad[] = (double[])iterator.next();
            Location.distanceBetween(d1, d2, ad[0], ad[1], af);
            float f1;
            if(af[0] < f)
                f1 = af[0];
            else
                f1 = f;
            f = f1;
        }
        return f;
    }

    private Building MF_CLASS179_a653(List list, String s1)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Building class99 = (Building)iterator.next();
            if(class99.getBuildingID().equals(s1))
                return class99;
        }

        return null;
    }

    private CLASS106 MF_CLASS179_a653(String s1)
    {
        List list;
        try {
        CLASS167.MF_CLASS167_b635("Sipa", "calling mGeoCoder.getFromLocationName(name, MAX_RESULT)");
        list = MF_CLASS181_c686.getFromLocationName(s1, 10);
        if(list == null) {
            Toast.makeText(this, getString(0x7f08003e), 1).show();
            Toast.makeText(this, "No search matches were found.", 1).show();
            return null;
        }
        if(list.isEmpty()) {
	        Toast.makeText(this, "No search matches were found.", 1).show();
	        return null;
        }
        CLASS106 class106;
        double d1 = ((Address)list.get(0)).getLatitude();
        double d2 = ((Address)list.get(0)).getLongitude();
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append(" searchFromLocationName: got lat = ").append(d1).append(", lon = ").append(d2).toString());
        class106 = new CLASS106();
        class106.a = d1;
        class106.b = d2;
        return class106;
        } catch(Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
    }

    private void reset()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "reset called");
        setBuildingSelectionOngoing(false);
        mCurrentBuilding = null;
        mCurrentLevelList = null;
        mSelectedLevel = null;
        mSelectedGraphics = null;
    }

    static void MF_CLASS179_a653(Sipa sipa)
    {
        sipa.MF_CLASS181_c686();
    }

    static void MF_CLASS179_a653(Sipa sipa, boolean flag)
    {
        sipa.MF_CLASS179_a653(flag);
    }

    private void MF_CLASS179_a653(boolean flag)
    {
        try
        {
//            if(mCurrentScale >= mMapView.getMaxZoomLevel())
//                break MISSING_BLOCK_LABEL_36;
            mCurrentScale = 1 + mCurrentScale;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return;
        }
//        if(!flag)
//            break MISSING_BLOCK_LABEL_36;
//        mapController.zoomIn();
    }

    private Level MF_CLASS113_b487(List list, String s1)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Level class105 = (Level)iterator.next();
            if(class105.getLevelID().equals(s1))
                return class105;
        }

        return null;
    }

    static RestClient MF_CLASS113_b487(Sipa sipa)
    {
        return sipa.w;
    }

    private void MF_CLASS113_b487()
    {
        Location location = mlocationManager.getLastKnownLocation("gps");
        Location location1 = mlocationManager.getLastKnownLocation("network");
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("setInitialLocation(): locGPS = ").append(location).append(", locNet = ").append(location1).toString());
        if(u.MF_CLASS163_c627)
        {
            CLASS167.MF_CLASS167_b635("Sipa", "setInitialLocation(): location updated already receiced, not setting initial location");
            return;
        }
        if(location != null && location1 != null)
        {
            long l1 = location.getTime();
            long l2 = location1.getTime();
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("gpsTime = ").append(l1).append(", netTime = ").append(l2).toString());
            LatLng geopoint2;
            if(l1 >= l2)
            {
                CLASS167.MF_CLASS167_b635("Sipa", "gpsTime >= netTime");
            } else
            {
                CLASS167.MF_CLASS167_b635("Sipa", "gpsTime < netTime");
                location = location1;
            }
            loc = location;
            geopoint2 = new LatLng((int)(1000000D * loc.getLatitude()), (int)(1000000D * loc.getLongitude()));
//            mapController.animateTo(geopoint2);
        } else
        if(location != null)
        {
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("locGPS != null, locGPS = ").append(location.toString()).toString());
            loc = location;
            LatLng geopoint1 = new LatLng((int)(1000000D * loc.getLatitude()), (int)(1000000D * loc.getLongitude()));
//            mapController.animateTo(geopoint1);
        } else
        if(location1 != null)
        {
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("locNet != null, locNet = ").append(location1.toString()).toString());
            loc = location1;
            LatLng geopoint = new LatLng((int)(1000000D * loc.getLatitude()), (int)(1000000D * loc.getLongitude()));
  //          mapController.animateTo(geopoint);
        } else
        {
            CLASS167.MF_CLASS167_b635("Sipa", "both null, not scrolling anywhere.");
        }
//        mMapView.invalidate();
    }

    static void MF_CLASS113_b487(Sipa sipa, boolean flag)
    {
        sipa.MF_CLASS113_b487(flag);
    }

    private void MF_CLASS113_b487(String s1)
    {
        try
        {
            CLASS75.MF_CLASS75_a259("GraphicsId", s1);
            CLASS75.MF_CLASS75_a259("DeviceModelId", s.MF_CLASS101_a388());
            CLASS75.MF_CLASS75_a259("IDAUUID", CLASS75.createIDAUID(mApiKey, mDevice.MF_CLASS100_b387));
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	return;
        }
    }

    private void MF_CLASS113_b487(boolean flag)
    {
        LatLng geopoint;
        float f;
        try
        {
//            if(mCurrentScale <= 1)
//                break MISSING_BLOCK_LABEL_112;
            mCurrentScale = -1 + mCurrentScale;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return;
        }
//        if(!flag)
//            break MISSING_BLOCK_LABEL_30;
//        mapController.zoomOut();
//        geopoint = mMapView.getMapCenter();
        geopoint = mMap.getCameraPosition().target;

        f = getVisibleRadiusMeters(geopoint);
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Sipa.handleZoomOut() called, fetching buildings with radius (m): ").append(f).toString());
        w.getBuildings((double)geopoint.latitude / 1000000D, (double)geopoint.longitude / 1000000D, (new Float(f)).intValue());
    }

    private CLASS103 MF_CLASS181_c686(List list, String s1)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            CLASS103 class103 = (CLASS103)iterator.next();
            if(class103.MF_CLASS103_a414().equals(s1))
                return class103;
        }

        return null;
    }

    static List MF_CLASS181_c686(Sipa sipa)
    {
        return sipa.r;
    }

    private void MF_CLASS181_c686()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete all local db contents?").setCancelable(false).setPositiveButton("Yes", new CLASS340(this)).setNegativeButton("No", new CLASS339(this));
        builder.create().show();
    }

    static CLASS358 d(Sipa sipa)
    {
        return sipa.t;
    }

    public static void logHeap(Class class1, String s1)
    {
        try
        {
            Double double1 = Double.valueOf((new Double(Debug.getNativeHeapAllocatedSize())).doubleValue() / (new Double(1048576D)).doubleValue());
            Double double2 = Double.valueOf((new Double(Debug.getNativeHeapSize())).doubleValue() / 1048576D);
            Double double3 = Double.valueOf((new Double(Debug.getNativeHeapFreeSize())).doubleValue() / 1048576D);
            DecimalFormat decimalformat = new DecimalFormat();
            decimalformat.setMaximumFractionDigits(2);
            decimalformat.setMinimumFractionDigits(2);
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("debug. ================ ").append(s1).append(" =================").toString());
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("debug.heap native: allocated ").append(decimalformat.format(double1)).append("MB of ").append(decimalformat.format(double2)).append("MB (").append(decimalformat.format(double3)).append("MB free) in [").append(class1.getName().replaceAll("com.myapp.android.", "")).append("]").toString());
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("debug.memory: allocated: ").append(decimalformat.format(new Double(Runtime.getRuntime().totalMemory() / 0x100000L))).append("MB of ").append(decimalformat.format(new Double(Runtime.getRuntime().maxMemory() / 0x100000L))).append("MB (").append(decimalformat.format(new Double(Runtime.getRuntime().freeMemory() / 0x100000L))).append("MB free)").toString());
            System.gc();
            System.gc();
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	return;
        }
    }

    public boolean getBuildingSelectionOngoing()
    {
        return mBuildingLevelFloorplanSelectionOngoing.booleanValue();
    }

    public List getBuildingsWithinVisibleRadius(List list)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        float af[] = {
            -1F
        };
        //LatLng geopoint = mMapView.getMapCenter();
        LatLng geopoint = mMap.getCameraPosition().target;

        return list;
        /*
        float f = getVisibleRadiusMeters(geopoint);
        Iterator iterator = list.iterator();
        for(;iterator.hasNext();) {
            Building class99 = (Building)iterator.next();
            Location.distanceBetween((double)(float)geopoint.latitude / 1000000D, (double)(float)geopoint.longitude / 1000000D, class99.MF_CLASS99_c372().MF_CLASS102_a412(), class99.MF_CLASS99_c372().MF_CLASS102_b413(), af);
            if(af[0] < f)
                arraylist.add(class99);
        }
        
        return arraylist;
        */
    }

    public void getFloorPlanImage()
    {
        try
        {
            showWaitDialog("Loading...");
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("getFloorPlanImage, mSelectedGraphics = ").append(mSelectedGraphics).toString());
            w.getGraphics(mSelectedGraphics.MF_CLASS103_a414());
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public float getVisibleRadiusMeters(LatLng geopoint)
    {
        float f;
        try
        {
            double i1 = geopoint.latitude;
            double j1 = geopoint.longitude;
//            double k1 = mMapView.getLatitudeSpan();
//            double l1 = mMapView.getLongitudeSpan();
            geopoint = mMap.getCameraPosition().target;
            double k1 = geopoint.latitude;
            double l1 = geopoint.longitude;

            double d1 = i1 - k1 / 2;
            double d2 = j1 - l1 / 2;
            double d3 = i1 + k1 / 2;
            double d4 = j1 + l1 / 2;
            float af[] = {
                0.0F
            };
            Location.distanceBetween(d1 / 1000000D, d2 / 1000000D, d3 / 1000000D, d4 / 1000000D, af);
            f = af[0];
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return 1.0F;
        }
        return f;
    }

    public void handlerSensorErrorAndTimetampError(CLASS369 c)
    {
        if(CLASS113.isExceptionLogged.booleanValue())
        {
            CLASS167.MF_CLASS167_b635("Sipa", "notifySensorError() dumping stack");
            Thread.dumpStack();
        }
    }

    public void hideInProgressDialog()
    {
        if(l != null)
        {
            l.cancel();
            l = null;
        }
    }

    public void hideWaitDialog()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "hideWaitDialog() called.");
        try {
        if(v != null)
        {
            v.cancel();
            CLASS167.MF_CLASS167_b635("Sipa", "hideWaitDialog() progressDialog cancelled.");
            v = null;
        }

        return;
        } catch(Exception exception1) {
        	CLASS167.unhandledexception(exception1, getApplicationContext());
        }
    }

    public void initialize()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "initialize called");
        hideWaitDialog();
        if(!MeasurementDataSource.MF_CLASS381_a1107)
            MeasurementDataSource.openDB(getApplicationContext());
        reset();
        MF_CLASS113_b487();
        initiateGetBuildingsRequest();
        CLASS167.MF_CLASS167_b635("Sipa", "initialize(): requesting location updates");
        mlocationManager.requestLocationUpdates("network", 0L, 0.0F, u);
        u.MF_CLASS113_a486();
    }

    public void initiateGetBuildingsRequest()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", "Sipa.initiateGetBuildinsRequest() called, fetching buildings");
//            LatLng geopoint = mMapView.getMapCenter();
//            float f = getVisibleRadiusMeters(geopoint);
  //          CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Sipa.initiateGetBuildinsRequest(): getting buildings with search radius(m): ").append(f).toString());
//            w.MF_CLASS54_a201((double)geopoint.latitude / 1000000D, (double)geopoint.longitude / 1000000D, (new Float(f)).intValue());
            
            Location location = mlocationManager.getLastKnownLocation("gps");
            Location location1 = mlocationManager.getLastKnownLocation("network");

            //LatLng geopoint = mMap.getCameraPosition().target;
            LatLng geopoint = new LatLng(1.336053,103.905661);
            
          float f = getVisibleRadiusMeters(geopoint);
          f = 0.003f;
//          CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Sipa.initiateGetBuildinsRequest(): getting buildings with search radius(m): ").append(f).toString());
          w.getBuildings((double)geopoint.latitude / 1000000D, (double)geopoint.longitude / 1000000D, (new Float(f)).intValue());
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    protected boolean isRouteDisplayed()
    {
        return false;
    }

    public void notifySensorError(int i1,CLASS369 c)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("notifySensorError() called type = ").append(i1).append(", sps = ").append(c).toString());
        showToastMessage("Sensor error.", 0);
        runOnUiThread(new CLASS335(this, c));
    }

    public void notifyTimestampError(CLASS369 c)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("notifyTimestampError() called sps = ").append(c).toString());
        showToastMessage("Sensor timestamp error.", 0);
        runOnUiThread(new CLASS336(this, c));
    }

    public void onCalibrationFailed(String s1)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onCalibrationFailed: reson = ").append(s1).toString());
    }

    public void onCalibrationInvalid()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onCalibrationInvalid().");
    }

    public void onCalibrationReady()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onCalibrationReady() now called when BG calib ready.");
        return;
    }

    public void onCalibrationStatus(Some1Base some1base)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onCalibrationStatus() calibrationState.getCalibrationEvent() = ").append(some1base.getIndoorAction()).append(", calibrationState.getPercentage() = ").append(some1base.actionPercentage()).toString());
    }

    public void onCreate(Bundle bundle)
    {
        try
        {
            super.onCreate(bundle);
            CLASS167.MF_CLASS167_b635("Sipa", " -lifecycle- Sipa.onCreate");

            setContentView(R.layout.main);
            
        	mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
        	mMap.setMyLocationEnabled(true);

            Thread.setDefaultUncaughtExceptionHandler(new CLASS164(this));
            k = this;
            mCookie = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.cookie");
            mUser = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.username");
            mPassword = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.password");
            mApiKey = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.apikey");
            mSecret = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.secret");
            s = (CLASS101)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.devicemodel");
//            mMapView = (SipaMapView)findViewById(0x7f0b0016);
//            mMapView.setEnabled(true);
//            mMapView.setClickable(true);
//            mMapView.setOnPanListener(this);
//            mapController = mMapView.getController();
//            mMapView.setBuiltInZoomControls(true);
//            mMapView.setSatellite(true);
//            mapController.setZoom(14);
            mCurrentScale = 14;
            mlocationManager = (LocationManager)getSystemService("location");
            u = new CLASS163(this);
            android.graphics.drawable.Drawable drawable = getResources().getDrawable(0x7f02002f);
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onCreate: got drawable = ").append(drawable).toString());
            t = new CLASS358(drawable, this, this);
//            mMapView.getOverlays().add(t);
            w = new RestClient(this, mCurrentBuilding, mCookie);
            TelephonyManager telephonymanager = (TelephonyManager)getBaseContext().getSystemService("phone");
            mDevice = new CLASS100();
            mDevice.MF_CLASS100_b387 = telephonymanager.getDeviceId();
            if(!Geocoder.isPresent())
            {
                Toast.makeText(this, getString(0x7f08003e), 1).show();
                return;
            }
        }
        catch(Exception exception)
        {
            showInformationDialogWhichClosesActivity("Error in opening world map view, please retry.");
            CLASS167.unhandledexception(exception, getApplicationContext());
            return;
        }
        MF_CLASS181_c686 = new Geocoder(this);
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0a0001, menu);
        MF_CLASS113_b487 = menu.findItem(0x7f0b0032);
        MF_CLASS179_a653 = (SearchView)MF_CLASS113_b487.getActionView();
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onCreateOptionsMenu(): mSearchMapView = ").append(MF_CLASS179_a653).toString());
        MF_CLASS179_a653.setOnQueryTextListener(this);
        if(!CLASS113.isDeviceChecked.booleanValue()) {
            try
            {
                k.invalidateOptionsMenu();
            }
            catch(Exception exception)
            {
                CLASS167.unhandledexception(exception, getApplicationContext());
                return true;
            }
            return true;

        }
        e = menu.findItem(0x7f0b0031);
        e.setVisible(true);
        d = (SearchView)e.getActionView();
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onCreateOptionsMenu(): mBuildingFilter = ").append(d).toString());
        MF_CLASS113_f491 = new CLASS342(this);
        d.setOnQueryTextListener(MF_CLASS113_f491);
        return true;
    }

    public void onDestroy()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", " -lifecycle- Sipa.onDestroy");
            super.onDestroy();
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public void onInitializationFailed(String s1)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onInitializationFailed: reason = ").append(s1).toString());
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        long l1;
        long l2;
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onKeyDown():").append(keyevent.toString()).toString());
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onKeyDown():  keyCode = ").append(i1).toString());
            CLASS167.MF_CLASS167_b635("Sipa", "onKeyDown():  KeyEvent.KEYCODE_VOLUME_DOWN =  25");
            CLASS167.MF_CLASS167_b635("Sipa", "onKeyDown():  KeyEvent.KEYCODE_VOLUME_UP =  24");
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return true;
        }
        if(i1 != 4) {
                if(i1 != 25 && i1 != 24)
                	return true;
        } else {
	        CLASS167.MF_CLASS167_b635("Sipa", "onKeyDown(): keyCode == KeyEvent.KEYCODE_BACK: closing Sipa Activity, returning true, --> starting LoginActivity");
	        Intent intent = new Intent(k.getApplicationContext(), LoginActivity.class);
	        intent.setFlags(0x4000000);
	        intent.setFlags(0x10000000);
	        k.getApplicationContext().startActivity(intent);
	        CLASS167.MF_CLASS167_b635("Sipa", "onKeyDown(): started LoginActivity, finish self.");
	        k.finish();
	        return true;
        }

        CLASS167.MF_CLASS167_b635("Sipa", "onKeyDown(): keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP");
        l1 = System.currentTimeMillis();
        l2 = l1 - h;
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Volume-key click-sequence detection: elapsed = ").append(l2).append(", mDevOptionKeyCnt = ").append(g).append(", mLastVolumeKey = ").append(i).toString());
        if(g != 0) {
            if(l2 >= 2000L || g >= 2) {
                if(l1 - h >= 2000L || g != 2) {
                    CLASS167.MF_CLASS167_b635("Sipa", "Volume-key click-sequence detection: cancel the sequence 2");
                    g = 0;
                    h = 0L;
                    i = 0;
                    return true;
                }
                CLASS167.MF_CLASS167_b635("Sipa", "Volume-key click-sequence detection: DONE!");
                if(CLASS113.isDeviceChecked.booleanValue())
                    showDeveloperMenuDialog();
                g = 0;
                h = 0L;
                i = 0;
                return true;
            }

            CLASS167.MF_CLASS167_b635("Sipa", "Volume-key click-sequence detection: curTime - mDevOptionKeySequenceStartTime  < 2000 && mDevOptionKeyCnt < 3");
            if(i1 != 25 || i != 24) {
                if(i1 != 24 || i != 25) {
                    CLASS167.MF_CLASS167_b635("Sipa", "Volume-key click-sequence detection: cancel the sequence 1");
                    g = 0;
                    h = 0L;
                    i = 0;
                    return true;
                }
                CLASS167.MF_CLASS167_b635("Sipa", "keyCode == KeyEvent.KEYCODE_VOLUME_UP && mLastVolumeKey == KeyEvent.KEYCODE_VOLUME_DOWN");
                g = 1 + g;
                i = i1;
                return true;
            }

            CLASS167.MF_CLASS167_b635("Sipa", "keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && mLastVolumeKey == KeyEvent.KEYCODE_VOLUME_UP");
            g = 1 + g;
            i = i1;
            return true;


        }
        CLASS167.MF_CLASS167_b635("Sipa", "Volume-key click-sequence detection: mDevOptionKeyCnt == 0");
        h = l1;
        g = 1 + g;
        i = i1;
        return true;

    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onKeyUp():").append(keyevent.toString()).toString());
        if(i1 == 25 || i1 == 24) {
	        CLASS167.MF_CLASS167_b635("Sipa", "onKeyUp(): keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP");
	        return true;
        }

        if(i1 == 82) {
	        CLASS167.MF_CLASS167_b635("Sipa", "onKeyUp(): keyCode == KeyEvent.KEYCODE_MENU: , returning false");
	        return false;
        }

        return true;
    }

    public void onNetworkChangeComplete(boolean flag)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onCalibrationRequired");
    }

    public void onPan()
    {
        LatLng geopoint;
        float af[];
        CLASS167.MF_CLASS167_b635("Sipa", "Sipa.onPan() called, fetching buildings");
//        geopoint = mMapView.getMapCenter();
        geopoint = mMap.getCameraPosition().target;

        if(m != null) {
	        double d1 = (double)geopoint.latitude / 1000000D;
	        double d2 = (double)geopoint.longitude / 1000000D;
	        double d3 = (double)m.latitude / 1000000D;
	        double d4 = (double)m.longitude / 1000000D;
	        af = (new float[] {
	            0.0F
	        });
	        Location.distanceBetween(d1, d2, d3, d4, af);
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onPan(): distance from last map center = ").append(af[0]).append(" meters, lat1 = ").append(d1).append(", lon1 = ").append(d2).append(", lat2 = ").append(d3).append(", lon2 = ").append(d4).toString());
	        if(af[0] <= 500F) {
	            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onPan(): distance from last map center = ").append(af[0]).append(" *NOT* initiating buildings request").toString());
	        } else {
		        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onPan(): distance from last map center = ").append(af[0]).append(" initiating buildings request").toString());
		        initiateGetBuildingsRequest();
	        }
        }
        m = geopoint;

        return;
        /*
        Exception exception1;
        exception1;
        CLASS167.unhandledexception(exception1, getApplicationContext());
          goto _L4
        Exception exception;
        exception;
        throw exception;
        CLASS167.MF_CLASS167_b635("Sipa", "onPan(): mLastBuildingsQueryMapCenter == null, initiating buildings-request");
        initiateGetBuildingsRequest();
        m = geopoint;
          goto _L4
          */
    }

    public void onPause()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", " -lifecycle- Sipa.onPause");
            super.onPause();
            mlocationManager.removeUpdates(u);
            if(w != null)
                w.MF_CLASS54_a201(true);
            if(MF_CLASS113_b487 != null)
            {
                MF_CLASS113_b487.collapseActionView();
                if(MF_CLASS179_a653 != null)
                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(MF_CLASS179_a653.getWindowToken(), 0);
            }
            if(e != null)
            {
                e.collapseActionView();
                if(d != null)
                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(d.getWindowToken(), 0);
            }
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        int i1 = menu.size();
        for(int j1 = 0; j1 < i1; j1++)
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onPrepareOptionsMenu(): menu item ").append(menu.getItem(j1)).toString());

        if(!CLASS113.isDeviceChecked.booleanValue())
        {
            CLASS167.MF_CLASS167_b635("Sipa", "onPrepareOptionsMenu(): removing item");
            MenuItem menuitem = menu.findItem(0x7f0b0031);
            menuitem.setEnabled(false);
            menuitem.setVisible(false);
            menuitem.setTitle("");
            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onPrepareOptionsMenu(): removed item : ").append(menuitem).toString());
        }
        return true;
    }

    public boolean onQueryTextChange(String s1)
    {
        return false;
    }

    public boolean onQueryTextSubmit(String s1)
    {
        CLASS106 class106;
        if(MF_CLASS181_c686 == null) {
            Toast.makeText(this, (new StringBuilder()).append("No results for query :").append(s1).toString(), 0).show();
            return true;
        }
        class106 = MF_CLASS179_a653(s1);
        if(class106 != null)
        {
            try
            {
                MF_CLASS113_b487.collapseActionView();
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(MF_CLASS179_a653.getWindowToken(), 0);
                LatLng geopoint = new LatLng((int)(1000000D * class106.a), (int)(1000000D * class106.b));
//                mapController.animateTo(geopoint);
//                mapController.setZoom(16);
            }
            catch(Exception exception)
            {
                CLASS167.unhandledexception(exception, getApplicationContext());
                return true;
            }
            return true;
        }
        Toast.makeText(this, getString(0x7f08003e), 0).show();
        return true;
    }

    protected void onRestart()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", " -lifecycle- Sipa.onRestart");
            super.onRestart();
            mlocationManager.requestLocationUpdates("network", 0L, 0.0F, u);
            mlocationManager.requestLocationUpdates("gps", 0L, 0.0F, u);
            if(w != null)
            {
                w.MF_CLASS54_a201(false);
                w.MF_CLASS108_c449 = false;
            }
            reset();
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public void onResume()
    {
        CLASS167.MF_CLASS167_b635("Sipa", " -lifecycle- Sipa.onResume");
        super.onResume();
//        Exception exception1;
        Iterator iterator;
        java.util.Map.Entry entry;
        try
        {
            CLASS167.MF_CLASS167_b635("Sipa", "--state-- onResume : creating API instance with empty apikey and secret");
            x = IndoorAtlasFactory.createIndoorAtlas(getApplicationContext(), this, mApiKey, mSecret);
            CLASS167.MF_CLASS167_b635("Sipa", "--state-- onResume : created API instance with empty apikey and secret");
            CLASS75.MF_CLASS75_a259(4, "API_CREATION_OK", Sipa.class, "onCreate");
        initialize();
        reset();
        if(w != null)
        {
            w.MF_CLASS54_a201(false);
            w.MF_CLASS108_c449 = false;
        }
        for(iterator = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getAll().entrySet().iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("--state-- onResume: PREF : ").append((String)entry.getKey()).append(": ").append(entry.getValue().toString()).toString()))
            entry = (java.util.Map.Entry)iterator.next();

        if(j) {
            j = false;
            w = new RestClient(this, mCurrentBuilding, mCookie);
            return;
        } else
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        	CLASS167.MF_CLASS167_b635("Sipa", "--state-- onResume : API creation failed as expected. BG calib is running anyway.");
        }

//        exception1;
//        showInformationDialogWhichClosesActivity("Error in opening world map view, please retry.");
    }

    public void onServiceFailure(int i1, String s1)
    {
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("onServiceFailure: code: ").append(i1).append(", reason = ").append(s1).toString());
    }

    public void onServiceInitialized()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onServiceInitialized");
    }

    public void onServiceInitializing()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onServiceInitializing");
    }

    public void onServiceStopped()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onServiceStopped");
    }

    public void onServiceUpdate(CLASS6 class6)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "onServiceUpdate");
    }

    public void onStop()
    {
        CLASS167.MF_CLASS167_b635("Sipa", " -lifecycle- Sipa.onStop");
        super.onStop();
    }

    public void onZoomIn()
    {
        try
        {
            MF_CLASS179_a653(false);
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public void onZoomOut()
    {
        try
        {
            m = null;
            MF_CLASS113_b487(false);
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public void setBuildingSelectionOngoing(boolean flag)
    {
        mBuildingLevelFloorplanSelectionOngoing = Boolean.valueOf(flag);
    }

    public void showBuildingSelectionDialog(List list)
    {
        ArrayList arraylist;
        hideWaitDialog();
        if(o != null)
            o.cancel();
        arraylist = new ArrayList(list);
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showBuildingSelectionDialog : buildings2 = ").append(arraylist).toString());
        if(list != null) {
	        CharSequence acharsequence[];
	        Collections.sort(arraylist, new CLASS324(this));
	        acharsequence = new CharSequence[arraylist.size()];
	        int i1 = 0;

	        for(;i1 < acharsequence.length;i1++) {
	        Building class99;
	        String s1;
	        class99 = (Building)arraylist.get(i1);
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showBuildingSelectionDialog : b = ").append(class99).toString());
	        s1 = class99.MF_CLASS99_b371();
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showBuildingSelectionDialog : levName = ").append(s1).toString());
	        String s2 ="";
	        if(s1 == null)
	            s2 = class99.getBuildingID();
	        if(class99.MF_CLASS99_b371().length() != 0) {
	            s2 = s1;
	        }

	        acharsequence[i1] = new String(s2);
	        }

	        CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() created level name array.");
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() calling builder.setTitle.");
	        builder.setTitle("Buildings");
	        builder.setItems(acharsequence, new showBuildingSelectionDialog(this, arraylist)).setNegativeButton("Cancel", new CLASS325(this));
	        o = builder.create();
	        o.setCanceledOnTouchOutside(true);
	        o.setCancelable(true);
	        CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() calling alert.show().");
	        o.show();
	        setBuildingSelectionOngoing(true);
        } else {
                setBuildingSelectionOngoing(false);
                showToastMessage("No buildings found on your account.", 0);
        }
        CLASS167.MF_CLASS167_b635("Sipa", "showBuildingSelectionDialog() returning.");
        return;
    }

    public void showDeveloperMenuDialog()
    {
        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() called.");
        CharSequence acharsequence[] = {
            "Settings", "Dump DB", "Delete DB", "Show sensors", "Show platform", "Check raw mgn sensor"
        };
        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() created menu item array.");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() calling builder.setTitle.");
        builder.setTitle("Extra menu");
        builder.setItems(acharsequence, new CLASS337(this)).setNegativeButton("Cancel", new CLASS332(this));
        AlertDialog alertdialog = builder.create();
        alertdialog.setCanceledOnTouchOutside(false);
        alertdialog.setCancelable(false);
        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() calling alert.show().");
        alertdialog.show();
        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() returning.");
        return;
    }

    public void showFloorplanImageSelectionDialog(List list)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "showFloorplanImageSelectionDialog : called.");
        hideWaitDialog();
        if(CLASS113.MF_CLASS113_f491.booleanValue()) {
	        CLASS167.MF_CLASS167_b635("Sipa", "showFloorplanImageSelectionDialog() called, FAST_DEBUG *ON*");
	        mSelectedGraphics = MF_CLASS181_c686(list, "22d9b73c-03fe-449c-ba12-f09c06b02381".toLowerCase());
	        getFloorPlanImage();
	        return;
        }
        if(list.size() != 1) {
            CharSequence acharsequence[] = new CharSequence[list.size()];
            int i1 = 0;
            String s1;
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);

            for(;i1 < acharsequence.length;) {
    	        acharsequence[i1] = ((CLASS103)list.get(i1)).MF_CLASS103_b415();
    	        if(acharsequence[i1] == null) {
    		        s1 = mSelectedLevel.MF_CLASS105_b433();
    		        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showFloorplanImageSelectionDialog : levName = ").append(s1).toString());
    		        if(s1 != null) {
    		            if(list.size() == 0) {
    		    	        showToastMessage(getString(0x7f080044), 1);
    		    	        setBuildingSelectionOngoing(false);
        		            return;
    		            }
    		        }
    		        s1 = (new Integer(mSelectedLevel.MF_CLASS105_c434())).toString();
    		        acharsequence[i1] = (new StringBuilder()).append("Level:").append(s1).append(", ").append(Integer.toString(i1 + 1)).toString();
    	        }
            }


            builder.setTitle(getString(0x7f080043).toUpperCase(Locale.US));
            builder.setItems(acharsequence, new CLASS331(this, list)).setNegativeButton("Cancel", new CLASS330(this));
            AlertDialog alertdialog = builder.create();
            alertdialog.setCanceledOnTouchOutside(false);
            alertdialog.setCancelable(false);
            alertdialog.show();
            return;

        }
        mSelectedGraphics = (CLASS103)list.get(0);
        getFloorPlanImage();
        return;
    }

    public void showInProgressDialog(String s1)
    {
        if(l != null)
            hideInProgressDialog();
        l = new ProgressDialog(this);
        l.setCancelable(false);
        l.setProgressStyle(0);
        l.setMessage(s1);
        l.setCanceledOnTouchOutside(false);
        l.setOnKeyListener(new CLASS333(this));
        CLASS167.MF_CLASS167_b635("Sipa", " showInProgressDialog : calling this.inProgressDialog.show()");
        l.show();
    }

    public void showIndoorMapView(CLASS103 class103)
    {

        mlocationManager.removeUpdates(u);
        CLASS167.MF_CLASS167_b635("Sipa", " showMapView(): starting MapScreen activity");
        Intent intent = new Intent(this, MapScreen.class);
        intent.putExtra("com.indooratlas.mapcreator.main.currentBuilding", mCurrentBuilding);
        intent.putExtra("com.indooratlas.mapcreator.main.currentBuilding.selectedFloorplan", class103);
        intent.putExtra("com.indooratlas.mapcreator.main.mDevice", mDevice);
        intent.putExtra("com.indooratlas.mapcreator.main.currentBuilding.selectedLevel", mSelectedLevel);
        intent.putExtra("com.indooratlas.mapcreator.main.cookie", mCookie);
        intent.putExtra("com.indooratlas.mapcreator.main.username", mUser);
        intent.putExtra("com.indooratlas.mapcreator.main.password", mPassword);
        intent.putExtra("com.indooratlas.mapcreator.main.apikey", mApiKey);
        intent.putExtra("com.indooratlas.mapcreator.main.secret", mSecret);
        intent.putExtra("com.indooratlas.mapcreator.main.devicemodel", s);
        hideWaitDialog();
        startActivity(intent);
        setBuildingSelectionOngoing(false);
        MF_CLASS113_b487(class103.MF_CLASS103_a414());
        return;
    }

    public void showInformationDialog(String s1)
    {
        if(n != null)
            n.cancel();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS338(this));
        n = builder.create();
        n.show();
    }

    public void showInformationDialogWhichClosesActivity(String s1)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS321(this));
        builder.create().show();
    }

    public void showLevelSelectionDialog()
    {
        hideWaitDialog();
        if(CLASS113.MF_CLASS113_f491.booleanValue()) {
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showLevelSelectionDialog() called, FAST_DEBUG *ON*, mRestClient = ").append(w).append(", mCurrentBuilding = ").append(mCurrentBuilding).toString());
	        mSelectedLevel = MF_CLASS113_b487(mCurrentLevelList, "f5816295-cd4f-49f7-b035-00ef238d0545");
	        w.Floorplans("f5816295-cd4f-49f7-b035-00ef238d0545");
	        return;
        }
        ArrayList arraylist;
        arraylist = new ArrayList(mCurrentLevelList);
        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showLevelSelectionDialog : levels = ").append(arraylist).toString());
        if(arraylist != null) {
	        CharSequence acharsequence[];
	        Collections.sort(arraylist, new CLASS327(this));
	        acharsequence = new CharSequence[arraylist.size()];
	        int i1 = 0;

	        for(;i1 < acharsequence.length;i1++) {
		        Level class105;
		        String s1;
		        class105 = (Level)arraylist.get(i1);
		        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showLevelSelectionDialog : lev = ").append(class105).toString());
		        s1 = class105.MF_CLASS105_b433();
		        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showLevelSelectionDialog : levName = ").append(s1).toString());
		        String s2;
		        if(s1 != null) {
		            s2 = s1;
		        } else {
		        	s2 = (new Integer(class105.MF_CLASS105_c434())).toString();
		        }
		        acharsequence[i1] = new String(s2);
	        }

	        CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() created level name array.");
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() calling builder.setTitle.");
	        builder.setTitle(mCurrentBuilding.MF_CLASS99_b371().toUpperCase(Locale.US));
	        builder.setItems(acharsequence, new CLASS329(this, arraylist)).setNegativeButton("Cancel", new CLASS328(this));
	        AlertDialog alertdialog = builder.create();
	        alertdialog.setCanceledOnTouchOutside(false);
	        alertdialog.setCancelable(false);
	        CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() calling alert.show().");
	        alertdialog.show();
        } else {
            setBuildingSelectionOngoing(false);
            showToastMessage("No levels specified for the selected building.", 0);
        }

        CLASS167.MF_CLASS167_b635("Sipa", "showLevelSelectionDialog() returning.");
        return;

    }

    public void showToastMessage(String s1, int i1)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "showToastMessage called");
        Toast.makeText(this, s1, i1).show();
        CLASS167.MF_CLASS167_b635("Sipa", "showToastMessage done");
    }

    public void showWaitDialog(String s1)
    {
        v = new ProgressDialog(this);
        v.setCancelable(false);
        v.setProgressStyle(0);
        v.setMessage(s1);
        v.show();
        return;
    }

    public void updateBuildingList(List list)
    {
        if(list == null || list.size() == 0) {
	        showInformationDialog("No buildings found. Please use the Floor Plans tool on My Account at www.indooratlas.com to add buildings on your account.");
	        return;
        }

        try {
	        ArrayList arraylist;
	        List list1;
	        arraylist = new ArrayList();
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Sipa.updateBuildingList() called: buildings.size = ").append(list.size()).toString());
	        list1 = getBuildingsWithinVisibleRadius(list);
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Sipa.updateBuildingList() called: Visible buildings list2.size = ").append(list1.size()).toString());
	        r = list1;
	        if(!CLASS113.MF_CLASS113_f491.booleanValue() || mCurrentBuilding != null) {
	            Iterator iterator;
//	            t.MF_CLASS353_b954();
	            iterator = list1.iterator();

	            Building class99;
	            float f;

	            for(;iterator.hasNext();)  {
	    	        class99 = (Building)iterator.next();
	    	        double ad[] = new double[2];
	    	        ad[0] = class99.MF_CLASS99_c372().MF_CLASS102_a412();
	    	        ad[1] = class99.MF_CLASS99_c372().MF_CLASS102_b413();
	    	        f = MF_CLASS179_a653(ad[0], ad[1], arraylist);
	    	        arraylist.add(ad);
	    	        char c;
	    	        if(f > 5F) {
	    	            c = '\0';
	    	        } else {
	    		        CLASS167.MF_CLASS167_b635("Sipa", "updateBuildingList: overlapping building found --> adding to latitude");
	    		        c = '\u03E8';
	    	        }

	    	        CLASS353 class353 = new CLASS353(new LatLng(c + (int)(1000000D * class99.MF_CLASS99_c372().MF_CLASS102_a412()), (int)(1000000D * class99.MF_CLASS99_c372().MF_CLASS102_b413())), this, class99);
//	    	        t.MF_CLASS353_a955(class353);
	            }

	            t.MF_CLASS353_a955();
//	            mMapView.invalidate();
	            if(list1.size() == 0)
	                runOnUiThread(new CLASS323(this));
	            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("End of Sipa.updateList()buildings.size = ").append(list1.size()).toString());

	            showBuildingSelectionDialog(list1);
	            return;

	        }

	        mCurrentBuilding = MF_CLASS179_a653(list1, "53f73a31-5903-4f2e-b11d-a527c1eb862a");
	        w.setBuilding(mCurrentBuilding);
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("updateBuildingList() called, FAST_DEBUG *ON*, set mCurrentBuilding = ").append(mCurrentBuilding).toString());
	        w.getLevels("53f73a31-5903-4f2e-b11d-a527c1eb862a");
	        return;

        } catch(Exception exception1) {
        	exception1.printStackTrace();
	        CLASS167.unhandledexception(exception1, getApplicationContext());
	        return;
        }

    }

    public void updateInProgressDialog(String s1)
    {
        l.setMessage(s1);
    }

    public static final String TAG = "Sipa";
    SearchView MF_CLASS179_a653;
    MenuItem MF_CLASS113_b487;
    Geocoder MF_CLASS181_c686;
    SearchView d;
    MenuItem e;
    CLASS342 MF_CLASS113_f491;
    int g;
    long h;
    int i;
    boolean j;
    Sipa k;
    ProgressDialog l;
    public Location loc;
    LatLng m;
    public String mApiKey;
    public Boolean mBuildingLevelFloorplanSelectionOngoing;
    public String mCookie;
    public Building mCurrentBuilding;
    public List mCurrentLevelList;
    public int mCurrentScale;
    public CLASS100 mDevice;
    public SipaMapView mMapView;
    public String mPassword;
    public String mSecret;
    public CLASS103 mSelectedGraphics;
    public Level mSelectedLevel;
    public String mUser;
//    public MapController mapController;
    public LocationManager mlocationManager;
    AlertDialog n;
    AlertDialog o;
    android.view.View.OnClickListener p;
    android.view.View.OnClickListener q;
    private List r;
    private CLASS101 s;
    public CLASS353 selectedMapImage;
    private CLASS358 t;
    private CLASS163 u;
    private ProgressDialog v;
    private RestClient w;
    private IndoorAtlas x;

    public GoogleMap mMap;

}
