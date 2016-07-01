// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            CLASS167

public class CLASS169
{

    public static void MF_CLASS169_a637(Context context)
    {
        MF_CLASS169_a637(PreferenceManager.getDefaultSharedPreferences(context));
    }

    private static void MF_CLASS169_a637(SharedPreferences sharedpreferences)
    {
        double d = sharedpreferences.getInt("key_preferences_version", 1);
        if(d < 2D)
        {
            CLASS167.MF_CLASS167_b635("VersionManager", (new StringBuilder()).append("checkPreferences(): oldVersion = ").append(d).append(", upgrading to version ").append(2).toString());
            if(d == 1.0D)
            {
                android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("first_usage_calib_done", "");
                editor.putInt("key_preferences_version", 2);
                editor.commit();
            }
        }
    }
}
