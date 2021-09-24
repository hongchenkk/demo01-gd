package com.godink.demo01.threadlocal;

/**
 * url:https://www.liaoxuefeng.com/wiki/1252599548343744/1306581251653666
 * @ClassName: ThreadContext 
 * @Description: 同一个线程持有的本地变量
 * @author: Hong.Chen
 * @date: 2021年9月24日 下午2:40:05
 */
public class ThreadContext implements AutoCloseable{
	
	public static final ThreadLocal<String> threadCtx = new ThreadLocal<>();
	
	public ThreadContext(String val) {
		threadCtx.set(val);
	}
	
	public static String currentVal() {
		return threadCtx.get();
	}

	@Override
	public void close() {
		threadCtx.remove();
	}

}
