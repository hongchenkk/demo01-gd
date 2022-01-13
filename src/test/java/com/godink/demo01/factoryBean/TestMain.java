package com.godink.demo01.factoryBean;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试工程bean
 * 参考地址：https://juejin.cn/post/6844903775769985031
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean("myFactoryBean").getClass().getSimpleName());
		System.out.println(context.getBean("&myFactoryBean").getClass().getSimpleName());
	}
}
