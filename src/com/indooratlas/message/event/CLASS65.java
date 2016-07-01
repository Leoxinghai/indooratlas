// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.message.event;

import com.indooratlas.message.event.type.CLASS63;
import java.io.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;

// Referenced classes of package com.indooratlas.message.event:
//            CLASS66, CLASS64

public final class CLASS65
{

    public CLASS65()
    {
        this(null);
    }

    public CLASS65(CLASS64 class64)
    {
        MF_CLASS65_c223 = null;
        if(class64 == null)
        {
            MF_CLASS65_c223 = new CLASS66();
            return;
        } else
        {
            MF_CLASS65_c223 = class64;
            return;
        }
    }

    private String MF_CLASS65_a221(Map map) throws CLASS63
    {
        StringBuilder stringbuilder = new StringBuilder("");
        Iterator iterator = map.keySet().iterator();
        for(;iterator.hasNext();) {
	        String s = (String)iterator.next();
	        if(s.toLowerCase().startsWith("x-ida-"))
	        {
	            if(((List)map.get(s)).size() != 1)
	                throw new CLASS63((new StringBuilder()).append("Invalid header count for: ").append(s).toString());
	            String s1 = (String)((List)map.get(s)).get(0);
	            stringbuilder.append((new StringBuilder()).append(s.toLowerCase().trim()).append(":").append(s1.toLowerCase().trim()).append("\n").toString());
	        }
        }
        return stringbuilder.toString();
    }

    private final String MF_CLASS65_a221(HttpRequestBase httprequestbase, String s, String s1) throws CLASS63
    {
        String s2 = "";
        if((httprequestbase instanceof HttpPost) || (httprequestbase instanceof HttpPut))
            s2 = ((HttpEntityEnclosingRequestBase)httprequestbase).getEntity().getContentType().getValue();
        return MF_CLASS65_a221(httprequestbase.getMethod(), s, s2, MF_CLASS65_a221(httprequestbase), httprequestbase.getURI().getPath(), httprequestbase.getURI().getQuery(), s1);
    }

    public static final Map MF_CLASS65_a221(HttpRequestBase httprequestbase)
    {
        TreeMap treemap = new TreeMap();
        Header aheader[] = httprequestbase.getAllHeaders();
        int i = aheader.length;
        int j = 0;
        while(j < i) 
        {
            Header header = aheader[j];
            if(treemap.containsKey(header.getName().toLowerCase()))
            {
                ((List)treemap.get(header.getName())).add(header.getValue());
            } else
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(header.getValue());
                treemap.put(header.getName().toLowerCase(), arraylist);
            }
            j++;
        }
        return treemap;
    }

    public static final byte[] MF_CLASS65_a221(InputStream inputstream) throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        do
        {
            int i = inputstream.read();
            if(i != -1)
            {
                bytearrayoutputstream.write(i);
            } else
            {
                bytearrayoutputstream.close();
                inputstream.close();
                return bytearrayoutputstream.toByteArray();
            }
        } while(true);
    }

    public static final byte[] MF_CLASS65_a221(HttpEntity httpentity) throws IOException
    {
        if(httpentity != null)
            return MF_CLASS65_a221(httpentity.getContent());
        else
            return new byte[0];
    }

    private String MF_CLASS65_b222(String s, String s1)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder("");
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
        Iterator iterator;
        String s2;
        List list;
        int j;
        int k;
        String s5;
        if(s1 != null && s1.length() > 0) {

	        TreeMap treemap = new TreeMap();
	        String as[] = s1.split("&");
	        int i = 0;
	        while(i < as.length) 
	        {
	            String s3 = as[i];
	            System.out.println("param");
	            String as1[] = s3.split("=");
	            String s4 = as1[0].toLowerCase();
	            if(as1.length > 1)
	                s5 = as1[1];
	            else
	                s5 = "";
	            if(treemap.containsKey(s4))
	            {
	                ((List)treemap.get(s4)).add(s5);
	            } else
	            {
	                ArrayList arraylist = new ArrayList();
	                arraylist.add(s5);
	                treemap.put(s4, arraylist);
	            }
	            i++;
	        }
	        iterator = treemap.keySet().iterator();
	        for(;iterator.hasNext();) {
		        s2 = (String)iterator.next();
		        stringbuilder.append((new StringBuilder()).append(s2).append(":").toString());
		        Collections.sort((List)treemap.get(s2));
		        list = (List)treemap.get(s2);
		        j = 0;
		        
		        for(;;) {
			        if(j != 0)
			            stringbuilder.append(',');
			        k = j + 1;
			        stringbuilder.append((String)list.get(j));
			        if(k < list.size()) {
			            j = k;
			        } else {
			        	break;
			        }
		        }
		        stringbuilder.append("\n");
	        }
        }
        
        return stringbuilder.toString();
    }

    public String MF_CLASS65_a221(String s, String s1)
    {
        return MF_CLASS65_c223.MF_CLASS64_a220(s, s1);
    }

    public final String MF_CLASS65_a221(String s, String s1, String s2, Map map, String s3, String s4, String s5) throws CLASS63
    {
        TreeMap treemap = new TreeMap(map);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append(s.toUpperCase().trim()).append("\n").toString());
        stringbuilder.append((new StringBuilder()).append(s5).append("\n").toString());
        stringbuilder.append((new StringBuilder()).append(s2).append("\n").toString());
        stringbuilder.append((new StringBuilder()).append(s1).append("\n").toString());
        stringbuilder.append(MF_CLASS65_a221(((Map) (treemap))));
        stringbuilder.append(MF_CLASS65_b222(s3, s4));
        return stringbuilder.toString();
    }

    public final String MF_CLASS65_a221(Date date, HttpRequestBase httprequestbase, String s, String s1, String s2) throws IOException, CLASS63
    {
        String s3 = MF_CLASS65_a221.format(date);
        String s4;
        if((httprequestbase instanceof HttpPost) || (httprequestbase instanceof HttpPut))
        {
            byte abyte0[] = MF_CLASS65_a221(((HttpEntityEnclosingRequestBase)httprequestbase).getEntity());
            if(s2 == null || "".equals(s2))
                s2 = MF_CLASS65_a221(abyte0);
        } else
        {
            s2 = "";
        }
        s4 = MF_CLASS65_a221(s1, MF_CLASS65_a221(httprequestbase, s3, s2));
        httprequestbase.addHeader("Authorization", (new StringBuilder()).append("HMAC-256 ").append(s).append(":").append(s4).toString());
        httprequestbase.addHeader("Date", s3);
        httprequestbase.addHeader("Content-SHA256", s2);
        return s4;
    }

    public String MF_CLASS65_a221(byte abyte0[])
    {
        return MF_CLASS65_c223.MF_CLASS64_a220(abyte0);
    }

    private static final SimpleDateFormat MF_CLASS65_a221;
    private static final String MF_CLASS65_b222[] = {
        "x-ida-api-version", "x-ida-device-model", "x-ida-uuid"
    };
    private CLASS64 MF_CLASS65_c223;

    static 
    {
        MF_CLASS65_a221 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        Arrays.sort(MF_CLASS65_b222);
        MF_CLASS65_a221.setTimeZone(new SimpleTimeZone(2, "UTC"));
    }
}
