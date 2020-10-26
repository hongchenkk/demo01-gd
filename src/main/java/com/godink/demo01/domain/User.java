package com.godink.demo01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {
	private String name;
	private String account;
	private Integer age;
	private String password;
	
	public static void main(String[] args) {
		User user = User.builder()
				.name("hong")
				.account("ch")
				.age(28).build();
		
		log.info("user:{}", user);
	}
}
