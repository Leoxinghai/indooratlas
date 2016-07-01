// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xinghai.indoor.util;

import java.io.IOException;

public class OutofSpaceException extends IOException
{

    OutofSpaceException()
    {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    private static final long serialVersionUID = 0x9f95917c52ce6e25L;
}
