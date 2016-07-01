package com.indooratlas.mapcreator.data;


import java.io.Serializable;

//Referenced classes of package com.indooratlas.mapcreator.data:
//         GraphicsImage, PixelTransform

public class MapGraphics
 implements Serializable
{

	public MapGraphics() {
		this.mGraphicImage = new GraphicsImage();
		this.mPixelTransform = new PixelTransform();
	}
	
 public MapGraphics(com.indooratlas.communication.cmn.Graphic graphic)
 {
	 mGraphicsID = "";
     mUrl = "";
     mGraphicsName = "";
     mGraphicImage = null;
     mPixelTransform = null;
     if(graphic.hasId())
    	 setGraphicsID(graphic.getId());
     if(graphic.hasUrl())
    	 setGraphicsUrl(graphic.getUrl());
     if(graphic.hasName())
    	 setGraphicsName(graphic.getName());
     if(graphic.hasImage())
    	 setGraphicsImage(new GraphicsImage(graphic.getImage()));
     if(graphic.hasTransformations())
    	 setPixelTransform(new PixelTransform(graphic.getTransformations()));
 }

 public MapGraphics setGraphicsImage(GraphicsImage class104)
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

 public MapGraphics setPixelTransform(PixelTransform class111)
 {
     if(class111 == null)
     {
         throw new NullPointerException();
     } else
     {
         MF_CLASS103_e423 = true;
         mPixelTransform = class111;
         return this;
     }
 }

 public MapGraphics setGraphicsID(String s)
 {
     MF_CLASS103_a414 = true;
     mGraphicsID = s;
     return this;
 }

 public String getGraphicsID()
 {
     return mGraphicsID;
 }

 public MapGraphics setGraphicsUrl(String s)
 {
 	mHasUrl = true;
 	mUrl = s;
     return this;
 }

 public String getGraphicsName()
 {
     return mGraphicsName;
 }

 public MapGraphics setGraphicsName(String s)
 {
     MF_CLASS103_c416 = true;
     mGraphicsName = s;
     return this;
 }

 public GraphicsImage getGraphicImage()
 {
     return mGraphicImage;
 }

 public PixelTransform getPixelTransform()
 {
     return mPixelTransform;
 }

 private static final long serialVersionUID = 1L;
 private boolean MF_CLASS103_a414;
 private boolean mHasUrl;
 private boolean MF_CLASS103_c416;
 private boolean MF_CLASS103_d417;
 private boolean MF_CLASS103_e423;
 private String mGraphicsID;
 private String mUrl;
 private String mGraphicsName;
 private GraphicsImage mGraphicImage;
 private PixelTransform mPixelTransform;
}
