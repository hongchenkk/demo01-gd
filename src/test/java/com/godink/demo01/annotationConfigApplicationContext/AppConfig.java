package com.godink.demo01.annotationConfigApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.godink.demo01.annotationConfigApplicationContext"})
@ComponentScan
public class AppConfig {

	@Bean
	public ServiceInConfig serviceInConfig() {
		return new ServiceInConfig();
	}
}
