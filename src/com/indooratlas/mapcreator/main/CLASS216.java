// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

package com.indooratlas.mapcreator.main;

import android.widget.Toast;
import com.indooratlas.mapcreator.controller.CLASS113;
import com.indooratlas.mapcreator.controller.CLASS167;
import com.indooratlas.mapcreator.data.CLASS101;
import com.indooratlas.position.CLASS75;
import com.indooratlas.thread.client.IDeviceCheck;
import com.xinghai.indoor.util.ReadStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.indooratlas.communication.*;

// Referenced classes of package com.indooratlas.mapcreator.main:
//            LoginActivity, CLASS217

class CLASS216
    implements IDeviceCheck
{

    CLASS216(LoginActivity loginactivity)
    {
        MF_CLASS113_a486 = loginactivity;

    }

    public void onRequestComplete(int i, String s, int j, String s1, List list, String s2, Long long1,
            InputStream inputstream, String s3)
    {
        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported onRequestComplete: url = ").append(s).append(", result = ").append(s1).append(", statusCode = ").append(j).toString());
        int k;
        ReadStream readstream = ReadStream.getInstance(inputstream);
//        LoginActivity.MF_CLASS19_a67(MF_CLASS113_a486, new CLASS101(be.DeviceModel.parseFrom(readstream)));
//        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported : mDeviceModel = ").append(LoginActivity.MF_CLASS19_b68(MF_CLASS113_a486).MF_CLASS101_b389()).append(", mDeviceModel.getId = ").append(LoginActivity.MF_CLASS19_b68(MF_CLASS113_a486).MF_CLASS101_a388()).toString());
//        CLASS75.MF_CLASS75_a259(4, "DEVICE_MODEL_CHECK_OK", MF_CLASS113_a486.f.getClass(), (new StringBuilder()).append("checkDeviceSupported, device : ").append(LoginActivity.MF_CLASS19_b68(MF_CLASS113_a486).MF_CLASS101_c390()).toString());
//        k = LoginActivity.MF_CLASS19_b68(MF_CLASS113_a486).MF_CLASS101_d391();
       k=1;
        if(k == 1 || k == 0)
        {
            try
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    MF_CLASS113_a486.f.runOnUiThread(new CLASS217(this));
                LoginActivity.startSipa(MF_CLASS113_a486);
                return;
            }
            catch(Exception ioexception)
            {
                if(CLASS113.isExceptionLogged.booleanValue())
                    ioexception.printStackTrace();
            }
            LoginActivity.MF_CLASS19_d70(MF_CLASS113_a486);
            return;
        }
        Toast.makeText(MF_CLASS113_a486.f, "Your device is not officially supported by IndoorAtlas. You may still try it out.", 1).show();
        LoginActivity.startSipa(MF_CLASS113_a486);
        return;
    }

    public void checkDeviceSupported(int i, String s, int j, String s1, List list, String s2, String s3)
    {
        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported: onRequestFailed ").append(j).append(", result = ").append(s1).append(", statusCode = ").append(j).toString());
        LoginActivity.MF_CLASS19_d70(MF_CLASS113_a486);
    }

    public void onRequestTimeout(int i, String s, int j, List list, String s1)
    {
        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported: onRequestTimeout ").append(j).toString());
        LoginActivity.MF_CLASS19_d70(MF_CLASS113_a486);
    }

    public void checkDeviceSupported(int i, String s, List list, String s1)
    {
        CLASS167.MF_CLASS167_b635(LoginActivity.MF_CLASS19_a67, (new StringBuilder()).append("checkDeviceSupported onRequestStarted : url = ").append(s).toString());
    }

    final LoginActivity MF_CLASS113_a486;
}
