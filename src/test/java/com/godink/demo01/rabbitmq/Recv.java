package com.godink.demo01.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Recv {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.0.2.33");
		factory.setPort(5672);
		factory.setUsername("ch01demo");
		factory.setPassword("123456");
		factory.setVirtualHost("/ch01test");
		
		Connection conn = factory.newConnection();
		Channel channel = conn.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DeliverCallback  deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println("[x] Recv message:"+message);
		};
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
		System.out.println("[*] Waitting for messages.");
	}
}
