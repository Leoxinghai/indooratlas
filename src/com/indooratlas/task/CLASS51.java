// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.task;

import android.content.Context;
import com.indooratlas.thread.server.WebsocketConnectionThread;

// Referenced classes of package com.indooratlas.task:
//            CLASS42, RemoteImplementation, CLASS41

class CLASS51
    implements Runnable
{

    CLASS51(RemoteImplementation class50, CLASS42 class42, Context context)
    {
    	mRemoteImpl = class50;
        MF_CLASS51_a197 = class42;
        MF_CLASS51_b198 = context;

    }

    public void run()
    {
        if(MF_CLASS51_a197.MF_CLASS42_a150().length() > 10 && RemoteImplementation.MF_CLASS19_a67(mRemoteImpl) == null)
            RemoteImplementation.MF_CLASS19_a67(mRemoteImpl, WebsocketConnectionThread.MF_CLASS85_a315(RemoteImplementation.MF_CLASS369_b995(mRemoteImpl), MF_CLASS51_b198, MF_CLASS51_a197, RemoteImplementation.MF_CLASS19_c69(mRemoteImpl), CLASS41.locationService));
        if(RemoteImplementation.MF_CLASS19_a67(mRemoteImpl) != null)
            RemoteImplementation.MF_CLASS19_a67(mRemoteImpl).MF_CLASS85_a315(RemoteImplementation.getIndoorAltas(mRemoteImpl), RemoteImplementation.MF_CLASS369_b995(mRemoteImpl));
    }

    final CLASS42 MF_CLASS51_a197;
    final Context MF_CLASS51_b198;
    final RemoteImplementation mRemoteImpl;
}
