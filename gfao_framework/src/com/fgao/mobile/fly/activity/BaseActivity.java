/**
 * 
 */
package com.fgao.mobile.fly.activity;

import com.fgao.mobile.fly.HandlerCallBack;
import com.fgao.mobile.fly.UIHandler;
import com.fgao.mobile.fly.fragment.BaseFragment;
import com.fgao.mobile.fly.fragment.DataTransportListener;
import com.fgao.mobile.fly.fragment.FragmentChangeListener;
import com.fgao.mobile.fly.model.MData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public abstract class BaseActivity extends FragmentActivity implements HandlerCallBack, ActivityCallback {
	
	protected ActivityHelper activityHelper;
	protected FragmentManager fragmentManager;
	protected UIHandler uiHandler;
	protected FragmentChangeListener fragmentChangeListener;
	protected DataTransportListener dataTransportListener;
	protected BaseFragment currentFragment;
	protected boolean networkStateOpen;
	
	public void setNetworkStateOpen(boolean networkStateOpen) {
		this.networkStateOpen = networkStateOpen;
	}
	
	public BaseActivity() {
	}
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		fragmentManager = getSupportFragmentManager();
		loadBase();
		loadView();
		uiHandler = new UIHandler();
		uiHandler.setCallback(this);
		activityHelper = new ActivityHelper(this);
		activityHelper.onCreate();
	}
	
	/**
	 * First initView and setContentView
	 */
	abstract void loadView();

	protected void loadBase() {
		
	}
	
	public void setFragmentChangeListener(
			FragmentChangeListener fragmentChangeListener) {
		this.fragmentChangeListener = fragmentChangeListener;
	}
	
	protected void addFragment(int id, BaseFragment fragment, boolean addBackStack){
		FragmentTransaction t = fragmentManager.beginTransaction();
		t.add(id, fragment);
		if (addBackStack) {
			t.addToBackStack(null);
		}
		t.commit();
		fragmentChanged(fragment);
	}
	
	private void fragmentChanged(BaseFragment fragment) {
		if (fragmentChangeListener != null) {
			fragmentChangeListener.onChanged(currentFragment, fragment);
		}
		currentFragment = fragment;
	}
	
	protected void dataUpdated(MData<?> data) {
		if (dataTransportListener != null) {
			dataTransportListener.updateData(data);
		}
	}

	protected void replaceFragment(int id,BaseFragment fragment, boolean addBackStack){
		FragmentTransaction t = fragmentManager.beginTransaction();
		t.replace(id, fragment);
		if (addBackStack) {
			t.addToBackStack(null);
		}
		t.commit();
		fragmentChanged(fragment);
	}
	
	protected void popStack(){
		fragmentManager.popBackStack();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (activityHelper != null) {
			activityHelper.onResume();
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if (activityHelper != null) {
			activityHelper.onPause();
		}
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		if (activityHelper != null) {
			activityHelper.onStop();
		}
	}

	public void setDataTransportListener(DataTransportListener dataTransportListener) {
		this.dataTransportListener = dataTransportListener;
	}

}
