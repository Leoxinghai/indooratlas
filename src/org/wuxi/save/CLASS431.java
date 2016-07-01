// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.wuxi.save;

import java.io.*;

// Referenced classes of package org.wuxi.save:
//            CLASS430

public class CLASS431 extends FilterOutputStream
{

    public CLASS431(OutputStream outputstream, int i)
    {
        super(outputstream);
        boolean flag = true;
        boolean flag1;
        int j;
        if((i & 8) != 0)
            flag1 = flag;
        else
            flag1 = false;
        MF_CLASS431_f1284 = flag1;
        if((i & 1) == 0)
            flag = false;
        MF_CLASS431_a1283 = flag;
        if(MF_CLASS431_a1283)
            j = 3;
        else
            j = 4;
        MF_CLASS431_d1285 = j;
        MF_CLASS431_c1286 = new byte[MF_CLASS431_d1285];
        MF_CLASS431_b1287 = 0;
        MF_CLASS431_e1288 = 0;
        MF_CLASS431_h1289 = false;
        MF_CLASS431_g1290 = new byte[4];
        MF_CLASS431_i1291 = i;
        MF_CLASS431_j1292 = CLASS430.MF_CLASS430_a1276(i);
    }

    public void MF_CLASS431_a1283() throws IOException
    {
        if(MF_CLASS431_b1287 > 0)
        {
            if(!MF_CLASS431_a1283)
                throw new IOException("Base64 input not properly padded.");
            out.write(CLASS430.MF_CLASS430_a1276(MF_CLASS431_g1290, MF_CLASS431_c1286, MF_CLASS431_b1287, MF_CLASS431_i1291));
            MF_CLASS431_b1287 = 0;
        }
        return;
    }

    public void close() throws IOException
    {
        MF_CLASS431_a1283();
        close();
        MF_CLASS431_c1286 = null;
        out = null;
    }

    public void write(int i) throws IOException
    {
        if(!MF_CLASS431_h1289) {
            if(MF_CLASS431_a1283) {
	            byte abyte1[] = MF_CLASS431_c1286;
	            int l = MF_CLASS431_b1287;
	            MF_CLASS431_b1287 = l + 1;
	            abyte1[l] = (byte)i;
	            if(MF_CLASS431_b1287 >= MF_CLASS431_d1285)
	            {
	                out.write(CLASS430.MF_CLASS430_a1276(MF_CLASS431_g1290, MF_CLASS431_c1286, MF_CLASS431_d1285, MF_CLASS431_i1291));
	                MF_CLASS431_e1288 = 4 + MF_CLASS431_e1288;
	                if(MF_CLASS431_f1284 && MF_CLASS431_e1288 >= 76)
	                {
	                    out.write(10);
	                    MF_CLASS431_e1288 = 0;
	                }
	                MF_CLASS431_b1287 = 0;
	                return;
	            }
            } else {

                if(MF_CLASS431_j1292[i & 0x7f] > -5) {
	                byte abyte0[] = MF_CLASS431_c1286;
	                int j = MF_CLASS431_b1287;
	                MF_CLASS431_b1287 = j + 1;
	                abyte0[j] = (byte)i;
	                if(MF_CLASS431_b1287 >= MF_CLASS431_d1285) {
	        	        int k = CLASS430.MF_CLASS430_a1276(MF_CLASS431_c1286, 0, MF_CLASS431_g1290, 0, MF_CLASS431_i1291);
	        	        out.write(MF_CLASS431_g1290, 0, k);
	        	        MF_CLASS431_b1287 = 0;
	        	        return;
	                }
                }else if(MF_CLASS431_j1292[i & 0x7f] != -5) 
                	throw new IOException("Invalid character in Base64 data.");
            	
            }
        } else {
        	out.write(i);
        }
        return;
    }

    public void write(byte abyte0[], int i, int j) throws IOException
    {
        if(MF_CLASS431_h1289)
        {
            out.write(abyte0, i, j);
        } else
        {
            int k = 0;
            while(k < j) 
            {
                write(abyte0[i + k]);
                k++;
            }
        }
    }

    private boolean MF_CLASS431_a1283;
    private int MF_CLASS431_b1287;
    private byte MF_CLASS431_c1286[];
    private int MF_CLASS431_d1285;
    private int MF_CLASS431_e1288;
    private boolean MF_CLASS431_f1284;
    private byte MF_CLASS431_g1290[];
    private boolean MF_CLASS431_h1289;
    private int MF_CLASS431_i1291;
    private byte MF_CLASS431_j1292[];
}
