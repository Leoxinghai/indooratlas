// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.task;

import android.content.Context;
import android.content.res.AssetManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.*;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.indooratlas.Calibrator.*;
import com.indooratlas.base.*;
import com.indooratlas.cursor.list.CLASS24;
import com.indooratlas.cursor.list.CLASS25;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.position.CLASS75;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.sensor.*;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.sensor.type.CLASS48;
import com.indooratlas.thread.HTTPHandler;
import com.indooratlas.thread.client.CLASS47;
import com.indooratlas.thread.server.WebsocketConnectionThread;
import com.indooratlas.types.INDOORTYPE;
import com.indooratlas.types.IndoorAtlas;

import java.io.IOException;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import com.indooratlas.communication.*;

// Referenced classes of package com.indooratlas.task:
//            CLASS41, CLASS61, PositioningState, CLASS46,
//            CLASS42, CLASS55, CLASS56, CLASS43,
//            CLASS52, CLASS51, CLASS40, StartPositioningTask,
//            CLASS62, CLASS53, RefreshHipriTask

public class RemoteImplementation
    implements IndoorAtlas, CLASS20, IBGCalibration, CLASS47, CLASS48, CLASS49
{

    public RemoteImplementation()
    {
        MF_CLASS369_b995 = false;
        MF_CLASS19_c69 = false;
        WAITINGType = 0;
        MF_CLASS25_f99 = 0L;
        mQueueWifiData = null;
        MF_CLASS50_p185 = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss z", Locale.ENGLISH);
        mTimer = null;
        mStartPositioningTask = null;
        mStopPositioningTask = null;
        D = false;
        mRefreshHipriTask = null;
        F = false;
        I = false;
        MF_CLASS19_a67 = null;
        mSensorDataProcessorTH = null;
        K = null;
        L = 0L;
        N = 0L;
        O = false;
        P = 0L;
        Q = false;
        MF_CLASS50_r187_boolean_fld = false;
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "RemoteImplementation() called");
    }

    private boolean A()
    {
        int i;
        i = 0;
        for(int j = 0; i == 0 && j < 5;)
        {
            j++;
            i = MF_CLASS19_a67(MF_CLASS50_n183, CLASS41.locationService, true);
            if(i != 0)
                continue; /* Loop/switch isn't completed */
            try
            {
                Thread.sleep(50L);
            }
            catch(Exception exception) { 
                exception.printStackTrace();
            	
            }
        }

        if(i == 1)
            return true;
        return false;

    }

    private long B()
    {
        return (SystemClock.elapsedRealtime() - MF_CLASS46_g163) + MF_CLASS25_f99;
    }

    private void createStopPositioningTask()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "createStopPositioningTask: called");
        if(mStopPositioningTask != null)
        	mStopPositioningTask.cancel(true);
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "createStopPositioningTask: calling mHandler.post");
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "createStopPositioningTask: creating task inside handler");
        mStopPositioningTask = (new StopPositioningTask(this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "createStopPositioningTask: created task inside handler");
    }

    private void readProperties()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "readProperties() properties");
        Properties properties = new Properties();
        try
        {
            java.io.InputStream inputstream = MF_CLASS50_n183.getAssets().open("constants.properties");
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("readProperties() properties :  fin = ").append(inputstream).toString());
            properties.load(inputstream);
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "readProperties() properties loaded");
        }
        catch(IOException ioexception) { }
        if(properties.getProperty("location.service.url") != null)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("readProperties() key = ").append("location.service.url").append(", properties.getProperty(key) != null").toString());
            CLASS41.locationService = properties.getProperty("location.service.url");
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("readProperties() key = ").append("location.service.url").append(", properties.getProperty(key) == null").toString());
            CLASS41.locationService = new String("wss://ps.trafficmanager.net:443/");
        }
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("readProperties: location.service.url=").append(CLASS41.locationService).toString());
    }

    private int MF_CLASS19_a67(Context context, String s, boolean flag)
    {
        if(MF_CLASS50_x193 == null)
            return 0;
        android.net.NetworkInfo.State state = MF_CLASS50_x193.getNetworkInfo(5).getState();
        if(!flag && (state.compareTo(android.net.NetworkInfo.State.CONNECTED) == 0 || state.compareTo(android.net.NetworkInfo.State.CONNECTING) == 0))
            return 1;
        int i = MF_CLASS50_x193.startUsingNetworkFeature(0, "enableHIPRI");
        if(-1 == i)
            return 0;
        if(!flag)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "forceMobileConnectionForAddress: forceRefresh == false, not checking if already ENABLED.");
            if(i == 0)
                return 1;
        }
        String s1 = CLASS75.MF_CLASS75_b260(s);
        long l;
        int j;
        long l1;
        int k;
        boolean flag1;
        android.net.NetworkInfo.State state1;
        int i1;
        if(!TextUtils.isEmpty(s1))
            s = s1;
        l = SystemClock.elapsedRealtime();
        j = CLASS75.lookupHost(s);
        l1 = SystemClock.elapsedRealtime() - l;
        if(-1 == j && l1 > 25000L)
            return -1;
        if(-1 == j)
            return 0;
        k = 0;
        if(k < 30) {
	        state1 = MF_CLASS50_x193.getNetworkInfo(5).getState();
	        i1 = state1.compareTo(android.net.NetworkInfo.State.CONNECTED);
	        if(i1 != 0) {
	                if(state1.compareTo(android.net.NetworkInfo.State.UNKNOWN) == 0)
	                    return 0;
	                try {
	                	Thread.sleep(30L);
	                } catch(InterruptedException  interruptedexception) {
	                	interruptedexception.printStackTrace();
	                }
	                k++;
	        }
        }
        MF_CLASS50_x193.getNetworkInfo(5).getState();
        flag1 = MF_CLASS50_x193.requestRouteToHost(5, j);
        if(flag1);
        return !flag1 ? 0 : 1;
    }

    static long MF_CLASS19_a67(RemoteImplementation class50, long l)
    {
        class50.MF_CLASS25_f99 = l;
        return l;
    }

    static long MF_CLASS19_a67(RemoteImplementation class50, String s)
    {
        return class50.MF_CLASS25_f99(s);
    }

    static RefreshHipriTask MF_CLASS19_a67(RemoteImplementation class50, RefreshHipriTask class58)
    {
        class50.mRefreshHipriTask = class58;
        return class58;
    }

    static WebsocketConnectionThread MF_CLASS19_a67(RemoteImplementation class50)
    {
        return class50.mWebSocketConnectionThread;
    }

    static WebsocketConnectionThread MF_CLASS19_a67(RemoteImplementation class50, WebsocketConnectionThread class78)
    {
        class50.mWebSocketConnectionThread = class78;
        return class78;
    }

    private void MF_CLASS19_a67(long l)
    {
        G = l;
    }

    private void setPositioningState(PositioningState class57)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setPositioningState(): called, inside synchronized, positioningState = ").append(class57).toString());
        mPositioningState = class57;
        return;
    }

    static boolean MF_CLASS19_a67(RemoteImplementation class50, boolean flag)
    {
        class50.O = flag;
        return flag;
    }

    static RemoteImplementation MF_CLASS369_b995(RemoteImplementation class50)
    {
        return class50.H;
    }

    static String MF_CLASS369_b995(RemoteImplementation class50, String s)
    {
        class50.MF_CLASS50_l181 = s;
        return s;
    }

    static boolean MF_CLASS369_b995(RemoteImplementation class50, boolean flag)
    {
        class50.MF_CLASS369_b995 = flag;
        return flag;
    }

    static String MF_CLASS19_c69(RemoteImplementation class50)
    {
        return class50.MF_CLASS24_h93;
    }

    static boolean MF_CLASS19_c69(RemoteImplementation class50, boolean flag)
    {
        class50.F = flag;
        return flag;
    }

    static CLASS3 getIndoorAltas(RemoteImplementation class50)
    {
        return class50.mIndoorAltas;
    }

    private void WAITINGType(String s)
    {
    }

    private void WAITINGType(boolean flag)
    {
        I = flag;
    }

    static boolean WAITINGType(RemoteImplementation class50, boolean flag)
    {
        class50.D = flag;
        return flag;
    }

    static SensorReader getSensorReader(RemoteImplementation class50)
    {
        return class50.mSensorReader;
    }

    private void MF_CLASS19_e71(String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("informPositioningStartFailed: reason = ").append(s).append(" --> onInitializationFailed").toString());
        if(mIndoorAltas != null)
        	mIndoorAltas.onInitializationFailed(s);
    }

    static long MF_CLASS25_f99(RemoteImplementation class50)
    {
        return class50.MF_CLASS25_f99;
    }

    private long MF_CLASS25_f99(String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "parseNetworkTime called.");
        MF_CLASS46_g163 = SystemClock.elapsedRealtime();
        long l;
        try
        {
            Date date = MF_CLASS50_p185.parse(s);
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("parseNetworkTime: serverTime = ").append(s).append(", from Date : ").append(date.toString()).toString());
            l = date.getTime();
        }
        catch(ParseException parseexception)
        {
        	parseexception.printStackTrace();
        	return (new Date()).getTime();
        }
        return l;
    }

    static int MF_CLASS46_g163(RemoteImplementation class50)
    {
        int i = class50.WAITINGType;
        class50.WAITINGType = i + 1;
        return i;
    }

    static void S_SendDeviceModelCheck(RemoteImplementation class50)
    {
        class50.sendDeviceModelCheck();
    }

    static int MF_CLASS50_i178(RemoteImplementation class50)
    {
        return class50.WAITINGType;
    }

    static RefreshHipriTask getRefreshHipriTask(RemoteImplementation class50)
    {
        return class50.mRefreshHipriTask;
    }

    static boolean MF_CLASS50_k180(RemoteImplementation class50)
    {
        return class50.D;
    }

    static void MF_CLASS50_l181(RemoteImplementation class50)
    {
        class50.MF_CLASS50_y194();
    }

    static boolean MF_CLASS50_m182(RemoteImplementation class50)
    {
        return class50.F;
    }

    static Context MF_CLASS50_n183(RemoteImplementation class50)
    {
        return class50.MF_CLASS50_n183;
    }

    static void DoStartPositioning(RemoteImplementation class50) throws Exception
    {
        class50.doStartPositioning();
    }

    private boolean MF_CLASS50_p185()
    {
        return APIDataBase.selectBGCalibrationFromDB() != null;
    }

    static boolean MF_CLASS50_p185(RemoteImplementation class50)
    {
        return class50.A();
    }

    private boolean MF_CLASS50_q186()
    {
        return I;
    }

    private boolean isPositioningActive()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "isPositioningActive(), outside synchronized");
        PositioningState class57 = mPositioningState;
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "isPositioningActive(), inside synchronized");
        if(mPositioningState != PositioningState.ACTIVE)
            return false;
        return true;
    }

    private void sendDeviceModelCheck()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "sendDeviceModelCheck(): called.");
        Runnable runnable = checkDeviceSupported();
        A.execute(runnable);
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "sendDeviceModelCheck(): done.");
    }

    private void doStartPositioning() throws Exception
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): called.");
        P = 0L;
        Q = false;
        WAITINGType(false);
        MF_CLASS19_a67(SystemClock.elapsedRealtime());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): called, calling synchronized setPositioningState(ACTIVE)");
        setPositioningState(PositioningState.ACTIVE);
        CLASS15 class15 = APIDataBase.selectBGCalibrationFromDB();
        CLASS46 class46;
        if(class15 != null)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("doStartPositioning(): got bg bias from DB: ").append(class15).toString());
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("doStartPositioning(): got bg bias from DB, age = ").append(System.currentTimeMillis() - class15.MF_CLASS15_f50()).toString());
            mWebSocketConnectionThread.MF_CLASS85_b316(class15);
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): did *NOT* get bg bias from DB --> posting calibration invalid!");
            double ad[] = {
                0.0D, 0.0D, 0.0D
            };
            CLASS17 _tmp = CLASS17.BACKGROUND;
            CLASS15 class15_1 = new CLASS15("none", ad, 0.0D, 0.0D, CLASS17.BACKGROUND, BGC_TYPE.BGC_IN_PROGRESS);
            mWebSocketConnectionThread.MF_CLASS85_b316(class15_1);
            postCalibInvalidThread(MF_CLASS50_n183);
        }
        mWebSocketConnectionThread.MF_CLASS85_a315(true);
        (new Thread(mWebSocketConnectionThread, "ConnectionService")).start();
        class46 = CLASS75.getNetworkStatus(MF_CLASS50_n183);
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("doStartPositioning : nsw = ").append(class46.toString()).toString());
        if(D && class46.mMobileHipriConnected && class46.mMobileDataEnabled)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning : preferMobileConnection && mobileHipriConnected");
            startSensorsAndScanning();
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning : mobileHipriConnected --> calling connectionService.connect();");
            mWebSocketConnectionThread.connect();
            return;
        }
        if(!D && (class46.mMobileConnected || class46.mWifiConnected))
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning : WiFi or normal mobile is connected --> calling connectionService.connect;");
            startSensorsAndScanning();
            mWebSocketConnectionThread.connect();
            return;
        }
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): No network connections --> not initializing positioning");
        if(D)
        {
            if(!class46.mMobileHipriConnected)
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): Mobile hipri network was preferred, but not connected. Positioning cancelled.");
                MF_CLASS19_e71("Mobile hipri network was preferred, but not available. Positioning cancelled.");
            } else
            if(!class46.mMobileDataEnabled)
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): Mobile hipri network was preferred, but mobile data is disabled. Positioning cancelled.");
                MF_CLASS19_e71("Mobile hipri network was preferred, but mobile data is disabled. Positioning cancelled.");
            } else
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): preferMobileConnection == true, Unknown error");
                MF_CLASS19_e71("Mobile network was preferred, but unknown error occurred. Positioning cancelled.");
            }
        } else
        if(!class46.mWifiConnected && !D)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): preferMobileConnection == false --> No Wifi connection, positioning cancelled");
            MF_CLASS19_e71("Device default network was preferred, but neither WiFi nor Mobile is connected. Positioning cancelled.");
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStartPositioning(): Unknown error");
            MF_CLASS19_e71("Unknown error. Positioning cancelled.");
        }
        doStopPositioning();
    }

    private void startSensorsAndScanning()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "startSensorsAndScanning");
        MF_CLASS50_l181();
        mSensorReader.MF_CLASS375_a1045(15F);
        boolean flag = mSensorReader.startDataCollection();
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "startSensorsAndScanning() Started data collection.");
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startSensorsAndScanning() sensorsRunning = ").append(flag).toString());
        if(flag)
            MF_CLASS50_t189.startScanning();
    }

    private void stopSensorsAndScanning() throws Exception
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopSensorsAndScanning");
        if(mSensorReader != null) {
        	mSensorReader.MF_CLASS369_c996();
	        if(!mSensorReader.MF_CLASS158_f565()) {
	            CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopSensorsAndScanning: stopping sensors, bg calib not running");
	            mSensorReader.stopSensors(true, true);
	        } else {
	            try
	            {
	                CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopSensorsAndScanning: *NOT* stopping sensors, bg calib running");
	            }
	            catch(Exception exception)
	            {
	            	exception.printStackTrace();
	            	CLASS75.MF_CLASS75_b260("RemoteImplementation", exception.getMessage());
	            }
	        }
        }
        if(mSensorDataProcessorTH != null)
        	mSensorDataProcessorTH.stopSensorDataProcessor();
        if(MF_CLASS50_t189 != null)
            MF_CLASS50_t189.stopScanning();
        return;
    }


    private long MF_CLASS50_w192()
    {
        return G;
    }

    private Runnable checkDeviceSupported()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported : android.os.Build.MODEL: ").append(Build.MODEL).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported : android.os.Build.PRODUCT: ").append(Build.PRODUCT).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported : android.os.Build.DEVICE: ").append(Build.DEVICE).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported : android.os.Build.MANUFACTURER: ").append(Build.MANUFACTURER).toString());
        String s;
        be.DeviceModel devicemodel;
        byte abyte0[];
        if(CLASS41.MF_CLASS41_b149 != null)
        {
            s = (new StringBuilder()).append(CLASS41.MF_CLASS41_b149).append("/resources/models/").toString();
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported(): BACKEND_URL_OVERRIDE = ").append(CLASS41.MF_CLASS41_b149).toString());
        } else
        {
            s = "https://services.indooratlas.com/resources/models/";
        	//s = "http://services.indooratlas.com/resources/models/";
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "checkDeviceSupported(): BACKEND_URL = https://services.indooratlas.com");
        }
        devicemodel = new be.DeviceModel();
        devicemodel.setProduct(Build.PRODUCT);
        devicemodel.setPlatform("Android");
        devicemodel.setPlatformVersion(android.os.Build.VERSION.RELEASE);
        devicemodel.setHardwareVersion(Build.HARDWARE);
        devicemodel.setManufacturer(Build.MANUFACTURER);
        devicemodel.setDevice(Build.DEVICE);
        devicemodel.setBrand(Build.BRAND);
        devicemodel.setSdkVersion(String.valueOf(android.os.Build.VERSION.SDK_INT));
        devicemodel.setOthers((new StringBuilder()).append((new StringBuilder()).append(Build.BOARD).append(",").append(Build.BOOTLOADER).append(",").append(Build.BRAND).append(",").append(Build.CPU_ABI).append(",").append(Build.CPU_ABI2).append(",").append(Build.DEVICE).append(",").append(Build.DISPLAY).append(",").append(Build.FINGERPRINT).append(",").append(Build.HARDWARE).append(",").append(Build.HOST).append(",").append(Build.ID).append(",").append(Build.MANUFACTURER).append(",").append(Build.MODEL).append(",").append(Build.PRODUCT).append(",").append(Build.getRadioVersion()).append(",").append(Build.SERIAL).append(",").append(Build.TAGS).append(",").append(Build.TIME).append(",").append(Build.TYPE).append(",").append(Build.USER).append(",").append(Build.getRadioVersion()).append(",").append(android.os.Build.VERSION.CODENAME).append(",").append(android.os.Build.VERSION.INCREMENTAL).append(",").append(android.os.Build.VERSION.RELEASE).append(",").append(android.os.Build.VERSION.SDK_INT).toString()).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported(): sending out dm = ").append(devicemodel.toString()).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("apikey:").append(MF_CLASS50_o184.MF_CLASS42_a150()).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("secret:").append(MF_CLASS50_o184.MF_CLASS42_b151()).toString());
        abyte0 = devicemodel.toByteArray();
        return new HTTPHandler(1, s, null, new CLASS55(this), 0, abyte0, MF_CLASS50_o184.MF_CLASS42_a150(), MF_CLASS50_o184.MF_CLASS42_b151(), B());
    }

    private void MF_CLASS50_y194()
    {
        if(mTimer != null)
        {
        	mTimer.cancel();
            mTimer = null;
        }
    }

    private void startHipriUpdater()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "startHipriUpdater: called");
        MF_CLASS50_y194();
        mTimer = new Timer();
        HipriUpdaterTask class56 = new HipriUpdaterTask(this);
        mTimer.schedule(class56, 0L, 10000L);
    }

    public void stopPositioning()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopPositioning() called, within synchronized");
        getPositioningState();
        if(mPositioningState != PositioningState.STOPPING) {
            if(mSensorReader != null)
            	mSensorReader.MF_CLASS375_a1045(50F);
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopPositioning(): called, calling synchronized setPositioningState(STOPPING)");
            setPositioningState(PositioningState.STOPPING);
            createStopPositioningTask();
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopPositioning() done");
        } else {
	        CLASS3 class3;
	        CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopPositioning called, already positioningState == PositioningState.STOPPING, returning");
	        class3 = mIndoorAltas;
	        if(class3 == null);
        }
        return;
    }

    public void MF_CLASS19_a67(int i, String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("relayPositioningError() called, calling synchronized stopPositioning(), code: ").append(i).append(", message = ").append(s).toString());
        int j = CLASS43.MF_CLASS43_a152(i);
        String s1 = "";
        if(j != i)
            s1 = (new StringBuilder()).append(" (Internal error code: ").append(j).append(")").toString();
        mIndoorAltas.onServiceFailure(j, (new StringBuilder()).append(s).append(s1).toString());
        stopPositioning();
    }

    public void MF_CLASS19_a67(Context context)
    {
        (new Handler(context.getMainLooper())).post(new CLASS52(this));
    }

    public void setup(Context context, CLASS3 class3, CLASS42 class42)
    {
        int i;
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup called.");
        MF_CLASS50_r187_boolean_fld = false;
        if(A == null)
            A = Executors.newCachedThreadPool();
        MF_CLASS50_n183 = context;
        mIndoorAltas = class3;
        MF_CLASS50_o184 = class42;
        H = this;
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup calling setPositioningState(INACTIVE)");
        setPositioningState(PositioningState.INACTIVE);
        O = false;
        MF_CLASS50_t189 = new WifiScanBroadcastReceiver(context, this);
        MF_CLASS50_x193 = (ConnectivityManager)context.getSystemService("connectivity");
        MF_CLASS50_y194 = (LocationManager)context.getSystemService("location");
        MF_CLASS50_z195 = (TelephonyManager)context.getSystemService("phone");
        MF_CLASS24_h93 = MF_CLASS50_z195.getDeviceId();
        try {
        if(mSensorReader == null || mSensorReader.isSensorErrorReported())
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup(): creating SensorReader");
            if(mSensorReader != null)
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setup(): calling sensorReader.stopSensors for old sensorReader, sensorReader.isSensorErrorReported() ==  ").append(mSensorReader.isSensorErrorReported()).toString());
                mSensorReader.stopSensors(false, true);
            }
            InterruptedException interruptedexception1;
            try
            {
            	mSensorReader = new SensorReader(context, this, this);
            	mSensorReader.MF_CLASS375_a1045(50F);
            	mSensorReader.start();
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup(): SensorReader created");
                K = new CLASS8();
                MF_CLASS50_w192 = new BackgroundCalibratorController(mSensorReader);
                MF_CLASS50_w192.startBackgroundCalibration();
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup(): Background calibrator initialized & started.");
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            	throw new CLASS1("Error in setting up sensor listener.");
            }
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup(): SensorReader and BG calibrator already existing, calling startBackgroundCalibrationCycle()");
            MF_CLASS50_w192.startBackgroundCalibration();
        }
        BackgroundCalibratorController.MF_CLASS9_b23(this);
        BackgroundCalibratorController.MF_CLASS376_a1051(this);
        readProperties();
        if(context.getMainLooper().getThread() == Thread.currentThread())
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup: running in main thread");
            if(class42.MF_CLASS42_a150().length() > 10 && mWebSocketConnectionThread == null)
            	mWebSocketConnectionThread = WebsocketConnectionThread.MF_CLASS85_a315(H, context, class42, MF_CLASS24_h93, CLASS41.locationService);
            if(mWebSocketConnectionThread != null)
            	mWebSocketConnectionThread.MF_CLASS85_a315(mIndoorAltas, H);
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup: *NOT* running in main thread");
            Handler handler = new Handler(context.getMainLooper());
            mWebSocketConnectionThread = null;
            handler.post(new CLASS51(this, class42, context));
        }
        if(class42.MF_CLASS42_a150().length() <= 10) {
            //break MISSING_BLOCK_LABEL_568;
        }

        i = 0;
        for(;i < 200;i++) {

	        if(mWebSocketConnectionThread != null)
	            break; /* Loop/switch isn't completed */
	        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setup(): waiting for creation of connectionService...").append(i).toString());
//            try
//            {
//    	        Thread.sleep(50L);
//                throw new CLASS1("Could not create connection interface.");
//            }
            // Misplaced declaration of an exception variable
            //catch(InterruptedException interruptedexception1) { }
        }
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setup(): connectionService created ").append(mWebSocketConnectionThread).toString());
        if(!MF_CLASS369_b995 && class42 != null && class42.MF_CLASS42_a150() != null && class42.MF_CLASS42_a150().length() != 0 && class42.MF_CLASS42_b151() != null && class42.MF_CLASS42_b151().length() != 0)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup(): deviceTypeCheckDone == false --> sending http request and waiting for response...stalling calling thread");
            WAITINGType = 0;
