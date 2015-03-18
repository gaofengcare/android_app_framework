/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import com.fgao.mobile.fly.model.AppVersion;
import com.fgao.mobile.fly.model.MError;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author gaofeng
 * @since 2015-02
 * 
 */
public class AppUpgradeService extends Service {

	public static final int CMD_VERSION_CHECKING = 10;
	public static final int CMD_APK_DOWNLOAD = 11;
	private boolean autoDownloadAPK = false;
	private boolean updating;

	public AppUpgradeService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (updating) {
			return 0;
		}
		int cmd = intent.getIntExtra("cmd", -1);
		switch (cmd) {
		case CMD_VERSION_CHECKING:
			checkNewVersion();
			break;
		case CMD_APK_DOWNLOAD:
			startDownloadAPK(null);
			break;
		default:
			break;
		}
		return START_NOT_STICKY;
	}

	private void checkNewVersion() {
		ApkNewVersionCheckTask checkTask = new ApkNewVersionCheckTask(this);
		checkTask.setUpgradeListener(appUpgradeListener);
		checkTask.run();
	}

	private void startDownloadAPK(AppVersion newVersion) {
		ApkDownloadTask downloadTask = new ApkDownloadTask(this);
		downloadTask.setVersion(newVersion);
		downloadTask.setApkDownloadListener(apkDownloadListener);
		downloadTask.run();
	}

	AppUpgradeListener appUpgradeListener = new AppUpgradeListener() {

		@Override
		public void onFindNewVersion(AppVersion newVersion) {
			if (newVersion != null && autoDownloadAPK) {
				startDownloadAPK(newVersion);
			} else {
				noticeUser(newVersion);
			}
		}
		

		@Override
		public void onError(MError error) {
			
		}
	};

	ApkDownloadListener apkDownloadListener = new ApkDownloadListener() {

		@Override
		public void onStart() {
		}

		@Override
		public void onProgress(int progress) {
		}

		@Override
		public void onError(MError error) {
		}

		@Override
		public void onDone(String path) {
		}
	};

	protected void noticeUser(AppVersion newVersion) {
		
	}

}
