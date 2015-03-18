/**
 * 
 */
package com.fgao.mobile.fly.upgrade;

import com.fgao.mobile.fly.model.AppVersion;

/**
 * @author gaofeng
 * @since 2015-02
 *
 */
public interface AppUpgradeListener {
	
	public void onFindNewVersion(AppVersion newVersion);

}
