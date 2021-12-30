package com.godink.demo01.annoImport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试import注解
 * 参考链接：https://juejin.cn/post/6844903775769985031
 */
public class TestMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(ServiceImpl.class).query();
	}
}
