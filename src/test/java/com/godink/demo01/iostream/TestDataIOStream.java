package com.godink.demo01.iostream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * flush是立即将缓冲区的数据刷出去，如文件或者磁盘或者其他流
 * 一般都是等缓冲区满了才会自动刷，如果不调flush的话
 * 而其实close方法也是在关闭前将所有的数据刷出去
 * 如果flush和close都不调的话，只能默认刷了
 */
@Slf4j
class TestDataIOStream {

	@Test
	void test() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			DataInputStream dis = new DataInputStream(bis);
			log.info("{}|{}", dis.readDouble(), dis.readBoolean());
			
			//这样读会报错，只能按设置值的顺序和类型读，不能乱序读，乱序读就报错
			log.info("{}|{}", dis.readBoolean(), dis.readDouble());
			
			bos.close();
			dos.close();
			bis.close();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
