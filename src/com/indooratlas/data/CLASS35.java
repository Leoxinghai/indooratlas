// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.data;


// Referenced classes of package com.indooratlas.data:
//            CLASS36, CLASS37

public class CLASS35
{

    public static CLASS36 MF_CLASS37_a144(long al[], double ad[])
    {
        CLASS36 class36 = new CLASS36();
        class36.MF_CLASS36_a142 = al[0];
        class36.b = MF_CLASS37_a144(al);
        class36.MF_CLASS36_c143 = ad[0];
        class36.d = MF_CLASS37_a144(ad);
        return class36;
    }

    public static CLASS37 MF_CLASS37_a144(long al[], double ad[], double ad1[], double ad2[])
    {
        CLASS37 class37 = new CLASS37();
        class37.MF_CLASS37_a144 = al[0];
        class37.b = MF_CLASS37_a144(al);
        double ad3[] = new double[3];
        ad3[0] = ad[0];
        ad3[1] = ad1[0];
        ad3[2] = ad2[0];
        class37.MF_CLASS37_c145 = ad3;
        class37.d = MF_CLASS37_a144(ad);
        class37.e = MF_CLASS37_a144(ad1);
        class37.f = MF_CLASS37_a144(ad2);
        return class37;
    }

    public static int[] MF_CLASS37_a144(double ad[])
    {
        int ai[] = new int[-1 + ad.length];
        for(int i = 0; i < -1 + ad.length; i++)
            ai[i] = (int)Math.round(1000D * (ad[i + 1] - ad[i]));

        return ai;
    }

    public static int[] MF_CLASS37_a144(long al[])
    {
        double ad[] = new double[al.length];
        int ai[] = new int[-1 + al.length];
        int i = 0;
        int k;
        int j = al.length;
        k = 0;
        for(;i < j;) {
            ad[i] = (double)al[i] / 1000000D;
            i++;
        }
        for(; k < -1 + al.length; k++)
            ai[k] = (int)Math.round(ad[k + 1] - ad[k]);

        return ai;
    }
}
