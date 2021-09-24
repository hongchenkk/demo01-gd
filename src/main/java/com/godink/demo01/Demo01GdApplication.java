package com.godink.demo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.godink.demo01.mapper")
public class Demo01GdApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo01GdApplication.class, args);
	}

}
