package com.godink.demo01.threadlocal;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * url: url:https://www.liaoxuefeng.com/wiki/1252599548343744/1306581251653666
 * @ClassName: TestThreadLocal 
 * @Description: 测试线程单独持有的本地变量
 * @author: Hong.Chen
 * @date: 2021年9月24日 下午2:48:17
 */
@Slf4j
class TestThreadLocal {

	@Test
	void test() {
		ThreadContext mainCtx = new ThreadContext("main");
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadContext thread1Ctx = new ThreadContext("thread1");
				log.info("tname:{}, treadLocal:{}", Thread.currentThread().getName(), ThreadContext.currentVal());
				subm();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadContext thread2Ctx = new ThreadContext("thread2");
				log.info("tname:{}, treadLocal:{}", Thread.currentThread().getName(), ThreadContext.currentVal());
			}
		});
		log.info("thread start");
		thread1.start();
		thread2.start();
		log.info("thread end");
		log.info("tname:{}, treadLocal:{}", Thread.currentThread().getName(), ThreadContext.currentVal());
	}
	
	private void subm() {
		log.info("subm, treadLocal:{}", ThreadContext.currentVal());
	}

}
