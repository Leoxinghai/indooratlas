// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.wifiroaming;

import android.net.wifi.WifiInfo;
import java.util.List;

public interface CLASS198
{

    public abstract void infoMessage(String s);

    public abstract void onScanReceived(long l, List list, WifiInfo wifiinfo, int i, int j, boolean flag);
}
