/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import android.content.Context;

/**
 * @author gaofeng
 *
 */
public class ApkNewVersionCheckTask implements Runnable  {
	
	private AppUpgradeListener upgradeListener;
	private Context context;
	
	public void setUpgradeListener(AppUpgradeListener upgradeListener) {
		this.upgradeListener = upgradeListener;
	}

	public ApkNewVersionCheckTask() {
	}

	public ApkNewVersionCheckTask(Context context) {
		this.context = context;
	}

	@Override
	public void run() {
	}

}
