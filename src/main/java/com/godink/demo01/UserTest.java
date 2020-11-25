package com.godink.demo01;

import java.util.Arrays;
import java.util.List;

public class UserTest {
	private Integer age;
	private String name;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "UserTest [age=" + getAge() + ", name=" + name + "]";
	}
	public static void main(String[] args) {
		UserTest userTest = new UserTest();
		userTest.setAge(20);
		userTest.setName("chehong");
		
		System.out.println(userTest);
		
		Integer i = -10001;
		System.out.println(i.toString());
		
		List<String> insideCategoryIds = Arrays.asList("-10001","-10000","-9903","-9902","-9901","-101","-100","-99");
		System.out.println(insideCategoryIds.contains(i.toString()));
	}
	
}
