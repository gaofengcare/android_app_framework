/**
 * 
 */
package com.fgao.mobile.fly.cache;

/**
 * @author gaofeng
 * @since 2015
 *
 */
public interface ICache<T> {
	public void put(String key, T value);
	public T get(String key);
	public T remove(String key);
}
