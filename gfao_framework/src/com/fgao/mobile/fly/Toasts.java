/**
 * 
 */
package com.fgao.mobile.fly;

import android.widget.Toast;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public class Toasts {

	private Toasts() {
	}
	
	public static void showToast(String msg){
		Toast.makeText(MobileApplication.application, msg, Toast.LENGTH_SHORT).show();
	}
	
	public static void showToastL(String msg){
		Toast.makeText(MobileApplication.application, msg, Toast.LENGTH_LONG).show();
	}

}
