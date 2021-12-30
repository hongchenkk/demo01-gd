package com.godink.demo01.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class TestClassLoader {

	@Test
	void test() throws IOException {
		//获取AppClassLoader加载器:既加载类路径下classpath下的资源，这是默认的，如果不指定类加载器时
		ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(appClassLoader);
		//打印出来是：sun.misc.Launcher$AppClassLoader@76fb509a
		//自定义类加载器：
		ClassLoader customerClassLoader = this.getClass().getClassLoader();
		System.out.println(customerClassLoader);
		//加载类路径的文件为资源输入流，进行读取
		InputStream input = appClassLoader.getResourceAsStream("doc/test2.txt");
		//读取到字节数组中，将字节数组读取到字节数组输出流中
		BufferedInputStream bfin = new BufferedInputStream(input);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buffer = new byte[2];
		int size = 0;
		while ((size = bfin.read(buffer)) != -1) {
			bos.write(buffer, 0, size);
		}
		byte[] content = bos.toByteArray();
		bfin.close();
		input.close();
		bos.close();
		System.out.println(new String(content, "utf-8"));
//		Reader reader = new InputStreamReader(input);
//		String readStr = IoUtil.read(input, "utf-8");
//		byte[] readBytes = IoUtil.readBytes(input);
//		System.out.println(new String(readBytes, "utf-8"));
//		System.out.println(readStr);
	}

}
