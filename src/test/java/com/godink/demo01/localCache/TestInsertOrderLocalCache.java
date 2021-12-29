package com.godink.demo01.localCache;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试按插入顺序的本地缓存
 * @ClassName: TestInsertOrderLocalCache 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月29日 下午2:33:12
 */
@Slf4j
class TestInsertOrderLocalCache {

	@Test
	void testPutAndGetMaxSize2() {
		InsertOrderLocalCache<String, String> cache = new InsertOrderLocalCache<>(2);
//		LRULocalCache<String, String> cache = new LRULocalCache<>(2);
		//插入元素
		cache.put("a1", "a11");
		cache.put("a2", "a21");
		//读取元素
		log.info("get by key=a1:{}", cache.get("a1"));
		cache.put("a3", "a31");
		//打印结果
		log.info("cache size: {}", cache.size());
		log.info("cache:{}", cache);
	}

}
