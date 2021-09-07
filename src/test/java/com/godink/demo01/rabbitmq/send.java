package com.godink.demo01.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class send {
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		//获取连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.0.2.33");
		factory.setPort(5672);
		factory.setUsername("ch01demo");
		factory.setPassword("123456");
		factory.setVirtualHost("/ch01test");
		//获取连接
		Connection connection = factory.newConnection();
		//创建通道
		Channel channel = connection.createChannel();
		channel.queueDeclareNoWait(QUEUE_NAME, false, false, false, null);
		//发送的消息内容
		String message = "ni hao a11!";
		//发送
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println("[x] Send message:"+message);
	}
}
