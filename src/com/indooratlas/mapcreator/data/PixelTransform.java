package com.indooratlas.mapcreator.data;



import java.io.Serializable;

//Referenced classes of package com.indooratlas.mapcreator.data:
//         MapMatrix

public class PixelTransform
 implements Serializable
{

	 public PixelTransform()
	 {
		 //add by xinghai	
		 mPixelToMeterRatio = 0.8F;
		 
	 }
	 
 public PixelTransform(com.indooratlas.communication.cmn.Transformations transformations)
 {
 	mPixelToMeterRatio = 0.0F;
     MF_CLASS111_d473 = null;
     MF_CLASS111_f474 = null;
     MF_CLASS111_h475 = null;
     mGeoToPixelMatrix = null;
     if(transformations.hasGeoToPixelMatrix())
     	setGeoToPixelMatrix(new MapMatrix(transformations.getGeoToPixelMatrix()));
     if(transformations.hasMeterToPixelMatrix())
     	setMeterToPixelMatrix(new MapMatrix(transformations.getMeterToPixelMatrix()));
     if(transformations.hasPixelToGeoMatrix())
     	setPixelToGeoMatrix(new MapMatrix(transformations.getPixelToGeoMatrix()));
     if(transformations.hasPixelToMeterMatrix())
     	setPixelToMeterMatrix(new MapMatrix(transformations.getPixelToMeterMatrix()));
     if(transformations.hasPixelToMeterRatio())
     	setPixelToMeterRatio(transformations.getPixelToMeterRatio());
 }

 public float getPixelToMeterRatio()
 {
     return mPixelToMeterRatio;
 }

 public PixelTransform setPixelToMeterRatio(float f)
 {
     MF_CLASS111_a470 = true;
     mPixelToMeterRatio = f;
     return this;
 }

 public PixelTransform setPixelToMeterMatrix(MapMatrix class107)
 {
     if(class107 == null)
     {
         throw new NullPointerException();
     } else
     {
     	mHasPixelToMeterMatrix = true;
         MF_CLASS111_d473 = class107;
         return this;
     }
 }

 public PixelTransform setMeterToPixelMatrix(MapMatrix class107)
 {
     if(class107 == null)
     {
         throw new NullPointerException();
     } else
     {
     	mHasMeterToPixelMatrix = true;
         MF_CLASS111_f474 = class107;
         return this;
     }
 }

 public PixelTransform setPixelToGeoMatrix(MapMatrix class107)
 {
     if(class107 == null)
     {
         throw new NullPointerException();
     } else
     {
     	mHasPixelToGeoMatrix = true;
         MF_CLASS111_h475 = class107;
         return this;
     }
 }

 public PixelTransform setGeoToPixelMatrix(MapMatrix class107)
 {
     if(class107 == null)
     {
         throw new NullPointerException();
     } else
     {
     	mHasGeoToPixelMatrix = true;
     	mGeoToPixelMatrix = class107;
         return this;
     }
 }

 private static final long serialVersionUID = 1L;
 private boolean MF_CLASS111_a470;
 private float mPixelToMeterRatio;
 private boolean mHasPixelToMeterMatrix;
 private MapMatrix MF_CLASS111_d473;
 private boolean mHasMeterToPixelMatrix;
 private MapMatrix MF_CLASS111_f474;
 private boolean mHasPixelToGeoMatrix;
 private MapMatrix MF_CLASS111_h475;
 private boolean mHasGeoToPixelMatrix;
 private MapMatrix mGeoToPixelMatrix;
}
