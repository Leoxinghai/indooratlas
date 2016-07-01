// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.Context;
import android.graphics.*;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.mapcreator.data.*;
import com.indooratlas.position.CLASS69;
import com.indooratlas.position.CLASS72;
import com.indooratlas.task.CLASS41;
import java.text.DecimalFormat;
import java.util.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS366, MapScreen, CLASS359, CLASS361,
//            CLASS365, CLASS367, CLASS316, CLASS317,
//            CLASS363

public class IndoorMapView extends ImageView
{

    public IndoorMapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        MF_CLASS113_a486 = null;
        mTimer0 = null;
        mCurrentStartX = 0.0F;
        mCurrentStartY = 0.0F;
        mCurrentEndY = 0.0F;
        mCurrentEndX = 0.0F;
        ad = false;
        ae = false;
        currentSegment = null;
        af = false;
        ag = null;
        ah = null;
        MF_CLASS113_d489 = null;
        e = null;
        ai = false;
        aj = null;
        ak = null;
        al = null;
        am = 0.7F;
        an = null;
        mMapScreen = null;
        MF_CLASS112_f485 = 0.0F;
        g = 0.0F;
        h = -1F;
        i = -1F;
        j = 0.0F;
        MF_CLASS108_k457 = 0.0F;
        MF_CLASS108_l458 = 0.0F;
        m = 0.0F;
        MF_CLASS108_n460 = 0.0F;
        MF_CLASS108_o461 = 0;
        MF_CLASS108_p462 = 0.0F;
        q = 0.0F;
        MF_CLASS108_r464 = 0.0F;
        s = 0.0F;
        t = 0.0F;
        u = 0.0F;
        v = 0.0F;
        w = 0.0F;
        x = 0.0F;
        y = false;
        ao = 0L;
        ap = 0L;
        B = false;
        C = new float[2];
        D = 0.01F;
        E = null;
        mImgBoll = null;
        aq = 0;
        mFSPOINTType = FIRSTSECOND_POINT.NONE;
        H = 0L;
        ar = 0L;
        as = 0.0F;
        I = new DecimalFormat("##.##");
        at = new CLASS69(10);
        au = 0L;
        av = new ArrayList();
        E = this;
        J = new Paint();
        J.setDither(true);
        J.setColor(0xff000000);
        J.setStyle(android.graphics.Paint.Style.STROKE);
        J.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        J.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        float f = 8F * MapScreen.UiPixelScale;
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView: selectedWidth = ").append(f).append(", MapScreen.UiPixelScale = ").append(MapScreen.UiPixelScale).append(", SELECTED_SEGMENT_WIDTH_DIP = ").append(8F).toString());
        J.setStrokeWidth(f);
        K = new Paint();
        K.setDither(true);
        K.setColor(0xffff0000);
        K.setStyle(android.graphics.Paint.Style.STROKE);
        K.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        K.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        K.setStrokeWidth(f);
        L = new Paint();
        L.setDither(true);
        L.setColor(0xffff0000);
        L.setStyle(android.graphics.Paint.Style.STROKE);
        L.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        L.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        float f1 = 3F * MapScreen.UiPixelScale;
        L.setStrokeWidth(f1);
        M = new Paint();
        M.setDither(true);
        M.setColor(-256);
        M.setStyle(android.graphics.Paint.Style.STROKE);
        M.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        M.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        M.setStrokeWidth(f);
        N = new Paint();
        N.setDither(true);
        N.setColor(0xff00ff00);
        N.setStyle(android.graphics.Paint.Style.STROKE);
        N.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        N.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        N.setStrokeWidth(f);
        O = new Paint();
        O.setStyle(android.graphics.Paint.Style.STROKE);
        O.setStyle(android.graphics.Paint.Style.STROKE);
        O.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        O.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        float f2 = 5F * MapScreen.UiPixelScale;
        O.setStrokeWidth(f2);
        P = new Paint();
        P.setStyle(android.graphics.Paint.Style.STROKE);
        P.setStyle(android.graphics.Paint.Style.STROKE);
        P.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        P.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        P.setStrokeWidth(f2);
        P.setColor(0xff000000);
        P.setAlpha(150);
        Q = new Paint();
        Q.setStyle(android.graphics.Paint.Style.STROKE);
        Q.setPathEffect(new DashPathEffect(new float[] {
            10F, 20F
        }, 0.0F));
        Q.setStyle(android.graphics.Paint.Style.STROKE);
        Q.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        Q.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        Q.setStrokeWidth(f2);
        R = new Paint();
        R.setStyle(android.graphics.Paint.Style.STROKE);
        R.setPathEffect(new DashPathEffect(new float[] {
            10F, 20F
        }, 0.0F));
        R.setStyle(android.graphics.Paint.Style.STROKE);
        R.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        R.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        R.setStrokeWidth(f2);
        R.setColor(0xff000000);
        R.setAlpha(150);
        T = new Paint();
        T.setColor(0xffff0000);
        T.setStyle(android.graphics.Paint.Style.STROKE);
        T.setStrokeWidth(f1);
        U = new Paint();
        U.setColor(Color.rgb(0, 210, 241));
        U.setAlpha(75);
        V = new Paint();
        V.setColor(Color.rgb(22, 126, 145));
        V.setStyle(android.graphics.Paint.Style.STROKE);
        W = new Paint();
        W.setColor(Color.rgb(0, 210, 241));
        W.setStyle(android.graphics.Paint.Style.FILL);
        W.setAlpha(200);
        Z = new Paint();
        Z.setColor(0xff000000);
        Z.setAlpha(150);
        Z.setStyle(android.graphics.Paint.Style.FILL);
        float f3 = 3F * MapScreen.UiPixelScale;
        Z.setStrokeWidth(f3);
        S = new Paint();
        S.setColor(0xff000000);
        S.setAlpha(150);
        S.setStyle(android.graphics.Paint.Style.STROKE);
        float f4 = 3F * MapScreen.UiPixelScale;
        S.setStrokeWidth(f4);
        aa = new Paint();
        aa.setColor(-65281);
        aa.setStyle(android.graphics.Paint.Style.FILL);
        aa.setAlpha(200);
        ab = new Paint();
        float f5 = 10F * MapScreen.UiPixelScale;
        ab.setTextSize((int)f5);
        ab.setColor(Color.rgb(10, 10, 10));
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView: textSize = ").append(f5).append(", MapScreen.UiPixelScale = ").append(MapScreen.UiPixelScale).toString());
        ac = new Paint();
        ac.setColor(-1);
        ac.setStyle(android.graphics.Paint.Style.FILL);
        ac.setAlpha(200);
    }

    private Path plotSegment(Measurement measurement)
    {
        Path path = new Path();
        Object aobj[] = measurement.mPoints.toArray();
        long l = SystemClock.elapsedRealtime();
        long l1;
        if(measurement.mBezier == 1 && aobj.length >= 2)
        {
        	CheckPoint class112_3 = (CheckPoint)aobj[0];
            CheckPoint class112_4 = (CheckPoint)aobj[1];
            CheckPoint class112_5 = (CheckPoint)aobj[2];
            float af4[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_3.coordX, class112_3.coordY);
            path.moveTo(af4[0], af4[1]);
            float af5[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_5.coordX, class112_5.coordY);
            float af6[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_4.coordX, class112_4.coordY);
            path.quadTo(af6[0], af6[1], af5[0], af5[1]);
        } else
        if(aobj.length >= 2)
        {
            CLASS167.MF_CLASS167_b635("IndoorMapView", "IndoorMapView.plotSegment(): s.mBezier == 0");
            CheckPoint class112 = (CheckPoint)aobj[0];
            CheckPoint class112_1 = (CheckPoint)aobj[-1 + aobj.length];
            float af1[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112.coordX, class112.coordY);
            path.moveTo(af1[0], af1[1]);
            for(int k = 0; k < measurement.mPoints.size(); k++)
            {
                CheckPoint class112_2 = (CheckPoint)measurement.mPoints.get(k);
                float af3[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_2.coordX, class112_2.coordY);
                path.lineTo(af3[0], af3[1]);
            }

            float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_1.coordX, class112_1.coordY);
            path.lineTo(af2[0], af2[1]);
        } else
        {
            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.plotSegment(): not plotting, not enough points failed for measurement : ").append(measurement).toString());
        }
        l1 = SystemClock.elapsedRealtime() - l;
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.plotSegment(): took = ").append(l1).toString());
        return path;
    }

    private Measurement getMeasurementByID(long l)
    {
        for(Iterator iterator = ah.iterator(); iterator.hasNext();)
        {
            Measurement class108 = (Measurement)iterator.next();
            if(class108.mMeasurementID == l)
                return class108;
        }

        return null;
    }

    private void MF_CLASS113_a486()
    {
        int k = (new Double(MF_CLASS112_f485)).intValue();
        int l = (new Double(g)).intValue();
        C[0] = 0.9F * C[0] + 0.1F * (float)k;
        C[1] = 0.9F * C[1] + 0.1F * (float)l;
        if(!mMapScreen.mTurnMapAutomatically) {
            if(mMapScreen.mScrollToPosition)
            {
                float af1[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(E, C[0], C[1]);
                MF_CLASS113_a486(af1[0], af1[1]);
            }
            return;
        }

        float f = Math.abs(w) - Math.abs(MF_CLASS108_r464);
        if((double)Math.abs(w) >= 1.0D && Math.abs(f) >= Math.abs(s)) {
            if(f >= Math.abs(s))
            {
                MF_CLASS108_r464 = MF_CLASS108_r464 + s;
                t = v - MF_CLASS108_r464;
            }

        } else {
        	t = u;
        }
        g();
    }

    private void MF_CLASS113_a486(float f, float f1)
    {
        synchronized(mMapScreen)
        {
            Matrix matrix = new Matrix();
            matrix.postConcat(getImageMatrix());
            double d = getHeight();
            float f2 = (float)((double)getWidth() / 2D);
            float f3 = (float)(d / 2D);
            matrix.postTranslate(f2 - f, f3 - f1);
            setImageMatrix(matrix);
            mMapScreen.matrix.set(matrix);
        }
        return;
    }

    private void MF_CLASS113_a486(Canvas canvas, Path path, Paint paint)
    {
        canvas.drawPoints(MF_CLASS113_a486(path), paint);
    }

    static void MF_CLASS113_a486(IndoorMapView indoormapview)
    {
        indoormapview.MF_CLASS113_a486();
    }

    private float[] MF_CLASS113_a486(Path path)
    {
        ArrayList arraylist = new ArrayList();
        PathMeasure pathmeasure = new PathMeasure(path, false);
        for(int k = 0; (float)k < 1.0F + pathmeasure.getLength(); k += 3)
        {
            float af3[] = new float[2];
            pathmeasure.getPosTan(k, af3, null);
            arraylist.add(af3);
        }

        float af1[] = new float[2 * arraylist.size()];
        Iterator iterator = arraylist.iterator();
        int l = 0;
        while(iterator.hasNext())
        {
            float af2[] = (float[])iterator.next();
            int i1 = l + 1;
            af1[l] = af2[0];
            l = i1 + 1;
            af1[i1] = af2[1];
        }
        return af1;
    }

    private void MF_CLASS110_b469()
    {
        aq = 1 + aq;
        if(aq > 10)
        {
        	mTimer0.cancel();
        	mFSPOINTType = FIRSTSECOND_POINT.NONE;
            mTimer0 = null;
        }
        invalidate();
    }

    static void MF_CLASS110_b469(IndoorMapView indoormapview)
    {
        indoormapview.MF_CLASS110_b469();
    }

    private void MF_CLASS113_c488()
    {
        if(MF_CLASS113_a486 != null)
        {
            MF_CLASS113_a486.cancel();
            MF_CLASS113_a486 = null;
        }
    }

    private void MF_CLASS113_d489()
    {
        Handler handler = new Handler();
        MF_CLASS113_c488();
        MF_CLASS113_a486 = new Timer();
        CLASS359 class359 = new CLASS359(this, handler);
        MF_CLASS113_a486.schedule(class359, 0L, 50L);
    }

    private void e()
    {
        if(mScheduleTimer != null)
        {
        	mScheduleTimer.cancel();
        	mScheduleTimer = null;
        }
    }

    private void MF_CLASS112_f485()
    {
        Handler handler = new Handler();
        e();
        mScheduleTimer = new Timer();
        CLASS361 class361 = new CLASS361(this, handler);
        mScheduleTimer.schedule(class361, 0L, 1000L);
    }

    private void g()
    {
        synchronized(mMapScreen)
        {
            double d = getHeight();
            double d1 = getWidth();
            Matrix matrix = new Matrix();
            matrix.postRotate(-1F * (90F + t), (float)(d1 / 2D), (float)(d / 2D));
            matrix.postScale(mMapScreen.mCurrentZoom, mMapScreen.mCurrentZoom, (float)(d1 / 2D), (float)(d / 2D));
            E.setImageMatrix(matrix);
        }
        return;
    }

    public void addRecordedSegment()
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", "addRecordedSegment(): adding currentSegment to mSegments");
        ah.add(currentSegment);
        prepareDraw();
        invalidate();
    }

    public void addRecordedSegment(Measurement class108)
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("addRecordedSegment(): adding m to mSegments, size = ").append(ah.size()).toString());
        ah.add(class108);
        Measurement class108_1;
        for(Iterator iterator = ah.iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("addRecordedSegment(): contained m2 = ").append(class108_1.segmentID).toString()))
            class108_1 = (Measurement)iterator.next();

    }

    public void addRecordedTestSegment()
    {
        ah.add(e);
        prepareDraw();
        invalidate();
    }

    public void clearPoints()
    {
        ad = false;
        ae = false;
        currentSegment = null;
        e = null;
        invalidate();
    }

    public void destroy()
    {
        if(ak != null)
        {
            ak.recycle();
            ak = null;
        }
        if(an != null)
        {
            an.recycle();
            an = null;
        }
        if(al != null)
        {
            al.recycle();
            al = null;
        }
        if(mImgBoll != null)
        {
        	mImgBoll.recycle();
            mImgBoll = null;
        }
        mMapScreen = null;
    }

    public Path getArrowHeadPath(float f, float f1, float f2, Matrix matrix)
    {
        Path path = new Path();
        float af1[] = new float[2];
        af1[0] = f + 0.0F;
        af1[1] = 5F + f1;
        float af2[] = new float[2];
        af2[0] = 10F + f;
        af2[1] = f1 + 0.0F;
        float af3[] = new float[2];
        af3[0] = 0.0F + f;
        af3[1] = -5F + f1;
        matrix.mapPoints(af1);
        matrix.mapPoints(af2);
        matrix.mapPoints(af3);
        path.moveTo(af1[0], af1[1]);
        path.lineTo(af2[0], af2[1]);
        path.lineTo(af3[0], af3[1]);
        Matrix matrix1 = new Matrix();
        matrix1.setRotate(f2, af2[0], af2[1]);
        path.transform(matrix1);
        return path;
    }

    public Path getArrowHeadPath2(float f, float f1, float f2, float f3, Matrix matrix)
    {
        Path path = new Path();
        float af1[] = {
            f, f1
        };
        float af2[] = {
            f2, f3
        };
        matrix.mapPoints(af1);
        matrix.mapPoints(af2);
        float f4 = af1[1] - af2[1];
        float f5 = af1[0] - af2[0];
        float f6 = (float)Math.atan2(f4, f5);
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getArrowHeadPath2(): theta = ").append(Math.toDegrees(f6)).toString());
        float f7 = (float)Math.toRadians(40D);
        float f8 = (20F * getScaleX()) / (float)mMapScreen.mBitmapScale;
        float f9 = f6 + f7;
        for(int k = 0; k < 2; k++)
        {
            float f10 = af1[0] - f8 * (float)Math.cos(f9);
            float f11 = af1[1] - f8 * (float)Math.sin(f9);
            path.moveTo(af1[0], af1[1]);
            path.lineTo(f10, f11);
            f9 = f6 - f7;
        }

        return path;
    }

    public boolean getBackEndSegmentVisibility()
    {
        return af;
    }

    public List getBackendSegments()
    {
        return ag;
    }

    public float[] getClosestRecordedSegmentStartOrEndPoint(float af1[], boolean flag)
    {
        float f = 3.402823E+038F;
        float af2[] = null;
        for(Iterator iterator = ah.iterator(); iterator.hasNext();)
        {
            Measurement class108 = (Measurement)iterator.next();
            if(class108.TestSegment == 1 && !flag)
            {
                CLASS167.MF_CLASS167_b635("IndoorMapView", "getClosestSegmentStartOrEndPoint() skipping a test segment");
            } else
            {
                Iterator iterator1 = class108.mPoints.iterator();
                while(iterator1.hasNext())
                {
                    CheckPoint class112 = (CheckPoint)iterator1.next();
                    CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentStartOrEndPoint() segment = ").append(class108.toString()).toString());
                    float af3[] = new float[2];
                    af3[0] = class112.coordX;
                    af3[1] = class112.coordY;
                    CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentStartOrEndPoint segmentStartPoint = ").append(af3[0]).append(",").append(af3[1]).toString());
                    CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentStartOrEndPoint touchPointOriginalImageCoords = ").append(af1[0]).append(",").append(af1[1]).toString());
                    float f1 = (float)Math.sqrt((af3[0] - af1[0]) * (af3[0] - af1[0]) + (af3[1] - af1[1]) * (af3[1] - af1[1]));
                    CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentStartOrEndPoint() Calculated distances from point = ").append(f1).toString());
                    float af4[];
                    float f2;
                    if(f1 < f)
                    {
                        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("dist1 < dist2 && dist1 < shortestDist : segmentStartPoint = ").append(af3[0]).append(",").append(af3[1]).toString());
                        f2 = f1;
                        af4 = af3;
                    } else
                    {
                        af4 = af2;
                        f2 = f;
                    }
                    af2 = af4;
                    f = f2;
                }
            }
        }

        return af2;
    }

    public CLASS365 getClosestSegment(float f, float f1)
    {
        float af1[];
        float f2;
        float f3;
        Measurement class108;
        Iterator iterator;
        af1 = (new float[] {
            f, f1
        });
        f2 = 3.402823E+038F;
        class108 = null;
        iterator = ah.iterator();

        for(;iterator.hasNext();) {
	        Measurement class108_1;
	        Object aobj[];
	        class108_1 = (Measurement)iterator.next();
	        aobj = class108_1.mPoints.toArray();
	        if(class108_1.TestSegment != 0) {
	                int k = 0;
	                while(k < -1 + aobj.length)
	                {
	                    CheckPoint class112 = (CheckPoint)aobj[k];
	                    CheckPoint class112_1 = (CheckPoint)aobj[k + 1];
	                    float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112.coordX, class112.coordY);
	                    float af3[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_1.coordX, class112_1.coordY);
	                    float af4[] = getProjectionOfPointOnLine(af2, af3, af1);
	                    Measurement class108_2;
	                    float f5;
	                    if(af4 == null)
	                    {
	                        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegment() : pointOfLine == null, segmentStartPoint = ").append(af2[0]).append(",").append(af2[1]).append("segmentEndPoint = ").append(af3[0]).append(",").append(af3[1]).toString());
	                        class108_2 = class108;
	                        f5 = f2;
	                    } else
	                    {
	                        float f4 = (float)Math.sqrt((af4[0] - f) * (af4[0] - f) + (af4[1] - f1) * (af4[1] - f1));
	                        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("Calculated *TEST* segment distance from point = ").append(f4).append(", i = ").append(k).toString());
	                        if(f4 < f2)
	                        {
	                            f5 = f4;
	                            class108_2 = class108_1;
	                        } else
	                        {
	                            class108_2 = class108;
	                            f5 = f2;
	                        }
	                    }
	                    k++;
	                    f2 = f5;
	                    class108 = class108_2;
	                }
		            class108_1 = class108;
		            f3 = f2;

	        } else {
		        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegment() segment = ").append(class108_1.toString()).toString());
		        CheckPoint class112_2 = (CheckPoint)aobj[0];
		        CheckPoint class112_3 = (CheckPoint)aobj[-1 + aobj.length];
		        float af5[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_2.coordX, class112_2.coordY);
		        float af6[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_3.coordX, class112_3.coordY);
		        if(class108_1.mBezier == 0)
		        {
		            float af7[] = getProjectionOfPointOnLine(af5, af6, af1);
		            f3 = (float)Math.sqrt((af7[0] - f) * (af7[0] - f) + (af7[1] - f1) * (af7[1] - f1));
		            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("Calculated *MAP* segment distance from point = ").append(f3).toString());
		        } else
		        {
		            f3 = getProjectionOfPointOnBezierCurveOriginalImageCoords(class108_1, mMapScreen.transformTouchPointCoordsToOriginalImageCoords(this, f, f1))[2];
		        }
		        if(f3 >= f2) {
		            class108_1 = class108;
		            f3 = f2;
		        }
	        }

	        class108 = class108_1;
	        f2 = f3;
    }


        if(class108 != null)
            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegment's dist = ").append(f2).append(", closestSegment.mTestSegment = ").append(class108.TestSegment).toString());
        return new CLASS365(this, class108, f2);
    }

    public float[] getClosestSegmentPoint(float f, float f1)
    {
        float af1[];
        Iterator iterator;
        float af3[];
        float f2;
        af1 = (new float[] {
            f, f1
        });
        float af2[] = new float[2];
        iterator = ah.iterator();
        af3 = af2;
        f2 = 3.402823E+038F;

        float af5[];
        float f3;

        for(;iterator.hasNext();) {
	        Measurement class108 = (Measurement)iterator.next();
	        Object aobj[] = class108.mPoints.toArray();
	        if(class108.TestSegment == 0) {
//	            break MISSING_BLOCK_LABEL_408;
	        	CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentPoint() segment = ").append(class108.toString()).toString());
	        }
	        CheckPoint class112 = (CheckPoint)aobj[0];
	        CheckPoint class112_1 = (CheckPoint)aobj[-1 + aobj.length];
	        float af6[] = new float[2];
	        af6[0] = class112.coordX;
	        af6[1] = class112.coordY;
	        float af7[] = new float[2];
	        af7[0] = class112_1.coordX;
	        af7[1] = class112_1.coordY;
	        float af8[] = {
	            0.0F, 0.0F
	        };
	        if(class108.mBezier == 0)
	        {
	            af5 = getProjectionOfPointOnLine(af6, af7, af1);
	            f3 = (float)Math.sqrt((af5[0] - f) * (af5[0] - f) + (af5[1] - f1) * (af5[1] - f1));
	            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentPoint Calculated *MAP* segment distance from point = ").append(f3).toString());
	        } else
	        {
	            float af9[] = getProjectionOfPointOnBezierCurveOriginalImageCoords(class108, new float[] {
	                f, f1
	            });
	            af8[0] = af9[0];
	            af8[1] = af9[1];
	            float f4 = af9[2];
	            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getClosestSegmentPoint Calculated *MAP* bezier segment distance from point = ").append(f4).toString());
	            f3 = f4;
	            af5 = af8;
	        }
	        if(f3 >= f2) {
	            af5 = af3;
	            f3 = f2;
	        } else {
		        af3 = af5;
		        f2 = f3;
	        }
        }

        float af4[] = {
            -1F, 0.0F, 0.0F
        };
        af4[0] = af3[0];
        af4[1] = af3[1];
        af4[2] = f2;
        return af4;
    }

    public float getDistanceFromPointToSegmentMiddlePointCurrentImageCoords(Measurement class108, float af1[])
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", "getDistanceFromPointToSegmentMiddlePointCurrentImageCoords() ");
        float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, af1[0], af1[1]);
        Object aobj[] = class108.mPoints.toArray();
        CheckPoint class112 = (CheckPoint)aobj[0];
        CheckPoint class112_1 = (CheckPoint)aobj[-1 + aobj.length];
        float af3[] = new float[2];
        af3[0] = class112.coordX;
        af3[1] = class112.coordY;
        float af4[] = new float[2];
        af4[0] = class112_1.coordX;
        af4[1] = class112_1.coordY;
        float af5[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, af3[0], af3[1]);
        float af6[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, af4[0], af4[1]);
        Path path = new Path();
        path.moveTo(af5[0], af5[1]);
        if(class108.mBezier == 0)
        {
            float f1 = (class112.coordX + class112_1.coordX) / 2.0F;
            float f2 = (class112.coordY + class112_1.coordY) / 2.0F;
            float af9[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, f1, f2);
            float f3 = (float)Math.sqrt((af9[0] - af2[0]) * (af9[0] - af2[0]) + (af9[1] - af2[1]) * (af9[1] - af2[1]));
            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getDistanceFromPointToSegmentMiddlePointCurrentImageCoords(): straight-line middle point =").append(af9[0]).append(",").append(af9[1]).append(" touch point =").append(af2[0]).append(",").append(af2[1]).append(", dist = ").append(f3).toString());
            return f3;
        }
        CheckPoint class112_2 = (CheckPoint)aobj[1];
        float af7[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_2.coordX, class112_2.coordY);
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getDistanceFromPointToSegmentMiddlePointCurrentImageCoords(): transformed bezier middle point=").append(af7[0]).append(",").append(af7[1]).append(" touch point =").append(af1[0]).append(",").append(af1[1]).append(", dist = ").append(3.402823E+038F).toString());
        path.quadTo(af7[0], af7[1], af6[0], af6[1]);
        PathMeasure pathmeasure = new PathMeasure(path, false);
        float af8[] = new float[2];
        pathmeasure.getPosTan(0.5F * pathmeasure.getLength(), af8, null);
        float f = (float)Math.sqrt((af8[0] - af2[0]) * (af8[0] - af2[0]) + (af8[1] - af2[1]) * (af8[1] - af2[1]));
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getDistanceFromPointToSegmentMiddlePointCurrentImageCoords(): bezier point=").append(af8[0]).append(",").append(af8[1]).append(" touch point =").append(af2[0]).append(",").append(af2[1]).append(", tDist = ").append(f).toString());
        if(f < 3.402823E+038F)
        {
            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getDistanceFromPointToSegmentMiddlePointCurrentImageCoords(): setting closest dist so far : bezier point=").append(af8[0]).append(",").append(af8[1]).append(" touch point =").append(af2[0]).append(",").append(af2[1]).append(", tDist = ").append(f).toString());
            return f;
        } else
        {
            return 3.402823E+038F;
        }
    }

    public float getEuclideanDistance(float f, float f1, float f2, float f3)
    {
        float f4 = f2 - f;
        float f5 = f3 - f1;
        return FloatMath.sqrt(f4 * f4 + f5 * f5);
    }

    public float[] getProjectionOfPointOnBezierCurveOriginalImageCoords(Measurement class108, float af1[])
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", "getProjectionOfPointOnBezierCurveOriginalImageCoords() ");
        float af2[] = new float[3];
        Object aobj[] = class108.mPoints.toArray();
        CheckPoint class112 = (CheckPoint)aobj[0];
        CheckPoint class112_1 = (CheckPoint)aobj[-1 + aobj.length];
        float af3[] = new float[2];
        af3[0] = class112.coordX;
        af3[1] = class112.coordY;
        float af4[] = new float[2];
        af4[0] = class112_1.coordX;
        af4[1] = class112_1.coordY;
        Path path = new Path();
        path.moveTo(af3[0], af3[1]);
        if(class108.mBezier == 1)
        {
            CheckPoint class112_2 = (CheckPoint)aobj[1];
            float af5[] = new float[2];
            af5[0] = class112_2.coordX;
            af5[1] = class112_2.coordY;
            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getProjectionOfPointOnBezierCurveOriginalImageCoords(): transformed bezier middle point=").append(af5[0]).append(",").append(af5[1]).append(" touch point =").append(af1[0]).append(",").append(af1[1]).append(", dist = ").append(3.402823E+038F).toString());
            path.quadTo(af5[0], af5[1], af4[0], af4[1]);
            PathMeasure pathmeasure = new PathMeasure(path, false);
            float af6[] = new float[2];
            float f = 3.402823E+038F;
            int k = 0;
            while(k < 50)
            {
                pathmeasure.getPosTan(((float)k / 50F) * pathmeasure.getLength(), af6, null);
                float f1 = (float)Math.sqrt((af6[0] - af1[0]) * (af6[0] - af1[0]) + (af6[1] - af1[1]) * (af6[1] - af1[1]));
                CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getProjectionOfPointOnBezierCurveOriginalImageCoords(): bezier point=").append(af6[0]).append(",").append(af6[1]).append(" touch point =").append(af1[0]).append(",").append(af1[1]).append(", dist = ").append(f).toString());
                if(f1 < f)
                {
                    af2[0] = af6[0];
                    af2[1] = af6[1];
                    af2[2] = f1;
                } else
                {
                    f1 = f;
                }
                k++;
                f = f1;
            }
        } else
        {
            CLASS167.MF_CLASS167_b635("IndoorMapView", "getProjectionOfPointOnBezierCurveOriginalImageCoords() : NOT A BEZIER CURVE! Returning null");
            return null;
        }
        return af2;
    }

    public float[] getProjectionOfPointOnLine(float af1[], float af2[], float af3[])
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("p1[0] = ").append(af1[0]).append(", p1[1] = ").append(af1[1]).append(", p2[0] = ").append(af2[0]).append(", p2[1] = ").append(af2[1]).append(", p3[0] = ").append(af3[0]).append(", p3[1] = ").append(af3[1]).toString());
        double d = af2[0] - af1[0];
        double d1 = af2[1] - af1[1];
        if(d != 0.0D || d1 != 0.0D)
        {
            double d2 = (d * (double)(af3[0] - af1[0]) + d1 * (double)(af3[1] - af1[1])) / (d * d + d1 * d1);
            float af4[] = {
                0.0F, 0.0F
            };
            if(d2 >= 0.0D)
                if(d2 > 1.0D)
                {
                    return af2;
                } else
                {
                    af4[0] = (float)((double)af1[0] + d * d2);
                    af4[1] = (float)((double)af1[1] + d2 * d1);
                    return af4;
                }
        }
        return af1;
    }

    public List getRecordedSegments()
    {
        return ah;
    }

    public Bitmap getRotatedArrowHeadBitmap(float f, float f1, float f2, float f3, float f4, float f5, Matrix matrix,
            Bitmap bitmap)
    {
        float af1[] = {
            f, f1
        };
        float af2[] = {
            f2, f3
        };
        float af3[] = {
            f4, f5
        };
        matrix.mapPoints(af1);
        matrix.mapPoints(af2);
        matrix.mapPoints(af3);
        Path path = new Path();
        path.moveTo(af2[0], af2[1]);
        path.quadTo(af3[0], af3[1], af1[0], af1[1]);
        PathMeasure pathmeasure = new PathMeasure(path, false);
        float af4[] = new float[2];
        float af5[] = new float[2];
        pathmeasure.getPosTan(0.5F * pathmeasure.getLength(), af4, af5);
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getRotatedArrowHeadBitmap(): res_tan = ").append(Math.toDegrees(af5[0])).append(", Math.toDegrees(res_tan[1]) = ").append(Math.toDegrees(af5[1])).toString());
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getRotatedArrowHeadBitmap(): not to degrees : res_tan = ").append(af5[0]).append(", res_tan[1] = ").append(af5[1]).toString());
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getRotatedArrowHeadBitmap(): theta = ").append(Math.toDegrees(af5[0])).toString());
        Matrix matrix1 = new Matrix();
        matrix1.setRotate((float)Math.toDegrees(af5[0]), (float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F);
        return Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix1, true), (new Float((float)bitmap.getWidth() * getScaleX())).intValue(), (new Float(0.69999999999999996D * (double)((float)bitmap.getHeight() * getScaleX()))).intValue(), true);
    }

    public Bitmap getRotatedBitmapForSegment(float f, float f1, float f2, float f3, Bitmap bitmap, float f4)
    {
        float f5 = CLASS72.MF_CLASS72_a237(f, f2, f1, f3);
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getRotatedBitmapForSegment(): angleOfSegment = ").append(Math.toDegrees(f5)).append(", degreesOffset = ").append(f4).toString());
        Matrix matrix = new Matrix();
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("getRotatedBitmapForSegment(): setting rorate to degrees = ").append(Math.toDegrees(f5) + (double)f4).append(", mMapScreen.mCurrentZoom = ").append(mMapScreen.mCurrentZoom).toString());
        matrix.setRotate(f4 + (float)Math.toDegrees(f5), (float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return Bitmap.createScaledBitmap(bitmap1, (new Float((float)(1 * bitmap1.getWidth()) * am)).intValue(), (new Float((float)(1 * bitmap1.getHeight()) * am)).intValue(), true);
    }

    public List getSegmentsFromDB()
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.getSegmentsFromDB():  mMapScreen.mCurrentBuilding = ").append(mMapScreen.mCurrentBuilding).toString());
        List list = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID(mMapScreen.mCurrentBuilding.getBuildingID(), mMapScreen.mCurrentLevel.getLevelID(), mMapScreen.mGraphics.getGraphicsID());
//        List list = MeasurementDataSource.getMeasurementsByBuildingIDAndLevelIDAndGraphicsID("BuildID001","LevelID004","GraphyID001");

//        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.getSegmentsFromDB(): measurements.size() = ").append(list.size()).append(", for building = ").append(mMapScreen.mCurrentBuilding.MF_CLASS99_a370()).append(", level = ").append(mMapScreen.mCurrentLevel.MF_CLASS105_a432()).append(", graphics = ").append(mMapScreen.mGraphics.MF_CLASS103_a414()).toString());
        return list;
    }

    public CLASS110 getSelectedPoint()
    {
        return aj;
    }

    public Measurement getSelectedSegment()
    {
        return MF_CLASS113_d489;
    }

    public void hideSegments()
    {
        ai = false;
        prepareDraw();
        invalidate();
    }

    public void initialize()
    {
        ak = BitmapFactory.decodeResource(getResources(), 0x7f020011);
        al = BitmapFactory.decodeResource(getResources(), 0x7f020015);
        an = BitmapFactory.decodeResource(getResources(), 0x7f02002e);
        mImgBoll = Bitmap.createScaledBitmap(al, (new Float((float)(1 * al.getWidth()) * am)).intValue(), (new Float((float)(1 * al.getHeight()) * am)).intValue(), true);
        hideSegments();
        ah = getSegmentsFromDB();
        clearPoints();
        prepareDraw();
        invalidate();
    }

    public boolean isFirstPointGiven()
    {
        return ad;
    }

    public boolean isPositioning()
    {
        return B;
    }

    public void markSegmentSent(Measurement class108)
    {
    	getMeasurementByID(class108.mMeasurementID).mSentToServer = 1L;
        prepareDraw();
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        long l = System.currentTimeMillis();
        super.onDraw(canvas);
        if(mMapScreen.mMaxImageWidthHWAccel == 0.0F)
        {
            mMapScreen.mMaxImageWidthHWAccel = canvas.getMaximumBitmapWidth();
            mMapScreen.mMaxImageHeightHWAccel = canvas.getMaximumBitmapHeight();
        }
        //if(ai) return;
        
        String s1;
        float f2;
        int k;
        int i1;
        int j1;
        int k1;
        float af1[];
        Matrix matrix;
        long l4;
        String s2;
        float f3;

        long l8;
        l8 = SystemClock.elapsedRealtime();
        CLASS367 class367;
        for(Iterator iterator1 = av.iterator(); iterator1.hasNext();) {
       	 	 class367 = (CLASS367)iterator1.next();
        	 canvas.drawPath((Path)class367.MF_CLASS367_a985, (Paint)class367.MF_CLASS367_b986);
        }

//        SystemClock.elapsedRealtime() - l8;
        if(MF_CLASS113_d489 != null) {
		    long l9 = SystemClock.elapsedRealtime();
		    if(currentSegment != MF_CLASS113_d489) {
		        canvas.drawPath(plotSegment(MF_CLASS113_d489), J);
		//            SystemClock.elapsedRealtime() - l9;
		    } else {
		    	canvas.drawPath(plotSegment(MF_CLASS113_d489), K);
		    }
        }

        if(currentSegment != null) {
	        long l7;
	        Object aobj1[];
	        CheckPoint class112_9;
	        Path path1;
	        float af17[];
	        l7 = SystemClock.elapsedRealtime();
	        aobj1 = currentSegment.mPoints.toArray();
	        CheckPoint class112_8 = (CheckPoint)aobj1[0];
	        class112_9 = (CheckPoint)aobj1[-1 + aobj1.length];
	        path1 = new Path();
	        float af16[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_8.coordX, class112_8.coordY);
	        af17 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_9.coordX, class112_9.coordY);
	        path1.moveTo(af16[0], af16[1]);
	        if(currentSegment.mBezier != 0) {
                float af18[];
                float f4;
                float f5;
                CheckPoint class112_10 = (CheckPoint)aobj1[1];
                af18 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_10.coordX, class112_10.coordY);
                f4 = Math.abs(af18[0] - mCurrentStartX);
                f5 = Math.abs(af18[1] - mCurrentStartY);
                if(f4 >= 4F || f5 >= 4F) {
        	        path1.quadTo(af18[0], af18[1], af17[0], af17[1]);
                }
	        } else {
		        float af19[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_9.coordX, class112_9.coordY);
		        path1.lineTo(af19[0], af19[1]);
	        }
	        if(mMapScreen.mScreenPointType == POINT_TYPE.RECORDING) {
                MF_CLASS113_a486(canvas, path1, L);
	        } else {
	        	canvas.drawPath(path1, L);
	        }
	        //SystemClock.elapsedRealtime() - l7;
        }

        if(ad && !ae)
        {
            float af15[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, mCurrentStartX, mCurrentStartY);
            canvas.drawBitmap(mImgBoll, af15[0] - (float)(mImgBoll.getWidth() / 2), af15[1] - (float)(mImgBoll.getHeight() / 2), null);
            if(mFSPOINTType == FIRSTSECOND_POINT.FIRST_POINT)
            {
                int j4 = 60 - 5 * aq;
                canvas.drawCircle(af15[0], af15[1], j4, Z);
            }
        }
        if(ae && ad) {
	        long l6;
	        float af12[];
	        float af13[];
	        l6 = SystemClock.elapsedRealtime();
	        af12 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, mCurrentStartX, mCurrentStartY);
	        af13 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, mCurrentEndX, mCurrentEndY);
	        if(currentSegment == null || currentSegment.mBezier != 1) {
                Bitmap bitmap5 = getRotatedBitmapForSegment(af12[0], af12[1], af13[0], af13[1], ak, 0.0F);
                canvas.drawBitmap(bitmap5, af13[0] - (float)(bitmap5.getWidth() / 2), af13[1] - (float)(bitmap5.getHeight() / 2), null);
                Bitmap bitmap6 = getRotatedBitmapForSegment(af12[0], af12[1], af13[0], af13[1], al, -180F);
                canvas.drawBitmap(bitmap6, af12[0] - (float)(bitmap6.getWidth() / 2), af12[1] - (float)(bitmap6.getHeight() / 2), null);
	        } else {
		        CheckPoint class112_7 = (CheckPoint)currentSegment.mPoints.toArray()[1];
		        float af14[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_7.coordX, class112_7.coordY);
		        Bitmap bitmap7 = getRotatedBitmapForSegment(af14[0], af14[1], af13[0], af13[1], ak, 0.0F);
		        canvas.drawBitmap(bitmap7, af13[0] - (float)(bitmap7.getWidth() / 2), af13[1] - (float)(bitmap7.getHeight() / 2), null);
		        Bitmap bitmap8 = getRotatedBitmapForSegment(af12[0], af12[1], af14[0], af14[1], al, -180F);
		        canvas.drawBitmap(bitmap8, af12[0] - (float)(bitmap8.getWidth() / 2), af12[1] - (float)(bitmap8.getHeight() / 2), null);
	        }

	        if(mFSPOINTType != FIRSTSECOND_POINT.SECOND_POINT) {
	                if(mFSPOINTType == FIRSTSECOND_POINT.FIRST_POINT) {
	        	        int k3 = 60 - 5 * aq;
	        	        canvas.drawCircle(af12[0], af12[1], k3, Z);
	                }
	        } else {
		        int i4 = 60 - 5 * aq;
		        canvas.drawCircle(af13[0], af13[1], i4, Z);
	        }
	        l8 = SystemClock.elapsedRealtime() - l6;
        }

        if(e != null) {
	        long l5;
	        Object aobj[];
	        l5 = SystemClock.elapsedRealtime();
	        aobj = e.mPoints.toArray();
	        if(e.mPoints.size() >= 2) {
		        float af6[];
		        float af7[];
		        float af8[];
		        float af9[];
		        Path path;
		        CheckPoint class112_1 = (CheckPoint)aobj[0];
		        CheckPoint class112_2 = (CheckPoint)aobj[1];
		        CheckPoint class112_3 = (CheckPoint)aobj[-2 + aobj.length];
		        CheckPoint class112_4 = (CheckPoint)aobj[-1 + aobj.length];
		        af6 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_1.coordX, class112_1.coordY);
		        af7 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_2.coordX, class112_2.coordY);
		        af8 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_3.coordX, class112_3.coordY);
		        af9 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_4.coordX, class112_4.coordY);
		        path = new Path();
		        path.moveTo(af6[0], af6[1]);
		        float af11[];
		        for(Iterator iterator = e.mPoints.iterator(); iterator.hasNext(); path.lineTo(af11[0], af11[1]))
		        {
		            CheckPoint class112_6 = (CheckPoint)iterator.next();
		            af11 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_6.coordX, class112_6.coordY);
		        }

		        if(mMapScreen.mScreenPointType == POINT_TYPE.RECORDING) {
		        	MF_CLASS113_a486(canvas, path, L);
		        } else {
		        	canvas.drawPath(path, L);
		        }
		        Bitmap bitmap3 = getRotatedBitmapForSegment(af8[0], af8[1], af9[0], af9[1], ak, 0.0F);
		        canvas.drawBitmap(bitmap3, af9[0] - (float)(bitmap3.getWidth() / 2), af9[1] - (float)(bitmap3.getHeight() / 2), null);
		        Bitmap bitmap4 = getRotatedBitmapForSegment(af6[0], af6[1], af7[0], af7[1], al, -180F);
		        canvas.drawBitmap(bitmap4, af6[0] - (float)(bitmap4.getWidth() / 2), af6[1] - (float)(bitmap4.getHeight() / 2), null);
		        int j3 = 1;
		        for(;j3 < -1 + e.mPoints.size();) {
			        float af10[];
			        CheckPoint class112_5 = (CheckPoint)e.mPoints.get(j3);
			        af10 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112_5.coordX, class112_5.coordY);
			        if(class112_5.CheckPointTimestamp == 0L)
			        {
			            canvas.drawCircle(af10[0], af10[1], 12F, T);
			        } else {
				        T.setStyle(android.graphics.Paint.Style.FILL);
				        canvas.drawCircle(af10[0], af10[1], 12F, T);
				        T.setStyle(android.graphics.Paint.Style.STROKE);
			        }
			        j3++;
		        }
	        }
	        CheckPoint class112 = (CheckPoint)aobj[0];
	        float af5[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, class112.coordX, class112.coordY);
	        Bitmap bitmap2 = Bitmap.createScaledBitmap(al, (new Float((float)(1 * al.getWidth()) * am)).intValue(), (new Float((float)(1 * al.getHeight()) * am)).intValue(), true);
	        canvas.drawBitmap(bitmap2, af5[0] - (float)(bitmap2.getWidth() / 2), af5[1] - (float)(bitmap2.getHeight() / 2), null);

	        l8 = SystemClock.elapsedRealtime() - l5;

        }

        if(aj != null && mMapScreen.getTouchMode() != TouchMode.DRAG)
        {
            int i3 = (int)(15F * MapScreen.UiPixelScale);
            float af4[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, aj.MF_CLASS110_b469.coordX, aj.MF_CLASS110_b469.coordY);
            canvas.drawCircle(af4[0], af4[1], i3, S);
        }
        if(mMapScreen.mUpdatingLocation && isPositioning())
            mMapScreen.showConnectionIndicator();
        if(mMapScreen.mUpdatingLocation && isPositioning() && H > 0L) {
	        float f;
	        float f1;
	        System.currentTimeMillis();
	        f = ((float)(Math.min(mMapScreen.mBitmap.getWidth(), mMapScreen.mBitmap.getHeight()) * mMapScreen.mBitmapScale) * mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio()) / 2.0F;
	        f1 = D;
	        if(!CLASS113.MF_CLASS113_d489.booleanValue()) {

		        f1 = 1.0F + f * (1.0F - D);
		        if(D < 0.0F || D > 1.0F)
		            f1 = 1.0F;
	        }
	        f2 = (float)((1.0D / (double)(float)mMapScreen.mBitmapScale) * (double)mMapScreen.mCurrentZoom * (1.0D / (double)mMapScreen.mGraphics.getPixelTransform().getPixelToMeterRatio()));
	        k = (new Float(f1 * f2)).intValue();
	        if(k < 25)
	            i1 = 25;
	        else
	            i1 = k;
	        j1 = (new Float(1.5F * f2)).intValue();
	        if(j1 < 15)
	            k1 = 15;
	        else
	            k1 = j1;
	        af1 = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, C[0], C[1]);
	        if(mMapScreen.mSmoothBetweenPrevAndCurrentPosition)
	        {
	            int i2 = (new Double(MF_CLASS112_f485)).intValue();
	            int j2 = (new Double(g)).intValue();
	            float af3[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, i2, j2);
	            int k2 = (new Float(f2 * 0.5F)).intValue();
	            canvas.drawCircle(af3[0], af3[1], k2, W);
	        }
	        canvas.drawCircle(af1[0], af1[1], i1, U);
	        canvas.drawCircle(af1[0], af1[1], i1, V);
	        matrix = new Matrix();
	        if(!mMapScreen.mTurnMapAutomatically) {
	            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("onDraw(): *NOT* turning map automatically: mProbability = ").append(D).append(", mMapScreen.mTurnMapAutomatically = ").append(mMapScreen.mTurnMapAutomatically).toString());
	            f3 = 180F + (90F + u);
	            matrix.postConcat(getImageMatrix());
	            matrix.postRotate(f3, an.getWidth() / 2, an.getHeight() / 2);
	        } else {
		        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("onDraw(): turning map automatically: mProbability = ").append(D).append(" mMapScreen.mTurnMapAutomatically = ").append(mMapScreen.mTurnMapAutomatically).toString());
		        matrix.postRotate(180F, an.getWidth() / 2, an.getHeight() / 2);
	        }
	        System.currentTimeMillis();
	        Bitmap bitmap = Bitmap.createBitmap(an, 0, 0, an.getWidth(), an.getHeight(), matrix, true);
	        System.currentTimeMillis();
	        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, k1, k1, true);
	        canvas.drawBitmap(bitmap1, af1[0] - (float)(bitmap1.getWidth() / 2), af1[1] - (float)(bitmap1.getHeight() / 2), null);
	        l4 = System.currentTimeMillis() - mMapScreen.mLastSuccesfulLocationUpdateTimestamp;
	        if(mMapScreen.mLastRountrip <= 4000L)
	            if(l4 <= 4000L);
	        if(h != -1F)
	        {
	            float af2[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(this, h, i);
	            canvas.drawCircle(af2[0], af2[1], 25, aa);
	            canvas.drawText((new StringBuilder()).append("Angle : ").append(j).toString(), 5F, 100F, ab);
	        }
        }

        if(CLASS113.MF_CLASS113_c488.booleanValue()) {
	        ar = 1L + ar;
	        at.add(Long.valueOf(System.currentTimeMillis()));
	        if(ar % 10L == 0L)
	        {
	            long l2 = ((Long)at.getFirst()).longValue();
	            long l3 = ((Long)at.getLast()).longValue() - l2;
	            as = (float)at.size() / ((float)l3 / 1000F);
	        }
	        I.format(as);
	        I.format(t);
	        I.format(u);
	        s1 = I.format(mMapScreen.getAPIBGCalibrationStatusPercent());
	        if(mMapScreen.isBGCalibrationReady())
	            s2 = "Ready";
	        else
	            s2 = "Not ready";
	        try
	        {
	            String s3 = I.format(mMapScreen.getCommunicationLatency());
	            canvas.drawRect(0.0F, 0.0F, E.getWidth(), 1.5F * (float)mMapScreen.mNaviButton.getHeight(), ac);
	            canvas.drawText((new StringBuilder()).append("Queued: ").append(mMapScreen.getMessageQueueLength()).append(", Latency: ").append(s3).append("s").append(", Est: ").append(H).append(", BGC: ").append(s2).append(", ").append(s1).append("%").toString(), 5 + 2 * mMapScreen.mNaviButton.getWidth(), 25F, ab);
	            canvas.drawText(mMapScreen.K, 5 + 2 * mMapScreen.mNaviButton.getWidth(), 50F, ab);
	            canvas.drawText(mMapScreen.mConnectedVsStrongestWiFiAP, 5 + 2 * mMapScreen.mNaviButton.getWidth(), 75F, ab);
	            canvas.drawText((new StringBuilder()).append("Connecting to: ").append(CLASS41.locationService).toString(), 5 + 2 * mMapScreen.mNaviButton.getWidth(), 100F, ab);
	        }
	        // Misplaced declaration of an exception variable
	        catch(Exception exception)
	        {
	            exception.printStackTrace();
	        	CLASS167.unhandledexception(exception, mMapScreen);
	        }
        }

        long l1 = System.currentTimeMillis();
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("onDraw took = ").append(l1 - l).append("ms").toString());
        return;

    }

    public void prepareDraw()
    {
        long l = SystemClock.elapsedRealtime();
        av.clear();
        if(ai && ah != null)
        {
            long l2 = SystemClock.elapsedRealtime();
            for(Iterator iterator1 = ah.iterator(); iterator1.hasNext();)
            {
                Measurement class108_1 = (Measurement)iterator1.next();
                if(class108_1.TestSegment == 0)
                {
                    if(class108_1.mSentToServer == 1L)
                        av.add(new CLASS367(this, plotSegment(class108_1), P));
                    else
                        av.add(new CLASS367(this, plotSegment(class108_1), O));
                } else
                if(class108_1.mSentToServer == 1L)
                    av.add(new CLASS367(this, plotSegment(class108_1), R));
                else
                    av.add(new CLASS367(this, plotSegment(class108_1), Q));
            }

            long _tmp = SystemClock.elapsedRealtime() - l2;
        }
        if(af && ag != null)
        {
            long l1 = SystemClock.elapsedRealtime();
            for(Iterator iterator = ag.iterator(); iterator.hasNext();)
            {
                Measurement l_measurement = (Measurement)iterator.next();
                if(l_measurement.TestSegment == 0)
                    av.add(new CLASS367(this, plotSegment(l_measurement), N));
                else
                    av.add(new CLASS367(this, plotSegment(l_measurement), M));
            }

            long _tmp1 = SystemClock.elapsedRealtime() - l1;
        }
        long _tmp2 = SystemClock.elapsedRealtime() - l;
    }

    public void removeLastCheckPoint()
    {
        e.MF_CLASS108_b448();
        invalidate();
    }

    public void removeRecordedSegment(Measurement class108)
    {
    	boolean flag;
    	if(!class108.MF_CLASS108_r464) {
            Iterator iterator = ah.iterator();
            for(;iterator.hasNext();) {
    	        Measurement class108_2 = (Measurement)iterator.next();
    	        if(class108_2.mMeasurementID == class108.mMeasurementID) {
    	        	flag = ah.remove(class108_2);
    	        	break;
    	        }
            }
        } else {
        	Iterator iterator2 = ah.iterator();
	        for(;iterator2.hasNext();) {
		        Measurement class108_3 = (Measurement)iterator2.next();
		        if(class108_3.segmentID.equals(class108.segmentID)) {
		        	flag = ah.remove(class108_3);
		        	break;
		        }
	        }
        }
        flag = false;
        boolean flag1;
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.removeRecordedSegment() REMOVED LOCAL : removed = ").append(flag).toString());
        flag1 = false;
        if(ag != null) {

            Iterator iterator1 = ag.iterator();
            Measurement measurement1;
            for(;iterator1.hasNext();) {
            	measurement1 = (Measurement)iterator1.next();
            	if(measurement1.segmentID.equals(class108.segmentID)) {
            		flag1 = ag.remove(measurement1);
            		break;
            	}
            }
        }
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.removeRecordedSegment() REMOVED BE-SEGMENT'S LOCAL COPY : removed = ").append(flag1).toString());
        if(currentSegment == class108)
            clearPoints();
        return;

    }

    public void scrollToPosition(int k, int l)
    {
        double d = getHeight();
        double d1 = getWidth();
        scrollTo((new Double((double)k - d1 / 2D)).intValue(), (new Double((double)l - d / 2D)).intValue());
    }

    public void setBackEndSegmentVisibility(boolean flag)
    {
        af = flag;
        prepareDraw();
        invalidate();
    }

    public void setBackendSegments(List list)
    {
        if(list != null)
            CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("setBackendSegments called, backendSegments.size = ").append(list.size()).toString());
        else
            CLASS167.MF_CLASS167_b635("IndoorMapView", "setBackendSegments called, backendSegments == NULL!");
        ag = list;
        if(CLASS113.isExceptionLogged.booleanValue() && ag != null)
        {
            CLASS167.MF_CLASS167_b635("IndoorMapView", "setBackendSegments() : Setting and plotting backend measurements:\n");
            Measurement class108;
            for(Iterator iterator = ag.iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("measurement : ").append(class108.toString()).toString()))
                class108 = (Measurement)iterator.next();

        }
    }

    public void setEndPoint(float f, float f1)
    {
        mCurrentEndX = f;
        mCurrentEndY = f1;
        ae = true;
    }

    public void setInitialRotation()
    {
        double d = getHeight();
        double d1 = getWidth();
        Matrix matrix = new Matrix();
        matrix.postConcat(getImageMatrix());
        matrix.postRotate(-90F, (float)(d1 / 2D), (float)(d / 2D));
        E.setImageMatrix(matrix);
        prepareDraw();
        invalidate();
        y = true;
    }

    public void setMapScreen(MapScreen mapscreen)
    {
        mMapScreen = mapscreen;
    }

    public void setPosition(float f, float f1, float f2)
    {
        u = f2;
        t = u;
        MF_CLASS112_f485 = f;
        g = f1;
        int k = (new Double(MF_CLASS112_f485)).intValue();
        int l = (new Double(g)).intValue();
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("setPosition(): server coords in pixels :(").append(k).append(",").append(l).append(")").toString());
        g();
        try
        {
            float af1[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(E, k, l);
            MF_CLASS113_a486(af1[0], af1[1]);
            return;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void setPositioning(boolean flag)
    {
        B = flag;
        y = false;
        double d = mMapScreen.mGraphics.getGraphicImage().getHeight();
        double d1 = mMapScreen.mGraphics.getGraphicImage().getWidth();
        C[0] = (int)(d1 / 2D);
        C[1] = (int)(d / 2D);
        MF_CLASS112_f485 = (int)(d1 / 2D);
        g = (int)(d / 2D);
        h = -1F;
        i = -1F;
        MF_CLASS108_k457 = (int)(d1 / 2D);
        MF_CLASS108_l458 = (int)(d / 2D);
        q = 0.0F;
        m = -1.570796F;
        u = 270F;
        D = 10F;
        H = 0L;
        ar = 0L;
        au = 0L;
        if(flag)
        {
            MF_CLASS113_d489();
            MF_CLASS112_f485();
        } else
        {
            if(MF_CLASS113_a486 != null)
            {
                MF_CLASS113_a486.cancel();
                MF_CLASS113_a486 = null;
            }
            if(mScheduleTimer != null)
            {
            	mScheduleTimer.cancel();
                mScheduleTimer = null;
                return;
            }
        }
    }

    public void setSegment(Measurement class108)
    {
        currentSegment = class108;
        invalidate();
    }

    public void setSegmentsFromMeasurements(List list)
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.setSegmentsFromMeasurements():  sipa = ").append(mMapScreen.mCurrentBuilding).toString());
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.setSegmentsFromMeasurements():  for building = ").append(mMapScreen.mCurrentBuilding.MF_CLASS99_b371()).toString());
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.setSegmentsFromMeasurements(): measurements.size() = ").append(list.size()).append(", for building = ").append(mMapScreen.mCurrentBuilding.getBuildingID()).toString());
        ah = list;
        prepareDraw();
        invalidate();
    }

    public void setSelectedPoint(CLASS110 class110)
    {
        aj = class110;
    }

    public void setSelectedSegment(Measurement class108)
    {
        MF_CLASS113_d489 = class108;
    }

    public void setStartPoint(float f, float f1)
    {
        mCurrentStartX = f;
        mCurrentStartY = f1;
        ad = true;
        invalidate();
    }

    public void setTestPath(Measurement class108)
    {
        e = class108;
    }

    public void setupSnapAnimation(FIRSTSECOND_POINT class366)
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.setupSnapAnimation called: s = ").append(class366).toString());
        if(mTimer0 != null)
        {
            CLASS167.MF_CLASS167_b635("IndoorMapView", "setupSnapAnimation : snapTimer != null, not creating new timer!");
            return;
        } else
        {
            aq = 0;
            mFSPOINTType = class366;
            startSnapUIUpdater();
            return;
        }
    }

    public void showSegments()
    {
        ai = true;
        prepareDraw();
        invalidate();
    }

    public void startSnapUIUpdater()
    {
        CLASS167.MF_CLASS167_b635("IndoorMapView", "startSnapUIUpdater called");
        Handler handler = new Handler();
        if(mTimer0 != null)
        {
        	mTimer0.cancel();
            mTimer0 = null;
            return;
        } else
        {
        	mTimer0 = new Timer();
            CLASS363 class363 = new CLASS363(this, handler);
            mTimer0.schedule(class363, 0L, 50L);
            return;
        }
    }

    public void stopSnapAnimation()
    {
    	mFSPOINTType = FIRSTSECOND_POINT.NONE;
        if(mTimer0 != null)
        {
        	mTimer0.cancel();
        	mTimer0 = null;
        }
    }

    public void updatePosition(float f, float f1, float f2, float f3)
    {
        int k = 500;
        int l;
        MF_CLASS113_c488();
        H = 1L + H;
        if(mMapScreen.mTurnMapAutomatically && !y)
            setInitialRotation();
        D = f3;
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.updatePosition() called x = ").append(f).append(", y = ").append(f1).append(", mUncertainty = ").append(D).append(", headingDeg = ").append(f2).append(", mMapScreen.mTurnMapAutomatically = ").append(mMapScreen.mTurnMapAutomatically).append(", mMapScreen.mSmoothBetweenPrevAndCurrentPosition = ").append(mMapScreen.mSmoothBetweenPrevAndCurrentPosition).append(", mMapScreen.mScrollToPosition = ").append(mMapScreen.mScrollToPosition).toString());
        v = u;
        float f4 = 0.01745329F * (u - f2);
        float f5 = 57.29578F * (float)Math.atan2(Math.sin(f4), Math.cos(f4));
        MF_CLASS108_r464 = 0.0F;
        w = f5;
        s = 3F * (w / 10F);
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("IndoorMapView.updatePosition() angleDiffDeg = ").append(f5).toString());
        u = f2;
        setVisibility(0);
        MF_CLASS108_k457 = MF_CLASS112_f485;
        MF_CLASS108_l458 = g;
        m = q;
        MF_CLASS112_f485 = f;
        g = f1;
        ao = ap;
        ap = System.currentTimeMillis();
        l = (int)(ap - ao);
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("updatePosition(): updatePeriod = ").append(l).toString());
        Exception exception;
        int i1;
        int j1;
        int k1;
        int l1;
        if(l <= k)
            k = l;
        i1 = (new Double(MF_CLASS112_f485)).intValue();
        j1 = (new Double(g)).intValue();
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("updatePosition(): server coords in pixels :(").append(i1).append(",").append(j1).append(")").toString());
        k1 = (new Double(C[0])).intValue();
        l1 = (new Double(C[1])).intValue();
        CLASS167.MF_CLASS167_b635("IndoorMapView", (new StringBuilder()).append("updatePosition() updatePeriod = ").append(k).append(", finalX = ").append(i1).append(", finalY = ").append(j1).append(" finalLastX = ").append(k1).append(" finalLastY = ").append(l1).toString());
        CLASS167.MF_CLASS167_b635("IndoorMapView", "updateposition : distanceMovedMeters >= MAX_DISTANCE_TO_ANIMATE --> jumping to new position ");
        if(mMapScreen.mSmoothBetweenPrevAndCurrentPosition) {
            CLASS167.MF_CLASS167_b635("IndoorMapView", "updateposition : mSmoothBetweenPrevAndCurrentPosition == true, not updating screen in this function!");
        } else {

	        CLASS167.MF_CLASS167_b635("IndoorMapView", "updateposition : mSmoothBetweenPrevAndCurrentPosition == false");
	        C[0] = i1;
	        C[1] = j1;
	        if(mMapScreen.mTurnMapAutomatically)
	        {
	            CLASS167.MF_CLASS167_b635("IndoorMapView", "updateposition : mMapScreen.mTurnMapAutomatically == true");
	            t = f2;
	            g();
	        }
	        if(mMapScreen.mScrollToPosition)
	        {
	            CLASS167.MF_CLASS167_b635("IndoorMapView", "updateposition : mMapScreen.mScrollToPosition == true");
	            float af1[] = mMapScreen.transformOriginalCoordsToCurrentImageCoords(E, C[0], C[1]);
	            MF_CLASS113_a486(af1[0], af1[1]);
	        }
        }
        invalidate();
        if(mMapScreen.mUpdatingLocation)
            MF_CLASS113_d489();
        return;
    }

    public void updateShortTermPosition(float f, float f1, float f2)
    {
        au = 1L + au;
        j = f2;
        h = f;
        i = f1;
        invalidate();
        return;
    }

    public static final float NOT_SELECTED_CURRENT_SEGMENT_WIDTH_DIP = 3F;
    public static final float NOT_SELECTED_SEGMENT_WIDTH_DIP = 5F;
    public static final float SELECTED_POINT_WIDTH_DIP = 3F;
    public static final float SELECTED_SEGMENT_WIDTH_DIP = 8F;
    public static final float SNAP_ANIM_WIDTH_DIP = 3F;
    public static final String TAG = "IndoorMapView";
    float A[] = {
        88F, 92F, 469F, 466F
    };
    boolean B;
    float C[];
    float D;
    IndoorMapView E;
    Bitmap mImgBoll;
    FIRSTSECOND_POINT mFSPOINTType;
    long H;
    DecimalFormat I;
    private Paint J;
    private Paint K;
    private Paint L;
    private Paint M;
    private Paint N;
    private Paint O;
    private Paint P;
    private Paint Q;
    private Paint R;
    private Paint S;
    private Paint T;
    private Paint U;
    private Paint V;
    private Paint W;
    private Paint Z;
    Timer MF_CLASS113_a486;
    private Paint aa;
    private Paint ab;
    private Paint ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private List ag;
    private List ah;
    private boolean ai;
    private CLASS110 aj;
    private Bitmap ak;
    private Bitmap al;
    private float am;
    private Bitmap an;
    private long ao;
    private long ap;
    private int aq;
    private long ar;
    private float as;
    private CLASS69 at;
    private long au;
    private List av;
    Timer mTimer0;
    Timer mScheduleTimer;
    public Measurement currentSegment;
    Measurement MF_CLASS113_d489;
    Measurement e;
    float MF_CLASS112_f485;
    float g;
    float h;
    float i;
    float j;
    float MF_CLASS108_k457;
    float MF_CLASS108_l458;
    float m;
    public float mCurrentEndX;
    public float mCurrentEndY;
    public float mCurrentStartX;
    public float mCurrentStartY;
    public MapScreen mMapScreen;
    float MF_CLASS108_n460;
    int MF_CLASS108_o461;
    float MF_CLASS108_p462;
    float q;
    float MF_CLASS108_r464;
    float s;
    float t;
    float u;
    float v;
    float w;
    float x;
    boolean y;
    float z[] = {
        130F, 542F, 540F, 132F
    };
}
