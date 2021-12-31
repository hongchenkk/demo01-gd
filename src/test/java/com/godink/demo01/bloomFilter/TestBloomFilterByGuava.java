package com.godink.demo01.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 测试布隆过滤器: 用guava实现本地的布隆过滤器，也可以用redis实现，链接中有
 * 参考链接：https://juejin.cn/post/6844903849400991752
 * @ClassName: TestBloomFilterByGuava 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月31日 上午11:12:22
 */
public class TestBloomFilterByGuava {
	
	private static int size = 100 * 10000;//预计要插入多少数据
	private static double fpp = 0.01;//期望的误判率
	
	private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

	public static void main(String[] args) {
		//插入数据
		for (int i = 0; i < size; i++) {
			bloomFilter.put(i);
		}
		//测试匹配：误判率
		int count = 0;//误判的数量
		for (int i = 100*10000; i < 200*10000; i++) {
			if(bloomFilter.mightContain(i)) {
				count++;
				System.out.println(i+"误判了");
			}
		}
		System.out.println("总共误判次数：" + count);
		System.out.println("误判率为：" + Double.valueOf(count)/size);
	}
}
