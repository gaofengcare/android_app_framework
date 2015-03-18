/**
 * 
 */
package com.fgao.mobile.fly.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author gaofeng
 * @since 2015
 *
 */
public class NetworkState {

	public NetworkState() {
	}
	
	public static boolean networkIsOpen(Context ctx){
		ConnectivityManager connectivityMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityMgr.getActiveNetworkInfo();
		if (activeNetInfo != null && (activeNetInfo.isAvailable() || activeNetInfo.isConnected())) {
			return true;
		}
		return false;
	}
	
	public static String getNetworkTypeName(Context ctx){
		ConnectivityManager connectivityMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityMgr.getActiveNetworkInfo();
		if (activeNetInfo != null) {
			return activeNetInfo.getTypeName();
		}
		return null;
	}

}
