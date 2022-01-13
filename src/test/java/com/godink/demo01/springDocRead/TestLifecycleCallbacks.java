package com.godink.demo01.springDocRead;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

public class TestLifecycleCallbacks implements InitializingBean, DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@PostConstruct
	public void post1() {
		// TODO Auto-generated method stub

	}
	
	@Bean(initMethod = "111")
	public void bean1() {
		// TODO Auto-generated method stub

	}

}
