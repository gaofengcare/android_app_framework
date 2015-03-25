/**
 * 
 */
package com.fgao.mobile.fly.activity;

import com.fgao.mobile.fly.GlobalConfig;
import com.fgao.mobile.fly.common.NetworkState;
import com.fgao.mobile.fly.common.Toasts;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public class ActivityHelper implements LifecycleCallback{
	
	private Activity activity;
	private boolean networkInfoOpen;

	public ActivityHelper(Activity context) {
		this.activity = context;
	}
	
	public void setNetworkStateOpen(boolean networkStateOpen) {
		this.networkInfoOpen = networkStateOpen;
	}
	
	@Override
	public void onResume() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(GlobalConfig.ACTION_NETWORK_STATE);
		activity.registerReceiver(networkStateReceiver, filter);
	}

	@Override
	public void onPause() {
		activity.unregisterReceiver(networkStateReceiver);
	}
	
	BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context ctx, Intent intent) {
			if (networkInfoOpen) {
				if (!NetworkState.networkIsOpen(ctx)) {
					Toasts.showToast("network is unavaiable");
				}
			}
		}
	};

	@Override
	public void onStop() {
		
	}

	@Override
	public void onCreate() {
		
	}
	
}
