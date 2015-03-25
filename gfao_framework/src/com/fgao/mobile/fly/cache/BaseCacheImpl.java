/**
 * 
 */
package com.fgao.mobile.fly.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * List Cache
 * @author gaofeng
 *
 */
public class BaseCacheImpl implements ICache<CacheModel<Object>> {
	
	public Map<String,CacheModel<Object>> cacheMap;
	public static BaseCacheImpl cacheInstance;

	protected BaseCacheImpl() {
		cacheMap = new HashMap<String,CacheModel<Object>>();
	}

	@Override
	public synchronized void put(String key, CacheModel<Object> value) {
		cacheMap.put(key, value);
	}

	@Override
	public synchronized CacheModel<Object> get(String key) {
		return cacheMap.get(key);
	}

	public static ICache<CacheModel<Object>> getCacheInstance() {
		if (cacheInstance == null) {
			cacheInstance = new BaseCacheImpl();
		}
		return cacheInstance;
	}

	@Override
	public synchronized CacheModel<Object> remove(String key) {
		return cacheMap.remove(key);
	}

}
