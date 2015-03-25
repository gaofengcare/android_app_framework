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

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		fragmentId =  HOME_FRAGMENT;
		return inflater.inflate(0, null);
	}
	

	@Override
	public void onChanged(BaseFragment oldFragment, BaseFragment currFragment) {
		LOG.Debug(TAG, "onShow:" + oldFragment);
	}

	@Override
	public void updateData(MData<?> data) {
		LOG.Debug(TAG, "updateData:" + data);
	}

	@Override
	void setUpView(View view, Bundle savedInstanceState) {
		rootView = view;
	}


}
