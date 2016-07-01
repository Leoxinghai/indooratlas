// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;

import java.io.IOException;

public class ExceptionManager extends IOException
{

    public ExceptionManager(String s)
    {
        super(s);
    }

    static ExceptionManager InputEndingException()
    {
        return new ExceptionManager("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static ExceptionManager NegativeException()
    {
        return new ExceptionManager("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ExceptionManager MalformedvarintException()
    {
        return new ExceptionManager("CodedInputStream encountered a malformed varint.");
    }

    static ExceptionManager InvalidTagException()
    {
        return new ExceptionManager("Protocol message contained an invalid tag (zero).");
    }

    static ExceptionManager NotMatchException()
    {
        return new ExceptionManager("Protocol message end-group tag did not match expected tag.");
    }

    static ExceptionManager InvalidWireException()
    {
        return new ExceptionManager("Protocol message tag had invalid wire type.");
    }

    static ExceptionManager OverNestingException()
    {
        return new ExceptionManager("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static ExceptionManager OverSizeException()
    {
        return new ExceptionManager("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    private static final long serialVersionUID = 0xe9924688c2f20054L;
}
