// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import com.indooratlas.position.CLASS75;
import java.io.PrintWriter;
import java.io.StringWriter;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS166, CLASS113, CLASS167, CLASS165

public class CLASS164
    implements Thread.UncaughtExceptionHandler
{

    public CLASS164(Activity activity)
    {
        MF_CLASS113_a486 = activity;
    }

    public void MF_CLASS113_a486(String s)
    {
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(MF_CLASS113_a486);
        builder.setMessage(s).setCancelable(false).setPositiveButton("Ok", new CLASS166(this));
        builder.create().show();
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("************ CAUSE OF ERROR ************\n\n");
        stringbuilder.append(stringwriter.toString());
        stringbuilder.append("\n************ DEVICE INFORMATION ***********\n");
        stringbuilder.append("Brand: ");
        stringbuilder.append(Build.BRAND);
        stringbuilder.append("\n");
        stringbuilder.append("Device: ");
        stringbuilder.append(Build.DEVICE);
        stringbuilder.append("\n");
        stringbuilder.append("Model: ");
        stringbuilder.append(Build.MODEL);
        stringbuilder.append("\n");
        stringbuilder.append("Id: ");
        stringbuilder.append(Build.ID);
        stringbuilder.append("\n");
        stringbuilder.append("Product: ");
        stringbuilder.append(Build.PRODUCT);
        stringbuilder.append("\n");
        stringbuilder.append("\n************ FIRMWARE ************\n");
        stringbuilder.append("SDK: ");
        stringbuilder.append(android.os.Build.VERSION.SDK);
        stringbuilder.append("\n");
        stringbuilder.append("Release: ");
        stringbuilder.append(android.os.Build.VERSION.RELEASE);
        stringbuilder.append("\n");
        stringbuilder.append("Incremental: ");
        stringbuilder.append(android.os.Build.VERSION.INCREMENTAL);
        stringbuilder.append("\n");
        stringbuilder.append("************ END OF REPORT ************\n\n");
        String s = stringbuilder.toString();
        if(CLASS113.isExceptionLogged.booleanValue())
            CLASS167.MF_CLASS167_b635("UncaughtEceptionHandler", (new StringBuilder()).append("fatal errorReport = ").append(stringbuilder).toString());
        CLASS75.MF_CLASS75_a259(6, "UncaughtException", CLASS164.class, (new StringBuilder()).append("Error : ").append(s).toString());
        try
        {
            Thread.currentThread();
            Thread.sleep(3000L);
        }
        catch(InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        MF_CLASS113_a486.runOnUiThread(new CLASS165(this));
    }

    private final Activity MF_CLASS113_a486;
    private final String MF_CLASS164_b631 = "\n";
}
