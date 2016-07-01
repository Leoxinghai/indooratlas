package com.indooratlas.wifiroaming;


import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.os.SystemClock;
import java.util.Date;

//Referenced classes of package com.indooratlas.wifiroaming:
//         CLASS382, WifiRoamingScanReceiver, CLASS198

class ScanResultPoller extends CountDownTimer
{

	ScanResultPoller(WifiRoamingScanReceiver wifiroamingscanreceiver, long l, long l1)
 {
     super(l, l1);
     MF_CLASS383_a1115 = wifiroamingscanreceiver;
 }

 public void onFinish()
 {
     CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "mScanResultPoller.onFinish(): polling stopped...");
     MF_CLASS383_a1115.b.infoMessage((new StringBuilder("Result poller: stopped : ")).append(new Date()).toString());
 }

 public void onTick(long l)
 {
     long l1 = SystemClock.elapsedRealtime() - MF_CLASS383_a1115.d;
     CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", (new StringBuilder("mScanResultPoller.onTick(): elapsedSinceLastScanResults = ")).append(l1).toString());
     if(l1 > 3000L)
     {
         CLASS382.MF_CLASS382_a1114("WifiRoamingScanReceiver", "mScanResultPoller.onTick(): initiating scan!");
         MF_CLASS383_a1115.b.infoMessage((new StringBuilder("Result poller: Scan initiated : ")).append(new Date()).toString());
         MF_CLASS383_a1115.MF_null_a1.startScan();
     }
 }

 final WifiRoamingScanReceiver MF_CLASS383_a1115;
}
