/**
 * 
 */
package com.fgao.mobile.fly.activity;

import com.fgao.mobile.fly.R;
import com.fgao.mobile.fly.activity.TabViewLoader.TabView;
import com.fgao.mobile.fly.fragment.BaseFragment;
import com.fgao.mobile.fly.fragment.GPSFragment;
import com.fgao.mobile.fly.fragment.HomeFragment;
import com.fgao.mobile.fly.model.MError;
import com.fgao.mobile.fly.model.MNotice;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

/**
 * @author gaofeng
 * @date 2015-3-13
 */
public class HomeActivity extends BaseActivity {
	
	private int currentId;

	public HomeActivity() {
	}

	@Override
	public void handleMessage(Message msg) {
		
	}

	@Override
	void loadView() {
		setContentView(R.layout.activity_main_tab);
		tabMenuLoad();
		HomeFragment homeFragment = new HomeFragment();
		homeFragment.setActivity(this);
		homeFragment.setCallback(this);
		replaceFragment(R.id.container, homeFragment, false);
	}

	private void tabMenuLoad() {
		
		LinearLayout tabLayout = (LinearLayout) findViewById(R.id.tab_ly);
		LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,1);
		parms.gravity = Gravity.CENTER_VERTICAL;
		
		TabView view1 = new TabView(TabViewLoader.ID_HOME, R.drawable.tab_home, "Home");
		TabView view2 = new TabView(TabViewLoader.ID_GPS,  R.drawable.tab_gps,  "GPS");
		TabView view3 = new TabView(TabViewLoader.ID_TASK,  R.drawable.tab_tasks,   "Tasks");
		TabView view4 = new TabView(TabViewLoader.ID_SETTING,R.drawable.tab_setting,"Setting");
		
		tabLayout.addView(TabViewLoader.createTab(this, view1, clickListener),parms);
		tabLayout.addView(TabViewLoader.createTab(this, view2, clickListener),parms);
		tabLayout.addView(TabViewLoader.createTab(this, view3, clickListener),parms);
		tabLayout.addView(TabViewLoader.createTab(this, view4, clickListener),parms);
		
		currentId = TabViewLoader.ID_HOME;
	}
	
	OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			if (currentId == view.getId()) {
				return;
			}
			currentId = view.getId();
			switch (view.getId()) {
			case TabViewLoader.ID_HOME:
				HomeFragment homeFragment = new HomeFragment();
				homeFragment.setActivity(HomeActivity.this);
				homeFragment.setCallback(HomeActivity.this);
				replaceFragment(R.id.container, homeFragment, false);
				break;
			case TabViewLoader.ID_GPS:
				GPSFragment gpsFragment = new GPSFragment();
				gpsFragment.setActivity(HomeActivity.this);
				gpsFragment.setCallback(HomeActivity.this);
				replaceFragment(R.id.container, gpsFragment, false);
				break;
			case TabViewLoader.ID_TASK:
				break;
			case TabViewLoader.ID_SETTING:
				break;
			default:
				break;
			}
		}
	};

	@Override
	public void onNoticeData(MNotice<?> data,BaseFragment currentFragment) {
		
	}

	@Override
	public void onError(MError e) {
		
	}

}
