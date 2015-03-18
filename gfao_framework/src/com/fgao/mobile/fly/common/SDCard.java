/**
 * 
 */
package com.fgao.mobile.fly.common;

import java.io.File;

import android.os.Environment;

/**
 * @author gaofeng
 * @since 2015 
 */
public class SDCard {

	private SDCard() {
	}
	
	public static boolean hasCDCard(){
		return (Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED));
	}

	public static File getSDCardDir(){
		return Environment.getExternalStorageDirectory();
	}
	
	public static String getSDCardPath(){
	   if (hasCDCard()) {
		   return getSDCardDir().getAbsolutePath();
	   }
	   return null;
	}
	
}
