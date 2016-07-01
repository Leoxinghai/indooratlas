// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.message.event;

import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.housidea.indoor.data.Charset.CLASS388;

// Referenced classes of package com.indooratlas.message.event:
//            CLASS64

final class CLASS66
    implements CLASS64
{

    CLASS66()
    {
    }

    public String MF_CLASS64_a220(String s, String s1)
    {
        String s2 ="";
        try {
	        byte abyte0[] = s1.trim().getBytes("UTF-8");
	        SecretKeySpec secretkeyspec = new SecretKeySpec(s.getBytes("UTF-8"), "HmacSHA256");
	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(secretkeyspec);
	        s2 = new String(CLASS388.MF_CLASS387_a1120(mac.doFinal(abyte0)));
        } catch(InvalidKeyException invalidkeyexception) {
	        invalidkeyexception.printStackTrace();
        } catch(UnsupportedEncodingException unsupportedencodingexception) {
        	unsupportedencodingexception.printStackTrace();
    	} catch(NoSuchAlgorithmException nosuchalgorithmexception) {
    		nosuchalgorithmexception.printStackTrace();
    	} catch(IllegalStateException illegalstateexception) {
    		illegalstateexception.printStackTrace();
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
            s = new String(CLASS388.MF_CLASS387_a1120(messagedigest.digest()));
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        return s;
    }
}
