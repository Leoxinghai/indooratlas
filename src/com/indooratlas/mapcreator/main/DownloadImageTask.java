package com.indooratlas.mapcreator.main;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.indooratlas.base.CLASS1;
import com.indooratlas.base.IndoorAtlasFactory;
import com.indooratlas.mapcreator.controller.*;
import com.indooratlas.position.CLASS75;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

//Referenced classes of package com.indooratlas.mapcreator.main:
//         MapScreen, CLASS316

class DownloadImageTask extends AsyncTask
{

 public DownloadImageTask(MapScreen mapscreen, ImageView imageview)
 {
     super();
     MF_CLASS309_b882 = mapscreen;
     MF_CLASS316_a895 = imageview;
 }

 private void MF_CLASS309_b882(String s)
 {
     MapScreen.sHideDownloadFloorplanProgressDialog(MF_CLASS309_b882);
     MapScreen.sShowImageDownloadRetryDialog(MF_CLASS309_b882);
 }

 public String MF_CLASS316_a895(String s) throws IOException
 {
     String s1 = s.substring(1 + s.lastIndexOf("/"));
     BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(MF_CLASS309_b882.mMe.openFileOutput(s1, 0));
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.storeImageFromUrl: file created: fname = ").append(s1).toString());
     URL url = new URL(s);
     URLConnection urlconnection = url.openConnection();
     urlconnection.connect();
     urlconnection.setConnectTimeout(10000);
     urlconnection.setReadTimeout(0x493e0);
     int i = urlconnection.getContentLength();
     BufferedInputStream bufferedinputstream = new BufferedInputStream(url.openStream(), 8192);
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.storeImageFromUrl: lenghtOfFile = ").append(i).toString());
     byte abyte0[] = new byte[1024];
     long l = 0L;
     do
     {
         int j = bufferedinputstream.read(abyte0,0,abyte0.length);
         if(j != -1)
         {
             l += j;
             CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.storeImageFromUrl: lenghtOfFile = ").append(i).append(", read status = ").append(l).toString());
             bufferedoutputstream.write(abyte0, 0, j);
             String as[] = new String[1];
             as[0] = (new StringBuilder()).append("").append((int)((100L * l) / (long)i)).toString();
             publishProgress(as);
             if(isCancelled())
             {
                 CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.storeImageFromUrl: isCancelled == true -->  return null");
                 return null;
             }
         } else
         {
             CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.storeImageFromUrl: file writing done: url = ").append(s).append(", fname = ").append(s1).toString());
             bufferedoutputstream.close();
             bufferedinputstream.close();
             CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.storeImageFromUrl: successful, returning fname = ").append(s1).toString());
             return s1;
         }
     } while(true);
 }

