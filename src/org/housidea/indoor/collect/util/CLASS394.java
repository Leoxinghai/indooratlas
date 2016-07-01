// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package org.housidea.indoor.collect.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package org.housidea.indoor.collect.util:
//            CLASS393

class CLASS394
    implements Iterator
{

    CLASS394(CLASS393 class393)
    {
        MF_CLASS394_a1154 = class393;

        MF_CLASS394_b1155 = CLASS393.MF_CLASS393_a1149(MF_CLASS394_a1154);
        MF_CLASS394_c1156 = -1;
        MF_CLASS394_d1157 = CLASS393.MF_CLASS393_b1150(MF_CLASS394_a1154);
    }

    public boolean hasNext()
    {
        return MF_CLASS394_d1157 || MF_CLASS394_b1155 != CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154);
    }

    public Object next()
    {
        if(!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            MF_CLASS394_d1157 = false;
            MF_CLASS394_c1156 = MF_CLASS394_b1155;
            MF_CLASS394_b1155 = CLASS393.MF_CLASS393_a1149(MF_CLASS394_a1154, MF_CLASS394_b1155);
            return CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154)[MF_CLASS394_c1156];
        }
    }

    public void remove()
    {
        if(MF_CLASS394_c1156 == -1)
            throw new IllegalStateException();
        if(MF_CLASS394_c1156 == CLASS393.MF_CLASS393_a1149(MF_CLASS394_a1154))
        {
            MF_CLASS394_a1154.remove();
            MF_CLASS394_c1156 = -1;
            return;
        }
        int i = 1 + MF_CLASS394_c1156;
        if(CLASS393.MF_CLASS393_a1149(MF_CLASS394_a1154) < MF_CLASS394_c1156 && i < CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154))
            System.arraycopy(((Object) (CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154))), i, ((Object) (CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154))), MF_CLASS394_c1156, CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154) - i);
        else
            while(i != CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154))
                if(i >= CLASS393.MF_CLASS393_e1153(MF_CLASS394_a1154))
                {
                    CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154)[i - 1] = CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154)[0];
                    i = 0;
                } else
                {
                    CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154)[CLASS393.MF_CLASS393_b1150(MF_CLASS394_a1154, i)] = CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154)[i];
                    i = CLASS393.MF_CLASS393_a1149(MF_CLASS394_a1154, i);
                }
        MF_CLASS394_c1156 = -1;
        CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154, CLASS393.MF_CLASS393_b1150(MF_CLASS394_a1154, CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154)));
        CLASS393.MF_CLASS393_d1152(MF_CLASS394_a1154)[CLASS393.MF_CLASS393_c1151(MF_CLASS394_a1154)] = null;
        CLASS393.MF_CLASS393_a1149(MF_CLASS394_a1154, false);
        MF_CLASS394_b1155 = CLASS393.MF_CLASS393_b1150(MF_CLASS394_a1154, MF_CLASS394_b1155);
    }

    final CLASS393 MF_CLASS394_a1154;
    private int MF_CLASS394_b1155;
    private int MF_CLASS394_c1156;
    private boolean MF_CLASS394_d1157;
}
