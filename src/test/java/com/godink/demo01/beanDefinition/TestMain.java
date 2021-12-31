package com.godink.demo01.beanDefinition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * beanDefinition定义
 * 参考链接:https://juejin.cn/post/6862259842799632391
 * @ClassName: TestMain 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月31日 上午10:10:04
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		//定义一个父类的BeanDefinition
		GenericBeanDefinition parentBeanDefinition = new GenericBeanDefinition();
		parentBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
		parentBeanDefinition.setAttribute("name", "chong1");
		parentBeanDefinition.setAbstract(true);//这里要设置为ture，代表不是真正的类，就不会实例这个，只是在定义上被继承，如果false则需要设置beanClass
		parentBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(1);
		parentBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("chong2");
		
		//子类bean定义
		GenericBeanDefinition childBeanDefinition = new GenericBeanDefinition();
		childBeanDefinition.setParentName("parent");
		childBeanDefinition.setBeanClass(ChildService.class);
		
		//向容器注册bean
		context.registerBeanDefinition("parent", parentBeanDefinition);
		context.registerBeanDefinition("child", childBeanDefinition);
		
		//刷新容器，完成bean的初始化
		context.refresh();
		
		//获取child的bean定义
		BeanDefinition child = context.getBeanFactory().getMergedBeanDefinition("child");
		for (String s : child.attributeNames()) {
			System.out.println(s + ":" + child.getAttribute(s));
		}
		System.out.println("scope:" + child.getScope());
		System.out.println("----------------------");
		
		ChildService service = context.getBean(ChildService.class);
		System.out.println(service.getId());
		System.out.println(service.getName());
	}
}
