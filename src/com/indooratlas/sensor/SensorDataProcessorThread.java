package com.indooratlas.sensor;


import com.indooratlas.cursor.list.CLASS24;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.RemoteImplementation;
import com.indooratlas.types.IndoorAtlas;
import java.util.concurrent.ConcurrentLinkedQueue;

//Referenced classes of package com.indooratlas.sensor:
//         CLASS376

public class SensorDataProcessorThread extends Thread
{

 public SensorDataProcessorThread(SensorReader class376, IndoorAtlas some3eventbase)
 {
	 isRunning = true;
     setName("SensorDataProcessorThread");
     mSensorReader = class376;
     mRemoteImpl = (RemoteImplementation)some3eventbase;
 }

 public void stopSensorDataProcessor()
 {
	 isRunning = false;
 }

 public void run()
 {
     CLASS75.MF_CLASS75_b260("SensorDataProcessorThread", "SensorDataProcessorThread.run(): started");
     while(mRemoteImpl.MF_CLASS50_k180() && isRunning)
         try
         {
             if(mSensorReader.collectDataQueue.size() > 0)
             {
                 CLASS24 class24 = (CLASS24)mSensorReader.collectDataQueue.poll();
                 mRemoteImpl.notifySensorDataPackage(class24);
             }
             Thread.sleep(25L);
         }
         catch(InterruptedException interruptedexception) { }
     CLASS75.MF_CLASS75_b260("SensorDataProcessorThread", "SensorDataProcessorThread.run(): stopped, returning, dying...");
 }

 SensorReader mSensorReader;
 RemoteImplementation mRemoteImpl;
 private boolean isRunning;
}
