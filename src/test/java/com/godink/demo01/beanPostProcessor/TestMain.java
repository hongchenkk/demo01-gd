package com.godink.demo01.beanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试BeanPostProcessor（bean后处理器）
 * 参考链接：https://juejin.cn/post/6844903775769985031
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Service service = context.getBean(Service.class);
		service.query();
	}
}
