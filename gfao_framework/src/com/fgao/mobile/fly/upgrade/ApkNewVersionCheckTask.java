/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import org.apache.http.Header;

import com.fgao.mobile.fly.GlobalConfig;
import com.fgao.mobile.fly.MobileApplication;
import com.fgao.mobile.fly.common.HTTPHelper;
import com.fgao.mobile.fly.model.AppVersion;
import com.loopj.android.http.TextHttpResponseHandler;

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
		HTTPHelper.get(GlobalConfig.UPDATE_URL, new TextHttpResponseHandler(){
			public void onFailure(int arg0, Header[] arg1, String arg2,
					Throwable arg3) {
			}

			@Override
			public void onSuccess(int arg0, Header[] arg1, String content) {
				AppVersion appVersion = Helper.parserXML(content);
				int oldCode = MobileApplication.getApplication().getPackageInfo().versionCode;
				boolean find = Helper.checkAppVersion(appVersion, oldCode + "");
				if (find) {
					upgradeListener.onFindNewVersion(appVersion);
				} else {
					upgradeListener.onFindNewVersion(null);
				}
			}
			
		});
	}

}
