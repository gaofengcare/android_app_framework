/**
 * 
 */
package com.fgao.mobile.fly;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
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
	
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
	

}
