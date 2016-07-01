// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.indooratlas.mapcreator.controller.CLASS167;
import java.text.NumberFormat;
import java.util.*;

public class Plot2D extends View
{

    public Plot2D(Context context, ArrayList arraylist, ArrayList arraylist1, int i1, String as[], Float float1)
    {
        super(context);
        k = 1;
        l = null;
        m = null;
        b = arraylist;
        c = arraylist1;
        k = i1;
        l = as;
        m = float1;
        j = ((float[])arraylist.get(0)).length;
        a = new Paint();
        Iterator iterator = arraylist.iterator();
        int j1;
        for(j1 = 0; iterator.hasNext(); j1 += ((float[])iterator.next()).length);
        float af[] = new float[j1];
        float af1[] = new float[j1];
        Iterator iterator1 = arraylist.iterator();
        int k1 = 0;
        while(iterator1.hasNext())
        {
            float af3[] = (float[])iterator1.next();
            int k2 = 0;
            while(k2 < af3.length)
            {
                int l2 = k1 + 1;
                af1[k1] = af3[k2];
                k2++;
                k1 = l2;
            }
        }
        Iterator iterator2 = arraylist1.iterator();
        int l1 = 0;
        while(iterator2.hasNext())
        {
            float af2[] = (float[])iterator2.next();
            int i2 = 0;
            while(i2 < af2.length)
            {
                int j2 = l1 + 1;
                af[l1] = af2[i2];
                i2++;
                l1 = j2;
            }
        }
        a(af1, af);
    }

    private float a(float af[])
    {
        int i1 = 0;
        float f1 = af[0];
        for(; i1 < af.length; i1++)
            if(af[i1] > f1)
                f1 = af[i1];

        return f1;
    }

    private int a(float f1, float f2, float f3, float f4)
    {
        return (int)(0.10000000000000001D * (double)f1 + 0.80000000000000004D * (double)((f4 - f2) / (f3 - f2)) * (double)f1);
    }

    private void a(float af[], float af1[])
    {
        f = b(af);
        g = b(af1);
        d = a(af);
        e = a(af1);
        if(f >= 0.0F)
            i = f;
        else
        if(f < 0.0F && d >= 0.0F)
            i = 0.0F;
        else
            i = d;
        if(g >= 0.0F)
        {
            h = g;
            return;
        }
        if(g < 0.0F && e >= 0.0F)
        {
            h = 0.0F;
            return;
        } else
        {
            h = e;
            return;
        }
    }

    private int[] a(float f1, float f2, float f3, float af[])
    {
        double ad[] = new double[af.length];
        int ai[] = new int[af.length];
        for(int i1 = 0; i1 < af.length; i1++)
        {
            ad[i1] = 0.10000000000000001D * (double)f1 + 0.80000000000000004D * (double)((af[i1] - f2) / (f3 - f2)) * (double)f1;
            ai[i1] = (int)ad[i1];
        }

        return ai;
    }

    private float b(float af[])
    {
        int i1 = 0;
        float f1 = af[0];
        for(; i1 < af.length; i1++)
            if(af[i1] < f1)
                f1 = af[i1];

        return f1;
    }

    protected void onDraw(Canvas canvas)
    {
        float f1 = getHeight();
        float f2 = getWidth();
        canvas.drawARGB(0, 0, 0, 0);
        int i1 = 0;
        int j1 = 0;
        int k1;
        int k3;
        for(k1 = 0; i1 < b.size(); k1 = k3)
        {
            int ai2[] = a(f2, f, d, (float[])b.get(i1));
            int ai3[] = a(f1, g, e, (float[])c.get(i1));
            CLASS167.MF_CLASS167_b635("Plot2D", (new StringBuilder()).append("onDraw(): xvaluesInPixels.length = ").append(ai2.length).append(", yvaluesInPixels.length = ").append(ai3.length).toString());
            k3 = a(f1, g, e, h);
            j1 = a(f2, f, d, i);
            CLASS167.MF_CLASS167_b635("Plot2D", (new StringBuilder()).append("onDraw(): locxAxisInPixels = ").append(k3).append(", locyAxisInPixels = ").append(j1).toString());
            a.setStrokeWidth(2.0F);
            for(int l3 = 0; l3 < -1 + j; l3++)
            {
                a.setColor(n[i1]);
                canvas.drawLine(ai2[l3], f1 - (float)ai3[l3], ai2[l3 + 1], f1 - (float)ai3[l3 + 1], a);
            }

            a.setColor(-1);
            canvas.drawLine(0.0F, f1 - (float)k3, f2, f1 - (float)k3, a);
            canvas.drawLine(j1, 0.0F, j1, f1, a);
            i1++;
        }

        float f3 = 10 + (int)(10L * Math.round((double)d / 10D));
        float f4 = -10 + (int)(10L * Math.round((double)f / 10D));
        float f5 = 10 + (int)(10L * Math.round((double)e / 10D));
        float f6 = -10 + (int)(10L * Math.round((double)g / 10D));
        float f7 = f3 - f4;
        float f8 = f5 - f6;
        int l1 = (int)((double)f7 / 10D);
        int i2 = (int)((double)f8 / 10D);
        int ai[] = new int[l1];
        int ai1[] = new int[i2];
        for(int j2 = 0; j2 < l1; j2++)
            ai[j2] = (int)(f4 + (float)(j2 * 10));

        for(int k2 = 0; k2 < i2; k2++)
            ai1[k2] = (int)(f6 + (float)(k2 * 10));

        if(k != 0)
        {
            a.setTextAlign(android.graphics.Paint.Align.CENTER);
            a.setTextSize(20F);
            for(int i3 = 0; i3 < ai.length; i3++)
            {
                CLASS167.MF_CLASS167_b635("Plot2d", (new StringBuilder()).append(" xsteps[i] = ").append(ai[i3]).toString());
                canvas.drawText((new StringBuilder()).append("").append(ai[i3]).toString(), a(f2, f, d, ai[i3]), 20F + (f1 - (float)k1), a);
            }

            for(int j3 = 0; j3 < ai1.length; j3++)
            {
                CLASS167.MF_CLASS167_b635("Plot2d", (new StringBuilder()).append(" ysteps[i] = ").append(ai1[j3]).toString());
                canvas.drawText((new StringBuilder()).append("").append(ai1[j3]).toString(), j1 - 20, f1 - (float)a(f1, g, e, ai1[j3]), a);
                a.setColor(0xff444444);
                canvas.drawLine(j1, a(f1, g, e, ai1[j3]), f2, a(f1, g, e, ai1[j3]), a);
                a.setColor(-1);
            }

        }
        a.setTextAlign(android.graphics.Paint.Align.RIGHT);
        a.setColor(-1);
        NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
        numberformat.setMinimumFractionDigits(1);
        numberformat.setMaximumFractionDigits(1);
        canvas.drawText((new StringBuilder()).append("Fs = ").append(numberformat.format(m)).append(" Hz").toString(), f2 - 30F, 30F, a);
        for(int l2 = 0; l2 < b.size(); l2++)
        {
            a.setColor(n[l2]);
            canvas.drawText(l[l2], f2 - 30F, 60 + l2 * 25, a);
        }

    }

    private Paint a;
    private ArrayList b;
    private ArrayList c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private String l[];
    private Float m;
    private int n[] = {
        0xffff0000, 0xff0000ff, 0xff00ff00, -65281, 0xff00ffff, -256
    };
}
