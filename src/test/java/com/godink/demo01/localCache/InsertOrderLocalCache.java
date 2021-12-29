package com.godink.demo01.localCache;

/**
 * 按插入顺序的排列
 * @ClassName: InsertOrderLocalCache 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月29日 下午2:31:49 
 * @param <K>
 * @param <V>
 */
public class InsertOrderLocalCache<K, V> extends LRULocalCache<K, V> {
	private static final long serialVersionUID = 1L;

	public InsertOrderLocalCache(int maxSize) {
		super(maxSize, maxSize+1, 1, false);
	}
}
