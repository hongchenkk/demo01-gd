package com.godink.demo01.enums;

import java.util.Arrays;

public enum PersonTypeEnum {
	
	GOOD_MAN(0, "goodMan"),
	BAD_MAN(1, "badMan"),
	GOOD_WOMAN(3, "goodWoman"),
	BAD_WOMAN(4, "badWoman");

	PersonTypeEnum(Integer code, String name){
		this.code = code;
		this.name = name;
	}
	
	private Integer code;
	private String name;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static PersonTypeEnum getByName(String name) {
		for (PersonTypeEnum pt : PersonTypeEnum.values()) {
			if(pt.getName().equals(name)) {
				return pt;
			}
		}
		return null;
	}
	
	public static Integer getCodeByName(String name) {
		for (PersonTypeEnum pt : PersonTypeEnum.values()) {
			if(pt.getName().equals(name)) {
				return pt.getCode();
			}
		}
		return null;
	}
	
	public static PersonTypeEnum getByCode(Integer code) {
		for (PersonTypeEnum pt : PersonTypeEnum.values()) {
			if(pt.getCode().equals(code)) {
				return pt;
			}
		}
		return null;
	}
	
	public static String getNameByCode(Integer code) {
		for (PersonTypeEnum pt : PersonTypeEnum.values()) {
			if(pt.getCode().equals(code)) {
				return pt.getName();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(PersonTypeEnum.GOOD_MAN.getCode());
		System.out.println(PersonTypeEnum.GOOD_MAN.getName());
		
		PersonTypeEnum[] values = PersonTypeEnum.values();
		Arrays.stream(values).map(PersonTypeEnum::getName).forEach(System.out::println);
		
	}
	
}
