package com.godink.demo01.classpathFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试读取类路径下的文件
 * 参考链接：https://blog.csdn.net/neweastsun/article/details/100591046
 */
@Slf4j
class TestReadClasspathFile {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private ApplicationContext applicationContext;

	//手动获取
	@Test
	void testReadTxtFile1() throws IOException {
		Resource resource = new ClassPathResource("doc/test1.txt");
		File file = resource.getFile();
		log.info("file name:{}", file.getName());
	}
	
	//通过指定类加载器获取
	@Test
	void testReadTxtFile2() throws IOException {
		Resource res = new ClassPathResource("doc/test1.txt", this.getClass().getClassLoader());
		File file = res.getFile();
		log.info("file name:{}", file.getName());
	}
	
	//通过导入资源加载器加载
	//这种方式需要通过集成测试，启动容器才可以
	@Test
	void testReadTxtFile3() throws IOException {
		Resource res = resourceLoader.getResource("doc/test1.txt");
		File file = res.getFile();
		log.info("file name:{}", file.getName());
	}
	
	//通过应用上下文加载
	//这种方式需要通过集成测试，启动容器才可以
	@Test
	void testReadTxtFile4() throws IOException {
		Resource res = applicationContext.getResource("classpath:doc/test1.txt");
		File file = res.getFile();
		log.info("file name:{}", file.getName());
	}
	
	//通过类加载器的其他方法1
	@Test
	void testReadTxtFile5() throws IOException {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("doc/test1.txt");
		//将is转为字符流
		InputStreamReader ir = new InputStreamReader(is);
		//ir转为缓冲流
		BufferedReader br = new BufferedReader(ir);
		String collect = br.lines().collect(Collectors.joining("-"));
		log.info("collect:{}", collect);
	}
	
	//通过类加载器的其他方法2
	@Test
	void testReadTxtFile6() throws IOException {
		URL url = this.getClass().getClassLoader().getResource("doc/test1.txt");
		//将is转为字符流
		InputStream is = new FileInputStream(new File(url.getFile()));
		InputStreamReader ir = new InputStreamReader(is);
		//ir转为缓冲流
		BufferedReader br = new BufferedReader(ir);
		String collect = br.lines().collect(Collectors.joining("-"));
		log.info("collect:{}", collect);
	}
	
	//测试获取File及inputstream流，通过资源对象Resource
	@Test
	void testReadContentFile() throws Exception{
		Resource res = new ClassPathResource("doc/test1.txt");
		//1.获取文件
		File file = res.getFile();
		//将文件读取为字节数组
		byte[] bytes = Files.readAllBytes(file.toPath());
		//将字节数组转为字符串输出
		String string = new String(bytes, 0, bytes.length);
		log.info("content:{}", string);
		
		//2.获取inputstream
		InputStream is = res.getInputStream();
		//将is转为字符流
		InputStreamReader ir = new InputStreamReader(is);
		//ir转为缓冲流
		BufferedReader br = new BufferedReader(ir);
//		//循环读取每行数据
//		String readLine = null;
//		while ((readLine = br.readLine()) != null) {
//			log.info("readline:{}", readLine);
//		}
		String collect = br.lines().collect(Collectors.joining("-"));
		log.info("collect:{}", collect);
	}

}
