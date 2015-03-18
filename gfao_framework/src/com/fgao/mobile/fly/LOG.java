/**
 * 
 */
package com.fgao.mobile.fly;

import android.util.Log;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public class LOG {

	private static final boolean isDebug = true;

	private LOG() {

	}

	public static void Debug(String tag, String msg) {
		 if (isDebug) {
			 Log.d(tag, msg);
		 }
	}
	
	public static void Info(String tag, String msg) {
		 if (isDebug) {
			 Log.i(tag, msg);
		 }
	}
	
	public static void Error(String tag, String msg) {
		 if (isDebug) {
			 Log.e(tag, msg);
		 }
	}

}
