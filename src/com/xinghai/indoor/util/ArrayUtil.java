// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;


public final class ArrayUtil
{

    private ArrayUtil(byte abyte0[])
    {
        hashValue = 0;
        backupArray = abyte0;
    }

    public static ArrayUtil createArray(byte abyte0[])
    {
        return createArray(abyte0, 0, abyte0.length);
    }

    public static ArrayUtil createArray(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        return new ArrayUtil(abyte1);
    }

    public int createArray()
    {
        return backupArray.length;
    }

    public byte[] backupArray()
    {
        int i = backupArray.length;
        byte abyte0[] = new byte[i];
        System.arraycopy(backupArray, 0, abyte0, 0, i);
        return abyte0;
    }

    public boolean equals(Object obj)
    {
        if(obj != this)
        {
            if(!(obj instanceof ArrayUtil))
                return false;
            ArrayUtil arrayutil = (ArrayUtil)obj;
            int i = backupArray.length;
            if(i != arrayutil.backupArray.length)
                return false;
            byte abyte0[] = backupArray;
            byte abyte1[] = arrayutil.backupArray;
            int j = 0;
            while(j < i) 
            {
                if(abyte0[j] != abyte1[j])
                    return false;
                j++;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i = hashValue;
        if(i != 0) {
            return i;
        }

        byte abyte0[];
        int j;
        int k;
        abyte0 = backupArray;
        j = backupArray.length;
        k = 0;
        i = j;

        for(;k < j;) {
            int l = i * 31 + abyte0[k];
            k++;
            i = l;
        }

        if(i == 0)
            i = 1;
        hashValue = i;
        return i;
    }

    public static final ArrayUtil createArray = new ArrayUtil(new byte[0]);
    private final byte backupArray[];
    private int hashValue;

}
