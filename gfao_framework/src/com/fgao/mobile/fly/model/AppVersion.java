/**
 * 
 */
package com.fgao.mobile.fly.model;

import java.io.Serializable;

/**
 * @author gaofeng
 *
 */
public class AppVersion implements Serializable {

	private static final long serialVersionUID = 8886284852424020261L;

	public AppVersion() {
	}
	
	public String version;
	public String desc;
	public String apkURL;
	public int apkSize;

}
