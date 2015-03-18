/**
 * 
 */
package com.fgao.mobile.fly.common;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * @author gaofeng
 *
 */
public class HTTPHelper {

	public HTTPHelper() {
	}
	
	public static void get(String url,ResponseHandlerInterface callback){
		AsyncHttpClient  client = new AsyncHttpClient();
		client.get(url,callback);
	}

	public static void post(String url,RequestParams params,ResponseHandlerInterface callback){
		AsyncHttpClient  client = new AsyncHttpClient();
		client.post(url, params, callback);
	}
	
}
