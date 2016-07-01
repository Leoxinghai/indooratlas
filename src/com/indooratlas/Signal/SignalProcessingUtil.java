package com.indooratlas.Signal;


import com.indooratlas.position.CLASS75;
import java.util.Arrays;

//CLASS67

public class SignalProcessingUtil
{

 public static boolean outlierDetection(double ad[], double ad1[], long l, long l1, double d,
         long l2)
 {
     double d1 = Math.abs(ad1[0] - ad[0]);
     double d2 = Math.abs(ad1[1] - ad[1]);
     double d3 = Math.abs(ad1[2] - ad[2]);
     boolean flag;
     if(l - l1 > l2)
     {
         flag = false;
     } else
     {
//         int i = d1 != d;
     	 double i = d1;
         flag = false;
         //if(i > 0)
         if(d1 > d)
         {
             CLASS75.MF_CLASS75_b260("SignalProcessingUtil", (new StringBuilder()).append("outlierDetection: X delta mgn > TH = ").append(d1).append(", prevValues = ").append(Arrays.toString(ad1)).append(", curValues = ").append(Arrays.toString(ad)).toString());
             ad[0] = ad1[0];
             flag = true;
         }
         if(d2 > d)
         {
             CLASS75.MF_CLASS75_b260("SignalProcessingUtil", (new StringBuilder()).append("outlierDetection: Y delta mgn > TH = ").append(d2).append(", prevValues = ").append(Arrays.toString(ad1)).append(", curValues = ").append(Arrays.toString(ad)).toString());
             ad[1] = ad1[1];
             flag = true;
         }
         if(d3 > d)
         {
             CLASS75.MF_CLASS75_b260("SignalProcessingUtil", (new StringBuilder()).append("outlierDetection: Z delta mgn > TH = ").append(d3).append(", prevValues = ").append(Arrays.toString(ad1)).append(", curValues = ").append(Arrays.toString(ad)).toString());
             ad[2] = ad1[2];
             return true;
         }
     }
     return flag;
 }
}
