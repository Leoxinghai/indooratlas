// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;


// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS143, RestClient

class CLASS144
    implements Runnable
{

    CLASS144(CLASS143 class143, String s)
    {
        MF_CLASS144_b542 = class143;
        MF_CLASS143_a541 = s;
    }

    public void run()
    {
        RestClient.MF_CLASS54_a201(MF_CLASS144_b542.mRestClient, (new StringBuilder()).append("Validation coverage: ").append(MF_CLASS143_a541).append("%").toString());
    }

    final String MF_CLASS143_a541;
    final CLASS143 MF_CLASS144_b542;
}
