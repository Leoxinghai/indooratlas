// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.housidea.indoor.data.Charset;

import java.nio.charset.Charset;
import org.housidea.indoor.data.CLASS391;

public class CLASS390
{

    public static String MF_CLASS390_a1142(byte abyte0[])
    {
        return MF_CLASS390_a1142(abyte0, CLASS391.MF_CLASS391_f1148);
    }

    private static String MF_CLASS390_a1142(byte abyte0[], Charset charset)
    {
        if(abyte0 == null)
            return null;
        else
            return new String(abyte0, charset);
    }
}
