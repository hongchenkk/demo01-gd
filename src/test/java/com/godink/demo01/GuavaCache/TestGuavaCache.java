package com.godink.demo01.GuavaCache;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试guava缓存
 * 参考链接：https://juejin.cn/post/6844904199453409294
 * @ClassName: TestGuavaCache 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月29日 下午2:50:08
 */
@Slf4j
class TestGuavaCache {

	@Test
	void test() throws InterruptedException, ExecutionException {
		//构建缓存
		Cache<String, String> cache = CacheBuilder.newBuilder()
		.initialCapacity(2)
		.maximumSize(3)
		.expireAfterWrite(2, TimeUnit.SECONDS)
		.expireAfterAccess(2, TimeUnit.SECONDS)
		.build();
		
		//插入数据
		cache.put("a1", "a11");
		cache.put("a12", "a12");
		cache.put("a13", "a13");
		cache.put("a14", "a14");
		//统计数据
		log.info("cache size:{}", cache.size());
		//获取数据1
		String ifPresent = cache.getIfPresent("a12");
		log.info("get by ifPresent:{}", ifPresent);
		//获取数据1 模拟过期
		TimeUnit.SECONDS.sleep(3);
		//获取过期数据
		String expire = cache.getIfPresent("a13");
		log.info("get by expire expire time:{}", expire);
		//获取数据，如果不存在就将数据加载进缓存后再返回
		String fromDb = cache.get("a14", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return getFromDb();
			}
		});
		log.info("get from db: {}", fromDb);
		String fromDbCache = cache.getIfPresent("a14");
		log.info("get from cache from db: {}", fromDbCache);
		//删除缓存
		cache.invalidate("a14");
		String deleted = cache.getIfPresent("a14");
		log.info("get from cache for deleted: {}", deleted);


	}
	
	/**模拟来自数据库的数据*/
	private String getFromDb() {
		return "from db";
	}

}
