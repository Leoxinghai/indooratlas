// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.data.Level;
import java.util.Comparator;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS327
    implements Comparator
{

    CLASS327(Sipa sipa)
    {
        MF_CLASS327_a919 = sipa;

    }

    public int MF_CLASS327_a919(Level class105, Level class105_1)
    {
        return class105.MF_CLASS105_b433().compareTo(class105_1.MF_CLASS105_b433());
    }

    public int compare(Object obj, Object obj1)
    {
        return MF_CLASS327_a919((Level)obj, (Level)obj1);
    }

    final Sipa MF_CLASS327_a919;
}
