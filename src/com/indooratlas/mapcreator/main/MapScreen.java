// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.*;
import android.content.*;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.*;
import android.os.*;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.*;

import com.indooratlas.Calibrator.*;
import com.indooratlas.algorithm.cpa;
import com.indooratlas.base.*;
import com.indooratlas.cursor.list.CLASS22;
import com.indooratlas.cursor.list.CLASS24;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.*;
import com.indooratlas.position.*;
import com.indooratlas.sensor.CLASS370;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.sensor.SensorReader;
import com.indooratlas.sensor.type.CLASS369;
import com.indooratlas.sensor.type.CLASS48;
import com.indooratlas.types.*;
import com.indooratlas.wifiroaming.CLASS198;
import com.indooratlas.wifiroaming.WifiRoamingScanReceiver;

import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class MapScreen extends Activity
    implements CLASS3, IBGCalibration, CLASS195, CLASS197, CLASS48, CLASS198
{

    public MapScreen()
    {
        S = false;
        T = 0;
        mUpdatingLocation = false;
        mInitializingPositioning = false;
        mLabelRoutePoints = false;
        mPositioningStartTime = 0L;
        U = "";
        mConnectedVsStrongestWiFiAP = "";
        mRecordingSegment = false;
        mRecordingCancelled = false;
        aa = 0L;
        mFlashStop = null;
        MF_CLASS19_b68 = null;
        mScreenPointType = POINT_TYPE.DEFAULT;
        mMode = CLASS314.SEGMENT_DATA;
        mStartMeasure = null;
        ai = null;
        aj = 0;
        ak = 0;
        al = 0L;
        an = null;
        ao = null;
        aq = 25;
        ar = 0.052359877559829883D;
        as = 0.5D;
        at = 0.5D;
        au = 2D;
        av = 50D;
        aw = 25F;
        ax = -1;
        ay = 500;
        az = 0L;
        aA = 0.0F;
        aB = false;
        aC = false;
        aD = 0.0F;
        aE = 0.0F;
        matrix = new Matrix();
        MF_CLASS19_d70 = new Matrix();
        mTouchMode = TouchMode.NONE;
        MF_CLASS19_e71 = 0.0F;
        MF_CLASS159_f577 = 0.0F;
        MF_CLASS22_g77 = new PointF();
        MF_CLASS159_h579 = new PointF();
        MF_CLASS108_i455 = 1.0F;
        MF_CLASS108_j456 = 0.05F;
        MF_CLASS108_k457 = 30F;
        MF_CLASS108_l458 = 0.3F;
        mCurrentZoom = 1.0F;
        m = 1.0F;
        MF_CLASS108_n460 = 1.0F;
        MF_CLASS108_o461 = 0.0F;
        MF_CLASS108_p462 = 0.0F;
        MF_CLASS108_q463 = 0.0F;
        r = 0.0F;
        s = 0.0F;
        mCumulativeRotation = 0.0F;
        mVibrator = null;
        aG = false;
        mBitmap = null;
        mBitmapScale = 1;
        aH = false;
        aI = false;
        aJ = false;
        aK = false;
        aL = false;
        aM = false;
        aN = false;
        t = null;
        aO = null;
        mMe = this;
        mPrefsChanged = false;
        mScrollToPosition = true;
        mTurnMapAutomatically = false;
        mSmoothBetweenPrevAndCurrentPosition = false;
        aP = false;
        u = null;
        v = 0x927c0L;
        mFilesBeingWritten = Integer.valueOf(0);
        w = 0;
        x = 0L;
        y = 0;
        A = "";
        B = "";
        C = "";
        mLastSuccesfulLocationUpdateTimestamp = 0L;
        D = 0L;
        E = false;
        F = 0;
        mPositionCnt = 0L;
        H = "";
        I = "";
        J = "";
        K = "";
        mLastRountrip = 0L;
        mCookie = null;
        mUserName = "";
        mPassword = "";
        mApiKey = "";
        mSecret = "";
        L = null;
        M = null;
        N = false;
        aQ = null;
        aR = 0;
        aS = 0;
        aT = false;
        aV = false;
        aW = false;
        aX = null;
        aY = false;
        aZ = false;
        mMaxImageWidthHWAccel = 0.0F;
        mMaxImageHeightHWAccel = 0.0F;
        mNaviButton = null;
        ba = 0;
        bb = 0;
        mUploadingGenerationInProgress = false;
        bd = "";
        be = 0.0F;
        bf = 0.0F;
        mBufferedReader = null;
        P = null;
        bg = null;
        bh = 0L;
        bi = true;
        mLastUIUpdateTimestamp = 0L;
        bl = 0L;
        mAlertDialog2 = null;
        bm = 0L;
        localTouchListener = new MapScreenOnTouchListener(this);
        bn = null;
    }

    static boolean A(MapScreen mapscreen)
    {
        return mapscreen.aY;
    }

    static boolean B(MapScreen mapscreen)
    {
        return mapscreen.aZ;
    }

    static float C(MapScreen mapscreen)
    {
        return mapscreen.aA;
    }

    static int D(MapScreen mapscreen)
    {
        return mapscreen.ax;
    }

    static int E(MapScreen mapscreen)
    {
        return mapscreen.ay;
    }

    static double F(MapScreen mapscreen)
    {
        return mapscreen.av;
    }

    static double G(MapScreen mapscreen)
    {
        return mapscreen.at;
    }

    static double H(MapScreen mapscreen)
    {
        return mapscreen.au;
    }

    static double I(MapScreen mapscreen)
    {
        return mapscreen.as;
    }

    static void J(MapScreen mapscreen)
    {
        mapscreen.r();
    }

    static boolean K(MapScreen mapscreen)
    {
        return mapscreen.S;
    }

    static float L(MapScreen mapscreen)
    {
        return mapscreen.be;
    }

    static long M(MapScreen mapscreen)
    {
        return mapscreen.bh;
    }

    static int N(MapScreen mapscreen)
    {
        int i = mapscreen.T;
        mapscreen.T = i + 1;
        return i;
    }

    static int O(MapScreen mapscreen)
    {
        return mapscreen.T;
    }

    static SensorController getSensorController(MapScreen mapscreen)
    {
        return mapscreen.mSensorController;
    }

    static void doubleTap(MapScreen mapscreen)
    {
        mapscreen.onDoubleTap();
    }

    static WalkViewDialogFragment R(MapScreen mapscreen)
    {
        return mapscreen.bq;
    }

    static boolean S(MapScreen mapscreen)
    {
        return mapscreen.aM;
    }

    static void sHideDownloadFloorplanProgressDialog(MapScreen mapscreen)
    {
        mapscreen.hideDownloadFloorplanProgressDialog();
    }

    static void U(MapScreen mapscreen)
    {
        mapscreen.MF_CLASS108_i455();
    }

    static void sShowImageDownloadRetryDialog(MapScreen mapscreen)
    {
        mapscreen.showImageDownloadRetryDialog();
    }

    static long W(MapScreen mapscreen)
    {
        long l = mapscreen.aa;
        mapscreen.aa = 1L + l;
        return l;
    }

    static long X(MapScreen mapscreen)
    {
        return mapscreen.aa;
    }

    static MenuItem getRecordingItem(MapScreen mapscreen)
    {
        return mapscreen.mRecordingItem;
    }

    static ProgressDialog Z(MapScreen mapscreen)
    {
        return mapscreen.mProgressDialog2;
    }

    static float MF_CLASS19_a67(MapScreen mapscreen, float f)
    {
        mapscreen.aA = f;
        return f;
    }

    static long MF_CLASS19_a67(MapScreen mapscreen, long l)
    {
        mapscreen.az = l;
        return l;
    }

    static AlertDialog MF_CLASS19_a67(MapScreen mapscreen, AlertDialog alertdialog)
    {
        mapscreen.mAlertDialog = alertdialog;
        return alertdialog;
    }

    static IndoorAtlas MF_CLASS19_a67(MapScreen mapscreen, IndoorAtlas some3eventbase)
    {
        mapscreen.mIndoorAtlas = some3eventbase;
        return some3eventbase;
    }

    static CLASS110 MF_CLASS19_a67(MapScreen mapscreen, CLASS110 class110)
    {
        mapscreen.ai = class110;
        return class110;
    }

    static WifiScanReceiver MF_CLASS19_a67(MapScreen mapscreen)
    {
        return mapscreen.am;
    }

    static TouchMode MF_CLASS19_a67(MapScreen mapscreen, TouchMode class317)
    {
        mapscreen.mTouchMode = class317;
        return class317;
    }

    private List getNotContained(List list, List list1)
    {
        ArrayList arraylist;
        Iterator iterator;
        if(list == null || list1 == null)
            return null;
        arraylist = new ArrayList();
        iterator = list1.iterator();

        Measurement class108;
        boolean flag;

        for(;iterator.hasNext();) {
	        class108 = (Measurement)iterator.next();
	        Iterator iterator1 = list.iterator();
	        Measurement class108_1;
	        class108_1 = (Measurement)iterator1.next();
	        if(class108_1.segmentID.equals(class108.segmentID)) {
	        	CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getNotContained found contained segment: ").append(class108_1.segmentID).append(", ").append(class108.segmentID).toString());
	        } else {
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getNotContained returning false, not contained: ").append(class108.segmentID).toString());
	            arraylist.add(class108);
	        }
        }
        return arraylist;
    }

    private void focusLineInMiddleOfFloorplan(float f, float f1, float f2, float f3)
    {
        float f4 = CLASS72.MF_CLASS72_a237(f1, f, f3, f2);
        float f5 = (float)Math.toDegrees(f4);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("focusLineInMiddleOfFloorplan(): ang = ").append(f4).append(", andDeg = ").append(f5).toString());
        int i = (int)(f + f1) / 2;
        int j = (int)(f2 + f3) / 2;
        float f6 = mIndoorMapView.getEuclideanDistance(f, f2, f1, f3);
        float f7 = 100 + 2 * getActionBar().getHeight();
        mCurrentZoom = ((float)mIndoorMapView.getHeight() - f7) / ((1.0F / (float)mBitmapScale) * (2.0F * f6));
        if(mCurrentZoom > 30F)
            mCurrentZoom = 30F;
        if(mCurrentZoom <= 0.05F)
            mCurrentZoom = 0.05F;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("focusLineInMiddleOfFloorplan(): middleX = ").append(i).append(", middleY = ").append(j).append(", mCurrentZoom = ").append(mCurrentZoom).append(", mIndoorMapView.getHeight() = ").append(mIndoorMapView.getHeight()).append(", extraRoom = ").append(f7).append(", mBitmapScale = ").append(mBitmapScale).append(", segLenOrigimageCoords = ").append(f6).toString());
        mIndoorMapView.setPosition(i, j, f5);
    }

    private void disableAllExceptRecordingMenuItems(Menu menu)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "disableAllExceptRecordingMenuItems called");
        MenuItem menuitem = menu.findItem(0x7f0b0025);
        menuitem.setEnabled(true);
        menuitem.setIcon(0x7f020008);
        menuitem.setTitle(0x7f08002d);
        menu.findItem(0x7f0b0026).setEnabled(false);
        menu.findItem(0x7f0b0027).setEnabled(false);
        menu.findItem(0x7f0b0028).setEnabled(false);
        menu.findItem(0x7f0b002b).setEnabled(false);
        menu.findItem(0x7f0b002c).setEnabled(false);
        menu.findItem(0x7f0b0030).setEnabled(false);
        menu.findItem(0x7f0b002f).setEnabled(false);
        menu.findItem(0x7f0b002a).setEnabled(false);
        menu.findItem(0x7f0b0029).setEnabled(false);
    }

    private void MF_CLASS19_a67(Measurement class108)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(0x7f080052);
        Date date = new Date(class108.mStartTimestamp);
        String s1 = z.format(date);
        Date date1 = new Date(class108.EndTimestamp);
        String s2 = z.format(date1);
        String s3 = mRestClient.formatMeasurementFileString(class108);
        List list = MeasurementDataSource.getMeasurementWifiScans(class108);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("ID : ").append(Long.valueOf(class108.mMeasurementID)).append("\nBuilding : ").append(class108.bID).append((new StringBuilder()).append("\nLevel : ").append(class108.lID).toString()).append("\nGraphics : ").append(class108.gID).append("\nUser : ").append(class108.userId).append("\nStart : ").append(s1).append("\nEnd : ").append(s2).append("\nBackend ID : ").append(class108.segmentID).append("\nValidation path : ").append(class108.TestSegment).append("\nCurved : ").append(class108.mBezier).append("\nLabel : ").append(class108.mLabel).append("\nNum Wifi scans : ").append(list.size()).append("\nFile : ").append(s3);
        builder.setMessage(stringbuilder).setCancelable(false).setPositiveButton("Ok", new CLASS265(this));
        builder.create().show();
    }

    static void MF_CLASS19_a67(MapScreen mapscreen, Measurement class108)
    {
        mapscreen.MF_CLASS19_a67(class108);
    }

    static void setMapState(MapScreen mapscreen, POINT_TYPE class316)
    {
        mapscreen.setState(class316);
    }

    static void MF_CLASS19_a67(MapScreen mapscreen, String s1)
    {
        mapscreen.showNextActionHelp(s1);
    }

    static void MF_CLASS19_a67(MapScreen mapscreen, String s1, String s2, String s3)
    {
        mapscreen.MF_CLASS19_a67(s1, s2, s3);
    }

    private void setState(POINT_TYPE class316)
    {
        try {
    	CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setState() called with state = ").append(class316).toString());
        CLASS167.MF_CLASS167_b635("TESTI", (new StringBuilder()).append("setState() called with state = ").append(class316).toString());
        mScreenPointType = class316;
        if(mMaxImageWidthHWAccel == 0.0F) {
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setState() mMaxImageWidthHWAccel = ").append(mMaxImageWidthHWAccel).append(" --> keeping accel un-touched").toString());
        } else {
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setState() mMaxImageWidthHWAccel = ").append(mMaxImageWidthHWAccel).append(" --> setting HW accel OFF").toString());
	        mIndoorMapView.setLayerType(1, null);
        }

        if(class316 == POINT_TYPE.DEFAULT) {
	        N = false;
	        aL = false;
	        invalidateOptionsMenu();
	        MF_CLASS108_p462();
	        if(mRecordingItem != null)
	        	mRecordingItem.setIcon(0x7f020006);
	        mIndoorMapView.showSegments();
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setState(): mRecordingSegment = ").append(mRecordingSegment).append(", mRecordingCancelled = ").append(mRecordingCancelled).toString());
	        if(!mRecordingSegment || mRecordingCancelled) {
		            if(!mRecordingSegment || !mRecordingCancelled) {
		            	mStartMeasure = null;
	    		        mIndoorMapView.clearPoints();
		            } else {
			            CLASS167.MF_CLASS167_b635("MapScreen", "setState(): cancelling recording.");
			            showToastMessage("Recording cancelled.", 1);
			            stopRecording(true);
			            mRecordingCancelled = false;
			        }
	        } else {
	        	stopRecording(false);
	        }
	        mEndMeasure = null;
        } else if(class316 == POINT_TYPE.FIRST_POINT) {
            showStatusText("Give first point");
            mIndoorMapView.clearPoints();
            invalidateOptionsMenu();
            if(getReCalibrationRequired())
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "setState(): MGN accuracy event occurred during recording previous segment force re-calibration");
                showReCalibrationDueToAccuracyDialog();
            }
            if(aI)
            	showNextActionHelp(getString(0x7f080015));
        } else if(class316 == POINT_TYPE.FIRST_POINT_GIVEN) {
        	showStatusText("Adjust first point position");
        } else if(class316 == POINT_TYPE.SECOND_POINT) {
            showStatusText("Give second point");
            if(aI)
            	showNextActionHelp(getString(0x7f080018));
        } else if(class316 == POINT_TYPE.SECOND_POINT_GIVEN) {
	        showStatusText("Press REC to record segment");
	        String s1 = "not null";
	        if(mEndMeasure == null)
	            s1 = "null";
	        CLASS167.MF_CLASS167_b635("TESTI", (new StringBuilder()).append("MapScreen.onTouch() called, mCurrentState == State.SECOND_POINT_GIVEN, mSegmen is ").append(s1).toString());
	        mIndoorMapView.setSegment(mEndMeasure);
	        invalidateOptionsMenu();
	        if(aI)
	        {
	        	showNextActionHelp(getString(0x7f080018));
	        	showNextActionHelp(getString(0x7f080019));
	            aI = false;
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "setState(): Second point added --> starting sensors");
	        mSensorController.startSensors(true);
        } else if(class316 == POINT_TYPE.TEST_POINTS) {
            showStatusText("Mark test path.");
            mIndoorMapView.clearPoints();
            invalidateOptionsMenu();
        } else if(class316 == POINT_TYPE.RECORDING) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.setState(): RECORDING");
	        mIndoorMapView.hideSegments();
	        mSensorController.MF_CLASS158_a563 = false;
	        MF_CLASS108_p462();
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): RECORDING mMaxImageWidthHWAccel = ").append(mMaxImageWidthHWAccel).append(" --> setting HW accel ON").toString());
	        mIndoorMapView.setLayerType(1, null);
	        showStatusText("Press Stop to send segment.\nClick on screen to mark the route while walking.");
	        mRecordingSegment = true;
	        mRecordingCancelled = false;
	        if(mSensorController.startDataCollection()) {
	            NetworkInfo networkinfo;
	            NetworkInfo networkinfo1;
	            boolean flag = ((WifiManager)getSystemService("wifi")).isWifiEnabled();
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): starting recording: wifiEnabled = ").append(flag).toString());
	            ConnectivityManager connectivitymanager = (ConnectivityManager)getSystemService("connectivity");
	            networkinfo = connectivitymanager.getNetworkInfo(1);
	            networkinfo1 = connectivitymanager.getNetworkInfo(0);
	            boolean flag1;
	            if(networkinfo1 == null)
	                flag1 = false;
	            else
	            	flag1 = networkinfo1.isConnected();
	    		boolean flag2;
	            if(networkinfo == null) {
	            	flag2 = false;
	            } else {
	            	flag2 = networkinfo.isConnected();
	            }
	            Measurement class108;
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): starting recording: mobileConnected = ").append(flag1).toString());
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): starting recording: wifiConnected = ").append(flag2).toString());
	            if(!checkScanModeOnly(false))
	            {
	                boolean flag4 = ensureWifiEnabled();
	                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): starting recording: result of ensureWifiEnabled = ").append(flag4).toString());
	                takeWifiScanLock();
	            }
	            registerReceiver(am, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
	            boolean flag3 = am.MF_CLASS108_a447();
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): wifi scanning started, res = ").append(flag3).toString());
	            class108 = new Measurement();
	            class108.bID = mCurrentBuilding.getBuildingID();
	            class108.lID = mCurrentLevel.getLevelID();
	            class108.gID = mGraphics.getGraphicsID();
	            class108.coordSys = "image";
	            class108.mDeviceModel = mDevice.MF_CLASS100_a386;
	            class108.userId = "";
	            class108.mStartTimestamp = 0L;
	            class108.EndTimestamp = 0L;
	            class108.mSentToServer = 0L;
	            if(mMode != CLASS314.SEGMENT_DATA) {
	                class108.mPoints = mStartMeasure.mPoints;
	                class108.TestSegment = 1;
	                showToastMessage(getString(0x7f08001f), 1);
	                mIndoorMapView.setInitialRotation();
	                focusLineInMiddleOfFloorplan(((CheckPoint)mStartMeasure.mPoints.get(0)).coordX, ((CheckPoint)mStartMeasure.mPoints.get(1)).coordX, ((CheckPoint)mStartMeasure.mPoints.get(0)).coordY, ((CheckPoint)mStartMeasure.mPoints.get(1)).coordY);
	            } else {
	    	        class108.mPoints = mEndMeasure.mPoints;
	    	        class108.TestSegment = 0;
	    	        class108.mBezier = mIndoorMapView.currentSegment.mBezier;
	            }

	            currentMeasurement = MeasurementDataSource.storeMeasurement(class108);

	            if(mMode != CLASS314.SEGMENT_DATA) {
	                mIndoorMapView.e.mMeasurementID = currentMeasurement.mMeasurementID;
	                mIndoorMapView.e.TestSegment = 1;
	    	    } else {
	    	        mIndoorMapView.currentSegment.mMeasurementID = currentMeasurement.mMeasurementID;
	    	        mIndoorMapView.currentSegment.TestSegment = 0;
	    	    }
	            mFlashStop = new FlashStopButtonTask(this);
	            mFlashStop.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
	            u = (new CLASS253(this, v, 0x493e0L)).start();

	        } else {
	        	setState(POINT_TYPE.DEFAULT);
		        showToastMessage("Failed to start sensors, please check device model compatibility with IndoorAtlas.", 1);
	        }
        } else if(class316 == POINT_TYPE.POSITIONING) {
  	        invalidateOptionsMenu();
  	        mIndoorMapView.clearPoints();
  	        mIndoorMapView.hideSegments();
  	        onDoubleTap();
  	        mSensorController.stopSensors(true);
  	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.setState(): POSITIONING mMaxImageWidthHWAccel = ").append(mMaxImageWidthHWAccel).append(" --> setting HW accel ON").toString());
  	        mIndoorMapView.setLayerType(1, null);
  	        CLASS167.MF_CLASS167_b635("MapScreen", "setState: *not* requiring calib, calling showWalkView.");
  	        showWalkViewAndStartPositioning();
        }
        return;

    } catch(Exception exception1) {
        if(CLASS113.isExceptionLogged.booleanValue())
            exception1.printStackTrace();
        showToastMessage("Failed to start sensors. Please try again.", 2000);
    }

    }

    private void showCancellableWaitDialog(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showCancellableWaitDialog() called.");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Cancel", new CLASS287(this));
        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    private void MF_CLASS19_a67(String s1, String s2, String s3)
    {
    	mSensorController.MF_CLASS375_c1047(false);
        mRestClient.MF_CLASS108_c449(s1, s2, s3);
    }

    private void stopPositioning(boolean flag)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.stopPositioning() called ");
        hideWalkView();
        hideConnectionIndicator();
        hideRotateIcon();
        if(mScreenPointType != POINT_TYPE.POSITIONING)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.stopPositioning() called, but ignoring, because mCurrentState != State.POSITIONING");
            return;
        }
        aL = true;
        invalidateOptionsMenu();
        int _tmp = (int)(System.currentTimeMillis() - mPositioningStartTime) / 1000;
        mUpdatingLocation = false;
        mIndoorMapView.setPositioning(false);
        if(flag)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "stopPositioning, calling synchronized mIndoorAtlas.stopPositioning()");
            mIndoorAtlas.stopPositioning();
        }
        mIndoorMapView.showSegments();
        updateBGCalibIconVisibility();
        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.stopPositioning() done.");
    }

    private boolean MF_CLASS19_a67()
    {
        if(mScreenPointType != POINT_TYPE.RECORDING || mMode != CLASS314.TEST_DATA || aB || aC)
            return false;
        CLASS167.MF_CLASS167_b635("MapScreen", "onKeyDown(): mCurrentState == State.RECORDING && mMode == Mode.TEST_DATA --> adding new checkpoint timestamp.");
        try {
	        while(aj < -2 + mStartMeasure.mPoints.size()) {

		        CheckPoint class112 = (CheckPoint)currentMeasurement.mPoints.get(1 + aj);
		        focusLineInMiddleOfFloorplan(((CheckPoint)mStartMeasure.mPoints.get(1 + aj)).coordX, ((CheckPoint)mStartMeasure.mPoints.get(2 + aj)).coordX, ((CheckPoint)mStartMeasure.mPoints.get(1 + aj)).coordY, ((CheckPoint)mStartMeasure.mPoints.get(2 + aj)).coordY);
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Checkpoint = ").append(class112.hashCode()).toString());
		        class112.CheckPointTimestamp = System.nanoTime() - mSensorController.MF_CLASS375_c1047;
		        mIndoorMapView.invalidate();
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Checkpoint.mTimestamp = ").append(class112.CheckPointTimestamp).toString());
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Checkpoint : currentMeasurement.mPoints.get(mCheckPointCnt+1).mTimestamp = ").append(((CheckPoint)currentMeasurement.mPoints.get(1 + aj)).CheckPointTimestamp).toString());
		        aj = 1 + aj;
		        showToastMessage((new StringBuilder()).append(getString(0x7f080020)).append(" ").append(aj).toString(), 0);
	        }

	        if(aj >= -2 + mStartMeasure.mPoints.size())
	        {
	            onRecordButtonClick();
	            return true;
	        }
	        return false;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
        return false;
    }

    static boolean MF_CLASS19_a67(MapScreen mapscreen, boolean flag)
    {
        mapscreen.bi = flag;
        return flag;
    }

    static boolean MF_CLASS19_a67(MapScreen mapscreen, float af1[])
    {
        return mapscreen.MF_CLASS19_a67(af1);
    }

    private boolean MF_CLASS19_a67(float af1[])
    {
        float af2[] = getOriginalImageSize();
        return af1[0] <= af2[0] && af1[1] <= af2[1] && af1[0] > 0.0F && af1[1] > 0.0F;
    }

    static int aa(MapScreen mapscreen)
    {
        return mapscreen.mRouteFetchCount;
    }

    static AlertDialog ab(MapScreen mapscreen)
    {
        return mapscreen.mAlertDialog;
    }

    static void ac(MapScreen mapscreen)
    {
        mapscreen.MF_CLASS24_c88();
    }

    static void ad(MapScreen mapscreen)
    {
        mapscreen.MF_CLASS19_e71();
    }

    static int ae(MapScreen mapscreen)
    {
        return mapscreen.bb;
    }

    static void sHandleStoringMapData(MapScreen mapscreen)
    {
        mapscreen.handleStoringMapData();
    }

    static void sHandleStoringTestData(MapScreen mapscreen)
    {
        mapscreen.handleStoringTestData();
    }

    static int ah(MapScreen mapscreen)
    {
        int i = mapscreen.bb;
        mapscreen.bb = i + 1;
        return i;
    }

    static boolean ai(MapScreen mapscreen)
    {
        return mapscreen.bi;
    }

    static float MF_CLASS19_b68(MapScreen mapscreen, float f)
    {
        mapscreen.aD = f;
        return f;
    }

    static long MF_CLASS19_b68(MapScreen mapscreen, long l)
    {
        mapscreen.bh = l;
        return l;
    }

    static Measurement setEndMeasurement(MapScreen mapscreen, Measurement class108)
    {
        mapscreen.mEndMeasure = class108;
        return class108;
    }

    static IndoorMapView getIndoorMapView(MapScreen mapscreen)
    {
        return mapscreen.mIndoorMapView;
    }

    static String MF_CLASS19_b68(MapScreen mapscreen, String s1)
    {
        mapscreen.U = s1;
        return s1;
    }

    private List getBESegmentsWithoutRoute(List list)
    {
        if(list == null)
            return null;
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Measurement class108 = (Measurement)iterator.next();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getBESegmentsWithoutRoute : ").append(class108.segmentID).append(" :  m.mPoints.size() = ").append(class108.mPoints.size()).toString());
            if(class108.segmentID != null && class108.segmentID.length() > 1 && class108.mPoints.size() < 2)
            {
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getBESegmentsWithoutRoute adding : ").append(class108.segmentID).toString());
                arraylist.add(class108);
            }
        } while(true);
        return arraylist;
    }

    private void invalidateIndoorMapView()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("invalidateIndoorMapView called, thread = ").append(Thread.currentThread().getName()).toString());
        mIndoorMapView.prepareDraw();
        mIndoorMapView.postInvalidate();
    }

    private void MF_CLASS19_b68(Menu menu)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "disableAllExceptPositioningOnOff called");
        menu.findItem(0x7f0b0025).setEnabled(false);
        menu.findItem(0x7f0b0026).setEnabled(false);
        menu.findItem(0x7f0b0027).setEnabled(false);
        menu.findItem(0x7f0b0028).setEnabled(false);
        menu.findItem(0x7f0b002b).setEnabled(false);
        menu.findItem(0x7f0b002c).setEnabled(false);
        menu.findItem(0x7f0b0030).setEnabled(false);
        menu.findItem(0x7f0b002f).setEnabled(false);
        menu.findItem(0x7f0b002a).setEnabled(false);
        MenuItem menuitem = menu.findItem(0x7f0b0029);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("disableAllExceptPositioningOnOff : mBGCalibrationReady = ").append(isBGCalibrationReady()).toString());
        menuitem.setIcon(0x7f020012);
        menuitem.setEnabled(true);
    }

    static void MF_CLASS19_b68(MapScreen mapscreen, boolean flag)
    {
        mapscreen.stopPositioning(flag);
    }

    private void updateCancellableWaitDialog(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "updateCancellableWaitDialog() called.");
        if(mAlertDialog != null)
            mAlertDialog.setMessage(s1);
    }

    private void stopRecording(boolean flag)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(): abortCollection = ").append(flag).toString());
        showStatusText("Saving record");
        try {
	        mRecordingSegment = false;
	        if(mSensorController != null)
	        	mSensorController.stopDataCollection();
	        unregisterReceiver(am);
	        am.b();
	        giveWifiScanLock();
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording() : mCountDownTimer = ").append(u).toString());
        if(u != null)
            u.cancel();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(): Perhaps going to store segment with Routepoints: ").append(currentMeasurement.MF_CLASS108_a447()).toString());
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(), mSensorController.mSampleIndex = ").append(mSensorController.MF_CLASS158_h567).toString());
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(), mSensorController.mMeasurementStartTime = ").append(mSensorController.MF_CLASS113_b487).toString());
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(), mSensorController.mMeasurementEndTime = ").append(mSensorController.MF_CLASS375_d1048).toString());
        currentMeasurement.mStartTimestamp = mSensorController.MF_CLASS113_b487;
        currentMeasurement.EndTimestamp = mSensorController.MF_CLASS375_d1048;
        CLASS167.MF_CLASS167_b635("MapScreen", "stopRecording(): Perhaps going to store segment, mMeasurementStartTimeNano now always 0");
        ((CheckPoint)currentMeasurement.mPoints.get(0)).CheckPointTimestamp = 0L;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(): Perhaps going to store segment mSensorController.mMeasurementEndTimeNano = ").append(mSensorController.MF_CLASS158_e564).toString());
        ((CheckPoint)currentMeasurement.mPoints.get(-1 + currentMeasurement.mPoints.size())).CheckPointTimestamp = mSensorController.MF_CLASS158_e564 - mSensorController.MF_CLASS375_c1047;
        (new CLASS307(this, flag)).execute(new Void[0]);
        return;
    }

    static float MF_CLASS24_c88(MapScreen mapscreen, float f)
    {
        mapscreen.aE = f;
        return f;
    }

    static IndoorAtlas MF_CLASS24_c88(MapScreen mapscreen)
    {
        return mapscreen.mIndoorAtlas;
    }

    static Measurement setFistMeasure(MapScreen mapscreen, Measurement class108)
    {
        mapscreen.mStartMeasure = class108;
        return class108;
    }

    static String MF_CLASS24_c88(MapScreen mapscreen, String s1)
    {
        mapscreen.bd = s1;
        return s1;
    }

    private void MF_CLASS24_c88()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "hideCancellableWaitDialog() called.");
        if(mAlertDialog != null)
        {
            mAlertDialog.cancel();
            mAlertDialog = null;
        }
    }

    private void MF_CLASS24_c88(Menu menu)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "disableAll called");
        menu.findItem(0x7f0b0025).setEnabled(false);
        menu.findItem(0x7f0b0026).setEnabled(false);
        menu.findItem(0x7f0b0027).setEnabled(false);
        menu.findItem(0x7f0b0028).setEnabled(false);
        menu.findItem(0x7f0b002b).setEnabled(false);
        menu.findItem(0x7f0b002c).setEnabled(false);
        menu.findItem(0x7f0b0030).setEnabled(false);
        menu.findItem(0x7f0b002f).setEnabled(false);
        menu.findItem(0x7f0b0029).setEnabled(false);
        menu.findItem(0x7f0b002a).setEnabled(false);
    }

    private void showNextActionHelp(String s1)
    {
        if(!aK)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "showNextActionHelp: showing help dialog.");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(s1).setCancelable(false).setPositiveButton("Skip tips", new CLASS273(this)).setNegativeButton("Ok", new CLASS272(this));
            builder.create().show();
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "showNextActionHelp: helps are skipped.");
            return;
        }
    }

    private void MF_CLASS24_c88(List list)
    {
        if(list != null)
        {
            Iterator iterator = list.iterator();
            while(iterator.hasNext())
                MeasurementDataSource.storeMeasurement((Measurement)iterator.next());
        }
    }

    static boolean MF_CLASS24_c88(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aN = flag;
        return flag;
    }

    static float MF_CLASS19_d70(MapScreen mapscreen, float f)
    {
        mapscreen.bf = f;
        return f;
    }

    static ProgressDialog MF_CLASS19_d70(MapScreen mapscreen)
    {
        return mapscreen.mProgressDialog1;
    }

    private void reMSCreateTables()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete all local db contents?").setCancelable(false).setPositiveButton("Yes", new CLASS226(this)).setNegativeButton("No", new CLASS306(this));
        builder.create().show();
    }

    private void enableAllMenuItems(Menu menu)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "enableAllMenuItems called");
        menu.findItem(0x7f0b0030).setEnabled(true);
        menu.findItem(0x7f0b002f).setEnabled(true);
        menu.findItem(0x7f0b0026).setEnabled(true);
        menu.findItem(0x7f0b0025).setEnabled(true);
        menu.findItem(0x7f0b0027).setEnabled(true);
        menu.findItem(0x7f0b0028).setEnabled(true);
        menu.findItem(0x7f0b002b).setEnabled(true);
        menu.findItem(0x7f0b002c).setEnabled(true);
        menu.findItem(0x7f0b002a).setEnabled(true);
        MenuItem menuitem = menu.findItem(0x7f0b0029);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("enableAllMenuItems : mBGCalibrationReady = ").append(isBGCalibrationReady()).toString());
        menuitem.setEnabled(true);
    }

    static void sUpdateCancellableWaitDialog(MapScreen mapscreen, String s1)
    {
        mapscreen.updateCancellableWaitDialog(s1);
    }

    private void removeLocalSegmentsFromDBAndMemory(List list)
    {
        if(list == null)
            return;
        Measurement class108;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); mIndoorMapView.removeRecordedSegment(class108))
        {
            class108 = (Measurement)iterator.next();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("removeLocalSegmentsFromDBAndMemory : removing ").append(class108.mMeasurementID).append(", ").append(class108.segmentID).toString());
            MeasurementDataSource.MeasurementdeletedDBWithid(class108.mMeasurementID);
        }

        invalidateIndoorMapView();
    }

    static boolean MF_CLASS19_d70(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aW = flag;
        return flag;
    }

    static float MF_CLASS19_e71(MapScreen mapscreen, float f)
    {
        mapscreen.be = f;
        return f;
    }

    private void MF_CLASS19_e71()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Upload to IndoorAtlas?").setCancelable(false).setPositiveButton("Yes", new CLASS229(this)).setNegativeButton("No", new CLASS228(this));
        builder.create().show();
    }

    static boolean MF_CLASS19_e71(MapScreen mapscreen)
    {
        return mapscreen.aN;
    }

    static boolean MF_CLASS19_e71(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aY = flag;
        return flag;
    }

    static CalibrationDialogFragment MF_CLASS159_f577(MapScreen mapscreen)
    {
        return mapscreen.br;
    }

    private void MF_CLASS159_f577()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete all paths from the current floorplan, including paths stored to IndoorAtlas?").setCancelable(false).setPositiveButton("Yes", new CLASS231(this)).setNegativeButton("No", new CLASS230(this));
        builder.create().show();
    }

    static boolean MF_CLASS159_f577(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aZ = flag;
        return flag;
    }

    private void showImageDownloadRetryDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Image download failed. Retry?").setCancelable(false).setNegativeButton("Ok", new CLASS233(this)).setPositiveButton("Cancel", new CLASS232(this));
        builder.create().show();
    }

    static void MF_CLASS22_g77(MapScreen mapscreen) throws CLASS1
    {
        mapscreen.cancelCalibration();
    }

    static boolean MF_CLASS22_g77(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aB = flag;
        return flag;
    }

    static String MF_CLASS159_h579(MapScreen mapscreen)
    {
        return mapscreen.aO;
    }

    private void MF_CLASS159_h579()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select network");
        builder.setCancelable(true);
        builder.setOnKeyListener(new CLASS236(this));
        builder.setMessage("Select positioning connection").setNegativeButton("Mobile Hipri", new CLASS239(this)).setPositiveButton("Device default", new CLASS238(this));
        builder.create().show();
    }

    static boolean MF_CLASS159_h579(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aC = flag;
        return flag;
    }

    static RestClient MF_CLASS108_i455(MapScreen mapscreen)
    {
        return mapscreen.mRestClient;
    }

    private void MF_CLASS108_i455()
    {
        mProgressDialog1 = new ProgressDialog(this);
        mProgressDialog1.setCancelable(true);
        mProgressDialog1.setProgressStyle(1);
        mProgressDialog1.setMessage(getString(0x7f080045));
        mProgressDialog1.setProgressNumberFormat(null);
        mProgressDialog1.setCanceledOnTouchOutside(false);
        mProgressDialog1.setButton(-2, "Cancel", new CLASS240(this));
        mProgressDialog1.setOnKeyListener(new CLASS241(this));
        mProgressDialog1.show();
    }

    static boolean MF_CLASS108_i455(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aG = flag;
        return flag;
    }

    private void hideDownloadFloorplanProgressDialog()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "hideDownloadFloorplanProgressDialog called.");
        if(mProgressDialog1 != null)
        {
            mProgressDialog1.dismiss();
            while(mProgressDialog1.isShowing())
                try
                {
                    CLASS167.MF_CLASS167_b635("MapScreen", "hideDownloadFloorplanProgressDialog: waiting isShowing false");
                    Thread.sleep(20L);
                }
                catch(InterruptedException interruptedexception) {
                	interruptedexception.printStackTrace();
                }
            mProgressDialog1 = null;
        }
    }

    static void sReMSCreateTables(MapScreen mapscreen)
    {
        mapscreen.reMSCreateTables();
    }

    static boolean MF_CLASS108_j456(MapScreen mapscreen, boolean flag)
    {
        mapscreen.aK = flag;
        return flag;
    }

    private void cancelCalibration() throws CLASS1
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "cancelCalibration called.");
        aV = false;
        setReCalibrationRequired(false);
        vibrate(200);
        long l = MeasurementDataSource.getMeasurementCount();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.notifyCalibrationDone measurementCount == ").append(l).toString());
        hideCalibView();
        if(mSensorReader != null)
        	mSensorReader.stopCalibration();
        mSensorReader = null;
        bi = false;
        mIndoorAtlas = IndoorAtlasFactory.createIndoorAtlas(mMe.getApplicationContext(), mMe, mApiKey, mSecret);
        CLASS167.MF_CLASS167_b635("MapScreen", "cancelCalibration done.");
    }

    static void sFireBackendSegmentSynch(MapScreen mapscreen)
    {
        mapscreen.fireBackendSegmentSynch();
    }

    private void fireBackendSegmentSynch()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "fireBackendSegmentSynch called");
        showInProgressDialog(getString(0x7f080024), true);
        mRestClient.getSegments(mGraphics.getGraphicsID());
        mIndoorMapView.setBackEndSegmentVisibility(false);
    }

    static double[] MF_CLASS108_l458(MapScreen mapscreen)
    {
        return mapscreen.bc;
    }

    static long m(MapScreen mapscreen)
    {
        return mapscreen.az;
    }

    private void floorPlanSanityCheck()
    {
        String s1;
        String s2;

        int i = mBitmap.getWidth();
        mIndoorMapView.getHeight();
        int j = mBitmap.getHeight();
        try {
	        float f = (float)(i * mBitmapScale) * mGraphics.getPixelTransform().getPixelToMeterRatio();
	        float f1 = (float)(j * mBitmapScale) * mGraphics.getPixelTransform().getPixelToMeterRatio();
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("floorPlanSanityCheck: widthMeter = ").append(f).append(", heightMeter = ").append(f1).toString());
	        s1 = L.format(f);
	        s2 = L.format(f1);
	        if(f <= 1000F && f1 <= 1000F)
	            return;
	        showInformationDialog((new StringBuilder()).append("Floor plan width is ").append(s1).append("m and height is ").append(s2).append("m. ").append("Please make sure the image was correctly superimposed on the world map. ").append("Incorrect superimposition decreases positioning accuracy.").toString());
	        return;
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }

    static TouchMode MF_CLASS108_n460(MapScreen mapscreen)
    {
        return mapscreen.mTouchMode;
    }

    private void takeWifiScanLock()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "takeWifiScanLock  called");
        an = mWifiManager.createWifiLock(2, "MapCreatorWifiLock");
        if(!an.isHeld())
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "takeWifiScanLock, calling acquire()");
            an.acquire();
        }
    }

    static float MF_CLASS108_o461(MapScreen mapscreen)
    {
        return mapscreen.aD;
    }

    private void giveWifiScanLock()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "giveWifiScanLock called.");
        try {
	        if(an != null && an.isHeld())
	            an.release();

        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }

        return;
    }

    static float MF_CLASS108_p462(MapScreen mapscreen)
    {
        return mapscreen.aE;
    }

    private void MF_CLASS108_p462()
    {
        ai = null;
        mIndoorMapView.setSelectedPoint(null);
        clearSelectedSegment();
    }

    static CLASS110 MF_CLASS108_q463(MapScreen mapscreen)
    {
        return mapscreen.ai;
    }

    private void handleStoringMapData()
    {
        int i;
        try
        {
            if(mIndoorMapView.currentSegment == null)
            {
                mMe.discardCollectedData();
                CLASS167.MF_CLASS167_b635("TESTI", "MapScreen.handleStoringMapData(), currentSegment == null, discarding collected data");
                return;
            }
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return;
        }
        i = mSensorController.MF_CLASS158_a563();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(), numTasksRunning = ").append(i).toString());
        if(i != 0) {
	        showToastMessage("Saving...", 1);
        }
        if(mRecordingItem != null)
        {
        	mRecordingItem.setIcon(0x7f020006);
            invalidateOptionsMenu();
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("stopRecording(): Storing measurement, currentMeasurement.mMeasurementID = ").append(currentMeasurement.mMeasurementID).toString());
        MeasurementDataSource.updateMeasurement(currentMeasurement);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Storing measurement done, measurementLengthSecs = ").append((double)(float)(mSensorController.MF_CLASS375_d1048 - mSensorController.MF_CLASS113_b487) / 1000000000D).append(", mSensorController.mTotalSQLTime = ").append((double)(float)mSensorController.MF_CLASS158_f565 / 1000000000D).toString());
        mIndoorMapView.addRecordedSegment();
        mIndoorMapView.clearPoints();
        if(SystemClock.elapsedRealtime() - bm >= 0x1b7740L);
        CLASS167.MF_CLASS167_b635("MapScreen", "stopRecording(): *NOT* setting last point of current segment as the first point of next segment, because new calib is required!");
        mEndMeasure = new Measurement();
        setState(POINT_TYPE.DEFAULT);
        if(!aH && !aK)
        {
        	showNextActionHelp(getString(0x7f080013));
            showNextActionHelp(getString(0x7f080017));
            aH = true;
        }
        if(!CLASS113.isDeviceChecked.booleanValue()) {
            CLASS319 class319_1 = new CLASS319(this);
            java.util.concurrent.Executor executor1 = AsyncTask.THREAD_POOL_EXECUTOR;
            Measurement aclass108_1[] = new Measurement[1];
            aclass108_1[0] = currentMeasurement;
            class319_1.executeOnExecutor(executor1, aclass108_1);
        } else {
	        CLASS319 class319 = new CLASS319(this);
	        java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
	        Measurement aclass108[] = new Measurement[1];
	        aclass108[0] = currentMeasurement;
	        class319.executeOnExecutor(executor, aclass108);
        }
        mMe.invalidateOptionsMenu();
        return;
    }

    private void r()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter label");
        builder.setMessage("Label:");
        EditText edittext = new EditText(this);
        builder.setView(edittext);
        builder.setPositiveButton("Ok", new CLASS269(this, edittext));
        builder.setNegativeButton("Cancel", new CLASS270(this));
        builder.show();
    }

    static boolean r(MapScreen mapscreen)
    {
        return mapscreen.MF_CLASS19_a67();
    }

    private void handleStoringTestData()
    {
        if(mIndoorMapView.e == null)
        {
            mMe.discardCollectedData();
            CLASS167.MF_CLASS167_b635("TESTI", "MapScreen.handleStoringTestData(), mTestSegmentPath == null, discarding collected data");
            return;
        }
        try
        {
            if(mRecordingItem != null)
            {
            	mRecordingItem.setIcon(0x7f020006);
                invalidateOptionsMenu();
            }
            MeasurementDataSource.updateMeasurement(currentMeasurement);
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleStoringTestData(): Storing measurement done, measurementLengthSecs = ").append((double)(float)(mSensorController.MF_CLASS375_d1048 - mSensorController.MF_CLASS113_b487) / 1000000000D).append(", mSensorController.mTotalSQLTime = ").append((double)(float)mSensorController.MF_CLASS158_f565 / 1000000000D).toString());
            mIndoorMapView.addRecordedTestSegment();
            mIndoorMapView.clearPoints();
            mStartMeasure = null;
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleStoringTestData(): Storing segment with Routepoints: ").append(currentMeasurement.MF_CLASS108_a447()).toString());
            CLASS319 class319 = new CLASS319(this);
            Measurement aclass108[] = new Measurement[1];
            aclass108[0] = currentMeasurement;
            class319.execute(aclass108);
            if(!CLASS113.isDeviceChecked.booleanValue());
            mMe.invalidateOptionsMenu();
            double d = RestClient.handleRestSend(MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID()));
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleStoringTestData(): countSegmentLengthSeconds returned  coverageTestPercent = ").append(d).toString());
            runOnUiThread(new CLASS271(this, L.format(d * 100D)));
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
        return;
    }

    static boolean s(MapScreen mapscreen)
    {
        return mapscreen.aW;
    }

    private void updateBGCalibIconVisibility()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("updateBGCalibIconVisibility(): calibReady = ").append(S).toString());
        runOnUiThread(new CLASS285(this));
    }

    static boolean t(MapScreen mapscreen)
    {
        return mapscreen.aC;
    }

    static Measurement getStartMeasure(MapScreen mapscreen)
    {
        return mapscreen.mStartMeasure;
    }

    private void markFirstUsageCalibrationReady()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "markFirstUsageCalibrationReady called.");
        android.content.SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(mMe.getApplicationContext()).edit();
        editor.putString("first_usage_calib_done", "yes");
        boolean flag = editor.commit();
        String s1 = PreferenceManager.getDefaultSharedPreferences(mMe.getApplicationContext()).getString("first_usage_calib_done", "");
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("markFirstUsageCalibrationReady done, writtenPersistently = ").append(flag).append(", prefs.getString() = ").append(s1).toString());
    }

    static Measurement getEndMeasure(MapScreen mapscreen)
    {
        return mapscreen.mEndMeasure;
    }

    private void onDoubleTap()
    {
        Matrix matrix1 = new Matrix();
        int i = mIndoorMapView.getWidth();
        int k = mIndoorMapView.getHeight();
        int j = 0;
        int l = 0;
        if(mBitmap != null) {
	        j = mBitmap.getWidth();
	        l = mBitmap.getHeight();
        }
        float f;
        if(j > l)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "GestureListener.onDoubleTap(): scaling by width");
            f = (float)i / (float)j;
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "GestureListener.onDoubleTap(): scaling by height");
            f = (float)k / (float)l;
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("GestureListener.onDoubleTap(): calling  setting scale of ImageView = ").append(f).append(", w = ").append(i).append(", image_w = ").append(j).toString());
        matrix1.setScale(f, f);
        mCurrentZoom = f;
        matrix = matrix1;
        mIndoorMapView.setImageMatrix(matrix1);
        mIndoorMapView.scrollTo(0, 0);
    }

    private void loadPreferences()
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        java.util.Map.Entry entry;
        for(Iterator iterator = sharedpreferences.getAll().entrySet().iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences, PREF: ").append((String)entry.getKey()).append(": ").append(entry.getValue().toString()).toString()))
            entry = (java.util.Map.Entry)iterator.next();

        String s1 = sharedpreferences.getString(getString(0x7f080060), getString(0x7f080063));
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences(): positioning_server = ").append(s1).toString());
        String s2 = sharedpreferences.getString("login_address", getString(0x7f080064));
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences(): login_address = ").append(s2).toString());
        String s3 = sharedpreferences.getString("backend_address", getString(0x7f080065));
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences(): backendURL = ").append(s3).toString());
        boolean flag = sharedpreferences.getBoolean("sensor_values_on_screen_key", false);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences(): show_sensor_values = ").append(flag).toString());
        mScrollToPosition = sharedpreferences.getBoolean("scroll_to_position_key", true);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences(): mScrollToPosition = ").append(mScrollToPosition).toString());
        mSmoothBetweenPrevAndCurrentPosition = sharedpreferences.getBoolean("smooth_position_key", true);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("loadPreferences(): mSmoothBetweenPrevAndCurrentPosition = ").append(mSmoothBetweenPrevAndCurrentPosition).toString());
