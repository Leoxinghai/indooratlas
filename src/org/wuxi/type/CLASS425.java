// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.type;


// Referenced classes of package org.wuxi.type:
//            CLASS424, CLASS423

public class CLASS425 extends CLASS424
    implements CLASS423
{

    public CLASS425()
    {
        MF_CLASS425_a1250 = "*";
    }

    public String MF_CLASS421_a1244()
    {
        return MF_CLASS425_a1250;
    }

    public void MF_CLASS423_a1246(String s)
    {
        if(s == null)
        {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        } else
        {
            MF_CLASS425_a1250 = s;
            return;
        }
    }

    private String MF_CLASS425_a1250;
}
