package com.indooratlas.task;

//CLASS57

public enum PositioningState 
{
	INACTIVE("INACTIVE", 0),
	INITIALIZING("INITIALIZING", 1),
	ACTIVE("ACTIVE", 2),
	STOPPING("STOPPING", 3);
	
 String sType;
 int iType;
 private PositioningState(String s, int i)
 {
 	sType = s;
 	iType = i;
 }

 private static final PositioningState MF_CLASS57_e208[];

 static 
 {
	 PositioningState aclass57[] = new PositioningState[4];
     aclass57[0] = INACTIVE;
     aclass57[1] = INITIALIZING;
     aclass57[2] = ACTIVE;
     aclass57[3] = STOPPING;
     MF_CLASS57_e208 = aclass57;
 }
}
