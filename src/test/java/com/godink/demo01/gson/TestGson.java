package com.godink.demo01.gson;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试：利用Gson对json字符串序列化和反序列化
 * 参考文档1：https://www.jianshu.com/p/e740196225a4
 * 参考文档2: https://blog.csdn.net/csdn_liumh/article/details/82893908
 * @ClassName: TestGson 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年10月14日 下午2:20:11
 */
@Slf4j
class TestGson {

	/**测试基本类型: 从json字符串生成对象*/
	@Test
	void testPrimaryFromGson() {
		Gson gson = new Gson();
		Integer i = gson.fromJson("200", int.class);
		Boolean b = gson.fromJson("true", boolean.class);
		String s = gson.fromJson("String", String.class);
		Double d = gson.fromJson("99.99", double.class);
		log.info("[{}|{}|{}|{}]", i, b, s, d);
	}
	
	/**测试基本类型：从对象生成为json字符串*/
	@Test
	void testPrimaryToGson() {
		Gson gson = new Gson();
		String i = gson.toJson(100);
		String b = gson.toJson(false);
		String s = gson.toJson("String");
		log.info("[{}|{}|{}]", i, b, s);
	}
	
	/**测试pojo：从对象生成json*/
	@Test
	void testPojoToJson() {
		User user1 = new User();
		user1.setName("test1");
		user1.setAge(18);
		user1.setEmail("6555@qq.com");
		
		User user2 = new User("test2", 20, "235@qq.com");
		
		Gson gson = new Gson();
		String jsonString1 = gson.toJson(user1);
		log.info("user1->json: {}", jsonString1);
		
		String jsonString2 = gson.toJson(user2);
		log.info("user2->json: {}", jsonString2);
	}
	
	/**测试pojo: 从json生成对象*/
	@Test
	void testJsonToPojo() {
		String jsonObj = "{\"name\":\"test1\",\"age\":18,\"email\":\"6555@qq.com\"}";
		
		Gson gson = new Gson();
		User user1 = gson.fromJson(jsonObj, User.class);
		
		log.info("json->user1: {}", user1.toString());
	}
	
	/**测试数组：从数组生成json*/
	@Test
	void testArrayToJson() {
		String[] arr = {"chong", "1ggg", "ghhhg"};
		
		Gson gson = new Gson();
		String jsonArray = gson.toJson(arr);
		
		log.info("arr->json: {}", jsonArray);
	}
	
	/**测试数组：从json生成数组*/
	@Test
	void testJsonToArray() {		
		Gson gson = new Gson();
		String jsonArray = "[\"chong\",\"1ggg\",\"ghhhg\"]";
		String[] arr = gson.fromJson(jsonArray, String[].class);
		
		log.info("json->arr: {}", arr.length);
	}
	
	/**测试列表：从列表生成json*/
	@Test
	void testListToJson() {
		Gson gson = new Gson();
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		String jsonArray = gson.toJson(list);
		
		log.info("list->json: {}", jsonArray);
	}
	
	/**测试列表<字符串>：从json生成列表*/
	@Test
	void testJsonToList() {
		Gson gson = new Gson();
		
		String jsonArray = "[\"aaa\",\"bbb\",\"ccc\"]";
		
		List<String> list = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
		
		log.info("json->list: {}", list);
	}
	
	/**测试列表<Pojo>：从列表生成json*/
	@Test
	void testListPojoToJson() {
		Gson gson = new Gson();
		
		User user1 = new User("a", 18, "a1");
		User user2 = new User("b", 19, "a2");
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		
		String jsonArr = gson.toJson(list);		
		log.info("list<user>->json: {}", jsonArr);
	}
	
	/**测试列表<Pojo>：从json生成列表*/
	@Test
	void testJsonToListPojo() {
		Gson gson = new Gson();
		
		String jsonArr = "[{\"name\":\"a\",\"age\":18,\"email\":\"a1\"},{\"name\":\"b\",\"age\":19,\"email\":\"a2\"}]";
		
		List<User> list = gson.fromJson(jsonArr, new TypeToken<List<User>>() {}.getType());		
		log.info("json->list<user>: {}", list);
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class User {
		private String name;
		private int age;
		private String email;
	}

}
