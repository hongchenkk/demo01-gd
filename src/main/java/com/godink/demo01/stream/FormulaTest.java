package com.godink.demo01.stream;

import java.util.HashMap;
import java.util.Map;

public class FormulaTest {
	public static void main(String[] args) {
//		test1();
		
		Map<Integer, String> map = new HashMap<>();
		System.out.println(map.putIfAbsent(1, "2"));
		System.out.println(map.putIfAbsent(1, "2"));
		System.out.println(map.putIfAbsent(2, "3"));
		System.out.println(map.putIfAbsent(3, "4"));
		map.forEach((key, val) -> {
			System.out.println(key+"--"+val);
		});
		System.out.println(map.containsKey(2));
		map.compute(2, (key ,val)->key+val);
		map.computeIfAbsent(4, key -> "val"+key);
		System.out.println(map.containsKey(4));
		System.err.println(map.get(2));
		System.err.println(map.get(3));
		System.err.println(map.get(4));
	}

	public static void test1() {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a*100);
			}
		};
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
}
