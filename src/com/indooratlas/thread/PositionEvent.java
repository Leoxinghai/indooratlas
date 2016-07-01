package com.indooratlas.thread;

//CLASS97
import android.os.SystemClock;

public class PositionEvent
{

 public PositionEvent(com.indooratlas.communication.positioning_request.PositioningRequest positioningrequest, int i)
 {
     MF_CLASS97_d357 = 0L;
     MF_CLASS97_e358 = 0L;
     MF_CLASS97_b355 = positioningrequest;
     MF_CLASS97_a354 = i;
 }

 public int MF_CLASS97_a354()
 {
     if(MF_CLASS97_d357 > 0L && MF_CLASS97_e358 > 0L)
         return (int)(MF_CLASS97_e358 - MF_CLASS97_d357);
     else
         return -1;
 }

 public void MF_CLASS97_a354(float f)
 {
     MF_CLASS97_c356 = f;
 }

 public void MF_CLASS97_a354(long l)
 {
     MF_CLASS97_e358 = l;
 }

 public void MF_CLASS97_a354(com.indooratlas.communication.positioning_response.PositioningResponse positioningresponse)
 {
     MF_CLASS97_f359 = positioningresponse;
 }

 public void MF_CLASS97_b355()
 {
     MF_CLASS97_d357 = SystemClock.elapsedRealtime();
 }

 public int MF_CLASS97_c356()
 {
     return MF_CLASS97_a354;
 }

 public com.indooratlas.communication.positioning_request.PositioningRequest MF_CLASS97_d357()
 {
     return MF_CLASS97_b355;
 }

 public com.indooratlas.communication.positioning_response.PositioningResponse MF_CLASS97_e358()
 {
     return MF_CLASS97_f359;
 }

 private final int MF_CLASS97_a354;
 private final com.indooratlas.communication.positioning_request.PositioningRequest MF_CLASS97_b355;
 private float MF_CLASS97_c356;
 private long MF_CLASS97_d357;
 private long MF_CLASS97_e358;
 private com.indooratlas.communication.positioning_response.PositioningResponse MF_CLASS97_f359;
}
