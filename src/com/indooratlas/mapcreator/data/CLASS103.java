// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.indooratlas.mapcreator.data;

import java.io.Serializable;

// Referenced classes of package com.indooratlas.mapcreator.data:
//            GraphicsImage, PixelTransform

public class CLASS103
    implements Serializable
{

    public CLASS103(com.indooratlas.communication.cmn.Graphic graphic)
    {
        MF_CLASS103_f418 = "";
        mUrl = "";
        MF_CLASS103_h420 = "";
        mGraphicImage = null;
        MF_CLASS103_j422 = null;
        if(graphic.hasId())
            MF_CLASS103_a414(graphic.getId());
        if(graphic.hasUrl())
            MF_CLASS103_b415(graphic.getUrl());
        if(graphic.hasName())
            MF_CLASS103_c416(graphic.getName());
        if(graphic.hasImage())
            MF_CLASS103_a414(new GraphicsImage(graphic.getImage()));
        if(graphic.hasTransformations())
            MF_CLASS103_a414(new PixelTransform(graphic.getTransformations()));
    }

    public CLASS103 MF_CLASS103_a414(GraphicsImage class104)
    {
        if(class104 == null)
        {
            throw new NullPointerException();
        } else
        {
            MF_CLASS103_d417 = true;
            mGraphicImage = class104;
            return this;
        }
    }

    public CLASS103 MF_CLASS103_a414(PixelTransform class111)
    {
        if(class111 == null)
        {
            throw new NullPointerException();
        } else
        {
            MF_CLASS103_e423 = true;
            MF_CLASS103_j422 = class111;
            return this;
        }
    }

    public CLASS103 MF_CLASS103_a414(String s)
    {
        MF_CLASS103_a414 = true;
        MF_CLASS103_f418 = s;
        return this;
    }

    public String MF_CLASS103_a414()
    {
        return MF_CLASS103_f418;
    }

    public CLASS103 MF_CLASS103_b415(String s)
    {
    	mHasUrl = true;
    	mUrl = s;
        return this;
    }

    public String MF_CLASS103_b415()
    {
        return MF_CLASS103_h420;
    }

    public CLASS103 MF_CLASS103_c416(String s)
    {
        MF_CLASS103_c416 = true;
        MF_CLASS103_h420 = s;
        return this;
    }

    public GraphicsImage getGraphicImage()
    {
        return mGraphicImage;
    }

    public PixelTransform MF_CLASS103_d417()
    {
        return MF_CLASS103_j422;
    }

    private static final long serialVersionUID = 1L;
    private boolean MF_CLASS103_a414;
    private boolean mHasUrl;
    private boolean MF_CLASS103_c416;
    private boolean MF_CLASS103_d417;
    private boolean MF_CLASS103_e423;
    private String MF_CLASS103_f418;
    private String mUrl;
    private String MF_CLASS103_h420;
    private GraphicsImage mGraphicImage;
    private PixelTransform MF_CLASS103_j422;
}
