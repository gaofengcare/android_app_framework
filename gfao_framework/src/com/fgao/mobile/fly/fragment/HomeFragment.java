/**
 * 
 */
package com.fgao.mobile.fly.fragment;

import com.fgao.mobile.fly.LOG;
import com.fgao.mobile.fly.model.MData;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author gaofeng
 * @since 2015
 *
 */
public class HomeFragment extends BaseFragment {
	
	static final String TAG = HomeFragment.class.getCanonicalName();
	private static final int HOME_FRAGMENT = 10;

	/**
	 * 
	 */
	public HomeFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		fragmentId =  HOME_FRAGMENT;
		return rootView;
	}
	
	/* (non-Javadoc)
	 * @see com.fgao.mobile.fly.fragment.FragmentChangeListener#onChanged(android.support.v4.app.Fragment, android.support.v4.app.Fragment)
	 */
	@Override
	public void onChanged(BaseFragment oldFragment, BaseFragment currFragment) {
		LOG.Debug(TAG, "onShow:" + oldFragment);
		if (oldFragment != null) {
			
		}
	}

	@Override
	public void updateData(MData<?> data) {
		LOG.Debug(TAG, "updateData:" + data);
	}


}
