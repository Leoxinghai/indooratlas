package org.wuxi;


public enum READYSTATE 
{
	NOT_YET_CONNECTED("NOT_YET_CONNECTED", 0),
	CONNECTING("CONNECTING", 1),
    OPEN("OPEN", 2),
    CLOSING("CLOSING", 3),
    CLOSED("CLOSED", 4);
    
    private String sType;
    private int iType;

    private READYSTATE(String s, int i)
    {
        sType = s;
        iType = i;
    }

    private static final READYSTATE MF_CLASS405_f1209[];

    static 
    {
    	READYSTATE aclass405[] = new READYSTATE[5];
        aclass405[0] = NOT_YET_CONNECTED;
        aclass405[1] = CONNECTING;
        aclass405[2] = OPEN;
        aclass405[3] = CLOSING;
        aclass405[4] = CLOSED;
        MF_CLASS405_f1209 = aclass405;
    }
}
