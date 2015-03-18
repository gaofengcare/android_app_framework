/**
 * 
 */
package com.fgao.mobile.fly.common;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;

/**
 * @author gaofeng
 * @since 2015
 *
 */
public final class PhoneUtils {

	protected PhoneUtils() {
	}

	public static String getIMEI(Activity act) {
		TelephonyManager t = (TelephonyManager) act.getSystemService(Context.TELEPHONY_SERVICE);
		String deviceId = t.getDeviceId();
		return deviceId;
	}
	
	public static String getModel() {
		return android.os.Build.MODEL;
	}
	
	public static String getOS() {
		return android.os.Build.VERSION.RELEASE;
	}
	
	public static Location getGPS(Activity act) {
		try {
			LocationManager  loctionManager = (LocationManager) act.getSystemService(Activity.LOCATION_SERVICE);
			if(loctionManager == null){
				return null;
			}
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);  
			criteria.setCostAllowed(false);  
			criteria.setPowerRequirement(Criteria.POWER_LOW);  
			criteria.setBearingRequired(false);  
			criteria.setAltitudeRequired(false);
			String provider   = loctionManager.getBestProvider(criteria, true); 
			Location location = loctionManager.getLastKnownLocation(provider);
			return location;
		} catch (Exception e) {
		}
		return null;
	}
	
	public static PackageInfo getPackageInfo(Context context) {
		String packageName = context.getPackageName();
		try {
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName,
					PackageManager.GET_CONFIGURATIONS | PackageManager.GET_ACTIVITIES);
			return packageInfo;
		} catch (NameNotFoundException e) {
		}
		return null;
	}
	
}
