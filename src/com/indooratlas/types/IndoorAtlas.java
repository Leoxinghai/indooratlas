package com.indooratlas.types;


import com.indooratlas.base.CLASS1;

public interface IndoorAtlas
{
	
    public abstract void stopPositioning();

    public abstract void startPositioning(String s, String s1, String s2) throws CLASS1;

    public abstract void setPreferMobileConnection(boolean flag);

    public abstract void tearDown() throws Exception;

    public abstract boolean isBGCalibrated();

    public abstract float getCommunicationLatency();

    public abstract int MF_Some3EventBase_e005();
}
