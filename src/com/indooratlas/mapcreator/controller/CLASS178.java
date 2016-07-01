// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.BasicHeader;
import java.io.IOException;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CookieHTTPHandler

class CLASS178 extends HttpEntityWrapper
{

    public CLASS178(CookieHTTPHandler class140, HttpEntity httpentity)
    {
        super(httpentity);
        MF_CLASS178_a652 = class140;
    }

    public Header getContentEncoding()
    {
        return new BasicHeader("Content-Encoding", "gzip");
    }

    public long getContentLength()
    {
        return -1L;
    }

    public boolean isChunked()
    {
        return true;
    }

    public void writeTo(OutputStream outputstream) throws IOException
    {
        if(outputstream == null)
            throw new IllegalArgumentException("Output stream may not be null");
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(outputstream);
        InputStream inputstream = wrappedEntity.getContent();
        byte abyte0[] = new byte[2048];
        do
        {
            int i = inputstream.read(abyte0);
            if(i != -1)
            {
                gzipoutputstream.write(abyte0, 0, i);
            } else
            {
                gzipoutputstream.close();
                inputstream.close();
                return;
            }
        } while(true);
    }

    final CookieHTTPHandler MF_CLASS178_a652;
}
