package com.indooratlas.Calibrator;


public class CalibrationEvent
{

 public CalibrationEvent(CLASS19 class19, int i, double ad[], long l, long l1, 
         long l2)
 {
     MF_CLASS18_b62 = 0;
     MF_CLASS18_d64 = 0L;
     MF_CLASS18_e65 = 0L;
     MF_CLASS18_f66 = 0L;
     MF_CLASS18_a61 = class19;
     MF_CLASS18_b62 = i;
     MF_CLASS18_c63 = ad;
     MF_CLASS18_d64 = l;
     MF_CLASS18_e65 = l1;
     MF_CLASS18_f66 = l2;
 }

 public CLASS19 getCalibrationStatus()
 {
     return MF_CLASS18_a61;
 }

 public void MF_CLASS18_a61(long l)
 {
     MF_CLASS18_f66 = l;
 }

 public int MF_CLASS18_b62()
 {
     return MF_CLASS18_b62;
 }

 public double[] MF_CLASS18_c63()
 {
     return MF_CLASS18_c63;
 }

 public long MF_CLASS18_d64()
 {
     return MF_CLASS18_d64;
 }

 public long MF_CLASS18_e65()
 {
     return MF_CLASS18_e65;
 }

 public long MF_CLASS18_f66()
 {
     return MF_CLASS18_f66;
 }

 public String toString()
 {
     StringBuilder stringbuilder = new StringBuilder();
     stringbuilder.append(MF_CLASS18_a61).append(", ").append(MF_CLASS18_b62).append(", ").append("b_x = ").append(MF_CLASS18_c63[0]).append(", ").append("b_y = ").append(MF_CLASS18_c63[1]).append(", ").append("b_z = ").append(MF_CLASS18_c63[2]).append(", ").append("currentDurationMS = ").append(MF_CLASS18_d64);
     return stringbuilder.toString();
 }

 CLASS19 MF_CLASS18_a61;
 int MF_CLASS18_b62;
 double MF_CLASS18_c63[] = {
     0.0D, 0.0D, 0.0D
 };
 long MF_CLASS18_d64;
 long MF_CLASS18_e65;
 long MF_CLASS18_f66;
}
