// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.position;

import android.util.Base64;
import com.indooratlas.message.event.CLASS64;
import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CLASS71
    implements CLASS64
{

    public CLASS71()
    {
    }

    public String MF_CLASS64_a220(String s, String s1)
    {
        String s2;
        try
        {
            byte abyte0[] = s1.trim().getBytes("UTF-8");
            SecretKeySpec secretkeyspec = new SecretKeySpec(s.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretkeyspec);
            s2 = new String(Base64.encode(mac.doFinal(abyte0), 2));
        }
        catch(GeneralSecurityException generalsecurityexception)
        {
        	generalsecurityexception.printStackTrace();
        	throw new IllegalArgumentException();
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
            return null;
        }
        return s2;
    }

    public String MF_CLASS64_a220(byte abyte0[])
    {
        String s;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(abyte0);
            s = new String(Base64.encode(messagedigest.digest(), 2));
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        return s;
    }
}