//        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("graphicsID = ").append(mGraphics.MF_CLASS103_a414()).toString());
        if(mSensorController != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "loadPreferences(): mSensorController != null --> stopping sensors");
            mSensorController.stopDataCollection();
            mSensorController.stopSensors(true);
        } else
        {
        	mSensorController = new SensorController(getApplicationContext(), this, this);
        	mSensorController.start();
        }
        if(mIndoorAtlas != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "loadPreferences, calling synchronized mIndoorAtlas.stopPositioning()");
            mIndoorAtlas.stopPositioning();
        }
        mRestClient = new RestClient(this, mCurrentBuilding, mDevice, mCookie);
        if(flag)
        {
            setDebugBoxVisible(true);
            mSensorController.MF_CLASS375_c1047(flag);
        } else
        {
        	mSensorController.MF_CLASS375_c1047(flag);
            setDebugBoxVisible(false);
        }
        setState(POINT_TYPE.DEFAULT);
    }

    static void w(MapScreen mapscreen)
    {
        mapscreen.invalidateIndoorMapView();
    }

    static boolean x(MapScreen mapscreen)
    {
        return mapscreen.aB;
    }

    static boolean y(MapScreen mapscreen)
    {
        return mapscreen.aI;
    }

    static void z(MapScreen mapscreen)
    {
        mapscreen.MF_CLASS108_p462();
    }

    List MF_CLASS19_a67(List list)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Measurement class108 = (Measurement)iterator.next();
            if(class108.mSentToServer == 1L)
                arraylist.add(class108);
        } while(true);
        return arraylist;
    }

    public boolean checkScanModeOnly(boolean flag)
    {
        boolean flag1;
        if(android.os.Build.VERSION.SDK_INT < 18) {
            if(CLASS113.isExceptionLogged.booleanValue())
                showToastMessage("CheckScanModeOnly, platform ver < 18", 1);
            return false;
        }
        flag1 = mWifiManager.isScanAlwaysAvailable();
        if(CLASS113.isDeviceChecked.booleanValue())
            showToastMessage((new StringBuilder()).append("CheckScanModeOnly: ret = ").append(flag1).toString(), 1);
        if(flag1 || !flag) {
            //showScanModeOnlyDialog();
        	flag1 = true;
            return flag1;
        }
        if(CLASS113.isExceptionLogged.booleanValue())
            showToastMessage("Requesting permission from user", 1);
        return flag1;
    }

    public boolean checkTimeStamps(Measurement class108)
    {
        boolean flag = true;
        int i = ((flag) ? 1 : 0);
        for(;i < class108.mPoints.size();i++)
        {
            if(((CheckPoint)class108.mPoints.get(i)).CheckPointTimestamp == 0L)
            	flag = false;
        }
        return flag;
    }

    public void clearCurrentSegment()
    {
        mIndoorMapView.clearPoints();
    }

    public void clearSelectedSegment()
    {
        mIndoorMapView.setSelectedSegment(null);
        mIndoorMapView.invalidate();
    }

    public void deleteAllMeasurementsOfCurrentFloorplan()
    {
        showInProgressDialog("Deleting all paths of current floor plan from IndoorAtlas Maps...", false);
        mRestClient.deleteMeasurementSequence(mGraphics.getGraphicsID());
    }

    public void deleteSelectedMeasurementFromLocalDB()
    {
        Measurement class108 = mIndoorMapView.getSelectedSegment();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("deleteSelectedMeasurementFromLocalDB : s = ").append(class108).toString());
        MeasurementDataSource.getNotUploadedMeasurementCount(class108.MF_CLASS108_a447());
        mIndoorMapView.setSelectedSegment(null);
        mIndoorMapView.removeRecordedSegment(class108);
        setIconOverlayForNumberOfToBeUploadedSegments();
        hideInProgressDialog();
        invalidateIndoorMapView();
    }

    public void discardCollectedData()
    {
        if(mRecordingItem != null)
        {
        	mRecordingItem.setIcon(0x7f020006);
            invalidateOptionsMenu();
        }
        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.discardCollectedData: calling mIndoorMapView.clearPoints");
        mIndoorMapView.clearPoints();
        mIndoorMapView.showSegments();
        setState(POINT_TYPE.DEFAULT);
        showStatusText("");
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Discarding collected segment --> delete segment with ID from local DB, id = ").append(currentMeasurement.mMeasurementID).toString());
        MeasurementDataSource.MeasurementdeletedDBWithid(currentMeasurement.mMeasurementID);
        mStartMeasure = null;
        mIndoorMapView.clearPoints();
    }

    public boolean ensureWifiEnabled()
    {
        boolean flag = mWifiManager.isWifiEnabled();
        int i = 0;
        if(!flag)
        {
            boolean flag1 = mWifiManager.setWifiEnabled(true);
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("ensureWifiEnabled:  after setWifiEnabled() wifiEnabled = ").append(flag1).toString());
            flag = mWifiManager.isWifiEnabled();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("ensureWifiEnabled:  after isWifiEnabled() wifiEnabled = ").append(flag).toString());
            while(!flag && i < 30)
            {
                i++;
                try
                {
                    Thread.sleep(50L);
                }
                catch(Exception exception) { }
                mWifiManager.setWifiEnabled(true);
                flag = mWifiManager.isWifiEnabled();
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("ensureWifiEnabled: enabling wifi, retry ").append(i).append(", wifiEnabled = ").append(flag).toString());
            }
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("ensureWifiEnabled: RETURNING, after retry ").append(i).append(", wifiEnabled = ").append(flag).toString());
        return flag;
    }

    public float getAPIBGCalibrationStatusPercent()
    {
        return bf;
    }

    public float getCommunicationLatency()
    {
        if(mIndoorAtlas != null)
            return mIndoorAtlas.getCommunicationLatency();
        else
            return -1F;
    }

    public int getMessageQueueLength()
    {
        if(mIndoorAtlas != null)
            return mIndoorAtlas.MF_Some3EventBase_e005();
        else
            return -1;
    }

    public float[] getOriginalImageSize()
    {
        float af1[] = new float[2];
        af1[0] = mGraphics.getGraphicImage().getWidth();
        af1[1] = mGraphics.getGraphicImage().getHeight();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getOriginalImageSize: ").append(af1[0]).append(",").append(af1[1]).toString());
        float af2[] = new float[2];
        af2[0] = mBitmap.getWidth() * mBitmapScale;
        af2[1] = mBitmap.getHeight() * mBitmapScale;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("sizeOrigImageClient: ").append(af2[0]).append(",").append(af2[1]).toString());
        return af2;
    }

    public boolean getReCalibrationRequired()
    {
        return aP;
    }

    public Measurement getSequenceFromLocalMeasurementsForBeSynch(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getSequenceFromLocalMeasurementsForBe : id = ").append(s1).toString());
        for(Iterator iterator = bp.iterator(); iterator.hasNext();)
        {
            Measurement class108 = (Measurement)iterator.next();
            if(class108.segmentID.equals(s1))
                return class108;
        }

        return null;
    }

    public TouchMode getTouchMode()
    {
        return mTouchMode;
    }

    public void handleBackPressed()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleBackPressed() called: mWasCalibrating = ").append(aV).toString());
        try {
	        if(!aV && (mSensorReader == null || !mSensorReader.MF_CLASS376_i1066())) {
	            CLASS167.MF_CLASS167_b635("MapScreen", "handleBackPressed() called - NOT calibrating");
	            vibrate(100);
	            if(mScreenPointType == POINT_TYPE.POSITIONING)
	            {
	                showStopPositioningDialog();
	                return;
	            } else
	            {
	                showCloseFloorplanDialog();
	                return;
	            }
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "handleBackPressed() called - calibrating --> Now we allow cancelling calibration, but mapping cannot be done before calibrated successfully");
	        cancelCalibration();
	        showToastMessage("Calibration cancelled.", 0);

        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
		        exception.printStackTrace();
        }
        return;
    }

    public void handleSelectPath()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "handleSelectPath() called");
        CLASS365 class365;
        try
        {
            if(ai != null || mIndoorMapView.getSelectedSegment() != null)
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "handleSelectPath() skipping click, because a segment or a point is currently selected.");
                return;
            }
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return;
        }
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleSelectPath() touch at ").append(MF_CLASS22_g77.x).append(",").append(MF_CLASS22_g77.y).toString());
        class365 = mIndoorMapView.getClosestSegment(MF_CLASS22_g77.x, MF_CLASS22_g77.y);
        if(class365 == null) {
            CLASS167.MF_CLASS167_b635("MapScreen", "handleSelectPath(): no closest segment found - probably no recorded segments for this floorplan.");
        } else  if((double)class365.MF_CLASS365_b979 >= av || aB || aC) {
            CLASS167.MF_CLASS167_b635("MapScreen", "handleSelectPath(): no closest segment found - probably no recorded segments for this floorplan.");
        } else {
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleSelectPath() touch at ").append(MF_CLASS22_g77.x).append(",").append(MF_CLASS22_g77.y).append(", dist = ").append(class365.MF_CLASS365_b979).toString());
	        vibrate(20);
	        aW = true;
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("handleSelectPath(): closest segment ").append(class365.MF_CLASS365_a978.MF_CLASS108_a447()).toString());
	        mIndoorMapView.setSelectedSegment(class365.MF_CLASS365_a978);
	        mIndoorMapView.invalidate();
	        showSegmentSelectedDialog();
        }
        mTouchMode = TouchMode.NONE;
        return;
    }

    public void handlerSensorErrorAndTimetampError(CLASS369 c)
    {
        if(CLASS113.isExceptionLogged.booleanValue())
            showToastMessage("Sensor error.", 0);
        if(CLASS113.isExceptionLogged.booleanValue())
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "notifySensorError() dumping stack");
            Thread.dumpStack();
        }
        if(mSensorController != null) {
            try
            {
            	mSensorController.stopDataCollection();
            	mSensorController.stopSensors(true);
            }
            catch(Exception exception1)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception1.printStackTrace();
            }
        }

        if(mSensorReader == null) {
                if(c == CLASS369.POSITIONING)
                {
                    CLASS167.MF_CLASS167_b635("MapScreen", "notifySensorError: sensor error during positioning!");
                    return;
                }
                showRecordingCancelledDueToSensorProblemDialog("Sensor error.");
                return;
        }
        try {
        	mSensorReader.MF_CLASS369_c996();
        	mSensorReader.stopSensors(false, true);

        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }

        if(c == CLASS369.CALIBRATING)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "notifySensorError: sensor error during calibration!");
            showInformationDialogWhichRestartsCalibration("Sensor error. Click Ok to restart calibration.");
            return;
        }

    }

    public void hideCalibView()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "hideCalibView(): called");
        mIndoorMapView.setOnTouchListener(localTouchListener);
        br.dismiss();
    }

    public void hideConnectionIndicator()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "hideConnectionIndicator() called ");
        ((ImageView)findViewById(0x7f0b001c)).setVisibility(4);
        CLASS167.MF_CLASS167_b635("MapScreen", "hideConnectionIndicator() done ");
    }

    public void hideInProgressDialog()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", " hideInProgressDialog called");
        if(mProgressDialog2 != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", " hideInProgressDialog : calling this.inProgressDialog.cancel()");
            mProgressDialog2.cancel();
            mProgressDialog2 = null;
        }
    }

    public void hideRotateIcon()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "hideRotateIcon()");

        mNaviButton.setVisibility(4);
        mNaviButton.setClickable(false);
    }

    public void hideWalkView()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "hideWalkView(): called");
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("hideWalkView(): mWalkViewFragment = ").append(bq).toString());
        if(bq != null)
        {
            bq.MF_CLASS350_a948();
            bq.dismiss();
            bq = null;
        }
    }

    public void infoMessage(String s1)
    {
    }

    public void informAllMeasurementsDeletedFromBackend()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "informAllMeasurementsDeletedFromBackend called.");
        Measurement class108;
        for(Iterator iterator = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID()).iterator(); iterator.hasNext(); mIndoorMapView.removeRecordedSegment(class108))
        {
            class108 = (Measurement)iterator.next();
            MeasurementDataSource.MeasurementdeletedDBWithid(class108.mMeasurementID);
        }

        hideInProgressDialog();
        invalidateIndoorMapView();
    }

    public void informMapGenerationInitiatedOk(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("informMapGenerationInitiatedOk(): creating poller for checking backend map generation status. jobId = ").append(s1).toString());
        aN = true;
        aO = s1;
        vibrate(300);
        t = (new CLASS252(this, 0x1b7740L, 10000L)).start();
    }

    public void informMapGenerationStatus(boolean flag, String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("informMapGenerationStatus(): generatingThese = ").append(flag).append(", jobId = ").append(s1).toString());
        aO = s1;
        try {
	        if(aN)
	        {
	            if(!flag) {
	                CLASS167.MF_CLASS167_b635("MapScreen", "informMapGenerationStatus(): generation done.");
	                aN = false;
	                if(t != null)
	                    t.cancel();
	                hideInProgressDialog();
	                showInformationDialog("Map generated.");

	            } else {
	            	CLASS167.MF_CLASS167_b635("MapScreen", "informMapGenerationStatus(): still generating the map...");
	            }
	        }
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }

        vibrate(500);
        return;
    }

    public void informUploadAborted(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "informUploadAborted()  calling getBackendSegments()");
        mUploadingGenerationInProgress = false;
        try {
	        hideInProgressDialog();
	        String s2 = L.format(5D);
	        showInformationDialog((new StringBuilder()).append("Validation data coverage is ").append(s1).append("% ").append(" - should be ").append(s2).append(" % at minimum.").toString());
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }
    }

    public void informUploadDone()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("informUploadDone() mUploadingGenerationInProgress =  ").append(mUploadingGenerationInProgress).toString());
        if(mUploadingGenerationInProgress)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "informUploadDone(): initiating generation.");
            showInProgressDialog(getString(0x7f08004c), true);
            mRestClient.initiateMapGeneration(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID());
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "informUploadDone(): calling hideInProgressDialog() and starting path sync");
            hideInProgressDialog();
        }
        mUploadingGenerationInProgress = false;
        mMe.invalidateOptionsMenu();
    }

    public boolean isBGCalibrationReady()
    {
        if(mIndoorAtlas != null)
        {
            if(mIndoorAtlas != null && !mIndoorAtlas.isBGCalibrated())
                return false;
            if(mIndoorAtlas != null && mIndoorAtlas.isBGCalibrated())
                return true;
        }
        return true;
    }

    public void markSegmentSent(Measurement class108)
    {
        mIndoorMapView.markSegmentSent(class108);
    }

    public void notifyCalibrationDone(CalibrationEvent class18, CLASS24 class24)
    {
        long l;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.notifyCalibrationDone called, mCalibrationCount = ").append(ba).append(", cs = ").append(class18.toString()).toString());
        if(class18.getCalibrationStatus() == CLASS19.READY) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "notifyCalibrationDone(): DONE_SUCCESS ");
	        ba = 1 + ba;
	        bm = SystemClock.elapsedRealtime();
	        double d = class18.MF_CLASS18_c63()[1];
	        double d1 = -1D * class18.MF_CLASS18_c63()[0];
	        bc[0] = d;
	        bc[1] = d1;
	        bc[2] = class18.MF_CLASS18_c63()[2];
	        String s1 = M.format(class18.MF_CLASS18_c63()[0]);
	        String s2 = M.format(class18.MF_CLASS18_c63()[1]);
	        String s3 = M.format(class18.MF_CLASS18_c63()[2]);
	        if(CLASS113.isDeviceChecked.booleanValue() || CLASS113.isExceptionLogged.booleanValue())
	            showToastMessage((new StringBuilder()).append("Calibration successful. \nBiases : \nx : ").append(s1).append("\ny : ").append(s2).append("\nz : ").append(s3).append("\nt = ").append(class18.MF_CLASS18_d64()).toString(), 1);
	        CLASS370 class370 = mSensorReader.MF_CLASS376_k1068();
	        if(class370 == null) {
	                CLASS167.MF_CLASS167_b635("MapScreen", "notifyCalibrationDone(): calib == NULL!!!");
	        } else {
		        try
		        {
		            CLASS167.MF_CLASS167_b635("MapScreen", "notifyCalibrationDone:  storing calibration to DB");
		            CLASS370 class370_1 = MeasurementDataSource.storeCalibrationSet(class370);
		            CLASS167.MF_CLASS167_b635("MapScreen", "notifyCalibrationDone:  storing calibration to file");
		            if(class24.magnetometerSamples != null && class24.gyroscopeSamples != null && class24.accelerometerSamples != null)
		            {
		                long l1 = ((CLASS22)class24.magnetometerSamples.get(-1 + class24.magnetometerSamples.size())).timeStamp - ((CLASS22)class24.magnetometerSamples.get(0)).timeStamp;
		                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("notifyCalibrationDone:  mgn data dur = ").append((double)l1 / 1000000000D).toString());
		                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("notifyCalibrationDone: gyro size : ").append(class24.gyroscopeSamples.size()).toString());
		                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("notifyCalibrationDone: acc size : ").append(class24.accelerometerSamples.size()).toString());
		                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("notifyCalibrationDone: mgn size : ").append(class24.magnetometerSamples.size()).toString());
		            }
		            java.util.concurrent.ConcurrentLinkedQueue concurrentlinkedqueue = CLASS68.MF_CLASS27_d107(class24.gyroscopeSamples);
		            java.util.concurrent.ConcurrentLinkedQueue concurrentlinkedqueue1 = CLASS68.MF_CLASS27_d107(class24.accelerometerSamples);
		            java.util.concurrent.ConcurrentLinkedQueue concurrentlinkedqueue2 = CLASS68.MF_CLASS27_d107(class24.magnetometerSamples);
		            MeasurementDataSource.storeGyroSensorData(concurrentlinkedqueue, class370_1.mMeasurementID, true);
		            MeasurementDataSource.storeAccSensorData(concurrentlinkedqueue1, class370_1.mMeasurementID, true);
		            MeasurementDataSource.storeMgnSensorData(concurrentlinkedqueue2, class370_1.mMeasurementID, true);
		            writeCalibrationSetToFile(class370_1);
		        }
		        catch(Exception exception)
		        {
		            if(CLASS113.isExceptionLogged.booleanValue())
		                exception.printStackTrace();
		        }
	        }

	        l = MeasurementDataSource.getMeasurementCount();
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.notifyCalibrationDone measurementCount == ").append(l).toString());
	        if(l < 1L)
	        {
	            aI = true;
	            runOnUiThread(new CLASS243(this));
	        } else
	        {
	            aK = true;
	        }
	        runOnUiThread(new CLASS244(this));
        } else if(class18.getCalibrationStatus() == CLASS19.FAILED)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "notifyCalibrationDone(): DONE_FAILURE_NOT_MOVED_ENOUGH");
            if(mSensorReader != null)
                runOnUiThread(new CLASS245(this));
        }

        aV = false;
        setReCalibrationRequired(false);
        vibrate(200);
        hideCalibView();
        floorPlanSanityCheck();
