package com.indooratlas.mapcreator.main;



public enum FIRSTSECOND_POINT 
{
	FIRST_POINT("FIRST_POINT", 0),
	SECOND_POINT("SECOND_POINT", 1),
	NONE("NONE", 2);

 private FIRSTSECOND_POINT(String s, int i)
 {
     sType = s;
     iType = i;
 }
 
 private String sType;
 private int iType;

 private static final FIRSTSECOND_POINT MF_CLASS366_d983[];

 static 
 {
	 FIRSTSECOND_POINT aclass366[] = new FIRSTSECOND_POINT[3];
     aclass366[0] = FIRST_POINT;
     aclass366[1] = SECOND_POINT;
     aclass366[2] = NONE;
     MF_CLASS366_d983 = aclass366;
 }
}
