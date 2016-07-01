// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.*;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import com.indooratlas.Calibrator.*;
import com.indooratlas.base.*;
import com.indooratlas.cursor.list.CLASS22;
import com.indooratlas.cursor.list.CLASS24;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.CLASS101;
import com.indooratlas.position.CLASS68;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.CLASS370;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.sensor.SensorReader;
import com.indooratlas.sensor.type.CLASS48;
import com.indooratlas.task.CLASS41;
import com.indooratlas.types.Some1Base;
import com.indooratlas.types.IndoorAtlas;
import com.indooratlas.communication.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.concurrent.*;
import java.util.*;
import java.util.zip.GZIPOutputStream;
import org.apache.http.cookie.Cookie;
import org.slf4j.MDC;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS194, CLASS195, CLASS196, CLASS223,
//            CLASS216, CLASS218, CLASS219, CLASS220,
//            CLASS224, CLASS200, CLASS202, CLASS215,
//            CLASS211, CLASS221, CalibrationDialogFragment, Sipa,
//            CLASS346, CLASS208, CLASS209, CLASS210,
//            CLASS213, CLASS214, CLASS222, CLASS203,
//            CLASS201, CLASS212, CLASS204, CLASS205,
//            CLASS206, CLASS207

public class LoginActivity extends Activity
    implements CLASS3, IBGCalibration, CLASS194, CLASS195, CLASS196, CLASS48
{

    public LoginActivity()
    {
        f = null;
        MF_CLASS22_g77 = "";
        h = "";
        i = null;
        j = false;
        k = null;
        l = null;
        m = null;
        n = 0;
        r = null;
        t = 0.0F;
        o = null;
        u = false;
        p = null;
        B = false;
        C = null;
        D = false;
        q = false;
        E = null;
        F = null;
    }

    private void A()
    {
        MF_CLASS19_b68.setClickable(false);
        MF_CLASS19_c69.setClickable(false);
        MF_CLASS19_e71.setClickable(false);
    }

    private void B()
    {
        MF_CLASS19_b68.setClickable(true);
        MF_CLASS19_c69.setClickable(true);
        MF_CLASS19_e71.setClickable(true);
    }

    private boolean C()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "isBGCalibViewVisible()");
        return y != null;
    }

    private void cancelCalibration()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "cancelCalibration called.");
        u = false;
        i();
        if(mSensorReader != null)
        	mSensorReader.stopCalibration();
        mSensorReader = null;
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "cancelCalibration done.");
    }

    private void E()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "markFirstUsageCalibrationReady called.");
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(f.getApplicationContext()).edit();
        editor.putString("first_usage_calib_done", "yes");
        boolean flag = editor.commit();
        String s1 = PreferenceManager.getDefaultSharedPreferences(f.getApplicationContext()).getString("first_usage_calib_done", "");
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("markFirstUsageCalibrationReady done, writtenPersistently = ").append(flag).append(", prefs.getString() = ").append(s1).toString());
        java.util.Map.Entry entry;
        for(Iterator iterator = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getAll().entrySet().iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("markFirstUsageCalibrationReady: PREF : ").append((String)entry.getKey()).append(": ").append(entry.getValue().toString()).toString()))
            entry = (java.util.Map.Entry)iterator.next();

    }

    static float MF_CLASS19_a67(LoginActivity loginactivity, float f1)
    {
        loginactivity.t = f1;
        return f1;
    }

    static CLASS101 MF_CLASS19_a67(LoginActivity loginactivity, CLASS101 class101)
    {
        loginactivity.r = class101;
        return class101;
    }

    static void MF_CLASS19_a67(LoginActivity loginactivity)
    {
        loginactivity.startLogin();
    }

    static void MF_CLASS19_a67(LoginActivity loginactivity, CLASS370 class370, CLASS24 class24)
    {
        loginactivity.MF_CLASS19_a67(class370, class24);
    }

    static void MF_CLASS19_a67(LoginActivity loginactivity, String s1)
    {
        loginactivity.MF_CLASS19_c69(s1);
    }

    private void MF_CLASS19_a67(CLASS370 class370, CLASS24 class24)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "storeCalibrationSet:  storing calibration to DB");
        CLASS370 class370_1 = MeasurementDataSource.storeCalibrationSet(class370);
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "storeCalibrationSet:  storing calibration to file");
        if(class24.magnetometerSamples != null && class24.gyroscopeSamples != null && class24.accelerometerSamples != null)
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("storeCalibrationSet: gyro size : ").append(class24.gyroscopeSamples.size()).toString());
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("storeCalibrationSet: acc size : ").append(class24.accelerometerSamples.size()).toString());
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("storeCalibrationSet: mgn size : ").append(class24.magnetometerSamples.size()).toString());
            long l1 = ((CLASS22)class24.magnetometerSamples.get(-1 + class24.magnetometerSamples.size())).timeStamp - ((CLASS22)class24.magnetometerSamples.get(0)).timeStamp;
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("storeCalibrationSet:  mgn data dur = ").append((double)l1 / 1000000000D).toString());
        }
        ConcurrentLinkedQueue concurrentlinkedqueue = CLASS68.MF_CLASS27_d107(class24.gyroscopeSamples);
        ConcurrentLinkedQueue concurrentlinkedqueue1 = CLASS68.MF_CLASS27_d107(class24.accelerometerSamples);
        ConcurrentLinkedQueue concurrentlinkedqueue2 = CLASS68.MF_CLASS27_d107(class24.magnetometerSamples);
        MeasurementDataSource.storeGyroSensorData(concurrentlinkedqueue, class370_1.mMeasurementID, true);
        MeasurementDataSource.storeAccSensorData(concurrentlinkedqueue1, class370_1.mMeasurementID, true);
        MeasurementDataSource.storeMgnSensorData(concurrentlinkedqueue2, class370_1.mMeasurementID, true);
        MF_CLASS19_a67(class370_1);
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "storeCalibrationSet:  storing calibration to DB");
    }

    static boolean MF_CLASS19_a67(LoginActivity loginactivity, boolean flag)
    {
        loginactivity.D = flag;
        return flag;
    }

    static CLASS101 MF_CLASS19_b68(LoginActivity loginactivity)
    {
        return loginactivity.r;
    }

    static void startSipa(LoginActivity loginactivity)
    {
        loginactivity.startWorldMapView();
    }

    private void MF_CLASS19_c69(String s1)
    {
        try {
	    	CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "setupLogging called.");
	        String s2 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
	        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("setupLogging : versionName = ").append(s2).toString());
	        CLASS75.MF_CLASS75_a259("UserName", s1);
	        CLASS75.MF_CLASS75_a259("MCVersion", s2);
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }
    }

    static void MF_CLASS19_d70(LoginActivity loginactivity)
    {
        loginactivity.v();
    }

    static void MF_CLASS19_e71(LoginActivity loginactivity)
    {
        loginactivity.y();
    }

    static void f(LoginActivity loginactivity)
    {
        loginactivity.z();
    }

    static CLASS370 MF_CLASS22_g77(LoginActivity loginactivity)
    {
        return loginactivity.E;
    }

    static CLASS24 h(LoginActivity loginactivity)
    {
        return loginactivity.F;
    }

    static void startMapCreator_i(LoginActivity loginactivity)
    {
        loginactivity.startMapCreator();
    }

    static void j(LoginActivity loginactivity)
    {
        loginactivity.p();
    }

    static CLASS200 k(LoginActivity loginactivity)
    {
        return loginactivity.y;
    }

    static void l(LoginActivity loginactivity)
    {
        loginactivity.showLoginView();
    }

    static float m(LoginActivity loginactivity)
    {
        return loginactivity.t;
    }

    static CalibrationDialogFragment n(LoginActivity loginactivity)
    {
        return loginactivity.z;
    }

    private void startLogin()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startLogin()");
        D = false;
        q = false;
        i = null;
        j = false;
        k = null;
        l = null;
        m = null;
        if(MF_CLASS19_e71())
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--setOnClickListener--  Network connection exists.");
            MF_CLASS19_d70.setText("");
            MF_CLASS19_b68.setEnabled(false);
            MF_CLASS19_c69.setEnabled(false);
            MF_CLASS19_e71.setEnabled(false);
            x();
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            String s1 = MF_CLASS19_b68.getText().toString();
            String s2 = MF_CLASS19_c69.getText().toString();
            MF_CLASS22_g77 = s1;
            h = s2;
            C = new PerformNetworkLoginTask(this);
            C.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] {
                s1, s2
            });
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--setOnClickListener--  *NO Network connection exists.");
            Toast.makeText(f, getString(0x7f080069), 1).show();
            return;
        }
    }

    static void o(LoginActivity loginactivity)
    {
        loginactivity.cancelCalibration();
    }

    private void p()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "cancelLogin()");
        if(C != null)
        {
            C.cancel(true);
            C = null;
        }
        y();
        MF_CLASS19_b68.setEnabled(true);
        MF_CLASS19_c69.setEnabled(true);
        MF_CLASS19_e71.setEnabled(true);
    }

    private void showLoginView()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showLoginView");
        ((RelativeLayout)findViewById(0x7f0b0011)).setVisibility(0);
    }

    private void r()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "hideLoginView");
        ((RelativeLayout)findViewById(0x7f0b0011)).setVisibility(4);
    }

    private boolean isInstallCalibDone()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "isInstallCalibDone called.");
        String s1 = PreferenceManager.getDefaultSharedPreferences(f.getApplicationContext()).getString("first_usage_calib_done", "");
        
        s1 ="done";
        
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("isInstallCalibDone calibDone = ").append(s1).toString());
        return s1 != null && s1.length() != 0;
    }

    private void t()
    {
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(f.getApplicationContext()).edit();
        String s1 = MF_CLASS19_b68.getText().toString();
        String s2 = MF_CLASS19_c69.getText().toString();
        if(s1 != null && s1.length() != 0)
            editor.putString("user_name", s1);
        if(s2 != null && s2.length() != 0)
            editor.putString("password", s2);
        editor.commit();
    }

    private void startMapCreator()
    {
        String s2;
        byte abyte0[];
        ByteArrayOutputStream bytearrayoutputstream;
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported : android.os.Build.MODEL: ").append(Build.MODEL).toString());
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported : android.os.Build.PRODUCT: ").append(Build.PRODUCT).toString());
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported : android.os.Build.DEVICE: ").append(Build.DEVICE).toString());
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported : android.os.Build.MANUFACTURER: ").append(Build.MANUFACTURER).toString());
        String s1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("backend_address", getString(0x7f080065));
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported(): backendURL = ").append(s1).toString());
        s2 = (new StringBuilder()).append(s1).append("/resources/models").toString();
        be.DeviceModel devicemodel = new be.DeviceModel();
        devicemodel.setProduct(Build.PRODUCT);
        devicemodel.setPlatform("Android");
        devicemodel.setPlatformVersion(android.os.Build.VERSION.RELEASE);
        devicemodel.setHardwareVersion(Build.HARDWARE);
        devicemodel.setManufacturer(Build.MANUFACTURER);
        devicemodel.setDevice(Build.DEVICE);
        devicemodel.setBrand(Build.BRAND);
        devicemodel.setSdkVersion(android.os.Build.VERSION.SDK);
        devicemodel.setOthers((new StringBuilder()).append(Build.BOARD).append(",").append(Build.BOOTLOADER).append(",").append(Build.BRAND).append(",").append(Build.CPU_ABI).append(",").append(Build.CPU_ABI2).append(",").append(Build.DEVICE).append(",").append(Build.DISPLAY).append(",").append(Build.FINGERPRINT).append(",").append(Build.HARDWARE).append(",").append(Build.HOST).append(",").append(Build.ID).append(",").append(Build.MANUFACTURER).append(",").append(Build.MODEL).append(",").append(Build.PRODUCT).append(",").append(Build.RADIO).append(",").append(Build.SERIAL).append(",").append(Build.TAGS).append(",").append(Build.TIME).append(",").append(Build.TYPE).append(",").append(Build.USER).append(",").append(Build.getRadioVersion()).append(",").append(android.os.Build.VERSION.CODENAME).append(",").append(android.os.Build.VERSION.INCREMENTAL).append(",").append(android.os.Build.VERSION.RELEASE).append(",").append(android.os.Build.VERSION.SDK_INT).toString());
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported: sending out = ").append(devicemodel.toString()).toString());
        abyte0 = devicemodel.toByteArray();
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported: original length = ").append(abyte0.length).toString());
        try
        {

	        bytearrayoutputstream = new ByteArrayOutputStream();
	        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new GZIPOutputStream(bytearrayoutputstream));
	        int i1 = 0;

	        for(;i1 < abyte0.length;i1++) {
	        	bufferedoutputstream.write(abyte0[i1]);
	        }
	        bufferedoutputstream.flush();

	        byte abyte1[];
	        ByteArrayInputStream bytearrayinputstream;
	        abyte1 = bytearrayoutputstream.toByteArray();
	        bufferedoutputstream.close();
	        
	        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported: gzipped length = ").append(abyte1.length).toString());
	        bytearrayinputstream = new ByteArrayInputStream(abyte1);
	        (new Thread(new CookieHTTPHandler(1, s2, null, null, new CLASS216(this), true, 0, bytearrayinputstream, (new StringBuilder()).append(i.getName()).append("=").append(i.getValue()).toString(), "MapCreator"))).start();
	        //(new Thread(new CookieHTTPHandler(1, s2, null, String.valueOf(abyte0), new CLASS216(this), true, 0, null, (new StringBuilder()).append(i.getName()).append("=").append(i.getValue()).toString(), "MapCreator"))).start();


        } catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        return;
    }

    private void v()
    {
        if(n < 3)
        {
            n = 1 + n;
            startMapCreator();
            return;
        } else
        {
            CLASS75.MF_CLASS75_a259(5, "APP_CLOSED", f.getClass(), "checkDeviceSupported, handleRetry too many retries.");
            f.runOnUiThread(new CLASS218(this));
            return;
        }
    }

    private void startWorldMapView()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startWorldMapView: called. Logging this event!");
        CLASS75.MF_CLASS75_a259(3, "LOGIN_OK", f.getClass(), (new StringBuilder()).append("Login ok, opening world map, user = ").append(k).toString());
        if(CLASS113.isDeviceChecked.booleanValue())
            MDC.put("USERID", MF_CLASS22_g77);
        f.runOnUiThread(new StartWorldMapViewRunnable(this));
    }

    private void x()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showProgressCircle");
        ((LinearLayout)findViewById(0x7f0b0013)).setVisibility(0);
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showProgressCircle done.");
    }

    private void y()
    {
        ((LinearLayout)findViewById(0x7f0b0013)).setVisibility(4);
    }

    private void z()
    {
        if(!MF_CLASS19_d70())
        {
            f.runOnUiThread(new CLASS220(this));
            CLASS75.MF_CLASS75_a259(4, "APP_CLOSED", f.getClass(), "PerformNetworkLoginTask. checkDeviceSensors returned false.");
            f.finish();
        }
    }

    public void startBackGroundCalibration()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration()");
        t = 0.0F;
        if(mIndoorAtlas != null)
        {
            try
            {
            	mIndoorAtlas.tearDown();
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration : creating API instance with empty apikey and secret");
                mIndoorAtlas = IndoorAtlasFactory.createIndoorAtlas(f.getApplicationContext(), f, "", "");
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration : created API instance with empty apikey and secret");
                return;
            }
            catch(Exception exception1)
            {
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration : API creation failed as expected. BG calib is running anyway.");
            }
            return;
        }
        try
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration : creating API instance with empty apikey and secret");
            mIndoorAtlas = IndoorAtlasFactory.createIndoorAtlas(f.getApplicationContext(), f, "", "");
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration : created API instance with empty apikey and secret");
            return;
        }
        catch(Exception exception)
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "startBackGroundCalibration : API creation failed as expected. BG calib is running anyway.");
        }
    }

    public void MF_CLASS19_a67(int i1)
    {
        if(x != null)
            x.vibrate(i1);
    }

    public void MF_CLASS19_a67(CLASS369 c)
    {
        if(CLASS113.isExceptionLogged.booleanValue())
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "notifySensorError(), debug mode, dumping stack");
            Thread.dumpStack();
        }
    }

    public void MF_CLASS19_a67(CLASS370 class370)
    {
        (new CLASS224(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new CLASS370[] {
            class370
        });
    }

    public void MF_CLASS19_a67(String s1)
    {
        y.setProgressValue("100 %");
        MF_CLASS19_a67(100);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS202(this));
        builder.create().show();
    }

    public void MF_CLASS194_b730()
    {
    	showCalibView();
        f.runOnUiThread(new CLASS215(this));
    }

    public void MF_CLASS19_b68(String s1)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS211(this));
        builder.create().show();
    }

    public void MF_CLASS196_c731()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onSplashScreenClosed()");
        m();
        showCalibOrLoginView();
    }

    public boolean MF_CLASS19_d70()
    {
        boolean flag = true;
        List list = ((SensorManager)f.getSystemService("sensor")).getSensorList(-1);
        ArrayList arraylist = new ArrayList();
        Sensor sensor;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(Integer.valueOf(sensor.getType())))
        {
            sensor = (Sensor)iterator.next();
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).toString());
        }

        int ai[] = {
            1, 4, 2
        };
        int i1 = 0;
        while(i1 < ai.length)
        {
            if(arraylist.contains(Integer.valueOf(ai[i1])))
            {
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSensors() : sensorType found : ").append(ai[i1]).toString());
            } else
            {
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSensors() : sensorType *NOT* found : ").append(ai[i1]).toString());
                flag = false;
            }
            i1++;
        }
        return flag;
    }

    public boolean MF_CLASS19_e71()
    {
        WifiManager wifimanager = (WifiManager)getSystemService("wifi");
        ConnectivityManager connectivitymanager = (ConnectivityManager)getSystemService("connectivity");
        boolean flag = wifimanager.isWifiEnabled();
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkNetworkConnected : wifiEnabled = ").append(flag).toString());
        NetworkInfo networkinfo = connectivitymanager.getNetworkInfo(1);
        NetworkInfo networkinfo1 = connectivitymanager.getNetworkInfo(0);
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if(networkinfo1 != null)
            flag1 = networkinfo1.isConnected();
        else
            flag1 = false;
        if(networkinfo != null)
            flag2 = networkinfo.isConnected();
        else
            flag2 = false;
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkNetworkConnected : mobileConnected = ").append(flag1).toString());
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("checkNetworkConnected : mWifiWasConnected = ").append(flag2).toString());
        if(!flag1)
        {
            flag3 = false;
            if(!flag2)
            	return flag3;
        }
        flag3 = true;
        return flag3;
    }

    public void f()
    {
        f.runOnUiThread(new CLASS221(this));
    }

    public void showCalibView()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showCalibView called.");
        try {
	        A();
	        if(mIndoorAtlas != null)
	        {
	            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showCalibView(): calling mIndoorAtlas.tearDown()");
	            mIndoorAtlas.tearDown();
	        }
	        u = true;
	        if(mSensorReader != null)
	        	mSensorReader.stopCalibration();
	        mSensorReader = new SensorReader(f.getApplicationContext(), f, f);
	        mSensorReader.MF_CLASS375_a1045(50F);
	        mSensorReader.startSensors();

        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }

        z = CalibrationDialogFragment.createInstance(this);
        z.show(getFragmentManager(), "calibviewdialog");
        CLASS75.MF_CLASS75_a259(4, "CALIBRATION_VIEW_SHOW_OK", Sipa.class, "showCalibView");
        return;
    }

    public void hStartCalibration()
    {
        try
        {
        	mSensorReader.startCalibration(false);
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public void i()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "hideCalibView(): called");
        B();
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("hideCalibView(): mCalibViewFragment = ").append(z).toString());
        if(z != null)
        {
            z.dismiss();
            z = null;
        }
    }

    public void showBGCalibView()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showBGCalibView called.");
        y = CLASS200.createInstance(this);
        y.show(getFragmentManager(), "bgcalibviewdialog");
        CLASS75.MF_CLASS75_a259(4, "CALIBRATION_VIEW_SHOW_OK", Sipa.class, "showBGCalibView");
    }

    public void k()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "hideBGCalibView(): called");
        if(y != null)
        {
            y.MF_CLASS200_a732();
            y.dismiss();
            y = null;
        }
    }

    public void showSplashView()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showSplashView called.");
        A = CLASS346.MF_CLASS346_a943(this);
        A.show(getFragmentManager(), "splashviewdialog");
    }

    public void m()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "hideInstallSplashView(): called");
        if(A != null)
        {
            A.killTimer();
            A.dismiss();
            A = null;
        }
    }

    public void showCalibOrLoginView()
    {
        if(isInstallCalibDone())
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showCalibOrLoginView(): first usage calibration already done --> show login view");
            showLoginView();
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "showCalibOrLoginView(): first usage --> show BG calibration view.");
            showBGCalibView();
            return;
        }
    }

    public void notifyCalibrationDone(CalibrationEvent class18, CLASS24 class24)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("notifyCalibrationDone called, cs = ").append(class18.toString()).toString());
        if(class18.getCalibrationStatus() != CLASS19.READY) {
                if(class18.getCalibrationStatus() == CLASS19.FAILED)
                {
                    CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "notifyCalibrationDone(): FAILED");
                    runOnUiThread(new CLASS210(this));
                }

        } else {

	        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "notifyCalibrationDone(): READY ");
	        MF_CLASS19_a67(100);