//        (long)ba;
        runOnUiThread(new CLASS246(this));
        mSensorReader = null;
        runOnUiThread(new CLASS247(this));
        return;
    }

    public void notifySensorError(int i, CLASS369 c)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("notifySensorError() called type = ").append(i).append(", sps = ").append(c).toString());
        showToastMessage("Sensor error.", 0);
        runOnUiThread(new CLASS300(this, c));
    }

    public void notifySensorEventQueueFull()
    {
    }

    public void notifyTimestampError(CLASS369 c)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("notifyTimestampError() called sps = ").append(c).toString());
        showToastMessage("Sensor timestamp error.", 0);
        runOnUiThread(new CLASS301(this, c));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onActivityResult() called with requestCode = ").append(i).append(", resultCode = ").append(j).append(", data.getAction() = ").append(intent.getAction()).toString());
        showToastMessage((new StringBuilder()).append("onActivityResult : data.getAction() = ").append(intent.getAction()).toString(), 1);
        if(android.os.Build.VERSION.SDK_INT >= 18)
        {
            boolean flag = mWifiManager.isScanAlwaysAvailable();
            if(CLASS113.isExceptionLogged.booleanValue())
                showToastMessage((new StringBuilder()).append("CheckScanModeOnly: ret = ").append(flag).toString(), 1);
        }
    }

    public void onCalibrationFailed(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onCalibrationFailed() called. reason = ").append(s1).toString());
        runOnUiThread(new CLASS286(this, s1));
    }

    public void onCalibrationInvalid()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onCalibrationInvalid() now called when BG calib is too old.");
        S = false;
        updateBGCalibIconVisibility();
    }

    public void onCalibrationReady()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onCalibrationReady() now called when BG calib ready.");
        S = true;
        try {
	        invalidateOptionsMenu();
	        markFirstUsageCalibrationReady();
	        updateBGCalibIconVisibility();
        } catch(Exception exception) {
            exception.printStackTrace();
            //throw exception;
        }
        return;
    }

    public void onCalibrationStatus(Some1Base some1base)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onCalibrationStatus() calibrationState.getCalibrationEvent() = ").append(some1base.getIndoorAction()).append(", calibrationState.getPercentage() = ").append(some1base.actionPercentage()).toString());
        runOnUiThread(new CLASS288(this, some1base));
    }

    public void onCancelCalibration()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onCancelCalibration: cancelling calibration");
        try {
        	cancelCalibration();
	        showToastMessage("Calibration cancelled.", 0);
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }
    }

    public void onCreate(Bundle bundle)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onCreate");
        super.onCreate(bundle);

        Thread.setDefaultUncaughtExceptionHandler(new CLASS164(this));
        if(!CLASS113.isExceptionLogged.booleanValue());
        UiPixelScale = getResources().getDisplayMetrics().density;
        ax = (int)(0.5F + aw * UiPixelScale);
        z = new SimpleDateFormat("MM-dd-yyyy, HH:mm:ss");
        L = NumberFormat.getInstance(Locale.US);
        L.setMinimumFractionDigits(0);
        L.setMaximumFractionDigits(0);
        M = NumberFormat.getInstance(Locale.US);
        M.setMinimumFractionDigits(1);
        M.setMaximumFractionDigits(1);
        ViewConfiguration viewconfiguration;
        Field field = null;
        viewconfiguration = ViewConfiguration.get(this);

