/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import com.fgao.mobile.fly.model.AppVersion;
import com.fgao.mobile.fly.model.MError;

/**
 * @author gaofeng
 * @since 2015-02
 *
 */
public interface AppUpgradeListener {
	
	public void onFindNewVersion(AppVersion newVersion);
	public void onError(MError error);

}
