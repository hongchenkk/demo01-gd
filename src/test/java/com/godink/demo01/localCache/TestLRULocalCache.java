package com.godink.demo01.localCache;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试本地缓存
 * @ClassName: TestLRULocalCache 
 * @author: Hong.Chen
 * @date: 2021年12月29日 下午2:20:39
 */
@Slf4j
class TestLRULocalCache {

	@Test
	void testPutAndGet2MaxSize() {
		LRULocalCache<String, String> cache = new LRULocalCache<>(2);
		
		//插入元素
		cache.put("a1", "a11");
		cache.put("a2", "a12");
		log.info("get by key a1:{}", cache.get("a1"));
		cache.put("a3", "a13");
		log.info("size: {}", cache.size());
		log.info("cache: {}", cache);
	}

}
