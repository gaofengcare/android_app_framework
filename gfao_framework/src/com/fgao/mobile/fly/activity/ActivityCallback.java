/**
 * 
 */
package com.fgao.mobile.fly.activity;

import com.fgao.mobile.fly.fragment.BaseFragment;
import com.fgao.mobile.fly.model.MError;
import com.fgao.mobile.fly.model.MNotice;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public interface ActivityCallback {
	
	public void onNoticeData(MNotice<?> data, BaseFragment currentFragment);
	public void onError(MError e);

}