//        field = ViewConfiguration.getDeclaredField("sHasPermanentMenuKey");

        try
        {
	        if(field == null) {
//	        	return;
	         //   break MISSING_BLOCK_LABEL_165;
	        }
//	        field.setAccessible(true);
//	        field.setBoolean(viewconfiguration, false);

            getWindow().addFlags(128);
            mCurrentBuilding = (Building)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.currentBuilding");
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapsScreen.onCreate(): got from bundle: mCurrentBuilding = ").append(mCurrentBuilding).toString());
            mGraphics = (MapGraphics)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.currentBuilding.selectedFloorplan");
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapsScreen.onCreate(): got from bundle: mFloorplan = ").append(mGraphics).toString());
            mDevice = (CLASS100)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.mDevice");
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapsScreen.onCreate(): got from bundle: mDevice = ").append(mDevice).toString());
            mCurrentLevel = (Level)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.currentBuilding.selectedLevel");
//            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapsScreen.onCreate(): got from bundle: mCurrentLevelXML = ").append(mCurrentLevel.toString()).toString());
            mCookie = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.cookie");
            mPassword = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.password");
            mUserName = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.username");
            mApiKey = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.apikey");
            mSecret = (String)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.secret");
            mDeviceModel = (CLASS101)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.devicemodel");
            
            //add by xinghai
            mCurrentBuilding = new Building();
            mCurrentLevel = new Level();
            mGraphics = new MapGraphics();
            mDevice = new CLASS100();
            
            getWindow().requestFeature(9);
            getActionBar().setBackgroundDrawable(getResources().getDrawable(0x7f020009));
            getActionBar().setSplitBackgroundDrawable(getResources().getDrawable(0x7f020009));
            getActionBar().setDisplayOptions(16);
            getActionBar().setCustomView(R.layout.actionbar_mapscreen);
//            ((TextView)findViewById(0x7f0b0000)).setText(mGraphics.MF_CLASS103_b415());
            if(!MeasurementDataSource.MF_CLASS381_a1107)
                MeasurementDataSource.openDB(getApplicationContext());
            setContentView(R.layout.mapscreen);
            mNaviButton = (ImageButton)findViewById(R.id.naviButton);
            mNaviButton.setOnClickListener(new CLASS225(this));
            mWifiManager = (WifiManager)getSystemService("wifi");
            if(am == null)
                am = new WifiScanReceiver(this);
            ao = new CLASS237(this);
            registerReceiver(ao, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            mRestClient = new RestClient(this, mCurrentBuilding, mDevice, mCookie);
            mIndoorMapView = (IndoorMapView)findViewById(R.id.indoormapview);
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("created mIndoorMapView : ").append(mIndoorMapView).toString());
            mIndoorMapView.setMapScreen(this);
            mIndoorMapView.initialize();
            mIndoorMapView.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
//            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("calling DownloadImageTask.execute with ").append(mGraphics.MF_CLASS103_c416().MF_CLASS104_a424()).toString());
            MF_CLASS19_b68 = new DownloadImageTask(this, mIndoorMapView);
            DownloadImageTask class309 = MF_CLASS19_b68;
            java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            String as1[] = new String[1];
            //as1[0] = mGraphics.getGraphicImage().getImageUrl();
            //as1[0] = "GraphyID001";
            as1[0] = "http://192.168.1.99:8080/hashed/00ab14496ad8f6aed0f54a28d7103b13.jpg";
            class309.executeOnExecutor(executor, as1);
            mIndoorMapView.setOnTouchListener(localTouchListener);
            mVibrator = (Vibrator)getSystemService("vibrator");
            mGestureListener = new CLASS313(this, null);
            mGestureDetector = new GestureDetector(this, mGestureListener, null, true);
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
        showInformationDialogWhichClosesActivity("Error in opening floor plan view, please retry.");
        return;

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0a0000, menu);
        return true;
    }

    public void onDebug(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onDebug() info = ").append(s1).toString());
        runOnUiThread(new CLASS290(this, s1));
    }

    protected void onDestroy()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onDestroy");
        super.onDestroy();
        if(!CLASS113.isExceptionLogged.booleanValue());
        if(mUpdatingLocation)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onDestroy : stopping positioning");
            stopPositioning(true);
        }
        if(mRecordingSegment)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onDestroy : stopping recording");
            mRecordingCancelled = true;
            onRecordButtonClick();
        }
        if(mSensorController != null)
        {
        	mSensorController.stopSensors(true);
            mSensorController.quit();
            mSensorController = null;
        }
        try
        {
            unregisterReceiver(am);
        }
        catch(Exception exception1) { 
        	exception1.printStackTrace();
        }
        try
        {
            if(mBitmap != null)
            {
                mBitmap.recycle();
                mBitmap = null;
            }
            mIndoorMapView.destroy();
            System.gc();
            CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onDestroy done.");
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
        return;
    }

    public void onInitializationFailed(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onInitializationFailed() called. ");
        if(mScreenPointType == POINT_TYPE.POSITIONING)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onInitializationFailed() called, mCurrentState == State.POSITIONING --> calling stopPositioning");
            runOnUiThread(new CLASS293(this, s1));
        }
    }

    public void onInitializationTimeout()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onInitializationTimeout, mCurrentState == ").append(mScreenPointType).append(" calling --> mIndoorAtlas.stopPositioning()").toString());
        try {
        	stopPositioning(true);
	        showInformationDialog("Initialization timeout.");
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        long l;
        long l1;
        try
        {
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onKeyDown():").append(keyevent.toString()).toString());
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
            return true;
        }
        if(i == 4) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "onKeyDown(): keyCode == KeyEvent.KEYCODE_BACK: closing MapScreen Activity, returning true");
	        handleBackPressed();
	        return true;
        }

        if(i != 25 && i != 24) {
        	return true;
        }

        CLASS167.MF_CLASS167_b635("MapScreen", "onKeyDown(): keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP");
        MF_CLASS19_a67();
        l = System.currentTimeMillis();
        l1 = l - x;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("Volume-key click-sequence detection: elapsed = ").append(l1).append(", mDevOptionKeyCnt = ").append(w).append(", mLastVolumeKey = ").append(y).toString());
        if(w != 0) {
            if(l1 >= 2000L || w >= 2) {
                if(l - x >= 2000L || w != 2) {
                    CLASS167.MF_CLASS167_b635("MapScreen", "Volume-key click-sequence detection: cancel the sequence 2");
                    w = 0;
                    x = 0L;
                    y = 0;
                    return true;

                }
                CLASS167.MF_CLASS167_b635("MapScreen", "Volume-key click-sequence detection: DONE!");
                if(CLASS113.isDeviceChecked.booleanValue())
                    showDeveloperMenuDialog();
                w = 0;
                x = 0L;
                y = 0;
                return true;
            }

            CLASS167.MF_CLASS167_b635("MapScreen", "Volume-key click-sequence detection: curTime - mDevOptionKeySequenceStartTime  < 2000 && mDevOptionKeyCnt < 3");
            if(i != 25 || y != 24) {
                if(i != 24 || y != 25) {
                    CLASS167.MF_CLASS167_b635("MapScreen", "Volume-key click-sequence detection: cancel the sequence 1");
                    w = 0;
                    x = 0L;
                    y = 0;
                    return true;
                }
                CLASS167.MF_CLASS167_b635("MapScreen", "keyCode == KeyEvent.KEYCODE_VOLUME_UP && mLastVolumeKey == KeyEvent.KEYCODE_VOLUME_DOWN");
                w = 1 + w;
                y = i;
                return true;
            }
            CLASS167.MF_CLASS167_b635("MapScreen", "keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && mLastVolumeKey == KeyEvent.KEYCODE_VOLUME_UP");
            w = 1 + w;
            y = i;
            return true;
        }
        CLASS167.MF_CLASS167_b635("MapScreen", "Volume-key click-sequence detection: mDevOptionKeyCnt == 0");
        x = l;
        w = 1 + w;
        y = i;
        return true;



    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onKeyUp():").append(keyevent.toString()).toString());
        try {
	        if(i != 25 && i != 24) {
	            if( i == 82) {
		            CLASS167.MF_CLASS167_b635("MapScreen", "onKeyUp(): keyCode == KeyEvent.KEYCODE_MENU: , returning false");
		            return false;
	            }

	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "onKeyUp(): keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP");
	        return true;
        } catch(Exception exception) {
	        exception.printStackTrace();
	        CLASS167.unhandledexception(exception, getApplicationContext());
	        return true;
        }
    }

    public void onNetworkChangeComplete(boolean flag)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onNetworkChangeComplete() : closing wait dialog, success = ").append(flag).append(", mListenToNetworkSwitch = ").append(bi).toString());
        runOnUiThread(new CLASS299(this, flag));
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected called.");
        vibrate(25);
        if(menuitem.getItemId() == 0x7f0b0025) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.record_button_new clicked");
	        onRecordButtonClick();
        } else if(menuitem.getItemId() == 0x7f0b0026) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.test_path_button_new");
                if(mMode != CLASS314.SEGMENT_DATA) {
                    try
                    {
                        showToastMessage(getString(0x7f08001d), 1);
                        mMode = CLASS314.SEGMENT_DATA;
                        setState(POINT_TYPE.DEFAULT);
                    }
                    // Misplaced declaration of an exception variable
                    catch(Exception exception)
                    {
                        CLASS167.unhandledexception(exception, getApplicationContext());
                        return true;
                    }
                } else {
	                showToastMessage(getString(0x7f08001c), 1);
	                mMode = CLASS314.TEST_DATA;
	                setState(POINT_TYPE.TEST_POINTS);
                }
        } else if(menuitem.getItemId() == 0x7f0b0027) {
    	        CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.reset_button_new clicked.");
    	        onResetButtonClick();
       } else if(menuitem.getItemId() == 0x7f0b0028) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.upload_button_new clicked.");
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onOptionsItemSelected(): R.id.upload_button_new  : mFilesBeingWritten = ").append(mFilesBeingWritten).toString());
                if(mFilesBeingWritten.intValue() != 0) {
                    CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected() calling showCancellableWaitDialog()");
                    showCancellableWaitDialog((new StringBuilder()).append("Preparing data, please wait...\n\n").append(mFilesBeingWritten).append(" items to be processed.").toString());
                } else {
                	MF_CLASS19_e71();
                }
       } else if(menuitem.getItemId() == 0x7f0b0030) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.about_button_new clicked.");
                try {
	                String s1 = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
	                Toast.makeText(this, (new StringBuilder()).append(getString(0x7f080001)).append(" Version ").append(s1).toString(), 1).show();
                } catch(Exception ex) {
                	ex.printStackTrace();
                }
       } else if(menuitem.getItemId() == 0x7f0b002b) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.delete_all_paths clicked.");
                MF_CLASS159_f577();
       } else if(menuitem.getItemId() == 0x7f0b002c) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.set_connection_type clicked.");
                aJ = true;
                MF_CLASS159_h579();
       } else if(menuitem.getItemId() == 0x7f0b002f) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.about_button_new clicked.");
                showHelpMenu();
       } else if(menuitem.getItemId() == R.id.positioning_onoff_button_new) {
                CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.positioning_onoff_button_new clicked.");
                if(!aJ)
                {
                    aJ = true;
                    showToastMessage("Note: select preferred network from menu.", 1);
                }
                mLastSuccesfulLocationUpdateTimestamp = System.currentTimeMillis();
                T = 0;
                F = 0;
                E = false;
                hideInProgressDialog();
                if(mScreenPointType != POINT_TYPE.POSITIONING) {
                	setState(POINT_TYPE.POSITIONING);
                } else {
                	stopPositioning(true);
                }
       } else if(menuitem.getItemId() == 0x7f0b002d) {
    	        CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.roaming_button_new clicked.");
    	        if(!mWifiRoamingScanReceiver.d()) {
    	        	mWifiRoamingScanReceiver.MF_null_a1();
    	        	mWifiRoamingScanReceiver.MF_null_a1(true);
    	        } else {
    	        	mWifiRoamingScanReceiver.MF_null_a1(false);
    	        	mWifiRoamingScanReceiver.abortBroadcast();
    	        }
    	        Toast.makeText(getApplicationContext(), (new StringBuilder()).append("Wifi Roaming : ").append(mWifiRoamingScanReceiver.d()).toString(), 1).show();
      } else if(menuitem.getItemId() == 0x7f0b002a) {
    	        CLASS167.MF_CLASS167_b635("MapScreen", "onOptionsItemSelected(): R.id.calibrate_with_forced clicked --> calling showCalibView()");
    	        showCalibView();
      }

      invalidateOptionsMenu();
      return true;
    }

    protected void onPause()
    {
        aM = true;
        CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onPause");
        super.onPause();
        if(!CLASS113.isDeviceChecked.booleanValue() || mScreenPointType != POINT_TYPE.POSITIONING && !mRecordingSegment) {
                try
                {
                    CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onPause : stopping recording and positioning, if ongoing");
                }
                catch(Exception exception)
                {
                    CLASS167.unhandledexception(exception, getApplicationContext());
                    return;
                }
                try
                {
                    unregisterReceiver(ao);
                    unregisterReceiver(am);
                }
                catch(Exception exception2) { 
                	exception2.printStackTrace();
                }
                giveWifiScanLock();
                if(mScreenPointType == POINT_TYPE.POSITIONING)
                {
                    CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onPause() stopping positioning.");
                    stopPositioning(true);
                    hideInProgressDialog();
                }
                if(mRecordingSegment)
                {
                    mRecordingCancelled = true;
                    onRecordButtonClick();
                }
                mSensorController.stopSensors(true);
        } else {
        	CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onPause : continuing recording or positioning");
        }

        try {
        	mIndoorAtlas.tearDown();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        mIndoorAtlas = null;
        return;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onPrepareOptionsMenu called, mCurrentState = ").append(mScreenPointType).append(", State.SECOND_POINT_GIVEN = ").append(POINT_TYPE.SECOND_POINT_GIVEN).append(", State.RECORDING = ").append(POINT_TYPE.RECORDING).toString());
        mRecordingItem = menu.findItem(R.id.record_button_new);
        mUploadButton = menu.findItem(R.id.upload_button_new);
        Z = menu.findItem(0x7f0b0029);
        setIconOverlayForNumberOfToBeUploadedSegments();
        menu.findItem(0x7f0b002d).setVisible(false);
        menu.findItem(0x7f0b002e).setVisible(false);
        menuitem = menu.findItem(0x7f0b0026);
        if(mMode != CLASS314.SEGMENT_DATA) {
            try
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "onPrepareOptionsMenu, setting icon_record_test_route_selected");
                menuitem.setIcon(0x7f020039);
            }
            catch(Exception exception)
            {
                CLASS167.unhandledexception(exception, getApplicationContext());
                Drawable drawable = Z.getIcon().getCurrent();
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onPrepareOptionsMenu currentIcon = ").append(drawable).append(", R.drawable.icon_positioning_inactive_white = ").append(0x7f020013).toString());
                return true;
            }
        } else {
	        CLASS167.MF_CLASS167_b635("MapScreen", "onPrepareOptionsMenu, setting icon_record_test_route");
	        menuitem.setIcon(0x7f02003a);
        }

        if(mScreenPointType == POINT_TYPE.DEFAULT) {
        	enableAllMenuItems(menu);
	        if(isBGCalibrationReady()) {
	            CLASS167.MF_CLASS167_b635("MapScreen", "onPrepareOptionsMenu, BG calib ready --> ENABLED positioning button");
	            return true;
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "onPrepareOptionsMenu, BG calib not ready --> DISABLING positioning button");
	        menu.findItem(0x7f0b0029);
	        return true;
        } else if(mScreenPointType == POINT_TYPE.FIRST_POINT) {
	        menu.findItem(0x7f0b0027).setEnabled(true);
	        MenuItem menuitem6 = menu.findItem(R.id.record_button_new);
	        menuitem6.setIcon(0x7f020007);
	        menuitem6.setEnabled(false);
	        return true;
        } else if(mScreenPointType == POINT_TYPE.FIRST_POINT_GIVEN) {
	        MenuItem menuitem5 = menu.findItem(R.id.record_button_new);
	        menuitem5.setIcon(0x7f020001);
	        menuitem5.setTitle(0x7f080029);
	        menuitem5.setEnabled(true);
	        return true;
        } else if(mScreenPointType == POINT_TYPE.SECOND_POINT) {
	        MenuItem menuitem4 = menu.findItem(R.id.record_button_new);
	        menuitem4.setIcon(0x7f020002);
	        menuitem4.setTitle(0x7f080029);
	        menuitem4.setEnabled(true);
	        return true;
        } else if(mScreenPointType == POINT_TYPE.SECOND_POINT_GIVEN) {
	        CLASS167.MF_CLASS167_b635("MapScreen", " onPrepareOptionsMenu(): mCurrentState == State.SECOND_POINT_GIVEN, setting icon_record");
	        MenuItem menuitem3 = menu.findItem(R.id.record_button_new);
	        menuitem3.setEnabled(true);
	        menuitem3.setIcon(0x7f020003);
	        menuitem3.setTitle(0x7f08002c);
	        return true;
        } else if(mScreenPointType == POINT_TYPE.TEST_POINTS) {
            MenuItem menuitem2;
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append(" onPrepareOptionsMenu(): mCurrentState == State.TEST_POINTS, setting icon_record, mValidationPathStartPointClicked = ").append(N).toString());
	        menuitem2 = menu.findItem(0x7f0b0025);
	        menuitem2.setEnabled(true);
	        if(mStartMeasure == null && N)
	        {
	            menuitem2.setIcon(0x7f020007);
	            menuitem2.setEnabled(false);
	            menuitem2.setTitle("Start");
	        }

	        if(mStartMeasure != null && mStartMeasure.mPoints.size() >= 2) {
		        menuitem2.setIcon(0x7f020003);
		        menuitem2.setTitle(0x7f08002c);
		        return true;
	        } else if(mStartMeasure != null && mStartMeasure.mPoints.size() == 1) {
		        menuitem2.setIcon(0x7f020007);
		        mRecordingItem.setEnabled(false);
		        menuitem2.setTitle("Start");
		        mSensorController.startSensors(true);
		        return true;
		    }

	    } else if(mScreenPointType == POINT_TYPE.RECORDING) {
	    	disableAllExceptRecordingMenuItems(menu);
	        return true;
        } else if(mScreenPointType == POINT_TYPE.POSITIONING) {
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onPrepareOptionsMenu: mStoppingPositioning = ").append(aL).append(", mCurrentState == State.DEFAULT").toString());
	        if(!aL) {
	            MF_CLASS19_b68(menu);
	            return true;
	        }
	        MF_CLASS24_c88(menu);
	        MenuItem menuitem1 = menu.findItem(0x7f0b0029);
	        menuitem1.setIcon(0x7f020012);
	        menuitem1.setEnabled(false);
	        return true;
        }
        return true;
    }

    public void onRecordButtonClick()
    {
        long l;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onRecordButtonClick(): mRecordButtonOnActionBar = ").append(mRecordingItem).append(", mTestSegmentPath = ").append(mStartMeasure).toString());
        l = SystemClock.elapsedRealtime() - bm;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onRecordButtonClick(): R.id.record_button_new clicked, diff since last calibration = ").append(l).toString());
        if(mScreenPointType == POINT_TYPE.DEFAULT) {
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onRecordButtonClick(): mCurrentState == State.DEFAULT, mMode = ").append(mMode).toString());
	        if(ba != 0 && l < 0x1b7740L) {
	                if(mMode == CLASS314.SEGMENT_DATA)
	                {
	                	setState(POINT_TYPE.FIRST_POINT);
	                    return;
	                } else
	                {
	                	setState(POINT_TYPE.TEST_POINTS);
	                    N = true;
	                    return;
	                }
	        } else {
		        CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): calibration has not yet been done or is too old --> force calib");
		        //add by xinghai
		       // showCalibView();
		        mMode = CLASS314.TEST_DATA;
		        setState(POINT_TYPE.TEST_POINTS);
	        }
        } else if(mScreenPointType == POINT_TYPE.FIRST_POINT)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): mCurrentState == State.FIRST_POINT");
            return;
        } else if(mScreenPointType == POINT_TYPE.FIRST_POINT_GIVEN)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): mCurrentState == State.FIRST_POINT_GIVEN");
            setState(POINT_TYPE.SECOND_POINT);
            return;
        } else if(mScreenPointType == POINT_TYPE.SECOND_POINT_GIVEN)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): mCurrentState == State.SECOND_POINT_GIVEN");
            setState(POINT_TYPE.RECORDING);
            return;
        } else if(mScreenPointType == POINT_TYPE.TEST_POINTS) {
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onRecordButtonClick : mCurrentState == State.TEST_POINTS, mRecordButtonOnActionBar = ").append(mRecordingItem).append(", mTestSegmentPath = ").append(mStartMeasure).toString());
	        if(ba == 0 || l >= 0x1b7740L)
	        {
	            CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): TEST_POINTS calibration has not yet been done or is too old --> force calib");
//	            showCalibView();
//	            return;
	        }
	        N = true;
	        if(mStartMeasure != null && mStartMeasure.mPoints.size() > 1) {
		        aj = 0;
		        setState(POINT_TYPE.RECORDING);  
		        return;
	        }
	    } else if(mScreenPointType == POINT_TYPE.RECORDING) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): mCurrentState == State.RECORDING");
	        if(mFlashStop != null)
	        	mFlashStop.cancel(true);
	        if(mRecordingItem != null)
	        {
	        	mRecordingItem.setIcon(0x7f020006);
	            invalidateOptionsMenu();
	        }
	        setState(POINT_TYPE.DEFAULT);
	        CLASS167.MF_CLASS167_b635("MapScreen", "onRecordButtonClick(): mCurrentState == State.RECORDING, setState to default");
	        return;
        }

        return;

    }

    public void onResetButtonClick()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", " resetButtonHandler onClick() called.");
        if(mScreenPointType == POINT_TYPE.FIRST_POINT || mScreenPointType == POINT_TYPE.FIRST_POINT_GIVEN || mScreenPointType == POINT_TYPE.SECOND_POINT_GIVEN || mScreenPointType == POINT_TYPE.SECOND_POINT)
        {
            mIndoorMapView.clearPoints();
            setState(POINT_TYPE.DEFAULT);
            showStatusText("");
            return;
        }
        if(mScreenPointType == POINT_TYPE.DEFAULT)
        {
            mIndoorMapView.clearPoints();
            showStatusText("");
            mIndoorMapView.setSelectedSegment(null);
            mIndoorMapView.invalidate();
            return;
        }
        if(mScreenPointType == POINT_TYPE.TEST_POINTS)
        {
            mIndoorMapView.removeLastCheckPoint();
            if(mStartMeasure.mPoints.size() == 0)
            {
                mStartMeasure = null;
                mIndoorMapView.clearPoints();
                mIndoorMapView.setTestPath(null);
                N = false;
                setState(POINT_TYPE.TEST_POINTS);
            }
            mIndoorMapView.setSelectedSegment(null);
            invalidateIndoorMapView();
            invalidateOptionsMenu();
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", " resetButtonHandler: doing nothing, because state is not first point or second point");
            return;
        }
    }

    public void onRestart()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onRestart");
            super.onRestart();
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    protected void onResume()
    {
        aM = false;
        try {
	        resetAPI();
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append(" -lifecycle- MapScreen.onResume, mCurrentState = ").append(mScreenPointType).toString());
	        super.onResume();
	        checkScanModeOnly(true);
	
	        if(!CLASS113.isDeviceChecked.booleanValue() || !mRecordingSegment) {
	            if(!CLASS113.isDeviceChecked.booleanValue() || mScreenPointType != POINT_TYPE.POSITIONING) {
	                try
	                {
	                    registerReceiver(ao, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
	                    loadPreferences();
	                    //add by xinghai
	                    //onRecordButtonClick();
	                    //startCalibration();
	
	                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append(" -lifecycle- MapScreen.onResume() mWasCalibrating = ").append(aV).toString());
	                    if(MF_CLASS19_b68 != null && MF_CLASS19_b68.getStatus() == android.os.AsyncTask.Status.FINISHED)
	                        CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onResume() download task has been done, checking whether install calibration has been done");
	                    if(aV)
	                        CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onResume() mCalibrating=true, restarting calibration.");
	                }
	                // Misplaced declaration of an exception variable
	                catch(Exception exception)
	                {
	                    exception.printStackTrace();
	                	CLASS167.unhandledexception(exception, getApplicationContext());
	                    return;
	                }
	            } else {
	            	CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onResume() mRecordingSegment=true, continuing positioning.");
	            }
	        } else {
		        CLASS167.MF_CLASS167_b635("MapScreen", " -lifecycle- MapScreen.onResume() mRecordingSegment=true, continuing recording.");
	        }
	
	        aS = 0;
	        updateBGCalibIconVisibility();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        return;
    }

    public void onScanReceived(long l, List list, WifiInfo wifiinfo, int i, int j, boolean flag)
    {
        if(!CLASS113.isExceptionLogged.booleanValue());
        if(wifiinfo != null)
        {
            String s1 = wifiinfo.getSSID().replace("\"", "");
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onScanReceived(): connectedSSID = ").append(s1).toString());
            String s2 = wifiinfo.getBSSID();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onScanReceived(): currentBSSID = ").append(s2).toString());
            mConnectedVsStrongestWiFiAP = (new StringBuilder()).append("N : ").append(s1).append(", AP : ").append(s2).append(" (").append(i).append(")").append("\nStr. : (").append(j).append(")").toString();
            showOnDebugMessage();
            if(CLASS113.isDeviceChecked.booleanValue() && flag)
                Toast.makeText(this, (new StringBuilder()).append("Trying to connect (roam) to AP : ").append(((ScanResult)list.get(0)).BSSID).append(" : ").append(j).toString(), 0).show();
            if(!CLASS113.isExceptionLogged.booleanValue());
            return;
        } else
        {
            mConnectedVsStrongestWiFiAP = "WiFi not connected.";
            showOnDebugMessage();
            return;
        }
    }

    public void onServiceFailure(int i, String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceFailure() called, code: ").append(i).append(", reason =  ").append(s1).toString());
        CLASS75.MF_CLASS75_a259(5, "ON_SERVICE_FAILURE", MapScreen.class, (new StringBuilder()).append("onServiceFailure: code: ").append(i).append(", reason = ").append(s1).toString());
        runOnUiThread(new CLASS291(this, s1, i));
    }

    public void onServiceInitialized()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onServiceInitialized() called.");
        mLastSuccesfulLocationUpdateTimestamp = System.currentTimeMillis();
        if(mScreenPointType == POINT_TYPE.POSITIONING)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceInitialized() called, current state = POSITIONING ");
            try
            {
                runOnUiThread(new CLASS294(this));
                return;
            }
            catch(Exception exception)
            {
                CLASS167.unhandledexception(exception, getApplicationContext());
            }
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceInitialized: received response, but positioning was already stopped by the user.");
            return;
        }
    }

    public void onServiceInitializing()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceInitializing() called. ");
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
    }

    public void onServiceStopped()
    {
        try
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "onServiceStopped() called. ");
            runOnUiThread(new CLASS295(this));
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
        CLASS167.MF_CLASS167_b635("MapScreen", "onServiceStopped() done. ");
    }

    public void onServiceUpdate(CLASS6 class6)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "onServiceUpdate() called. ");
        if(class6 == null)
            return;
        int i = getMessageQueueLength();
