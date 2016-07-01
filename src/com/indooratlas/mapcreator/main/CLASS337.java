// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.indooratlas.mapcreator.controller.CLASS167;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            Sipa, PrefsActivity, CLASS344

class CLASS337
    implements android.content.DialogInterface.OnClickListener
{

    CLASS337(Sipa sipa)
    {
        MF_CLASS337_a933 = sipa;

    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() onClick ");
        if(i == 0) {
	        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() onClick item == 0");
	        MF_CLASS337_a933.j = true;
	        Intent intent = new Intent(MF_CLASS337_a933.k, PrefsActivity.class);
	        intent.setFlags(0x40000000);
	        MF_CLASS337_a933.startActivity(intent);
        } else if( i==1 ){
            try
            {
                CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() onClick item == 1");
                (new DumpDBTask(MF_CLASS337_a933)).execute(new Void[0]);
            }
            catch(Exception exception)
            {
                CLASS167.unhandledexception(exception, MF_CLASS337_a933.getApplicationContext());
                return;
            }
        } else if(i == 2) {
	        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() onClick item == 2");
	        Sipa.MF_CLASS179_a653(MF_CLASS337_a933);
        } else if(i == 3) {
	        Iterator iterator = ((SensorManager)MF_CLASS337_a933.k.getSystemService("sensor")).getSensorList(-1).iterator();
	        String s = "";
	        while(iterator.hasNext())
	        {
	            Sensor sensor = (Sensor)iterator.next();
	            CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).toString());
	            s = (new StringBuilder()).append(s).append("Sensor: name = ").append(sensor.getName()).append(", type = ").append(sensor.getType()).append(", vendor = ").append(sensor.getVendor()).append(", maxRange = ").append(sensor.getMaximumRange()).append(", resolution = ").append(sensor.getResolution()).append(", power = ").append(sensor.getPower()).append("\n\n").toString();
	        }
	        MF_CLASS337_a933.showInformationDialog(s);
        } else if(i == 4) {
	        StringBuilder stringbuilder = new StringBuilder();
	        stringbuilder.append("android.os.Build.BOARD = ").append(Build.BOARD).append("\n");
	        stringbuilder.append("android.os.Build.BOOTLOADER = ").append(Build.BOOTLOADER).append("\n");
	        stringbuilder.append("android.os.Build.BRAND = ").append(Build.BRAND).append("\n");
	        stringbuilder.append("android.os.Build.CPU_ABI = ").append(Build.CPU_ABI).append("\n");
	        stringbuilder.append("android.os.Build.CPU_ABI2 = ").append(Build.CPU_ABI2).append("\n");
	        stringbuilder.append("android.os.Build.DEVICE = ").append(Build.DEVICE).append("\n");
	        stringbuilder.append("android.os.Build.DISPLAY = ").append(Build.DISPLAY).append("\n");
	        stringbuilder.append("android.os.Build.FINGERPRINT = ").append(Build.FINGERPRINT).append("\n");
	        stringbuilder.append("android.os.Build.HARDWARE = ").append(Build.HARDWARE).append("\n");
	        stringbuilder.append("android.os.Build.HOST = ").append(Build.HOST).append("\n");
	        stringbuilder.append("android.os.Build.ID = ").append(Build.ID).append("\n");
	        stringbuilder.append("android.os.Build.MANUFACTURER = ").append(Build.MANUFACTURER).append("\n");
	        stringbuilder.append("android.os.Build.MODEL = ").append(Build.MODEL).append("\n");
	        stringbuilder.append("android.os.Build.PRODUCT = ").append(Build.PRODUCT).append("\n");
	        stringbuilder.append("android.os.Build.RADIO = ").append(Build.RADIO).append("\n");
	        stringbuilder.append("android.os.Build.SERIAL = ").append(Build.SERIAL).append("\n");
	        stringbuilder.append("android.os.Build.TAGS = ").append(Build.TAGS).append("\n");
	        stringbuilder.append("android.os.Build.TIME = ").append(Build.TIME).append("\n");
	        stringbuilder.append("android.os.Build.TYPE = ").append(Build.TYPE).append("\n");
	        stringbuilder.append("android.os.Build.USER = ").append(Build.USER).append("\n");
	        stringbuilder.append("android.os.Build.getRadioVersion() = ").append(Build.getRadioVersion()).append("\n");
	        stringbuilder.append("android.os.Build.VERSION.CODENAME = ").append(android.os.Build.VERSION.CODENAME).append("\n");
	        stringbuilder.append("android.os.Build.VERSION.INCREMENTAL = ").append(android.os.Build.VERSION.INCREMENTAL).append("\n");
	        stringbuilder.append("android.os.Build.VERSION.RELEASE = ").append(android.os.Build.VERSION.RELEASE).append("\n");
	        stringbuilder.append("android.os.Build.VERSION.SDK = ").append(android.os.Build.VERSION.SDK).append("\n");
	        stringbuilder.append("android.os.Build.VERSION.SDK_INT = ").append(android.os.Build.VERSION.SDK_INT).append("\n");
	        stringbuilder.append("android.os.Build.VERSION.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 = ").append(15).append("\n");
	        String s1 = stringbuilder.toString();
	        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("Version Info : \n").append(s1).toString());
	        MF_CLASS337_a933.showInformationDialog(s1);
        } else if(i == 5) {
	        Sensor sensor1;
	        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog() onClick item == 5");
	        SensorManager sensormanager = (SensorManager)MF_CLASS337_a933.k.getSystemService("sensor");
	        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog: checking uncalibrated mgn sensor");
	        if(android.os.Build.VERSION.SDK_INT < 18) {
		        MF_CLASS337_a933.showInformationDialog("No raw Mgn sensor found!");
	        } else {
		        sensor1 = sensormanager.getDefaultSensor(14);
		        CLASS167.MF_CLASS167_b635("Sipa", (new StringBuilder()).append("showDeveloperMenuDialog: got uncalibrated mgn sensor = ").append(sensor1).toString());
		        if(sensor1 != null) {
			        MF_CLASS337_a933.showInformationDialog("Raw Mgn sensor found!");
		        } else {
			        CLASS167.MF_CLASS167_b635("Sipa", "showDeveloperMenuDialog: PLATFORM WAS > 4.3, BUT sensor == null");
			        MF_CLASS337_a933.showInformationDialog("No raw Mgn sensor found.");
		        }
	        }
        }

        dialoginterface.cancel();
        return;
    }

    final Sipa MF_CLASS337_a933;
}
