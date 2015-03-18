/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import java.io.File;

import org.apache.http.Header;

import com.fgao.mobile.fly.GlobalConfig;
import com.fgao.mobile.fly.common.HTTPHelper;
import com.fgao.mobile.fly.common.IOUtils;
import com.fgao.mobile.fly.common.SDCard;
import com.fgao.mobile.fly.model.AppVersion;
import com.loopj.android.http.BinaryHttpResponseHandler;

import android.content.Context;
import android.provider.Settings.Global;

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
		String url  = this.newVersion.apkURL;
		HTTPHelper.get(url, new BinaryHttpResponseHandler() {
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] data) {
				String path = SDCard.getSDCardPath() + File.separator + GlobalConfig.APP_DIR + System.currentTimeMillis() + ".apk";
				if (data != null) {
					IOUtils.saveFile(path, data);
					apkDownloadListener.onDone(path);
				}
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable error) {
			}
		});
	}

	public void setVersion(AppVersion newVersion) {
		this.newVersion = newVersion;
	}

}