//        if(i < 7)
//            break MISSING_BLOCK_LABEL_69;
        if(i >= 7) {
        	return;
        }
        bl = System.currentTimeMillis();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): sentButNotRespondedMessages : ").append(i).append(" --> set mForceYellowTimestamp ").append(bl).toString());
        double d;
        double d1;
        double d2;
        double d3;
        float f;
        mPositionCnt = 1L + mPositionCnt;
        if(mPositionCnt == 1L)
        {
            vibrate(25);
            long l = System.currentTimeMillis() - mPositioningStartTime;
            CLASS75.MF_CLASS75_a259(4, "START_POSITIONING_OK", MapScreen.class, (new StringBuilder()).append("timeToFirstFix: ").append(l).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): timeToFirstFix: ").append(l).toString());
        }
        mLastRountrip = class6.MF_CLASS6_e11();
        mLastSuccesfulLocationUpdateTimestamp = System.currentTimeMillis();
        E = false;
        F = 0;
        d = class6.MF_CLASS6_a7().some2_fun1();
        d1 = class6.MF_CLASS6_a7().some2_fun2();
        d2 = class6.MF_CLASS6_b8().MF_CLASS4_a4();
        d3 = class6.MF_CLASS6_b8().MF_CLASS4_b5();
        f = (float)(1.0D / (double)mGraphics.getPixelTransform().getPixelToMeterRatio());
        double d4 = d2 * (double)f;
        double d5 = d3 * (double)f;
        try
        {
            double d6 = class6.MF_CLASS6_c9();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): new position is (x,y) = (").append(d).append(", ").append(d1).append(")").append(", headingDeg = ").append(d6).append(", mPositionCnt = ").append(mPositionCnt).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): new position is pixel (x,y) = (").append(d).append(", ").append(d1).append(")").append(", headingDeg = ").append(d6).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): new position is meter (x,y) = (").append(d2).append(", ").append(d3).append(")").append(", headingDeg = ").append(d6).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): new position is conv pixel (x,y) = (").append(d4).append(", ").append(d5).append(")").append(", headingDeg = ").append(d6).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): new position mGraphicsXML.getTransformations().getPixelToMeterRatio() = ").append(mGraphics.getPixelTransform().getPixelToMeterRatio()).toString());
            NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
            numberformat.setMinimumFractionDigits(1);
            numberformat.setMaximumFractionDigits(1);
            String s1 = numberformat.format(d);
            String s2 = numberformat.format(d1);
            String s3 = numberformat.format(d6);
            Date date = new Date();
            String s4 = z.format(date);
            String s5 = (new StringBuilder()).append("Resp:, x = ").append(s1).append(", y = ").append(s2).append(", deg = ").append(s3).append(", r-trip: %1$sms").toString();
            Object aobj[] = new Object[1];
            aobj[0] = (new StringBuilder()).append(class6.MF_CLASS6_e11()).append(", ts : ").append(s4).toString();
            A = String.format(s5, aobj);
            A = (new StringBuilder()).append(A).append("\nqueue len =").append(class6.MF_CLASS6_f12()).toString();
            bk = class6.MF_CLASS6_f12();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onServiceUpdate(): mLastBGCalib = ").append(bd).toString());
            runOnUiThread(new CLASS289(this, d, d1, d6, class6));
            return;
        }
        catch(Exception exception)
        {
            CLASS167.unhandledexception(exception, getApplicationContext());
        }
        return;
    }

    public void onStartCalibration()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onStartCalibration: setting black image: ").append(System.currentTimeMillis()).toString());
        startCalibration();
    }

    public void onWalkViewCancelled()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("onWalkViewCancelled, mCurrentState == ").append(mScreenPointType).toString());
        if(mScreenPointType == POINT_TYPE.POSITIONING)
            showStopPositioningDialog();
    }

    public void putOverlay(Bitmap bitmap, String s1, int i, float f, float f1, int j)
    {
        float f2 = mMe.getResources().getDisplayMetrics().density;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("putOverlay : scale = ").append(f2).append(", bitmap.getWidth() = ").append(bitmap.getWidth()).append(", bitmap.getHeight() = ").append(bitmap.getHeight()).append(", text = ").append(s1).toString());
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint.setTextSize(f2 * (float)j);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(i);
        canvas.drawText(s1, f * (float)bitmap.getWidth(), f1 * (float)bitmap.getHeight(), paint);
    }

    public void resetAPI() throws CLASS1
    {
        try {
	    	if(mIndoorAtlas != null)
	            mIndoorAtlas.tearDown();
	        bi = false;
	        mIndoorAtlas = IndoorAtlasFactory.createIndoorAtlas(mMe.getApplicationContext(), mMe, mApiKey, mSecret);
	        bd = "";
	        be = 0.0F;
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("resetAPI : mBGCalibrationReady = ").append(isBGCalibrationReady()).toString());
	        runOnUiThread(new CLASS262(this));
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }

    public void setBackendSequences(List list)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences called, segments = ").append(list).toString());
        CLASS167.MF_CLASS167_b635("MapScreen", "setBackendSequences(): calling mIndoorMapView.setBackendSegments(segments)");
        mIndoorMapView.setBackendSegments(list);
        List list1 = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID());
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): 1 localMeasurements.size = ").append(list1.size()).toString());
        List list2 = getNotContained(list1, list);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): beSegmentsNoInLocalDB = ").append(list2).toString());
        if(list2 != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): beSegmentsNoInLocalDB.size = ").append(list2.size()).toString());
            for(Iterator iterator = list2.iterator(); iterator.hasNext();)
            {
                Measurement class108 = (Measurement)iterator.next();
                class108.bID = mCurrentBuilding.getBuildingID();
                class108.lID = mCurrentLevel.getLevelID();
            }

            MF_CLASS24_c88(list2);
        }
        List list3 = getNotContained(list, MF_CLASS19_a67(list1));
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): localSegmentsNotInBE = ").append(list3).toString());
        if(list3 != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): localSegmentsNotInBE.size = ").append(list3.size()).toString());
            removeLocalSegmentsFromDBAndMemory(list3);
        }
        List list4 = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID());
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): 2 localMeasurements.size = ").append(list4.size()).toString());
        List list5 = getBESegmentsWithoutRoute(list4);
        if(list5 != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setBackendSequences(): calling mRestClient.getBackendSegmentRoutes: beSegmentsWithoutRoute.size = ").append(list5.size()).toString());
            bp = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID());
            mRouteFetchCount = list5.size();
            mRestClient.getBackendSegmentRoutes(list5);
        }
        if(mRouteFetchCount == 0)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "setBackendSequences closing inprogress dialog --> no routes to fetch");
            hideInProgressDialog();
        }
    }

    public void setDebugBoxVisible(boolean flag)
    {
        int i;
        LinearLayout linearlayout;
        if(flag)
            i = 0;
        else
            i = 4;
        linearlayout = (LinearLayout)findViewById(R.id.overlaybox);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setDebugBoxVisible: overlaybox = ").append(linearlayout).toString());
        linearlayout.setVisibility(i);
    }

    public void setDebugMessage(String s1)
    {
        if(bn == null)
            bn = (TextView)findViewById(0x7f0b001e);
//        bn.setText(s1);
//        mIndoorMapView.invalidate();
    }

    public void setIconOverlayForNumberOfToBeUploadedSegments()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "setIconOverlayForNumberOfToBeUploadedSegments called: ");
        //long l = MeasurementDataSource.MF_CLASS381_a1107(mGraphics.MF_CLASS103_a414());
        long l = 20001;

        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setIconOverlayForNumberOfToBeUploadedSegments cnt = ").append(l).toString());
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.action_bar_icon_send);
        Bitmap bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        bitmap.recycle();
        putOverlay(bitmap1, Long.valueOf(l).toString(), Color.rgb(110, 110, 110), 0.5F, 0.5555556F, 10);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setIconOverlayForNumberOfToBeUploadedSegments setting icon for  ").append(mUploadButton).append(", drawable = ").append(bitmapdrawable).toString());
        mUploadButton.setIcon(bitmapdrawable);
        CLASS167.MF_CLASS167_b635("MapScreen", "setIconOverlayForNumberOfToBeUploadedSegments done. ");
    }

    public void setReCalibrationRequired(boolean flag)
    {
        aP = flag;
    }

    public void setRouteForSequence(String s1, List list)
    {
    	mRouteFetchCount = -1 + mRouteFetchCount;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setRouteForSequence : sequenceId = ").append(s1).append(", points.size = ").append(list.size()).append(", mRouteFetchCount = ").append(mRouteFetchCount).toString());

        try {
	        runOnUiThread(new CLASS297(this));
	        Iterator iterator = bp.iterator();
	        do
	        {
	            if(!iterator.hasNext())
	                break;
	            Measurement class108 = (Measurement)iterator.next();
	            if(!class108.segmentID.equals(s1))
	                continue;
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setRouteForSequence MATCHING SEQ: sequenceId = ").append(s1).append(", --> storing route.").toString());
	            class108.MF_CLASS108_a447(list);
	            MeasurementDataSource.MeasurementdeletedDBWithid(class108.mMeasurementID);
	            MeasurementDataSource.storeMeasurement(class108);
	            mIndoorMapView.addRecordedSegment(class108);
	            break;
	        } while(true);
	        if(mRouteFetchCount == 0)
	        {
	            CLASS167.MF_CLASS167_b635("MapScreen", "setRouteForSequence closing inprogress dialog");
	            runOnUiThread(new CLASS298(this));
	            bp = null;
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("setRouteForSequence : *** ERROR:  NO MATHCING SEQUENCE***: sequenceId = ").append(s1).toString());
	        return;

        } catch(Exception exception) {
	        exception.printStackTrace();
	        //throw exception;
        }
    }

    public void setShowSensorValuesOnScreen(boolean flag)
    {
    	mSensorController.MF_CLASS375_c1047(flag);
    }

    public void showCalibView()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showCalibView called.");

        try {
	        if(mIndoorAtlas != null)
	        {
	            CLASS167.MF_CLASS167_b635("MapScreen", "showCalibView(): calling mIndoorAtlas.tearDown()");
	            mIndoorAtlas.tearDown();
	        }
	        aV = true;
	        if(mSensorReader != null)
	        	mSensorReader.stopCalibration();
	        mSensorReader = new SensorReader(mMe.getApplicationContext(), mMe, mMe);
	        mSensorReader.MF_CLASS375_a1045(50F);
	        mSensorReader.startSensors();
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
	    }

        br = CalibrationDialogFragment.createInstance(this);
        br.show(getFragmentManager(), "calibviewdialog");
        return;
    }

    public void showCloseFloorplanDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Close floor plan?").setCancelable(false).setPositiveButton("Yes", new CLASS282(this)).setNegativeButton("No", new CLASS280(this));
        builder.create().show();
    }

    public void showConnectionIndicator()
    {
        int i = getMessageQueueLength();
        ImageView imageview = (ImageView)findViewById(0x7f0b001c);
        imageview.setVisibility(0);
        if(System.currentTimeMillis() - bl < 2000L)
        {
            imageview.setImageResource(0x7f02001b);
            return;
        }
        if(i <= 3)
        {
            imageview.setVisibility(4);
            return;
        }
        if(i <= 7)
        {
            imageview.setImageResource(0x7f02001b);
            return;
        } else
        {
            imageview.setImageResource(0x7f02001a);
            return;
        }
    }

    public void showDeveloperMenuDialog()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() called.");
        CharSequence acharsequence[] = {
            "Settings", "Dump DB", "Delete DB", "Toggle Show Backend Data", "Generate Map", "Show sensors", "Show help video", "Plot Last Calibration Mgn", "Check raw Mgn sensor", "Test API calibration",
            "Reset API", "Test Paths", "Generate map", "Plot BG Calibs"
        };
        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() created name array.");

        try {
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showDeveloperMenuDialog() calling builder.setTitle.");
	        builder.setTitle("Extra menu");
	        builder.setItems(acharsequence, new CLASS261(this)).setNegativeButton("Cancel", new CLASS260(this));
	        AlertDialog alertdialog = builder.create();
	        alertdialog.setCanceledOnTouchOutside(false);
	        alertdialog.setCancelable(false);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() calling alert.show().");
	        alertdialog.show();
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() returning.");

	        return;
        } catch(Exception exception1) {
	        exception1.printStackTrace();
	        CLASS167.unhandledexception(exception1, getApplicationContext());
        //throw exception1;
        }
    }

    public void showHelpMenu()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() called.");
        CharSequence acharsequence[] = {
            "Toolbox User's Guide video"
        };
        CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() item name array.");
        try {
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() calling builder.setTitle.");
	        builder.setTitle("Help menu");
	        builder.setItems(acharsequence, new CLASS264(this)).setNegativeButton("Cancel", new CLASS263(this));
	        AlertDialog alertdialog = builder.create();
	        alertdialog.setCanceledOnTouchOutside(false);
	        alertdialog.setCancelable(false);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() calling alert.show().");
	        alertdialog.show();
	        CLASS167.MF_CLASS167_b635("MapScreen", "showHelpMenu() returning.");
	        return;
        } catch(Exception exception1) {
	        exception1.printStackTrace();
	        CLASS167.unhandledexception(exception1, getApplicationContext());
	        //throw exception1;
        }
    }

    public void showHipriModeDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(0x7f08003c)).setCancelable(false).setPositiveButton("Yes", new CLASS284(this)).setNegativeButton("No", new CLASS283(this));
        builder.create().show();
    }

    public void showInProgressDialog(String s1, boolean flag)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showInProgressDialog(): called, text = ").append(s1).toString());
        if(mProgressDialog2 != null)
            hideInProgressDialog();
        mProgressDialog2 = new ProgressDialog(this);
        mProgressDialog2.setCancelable(flag);
        mProgressDialog2.setProgressStyle(0);
        mProgressDialog2.setMessage(s1);
        mProgressDialog2.setCanceledOnTouchOutside(false);
        mProgressDialog2.setOnKeyListener(new CLASS242(this));
        CLASS167.MF_CLASS167_b635("MapScreen", " showInProgressDialog : calling this.inProgressDialog.show()");
        mProgressDialog2.show();
    }

    public void showInformationDialog(String s1)
    {
        if(mAlertDialog2 != null)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "showInformationDialog : old dialog still existing -- was this intentional?");
            mAlertDialog2.cancel();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS274(this));
        mAlertDialog2 = builder.create();
        mAlertDialog2.show();
    }

    public void showInformationDialogWhichClosesActivity(String s1)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS275(this));
        builder.create().show();
    }

    public void showInformationDialogWhichRestartsCalibration(String s1)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Ok", new CLASS276(this));
        builder.create().show();
    }

    public void showNetworkProblemDialog()
    {
        if(!E)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "showNetworkProblemDialog(): showing InProgressDialog");
            E = true;
            runOnUiThread(new CLASS292(this));
            return;
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "showNetworkProblemDialog(): NOT showing InProgressDialog, already visible");
            return;
        }
    }

    public void showOkButtonDialog(String s1)
    {
        runOnUiThread(new CLASS302(this, s1));
    }

    public void showOnDebugMessage()
    {
        setDebugMessage((new StringBuilder()).append(A).append("\n").append(K).append("\n").append(bd).append("\nForced: ").append(CLASS75.MF_CLASS75_a259(bc)).append("\n").append(H).append("\n").append(J).append("\n failed requests: ").append(T).append("\n").append(U).append("\n").append(mConnectedVsStrongestWiFiAP).toString());
    }

    public void showReCalibrationDueToAccuracyDialog()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showReCalibrationDueToAccuracyDialog called.");
        mRecordingCancelled = true;
        try {
        	onRecordButtonClick();
        } catch(Exception exception) {
	        exception.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The device requires re-calibration.").setCancelable(false).setPositiveButton("Ok", new CLASS234(this));
        builder.create().show();
        return;
    }

    public void showRecordingCancelledDueToSensorProblemDialog(String s1)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showRecordingCancelledDueToSensorProblemDialog called error = ").append(s1).toString());
        mRecordingCancelled = true;
        try {
        	onRecordButtonClick();
        } catch(Exception exception) {
	        exception.printStackTrace();
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception.printStackTrace();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sensor error. Please record the path again.").setCancelable(false).setPositiveButton("Ok", new CLASS235(this));
        builder.create().show();
        return;
    }

    public void showRetryDeleteAllSegmentsDialog(String s1)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(s1).setCancelable(false).setPositiveButton("Retry", new CLASS305(this)).setNegativeButton("Cancel", new CLASS304(this));
        builder.create().show();
    }

    public void showRotateIcon()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showRotateIcon()");
        mNaviButton.setVisibility(0);
        mNaviButton.setClickable(true);
    }

    public void showRoutePointLabelDialog()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showRoutePointLabelDialog() called.");
        try {
	        getResources();
	        String as1[] = aQ;
	        CLASS167.MF_CLASS167_b635("MapScreen", "showRoutePointLabelDialog() created level name array.");
	        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showRoutePointLabelDialog() calling builder.setTitle.");
	        builder.setTitle("Select route point label");
	        builder.setItems(as1, new CLASS268(this, as1));
	        AlertDialog alertdialog = builder.create();
	        alertdialog.setCanceledOnTouchOutside(false);
	        alertdialog.setCancelable(false);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showRoutePointLabelDialog() calling alert.show().");
	        alertdialog.show();
	        CLASS167.MF_CLASS167_b635("MapScreen", "showRoutePointLabelDialog() returning.");
	        return;
        } catch(Exception exception1) {
	        exception1.printStackTrace();
	        CLASS167.unhandledexception(exception1, getApplicationContext());
	        //throw exception1;
        }
    }

    public void showScanModeOnlyDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Opening Wi-Fi settings. Please check the option Scanning Always Available from the Advanced Settings.").setCancelable(false).setPositiveButton("Ok", new CLASS277(this));
        builder.create().show();
    }

    public void showSegmentLabelDialog()
    {
        int i = 0;
        String as1[];
        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentLabelDialog() called.");
        as1 = new String[1 + aQ.length];

        for(;i < aQ.length;i++) {
        	as1[i] = aQ[i];
        }

        try {
	        as1[aQ.length] = "Enter text";
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentLabelDialog() created level name array.");
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentLabelDialog() calling builder.setTitle.");
	        builder.setTitle("Select path label");
	        builder.setItems(as1, new ShowSegmentLabelDialogListener(this, as1));
	        AlertDialog alertdialog = builder.create();
	        alertdialog.setCanceledOnTouchOutside(false);
	        alertdialog.setCancelable(false);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentLabelDialog() calling alert.show().");
	        alertdialog.show();
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentLabelDialog() returning.");
	
	        return;
        } catch(Exception exception1) {
	        exception1.printStackTrace();
	        CLASS167.unhandledexception(exception1, getApplicationContext());
	        //throw exception1;
        }
    }

    public void showSegmentSelectedDialog()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() called.");
        CharSequence acharsequence[];
        if(!CLASS113.isDeviceChecked.booleanValue()) {
                acharsequence = (new CharSequence[] {
                    "Delete"
                });
        } else {
	        acharsequence = new CharSequence[10];
	        acharsequence[0] = "Delete";
	        acharsequence[1] = "Properties";
	        acharsequence[2] = "Plot Mgn";
	        acharsequence[3] = "Plot Pressure";
	        acharsequence[4] = "Plot Light";
	        acharsequence[5] = "Plot Proximity";
	        acharsequence[6] = "Plot Temperature";
	        acharsequence[7] = "Plot Gyro";
	        acharsequence[8] = "Plot Acc";
	        acharsequence[9] = "Write to protobuf";
        }

        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() created level name array.");

        try {
	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() calling builder.setTitle.");
	        builder.setTitle("Edit");
	        builder.setItems(acharsequence, new CLASS259(this)).setNegativeButton("Cancel", new CLASS258(this));
	        AlertDialog alertdialog = builder.create();
	        alertdialog.setCanceledOnTouchOutside(false);
	        alertdialog.setCancelable(false);
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() calling alert.show().");
	        alertdialog.show();
	        CLASS167.MF_CLASS167_b635("MapScreen", "showSegmentSelectedDialog() returning.");
	        return;

        } catch(Exception exception1) {
	        exception1.printStackTrace();
	        aW = false;
	        CLASS167.unhandledexception(exception1, getApplicationContext());
        //throw exception;
        }
    }

    public void showStatusText(String s1)
    {
    }

    public void showStopPositioningDialog()
    {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stop positioning?").setCancelable(false).setPositiveButton("Yes", new CLASS279(this)).setNegativeButton("No", new CLASS278(this));
        builder.create().show();
    }

    public void showToastMessage(String s1, int i)
    {
        runOnUiThread(new CLASS296(this, s1, i));
    }

    public void showWalkView()
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showWalkView called.");
        bq = WalkViewDialogFragment.MF_CLASS350_a948(this);
        bq.show(getFragmentManager(), "walkviewdialog");
    }

    public void showWalkViewAndStartPositioning()
    {
        runOnUiThread(new CLASS255(this));
        CLASS167.MF_CLASS167_b635("MapScreen", "calling synchronized mIndoorAtlas.startPositioning");
        try
        {
            mIndoorAtlas.startPositioning(mCurrentBuilding.getBuildingID(), mCurrentLevel.getLevelID(), mGraphics.getGraphicsID());
        }
        catch(Exception class1)
        {
            class1.printStackTrace();
            runOnUiThread(new ShowCalibrationRequiredDialog(this));
        }
        mPositioningStartTime = System.currentTimeMillis();
        mPositionCnt = 0L;
    }

    public void startCalibration()
    {
        try {
        	mSensorReader.startCalibration(false);
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }
    }

    public final float[] transformOriginalCoordsToCurrentImageCoords(ImageView imageview, float f, float f1)
    {
        float af1[] = new float[2];
        af1[0] = f / (float)mBitmapScale;
        af1[1] = f1 / (float)mBitmapScale;
        imageview.getImageMatrix().mapPoints(af1);
        return af1;
    }

    public Path transformPathFromOriginalCoordsToCurrentImageCoords(ImageView imageview, Path path)
    {
        path.transform(imageview.getImageMatrix());
        return path;
    }

    public final float transformPixelDistanceToPIxelDistanceInOriginalImageCoords(ImageView imageview, float f)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("transformPixelDistanceToPIxelDistanceInOriginalImageCoords: dist = ").append(f).toString());
        float af1[] = {
            0.0F, 0.0F
        };
        float af2[] = {
            0.0F, f
        };
        Matrix matrix1 = new Matrix();
        imageview.getImageMatrix().invert(matrix1);
        matrix1.mapPoints(af1);
        matrix1.mapPoints(af2);
        float f1 = af1[0] * (float)mBitmapScale;
        float f2 = af1[1] * (float)mBitmapScale;
        float f3 = af2[0] * (float)mBitmapScale;
        float f4 = af2[1] * (float)mBitmapScale;
        float f5 = mIndoorMapView.getEuclideanDistance(f1, f2, f3, f4);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("transformPixelDistanceToPIxelDistanceInOriginalImageCoords: distOrigCoords = ").append(f5).toString());
        return f5;
    }

    public final float[] transformTouchPointCoordsToOriginalImageCoords(ImageView imageview, float f, float f1)
    {
        float af1[] = {
            f, f1
        };
        Matrix matrix1 = new Matrix();
        imageview.getImageMatrix().invert(matrix1);
        matrix1.mapPoints(af1);
        return (new float[] {
            af1[0] * (float)mBitmapScale, af1[1] * (float)mBitmapScale
        });
    }

    public void updateCalibrationStatus(CalibrationEvent class18)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("updateCalibrationStatus called, cs = ").append(class18).toString());
        if(class18.getCalibrationStatus() == CLASS19.IN_PROGRESS) {
	        runOnUiThread(new CLASS248(this, (new StringBuilder()).append(L.format(class18.MF_CLASS18_b62())).append(" %").toString()));
        } else if(class18.getCalibrationStatus() == CLASS19.DISCARDING) {
    	        runOnUiThread(new CLASS249(this));
    	        if(class18.MF_CLASS18_d64() > 20000L) {
    		        CLASS167.MF_CLASS167_b635("MapScreen", "updateCalibrationStatus called, > Constants.MAX_CALIBRATION_DURATION --> cancelling calibration");
    		        runOnUiThread(new CLASS250(this));
    		        return;
    	        }
        } else if(class18.getCalibrationStatus() == CLASS19.WAITING) {
    	        runOnUiThread(new CLASS251(this));
        }
        return;
    }

    public void updateInProgressDialog(String s1)
    {
        if(mProgressDialog2 != null)
            mProgressDialog2.setMessage(s1);
    }

    public void updatePosition(float f, float f1, float f2, float f3)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.updatePosition(): called");
        ak = 1 + ak;
    }

    public void vibrate(int i)
    {
        if(mVibrator != null)
            mVibrator.vibrate(i);
    }

    public void writeCalibrationSetToFile(CLASS370 class370)
    {
        (new CLASS318(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new CLASS370[] {
            class370
        });
    }

    public static final String TAG = "MapScreen";
    public static float UiPixelScale = 1.0F;
    public static Measurement currentMeasurement = null;
    String A;
    String B;
    String C;
    long D;
    boolean E;
    int F;
    long mPositionCnt;
    String H;
    String I;
    String J;
    String K;
    NumberFormat L;
    NumberFormat M;
    boolean N;
    BufferedReader mBufferedReader;
    android.os.Process P;
    AlertDialog mAlertDialog2;
    android.view.View.OnTouchListener localTouchListener;
    private boolean S;
    private int T;
    private String U;
    private SensorController mSensorController;
    private SensorReader mSensorReader;
    private MenuItem mRecordingItem;
    private MenuItem mUploadButton;
    private MenuItem Z;
    FlashStopButtonTask mFlashStop;
    private float aA;
    private boolean aB;
    private boolean aC;
    private float aD;
    private float aE;
    private TouchMode mTouchMode;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private boolean aN;
    private String aO;
    private boolean aP;
    private String aQ[];
    private int aR;
    private int aS;
    private boolean aT;
    private IndoorAtlas mIndoorAtlas;
    private boolean aV;
    private boolean aW;
    private ImageView aX;
    private boolean aY;
    private boolean aZ;
    private long aa;
    private IndoorMapView mIndoorMapView;
    private ProgressDialog mProgressDialog1;
    private ProgressDialog mProgressDialog2;
    private AlertDialog mAlertDialog;
    private RestClient mRestClient;
    private Measurement mEndMeasure;
    private Measurement mStartMeasure;
    private CLASS110 ai;
    private int aj;
    private int ak;
    private long al;
    private WifiScanReceiver am;
    private android.net.wifi.WifiManager.WifiLock an;
    private BroadcastReceiver ao;
    private final float ap = 1000F;
    private int aq;
    private double ar;
    private double as;
    private double at;
    private double au;
    private double av;
    private float aw;
    private int ax;
    private int ay;
    private long az;
    DownloadImageTask MF_CLASS19_b68;
    private int ba;
    private int bb;
    private double bc[] = {
        0.0D, 0.0D, 0.0D
    };
    private String bd;
    private float be;
    private float bf;
    private CLASS368 bg;
    private long bh;
    private boolean bi;
    private WifiRoamingScanReceiver mWifiRoamingScanReceiver;
    private int bk;
    private long bl;
    private long bm;
    private TextView bn;
    private int mRouteFetchCount;
    private List bp;
    private WalkViewDialogFragment bq;
    private CalibrationDialogFragment br;
    public POINT_TYPE mScreenPointType;
    Matrix MF_CLASS19_d70;
    float MF_CLASS19_e71;
    float MF_CLASS159_f577;
    PointF MF_CLASS22_g77;
    PointF MF_CLASS159_h579;
    float MF_CLASS108_i455;
    float MF_CLASS108_j456;
    float MF_CLASS108_k457;
    float MF_CLASS108_l458;
    float m;
    public String mApiKey;
    public Bitmap mBitmap;
    public int mBitmapScale;
    public String mConnectedVsStrongestWiFiAP;
    public String mCookie;
    public float mCumulativeRotation;
    public Building mCurrentBuilding;
    public Level mCurrentLevel;
    public float mCurrentZoom;
    public CLASS100 mDevice;
    public CLASS101 mDeviceModel;
    public Integer mFilesBeingWritten;
    protected GestureDetector mGestureDetector;
    protected CLASS313 mGestureListener;
    public MapGraphics mGraphics;
    public boolean mInitializingPositioning;
    public boolean mLabelRoutePoints;
    public long mLastRountrip;
    public long mLastSuccesfulLocationUpdateTimestamp;
    protected long mLastUIUpdateTimestamp;
    protected final Runnable mLongClickHandler = new CLASS257(this);
    public float mMaxImageHeightHWAccel;
    public float mMaxImageWidthHWAccel;
    public MapScreen mMe;
    public CLASS314 mMode;
    public ImageButton mNaviButton;
    public String mPassword;
    public long mPositioningStartTime;
    public boolean mPrefsChanged;
    public boolean mRecordingCancelled;
    public boolean mRecordingSegment;
    public boolean mScrollToPosition;
    public String mSecret;
    public boolean mSmoothBetweenPrevAndCurrentPosition;
    public boolean mTurnMapAutomatically;
    public boolean mUpdatingLocation;
    public boolean mUploadingGenerationInProgress;
    public String mUserName;
    public Vibrator mVibrator;
    public WifiManager mWifiManager;
    public Matrix matrix;
    float MF_CLASS108_n460;
    float MF_CLASS108_o461;
    float MF_CLASS108_p462;
    float MF_CLASS108_q463;
    float r;
    float s;
    CountDownTimer t;
    CountDownTimer u;
    long v;
    int w;
    long x;
    int y;
    SimpleDateFormat z;

}
