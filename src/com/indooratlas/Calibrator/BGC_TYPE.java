package com.indooratlas.Calibrator;



public enum BGC_TYPE 
{
	BGC_IN_PROGRESS("BGC_IN_PROGRESS", 0),
	BGC_FAILED("BGC_FAILED", 1),
	BGC_READY("BGC_READY", 2),
	BGC_CONVERGED("BGC_CONVERGED", 3);

 private String sType;
 private int iType;
 private BGC_TYPE(String s, int i)
 {
 }


 private static final BGC_TYPE MF_CLASS16_e57[];

 static 
 {
	 BGC_TYPE aclass16[] = new BGC_TYPE[4];
     aclass16[0] = BGC_IN_PROGRESS;
     aclass16[1] = BGC_FAILED;
     aclass16[2] = BGC_READY;
     aclass16[3] = BGC_CONVERGED;
     MF_CLASS16_e57 = aclass16;
 }
}
