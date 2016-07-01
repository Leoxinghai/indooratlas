// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import com.indooratlas.mapcreator.controller.CLASS167;
import java.util.*;

public class PrefsActivity extends PreferenceActivity
{

    public PrefsActivity()
    {
    }

    protected void a(String s)
    {
        CLASS167.MF_CLASS167_b635("PrefsActivity", "setListPreferenceData : setting list preference data");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        CLASS167.MF_CLASS167_b635("PrefsActivity", " -lifecycle- PrefsActivity.onCreate");
        addPreferencesFromResource(0x7f040000);
        a("Requesting available algs ongoing...");
    }

    protected void onDestroy()
    {
        CLASS167.MF_CLASS167_b635("PrefsActivity", " -lifecycle- PrefsActivity.onDestroy");
        super.onDestroy();
    }

    protected void onPause()
    {
        CLASS167.MF_CLASS167_b635("PrefsActivity", " -lifecycle- PrefsActivity.onPause");
        super.onPause();
        java.util.Map.Entry entry;
        for(Iterator iterator = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getAll().entrySet().iterator(); iterator.hasNext(); CLASS167.MF_CLASS167_b635("PrefsActivity", (new StringBuilder()).append("onPause(): PREF: ").append((String)entry.getKey()).append(": ").append(entry.getValue().toString()).toString()))
            entry = (java.util.Map.Entry)iterator.next();

    }

    protected void onRestart()
    {
        CLASS167.MF_CLASS167_b635("PrefsActivity", " -lifecycle- PrefsActivity.onRestart");
        super.onRestart();
    }

    public void onResume()
    {
        CLASS167.MF_CLASS167_b635("PrefsActivity", " -lifecycle- PrefsActivity.onResume");
        super.onResume();
    }
}
