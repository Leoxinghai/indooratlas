package com.indooratlas.mapcreator.main;


import com.indooratlas.mapcreator.controller.CLASS167;

public class MathUtils
{

 public static double MF_CLASS320_a910(double d, double d1, double d2, double d3,
         double d4, double d5)
 {
     double d6 = d2 - d;
     double d7 = d3 - d1;
     double d8 = d4 - d;
     double d9 = d5 - d1;
     double d10 = d8 * d7 - d9 * d6;
     return (d10 * d10) / (d6 * d6 + d7 * d7);
 }

 public static double MF_CLASS320_a910(double ad[])
 {
     double d = 0.0D;
     for(int i = 0; i < ad.length; i++)
         d += ad[i] * ad[i];

     return Math.sqrt(d);
 }

 public static float angleBetween2Lines(float f, float f1, float f2, float f3, float f4, float f5, float f6, float f7)
 {
     CLASS167.MF_CLASS167_b635("MathUtils", (new StringBuilder()).append("angleBetween2Lines(): line1_Y1=").append(f2).append(",line1_Y2=").append(f3).append(",line1_X1=").append(f).append(",line1_X2=").append(f1).append(",line2_Y1=").append(f6).append(",line2_Y2=").append(f7).append(",line2_X1=").append(f4).append(",line2_X2=").append(f5).toString());
     float f8 = (float)Math.atan2(f2 - f3, f - f1);
     float f9 = (float)Math.atan2(f6 - f7, f4 - f5);
     float f10 = f8 - f9;
     CLASS167.MF_CLASS167_b635("MathUtils", (new StringBuilder()).append("angleBetween2Lines(): angle1 = ").append(Math.toDegrees(f8)).append(", angle2 = ").append(Math.toDegrees(f9)).append(", angleDiff = ").append(Math.toDegrees(f10)).toString());
     return f10;
 }

 public static double MF_CLASS320_b911(double d, double d1, double d2, double d3,
         double d4, double d5)
 {
     return Math.sqrt(MF_CLASS320_a910(d, d1, d2, d3, d4, d5));
 }
}
