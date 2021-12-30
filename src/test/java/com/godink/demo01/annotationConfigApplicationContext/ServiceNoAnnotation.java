package com.godink.demo01.annotationConfigApplicationContext;

import lombok.Getter;
import lombok.Setter;

/**
 * 不带注解的bean
 */
@Setter
@Getter
public class ServiceNoAnnotation {

	private String message;
	
	public ServiceNoAnnotation(String message) {
		this.message = message;
	}
}
