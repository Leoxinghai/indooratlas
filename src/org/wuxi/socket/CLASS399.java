// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.socket;


public enum CLASS399
{
    MF_CLASS399_a1168("MATCHED", 0),
    MF_CLASS399_b1169("NOT_MATCHED", 1);
    
    private String sType;
    private int iType;
    
    private CLASS399(String s, int i)
    {
        sType = s;
        iType = i;
    }

    private static final CLASS399 MF_CLASS399_c1170[];

    static 
    {
        CLASS399 aclass399[] = new CLASS399[2];
        aclass399[0] = MF_CLASS399_a1168;
        aclass399[1] = MF_CLASS399_b1169;
        MF_CLASS399_c1170 = aclass399;
    }
}
