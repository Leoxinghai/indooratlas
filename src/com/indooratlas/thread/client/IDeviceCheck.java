package com.indooratlas.thread.client;



import java.io.InputStream;
import java.util.List;

public interface IDeviceCheck
{

 public abstract void onRequestComplete(int i, String s, int j, String s1, List list, String s2, Long long1, 
         InputStream inputstream, String s3);

 public abstract void checkDeviceSupported(int i, String s, int j, String s1, List list, String s2, String s3);

 public abstract void onRequestTimeout(int i, String s, int j, List list, String s1);

 public abstract void checkDeviceSupported(int i, String s, List list, String s1);
}
