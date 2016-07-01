// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;


// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen

class CLASS271
    implements Runnable
{

    CLASS271(MapScreen mapscreen, String s)
    {
        MF_CLASS271_b826 = mapscreen;
        MF_CLASS271_a827 = s;

    }

    public void run()
    {
        MF_CLASS271_b826.showToastMessage((new StringBuilder()).append("Validation coverage: ").append(MF_CLASS271_a827).append("%").toString(), 0);
    }

    final String MF_CLASS271_a827;
    final MapScreen MF_CLASS271_b826;
}
