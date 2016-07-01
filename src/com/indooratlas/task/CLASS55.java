// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.task;

import com.indooratlas.position.CLASS75;
import com.indooratlas.thread.client.IDeviceCheck;
import com.indooratlas.thread.server.WebsocketConnectionThread;
import com.xinghai.indoor.util.ReadStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.indooratlas.task:
//            RemoteImplementation

class CLASS55
    implements IDeviceCheck
{

    CLASS55(RemoteImplementation class50)
    {
        MF_CLASS55_a202 = class50;

    }

    public void onRequestComplete(int i, String s, int j, String s1, List list, String s2, Long long1,
            InputStream inputstream, String s3)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported onRequestComplete: url = ").append(s).append(", result = ").append(s1).append(", statusCode = ").append(j).toString());
        CLASS75.MF_CLASS75_a259(4, "DEVICE_MODEL_CHECK_OK", RemoteImplementation.class, "createCheckDeviceSupportTask.");
        RemoteImplementation.MF_CLASS19_a67(MF_CLASS55_a202, RemoteImplementation.MF_CLASS19_a67(MF_CLASS55_a202, s3));
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("ServerTimeString(completed): ").append(s3).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("serverTimeAtApiCreation(completed): ").append(RemoteImplementation.MF_CLASS25_f99(MF_CLASS55_a202)).toString());
        com.indooratlas.communication.be.DeviceModel devicemodel;
        int k;
        devicemodel = com.indooratlas.communication.be.DeviceModel.parseFrom(ReadStream.getInstance(inputstream));
        RemoteImplementation.MF_CLASS19_a67(MF_CLASS55_a202).MF_CLASS85_b316(devicemodel.getId());
        k = devicemodel.getSupportStatus();
        if(k != 1 && k != 0) {
        	RemoteImplementation.MF_CLASS369_b995(MF_CLASS55_a202, null);
        }
        
        RemoteImplementation.MF_CLASS369_b995(MF_CLASS55_a202, devicemodel.getId());
        RemoteImplementation.MF_CLASS369_b995(MF_CLASS55_a202, true);
        CLASS75.MF_CLASS75_b260("RemoteImplementation", "Device type check complete.");
        return;
    }

    public void checkDeviceSupported(int i, String s, int j, String s1, List list, String s2, String s3)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported: onRequestFailed ").append(j).append(", result = ").append(s1).append(", statusCode = ").append(j).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("ServerTimeString(failed): ").append(s3).toString());
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("serverTimeAtApiCreation(failed): ").append(RemoteImplementation.MF_CLASS25_f99(MF_CLASS55_a202)).toString());
        CLASS75.MF_CLASS75_a259(5, "DEVICE_MODEL_CHECK_FAILED", RemoteImplementation.class, "createCheckDeviceSupportTask, onRequestFailed");
        RemoteImplementation.MF_CLASS19_a67(MF_CLASS55_a202, RemoteImplementation.MF_CLASS19_a67(MF_CLASS55_a202, s3));
        RemoteImplementation.MF_CLASS46_g163(MF_CLASS55_a202);
        if(RemoteImplementation.MF_CLASS50_i178(MF_CLASS55_a202) < 5)
            RemoteImplementation.S_SendDeviceModelCheck(MF_CLASS55_a202);
    }

    public void onRequestTimeout(int i, String s, int j, List list, String s1)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported: onRequestTimeout ").append(j).toString());
        CLASS75.MF_CLASS75_a259(5, "DEVICE_MODEL_CHECK_FAILED", RemoteImplementation.class, "createCheckDeviceSupportTask, onRequestTimeout");
        RemoteImplementation.MF_CLASS46_g163(MF_CLASS55_a202);
        RemoteImplementation.S_SendDeviceModelCheck(MF_CLASS55_a202);
    }

    public void checkDeviceSupported(int i, String s, List list, String s1)
    {
        CLASS75.MF_CLASS75_b260("RemoteImplementation", (new StringBuilder()).append("checkDeviceSupported onRequestStarted : url = ").append(s).toString());
    }

    final RemoteImplementation MF_CLASS55_a202;
}
