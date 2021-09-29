package com.godink.demo01.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectoinsTest {
	public static void main(String[] args) {
		String text = null;
	}

	public static void sortTest() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		
		Collections.reverse(list);
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer t1, Integer t2) {
				return t2.compareTo(t1);
			}
		});
		
		System.out.println(list);
	}
	
	public static void testPeek() {
		Stream.of("one", "two", "three", "four")
			.filter(e -> e.length() > 3)
			.peek(System.out::println)
			.peek(String::toUpperCase)
			.peek(System.out::println)
			.collect(Collectors.toList());
	}

	
}

