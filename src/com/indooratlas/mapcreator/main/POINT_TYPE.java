package com.indooratlas.mapcreator.main;


public enum POINT_TYPE 
{
	DEFAULT("DEFAULT", 0),
	FIRST_POINT("FIRST_POINT", 1),
	FIRST_POINT_GIVEN("FIRST_POINT_GIVEN", 2),
	SECOND_POINT("SECOND_POINT", 3),
	SECOND_POINT_GIVEN("SECOND_POINT_GIVEN", 4),
	RECORDING("RECORDING", 5),
	TEST_POINTS("TEST_POINTS", 6),
	POSITIONING("POSITIONING", 7);
 String sType;
 int iType;
 private POINT_TYPE(String s, int i)
 {
     sType = s;
     iType = i;
 }


 private static final POINT_TYPE MF_CLASS316_i903[];

 static 
 {
	 POINT_TYPE aclass316[] = new POINT_TYPE[8];
     aclass316[0] = DEFAULT;
     aclass316[1] = FIRST_POINT;
     aclass316[2] = FIRST_POINT_GIVEN;
     aclass316[3] = SECOND_POINT;
     aclass316[4] = SECOND_POINT_GIVEN;
     aclass316[5] = RECORDING;
     aclass316[6] = TEST_POINTS;
     aclass316[7] = POSITIONING;
     MF_CLASS316_i903 = aclass316;
 }
}
