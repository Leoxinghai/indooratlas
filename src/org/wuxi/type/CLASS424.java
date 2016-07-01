// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.type;

import java.util.*;

// Referenced classes of package org.wuxi.type:
//            CLASS422

public class CLASS424
    implements CLASS422
{

    public CLASS424()
    {
        MF_CLASS424_b1248 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    }

    public void MF_CLASS422_a1245(String s, String s1)
    {
        MF_CLASS424_b1248.put(s, s1);
    }

    public void MF_CLASS422_a1245(byte abyte0[])
    {
        MF_CLASS424_a1247 = abyte0;
    }

    public String MF_CLASS420_b1242(String s)
    {
        String s1 = (String)MF_CLASS424_b1248.get(s);
        if(s1 == null)
            s1 = "";
        return s1;
    }

    public Iterator MF_CLASS420_b1242()
    {
        return Collections.unmodifiableSet(MF_CLASS424_b1248.keySet()).iterator();
    }

    public boolean MF_CLASS420_c1243(String s)
    {
        return MF_CLASS424_b1248.containsKey(s);
    }

    public byte[] MF_CLASS420_c1243()
    {
        return MF_CLASS424_a1247;
    }

    private byte MF_CLASS424_a1247[];
    private TreeMap MF_CLASS424_b1248;
}
