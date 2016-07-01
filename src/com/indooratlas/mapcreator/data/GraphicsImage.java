package com.indooratlas.mapcreator.data;



import java.io.Serializable;

public class GraphicsImage
 implements Serializable
{
	
	public GraphicsImage() {
		
	}

 public GraphicsImage(com.indooratlas.communication.cmn.GraphicsImage graphicsimage)
 {
 	mImageUrl = "";
     MF_CLASS104_f428 = "";
     mWidth = 0;
     mHeight = 0;
     if(graphicsimage.hasUrl())
     	setImageUrl(graphicsimage.getUrl());
     if(graphicsimage.hasFormat())
    	 setFormat(graphicsimage.getFormat());
     if(graphicsimage.hasWidth())
    	 setWidth(graphicsimage.getWidth());
     if(graphicsimage.hasHeight())
    	 setHeight(graphicsimage.getHeight());
 }

 public GraphicsImage setWidth(int i)
 {
     MF_CLASS104_c426 = true;
     mWidth = i;
     return this;
 }

 public GraphicsImage setImageUrl(String s)
 {
     MF_CLASS104_a424 = true;
     mImageUrl = s;
     return this;
 }

 public String getImageUrl()
 {
     return mImageUrl;
 }

 public int getWidth()
 {
     return mWidth;
 }

 public GraphicsImage setHeight(int i)
 {
     MF_CLASS104_d431 = true;
     mHeight = i;
     return this;
 }

 public GraphicsImage setFormat(String s)
 {
     MF_CLASS104_b425 = true;
     MF_CLASS104_f428 = s;
     return this;
 }

 public int getHeight()
 {
     return mHeight;
 }

 private static final long serialVersionUID = 1L;
 private boolean MF_CLASS104_a424;
 private boolean MF_CLASS104_b425;
 private boolean MF_CLASS104_c426;
 private boolean MF_CLASS104_d431;
 private String mImageUrl;
 private String MF_CLASS104_f428;
 private int mWidth;
 private int mHeight;
}
