/**
 * 
 */
package com.fgao.mobile.fly.activity;

import com.fgao.mobile.fly.R;
import com.fgao.mobile.fly.fragment.BaseFragment;
import com.fgao.mobile.fly.fragment.HomeFragment;
import com.fgao.mobile.fly.model.MError;
import com.fgao.mobile.fly.model.MNotice;

import android.os.Message;
import android.support.v4.app.Fragment;

/**
 * @author gaofeng
 * @date 2015-3-13
 */
public class HomeActivity extends BaseActivity {

	/**
	 * 
	 */
	public HomeActivity() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.fgao.mobile.fly.HandlerCallBack#handleMessage(android.os.Message)
	 */
	@Override
	public void handleMessage(Message msg) {
		
	}

	/* (non-Javadoc)
	 * @see com.fgao.mobile.fly.activity.BaseActivity#loadView()
	 */
	@Override
	void loadView() {
		setContentView(R.layout.activity_main);
		HomeFragment homeFragment = new HomeFragment();
		homeFragment.setActivity(this);
		homeFragment.setCallback(this);
		replaceFragment(R.id.container, homeFragment, false);
	}

	@Override
	public void onNoticeData(MNotice<?> data,BaseFragment currentFragment) {
		
	}

	@Override
	public void onError(MError e) {
		
	}

}
