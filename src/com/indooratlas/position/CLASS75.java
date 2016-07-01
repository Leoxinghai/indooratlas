// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.position;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.indooratlas.cursor.list.CLASS22;
import com.indooratlas.task.CLASS46;
import com.indooratlas.task.RemoteImplementation;
import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.indooratlas.position:
//            CLASS74

public class CLASS75
{

    public static int lookupHost(String s)
    {
        InetAddress inetaddress;
        byte abyte0[];
        try
        {
            inetaddress = InetAddress.getByName(s);
            MF_CLASS75_b260("Util", (new StringBuilder()).append("lookupHost returned : ").append(inetaddress).toString());
        }
        catch(UnknownHostException unknownhostexception)
        {
            return -1;
        }
        abyte0 = inetaddress.getAddress();
        return (0xff & abyte0[3]) << 24 | (0xff & abyte0[2]) << 16 | (0xff & abyte0[1]) << 8 | 0xff & abyte0[0];
    }

    public static String formatDouble(double d)
    {
        return MF_CLASS75_b260.format(d);
    }

    public static String MF_CLASS75_a259(Exception exception)
    {
        StringWriter stringwriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString();
    }

    public static String MF_CLASS75_a259(Date date)
    {
        return MF_CLASS75_c261.format(date);
    }

    private static String MF_CLASS75_a259(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = abyte0.length;
        for(int j = 0; j < i; j++)
            stringbuffer.append(Integer.toString(256 + (0xff & abyte0[j]), 16).substring(1));

        return stringbuffer.toString();
    }

