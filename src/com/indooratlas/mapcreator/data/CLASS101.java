// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.data;

import java.io.Serializable;


public class CLASS101
    implements Serializable
{

    public CLASS101(com.indooratlas.communication.be.DeviceModel devicemodel)
    {
        MF_CLASS101_m399 = "";
        MF_CLASS101_n400 = "";
        MF_CLASS101_o401 = "";
        MF_CLASS101_p402 = "";
        MF_CLASS101_q403 = "";
        MF_CLASS101_r404 = "";
        MF_CLASS101_s405 = "";
        MF_CLASS101_t406 = "";
        MF_CLASS101_u407 = "";
        MF_CLASS101_v408 = "";
        MF_CLASS101_w409 = "";
        MF_CLASS101_x410 = 0;
        if(devicemodel.hasId())
            MF_CLASS101_a388(devicemodel.getId());
        if(devicemodel.hasUrl())
            MF_CLASS101_b389(devicemodel.getUrl());
        if(devicemodel.hasProduct())
            MF_CLASS101_c390(devicemodel.getProduct());
        if(devicemodel.hasPlatform())
            MF_CLASS101_d391(devicemodel.getPlatform());
        if(devicemodel.hasPlatformVersion())
            MF_CLASS101_e392(devicemodel.getPlatformVersion());
        if(devicemodel.hasHardwareVersion())
            MF_CLASS101_f393(devicemodel.getHardwareVersion());
        if(devicemodel.hasManufacturer())
            MF_CLASS101_g394(devicemodel.getManufacturer());
        if(devicemodel.hasDevice())
            MF_CLASS101_h395(devicemodel.getDevice());
        if(devicemodel.hasBrand())
            MF_CLASS101_i396(devicemodel.getBrand());
        if(devicemodel.hasSdkVersion())
            MF_CLASS101_j397(devicemodel.getSdkVersion());
        if(devicemodel.hasOthers())
            MF_CLASS101_k398(devicemodel.getOthers());
        if(devicemodel.hasSupportStatus())
            MF_CLASS101_a388(devicemodel.getSupportStatus());
    }

    public CLASS101 MF_CLASS101_a388(int i)
    {
        MF_CLASS101_l411 = true;
        MF_CLASS101_x410 = i;
        return this;
    }

    public CLASS101 MF_CLASS101_a388(String s)
    {
        MF_CLASS101_a388 = true;
        MF_CLASS101_m399 = s;
        return this;
    }

    public String MF_CLASS101_a388()
    {
        return MF_CLASS101_m399;
    }

    public CLASS101 MF_CLASS101_b389(String s)
    {
        MF_CLASS101_b389 = true;
        MF_CLASS101_n400 = s;
        return this;
    }

    public String MF_CLASS101_b389()
    {
        return MF_CLASS101_t406;
    }

    public CLASS101 MF_CLASS101_c390(String s)
    {
        MF_CLASS101_c390 = true;
        MF_CLASS101_o401 = s;
        return this;
    }

    public String MF_CLASS101_c390()
    {
        return MF_CLASS101_w409;
    }

    public int MF_CLASS101_d391()
    {
        return MF_CLASS101_x410;
    }

    public CLASS101 MF_CLASS101_d391(String s)
    {
        MF_CLASS101_d391 = true;
        MF_CLASS101_p402 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_e392(String s)
    {
        MF_CLASS101_e392 = true;
        MF_CLASS101_q403 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_f393(String s)
    {
        MF_CLASS101_f393 = true;
        MF_CLASS101_r404 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_g394(String s)
    {
        MF_CLASS101_g394 = true;
        MF_CLASS101_s405 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_h395(String s)
    {
        MF_CLASS101_h395 = true;
        MF_CLASS101_t406 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_i396(String s)
    {
        MF_CLASS101_i396 = true;
        MF_CLASS101_u407 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_j397(String s)
    {
        MF_CLASS101_j397 = true;
        MF_CLASS101_v408 = s;
        return this;
    }

    public CLASS101 MF_CLASS101_k398(String s)
    {
        MF_CLASS101_k398 = true;
        MF_CLASS101_w409 = s;
        return this;
    }

    private static final long serialVersionUID = 1L;
    private boolean MF_CLASS101_a388;
    private boolean MF_CLASS101_b389;
    private boolean MF_CLASS101_c390;
    private boolean MF_CLASS101_d391;
    private boolean MF_CLASS101_e392;
    private boolean MF_CLASS101_f393;
    private boolean MF_CLASS101_g394;
    private boolean MF_CLASS101_h395;
    private boolean MF_CLASS101_i396;
    private boolean MF_CLASS101_j397;
    private boolean MF_CLASS101_k398;
    private boolean MF_CLASS101_l411;
    private String MF_CLASS101_m399;
    private String MF_CLASS101_n400;
    private String MF_CLASS101_o401;
    private String MF_CLASS101_p402;
    private String MF_CLASS101_q403;
    private String MF_CLASS101_r404;
    private String MF_CLASS101_s405;
    private String MF_CLASS101_t406;
    private String MF_CLASS101_u407;
    private String MF_CLASS101_v408;
    private String MF_CLASS101_w409;
    private int MF_CLASS101_x410;
}
