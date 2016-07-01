// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS323
    implements Runnable
{

    CLASS323(Sipa sipa)
    {
        MF_CLASS323_a914 = sipa;

    }

    public void run()
    {
        MF_CLASS323_a914.initiateGetBuildingsRequest();
    }

    final Sipa MF_CLASS323_a914;
}
