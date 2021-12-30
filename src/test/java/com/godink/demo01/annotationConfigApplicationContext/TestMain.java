package com.godink.demo01.annotationConfigApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

	public static void main(String[] args) throws Exception {
		//testConfigClass();
		//testConfigRegister();
		//testBeanWithAnnoRegister();
		testBeanRegisterCumstomer();
	}
	
	/**
	 * 初始化容器注册配置类
	 */
	private static void testConfigClass() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(ServiceHasAnnotation.class).getClass().getSimpleName());
		System.out.println(context.getBean("serviceInConfig"));
	}
	
	/**
	 * 通过注册方法注册配置类
	 */
	private static void testConfigRegister() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		System.out.println(context.getBeanDefinition("serviceHasAnnotation"));
		System.out.println(context.getBean("serviceHasAnnotation"));
	}
	
	/**
	 * 注册普通的带注解的bean
	 */
	private static void testBeanWithAnnoRegister() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ServiceHasAnnotation.class);
		context.register(ServiceNoAnnotation.class);
		context.refresh();
		System.out.println(context.getBean("serviceHasAnnotation"));
		System.out.println(context.getBean("serviceNoAnnotation"));
	}
	
	/**
	 * 自定义注册bean：作用域，构造函数
	 */
	private static void testBeanRegisterCumstomer() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerBean("myService", ServiceNoAnnotation.class, () -> new ServiceNoAnnotation("nihoa"), def -> {
			def.setScope("prototype");
		});
		context.refresh();
		System.out.println(context.getBean("myService"));
		System.out.println(context.getBeanDefinition("myService"));
	}

}
