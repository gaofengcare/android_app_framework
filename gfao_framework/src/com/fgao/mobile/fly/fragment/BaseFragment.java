/**
 * 
 */
package com.fgao.mobile.fly.fragment;

import com.fgao.mobile.fly.activity.ActivityCallback;
import com.fgao.mobile.fly.activity.BaseActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public abstract class BaseFragment extends Fragment implements
		FragmentChangeListener, DataTransportListener {

	protected View rootView;
	protected BaseActivity activity;
	protected ActivityCallback callback;
	protected int fragmentId;

	public BaseFragment() {
	}

	public void setActivity(BaseActivity activity) {
		this.activity = activity;
		this.activity.setFragmentChangeListener(this);
		this.activity.setDataTransportListener(this);
	}

	public void setCallback(ActivityCallback callback) {
		this.callback = callback;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

}
