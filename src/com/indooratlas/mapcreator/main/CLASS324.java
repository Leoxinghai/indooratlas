// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import com.indooratlas.mapcreator.data.Building;
import java.util.Comparator;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa

class CLASS324
    implements Comparator
{

    CLASS324(Sipa sipa)
    {
        MF_CLASS324_a915 = sipa;

    }

    public int MF_CLASS324_a915(Building class99, Building class99_1)
    {
        return class99.MF_CLASS99_b371().compareTo(class99_1.MF_CLASS99_b371());
    }

    public int compare(Object obj, Object obj1)
    {
        return MF_CLASS324_a915((Building)obj, (Building)obj1);
    }

    final Sipa MF_CLASS324_a915;
}
