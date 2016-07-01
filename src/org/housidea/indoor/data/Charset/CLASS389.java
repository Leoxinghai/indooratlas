// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.housidea.indoor.data.Charset;

import java.util.Arrays;

class CLASS389
{

    CLASS389()
    {
    }

    public String toString()
    {
        Object aobj[] = new Object[9];
        aobj[0] = getClass().getSimpleName();
        aobj[1] = Arrays.toString(MF_CLASS389_c1134);
        aobj[2] = Integer.valueOf(MF_CLASS389_g1135);
        aobj[3] = Boolean.valueOf(MF_CLASS389_f1136);
        aobj[4] = Integer.valueOf(MF_CLASS389_a1137);
        aobj[5] = Long.valueOf(MF_CLASS389_b1138);
        aobj[6] = Integer.valueOf(MF_CLASS389_h1139);
        aobj[7] = Integer.valueOf(MF_CLASS389_d1140);
        aobj[8] = Integer.valueOf(MF_CLASS389_e1141);
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", aobj);
    }

    int MF_CLASS389_a1137;
    long MF_CLASS389_b1138;
    byte MF_CLASS389_c1134[];
    int MF_CLASS389_d1140;
    int MF_CLASS389_e1141;
    boolean MF_CLASS389_f1136;
    int MF_CLASS389_g1135;
    int MF_CLASS389_h1139;
}
