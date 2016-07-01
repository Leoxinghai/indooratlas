package com.indooratlas.position;



import android.content.Context;
import com.indooratlas.task.CLASS46;

//Referenced classes of package com.indooratlas.position:
//         CLASS75

public class PositioningStats
{

 public PositioningStats(Context context)
 {
     MF_CLASS46_a157 = 0L;
     MF_CLASS73_b239 = 0.0D;
     mMinRT = 1.7976931348623157E+308D;
     mMaxRT = 4.9406564584124654E-324D;
     MF_CLASS73_e242 = 0L;
     MF_CLASS46_f162 = 0.0D;
     mMinQ = 1.7976931348623157E+308D;
     mMaxQ = 4.9406564584124654E-324D;
     MF_CLASS73_i246 = 0L;
     MF_CLASS73_j247 = 0L;
     MF_CLASS73_k248 = -1;
     MF_CLASS73_l249 = 0L;
     MF_CLASS73_m250 = 0L;
     MF_CLASS73_n251 = context;
 }

 public void MF_CLASS46_a157()
 {
     MF_CLASS73_i246 = 1L + MF_CLASS73_i246;
 }

 public void MF_CLASS46_a157(float f)
 {
     if((double)f > mMaxRT)
     	mMaxRT = f;
     if((double)f < mMinRT)
     	mMinRT = f;
     MF_CLASS73_b239 = MF_CLASS73_b239 + (double)f;
     MF_CLASS46_a157 = 1L + MF_CLASS46_a157;
     double d = MF_CLASS73_b239 / (double)MF_CLASS46_a157;
     CLASS75.MF_CLASS75_b260("PositioningStats", (new StringBuilder()).append("addRoundtrip: maxRoundtrip = ").append(mMaxRT).append(", minRoundtrip = ").append(mMinRT).append(", avgRoundtrip = ").append(d).toString());
 }

 public void MF_CLASS46_a157(int i)
 {
     MF_CLASS73_k248 = i;
 }

 public void MF_CLASS46_a157(long l)
 {
     MF_CLASS73_l249 = l;
 }

 public long retransmitCount()
 {
     return MF_CLASS73_i246;
 }

 public void MF_CLASS73_b239(float f)
 {
     if((double)f > mMaxQ)
     	mMaxQ = f;
     if((double)f < mMinQ)
     	mMinQ = f;
     MF_CLASS46_f162 = MF_CLASS46_f162 + (double)f;
     MF_CLASS73_e242 = 1L + MF_CLASS73_e242;
     CLASS46 class46 = CLASS75.getNetworkStatus(MF_CLASS73_n251);
     if(class46.mMobileConnected)
         MF_CLASS73_o252 = 1 + MF_CLASS73_o252;
     else
         MF_CLASS73_q254 = 1 + MF_CLASS73_q254;
     if(class46.mWifiConnected)
     {
         MF_CLASS73_p253 = 1 + MF_CLASS73_p253;
         return;
     } else
     {
         MF_CLASS73_r255 = 1 + MF_CLASS73_r255;
         return;
     }
 }

 public void MF_CLASS73_b239(long l)
 {
     MF_CLASS73_m250 = l;
 }

 public void MF_CLASS73_c240()
 {
     MF_CLASS73_j247 = 1L + MF_CLASS73_j247;
 }

 public long createRetransmitCount()
 {
     return MF_CLASS73_j247;
 }

 public double getAvgRoundtrip()
 {
     double d = MF_CLASS73_b239 / (double)MF_CLASS46_a157;
     CLASS75.MF_CLASS75_b260("PositioningStats", (new StringBuilder()).append("getAvgRoundtrip: returning : ").append(d).toString());
     return d;
 }

 public double getAvgQueueLen()
 {
     double d = MF_CLASS46_f162 / (double)MF_CLASS73_e242;
     CLASS75.MF_CLASS75_b260("PositioningStats", (new StringBuilder()).append("getAvgQueueLen: returning : ").append(d).toString());
     return d;
 }

 public double minRT()
 {
     return mMinRT;
 }

 public double maxRT()
 {
     return mMaxRT;
 }

 public double minQ()
 {
     return mMinQ;
 }

 public double maxQ()
 {
     return mMaxQ;
 }

 public int seqNumOfFirstPosition()
 {
     return MF_CLASS73_k248;
 }

 public long connectTook()
 {
     return MF_CLASS73_m250;
 }

 public long initTook()
 {
     return MF_CLASS73_l249;
 }

 private long MF_CLASS46_a157;
 private double MF_CLASS73_b239;
 private double mMinRT;
 private double mMaxRT;
 private long MF_CLASS73_e242;
 private double MF_CLASS46_f162;
 private double mMinQ;
 private double mMaxQ;
 private long MF_CLASS73_i246;
 private long MF_CLASS73_j247;
 private int MF_CLASS73_k248;
 private long MF_CLASS73_l249;
 private long MF_CLASS73_m250;
 private Context MF_CLASS73_n251;
 private int MF_CLASS73_o252;
 private int MF_CLASS73_p253;
 private int MF_CLASS73_q254;
 private int MF_CLASS73_r255;
}
