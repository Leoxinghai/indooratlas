package com.indooratlas.mapcreator.main;


import android.app.ActionBar;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.FloatMath;
import android.view.*;
import android.widget.ImageView;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.*;
import java.text.NumberFormat;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, IndoorMapView, POINT_TYPE, CLASS366, 
//            TouchMode, CLASS320

class MapScreenOnTouchListener
    implements android.view.View.OnTouchListener
{

	MapScreenOnTouchListener(MapScreen mapscreen)
    {
    	mMapScreen = mapscreen;
    }

    private int pointInsideRect(float f, float f1, int i, int j, int k, int l)
    {
        return f <= (float)i || f >= (float)k || f1 <= (float)j || f1 >= (float)l ? 0 : 1;
    }

    private CheckPoint snapToGrid(float af[], CheckPoint class112)
    {
        double d = Math.abs(af[0] - class112.coordX);
        double d1 = Math.abs(af[1] - class112.coordY);
        double d2 = mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("snapToGrid() conv = ").append(d2).toString());
        double d3 = d2 * d;
        double d4 = d2 * d1;
        double d5 = Math.atan2(d1, d);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapToGrid() called: angle = ").append(d5).append(", dx = ").append(d).append(", dy = ").append(d1).toString());
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapToGrid() called: angle = ").append(d5).append(", dx_meter = ").append(d3).append(", dy_meter = ").append(d4).toString());
        CheckPoint class112_1 = new CheckPoint(af[0], af[1]);
        if(d3 < MapScreen.I(mMapScreen))
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.snapToGrid(): snapping X");
            class112_1.coordX = class112.coordX;
        }
        if(d4 < MapScreen.I(mMapScreen))
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.snapToGrid(): snapping Y");
            class112_1.coordY = class112.coordY;
        }
        return class112_1;
    }

    private void MF_CLASS317_a904()
    {
        try {
	    	float f = MapScreen.getIndoorMapView(mMapScreen).getEuclideanDistance(MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint().coordX, MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint().coordY, MapScreen.getEndMeasure(mMapScreen).getLastCheckPoint().coordX, MapScreen.getEndMeasure(mMapScreen).getLastCheckPoint().coordY) * mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio();
	        float f1 = 3.28084F * f;
	        String s = mMapScreen.L.format(f);
	        String s1 = mMapScreen.L.format(f1);
	        mMapScreen.showToastMessage((new StringBuilder()).append(s).append("m (").append(s1).append("ft)").toString(), 0);
	        return;
        } catch(Exception exception) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	        {
	            exception.printStackTrace();
	            return;
	        }
        }
          
    }

    private void MF_CLASS317_a904(PointF pointf, MotionEvent motionevent)
    {
        float f = motionevent.getX(0) + motionevent.getX(1);
        float f1 = motionevent.getY(0) + motionevent.getY(1);
        pointf.set(f / 2.0F, f1 / 2.0F);
    }

    private void dumpEvent(MotionEvent motionevent)
    {
        int i = 0;
        String as[] = {
            "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"
        };
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("dumpEvent(): ");
        int j = motionevent.getAction();
        int k = j & 0xff;
        stringbuilder.append("event ACTION_").append(as[k]);
        if(k == 5 || k == 6)
        {
            stringbuilder.append("(pid ").append(j >> 8);
            stringbuilder.append(")");
        }
        stringbuilder.append("[");
        for(; i < motionevent.getPointerCount(); i++)
        {
            stringbuilder.append("#").append(i);
            stringbuilder.append("(pid ").append(motionevent.getPointerId(i));
            stringbuilder.append(")=").append((int)motionevent.getX(i));
            stringbuilder.append(",").append((int)motionevent.getY(i));
            if(i + 1 < motionevent.getPointerCount())
                stringbuilder.append(";");
        }

        stringbuilder.append("]");
        CLASS167.MF_CLASS167_b635("MapScreen", stringbuilder.toString());
    }

    private void handleAddSecondPoint(MotionEvent motionevent, ImageView imageview, float af[])
    {
        if(!MapScreen.MF_CLASS19_a67(mMapScreen, af))
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "handleAddSecondPoint: isWithin  == false");
            if(!MapScreen.A(mMapScreen))
            {
                MapScreen.MF_CLASS19_e71(mMapScreen, true);
                mMapScreen.showToastMessage(mMapScreen.getString(0x7f080025), 1);
            }
            return;
        }
        CLASS167.MF_CLASS167_b635("MapScreen", "handleAddSecondPoint: isWithin == true ");
        if(!snapEndPointToClosestSegmentPoint(motionevent, imageview, af))
        {
            CheckPoint class112 = snapToGrid(af, MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint());
            try
            {
                MapScreen.getEndMeasure(mMapScreen).setOrReplaceEndPoint(class112);
            }
            catch(Exception exception)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    exception.printStackTrace();
            }
            MapScreen.getIndoorMapView(mMapScreen).setEndPoint(class112.coordX, class112.coordY);
        } else
        {
            MapScreen.getIndoorMapView(mMapScreen).setupSnapAnimation(FIRSTSECOND_POINT.SECOND_POINT);
        }
        MF_CLASS317_a904();
        MapScreen.setMapState(mMapScreen, POINT_TYPE.SECOND_POINT_GIVEN);
    }

    private boolean isAtLeastOneImagePointVisibleOnScreen(int i, int j, Bitmap bitmap, Matrix matrix)
    {
        float af[] = {
            0.0F, 0.0F
        };
        boolean flag = false;
        boolean flag1;
        for(float f = 0.0F; f < (float)bitmap.getWidth() && !flag; flag = flag1)
        {
            flag1 = flag;
            for(float f1 = 0.0F; f1 < (float)bitmap.getHeight() && !flag1; f1 += 25)
            {
                af[0] = f;
                af[1] = f1;
                matrix.mapPoints(af);
                if(pointInsideRect(af[0], af[1], 25, 25, j - 25, i - 25) == 1)
                {
                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.isAtLeastOneImagePointVisibleOnScreen(): FOUND = TRUE, within view: x_coord = ").append(f).append(", y_coord = ").append(f1).toString());
                    flag1 = true;
                }
            }

            f += 25;
        }

        return flag;
    }

    private float moveDistance(MotionEvent motionevent)
    {
        float f = motionevent.getX(0) - motionevent.getX(1);
        float f1 = motionevent.getY(0) - motionevent.getY(1);
        return FloatMath.sqrt(f * f + f1 * f1);
    }

    private CLASS110 checkPointSelected(MotionEvent motionevent, ImageView imageview, float af[])
    {
        CLASS110 class110 = getClosestCurrentSegmentPoint(af);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.checkPointSelected() closestPoint = ").append(class110).toString());
        if(class110 != null)
        {
            float af1[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen), class110.MF_CLASS110_b469.coordX, class110.MF_CLASS110_b469.coordY);
            float f = MapScreen.getIndoorMapView(mMapScreen).getEuclideanDistance(af1[0], af1[1], motionevent.getX(), motionevent.getY());
            float f1 = f * mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.checkPointSelected() event.getX(),getY() = ").append(motionevent.getX()).append(", ").append(motionevent.getY()).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.checkPointSelected() closestPointCurrentImageCoords = ").append(af1[0]).append(", ").append(af1[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.checkPointSelected() original image coords closestPoint = ").append(class110.MF_CLASS110_b469.coordX).append(", ").append(class110.MF_CLASS110_b469.coordY).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.checkPointSelected() original image coords touchPoint = ").append(af[0]).append(", ").append(af[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            if((double)f < MapScreen.F(mMapScreen))
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.checkPointSelected() : snapDistMeter < SELECT_POINT_OR_SEGMENT_PIXEL_DISTANCE_THRESHOLD --> **selecting point**");
                return class110;
            }
            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.checkPointSelected() : snapDistMeter > SELECT_POINT_OR_SEGMENT_PIXEL_DISTANCE_THRESHOLD --> **NOT** selecting point**");
        }
        return null;
    }

    private boolean snapFirstPointToClosestSegmentPoint(MotionEvent motionevent, ImageView imageview, float af[])
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "snapFirstPointToClosestSegmentPoint() started");
        if(!MapScreen.MF_CLASS19_a67(mMapScreen, af))
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "snapFirstPointToClosestSegmentPoint: isWithin  == false");
            if(!MapScreen.A(mMapScreen))
            {
                MapScreen.MF_CLASS19_e71(mMapScreen, true);
                mMapScreen.showToastMessage(mMapScreen.getString(0x7f080025), 1);
            }
            return false;
        }
        CLASS167.MF_CLASS167_b635("MapScreen", "snapFirstPointToClosestSegmentPoint: isWithin == true ");
        float af1[] = MapScreen.getIndoorMapView(mMapScreen).getClosestSegmentPoint(af[0], af[1]);
        boolean flag;
        if(af1 != null)
        {
            float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen), af[0], af[1]);
            float af3[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen), af1[0], af1[1]);
            float f = MapScreen.getIndoorMapView(mMapScreen).getEuclideanDistance(af3[0], af3[1], af2[0], af2[1]);
            float f1 = f * (1.0F / (float)((1.0D / (double)(float)mMapScreen.mBitmapScale) * (double)mMapScreen.mCurrentZoom * (1.0D / (double)mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio())));
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapFirstPointToClosestSegmentPoint() closestPointCurrentImageCoords = ").append(af3[0]).append(", ").append(af3[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            if((double)f1 < MapScreen.G(mMapScreen))
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.snapFirstPointToClosestSegmentPoint() : *snapping* to closest segment start point");
                MapScreen.getEndMeasure(mMapScreen).replaceStartPoint(af1[0], af1[1]);
                MapScreen.getIndoorMapView(mMapScreen).setStartPoint(af1[0], af1[1]);
                flag = true;
            } else
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.snapFirstPointToClosestSegmentPoint() : NOT snapping to closest segment start point");
                MapScreen.getEndMeasure(mMapScreen).replaceStartPoint(af[0], af[1]);
                MapScreen.getIndoorMapView(mMapScreen).setStartPoint(af[0], af[1]);
                flag = false;
            }
        } else
        {
            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.snapFirstPointToClosestSegmentPoint() : NOT snapping to closest segment start point");
            MapScreen.getEndMeasure(mMapScreen).replaceStartPoint(af[0], af[1]);
            MapScreen.getIndoorMapView(mMapScreen).setStartPoint(af[0], af[1]);
            flag = false;
        }
        if(flag)
            MapScreen.getIndoorMapView(mMapScreen).setupSnapAnimation(FIRSTSECOND_POINT.FIRST_POINT);
        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.snapFirstPointToClosestSegmentPoint() : returning true");
        return true;
    }

    private boolean snapEndPointToClosestSegmentPoint(MotionEvent motionevent, ImageView imageview, float af[])
    {
    	try {
    	float af1[] = MapScreen.getIndoorMapView(mMapScreen).getClosestSegmentPoint(af[0], af[1]);
        if(af1 == null) {
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapEndPointToClosestSegmentPoint() : NOT snapping to closest segment start point, mSegment = ").append(MapScreen.getEndMeasure(mMapScreen)).toString());
                try
                {
                    MapScreen.getEndMeasure(mMapScreen).setOrReplaceEndPoint(new CheckPoint(af[0], af[1]));
                }
                catch(Exception exception)
                {
                    if(CLASS113.isExceptionLogged.booleanValue())
                        exception.printStackTrace();
                }
                return false;
        	
        } else {
	        float f1;
	        float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen), af1[0], af1[1]);
	        float af3[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen), af[0], af[1]);
	        float f = MapScreen.getIndoorMapView(mMapScreen).getEuclideanDistance(af2[0], af2[1], af3[0], af3[1]);
	        f1 = f * (1.0F / (float)((1.0D / (double)(float)mMapScreen.mBitmapScale) * (double)mMapScreen.mCurrentZoom * (1.0D / (double)mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio())));
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapEndPointToClosestSegmentPoint() closestPointCurrentImageCoords = ").append(af2[0]).append(", ").append(af2[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
	        if((double)f1 >= MapScreen.G(mMapScreen)) {
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapEndPointToClosestSegmentPoint() : NOT snapping to closest segment start point, mSegment = ").append(MapScreen.getEndMeasure(mMapScreen)).toString());
                try
                {
                    MapScreen.getEndMeasure(mMapScreen).setOrReplaceEndPoint(new CheckPoint(af[0], af[1]));
                }
                catch(Exception exception1)
                {
                    if(CLASS113.isExceptionLogged.booleanValue())
                        exception1.printStackTrace();
                }
	        	
	        } else {
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.snapEndPointToClosestSegmentPoint() : snapping to closest segment start point, mSegment = ").append(MapScreen.getEndMeasure(mMapScreen)).toString());
		        MapScreen.getEndMeasure(mMapScreen).setOrReplaceEndPoint(new CheckPoint(af1[0], af1[1]));
		        MapScreen.getIndoorMapView(mMapScreen).setEndPoint(af1[0], af1[1]);
		        MapScreen.getIndoorMapView(mMapScreen).setupSnapAnimation(FIRSTSECOND_POINT.SECOND_POINT);
	        }
	        return true;
        }
    	} catch(Exception exception2) {
	        if(CLASS113.isExceptionLogged.booleanValue())
	            exception2.printStackTrace();
	        return false;
    	}
    }

    private boolean isValidationPointCloseEnoughToSegmentPoint(MotionEvent motionevent, ImageView imageview, float af[])
    {
        float af1[] = MapScreen.getIndoorMapView(mMapScreen).getClosestSegmentPoint(af[0], af[1]);
        if(af1 != null)
        {
            float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen), af1[0], af1[1]);
            float f = MapScreen.getIndoorMapView(mMapScreen).getEuclideanDistance(af2[0], af2[1], motionevent.getX(), motionevent.getY());
            float f1 = f * (float)mMapScreen.mBitmapScale * mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.isValidationPointCloseEnoughToSegmentPoint() event.getX(),getY() = ").append(motionevent.getX()).append(", ").append(motionevent.getY()).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.isValidationPointCloseEnoughToSegmentPoint() closestPointCurrentImageCoords = ").append(af2[0]).append(", ").append(af2[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.isValidationPointCloseEnoughToSegmentPoint() original image coords closestPoint = ").append(af1[0]).append(", ").append(af1[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.isValidationPointCloseEnoughToSegmentPoint() original image coords touchPoint = ").append(af[0]).append(", ").append(af[1]).append(", snapDist = ").append(f).append(", snapDistMeter = ").append(f1).toString());
            if((double)f1 < MapScreen.H(mMapScreen))
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.isValidationPointCloseEnoughToSegmentPoint() : return true");
                return true;
            }
        }
        return false;
    }

    public CLASS110 getClosestCurrentSegmentPoint(float af[])
    {
        Iterator iterator;
        float f;
        CLASS110 class110;
        CheckPoint class112;
        float af1[];
        float f1;
        CLASS110 class110_1;
        float f2;
        float f3;
        float f4;
        if(mMapScreen.mScreenPointType != POINT_TYPE.TEST_POINTS)
        {
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint() mSegment = ").append(MapScreen.getEndMeasure(mMapScreen).toString()).toString());
            if(MapScreen.getEndMeasure(mMapScreen).mPoints.size() == 1)
            {
                float af4[] = new float[2];
                af4[0] = MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint().coordX;
                af4[1] = MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint().coordY;
                f4 = (float)Math.sqrt((af4[0] - af[0]) * (af4[0] - af[0]) + (af4[1] - af[1]) * (af4[1] - af[1]));
                f3 = 3.402823E+038F;
            } else
            if(MapScreen.getEndMeasure(mMapScreen).mPoints.size() > 1)
            {
                float af2[] = new float[2];
                af2[0] = MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint().coordX;
                af2[1] = MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint().coordY;
                f4 = (float)Math.sqrt((af2[0] - af[0]) * (af2[0] - af[0]) + (af2[1] - af[1]) * (af2[1] - af[1]));
                float af3[] = new float[2];
                af3[0] = MapScreen.getEndMeasure(mMapScreen).getLastCheckPoint().coordX;
                af3[1] = MapScreen.getEndMeasure(mMapScreen).getLastCheckPoint().coordY;
                f3 = (float)Math.sqrt((af3[0] - af[0]) * (af3[0] - af[0]) + (af3[1] - af[1]) * (af3[1] - af[1]));
            } else
            {
                f3 = 3.402823E+038F;
                f4 = 3.402823E+038F;
            }
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint touchPointOriginalImageCoords = ").append(af[0]).append(",").append(af[1]).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint() Calculated distances from start point = ").append(f4).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint() Calculated distances from end point = ").append(f3).toString());
            if(f4 < 3.402823E+038F && f4 < f3)
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "getClosestCurrentSegmentPoint : segment StartPoint selected");
                return new CLASS110(MapScreen.getEndMeasure(mMapScreen), MapScreen.getEndMeasure(mMapScreen).getFirstCheckPoint(), f4, true);
            } else
            {
                CLASS167.MF_CLASS167_b635("MapScreen", "getClosestCurrentSegmentPoint : segment EndPoint selected");
                return new CLASS110(MapScreen.getEndMeasure(mMapScreen), MapScreen.getEndMeasure(mMapScreen).getLastCheckPoint(), f3, false);
            }
        }
        iterator = MapScreen.getStartMeasure(mMapScreen).mPoints.iterator();
        f = 3.402823E+038F;
        class110 = null;
        while(iterator.hasNext()) 
        {
            class112 = (CheckPoint)iterator.next();
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint() mTestSegmentPath = ").append(MapScreen.getStartMeasure(mMapScreen).toString()).toString());
            af1 = new float[2];
            af1[0] = class112.coordX;
            af1[1] = class112.coordY;
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint segmentStartPoint = ").append(af1[0]).append(",").append(af1[1]).toString());
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint touchPointOriginalImageCoords = ").append(af[0]).append(",").append(af[1]).toString());
            f1 = (float)Math.sqrt((af1[0] - af[0]) * (af1[0] - af[0]) + (af1[1] - af[1]) * (af1[1] - af[1]));
            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint() Calculated distances from point = ").append(f1).toString());
            if(f1 < f)
            {
                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("getClosestCurrentSegmentPoint dist1 < dist2 && dist1 < shortestDist : segmentStartPoint = ").append(af1[0]).append(",").append(af1[1]).toString());
                class110_1 = new CLASS110(MapScreen.getStartMeasure(mMapScreen), class112, f1, false);
                f2 = f1;
            } else
            {
                class110_1 = class110;
                f2 = f;
            }
            f = f2;
            class110 = class110_1;
        }
        return class110;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        long l;
        float f;
        float f1;
        float f13;
        float f14;
        
        float f22;
        float f23;
        float f24;
        float f25;
        l = System.currentTimeMillis() - MapScreen.m(mMapScreen);
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called:  time since gesture started, tdiff = ").append(l).toString());
        f = 0.0F;
        f1 = 0.0F;
        MapScreen mapscreen = mMapScreen.mMe;
        ImageView imageview;
        int i;
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called: mTouchMode = ").append(MapScreen.MF_CLASS108_n460(mMapScreen)).append(", mCurrentState == ").append(mMapScreen.mScreenPointType).toString());
        mMapScreen.mGestureDetector.onTouchEvent(motionevent);
        imageview = (ImageView)view;
        dumpEvent(motionevent);
        i = 0xff & motionevent.getAction();
        boolean flag = false;
        switch(i) {
	//        JVM INSTR tableswitch 0 6: default 184
	    //                   0 219
	    //                   1 745
	    //                   2 2298
	    //                   3 184
	    //                   4 184
	    //                   5 525
	    //                   6 745;
	//           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L3
	default:
	case 3:
	case 4:
		break;
	case 0:
	        POINT_TYPE class316;
	        POINT_TYPE class316_1;
	        try {
		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): MotionEvent.ACTION_DOWN");
		        MapScreen.MF_CLASS19_a67(mMapScreen, System.currentTimeMillis());
		        MapScreen.MF_CLASS19_a67(mMapScreen, 0.0F);
		        mMapScreen.MF_CLASS19_d70.set(mMapScreen.matrix);
		        mMapScreen.MF_CLASS22_g77.set(motionevent.getX(), motionevent.getY());
		        CLASS167.MF_CLASS167_b635("MapScreen", "mode=DRAG");
		        MapScreen.MF_CLASS19_a67(mMapScreen, TouchMode.DRAG);
		        MapScreen.MF_CLASS19_b68(mMapScreen, motionevent.getX() + (float)MapScreen.getIndoorMapView(mMapScreen).getScrollX());
		        MapScreen.MF_CLASS24_c88(mMapScreen, motionevent.getY() + (float)MapScreen.getIndoorMapView(mMapScreen).getScrollY());
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_DOWN, mStartX = ").append(new Double(MapScreen.MF_CLASS108_o461(mMapScreen))).toString());
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_DOWN, mStartY = ").append(new Double(MapScreen.MF_CLASS108_p462(mMapScreen))).toString());
		        mMapScreen.MF_CLASS108_o461 = motionevent.getX();
		        mMapScreen.MF_CLASS108_p462 = motionevent.getY();
		        class316 = mMapScreen.mScreenPointType;
		        class316_1 = POINT_TYPE.DEFAULT;
		        flag = false;
		        if(class316 == class316_1) {
			        MapScreen.getIndoorMapView(mMapScreen).getHandler().postDelayed(mMapScreen.mLongClickHandler, 2 * ViewConfiguration.getLongPressTimeout());
			        flag = false;
		        }
	        } catch(Exception exception1) {
		        CLASS167.unhandledexception(exception1, mMapScreen.getApplicationContext());
		        return true;
	        }
	        break;
	case 5:
	        int j1;
	        try {
		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): MotionEvent.ACTION_POINTER_DOWN");
		        MapScreen.getIndoorMapView(mMapScreen).getHandler().removeCallbacks(mMapScreen.mLongClickHandler);
		        mMapScreen.MF_CLASS108_i455 = moveDistance(motionevent);
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("oldDist=").append(mMapScreen.MF_CLASS108_i455).toString());
		        //j1 = mMapScreen.MF_CLASS108_i455 != 15F;
		        j1 = (int)mMapScreen.MF_CLASS108_i455;
		        flag = false;
		        if(j1 > 0) {
			        mMapScreen.MF_CLASS19_d70.set(mMapScreen.matrix);
			        MF_CLASS317_a904(mMapScreen.MF_CLASS159_h579, motionevent);
			        MapScreen.MF_CLASS19_a67(mMapScreen, TouchMode.ZOOM);
			        CLASS167.MF_CLASS167_b635("MapScreen", "mode=ZOOM");
			        mMapScreen.m = mMapScreen.mCurrentZoom;
			        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): MotionEvent.ACTION_POINTER_DOWN: event.getPointerCount() = ").append(motionevent.getPointerCount()).toString());
			        mMapScreen.MF_CLASS108_q463 = motionevent.getX(1);
			        mMapScreen.r = motionevent.getY(1);
			        flag = false;
		        }
	        } catch(Exception exception) {
	        	exception.printStackTrace();
	        }
	        break;
	case 1:
	case 6:
	        CLASS110 class110;
	        float af6[];
	        float af7[];
	        MapScreen.MF_CLASS19_e71(mMapScreen, false);
	        MapScreen.MF_CLASS159_f577(mMapScreen, false);
	        if(MapScreen.MF_CLASS108_q463(mMapScreen) != null && mMapScreen.mScreenPointType == POINT_TYPE.SECOND_POINT_GIVEN)
	            MF_CLASS317_a904();
	        class110 = MapScreen.MF_CLASS108_q463(mMapScreen);
	        MapScreen.MF_CLASS19_a67(mMapScreen, class110);
	        MapScreen.getIndoorMapView(mMapScreen).setSelectedPoint(null);
	        MapScreen.getIndoorMapView(mMapScreen).getHandler().removeCallbacks(mMapScreen.mLongClickHandler);
	        int i1 = motionevent.getActionIndex();
	        af6 = mMapScreen.transformTouchPointCoordsToOriginalImageCoords(imageview, motionevent.getX(i1), motionevent.getY(i1));
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() Touched coordinates: ").append(motionevent.getX()).append(", ").append(motionevent.getY()).toString());
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() Transformed coordinates: ").append(af6[0]).append(", ").append(af6[1]).toString());
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_UP, mode = ").append(MapScreen.MF_CLASS108_n460(mMapScreen)).append(", mIndoorMapView.getSelectedSegment() = ").append(MapScreen.getIndoorMapView(mMapScreen).getSelectedSegment()).toString());
	        af7 = mMapScreen.transformTouchPointCoordsToOriginalImageCoords(MapScreen.getIndoorMapView(mMapScreen), motionevent.getX(), motionevent.getY());
	        float f26 = 3.402823E+038F;
	        boolean flag3;
	        if(MapScreen.getIndoorMapView(mMapScreen).currentSegment != null)
	        {
	            f26 = MapScreen.getIndoorMapView(mMapScreen).getDistanceFromPointToSegmentMiddlePointCurrentImageCoords(MapScreen.getIndoorMapView(mMapScreen).currentSegment, af7);
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): bezier TH dist = ").append(f26).toString());
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called: calling handleLabelCheckPoint");
	        flag3 = MapScreen.r(mMapScreen);
	        if(!MapScreen.s(mMapScreen)) {
	                if(mMapScreen.mScreenPointType != POINT_TYPE.DEFAULT || MapScreen.t(mMapScreen)) {
	        	        if(flag3 || (mMapScreen.mScreenPointType != POINT_TYPE.TEST_POINTS || mMapScreen.N || MapScreen.getStartMeasure(mMapScreen) != null || MapScreen.t(mMapScreen))) { 
	                        if((f26 >= 50F) || (mMapScreen.mScreenPointType != POINT_TYPE.SECOND_POINT_GIVEN || MapScreen.getIndoorMapView(mMapScreen).getSelectedSegment() != null)) {
	                        	
	                            if(MapScreen.getIndoorMapView(mMapScreen).getSelectedSegment() == null) {
	                                if(mMapScreen.mScreenPointType != POINT_TYPE.FIRST_POINT || MapScreen.x(mMapScreen) || MapScreen.t(mMapScreen)) {
	                                        if(mMapScreen.mScreenPointType != POINT_TYPE.FIRST_POINT_GIVEN && mMapScreen.mScreenPointType != POINT_TYPE.SECOND_POINT_GIVEN || MapScreen.x(mMapScreen) || MapScreen.t(mMapScreen)) {
	                                	        if(mMapScreen.mScreenPointType != POINT_TYPE.SECOND_POINT || MapScreen.x(mMapScreen) || MapScreen.t(mMapScreen)) {
	                                	            if(mMapScreen.mScreenPointType == POINT_TYPE.TEST_POINTS && !MapScreen.x(mMapScreen) && !MapScreen.t(mMapScreen)) { 
	                                	    	        boolean flag4;
	                                	    	        boolean flag5;
	                                	    	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called: Test data collection");
	                                	    	        flag4 = MapScreen.MF_CLASS19_a67(mMapScreen, af6);
	                                	    	        flag5 = isValidationPointCloseEnoughToSegmentPoint(motionevent, imageview, af6);
	                                	    	        if(flag4) {
	                                	    		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): test points isWithin  == true");
	                                	    		        if(MapScreen.getStartMeasure(mMapScreen) == null) {
	                                	    			        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called: creating new test path, setting first point");
	                                	    			        MapScreen.setFistMeasure(mMapScreen, new Measurement());
	                                	    			        MapScreen.getStartMeasure(mMapScreen).MF_CLASS108_b448(af6[0], af6[1]);
	                                	    			        MapScreen.getIndoorMapView(mMapScreen).setTestPath(MapScreen.getStartMeasure(mMapScreen));
	                                	    			        if(!CLASS113.isDeviceChecked.booleanValue());
	                                	    			        mMapScreen.invalidateOptionsMenu();
	                                	    		        }
	                                	    		        if(MapScreen.getStartMeasure(mMapScreen) != null) {
	                                	    			        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called: adding point to test path.");
	                                	    			        MapScreen.MF_CLASS19_a67(mMapScreen, checkPointSelected(motionevent, imageview, af6));
	                                	    			        boolean flag6 = false;
	                                	    			        if(class110 != null) {
	                                	    			        	flag6 = class110.MF_CLASS110_a465(MapScreen.MF_CLASS108_q463(mMapScreen));
	                                	    			        }
	                                	    			        if(!flag6) {
	                                	    				        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() mTestSegmentPath != null : calling mIndoorMapView.setSelectedPoint with mSelectedPoint = ").append(MapScreen.MF_CLASS108_q463(mMapScreen)).toString());
	                                	    				        MapScreen.getIndoorMapView(mMapScreen).setSelectedPoint(MapScreen.MF_CLASS108_q463(mMapScreen));
	                                	    			        }
	                                	    			
	                                	    			        if(MapScreen.MF_CLASS108_q463(mMapScreen) != null || class110 != null) {
	                                	    			                mMapScreen.invalidateOptionsMenu();
	                                	    			        } else {
	                                	    				        CheckPoint class112 = snapToGrid(af6, MapScreen.getStartMeasure(mMapScreen).getLastCheckPoint());
	                                	    				        MapScreen.getStartMeasure(mMapScreen).MF_CLASS108_a447(class112.coordX, class112.coordY);
	                                	    				        if(CLASS113.isDeviceChecked.booleanValue() && CLASS113.isDeviceChecked.booleanValue() && mMapScreen.mLabelRoutePoints)
	                                	    				            mMapScreen.showRoutePointLabelDialog();
	                                	    			        }
	                                	    		        }
	                                	    	        }
	                                	    	        
	                                	    	        if(flag4) {
	                                	    	            if(!flag5) {
	                                	    	    	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): test point close enough to map point == false");
	                                	    	    	        if(!MapScreen.B(mMapScreen))
	                                	    	    	        {
	                                	    	    	            MapScreen.MF_CLASS159_f577(mMapScreen, true);
	                                	    	    	            mMapScreen.showToastMessage(mMapScreen.getString(0x7f080026), 1);
	                                	    	    	        }
	                                	    	            }
	                                	    	        } else {
	                                	    		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): test points isWithin  == false");
	                                	    		        if(!MapScreen.A(mMapScreen))
	                                	    		        {
	                                	    		            MapScreen.MF_CLASS19_e71(mMapScreen, true);
	                                	    		            mMapScreen.showToastMessage(mMapScreen.getString(0x7f080025), 1);
	                                	    		        }
	                                	    	        }
	                                	            }
	                                	        	
	                                	        } else {
	                                		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called, mCurrentState == State.SECOND_POINT OR SECOND_POINT_GIVEN");
	                                		        handleAddSecondPoint(motionevent, imageview, af6);
	                                	        }
	                                        	
	                                        } else {
	                                		    CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called, mCurrentState == State.FIRST_POINT_GIVEN or State.SECOND_POINT_GIVEN, selecting?");
	                                		    MapScreen.MF_CLASS19_a67(mMapScreen, checkPointSelected(motionevent, imageview, af6));
	                                		    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, checkPointSelected returned mSelectedPoint = ").append(MapScreen.MF_CLASS108_q463(mMapScreen)).toString());
	                                		    boolean flag7 = false;
	                                		    if(class110 != null) {
	                                		    	flag7 = class110.MF_CLASS110_a465(MapScreen.MF_CLASS108_q463(mMapScreen));
	                                		    } else {
	                                		        if(MapScreen.MF_CLASS108_q463(mMapScreen) == null || flag7) {
	                                		                if(MapScreen.MF_CLASS108_q463(mMapScreen) == null || !flag7) {
	                                		                    if(class110 == null) {
	                                		            	        CLASS167.MF_CLASS167_b635("MapScreen", "=== MapScreen.onTouch() adding second point, because touch was not close enough to select first point ===");
	                                		            	        handleAddSecondPoint(motionevent, imageview, af6);
	                                		                    }
	                                		                } else {
	                                		        	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() setting selected point");
	                                		        	        MapScreen.z(mMapScreen);
	                                		                }
	                                		        } else {
	                                			        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() setting selected point");
	                                			        MapScreen.getIndoorMapView(mMapScreen).setSelectedPoint(MapScreen.MF_CLASS108_q463(mMapScreen));
	                                		        }
	                                		    }
	                                        }
	                                	
	                                } else {
	                        		    CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() called, mCurrentState == State.FIRST_POINT");
	                        		    CLASS167.MF_CLASS167_b635("TESTI", "MapScreen.onTouch() called, mCurrentState == State.FIRST_POINT, currentSegment is set to NULL");
	                        		    MapScreen.getIndoorMapView(mMapScreen).setSegment(null);
	                        		    MapScreen.setEndMeasurement(mMapScreen, new Measurement());
	                        		    if(snapFirstPointToClosestSegmentPoint(motionevent, imageview, af6))
	                        		    {
	                        		        MapScreen.setMapState(mMapScreen, POINT_TYPE.FIRST_POINT_GIVEN);
	                        		        mMapScreen.invalidateOptionsMenu();
	                        		        if(MapScreen.y(mMapScreen))
	                        		            MapScreen.MF_CLASS19_a67(mMapScreen, mMapScreen.getString(0x7f080016));
	                        		    }
	                                }
	                            	
	                            } else {
	                    	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): ACTION_POINTER_UP : mIndoorMapView.getSelectedSegment() != null --> STOPPING BEZIER DRAG!");
	                    	        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(null);
	                    	        MapScreen.w(mMapScreen);
	                            }
	                        	
	
	                        }
	                        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): calling mIndoorMapView.setSelectedSegment(mSegment)");
	                        MapScreen.getIndoorMapView(mMapScreen).setSelectedSegment(MapScreen.getEndMeasure(mMapScreen));
	        	        }
	                }
	                mMapScreen.handleSelectPath();
	        	
	        } else {
	        	CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): mLongClickSegmentSelectionOngoing == true --> skipping other events)");
	        }
	        
	        MapScreen.MF_CLASS22_g77(mMapScreen, false);
	        if(MapScreen.MF_CLASS108_n460(mMapScreen) == TouchMode.NONE)
	            MapScreen.MF_CLASS159_h579(mMapScreen, false);
	        MapScreen.MF_CLASS19_a67(mMapScreen, TouchMode.NONE);
	        CLASS167.MF_CLASS167_b635("MapScreen", "mode=NONE");
	        MapScreen.MF_CLASS108_i455(mMapScreen, false);
	        mMapScreen.MF_CLASS19_e71 = 0.0F;
	        mMapScreen.MF_CLASS159_f577 = 0.0F;
	        mMapScreen.s = 0.0F;
	        mMapScreen.MF_CLASS108_n460 = 1.0F;
	        flag = false;
	        break;
	
	case 2:
	        if(MapScreen.MF_CLASS108_n460(mMapScreen) != TouchMode.DRAG) {
	        	TouchMode class317;
	        	TouchMode class317_1;
	            class317 = MapScreen.MF_CLASS108_n460(mMapScreen);
	            class317_1 = TouchMode.ZOOM;
	            f1 = 0.0F;
	            f = 0.0F;
                float f2;
                float f3;
                float f4;
	            if(class317 == class317_1) {
	                    CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): case MotionEvent.ACTION_MOVE, mode == ZOOM ");
	                    f2 = moveDistance(motionevent);
	                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("newDist=").append(f2).toString());
	                    if(f2 <= 15F) {
	                        f3 = 0.0F;
	                        if(motionevent.getPointerCount() != 2) {
	                            f1 = f3;
	                            f = 0.0F;
	                        } else {
	                	        float f10;
	                	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): pointerCount == 2, event.getHistorySize() = ").append(motionevent.getHistorySize()).toString());
	                	        float f5 = motionevent.getX(0);
	                	        float f6 = motionevent.getY(0);
	                	        float f7 = motionevent.getX(1);
	                	        float f8 = motionevent.getY(1);
	                	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): start_y_finger_1 = ").append(mMapScreen.MF_CLASS108_p462).append(", start_y_finger_2 = ").append(mMapScreen.r).append(", start_x_finger_1 = ").append(mMapScreen.MF_CLASS108_o461).append(", start_x_finger_2 = ").append(mMapScreen.MF_CLASS108_q463).toString());
	                	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): cur_y_finger_1 = ").append(f6).append(", cur_y_finger_2 = ").append(f8).append(", cur_x_finger_1 = ").append(f5).append(", cur_x_finger_2 = ").append(f7).toString());
	                	        float f9 = MathUtils.angleBetween2Lines(mMapScreen.MF_CLASS108_o461, mMapScreen.MF_CLASS108_q463, mMapScreen.MF_CLASS108_p462, mMapScreen.r, f5, f7, f6, f8);
	                	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): got angle: ").append(Math.toDegrees(f9)).toString());
	                	        if(mMapScreen.s == 0.0F)
	                	        {
	                	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): setting start angle: ").append(Math.toDegrees(f9)).toString());
	                	            mMapScreen.s = f9;
	                	        }
	                	        f10 = (float)Math.toDegrees(mMapScreen.s - f9);
	                	        mMapScreen.mCumulativeRotation = f10 + mMapScreen.mCumulativeRotation;
	                	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): got angle diff: ").append(f10).toString());
	                	        float af[] = {
	                	            (f5 + f7) / 2.0F, (f6 + f8) / 2.0F
	                	        };
	                	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): rotating around: ").append(af[0]).append(",").append(af[1]).toString());
	                	        mMapScreen.matrix.postRotate(f10, af[0], af[1]);
	                	        f1 = f3;
	                	        f = f10;
	                        }
	
	                    } else {
	                            mMapScreen.matrix.set(mMapScreen.MF_CLASS19_d70);
	                            f3 = f2 / mMapScreen.MF_CLASS108_i455;
	                            f4 = f3 * mMapScreen.m;
	                            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): tempZoom = ").append(f4).append(", mOldZoom = ").append(mMapScreen.m).append(", scale = ").append(f3).append(", mLastScale = ").append(mMapScreen.MF_CLASS108_n460).toString());
	                            
	                            
	                            if(f4 > mMapScreen.MF_CLASS108_k457 || f4 < mMapScreen.MF_CLASS108_j456) {
	                                mMapScreen.matrix.postScale(mMapScreen.MF_CLASS108_n460, mMapScreen.MF_CLASS108_n460, mMapScreen.MF_CLASS159_h579.x, mMapScreen.MF_CLASS159_h579.y);
	                                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): NO TRUE: tempZoom <= MAX_ZOOM && tempZoom >= MIN_ZOOM --> NOT applying scale = ").append(f3).append(", tempZoom = ").append(f4).append(", MAX_ZOOM = ").append(mMapScreen.MF_CLASS108_k457).append(", MIN_ZOOM = ").append(mMapScreen.MF_CLASS108_j456).toString());
	                            } else {
	                    	        Matrix matrix;
	                    	        Bitmap bitmap;
	                    	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): testing, whether at least one image point visible after applying scale = ").append(f3).toString());
	                    	        matrix = new Matrix(mMapScreen.matrix);
	                    	        matrix.postScale(f3, f3, mMapScreen.MF_CLASS159_h579.x, mMapScreen.MF_CLASS159_h579.y);
	                    	        bitmap = ((BitmapDrawable)MapScreen.getIndoorMapView(mMapScreen).getDrawable()).getBitmap();
	                    	        if(!isAtLeastOneImagePointVisibleOnScreen(MapScreen.getIndoorMapView(mMapScreen).getHeight() - 2 * mMapScreen.getActionBar().getHeight(), MapScreen.getIndoorMapView(mMapScreen).getWidth(), bitmap, matrix)) {
	                                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): ZOOM found == false, zero image points visible, NOT applying scale = ").append(f3).toString());
	                                    mMapScreen.matrix.postScale(mMapScreen.MF_CLASS108_n460, mMapScreen.MF_CLASS108_n460, mMapScreen.MF_CLASS159_h579.x, mMapScreen.MF_CLASS159_h579.y);
	                    	        } else {
	                    		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() ZOOM : applying scale = ").append(f3).toString());
	                    		        mMapScreen.matrix.postScale(f3, f3, mMapScreen.MF_CLASS159_h579.x, mMapScreen.MF_CLASS159_h579.y);
	                    		        mMapScreen.mCurrentZoom = f4;
	                    		        mMapScreen.MF_CLASS108_n460 = f3;
	                    	        }
	                            }
	                            NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
	                            numberformat.setMinimumFractionDigits(1);
	                            numberformat.setMaximumFractionDigits(1);
	                            mMapScreen.showStatusText((new StringBuilder()).append("Zoom: ").append(numberformat.format(mMapScreen.mCurrentZoom)).toString());
	                            MapScreen.MF_CLASS159_h579(mMapScreen, true);
	                            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() NOT calling view.setImageMatrix(matrix) and view.invalidate");
	                            return true;
	                    }
	            }
	        } else {
		        float f11;
		        float f12;
		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): case MotionEvent.ACTION_MOVE, mode == DRAG");
		        f11 = motionevent.getX() - mMapScreen.MF_CLASS22_g77.x;
		        f12 = motionevent.getY() - mMapScreen.MF_CLASS22_g77.y;
		        if(MapScreen.MF_CLASS108_q463(mMapScreen) == null) {
	                if(MapScreen.getIndoorMapView(mMapScreen).getSelectedSegment() == null) {
	                        int j;
	                        int k;
	                        Bitmap bitmap1;
	                        Matrix matrix1;
	                        Rect rect = MapScreen.getIndoorMapView(mMapScreen).getDrawable().getBounds();
	                        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() NOT in Bezier mode: r.left = ").append(rect.left).append(", r.top = ").append(rect.top).append(", r.right = ").append(rect.right).append(", r.bottom = ").append(rect.bottom).toString());
	                        j = MapScreen.getIndoorMapView(mMapScreen).getHeight() - 2 * mMapScreen.getActionBar().getHeight();
	                        k = MapScreen.getIndoorMapView(mMapScreen).getWidth();
	                        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): viewHeight= ").append(j).append(", viewWidth = ").append(k).append(" viewHeight/2= ").append((float)j / 2.0F).append(", viewWidth/2 = ").append((float)k / 2.0F).toString());
	                        bitmap1 = ((BitmapDrawable)MapScreen.getIndoorMapView(mMapScreen).getDrawable()).getBitmap();
	                        matrix1 = new Matrix(mMapScreen.matrix);
	                        matrix1.postTranslate(f11, f12);
	                        if(isAtLeastOneImagePointVisibleOnScreen(j, k, bitmap1, matrix1)) {
	                                f13 = f12;
	                                f14 = f11;
	                        } else {
	                	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): FOUND = FALSE, current view shows right part of the image, setting xdiff = 0 and ydiff = 0");
	                	        f14 = mMapScreen.MF_CLASS19_e71;
	                	        f13 = mMapScreen.MF_CLASS159_f577;
	                        }
	                        mMapScreen.matrix.set(mMapScreen.MF_CLASS19_d70);
	                        mMapScreen.matrix.postTranslate(f14, f13);
	                	
		                } else {
		        	        float af1[];
		        	        float f21;
		        	        try {
		        	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): MotionEvent.ACTION_MOVE: mIndoorMapView.getSelectedSegment() != null --> in Bezier mode!");
		        	        MapScreen.MF_CLASS108_i455(mMapScreen, true);
		        	        af1 = mMapScreen.transformTouchPointCoordsToOriginalImageCoords(imageview, motionevent.getX(), motionevent.getY());
		        	        MapScreen.getIndoorMapView(mMapScreen).currentSegment.mBezier = 1;
		        	        float f18 = (MapScreen.getIndoorMapView(mMapScreen).currentSegment.getFirstCheckPoint().coordX + MapScreen.getIndoorMapView(mMapScreen).currentSegment.getLastCheckPoint().coordX) / 2.0F;
		        	        float f19 = (MapScreen.getIndoorMapView(mMapScreen).currentSegment.getFirstCheckPoint().coordY + MapScreen.getIndoorMapView(mMapScreen).currentSegment.getLastCheckPoint().coordY) / 2.0F;
		        	        float f20 = MapScreen.getIndoorMapView(mMapScreen).getEuclideanDistance(af1[0], af1[1], f18, f19);
		        	        f21 = f20 * mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio();
		        	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): MotionEvent.ACTION_MOVE: mCurrentState == State.SECOND_POINT_GIVEN --> in Bezier mode: curveLen = ").append(f20).append(", curveLenMeter = ").append(f21).append(", lineMidX = ").append(f18).append(", lineMidY = ").append(f19).append(", coords2[0] = ").append(af1[0]).append(", coords2[1] = ").append(af1[1]).toString());
		        	        if(f21 <= 1.0F) {
		        	            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): MotionEvent.ACTION_MOVE: mCurrentState == State.SECOND_POINT_GIVEN --> Bezier to line!");
		        	            MapScreen.getIndoorMapView(mMapScreen).currentSegment.MF_CLASS112_c482();
		        	            MapScreen.getIndoorMapView(mMapScreen).currentSegment.mBezier = 0;
		        	        } else {
		        		        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): MotionEvent.ACTION_MOVE: mCurrentState == State.SECOND_POINT_GIVEN --> line to bezier!");
		        		        MapScreen.getIndoorMapView(mMapScreen).currentSegment.setMiddlePoint(af1[0], af1[1]);
		        	        }
		        	        } catch(Exception exception2) {
				                if(CLASS113.isExceptionLogged.booleanValue()) {
				                	exception2.printStackTrace();
				                }
		        	        }
		        	        f13 = f12;
		        	        f14 = f11;
		                }
		
		        }  else {
		                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): mSelectedPoint != null");
		                float af2[] = mMapScreen.transformTouchPointCoordsToOriginalImageCoords(imageview, mMapScreen.MF_CLASS22_g77.x, mMapScreen.MF_CLASS22_g77.y);
		                float af3[] = mMapScreen.transformTouchPointCoordsToOriginalImageCoords(imageview, motionevent.getX(), motionevent.getY());
		                f22 = af3[0] - af2[0];
		                f23 = af3[1] - af2[1];
		                f24 = f22 + MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS112_d483[0];
		                f25 = f23 + MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS112_d483[1];
		                boolean flag1 = true;
		                boolean flag2;
		                if(mMapScreen.mScreenPointType == POINT_TYPE.TEST_POINTS)
		                    flag1 = isValidationPointCloseEnoughToSegmentPoint(motionevent, imageview, new float[] {
		                        f24, f25
		                    });
		                flag2 = MapScreen.MF_CLASS19_a67(mMapScreen, new float[] {
		                    f24, f25
		                });
		                if(flag2) {
		        	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): mSelectedPoint != null: isWithin == true ");
		        	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch(): mSelectedPoint != null: xMoveDist = ").append(f22).append(", yMoveDist = ").append(f23).toString());
		        	        MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordX = f24;
		        	        MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordY = f25;
		        	        if(!MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_e468) {
		        	                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): mSelectedPoint.startPoint == false --> setting end point");
		        	                MapScreen.getIndoorMapView(mMapScreen).setEndPoint(MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordX, MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordY);
		        	                float af4[] = new float[2];
		        	                af4[0] = MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordX;
		        	                af4[1] = MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordY;
		        	                snapEndPointToClosestSegmentPoint(motionevent, imageview, af4);
		        	        } else {
		        			    CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): mSelectedPoint.startPoint == true --> setting start point");
		        			    MapScreen.getIndoorMapView(mMapScreen).setStartPoint(MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordX, MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordY);
		        			    float af5[] = new float[2];
		        			    af5[0] = MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordX;
		        			    af5[1] = MapScreen.MF_CLASS108_q463(mMapScreen).MF_CLASS110_b469.coordY;
		        			    snapFirstPointToClosestSegmentPoint(motionevent, imageview, af5);
		        	        }
		                }
		                if(flag2) {
		                        if(!flag1) {
		        	                CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): test point close enough to map point == false");
		        	                if(!MapScreen.B(mMapScreen))
		        	                {
		        	                    MapScreen.MF_CLASS159_f577(mMapScreen, true);
		        	                    mMapScreen.showToastMessage(mMapScreen.getString(0x7f080026), 1);
		        	                }
		                        }
		                } else {
		        	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch(): mSelectedPoint != null: isWithin  == false");
		        	        if(!MapScreen.A(mMapScreen))
		        	        {
		        	            MapScreen.MF_CLASS19_e71(mMapScreen, true);
		        	            mMapScreen.showToastMessage(mMapScreen.getString(0x7f080025), 1);
		        	        }
		                }
		                f13 = f12;
		                f14 = f11;
		        }
	            float f15 = motionevent.getX() + (float)MapScreen.getIndoorMapView(mMapScreen).getScrollX();
	            float f16 = motionevent.getY() + (float)MapScreen.getIndoorMapView(mMapScreen).getScrollY();
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_MOVE, x = ").append(new Double(f15)).toString());
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_MOVE, y = ").append(new Double(f16)).toString());
	            float f17 = (float)Math.sqrt(Math.pow(f15 - MapScreen.MF_CLASS108_o461(mMapScreen), 2D) + Math.pow(f16 - MapScreen.MF_CLASS108_p462(mMapScreen), 2D));
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_MOVE, dist = ").append(new Double(f17)).toString());
	            MapScreen.MF_CLASS19_a67(mMapScreen, f17 + MapScreen.C(mMapScreen));
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_MOVE, mCurrentActionDragDist = ").append(MapScreen.C(mMapScreen)).append(", gestureDur = ").append(l).toString());
	            if(MapScreen.C(mMapScreen) > (float)MapScreen.D(mMapScreen) || l > (long)MapScreen.E(mMapScreen))
	            {
	                CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_MOVE, setting mDragged = true, mCurrentActionDragDist = ").append(MapScreen.C(mMapScreen)).append(", gestureDur = ").append(l).append(", FINGER_MOVE_DIST_FILTER_DEVICE_PIX = ").append(MapScreen.D(mMapScreen)).toString());
	                MapScreen.MF_CLASS22_g77(mMapScreen, true);
	                if(MapScreen.C(mMapScreen) > (float)MapScreen.D(mMapScreen))
	                {
	                    CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() called, MotionEvent.ACTION_MOVE, REMOVE long click handler, mCurrentActionDragDist = ").append(MapScreen.C(mMapScreen)).append(", gestureDur = ").append(l).append(", FINGER_MOVE_DIST_FILTER_DEVICE_PIX = ").append(MapScreen.D(mMapScreen)).toString());
	                    MapScreen.getIndoorMapView(mMapScreen).getHandler().removeCallbacks(mMapScreen.mLongClickHandler);
	                }
	            }
	            mMapScreen.MF_CLASS19_e71 = f14;
	            mMapScreen.MF_CLASS159_f577 = f13;
	        }
	        
	        long l1 = SystemClock.elapsedRealtime() - mMapScreen.mLastUIUpdateTimestamp;
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() --> rotate_or_zoom invalidate UI diff = ").append(l1).append(", angle_diff ").append(f).append(", scale = ").append(f1).toString());
	        mMapScreen.mLastUIUpdateTimestamp = SystemClock.elapsedRealtime();
	        flag = true;
	        if((double)f > 2.5D || (double)f1 > 1.1000000000000001D || (double)f1 < 0.90000000000000002D) {
		        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("MapScreen.onTouch() angle_diff ").append(f).append(", scale = ").append(f1).toString());
		        imageview.setImageMatrix(mMapScreen.matrix);
		        MapScreen.w(mMapScreen);
	        }
	        break;
        }
        
        if(flag) {
            CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() NOT calling view.setImageMatrix(matrix) and view.invalidate");
            return false;
        } else {
	        CLASS167.MF_CLASS167_b635("MapScreen", "MapScreen.onTouch() calling view.setImageMatrix(matrix) and view.invalidate");
	        imageview.setImageMatrix(mMapScreen.matrix);
	        imageview.invalidate();
	        return true;
        }
        
    }

    final MapScreen mMapScreen;
}
