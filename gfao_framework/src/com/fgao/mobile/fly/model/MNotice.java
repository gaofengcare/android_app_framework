/**
 * 
 */
package com.fgao.mobile.fly.model;

import java.io.Serializable;

/**
 * @author gaofeng
 * @date 2015-3-12
 */
public class MNotice<T> implements Serializable {
	
	public int type;
	public T data;

	public MNotice() {
	}

}
