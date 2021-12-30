package com.godink.demo01.beanPostProcessor;

import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Object o = Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(), 
				bean.getClass().getInterfaces(), new MyInvocationHandler(bean));
		return o;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
