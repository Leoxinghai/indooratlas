// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.controller;


// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS113, CLASS164

class CLASS165
    implements Runnable
{

    CLASS165(CLASS164 class164)
    {
        MF_CLASS113_a486 = class164;
    }

    public void run()
    {
        if(CLASS113.isExceptionLogged.booleanValue())
            MF_CLASS113_a486.MF_CLASS113_a486("Unfortunately IndoorAtlas was stopped. A crash report has been recorded and we're working on a fix. Please restart the application and retry.");
    }

    final CLASS164 MF_CLASS113_a486;
}
