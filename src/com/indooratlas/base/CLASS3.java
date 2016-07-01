// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.base;

import com.indooratlas.types.Some1Base;

// Referenced classes of package com.indooratlas.base:
//            CLASS6

public interface CLASS3
{

    public abstract void onCalibrationFailed(String s);

    public abstract void onCalibrationInvalid();

    public abstract void onCalibrationReady();

    public abstract void onCalibrationStatus(Some1Base some1base);

    public abstract void onInitializationFailed(String s);

    public abstract void onNetworkChangeComplete(boolean flag);

    public abstract void onServiceFailure(int i, String s);

    public abstract void onServiceInitialized();

    public abstract void onServiceInitializing();

    public abstract void onServiceStopped();

    public abstract void onServiceUpdate(CLASS6 class6);
}
