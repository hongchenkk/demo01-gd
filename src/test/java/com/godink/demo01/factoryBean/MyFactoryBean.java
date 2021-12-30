package com.godink.demo01.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<DataSource>{

	@Override
	public DataSource getObject() throws Exception {
		return new DataSource();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

}
