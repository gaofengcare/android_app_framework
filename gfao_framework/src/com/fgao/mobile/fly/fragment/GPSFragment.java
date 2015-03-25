/**
 * 
 */
package com.fgao.mobile.fly.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fgao.mobile.fly.R;
import com.fgao.mobile.fly.model.MData;

/**
 * @author user
 *
 */
public class GPSFragment extends BaseFragment {

	/**
	 * 
	 */
	public GPSFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_gps, null);
	}

	/* (non-Javadoc)
	 * @see com.fgao.mobile.fly.fragment.FragmentChangeListener#onChanged(com.fgao.mobile.fly.fragment.BaseFragment, com.fgao.mobile.fly.fragment.BaseFragment)
	 */
	@Override
	public void onChanged(BaseFragment oldFragment, BaseFragment currFragment) {

	}

	/* (non-Javadoc)
	 * @see com.fgao.mobile.fly.fragment.DataTransportListener#updateData(com.fgao.mobile.fly.model.MData)
	 */
	@Override
	public void updateData(MData<?> data) {

	}

	/* (non-Javadoc)
	 * @see com.fgao.mobile.fly.fragment.BaseFragment#setUpView(android.view.View, android.os.Bundle)
	 */
	@Override
	void setUpView(View view, Bundle savedInstanceState) {
		if (view != null) {
			((TextView)view.findViewById(R.id.text_title)).setText("GPS Location");
		}
	}

}
