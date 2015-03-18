/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import com.fgao.mobile.fly.model.MError;

/**
 * @author gaofeng
 * @since 2015-02
 *
 */
public interface ApkDownloadListener {
	
	public void onProgress(int progress);
	public void onStart();
	public void onDone(String path);
	public void onError(MError error);

}
