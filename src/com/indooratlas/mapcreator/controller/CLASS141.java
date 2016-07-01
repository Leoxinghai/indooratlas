// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.controller;

import com.indooratlas.mapcreator.data.Measurement;
import com.indooratlas.mapcreator.main.MapScreen;

// Referenced classes of package com.indooratlas.mapcreator.controller:
//            RestClient

class CLASS141
    implements Runnable
{

    CLASS141(RestClient class181, Measurement class108)
    {
        MF_CLASS141_b538 = class181;
        MF_CLASS141_a539 = class108;

    }

    public void run()
    {
        RestClient.getMapScreen(MF_CLASS141_b538).markSegmentSent(MF_CLASS141_a539);
    }

    final Measurement MF_CLASS141_a539;
    final RestClient MF_CLASS141_b538;
}