    public static String MF_CLASS75_a259(double ad[])
    {
        if(ad == null)
            return "null";
        StringBuilder stringbuilder = new StringBuilder();
        String s = "";
        stringbuilder.append("[");
        int i = ad.length;
        for(int j = 0; j < i; j++)
        {
            double d = ad[j];
            stringbuilder.append(s);
            stringbuilder.append(MF_CLASS75_b260.format(d));
            s = " ";
        }

        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public static List removeDuplicateTimestamps(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        long l = -1L;
        while(iterator.hasNext()) 
        {
            CLASS22 class22 = (CLASS22)iterator.next();
            long l1;
            if(class22.timeStamp > l)
            {
                arraylist.add(class22);
                l1 = class22.timeStamp;
            } else
            {
                MF_CLASS75_b260("Util", "removeDuplicateTimestamps : removing duplicate! **");
                l1 = l;
            }
            l = l1;
        }
        return arraylist;
    }

    public static void MF_CLASS75_a259(int i, String s, Class class1, String s1)
    {
    }

    public static void MF_CLASS75_a259(String s, String s1)
    {
        if(MF_CLASS75_a259 == null)
        {
            MF_CLASS75_a259 = new CLASS74();
            MF_CLASS75_a259.start();
        }
        MF_CLASS75_a259.MF_CLASS74_a256(s, s1);
    }

    public static void MF_CLASS75_a259(String s, List list)
    {
    }

    public static boolean checkScanModeOnly(Context context)
    {
        if(android.os.Build.VERSION.SDK_INT >= 18)
        {
            MF_CLASS75_b260("Util", " checkScanModeOnly(): NEWER THAN ANDROID 4.3");
            return ((WifiManager)context.getSystemService("wifi")).isScanAlwaysAvailable();
        } else
        {
            MF_CLASS75_b260("Util", " checkScanModeOnly(): OLDER THAN ANDROID 4.3");
            return false;
        }
    }

    public static CLASS46 getNetworkStatus(Context context)
    {
        WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        boolean flag;
        NetworkInfo networkinfo;
        NetworkInfo networkinfo1;
        NetworkInfo networkinfo2;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        CLASS46 class46;
        if(wifimanager != null)
            flag = wifimanager.isWifiEnabled();
        else
            flag = false;
        networkinfo = connectivitymanager.getNetworkInfo(1);
        networkinfo1 = connectivitymanager.getNetworkInfo(0);
        networkinfo2 = connectivitymanager.getNetworkInfo(5);
        MF_CLASS75_b260("Util", (new StringBuilder()).append("getNetworkStatus : mobile = ").append(networkinfo1).toString());
        if(networkinfo1 != null)
            MF_CLASS75_b260("Util", (new StringBuilder()).append("getNetworkStatus : mobile detailed state = ").append(networkinfo1.getDetailedState()).toString());
        MF_CLASS75_b260("Util", (new StringBuilder()).append("getNetworkStatus : mobile hipri = ").append(networkinfo1).toString());
        if(networkinfo2 != null)
            MF_CLASS75_b260("Util", (new StringBuilder()).append("getNetworkStatus : mobile hipri detailed state = ").append(networkinfo2.getDetailedState()).toString());
        flag1 = MF_CLASS75_c261(context);
        if(networkinfo1 != null)
        {
            flag2 = networkinfo1.isConnected();
            flag3 = networkinfo1.isAvailable();
        } else
        {
            flag2 = false;
            flag3 = false;
        }
        if(networkinfo2 != null)
        {
            flag4 = networkinfo2.isConnected();
            flag5 = networkinfo2.isAvailable();
        } else
        {
            flag4 = false;
            flag5 = false;
        }
        flag6 = false;
        if(networkinfo != null)
            flag6 = networkinfo.isConnected();
        class46 = new CLASS46(flag2, flag3, flag4, flag5, flag, flag6, flag1, networkinfo, networkinfo1, networkinfo2);
        MF_CLASS75_a259(4, "NETWORK_INFO", RemoteImplementation.class, (new StringBuilder()).append("getNetworkStatus : ").append(class46.toString()).toString());
        MF_CLASS75_b260("Util", (new StringBuilder()).append("getNetworkStatus : nsw.toString()  = ").append(class46.toString()).toString());
        return class46;
    }

    public static String MF_CLASS75_b260(String s)
    {
        int i = s.indexOf("://");
        if(i > 0)
            s = s.substring(i + 3);
        int j = s.indexOf(':');
        if(j >= 0)
            s = s.substring(0, j);
        int k = s.indexOf('/');
        if(k >= 0)
            s = s.substring(0, k);
        int l = s.indexOf('?');
        if(l >= 0)
            s = s.substring(0, l);
        return s;
    }

    public static void MF_CLASS75_b260(String s, String s1)
    {
    }

    public static String createIDAUID(String s, String s1)
    {
        String s2 = (new StringBuilder()).append(s).append("_").append(s1).toString();
        String s3 = MF_CLASS75_a259(MF_CLASS75_c261(s2));
        MF_CLASS75_b260("Util", (new StringBuilder()).append("createIDAUID: input: ").append(s2).toString());
        MF_CLASS75_b260("Util", (new StringBuilder()).append("createIDAUID: hex-encoded UID: ").append(s3).toString());
        MF_CLASS75_b260("Util", (new StringBuilder()).append("createIDAUID: hex-encoded UID.length: ").append(s3.length()).toString());
        return s3;
    }

    public static boolean MF_CLASS75_c261(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        boolean flag1;
        boolean flag ;
        try {
	        Method method = Class.forName(connectivitymanager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
	        method.setAccessible(true);
	        flag1 = ((Boolean)method.invoke(connectivitymanager, new Object[0])).booleanValue();
	        flag = flag1;
        } catch(Exception exception) {
	        exception.printStackTrace();
	        flag = false;
        }
        MF_CLASS75_b260("Util", (new StringBuilder()).append("isMobileDataEnabled : returning  mobileDataEnabled = ").append(flag).toString());
        return flag;
    }

    private static byte[] MF_CLASS75_c261(String s)
    {
        byte abyte0[];
        try {
	        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
	        messagedigest.reset();
	        messagedigest.update(s.getBytes("UTF-8"));
	        abyte0 = messagedigest.digest();
	        return abyte0;
        } catch(NoSuchAlgorithmException nosuchalgorithmexception) {
        	nosuchalgorithmexception.printStackTrace();
        } catch(UnsupportedEncodingException eex) {
        	eex.printStackTrace();
        }
        return null;
    }

    private static CLASS74 MF_CLASS75_a259 = null;
    private static NumberFormat MF_CLASS75_b260;
    private static SimpleDateFormat MF_CLASS75_c261 = null;

    static 
    {
        MF_CLASS75_b260 = null;
        MF_CLASS75_b260 = NumberFormat.getInstance(Locale.US);
        MF_CLASS75_b260.setGroupingUsed(false);
        MF_CLASS75_b260.setMinimumFractionDigits(3);
        MF_CLASS75_b260.setMaximumFractionDigits(3);
        MF_CLASS75_c261 = new SimpleDateFormat("MM-dd-yyyy, HH:mm:ss");
    }
}
