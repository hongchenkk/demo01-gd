package com.godink.demo01.localCache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 本地缓存：用HashMap实现，LRU算法，最少最近使用的
 * 按访问的顺序排列，每次访问元素，通过get方法访问，都会让元素向前排
 * 参考地址：https://juejin.cn/post/6844904199453409294
 * @ClassName: LRULocalCache 
 * @author: Hong.Chen
 * @date: 2021年12月29日 上午11:47:39
 */
public class LRULocalCache<K, V> extends LinkedHashMap<K, V>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 可重入读写锁，保证并发读写安全性
	 */
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();
	
	/**缓存大小限制*/
	private int maxSize;

	public LRULocalCache(int maxSize) {
		super(maxSize+1, 1, true);
		this.maxSize = maxSize;
	}
	
	public LRULocalCache(int maxSize, int initialCapacity,float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
		this.maxSize = maxSize;
	}
	
	@Override
	public V get(Object key) {
		readLock.lock();
		try {
			return super.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	@Override
	public V put(K key, V value) {
		writeLock.lock();
		try {
			return super.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return this.size() > maxSize;
	}
}
