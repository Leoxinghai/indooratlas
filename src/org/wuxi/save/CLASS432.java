// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.save;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import org.wuxi.exception.CLASS407;

public class CLASS432
{

    public static String a(ByteBuffer bytebuffer) throws CLASS407
    {
        CharsetDecoder charsetdecoder = Charset.forName("UTF8").newDecoder();
        charsetdecoder.onMalformedInput(a);
        charsetdecoder.onUnmappableCharacter(a);
        String s;
        try
        {
            bytebuffer.mark();
            s = charsetdecoder.decode(bytebuffer).toString();
            bytebuffer.reset();
        }
        catch(CharacterCodingException charactercodingexception)
        {
            throw new CLASS407(1007, charactercodingexception);
        }
        return s;
    }

    public static String a(byte abyte0[], int i, int j)
    {
        String s;
        try
        {
            s = new String(abyte0, i, j, "ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException(unsupportedencodingexception);
        }
        return s;
    }

    public static byte[] a(String s)
    {
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("UTF8");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException(unsupportedencodingexception);
        }
        return abyte0;
    }

    public static byte[] b(String s)
    {
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException(unsupportedencodingexception);
        }
        return abyte0;
    }

    public static CodingErrorAction a;

    static 
    {
        a = CodingErrorAction.REPORT;
    }
}
