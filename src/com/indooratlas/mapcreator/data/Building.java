package com.indooratlas.mapcreator.data;


import java.io.Serializable;

//Referenced classes of package com.indooratlas.mapcreator.data:
//         CLASS102

public class Building
 implements Serializable
{

	public Building() {
		this.mBuildingID = "20151228";
	}

 public Building(com.indooratlas.communication.cmn.Building building)
 {
 	mBuildingID = "";
     MF_CLASS99_j377 = "";
     MF_CLASS99_k378 = "";
     MF_CLASS99_l379 = "";
     MF_CLASS99_m380 = "";
     MF_CLASS99_n381 = "";
     mPosition = null;
     MF_CLASS99_p383 = false;
     if(building.hasId())
    	 setBuildingID(building.getId());
     if(building.hasUrl())
         MF_CLASS99_b371(building.getUrl());
     if(building.hasLevelsUrl())
         MF_CLASS99_c372(building.getLevelsUrl());
     if(building.hasName())
         MF_CLASS99_d373(building.getName());
     if(building.hasAddress())
         MF_CLASS99_e374(building.getAddress());
     if(building.hasDescription())
         MF_CLASS99_f375(building.getDescription());
     if(building.hasPosition())
    	 setPosition(new CLASS102(building.getPosition().getLatitude(), building.getPosition().getLongitude()));
     if(building.hasIsPrivate())
         MF_CLASS99_a370(building.getIsPrivate());
 }

 public Building setPosition(CLASS102 class102)
 {
     if(class102 == null)
     {
         throw new NullPointerException();
     } else
     {
         MF_CLASS99_g384 = true;
         mPosition = class102;
         return this;
     }
 }

 public Building setBuildingID(String s)
 {
	 hasBuildingID = true;
     mBuildingID = s;
     return this;
 }

 public Building MF_CLASS99_a370(boolean flag)
 {
     MF_CLASS99_h385 = true;
     MF_CLASS99_p383 = flag;
     return this;
 }

 public String getBuildingID()
 {
     return mBuildingID;
 }

 public Building MF_CLASS99_b371(String s)
 {
     MF_CLASS99_b371 = true;
     MF_CLASS99_j377 = s;
     return this;
 }

 public String MF_CLASS99_b371()
 {
     return MF_CLASS99_l379;
 }

 public Building MF_CLASS99_c372(String s)
 {
     MF_CLASS99_c372 = true;
     MF_CLASS99_k378 = s;
     return this;
 }

 public CLASS102 MF_CLASS99_c372()
 {
     return mPosition;
 }

 public Building MF_CLASS99_d373(String s)
 {
     MF_CLASS99_d373 = true;
     MF_CLASS99_l379 = s;
     return this;
 }

 public Building MF_CLASS99_e374(String s)
 {
     MF_CLASS99_e374 = true;
     MF_CLASS99_m380 = s;
     return this;
 }

 public Building MF_CLASS99_f375(String s)
 {
     MF_CLASS99_f375 = true;
     MF_CLASS99_n381 = s;
     return this;
 }

 private static final long serialVersionUID = 1L;
 private boolean hasBuildingID;
 private boolean MF_CLASS99_b371;
 private boolean MF_CLASS99_c372;
 private boolean MF_CLASS99_d373;
 private boolean MF_CLASS99_e374;
 private boolean MF_CLASS99_f375;
 private boolean MF_CLASS99_g384;
 private boolean MF_CLASS99_h385;
 private String mBuildingID;
 private String MF_CLASS99_j377;
 private String MF_CLASS99_k378;
 private String MF_CLASS99_l379;
 private String MF_CLASS99_m380;
 private String MF_CLASS99_n381;
 private CLASS102 mPosition;
 private boolean MF_CLASS99_p383;
}
