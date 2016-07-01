// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.data;


// Referenced classes of package com.indooratlas.mapcreator.data:
//            CLASS112, Measurement

public class CLASS110
{

    public CLASS110(Measurement class108, CheckPoint class112, float f, boolean flag)
    {
        MF_CLASS112_c482 = 0.0F;
        MF_CLASS112_d483 = null;
        MF_CLASS110_e468 = false;
        MF_CLASS110_a465 = MF_CLASS110_a465;
        MF_CLASS110_b469 = class112;
        MF_CLASS112_c482 = f;
        float af[] = new float[2];
        af[0] = class112.coordX;
        af[1] = class112.coordY;
        MF_CLASS112_d483 = af;
        MF_CLASS110_e468 = flag;
    }

    public boolean MF_CLASS110_a465(CLASS110 class110)
    {
        return class110 != null && class110.MF_CLASS110_b469.coordX == MF_CLASS110_b469.coordX && class110.MF_CLASS110_b469.coordY == MF_CLASS110_b469.coordY;
    }

    public Measurement MF_CLASS110_a465;
    public CheckPoint MF_CLASS110_b469;
    public float MF_CLASS112_c482;
    public float MF_CLASS112_d483[];
    public boolean MF_CLASS110_e468;
}
