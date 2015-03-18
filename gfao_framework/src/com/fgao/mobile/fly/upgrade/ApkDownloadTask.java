/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import com.fgao.mobile.fly.model.AppVersion;

import android.content.Context;

/**
 * @author gaofeng
 *
 */
public class ApkDownloadTask implements Runnable {
	
	private ApkDownloadListener apkDownloadListener;
	private AppVersion newVersion;
	private Context context;
	
	public void setApkDownloadListener(ApkDownloadListener apkDownloadListener) {
		this.apkDownloadListener = apkDownloadListener;
	}

	public ApkDownloadTask() {
	}

	public ApkDownloadTask(Context context) {
		this.context = context;
	}

	@Override
	public void run() {
	}

	public void setVersion(AppVersion newVersion) {
		
	}

}
