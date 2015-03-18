/**
 * 
 */
package com.fgao.mobile.fly;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;

/**
 * @author gaofeng
 * @since 2015-03
 * 
 */
public class MobileApplication extends Application {

	protected static MobileApplication application;
	protected SharedPreferences sharedPreferences;

	public MobileApplication() {
	}

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
	}
	
	protected void putString(String key,String value){
		sharedPreferences.edit().putString(key, value).commit();
	}
	
	protected void putInt(String key,int value) {
		sharedPreferences.edit().putInt(key, value);
	}
	
	public static MobileApplication getApplication() {
		return application;
	}
	
	public PackageInfo getPackageInfo() {
		String packageName = getPackageName();
		try {
			PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName,
					PackageManager.GET_CONFIGURATIONS | PackageManager.GET_ACTIVITIES);
			return packageInfo;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
	

}
