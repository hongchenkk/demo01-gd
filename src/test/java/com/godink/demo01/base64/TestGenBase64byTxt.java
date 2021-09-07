package com.godink.demo01.base64;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;

import org.junit.jupiter.api.Test;

import sun.misc.BASE64Encoder;

/**
 * 测试通过test.txt文本生成base64字符串
 * @ClassName: TestGenBase64byTxt 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年8月28日 上午11:40:25
 */
class TestGenBase64byTxt {

	@Test
	void test() throws Exception {
		String txtPath = "D:\\tmp\\testtxt\\test1.txt";
		String base64Str = encodeBase64File(txtPath);
		System.out.println(base64Str);
	}
	
    /**
    * <p>将文件转成base64 字符串</p>
    * @param path 文件路径
    * @return
    * @throws Exception
    */
    public String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

}
