// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.EditText;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.controller.MeasurementDataSource;
import com.indooratlas.mapcreator.data.Measurement;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            MapScreen, CLASS319

class CLASS269
    implements android.content.DialogInterface.OnClickListener
{

    CLASS269(MapScreen mapscreen, EditText edittext)
    {
        MF_CLASS269_b823 = mapscreen;
        MF_CLASS269_a824 = edittext;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = MF_CLASS269_a824.getText().toString();
        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("showEnterLabelDialog(): storing label = ").append(s).toString());
        MapScreen.currentMeasurement.mLabel = s;
        MeasurementDataSource.updateMeasurement(MapScreen.currentMeasurement);
        CLASS319 class319 = new CLASS319(MF_CLASS269_b823);
        java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Measurement aclass108[] = new Measurement[1];
        aclass108[0] = MapScreen.currentMeasurement;
        class319.executeOnExecutor(executor, aclass108);
        dialoginterface.cancel();
    }

    final EditText MF_CLASS269_a824;
    final MapScreen MF_CLASS269_b823;
}
