package com.godink.demo01.generic;

public class GenericParent {

	public static void main(String[] args) {
		boolean isInstance = GenericParent.class.isInstance(new GenericParent());
		System.out.println(isInstance);
		System.out.println(new GenericParent() instanceof GenericParent);
	}
}
