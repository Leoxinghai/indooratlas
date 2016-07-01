package com.indooratlas.mapcreator.data;


import java.io.Serializable;

public class Level
    implements Serializable
{
	public Level() {
		mLevelID = "492398922";
	}
    
    public Level(com.indooratlas.communication.cmn.Level level)
    {
    	mLevelID = "";
        MF_CLASS105_g437 = "";
        MF_CLASS105_h438 = "";
        MF_CLASS105_i439 = 0;
        MF_CLASS105_j440 = "";
        if(level.hasId())
            MF_CLASS105_a432(level.getId());
        if(level.hasUrl())
            MF_CLASS105_b433(level.getUrl());
        if(level.hasName())
            MF_CLASS105_c434(level.getName());
        if(level.hasLevelNum())
            MF_CLASS105_a432(level.getLevelNum());
        if(level.hasGraphicsUrl())
            MF_CLASS105_d435(level.getGraphicsUrl());
    }

    public Level MF_CLASS105_a432(int i)
    {
        MF_CLASS105_d435 = true;
        MF_CLASS105_i439 = i;
        return this;
    }

    public Level MF_CLASS105_a432(String s)
    {
        MF_CLASS105_a432 = true;
        mLevelID = s;
        return this;
    }

    public String getLevelID()
    {
        return mLevelID;
    }

    public Level MF_CLASS105_b433(String s)
    {
        MF_CLASS105_b433 = true;
        MF_CLASS105_g437 = s;
        return this;
    }

    public String MF_CLASS105_b433()
    {
        return MF_CLASS105_h438;
    }

    public int MF_CLASS105_c434()
    {
        return MF_CLASS105_i439;
    }

    public Level MF_CLASS105_c434(String s)
    {
        MF_CLASS105_c434 = true;
        MF_CLASS105_h438 = s;
        return this;
    }

    public Level MF_CLASS105_d435(String s)
    {
        MF_CLASS105_e441 = true;
        MF_CLASS105_j440 = s;
        return this;
    }

    private static final long serialVersionUID = 1L;
    private boolean MF_CLASS105_a432;
    private boolean MF_CLASS105_b433;
    private boolean MF_CLASS105_c434;
    private boolean MF_CLASS105_d435;
    private boolean MF_CLASS105_e441;
    private String mLevelID;
    private String MF_CLASS105_g437;
    private String MF_CLASS105_h438;
    private int MF_CLASS105_i439;
    private String MF_CLASS105_j440;
}
