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
				try {
					log.info("tname:{}, treadLocal:{}", Thread.currentThread().getName(), ThreadContext.currentVal());
					subm();
				}finally {//用完要记得释放这个线程持有的对象，不然被放入线程池，还继续持有这个旧对象
					thread1Ctx.close();
				}
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
	
	private void sub1() {
		try (ThreadContext ctx = new ThreadContext("Bob")) {
		    // 可任意调用UserContext.currentUser():
		    String currentVal = ThreadContext.currentVal();
		} // 在此自动调用UserContext.close()方法释放ThreadLocal关联对象
	}

}
