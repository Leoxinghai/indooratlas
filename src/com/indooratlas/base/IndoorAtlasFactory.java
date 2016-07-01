package com.indooratlas.base;

//CLASS2


import android.content.Context;
import android.content.res.AssetManager;

import com.indooratlas.algorithm.CLASS7;
import com.indooratlas.algorithm.cpa;
import com.indooratlas.database.APIDataBase;
import com.indooratlas.position.CLASS75;
import com.indooratlas.task.CLASS42;
import com.indooratlas.task.RemoteImplementation;
import com.indooratlas.types.IndoorAtlas;

import java.io.*;

//Referenced classes of package com.indooratlas.base:
//         CLASS1, CLASS3

public class IndoorAtlasFactory
{

 public static IndoorAtlas createIndoorAtlas(Context context, CLASS3 class3, String s, String s1) throws CLASS1
 {
     try {
	    	if(APIDataBase.MF_CLASS33_a137) {
	            CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : APIDataBase.open == true");
	        } else {
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : calling APIDataBase.open(context)");
		        APIDataBase.MF_CLASS33_a137(context);
	        }

	        if(MF_CLASS2_b3 == null) {
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : indoorAtlas == null");
		        MF_CLASS33_a137(context);
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : created cpa.BackgroundCalibrator");
		        MF_CLASS2_b3 = new RemoteImplementation();
	        }

	        MF_CLASS2_b3.setup(context, class3, new CLASS42(s, s1));
	        RemoteImplementation class50 = MF_CLASS2_b3;
	        return class50;
     } catch(Exception exception) {
     	exception.printStackTrace();
     	throw new CLASS1("Error in loading native libraries.");
     }
 }

 private static File MF_CLASS33_a137(Context context, InputStream inputstream, String s) throws IOException
 {
     java.io.FileOutputStream fileoutputstream;
     byte abyte0[];
     CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "copyFromInputStreamToFile() called");
     fileoutputstream = context.openFileOutput(s, 0);
     CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("copyFromInputStreamToFile() file created, outputStream = ").append(fileoutputstream).toString());
     abyte0 = new byte[1024];

     while(true) {
 	   int i = inputstream.read(abyte0);
         if(i <= 0)
             break;
         try
         {
             fileoutputstream.write(abyte0, 0, i);
         }
         catch(IOException ioexception)
         {
             return null;
         }
     }
     fileoutputstream.close();
     inputstream.close();
     CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "copyFromInputStreamToFile() outputStream and inputStream closed");
     File file;
     file = context.getFileStreamPath(s);
     return file;
 }

 private static void MF_CLASS33_a137(Context context) throws CLASS1,IOException
 {
     boolean flag;
     String as[];
     int i;
     flag = false;
     String s = System.getProperty("os.arch");
     CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("createIndoorAtlas : opening libcpaJNI.so from assets, arch = ").append(s).toString());
     MF_CLASS2_b3(context);
     as = (new String[] {
         "armeabi-v7a-libcpaJNI.native", "armeabi-libcpaJNI.native", "mips-libcpaJNI.native", "x86-libcpaJNI.native"
     });
     i = 0;

     while(true) {
	        if(flag || i >= as.length)
	            break; /* Loop/switch isn't completed */
	        try {
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("createIndoorAtlas : opening libcpaJNI.so from assets ").append(as[i]).toString());
		        InputStream inputstream = context.getAssets().open(as[i]);
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("createIndoorAtlas : successfully opened libcpaJNI.so from assets ").append(as[i]).toString());
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : copying lib from asset to file");
		        File file = MF_CLASS33_a137(context, inputstream, "cpaJNICopy.so");
		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("createIndoorAtlas : copied native lib from assets, trying to load lib from absolute path = ").append(file.getAbsolutePath()).toString());
		        System.load(file.getAbsolutePath());
		        new CLASS7();

		        CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : loaded library");
		        flag = true;
	        } catch(UnsatisfiedLinkError unsatisfiedlinkerror) {
	        	unsatisfiedlinkerror.printStackTrace();
	        } catch(Exception exception) {
	        	exception.printStackTrace();
	        }
	        i++;
     }

     if(!flag)
     {
         CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, "createIndoorAtlas : loaded == false --> throw");
         throw new CLASS1("Loading native library failed.");
     } else
     {
         return;
     }
 }

 private static void MF_CLASS2_b3(Context context) throws IOException
 {
     String as[] = context.getAssets().list("");
     CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("createIndoorAtlas, asset fileList.length = ").append(as.length).toString());
     if(as != null)
     {
         for(int i = 0; i < as.length; i++)
             CLASS75.MF_CLASS75_b260(mIndoorAtlasFactory, (new StringBuilder()).append("createIndoorAtlas, asset = ").append(as[i]).toString());

     }
 }

 private static String mIndoorAtlasFactory = "IndoorAtlasFactory";
 private static RemoteImplementation MF_CLASS2_b3 = null;

}
