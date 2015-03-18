/**
 * 
 */
package com.fgao.mobile.fly;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * @author gaofeng
 * @date 2015-3-13
 */
public class UIHandler extends Handler  {
	
	private static final String TAG = "UIHandler";
	private HandlerCallBack callback;

	public UIHandler() {
	}

	/**
	 * @param callback
	 */
	public UIHandler(Callback callback) {
		super(callback);
	}

	/**
	 * @param looper
	 */
	public UIHandler(Looper looper) {
		super(looper);
	}

	/**
	 * @param looper
	 * @param callback
	 */
	public UIHandler(Looper looper, Callback callback) {
		super(looper, callback);
	}
	
	public void setCallback(HandlerCallBack callback) {
		this.callback = callback;
	}
	
	@Override
	public void handleMessage(Message msg) {
		trackMsg(msg);
		this.callback.handleMessage(msg);
	}

	private void trackMsg(Message msg) {
		LOG.Debug(TAG, "msg:" + msg);
	}

}
