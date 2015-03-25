/**
 * 
 */
package com.fgao.mobile.fly.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author gaofeng
 *
 */
public class LRUCache extends BaseCacheImpl {
	
	private Map<String,Long> TimeMap;

	public LRUCache() {
		super();
		TimeMap = new HashMap<String, Long>();
	}

	@Override
	public void put(String key, CacheModel<Object> value) {
		super.put(key, value);
		TimeMap.put(key, System.currentTimeMillis());
		LRU();
	}

	@Override
	public CacheModel<Object> get(String key) {
		TimeMap.put(key, System.currentTimeMillis());
		LRU();
		return super.get(key);
	}

	@Override
	public CacheModel<Object> remove(String key) {
		return super.remove(key);
	}
	
	//A Simple LRU
	private synchronized void LRU(){
		long now = System.currentTimeMillis();
		Set<Entry<String,Long>> set = TimeMap.entrySet();
		long min = now;
		String key = null;
		for (Entry<String,Long> entry : set) {
			long t = now - entry.getValue();
			if (t < min) {
				min = t;
				key = entry.getKey();
			}
		}
		TimeMap.remove(key);
		this.remove(key);
	}

}
