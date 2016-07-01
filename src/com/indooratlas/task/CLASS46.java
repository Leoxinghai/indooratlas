// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.task;

import android.net.NetworkInfo;

public class CLASS46
{

    public CLASS46(boolean flag, boolean _mMobileAvailable, boolean flag2, boolean flag3, boolean flag4, boolean flag5, boolean flag6, 
            NetworkInfo networkinfo, NetworkInfo networkinfo1, NetworkInfo networkinfo2)
    {
    	mMobileHipriConnected = false;
    	mMobileHipriAvailable = false;
    	mWifiEnabled = false;
    	mWifiConnected = false;
    	mMobileDataEnabled = false;
        mWifi = null;
        mMobile = null;
        mMobileHipri = null;
        mMobileConnected = flag;
        mMobileAvailable = _mMobileAvailable;
        mMobileHipriConnected = flag2;
        mMobileHipriAvailable = flag3;
        mWifiEnabled = flag4;
        mWifiConnected = flag5;
        mMobileDataEnabled = flag6;
        mWifi = networkinfo;
        mMobile = networkinfo1;
        mMobileHipri = networkinfo2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("mobileConnected = ").append(mMobileConnected).append(", mobileAvailable = ").append(mMobileAvailable).append(", mobileHipriConnected = ").append(mMobileHipriConnected).append(", mobileHipriAvailable = ").append(mMobileHipriAvailable).append(", wifiEnabled = ").append(mWifiEnabled).append(", wifiConnected = ").append(mWifiConnected).append(", mobileDataEnabled = ").append(mMobileDataEnabled).append(", wifi = ").append(mWifi).append(", mobile = ").append(mMobile).append(", mobileHipri = ").append(mMobileHipri).toString();
    }

    public boolean mMobileConnected;
    public boolean mMobileAvailable;
    public boolean mMobileHipriConnected;
    public boolean mMobileHipriAvailable;
    public boolean mWifiEnabled;
    public boolean mWifiConnected;
    public boolean mMobileDataEnabled;
    NetworkInfo mWifi;
    NetworkInfo mMobile;
    NetworkInfo mMobileHipri;
}
