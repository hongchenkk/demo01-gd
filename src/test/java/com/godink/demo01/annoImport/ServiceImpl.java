package com.godink.demo01.annoImport;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service{

	@Override
	public void query() {
		System.out.println("正在查询中");
	}

}
