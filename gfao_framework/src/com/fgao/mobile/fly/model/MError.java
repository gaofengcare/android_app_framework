/**
 * 
 */
package com.fgao.mobile.fly.model;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public class MError implements java.io.Serializable {
	
	public static final int UPDATE_ERROR = 90;
	public static final int DOWNLOAD_ERROR = 91;
	
	public int code;
	public int type;
	public String msg;

	public MError() {
	}

}