//	        class18.MF_CLASS18_c63()[1];
//	        -1D * class18.MF_CLASS18_c63()[0];
	        String s1 = w.format(class18.MF_CLASS18_c63()[0]);
	        String s2 = w.format(class18.MF_CLASS18_c63()[1]);
	        String s3 = w.format(class18.MF_CLASS18_c63()[2]);
	        if(CLASS113.isDeviceChecked.booleanValue() || CLASS113.isExceptionLogged.booleanValue())
	            runOnUiThread(new CLASS208(this, s1, s2, s3, class18));
	        try
	        {
	            E = mSensorReader.MF_CLASS376_k1068();
	            F = class24;
	            E();
	            runOnUiThread(new CLASS209(this));
	        }
	        catch(Exception exception)
	        {
	            if(CLASS113.isExceptionLogged.booleanValue())
	                exception.printStackTrace();
	        }
        }
        u = false;
        mSensorReader = null;
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "notifyCalibrationDone done.");
        return;

    }

    public void notifySensorError(int i1, CLASS369 c)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("notifySensorError() called type = ").append(i1).append(", sps = ").append(c).toString());
        runOnUiThread(new CLASS213(this, c));
    }

    public void notifyTimestampError(CLASS369 c)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("notifyTimestampError() called sps = ").append(c).toString());
        Toast.makeText(f, "Sensor timestamp error.", 1).show();
        runOnUiThread(new CLASS214(this, c));
    }

    public void onCalibrationFailed(String s1)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onCalibrationFailed: reson = ").append(s1).toString());
    }

    public void onCalibrationInvalid()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onCalibrationInvalid().");
    }

    public void onCalibrationReady()
    {
    	CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onCalibrationReady() now called when BG calib ready.");
    	try {
	        if(!isInstallCalibDone()) {
	            E();
	            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onCalibrationReady() isBGCalibViewVisible == ").append(C()).toString());
	            if(C())
	                runOnUiThread(new CLASS222(this));
	        } else {
	        	CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onCalibrationReady() : isInstallCalibDone() == true --> doing nothing.");
	        }

	        return;
    	} catch(Exception exception) {
    		exception.printStackTrace();
    	}

    }

    public void onCalibrationStatus(Some1Base some1base)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onCalibrationStatus() calibrationState.getCalibrationEvent() = ").append(some1base.getIndoorAction()).append(", calibrationState.getPercentage() = ").append(some1base.actionPercentage()).toString());
        runOnUiThread(new UpdateCalibrationStatusTH(this, some1base));
    }

    public void onCancelCalibration()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onCancelCalibration: doing nothing");
        Toast.makeText(f, "Cancelling not allowed.", 0).show();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- onCreate");
        Thread.setDefaultUncaughtExceptionHandler(new CLASS164(this));
        CLASS169.MF_CLASS169_a637(getApplicationContext());
        f = this;
        x = (Vibrator)getSystemService("vibrator");
        o = NumberFormat.getInstance(Locale.US);
        o.setMinimumFractionDigits(0);
        o.setMaximumFractionDigits(0);
        w = NumberFormat.getInstance(Locale.US);
        w.setMinimumFractionDigits(1);
        w.setMaximumFractionDigits(1);
        Thread thread = new Thread(new CLASS201(this));
        thread.setName("GraylogFirst");
        thread.start();
        CLASS41.MF_CLASS41_a148(getString(0x7f080065));
        setContentView(R.layout.login4);
        MF_CLASS19_b68 = (EditText)findViewById(0x7f0b000c);
        MF_CLASS19_c69 = (EditText)findViewById(0x7f0b000e);
        MF_CLASS19_e71 = (Button)findViewById(0x7f0b000f);
        MF_CLASS19_d70 = (TextView)findViewById(0x7f0b0010);
        MF_CLASS19_c69.setTypeface(Typeface.DEFAULT);
        MF_CLASS19_c69.setTransformationMethod(new PasswordTransformationMethod());
        MF_CLASS19_c69.setSelectAllOnFocus(true);
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(f.getApplicationContext());
        String s1 = sharedpreferences.getString("user_name", "");
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("--lifecycle-- onCreate loaded pref: user_name = ").append(s1).toString());
        MF_CLASS19_b68.setText(s1);
        String s2 = sharedpreferences.getString("password", "");
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("--lifecycle-- onCreate loaded pref: password = ").append(s2).toString());
        MF_CLASS19_c69.setText(s2);
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("--lifecycle-- onCreate Device is = ").append(Build.MODEL).toString());
        MF_CLASS19_e71.setSelectAllOnFocus(true);
        MF_CLASS19_e71.setOnClickListener(new CLASS212(this));
        
        this.startWorldMapView();
    }

    public void onInitializationFailed(String s1)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onInitializationFailed: reason = ").append(s1).toString());
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onKeyDown():").append(keyevent.toString()).toString());
        if(i1 == 4)
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onKeyDown(): keyCode == KeyEvent.KEYCODE_BACK: ");
            if(!D)
            {
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onKeyDown(): mWorldMapStarted == false --> cancelling login or closing activity (if login not ongoing)");
                q = true;
                if(C != null)
                {
                    CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onKeyDown(): mWorldMapStarted == false && mLoginTask == null --> cancelLogin()");
                    p();
                    return true;
                } else
                {
                    CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onKeyDown(): mWorldMapStarted == false && mLoginTask == null --> closing activity");
                    f.finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                    return true;
                }
            } else
            {
                CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onKeyDown(): mWorldMapStarted == false --> not allowing cancel, because World map already started");
                return true;
            }
        } else
        {
            return false;
        }
    }

    public void onNetworkChangeComplete(boolean flag)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onCalibrationRequired");
    }

    public void onPause()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- onPause");
        super.onPause();
        t();
        i();
        k();
        m();
        r();
        cancelCalibration();
    }

    public void onResume()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- onResume");
        super.onResume();
        z();
        D = false;
        q = false;
        if(!MeasurementDataSource.MF_CLASS381_a1107)
            MeasurementDataSource.openDB(getApplicationContext());
        if(!APIDataBase.MF_CLASS33_a137)
            APIDataBase.MF_CLASS33_a137(getApplicationContext());
        if(!B)
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- mStarted false --> showSplashView()");
            showSplashView();
        } else
        {
            CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- mStarted true --> showCalibOrLoginView");
            showCalibOrLoginView();
        }
        B = true;
    }

    public void onServiceFailure(int i1, String s1)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onServiceFailure: code: ").append(i1).append(", reason = ").append(s1).toString());
    }

    public void onServiceInitialized()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onServiceInitialized");
    }

    public void onServiceInitializing()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onServiceInitializing");
    }

    public void onServiceStopped()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onServiceStopped");
    }

    public void onServiceUpdate(CLASS6 class6)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "onServiceUpdate");
    }

    public void onStart()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- onStart");
        super.onStart();
    }

    public void onStartCalibration()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("onStartCalibration: setting black image: ").append(System.currentTimeMillis()).toString());
        hStartCalibration();
    }

    public void onStop()
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "--lifecycle-- onStop");
        super.onStop();
        t();
    }

    public void updateCalibrationStatus(CalibrationEvent class18)
    {
        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, (new StringBuilder()).append("updateCalibrationStatus called, cs = ").append(class18).toString());
        if(class18.getCalibrationStatus() == CLASS19.IN_PROGRESS) {
        	runOnUiThread(new CLASS204(this, (new StringBuilder()).append(o.format(class18.MF_CLASS18_b62())).append(" %").toString()));
	        return;
        } else if(class18.getCalibrationStatus() == CLASS19.WAITING) {
	        runOnUiThread(new CLASS207(this));
	        return;
        }else if(class18.getCalibrationStatus() == CLASS19.DISCARDING) {
	        runOnUiThread(new CLASS205(this));
	        return;
        }
        if(class18.MF_CLASS18_d64() > 20000L) {
	        CLASS167.MF_CLASS167_b635(MF_CLASS19_a67, "updateCalibrationStatus called, > Constants.MAX_CALIBRATION_DURATION --> cancelling calibration");
	        runOnUiThread(new CLASS206(this));
	        return;
        }
        return;


    }

    public static String MF_CLASS19_a67 = "LoginActivity";
    private CLASS346 A;
    private boolean B;
    private PerformNetworkLoginTask C;
    private boolean D;
    private CLASS370 E;
    private CLASS24 F;
    EditText MF_CLASS19_b68;
    EditText MF_CLASS19_c69;
    TextView MF_CLASS19_d70;
    Button MF_CLASS19_e71;
    LoginActivity f;
    String MF_CLASS22_g77;
    String h;
    Cookie i;
    boolean j;
    String k;
    String l;
    String m;
    int n;
    NumberFormat o;
    AlertDialog p;
    protected boolean q;
    private CLASS101 r;
    private IndoorAtlas mIndoorAtlas;
    private float t;
    private boolean u;
    private SensorReader mSensorReader;
    private NumberFormat w;
    private Vibrator x;
    private CLASS200 y;
    private CalibrationDialogFragment z;

}
