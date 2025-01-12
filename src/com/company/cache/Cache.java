package com.company.cache;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
	private final HashMap<String, Object> cache = new HashMap<>();
	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public Object getValue(String key) {
		readWriteLock.readLock().lock();
		try {
			return cache.get(key);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

	public void putInCache(String key, Object value) {
		readWriteLock.writeLock().lock();
		try {
			cache.put(key, value);
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
}
