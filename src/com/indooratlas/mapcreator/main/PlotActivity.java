// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.indooratlas.mapcreator.controller.CLASS167;
import java.util.ArrayList;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Plot2D

public class PlotActivity extends Activity
{

    public PlotActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(-2, -2);
        ArrayList arraylist = (ArrayList)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.xvalues");
        ArrayList arraylist1 = (ArrayList)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.yvalues");
        String as[] = (String[])(String[])getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.legends");
        Float float1 = (Float)getIntent().getSerializableExtra("com.indooratlas.mapcreator.main.samplefreq");
        CLASS167.MF_CLASS167_b635("PlotActivity", (new StringBuilder()).append("PlotActivity.onCreate(): got from bundle: xManySeries.size() = ").append(arraylist.size()).toString());
        CLASS167.MF_CLASS167_b635("PlotActivity", (new StringBuilder()).append("PlotActivity.onCreate(): got from bundle: yManySeries.size() = ").append(arraylist1.size()).toString());
        linearlayout.addView(new Plot2D(this, arraylist, arraylist1, 1, as, float1), layoutparams);
        setContentView(linearlayout);
    }
}
