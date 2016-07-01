package org.wuxi;

public enum Role
{
    MF_CLASS413_a1212("CLIENT", 0),
    MF_CLASS413_b1213("SERVER", 1);

    private String sType;
    private int iType;

    private Role(String s, int i)
    {
        sType = s;
        iType = i;
    }


    private static final Role MF_CLASS413_c1214[];

    static 
    {
    	Role aclass413[] = new Role[2];
        aclass413[0] = MF_CLASS413_a1212;
        aclass413[1] = MF_CLASS413_b1213;
        MF_CLASS413_c1214 = aclass413;
    }
}