 protected void MF_CLASS316_a895(Object aobj[])
 {
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.onPostExecute(): calling setImageBitmap() on ImageView, result = ").append(((Object) (aobj))).toString());
     if(MF_CLASS309_b882.mBitmap != null)
     {
         MF_CLASS309_b882.mBitmap.recycle();
         MF_CLASS309_b882.mBitmap = null;
         System.gc();
     }
     if(aobj == null) {
	        if(!isCancelled())
	        {
	            CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.onPostExecute(): result == null && isCancelled() == false --> handling download failure and returning.");
	            MF_CLASS309_b882(MF_CLASS309_b882.mMe.getString(0x7f080022));
	            return;
	        }
     }
     if(aobj != null) {
         try
         {
             MF_CLASS309_b882.mBitmap = (Bitmap)aobj[0];
             MF_CLASS309_b882.mBitmapScale = ((Integer)aobj[1]).intValue();
             CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.onPostExecute(): mBitmapScale = ").append(MF_CLASS309_b882.mBitmapScale).toString());
             CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.onPostExecute(): : creating API");
             MapScreen.MF_CLASS19_a67(MF_CLASS309_b882, false);
             MapScreen.MF_CLASS19_a67(MF_CLASS309_b882, IndoorAtlasFactory.createIndoorAtlas(MF_CLASS309_b882.mMe.getApplicationContext(), MF_CLASS309_b882.mMe, MF_CLASS309_b882.mApiKey, MF_CLASS309_b882.mSecret));
             CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.onPostExecute():  mBGCalibrationReady = ").append(MF_CLASS309_b882.isBGCalibrationReady()).toString());
             MF_CLASS309_b882.invalidateOptionsMenu();
             CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.onPostExecute():  API created");
             MapScreen.doubleTap(MF_CLASS309_b882.mMe);
             MF_CLASS316_a895.setImageBitmap(MF_CLASS309_b882.mBitmap);
             MapScreen.sHideDownloadFloorplanProgressDialog(MF_CLASS309_b882);
             MapScreen.setMapState(MF_CLASS309_b882.mMe, POINT_TYPE.DEFAULT);
             CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.onPostExecute(): NOT calling fireBackendSegmentSynch");
             return;
         }
         // Misplaced declaration of an exception variable
         catch(CLASS1 class1)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 class1.printStackTrace();
             MF_CLASS309_b882(class1.getMessage());
             return;
         }
         catch(Exception exception)
         {
             if(CLASS113.isExceptionLogged.booleanValue())
                 exception.printStackTrace();
         }
         MF_CLASS309_b882(MF_CLASS309_b882.mMe.getString(0x7f080022));
         return;

     }
//     CLASS1 class1;
     if(isCancelled())
     {
         CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.onPostExecute(): result == null && isCancelled() == true --> just return.");
         return;
     }
 }

 protected Object[] MF_CLASS316_a895(String as[])
 {
     long l;
     int i;
     String s1;
     String s3;
     BitmapFactory.Options options;
     CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.doInBackground(): called.");
     l = System.nanoTime();
     String s = as[0];
     i = 1;
     String s2;
     long l1;
     FileInputStream fileinputstream;

     int j;
     double d;
     float f;
     float f1;
     int k;
     FileInputStream fileinputstream1;
     Bitmap bitmap;
     Object aobj[] = null;
     double d1 =0;

     try
     {
         s1 = MeasurementDataSource.getFloorplanLocalFileName(s);
         CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): got from cache: ").append(s1).toString());
         //add by xinghai
         s1 = null;
     if(s1 != null) {
             publishProgress(new String[] {
                 "50"
             });
             try
             {
                 Thread.sleep(200L);
             }
             catch(InterruptedException interruptedexception1) { }
             publishProgress(new String[] {
                 "100"
             });
             s3 = s1;
     } else {

	        CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.doInBackground(): floorplan not in cache, storing from URL.");
	        s2 = MF_CLASS316_a895(s);
	        if(s2 != null) {
	            l1 = MeasurementDataSource.storeFloorplan(s, s2);
	            CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): floorplan cached with URL :").append(s).append(", id = ").append(l1).toString());
	            s3 = s2;
	        } else {
		        CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.doInBackground(): storing image to file failed.");
		        return null;
	        }
     }

     fileinputstream = MF_CLASS309_b882.mMe.openFileInput(s3);
     options = new BitmapFactory.Options();
     options.inJustDecodeBounds = true;
     BitmapFactory.decodeStream(new BufferedInputStream(fileinputstream), null, options);
     fileinputstream.close();
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): o.outHeight  = ").append(options.outHeight).append(", o.outWidth = ").append(options.outWidth).append(", IMAGE_MAX_SIZE = ").append(1024).append(", mMaxImageWidthHWAccel = ").append(MF_CLASS309_b882.mMaxImageWidthHWAccel).append(", mMaxImageHeightHWAccel = ").append(MF_CLASS309_b882.mMaxImageHeightHWAccel).toString());

     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): AFTER wait, mMaxImageWidthHWAccel = ").append(MF_CLASS309_b882.mMaxImageWidthHWAccel).append(", mMaxImageHeightHWAccel = ").append(MF_CLASS309_b882.mMaxImageHeightHWAccel).toString());
     j = (int)Math.min(MF_CLASS309_b882.mMaxImageWidthHWAccel, MF_CLASS309_b882.mMaxImageHeightHWAccel);
     if(options.outHeight >= j || options.outWidth >= j) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.doInBackground():  calculating scaling factor");
	        d = Math.max(options.outHeight, options.outWidth);
	        if(d == 0.0D) {
	                i = 1;
	        } else {
	        	i = (int)Math.pow(2D, (int)Math.round(Math.log((double)j / d) / Math.log(0.5D)));
	        }

	        f = (float)options.outWidth / (float)i;
	        f1 = (float)options.outHeight / (float)i;
	        if(f > (float)j || f1 > (float)j) {
	            if(i == 1)
	                i = 2;
	            else
	                i += 2;
	        }
	        CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): scaling factor increased to ").append(i).toString());
     }

     k = i;
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): scale = ").append(k).toString());
     BitmapFactory.Options options1 = new BitmapFactory.Options();
     options1.inSampleSize = k;
     options1.inPurgeable = true;
     fileinputstream1 = MF_CLASS309_b882.mMe.openFileInput(s3);
     bitmap = BitmapFactory.decodeStream(fileinputstream1, null, options1);
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): decoded bitmap = ").append(bitmap).toString());
     //if(!CLASS113.isExceptionLogged.booleanValue() || bitmap == null) {
     if( bitmap == null) {
	        CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.doInBackground(): bitmap == null");
	        CLASS75.MF_CLASS75_a259(5, "FLOORPLAN_IMAGE_LOAD_FAILED", DownloadImageTask.class, (new StringBuilder()).append("DownloadImageTask, took: ").append(d1).append(", scale = ").append(k).toString());
	        return aobj;

     }
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): bitmap.getByteCount() = ").append(bitmap.getByteCount()).append(", bitmap.getHeight = ").append(bitmap.getHeight()).append(", bitmap.getWidth = ").append(bitmap.getWidth()).toString());
     fileinputstream1.close();
     aobj = new Object[2];
     aobj[0] = bitmap;
     aobj[1] = new Integer(k);
     d1 = System.nanoTime() - l;
     double d2 = d1 / 1000000000D;
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): took = ").append(d2).toString());
     if(bitmap != null) {
         CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.doInBackground(): bitmap != null, OK");
         CLASS75.MF_CLASS75_a259(4, "FLOORPLAN_IMAGE_LOAD_OK", DownloadImageTask.class, (new StringBuilder()).append("DownloadImageTask, took: ").append(d1).append(", scale = ").append(k).toString());
         return aobj;
     }

     }
     catch(IOException ioexception)
     {
         CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.doInBackground(): caught IOException, *returning null*, excep =  : ").append(ioexception.getMessage()).toString());
         CLASS75.MF_CLASS75_a259(5, "FLOORPLAN_IMAGE_LOAD_FAILED", DownloadImageTask.class, (new StringBuilder()).append("DownloadImageTask.doInBackground, ").append(CLASS75.MF_CLASS75_a259(ioexception)).toString());
         if(CLASS113.isExceptionLogged.booleanValue())
             ioexception.printStackTrace();
         return null;
     }
     return aobj;

 }

 protected void MF_CLASS309_b882(String as[])
 {
     CLASS167.MF_CLASS167_b635("MapScreen", (new StringBuilder()).append("DownloadImageTask.onProgressUpdate(): updating download status, progress = ").append(as).toString());
     MapScreen.MF_CLASS19_d70(MF_CLASS309_b882.mMe).setProgress(Integer.parseInt(as[0]));
 }

 protected Object doInBackground(Object aobj[])
 {
     return ((Object) (MF_CLASS316_a895((String[])aobj)));
 }

 public void onCancelled()
 {
     CLASS167.MF_CLASS167_b635("MapScreen", "DownloadImageTask.onCancelled(): called.");
 }

 protected void onPostExecute(Object obj)
 {
     MF_CLASS316_a895((Object[])obj);
 }

 protected void onPreExecute()
 {
     MF_CLASS309_b882.hideConnectionIndicator();
     MapScreen.U(MF_CLASS309_b882);
 }

 protected void onProgressUpdate(Object aobj[])
 {
     MF_CLASS309_b882((String[])aobj);
 }

 ImageView MF_CLASS316_a895;
 final MapScreen MF_CLASS309_b882;
}
