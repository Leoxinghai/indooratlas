// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.housidea.indoor.collect.util;

import java.io.*;
import java.util.*;
import org.housidea.indoor.collect.CLASS392;

// Referenced classes of package org.housidea.indoor.collect.util:
//            CLASS394

public class CLASS393 extends AbstractCollection
    implements Serializable, Queue, CLASS392
{

    public CLASS393()
    {
        this(32);
    }

    public CLASS393(int i)
    {
        MF_CLASS393_b1150 = 0;
        MF_CLASS393_c1151 = 0;
        MF_CLASS393_d1152 = false;
        if(i <= 0)
        {
            throw new IllegalArgumentException("The size must be greater than 0");
        } else
        {
            MF_CLASS393_a1149 = (Object[])new Object[i];
            MF_CLASS393_e1153 = MF_CLASS393_a1149.length;
            return;
        }
    }

    static int MF_CLASS393_a1149(CLASS393 class393)
    {
        return class393.MF_CLASS393_b1150;
    }

    static int MF_CLASS393_a1149(CLASS393 class393, int i)
    {
        return class393.MF_CLASS393_b1150(i);
    }

    private boolean MF_CLASS393_a1149()
    {
        return size() == MF_CLASS393_e1153;
    }

    static boolean MF_CLASS393_a1149(CLASS393 class393, boolean flag)
    {
        class393.MF_CLASS393_d1152 = flag;
        return flag;
    }

    private int MF_CLASS393_b1150(int i)
    {
        int j = i + 1;
        if(j >= MF_CLASS393_e1153)
            j = 0;
        return j;
    }

    static int MF_CLASS393_b1150(CLASS393 class393, int i)
    {
        return class393.MF_CLASS393_c1151(i);
    }

    static boolean MF_CLASS393_b1150(CLASS393 class393)
    {
        return class393.MF_CLASS393_d1152;
    }

    private int MF_CLASS393_c1151(int i)
    {
        int j = i - 1;
        if(j < 0)
            j = -1 + MF_CLASS393_e1153;
        return j;
    }

    static int MF_CLASS393_c1151(CLASS393 class393)
    {
        return class393.MF_CLASS393_c1151;
    }

    static int MF_CLASS393_c1151(CLASS393 class393, int i)
    {
        class393.MF_CLASS393_c1151 = i;
        return i;
    }

    static Object[] MF_CLASS393_d1152(CLASS393 class393)
    {
        return class393.MF_CLASS393_a1149;
    }

    static int MF_CLASS393_e1153(CLASS393 class393)
    {
        return class393.MF_CLASS393_e1153;
    }

    private void readObject(ObjectInputStream objectinputstream) throws IOException,ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        MF_CLASS393_a1149 = (Object[])new Object[MF_CLASS393_e1153];
        int i = objectinputstream.readInt();
        for(int j = 0; j < i; j++)
            MF_CLASS393_a1149[j] = objectinputstream.readObject();

        MF_CLASS393_b1150 = 0;
        boolean flag;
        if(i == MF_CLASS393_e1153)
            flag = true;
        else
            flag = false;
        MF_CLASS393_d1152 = flag;
        if(MF_CLASS393_d1152)
        {
            MF_CLASS393_c1151 = 0;
            return;
        } else
        {
            MF_CLASS393_c1151 = i;
            return;
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream) throws IOException
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeInt(size());
        for(Iterator iterator1 = iterator(); iterator1.hasNext();) {
        	objectoutputstream.writeObject(iterator1.next());        	
        }
    }

    public Object MF_CLASS393_a1149(int i)
    {
        int j = size();
        if(i < 0 || i >= j)
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = Integer.valueOf(j);
            throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", aobj));
        } else
        {
            int k = (i + MF_CLASS393_b1150) % MF_CLASS393_e1153;
            return MF_CLASS393_a1149[k];
        }
    }

    public boolean add(Object obj)
    {
        if(obj == null)
            throw new NullPointerException("Attempted to add null object to queue");
        if(MF_CLASS393_a1149())
            remove();
        Object aobj[] = MF_CLASS393_a1149;
        int i = MF_CLASS393_c1151;
        MF_CLASS393_c1151 = i + 1;
        aobj[i] = obj;
        if(MF_CLASS393_c1151 >= MF_CLASS393_e1153)
            MF_CLASS393_c1151 = 0;
        if(MF_CLASS393_c1151 == MF_CLASS393_b1150)
            MF_CLASS393_d1152 = true;
        return true;
    }

    public void clear()
    {
        MF_CLASS393_d1152 = false;
        MF_CLASS393_b1150 = 0;
        MF_CLASS393_c1151 = 0;
        Arrays.fill(MF_CLASS393_a1149, null);
    }

    public Object element()
    {
        if(isEmpty())
            throw new NoSuchElementException("queue is empty");
        else
            return peek();
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Iterator iterator()
    {
        return new CLASS394(this);
    }

    public boolean offer(Object obj)
    {
        return add(obj);
    }

    public Object peek()
    {
        if(isEmpty())
            return null;
        else
            return MF_CLASS393_a1149[MF_CLASS393_b1150];
    }

    public Object poll()
    {
        if(isEmpty())
            return null;
        else
            return remove();
    }

    public Object remove()
    {
        if(isEmpty())
            throw new NoSuchElementException("queue is empty");
        Object obj = MF_CLASS393_a1149[MF_CLASS393_b1150];
        if(obj != null)
        {
            Object aobj[] = MF_CLASS393_a1149;
            int i = MF_CLASS393_b1150;
            MF_CLASS393_b1150 = i + 1;
            aobj[i] = null;
            if(MF_CLASS393_b1150 >= MF_CLASS393_e1153)
                MF_CLASS393_b1150 = 0;
            MF_CLASS393_d1152 = false;
        }
        return obj;
    }

    public int size()
    {
        if(MF_CLASS393_c1151 < MF_CLASS393_b1150)
            return (MF_CLASS393_e1153 - MF_CLASS393_b1150) + MF_CLASS393_c1151;
        if(MF_CLASS393_c1151 == MF_CLASS393_b1150)
        {
            if(MF_CLASS393_d1152)
                return MF_CLASS393_e1153;
            else
                return 0;
        } else
        {
            return MF_CLASS393_c1151 - MF_CLASS393_b1150;
        }
    }

    private static final long serialVersionUID = 0x8b1a05bf1d1f455aL;
    private Object MF_CLASS393_a1149[];
    private int MF_CLASS393_b1150;
    private int MF_CLASS393_c1151;
    private boolean MF_CLASS393_d1152;
    private final int MF_CLASS393_e1153;
}
