// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.content.DialogInterface;
import android.os.AsyncTask;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.CLASS103;
import com.indooratlas.mapcreator.data.GraphicsImage;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            CLASS309, MapScreen

class CLASS233
    implements android.content.DialogInterface.OnClickListener
{

    CLASS233(MapScreen mapscreen)
    {
        MF_CLASS233_a779 = mapscreen;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        CLASS167.MF_CLASS167_b635("MapScreen", "showImageDownloadRetryDialog : RETRY clicked --> creating download task");
        MF_CLASS233_a779.MF_CLASS19_b68 = new DownloadImageTask(MF_CLASS233_a779, MapScreen.getIndoorMapView(MF_CLASS233_a779));
        DownloadImageTask class309 = MF_CLASS233_a779.MF_CLASS19_b68;
        java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        String as[] = new String[1];
        as[0] = MF_CLASS233_a779.mGraphics.getGraphicImage().getImageUrl();
        class309.executeOnExecutor(executor, as);
        dialoginterface.cancel();
    }

    final MapScreen MF_CLASS233_a779;
}
