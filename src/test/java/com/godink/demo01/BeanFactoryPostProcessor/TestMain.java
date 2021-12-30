package com.godink.demo01.BeanFactoryPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试bean工厂后处理器
 * 参考链接：https://juejin.cn/post/6844903775769985031
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean("repo"));
		System.out.println(context.getBeanDefinition("repo"));
	}
}
