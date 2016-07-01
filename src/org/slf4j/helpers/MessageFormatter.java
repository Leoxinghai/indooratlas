// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.slf4j.helpers;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package org.slf4j.helpers:
//            FormattingTuple

public final class MessageFormatter
{

    public MessageFormatter()
    {
    }

    public static final FormattingTuple arrayFormat(String s, Object aobj[])
    {
        int i = 0;
        Throwable throwable = getThrowableCandidate(aobj);
        if(s == null)
            return new FormattingTuple(null, aobj, throwable);
        if(aobj == null)
            return new FormattingTuple(s);
        StringBuffer stringbuffer = new StringBuffer(50 + s.length());
        int j = 0;
        while(i < aobj.length) 
        {
            int k = s.indexOf("{}", j);
            if(k == -1)
                if(j == 0)
                {
                    return new FormattingTuple(s, aobj, throwable);
                } else
                {
                    stringbuffer.append(s.substring(j, s.length()));
                    return new FormattingTuple(stringbuffer.toString(), aobj, throwable);
                }
            if(isEscapedDelimeter(s, k))
            {
                if(!isDoubleEscaped(s, k))
                {
                    i--;
                    stringbuffer.append(s.substring(j, k - 1));
                    stringbuffer.append('{');
                    j = k + 1;
                } else
                {
                    stringbuffer.append(s.substring(j, k - 1));
                    deeplyAppendParameter(stringbuffer, aobj[i], new HashMap());
                    j = k + 2;
                }
            } else
            {
                stringbuffer.append(s.substring(j, k));
                deeplyAppendParameter(stringbuffer, aobj[i], new HashMap());
                j = k + 2;
            }
            i++;
        }
        stringbuffer.append(s.substring(j, s.length()));
        if(i < -1 + aobj.length)
            return new FormattingTuple(stringbuffer.toString(), aobj, throwable);
        else
            return new FormattingTuple(stringbuffer.toString(), aobj, null);
    }

    private static void booleanArrayAppend(StringBuffer stringbuffer, boolean aflag[])
    {
        stringbuffer.append('[');
        int i = aflag.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(aflag[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    private static void byteArrayAppend(StringBuffer stringbuffer, byte abyte0[])
    {
        stringbuffer.append('[');
        int i = abyte0.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(abyte0[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    private static void charArrayAppend(StringBuffer stringbuffer, char ac[])
    {
        stringbuffer.append('[');
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(ac[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    private static void deeplyAppendParameter(StringBuffer stringbuffer, Object obj, Map map)
    {
        if(obj == null)
        {
            stringbuffer.append("null");
            return;
        }
        if(!obj.getClass().isArray())
        {
            safeObjectAppend(stringbuffer, obj);
            return;
        }
        if(obj instanceof boolean[])
        {
            booleanArrayAppend(stringbuffer, (boolean[])(boolean[])obj);
            return;
        }
        if(obj instanceof byte[])
        {
            byteArrayAppend(stringbuffer, (byte[])(byte[])obj);
            return;
        }
        if(obj instanceof char[])
        {
            charArrayAppend(stringbuffer, (char[])(char[])obj);
            return;
        }
        if(obj instanceof short[])
        {
            shortArrayAppend(stringbuffer, (short[])(short[])obj);
            return;
        }
        if(obj instanceof int[])
        {
            intArrayAppend(stringbuffer, (int[])(int[])obj);
            return;
        }
        if(obj instanceof long[])
        {
            longArrayAppend(stringbuffer, (long[])(long[])obj);
            return;
        }
        if(obj instanceof float[])
        {
            floatArrayAppend(stringbuffer, (float[])(float[])obj);
            return;
        }
        if(obj instanceof double[])
        {
            doubleArrayAppend(stringbuffer, (double[])(double[])obj);
            return;
        } else
        {
            objectArrayAppend(stringbuffer, (Object[])(Object[])obj, map);
            return;
        }
    }

    private static void doubleArrayAppend(StringBuffer stringbuffer, double ad[])
    {
        stringbuffer.append('[');
        int i = ad.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(ad[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    private static void floatArrayAppend(StringBuffer stringbuffer, float af[])
    {
        stringbuffer.append('[');
        int i = af.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(af[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    public static final FormattingTuple format(String s, Object obj)
    {
        return arrayFormat(s, new Object[] {
            obj
        });
    }

    public static final FormattingTuple format(String s, Object obj, Object obj1)
    {
        return arrayFormat(s, new Object[] {
            obj, obj1
        });
    }

    static final Throwable getThrowableCandidate(Object aobj[])
    {
        if(aobj == null || aobj.length == 0)
            return null;
        Object obj = aobj[-1 + aobj.length];
        if(obj instanceof Throwable)
            return (Throwable)obj;
        else
            return null;
    }

    private static void intArrayAppend(StringBuffer stringbuffer, int ai[])
    {
        stringbuffer.append('[');
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(ai[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    static final boolean isDoubleEscaped(String s, int i)
    {
        return i >= 2 && s.charAt(i - 2) == '\\';
    }

    static final boolean isEscapedDelimeter(String s, int i)
    {
        while(i == 0 || s.charAt(i - 1) != '\\') 
            return false;
        return true;
    }

    private static void longArrayAppend(StringBuffer stringbuffer, long al[])
    {
        stringbuffer.append('[');
        int i = al.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(al[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    private static void objectArrayAppend(StringBuffer stringbuffer, Object aobj[], Map map)
    {
        stringbuffer.append('[');
        if(!map.containsKey(((Object) (aobj))))
        {
            map.put(((Object) (aobj)), null);
            int i = aobj.length;
            for(int j = 0; j < i; j++)
            {
                deeplyAppendParameter(stringbuffer, aobj[j], map);
                if(j != i - 1)
                    stringbuffer.append(", ");
            }

            map.remove(((Object) (aobj)));
        } else
        {
            stringbuffer.append("...");
        }
        stringbuffer.append(']');
    }

    private static void safeObjectAppend(StringBuffer stringbuffer, Object obj)
    {
        try
        {
            stringbuffer.append(obj.toString());
            return;
        }
        catch(Throwable throwable)
        {
            System.err.println((new StringBuilder()).append("SLF4J: Failed toString() invocation on an object of type [").append(obj.getClass().getName()).append("]").toString());
            throwable.printStackTrace();
            stringbuffer.append("[FAILED toString()]");
            return;
        }
    }

    private static void shortArrayAppend(StringBuffer stringbuffer, short aword0[])
    {
        stringbuffer.append('[');
        int i = aword0.length;
        for(int j = 0; j < i; j++)
        {
            stringbuffer.append(aword0[j]);
            if(j != i - 1)
                stringbuffer.append(", ");
        }

        stringbuffer.append(']');
    }

    static final char DELIM_START = 123;
    static final char DELIM_STOP = 125;
    static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = 92;
}
