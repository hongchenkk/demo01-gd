package com.godink.demo01.svgContvertToPng;

import org.junit.jupiter.api.Test;

import com.godink.springboot.common.demo.utils.FileToBase64;

import lombok.extern.slf4j.Slf4j;

/**
 * 将png图片转为base64字符串: 有点问题，通过System.out.println打印在控制台，会少很多，还是用html那个文档或者生成到文件
 * 参考文档1：https://www.open-open.com/lib/view/open1414817090294.html
 * 前端js插件，可产生svg文件的：http://fabricjs.com/
 */
@Slf4j
class TestPngToBase64Str {

	@Test
	void test1() throws Exception {
		String pngPath1 = "D:\\tmp\\testsvg\\base64img\\1.png";
		String base64Str1 = FileToBase64.encodeBase64File(pngPath1);
		System.out.println(base64Str1);
	}
	
	@Test
	void test2() throws Exception {
		String pngPath2 = "D:\\tmp\\testsvg\\base64img\\2.png";
		String base64Str2 = FileToBase64.encodeBase64File(pngPath2);
		System.out.println("base64Str2:");
		System.out.println(base64Str2);
	}

}