//            sendDeviceModelCheck();
//            do
//            {
                if(WAITINGType >= 5)
                {
                    CLASS75.MF_CLASS75_b260("RemoteImplementation", "setup(): backendTaskRepeatCount over --> throwing exception");
//                    throw new CLASS1("IndoorAtlas API could not connect to the cloud service.");
                }
                CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setup(): waiting for backend query to finish... backendTaskRepeatCount = ").append(WAITINGType).toString());
                try
                {
                    Thread.sleep(100L);
                }
                catch(InterruptedException interruptedexception) { }
//            } while(!MF_CLASS369_b995);
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setup(): deviceTypeCheckDone == ").append(MF_CLASS369_b995).append(" --> continuying without connecting to cloud").toString());
        }
        WAITINGType = 0;
        if(MF_CLASS50_l181 != null && mWebSocketConnectionThread != null)
        	mWebSocketConnectionThread.MF_CLASS85_b316(MF_CLASS50_l181);
        if(isBGCalibrated())
        {
            MF_CLASS19_a67(context);
            MF_CLASS50_w192.stopBackgroundCalibration(true, 0x36ee80L);
        } else
        {
//        	postCalibInvalidThread(context);
        }
        MF_CLASS50_r187_boolean_fld = true;
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "Setup done.");
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        return;
    }

    public void BGcalib(CLASS15 class15)
    {
        boolean flag;
        K.update(class15);
        flag = isBGCalibrated();
        if(flag && L == 0L)
            L = System.currentTimeMillis();
        long l = System.currentTimeMillis();
        long l1 = l - N;
        try {
        if(K.MF_CLASS16_c55() && l1 > 10000L)
        {
            class15.MF_CLASS16_b54(l);
            CLASS15 class15_1 = APIDataBase.selectBGCalibrationFromDB();
            if(class15_1 != null)
                APIDataBase.MF_CLASS33_b138(class15_1);
            class15 = APIDataBase.storeBGCalibration(class15);
            N = l;
        }
        long l2 = l - P;
        if(K.MF_CLASS16_c55() && l2 > 5000L && MF_CLASS50_q186())
        {
            P = l;
            mWebSocketConnectionThread.sendBias(class15);
        }
        double d = K.getCalibrationPercent();
        Date date;
        if(class15.getBGCState() == BGC_TYPE.BGC_FAILED)
        {
            CLASS40 class40 = new CLASS40(INDOORTYPE.RESTARTED, (float)d);
            mIndoorAltas.onCalibrationStatus(class40);
        } else
        {
            CLASS40 class40_1 = new CLASS40(INDOORTYPE.ONGOING, (float)d);
            mIndoorAltas.onCalibrationStatus(class40_1);
        }
        if(O || !flag) {
                if(flag)
                {
//                    System.currentTimeMillis() - L;
                    MF_CLASS50_w192.stopBackgroundCalibration(true, 0x36ee80L);
                } else
                if(O && !flag)
                {
                    O = false;
                    if(MF_CLASS50_r187_boolean_fld)
                    	mIndoorAltas.onCalibrationInvalid();
                }
        } else {
	        if(MF_CLASS50_r187_boolean_fld)
	        {
	        	mSensorReader.setUseNanoTime(false);
	        	mIndoorAltas.onCalibrationReady();
	            O = true;
	        }
	        L = System.currentTimeMillis();
        }

        date = new Date();
        WAITINGType((new StringBuilder()).append("BGcalib: ").append(CLASS75.MF_CLASS75_a259(class15.MF_CLASS16_b54())).append(": ").append(CLASS75.MF_CLASS75_a259(date)).append("\nbiasCov: ").append(class15.MF_CLASS16_c55()).append(", ").append(CLASS75.MF_CLASS75_a259(date)).append("\ncalibrator: ").append(class15.MF_CLASS17_a58()).toString());
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        return;

    }

    public void notifySensorDataPackage(CLASS24 class24)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifySensorDataPackage called, calling synchronized isPositioningActive()");
        if(!isPositioningActive())
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifySensorDataPackage() : positioning not active, returning");
            return;
        }
        if(mWebSocketConnectionThread != null)
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorDataPackage() called, Constants.MAX_QUEUE_LENGTH = 80, Constants.MAX_SENT_MESSAGE_COUNT_WITH_NO_RESPONSES = 80, positioningState = ").append(getPositioningState()).append(", connectionService.getNumberOfQueuedMessages() = ").append(mWebSocketConnectionThread.getQueueSize()).append(", connectionService.getNumberOfSentButNoResponseReceivedMessages() = ").append(mWebSocketConnectionThread.MF_CLASS85_b316()).toString());
        if(class24 == null)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifySensorDataPackage(): dataPackage == null --> returning. THIS IS AN ERROR!");
            return;
        }
        if(class24.gyroscopeSamples != null)
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorDataPackage(): dataPackage.gyroscopeSamples.size() = ").append(class24.gyroscopeSamples.size()).toString());
        if(class24.accelerometerSamples != null)
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorDataPackage(): dataPackage.accelerometerSamples.size() = ").append(class24.accelerometerSamples.size()).toString());
        if(class24.magnetometerSamples != null)
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorDataPackage(): dataPackage.magnetometerSamples.size() = ").append(class24.magnetometerSamples.size()).toString());
        if(mWebSocketConnectionThread != null && getPositioningState() == PositioningState.ACTIVE)
        {
            int j = mWebSocketConnectionThread.getQueueSize();
            int k = mWebSocketConnectionThread.MF_CLASS85_b316();
            if(j > 80 || k > 80)
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifySensorDataPackage(): Message buffer full, calling synchronized stopPositioning().");
                mIndoorAltas.onServiceFailure(2005, "Message buffer full, stopping positioning.");
                stopPositioning();
                return;
            }
        }
        List list = createGPSSample();
        if(list != null)
            class24.MF_CLASS24_h93 = list;
        try
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifySensorDataPackage(): calling connectionService.queueSensorData().");
            if(mQueueWifiData != null && !Q)
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorDataPackage(), firstDataPacketSent == false, queuing wifi data with size : ").append(mQueueWifiData.size()).toString());
                for(Iterator iterator = mQueueWifiData.iterator(); iterator.hasNext();)
                    ((CLASS381)iterator.next()).mScanTimeStamp = 0L;

            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        Q = true;
        mWebSocketConnectionThread.queueSensorData(class24, mQueueWifiData);
        int i = mWebSocketConnectionThread.getQueueSize();
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorDataPackage() : queueSize = ").append(i).toString());
        return;
    }

    public void onInitializationFailed(String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "onInitializationFailed() called, calling serviceListener.onInitializationFailed");
        long l = SystemClock.elapsedRealtime() - MF_CLASS50_w192();
        CLASS75.MF_CLASS75_a259(5, "POSITIONING_INIT_OK", RemoteImplementation.class, (new StringBuilder()).append("RemoteImplementation: onInitializationSuccessful: init took: ").append(l).toString());
        mIndoorAltas.onInitializationFailed(s);
        createStopPositioningTask();
    }


    public void startPositioning(String s, String s1, String s2) throws CLASS1
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning() with default parameters called: buildingId = ").append(s).append(", levelId = ").append(s1).append(", floorplanId = ").append(s2).toString());
        if(!MF_CLASS50_p185())
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "startPositioning(): first time calibration not done -> throwing error");
            throw new CLASS1("Device is not calibrated.");
        }
        startPositioning(s, s1, s2, new CLASS5());


    }

    public void startPositioning(String s, String s1, String s2, CLASS5 class5) throws CLASS1
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning() with custom parameters called: buildingId = ").append(s).append(", levelId = ").append(s1).append(", floorplanId = ").append(s2).toString());
        if(!MF_CLASS50_p185())
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "startPositioning(): first time calibration not done -> throwing error");
            throw new CLASS1("Device is not calibrated.");
        }

        PositioningState class57;
        boolean flag = isBGCalibrated();
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning(): calibReady = ").append(flag).toString());
        class57 = getPositioningState();
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning() called: within synchronized, PositioningState = ").append(class57).toString());

        try {
        if((mStartPositioningTask == null || mStartPositioningTask.getStatus() == android.os.AsyncTask.Status.FINISHED) && (mStopPositioningTask == null || mStopPositioningTask.getStatus() == android.os.AsyncTask.Status.FINISHED) && mPositioningState == PositioningState.INACTIVE) {
                PositioningState class57_1;
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "startPositioning(): called, calling synchronized setPositioningState(INITIALIZING)");
                setPositioningState(PositioningState.INITIALIZING);
                MF_CLASS50_i178 = s;
                mLevelId = s1;
                MF_CLASS50_k180 = s2;
                MF_CLASS50_s188_com_indooratlas_base_CLASS5_fld = class5;
                mWebSocketConnectionThread.MF_CLASS24_c88(s2);
                class57_1 = getPositioningState();
                if(class57_1 == PositioningState.ACTIVE || class57_1 == PositioningState.INITIALIZING && false) {
                    if(mIndoorAltas != null)
                    {
                        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning(): Previous positioning session is ongoing or being torn down 2, positioningState = ").append(class57_1).toString());
                        mIndoorAltas.onInitializationFailed("Previous positioning session is active or stopping, can't initialize new session.");
                    }
                } else if(class57_1 != PositioningState.STOPPING) {
                    (new StartPositioningTask(this, null)).execute(new Void[0]);
                    CLASS75.MF_CLASS75_b260("RemoteImplementation", "startPositioning() outside synchronized, done");
                }
        } else {
	        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning(): calling back informPositioningStartFailed, because stoppositioningTask or startPositioningTask is still running, positioningState = ").append(mPositioningState).append(", startPositioningTask = ").append(mStartPositioningTask).toString());
	        if(mStartPositioningTask != null)
	            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning(): startPositioningTask.getStatus() = ").append(mStartPositioningTask.getStatus()).toString());
	        if(mIndoorAltas != null)
	        {
	            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("startPositioning(): Previous positioning session is ongoing or being torn down 1, positioningState = ").append(class57).toString());
	            MF_CLASS19_e71("Previous positioning session is ongoing or being torn down.");
	        }
        }

        } catch(Exception exception) {
        	exception.printStackTrace();
        }

        return;
    }

    public void MF_CLASS49_a168(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "wifiScanAvailable called.");
        mQueueWifiData = concurrentlinkedqueue;
    }

    public void setPreferMobileConnection(boolean flag)
    {
        CLASS46 class46 = CLASS75.getNetworkStatus(MF_CLASS50_n183);
        if(flag)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setPreferMobileConnection : prefer mobile true --> checking if mobile HIPRI available");
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("setPreferMobileConnection : mobile hipri = ").append(class46.mMobileHipri).toString());
            if(!class46.mMobileHipriAvailable || !class46.mMobileDataEnabled)
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "setPreferMobileConnection : mobile hipri unavailable --> calling serviceListener.onNetworkChangeComplete(result) directly");
                D = false;
                MF_CLASS50_y194();
                mIndoorAltas.onNetworkChangeComplete(false);
                return;
            } else
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "setPreferMobileConnection : mobile hipri available --> switch to hipri");
                D = true;
                F = true;
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "setPreferMobileConnection : starting HIpri-updateer.");
                startHipriUpdater();
                return;
            }
        }
        D = false;
        if(class46.mMobileHipriAvailable)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setPreferMobileConnection : mobileHipriAvailable == true --> calling stopHipriUpdater and cancelling hipri-swtich task if any");
            MF_CLASS50_y194();
            F = true;
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "setPreferMobileConnection : creating StopUsingHipriTask.");
            (new StopUsingHipriTask(this, null)).execute(new Void[0]);
            return;
        } else
        {
        	mIndoorAltas.onNetworkChangeComplete(true);
            return;
        }
    }

    public void tearDown() throws Exception
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "tearDown called");
        BackgroundCalibratorController.MF_CLASS9_b23(this);
        if(MF_CLASS50_w192 != null)
            MF_CLASS50_w192.stopBackgroundCalibration(false, 0L);
        if(mSensorReader != null)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "tearDown: calling stopSensors");
            mSensorReader.stopSensors(true, true);
            mSensorReader.quit();
            mSensorReader = null;
        }
    }

    public void doStopSessionDueToError(int i, String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStopSessionDueToError() called, calling synchronized stopPositioning()");
        int j = CLASS43.MF_CLASS43_a152(i);
        String s1 = "";
        if(j != i)
            s1 = (new StringBuilder()).append(" (Internal error code: ").append(j).append(")").toString();
        if(s.startsWith("Error: value already present"))
        	mIndoorAltas.onServiceFailure(j, (new StringBuilder()).append("Communication error.").append(s1).toString());
        else
        	mIndoorAltas.onServiceFailure(j, (new StringBuilder()).append(s).append(s1).toString());
        stopPositioning();
    }

    public void postCalibInvalidThread(Context context)
    {
        (new Handler(context.getMainLooper())).post(new CalibInvalidThread(this));
    }

    public void MF_CLASS369_b995(String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "relayCalibrationError() called.");
        mIndoorAltas.onCalibrationFailed(s);
    }

    public void MF_CLASS49_b169(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "wifiSingleScanAvailable called.");
    }

    public void MF_CLASS369_b995(boolean flag)
    {
        MF_CLASS19_c69 = flag;
    }

    public void relayPositioningWarning(String s)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("relayPositioningWarning() called, calling synchronized stopPositioning(), message = ").append(s).toString());
        mIndoorAltas.onServiceFailure(0, s);
    }

    public void MF_CLASS19_c69(boolean flag)
    {
        M = flag;
    }

    public boolean isBGCalibrated()
    {
        long l = System.currentTimeMillis();
        CLASS15 class15;
        if(!K.MF_CLASS16_c55() || l - K.MF_CLASS8_d20() >= 0x6ddd00L)
            if((class15 = APIDataBase.selectBGCalibrationFromDB()) == null || l - class15.MF_CLASS15_f50() >= 0x6ddd00L)
                return false;
        return true;
    }

    public float getCommunicationLatency()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "getCommunicationLatency() called");
        if(mWebSocketConnectionThread != null && MF_CLASS50_q186())
        {
            float f = (float)(500 + 500 * (mWebSocketConnectionThread.MF_CLASS85_b316() + mWebSocketConnectionThread.getQueueSize())) / 1000F;
            CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("getCommunicationLatency() returning bufferDurSeconds = ").append(f).toString());
            return f;
        } else
        {
            return -1F;
        }
    }

    public int MF_Some3EventBase_e005()
    {
        if(mWebSocketConnectionThread != null && MF_CLASS50_q186())
            return mWebSocketConnectionThread.MF_CLASS85_b316() + mWebSocketConnectionThread.getQueueSize();
        else
            return -1;
    }

    public void onConnect()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "onConnect() called, calling connectionService.initializeSession()");
        CLASS75.MF_CLASS75_a259(4, "WEBSOCKET_CONNECTED", RemoteImplementation.class, "RemoteImplementation: onConnect");
        if(MF_CLASS50_q186()) {
            try
            {
                CLASS75.MF_CLASS75_b260("RemoteImplementation", "onConnect: session *ALREADY* alive --> skipping");
            }
            catch(Exception class1)
            {
            	class1.printStackTrace();

            	CLASS75.MF_CLASS75_b260("RemoteImplementation", "onConnect() : failed to initialize session, calling informPositioningStartFailed()");
                CLASS75.MF_CLASS75_a259(5, "POSITIONING_INIT_FAILED", RemoteImplementation.class, "RemoteImplementation: onConnect");
                MF_CLASS19_e71("Session initialization failed. Could not connect to cloud service.");
            }
        } else {
	        CLASS75.MF_CLASS75_b260("RemoteImplementation", "onConnect: session not yet alive --> calling connectionService.initializeSession()");
	        mWebSocketConnectionThread.initializeSession(MF_CLASS50_s188_com_indooratlas_base_CLASS5_fld);
        }

        CLASS75.MF_CLASS75_b260("RemoteImplementation", "onConnect() done.");
        return;
    }

    public void onDisConnect()
    {
        PositioningState class57 = getPositioningState();
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("onDisConnect() called: WebSocketConnectionService could not reconnect internally. positioningState = ").append(class57).toString());
        if(class57 == PositioningState.ACTIVE || class57 == PositioningState.INITIALIZING)
        {
            CLASS75.MF_CLASS75_a259(5, "WEBSOCKET_DISCONNECTED", RemoteImplementation.class, "RemoteImplementation: onDisconnect");
            MF_CLASS19_a67(2001, "Connection could not be established or was lost, could not reconnect.");
        }
    }

    public void onInitializationSuccessful()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "onInitializationSuccessful() called, calling serviceListener.onServiceInitialized");
        WAITINGType(true);
        long l = SystemClock.elapsedRealtime() - MF_CLASS50_w192();
        CLASS75.MF_CLASS75_a259(4, "POSITIONING_INIT_OK", RemoteImplementation.class, (new StringBuilder()).append("RemoteImplementation: onInitializationSuccessful: init took: ").append(l).toString());
        MF_CLASS369_b995(true);
        mSensorDataProcessorTH = new SensorDataProcessorThread(mSensorReader, this);
        mSensorDataProcessorTH.start();
        mIndoorAltas.onServiceInitialized();
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "onInitializationSuccessful() done");
    }

    public PositioningState getPositioningState()
    {
        return mPositioningState;
    }

    public List createGPSSample()
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "createGPSSample(): called.");
        Location location = MF_CLASS50_y194.getLastKnownLocation("network");
        if(location != null)
        {
            CLASS25 class25 = new CLASS25();
            class25.mLatitude = location.getLatitude();
            class25.mLongitude = location.getLongitude();
            class25.mAltitude = location.getAltitude();
            class25.mTimeStamp = location.getTime();
            ArrayList arraylist = new ArrayList();
            arraylist.add(class25);
            return arraylist;
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "createGPSSample(): done.");
            return null;
        }
    }

    public boolean MF_CLASS50_k180()
    {
        return MF_CLASS19_c69;
    }

    public void MF_CLASS50_l181()
    {
    	mStartTimeStamp = SystemClock.elapsedRealtime();
    }

    public void doStopPositioning()
    {
        CLASS3 class3;
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStopPositioning called, synchronized");
        try
        {

	        WAITINGType(false);
	        MF_CLASS369_b995(false);
	        stopSensorsAndScanning();
	        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStopPositioning calling connectionService.stopSession");
	        mWebSocketConnectionThread.MF_CLASS85_a315(false);
	        mWebSocketConnectionThread.stopSession();
	        CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStopPositioning(): called, calling synchronized setPositioningState INACTIVE");
	        setPositioningState(PositioningState.INACTIVE);
	        mStopPositioningTask = null;
	        class3 = mIndoorAltas;
	        if(class3 == null) {
	            CLASS75.MF_CLASS75_b260("RemoteImplementation", " doStopPositioning() done.");
	            return;
	    	}
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "doStopPositioning calling serviceListener.onServiceStopped");
            mIndoorAltas.onServiceStopped();
        }
        catch(Exception exception1) {
        	exception1.printStackTrace();
        }
    }

    public boolean stopUsingHipri()
    {
        int i = 0;

        for(;i<30;i++) {
		    NetworkInfo networkinfo1;
		    int j = MF_CLASS50_x193.stopUsingNetworkFeature(0, "enableHIPRI");
		    CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("stopUsingHipri HIPRI turned off, result = ").append(j).toString());
		    networkinfo1 = MF_CLASS50_x193.getNetworkInfo(5);
		    if(networkinfo1 != null) {
		        android.net.NetworkInfo.State state = networkinfo1.getState();
		        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("stopUsingHipri : checkState = ").append(state).append(", counter = ").append(i).toString());
		        if(state.compareTo(android.net.NetworkInfo.State.DISCONNECTED) != 0){
		        	continue;
		        }
		        CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopUsingHipri : HIPRI tear down successful");
		    }
		    try {
		    	Thread.sleep(100L);
		    } catch(Exception ex) {
		    	ex.printStackTrace();
		    }
    	}
	    NetworkInfo networkinfo = MF_CLASS50_x193.getNetworkInfo(5);
        if(networkinfo != null) {
	        if(networkinfo.getState().compareTo(android.net.NetworkInfo.State.DISCONNECTED) == 0) {
		        CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopUsingHipri : AFTER LOOP: HIPRI tear down successful");
		        return true;
	        }
        }

        CLASS75.MF_CLASS75_b260("RemoteImplementation", "stopUsingHipri : AFTER LOOP: HIPRI tear down **FAILED**");
        return false;

    }

    public void notifyCalibrationDone(CalibrationEvent class18, CLASS24 class24)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifyCalibrationDone(): called");
        MF_CLASS19_a67 = class24;
        if(class18.getCalibrationStatus() == CLASS19.READY)
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifyCalibrationDone(), result == CalibrationResult.READY --> uploading calibration.");
            WAITINGType = 0;
        } else
        {
            CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifyCalibrationDone(), result NOT CalibrationResult.READY --> informing onCalibrationFailed.");
            if(class18.getCalibrationStatus() == CLASS19.FAILED)
            	mIndoorAltas.onCalibrationFailed("Device not moved enough. Please rotate around all three axes.");
            else
            	mIndoorAltas.onCalibrationFailed("Error in calibration.");
        }
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifyCalibrationDone done.");
    }

    public void notifySensorError(int i, CLASS369 c)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("notifySensorError() called, type = ").append(i).append(", SensorProcessorState = ").append(c).toString());
        MF_CLASS19_c69(true);
        if(c == CLASS369.CALIBRATING)
        {
            MF_CLASS369_b995("Sensor error.");
            return;
        }
        if(c == CLASS369.BGCALIBRATING)
        {
            MF_CLASS369_b995("Sensor error.");
            return;
        } else
        {
            MF_CLASS19_a67(1002, "Sensor error.");
            return;
        }
    }

    public void notifyTimestampError(CLASS369 c)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "notifyTimestampError() called.");
        if(c == CLASS369.CALIBRATING)
        {
            MF_CLASS369_b995("Sensor timestamp error.");
            return;
        } else
        {
        	doStopSessionDueToError(1002, "Session stopped due to a sensor error.");
            return;
        }
    }

    public CLASS8 MF_CLASS50_o184()
    {
        return K;
    }

    public void updateCalibrationStatus(CalibrationEvent class18)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "updateCalibrationStatus(): called");
        if(class18.getCalibrationStatus() == CLASS19.DISCARDING)
        {
            CLASS40 class40 = new CLASS40(INDOORTYPE.RESTARTED, class18.MF_CLASS18_b62());
            mIndoorAltas.onCalibrationStatus(class40);
        } else
        {
            if(class18.getCalibrationStatus() == CLASS19.IN_PROGRESS)
            {
                CLASS40 class40_1 = new CLASS40(INDOORTYPE.ONGOING, class18.MF_CLASS18_b62());
                mIndoorAltas.onCalibrationStatus(class40_1);
                return;
            }
            if(class18.getCalibrationStatus() == CLASS19.WAITING)
            {
                CLASS40 class40_2 = new CLASS40(INDOORTYPE.WAITINGCALIBRATION, class18.MF_CLASS18_b62());
                mIndoorAltas.onCalibrationStatus(class40_2);
                return;
            }
        }
    }

    private ExecutorService A;
    private StartPositioningTask mStartPositioningTask;
    private AsyncTask mStopPositioningTask;
    private boolean D;
    private RefreshHipriTask mRefreshHipriTask;
    private boolean F;
    private long G;
    private RemoteImplementation H;
    private boolean I;
    private SensorDataProcessorThread mSensorDataProcessorTH;
    private CLASS8 K;
    private long L;
    private boolean M;
    private long N;
    private boolean O;
    private long P;
    private boolean Q;
    private boolean MF_CLASS50_r187_boolean_fld;
    private CLASS5 MF_CLASS50_s188_com_indooratlas_base_CLASS5_fld;
    CLASS24 MF_CLASS19_a67;
    private boolean MF_CLASS369_b995;
    private boolean MF_CLASS19_c69;
    private int WAITINGType;
    private long mStartTimeStamp;
    private long MF_CLASS25_f99;
    private long MF_CLASS46_g163;
    private String MF_CLASS24_h93;
    private String MF_CLASS50_i178;
    private String mLevelId;
    private String MF_CLASS50_k180;
    private String MF_CLASS50_l181;
    private ConcurrentLinkedQueue mQueueWifiData;
    private Context MF_CLASS50_n183;
    private CLASS42 MF_CLASS50_o184;
    private DateFormat MF_CLASS50_p185;
    private PositioningState mPositioningState;
    private Timer mTimer;
    private CLASS3 mIndoorAltas;
    private WifiScanBroadcastReceiver MF_CLASS50_t189;
    private SensorReader mSensorReader;
    private WebsocketConnectionThread mWebSocketConnectionThread;
    private BackgroundCalibratorController MF_CLASS50_w192;
    private ConnectivityManager MF_CLASS50_x193;
    private LocationManager MF_CLASS50_y194;
    private TelephonyManager MF_CLASS50_z195;
}
