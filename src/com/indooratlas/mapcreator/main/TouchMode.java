package com.indooratlas.mapcreator.main;


public enum TouchMode
{
 NONE("NONE", 0),
 DRAG("DRAG", 1),
 ZOOM("ZOOM", 2);
 String sType;
 int iType;
 private TouchMode(String s, int i)
 {
     sType = s;
     iType = i;
 }
	

 private static final TouchMode MF_CLASS317_d907[];

 static 
 {
	 TouchMode aclass317[] = new TouchMode[3];
     aclass317[0] = NONE;
     aclass317[1] = DRAG;
     aclass317[2] = ZOOM;
     MF_CLASS317_d907 = aclass317;
 }
}
