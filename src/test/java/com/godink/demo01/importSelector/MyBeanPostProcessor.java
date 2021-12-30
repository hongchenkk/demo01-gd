package com.godink.demo01.importSelector;

import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Object proxy = Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(), 
				bean.getClass().getInterfaces(), new MyInvocationHandler(bean));
		return proxy;
	}
}
