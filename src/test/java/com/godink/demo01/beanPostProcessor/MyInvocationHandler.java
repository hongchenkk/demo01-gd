package com.godink.demo01.beanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进来了");
		Object obj = method.invoke(target, args);
		System.out.println("出去了");
		return obj;
	}

}
